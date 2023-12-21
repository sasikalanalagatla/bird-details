package com.practiseexceptions.birds.controller;

import com.practiseexceptions.birds.dto.BirdDto;
import com.practiseexceptions.birds.model.Bird;
import com.practiseexceptions.birds.service.BirdService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BirdController {
    @Autowired
    BirdService birdService;

    @GetMapping("birds")
    public List<BirdDto> getAllBirds(){
        return birdService.getAllBirds();
    }

    @PostMapping("bird")
    public BirdDto addBird(@RequestBody @Valid BirdDto birdDto){
        return birdService.addBird(birdDto);
    }
}
