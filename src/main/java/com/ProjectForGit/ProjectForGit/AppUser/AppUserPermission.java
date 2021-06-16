package com.ProjectForGit.ProjectForGit.AppUser;

public enum AppUserPermission {
    ;

    private final String permission;

    public String getPermission() {
        return permission;
    }

    AppUserPermission(String permission) {
        this.permission = permission;
    }
}
