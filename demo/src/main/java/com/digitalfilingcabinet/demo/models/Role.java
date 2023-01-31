package com.digitalfilingcabinet.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends AbstractBaseClass {
    @Column(nullable = false, length = 45)
    private String name;

    public Role (){}

    public Role(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
        public String toString(){
        return this.name;
        }

}
