package com.example.paymentservice.service;

import com.example.paymentservice.dto.PaymentDto;
import com.example.paymentservice.dto.PaymentResponseDto;

public interface PaymentService {
	
	PaymentResponseDto deposit(PaymentDto paymentDto) throws Exception;
	PaymentResponseDto withdrawal(PaymentDto paymentDto) throws Exception;
	PaymentResponseDto transfer(PaymentDto paymentDto) throws Exception;
	
}
