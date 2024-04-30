package com.myprojects.artisteventsdb.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Artist extends AbstractEntity {


    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 75, message = "Must enter between 2 and 75 characters")
    public String name;

}
