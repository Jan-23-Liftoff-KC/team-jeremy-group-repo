package com.digitalfilingcabinet.demo.models;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class UserList extends AbstractBaseClass {

//I believe we need to code this similarly to how we did for JobData in assignment 4


    // we should be able to use this Derived Query Method to check if the 'name'
    // exists in any model that we insert into the parameters.
    List<UserList> findByNameEquals(String model) {
        return null;
    }


}
