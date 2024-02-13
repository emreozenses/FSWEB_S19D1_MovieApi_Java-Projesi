package com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto;

import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Actor;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Movie;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MovieRequest {

    private Movie movie;
    private List<Actor> actorList;

}
