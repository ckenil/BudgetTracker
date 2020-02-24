package com.uc.budgettracker.repositories.businesslogic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.uc.budgettracker.dto.Transaction;

/*
 * Class used to preform various calculations on budget objects
 */
public class BudgetCalculator {
	
	/*
	 * calculates the balance for a list of transactions
	 * @param transactions: the transactions to be calculated from
	 * @return: a double representation of the balance
	 */
	public double calculateBalance(List<Transaction> transactions) {
		List<Transaction> cloneTrans = new ArrayList<>(transactions);
		double curBal = 0.0;
		for(Transaction transaction : cloneTrans) {
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
	public double getSpendingDifference(List<Transaction> transactions, LocalDate monthOne, LocalDate monthTwo) {
		List<Transaction> cloneTrans = new ArrayList<>(transactions);
		double balanceOne = 0.0;
		double balanceTwo = 0.0;
		double difference = 0.0;
		List<Transaction> monthOneTrans = cloneTrans.stream().filter(transaction -> (transaction.getLocalDate().getMonthValue() == monthOne.getMonthValue() 
				&& transaction.getLocalDate().getYear() == monthOne.getYear())).collect(Collectors.toList());
		List<Transaction> monthTwoTrans = cloneTrans.stream().filter(transaction -> (transaction.getLocalDate().getMonthValue() == monthTwo.getMonthValue()
				&& transaction.getLocalDate().getYear() == monthTwo.getYear())).collect(Collectors.toList());
		balanceOne = calculateBalance(monthOneTrans);
		balanceTwo = calculateBalance(monthTwoTrans);
		difference = balanceOne / balanceTwo;
		return difference;
	}
}
