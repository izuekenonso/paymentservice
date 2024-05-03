package com.example.paymentservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.paymentservice.domain.ArithmeticOperation;
import com.example.paymentservice.dto.AccountDto;
import com.example.paymentservice.entity.Account;
import com.example.paymentservice.entity.Payment;
import com.example.paymentservice.mapper.AccountMapper;
import com.example.paymentservice.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	private Account account;
	
	private List<Account> accountList = new ArrayList<Account>();
	
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public AccountDto create(AccountDto accountDto) {
		
		Account account = AccountMapper.dtoToAccount(accountDto);
		Account result = accountRepository.save(account);
		
		return AccountMapper.accountToDto(result);
	}
	
	@Override
	public void updateAccountBalance(Payment payment, ArithmeticOperation ops) {

		double newBalance = processPayment(payment, ops);
		
 		account.setBalance(newBalance);
	}

	private double processPayment(Payment payment,  ArithmeticOperation ops) {
		
		double newBalance = 0.0;
		
		switch(payment.getPaymentType()) {
			case DEPOSIT: 			
				newBalance = creditOps(payment);
			break;
			case WITHDRAWAL: 
				newBalance = debitOps(payment);
			break;
			case TRANSFER: 
				if(ops == ArithmeticOperation.CREDIT) newBalance = creditOps(payment);
				if(ops == ArithmeticOperation.DEBIT) newBalance = debitOps(payment);
			break;
			default:
				newBalance = 0.0;
			break;
		}
		
		return newBalance;
		
	}

	private double debitOps(Payment payment) {
		account = findAccount(payment.getDebitAccount());
		double debit = account.getBalance() - payment.getAmount();
		
		Account result = accountRepository.findByAccountNumber(payment.getDebitAccount());
		result.setBalance(debit);
		accountRepository.save(result);
		
		return debit;
	}

	private double creditOps(Payment payment) {
		account = findAccount(payment.getCreditAccount());
		double credit = account.getBalance() + payment.getAmount();
		
		Account result = accountRepository.findByAccountNumber(payment.getCreditAccount());
		result.setBalance(credit);
		accountRepository.save(result);
		
		return credit;
	}

	@Override
	public Account getAccountBalance(String accountNumber) {
		
		account = findAccount(accountNumber);
		
		return account;
	}

	@Override
	public Account findAccount(String accountNumber) {
		
		account = accountRepository.findByAccountNumber(accountNumber);
		
		return account;
	}

}
