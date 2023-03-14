package com.bookcafe.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bookcafe.data.CookingClassData;
import com.bookcafe.model.CookingClass;
import com.bookcafe.repository.CookingClassRepository;

@Component
public class CookingClassUtil {
	
	@Autowired
	private CookingClassData data;
	
	@Autowired
	private CookingClassRepository masterclassRepository;
	
	@Value( "${current.env}" )
	private String env;
	
	public int addNewMasterclass(CookingClass masterClass) {
		CookingClass savedMasterclass = masterclassRepository.save(masterClass);
		return savedMasterclass.getClassId();
	}
	
	public void removeMasterclass(CookingClass masterClass) {
		masterclassRepository.delete(masterClass);
	}
	
	public List<CookingClass> retrieveMasterClassDetails() {
		if(env.equalsIgnoreCase("mock")) {
			return data.getData();
		} else {
			return masterclassRepository.findAll();
		}
	}

}
