package com.icommerce.product.restapi.impl;

import com.icommerce.product.service.shared.AccessDeniedException;
import com.icommerce.product.service.shared.BadRequestException;
import com.icommerce.product.service.shared.Constants;
import com.icommerce.product.service.shared.ResourceNotFoundException;
import com.icommerce.product.restapi.dto.CustomResponseBody;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({BadRequestException.class, HttpMediaTypeNotSupportedException.class, HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<CustomResponseBody<String>> badRequestExceptionHandler(Throwable ex, HttpServletRequest request) {
        final CustomResponseBody<String> response = new CustomResponseBody<>(Constants.FAILURE_STATUS, String.valueOf(HttpStatus.BAD_REQUEST), Constants.BAD_REQUEST_ERR_MSG);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<CustomResponseBody<String>> constraintViolationExceptionHandler(Throwable ex, HttpServletRequest request) {
        final CustomResponseBody<String> response = new CustomResponseBody<>(Constants.FAILURE_STATUS, String.valueOf(HttpStatus.BAD_REQUEST), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<CustomResponseBody<String>> resourceNotFoundExceptionHandler(Throwable ex, HttpServletRequest request) {
        final CustomResponseBody<String> response = new CustomResponseBody<>(Constants.FAILURE_STATUS, String.valueOf(HttpStatus.BAD_REQUEST), Constants.RESOURCE_NOT_FOUND_ERR_MSG);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({AccessDeniedException.class, AccessDeniedException.class})
    public ResponseEntity<CustomResponseBody<String>> accessDeniedExceptionHandler(Throwable ex, HttpServletRequest request) {
        final CustomResponseBody<String> response = new CustomResponseBody<>(Constants.FAILURE_STATUS, String.valueOf(HttpStatus.FORBIDDEN), Constants.ACCESS_DENIED_ERR_MSG);
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<CustomResponseBody<String>> globalExceptionHandler(Throwable ex, HttpServletRequest request) {
        final CustomResponseBody<String> response = new CustomResponseBody<>(Constants.FAILURE_STATUS, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR), Constants.INTERNAL_SERVER_ERR_MSG);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
