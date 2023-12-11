package com.iiht.evaluation.automation.functional;


import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.time.Duration;

import com.iiht.evaluation.automation.Activities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import com.iiht.evaluation.automation.SubActivities;
import org.testng.annotations.*;


public class TestAutomation {
	public static WebDriver driver = null;

	@BeforeMethod
	public static void setup() {
		System.out.println("\nBefore method setup");
		String req_chrome_driver_path = System.getProperty("user.dir") + "/binaries/chromedriver.exe";
		System.out.println(req_chrome_driver_path);
		String base_url = "https://www.moneycontrol.com/";

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--ignore-ssl-errors=yes");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--allow-cross-origin-auth-prompt");
		options.addArguments("--allow-control-allow-origin");
		options.addArguments("-–allow-file-access-from-files");
		options.addArguments("--test-type");
		options.addArguments("disable-infobars");
		options.addArguments("--disable-extensions");
		options.addArguments("--start-maximized");
		options.addArguments("--lang=en");
		options.addArguments("--no-sandbox");
		options.addArguments("disable-popup-blocking");
		options.addArguments("--remote-allow-origins=*");
		options.setExperimentalOption("debuggerAddress", "127.0.0.1:9223");

		Map<String, Object> loggingPrefs = new HashMap<>();
		loggingPrefs.put("driver", "INFO");
		loggingPrefs.put("server", "OFF");
		loggingPrefs.put("browser", "INFO");
		options.setCapability("goog:loggingPrefs", loggingPrefs);
		options.setCapability("acceptInsecureCerts", true);

		ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(new File(req_chrome_driver_path)).build();
		driver = new ChromeDriver(service, options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		driver.get(base_url);
		SubActivities.check_page_load_complete(driver);
	}

	@AfterMethod
	public static void teardown() {
		driver.quit();
	}


	@Test
	public static void test_success_login() {
		boolean testcase_status = true;
		String email = "prashant.ranjan.qa@gmail.com";
		String password = "igetup@7AM";
		try {
			boolean open_login_panel_succeed = Activities.open_login_panel(driver);
			System.out.println("open_login_panel_succeed " + open_login_panel_succeed);
			if (!open_login_panel_succeed) {
				testcase_status = false;
			}
			if (testcase_status) {
				boolean open_signin_box_succeed = Activities.open_signin_box(driver);
				System.out.println("open_signin_box_succeed " + open_signin_box_succeed);
				if (!open_signin_box_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean signin_box_enter_email_succeed = Activities.signin_box_enter_email(driver, email);
				System.out.println("signin_box_enter_email_succeed " + signin_box_enter_email_succeed);
				if (!signin_box_enter_email_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean signin_box_enter_password_succeed = Activities.signin_box_enter_password(driver, password);
				System.out.println("signin_box_enter_password_succeed " + signin_box_enter_password_succeed);
				if (!signin_box_enter_password_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean signin_box_click_login_button_succeed = Activities.signin_box_click_login_button(driver);
				System.out.println("signin_box_click_login_button_succeed " + signin_box_click_login_button_succeed);
				if (!signin_box_click_login_button_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean check_logged_in_user_succeed = Activities.check_logged_in_user(driver, email);
				System.out.println("check_logged_in_user_succeed " + check_logged_in_user_succeed);
				if (!check_logged_in_user_succeed) {
					testcase_status = false;
				}
			}
			System.out.println("testcase_status " + testcase_status);

		} catch (Exception ex) {
			System.out.println("ex " + ex);
		}
	}

}

