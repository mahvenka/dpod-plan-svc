/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package com.ge.ren.planning.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Yessesvy
 *
 */
@Entity
@Table(name = "task_status")
public class TaskStatus implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7110332659209213897L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_status_id")
    private Long taskStatusId;

    @Column(name = "task_status_name_default")
    private String taskStatusNameDefault;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "last_updated_by")
    private String lastUpdatedBy;

    @Column(name = "last_updated_on")
    private LocalDateTime lastUpdatedOn;

    public TaskStatus() {
	// Default Constructor
    }

    public TaskStatus(Long taskStatusId, String taskStatusNameDefault, Boolean isActive, String createdBy,
	    LocalDateTime createdOn, String lastUpdatedBy, LocalDateTime lastUpdatedOn) {
	this.taskStatusId = taskStatusId;
	this.taskStatusNameDefault = taskStatusNameDefault;
	this.isActive = isActive;
	this.createdBy = createdBy;
	this.createdOn = createdOn;
	this.lastUpdatedBy = lastUpdatedBy;
	this.lastUpdatedOn = lastUpdatedOn;
    }
    
    /**
     * @return the taskStatusId
     */
    public Long getTaskStatusId() {
        return taskStatusId;
    }

    /**
     * @param taskStatusId the taskStatusId to set
     */
    public void setTaskStatusId(Long taskStatusId) {
        this.taskStatusId = taskStatusId;
    }

    /**
     * @return the taskStatusNameDefault
     */
    public String getTaskStatusNameDefault() {
        return taskStatusNameDefault;
    }

    /**
     * @param taskStatusNameDefault the taskStatusNameDefault to set
     */
    public void setTaskStatusNameDefault(String taskStatusNameDefault) {
        this.taskStatusNameDefault = taskStatusNameDefault;
    }

    /**
     * @return the isActive
     */
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
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
     * @param createdBy the createdBy to set
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
     * @param createdOn the createdOn to set
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
     * @param lastUpdatedBy the lastUpdatedBy to set
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
     * @param lastUpdatedOn the lastUpdatedOn to set
     */
    public void setLastUpdatedOn(LocalDateTime lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    /* (non-Javadoc)
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
	result = prime * result + ((taskStatusId == null) ? 0 : taskStatusId.hashCode());
	result = prime * result + ((taskStatusNameDefault == null) ? 0 : taskStatusNameDefault.hashCode());
	return result;
    }

    /* (non-Javadoc)
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
	TaskStatus other = (TaskStatus) obj;
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
	if (taskStatusId == null) {
	    if (other.taskStatusId != null)
		return false;
	} else if (!taskStatusId.equals(other.taskStatusId))
	    return false;
	if (taskStatusNameDefault == null) {
	    if (other.taskStatusNameDefault != null)
		return false;
	} else if (!taskStatusNameDefault.equals(other.taskStatusNameDefault))
	    return false;
	return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "TaskStatus [taskStatusId=" + taskStatusId + ", taskStatusNameDefault=" + taskStatusNameDefault
		+ ", isActive=" + isActive + ", createdBy=" + createdBy + ", createdOn=" + createdOn
		+ ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedOn=" + lastUpdatedOn + "]";
    }

}
