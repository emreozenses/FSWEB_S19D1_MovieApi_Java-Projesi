package com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.service;

import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto.*;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Actor;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Movie;

import java.util.List;

public interface MovieService {

    MovieResponse save (Movie movie);

    List<MovieResponse> findAll();

    MovieResponse findById(long id);

    List<JustMovieResponse> findByName(String name);

    MovieResponse update (long id,Movie movie);


    MovieResponse addActor (MovieRequest movieRequest);

    MovieResponse delete (long id);
}
