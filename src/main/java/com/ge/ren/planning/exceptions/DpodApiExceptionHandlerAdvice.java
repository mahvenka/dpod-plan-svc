/*
 * Copyright (c) 2017 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package com.ge.ren.planning.exceptions;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

/**
 * @author Yessesvy
 *
 */
@ControllerAdvice
public class DpodApiExceptionHandlerAdvice {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<DpodApiError> exception(Exception exception, WebRequest request) {
	// return new
	// DpodApiError(Throwables.getRootCause(exception).getMessage());
	/*
	 * List<String> a = new ArrayList<>(); a.add("210: Very Bad");
	 * a.add("260: Not so Bad"); MapUtils.
	 */
	exception.printStackTrace();
	return new ResponseEntity<>(
		new DpodApiError(HttpStatus.BAD_REQUEST, "299", exception.getMessage(), new ArrayList<>()),
		HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PlanningException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<DpodApiError> genericException(Exception exception) {
	List<String> a = new ArrayList<>();
	a.add("200: Very Bad");
	a.add("250: Not so Bad");
	return new ResponseEntity<>(new DpodApiError(HttpStatus.BAD_REQUEST, "300", exception.getMessage(), a),
		HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<DpodApiError> handleConstraintViolation(ConstraintViolationException exception) {
	List<String> errors = new ArrayList<String>();
	System.out.println("Entered this!!");
	for (ConstraintViolation<?> violation : exception.getConstraintViolations()) {
	    System.out.println(violation.getRootBeanClass().getName() + " " + violation.getPropertyPath() + ": "
		    + violation.getMessage());
	    errors.add(violation.getRootBeanClass().getName() + " " + violation.getPropertyPath() + ": "
		    + violation.getMessage());
	}
	return new ResponseEntity<>(new DpodApiError(HttpStatus.BAD_REQUEST, "301", exception.getMessage(), errors),
		HttpStatus.BAD_REQUEST);
    }

}