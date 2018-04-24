package com.company.bank.bankdemodata.profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
	
	@Autowired
	private ProfileRepository profileRepository;
	List<Profile> profiles = new ArrayList<>(); 
	
	public List<Profile> getAllProfiles (){
		profileRepository.findAll()
		.forEach(profiles::add);
		return profiles;
	}
	
	public Optional<Profile> getProfile (String id){
		return profileRepository.findById(id);
	}
	
	public void addProfile(Profile profile){
		profileRepository.save(profile);
	}

	public void updateProfile(String id, Profile profile) {
		profileRepository.save(profile);
	}

	public void deleteProfile(String id) {
		profileRepository.deleteById(id);
	}
}
