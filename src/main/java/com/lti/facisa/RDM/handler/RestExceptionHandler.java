package com.lti.facisa.RDM.handler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lti.facisa.RDM.error.ResourceNotFoundDetails;
import com.lti.facisa.RDM.error.ResourceNotFoundException;
import com.lti.facisa.RDM.error.ValidationErrorDetails;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rnfException) {
		
		ResourceNotFoundDetails rnfDetails = ResourceNotFoundDetails.Builder
                .newBuilder()
                .status(HttpStatus.NOT_FOUND.value())
                .name("Resource not found")
                .detail(rnfException.getMessage())
                .developerMessage(rnfException.getClass().getName())
                .build();
        return new ResponseEntity<>(rnfDetails, HttpStatus.NOT_FOUND);
				
	}
	
	 @Override
	    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException manvException,
	                                                          HttpHeaders headers,
	                                                          HttpStatus status,
	                                                          WebRequest request) {
	        List<FieldError> fieldErrors = manvException.getBindingResult().getFieldErrors();
	        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
	        String fieldMessages = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
	        ValidationErrorDetails rnfDetails = ValidationErrorDetails.Builder
	                .newBuilder()
	                .status(HttpStatus.BAD_REQUEST.value())
	                .name("Field Validation Error")
	                .detail("Field Validation Error")
	                .developerMessage(manvException.getClass().getName())
	                .field(fields)
	                .fieldMessage(fieldMessages)
	                .build();
	        return new ResponseEntity<>(rnfDetails, HttpStatus.BAD_REQUEST);
	    }
}
