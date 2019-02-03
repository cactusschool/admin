package com.ashish.cactus.school.admin.test.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ashish.cactus.school.admin.input.AdminInput;
import com.ashish.cactus.school.admin.output.AdminOutput;
import com.ashish.cactus.school.admin.services.SchoolService;

@RestController
@RequestMapping("/")
public class SchoolController {
	
	@Autowired
	private SchoolService schoolService;
	@ApiOperation(value="Create new school",
				notes="Create new school",
				response=AdminOutput.class
			)
	
	@ApiResponses (value = {
							@ApiResponse(code=200, message="Successfully created the school"),
							@ApiResponse(code=400, message="Bad response")
						}
					)
	@RequestMapping(value="/create/school", method=RequestMethod.POST)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN_CREATE','ROLE_ADMIN_READ','ROLE_PARENT_READ')")
	public AdminOutput createSchool(
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
		return schoolService.createSchool(adminInput, transactionId);
	}
}
