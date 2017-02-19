package com.ge.ren.planning.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ge.ren.planning.dto.TaskDto;
import com.ge.ren.planning.dto.TaskTypeDto;

/**
*
* @author Yessesvy
*/
public class InputValidator implements Validator {

    /**
     * Validator to validate Task
     */
    public boolean supports(Class input) {
	return TaskTypeDto.class.equals(input);
    }

    /**
     * Validate the Task
     */
    public void validate(Object task, Errors errors) {
	ValidationUtils.rejectIfEmpty(errors, "taskType", "taskType.empty");
	TaskDto t = (TaskDto) task;
	if (t.getTaskResolutionNotes().equals("c")) {
	    errors.rejectValue("taskType", "wrongvalue");
	}
    }

}