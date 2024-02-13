package com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.repository;

import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto.ActorResponse;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto.MovieResponse;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    @Query(value = "SELECT m.id,m.name,m.rating,m.director_name,m.release_date FROM fsweb.movie AS m WHERE m.name ILIKE %:name%",nativeQuery = true)
    List<MovieResponse> findByName(String name);

}
