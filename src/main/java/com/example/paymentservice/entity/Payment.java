package com.example.paymentservice.entity;

import com.example.paymentservice.domain.PaymentType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "amount", nullable = false)
	private double amount;
	
	@Column(name = "credit_account")
	private String creditAccount;
	
	@Column(name = "debit_account")
	private String debitAccount;
	
	@Column(name = "payment_type")
	private PaymentType paymentType;
	
	
	public Payment() {
		
	}

	public Payment(Long id, double amount, String creditAccount, String debitAccount, PaymentType paymentType) {

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
		return "Payment [id=" + id + ", amount=" + amount + ", creditAccount=" + creditAccount
				+ ", debitAccount=" + debitAccount + ", paymentType=" + paymentType + "]";
	}

}
