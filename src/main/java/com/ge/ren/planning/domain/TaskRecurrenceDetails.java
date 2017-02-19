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
import java.time.LocalDate;
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
@Table(name = "task_recurrence_details")
public class TaskRecurrenceDetails implements Serializable {

    private static final long serialVersionUID = -7110332659209213897L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_recurrence_id")
    private Long taskRecurrenceId;

   /* @Column(name = "recurrence_type_id")
    private Long recurrenceTypeId;*/

    //@OneToOne
    @Column(name = "task_id")
    private Long taskId;
    
    @Column(name = "recurrence_type")
    private String recurrenceType;
    
    @Column(name = "recurrence")
    private String recurrence;
    
    @Column(name = "recurrence_cycle")
    private String recurrenceCycle;

    @Column(name = "recurrence_end_by_date")
    private LocalDate recurrenceEndByDate;

    @Column(name = "recurrence_end_by_count")
    private Integer recurrenceEndByCount;

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

    public TaskRecurrenceDetails() {
	// Default Constructor
    }

    public TaskRecurrenceDetails(Long taskRecurrenceId, Long taskId, String recurrenceType,
	    String recurrence, String recurrenceCycle, LocalDate recurrenceEndByDate, Integer recurrenceEndByCount,
	    Boolean isActive, String createdBy, LocalDateTime createdOn, String lastUpdatedBy,
	    LocalDateTime lastUpdatedOn) {
	this.taskRecurrenceId = taskRecurrenceId;
	this.taskId = taskId;
	this.recurrenceType = recurrenceType;
	this.recurrence = recurrence;
	this.recurrenceCycle = recurrenceCycle;
	this.recurrenceEndByDate = recurrenceEndByDate;
	this.recurrenceEndByCount = recurrenceEndByCount;
	this.isActive = isActive;
	this.createdBy = createdBy;
	this.createdOn = createdOn;
	this.lastUpdatedBy = lastUpdatedBy;
	this.lastUpdatedOn = lastUpdatedOn;
    }

    /**
     * @return the taskRecurrenceId
     */
    public Long getTaskRecurrenceId() {
        return taskRecurrenceId;
    }

    /**
     * @param taskRecurrenceId the taskRecurrenceId to set
     */
    public void setTaskRecurrenceId(Long taskRecurrenceId) {
        this.taskRecurrenceId = taskRecurrenceId;
    }

    /**
     * @return the task
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * @param task the task to set
     */
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    /**
     * @return the recurrenceType
     */
    public String getRecurrenceType() {
        return recurrenceType;
    }

    /**
     * @param recurrenceType the recurrenceType to set
     */
    public void setRecurrenceType(String recurrenceType) {
        this.recurrenceType = recurrenceType;
    }

    /**
     * @return the recurrence
     */
    public String getRecurrence() {
        return recurrence;
    }

    /**
     * @param recurrence the recurrence to set
     */
    public void setRecurrence(String recurrence) {
        this.recurrence = recurrence;
    }

    /**
     * @return the recurrenceCycle
     */
    public String getRecurrenceCycle() {
        return recurrenceCycle;
    }

    /**
     * @param recurrenceCycle the recurrenceCycle to set
     */
    public void setRecurrenceCycle(String recurrenceCycle) {
        this.recurrenceCycle = recurrenceCycle;
    }

    /**
     * @return the recurrenceEndByDate
     */
    public LocalDate getRecurrenceEndByDate() {
        return recurrenceEndByDate;
    }

    /**
     * @param recurrenceEndByDate the recurrenceEndByDate to set
     */
    public void setRecurrenceEndByDate(LocalDate recurrenceEndByDate) {
        this.recurrenceEndByDate = recurrenceEndByDate;
    }

    /**
     * @return the recurrenceEndByCount
     */
    public Integer getRecurrenceEndByCount() {
        return recurrenceEndByCount;
    }

    /**
     * @param recurrenceEndByCount the recurrenceEndByCount to set
     */
    public void setRecurrenceEndByCount(Integer recurrenceEndByCount) {
        this.recurrenceEndByCount = recurrenceEndByCount;
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
	result = prime * result + ((recurrence == null) ? 0 : recurrence.hashCode());
	result = prime * result + ((recurrenceCycle == null) ? 0 : recurrenceCycle.hashCode());
	result = prime * result + ((recurrenceEndByCount == null) ? 0 : recurrenceEndByCount.hashCode());
	result = prime * result + ((recurrenceEndByDate == null) ? 0 : recurrenceEndByDate.hashCode());
	result = prime * result + ((recurrenceType == null) ? 0 : recurrenceType.hashCode());
	result = prime * result + ((taskId == null) ? 0 : taskId.hashCode());
	result = prime * result + ((taskRecurrenceId == null) ? 0 : taskRecurrenceId.hashCode());
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
	TaskRecurrenceDetails other = (TaskRecurrenceDetails) obj;
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
	if (recurrence == null) {
	    if (other.recurrence != null)
		return false;
	} else if (!recurrence.equals(other.recurrence))
	    return false;
	if (recurrenceCycle == null) {
	    if (other.recurrenceCycle != null)
		return false;
	} else if (!recurrenceCycle.equals(other.recurrenceCycle))
	    return false;
	if (recurrenceEndByCount == null) {
	    if (other.recurrenceEndByCount != null)
		return false;
	} else if (!recurrenceEndByCount.equals(other.recurrenceEndByCount))
	    return false;
	if (recurrenceEndByDate == null) {
	    if (other.recurrenceEndByDate != null)
		return false;
	} else if (!recurrenceEndByDate.equals(other.recurrenceEndByDate))
	    return false;
	if (recurrenceType == null) {
	    if (other.recurrenceType != null)
		return false;
	} else if (!recurrenceType.equals(other.recurrenceType))
	    return false;
	if (taskId == null) {
	    if (other.taskId != null)
		return false;
	} else if (!taskId.equals(other.taskId))
	    return false;
	if (taskRecurrenceId == null) {
	    if (other.taskRecurrenceId != null)
		return false;
	} else if (!taskRecurrenceId.equals(other.taskRecurrenceId))
	    return false;
	return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "TaskRecurrenceDetails [taskRecurrenceId=" + taskRecurrenceId
		+ ", taskId=" + taskId + ", recurrenceType=" + recurrenceType + ", recurrence=" + recurrence
		+ ", recurrenceCycle=" + recurrenceCycle + ", recurrenceEndByDate=" + recurrenceEndByDate
		+ ", recurrenceEndByCount=" + recurrenceEndByCount + ", isActive=" + isActive + ", createdBy="
		+ createdBy + ", createdOn=" + createdOn + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedOn="
		+ lastUpdatedOn + "]";
    }

}
