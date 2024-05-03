package com.example.paymentservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.paymentservice.domain.ArithmeticOperation;
import com.example.paymentservice.dto.AccountDto;
import com.example.paymentservice.dto.PaymentDto;
import com.example.paymentservice.dto.PaymentResponseDto;
import com.example.paymentservice.entity.Account;
import com.example.paymentservice.entity.Payment;
import com.example.paymentservice.mapper.AccountMapper;
import com.example.paymentservice.mapper.PaymentMapper;
import com.example.paymentservice.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService{

	Logger log = LoggerFactory.getLogger(PaymentServiceImpl.class);
	
	private Account account;
	
	private AccountDto accountDto;
	
	@Autowired
	private PaymentResponseDto paymentResponseDto;
	
	@Autowired
	private AccountServiceImpl accountServiceImpl;
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@Override
	public PaymentResponseDto deposit(PaymentDto paymentDto) throws Exception {
		
		isNotNegativeAmountInput(paymentDto);
		
		Payment payment = PaymentMapper.dtoToPayment(paymentDto);
		
		log.info("Payment Entry" + payment.toString());
		
		creditOps(payment);
		paymentRepository.save(payment);
		
		paymentResponseDto.setCreditAccountDto(accountDto);
		paymentResponseDto.setDebitAccountDto(null);
		
		return paymentResponseDto;
	}

	private void creditOps(Payment payment) {
		
		accountServiceImpl.updateAccountBalance(payment, ArithmeticOperation.CREDIT);
		
		account = accountServiceImpl.findAccount(payment.getCreditAccount());
		
		accountDto = AccountMapper.accountToDto(account);
		
	}

	private boolean isNotNegativeAmountInput(PaymentDto paymentDto) throws Exception {
		
		if (paymentDto.getAmount() <= 0) {
			throw new Exception("Invalid input");
		}
		
		return true;
	}

	@Override
	public PaymentResponseDto withdrawal(PaymentDto paymentDto) throws Exception {
		
		isNotNegativeAmountInput(paymentDto);
		
		Payment payment = PaymentMapper.dtoToPayment(paymentDto);
		
		log.info("Payment Entry" + payment.toString());
		
		debitOps(payment);
		paymentRepository.save(payment);
		
		paymentResponseDto.setCreditAccountDto(null);
		paymentResponseDto.setDebitAccountDto(accountDto);
		
		return paymentResponseDto;
		
		
		
	}

	private void debitOps(Payment payment) throws Exception {
		
		Account account = accountServiceImpl.findAccount(payment.getDebitAccount());
		
		if ((account.getBalance() - payment.getAmount()) < 0) {
			throw new Exception("Insufficient Balance");
		}else {
			accountServiceImpl.updateAccountBalance(payment, ArithmeticOperation.DEBIT);
			
			account = accountServiceImpl.findAccount(payment.getDebitAccount());
			
			accountDto = AccountMapper.accountToDto(account);
		}
		
	}

	@Override
	public PaymentResponseDto transfer(PaymentDto paymentDto) throws Exception {
		
		isNotNegativeAmountInput(paymentDto);
		
		Payment payment = PaymentMapper.dtoToPayment(paymentDto);
		
		if(payment.getDebitAccount() != null) {
			debitOps(payment);
			paymentRepository.save(payment);
			paymentResponseDto.setDebitAccountDto(accountDto);
		}
		
		if(payment.getCreditAccount() != null) {
			creditOps(payment);
			paymentRepository.save(payment);
			paymentResponseDto.setCreditAccountDto(accountDto);
		}
		return paymentResponseDto;
		
	}

}
