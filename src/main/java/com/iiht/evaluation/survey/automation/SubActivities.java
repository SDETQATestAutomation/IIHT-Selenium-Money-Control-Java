package com.iiht.evaluation.survey.automation;

import org.openqa.selenium.WebDriver;

public class SubActivities extends Activities {

	public SubActivities(WebDriver driver) {
		super(driver);
	}

	public static void selectSurveyFormWithRetry() {
		int maxTries = 3;
		int currentTry = 0;

		while (currentTry < maxTries) {
			try {
				selectSurveyForm();
				return;
			} catch (Exception e) {
				System.out.println("Error selecting survey form, trying again...");
				currentTry++;
			}
		}

		System.out.println("Unable to select survey form after " + maxTries + " attempts.");
	}

	public static void populateSurveyFormWithRetry(String customerName, String agentName, String date, String caseNumber) {
		int maxTries = 3;
		int currentTry = 0;

		while (currentTry < maxTries) {
			try {
				populateSurveyForm(customerName, agentName, date, caseNumber);
				return;
			} catch (Exception e) {
				System.out.println("Error populating survey form, trying again...");
				currentTry++;
			}
		}

		System.out.println("Unable to populate survey form after " + maxTries + " attempts.");
	}

	public static void assignFeedbackRatingWithRetry() {
		int maxTries = 3;
		int currentTry = 0;

		while (currentTry < maxTries) {
			try {
				assignFeedbackRating();
				return;
			} catch (Exception e) {
				System.out.println("Error assigning feedback rating, trying again...");
				currentTry++;
			}
		}

		System.out.println("Unable to assign feedback rating after " + maxTries + " attempts.");
	}
	
	public static void completeSurveyQuestionsWithRetry() {
        int maxTries = 3;
        int currentTry = 0;

        while (currentTry < maxTries) {
            try {
                completeSurveyQuestions();
                return;
            } catch (Exception e) {
                System.out.println("Error completing survey questions, trying again...");
                currentTry++;
            }
        }

        System.out.println("Unable to complete survey questions after " + maxTries + " attempts.");
    }
	
	public static void submitFormWithRetry() {
        int maxTries = 3;
        int currentTry = 0;

        while (currentTry < maxTries) {
            try {
                submitForm();
                return;
            } catch (Exception e) {
                System.out.println("Error submitting form, trying again...");
                currentTry++;
            }
        }

        System.out.println("Unable to submit form after " + maxTries + " attempts.");
    }
	
	
}
	
	

