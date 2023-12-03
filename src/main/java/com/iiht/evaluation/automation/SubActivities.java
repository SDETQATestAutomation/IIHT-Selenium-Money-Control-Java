package com.iiht.evaluation.automation;

import static com.iiht.evaluation.automation.Helpers.getElementforEMIStart;
import static com.iiht.evaluation.automation.Helpers.getElementforHomeLoan;
import static com.iiht.evaluation.automation.Helpers.getElementforInterestRate;
import static com.iiht.evaluation.automation.Helpers.getElementforLoanAmount;
import static com.iiht.evaluation.automation.Helpers.getElementforLoanPeriod;
import static com.iiht.evaluation.automation.Helpers.getElementforMouseOver;
import static com.iiht.evaluation.automation.Helpers.getElementforTool;
import static com.iiht.evaluation.automation.Helpers.getElementforUpfrontcharges;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
//import java.util.List;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubActivities {
	
	public static boolean mouseOverPersonalFinance(WebDriver driver, String baseUrl)  {
		return false;
	}
	
	public static boolean clickTools(WebDriver driver, Actions actions)  {
		return false;
	}
	
	
	
	public static boolean clickOnHomeLoanEMICalculator(WebDriver driver) {
		return false;
	}

	
	public static boolean enterValueLoanAmount(WebDriver driver) 	{
		return false;
	}
	
	
	public static boolean enterValueLoanPeriod(WebDriver driver) {
		return false;
	}
	
	
	public static boolean selectEMIStartsFrom(WebDriver driver) {
		return false;
	}
	
	
	public static boolean enterInterestRate(WebDriver driver) {
		return false;
	}
	
	
	
	public static boolean enterValueUpfrontCharges(WebDriver driver) {
		return false;
	}
	
	
	
	public static WebElement getTotalPaymentElement(WebDriver driver) {
		return null;
	}
	
	
	public static boolean clickSubmit(WebDriver driver){
		return false;
	}
	
	
	
}
