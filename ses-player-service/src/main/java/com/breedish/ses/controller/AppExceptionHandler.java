package com.breedish.ses.controller;

import com.breedish.ses.dto.ErrorResponseDto;
import com.breedish.ses.exception.BaseAppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger log = LoggerFactory.getLogger(AppExceptionHandler.class);

    @ExceptionHandler(BaseAppException.class)
    @ResponseBody
    ResponseEntity<ErrorResponseDto> handleError(HttpServletRequest req, BaseAppException e) {
        log.error("Issue ", e);
        return new ResponseEntity<ErrorResponseDto>(
            ErrorResponseDto.builder().code(e.getErrorCode()).message(e.getMessage()).build(),
            HttpStatus.valueOf(e.getStatusCode())
        );
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    ResponseEntity<ErrorResponseDto> handleError(HttpServletRequest req, Exception t) {
        log.error("Issue ", t);
        return new ResponseEntity<ErrorResponseDto>(
            ErrorResponseDto.builder().message(t.getMessage()).build(),
            HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception e, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {
        log.error("Issue ", e);
        return new ResponseEntity<Object>(
            ErrorResponseDto.builder().message(e.getMessage()).build(),
            status
        );
    }
}
