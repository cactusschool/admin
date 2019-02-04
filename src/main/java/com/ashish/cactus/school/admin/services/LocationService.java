package com.ashish.cactus.school.admin.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashish.cactus.school.admin.db.model.LocationMaster;
import com.ashish.cactus.school.admin.db.repositories.LocationMasterRepository;
import com.ashish.cactus.school.admin.output.AdminOutput;
import com.ashish.cactus.school.admin.output.LocationDetails;

@Service
public class LocationService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LocationMasterRepository locationMasterRepository;
	
	public void getAllLocations(AdminOutput adminOutput) throws Exception {
		Iterable<LocationMaster> locations = locationMasterRepository.findAll();
		if(locations != null) {
			List<LocationDetails> locationDetailsBO = new ArrayList<>();
			adminOutput.setLocations(locationDetailsBO);
			for(LocationMaster location: locations) {
				LocationDetails locationDetails = new LocationDetails();
				BeanUtils.copyProperties(locationDetails, location);
				locationDetailsBO.add(locationDetails);
			}
		}
	}
}
