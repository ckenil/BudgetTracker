package com.uc.budgettracker.service;

import java.time.LocalDate;
import java.util.List;

import com.uc.budgettracker.dto.TransactionDTO;

public interface IBudgetService {
	
	/*
	 * calculates the balance for a list of transactions
	 * @param transactions: the transactions to be calculated from
	 * @return: a double representation of the balance
	 */
	public double calculateBalance(List<TransactionDTO> transactions);
	
	/*
	 * calculates the spending difference as a percent between two different time periods
	 * @param transactions: a list containing the total amount of transactions 
	 * @param monthOne: a date representing the first month to compare
	 * @param monthTwo: a date representing the second month to compare
	 * return: a double representation of the difference between the months' spending
	 */
	public double getSpendingDifference(List<TransactionDTO> transactions, LocalDate monthOne, LocalDate monthTwo);
}
