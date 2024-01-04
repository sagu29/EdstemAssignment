package com.cms.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> handleGlobalException(Exception se, WebRequest wr){
		MyErrorDetails error = new MyErrorDetails();
		error.setLocalDateTime(LocalDateTime.now());
		error.setDiscription(wr.getDescription(false));
		error.setMessege(se.getMessage());
		
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CmsException.class)
	public ResponseEntity<MyErrorDetails> handleCmsException(CmsException ce, WebRequest wr){
	MyErrorDetails error = new MyErrorDetails();
	error.setLocalDateTime(LocalDateTime.now());
	error.setDiscription(wr.getDescription(false));
	error.setMessege(ce.getMessage());
	
	return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	

}
