package com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.service;

import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto.ActorMovieRequest;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto.ActorResponse;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto.JustActorResponse;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Actor;

import java.time.LocalDate;
import java.util.List;

public interface ActorService {

    ActorResponse save (Actor actor);

    List<ActorResponse> findAll();

    ActorResponse findById(long id);

    List<JustActorResponse> findByName(String name);

    List<JustActorResponse> orderByBirthDateAsc();

    ActorResponse update (long id,Actor actor);

    ActorResponse addMovie (ActorMovieRequest actorMovieRequest);

    ActorResponse delete (long id);



}
