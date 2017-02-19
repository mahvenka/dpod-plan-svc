/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package com.ge.ren.planning.exceptions;

/**
 *
 * @author Yessesvy
 */
public class PlanningException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PlanningException() {
	super("Error while communicating with Planning services!!");
    }

    /**
     * Custom Constructor with Parameter with error message
     */
    public PlanningException(String errorMessage) {
	super(errorMessage);
    }

    /**
     * Custom Constructor with Parameter with error message
     */
    public PlanningException(Exception e) {
	super(e);
    }

}