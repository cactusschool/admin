package com.ashish.cactus.school.admin.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashish.cactus.school.admin.db.model.ModuleMaster;
import com.ashish.cactus.school.admin.db.repositories.ModuleMasterRepository;
import com.ashish.cactus.school.admin.input.ModuleDetails;
import com.ashish.cactus.school.admin.output.AdminOutput;

@Service
public class ModulesService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ModuleMasterRepository moduleMasterRepository;
	
	public void getAllModules(AdminOutput adminOutput) throws Exception {
		Iterable<ModuleMaster> modules = moduleMasterRepository.findAll();
		if(modules != null) {
			List<ModuleDetails> moduleDetailsBO = new ArrayList<>();
			adminOutput.setModules(moduleDetailsBO);
			for(ModuleMaster module: modules) {
				ModuleDetails moduleDetails = new ModuleDetails();
				BeanUtils.copyProperties(moduleDetails, module);
				moduleDetailsBO.add(moduleDetails);
			}
		}
	}
}
