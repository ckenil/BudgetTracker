package com.uc.budgettracker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BudgetTrackerController {
	
	@RequestMapping(value="/start")
	public String getUserBudget() {
		return "start";
	}
	

}
