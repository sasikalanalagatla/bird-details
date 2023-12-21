package com.practiseexceptions.birds.service;

import com.practiseexceptions.birds.dao.BirdDao;
import com.practiseexceptions.birds.dto.BirdDto;
import com.practiseexceptions.birds.exception.BirdAleadyExist;
import com.practiseexceptions.birds.model.Bird;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BirdService {
    @Autowired
    BirdDao birdDao;

    public List<BirdDto> getAllBirds() {
        List<BirdDto> res = new ArrayList<>();
        List<Bird> birds = birdDao.findAll();
        for(int i=0;i<birds.size();i++){
            Bird b = birds.get(i);
            BirdDto br = new BirdDto(b.getBirdId(),b.getBirdName(),b.getColor());
            res.add(br);
        }
        return res;
    }


    public BirdDto addBird(BirdDto birdDto) {
        if(birdDao.existsByBirdName(birdDto.getBirdName())){
            throw new BirdAleadyExist("Name already exist");
        }
        Bird bird = new Bird(birdDto.getBirdName(),birdDto.getColor());
         Bird b =birdDao.save(bird);
         BirdDto res = new BirdDto(b.getBirdId(),b.getBirdName(),b.getColor());
         return res;
    }
}
