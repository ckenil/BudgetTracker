package com.uc.budgettracker.repositories;

import com.uc.budgettracker.dto.Budget;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends CrudRepository<Budget, Long> {

	/*
	 * Finds all budgets related to a user
	 * @param userId: primary key of the user
	 * @return: A list of budgets related to the user
	 */
	@Query(nativeQuery=true, value="SELECT * FROM Budget WHERE UserID = :userId")
	public List<Budget> getUSerBudgetsByUserId(@Param(value="userId") int userId);
}
