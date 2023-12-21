package com.practiseexceptions.birds.exception.handler;

import com.practiseexceptions.birds.dto.ApiErrorResponse;
import com.practiseexceptions.birds.dto.ApiSubError;
import com.practiseexceptions.birds.exception.BirdAleadyExist;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {



    @ExceptionHandler(BirdAleadyExist.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiErrorResponse> handleBirdExit(BirdAleadyExist br){
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
        apiErrorResponse.setStatus("409 CONFLICT");
        apiErrorResponse.setMessage(br.getMessage());
        apiErrorResponse.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(apiErrorResponse,HttpStatus.CONFLICT);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ApiErrorResponse errorResponse = new ApiErrorResponse();
        errorResponse.setStatus("400 NOT_FOUND");
        errorResponse.setTimestamp(LocalDateTime.now());
        if(ex.getBindingResult().hasErrors()){
            List<ApiSubError> subErrors=ex.getBindingResult().getFieldErrors().stream().map(error-> new ApiSubError(
                    "bird",error.getField(),error.getRejectedValue(),error.getDefaultMessage()))
                    .collect(Collectors.toList());
            errorResponse.setSubErrors(subErrors);
        }
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
