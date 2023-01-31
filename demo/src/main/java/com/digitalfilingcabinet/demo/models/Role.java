package com.digitalfilingcabinet.demo.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Role extends AbstractBaseClass {

    @OneToMany
    @JoinColumn(name = "role_id")
    private final List<User> users = new ArrayList<>();

    public Role(){
        super();
    }


}
