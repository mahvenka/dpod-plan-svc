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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import com.ge.ren.planning.domain.TaskType;
import com.ge.ren.planning.dto.TaskTypeDto;

/**
 *
 * @author Yessesvy
 */
@Service("TaskTypeEntityDtoConverter")
public class TaskTypeEntityDtoConverter implements IEntityDtoConverter<TaskType, TaskTypeDto> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TaskTypeDto convertDomainEntityToDto(TaskType taskType) {
	TaskTypeDto taskTypeDto = modelMapper.map(taskType, TaskTypeDto.class);
	return taskTypeDto;
    }

    @Override
    public TaskType convertDtoToDomainEntity(TaskTypeDto taskTypeDto) {
	TaskType taskType = modelMapper.map(taskTypeDto, TaskType.class);
	return taskType;
    }

}
