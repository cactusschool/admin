package com.ashish.cactus.school.admin.input;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LicenseDetails {
	@ApiModelProperty(position=1, value="")
	private int licenseId;
	
	@ApiModelProperty(position=2, value="")
	private String paymentNeeded;
	
	@ApiModelProperty(position=3, value="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date startDate;
	
	@ApiModelProperty(position=4, value="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endDate;
	
	@ApiModelProperty(position=5, value="")
	private Double subscriptionFees;

	public int getLicenseId() {
		return licenseId;
	}

	public void setLicenseId(int licenseId) {
		this.licenseId = licenseId;
	}

	public String getPaymentNeeded() {
		return paymentNeeded;
	}

	public void setPaymentNeeded(String paymentNeeded) {
		this.paymentNeeded = paymentNeeded;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getSubscriptionFees() {
		return subscriptionFees;
	}

	public void setSubscriptionFees(Double subscriptionFees) {
		this.subscriptionFees = subscriptionFees;
	}
}
