/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package com.ge.ren.planning.validators;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.ge.ren.planning.constants.PlanningErrorCodes;
import com.ge.ren.planning.constants.RecurrenceEnum;
import com.ge.ren.planning.constants.RecurrenceTypeEnum;
import com.ge.ren.planning.constants.TaskCategoryEnum;
import com.ge.ren.planning.constants.TaskTypeEnum;
import com.ge.ren.planning.dto.ErrorDetail;
import com.ge.ren.planning.dto.TaskDto;
import com.ge.ren.planning.dto.TaskRecurrenceDetailsDto;
import com.ge.ren.planning.util.PlanningUtil;

/**
 * @author Yessesvy
 *
 */
@Service("planningValidator")
public class PlanningValidator {

	/**
	 * 
	 * This method is for validating taskDto object for "Asset" Task before persisting into database
	 * 
	 * @param taskDto
	 */
	public TaskDto validateAssetTask(TaskDto taskDto) {
		
		validateTask(taskDto);
		
		if (PlanningUtil.isNull(taskDto.getAssetIds()) || taskDto.getAssetIds().size() < 1) {
			taskDto.addErrorDetails(new ErrorDetail[] {
					new ErrorDetail(PlanningErrorCodes.TASK_ATLEAST_ONE_ASSET, "Please provide atleast one Asset") });
		}
		
		return taskDto;

	}


	/**
	 * 
	 * This method is for validating taskDto object for "Site" Task before persisting into database
	 * 
	 * @param taskDto
	 */
	public TaskDto validateSiteTask(TaskDto taskDto) {
		
		validateTask(taskDto);
		
		if(PlanningUtil.isNull(taskDto.getTaskCategory())){
			taskDto.addErrorDetails(new ErrorDetail[] { new ErrorDetail(PlanningErrorCodes.TASK_CATEGORY_MANDATORY,
					"Task Category should not be null") });
		}else if(!TaskCategoryEnum.SITE.name().equalsIgnoreCase(taskDto.getTaskCategory())){
			taskDto.addErrorDetails(new ErrorDetail[] { new ErrorDetail(PlanningErrorCodes.TASK_CATEGORY_INVALID,
					"Task Category has to be 'SITE'") });
		}
		
		return taskDto;

	}
	
	/**
	 * 
	 * This common validation method is for validating task object for 'Asset' & 'Site' Task before persisting into database
	 * 
	 * @param taskDto
	 */
	private void validateTask(TaskDto taskDto) {

		if (PlanningUtil.isNull(taskDto.getTaskType())
				|| PlanningUtil.isNull(taskDto.getTaskType().getTaskTypeNameDefault())) {
			taskDto.addErrorDetails(new ErrorDetail[] {
					new ErrorDetail(PlanningErrorCodes.TASK_TYPE_MANDATORY, "Task Type is mandatory") });
		}
		if (PlanningUtil.isNull(taskDto.getTaskPriority())
				|| PlanningUtil.isNull(taskDto.getTaskPriority().getTaskPriorityNameDefault())) {
			taskDto.addErrorDetails(new ErrorDetail[] {
					new ErrorDetail(PlanningErrorCodes.TASK_PRIORITY_MANDATORY, "Task Priority is mandatory") });
		}
		if (PlanningUtil.isNull(taskDto.getTaskEstimatedDurationHrs())
				|| PlanningUtil.isNull(taskDto.getTaskEstimatedDurationMins())) {
			taskDto.addErrorDetails(
					new ErrorDetail[] { new ErrorDetail(PlanningErrorCodes.TASK_ESTIMATED_DURATION_MANDATORY,
							"Task Estimated Duration is mandatory") });
		}
		if (PlanningUtil.isNull(taskDto.getTaskAddedOn())) {
			taskDto.addErrorDetails(new ErrorDetail[] { new ErrorDetail(PlanningErrorCodes.TASK_ADDED_ON_DATE_MANDATORY,
					"Task Added On Date is mandatory") });
		}
		// TODO - Part Details - Perform sanity check, filter script tags
		if (PlanningUtil.isNotNull(taskDto.getTaskDueOn()) && PlanningUtil.isNotNull(taskDto.getTaskAddedOn())
				&& taskDto.getTaskDueOn().isBefore(taskDto.getTaskAddedOn())) {
			taskDto.addErrorDetails(new ErrorDetail[] { new ErrorDetail(PlanningErrorCodes.TASK_DUE_ON_DATE_ADD_ON_DATE,
					"Task Due On Date cannot be earlier than Task Added On Date") });
		}

		if (PlanningUtil.isNotNull(taskDto.getTaskDescription()) && taskDto.getTaskDescription().length() > 2000) {

			taskDto.addErrorDetails(
					new ErrorDetail[] { new ErrorDetail(PlanningErrorCodes.TASK_DESCRIPTION_EXCESS_LENGTH,
							"Task Description length cannot exceed 2000 characters") });

		}

		if (PlanningUtil.isNotNull(taskDto.getTaskRecurrenceDetailsDto())) {

			validateTaskRecurrence(taskDto);

		}
	}
	

	/**
	 * 
	 * This method is for validating taskRecurrence object before persisting into database
	 * 
	 * @param taskDto
	 */
	private void validateTaskRecurrence(TaskDto taskDto) {

		TaskRecurrenceDetailsDto taskRecurrenceDetailsDto = taskDto.getTaskRecurrenceDetailsDto();

		String recurrenceType = taskRecurrenceDetailsDto.getRecurrenceType();

		if (TaskTypeEnum.MCE.name().equals(taskDto.getTaskType().getTaskTypeNameDefault())) {

			taskDto.addErrorDetails(
					new ErrorDetail[] { new ErrorDetail(PlanningErrorCodes.TASK_RECURRENCE_NOT_APPLICABLE_FOR_THIS_TASK,
							"Recurrence is not Applicable for MCE Task") });
		}

		if (RecurrenceTypeEnum.ENDBYOCCURENCE.name().equals(recurrenceType)
				& PlanningUtil.isNull(taskRecurrenceDetailsDto.getRecurrenceEndByCount())) {

			taskDto.addErrorDetails(new ErrorDetail[] {
					new ErrorDetail(PlanningErrorCodes.TASK_OCCURRENCE_MANDATORY_FOR_END_AFTER_RECURRENCE,
							"Occurrence is mandatory for Task Recurrence type 'End After'") });

		}

		if (RecurrenceTypeEnum.ENDBYDATE.name().equals(recurrenceType)) {

			if (PlanningUtil.isNotNull(taskRecurrenceDetailsDto.getRecurrenceEndByDate())) {

				if (taskRecurrenceDetailsDto.getRecurrenceEndByDate().isBefore(LocalDate.now())) {

					taskDto.addErrorDetails(new ErrorDetail[] {
							new ErrorDetail(PlanningErrorCodes.TASK_END_BY_DATE_SHOULD_NOT_BE_PAST_DATE,
									"Task End By Date should not be a Past Date") });
				}

			} else {

				taskDto.addErrorDetails(new ErrorDetail[] {
						new ErrorDetail(PlanningErrorCodes.TASK_END_BY_DATE_MANDATORY_FOR_END_BY_RECURRENCE,
								"End By Date is mandatory for Task Recurrence type 'End By'") });
			}
		}

		if (RecurrenceEnum.CUSTOM.getRecurrenceEnumCode().equals(taskRecurrenceDetailsDto.getRecurrence())) {

			if (PlanningUtil.isNotNull(taskRecurrenceDetailsDto.getRecurrenceCycle())) {

				String otherRecurrenceCycle = taskRecurrenceDetailsDto.getRecurrenceCycle();
				String[] splited = otherRecurrenceCycle.split("\\s+");

				if (PlanningUtil.isNumeric(splited[0])) {
					
					Long recurrenceCycle = Long.valueOf(splited[0]);
					
					if (recurrenceCycle.longValue() == 0) {

						taskDto.addErrorDetails(
								new ErrorDetail[] { new ErrorDetail(PlanningErrorCodes.TASK_RECURRENCE_CYCLE_IS_INVALID,
										"Task Recurrence Cycle is invalid") });
					}
				} else {

					taskDto.addErrorDetails(
							new ErrorDetail[] { new ErrorDetail(PlanningErrorCodes.TASK_RECURRENCE_CYCLE_IS_INVALID,
									"Task Recurrence Cycle is invalid") });
				}

			} else {

				taskDto.addErrorDetails(
						new ErrorDetail[] { new ErrorDetail(PlanningErrorCodes.TASK_RECURRENCE_CYCLE_IS_MANDATORY,
								"Task Recurrence Cycle is Mandatory if Task Recurrence is 'Other'") });
			}

		}

	}

}
