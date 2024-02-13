package com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto;

import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Actor;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Director;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Movie;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@NoArgsConstructor
@Validated
public class MovieRequest {

    private Movie movie;
    private List<Actor> actorList;
    private Director director;

}
