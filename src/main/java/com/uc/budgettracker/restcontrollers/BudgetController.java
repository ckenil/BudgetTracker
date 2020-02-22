package com.uc.budgettracker.restcontrollers;

import com.uc.budgettracker.dto.Budget;
import com.uc.budgettracker.dto.Transaction;
import com.uc.budgettracker.repositories.BudgetRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("budget")
public class BudgetController {

	/*
	 * Budget repository to interact with database
	 */
	@Autowired
	private BudgetRepository repo;

	/*
	 * Creates a default budget
	 */
	@PutMapping(path = "/create")
	public void create(Long userId) {
		repo.save(new Budget(new ArrayList<Transaction>(), userId, 0.0, new Date()));
	}

	/*
	 * Deletes the budget
	 *
	 * @param budget: budget to be deleted
	 */
	@DeleteMapping(path = "/delete")
	public void delete(Budget budget) {
		repo.delete(budget);
	}

	/*
	 * Finds a budget
	 *
	 * @param budgetId: the budget's primary key
	 *
	 * @return: the budget (if found)
	 */
	@GetMapping(path = "/get")
	public Optional<Budget> get(Long budgetId) {
		return repo.findById(budgetId);
	}

	/*
	 * Saves the budget
	 *
	 * @param budget: the budget to be saved
	 */
	@PutMapping(path = "/save")
	public void save(Budget budget) {
		repo.save(budget);
	}
}
