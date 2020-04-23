package com.uc.budgettracker;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uc.budgettracker.dto.Budget;
import com.uc.budgettracker.dto.Transaction;

@Controller
public class BudgetTrackerController {
	
	@RequestMapping(value="/")
	public String getUserBudget(Model model, @RequestParam(value="userId", required=false, defaultValue="1") Long userId) {
//		ArrayList<Budget> userBudgets = Budget.getUserBudgetsByUserID(userId)
//		model.addAttribute("userBudgets", userBudgets);
		return "start";
	}
	
	@RequestMapping(value="/month", method=RequestMethod.GET)
	public String getMonth(Model model, @RequestParam(value="budgetId", required=false, defaultValue="1") Long budgetId) {
//		ArrayList<Transaction> budgetTransactions = Transaction.getTransactionsByBudgetID(newTransaction.budgetId);
//		model.addAttribute("budgetTransactions", budgetTransactions);
		return "month";
	}
	
	@RequestMapping(value="/budget", method=RequestMethod.GET)
	public String getMonthlyBudget(Model model, @RequestParam(value="userId", required=false, defaultValue="1") Long userId) {
//		model.addAttribute("userId", userId);
		return "budget";
	}
	
	@RequestMapping(value="/budget/new", method=RequestMethod.POST)
	public String NewBudget(Model model, Budget budget) {
//		Budget newBudget = Budget.createNewBudget(budget);
//		ArrayList<Budget> userBudgets = Budget.getUserBudgets(budget.userId));
//		model.addAttribute("userBudgets", userBudgets);
		return "start";
	}

	@RequestMapping(value="/transaction", method=RequestMethod.GET)
	public String createTransaction(Model model, @RequestParam(value="budgetId", required=false, defaultValue="1") Long budgetId) {
//		model.addAttribute("budgetId", budgetId);
		return "transaction";
	}
	
	@RequestMapping(value="/transaction/new", method=RequestMethod.POST)
	public String NewTransaction(Model model, Transaction transaction) {
//		Budget newTransaction = Transaction.createNewTransaction(transaction);
//		ArrayList<Transaction> budgetTransactions = Transaction.getTransactionsByBudgetID(newTransaction.budgetId);
//		model.addAttribute("budgetTransactions", budgetTransactions);
		return "month";
	}
}
