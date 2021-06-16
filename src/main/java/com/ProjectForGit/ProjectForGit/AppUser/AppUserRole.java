package com.ProjectForGit.ProjectForGit.AppUser;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum AppUserRole {
    USER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet());

    AppUserRole(Set<AppUserPermission> permissions) {
        this.permissions = permissions;
    }

    private final Set<AppUserPermission> permissions;

    public Set<SimpleGrantedAuthority> getAuthorities(){
        Set<SimpleGrantedAuthority> permissionsSet=permissions.stream().map(permissions->new SimpleGrantedAuthority(permissions.getPermission()))
                .collect(Collectors.toSet());
        permissionsSet.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return permissionsSet;
    }
}
