package com.ashish.cactus.school.admin.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ashish.cactus.school.admin.output.AdminOutput;
import com.ashish.cactus.school.admin.services.LocationService;

@RestController
@RequestMapping("/")
public class LocationController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LocationService locationService;
	
	@ApiOperation(value="Get list of locations from database. This method provides all district, states, countries",
				notes="Get list of locations from database. This method provides all district, states, countries",
				response=AdminOutput.class
			)
	
	@ApiResponses (value = {
							@ApiResponse(code=200, message="Successfully retrieved the list of available locations"),
							@ApiResponse(code=400, message="Bad response")
						}
					)
	@RequestMapping(value="/locations", method=RequestMethod.GET)
	public AdminOutput getAllLocations(
			@ApiParam(value = "Access token authorization. Example Authorization: Bearer <JWT TOKEN>", required=true)
			@RequestHeader(name="Authorization", required=true) final String authorization,
			
			@ApiParam(value = "Unique transaction id", required=true)
			@RequestHeader(name="TransactionId", required=true) final String transactionId,
			
			@ApiParam(value = "MIME type for the request. Example: applicaion/json", required=true)
			@RequestHeader(name="Content-Type", required=true, defaultValue="applicaion/json") final String contentType,
			
			@ApiParam(value = "MIME type for the request", required=true)
			@RequestHeader(name="Accept", required=true, defaultValue="applicaion/json") final String accept
			
			) {
		AdminOutput adminOutput = new AdminOutput();
		try {
			locationService.getAllLocations(adminOutput);
		} catch (Exception e) {
			logger.error("Operation failed: Error message: ", e);
		}
		return adminOutput;
	}
}
