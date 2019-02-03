package com.ashish.cactus.school.admin.utils;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

import com.ashish.cactus.school.admin.output.AdminOutput;

@Component
public class AdminUtils {
	public void mapError(AdminOutput output, String errorCode, Exception e) {
		com.ashish.cactus.school.admin.output.Error error = new com.ashish.cactus.school.admin.output.Error();
		output.setError(error);
		error.setErrorCode(errorCode);
		error.setErrorDesc(e.getMessage());
		error.setDeveloperMsg(ExceptionUtils.getStackTrace(e));
	}
}
