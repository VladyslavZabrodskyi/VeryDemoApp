package com.ProjectForGit.ProjectForGit.Registration;

import com.ProjectForGit.ProjectForGit.AppUser.AppUserRole;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
    private  String username;
    private  String password;

    public RegistrationRequest(AppUserRole appUserRole) {
        this.appUserRole = appUserRole;
    }

    private  AppUserRole appUserRole;


}
