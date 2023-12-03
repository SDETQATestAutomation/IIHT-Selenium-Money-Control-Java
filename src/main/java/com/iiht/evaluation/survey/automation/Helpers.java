package com.iiht.evaluation.survey.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Helpers {
	public static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void initializeDriver() {
		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public static void closeDriver() {
		driver.quit();
	}
}
