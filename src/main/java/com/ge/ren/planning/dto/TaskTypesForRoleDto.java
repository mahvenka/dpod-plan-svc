/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package com.ge.ren.planning.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TaskTypesForRoleDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3282155649183111877L;

    /**
     * 
     */
    private Long taskTypeUserRoleRelationId;

    private Long userRoleId;

    private Boolean isActive;

    private String createdBy;

    private LocalDateTime createdOn;

    private String lastUpdatedBy;

    private LocalDateTime lastUpdatedOn;

    public TaskTypesForRoleDto() {
	// DefaultConstructor
    }

    public TaskTypesForRoleDto(Long taskTypeUserRoleRelationId, Long userRoleId, Boolean isActive, String createdBy,
	    LocalDateTime createdOn, String lastUpdatedBy, LocalDateTime lastUpdatedOn) {
	this.taskTypeUserRoleRelationId = taskTypeUserRoleRelationId;
	this.userRoleId = userRoleId;
	this.isActive = isActive;
	this.createdBy = createdBy;
	this.createdOn = createdOn;
	this.lastUpdatedBy = lastUpdatedBy;
	this.lastUpdatedOn = lastUpdatedOn;
    }

    /**
     * @return the taskTypeUserRoleRelationId
     */
    public Long getTaskTypeUserRoleRelationId() {
	return taskTypeUserRoleRelationId;
    }

    /**
     * @param taskTypeUserRoleRelationId
     *            the taskTypeUserRoleRelationId to set
     */
    public void setTaskTypeUserRoleRelationId(Long taskTypeUserRoleRelationId) {
	this.taskTypeUserRoleRelationId = taskTypeUserRoleRelationId;
    }

    /**
     * @return the userRoleId
     */
    public Long getUserRoleId() {
	return userRoleId;
    }

    /**
     * @param userRoleId
     *            the userRoleId to set
     */
    public void setUserRoleId(Long userRoleId) {
	this.userRoleId = userRoleId;
    }

    /**
     * @return the isActive
     */
    public Boolean getIsActive() {
	return isActive;
    }

    /**
     * @param isActive
     *            the isActive to set
     */
    public void setIsActive(Boolean isActive) {
	this.isActive = isActive;
    }

    /**
     * @return the createdBy
     */
    public String getCreatedBy() {
	return createdBy;
    }

    /**
     * @param createdBy
     *            the createdBy to set
     */
    public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
    }

    /**
     * @return the createdOn
     */
    public LocalDateTime getCreatedOn() {
	return createdOn;
    }

    /**
     * @param createdOn
     *            the createdOn to set
     */
    public void setCreatedOn(LocalDateTime createdOn) {
	this.createdOn = createdOn;
    }

    /**
     * @return the lastUpdatedBy
     */
    public String getLastUpdatedBy() {
	return lastUpdatedBy;
    }

    /**
     * @param lastUpdatedBy
     *            the lastUpdatedBy to set
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
	this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * @return the lastUpdatedOn
     */
    public LocalDateTime getLastUpdatedOn() {
	return lastUpdatedOn;
    }

    /**
     * @param lastUpdatedOn
     *            the lastUpdatedOn to set
     */
    public void setLastUpdatedOn(LocalDateTime lastUpdatedOn) {
	this.lastUpdatedOn = lastUpdatedOn;
    }

    @Override
    public String toString() {
	return "TaskTypesRoleDto [taskTypeUserRoleRelationId=" + taskTypeUserRoleRelationId + ", userRoleId="
		+ userRoleId + ", isActive=" + isActive + ", createdBy=" + createdBy + ", createdOn=" + createdOn
		+ ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedOn=" + lastUpdatedOn + "]";
    }

}
