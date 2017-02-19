/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package com.ge.ren.planning.util;

import java.time.LocalDateTime;

/**
 * @author 502585286
 *
 */
public class PlanningUtil {

	/** The Constant BLANK. */
	public static final String BLANK = "";

	/** The Constant NULL. */
	public static final String NULL = "null";

	/**
	 * 
	 */
	private PlanningUtil() {

	}

	/**
	 * This method will convert the system time (UTC) to respective Site Local
	 * time based on below params
	 * 
	 * @param LocalDateTime
	 *            dbTime
	 * @param Long
	 *            offsetHrs
	 * @param Long
	 *            offsetMts
	 */
	public static LocalDateTime convertToSiteLocalDateTime(LocalDateTime dbTime, Long offsetHrs, Long offsetMts) {

		dbTime.plusHours(offsetHrs);
		dbTime.plusMinutes(offsetMts);
		return dbTime;
	}

	public static Boolean compareDates(LocalDateTime date1, LocalDateTime date2, String Operation) {
		return false;
	}

	/**
	 * This method is used to check the given string is null or empty.
	 *
	 * @param inputStr
	 *            type String
	 * @return true if the given string is null/empty. Else return false.
	 */
	public static boolean isNull(String inputStr) {
		if (inputStr == null) {
			return true;
		}

		inputStr = inputStr.trim();

		if (inputStr.equals(NULL) || inputStr.equals(BLANK)) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to check the given string is not null or not empty.
	 * 
	 * @param inputStr
	 *            type String
	 * @return true if the given string is null/empty. Else return false.
	 */
	public static boolean isNotNull(String inputStr) {
		boolean isNotNull = true;
		if (inputStr == null) {
			isNotNull = false;
		} else {
			inputStr = inputStr.trim();
			if (inputStr.equals(NULL) || inputStr.equals(BLANK)) {
				isNotNull = false;
			}
		}
		return isNotNull;
	}

	/**
	 * This method to used whether the input object is null.
	 *
	 * @param obj
	 *            as type Object
	 * @return boolean
	 */
	public static boolean isNull(Object obj) {

		return (obj == null) ? true : false;
	}

	/**
	 * This method to used whether the input object is not null.
	 *
	 * @param obj
	 *            as type Object
	 * @return boolean
	 */
	public static boolean isNotNull(Object obj) {

		return (obj != null) ? true : false;
	}

	/**
	 * This method to used whether the input array object is null.
	 *
	 * @param obj
	 *            as type Object
	 * @return boolean true if input array object is null or array length is
	 *         zero otherwise returns false.
	 */
	public static boolean isNull(Object[] obj) {

		return (obj == null || obj.length <= 0) ? true : false;
	}
	
	
	/**
	 * Checks if is numeric.
	 *
	 * @param strInput the str input
	 * @return true, if is numeric
	 */
	public static boolean isNumeric(String strInput) {
		char inputChar;
		boolean valid = true;
		if (strInput == null) {
			return valid;//assuming null string is valid.
		} else {
			int strInputLength = strInput.length();
			for (int index = 0; index < strInputLength; index++) {
				inputChar = strInput.charAt(index);
				if ((inputChar >= 48 && inputChar <= 57)) {
					continue;
				} else {
					valid = false;
					return valid;
				}
			}
			return valid;
		}
	}

}
