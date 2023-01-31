package com.digitalfilingcabinet.demo.models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
//@Table //should this be a table or list?  How do we have several unique keys if it is in a list?
public class User extends AbstractBaseClass {
//not sure whether to use @Column(nullable-false) or @NotNull

//role grants permissions as an Admin, Editor, or Viewer
    @ManyToOne
    private Role role;

    //relationship could be son, power of attorney, executor of estate, emergency contact, and...
    @ManytoMany
    private List<Relationship> relationships;

    public User(){};




   //@Column(nullable = false, unique = true, length = 45)
    @NotBlank
    private String email;

    //@Column(nullable = false, length = 64)
    @NotBlank
    private String password;

   // @Column(name = "first_name", nullable = false, length = 20)
    @NotBlank
    private String firstName;

   // @Column(name = "last_name", nullable = false, length = 20)
    @NotBlank
    private String lastName;

   // @Column(name = "phone", nullable = false, length = 10)
   @NotBlank
    private Integer phoneNumber;

   // @Column(name = "relationship", nullable = false, )

    public User (String firstName, String lastName, Integer phoneNumber, String email, String password, Role role, List <Relationship> relationships) {
        super();
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.relationships = relationships;


    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }


    //public String getPassword() {return password;}


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public List<Relationship> getRelationships() {
        return this.relationships;
    }

    public void setRelationships(List<Relationship> relationships) {
        this.relationships = relationships;
    }

    public Role getRole () {return this.role;}

    public void setRole(Role role) {this.role = role;}
}
