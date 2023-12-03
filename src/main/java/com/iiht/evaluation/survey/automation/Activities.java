package com.iiht.evaluation.survey.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Activities {
	public static WebDriver driver;

	public Activities(WebDriver driver) {
		Activities.driver = driver;
	}

	public static void navigateToWebsite(String url) {
		driver.get(url);
	}

	public static void selectSurveyForm() {
		WebElement surveyLink = driver.findElement(By.linkText("Customer Feedback Survey"));
		surveyLink.click();
	}
	
	public static void populateSurveyForm(String customerName, String agentName, String date, String caseNumber) {
        WebElement customerNameField = driver.findElement(By.id("customer-name"));
        customerNameField.sendKeys(customerName);
        WebElement agentNameField = driver.findElement(By.id("agent-name"));
        agentNameField.sendKeys(agentName);
        WebElement dateField = driver.findElement(By.id("date"));
        dateField.sendKeys(date);
        WebElement caseNumberField = driver.findElement(By.id("case-number"));
        caseNumberField.sendKeys(caseNumber);
    }
	
	public static void assignFeedbackRating() {
        WebElement ratingField = driver.findElement(By.id("feedback-rating"));
        ratingField.sendKeys("5");
    }
	
	public static void completeSurveyQuestions() {
        WebElement question1Field = driver.findElement(By.id("question1"));
        question1Field.sendKeys("Answer 1");

        WebElement question2Field = driver.findElement(By.id("question2"));
        question2Field.sendKeys("Answer 2");

        WebElement question3Field = driver.findElement(By.id("question3"));
        question3Field.sendKeys("Answer 3");
    }
	
	public static void submitForm() {
        WebElement submitButton = driver.findElement(By.id("submit-button"));
        submitButton.click();
    }
	
	public static boolean isSubmissionSuccessful() {
        WebElement successMessage = driver.findElement(By.className("success-message"));
        return successMessage.isDisplayed();
    }
	
	
	
	
}
