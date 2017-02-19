/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package com.ge.ren.planning.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ge.ren.planning.constants.PlanningErrorCodes;
import com.ge.ren.planning.constants.RecurrenceCycleEnum;
import com.ge.ren.planning.constants.RecurrenceEnum;
import com.ge.ren.planning.constants.RecurrenceTypeEnum;
import com.ge.ren.planning.constants.TaskStatusEnum;
import com.ge.ren.planning.domain.Task;
import com.ge.ren.planning.dto.CommonCodeDto;
import com.ge.ren.planning.dto.ErrorDetail;
import com.ge.ren.planning.dto.TaskDto;
import com.ge.ren.planning.dto.TaskRecurrenceDetailsDto;
import com.ge.ren.planning.dto.TaskStatusDto;
import com.ge.ren.planning.dto.TaskTypeDto;
import com.ge.ren.planning.dto.converters.CommonCodeEntityDtoConverter;
import com.ge.ren.planning.dto.converters.TaskEntityDtoConverter;
import com.ge.ren.planning.dto.converters.TaskRecurrenceDetailsDtoConverter;
import com.ge.ren.planning.dto.converters.TaskStatusDtoConverter;
import com.ge.ren.planning.dto.converters.TaskTypeEntityDtoConverter;
import com.ge.ren.planning.repository.ICommonCodeRepository;
import com.ge.ren.planning.repository.TaskRecurrenceDetailsRepository;
import com.ge.ren.planning.repository.TaskRepository;
import com.ge.ren.planning.repository.TaskStatusRepository;
import com.ge.ren.planning.repository.TaskTypeRepository;
import com.ge.ren.planning.service.PlanningService;
import com.ge.ren.planning.util.PlanningUtil;
import com.ge.ren.planning.validators.PlanningValidator;

/**
 *
 * @author Yessesvy
 */
@Component
public class PlanningServiceImpl implements PlanningService {

    @Autowired
    private TaskRepository taskRepository;
    
    @Autowired
    private TaskRecurrenceDetailsRepository taskRecurrenceDetailsRepository;
    
    @Autowired
    private TaskRecurrenceDetailsDtoConverter taskRecurrenceDetailsDtoConverter;

    @Autowired
    private TaskEntityDtoConverter taskEntityDtoConverter;

    @Autowired
    private TaskTypeRepository taskTypeRepository;

    @Autowired
    private TaskTypeEntityDtoConverter taskTypeEntityDtoConverter;

    @Autowired
    private PlanningValidator planningValidator;
    
    @Autowired
    private ICommonCodeRepository commonCodeRepo;
    
    @Autowired
    private CommonCodeEntityDtoConverter commonCodeConverter;
    
    @Autowired
    private TaskStatusRepository taskStatusRepository;
    
    @Autowired
    private TaskStatusDtoConverter taskStatusDtoConverter;

    public List<TaskTypeDto> fetchTaskTypeByUserRoleId(Long userRoleId) {
	return taskTypeRepository.fetchTaskTypeByUserRoleId(userRoleId).stream()
		.map(taskTypeEntityDtoConverter::convertDomainEntityToDto).collect(Collectors.toList());
    }
    
	@Override
	public TaskRecurrenceDetailsDto fetchTaskRecurrenceByTaskId(Long taskId) {
		return taskRecurrenceDetailsDtoConverter.convertDomainEntityToDto(taskRecurrenceDetailsRepository.findByTaskId(taskId));
	}

	@Override
	public TaskDto validateTask(TaskDto taskDto) {
		if (PlanningUtil.isNull(taskDto)) {
			return null;
		}
		return planningValidator.validateAssetTask(taskDto);
	}	
	
    @Override
	public TaskDto createTask(TaskDto taskDto) {
		if (taskDto == null) {
			return null;
		}

		// Validate the input TaskDto
		if (planningValidator.validateAssetTask(taskDto).getErrorDetails() != null) {
			return taskDto;
		}

		// Persist the list of tasks to Task repo
		TaskStatusDto taskStatusDto = null;
		if (PlanningUtil.isNotNull(taskDto.getTaskCompletedOn())) {
			//Populate StatusDto for "COMPLETED"
			taskStatusDto = taskStatusDtoConverter.convertDomainEntityToDto(taskStatusRepository.findByTaskStatusNameDefault(TaskStatusEnum.COMPLETED.toString()));
		} else {
			//Populate StatusDto for "PENDING"
			taskStatusDto = taskStatusDtoConverter.convertDomainEntityToDto(taskStatusRepository.findByTaskStatusNameDefault(TaskStatusEnum.PENDING.toString()));
		}
		taskDto.setTaskStatus(taskStatusDto);
		taskDto.getAssetIds().forEach(t -> {
			
			taskDto.setAssetId(t);
			
			saveTaskAndRecurrence(taskDto); // Create Parent Task and its corresponding Recurrence
			
				if (isEligibleForRecurrence(taskDto)){
					
					TaskDto childTask = constructRecurrenceTaskforInsert(taskDto);
					
					saveTaskAndRecurrence(childTask); // Create Recurrence (Child) Task and its corresponding Recurrence
					
				}
				
		});
		return taskDto;
	}
    
    @Override
  	public TaskDto createSiteTask(TaskDto taskDto) {
  		if (taskDto == null) {
  			return null;
  		}

  		// Validate the input TaskDto
  		if (planningValidator.validateSiteTask(taskDto).getErrorDetails() != null) {
  			return taskDto;
  		}

  		// Persist the list of tasks to Task repo
  		TaskStatusDto taskStatusDto = null;
  		if (PlanningUtil.isNotNull(taskDto.getTaskCompletedOn())) {
  			//Populate StatusDto for "COMPLETED"
  			taskStatusDto = taskStatusDtoConverter.convertDomainEntityToDto(taskStatusRepository.findByTaskStatusNameDefault(TaskStatusEnum.COMPLETED.toString()));
  		} else {
  			//Populate StatusDto for "PENDING"
  			taskStatusDto = taskStatusDtoConverter.convertDomainEntityToDto(taskStatusRepository.findByTaskStatusNameDefault(TaskStatusEnum.PENDING.toString()));
  		}
  		taskDto.setTaskStatus(taskStatusDto);
  			
  			saveTaskAndRecurrence(taskDto); // Create Parent Task and its corresponding Recurrence
  			
  				if (isEligibleForRecurrence(taskDto)){
  					
  					TaskDto childTask = constructRecurrenceTaskforInsert(taskDto);
  					
  					saveTaskAndRecurrence(childTask); // Create Recurrence (Child) Task and its corresponding Recurrence
  					
  				}

  		return taskDto;
  	}


	/**
	 * @param taskDto
	 * @return
	 */
	private TaskDto constructRecurrenceTaskforInsert(TaskDto taskDto) {
		TaskDto childTask = taskDto;
		
		/*manipulate new StatusVO "PENDING" and set it to taskDto*/
		TaskStatusDto childStatusDto = taskStatusDtoConverter.convertDomainEntityToDto(taskStatusRepository.findByTaskStatusNameDefault(TaskStatusEnum.PENDING.toString()));
		
		childTask.setTaskCompletedOn(null);
		
		childTask.setTaskExternalNotes(null);
		
		childTask.setTaskResolutionNotes(null);
		
		childTask.setTaskParentId(taskDto.getTaskId());
		
		childTask.setTaskId(null);
		
		childTask.setTaskDueOn(findTaskDueDateForRecurrence(taskDto));
		
		childTask.setTaskStatus(childStatusDto);
		
		childTask.getTaskRecurrenceDetailsDto().setTaskRecurrenceId(null);
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/DD/YY");
		//childTask.setTaskInternalNotes("Closure notes from parent task closed on "+"'"+taskDto.getTaskCompletedOn().format(formatter)+"'"+":"+taskDto.getTaskResolutionNotes());
		if(RecurrenceTypeEnum.ENDBYOCCURENCE.equals(taskDto.getTaskRecurrenceDetailsDto().getRecurrenceType())){
			
		childTask.getTaskRecurrenceDetailsDto().setRecurrenceEndByCount(taskDto.getTaskRecurrenceDetailsDto().getRecurrenceEndByCount()-1);
		
		}
		return childTask;
	}


	/**
	 * @param taskDto
	 * @return
	 */
	private TaskDto saveTaskAndRecurrence(TaskDto taskDto) {
		
		Task task = taskRepository.save(taskEntityDtoConverter.convertDtoToDomainEntity(taskDto));
		
		// Persist Recurrence Details only if it is present in TaskDto
		if (PlanningUtil.isNotNull(taskDto.getTaskRecurrenceDetailsDto())) {

			taskDto.getTaskRecurrenceDetailsDto().setTaskId(task.getTaskId());
			taskDto.setTaskRecurrenceDetailsDto(taskRecurrenceDetailsDtoConverter
					.convertDomainEntityToDto(taskRecurrenceDetailsRepository.save(taskRecurrenceDetailsDtoConverter
							.convertDtoToDomainEntity(taskDto.getTaskRecurrenceDetailsDto()))));
		}
		
		taskDto.setTaskId(task.getTaskId());
		
		return taskDto;
	}
	

    @Override
    public TaskDto updateTask(TaskDto taskDto) {

    	if (taskDto == null) {
    		return null;
    	}

    	/* Validate the input TaskDto */
    	if (planningValidator.validateAssetTask(taskDto).getErrorDetails() != null) {
    		return taskDto;
    	}

    	TaskStatusDto taskStatusDto = null;
    	
		if (!taskDto.getTaskCompleted() && PlanningUtil.isNotNull(taskDto.getTaskStatus())
				&& TaskStatusEnum.COMPLETED.name().equals(taskDto.getTaskStatus().getTaskStatusNameDefault())
				&& PlanningUtil.isNull(taskDto.getTaskCompletedOn())) {
    		/* Populate StatusDto for "PENDING"*/
    		taskStatusDto = taskStatusDtoConverter.convertDomainEntityToDto(
    				taskStatusRepository.findByTaskStatusNameDefault(TaskStatusEnum.PENDING.name()));

    		taskDto.setTaskStatus(taskStatusDto);
    	}

    	if (taskDto.getTaskCompleted() && PlanningUtil.isNotNull(taskDto.getTaskCompletedOn())) {
    		/* Populate StatusDto for "COMPLETED"*/
    		taskStatusDto = taskStatusDtoConverter.convertDomainEntityToDto(
    				taskStatusRepository.findByTaskStatusNameDefault(TaskStatusEnum.COMPLETED.name()));

    		taskDto.setTaskStatus(taskStatusDto);
    	}
    	

    	/* check if Parent Task has any recursive tasks*/
    	if (isEligibleForRecurrence(taskDto) && PlanningUtil.isNotNull(taskDto.getTaskCompletedOn())
    			&& PlanningUtil.isNull(fetchRecurrenceTasks(taskDto.getTaskId()))) {
    		
    		saveTaskAndRecurrence(taskDto); /*// Persist Parent Task changes*/
    		
    		TaskDto childTask = constructRecurrenceTaskforInsert(taskDto);
    		
    		return saveTaskAndRecurrence(childTask); /*// Insert Recurrence Tasks*/
    		
    	} else if (!taskDto.getTaskCompleted() && PlanningUtil.isNull(taskDto.getTaskCompletedOn())
    			&& PlanningUtil.isNotNull(fetchRecurrenceTasks(taskDto.getTaskId()))) {

    		TaskDto recurrenceDto = fetchRecurrenceTasks(taskDto.getTaskId());

    		if (PlanningUtil.isNull(recurrenceDto.getTaskCompletedOn())) {
    			
    			saveTaskAndRecurrence(taskDto); /* Persist Parent Task changes*/
    			recurrenceDto.setIsActive(false); /* change the active flag to False for Recurrence Task */    			
    			return saveTaskAndRecurrence(recurrenceDto); /*  Deactivate Recurrence Task only if it is not completed */
    		} else {

    			taskDto.setErrorDetails(new ErrorDetail[] { new ErrorDetail(
    					PlanningErrorCodes.TASK_CANNOT_REMOVE_PARENT_TASK_COMPLETED_DATE,
    					"Parent Task Completed Date cannot be removed since its Recurrence task is already completed") });
    			
    			return taskDto;

    		}
    		
    	}
    	
    	return saveTaskAndRecurrence(taskDto);

    }

    @Override
    public List<TaskDto> getTasks() {
	return taskRepository.findByIsActive(true).stream().map(taskEntityDtoConverter::convertDomainEntityToDto)
		.collect(Collectors.toList());
    }
    
    
    @Override
    public TaskDto fetchRecurrenceTasks(Long taskParentId) {
	return taskEntityDtoConverter.convertDomainEntityToDto(taskRepository.findRecurrenceTaskByTaskParentId(taskParentId));
    }

    @Override
    public TaskDto getTaskById(Long taskId) {
	TaskDto taskDto =  taskEntityDtoConverter.convertDomainEntityToDto(taskRepository.findByTaskId(taskId));
	if (PlanningUtil.isNotNull(taskDto)) {
		taskDto.setTaskRecurrenceDetailsDto(fetchTaskRecurrenceByTaskId(taskId));
	}
	return taskDto;
    }

    @Override
    public TaskDto deleteTask(TaskDto taskDto) {
	 if (PlanningUtil.isNull(taskDto)) {
	           return null;
	       }

	       taskDto.setIsActive(false);

	       if (PlanningUtil.isNotNull(taskDto.getTaskRecurrenceDetailsDto())) {
	           taskDto.getTaskRecurrenceDetailsDto().setIsActive(false);
	           taskDto.setTaskRecurrenceDetailsDto(taskRecurrenceDetailsDtoConverter
	                   .convertDomainEntityToDto(taskRecurrenceDetailsRepository.save(taskRecurrenceDetailsDtoConverter
	                           .convertDtoToDomainEntity(taskDto.getTaskRecurrenceDetailsDto()))));
	           
	       }
	       
	       return taskEntityDtoConverter.convertDomainEntityToDto(
	               taskRepository.save(taskEntityDtoConverter.convertDtoToDomainEntity(taskDto)));
    }
    
    @Override
	public List<CommonCodeDto> findAllCodes(String dropdownType, String languageCode) {
		return commonCodeRepo.findByDropdownTypeAndLanguageCode(dropdownType, languageCode).stream()
		.map(commonCodeConverter::convertDomainEntityToDto).collect(Collectors.toList());
	}

	@Override
	public CommonCodeDto findCode(String dropdownType, String dropdownCode, String languageCode) {
		return commonCodeConverter.convertDomainEntityToDto(commonCodeRepo.findByDropdownTypeAndDropdownCodeAndLanguageCode(dropdownType, dropdownCode, languageCode));
	}
	
	
	@Override
	public boolean isEligibleForRecurrence( TaskDto taskDto) {
		
		boolean recurrence = false;
		
		if(PlanningUtil.isNotNull(taskDto) && PlanningUtil.isNotNull(taskDto.getTaskRecurrenceDetailsDto())){
			
			TaskRecurrenceDetailsDto taskRecurrenceDetailsDto =  taskDto.getTaskRecurrenceDetailsDto();//fetchTaskRecurrenceByTaskId(taskDto.getTaskId());
				//TaskDto taskDto = taskRecurrenceDetailsDto.getTaskDto();
				if(PlanningUtil.isNotNull(taskDto.getTaskStatus())){
					String taskStatus = taskDto.getTaskStatus().getTaskStatusNameDefault();
					if(PlanningUtil.isNotNull(taskStatus) && TaskStatusEnum.COMPLETED.name().equals(taskStatus)){

						if(PlanningUtil.isNotNull(taskRecurrenceDetailsDto.getRecurrenceType()) && RecurrenceTypeEnum.ENDBYOCCURENCE.name().equals(taskRecurrenceDetailsDto.getRecurrenceType())){
							if(PlanningUtil.isNotNull(taskRecurrenceDetailsDto.getRecurrenceEndByCount()) && taskRecurrenceDetailsDto.getRecurrenceEndByCount().intValue() > 0){
								recurrence = true;
							}
						}else if(PlanningUtil.isNotNull(taskRecurrenceDetailsDto.getRecurrenceType()) && RecurrenceTypeEnum.ENDBYDATE.name().equals(taskRecurrenceDetailsDto.getRecurrenceType())){
							if(PlanningUtil.isNotNull(taskRecurrenceDetailsDto.getRecurrenceEndByDate()) && taskRecurrenceDetailsDto.getRecurrenceEndByDate().isAfter(LocalDate.now())){
								recurrence = true;
							}
						}else if(PlanningUtil.isNotNull(taskRecurrenceDetailsDto.getRecurrence())){
							LocalDate dueDate = null;
							if(RecurrenceEnum.EVERYCLIMB.getRecurrenceEnumCode().equals(taskRecurrenceDetailsDto.getRecurrence())){
								dueDate = LocalDate.now().plusDays(1);
								if(PlanningUtil.isNotNull(dueDate) && dueDate.isAfter(LocalDate.now())){
									recurrence = true;
								}
							}else if(RecurrenceEnum.MONTHLY.getRecurrenceEnumCode().equals(taskRecurrenceDetailsDto.getRecurrence())){
								dueDate = LocalDate.now().plusMonths(1);
								if(PlanningUtil.isNotNull(dueDate) && dueDate.isAfter(LocalDate.now())){
									recurrence = true;
								}
							}else if(RecurrenceEnum.SEMIANNUAL.getRecurrenceEnumCode().equals(taskRecurrenceDetailsDto.getRecurrence())){
								dueDate = LocalDate.now().plusMonths(6);
								if(PlanningUtil.isNotNull(dueDate) && dueDate.isAfter(LocalDate.now())){
									recurrence = true;
								}
							}else if(RecurrenceEnum.ANNUAL.getRecurrenceEnumCode().equals(taskRecurrenceDetailsDto.getRecurrence())){
								dueDate = LocalDate.now().plusYears(1);
								if(PlanningUtil.isNotNull(dueDate) && dueDate.isAfter(LocalDate.now())){
									recurrence = true;
								}
							}else if(RecurrenceEnum.CUSTOM.getRecurrenceEnumCode().equals(taskRecurrenceDetailsDto.getRecurrence())){
								String otherRecurrence = taskRecurrenceDetailsDto.getRecurrenceCycle(); 
								String[] splited = otherRecurrence.split("\\s+");
								Long recurrenceCycle = Long.valueOf(splited[0]);
									if(recurrenceCycle > 0){
									recurrence = true;
								}
							}

						}
					}
				}
			
		}
		
		return recurrence;
	}
	
	
	@Override
	public LocalDateTime findTaskDueDateForRecurrence(TaskDto taskDto) {
		
		LocalDateTime dueDate = null;
		TaskRecurrenceDetailsDto taskRecurrenceDetailsDto =  taskDto.getTaskRecurrenceDetailsDto();
		
		if(RecurrenceEnum.EVERYCLIMB.getRecurrenceEnumCode().equals(taskRecurrenceDetailsDto.getRecurrence())){
			dueDate = null;
		}else if(RecurrenceEnum.MONTHLY.getRecurrenceEnumCode().equals(taskRecurrenceDetailsDto.getRecurrence())){
			dueDate = LocalDateTime.now().plusMonths(1);
		}else if(RecurrenceEnum.SEMIANNUAL.getRecurrenceEnumCode().equals(taskRecurrenceDetailsDto.getRecurrence())){
			dueDate = LocalDateTime.now().plusMonths(6);
		}else if(RecurrenceEnum.ANNUAL.getRecurrenceEnumCode().equals(taskRecurrenceDetailsDto.getRecurrence())){
			dueDate = LocalDateTime.now().plusYears(1);
		}else if(RecurrenceEnum.CUSTOM.getRecurrenceEnumCode().equals(taskRecurrenceDetailsDto.getRecurrence())){
			String otherRecurrence = taskRecurrenceDetailsDto.getRecurrenceCycle(); 
			String[] splited = otherRecurrence.split("\\s+");
			Long recurrenceCycle = Long.valueOf(splited[0]);
			
			if(RecurrenceCycleEnum.DAYS.name().equalsIgnoreCase(splited[1])){
				dueDate = LocalDateTime.now().plusDays(recurrenceCycle);
			}else if(RecurrenceCycleEnum.WEEKS.name().equalsIgnoreCase(splited[1])){
				dueDate = LocalDateTime.now().plusWeeks(recurrenceCycle);
			}else if(RecurrenceCycleEnum.MONTHS.name().equalsIgnoreCase(splited[1])){
				dueDate = LocalDateTime.now().plusMonths(recurrenceCycle);
			}else if(RecurrenceCycleEnum.YEARS.name().equalsIgnoreCase(splited[1])){
				dueDate = LocalDateTime.now().plusYears(recurrenceCycle);
			}
		}
		
		return dueDate;
	}
	
}
