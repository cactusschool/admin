package com.ashish.cactus.school.admin.input;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AuditDetails {
	@ApiModelProperty(position=1, value="")
	private String createUser;
	
	@ApiModelProperty(position=2, value="")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	
	@ApiModelProperty(position=3, value="")
	private String updateUser;
	
	@ApiModelProperty(position=4, value="")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updateDate;
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
