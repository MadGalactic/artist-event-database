package com.myprojects.artisteventsdb.data;

import com.myprojects.artisteventsdb.models.Artist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArtistRepository extends CrudRepository<Artist, Integer> {
}
