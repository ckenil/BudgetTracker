package com.uc.budgettracker.dao;

import com.uc.budgettracker.dto.BudgetDTO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepositoryDAO extends CrudRepository<BudgetDTO, Long> {

}
