package com.ashish.cactus.school.admin.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ashish.cactus.school.admin.input.AdminInput;
import com.ashish.cactus.school.admin.output.AdminOutput;
import com.ashish.cactus.school.admin.services.UserService;
import com.ashish.cactus.school.admin.utils.AdminUtils;

@RestController
@RequestMapping("/")
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AdminUtils adminUtil;
	
	@ApiOperation(value="Create new user",
				notes="Create new user",
				response=AdminOutput.class
			)
	
	@ApiResponses (value = {
							@ApiResponse(code=200, message="Successfully created the user"),
							@ApiResponse(code=400, message="Bad response")
						}
					)
	@RequestMapping(value="/create/staff", method=RequestMethod.POST)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN_CREATE','ROLE_ADMIN_UPDATE','ROLE_PRINCIPAL_CREATE')")
	public AdminOutput createStaff(
			@ApiParam(value = "Access token authorization. Example Authorization: Bearer <JWT TOKEN>", required=true)
			@RequestHeader(name="Authorization", required=true) final String authorization,
			
			@ApiParam(value = "Unique transaction id", required=true)
			@RequestHeader(name="TransactionId", required=true) final String transactionId,
			
			@ApiParam(value = "MIME type for the request. Example: applicaion/json", required=true)
			@RequestHeader(name="Content-Type", required=true, defaultValue="applicaion/json") final String contentType,
			
			@ApiParam(value = "MIME type for the request", required=true)
			@RequestHeader(name="Accept", required=true, defaultValue="applicaion/json") final String accept,
			
			@ApiParam(value = "Payload to create school", required=true)
			@RequestBody AdminInput adminInput
			
			) {
		AdminOutput response = new AdminOutput();
		try {
			response = userService.createStaff(adminInput, response, transactionId);
		} catch (Exception e) {
			logger.error("Operation failed while creating school details: Error message: ", e);
		}
		return response;
	}
	
	
	
	
	@ApiOperation(value="Get staff details",
			notes="Get staff details",
			response=AdminOutput.class
		)

@ApiResponses (value = {
						@ApiResponse(code=200, message="Successfully retrieved the staff details"),
						@ApiResponse(code=400, message="Bad response")
					}
				)
@RequestMapping(value="/get/staff", method=RequestMethod.POST)
@PreAuthorize("hasAnyRole('ROLE_ADMIN_READ','ROLE_PRINCIPAL_READ','ROLE_TEACHER_READ')")
public AdminOutput getUser(
		@ApiParam(value = "Access token authorization. Example Authorization: Bearer <JWT TOKEN>", required=true)
		@RequestHeader(name="Authorization", required=true) final String authorization,
		
		@ApiParam(value = "Unique transaction id", required=true)
		@RequestHeader(name="TransactionId", required=true) final String transactionId,
		
		@ApiParam(value = "MIME type for the request. Example: applicaion/json", required=true)
		@RequestHeader(name="Content-Type", required=true, defaultValue="applicaion/json") final String contentType,
		
		@ApiParam(value = "MIME type for the request", required=true)
		@RequestHeader(name="Accept", required=true, defaultValue="applicaion/json") final String accept,
		
		@ApiParam(value = "Payload to get staff", required=true)
		@RequestBody AdminInput adminInput,
		
		Authentication authentication
		
		) {
	AdminOutput response = new AdminOutput();
	try {
		// Set user name
		adminUtil.setUserDetails(adminInput, authentication);
		response = userService.getStaff(adminInput, response, transactionId);
		response.setStatusCode("200");
	} catch (Exception e) {
		response.setStatusCode("500");
		adminUtil.mapError(response, "500", e);
		logger.error("Operation failed while retrieving school details: Error message: ", e);
	}
	return response;
}
}
