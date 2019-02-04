package com.ashish.cactus.school.admin.input;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class SchoolDetails {
	@ApiModelProperty(position=1, value="")
	private int schoolId;
	
	@ApiModelProperty(position=2, value="")
	private int schoolParentId;
	
	@ApiModelProperty(position=3, value="")
	private String schoolName;
	
	@ApiModelProperty(position=4, value="")
	private String schoolGroupName;
	
	@ApiModelProperty(position=5, value="")
	private String dbName;
	
	@ApiModelProperty(position=6, value="")
	private String contextRoot;
	
	@ApiModelProperty(position=7, value="")
	private String schoolCode;
	
	@ApiModelProperty(position=8, value="")
	private String smsSenderId;
	
	@ApiModelProperty(position=9, value="")
	private AddressDetails addressDetails;
	
	@ApiModelProperty(position=10, value="")
	private List<UserDetails> users;
	
	@ApiModelProperty(position=11, value="")
	private List<ModuleDetails> modules;
	
	@ApiModelProperty(position=12, value="")
	private LicenseDetails licenseDetails;
	
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSchoolGroupName() {
		return schoolGroupName;
	}
	public void setSchoolGroupName(String schoolGroupName) {
		this.schoolGroupName = schoolGroupName;
	}
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public int getSchoolParentId() {
		return schoolParentId;
	}
	public void setSchoolParentId(int schoolParentId) {
		this.schoolParentId = schoolParentId;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getContextRoot() {
		return contextRoot;
	}
	public void setContextRoot(String contextRoot) {
		this.contextRoot = contextRoot;
	}
	public String getSchoolCode() {
		return schoolCode;
	}
	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}
	public String getSmsSenderId() {
		return smsSenderId;
	}
	public void setSmsSenderId(String smsSenderId) {
		this.smsSenderId = smsSenderId;
	}
	public AddressDetails getAddressDetails() {
		return addressDetails;
	}
	public void setAddressDetails(AddressDetails addressDetails) {
		this.addressDetails = addressDetails;
	}
	public List<UserDetails> getUsers() {
		return users;
	}
	public void setUsers(List<UserDetails> users) {
		this.users = users;
	}
	public List<ModuleDetails> getModules() {
		return modules;
	}
	public void setModules(List<ModuleDetails> modules) {
		this.modules = modules;
	}
	public LicenseDetails getLicenseDetails() {
		return licenseDetails;
	}
	public void setLicenseDetails(LicenseDetails licenseDetails) {
		this.licenseDetails = licenseDetails;
	}
	@Override
	public String toString() {
		return "SchoolDetails [schoolId=" + schoolId + ", schoolParentId="
				+ schoolParentId + ", schoolName=" + schoolName
				+ ", schoolGroupName=" + schoolGroupName + ", dbName=" + dbName
				+ ", contextRoot=" + contextRoot + ", schoolCode=" + schoolCode
				+ ", smsSenderId=" + smsSenderId + ", addressDetails="
				+ addressDetails + ", users=" + users + ", modules=" + modules
				+ ", licenseDetails=" + licenseDetails + "]";
	}
}
