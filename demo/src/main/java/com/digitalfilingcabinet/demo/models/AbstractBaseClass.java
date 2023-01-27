package com.digitalfilingcabinet.demo.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class AbstractBaseClass {
    // AbstractBaseClass needs to have the things like, generating a new ID
    // when one of the other classes is created
    // theres probly other things that are for EVERY single class, we will add them here
    // so the other classes can just extend this one.

    // the other model classes create tables for the MySQL stuff. but this one doesnt.


    // every single class will have an ID, so that we can select one entity at a time.
    @Id
    @GeneratedValue
    private int id;


    // every single class needs an NAME field. even when they upload a PDF
    // i want them to type in a name for the file they are uploading.
    @NotBlank(message="Please provide a name for this.")
    @Size(min= 3, max = 100, message = "Name must be between 3 and 100 characters.")
    private String name;


    // we want to make sure that we cannot create 2 users with the same name
    // 2 categories cannot have the same name
    // 2 uploaded PDF cannot have the same name

    // need to somehow do {if the string name already exists in the MySQL table, give error code}
    // i think this has to do with @ExceptionHandler.... i cant figure it out yet.




    // getters and setters





    // this thing makes sure that the ID is good to go.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractBaseClass that = (AbstractBaseClass) o;
        return id == that.id;
    }




}
