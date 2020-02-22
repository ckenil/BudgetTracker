package com.uc.budgettracker.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Budget {
	/*
	 * Primary key
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long budgetId;

	/*
	 * Foreign key of the User's ID
	 */
	private Long userId;
	/*
	 * List of all transactions related to the budgetId
	 */
	@OneToMany(targetEntity = Transaction.class, mappedBy = "budgetId")
	private List<Transaction> transactions;
	/*
	 * The net balance of the account during the transaction period
	 */
	private Double balance;
	/*
	 * Date representing the transaction period of the budget
	 */
	private Date period;

	public Budget(List<Transaction> transactions, Long userId, Double balance, Date period) {
		super();
		this.transactions = transactions;
		this.userId = userId;
		this.balance = balance;
		this.period = period;
	}

	public Budget(Long budgetId, List<Transaction> transactions, Long userId, Double balance, Date period) {
		super();
		this.budgetId = budgetId;
		this.transactions = transactions;
		this.userId = userId;
		this.balance = balance;
		this.period = period;
	}

	public Double getBalance() {
		return balance;
	}

	public Long getBudgetId() {
		return budgetId;
	}

	public Date getPeriod() {
		return period;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public Long getUserId() {
		return userId;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public void setBudgetId(Long budgetId) {
		this.budgetId = budgetId;
	}

	public void setPeriod(Date period) {
		this.period = period;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
