package com.iiht.evaluation.automation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class App{

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Activities activities = new Activities();
		
		try {
			if(activities.navigateToHomeLoanEMI(driver)) {
				if(activities.calculateHomeLoanEMI(driver)) {
					System.out.println("Total Payment : " + activities.getTotalPayment(driver));
					System.out.println("EMI : " + activities.getEMI(driver));
					System.out.println("7th Year EMI Payment : " + activities.getTableDetails7thYearEMIPaymentInTheYear(driver));
					System.out.println("7th Year Interest Payment : " + activities.getTableDetails7thYearInterestPaymentInTheYear(driver));
					System.out.println("7th Year Principal Payment : " + activities.getTableDetails7thYearPrincipalPaymentInTheYear(driver));
					System.out.println("5th Year Outstanding Principal : " + activities.getTableDetails5thYearOutstandingPrincipalAtTheEndOfYear(driver));
				}
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
	}
}
