package com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.controller;

import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto.ActorMovieRequest;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto.ActorResponse;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Actor;
import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/actor")
public class ActorController {

    private ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/")
    public List<ActorResponse> findAll(){
        return actorService.findAll();
    }

    @GetMapping("/{id}")
    public ActorResponse findById(@PathVariable long id){
        return actorService.findById(id);
    }

    @GetMapping("/findByName/{name}")
    public List<ActorResponse> findByName(@PathVariable String name){
        return actorService.findByName(name);
    }

    @GetMapping("/orderByBirthDateAsc")
    public List<ActorResponse> orderByBirthDateAsc(){
        return actorService.orderByBirthDateAsc();
    }

    @PostMapping("/")
    public ActorResponse save (@RequestBody Actor actor){
        return actorService.save(actor);
    }
    @PostMapping("/addMovie")
    public ActorResponse addMovie (@RequestBody ActorMovieRequest actorMovieRequest){
        return actorService.addMovie(actorMovieRequest);
    }


    @PutMapping("/{id}")
    public ActorResponse update(@PathVariable long id,@RequestBody Actor actor){
        return actorService.update(id,actor);

    }

    @DeleteMapping("/{id}")
    public ActorResponse delete(@PathVariable long id){
        return actorService.delete(id);
    }




}
