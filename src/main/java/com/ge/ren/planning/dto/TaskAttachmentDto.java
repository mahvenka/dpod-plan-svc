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

public class TaskAttachmentDto implements Serializable {
    
    private static final long serialVersionUID = -7110332659209213897L;

    private Long taskAttachmentId;

    private Long taskId;

    private Long attachmentId;
    
    private String attachementName;

    private Boolean isActive;

    private String createdBy;

    private LocalDateTime createdOn;

    private String lastUpdatedBy;

    private LocalDateTime lastUpdatedOn;
    
    public TaskAttachmentDto() {
	// Default Constructor
    }

    public TaskAttachmentDto(Long taskAttachmentId, Long taskId, Long attachmentId, String attachementName,
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

    /**
     * @return the taskAttachmentId
     */
    public Long getTaskAttachmentId() {
        return taskAttachmentId;
    }

    /**
     * @param taskAttachmentId the taskAttachmentId to set
     */
    public void setTaskAttachmentId(Long taskAttachmentId) {
        this.taskAttachmentId = taskAttachmentId;
    }

    /**
     * @return the taskId
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * @param taskId the taskId to set
     */
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    /**
     * @return the attachmentId
     */
    public Long getAttachmentId() {
        return attachmentId;
    }

    /**
     * @param attachmentId the attachmentId to set
     */
    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }

    /**
     * @return the attachementName
     */
    public String getAttachementName() {
        return attachementName;
    }

    /**
     * @param attachementName the attachementName to set
     */
    public void setAttachementName(String attachementName) {
        this.attachementName = attachementName;
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
	TaskAttachmentDto other = (TaskAttachmentDto) obj;
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

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "TaskAttachmentDto [taskAttachmentId=" + taskAttachmentId + ", taskId=" + taskId + ", attachmentId="
		+ attachmentId + ", attachementName=" + attachementName + ", isActive=" + isActive + ", createdBy="
		+ createdBy + ", createdOn=" + createdOn + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedOn="
		+ lastUpdatedOn + "]";
    }

}
