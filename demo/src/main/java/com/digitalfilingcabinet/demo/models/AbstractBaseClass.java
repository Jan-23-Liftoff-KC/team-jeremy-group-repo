package com.digitalfilingcabinet.demo.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractBaseClass {

    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    @NotBlank(message="Please provide a name for this.")
    @Size(min= 3, max = 100, message = "Name must be between 3 and 100 characters.")
    private String name;


    // to check if names are identical, we need to use a Derived Query Method




    public int getId() {
        return id;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractBaseClass that = (AbstractBaseClass) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}