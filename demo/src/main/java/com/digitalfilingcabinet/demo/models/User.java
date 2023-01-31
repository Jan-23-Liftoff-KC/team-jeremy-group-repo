package com.digitalfilingcabinet.demo.models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table //should this be a table or list?  How do we have several unique keys if it is in a list?
public class User extends AbstractBaseClass {
//not sure whether to use @Column(nullable-false) or @NotNull

//role grants permissions as an Admin, Editor, or Viewer
    @ManyToOne
    private Role role;

    //relationship could be son, power of attorney, executor of estate, emergency contact, and...
    @ManytoMany
    private Relationship relationship;


    public User (Role role, Relationship relationship) {
        super();
        this.role = role;
        this.relationship = relationship;
    }


   @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

    @Column(name = "phone", nullable = false, length = 10)
    private Integer phoneNumber;

    @Column(name = "relationship", nullable = false, )

    public User (String firstName, String lastName, Integer phoneNumber, String email, String password, Role role, Relationship relationship) {
        super();
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.relationship = relationship;


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
