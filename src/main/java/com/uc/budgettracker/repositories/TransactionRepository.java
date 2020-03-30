package com.uc.budgettracker.repositories;

import com.uc.budgettracker.dto.Transaction;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

	/*
	 * Sums the transactions for a given month
	 * @param month: the month to be summed in
	 * @param year: the year to be summed in
	 * @return: the total sum of all transactions for the time frame
	 */
	@Query(nativeQuery=true, value="SELECT SUM(amount) FROM Transactions WHERE Month(date) = :month AND Year(date) = :year ;")
	public double getSumOfMonth(@Param("month") int month, @Param("year") int year);
	
	/*
	 * Find all transactions with given name or description
	 * @param name: the name of the transaction
	 * @return: a list of all transactions whose name or description contained the name
	 */
	@Query(nativeQuery=true, value="SELECT * FROM Transactions WHERE Name LIKE '%' + :name + '%' OR Description LIKE '%' + :name: + '%' ;")
	public List<Transaction> findAllByNameAndDesc(@Param("name") String name);
	
	/*
	 * Finds all transactions within a given month and year
	 * @param month: the month being searched in
	 * @param year: the year being searched in
	 * @return: a list of all transactions within the given month and year
	 */
	@Query(nativeQuery=true, value="SELECT * FROM Transactions WHERE Month(date) = :month AND Year(date) = :year ;")
	public List<Transaction> findAllByMonth(@Param("month") int month, @Param("year") int year);
	
	/*
	 * Finds all transactions that are greater than a specified amount in the given month and year
	 * @param amount: the amount being compared to
	 * @param month: the month being searched in
	 * @param year: the year being searched in
	 * @return: a list containing all the transactions that had amounts greater than the specified amount and within the time frame
	 */
	@Query(nativeQuery=true, value="SELECT * FROM Transactions WHERE amount > :amount AND Month(date) = :month AND Year(date) = :year;")
	public List<Transaction> findByGreaterAmounts(@Param("amount") double amount);
	
	/*
	 * Finds all transactions that are less than a specified amount in the given month and year
	 * @param amount: the amount being compared to
	 * @param month: the month being searched in
	 * @param year: the year being searched in
	 * @return: a list containing all the transactions that had amounts less than the specified amount and within the time frame
	 */
	@Query(nativeQuery=true, value="SELECT * FROM Transactions WHERE amount < :amount AND Month(date) = :month AND Year(date) = :year;")
	public List<Transaction> findBySmallerAmounts(@Param("amount") double amount);
	
	/*
	 * Finds all transactions that are equal to the specified amount in the given month and year
	 * @param amount: the amount being compared to
	 * @param month: the month being searched in
	 * @param year: the year being searched in
	 * @return: a list containing all the transactions that had amounts equal to the specified amount and within the time frame
	 */
	@Query(nativeQuery=true, value="SELECT * FROM Transactions WHERE amount = :amount AND Month(date) = :month AND Year(date) = :year;")
	public List<Transaction> findByEqualAmount(@Param("amount") double amount);
	
}
