package com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.repository;

import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto.ActorResponse;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ActorRepository extends JpaRepository<Actor,Long> {

    @Query(value = "SELECT a.id,a.first_name,a.last_name,a.gender,a.birth_date FROM fsweb.actor AS a WHERE a.name ILIKE %:name%",nativeQuery = true)
    List<ActorResponse> findByName(String name);

    @Query("SELECT a.id,a.firstName,a.lastName,a.gender,a.birthDate FROM Actor a ORDER BY a.birthDate ASC ")
    List<ActorResponse> orderByBirthDateAsc();

}
