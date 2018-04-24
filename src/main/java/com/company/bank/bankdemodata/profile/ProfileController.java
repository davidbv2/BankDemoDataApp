package com.company.bank.bankdemodata.profile;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//created an another package & also created this Controller in it 
@RestController
public class ProfileController {
	
	//this annotation marks this variable as needing dependency injection 
	@Autowired
	private ProfileService profileService;
	
	@RequestMapping("/profiles")
	public List<Profile> getAllProfiles (){
		return profileService.getAllProfiles();
	}
	
	/* We use the @PathVariable annotation on the id arg. in our URL Java method 
	 * That allows the {id} variable to be passed as arg. thru the URL Java method &
	 * then passed thru our profileService method call
	 */
	@RequestMapping("/profiles/{id}")
	public Optional<Profile> getProfile (@PathVariable String id){
		return profileService.getProfile(id);
	}
	
	/*	What @RequestBody annotation does is tell Spring MVC that 
	 * your request body will contain a JSON representation 
	 * of this Profile instance & then to take the request body & convert it 
	 * to Profile instance to pass through 
	 * our ‘addProfile’ Java method 
	 */
	@RequestMapping(method=RequestMethod.POST,value="/profiles")
	public void addProfile (@RequestBody Profile profile){
		profileService.addProfile(profile);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/profiles/{id}")
	public void updateProfile (@RequestBody Profile profile, @PathVariable String id){
		profileService.updateProfile(id, profile);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/profiles/{id}")
	public void deleteProfile (@PathVariable String id){
		profileService.deleteProfile(id);
	}
	
	
	

}
 

