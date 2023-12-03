package com.iiht.evaluation.automation.functional;


import static com.iiht.evaluation.automation.testutils.TestUtils.businessTestFile;
import static com.iiht.evaluation.automation.testutils.TestUtils.currentTest;
import static com.iiht.evaluation.automation.testutils.TestUtils.yakshaAssert;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.iiht.evaluation.automation.Helpers;
import com.iiht.evaluation.automation.SubActivities;
import com.iiht.evaluation.automation.testutils.MasterData;

@TestMethodOrder(OrderAnnotation.class)
public class AutomationTest {
	
	private static WebDriver driver;
	private static Actions actions;
	
	@BeforeAll
	public static void preset() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String baseUrl = "https://www.moneycontrol.com/"; 
		driver.get(baseUrl);
	}
	
	public static String getHrefOfLink(WebElement w)
	{
		
		if (w.getAttribute("outerHTML").startsWith("<a")) {
			return w.getAttribute("href");
		}
		else
			return w.getAttribute("outerHTML");
		
	}
	
	@Test 
	@Order(1)
	public void testMouseOverPersonalFinance() throws IOException{
		boolean status = false;
		try {
			WebElement element = Helpers.getElementforMouseOver(driver);
			String href = getHrefOfLink(element);
			status = href.contentEquals(MasterData.repo.get(0));
			actions = new Actions(driver);
			actions.moveToElement(element).perform();
			yakshaAssert(currentTest(), status, businessTestFile);
		}catch(Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
		}
	}
	
	@Test 
	@Order(2)
	public void testGetToolForEMICalculator() throws IOException{
		boolean status = false;
		try {
			WebElement element = Helpers.getElementforTool(driver);
			String href = getHrefOfLink(element);
			status = href.contentEquals(MasterData.repo.get(1));
			actions.moveToElement(element).perform();
			actions.click().perform();
			yakshaAssert(currentTest(), status, businessTestFile);
		}catch(Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
		}
	}

	@Test 
	@Order(3)
	public void testGetHomeLoanEMICalculator() throws IOException{
		boolean status = false;
		try {
			WebElement element = Helpers.getElementforHomeLoan(driver);
			String href = getHrefOfLink(element);
			status = href.contentEquals(MasterData.repo.get(2));
			WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Home Loan')]"))));
			((JavascriptExecutor)driver).executeScript("arguments[0].click();",element);
			yakshaAssert(currentTest(), status, businessTestFile);
		}catch(Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
		}
	}

	
	@Test 
	@Order(4)
	public void testAccessLoanAmount() throws IOException{
		boolean status = false;
		try {
			WebElement element = Helpers.getElementforLoanAmount(driver);
			String href = getHrefOfLink(element);
			status = href.contentEquals(MasterData.repo.get(3));
			yakshaAssert(currentTest(), status, businessTestFile);
		}catch(Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
		}
	}
	
	@Test 
	@Order(5)
	public void testSetValueForLoanAmount() throws IOException{
		boolean status = false;
		try {
			status = SubActivities.enterValueLoanAmount(driver);
			yakshaAssert(currentTest(), status, businessTestFile);
		}catch(Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
		}
	}
	
	@Test 
	@Order(6)
	public void testAccessLoanPeriod() throws IOException{
		boolean status = false;
		try {
			WebElement element = Helpers.getElementforLoanPeriod(driver);
			String href = getHrefOfLink(element);
			status = href.contentEquals(MasterData.repo.get(4));
			yakshaAssert(currentTest(), status, businessTestFile);
		}catch(Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
		}
	}
	
	@Test 
	@Order(7)
	public void testSetValueForLoanPeriod() throws IOException{
		boolean status = false;
		try {
			status = SubActivities.enterValueLoanPeriod(driver);
			yakshaAssert(currentTest(), status, businessTestFile);
		}catch(Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
		}
	}
	
	
	/*@Test 
	@Order(8)
	public void testAccessEMIStartFrom() throws IOException{
		boolean status = false;
		try {
			WebElement element = Helpers.getElementforEMIStart(driver);
			String href = getHrefOfLink(element);
			System.out.println("EMI DB: " + MasterData.repo.get(5));
			System.out.println("EMI Ac: " + href);
			status = href.contentEquals(MasterData.repo.get(5));
			yakshaAssert(currentTest(), status, businessTestFile);
		}catch(Exception ex) {
			System.out.println("Exception : " + ex);
			yakshaAssert(currentTest(), false, businessTestFile);
		}
	}*/
	
	@Test 
	@Order(9)
	public void testSetValueForEMIStartFrom() throws IOException{
		boolean status = false;
		try {
			status = SubActivities.selectEMIStartsFrom(driver);
			yakshaAssert(currentTest(), status, businessTestFile);
		}catch(Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
		}
	}

	@Test 
	@Order(10)
	public void testAccessInterestRate() throws IOException{
		boolean status = false;
		try {
			WebElement element = Helpers.getElementforInterestRate(driver);
			String href = getHrefOfLink(element);
			status = href.contentEquals(MasterData.repo.get(6));
			yakshaAssert(currentTest(), status, businessTestFile);
		}catch(Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
		}
	}
	
	@Test 
	@Order(11)
	public void testSetValueForInterestRate() throws IOException{
		boolean status = false;
		try {
			status = SubActivities.enterInterestRate(driver);
			yakshaAssert(currentTest(), status, businessTestFile);
		}catch(Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
		}
	}
	
	
	@Test 
	@Order(12)
	public void testAccessUpFrontCharges() throws IOException{
		boolean status = false;
		try {
			WebElement element = Helpers.getElementforUpfrontcharges(driver);
			String href = getHrefOfLink(element);
			status = href.contentEquals(MasterData.repo.get(7));
			yakshaAssert(currentTest(), status, businessTestFile);
		}catch(Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
		}
	}
	
	@Test 
	@Order(13)
	public void testSetValueForUpfrontCharges() throws IOException{
		boolean status = false;
		try {
			status = SubActivities.enterValueUpfrontCharges(driver);
			yakshaAssert(currentTest(), status, businessTestFile);
		}catch(Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
		}
	}
	
	@Test 
	@Order(14)
	public void testGetTotalPaymentElement() throws IOException{
		boolean status = false;
		try {
			WebElement element = SubActivities.getTotalPaymentElement(driver);
			if(element !=null)
				yakshaAssert(currentTest(), true, businessTestFile);
			else
				yakshaAssert(currentTest(), false, businessTestFile);
		}catch(Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
		}
	}
	
	@Test 
	@Order(15)
	public void testGetXpathfor7thYearEMIPayment() throws IOException {
		boolean status = Helpers.getXpathfor7thYearEMIPayment().contains("sibling");
		yakshaAssert(currentTest(), status, businessTestFile);
		
	}
	
	@Test 
	@Order(16)
	public void testGetXpathfor7thYearInterestPayment() throws IOException {
		boolean status = Helpers.getXpathfor7thYearInterestPayment().contains("sibling");
		yakshaAssert(currentTest(), status, businessTestFile);
	}
	
	@Test 
	@Order(17)
	public void testGetXpathfor7thYearPrincipalPayment() throws IOException {
		boolean status = Helpers.getXpathfor7thYearPrincipalPayment().contains("sibling");
		yakshaAssert(currentTest(), status, businessTestFile);
	}
	
	@Test 
	@Order(18)
	public void testGetXpathfor5thYearOutstandingPrincipalPayment() throws IOException {
		boolean status = Helpers.getXpathfor5thYearOutstandingPrincipalPayment().contains("sibling");
		yakshaAssert(currentTest(), status, businessTestFile);
	}
	
	
	/*@Test 
	@Order(1)
	public void testNavigateToHomeLoanEMI() throws IOException{
		try {
				String baseUrl = "https://www.moneycontrol.com/"; 
				driver.get(baseUrl);
				if(!SubActivities.mouseOverPersonalFinance(driver, baseUrl)) {
					yakshaAssert(currentTest(), false, businessTestFile);
					return;
				}
			}catch(Exception ex) {
				yakshaAssert(currentTest(), false, businessTestFile);
				return;
			}
		yakshaAssert(currentTest(), true, businessTestFile);
	}
	
	@Test 
	@Order(2)
	public void testCalculateHomeLoanEMI() throws IOException
	{

		if(!SubActivities.enterValueLoanAmount(driver)) {
			yakshaAssert(currentTest(), false, businessTestFile);
			return;
		}
		if(!SubActivities.selectEMIStartsFrom(driver)) {
			yakshaAssert(currentTest(), false, businessTestFile);
			return;
		}
		if(!SubActivities.enterInterestRate(driver)) {
			yakshaAssert(currentTest(), false, businessTestFile);
			return;
		}
		if(!SubActivities.enterValueLoanPeriod(driver)){
			yakshaAssert(currentTest(), false, businessTestFile);
			return;
		}
		if(!SubActivities.enterValueUpfrontCharges(driver)) {
			yakshaAssert(currentTest(), false, businessTestFile);
			return;
		}
		if(!SubActivities.clickSubmit(driver)) {
			yakshaAssert(currentTest(), false, businessTestFile);
			return;
		}
		
		yakshaAssert(currentTest(), true, businessTestFile);
	}
	
	@Test 
	@Order(3)
	public void testGetTotalPayment() throws Exception{
		try {
			Activities activities = new Activities();
			String payment = activities.getTotalPayment(driver);
			if(payment.contentEquals("")) {
				yakshaAssert(currentTest(), false, businessTestFile);
				return;
			}
		}catch(Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			return;
		}
		yakshaAssert(currentTest(), true, businessTestFile);
	}
	
	@Test 
	@Order(4)
	public void testGetEMI() throws Exception{
		try {
			Activities activities = new Activities();
			String payment = activities.getEMI(driver);
			if(payment.contentEquals("")) {
				yakshaAssert(currentTest(), false, businessTestFile);
				return;
			}
		}catch(Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			return;
		}
		yakshaAssert(currentTest(), true, businessTestFile);
	}
	
	@Test 
	@Order(5)
	public void testGetTableDetails7thYearEMIPaymentInTheYear() throws Exception{
		try {
			Activities activities = new Activities();
			String payment = activities.getTableDetails7thYearEMIPaymentInTheYear(driver);
			if(payment.contentEquals("")) {
				yakshaAssert(currentTest(), false, businessTestFile);
				return;
			}
		}catch(Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			return;
		}
		yakshaAssert(currentTest(), true, businessTestFile);
	}
	
	
	@Test 
	@Order(6)
	public void testGetTableDetails7thYearInterestPaymentInTheYear() throws IOException{
		try {
			Activities activities = new Activities();
			String payment = activities.getTableDetails7thYearInterestPaymentInTheYear(driver);
			if(payment.contentEquals("")) {
				yakshaAssert(currentTest(), false, businessTestFile);
				return;
			}
		}catch(Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			return;
		}
		yakshaAssert(currentTest(), true, businessTestFile);
	}
	
	@Test 
	@Order(7)
	public void testGetTableDetails7thYearPrincipalPaymentInTheYear() throws IOException{
		try {
			Activities activities = new Activities();
			String payment = activities.getTableDetails7thYearPrincipalPaymentInTheYear(driver);
			if(payment.contentEquals("")) {
				yakshaAssert(currentTest(), false, businessTestFile);
				return;
			}
		}catch(Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			return;
		}
		yakshaAssert(currentTest(), true, businessTestFile);
	}
	
	@Test 
	@Order(8)
	public void testGetTableDetails5thYearOutstandingPrincipalAtTheEndOfYear() throws IOException{
		try {
			Activities activities = new Activities();
			String payment = activities.getTableDetails5thYearOutstandingPrincipalAtTheEndOfYear(driver);
			if(payment.contentEquals("")) {
				yakshaAssert(currentTest(), false, businessTestFile);
				return;
			}
		}catch(Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			return;
		}
		yakshaAssert(currentTest(), true, businessTestFile);
	}*/
	
	  @AfterAll
	  public static void cleanUp() {
			driver.quit();
	  } 	 
}

