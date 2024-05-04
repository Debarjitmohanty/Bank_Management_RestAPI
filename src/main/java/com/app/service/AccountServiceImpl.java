package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Account;
import com.app.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	public AccountRepository repo;
	
	@Override
	public Account createAccount(Account account) {
		Account createAccount=repo.save(account);
		return createAccount;
	}

	@Override
	public Account getAccountByNumber(Long accountNumber) {
		Optional<Account> account = repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account does not exist");
		}
		Account account_found=account.get();
		return account_found;
	}

	@Override
	public List<Account> getAllAccount() {
		List<Account> listOfAccount = repo.findAll();
		return listOfAccount;
	}

	@Override
	public Account depositeAmount(Long accountNumber, Double amount) {
		Optional<Account> account = repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not exsit");
		}
		Account accountPresent=account.get();
		Double totalBalance=accountPresent.getAccount_balance()+amount;
		accountPresent.setAccount_balance(totalBalance);
		repo.save(accountPresent);
		
		return accountPresent;
	}

	@Override
	public Account withdrawAmount(Long accountNumber, Double amount) {
		Optional<Account> account = repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not exsit");
		}
		Account accountPresent=account.get();
		Double accountBalance=accountPresent.getAccount_balance()-amount;
		accountPresent.setAccount_balance(accountBalance);
		repo.save(accountPresent);
		return accountPresent;
	}

	@Override
	public void closeAccount(Long accountNumber) {
		getAccountByNumber(accountNumber);
		repo.deleteById(accountNumber);
		
		
	}

}
