package com.digitalfilingcabinet.demo.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class RecordsList extends AbstractBaseClass {


    @NotBlank(message="Please provide a name for this.")
    @Size(min= 3, max = 100, message = "Name must be between 3 and 100 characters.")
    private String name;
    List<RecordsList> findByNameEquals(String model) {
        return null;
    }

    @Size(min=3, max = 250, message = "Description must be between 3 and 250 characters.")
    private String description;




}
