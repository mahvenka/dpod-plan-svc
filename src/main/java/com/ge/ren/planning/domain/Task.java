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
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;

/**
 * @author Yessesvy
 *
 */
@Entity
@Table(name = "task")
public class Task implements Serializable {

    private static final long serialVersionUID = -7110332659209213897L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;

    @Column(name = "asset_id")
    private Long assetId;

    @Column(name = "task_current_status_id")
    private Long taskCurrentStatusId;

    /*@OneToOne(mappedBy = "task_id", fetch = FetchType.EAGER)
    private TaskRecurrenceDetails taskRecurrenceDetails;*/
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "asset_pod_config_id")
    private AssetPodConfig assetPodConfig;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "task_type_id")
    private TaskType taskType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "task_status_id")
    private TaskStatus taskStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "task_priority_id")
    private TaskPriority taskPriority;

    @Column(name = "task_estimated_duration_hrs")
    private Long taskEstimatedDurationHrs;
    
    @Column(name = "task_estimated_duration_mins")
    private Long taskEstimatedDurationMins;

    @Column(name = "task_actual_duration_hrs")
    private Long taskActualDurationHrs;

    @Column(name = "task_actual_duration_mins")
    private Long taskActualDurationMins; 

    @Column(name = "task_description")
    private String taskDescription;

    @Column(name = "part_details")
    private String partDetails;

    @Column(name = "task_internal_notes")
    private String taskInternalNotes;

    @Column(name = "task_external_notes")
    private String taskExternalNotes;

    @Column(name = "task_resolution_notes")
    private String taskResolutionNotes;

    @Column(name = "is_pod_task")
    private Boolean isPodTask;

    @Column(name = "task_parent_id")
    private Long taskParentId;

    @Column(name = "number_of_tech_required")
    private Integer numberOfTechRequired;

    @Column(name = "task_location_at_asset")
    private Integer taskLocationAtAsset;

    @Column(name = "task_section_at_location")
    private Long taskSectionAtLocation;

    @Column(name = "task_component_at_section")
    private Long taskComponentAtSection;

    @Column(name = "task_added_on")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime taskAddedOn;

    @Column(name = "task_due_on")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime taskDueOn;

    @Column(name = "task_completed_on")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime taskCompletedOn;
	
    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime createdOn;

    @Column(name = "last_updated_by")
    private String lastUpdatedBy;

    @Column(name = "last_updated_on")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime lastUpdatedOn;
    
    @Column(name = "task_category")
    private String taskCategory;
    
    @Transient
    private Boolean taskCompleted; 

    public Task() {
	// Default Constructor
    }

    public Task(Long taskId, Long assetId, Long taskCurrentStatusId, AssetPodConfig assetPodConfig, TaskType taskType,
	    TaskStatus taskStatus, TaskPriority taskPriority, Long taskEstimatedDurationHrs,
	    Long taskEstimatedDurationMins, Long taskActualDurationHrs, Long taskActualDurationMins, String taskDescription, 
	    String taskInternalNotes, String taskExternalNotes, String taskResolutionNotes, Boolean isPodTask, 
	    Long taskParentId, Integer numberOfTechRequired, Integer taskLocationAtAsset, Long taskSectionAtLocation,
	    Long taskComponentAtSection, LocalDateTime taskAddedOn, LocalDateTime taskDueOn,
	    LocalDateTime taskCompletedOn, Boolean isActive, String createdBy, LocalDateTime createdOn,
	    String lastUpdatedBy, LocalDateTime lastUpdatedOn, String partDetails, String taskCategory) {
	this.taskId = taskId;
	this.assetId = assetId;
	this.taskCurrentStatusId = taskCurrentStatusId;
	this.assetPodConfig = assetPodConfig;
	this.taskType = taskType;
	this.taskStatus = taskStatus;
	this.taskPriority = taskPriority;
	this.taskEstimatedDurationHrs = taskEstimatedDurationHrs;
	this.taskActualDurationHrs = taskActualDurationHrs;
	this.taskEstimatedDurationMins = taskEstimatedDurationMins;
	this.taskActualDurationMins = taskActualDurationMins;
	this.taskDescription = taskDescription;
	this.taskInternalNotes = taskInternalNotes;
	this.taskExternalNotes = taskExternalNotes;
	this.taskResolutionNotes = taskResolutionNotes;
	this.isPodTask = isPodTask;
	this.taskParentId = taskParentId;
	this.numberOfTechRequired = numberOfTechRequired;
	this.taskLocationAtAsset = taskLocationAtAsset;
	this.taskSectionAtLocation = taskSectionAtLocation;
	this.taskComponentAtSection = taskComponentAtSection;
	this.taskAddedOn = taskAddedOn;
	this.taskDueOn = taskDueOn;
	this.taskCompletedOn = taskCompletedOn;
	this.isActive = isActive;
	this.createdBy = createdBy;
	this.createdOn = createdOn;
	this.lastUpdatedBy = lastUpdatedBy;
	this.lastUpdatedOn = lastUpdatedOn;
	this.partDetails = partDetails;
	this.taskCategory = taskCategory;
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
     * @return the assetId
     */
    public Long getAssetId() {
        return assetId;
    }

    /**
     * @param assetId the assetId to set
     */
    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    /**
     * @return the taskCurrentStatusId
     */
    public Long getTaskCurrentStatusId() {
        return taskCurrentStatusId;
    }

    /**
     * @param taskCurrentStatusId the taskCurrentStatusId to set
     */
    public void setTaskCurrentStatusId(Long taskCurrentStatusId) {
        this.taskCurrentStatusId = taskCurrentStatusId;
    }

    /**
     * @return the assetPodConfig
     */
    public AssetPodConfig getAssetPodConfig() {
        return assetPodConfig;
    }

    /**
     * @param assetPodConfig the assetPodConfig to set
     */
    public void setAssetPodConfig(AssetPodConfig assetPodConfig) {
        this.assetPodConfig = assetPodConfig;
    }

    /**
     * @return the taskType
     */
    public TaskType getTaskType() {
        return taskType;
    }

    /**
     * @param taskType the taskType to set
     */
    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    /**
     * @return the taskStatus
     */
    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    /**
     * @param taskStatus the taskStatus to set
     */
    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    /**
     * @return the taskPriority
     */
    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    /**
     * @param taskPriority the taskPriority to set
     */
    public void setTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    /**
     * @return the taskEstimatedDurationHrs
     */
    public Long getTaskEstimatedDurationHrs() {
        return taskEstimatedDurationHrs;
    }

    /**
     * @param taskEstimatedDurationHrs the taskEstimatedDurationHrs to set
     */
    public void setTaskEstimatedDurationHrs(Long taskEstimatedDurationHrs) {
        this.taskEstimatedDurationHrs = taskEstimatedDurationHrs;
    }

    /**
     * @return the taskEstimatedDurationMins
     */
    public Long getTaskEstimatedDurationMins() {
        return taskEstimatedDurationMins;
    }

    /**
     * @param taskEstimatedDurationMins the taskEstimatedDurationMins to set
     */
    public void setTaskEstimatedDurationMins(Long taskEstimatedDurationMins) {
        this.taskEstimatedDurationMins = taskEstimatedDurationMins;
    }

    /**
     * @return the taskActualDurationHrs
     */
    public Long getTaskActualDurationHrs() {
        return taskActualDurationHrs;
    }

    /**
     * @param taskActualDurationHrs the taskActualDurationHrs to set
     */
    public void setTaskActualDurationHrs(Long taskActualDurationHrs) {
        this.taskActualDurationHrs = taskActualDurationHrs;
    }

    /**
     * @return the taskActualDurationMins
     */
    public Long getTaskActualDurationMins() {
        return taskActualDurationMins;
    }

    /**
     * @param taskActualDurationMins the taskActualDurationMins to set
     */
    public void setTaskActualDurationMins(Long taskActualDurationMins) {
        this.taskActualDurationMins = taskActualDurationMins;
    }

    /**
     * @return the taskDescription
     */
    public String getTaskDescription() {
        return taskDescription;
    }

    /**
     * @param taskDescription the taskDescription to set
     */
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    /**
     * @return the taskInternalNotes
     */
    public String getTaskInternalNotes() {
        return taskInternalNotes;
    }

    /**
     * @param taskInternalNotes the taskInternalNotes to set
     */
    public void setTaskInternalNotes(String taskInternalNotes) {
        this.taskInternalNotes = taskInternalNotes;
    }

    /**
     * @return the taskExternalNotes
     */
    public String getTaskExternalNotes() {
        return taskExternalNotes;
    }

    /**
     * @param taskExternalNotes the taskExternalNotes to set
     */
    public void setTaskExternalNotes(String taskExternalNotes) {
        this.taskExternalNotes = taskExternalNotes;
    }

    /**
     * @return the taskResolutionNotes
     */
    public String getTaskResolutionNotes() {
        return taskResolutionNotes;
    }

    /**
     * @param taskResolutionNotes the taskResolutionNotes to set
     */
    public void setTaskResolutionNotes(String taskResolutionNotes) {
        this.taskResolutionNotes = taskResolutionNotes;
    }

    /**
     * @return the isPodTask
     */
    public Boolean getIsPodTask() {
        return isPodTask;
    }

    /**
     * @param isPodTask the isPodTask to set
     */
    public void setIsPodTask(Boolean isPodTask) {
        this.isPodTask = isPodTask;
    }

    /**
     * @return the taskParentId
     */
    public Long getTaskParentId() {
        return taskParentId;
    }

    /**
     * @param taskParentId the taskParentId to set
     */
    public void setTaskParentId(Long taskParentId) {
        this.taskParentId = taskParentId;
    }

    /**
     * @return the numberOfTechRequired
     */
    public Integer getNumberOfTechRequired() {
        return numberOfTechRequired;
    }

    /**
     * @param numberOfTechRequired the numberOfTechRequired to set
     */
    public void setNumberOfTechRequired(Integer numberOfTechRequired) {
        this.numberOfTechRequired = numberOfTechRequired;
    }

    /**
     * @return the taskLocationAtAsset
     */
    public Integer getTaskLocationAtAsset() {
        return taskLocationAtAsset;
    }

    /**
     * @param taskLocationAtAsset the taskLocationAtAsset to set
     */
    public void setTaskLocationAtAsset(Integer taskLocationAtAsset) {
        this.taskLocationAtAsset = taskLocationAtAsset;
    }

    /**
     * @return the taskSectionAtLocation
     */
    public Long getTaskSectionAtLocation() {
        return taskSectionAtLocation;
    }

    /**
     * @param taskSectionAtLocation the taskSectionAtLocation to set
     */
    public void setTaskSectionAtLocation(Long taskSectionAtLocation) {
        this.taskSectionAtLocation = taskSectionAtLocation;
    }

    /**
     * @return the taskComponentAtSection
     */
    public Long getTaskComponentAtSection() {
        return taskComponentAtSection;
    }

    /**
     * @param taskComponentAtSection the taskComponentAtSection to set
     */
    public void setTaskComponentAtSection(Long taskComponentAtSection) {
        this.taskComponentAtSection = taskComponentAtSection;
    }

    /**
     * @return the taskAddedOn
     */
    public LocalDateTime getTaskAddedOn() {
        return taskAddedOn;
    }

    /**
     * @param taskAddedOn the taskAddedOn to set
     */
    public void setTaskAddedOn(LocalDateTime taskAddedOn) {
        this.taskAddedOn = taskAddedOn;
    }

    /**
     * @return the taskDueOn
     */
    public LocalDateTime getTaskDueOn() {
        return taskDueOn;
    }

    /**
     * @param taskDueOn the taskDueOn to set
     */
    public void setTaskDueOn(LocalDateTime taskDueOn) {
        this.taskDueOn = taskDueOn;
    }

    /**
     * @return the taskCompletedOn
     */
    public LocalDateTime getTaskCompletedOn() {
        return taskCompletedOn;
    }

    /**
     * @param taskCompletedOn the taskCompletedOn to set
     */
    public void setTaskCompletedOn(LocalDateTime taskCompletedOn) {
        this.taskCompletedOn = taskCompletedOn;
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

    /**
     * @return the partDetails
     */
    public String getPartDetails() {
        return partDetails;
    }

    /**
     * @param partDetails the partDetails to set
     */
    public void setPartDetails(String partDetails) {
        this.partDetails = partDetails;
    }
    
    
    /**
	 * @return the taskCompleted
	 */
	public Boolean getTaskCompleted() {
		return taskCompleted;
	}

	/**
	 * @param taskCompleted the taskCompleted to set
	 */
	public void setTaskCompleted(Boolean taskCompleted) {
		this.taskCompleted = taskCompleted;
	}

    /**
	 * @return the taskCategory
	 */
	public String getTaskCategory() {
		return taskCategory;
	}

	/**
	 * @param taskCategory the taskCategory to set
	 */
	public void setTaskCategory(String taskCategory) {
		this.taskCategory = taskCategory;
	}

	/* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((assetId == null) ? 0 : assetId.hashCode());
	result = prime * result + ((assetPodConfig == null) ? 0 : assetPodConfig.hashCode());
	result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
	result = prime * result + ((createdOn == null) ? 0 : createdOn.hashCode());
	result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
	result = prime * result + ((isPodTask == null) ? 0 : isPodTask.hashCode());
	result = prime * result + ((lastUpdatedBy == null) ? 0 : lastUpdatedBy.hashCode());
	result = prime * result + ((lastUpdatedOn == null) ? 0 : lastUpdatedOn.hashCode());
	result = prime * result + ((numberOfTechRequired == null) ? 0 : numberOfTechRequired.hashCode());
	result = prime * result + ((partDetails == null) ? 0 : partDetails.hashCode());
	result = prime * result + ((taskActualDurationHrs == null) ? 0 : taskActualDurationHrs.hashCode());
	result = prime * result + ((taskActualDurationMins == null) ? 0 : taskActualDurationMins.hashCode());
	result = prime * result + ((taskAddedOn == null) ? 0 : taskAddedOn.hashCode());
	result = prime * result + ((taskCompletedOn == null) ? 0 : taskCompletedOn.hashCode());
	result = prime * result + ((taskComponentAtSection == null) ? 0 : taskComponentAtSection.hashCode());
	result = prime * result + ((taskCurrentStatusId == null) ? 0 : taskCurrentStatusId.hashCode());
	result = prime * result + ((taskDescription == null) ? 0 : taskDescription.hashCode());
	result = prime * result + ((taskDueOn == null) ? 0 : taskDueOn.hashCode());
	result = prime * result + ((taskEstimatedDurationHrs == null) ? 0 : taskEstimatedDurationHrs.hashCode());
	result = prime * result + ((taskEstimatedDurationMins == null) ? 0 : taskEstimatedDurationMins.hashCode());
	result = prime * result + ((taskExternalNotes == null) ? 0 : taskExternalNotes.hashCode());
	result = prime * result + ((taskId == null) ? 0 : taskId.hashCode());
	result = prime * result + ((taskInternalNotes == null) ? 0 : taskInternalNotes.hashCode());
	result = prime * result + ((taskLocationAtAsset == null) ? 0 : taskLocationAtAsset.hashCode());
	result = prime * result + ((taskParentId == null) ? 0 : taskParentId.hashCode());
	result = prime * result + ((taskPriority == null) ? 0 : taskPriority.hashCode());
	result = prime * result + ((taskResolutionNotes == null) ? 0 : taskResolutionNotes.hashCode());
	result = prime * result + ((taskSectionAtLocation == null) ? 0 : taskSectionAtLocation.hashCode());
	result = prime * result + ((taskStatus == null) ? 0 : taskStatus.hashCode());
	result = prime * result + ((taskType == null) ? 0 : taskType.hashCode());
	result = prime * result + ((taskCategory == null) ? 0 : taskCategory.hashCode());
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
	Task other = (Task) obj;
	if (assetId == null) {
	    if (other.assetId != null)
		return false;
	} else if (!assetId.equals(other.assetId))
	    return false;
	if (assetPodConfig == null) {
	    if (other.assetPodConfig != null)
		return false;
	} else if (!assetPodConfig.equals(other.assetPodConfig))
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
	if (isPodTask == null) {
	    if (other.isPodTask != null)
		return false;
	} else if (!isPodTask.equals(other.isPodTask))
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
	if (numberOfTechRequired == null) {
	    if (other.numberOfTechRequired != null)
		return false;
	} else if (!numberOfTechRequired.equals(other.numberOfTechRequired))
	    return false;
	if (partDetails == null) {
	    if (other.partDetails != null)
		return false;
	} else if (!partDetails.equals(other.partDetails))
	    return false;
	if (taskActualDurationHrs == null) {
	    if (other.taskActualDurationHrs != null)
		return false;
	} else if (!taskActualDurationHrs.equals(other.taskActualDurationHrs))
	    return false;
	if (taskActualDurationMins == null) {
	    if (other.taskActualDurationMins != null)
		return false;
	} else if (!taskActualDurationMins.equals(other.taskActualDurationMins))
	    return false;
	if (taskAddedOn == null) {
	    if (other.taskAddedOn != null)
		return false;
	} else if (!taskAddedOn.equals(other.taskAddedOn))
	    return false;
	if (taskCompletedOn == null) {
	    if (other.taskCompletedOn != null)
		return false;
	} else if (!taskCompletedOn.equals(other.taskCompletedOn))
	    return false;
	if (taskComponentAtSection == null) {
	    if (other.taskComponentAtSection != null)
		return false;
	} else if (!taskComponentAtSection.equals(other.taskComponentAtSection))
	    return false;
	if (taskCurrentStatusId == null) {
	    if (other.taskCurrentStatusId != null)
		return false;
	} else if (!taskCurrentStatusId.equals(other.taskCurrentStatusId))
	    return false;
	if (taskDescription == null) {
	    if (other.taskDescription != null)
		return false;
	} else if (!taskDescription.equals(other.taskDescription))
	    return false;
	if (taskDueOn == null) {
	    if (other.taskDueOn != null)
		return false;
	} else if (!taskDueOn.equals(other.taskDueOn))
	    return false;
	if (taskEstimatedDurationHrs == null) {
	    if (other.taskEstimatedDurationHrs != null)
		return false;
	} else if (!taskEstimatedDurationHrs.equals(other.taskEstimatedDurationHrs))
	    return false;
	if (taskEstimatedDurationMins == null) {
	    if (other.taskEstimatedDurationMins != null)
		return false;
	} else if (!taskEstimatedDurationMins.equals(other.taskEstimatedDurationMins))
	    return false;
	if (taskExternalNotes == null) {
	    if (other.taskExternalNotes != null)
		return false;
	} else if (!taskExternalNotes.equals(other.taskExternalNotes))
	    return false;
	if (taskId == null) {
	    if (other.taskId != null)
		return false;
	} else if (!taskId.equals(other.taskId))
	    return false;
	if (taskInternalNotes == null) {
	    if (other.taskInternalNotes != null)
		return false;
	} else if (!taskInternalNotes.equals(other.taskInternalNotes))
	    return false;
	if (taskLocationAtAsset == null) {
	    if (other.taskLocationAtAsset != null)
		return false;
	} else if (!taskLocationAtAsset.equals(other.taskLocationAtAsset))
	    return false;
	if (taskParentId == null) {
	    if (other.taskParentId != null)
		return false;
	} else if (!taskParentId.equals(other.taskParentId))
	    return false;
	if (taskPriority == null) {
	    if (other.taskPriority != null)
		return false;
	} else if (!taskPriority.equals(other.taskPriority))
	    return false;
	if (taskResolutionNotes == null) {
	    if (other.taskResolutionNotes != null)
		return false;
	} else if (!taskResolutionNotes.equals(other.taskResolutionNotes))
	    return false;
	if (taskSectionAtLocation == null) {
	    if (other.taskSectionAtLocation != null)
		return false;
	} else if (!taskSectionAtLocation.equals(other.taskSectionAtLocation))
	    return false;
	if (taskStatus == null) {
	    if (other.taskStatus != null)
		return false;
	} else if (!taskStatus.equals(other.taskStatus))
	    return false;
	if (taskType == null) {
	    if (other.taskType != null)
		return false;
	} else if (!taskType.equals(other.taskType))
	    return false;
	if (taskCategory == null) {
	    if (other.taskCategory != null)
		return false;
	} else if (!taskCategory.equals(other.taskCategory))
	    return false;
	return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Task [taskId=" + taskId + ", assetId=" + assetId + ", taskCurrentStatusId=" + taskCurrentStatusId
		+ ", assetPodConfig=" + assetPodConfig + ", taskType=" + taskType + ", taskStatus=" + taskStatus
		+ ", taskPriority=" + taskPriority + ", taskEstimatedDuration=" + taskEstimatedDurationHrs
		+ ", taskActualDuration=" + taskActualDurationHrs + ", taskDescription=" + taskDescription
		+ ", taskInternalNotes=" + taskInternalNotes + ", taskExternalNotes=" + taskExternalNotes
		+ ", taskResolutionNotes=" + taskResolutionNotes + ", isPodTask=" + isPodTask + ", taskParentId="
		+ taskParentId + ", numberOfTechRequired=" + numberOfTechRequired + ", taskLocationAtAsset="
		+ taskLocationAtAsset + ", taskSectionAtLocation=" + taskSectionAtLocation + ", taskComponentAtSection="
		+ taskComponentAtSection + ", taskAddedOn=" + taskAddedOn + ", taskDueOn=" + taskDueOn
		+ ", taskCompletedOn=" + taskCompletedOn + ", isActive=" + isActive + ", createdBy=" + createdBy
		+ ", createdOn=" + createdOn + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedOn=" + lastUpdatedOn
		+ ", taskCategory=" + taskCategory+ "]";
    }

}