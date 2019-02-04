package com.ashish.cactus.school.admin.input;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class LicenseDetails {
	@ApiModelProperty(position=1, value="")
	private int linceseId;
	
	@ApiModelProperty(position=2, value="")
	private int schoolId;
	
	@ApiModelProperty(position=3, value="")
	private int userId;
	
	@ApiModelProperty(position=4, value="")
	private String paymentNeeded;
	
	@ApiModelProperty(position=5, value="")
	private Date startDate;
	
	@ApiModelProperty(position=6, value="")
	private Date endDate;
	
	@ApiModelProperty(position=7, value="")
	private Double subscrptionFees;

	public int getLinceseId() {
		return linceseId;
	}

	public void setLinceseId(int linceseId) {
		this.linceseId = linceseId;
	}

	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public Double getSubscrptionFees() {
		return subscrptionFees;
	}

	public void setSubscrptionFees(Double subscrptionFees) {
		this.subscrptionFees = subscrptionFees;
	}
}
