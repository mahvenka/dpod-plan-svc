package com.ge.ren.planning.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ge.ren.planning.dto.TaskTypeDto;

/**
*
* @author Yessesvy
*/
public class TaskTypeValidator implements Validator {

    /**
     * Validator to validate TaskType
     */
    public boolean supports(Class input) {
	return TaskTypeDto.class.equals(input);
    }

    /**
     * Validate the TaskType
     */
    public void validate(Object taskType, Errors errors) {
	ValidationUtils.rejectIfEmpty(errors, "taskTypeNameDefault", "taskTypeNameDefault.empty");
	TaskTypeDto t = (TaskTypeDto) taskType;
	if (t.getTaskTypeId() < 0) {
	    errors.rejectValue("taskTypeId", "negativevalue");
	}
    }

}