package com.ProjectForGit.ProjectForGit.Controller;

import com.ProjectForGit.ProjectForGit.AppUser.AppUserRole;
import com.ProjectForGit.ProjectForGit.Registration.RegistrationRequest;
import com.ProjectForGit.ProjectForGit.Registration.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
@AllArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<RegistrationRequest> registerNewUSer(@ModelAttribute("RegistrationRequest") RegistrationRequest registrationRequest){
        registrationRequest.setAppUserRole(AppUserRole.USER);
        registrationService.registerNewUser(registrationRequest);
        return new ResponseEntity<>(registrationRequest, HttpStatus.OK);
    }



    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

    @ModelAttribute("RegistrationRequest")
    public RegistrationRequest RegistrationRequest(){
        return new RegistrationRequest();
    }
}
