/*
 * Copyright (c) 2017 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package com.ge.ren.planning.constants;

/**
*
* @author General Electric
* 
*/
public enum RecurrenceEnum {
	
	
	MONTHLY("1"),
	ANNUAL("2"),
	SEMIANNUAL("3"),
	EVERYCLIMB("4"),
	CUSTOM("5");
	
	private String recurrenceCode;
	
	private RecurrenceEnum(String s) {
		recurrenceCode = s;
	}
 
	public String getRecurrenceEnumCode() {
		return recurrenceCode;
	}

}
