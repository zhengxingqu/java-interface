package com.example.demo.tool;

import com.example.demo.entity.Result;
import com.example.demo.entity.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

@ControllerAdvice
public class BaseExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(BaseExceptionHandler.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return new Result("false", StatusCode.ERROR, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
//        logger.error(e.getMessage(), e);
        return new Result("false", StatusCode.ERROR, e.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(ValidationException.class)
    public Result handleValidationException(ValidationException e) {
//        logger.error(e.getMessage(), e);
        return new Result("false", StatusCode.ERROR, e.getCause().getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result handHttpRequestException(HttpRequestMethodNotSupportedException e) {
//        logger.error(e.getMessage(), e);
        return new Result("false", StatusCode.ERROR, e.getMessage());
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public Result handleConstraintViolationException(ConstraintViolationException e) {
//        logger.error(e.getMessage(), e);
        return new Result("false", StatusCode.ERROR, e.getMessage());
    }

}
