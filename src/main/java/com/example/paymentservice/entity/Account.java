package com.example.paymentservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "account_number", nullable = false)
	private String accountNumber;
	
	@Column(name = "balance", nullable = false)
	private double balance;

	@Column(name = "user_id", nullable = false)
	private Long userId;
	
	
	public Account() {

	}
	public Account(Long id, String accountNumber, double balance, Long userId) {

		this.id = id;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.userId = userId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", accountNumber=" + accountNumber + ", balance=" + balance + ", userId=" + userId
				+ "]";
	}
	
	
}
