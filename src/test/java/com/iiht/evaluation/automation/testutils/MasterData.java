package com.iiht.evaluation.automation.testutils;

import java.util.ArrayList;
import java.util.List;

public class MasterData {

	public static List<String> repo;
	
	static {
		repo= new ArrayList<String>();
		//Mouse over PErsonal Finance (0)
		repo.add("https://www.moneycontrol.com/personal-finance/");
		
		//Click Tools (1)
		repo.add("https://www.moneycontrol.com/personal-finance/tools/");
		
		// Home Loan Calculator (2)
		repo.add("https://www.moneycontrol.com/personal-finance/tools/emi-calculator.html");
		
		//Loan Amount (3)
		repo.add("<input class=\"sipslidervalue\" id=\"carhome_loan\" maxlength=\"20000\" value=\"10000\" oninput=\"javascript: if (this.value > 5000000) this.value = '5000000';this.value.replace(/[^\\d]/g,'');\" type=\"number\">");
		
		//Loan Period (4)
		repo.add("<input id=\"loan_period\" class=\"sipslidervalue month_input\" oninput=\"javascript: if (this.value > 35) this.value = '20';\" type=\"number\">");
		
		// EMI Start (5)
		repo.add("<select class=\"custselect\" id=\"emi_start_from\">" + 
				"                    <option value=\"0\">At the time of loan disbursement</option>" + 
				"                    <option value=\"1\">From next month after disbursement</option>" + 
				"                </select>");
		
		// Interest Rate(6
		repo.add("<input id=\"interest_rate\" class=\"sipslidervalue\" oninput=\"javascript: (this.value > 99.99 ) ? this.value = '' :this.value=this.value.slice(0,5);\" type=\"number\">");
		
		// Upfront charges (7)
		repo.add("<input id=\"upfront_charges\" class=\"sipslidervalue\" oninput=\"javascript: if (this.value > 1000000) this.value = '10000';\" type=\"number\">");
	
	}
}
