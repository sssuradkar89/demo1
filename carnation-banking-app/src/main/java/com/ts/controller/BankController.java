package com.ts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ts.model.Bank;
import com.ts.service.BankService;

@RestController
public class BankController {

	@Autowired
	BankService bankService;
	
	@PostMapping("/register")
	public Bank register(@RequestBody Bank bank) {
		return bankService.register(bank);
		
	}
	@GetMapping("/users")
	public List<Bank> getAllUsers(){
		return bankService.getAllUsers();
	}
	
	@PutMapping("/transfer")
	public String transfer( @RequestParam("fromAccount")Long fromAccount,
							@RequestParam("toAccount")Long toAccount,
							@RequestParam("amount")Long amount) {
		return bankService.transfer(fromAccount, toAccount, amount);	
	}	
}
