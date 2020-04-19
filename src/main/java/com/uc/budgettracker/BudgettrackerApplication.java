package com.uc.budgettracker;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.uc.budgettracker.dto.Budget;
import com.uc.budgettracker.repositories.BudgetRepository;

@EnableJpaRepositories("com.uc.budgettracker.repositories")
@SpringBootApplication
public class BudgettrackerApplication {
	@Autowired
	private BudgetRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(BudgettrackerApplication.class, args);
	}

	@PostConstruct
	public void init() {
		
	}
}
