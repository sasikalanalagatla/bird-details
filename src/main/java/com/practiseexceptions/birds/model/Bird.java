package com.practiseexceptions.birds.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "bird")
public class Bird {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int birdId;
    private String birdName;

    public Bird(String birdName, String color) {
        this.birdName = birdName;
        this.color = color;
    }

    private String color;

}
