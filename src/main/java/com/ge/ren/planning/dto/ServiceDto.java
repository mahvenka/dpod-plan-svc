/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package com.ge.ren.planning.dto;

import java.io.Serializable;

public class ServiceDto implements Serializable {


	private static final long serialVersionUID = 3897830287658979587L;

	/** The valid. */
	private boolean valid = true;

	private ErrorDetail[] errorDetails;

	public ServiceDto() {
	}

	/**
	 * @return the valid
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * @param valid the valid to set
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}

	/**
	 * @return the errorDetails
	 */
	public ErrorDetail[] getErrorDetails() {
		return errorDetails;
	}

	/**
	 * @param errorDetails the errorDetails to set
	 */
	public void setErrorDetails(ErrorDetail[] errorDetails) {

		if (errorDetails != null && errorDetails.length > 0) {
			this.errorDetails = errorDetails;
			this.valid = false;
		}

	}


	/**
	 * Adds the error details.
	 * 
	 * @param errorDetail the error detail
	 */
	public void addErrorDetails(ErrorDetail errorDetail) {

		if (errorDetail == null) {
			return;
		}

		if (this.errorDetails != null && this.errorDetails.length > 0) {
			ErrorDetail errors[] = new ErrorDetail[this.errorDetails.length + 1];
			// adding the new errorDetail to existing one.
			System.arraycopy(this.errorDetails, 0, errors, 0, this.errorDetails.length);
			errors[errorDetails.length] = errorDetail;
			this.errorDetails = errors;
		} else {
			// no error already exists.
			this.errorDetails = new ErrorDetail[] { errorDetail };
		}
		this.valid = false;
	}


	/**
	 * Adds the error details.
	 * 
	 * @param errorDetail[] the error detail
	 */
	public void addErrorDetails(ErrorDetail[] newErrorDetails) {
		ErrorDetail[] newErrors = newErrorDetails;
		if (newErrors == null || newErrors.length == 0){			
			return;
		}
		if (this.errorDetails != null && this.errorDetails.length > 0) {
			ErrorDetail errors[] = new ErrorDetail[this.errorDetails.length + newErrors.length];
			System.arraycopy(this.errorDetails, 0, errors, 0, this.errorDetails.length);
			System.arraycopy(newErrors, 0, errors, this.errorDetails.length, newErrors.length);
			this.errorDetails = errors;
		} else {
			// no error already exists.
			this.errorDetails = newErrors;
		}
		this.valid = false;
	}


}
