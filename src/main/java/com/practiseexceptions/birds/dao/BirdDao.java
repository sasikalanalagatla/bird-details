package com.practiseexceptions.birds.dao;

import com.practiseexceptions.birds.model.Bird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirdDao extends JpaRepository<Bird,Integer> {
     boolean existsByBirdName(String birdName);
}
