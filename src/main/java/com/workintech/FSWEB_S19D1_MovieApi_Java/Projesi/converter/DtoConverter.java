package com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.converter;

import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto.ActorResponse;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto.MovieResponse;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Actor;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Gender;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class DtoConverter {

    public static ActorResponse convertToActorResponse(Actor actor){
        return new ActorResponse(actor.getId(), actor.getFirstName(), actor.getLastName(), actor.getGender(),actor.getBirthDate());
    }

    public static List<ActorResponse> convertToActorResponseList (List<Actor> actorList){
        List<ActorResponse> actorResponseList = new ArrayList<>();
        if(actorList != null){
            actorList.forEach(actor -> {
                actorResponseList.add(DtoConverter.convertToActorResponse(actor));
            });
            return actorResponseList;
        }
        else {
            throw new RuntimeException("actor list is empty!");
        }

    }

    public static MovieResponse convertToMovieResponse(Movie movie){
        return new MovieResponse( movie.getName(), movie.getRating(), movie.getReleaseDate());
    }

    public static List<MovieResponse> convertToMovieResponseList (List<Movie> movieList){
        List<MovieResponse> movieResponseList = new ArrayList<>();
        if(movieList != null){
            movieList.forEach(movie -> {
                movieResponseList.add(DtoConverter.convertToMovieResponse(movie));
            });
            return movieResponseList;
        }
        else {
            throw new RuntimeException("actor list is empty!");
        }

    }


}
