package com.uc.budgettracker.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.uc.budgettracker.dto.TransactionDTO;

/*
 * Class used to preform various calculations on budget objects
 */
public class BudgetService {
	
	/*
	 * calculates the balance for a list of transactions
	 * @param transactions: the transactions to be calculated from
	 * @return: a double representation of the balance
	 */
	public double calculateBalance(List<TransactionDTO> transactions) {
		List<TransactionDTO> cloneTrans = new ArrayList<>(transactions);
		double curBal = 0.0;
		for(TransactionDTO transaction : cloneTrans) {
			curBal += transaction.getAmount();
		}
		return curBal;
	}
	
	/*
	 * calculates the spending difference as a percent between two different time periods
	 * @param transactions: a list containing the total amount of transactions 
	 * @param monthOne: a date representing the first month to compare
	 * @param monthTwo: a date representing the second month to compare
	 * return: a double representation of the difference between the months' spending
	 */
	public double getSpendingDifference(List<TransactionDTO> transactions, LocalDate monthOne, LocalDate monthTwo) {
		List<TransactionDTO> cloneTrans = new ArrayList<>(transactions);
		double balanceOne = 0.0;
		double balanceTwo = 0.0;
		double difference = 0.0;
		List<TransactionDTO> monthOneTrans = cloneTrans.stream().filter(transaction -> (transaction.getLocalDate().getMonthValue() == monthOne.getMonthValue() 
				&& transaction.getLocalDate().getYear() == monthOne.getYear())).collect(Collectors.toList());
		List<TransactionDTO> monthTwoTrans = cloneTrans.stream().filter(transaction -> (transaction.getLocalDate().getMonthValue() == monthTwo.getMonthValue()
				&& transaction.getLocalDate().getYear() == monthTwo.getYear())).collect(Collectors.toList());
		balanceOne = calculateBalance(monthOneTrans);
		balanceTwo = calculateBalance(monthTwoTrans);
		difference = balanceOne / balanceTwo;
		return difference;
	}
}
