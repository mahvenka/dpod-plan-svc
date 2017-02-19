/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package com.ge.ren.planning.service;

import java.time.LocalDateTime;
import java.util.List;

import com.ge.ren.planning.dto.CommonCodeDto;
import com.ge.ren.planning.dto.TaskDto;
import com.ge.ren.planning.dto.TaskRecurrenceDetailsDto;
import com.ge.ren.planning.dto.TaskTypeDto;

public interface PlanningService {

    List<TaskTypeDto> fetchTaskTypeByUserRoleId(Long userRoleId);

    /**
     * @param taskDto
     * @param assetIds 
     * @return
     */
    TaskDto createTask(TaskDto taskDto);

    /**
     * @param taskDto
     * @param assetIds 
     * @return
     */
    TaskDto createSiteTask(TaskDto taskDto);
    
    /**
     * @param taskDto
     * @return
     */
    TaskDto updateTask(TaskDto taskDto);

    /**
     * @param taskDto
     * @return
     */
    List<TaskDto> getTasks();

    /**
     * @param taskId
     * @return
     */
    TaskDto getTaskById(Long taskId);

    /**
     * @param taskDto
     * @return
     */
    TaskDto deleteTask(TaskDto taskDto);
    
    List<CommonCodeDto> findAllCodes(String dropdownType, String LanguageCode);
    
    CommonCodeDto findCode(String dropdownType, String dropdownCode, String LanguageCode);
    
    TaskRecurrenceDetailsDto fetchTaskRecurrenceByTaskId(Long taskID);
    
    boolean isEligibleForRecurrence(TaskDto taskDto );
    
    LocalDateTime findTaskDueDateForRecurrence(TaskDto taskDto);

	TaskDto fetchRecurrenceTasks(Long taskParentId);
	
	TaskDto validateTask(TaskDto taskDto);
	
    

}
