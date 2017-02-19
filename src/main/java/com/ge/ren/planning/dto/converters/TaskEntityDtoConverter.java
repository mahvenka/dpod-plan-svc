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

import com.ge.ren.planning.domain.Task;
import com.ge.ren.planning.dto.TaskDto;

/**
 *
 * @author Yessesvy
 */
@Service("TaskEntityDtoConverter")
public class TaskEntityDtoConverter implements IEntityDtoConverter<Task, TaskDto> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TaskDto convertDomainEntityToDto(Task task) {
    	if (task == null) {
    		return null;
    	}
    	TaskDto taskDto = modelMapper.map(task, TaskDto.class);
    	return taskDto;
    }

    @Override
    public Task convertDtoToDomainEntity(TaskDto taskDto) {

    	if (taskDto == null) {
    		return null;
    	}
    	Task task = modelMapper.map(taskDto, Task.class);
    	return task;
    }

}
