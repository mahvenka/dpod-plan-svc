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
@Table(name = "task_attachment")
public class TaskAttachment implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7110332659209213897L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_attachment_id")
    private Long taskAttachmentId;

    @Column(name = "task_id")
    private Long taskId;

    @Column(name = "attachment_id")
    private Long attachmentId;
    
    @Column(name = "attachment_name")
    private String attachementName;

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

    public TaskAttachment() {
	// Default Constructor
    }

    public TaskAttachment(Long taskAttachmentId, Long taskId, Long attachmentId, String attachementName,
	    Boolean isActive, String createdBy, LocalDateTime createdOn, String lastUpdatedBy,
	    LocalDateTime lastUpdatedOn) {
	this.taskAttachmentId = taskAttachmentId;
	this.taskId = taskId;
	this.attachmentId = attachmentId;
	this.attachementName = attachementName;
	this.isActive = isActive;
	this.createdBy = createdBy;
	this.createdOn = createdOn;
	this.lastUpdatedBy = lastUpdatedBy;
	this.lastUpdatedOn = lastUpdatedOn;
    }

    public Long getTaskAttachmentId() {
        return taskAttachmentId;
    }

    public void setTaskAttachmentId(Long taskAttachmentId) {
        this.taskAttachmentId = taskAttachmentId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }

    public String getAttachementName() {
        return attachementName;
    }

    public void setAttachementName(String attachementName) {
        this.attachementName = attachementName;
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
	result = prime * result + ((attachementName == null) ? 0 : attachementName.hashCode());
	result = prime * result + ((attachmentId == null) ? 0 : attachmentId.hashCode());
	result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
	result = prime * result + ((createdOn == null) ? 0 : createdOn.hashCode());
	result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
	result = prime * result + ((lastUpdatedBy == null) ? 0 : lastUpdatedBy.hashCode());
	result = prime * result + ((lastUpdatedOn == null) ? 0 : lastUpdatedOn.hashCode());
	result = prime * result + ((taskAttachmentId == null) ? 0 : taskAttachmentId.hashCode());
	result = prime * result + ((taskId == null) ? 0 : taskId.hashCode());
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
	TaskAttachment other = (TaskAttachment) obj;
	if (attachementName == null) {
	    if (other.attachementName != null)
		return false;
	} else if (!attachementName.equals(other.attachementName))
	    return false;
	if (attachmentId == null) {
	    if (other.attachmentId != null)
		return false;
	} else if (!attachmentId.equals(other.attachmentId))
	    return false;
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
	if (taskAttachmentId == null) {
	    if (other.taskAttachmentId != null)
		return false;
	} else if (!taskAttachmentId.equals(other.taskAttachmentId))
	    return false;
	if (taskId == null) {
	    if (other.taskId != null)
		return false;
	} else if (!taskId.equals(other.taskId))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "TaskAttachment [taskAttachmentId=" + taskAttachmentId + ", taskId=" + taskId + ", attachmentId="
		+ attachmentId + ", attachementName=" + attachementName + ", isActive=" + isActive + ", createdBy="
		+ createdBy + ", createdOn=" + createdOn + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedOn="
		+ lastUpdatedOn + "]";
    }

}
