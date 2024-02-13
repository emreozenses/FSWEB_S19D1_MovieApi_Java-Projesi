package com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.id.factory.spi.GeneratorDefinitionResolver;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "actor",schema = "fsweb")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    @NotNull
    @Size(min = 3,max = 50,message = "Input character length must be min. 3 ,max.50")
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    @Size(min = 3,max = 50,message = "Input character length must be min. 3 ,max.50")
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "gender")
    @NotNull
    private Gender gender;

    @Column(name = "birth_date")
    @NotNull
    private LocalDate birthDate;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "actor_movie",schema = "fsweb",
    joinColumns = @JoinColumn(name = "actor_id"),
    inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Movie> movieList;

    public void addMovie(Movie movie){
        if(movieList == null){
            movieList = new ArrayList<>();
        }
        movieList.add(movie);
    }



}
