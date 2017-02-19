/**
 * 
 */
package com.ge.ren.planning.dto.converters;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ge.ren.planning.domain.TaskTypesForRole;
import com.ge.ren.planning.dto.TaskTypesForRoleDto;

/**
 * @author 502687773
 *
 */
@Service("TaskTypesRoleEntityDtoConverter")
public class TaskTypesRoleEntityDtoConverter implements IEntityDtoConverter<TaskTypesForRole, TaskTypesForRoleDto> {

    /**
     * 
     */
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TaskTypesForRoleDto convertDomainEntityToDto(TaskTypesForRole taskTypesRole) {
	TaskTypesForRoleDto taskTypesRoleDto = modelMapper.map(taskTypesRole, TaskTypesForRoleDto.class);
	return taskTypesRoleDto;
    }

    @Override
    public TaskTypesForRole convertDtoToDomainEntity(TaskTypesForRoleDto taskTypesRoleDto) {
	TaskTypesForRole taskTypesRole = modelMapper.map(taskTypesRoleDto, TaskTypesForRole.class);
	return taskTypesRole;
    }

}
