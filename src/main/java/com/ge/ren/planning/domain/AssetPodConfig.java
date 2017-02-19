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
@Table(name = "asset_pod_config")
public class AssetPodConfig implements Serializable {

    private static final long serialVersionUID = -7110332659209213897L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asset_pod_config_id")
    private Long assetPodConfigId;

    @Column(name = "site_asset_id")
    private Long siteAssetId;
    
    @Column(name = "pod_date")
    private LocalDate podDate;
    
    @Column(name = "asset_pod_priority_order")
    private Long assetPodPriorityOrder;

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

    public AssetPodConfig() {
	// Default Constructor
    }

    public AssetPodConfig(Long assetPodConfigId, Long siteAssetId, LocalDate podDate, Long assetPodPriorityOrder,
	    Boolean isActive, String createdBy, LocalDateTime createdOn, String lastUpdatedBy,
	    LocalDateTime lastUpdatedOn) {
	this.assetPodConfigId = assetPodConfigId;
	this.siteAssetId = siteAssetId;
	this.podDate = podDate;
	this.assetPodPriorityOrder = assetPodPriorityOrder;
	this.isActive = isActive;
	this.createdBy = createdBy;
	this.createdOn = createdOn;
	this.lastUpdatedBy = lastUpdatedBy;
	this.lastUpdatedOn = lastUpdatedOn;
    }

    /**
     * @return the assetPodConfigId
     */
    public Long getAssetPodConfigId() {
        return assetPodConfigId;
    }

    /**
     * @param assetPodConfigId the assetPodConfigId to set
     */
    public void setAssetPodConfigId(Long assetPodConfigId) {
        this.assetPodConfigId = assetPodConfigId;
    }

    /**
     * @return the siteAssetId
     */
    public Long getSiteAssetId() {
        return siteAssetId;
    }

    /**
     * @param siteAssetId the siteAssetId to set
     */
    public void setSiteAssetId(Long siteAssetId) {
        this.siteAssetId = siteAssetId;
    }

    /**
     * @return the podDate
     */
    public LocalDate getPodDate() {
        return podDate;
    }

    /**
     * @param podDate the podDate to set
     */
    public void setPodDate(LocalDate podDate) {
        this.podDate = podDate;
    }

    /**
     * @return the assetPodPriorityOrder
     */
    public Long getAssetPodPriorityOrder() {
        return assetPodPriorityOrder;
    }

    /**
     * @param assetPodPriorityOrder the assetPodPriorityOrder to set
     */
    public void setAssetPodPriorityOrder(Long assetPodPriorityOrder) {
        this.assetPodPriorityOrder = assetPodPriorityOrder;
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
	result = prime * result + ((assetPodConfigId == null) ? 0 : assetPodConfigId.hashCode());
	result = prime * result + ((assetPodPriorityOrder == null) ? 0 : assetPodPriorityOrder.hashCode());
	result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
	result = prime * result + ((createdOn == null) ? 0 : createdOn.hashCode());
	result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
	result = prime * result + ((lastUpdatedBy == null) ? 0 : lastUpdatedBy.hashCode());
	result = prime * result + ((lastUpdatedOn == null) ? 0 : lastUpdatedOn.hashCode());
	result = prime * result + ((podDate == null) ? 0 : podDate.hashCode());
	result = prime * result + ((siteAssetId == null) ? 0 : siteAssetId.hashCode());
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
	AssetPodConfig other = (AssetPodConfig) obj;
	if (assetPodConfigId == null) {
	    if (other.assetPodConfigId != null)
		return false;
	} else if (!assetPodConfigId.equals(other.assetPodConfigId))
	    return false;
	if (assetPodPriorityOrder == null) {
	    if (other.assetPodPriorityOrder != null)
		return false;
	} else if (!assetPodPriorityOrder.equals(other.assetPodPriorityOrder))
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
	if (podDate == null) {
	    if (other.podDate != null)
		return false;
	} else if (!podDate.equals(other.podDate))
	    return false;
	if (siteAssetId == null) {
	    if (other.siteAssetId != null)
		return false;
	} else if (!siteAssetId.equals(other.siteAssetId))
	    return false;
	return true;
    }
  
    
}
