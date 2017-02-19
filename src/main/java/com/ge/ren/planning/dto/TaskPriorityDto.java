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
 * @author Yessesvy
 *
 */
public class TaskPriorityDto implements Serializable {

    private static final long serialVersionUID = -7110332659209213897L;

    private Long taskPriorityId;

    private Long tenantId;

    private String taskPriorityNameDefault;

    private Integer taskPriorityOrder;

    private Boolean isActive;

    private String createdBy;

    private LocalDateTime createdOn;

    private String lastUpdatedBy;

    private LocalDateTime lastUpdatedOn;

    public TaskPriorityDto() {
	// Default Constructor
    }

    public TaskPriorityDto(Long taskPriorityId, Long tenantId, String taskPriorityNameDefault,
	    Integer taskPriorityOrder, Boolean isActive, String createdBy, LocalDateTime createdOn,
	    String lastUpdatedBy, LocalDateTime lastUpdatedOn) {
	this.taskPriorityId = taskPriorityId;
	this.tenantId = tenantId;
	this.taskPriorityNameDefault = taskPriorityNameDefault;
	this.taskPriorityOrder = taskPriorityOrder;
	this.isActive = isActive;
	this.createdBy = createdBy;
	this.createdOn = createdOn;
	this.lastUpdatedBy = lastUpdatedBy;
	this.lastUpdatedOn = lastUpdatedOn;
    }

    /**
     * @return the taskPriorityId
     */
    public Long getTaskPriorityId() {
	return taskPriorityId;
    }

    /**
     * @param taskPriorityId
     *            the taskPriorityId to set
     */
    public void setTaskPriorityId(Long taskPriorityId) {
	this.taskPriorityId = taskPriorityId;
    }

    /**
     * @return the tenantId
     */
    public Long getTenantId() {
	return tenantId;
    }

    /**
     * @param tenantId
     *            the tenantId to set
     */
    public void setTenantId(Long tenantId) {
	this.tenantId = tenantId;
    }

    /**
     * @return the taskPriorityNameDefault
     */
    public String getTaskPriorityNameDefault() {
	return taskPriorityNameDefault;
    }

    /**
     * @param taskPriorityNameDefault
     *            the taskPriorityNameDefault to set
     */
    public void setTaskPriorityNameDefault(String taskPriorityNameDefault) {
	this.taskPriorityNameDefault = taskPriorityNameDefault;
    }

    /**
     * @return the taskPriorityOrder
     */
    public Integer getTaskPriorityOrder() {
	return taskPriorityOrder;
    }

    /**
     * @param taskPriorityOrder
     *            the taskPriorityOrder to set
     */
    public void setTaskPriorityOrder(Integer taskPriorityOrder) {
	this.taskPriorityOrder = taskPriorityOrder;
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
	result = prime * result + ((createdOn == null) ? 0 : createdOn.hashCode());
	result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
	result = prime * result + ((lastUpdatedBy == null) ? 0 : lastUpdatedBy.hashCode());
	result = prime * result + ((lastUpdatedOn == null) ? 0 : lastUpdatedOn.hashCode());
	result = prime * result + ((taskPriorityId == null) ? 0 : taskPriorityId.hashCode());
	result = prime * result + ((taskPriorityNameDefault == null) ? 0 : taskPriorityNameDefault.hashCode());
	result = prime * result + ((taskPriorityOrder == null) ? 0 : taskPriorityOrder.hashCode());
	result = prime * result + ((tenantId == null) ? 0 : tenantId.hashCode());
	return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	TaskPriorityDto other = (TaskPriorityDto) obj;
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
	if (taskPriorityId == null) {
	    if (other.taskPriorityId != null)
		return false;
	} else if (!taskPriorityId.equals(other.taskPriorityId))
	    return false;
	if (taskPriorityNameDefault == null) {
	    if (other.taskPriorityNameDefault != null)
		return false;
	} else if (!taskPriorityNameDefault.equals(other.taskPriorityNameDefault))
	    return false;
	if (taskPriorityOrder == null) {
	    if (other.taskPriorityOrder != null)
		return false;
	} else if (!taskPriorityOrder.equals(other.taskPriorityOrder))
	    return false;
	if (tenantId == null) {
	    if (other.tenantId != null)
		return false;
	} else if (!tenantId.equals(other.tenantId))
	    return false;
	return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "TaskPriorityDto [taskPriorityId=" + taskPriorityId + ", tenantId=" + tenantId
		+ ", taskPriorityNameDefault=" + taskPriorityNameDefault + ", taskPriorityOrder=" + taskPriorityOrder
		+ ", isActive=" + isActive + ", createdBy=" + createdBy + ", createdOn=" + createdOn
		+ ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedOn=" + lastUpdatedOn + "]";
    }

}
