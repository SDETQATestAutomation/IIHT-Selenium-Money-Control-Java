package com.iiht.evaluation.survey.functional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.iiht.evaluation.survey.automation.Activities;
import com.iiht.evaluation.survey.automation.Helpers;
import com.iiht.evaluation.survey.automation.SubActivities;

public class AutomationTest {

	

	public void testValidFormDataWithValidFeedbackRatingAndValidAnswers() {
		// navigate to website
		Activities.navigateToWebsite("http://www.example.com");

		// select survey form
		SubActivities.selectSurveyFormWithRetry();
		

		// populate survey form with valid data
		SubActivities.populateSurveyFormWithRetry("John Smith", "Jane Doe", "2020-12-15", "12345");

		// assign feedback rating
		SubActivities.assignFeedbackRatingWithRetry();

		// complete survey questions with valid answers
		SubActivities.completeSurveyQuestionsWithRetry();

		// submit form
		SubActivities.submitFormWithRetry();

		// verify submission success
		Assert.assertTrue("Submission was not successful", Activities.isSubmissionSuccessful());
	}

	public void testValidFormDataWithValidFeedbackRatingAndEmptyAnswers() {
		// navigate to website
		Activities.navigateToWebsite("http://www.example.com");

		// select survey form
		SubActivities.selectSurveyFormWithRetry();

		// populate survey form with valid data
		SubActivities.populateSurveyFormWithRetry("John Smith", "Jane Doe", "2020-12-15", "12345");
		// assign feedback rating
		SubActivities.assignFeedbackRatingWithRetry();

		// complete survey questions with empty answers
		SubActivities.completeSurveyQuestionsWithRetry();

		// submit form
		SubActivities.submitFormWithRetry();

		// verify submission success
		Assert.assertTrue("Submission was not successful", Activities.isSubmissionSuccessful());
	}

	public void testValidFormDataWithValidFeedbackRatingAndInvalidAnswers() {
		// navigate to website
		Activities.navigateToWebsite("http://www.example.com");

		// select survey form
		SubActivities.selectSurveyFormWithRetry();

		// populate survey form with valid data
		SubActivities.populateSurveyFormWithRetry("John Smith", "Jane Doe", "2020-12-15", "12345");

		// assign feedback rating
		SubActivities.assignFeedbackRatingWithRetry();

		// complete survey questions with invalid answers
		SubActivities.completeSurveyQuestionsWithRetry();
		SubActivities.submitFormWithRetry();

		// verify error messages are displayed for each invalid answer
		Assert.assertTrue("Error message not displayed for invalid answer to question 1",
				Helpers.driver.getPageSource().contains("Please enter a valid answer."));
		Assert.assertTrue("Error message not displayed for invalid answer to question 2",
				Helpers.driver.getPageSource().contains("Please enter a valid answer."));
		Assert.assertTrue("Error message not displayed for invalid answer to question 3",
				Helpers.driver.getPageSource().contains("Please enter a valid answer."));
	}

	public void testValidFormDataWithEmptyFeedbackRatingAndValidAnswers() {
		// navigate to website
		Activities.navigateToWebsite("http://www.example.com");

		// select survey form
		SubActivities.selectSurveyFormWithRetry();

		// populate survey form with valid data
		SubActivities.populateSurveyFormWithRetry("John Smith", "Jane Doe", "2020-12-15", "12345");

		// assign empty feedback rating
		WebElement ratingField = Activities.driver.findElement(By.id("feedback-rating"));
		ratingField.sendKeys(Keys.BACK_SPACE);
		ratingField.sendKeys(Keys.BACK_SPACE);
		ratingField.sendKeys(Keys.BACK_SPACE);
		Actions action = new Actions(Activities.driver);
		action.sendKeys(ratingField, " ").build().perform();

		// complete survey questions with valid answers
		SubActivities.completeSurveyQuestionsWithRetry();

		// submit form
		SubActivities.submitFormWithRetry();

		// verify error message is displayed for empty feedback rating
		Assert.assertTrue("Error message not displayed for empty feedback rating",
				Helpers.driver.getPageSource().contains("Please enter a feedback rating."));
	}

	

	@Test
	@Order(1)
	public void testValidURL() {
		// navigate to website
		Activities.navigateToWebsite("http://www.example.com");

		// verify the correct page is displayed
		Assert.assertTrue("Incorrect page title displayed for valid URL",
				Helpers.driver.getTitle().contains("Example Domain"));
	}

	@Test
	@Order(2)
	public void testInvalidURL() {
		// navigate to invalid website
		Activities.navigateToWebsite("http://www.invalidwebsite.com");

		// verify error message is displayed
		Assert.assertTrue("Error message not displayed for invalid URL",
				Helpers.driver.getPageSource().contains("Unable to connect"));
	}

	@Test
	@Order(3)
	public void testValidFormData_happypath() {
		// navigate to website
		Activities.navigateToWebsite("http://www.example.com");

		// select survey form
		SubActivities.selectSurveyFormWithRetry();

		// populate survey form with valid data
		SubActivities.populateSurveyFormWithRetry("John Smith", "Jane Doe", "2020-12-15", "12345");

		// assign feedback rating
		SubActivities.assignFeedbackRatingWithRetry();

		// complete survey questions
		SubActivities.completeSurveyQuestionsWithRetry();

		// submit form
		SubActivities.submitFormWithRetry();

		// verify submission success
		Assert.assertTrue("Submission was not successful", Activities.isSubmissionSuccessful());
	}

	@Test
	@Order(4)
	public void testEmptyFormData() {
		// navigate to website
		Activities.navigateToWebsite("http://www.example.com");

		// select survey form
		SubActivities.selectSurveyFormWithRetry();

		// populate survey form with empty data
		SubActivities.populateSurveyFormWithRetry("", "", "", "");

		// assign feedback rating
		SubActivities.assignFeedbackRatingWithRetry();

		// complete survey questions
		SubActivities.completeSurveyQuestionsWithRetry();

		// submit form
		SubActivities.submitFormWithRetry();

		// verify error messages are displayed for each empty field
		Assert.assertTrue("Error message not displayed for empty customer name field",
				Helpers.driver.getPageSource().contains("Please enter a valid customer name."));
		Assert.assertTrue("Error message not displayed for empty agent name field",
				Helpers.driver.getPageSource().contains("Please enter a valid agent name."));
		Assert.assertTrue("Error message not displayed for empty date field",
				Helpers.driver.getPageSource().contains("Please enter a valid date in the format yyyy-mm-dd."));
		Assert.assertTrue("Error message not displayed for empty case number field",
				Helpers.driver.getPageSource().contains("Please enter a valid case number."));
	}

	@Test
	@Order(5)
	public void testInvalidFieldData() {
		// navigate to website
		Activities.navigateToWebsite("http://www.example.com");

		// select survey form
		SubActivities.selectSurveyFormWithRetry();

		// populate survey form with invalid data
		SubActivities.populateSurveyFormWithRetry("1John Smith", "2Jane Doe", "2020-15-15", "abcde");

		// verify error messages are displayed for each invalid field
		Assert.assertTrue("Error message not displayed for invalid customer name field",
				Helpers.driver.getPageSource().contains("Please enter a valid customer name."));
		Assert.assertTrue("Error message not displayed for invalid agent name field",
				Helpers.driver.getPageSource().contains("Please enter a valid agent name."));
		Assert.assertTrue("Error message not displayed for invalid date format",
				Helpers.driver.getPageSource().contains("Please enter a valid date in the format yyyy-mm-dd."));
		Assert.assertTrue("Error message not displayed for invalid case number",
				Helpers.driver.getPageSource().contains("Please enter a valid case number."));
	}

	@Test
	@Order(6)
	public void testBoundaryValueAnalysis() {
		// navigate to website
		Activities.navigateToWebsite("http://www.example.com");

		// select survey form
		SubActivities.selectSurveyFormWithRetry();

		// populate survey form with boundary values
		SubActivities.populateSurveyFormWithRetry("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwx",
				"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwx", "2022-12-31", "9999999999");

		// assign feedback rating
		SubActivities.assignFeedbackRatingWithRetry();

		// complete survey questions
		SubActivities.completeSurveyQuestionsWithRetry();

		// submit form
		SubActivities.submitFormWithRetry();

		// verify submission success
		Assert.assertTrue("Submission was not successful", Activities.isSubmissionSuccessful());
	}

	@Test
	@Order(7)
	public void testValidFormData() {
		testValidFormDataWithValidFeedbackRatingAndValidAnswers();
		testValidFormDataWithValidFeedbackRatingAndEmptyAnswers();
		testValidFormDataWithValidFeedbackRatingAndInvalidAnswers();
		testValidFormDataWithEmptyFeedbackRatingAndValidAnswers();
	}

}
