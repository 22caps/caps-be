package com.syu.capsbe.domain.auth.exception.common;

import com.syu.capsbe.domain.auth.exception.AuthEmailExistenceException;
import com.syu.capsbe.global.response.message.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AuthExceptionHandler {

    @ExceptionHandler(AuthEmailExistenceException.class)
    public ResponseEntity<ErrorResponse> catchNonExistentEmail(AuthEmailExistenceException e) {
        log.warn(e.getErrorCode());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.of(e.getErrorCode(), e.getErrorMessage()));
    }
}
