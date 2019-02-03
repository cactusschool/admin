package com.ashish.cactus.school.admin.output;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class Error {
	@ApiModelProperty(position=1, value="")
	private String errorCode;
	@ApiModelProperty(position=2, value="")
	private String errorDesc;
	@ApiModelProperty(position=3, value="")
	private String developerMsg;
	@ApiModelProperty(position=4, value="")
	private List<ErrorInfo> errorInfoList;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	public List<ErrorInfo> getErrorInfoList() {
		return errorInfoList;
	}
	public void setErrorInfoList(List<ErrorInfo> errorInfoList) {
		this.errorInfoList = errorInfoList;
	}
	public String getDeveloperMsg() {
		return developerMsg;
	}
	public void setDeveloperMsg(String developerMsg) {
		this.developerMsg = developerMsg;
	}
}
