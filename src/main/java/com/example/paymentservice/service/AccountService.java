package com.example.paymentservice.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import com.example.paymentservice.dto.AccountDto;
import com.example.paymentservice.dto.AccountServiceDto;

@HttpExchange
public interface AccountService {

	@GetExchange("/account/find/{accountNumber}")
	public AccountDto findAccount(@PathVariable String accountNumber);
	
	@PostExchange("/account/update")
	public void updateAccountBalance(@RequestBody AccountServiceDto accountServiceDto);

}
