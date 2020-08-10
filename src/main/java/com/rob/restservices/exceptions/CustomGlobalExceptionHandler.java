package com.rob.restservices.exceptions;

import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler{

	/*
	 * This is like a interceptor(?) act on top of exception troggered by @Valid on 
	 * UserController
	 */
	// MethodArgumentNotValidException
	
		//Handlecustom exception raised from controller
		@ExceptionHandler(PortfolioNotFoundException.class)
		public final ResponseEntity<Object> handlePortfolioNotFoundException(PortfolioNotFoundException ex,
				WebRequest request) {
			PortfolioErrorDetails portfolioErrorDetails = new PortfolioErrorDetails(new Date(), ex.getMessage(),
					request.getDescription(false));

			return new ResponseEntity<>(portfolioErrorDetails, HttpStatus.NOT_FOUND);

		}
	
}
