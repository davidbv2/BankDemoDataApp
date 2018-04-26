package com.company.bank.bankdemodata.account;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.bank.bankdemodata.profile.Profile;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	/*
	 * We want to get all of the accounts related to a profile id; we don't want all accounts to be returned
	 * Thus, we need to add @PathVariable as a parameter in our method, to first get the particular profile by id
	 */
	@RequestMapping("/profiles/{id}/accounts")
	public List<Account> getAllAccounts (@PathVariable String id){
		return accountService.getAllAccounts(id);
	}
	
	
	@RequestMapping("/profiles/{profileId}/accounts/{id}")
	public Optional<Account> getAccount (@PathVariable String id){
		return accountService.getAccount(id);
	}
	
	/*
	 * We need 'account' object to contain profile info. so we can add/"map" an account to correct profile
	 * We map by adding 'profileId' & the creation of a new Profile (incomplete) instance to our 'Account' constructor 
	 * in our 'Account' class
	 * The reason of creating this 'Profile' instance & setting it here is just so we get the mapping right for 
	 * the profile ID 
	 */
	@RequestMapping(method=RequestMethod.POST,value="/profiles/{profileId}/accounts/")
	public void addAccount (@RequestBody Account account, @PathVariable String profileId){
		account.setProfile(new Profile(profileId,"","","","",0,0,""));
		accountService.addAccount(account);
	}	
	
	@RequestMapping(method=RequestMethod.PUT,value="/profiles/{profileId}/accounts/{id}")
	public void updateAccount (@RequestBody Account account, @PathVariable String profileId, @PathVariable String id){
		account.setProfile(new Profile(profileId,"","","","",0,0,""));
		accountService.updateAccount(account);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/profiles/{profileId}/accounts/{id}")
	public void deleteAccount (@PathVariable String id){
		accountService.deleteAccount(id);
	}
	
	
	

}
 

