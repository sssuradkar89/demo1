package com.ts.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ts.model.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank,Long>{

	Optional <Bank> findByAccountNumber(Long accountNumber);
}
