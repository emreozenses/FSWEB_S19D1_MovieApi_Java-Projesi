package com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto;

import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Gender;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Movie;

import java.time.LocalDate;
import java.util.List;

public record ActorResponse(Long id, String firstName, String lastName, LocalDate birthDate, List<Movie> movieList) {
}
