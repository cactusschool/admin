package com.ashish.cactus.school.admin.output;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import com.ashish.cactus.school.admin.input.SchoolDetails;
import com.ashish.cactus.school.admin.input.UserDetails;

public class AdminOutput {
	@ApiModelProperty(position=1, value="Status of the reponse")
	private String statusCode;
	
	@ApiModelProperty(position=2, value="School details is passed through this object")
	private SchoolDetails schoolDetails;
	
	@ApiModelProperty(position=3, value="User details is passed through this object")
	private UserDetails userDetails; 
	
	@ApiModelProperty(position=4, value="List of locations: District, State, Country")
	private List<LocationDetails> locations; 
	
	@ApiModelProperty(position=5, value="The error in the response will be captured")
	private Error error;

	public SchoolDetails getSchoolDetails() {
		return schoolDetails;
	}

	public void setSchoolDetails(SchoolDetails schoolDetails) {
		this.schoolDetails = schoolDetails;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public List<LocationDetails> getLocations() {
		return locations;
	}

	public void setLocations(List<LocationDetails> locations) {
		this.locations = locations;
	}
}
