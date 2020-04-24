package com.uc.budgettracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uc.budgettracker.dto.Budget;
import com.uc.budgettracker.dto.Transaction;

@Controller
public class BudgetTrackerController {
	
	@RequestMapping(value="/")
	public ModelAndView getUserBudget(@RequestParam(value="userId", required=false, defaultValue="1") int userId) {
		ModelAndView modelAndView = new ModelAndView();
		
		//mock list of budgets
		List<Budget> userBudgets = new ArrayList<Budget>();
		Budget budget = new Budget();
		budget.setBalance(100.0);
		budget.setBudgetId(1L);
		budget.setPeriod(LocalDate.now());
		budget.setUserId(1L);
		userBudgets.add(budget);
		
		Budget budget2 = new Budget();
		budget2.setBalance(-100.0);
		budget2.setBudgetId(1L);
		budget2.setPeriod(LocalDate.now());
		budget2.setUserId(1L);
		userBudgets.add(budget2);
		
		
		modelAndView.setViewName("start");
		modelAndView.addObject("userBudgets", userBudgets);
		
//		List<Budget> userBudgets = Budget.getUserBudgetsByUserID(userId)

		return modelAndView;
	}
	
	@RequestMapping(value="/month")
	public ModelAndView getMonth(@RequestParam(value="budgetId", required=false, defaultValue="1") int budgetId) {
		ModelAndView modelAndView = new ModelAndView();
		
		//mock list of transactions
				List<Transaction> userTransactions = new ArrayList<Transaction>();
				Transaction transaction = new Transaction();
				transaction.setBudgetId(1L);
				transaction.setTransactionId(1L);
				transaction.setAmount(-25.0);
				transaction.setDescription("Burger from Bob's Turkey Burger Shack");
				transaction.setLocalDate(LocalDate.now());
				userTransactions.add(transaction);
				
				Transaction transaction2 = new Transaction();
				transaction2.setBudgetId(1L);
				transaction2.setTransactionId(1L);
				transaction2.setAmount(25.0);
				transaction2.setDescription("Burger from Bob's Turkey Burger Shack");
				transaction2.setLocalDate(LocalDate.now());
				userTransactions.add(transaction2);
				
				modelAndView.setViewName("month");
				modelAndView.addObject("userTransactions", userTransactions);
				
//		List<Transaction> budgetTransactions = Transaction.getTransactionsByBudgetID(newTransaction.budgetId);
				
		return modelAndView;
	}
	
	@RequestMapping(value="/budget", method=RequestMethod.GET)
	public String getMonthlyBudget(Model model, @RequestParam(value="userId", required=false, defaultValue="1") int userId) {
//		model.addAttribute("userId", userId);
		return "budget";
	}
	
	@RequestMapping(value="/budget/edit")
	public ModelAndView editBudget(Budget budget) {
		ModelAndView modelAndView = new ModelAndView();
		
		Budget budgetMock = new Budget();
		budgetMock.setBalance(100.0);
		budgetMock.setBudgetId(1L);
		budgetMock.setPeriod(LocalDate.now());
		budgetMock.setUserId(1L);
		
		modelAndView.setViewName("editBudget");
		modelAndView.addObject("budget", budgetMock);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/budget/new", method=RequestMethod.POST)
	public String NewBudget(Model model, Budget budget) {
//		Budget newBudget = Budget.createNewBudget(budget);
//		ArrayList<Budget> userBudgets = Budget.getUserBudgets(budget.userId));
//		model.addAttribute("userBudgets", userBudgets);
		return "start";
	}
	
	@RequestMapping(value="/budget/delete", method=RequestMethod.DELETE)
	public String deleteBudget(Model model, Budget budget) {
		//delete budget
		//fetch budgets
		//return model and view
		return "start";
	}

	@RequestMapping(value="/transaction", method=RequestMethod.GET)
	public String createTransaction(Model model, @RequestParam(value="budgetId", required=false, defaultValue="1") int budgetId) {
		
		return "transaction";
	}
	
	@RequestMapping(value="/transaction/edit")
	public ModelAndView editTransaction(Transaction transaction) {
		ModelAndView modelAndView = new ModelAndView();
		
		Transaction transactionMock = new Transaction();
		transactionMock.setBudgetId(1L);
		transactionMock.setTransactionId(1L);
		transactionMock.setAmount(-25.0);
		transactionMock.setDescription("Burger from Bob's Turkey Burger Shack");
		transactionMock.setLocalDate(LocalDate.now());
		
		modelAndView.setViewName("editTransaction");
		modelAndView.addObject("transaction", transactionMock);
		
		return modelAndView;
	}
	
	
	
	@RequestMapping(value="/transaction/new", method=RequestMethod.POST)
	public String NewTransaction(Model model, Transaction transaction) {
//		Budget newTransaction = Transaction.createNewTransaction(transaction);
//		ArrayList<Transaction> budgetTransactions = Transaction.getTransactionsByBudgetID(newTransaction.budgetId);
//		model.addAttribute("budgetTransactions", budgetTransactions);
		return "month";
	}
	
	@RequestMapping(value="/transaction/delete", method=RequestMethod.DELETE)
	public String deleteTransaction(Model model, Transaction transaction) {
		//delete transaction
		//fetch transactions
		//return model and view
		return "month";
	}
}
