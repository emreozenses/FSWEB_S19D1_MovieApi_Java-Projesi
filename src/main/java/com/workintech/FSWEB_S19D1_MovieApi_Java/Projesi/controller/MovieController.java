package com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.controller;

import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto.*;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Actor;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Director;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Movie;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public List<MovieResponse> findAll(){
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public MovieResponse findById(@PathVariable long id){
        return movieService.findById(id);
    }

    @GetMapping("/findByName/{name}")
    public List<JustMovieResponse> findByName(@PathVariable String name){
        return movieService.findByName(name);
    }

    @PostMapping("/")
    public MovieResponse save (@Validated @RequestBody MovieRequest movieRequest){
        List<Actor> actorList = movieRequest.getActorList();
        Movie movie = movieRequest.getMovie();
        Director director = movieRequest.getDirector();
        actorList.forEach(actor -> {
            movie.addActor(actor);
        });
        director.addMovie(movie);
        movie.setDirector(director);

        return movieService.save(movie);
    }



    @PostMapping("/addActor")
    public MovieResponse addActor (@Validated @RequestBody MovieRequest movieRequest){
        return movieService.addActor(movieRequest);
    }


    @PutMapping("/{id}")
    public MovieResponse update(@PathVariable long id,@Validated @RequestBody Movie movie){
        return movieService.update(id,movie);

    }

    @DeleteMapping("/{id}")
    public MovieResponse delete(@PathVariable long id){
        return movieService.delete(id);
    }



}
