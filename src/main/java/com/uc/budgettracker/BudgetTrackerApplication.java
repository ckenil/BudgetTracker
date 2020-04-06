package com.uc.budgettracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.uc.budgettracker.repositories")
@SpringBootApplication
public class BudgettrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BudgettrackerApplication.class, args);
    }

}
