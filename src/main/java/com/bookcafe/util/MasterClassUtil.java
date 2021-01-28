package com.bookcafe.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bookcafe.data.MasterClassData;
import com.bookcafe.model.MasterClass;
import com.bookcafe.repository.MasterclassRepository;

@Component
public class MasterClassUtil {
	
	@Autowired
	private MasterClassData data;
	
	@Autowired
	private MasterclassRepository masterclassRepository;
	
	@Value( "${current.env}" )
	private String env;
	
	public int addNewMasterclass(MasterClass masterClass) {
		MasterClass savedMasterclass = masterclassRepository.save(masterClass);
		return savedMasterclass.getClassId();
	}
	
	public void removeMasterclass(MasterClass masterClass) {
		masterclassRepository.delete(masterClass);
	}
	
	public List<MasterClass> retrieveMasterClassDetails() {
		if(env.equalsIgnoreCase("mock")) {
			return data.getData();
		} else {
			return masterclassRepository.findAll();
		}
	}

}
