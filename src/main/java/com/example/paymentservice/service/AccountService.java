package com.example.paymentservice.service;

import com.example.paymentservice.domain.ArithmeticOperation;
import com.example.paymentservice.dto.AccountDto;
import com.example.paymentservice.entity.Account;
import com.example.paymentservice.entity.Payment;

public interface AccountService {
	
	AccountDto create(AccountDto accountDto);
	void updateAccountBalance(Payment payment, ArithmeticOperation ops);
	Account getAccountBalance(String accountNumber);
	Account findAccount(String accountNumber);
	
}
