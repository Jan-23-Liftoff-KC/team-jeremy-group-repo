package com.digitalfilingcabinet.demo.models.dto;

//do we need a dto?  The relationship is many to many
public class UserRoleDTO {

    @NotNull
    private User user;

    @NotNull
    private Role role;

    public UserRoleDTO(){}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
