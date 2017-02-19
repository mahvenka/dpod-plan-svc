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

/**
 * @author 502687773
 *
 */
public class TaskTypeDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 4959659715397968312L;

    private Long taskTypeId;

    private Long tenantId;

    private String taskTypeNameDefault;

    private Long displayOrder;

    private Boolean isActive;

    private String createdBy;

    private LocalDateTime createdOn;

    private String lastUpdatedBy;

    private LocalDateTime lastUpdatedOn;

    public TaskTypeDto() {
	// Default Constructor
    }

    public TaskTypeDto(Long taskTypeId, Long tenantId, String taskTypeNameDefault, Long displayOrder, Boolean isActive,
	    String createdBy, LocalDateTime createdOn, String lastUpdatedBy, LocalDateTime lastUpdatedOn) {
	this.taskTypeId = taskTypeId;
	this.tenantId = tenantId;
	this.taskTypeNameDefault = taskTypeNameDefault;
	this.displayOrder = displayOrder;
	this.isActive = isActive;
	this.createdBy = createdBy;
	this.createdOn = createdOn;
	this.lastUpdatedBy = lastUpdatedBy;
	this.lastUpdatedOn = lastUpdatedOn;
    }

    public Long getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(Long taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getTaskTypeNameDefault() {
        return taskTypeNameDefault;
    }

    public void setTaskTypeNameDefault(String taskTypeNameDefault) {
        this.taskTypeNameDefault = taskTypeNameDefault;
    }

    public Long getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Long displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public LocalDateTime getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(LocalDateTime lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
	result = prime * result + ((createdOn == null) ? 0 : createdOn.hashCode());
	result = prime * result + ((displayOrder == null) ? 0 : displayOrder.hashCode());
	result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
	result = prime * result + ((lastUpdatedBy == null) ? 0 : lastUpdatedBy.hashCode());
	result = prime * result + ((lastUpdatedOn == null) ? 0 : lastUpdatedOn.hashCode());
	result = prime * result + ((taskTypeId == null) ? 0 : taskTypeId.hashCode());
	result = prime * result + ((taskTypeNameDefault == null) ? 0 : taskTypeNameDefault.hashCode());
	result = prime * result + ((tenantId == null) ? 0 : tenantId.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	TaskTypeDto other = (TaskTypeDto) obj;
	if (createdBy == null) {
	    if (other.createdBy != null)
		return false;
	} else if (!createdBy.equals(other.createdBy))
	    return false;
	if (createdOn == null) {
	    if (other.createdOn != null)
		return false;
	} else if (!createdOn.equals(other.createdOn))
	    return false;
	if (displayOrder == null) {
	    if (other.displayOrder != null)
		return false;
	} else if (!displayOrder.equals(other.displayOrder))
	    return false;
	if (isActive == null) {
	    if (other.isActive != null)
		return false;
	} else if (!isActive.equals(other.isActive))
	    return false;
	if (lastUpdatedBy == null) {
	    if (other.lastUpdatedBy != null)
		return false;
	} else if (!lastUpdatedBy.equals(other.lastUpdatedBy))
	    return false;
	if (lastUpdatedOn == null) {
	    if (other.lastUpdatedOn != null)
		return false;
	} else if (!lastUpdatedOn.equals(other.lastUpdatedOn))
	    return false;
	if (taskTypeId == null) {
	    if (other.taskTypeId != null)
		return false;
	} else if (!taskTypeId.equals(other.taskTypeId))
	    return false;
	if (taskTypeNameDefault == null) {
	    if (other.taskTypeNameDefault != null)
		return false;
	} else if (!taskTypeNameDefault.equals(other.taskTypeNameDefault))
	    return false;
	if (tenantId == null) {
	    if (other.tenantId != null)
		return false;
	} else if (!tenantId.equals(other.tenantId))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "TaskTypeDto [taskTypeId=" + taskTypeId + ", tenantId=" + tenantId + ", taskTypeNameDefault="
		+ taskTypeNameDefault + ", displayOrder=" + displayOrder + ", isActive=" + isActive + ", createdBy="
		+ createdBy + ", createdOn=" + createdOn + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedOn="
		+ lastUpdatedOn + "]";
    }

}
