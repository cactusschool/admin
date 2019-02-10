package com.ashish.cactus.school.admin.utils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.ashish.cactus.school.admin.input.AdminInput;
import com.ashish.cactus.school.admin.input.UserDetails;
import com.ashish.cactus.school.admin.output.AdminOutput;

@Component
public class AdminUtils {
	public void mapError(AdminOutput output, String errorCode, Exception e) {
		output.setStatusCode(errorCode);
		com.ashish.cactus.school.admin.output.Error error = new com.ashish.cactus.school.admin.output.Error();
		output.setError(error);
		error.setErrorCode(errorCode);
		error.setErrorDesc(e.getMessage());
		error.setDeveloperMsg(ExceptionUtils.getStackTrace(e));
	}
	
	public void mapAuditFieldsAndDeleteDetails (AdminInput adminInput, Object dest) throws IllegalAccessException, InvocationTargetException {
		if(adminInput.getAuditDetails() != null && dest != null) {
			BeanUtils.copyProperties(dest, adminInput.getAuditDetails());
		}
		if(adminInput.getDeleteDetails() != null && dest != null) {
			BeanUtils.copyProperties(dest, adminInput.getDeleteDetails());
		}
	}
	
	public void setUserDetails(AdminInput adminInput, Authentication authentication) {
		if(adminInput == null) {
			adminInput = new AdminInput();
		}
		if(adminInput.getUserDetails() == null) {
			adminInput.setUserDetails(new UserDetails());
		}
		if(authentication != null && authentication.getName() != null) {
			adminInput.getUserDetails().setUserName(authentication.getName());
		}
	}
}
