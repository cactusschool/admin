package com.ashish.cactus.school.admin.input;

import io.swagger.annotations.ApiModelProperty;

public class AddressDetails {
	@ApiModelProperty(position=1, value="")
	private int addressId;
	@ApiModelProperty(position=2, value="")
	private String addressLine1;
	@ApiModelProperty(position=3, value="")
	private String addressLine2;
	@ApiModelProperty(position=4, value="")
	private String addressLine3;
	@ApiModelProperty(position=5, value="")
	private String city;
	@ApiModelProperty(position=6, value="")
	private String distCode;
	@ApiModelProperty(position=7, value="")
	private String stateCode;
	@ApiModelProperty(position=8, value="")
	private String countryCode;
	@ApiModelProperty(position=9, value="")
	private DeleteDetails deleteDetails;
	@ApiModelProperty(position=10, value="")
	private AuditDetails auditDetails;
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getAddressLine3() {
		return addressLine3;
	}
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistCode() {
		return distCode;
	}
	public void setDistCode(String distCode) {
		this.distCode = distCode;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public DeleteDetails getDeleteDetails() {
		return deleteDetails;
	}
	public void setDeleteDetails(DeleteDetails deleteDetails) {
		this.deleteDetails = deleteDetails;
	}
	public AuditDetails getAuditDetails() {
		return auditDetails;
	}
	public void setAuditDetails(AuditDetails auditDetails) {
		this.auditDetails = auditDetails;
	}
}
