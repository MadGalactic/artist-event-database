package com.myprojects.artisteventsdb.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class County extends AbstractEntity {

    @ManyToMany
    private List<Artist> artists = new ArrayList<>();



    // Getters & setters


    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }
}
