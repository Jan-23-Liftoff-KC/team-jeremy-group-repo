package com.digitalfilingcabinet.demo.models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User extends AbstractBaseClass {
//not sure whether to use @Column(nullable-false) or @NotNull

    @ManyToOne
    private Role role;

    public User() {};

    public User (Role role) {
        super();
        this.role = role;
    }
   @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;



    private Set<Role> roles = new HashSet<>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addRole (Role role) {
        this.roles.add(role);
    }

    public Set<Role> getRoles() {
        return roles;
    }


}
