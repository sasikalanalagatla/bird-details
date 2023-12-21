package com.practiseexceptions.birds.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BirdDto {
    private int birdId;
    @NonNull
    private String birdName;
    @NonNull
    private String color;
}
