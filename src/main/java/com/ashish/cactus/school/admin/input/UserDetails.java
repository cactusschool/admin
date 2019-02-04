package com.ashish.cactus.school.admin.input;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class UserDetails {
	@ApiModelProperty(position=1, value="")
	private int userId;
	
	@ApiModelProperty(position=2, value="")
	private int parentId;
	
	@ApiModelProperty(position=3, value="")
	private String userName;
	
	@ApiModelProperty(position=4, value="")
	private String password;
	
	@ApiModelProperty(position=5, value="")
	private String firstName;
	
	@ApiModelProperty(position=6, value="")
	private String middleName;
	
	@ApiModelProperty(position=7, value="")
	private String lastName;
	
	@ApiModelProperty(position=8, value="")
	private String accountLocked;
	
	@ApiModelProperty(position=9, value="")
	private Date endDate;
	
	@ApiModelProperty(position=10, value="")
	private Date lastLoggedIn;
	
	@ApiModelProperty(position=11, value="")
	private List<RoleDetails> roles;
	
	@ApiModelProperty(position=12, value="")
	private List<SchoolDetails> schools;
	
	@ApiModelProperty(position=13, value="")
	private AddressDetails addressDetails;
	
	@ApiModelProperty(position=14, value="")
	private LicenseDetails licenseDetails;
	
	@ApiModelProperty(position=11, value="")
	private List<ModuleDetails> modules;

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAccountLocked() {
		return accountLocked;
	}
	public void setAccountLocked(String accountLocked) {
		this.accountLocked = accountLocked;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getLastLoggedIn() {
		return lastLoggedIn;
	}
	public void setLastLoggedIn(Date lastLoggedIn) {
		this.lastLoggedIn = lastLoggedIn;
	}
	public List<RoleDetails> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleDetails> roles) {
		this.roles = roles;
	}
	public List<SchoolDetails> getSchools() {
		return schools;
	}
	public void setSchools(List<SchoolDetails> schools) {
		this.schools = schools;
	}
	public AddressDetails getAddressDetails() {
		return addressDetails;
	}
	public void setAddressDetails(AddressDetails addressDetails) {
		this.addressDetails = addressDetails;
	}
	public LicenseDetails getLicenseDetails() {
		return licenseDetails;
	}
	
	public List<ModuleDetails> getModules() {
		return modules;
	}
	public void setModules(List<ModuleDetails> modules) {
		this.modules = modules;
	}
	
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", parentId=" + parentId
				+ ", userName=" + userName + ", password=" + password
				+ ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", accountLocked=" + accountLocked
				+ ", endDate=" + endDate + ", lastLoggedIn=" + lastLoggedIn
				+ ", roles=" + roles + ", schools=" + schools
				+ ", addressDetails=" + addressDetails + ", licenseDetails="
				+ licenseDetails + "]";
	}
	public void setLicenseDetails(LicenseDetails licenseDetails) {
		this.licenseDetails = licenseDetails;
	}
}
