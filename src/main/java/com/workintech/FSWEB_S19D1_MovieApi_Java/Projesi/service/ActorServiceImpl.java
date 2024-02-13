package com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.service;

import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.converter.DtoConverter;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto.ActorMovieRequest;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto.ActorResponse;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto.JustActorResponse;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Actor;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Movie;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.exceptions.ActorException;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService{

    private final ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public ActorResponse save(Actor actor) {
        return DtoConverter.convertToActorMovieRequestResponse(actorRepository.save(actor));
    }

    @Override
    public List<ActorResponse> findAll() {
        List<Actor> foundActorList = actorRepository.findAll();
        return DtoConverter.convertToActorResponseList(foundActorList);
    }

    @Override
    public ActorResponse findById(long id) {
        Optional<Actor> foundActor = actorRepository.findById(id);
        if(foundActor.isPresent()){
            return DtoConverter.convertToActorResponse(foundActor.get());
        }
        throw new ActorException("Given id is not exist: "+id, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<JustActorResponse> findByName(String name) {

        return DtoConverter.convertToJustActorResponseList(actorRepository.findByName(name));
    }

    @Override
    public List<JustActorResponse> orderByBirthDateAsc() {

        return DtoConverter.convertToJustActorResponseList(actorRepository.orderByBirthDateAsc());
    }


    @Override
    public ActorResponse update(long id, Actor actor) {
        Optional<Actor> foundActor = actorRepository.findById(id);
        if(foundActor.isPresent()){
            foundActor.get().setFirstName(actor.getFirstName());
            foundActor.get().setLastName(actor.getLastName());
            foundActor.get().setGender(actor.getGender());
            foundActor.get().setBirthDate(actor.getBirthDate());
            foundActor.get().setMovieList(actor.getMovieList());
            actorRepository.save(foundActor.get());
            return DtoConverter.convertToActorResponse(foundActor.get());
        }

        throw new ActorException("Given id is not exist: "+id, HttpStatus.NOT_FOUND);
    }

    @Override
    public ActorResponse addMovie(ActorMovieRequest actorMovieRequest) {
            Actor actor = actorMovieRequest.getActor();
            List<Movie> movieList = actorMovieRequest.getMovieList();

            if(movieList != null){
                movieList.forEach(movie -> {
                    actor.addMovie(movie);
                });
            }
            ActorResponse savedActor = DtoConverter.convertToActorResponse(actorRepository.save(actor));
            return savedActor;

    }

    @Override
    public ActorResponse delete(long id) {
        ActorResponse willRemove = findById(id);
        actorRepository.deleteById(id);
        return willRemove;
    }
}
