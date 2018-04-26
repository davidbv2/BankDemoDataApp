package com.company.bank.bankdemodata.account;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.company.bank.bankdemodata.profile.Profile;
 
@Entity
public class Account {
	
	@Id
	private String id;
	private String type;
	private String accountNum;
	private String routingNum;
	private String balance;
	
	/*
	 * Creating this member variable allows us to tie an account with a particular profile instance; 
	 *Create getters & setters 
	 */ 
	private Profile profile; 
	
	public Account(){
		
	}
	
	//add 'profileId' to constructor; allows us to create new Account objects with a given Profile 
	public Account(String id, String type, String accountNum, String routingNum, String balance, String profileId) {
		super();
		this.id = id;
		this.type = type;
		this.accountNum = accountNum;
		this.routingNum = routingNum;
		this.balance = balance;
		this.profile = new Profile(profileId,"","","","",0,0,"");
	}

	public String getId() {
		return id;
	}

	public void setId2(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getRoutingNum() {
		return routingNum;
	}

	public void setRoutingNum(String routingNum) {
		this.routingNum = routingNum;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	
	
}	
