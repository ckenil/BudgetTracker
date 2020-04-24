package com.uc.budgettracker.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * A class that represents a user's budget 
 */
@Entity
@Table(name="Budget")
public class Budget {
	/*
	 * Primary key
	 */
	@Id
	@Column(name="budgetId")
	private Long budgetId;

	/*
	 * Foreign key of the User's ID
	 */
	@Column(name="userId")
	private Long userId;
	/*
	 * List of all transactions related to the budgetId
	 */
	@OneToMany(targetEntity = Transaction.class, mappedBy = "budgetId")
	private List<Transaction> transactions;
	/*
	 * The net balance of the account during the transaction period
	 */
	@Column(name="balance")
	private Double balance;
	/*
	 * Date representing the transaction period of the budget
	 */
	
	private LocalDate period;
	
	public Budget() {
		
	}

	public Budget(List<Transaction> transactions, Long userId, Double balance, LocalDate period) {
		super();
		this.transactions = transactions;
		this.userId = userId;
		this.balance = balance;
		this.period = period;
	}

	public Budget(Long budgetId, List<Transaction> transactions, Long userId, Double balance, LocalDate period) {
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

	public LocalDate getPeriod() {
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

	public void setPeriod(LocalDate period) {
		this.period = period;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
