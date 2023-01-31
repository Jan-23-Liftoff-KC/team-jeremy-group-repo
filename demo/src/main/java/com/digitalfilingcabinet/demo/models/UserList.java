package com.digitalfilingcabinet.demo.models;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class UserList extends AbstractBaseClass {




    // we should be able to use this Derived Query Method to check if the 'name'
    // exists in any model that we insert into the parameters.
    List<UserList> findByNameEquals(String model) {
        return null;
    }


}
