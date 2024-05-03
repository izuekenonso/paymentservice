package com.example.paymentservice.dto;

import com.example.paymentservice.domain.PaymentType;

public class PaymentDto {
	private Long id;
	private double amount;
	private String creditAccount;
	private String debitAccount;
	private PaymentType paymentType;
	
	
	public PaymentDto() {
		
	}

	public PaymentDto(Long id, double amount, String creditAccount, String debitAccount, PaymentType paymentType) {

		this.id = id;
		this.amount = amount;
		this.creditAccount = creditAccount;
		this.debitAccount = debitAccount;
		this.paymentType = paymentType;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCreditAccount() {
		return creditAccount;
	}

	public void setCreditAccount(String creditAccount) {
		this.creditAccount = creditAccount;
	}

	public String getDebitAccount() {
		return debitAccount;
	}

	public void setDebitAccount(String debitAccount) {
		this.debitAccount = debitAccount;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	@Override
	public String toString() {
		return "PaymentDto [id=" + id + ", amount=" + amount + ", creditAccount=" + creditAccount
				+ ", debitAccount=" + debitAccount + ", paymentType=" + paymentType + "]";
	}
}
