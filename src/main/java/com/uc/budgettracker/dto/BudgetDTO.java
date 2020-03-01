package com.uc.budgettracker.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/*
 * A class that represents a user's budget 
 */
@Entity
public class BudgetDTO {
	/*
	 * Primary key
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long budgetId;

	/*
	 * Foreign key of the User's ID
	 */
	@Column(name="userId")
	private Long userId;
	/*
	 * List of all transactions related to the budgetId
	 */
	@OneToMany(targetEntity = TransactionDTO.class, mappedBy = "budgetId")
	private List<TransactionDTO> transactions;
	/*
	 * The net balance of the account during the transaction period
	 */
	@Column(name="balance")
	private Double balance;
	/*
	 * Date representing the transaction period of the budget
	 */
	
	private LocalDate period;

	public BudgetDTO(List<TransactionDTO> transactions, Long userId, Double balance, LocalDate period) {
		super();
		this.transactions = transactions;
		this.userId = userId;
		this.balance = balance;
		this.period = period;
	}

	public BudgetDTO(Long budgetId, List<TransactionDTO> transactions, Long userId, Double balance, LocalDate period) {
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

	public List<TransactionDTO> getTransactions() {
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

	public void setTransactions(List<TransactionDTO> transactions) {
		this.transactions = transactions;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}