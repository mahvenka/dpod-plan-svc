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

import com.ge.ren.planning.domain.TaskPriority;
import com.ge.ren.planning.dto.TaskPriorityDto;

/**
 *
 * @author Yessesvy
 */
@Service("TaskPriorityDtoConverter")
public class TaskPriorityDtoConverter implements IEntityDtoConverter<TaskPriority, TaskPriorityDto> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TaskPriorityDto convertDomainEntityToDto(TaskPriority taskPriority) {
	TaskPriorityDto taskPriorityDto = modelMapper.map(taskPriority, TaskPriorityDto.class);
	return taskPriorityDto;
    }

    @Override
    public TaskPriority convertDtoToDomainEntity(TaskPriorityDto taskPriorityDto) {
	TaskPriority taskPriority = modelMapper.map(taskPriorityDto, TaskPriority.class);
	return taskPriority;
    }

}
