package com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.service;

import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.converter.DtoConverter;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto.ActorResponse;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto.MovieRequest;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto.MovieResponse;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Actor;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Director;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Movie;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.repository.ActorRepository;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.repository.DirectorRepository;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MovieServiceImpl implements MovieService{

    private MovieRepository movieRepository;
    private ActorRepository actorRepository;
    private DirectorRepository directorRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository,ActorRepository actorRepository,DirectorRepository directorRepository ){
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
        this.directorRepository = directorRepository;
    }

    @Override
    public MovieResponse save(Movie movie) {

         return DtoConverter.convertToMovieResponse(movieRepository.save(movie));
    }

    @Override
    public List<MovieResponse> findAll() {

        return DtoConverter.convertToMovieResponseList(movieRepository.findAll());
    }

    @Override
    public MovieResponse findById(long id) {
        Optional<Movie> movieResponseOptional = movieRepository.findById(id);
        if(movieResponseOptional.isPresent()){
            return DtoConverter.convertToMovieResponse(movieResponseOptional.get());
        }
        throw new RuntimeException("Id is not exist"+id);
    }

    @Override
    public List<MovieResponse> findByName(String name) {
        return movieRepository.findByName(name);
    }

    @Override
    public MovieResponse update(long id, Movie movie) {
        Optional<Movie> foundMovie = movieRepository.findById(id);
        if(foundMovie.isPresent()) {
            foundMovie.get().setName(movie.getName());
            foundMovie.get().setRating(movie.getRating());
            foundMovie.get().setDirector(movie.getDirector());
            foundMovie.get().setReleaseDate(movie.getReleaseDate());
            Movie updatedMovie = foundMovie.get();
            return DtoConverter.convertToMovieResponse(movieRepository.save(updatedMovie));
        }
        throw new RuntimeException("Id is not exist"+id);

    }

    @Override
    public MovieResponse addActor(MovieRequest movieRequest) {
        Movie movie = movieRequest.getMovie();
        List<Actor> actorList = movieRequest.getActorList();

        if(actorList != null){
            actorList.forEach(actor -> {
                movie.addActor(actor);
            });
        }
        MovieResponse savedMovie = DtoConverter.convertToMovieResponse(movieRepository.save(movie));
        return savedMovie;

    }


    @Override
    public MovieResponse delete(long id) {
       MovieResponse willRemove = findById(id);
        movieRepository.deleteById(id);
        return willRemove;
    }
}
