package com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.repository;

import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto.ActorResponse;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ActorRepository extends JpaRepository<Actor,Long> {

    @Query(value = "SELECT a.id,a.gender,a.first_name,a.last_name,a.birth_date FROM fsweb.actor AS a WHERE a.first_name ILIKE %:name%",nativeQuery = true)
    List<Actor> findByName(String name);

    @Query(value = "SELECT a.id,a.gender,a.first_name,a.last_name,a.birth_date FROM fsweb.actor AS a ORDER BY a.birth_date ASC ",nativeQuery = true)
    List<Actor> orderByBirthDateAsc();

}
