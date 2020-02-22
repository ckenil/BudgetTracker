package com.uc.budgettracker.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
	/*
	 * Primary key
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;
	/*
	 * Foreign key budget id
	 */
	private Long budgetId;
	/*
	 * Name describing the transaction
	 */
	private final String name;
	/*
	 * Description of the transaction
	 */
	private final String description;

	/*
	 * Amount of the transaction
	 */
	private final Double amount;

	/*
	 * Date the transaction occurred
	 */
	private final Date date;

	public Transaction(Long transactionId, String name, String description, Double amount, Date date) {
		super();
		this.transactionId = transactionId;
		this.name = name;
		this.description = description;
		this.amount = amount;
		this.date = date;
	}

	public Transaction(String name, String description, Double amount, Date date) {
		super();
		this.name = name;
		this.description = description;
		this.amount = amount;
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public Date getDate() {
		return date;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
}
