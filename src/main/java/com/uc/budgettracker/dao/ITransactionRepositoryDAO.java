package com.uc.budgettracker.dao;

import com.uc.budgettracker.dto.TransactionDTO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepositoryDAO extends CrudRepository<TransactionDTO, Long> {

}
