package com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto;

import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Actor;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Director;

import java.time.LocalDate;
import java.util.List;

public record MovieResponse(String name, Double rating, LocalDate releaseDate, List<Actor> actorList, Director director) {
}
