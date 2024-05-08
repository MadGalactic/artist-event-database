package com.myprojects.artisteventsdb.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
public class Artist extends AbstractEntity {

    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 75, message = "Must enter between 2 and 75 characters")
    public String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 75, message = "Must enter between 2 and 75 characters")
    public String lastName;

}
