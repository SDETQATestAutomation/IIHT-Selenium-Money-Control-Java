package com.iiht.evaluation.automation;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import static com.iiht.evaluation.automation.Helpers.*;

public class Activities {
	
		
	public boolean navigateToHomeLoanEMI(WebDriver driver) throws IOException{
		return false;
	}
	
	public boolean calculateHomeLoanEMI(WebDriver driver) throws InterruptedException
	{
		return false;
	}
	
	public String getTotalPayment(WebDriver driver) throws Exception{
		return "";
	}
	
	
	
	public String getEMI(WebDriver driver) throws Exception{
		return "";
	}
	
	public String getTableDetails7thYearEMIPaymentInTheYear(WebDriver driver) throws InterruptedException{
		return "";
	}
	public String getTableDetails7thYearInterestPaymentInTheYear(WebDriver driver) throws InterruptedException{
		return "";
	}
	public String getTableDetails7thYearPrincipalPaymentInTheYear(WebDriver driver) throws InterruptedException{
		return "";
	}
	public String getTableDetails5thYearOutstandingPrincipalAtTheEndOfYear(WebDriver driver) throws InterruptedException{
		return "";
	}

}
