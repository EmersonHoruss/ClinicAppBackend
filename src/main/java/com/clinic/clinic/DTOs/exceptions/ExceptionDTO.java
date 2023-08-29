package com.clinic.clinic.DTOs.exceptions;


import lombok.Getter;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Getter
public class ExceptionDTO {
    private final Date timestamp;
    private final String message;
    private final String path;
    private List<SubExceptionDTO> errors;

    public ExceptionDTO(Exception ex, HttpServletRequest request){
        timestamp = new Date();
        message = ex.getMessage();
        System.out.println(ex.getLocalizedMessage());
        System.out.println(ex.toString());

        path = request.getRequestURI();
        initErrors(ex);
    }

    private void initErrors(Exception ex) {
        errors = new ArrayList<SubExceptionDTO>();
        if (ex instanceof MethodArgumentNotValidException){
            List<ObjectError> objectErrors = ((MethodArgumentNotValidException) ex).getBindingResult().getAllErrors();
            for (ObjectError objectError:objectErrors) {
                errors.add(new SubExceptionDTO(objectError));
            }
        }else{
            errors = null;
        }
    }
}
