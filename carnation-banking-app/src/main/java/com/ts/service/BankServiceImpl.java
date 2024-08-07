package com.ts.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.model.Bank;
import com.ts.repo.BankRepository;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	BankRepository bankRepository;
	
	@Override
	public Bank register(Bank bank) {
		
		Random random = new Random();//0 - 100000
		Long acc = random.nextLong(100000);
		//unique accno 
		bank.setAccountNumber(acc);
		
		return bankRepository.save(bank);
	}

	@Override
	public List<Bank> getAllUsers() {
		//only show username and accno
		return bankRepository.findAll();
	}
	@Override
	public String transfer(Long fromAccount,Long toAccount,Long amount) {
		Bank fromAcc = bankRepository.findByAccountNumber(fromAccount).get();
		Bank toAcc = bankRepository.findByAccountNumber(toAccount).get();
		
		//check account are avaialable or not
		//check balance of fromAccount(>=Account)
		
		fromAcc.setBalance(fromAcc.getBalance()-amount);
		toAcc.setBalance(toAcc.getBalance()+amount);
		bankRepository.save(fromAcc);
		bankRepository.save(toAcc);
		
		return null;
		
	}
}
