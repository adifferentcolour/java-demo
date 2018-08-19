package com.adifferentcolour.starter.resources;

import com.adifferentcolour.starter.exceptions.PriceMismatchException;
import com.adifferentcolour.starter.exceptions.UnknownBundleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);

    @ExceptionHandler(value = { PriceMismatchException.class })
    public ResponseEntity handlePriceException(RuntimeException ex, WebRequest webRequest) {
        String body = "Price submitted does not match price on record";
        LOGGER.error(body, ex.getCause());
        return handleExceptionInternal(ex, body, null, HttpStatus.BAD_REQUEST, webRequest);
    }

    @ExceptionHandler(value = { UnknownBundleException.class })
    public ResponseEntity handleUnknownBundle(RuntimeException ex, WebRequest webRequest) {
        String body = "Unknown bundle identifier";
        LOGGER.error(body, ex.getCause());
        return handleExceptionInternal(ex, body, null, HttpStatus.BAD_REQUEST, webRequest);
    }

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity handleAllExceptions(RuntimeException ex, WebRequest webRequest) {
        String body = "Unknown exception";
        LOGGER.error(body, ex.getCause());
        return handleExceptionInternal(ex, body, null, HttpStatus.INTERNAL_SERVER_ERROR, webRequest);
    }
}
