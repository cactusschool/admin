package com.ashish.cactus.school.admin.input;

import io.swagger.annotations.ApiModelProperty;

public class AdminInput {
	@ApiModelProperty(position=1, value="School details is passed through this object")
	private SchoolDetails schoolDetails;
	@ApiModelProperty(position=2, value="User details is passed through this object")
	private UserDetails userDetails; 

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
}
