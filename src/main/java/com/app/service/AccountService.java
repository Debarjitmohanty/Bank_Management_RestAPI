package com.app.service;

import java.util.List;

import com.app.entity.Account;

public interface AccountService {

	public Account createAccount(Account account);
	
	public Account getAccountByNumber(Long accountNumber);
	
	public List<Account> getAllAccount();
	
	public Account depositeAmount(Long accountNumber, Double amount);
	
	public Account withdrawAmount(Long accountNumber, Double amount);
	
	public void closeAccount(Long accountNumber);
}
