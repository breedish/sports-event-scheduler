package com.breedish.ses.controller;

import com.breedish.ses.dto.ErrorResponseDto;
import com.breedish.ses.exception.BaseAppException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Component
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BaseAppException.class)
    @ResponseBody
    ResponseEntity<ErrorResponseDto> handleError(HttpServletRequest req, BaseAppException e) {
        return new ResponseEntity<ErrorResponseDto>(
            ErrorResponseDto.builder().code(e.getErrorCode()).message(e.getMessage()).build(),
            HttpStatus.valueOf(e.getStatusCode())
        );
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    ResponseEntity<ErrorResponseDto> handleError(HttpServletRequest req, Exception t) {
        return new ResponseEntity<ErrorResponseDto>(
            ErrorResponseDto.builder().message(t.getMessage()).build(),
            HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception e, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>(
            ErrorResponseDto.builder().message(e.getMessage()).build(),
            status
        );
    }
}
