package com.ProjectForGit.ProjectForGit.AppUser;

import com.ProjectForGit.ProjectForGit.ConfirmationToken.ConfirmationToken;
import com.ProjectForGit.ProjectForGit.Exceptions.UserNameAlreadyTakenException;
import com.ProjectForGit.ProjectForGit.Repositories.AppUserRepository;
import com.ProjectForGit.ProjectForGit.ConfirmationToken.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;


@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final ConfirmationTokenService confirmationTokenService;

    private final AppUserRepository appUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepository.findAppUserByUsername(username).orElseThrow(()->new UsernameNotFoundException(""));
    }

    @SneakyThrows
    public String registerNewAppUser(AppUser appUser){
        boolean UsernameAlreadyTaken =appUserRepository.findAppUserByUsername(appUser.getUsername())
                .isPresent();
        if(UsernameAlreadyTaken)
            throw new UserNameAlreadyTakenException("This username is already taken");
        String password=bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(password);
        if(appUser.getUsername().equals("username")) {
            appUser.setEnabled(true);
        }
        appUserRepository.save(appUser);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );

        confirmationTokenService.saveConfirmationToken(
                confirmationToken);

//        TODO: SEND EMAIL

        return token;
    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }
}
