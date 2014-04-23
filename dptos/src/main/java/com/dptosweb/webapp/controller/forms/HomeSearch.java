package com.dptosweb.webapp.controller.forms;

public class HomeSearch {

	private String locationToSearch;
	private String roomCount;
	private String operationType;
	private String propertyType;
	
	
	
	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getRoomCount() {
		return roomCount;
	}

	public void setRoomCount(String roomCount) {
		this.roomCount = roomCount;
	}

	public String getLocationToSearch() {
		return locationToSearch;
	}

	public void setLocationToSearch(String locationToSearch) {
		this.locationToSearch = locationToSearch;
	}
	
	
}
