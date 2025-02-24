package com.desafio.techmanage.exceptions;

import com.desafio.techmanage.exceptions.business.DataAlreadyRegisteredException;
import com.desafio.techmanage.exceptions.business.DataNotRegisteredException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler({
            DataAlreadyRegisteredException.class})
    public ResponseEntity<ApiError> handleExceptions(Exception exception) {
        ApiError errorDTO = new ApiError();

        errorDTO.setError(exception.getClass().getSimpleName());
        errorDTO.setStatus(HttpStatus.BAD_REQUEST.value());
        errorDTO.setMessage(exception.getLocalizedMessage());

        return ResponseEntity.badRequest().body(errorDTO);
    }

    @ExceptionHandler({
            DataNotRegisteredException.class})
    public ResponseEntity<ApiError> handleNotFoundExceptions(Exception exception) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ApiError> handleInvalidField(Exception exception) {
        ApiError errorDTO = new ApiError();

        MethodArgumentNotValidException excp = (MethodArgumentNotValidException) exception;

        StringBuilder fieldBuilder = new StringBuilder();
        for (FieldError fieldError : excp.getFieldErrors()) {
            fieldBuilder.append(fieldError.getField()).append(", ");
        }
        String fields = fieldBuilder.substring(0, fieldBuilder.length() - 2);

        errorDTO.setError(exception.getClass().getSimpleName());
        errorDTO.setStatus(HttpStatus.BAD_REQUEST.value());
        errorDTO.setMessage("campos inválidos: " + fields);

        return ResponseEntity.badRequest().body(errorDTO);
    }

    @ExceptionHandler({Exception.class, HttpMessageNotReadableException.class})
    public ResponseEntity<ApiError> handleUnhandledExceptions(Exception exception) {
        ApiError errorDTO = new ApiError();

        errorDTO.setError(exception.getClass().getSimpleName());
        errorDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity.internalServerError().body(errorDTO);
    }



}
