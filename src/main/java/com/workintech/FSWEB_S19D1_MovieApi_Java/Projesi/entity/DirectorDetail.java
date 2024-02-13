package com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "director_detail",schema = "fsweb")
public class DirectorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "movie_types")
    @NotNull
    @Size(min = 2,max = 100,message = "Input character length must be min. 3 ,max.100")
    private String movieTypes;

    @Column(name = "hobbies")
    @NotNull
    @Size(min = 2,max = 100,message = "Input character length must be min. 3 ,max.100")
    private String hobbies;

    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH},mappedBy = "directorDetail")
    private Director director;





}
