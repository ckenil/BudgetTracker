package com.uc.budgettracker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BudgetTrackerController {
	
	@RequestMapping(value="/start")
	public String getUserBudget() {
		return "start";
	}
	
	@RequestMapping(value="/month")
	public String getMonth() {
		return "month";
	}
	
	@RequestMapping(value="/budget")
	public String getMontlyBudget() {
		return "budget";
	}

	@RequestMapping(value="/transaction")
	public String createTransaction() {
		return "transaction";
	}
}
