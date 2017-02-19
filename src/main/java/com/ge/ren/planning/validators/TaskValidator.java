package com.ge.ren.planning.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ge.ren.planning.dto.TaskDto;

/**
*
* @author Yessesvy
*/
public class TaskValidator implements Validator {

    /**
     * Validator to validate Task
     */
    public boolean supports(Class input) {
	return TaskDto.class.equals(input);
    }

    /**
     * Validate the Task
     */
    public void validate(Object taskDto, Errors errors) {
	ValidationUtils.rejectIfEmpty(errors, "task", "task.empty");
	TaskDto t = (TaskDto) taskDto;
	if (t.getTaskResolutionNotes().equals("c")) {
	    errors.rejectValue("taskType", "wrongvalue");
	}
    }

}