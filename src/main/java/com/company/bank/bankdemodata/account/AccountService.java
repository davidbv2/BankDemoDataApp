package com.company.bank.bankdemodata.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	List<Account> accounts = new ArrayList<>(); 
	
	public List<Account> getAllAccounts (String id){
		accountRepository.findAll()
		.forEach(accounts::add);
		return accounts;
	}
	
	public Optional<Account> getAccount (String id){
		return accountRepository.findById(id);
	}
	
	public void addAccount(Account account){
		accountRepository.save(account);
	}

	public void updateAccount(Account account) {
		accountRepository.save(account);
	}

	public void deleteAccount(String id) {
		accountRepository.deleteById(id);
	}
}
