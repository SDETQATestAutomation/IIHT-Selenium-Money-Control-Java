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


	@Test
	public static void test_failure_login() {
		boolean testcase_status = true;
		String email="prashant.ranjan.qa@gmail.commmmm";
		String password="igetup@7AMmmmmmm";
		String error_message="Invalid User Id/EmailID or Password. Please try again.";
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
				boolean signin_box_click_login_button_except_error_succeed = Activities.signin_box_click_login_button_except_error(driver);
				System.out.println("signin_box_click_login_button_except_error_succeed " + signin_box_click_login_button_except_error_succeed);
				if (!signin_box_click_login_button_except_error_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean signin_box_check_error_succeed = Activities.signin_box_check_error(driver, error_message);
				System.out.println("signin_box_check_error_succeed " + signin_box_check_error_succeed);
				if (!signin_box_check_error_succeed) {
					testcase_status = false;
				}
			}
			System.out.println("testcase_status " + testcase_status);
		} catch (Exception ex) {
			System.out.println("ex " + ex);
		}
	}

	@Test
	public void test_fixed_deposit_calculator_interest_frequency_monthly() {
		boolean testcase_status = true;
		String investment_amount="2000000";
		String investment_period="14";
		String rate_of_return="12";
		String interest_frequency="Monthly";
		String tax_rate="15";
		String total_payment="2,000,000.00";
		String total_interest="8,641,939.64";
		String total_corpus="10,641,939.64";
		String post_tax_amount="9,293,797.05";
		try {
			boolean select_submenu_from_menu_succeed = Activities.select_submenu_from_menu(driver, "Personal Finance",
					"Fixed Deposit Interest Calculator");
			System.out.println("select_submenu_from_menu_succeed " + select_submenu_from_menu_succeed);
			if (!select_submenu_from_menu_succeed) {
				testcase_status = false;
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_enter_investment_amount_succeed = Activities.fixed_deposit_calculator_enter_investment_amount(
						driver, investment_amount);
				System.out.println("fixed_deposit_calculator_enter_investment_amount_succeed " + fixed_deposit_calculator_enter_investment_amount_succeed);
				if (!fixed_deposit_calculator_enter_investment_amount_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_enter_investment_period_succeed = Activities.fixed_deposit_calculator_enter_investment_period(
						driver, investment_period);
				System.out.println("fixed_deposit_calculator_enter_investment_period_succeed " + fixed_deposit_calculator_enter_investment_period_succeed);
				if (!fixed_deposit_calculator_enter_investment_period_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_enter_rate_of_return_succeed = Activities.fixed_deposit_calculator_enter_rate_of_return(
						driver, rate_of_return);
				System.out.println("fixed_deposit_calculator_enter_rate_of_return_succeed " + fixed_deposit_calculator_enter_rate_of_return_succeed);
				if (!fixed_deposit_calculator_enter_rate_of_return_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_select_interest_frequency_succeed = Activities.fixed_deposit_calculator_select_interest_frequency(
						driver, interest_frequency);
				System.out.println("fixed_deposit_calculator_select_interest_frequency_succeed " + fixed_deposit_calculator_select_interest_frequency_succeed);
				if (!fixed_deposit_calculator_select_interest_frequency_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_enter_tax_rate_succeed = Activities.fixed_deposit_calculator_enter_tax_rate(driver,
						tax_rate);
				System.out.println("fixed_deposit_calculator_enter_tax_rate_succeed " + fixed_deposit_calculator_enter_tax_rate_succeed);
				if (!fixed_deposit_calculator_enter_tax_rate_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_click_submit_button_succeed = Activities.fixed_deposit_calculator_click_submit_button(
						driver);
				System.out.println("fixed_deposit_calculator_click_submit_button_succeed " + fixed_deposit_calculator_click_submit_button_succeed);
				if (!fixed_deposit_calculator_click_submit_button_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_check_total_payment_succeed = Activities.fixed_deposit_calculator_check_total_payment(
						driver, total_payment);
				System.out.println("fixed_deposit_calculator_check_total_payment_succeed " + fixed_deposit_calculator_check_total_payment_succeed);
				if (!fixed_deposit_calculator_check_total_payment_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_check_total_interest_succeed = Activities.fixed_deposit_calculator_check_total_interest(
						driver, total_interest);
				System.out.println("fixed_deposit_calculator_check_total_interest_succeed " + fixed_deposit_calculator_check_total_interest_succeed);
				if (!fixed_deposit_calculator_check_total_interest_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_check_total_corpus_succeed = Activities.fixed_deposit_calculator_check_total_corpus(
						driver, total_corpus);
				System.out.println("fixed_deposit_calculator_check_total_corpus_succeed " + fixed_deposit_calculator_check_total_corpus_succeed);
				if (!fixed_deposit_calculator_check_total_corpus_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_check_post_tax_amount_succeed = Activities.fixed_deposit_calculator_check_post_tax_amount(
						driver, post_tax_amount);
				System.out.println("fixed_deposit_calculator_check_post_tax_amount_succeed " + fixed_deposit_calculator_check_post_tax_amount_succeed);
				if (!fixed_deposit_calculator_check_post_tax_amount_succeed) {
					testcase_status = false;
				}
			}
			System.out.println("testcase_status " + testcase_status);
		} catch (Exception ex) {
			System.out.println("ex " + ex);
		}
	}

	@Test
	public void test_fixed_deposit_calculator_interest_frequency_quaterly() {
		boolean testcase_status = true;
		String investment_amount="2000000";
		String investment_period="14";
		String rate_of_return="12";
		String interest_frequency="Quaterly";
		String tax_rate="15";
		String total_payment="2,000,000.00";
		String total_interest="8,223,373.39";
		String total_corpus="10,469,226.10";
		String post_tax_amount="9,148,026.83";
		try {
			boolean select_submenu_from_menu_succeed = Activities.select_submenu_from_menu(driver, "Personal Finance",
					"Fixed Deposit Interest Calculator");
			System.out.println("select_submenu_from_menu_succeed " + select_submenu_from_menu_succeed);
			if (!select_submenu_from_menu_succeed) {
				testcase_status = false;
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_enter_investment_amount_succeed = Activities.fixed_deposit_calculator_enter_investment_amount(
						driver, investment_amount);
				System.out.println("fixed_deposit_calculator_enter_investment_amount_succeed " + fixed_deposit_calculator_enter_investment_amount_succeed);
				if (!fixed_deposit_calculator_enter_investment_amount_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_enter_investment_period_succeed = Activities.fixed_deposit_calculator_enter_investment_period(
						driver, investment_period);
				System.out.println("fixed_deposit_calculator_enter_investment_period_succeed " + fixed_deposit_calculator_enter_investment_period_succeed);
				if (!fixed_deposit_calculator_enter_investment_period_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_enter_rate_of_return_succeed = Activities.fixed_deposit_calculator_enter_rate_of_return(
						driver, rate_of_return);
				System.out.println("fixed_deposit_calculator_enter_rate_of_return_succeed " + fixed_deposit_calculator_enter_rate_of_return_succeed);
				if (!fixed_deposit_calculator_enter_rate_of_return_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_select_interest_frequency_succeed = Activities.fixed_deposit_calculator_select_interest_frequency(
						driver, interest_frequency);
				System.out.println("fixed_deposit_calculator_select_interest_frequency_succeed " + fixed_deposit_calculator_select_interest_frequency_succeed);
				if (!fixed_deposit_calculator_select_interest_frequency_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_enter_tax_rate_succeed = Activities.fixed_deposit_calculator_enter_tax_rate(driver,
						tax_rate);
				System.out.println("fixed_deposit_calculator_enter_tax_rate_succeed " + fixed_deposit_calculator_enter_tax_rate_succeed);
				if (!fixed_deposit_calculator_enter_tax_rate_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_click_submit_button_succeed = Activities.fixed_deposit_calculator_click_submit_button(
						driver);
				System.out.println("fixed_deposit_calculator_click_submit_button_succeed " + fixed_deposit_calculator_click_submit_button_succeed);
				if (!fixed_deposit_calculator_click_submit_button_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_check_total_payment_succeed = Activities.fixed_deposit_calculator_check_total_payment(
						driver, total_payment);
				System.out.println("fixed_deposit_calculator_check_total_payment_succeed " + fixed_deposit_calculator_check_total_payment_succeed);
				if (!fixed_deposit_calculator_check_total_payment_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_check_total_interest_succeed = Activities.fixed_deposit_calculator_check_total_interest(
						driver, total_interest);
				System.out.println("fixed_deposit_calculator_check_total_interest_succeed " + fixed_deposit_calculator_check_total_interest_succeed);
				if (!fixed_deposit_calculator_check_total_interest_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_check_total_corpus_succeed = Activities.fixed_deposit_calculator_check_total_corpus(
						driver, total_corpus);
				System.out.println("fixed_deposit_calculator_check_total_corpus_succeed " + fixed_deposit_calculator_check_total_corpus_succeed);
				if (!fixed_deposit_calculator_check_total_corpus_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_check_post_tax_amount_succeed = Activities.fixed_deposit_calculator_check_post_tax_amount(
						driver, post_tax_amount);
				System.out.println("fixed_deposit_calculator_check_post_tax_amount_succeed " + fixed_deposit_calculator_check_post_tax_amount_succeed);
				if (!fixed_deposit_calculator_check_post_tax_amount_succeed) {
					testcase_status = false;
				}
			}
			System.out.println("testcase_status " + testcase_status);
		} catch (Exception ex) {
			System.out.println("ex " + ex);
		}
	}

	@Test
	public void test_fixed_deposit_calculator_interest_frequency_half_yearly() {
		boolean testcase_status = true;
		String investment_amount="2000000";
		String investment_period="14";
		String rate_of_return="12";
		String interest_frequency="Half Yearly";
		String tax_rate="15";
		String total_payment="2,000,000.00";
		String total_interest="8,223,373.39";
		String total_corpus="10,223,373.39";
		String post_tax_amount="8,940,527.14";
		try {
			boolean select_submenu_from_menu_succeed = Activities.select_submenu_from_menu(driver, "Personal Finance",
					"Fixed Deposit Interest Calculator");
			System.out.println("select_submenu_from_menu_succeed " + select_submenu_from_menu_succeed);
			if (!select_submenu_from_menu_succeed) {
				testcase_status = false;
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_enter_investment_amount_succeed = Activities.fixed_deposit_calculator_enter_investment_amount(
						driver, investment_amount);
				System.out.println("fixed_deposit_calculator_enter_investment_amount_succeed " + fixed_deposit_calculator_enter_investment_amount_succeed);
				if (!fixed_deposit_calculator_enter_investment_amount_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_enter_investment_period_succeed = Activities.fixed_deposit_calculator_enter_investment_period(
						driver, investment_period);
				System.out.println("fixed_deposit_calculator_enter_investment_period_succeed " + fixed_deposit_calculator_enter_investment_period_succeed);
				if (!fixed_deposit_calculator_enter_investment_period_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_enter_rate_of_return_succeed = Activities.fixed_deposit_calculator_enter_rate_of_return(
						driver, rate_of_return);
				System.out.println("fixed_deposit_calculator_enter_rate_of_return_succeed " + fixed_deposit_calculator_enter_rate_of_return_succeed);
				if (!fixed_deposit_calculator_enter_rate_of_return_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_select_interest_frequency_succeed = Activities.fixed_deposit_calculator_select_interest_frequency(
						driver, interest_frequency);
				System.out.println("fixed_deposit_calculator_select_interest_frequency_succeed " + fixed_deposit_calculator_select_interest_frequency_succeed);
				if (!fixed_deposit_calculator_select_interest_frequency_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_enter_tax_rate_succeed = Activities.fixed_deposit_calculator_enter_tax_rate(driver,
						tax_rate);
				System.out.println("fixed_deposit_calculator_enter_tax_rate_succeed " + fixed_deposit_calculator_enter_tax_rate_succeed);
				if (!fixed_deposit_calculator_enter_tax_rate_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_click_submit_button_succeed = Activities.fixed_deposit_calculator_click_submit_button(
						driver);
				System.out.println("fixed_deposit_calculator_click_submit_button_succeed " + fixed_deposit_calculator_click_submit_button_succeed);
				if (!fixed_deposit_calculator_click_submit_button_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_check_total_payment_succeed = Activities.fixed_deposit_calculator_check_total_payment(
						driver, total_payment);
				System.out.println("fixed_deposit_calculator_check_total_payment_succeed " + fixed_deposit_calculator_check_total_payment_succeed);
				if (!fixed_deposit_calculator_check_total_payment_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_check_total_interest_succeed = Activities.fixed_deposit_calculator_check_total_interest(
						driver, total_interest);
				System.out.println("fixed_deposit_calculator_check_total_interest_succeed " + fixed_deposit_calculator_check_total_interest_succeed);
				if (!fixed_deposit_calculator_check_total_interest_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_check_total_corpus_succeed = Activities.fixed_deposit_calculator_check_total_corpus(
						driver, total_corpus);
				System.out.println("fixed_deposit_calculator_check_total_corpus_succeed " + fixed_deposit_calculator_check_total_corpus_succeed);
				if (!fixed_deposit_calculator_check_total_corpus_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_check_post_tax_amount_succeed = Activities.fixed_deposit_calculator_check_post_tax_amount(
						driver, post_tax_amount);
				System.out.println("fixed_deposit_calculator_check_post_tax_amount_succeed " + fixed_deposit_calculator_check_post_tax_amount_succeed);
				if (!fixed_deposit_calculator_check_post_tax_amount_succeed) {
					testcase_status = false;
				}
			}
			System.out.println("testcase_status " + testcase_status);
		} catch (Exception ex) {
			System.out.println("ex " + ex);
		}
	}

	@Test
	public void test_fixed_deposit_calculator_interest_frequency_yearly() {
		boolean testcase_status = true;
		String investment_amount="2000000";
		String investment_period="14";
		String rate_of_return="12";
		String interest_frequency="Yearly";
		String tax_rate="15";
		String total_payment="2,000,000.00";
		String total_interest="7,774,224.57";
		String total_corpus="9,774,224.57";
		String post_tax_amount="8,561,445.54";
		try {
			boolean select_submenu_from_menu_succeed = Activities.select_submenu_from_menu(driver, "Personal Finance",
					"Fixed Deposit Interest Calculator");
			System.out.println("select_submenu_from_menu_succeed " + select_submenu_from_menu_succeed);
			if (!select_submenu_from_menu_succeed) {
				testcase_status = false;
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_enter_investment_amount_succeed = Activities.fixed_deposit_calculator_enter_investment_amount(
						driver, investment_amount);
				System.out.println("fixed_deposit_calculator_enter_investment_amount_succeed " + fixed_deposit_calculator_enter_investment_amount_succeed);
				if (!fixed_deposit_calculator_enter_investment_amount_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_enter_investment_period_succeed = Activities.fixed_deposit_calculator_enter_investment_period(
						driver, investment_period);
				System.out.println("fixed_deposit_calculator_enter_investment_period_succeed " + fixed_deposit_calculator_enter_investment_period_succeed);
				if (!fixed_deposit_calculator_enter_investment_period_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_enter_rate_of_return_succeed = Activities.fixed_deposit_calculator_enter_rate_of_return(
						driver, rate_of_return);
				System.out.println("fixed_deposit_calculator_enter_rate_of_return_succeed " + fixed_deposit_calculator_enter_rate_of_return_succeed);
				if (!fixed_deposit_calculator_enter_rate_of_return_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_select_interest_frequency_succeed = Activities.fixed_deposit_calculator_select_interest_frequency(
						driver, interest_frequency);
				System.out.println("fixed_deposit_calculator_select_interest_frequency_succeed " + fixed_deposit_calculator_select_interest_frequency_succeed);
				if (!fixed_deposit_calculator_select_interest_frequency_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_enter_tax_rate_succeed = Activities.fixed_deposit_calculator_enter_tax_rate(driver,
						tax_rate);
				System.out.println("fixed_deposit_calculator_enter_tax_rate_succeed " + fixed_deposit_calculator_enter_tax_rate_succeed);
				if (!fixed_deposit_calculator_enter_tax_rate_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_click_submit_button_succeed = Activities.fixed_deposit_calculator_click_submit_button(
						driver);
				System.out.println("fixed_deposit_calculator_click_submit_button_succeed " + fixed_deposit_calculator_click_submit_button_succeed);
				if (!fixed_deposit_calculator_click_submit_button_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_check_total_payment_succeed = Activities.fixed_deposit_calculator_check_total_payment(
						driver, total_payment);
				System.out.println("fixed_deposit_calculator_check_total_payment_succeed " + fixed_deposit_calculator_check_total_payment_succeed);
				if (!fixed_deposit_calculator_check_total_payment_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_check_total_interest_succeed = Activities.fixed_deposit_calculator_check_total_interest(
						driver, total_interest);
				System.out.println("fixed_deposit_calculator_check_total_interest_succeed " + fixed_deposit_calculator_check_total_interest_succeed);
				if (!fixed_deposit_calculator_check_total_interest_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_check_total_corpus_succeed = Activities.fixed_deposit_calculator_check_total_corpus(
						driver, total_corpus);
				System.out.println("fixed_deposit_calculator_check_total_corpus_succeed " + fixed_deposit_calculator_check_total_corpus_succeed);
				if (!fixed_deposit_calculator_check_total_corpus_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_check_post_tax_amount_succeed = Activities.fixed_deposit_calculator_check_post_tax_amount(
						driver, post_tax_amount);
				System.out.println("fixed_deposit_calculator_check_post_tax_amount_succeed " + fixed_deposit_calculator_check_post_tax_amount_succeed);
				if (!fixed_deposit_calculator_check_post_tax_amount_succeed) {
					testcase_status = false;
				}
			}
			System.out.println("testcase_status " + testcase_status);
		} catch (Exception ex) {
			System.out.println("ex " + ex);
		}
	}

	@Test
	public void test_fixed_deposit_calculator_reset() {
		boolean testcase_status = true;
		String investment_amount="2000000";
		String investment_period="14";
		String rate_of_return="12";
		String interest_frequency="Yearly";
		String tax_rate="15";
		String default_investment_amount="10000000";
		String default_investment_period="10";
		String default_rate_of_return="10";
		try {
			boolean select_submenu_from_menu_succeed = Activities.select_submenu_from_menu(driver, "Personal Finance", "Fixed Deposit Interest Calculator");
			System.out.println("select_submenu_from_menu_succeed " + select_submenu_from_menu_succeed);
			if (!select_submenu_from_menu_succeed) {
				testcase_status = false;
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_enter_investment_amount_succeed = Activities.fixed_deposit_calculator_enter_investment_amount(driver, investment_amount);
				System.out.println("fixed_deposit_calculator_enter_investment_amount_succeed " + fixed_deposit_calculator_enter_investment_amount_succeed);
				if (!fixed_deposit_calculator_enter_investment_amount_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_enter_investment_period_succeed = Activities.fixed_deposit_calculator_enter_investment_period(driver, investment_period);
				System.out.println("fixed_deposit_calculator_enter_investment_period_succeed " + fixed_deposit_calculator_enter_investment_period_succeed);
				if (!fixed_deposit_calculator_enter_investment_period_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_enter_rate_of_return_succeed = Activities.fixed_deposit_calculator_enter_rate_of_return(driver, rate_of_return);
				System.out.println("fixed_deposit_calculator_enter_rate_of_return_succeed " + fixed_deposit_calculator_enter_rate_of_return_succeed);
				if (!fixed_deposit_calculator_enter_rate_of_return_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_select_interest_frequency_succeed = Activities.fixed_deposit_calculator_select_interest_frequency(driver, interest_frequency);
				System.out.println("fixed_deposit_calculator_select_interest_frequency_succeed " + fixed_deposit_calculator_select_interest_frequency_succeed);
				if (!fixed_deposit_calculator_select_interest_frequency_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_enter_tax_rate_succeed = Activities.fixed_deposit_calculator_enter_tax_rate(driver, tax_rate);
				System.out.println("fixed_deposit_calculator_enter_tax_rate_succeed " + fixed_deposit_calculator_enter_tax_rate_succeed);
				if (!fixed_deposit_calculator_enter_tax_rate_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_click_reset_button_succeed = Activities.fixed_deposit_calculator_click_reset_button(driver);
				System.out.println("fixed_deposit_calculator_click_reset_button_succeed " + fixed_deposit_calculator_click_reset_button_succeed);
				if (!fixed_deposit_calculator_click_reset_button_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_check_investment_amount_succeed = Activities.fixed_deposit_calculator_check_investment_amount(driver, default_investment_amount);
				System.out.println("fixed_deposit_calculator_check_investment_amount_succeed " + fixed_deposit_calculator_check_investment_amount_succeed);
				if (!fixed_deposit_calculator_check_investment_amount_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_check_investment_period_succeed = Activities.fixed_deposit_calculator_check_investment_period(driver, default_investment_period);
				System.out.println("fixed_deposit_calculator_check_investment_period_succeed " + fixed_deposit_calculator_check_investment_period_succeed);
				if (!fixed_deposit_calculator_check_investment_period_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean fixed_deposit_calculator_check_rate_of_return_succeed = Activities.fixed_deposit_calculator_check_rate_of_return(driver, default_rate_of_return);
				System.out.println("fixed_deposit_calculator_check_rate_of_return_succeed " + fixed_deposit_calculator_check_rate_of_return_succeed);
				if (!fixed_deposit_calculator_check_rate_of_return_succeed) {
					testcase_status = false;
				}
			}
			System.out.println("testcase_status " + testcase_status);
		} catch (Exception ex) {
			System.out.println("ex " + ex);
		}
	}

	@Test
	public static void test_emergency_fund_calculator() {
		boolean testcase_status = true;
		try {
			boolean select_submenu_from_menu_succeed = Activities.select_submenu_from_menu(driver, "Personal Finance", "Emergency Fund Calculator");
			System.out.println("select_submenu_from_menu_succeed " + select_submenu_from_menu_succeed);
			if (!select_submenu_from_menu_succeed) {
				testcase_status = false;
			}
			if (testcase_status) {
				boolean emergency_fund_calculator_enter_medical_dental_cost_succeed = Activities.emergency_fund_calculator_enter_medical_dental_cost(driver, medical_dental_cost);
				System.out.println("emergency_fund_calculator_enter_medical_dental_cost_succeed " + emergency_fund_calculator_enter_medical_dental_cost_succeed);
				if (!emergency_fund_calculator_enter_medical_dental_cost_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean emergency_fund_calculator_enter_vehicle_repair_succeed = Activities.emergency_fund_calculator_enter_vehicle_repair(driver, vehicle_repair);
				System.out.println("emergency_fund_calculator_enter_vehicle_repair_succeed " + emergency_fund_calculator_enter_vehicle_repair_succeed);
				if (!emergency_fund_calculator_enter_vehicle_repair_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean emergency_fund_calculator_enter_others_succeed = Activities.emergency_fund_calculator_enter_others(driver, others);
				System.out.println("emergency_fund_calculator_enter_others_succeed " + emergency_fund_calculator_enter_others_succeed);
				if (!emergency_fund_calculator_enter_others_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean emergency_fund_calculator_enter_life_health_insurance_premium_succeed = Activities.emergency_fund_calculator_enter_life_health_insurance_premium(driver, life_health_insurance_premium);
				System.out.println("emergency_fund_calculator_enter_life_health_insurance_premium_succeed " + emergency_fund_calculator_enter_life_health_insurance_premium_succeed);
				if (!emergency_fund_calculator_enter_life_health_insurance_premium_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean emergency_fund_calculator_enter_home_auto_insurance_premium_succeed = Activities.emergency_fund_calculator_enter_home_auto_insurance_premium(driver, home_auto_insurance_premium);
				System.out.println("emergency_fund_calculator_enter_home_auto_insurance_premium_succeed " + emergency_fund_calculator_enter_home_auto_insurance_premium_succeed);
				if (!emergency_fund_calculator_enter_home_auto_insurance_premium_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean emergency_fund_calculator_enter_home_loan_other_important_emis_succeed = Activities.emergency_fund_calculator_enter_home_loan_other_important_emis(driver, home_loan_other_important_emis);
				System.out.println("emergency_fund_calculator_enter_home_loan_other_important_emis_succeed " + emergency_fund_calculator_enter_home_loan_other_important_emis_succeed);
				if (!emergency_fund_calculator_enter_home_loan_other_important_emis_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean emergency_fund_calculator_enter_monthly_living_expenses_succeed = Activities.emergency_fund_calculator_enter_monthly_living_expenses(driver, monthly_living_expenses);
				System.out.println("emergency_fund_calculator_enter_monthly_living_expenses_succeed " + emergency_fund_calculator_enter_monthly_living_expenses_succeed);
				if (!emergency_fund_calculator_enter_monthly_living_expenses_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean emergency_fund_calculator_enter_month_unemployed_succeed = Activities.emergency_fund_calculator_enter_month_unemployed(driver, month_unemployed);
				System.out.println("emergency_fund_calculator_enter_month_unemployed_succeed " + emergency_fund_calculator_enter_month_unemployed_succeed);
				if (!emergency_fund_calculator_enter_month_unemployed_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean emergency_fund_calculator_click_calculate_button_succeed = Activities.emergency_fund_calculator_click_calculate_button(driver);
				System.out.println("emergency_fund_calculator_click_calculate_button_succeed " + emergency_fund_calculator_click_calculate_button_succeed);
				if (!emergency_fund_calculator_click_calculate_button_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean emergency_fund_calculator_click_calculate_button_succeed = Activities.emergency_fund_calculator_click_calculate_button(driver);
				System.out.println("emergency_fund_calculator_click_calculate_button_succeed " + emergency_fund_calculator_click_calculate_button_succeed);
				if (!emergency_fund_calculator_click_calculate_button_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean emergency_fund_calculator_check_uninsured_unexpected_emergencies_total_succeed = Activities.emergency_fund_calculator_check_uninsured_unexpected_emergencies_total(driver, uninsured_unexpected_emergencies_total);
				System.out.println("emergency_fund_calculator_check_uninsured_unexpected_emergencies_total_succeed " + emergency_fund_calculator_check_uninsured_unexpected_emergencies_total_succeed);
				if (!emergency_fund_calculator_check_uninsured_unexpected_emergencies_total_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean emergency_fund_calculator_check_annual_amount_of_fixed_payments_total_succeed = Activities.emergency_fund_calculator_check_annual_amount_of_fixed_payments_total(driver, annual_amount_of_fixed_payments_total);
				System.out.println("emergency_fund_calculator_check_annual_amount_of_fixed_payments_total_succeed " + emergency_fund_calculator_check_annual_amount_of_fixed_payments_total_succeed);
				if (!emergency_fund_calculator_check_annual_amount_of_fixed_payments_total_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean emergency_fund_calculator_check_build_reserve_to_pay_for_job_loss_succeed = Activities.emergency_fund_calculator_check_build_reserve_to_pay_for_job_loss(driver, build_reserve_to_pay_for_job_loss);
				System.out.println("emergency_fund_calculator_check_build_reserve_to_pay_for_job_loss_succeed " + emergency_fund_calculator_check_build_reserve_to_pay_for_job_loss_succeed);
				if (!emergency_fund_calculator_check_build_reserve_to_pay_for_job_loss_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean emergency_fund_calculator_check_result_succeed = Activities.emergency_fund_calculator_check_result(driver, final_result);
				System.out.println("emergency_fund_calculator_check_result_succeed " + emergency_fund_calculator_check_result_succeed);
				if (!emergency_fund_calculator_check_result_succeed) {
					testcase_status = false;
				}
			}
			System.out.println("testcase_status " + testcase_status);
		} catch (Exception ex) {
			System.out.println("ex " + ex);
		}
	}

	@Test
	public static void test_provident_fund_calculator() {
		boolean testcase_status = true;
		String your_age="50";
		String your_basic_salary_monthly="75000";
		String your_contribution_to_epf="10";
		String your_employer_contribution_to_epf="12";
		String average_annual_increase_in_salary_you_expect="12";
		String age_when_you_intend_to_retire="60";
		String current_epf_balance_if_any="5000000";
		String current_interest_rate="9";
		String final_result="1,62,14,311";
		try {
			boolean select_submenu_from_menu_succeed = Activities.select_submenu_from_menu(driver, "Personal Finance",
					"Provident Fund Calculator");
			System.out.println("select_submenu_from_menu_succeed " + select_submenu_from_menu_succeed);
			if (!select_submenu_from_menu_succeed) {
				testcase_status = false;
			}
			if (testcase_status) {
				boolean provident_fund_calculator_enter_your_age_succeed = Activities.provident_fund_calculator_enter_your_age(
						driver, your_age);
				System.out.println("provident_fund_calculator_enter_your_age_succeed " + provident_fund_calculator_enter_your_age_succeed);
				if (!provident_fund_calculator_enter_your_age_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean provident_fund_calculator_enter_your_basic_salary_monthly_succeed = Activities.provident_fund_calculator_enter_your_basic_salary_monthly(
						driver, your_basic_salary_monthly);
				System.out.println("provident_fund_calculator_enter_your_basic_salary_monthly_succeed " + provident_fund_calculator_enter_your_basic_salary_monthly_succeed);
				if (!provident_fund_calculator_enter_your_basic_salary_monthly_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean provident_fund_calculator_enter_your_contribution_to_epf_succeed = Activities.provident_fund_calculator_enter_your_contribution_to_epf(
						driver, your_contribution_to_epf);
				System.out.println("provident_fund_calculator_enter_your_contribution_to_epf_succeed " + provident_fund_calculator_enter_your_contribution_to_epf_succeed);
				if (!provident_fund_calculator_enter_your_contribution_to_epf_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean provident_fund_calculator_enter_your_employer_contribution_to_epf_succeed = Activities.provident_fund_calculator_enter_your_employer_contribution_to_epf(
						driver, your_employer_contribution_to_epf);
				System.out.println("provident_fund_calculator_enter_your_employer_contribution_to_epf_succeed " + provident_fund_calculator_enter_your_employer_contribution_to_epf_succeed);
				if (!provident_fund_calculator_enter_your_employer_contribution_to_epf_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean provident_fund_calculator_enter_average_annual_increase_in_salary_you_expect_succeed = Activities.provident_fund_calculator_enter_average_annual_increase_in_salary_you_expect(
						driver,
						average_annual_increase_in_salary_you_expect);
				System.out.println("provident_fund_calculator_enter_average_annual_increase_in_salary_you_expect_succeed " + provident_fund_calculator_enter_average_annual_increase_in_salary_you_expect_succeed);
				if (!provident_fund_calculator_enter_average_annual_increase_in_salary_you_expect_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean provident_fund_calculator_enter_age_when_you_intend_to_retire_succeed = Activities.provident_fund_calculator_enter_age_when_you_intend_to_retire(
						driver,
						age_when_you_intend_to_retire);
				System.out.println("provident_fund_calculator_enter_age_when_you_intend_to_retire_succeed " + provident_fund_calculator_enter_age_when_you_intend_to_retire_succeed);
				if (!provident_fund_calculator_enter_age_when_you_intend_to_retire_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean provident_fund_calculator_enter_current_epf_balance_if_any_succeed = Activities.provident_fund_calculator_enter_current_epf_balance_if_any(
						driver,
						current_epf_balance_if_any);
				System.out.println("provident_fund_calculator_enter_current_epf_balance_if_any_succeed " + provident_fund_calculator_enter_current_epf_balance_if_any_succeed);
				if (!provident_fund_calculator_enter_current_epf_balance_if_any_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean provident_fund_calculator_enter_current_interest_rate_succeed = Activities.provident_fund_calculator_enter_current_interest_rate(
						driver,
						current_interest_rate);
				System.out.println("provident_fund_calculator_enter_current_interest_rate_succeed " + provident_fund_calculator_enter_current_interest_rate_succeed);
				if (!provident_fund_calculator_enter_current_interest_rate_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean provident_fund_calculator_click_submit_button_succeed = Activities.provident_fund_calculator_click_submit_button(
						driver);
				System.out.println("provident_fund_calculator_click_submit_button_succeed " + provident_fund_calculator_click_submit_button_succeed);
				if (!provident_fund_calculator_click_submit_button_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean provident_fund_calculator_check_result_succeed = Activities.provident_fund_calculator_check_result(
						driver, final_result);
				System.out.println("provident_fund_calculator_check_result_succeed " + provident_fund_calculator_check_result_succeed);
				if (!provident_fund_calculator_check_result_succeed) {
					testcase_status = false;
				}
			}
			System.out.println("testcase_status " + testcase_status);

		} catch (Exception ex) {
			System.out.println("ex " + ex);
		}
	}

	@Test
	public void test_debt_reduction_plan_calculator() {
		boolean testcase_status = true;
		String total_debt_outstanding="1500000";
		String rate_of_interest_per_annum="15";
		String how_much_can_you_repay_every_month="50000";
		String final_result="15,00,000";
		try {
			boolean select_submenu_from_menu_succeed = Activities.select_submenu_from_menu(driver, "Personal Finance", "Debt Reduction Planner");
			System.out.println("select_submenu_from_menu_succeed " + select_submenu_from_menu_succeed);
			if (!select_submenu_from_menu_succeed) {
				testcase_status = false;
			}
			if (testcase_status) {
				boolean debt_reduction_plan_calculator_enter_total_debt_outstanding_succeed = Activities.debt_reduction_plan_calculator_enter_total_debt_outstanding(driver, total_debt_outstanding);
				System.out.println("debt_reduction_plan_calculator_enter_total_debt_outstanding_succeed " + debt_reduction_plan_calculator_enter_total_debt_outstanding_succeed);
				if (!debt_reduction_plan_calculator_enter_total_debt_outstanding_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean debt_reduction_plan_calculator_enter_rate_of_interest_per_annum_succeed = Activities.debt_reduction_plan_calculator_enter_rate_of_interest_per_annum(driver, rate_of_interest_per_annum);
				System.out.println("debt_reduction_plan_calculator_enter_rate_of_interest_per_annum_succeed " + debt_reduction_plan_calculator_enter_rate_of_interest_per_annum_succeed);
				if (!debt_reduction_plan_calculator_enter_rate_of_interest_per_annum_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean debt_reduction_plan_calculator_enter_how_much_can_you_repay_every_month_succeed = Activities.debt_reduction_plan_calculator_enter_how_much_can_you_repay_every_month(driver, how_much_can_you_repay_every_month);
				System.out.println("debt_reduction_plan_calculator_enter_how_much_can_you_repay_every_month_succeed " + debt_reduction_plan_calculator_enter_how_much_can_you_repay_every_month_succeed);
				if (!debt_reduction_plan_calculator_enter_how_much_can_you_repay_every_month_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean debt_reduction_plan_calculator_click_calculate_button_succeed = Activities.debt_reduction_plan_calculator_click_calculate_button(driver);
				System.out.println("debt_reduction_plan_calculator_click_calculate_button_succeed " + debt_reduction_plan_calculator_click_calculate_button_succeed);
				if (!debt_reduction_plan_calculator_click_calculate_button_succeed) {
					testcase_status = false;
				}
			}
			if (testcase_status) {
				boolean debt_reduction_plan_calculator_check_result_succeed = Activities.debt_reduction_plan_calculator_check_result(driver, final_result);
				System.out.println("debt_reduction_plan_calculator_check_result_succeed " + debt_reduction_plan_calculator_check_result_succeed);
				if (!debt_reduction_plan_calculator_check_result_succeed) {
					testcase_status = false;
				}
			}
			System.out.println("testcase_status " + testcase_status);
		} catch (Exception ex) {
			System.out.println("ex " + ex);
		}
	}


}

