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

import com.ge.ren.planning.domain.TaskAttachment;
import com.ge.ren.planning.dto.TaskAttachmentDto;

/**
 *
 * @author Yessesvy
 */
@Service("TaskAttachmentDtoConverter")
public class TaskAttachmentDtoConverter implements IEntityDtoConverter<TaskAttachment, TaskAttachmentDto> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TaskAttachmentDto convertDomainEntityToDto(TaskAttachment taskAttachment) {
	TaskAttachmentDto taskAttachmentDto = modelMapper.map(taskAttachment, TaskAttachmentDto.class);
	return taskAttachmentDto;
    }

    @Override
    public TaskAttachment convertDtoToDomainEntity(TaskAttachmentDto taskAttachmentDto) {
	TaskAttachment taskAttachment = modelMapper.map(taskAttachmentDto, TaskAttachment.class);
	return taskAttachment;
    }

}
