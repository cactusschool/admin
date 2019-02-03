package com.ashish.cactus.school.admin.output;

import io.swagger.annotations.ApiModelProperty;

public class ErrorInfo {
	@ApiModelProperty(position=1, value="")
	private String errorInfoCode;
	@ApiModelProperty(position=2, value="")
	private String errorInfoDesc;
	@ApiModelProperty(position=3, value="")
	private String developerMsg;
	public String getErrorInfoCode() {
		return errorInfoCode;
	}
	public void setErrorInfoCode(String errorInfoCode) {
		this.errorInfoCode = errorInfoCode;
	}
	public String getErrorInfoDesc() {
		return errorInfoDesc;
	}
	public void setErrorInfoDesc(String errorInfoDesc) {
		this.errorInfoDesc = errorInfoDesc;
	}
	public String getDeveloperMsg() {
		return developerMsg;
	}
	public void setDeveloperMsg(String developerMsg) {
		this.developerMsg = developerMsg;
	}
	
	
}
