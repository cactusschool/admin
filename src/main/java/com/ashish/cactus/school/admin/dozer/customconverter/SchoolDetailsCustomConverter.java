package com.ashish.cactus.school.admin.dozer.customconverter;

import org.dozer.DozerConverter;
import org.springframework.stereotype.Component;

import com.ashish.cactus.school.admin.db.model.SchoolMaster;
import com.ashish.cactus.school.admin.input.SchoolDetails;

@Component("SchoolDetailsCustomConverter")
public class SchoolDetailsCustomConverter extends DozerConverter<SchoolDetails, SchoolMaster>{
	
	public SchoolDetailsCustomConverter() {
		super(SchoolDetails.class, SchoolMaster.class);
	}
	public SchoolDetailsCustomConverter(Class<SchoolDetails> prototypeA,
			Class<SchoolMaster> prototypeB) {
		super(prototypeA, prototypeB);
		// TODO Auto-generated constructor stub
	}

	@Override
	public SchoolDetails convertFrom(SchoolMaster source,
			SchoolDetails destination) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SchoolMaster convertTo(SchoolDetails source, SchoolMaster destination) {
		// TODO Auto-generated method stub
		return null;
	}

}
