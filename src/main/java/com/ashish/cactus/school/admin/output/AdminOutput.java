package com.ashish.cactus.school.admin.output;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import com.ashish.cactus.school.admin.db.model.ModuleMaster;
import com.ashish.cactus.school.admin.input.ModuleDetails;
import com.ashish.cactus.school.admin.input.SchoolDetails;
import com.ashish.cactus.school.admin.input.UserDetails;

public class AdminOutput {
	@ApiModelProperty(position=1, value="Status of the reponse")
	private String statusCode;
	
	@ApiModelProperty(position=2, value="School details is passed through this object")
	private List<SchoolDetails> schools;
	
	@ApiModelProperty(position=3, value="User details is passed through this object")
	private UserDetails userDetails; 
	
	@ApiModelProperty(position=4, value="List of locations: District, State, Country")
	private List<LocationDetails> locations; 
	
	@ApiModelProperty(position=5, value="List of modules")
	private List<ModuleDetails> modules; 
	
	@ApiModelProperty(position=6, value="The error in the response will be captured")
	private Error error;

	public List<SchoolDetails> getSchools() {
		return schools;
	}

	public void setSchools(List<SchoolDetails> schools) {
		this.schools = schools;
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

	public List<ModuleDetails> getModules() {
		return modules;
	}

	public void setModules(List<ModuleDetails> modules) {
		this.modules = modules;
	}
}
