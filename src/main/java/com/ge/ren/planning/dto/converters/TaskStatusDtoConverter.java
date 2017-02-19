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

import com.ge.ren.planning.domain.TaskStatus;
import com.ge.ren.planning.dto.TaskStatusDto;

/**
 *
 * @author Yessesvy
 */
@Service("TaskStatusDtoConverter")
public class TaskStatusDtoConverter implements IEntityDtoConverter<TaskStatus, TaskStatusDto> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
	public TaskStatusDto convertDomainEntityToDto(TaskStatus taskStatus) {

		if (taskStatus == null) {
			return null;
		}
		TaskStatusDto taskStatusDto = modelMapper.map(taskStatus, TaskStatusDto.class);
		return taskStatusDto;
	}

    @Override
	public TaskStatus convertDtoToDomainEntity(TaskStatusDto taskStatusDto) {

		if (taskStatusDto == null) {
			return null;
		}
		TaskStatus taskStatus = modelMapper.map(taskStatusDto, TaskStatus.class);
		return taskStatus;
	}

}
