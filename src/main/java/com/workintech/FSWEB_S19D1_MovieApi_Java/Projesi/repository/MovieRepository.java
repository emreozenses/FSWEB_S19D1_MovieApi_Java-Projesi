package com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.repository;

import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
