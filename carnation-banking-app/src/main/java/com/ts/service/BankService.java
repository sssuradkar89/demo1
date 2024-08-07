package com.ts.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.ts.model.Bank;

public interface BankService {

	Bank register(Bank bank);

	List<Bank> getAllUsers();
	
	String transfer(Long fromAccount,Long toAccount,Long amount);
}
