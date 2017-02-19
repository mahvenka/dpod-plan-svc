/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package com.ge.ren.planning.dto.converters;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ge.ren.planning.domain.TaskRecurrenceDetails;
import com.ge.ren.planning.dto.TaskRecurrenceDetailsDto;

/**
 *
 * @author Yessesvy
 */
@Service("TaskRecurrenceDetailsDtoConverter")
public class TaskRecurrenceDetailsDtoConverter
implements IEntityDtoConverter<TaskRecurrenceDetails, TaskRecurrenceDetailsDto> {

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public TaskRecurrenceDetailsDto convertDomainEntityToDto(TaskRecurrenceDetails taskRecurrenceDetails) {

		if (taskRecurrenceDetails == null) {
			return null;
		}
		TaskRecurrenceDetailsDto taskRecurrenceDetailsDto = modelMapper.map(taskRecurrenceDetails,
				TaskRecurrenceDetailsDto.class);
		return taskRecurrenceDetailsDto;
	}

	@Override
	public TaskRecurrenceDetails convertDtoToDomainEntity(TaskRecurrenceDetailsDto taskRecurrenceDetailsDto) {

		if (taskRecurrenceDetailsDto == null) {
			return null;
		}
		TaskRecurrenceDetails taskRecurrenceDetails = modelMapper.map(taskRecurrenceDetailsDto,
				TaskRecurrenceDetails.class);
		return taskRecurrenceDetails;
	}

}
