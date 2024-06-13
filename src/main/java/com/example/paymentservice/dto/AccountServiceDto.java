package com.example.paymentservice.dto;

import org.springframework.stereotype.Component;

import com.example.paymentservice.domain.ArithmeticOperation;
import com.example.paymentservice.entity.Payment;

@Component
public class AccountServiceDto {

	private Payment payment;
	private ArithmeticOperation ops;

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public ArithmeticOperation getOps() {
		return ops;
	}

	public void setOps(ArithmeticOperation ops) {
		this.ops = ops;
	}
	
	
}
