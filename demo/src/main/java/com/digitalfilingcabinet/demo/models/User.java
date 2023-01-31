package com.digitalfilingcabinet.demo.models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table //should this be a table or list?  How do we have several unique keys if it is in a list?
public class User extends AbstractBaseClass {
//not sure whether to use @Column(nullable-false) or @NotNull


    @ManyToOne
    private Role role;


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

    @Column(name = "phone_number", nullable = false, length = 10)
    private Integer phoneNumber;

    public User (String firstName, String lastName, Integer phoneNumber, String email, String password, Role role ) {
        super();
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.role = role;


    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

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
    private Set<Role> roles = new HashSet<>();


}
