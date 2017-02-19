/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package com.ge.ren.planning.constants;

/**
 * @author 502585286
 *
 */
public class PlanningErrorCodes {

	/**
	 * 
	 */
	private PlanningErrorCodes() {
		// TODO Auto-generated constructor stub.
	}
	
	public static final String PLAN_SERVICE_ERROR = "PLAN_ERR_1001";
	
	public static final String TASK_PRIORITY_MANDATORY = "PLAN_ERR_1002";
	
	public static final String TASK_ESTIMATED_DURATION_MANDATORY = "PLAN_ERR_1003";

	public static final String TASK_ADDED_ON_DATE_MANDATORY = "PLAN_ERR_1004";

	public static final String TASK_NUMBER_OF_TECH_NEEDED_NUMERIC = "PLAN_ERR_1005";

	public static final String TASK_DUE_ON_DATE_ADD_ON_DATE = "PLAN_ERR_1006";

	public static final String TASK_ATLEAST_ONE_ASSET = "PLAN_ERR_1007";
	
	public static final String TASK_RECURRENCE_NOT_APPLICABLE_FOR_THIS_TASK = "PLAN_ERR_1008";
	
	public static final String TASK_OCCURRENCE_MANDATORY_FOR_END_AFTER_RECURRENCE = "PLAN_ERR_1009";
	
	public static final String TASK_END_BY_DATE_MANDATORY_FOR_END_BY_RECURRENCE = "PLAN_ERR_1010";
	
	public static final String TASK_END_BY_DATE_SHOULD_NOT_BE_PAST_DATE = "PLAN_ERR_1011";
	
	public static final String TASK_RECURRENCE_CYCLE_IS_MANDATORY = "PLAN_ERR_1012";
	
	public static final String TASK_RECURRENCE_CYCLE_IS_INVALID = "PLAN_ERR_1013";
	
	public static final String TASK_CANNOT_REMOVE_PARENT_TASK_COMPLETED_DATE = "PLAN_ERR_1014";
	
	public static final String TASK_TYPE_MANDATORY = "PLAN_ERR_1015";
	
	public static final String TASK_CATEGORY_MANDATORY = "PLAN_ERR_1016";
	
	public static final String TASK_CATEGORY_INVALID = "PLAN_ERR_1017";
	
	public static final String TASK_ADDED_ON_DATE_INVALID = "PLAN_ERR_1018";
	
	public static final String TASK_DESCRIPTION_EXCESS_LENGTH = "PLAN_ERR_1019";
	
}
