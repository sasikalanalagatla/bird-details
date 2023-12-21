package com.practiseexceptions.birds.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiSubError {
    private String string;
    private String field;
    private Object rejectedValue;
    private String message;
}
