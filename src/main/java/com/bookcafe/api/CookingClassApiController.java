package com.bookcafe.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookcafe.model.CookingClass;
import com.bookcafe.util.CookingClassUtil;

@CrossOrigin("*")
@RestController
public class CookingClassApiController {
	
	@Autowired
	private CookingClassUtil masterClassUtil;
	
	@GetMapping("/getMasterClasses")
	public List<CookingClass> findAllMasterClasses(){
		return masterClassUtil.retrieveMasterClassDetails();
	}
	
	@PostMapping("/addMasterClass")
	public String addMasterClass(@RequestBody CookingClass classes) {
		return "New Master Class added with ID : "+masterClassUtil.addNewMasterclass(classes);
	}
	
	@PostMapping("/removeMasterClass")
	public String removeMasterClass(@RequestBody CookingClass classes) {
		masterClassUtil.removeMasterclass(classes);
		return "Master Class with ID : "+classes.getClassId()+" deleted successfully";
	}
	
}
