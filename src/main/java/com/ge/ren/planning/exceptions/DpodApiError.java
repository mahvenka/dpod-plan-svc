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

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

/**
 * @author Yessesvy
 *
 */
public class DpodApiError {

    private HttpStatus status;

    private String errorCode;

    private String errorMessage;
    
    private List<String> errors;
    
    /**
     * @param message
     */
    public DpodApiError(String errorMessage) {
	this.errorMessage = errorMessage;
    }
    
    public DpodApiError(HttpStatus status, String errorCode, String errorMessage, List<String> errors) {
        this.status = status;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errors = errors;
    }
 
    public DpodApiError(HttpStatus status, String errorMessage, String error) {
        this.status = status;
        this.errorMessage = errorMessage;
        errors = Arrays.asList(error);
    }

    /**
     * @return the status
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    /**
     * @return the errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * @return the errors
     */
    public List<String> getErrors() {
        return errors;
    }

    /**
     * @param errors the errors to set
     */
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
    
}
