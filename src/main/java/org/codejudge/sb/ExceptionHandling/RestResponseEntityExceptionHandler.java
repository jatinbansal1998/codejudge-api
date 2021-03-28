package org.codejudge.sb.ExceptionHandling;

import org.codejudge.sb.dto.BaseResponseEntityMO;
import org.codejudge.sb.dto.ErrorResponseMO;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.codejudge.sb.constants.Status.FAILURE;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = UdaanBusinessException.class)
    protected ResponseEntity<BaseResponseEntityMO> handleException(RuntimeException exception, WebRequest webRequest) {
        ErrorResponseMO errorResponseMO = ErrorResponseMO.builder()
                .status(FAILURE.getValue())
                .reason(exception.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseMO);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponseEntityMO());
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    protected ResponseEntity<BaseResponseEntityMO> handleConstraintViolationExceptionException(RuntimeException exception, WebRequest webRequest) {
        ErrorResponseMO errorResponseMO = ErrorResponseMO.builder()
                .status(FAILURE.getValue())
                .reason(exception.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseMO);
    }

    @ExceptionHandler(value = UdaanNotFoundException.class)
    protected ResponseEntity<BaseResponseEntityMO> handleNotFoundException(RuntimeException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BaseResponseEntityMO());
    }
}
