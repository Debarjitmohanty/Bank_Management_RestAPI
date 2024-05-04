package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Account;
import com.app.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	public AccountService service;
	
	//create the account
	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account createAccount = service.createAccount(account);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
	}
	
	@GetMapping("/{accountNumber}")
	public Account getAccountByNumber(@PathVariable Long accountNumber) {
		Account account_details=service.getAccountByNumber(accountNumber);
		return account_details;
	}
	
	@GetMapping("/getallaccount")
	public List<Account> getAllAccount() {
		List<Account> allAccountDetails = service.getAllAccount();
		return allAccountDetails;
	}
	
	@PutMapping("/deposite/{accountNumber}/{amount}")
	public Account depositeAccount(@PathVariable Long accountNumber,@PathVariable Double amount) {
		Account account=service.depositeAmount(accountNumber, amount);
		return account;
	}
	
	@PutMapping("/withdraw/{accountNumber}/{amount}")
	public Account withdrawAmount(@PathVariable Long accountNumber,@PathVariable Double amount) {
		Account account=service.withdrawAmount(accountNumber, amount);
		return account;
	}
	
	@DeleteMapping("/delete/{accountNumber}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber) {
		service.closeAccount(accountNumber);
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account Closed");
		return ResponseEntity.ok("Account Closed");
	}
	
}
