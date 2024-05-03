package com.example.paymentservice.dto;

import org.springframework.stereotype.Component;

@Component
public class PaymentResponseDto {
	
	private AccountDto debitAccountDto;
	private AccountDto creditAccountDto;
	public AccountDto getDebitAccountDto() {
		return debitAccountDto;
	}
	public void setDebitAccountDto(AccountDto debitAccountDto) {
		this.debitAccountDto = debitAccountDto;
	}
	public AccountDto getCreditAccountDto() {
		return creditAccountDto;
	}
	public void setCreditAccountDto(AccountDto creditAccountDto) {
		this.creditAccountDto = creditAccountDto;
	}
	
	
	
}
