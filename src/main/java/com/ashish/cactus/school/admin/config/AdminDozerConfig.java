package com.ashish.cactus.school.admin.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ashish.cactus.school.admin.dozer.customconverter.SchoolDetailsCustomConverter;

@Configuration
public class AdminDozerConfig {
	@Bean(name = "org.dozer.Mapper")
	  public DozerBeanMapper dozerBean() {
	    List<String> mappingFiles = Arrays.asList(
	      "dozer/dozer-global-configuration.xml",
	      "dozer/dozer-school-map.xml"
	    );
	
	    Map<String, CustomConverter> customConverters = new HashMap<>();
	    customConverters.put("SchoolDetailsCustomConverter", getSchoolDetailsCustomConverter());
	    
	    DozerBeanMapper dozerBean = new DozerBeanMapper();
	    dozerBean.setMappingFiles(mappingFiles);
	    dozerBean.setCustomConvertersWithId(customConverters);
	    return dozerBean;
	}
	
	@Bean
	public SchoolDetailsCustomConverter getSchoolDetailsCustomConverter() {
		return new SchoolDetailsCustomConverter();
	}
}
