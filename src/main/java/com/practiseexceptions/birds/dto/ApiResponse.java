package com.practiseexceptions.birds.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T>{
    private String source = "Practise-Exceptions";
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime startTime = LocalDateTime.now();
    private String status = "SUCCESS";
    private T data;

    public ApiResponse(T data) {
        this.data = data;
    }
}
