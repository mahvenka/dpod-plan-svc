/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package com.ge.ren.planning.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ge.ren.planning.dto.CommonCodeDto;
import com.ge.ren.planning.dto.TaskDto;
import com.ge.ren.planning.dto.TaskTypeDto;
import com.ge.ren.planning.service.PlanningService;

import io.swagger.annotations.ApiOperation;

/**
 * @author Yessesvy
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/plan")
public class PlanningController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlanningController.class);

    @Autowired
    private PlanningService planningService;

    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity<Object> handle() {
	return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Retreives the Task Type details", response = ResponseEntity.class)
    @RequestMapping(value = "/task/taskType", method = RequestMethod.GET)
    public ResponseEntity<List<TaskTypeDto>> retrieveTaskTypeByUserRoleId(
	    @RequestParam(value = "userRoleId", required = true) Long userRoleId) {
	return new ResponseEntity<>(planningService.fetchTaskTypeByUserRoleId(userRoleId), HttpStatus.OK);
    }

    @ApiOperation(value = "Get Task Details", response = ResponseEntity.class)
    @RequestMapping(value = "/task/fetchTaskDetails", method = RequestMethod.GET)
    public ResponseEntity<List<TaskDto>> getTasks() {
	return new ResponseEntity<>(planningService.getTasks(), HttpStatus.OK);
    }
    
    @ApiOperation(value = "Get Task By Id", response = ResponseEntity.class)
    @RequestMapping(value = "/task/fetchTaskById", method = RequestMethod.GET)
    public ResponseEntity<TaskDto> getTaskById(@RequestParam(value = "taskId", required = true) Long taskId) {
	return new ResponseEntity<>(planningService.getTaskById(taskId), HttpStatus.OK);
    }
    
    
    @ApiOperation(value = "Validate a Task", response = ResponseEntity.class)
    @RequestMapping(value = "/task/validateTask", method = RequestMethod.POST)
    public ResponseEntity<TaskDto> validate(@RequestBody TaskDto taskDto) { 
	return new ResponseEntity<>(planningService.validateTask(taskDto), HttpStatus.CREATED);
    }
    
 
    @ApiOperation(value = "Create a Task", response = ResponseEntity.class)
    @RequestMapping(value = "/task/createTask", method = RequestMethod.POST)
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) { 
	return new ResponseEntity<>(planningService.createTask(taskDto), HttpStatus.CREATED);
    }
    
    @ApiOperation(value = "Create a Site Task", response = ResponseEntity.class)
    @RequestMapping(value = "/task/createSiteTask", method = RequestMethod.POST)
    public ResponseEntity<TaskDto> createSiteTask(@RequestBody TaskDto taskDto) { 
	return new ResponseEntity<>(planningService.createSiteTask(taskDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update a Task", response = ResponseEntity.class)
    @RequestMapping(value = "/task/updateTask", method = RequestMethod.PUT)
    public ResponseEntity<TaskDto> updateTask(@RequestBody TaskDto taskDto) {
	return new ResponseEntity<>(planningService.updateTask(taskDto), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a Task", response = ResponseEntity.class)
    @RequestMapping(value = "/task/deleteTask", method = RequestMethod.PUT)
    public ResponseEntity<TaskDto> deleteTask(@RequestBody TaskDto taskDto) {
	return new ResponseEntity<>(planningService.deleteTask(taskDto), HttpStatus.OK);
    }
    
    @ApiOperation(value = "Retreives the dropdown details for the dropdown type and language", response = ResponseEntity.class)
    @RequestMapping(value = "/allCodes", method = RequestMethod.GET)
    public ResponseEntity<List<CommonCodeDto>> findAllCodes(
	    @RequestParam(value = "dropdownType", required = true) String dropdownType,
	    @RequestParam(value = "languageCode", required = true) String languageCode) {
	return new ResponseEntity<>(planningService.findAllCodes(dropdownType, languageCode), HttpStatus.OK);
    }

    @ApiOperation(value = "Retreives one dropdown value for the dropdown type, code and language", response = ResponseEntity.class)
    @RequestMapping(value = "/code", method = RequestMethod.GET)
    public ResponseEntity<CommonCodeDto> findCode(
	    @RequestParam(value = "dropdownType", required = true) String dropdownType,
	    @RequestParam(value = "dropdownCode", required = true) String dropdownCode,
	    @RequestParam(value = "languageCode", required = true) String languageCode) {
	return new ResponseEntity<>(planningService.findCode(dropdownType, dropdownCode, languageCode), HttpStatus.OK);
    }

}
