/**
 * 
 */
package com.ge.ren.planning.dto;

import java.time.LocalDateTime;

/**
 * @author 502585286
 *
 */
public class CommonCodeDto extends ServiceDto{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5079612283485198403L;

	private Long id;

	private String dropdownType;

	private String dropdownCode;

	private String dropdownValue;

	private String languageCode;

	private Boolean isActive;

	private String createdBy;

	private LocalDateTime createdOn;

	private String lastUpdatedBy;

	private LocalDateTime lastUpdatedOn;


	public CommonCodeDto() {
	}


	/**
	 * @param id
	 * @param dropdownType
	 * @param dropdownCode
	 * @param dropdownValue
	 * @param language
	 * @param isActive
	 * @param createdBy
	 * @param createdOn
	 * @param lastUpdatedBy
	 * @param lastUpdatedOn
	 */
	public CommonCodeDto(Long id, String dropdownType, String dropdownCode, String dropdownValue, String languageCode,
			Boolean isActive, String createdBy, LocalDateTime createdOn, String lastUpdatedBy,
			LocalDateTime lastUpdatedOn) {
		this.id = id;
		this.dropdownType = dropdownType;
		this.dropdownCode = dropdownCode;
		this.dropdownValue = dropdownValue;
		this.languageCode = languageCode;
		this.isActive = isActive;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedOn = lastUpdatedOn;
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the dropdownType
	 */
	public String getdropdownType() {
		return dropdownType;
	}


	/**
	 * @param dropdownType the dropdownType to set
	 */
	public void setdropdownType(String dropdownType) {
		this.dropdownType = dropdownType;
	}


	/**
	 * @return the dropdownCode
	 */
	public String getdropdownCode() {
		return dropdownCode;
	}


	/**
	 * @param dropdownCode the dropdownCode to set
	 */
	public void setdropdownCode(String dropdownCode) {
		this.dropdownCode = dropdownCode;
	}


	/**
	 * @return the dropdownValue
	 */
	public String getdropdownValue() {
		return dropdownValue;
	}


	/**
	 * @param dropdownValue the dropdownValue to set
	 */
	public void setdropdownValue(String dropdownValue) {
		this.dropdownValue = dropdownValue;
	}


	/**
	 * @return the language
	 */
	public String getLanguage() {
		return languageCode;
	}


	/**
	 * @param languageCode the languageCode to set
	 */
	public void setlanguageCode(String languageCode) {
		this.languageCode = languageCode;
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
		result = prime * result + ((dropdownCode == null) ? 0 : dropdownCode.hashCode());
		result = prime * result + ((dropdownType == null) ? 0 : dropdownType.hashCode());
		result = prime * result + ((dropdownValue == null) ? 0 : dropdownValue.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((languageCode == null) ? 0 : languageCode.hashCode());
		result = prime * result + ((lastUpdatedBy == null) ? 0 : lastUpdatedBy.hashCode());
		result = prime * result + ((lastUpdatedOn == null) ? 0 : lastUpdatedOn.hashCode());
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
		CommonCodeDto other = (CommonCodeDto) obj;
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
		if (dropdownCode == null) {
			if (other.dropdownCode != null)
				return false;
		} else if (!dropdownCode.equals(other.dropdownCode))
			return false;
		if (dropdownType == null) {
			if (other.dropdownType != null)
				return false;
		} else if (!dropdownType.equals(other.dropdownType))
			return false;
		if (dropdownValue == null) {
			if (other.dropdownValue != null)
				return false;
		} else if (!dropdownValue.equals(other.dropdownValue))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (languageCode == null) {
			if (other.languageCode != null)
				return false;
		} else if (!languageCode.equals(other.languageCode))
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
		return true;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CommonCode [id=" + id + ", dropdownType=" + dropdownType + ", dropdownCode=" + dropdownCode
				+ ", dropdownValue=" + dropdownValue + ", languageCode=" + languageCode + ", isActive=" + isActive
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", lastUpdatedBy=" + lastUpdatedBy
				+ ", lastUpdatedOn=" + lastUpdatedOn + "]";
	}



}
