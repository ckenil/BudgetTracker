package com.uc.budgettracker.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * Class that represents a single transaction
 */
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
	@Column(name = "budgetId")
	private Long budgetId;
	/*
	 * Name describing the transaction
	 */
	@Column(name = "name")
	private final String name;
	/*
	 * Description of the transaction
	 */
	@Column(name = "description")
	private final String description;
	/*
	 * Amount of the transaction
	 */
	@Column(name="amount")
	private final Double amount;

	/*
	 * Date the transaction occurred
	 */
	@Column(name="date")
	private final LocalDate date;

	public Transaction(Long transactionId, Long budgetId, String name, String description, Double amount, LocalDate date) {
		super();
		this.transactionId = transactionId;
		this.budgetId = budgetId;
		this.name = name;
		this.description = description;
		this.amount = amount;
		this.date = date;
	}

	
	public Transaction(Long transactionId, String name, String description, Double amount, LocalDate date) {
		super();
		this.transactionId = transactionId;
		this.name = name;
		this.description = description;
		this.amount = amount;
		this.date = date;
	}

	public Transaction(String name, String description, Double amount, LocalDate date) {
		super();
		this.name = name;
		this.description = description;
		this.amount = amount;
		this.date = date;
	}
	
	public Long getBudgetId() {
		return budgetId;
	}

	public void setBudgetId(Long budgetId) {
		this.budgetId = budgetId;
	}

	public Double getAmount() {
		return amount;
	}

	public LocalDate getLocalDate() {
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
