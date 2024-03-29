package com.clinic.clinic.exceptions;

import com.clinic.clinic.DTOs.exceptions.ExceptionDTO;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalException {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            DuplicateKeyException.class,
            HttpRequestMethodNotSupportedException.class,
            MethodArgumentNotValidException.class,
            MissingRequestHeaderException.class,
            MissingServletRequestParameterException.class,
            MethodArgumentTypeMismatchException.class,
            HttpMessageNotReadableException.class
    })
    @ResponseBody
    public ResponseEntity<ExceptionDTO> badRequest(Exception ex, HttpServletRequest request) {
        System.out.println("bad request");
        ExceptionDTO exDTO = new ExceptionDTO(ex, request);
        ex.printStackTrace();
        return new ResponseEntity<ExceptionDTO>(exDTO, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({
            ResourceNotFoundException.class
    })
    @ResponseBody
    public ResponseEntity<ExceptionDTO> notFoundRequest(Exception ex, HttpServletRequest request) {
        System.out.println("resource" + ex.getMessage());
        ExceptionDTO exDTO = new ExceptionDTO(ex, request);
        ex.printStackTrace();
        return new ResponseEntity<ExceptionDTO>(exDTO, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({
            Exception.class
    })
    @ResponseBody
    public ResponseEntity<ExceptionDTO> fatalErrorUnexpectedError(Exception ex, HttpServletRequest request) {
        System.out.println("internal server error");
        ex.printStackTrace();
        ExceptionDTO exDTO = new ExceptionDTO(ex, request);
        return new ResponseEntity<ExceptionDTO>(exDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
