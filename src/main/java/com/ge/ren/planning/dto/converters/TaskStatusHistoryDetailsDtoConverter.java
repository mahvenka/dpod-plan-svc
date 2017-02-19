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

import com.ge.ren.planning.domain.TaskStatusHistoryDetails;
import com.ge.ren.planning.dto.TaskStatusHistoryDetailsDto;

/**
 *
 * @author Yessesvy
 */
@Service("TaskStatusHistoryDetailsDtoConverter")
public class TaskStatusHistoryDetailsDtoConverter implements IEntityDtoConverter<TaskStatusHistoryDetails, TaskStatusHistoryDetailsDto> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TaskStatusHistoryDetailsDto convertDomainEntityToDto(TaskStatusHistoryDetails taskStatusHistoryDetails) {
	TaskStatusHistoryDetailsDto taskStatusHistoryDetailsDto = modelMapper.map(taskStatusHistoryDetails, TaskStatusHistoryDetailsDto.class);
	return taskStatusHistoryDetailsDto;
    }

    @Override
    public TaskStatusHistoryDetails convertDtoToDomainEntity(TaskStatusHistoryDetailsDto taskStatusHistoryDetailsDto) {
	TaskStatusHistoryDetails taskStatusHistoryDetails = modelMapper.map(taskStatusHistoryDetailsDto, TaskStatusHistoryDetails.class);
	return taskStatusHistoryDetails;
    }

}
