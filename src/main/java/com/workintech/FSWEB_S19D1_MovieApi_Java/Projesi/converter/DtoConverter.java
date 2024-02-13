package com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.converter;

import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto.ActorResponse;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto.JustActorResponse;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto.JustMovieResponse;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto.MovieResponse;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Actor;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Gender;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Movie;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.exceptions.ActorException;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.exceptions.MovieException;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class DtoConverter {

    public static ActorResponse convertToActorResponse(Actor actor){
        return new ActorResponse(actor.getId(), actor.getFirstName(), actor.getLastName(),actor.getBirthDate(),null);
    }

    public static ActorResponse convertToActorMovieRequestResponse (Actor actor){
        return  new ActorResponse(actor.getId(), actor.getFirstName(), actor.getLastName(), actor.getBirthDate(),actor.getMovieList());
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
            throw new ActorException("actor list is empty!", HttpStatus.BAD_REQUEST);
        }

    }

    public static MovieResponse convertToMovieResponse(Movie movie){
        return new MovieResponse( movie.getName(), movie.getRating(), movie.getReleaseDate(),null,null);
    }

    public static MovieResponse convertToMovieRequestResponse(Movie movie){
        return new MovieResponse( movie.getName(), movie.getRating(), movie.getReleaseDate(),movie.getActorList(),movie.getDirector());
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
            throw new MovieException("movie list is empty!",HttpStatus.BAD_REQUEST);
        }

    }

    public static JustMovieResponse convertToJustMovieResponse(Movie movie){
        return new JustMovieResponse(movie.getName(), movie.getRating(), movie.getReleaseDate());
    }
    public static List<JustMovieResponse> convertToJustMovieResponseList (List<Movie> movieList){
        List<JustMovieResponse> justMovieResponseList = new ArrayList<>();
        if(movieList != null){
            movieList.forEach(movie -> {
                justMovieResponseList.add(DtoConverter.convertToJustMovieResponse(movie));
            });
            return justMovieResponseList;
        }
        else {
            throw new MovieException("movie list is empty!",HttpStatus.BAD_REQUEST);
        }

    }
    public static JustActorResponse convertToJustActorResponse(Actor actor){
        return new JustActorResponse(actor.getFirstName(), actor.getLastName(),actor.getBirthDate());
    }

    public static List<JustActorResponse> convertToJustActorResponseList (List<Actor> actorList){
        List<JustActorResponse> actorResponseList = new ArrayList<>();
        if(actorList != null){
            actorList.forEach(actor -> {
                actorResponseList.add(DtoConverter.convertToJustActorResponse(actor));
            });
            return actorResponseList;
        }
        else {
            throw new ActorException("actor list is empty!", HttpStatus.BAD_REQUEST);
        }

    }


}
