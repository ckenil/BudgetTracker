package com.uc.budgettracker.repositories;

import com.uc.budgettracker.dto.Budget;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends CrudRepository<Budget, Long> {

}
