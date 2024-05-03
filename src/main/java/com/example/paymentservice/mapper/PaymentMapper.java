package com.example.paymentservice.mapper;

import com.example.paymentservice.dto.PaymentDto;
import com.example.paymentservice.entity.Payment;

public class PaymentMapper {

	public static Payment dtoToPayment(PaymentDto paymentDto) {
		Payment payment = new Payment();
		
		payment.setId(paymentDto.getId());
		payment.setAmount(paymentDto.getAmount());
		payment.setCreditAccount(paymentDto.getCreditAccount());
		payment.setDebitAccount(paymentDto.getDebitAccount());
		payment.setPaymentType(paymentDto.getPaymentType());
		
		return payment;
	}
	
	public static PaymentDto paymentToDto(Payment payment) {
		PaymentDto paymentDto = new PaymentDto();
		
		paymentDto.setId(payment.getId());
		paymentDto.setAmount(payment.getAmount());
		paymentDto.setCreditAccount(payment.getCreditAccount());
		paymentDto.setDebitAccount(payment.getDebitAccount());
		paymentDto.setPaymentType(payment.getPaymentType());
		
		return paymentDto;
	}
}
