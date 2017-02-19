/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package com.ge.ren.planning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ge.ren.planning.domain.Task;

/**
 * @author Yessesvy
 *
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    List<Task> findAll();

    List<Task> findByIsActive(@Param("isActive") Boolean isActive);

    Task findByTaskId(@Param("taskId") Long id);
    
    Task findRecurrenceTaskByTaskParentId(@Param("task_parent_id") Long taskParentId);

}
