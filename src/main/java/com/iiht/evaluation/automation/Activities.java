package com.iiht.evaluation.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Activities{

    public static boolean open_login_panel(WebDriver driver) {
        WebElement user_link_element = SubActivities.find_element_use_xpath(driver, locators.money_control_element.get("login_link"));
        if (user_link_element == null) {
            return false;
        }
        Actions actions = new Actions(driver);
        actions.moveToElement(user_link_element).perform();
        WebElement login_signup_box_element = SubActivities.find_element_use_xpath(driver,
                locators.money_control_element.get("login_signup_box"));
        if (login_signup_box_element == null) {
            return false;
        }
        boolean login_signup_box_element_display = login_signup_box_element.isDisplayed();
        System.out.println("login_signup_box_element_display " + login_signup_box_element_display);
        if (!login_signup_box_element_display) {
            return false;
        }
        return true;
    }

    public static boolean switch_to_signin_iframe(WebDriver driver) {
        WebElement login_signin_iframe_element = SubActivities.find_element_use_xpath(driver, locators.money_control_element.get("login_signin_iframe"));
        if (login_signin_iframe_element == null) {
            return false;
        }
        driver.switchTo().frame(login_signin_iframe_element);
        return true;
    }

    public static boolean open_signin_box(WebDriver driver) {
        WebElement signup_box_login_link_element = SubActivities.find_element_use_xpath(driver, locators.money_control_element.get("signup_box_login_link"));
        if (signup_box_login_link_element == null) {
            return false;
        }
        signup_box_login_link_element.click();
        boolean switch_to_signin_iframe_succeed = Activities.switch_to_signin_iframe(driver);
        if (!switch_to_signin_iframe_succeed) {
            return false;
        }
        WebElement login_signin_box_element = SubActivities.find_element_use_xpath(driver, locators.money_control_element.get("login_signin_box"));
        if (login_signin_box_element == null) {
            return false;
        }
        return true;
    }

    public static boolean signin_box_enter_email(WebDriver driver, String email) {
        driver.switchTo().defaultContent();
        boolean switch_to_signin_iframe_succeed = Activities.switch_to_signin_iframe(driver);
        if (!switch_to_signin_iframe_succeed) {
            return false;
        }
        WebElement signin_box_email_field_element = SubActivities.find_element_use_xpath(driver, locators.money_control_element.get("signin_box_email_field"));
        if (signin_box_email_field_element == null) {
            return false;
        }
        signin_box_email_field_element.sendKeys(email);
        return true;
    }

    public static boolean signin_box_enter_password(WebDriver driver, String password) {
        driver.switchTo().defaultContent();
        boolean switch_to_signin_iframe_succeed = Activities.switch_to_signin_iframe(driver);
        if (!switch_to_signin_iframe_succeed) {
            return false;
        }
        WebElement signin_box_password_field_element = SubActivities.find_element_use_xpath(driver, locators.money_control_element.get("signin_box_password_field"));
        if (signin_box_password_field_element == null) {
            return false;
        }
        signin_box_password_field_element.sendKeys(password);
        return true;
    }

    public static boolean signin_box_click_login_button(WebDriver driver) {
        boolean login_signin_box_not_present = false;
        driver.switchTo().defaultContent();
        boolean switch_to_signin_iframe_succeed = Activities.switch_to_signin_iframe(driver);
        if (!switch_to_signin_iframe_succeed) {
            return false;
        }
        WebElement signin_box_login_button_element = SubActivities.find_element_use_xpath(driver, locators.money_control_element.get("signin_box_login_button"));
        if (signin_box_login_button_element == null) {
            return false;
        }
        signin_box_login_button_element.click();

        try {
            login_signin_box_not_present = SubActivities.wait_for_element_not_present(driver, locators.money_control_element.get("login_signin_box"));
            System.out.println("login_signin_box_not_present " + login_signin_box_not_present);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
        } finally {
            driver.switchTo().defaultContent();
            return login_signin_box_not_present;
        }
    }

    public static boolean signin_box_click_login_button_except_error(WebDriver driver) {
        boolean login_signin_box_present = false;
        driver.switchTo().defaultContent();
        boolean switch_to_signin_iframe_succeed = Activities.switch_to_signin_iframe(driver);
        if (!switch_to_signin_iframe_succeed) {
            return false;
        }
        WebElement signin_box_login_button_element = SubActivities.find_element_use_xpath(driver, locators.money_control_element.get("signin_box_login_button"));
        if (signin_box_login_button_element == null) {
            return false;
        }
        signin_box_login_button_element.click();

        try {
            login_signin_box_present = SubActivities.wait_for_element_present(driver, locators.money_control_element.get("login_signin_box"));
            System.out.println("login_signin_box_present " + login_signin_box_present);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
        } finally {
            driver.switchTo().defaultContent();
            return login_signin_box_present;
        }
    }

    public static boolean signin_box_check_error(WebDriver driver, String error_message) {
        boolean is_error_message_checked = false;
        driver.switchTo().defaultContent();
        boolean switch_to_signin_iframe_succeed = Activities.switch_to_signin_iframe(driver);
        if (!switch_to_signin_iframe_succeed) {
            return false;
        }
        WebElement signin_box_error_div_element = SubActivities.find_element_use_xpath(driver, locators.money_control_element.get("signin_box_error_div"));
        if (signin_box_error_div_element == null) {
            return false;
        }
        String signin_box_error_div_element_text = signin_box_error_div_element.getText();
        System.out.println("signin_box_error_div_element_text " + signin_box_error_div_element_text);
        if (signin_box_error_div_element_text.equals(error_message)) {
            is_error_message_checked = true;
        }
        return is_error_message_checked;
    }

    public static boolean check_logged_in_user(WebDriver driver, String email) {
        boolean is_email_checked = false;
        WebElement logged_in_user_link_element = SubActivities.find_element_use_xpath(driver, locators.money_control_element.get("logged_in_user_link"));
        if (logged_in_user_link_element == null) {
            return false;
        }
        String logged_in_user_link_title_attribute = logged_in_user_link_element.getAttribute("title");
        System.out.println("logged_in_user_link_title_attribute " + logged_in_user_link_title_attribute);
        if (logged_in_user_link_title_attribute.trim().toLowerCase().equals(email)) {
            is_email_checked = true;
        }
        return is_email_checked;
    }

    public static boolean select_submenu_from_menu(WebDriver driver, String main_menu, String sub_menu) {
        String main_menu_xpath = locators.money_control_element.get("main_menu").replace("$(main_menu)", main_menu);
        String sub_menu_xpath = locators.money_control_element.get("sub_menu").replace("$(sub_menu)", sub_menu);

        WebElement main_menu_element = SubActivities.find_element_use_xpath(driver, main_menu_xpath);
        if (main_menu_element == null) {
            return false;
        }
        boolean main_menu_element_visible = SubActivities.wait_for_element_visible(driver, main_menu_xpath);
        System.out.println("main_menu_element_visible " + main_menu_element_visible);
        if (!main_menu_element_visible) {
            return false;
        }
        Actions actions = new Actions(driver);
        actions.moveToElement(main_menu_element).perform();
        WebElement sub_menu_element = SubActivities.find_element_use_xpath(driver, sub_menu_xpath);
        if (sub_menu_element == null) {
            return false;
        }
        boolean sub_menu_element_visible = SubActivities.wait_for_element_visible(driver, sub_menu_xpath);
        System.out.println("sub_menu_element_visible " + sub_menu_element_visible);
        if (!sub_menu_element_visible) {
            return false;
        }
        sub_menu_element.click();
        SubActivities.check_page_load_complete(driver);
        return true;
    }

    public static boolean fixed_deposit_calculator_enter_investment_amount(WebDriver driver, String investment_amount) {
        String investment_amount_input = locators.money_control_element.get("investment_amount_input");
        WebElement investment_amount_input_element = SubActivities.find_element_use_xpath(driver, investment_amount_input);
        if (investment_amount_input_element == null) {
            return false;
        }
        boolean investment_amount_input_element_visible = SubActivities.wait_for_element_visible(driver, investment_amount_input);
        System.out.println("investment_amount_input_element_visible " + investment_amount_input_element_visible);
        if (!investment_amount_input_element_visible) {
            return false;
        }
        investment_amount_input_element.clear();
        investment_amount_input_element.sendKeys(investment_amount);
        return true;
    }

    public static boolean fixed_deposit_calculator_check_investment_amount(WebDriver driver, String investment_amount) {
        String investment_amount_input = locators.money_control_element.get("investment_amount_input");
        WebElement investment_amount_input_element = SubActivities.find_element_use_xpath(driver, investment_amount_input);
        if (investment_amount_input_element == null) {
            return false;
        }
        boolean investment_amount_input_element_visible = SubActivities.wait_for_element_visible(driver, investment_amount_input);
        System.out.println("investment_amount_input_element_visible " + investment_amount_input_element_visible);
        if (!investment_amount_input_element_visible) {
            return false;
        }
        String investment_amount_input_element_value_attribute = investment_amount_input_element.getAttribute("value");
        System.out.println("investment_amount_input_element_value_attribute " + investment_amount_input_element_value_attribute);
        if (!investment_amount_input_element_value_attribute.equals(investment_amount)) {
            return false;
        }
        return true;
    }

    public static boolean fixed_deposit_calculator_enter_investment_period(WebDriver driver, String investment_period) {
        String investment_period_input = locators.money_control_element.get("investment_period_input");
        WebElement investment_period_input_element = SubActivities.find_element_use_xpath(driver, investment_period_input);
        if (investment_period_input_element == null) {
            return false;
        }
        boolean investment_period_input_element_visible = SubActivities.wait_for_element_visible(driver, investment_period_input);
        System.out.println("investment_period_input_element_visible " + investment_period_input_element_visible);
        if (!investment_period_input_element_visible) {
            return false;
        }
        investment_period_input_element.clear();
        investment_period_input_element.sendKeys(investment_period);
        return true;
    }

    public static boolean fixed_deposit_calculator_check_investment_period(WebDriver driver, String investment_period) {
        String investment_period_input = locators.money_control_element.get("investment_period_input");
        WebElement investment_period_input_element = SubActivities.find_element_use_xpath(driver, investment_period_input);
        if (investment_period_input_element == null) {
            return false;
        }
        boolean investment_period_input_element_visible = SubActivities.wait_for_element_visible(driver, investment_period_input);
        System.out.println("investment_period_input_element_visible " + investment_period_input_element_visible);
        if (investment_period_input_element_visible == false) {
            return false;
        }
        String investment_period_input_element_value_attribute = investment_period_input_element.getAttribute("value");
        System.out.println("investment_period_input_element_value_attribute " + investment_period_input_element_value_attribute);
        if (!investment_period_input_element_value_attribute.equals(investment_period)) {
            return false;
        }
        return true;
    }

    public static boolean fixed_deposit_calculator_enter_rate_of_return(WebDriver driver, String rate_of_return) {
        String rate_of_return_input = locators.money_control_element.get("rate_of_return_input");
        WebElement rate_of_return_input_element = SubActivities.find_element_use_xpath(driver, rate_of_return_input);
        if (rate_of_return_input_element == null) {
            return false;
        }
        boolean rate_of_return_input_element_visible = SubActivities.wait_for_element_visible(driver, rate_of_return_input);
        System.out.println("rate_of_return_input_element_visible " + rate_of_return_input_element_visible);
        if (rate_of_return_input_element_visible == false) {
            return false;
        }
        rate_of_return_input_element.clear();
        rate_of_return_input_element.sendKeys(rate_of_return);
        return true;
    }

    public static boolean fixed_deposit_calculator_check_rate_of_return(WebDriver driver, String rate_of_return) {
        String rate_of_return_input = locators.money_control_element.get("rate_of_return_input");
        WebElement rate_of_return_input_element = SubActivities.find_element_use_xpath(driver, rate_of_return_input);
        if (rate_of_return_input_element == null) {
            return false;
        }
        boolean rate_of_return_input_element_visible = SubActivities.wait_for_element_visible(driver, rate_of_return_input);
        System.out.println("rate_of_return_input_element_visible " + rate_of_return_input_element_visible);
        if (rate_of_return_input_element_visible == false) {
            return false;
        }
        String rate_of_return_input_element_value_attribute = rate_of_return_input_element.getAttribute("value");
        System.out.println("rate_of_return_input_element_value_attribute " + rate_of_return_input_element_value_attribute);
        if (!rate_of_return_input_element_value_attribute.equals(rate_of_return)) {
            return false;
        }
        return true;
    }

    public static boolean fixed_deposit_calculator_select_interest_frequency(WebDriver driver, String interest_frequency) {
        String interest_frequency_radio = locators.money_control_element.get("interest_frequency_radio").replace("$(interest_frequency)", interest_frequency);
        WebElement interest_frequency_radio_element = SubActivities.find_element_use_xpath(driver, interest_frequency_radio);
        if (interest_frequency_radio_element == null) {
            return false;
        }
        SubActivities.do_javascript_click(driver, interest_frequency_radio_element);
        String interest_frequency_radio_checked_attribute = interest_frequency_radio_element.getAttribute("checked");
        System.out.println("interest_frequency_radio_checked_attribute " + interest_frequency_radio_checked_attribute);
        if (!interest_frequency_radio_checked_attribute.equals("checked")) {
            return false;
        }
        return true;
    }

    public static boolean fixed_deposit_calculator_enter_tax_rate(WebDriver driver, String tax_rate) {
        String tax_rate_input = locators.money_control_element.get("tax_rate_input");
        WebElement tax_rate_input_element = SubActivities.find_element_use_xpath(driver, tax_rate_input);
        if (tax_rate_input_element == null) {
            return false;
        }
        boolean tax_rate_input_element_visible = SubActivities.wait_for_element_visible(driver, tax_rate_input);
        System.out.println("tax_rate_input_element_visible " + tax_rate_input_element_visible);
        if (tax_rate_input_element_visible == false) {
            return false;
        }
        tax_rate_input_element.clear();
        tax_rate_input_element.sendKeys(tax_rate);
        return true;
    }

    public static boolean fixed_deposit_calculator_check_tax_rate(WebDriver driver, String tax_rate) {
        String tax_rate_input = locators.money_control_element.get("tax_rate_input");
        WebElement tax_rate_input_element = SubActivities.find_element_use_xpath(driver, tax_rate_input);
        if (tax_rate_input_element == null) {
            return false;
        }
        boolean tax_rate_input_element_visible = SubActivities.wait_for_element_visible(driver, tax_rate_input);
        System.out.println("tax_rate_input_element_visible " + tax_rate_input_element_visible);
        if (tax_rate_input_element_visible == false) {
            return false;
        }
        String tax_rate_input_element_value_attribute = tax_rate_input_element.getAttribute("value");
        System.out.println("tax_rate_input_element_value_attribute " + tax_rate_input_element_value_attribute);
        if (!tax_rate_input_element_value_attribute.equals(tax_rate)) {
            return false;
        }
        return true;
    }

    public static boolean fixed_deposit_calculator_click_submit_button(WebDriver driver) {
        String submit_button = locators.money_control_element.get("submit_button");
        WebElement submit_button_element = SubActivities.find_element_use_xpath(driver, submit_button);
        if (submit_button_element == null) {
            return false;
        }
        boolean submit_button_element_visible = SubActivities.wait_for_element_visible(driver, submit_button);
        System.out.println("submit_button_element_visible " + submit_button_element_visible);
        if (submit_button_element_visible == false) {
            return false;
        }
        submit_button_element.click();
        return true;
    }

    public static boolean fixed_deposit_calculator_click_reset_button(WebDriver driver) {
        String reset_button = locators.money_control_element.get("reset_button");
        WebElement reset_button_element = SubActivities.find_element_use_xpath(driver, reset_button);
        if (reset_button_element == null) {
            return false;
        }
        boolean reset_button_element_visible = SubActivities.wait_for_element_visible(driver, reset_button);
        System.out.println("reset_button_element_visible " + reset_button_element_visible);
        if (reset_button_element_visible == false) {
            return false;
        }
        reset_button_element.click();
        return true;
    }

    public static boolean fixed_deposit_calculator_check_total_payment(WebDriver driver, String total_payment) {
        String total_payment_span = locators.money_control_element.get("total_payment_span");
        WebElement total_payment_span_element = SubActivities.find_element_use_xpath(driver, total_payment_span);
        if (total_payment_span_element == null) {
            return false;
        }
        boolean total_payment_span_element_visible = SubActivities.wait_for_element_visible(driver, total_payment_span);
        System.out.println("total_payment_span_element_visible " + total_payment_span_element_visible);
        if (total_payment_span_element_visible == false) {
            return false;
        }
        String total_payment_span_element_text = total_payment_span_element.getText();
        System.out.println("total_payment_span_element_text " + total_payment_span_element_text);
        if (!total_payment_span_element_text.equals(total_payment)) {
            return false;
        }
        return true;
    }

    public static boolean fixed_deposit_calculator_check_total_interest(WebDriver driver, String total_interest) {
        String total_interest_span = locators.money_control_element.get("total_interest_span");
        WebElement total_interest_span_element = SubActivities.find_element_use_xpath(driver, total_interest_span);
        if (total_interest_span_element == null) {
            return false;
        }
        boolean total_interest_span_element_visible = SubActivities.wait_for_element_visible(driver, total_interest_span);
        System.out.println("total_interest_span_element_visible " + total_interest_span_element_visible);
        if (total_interest_span_element_visible == false) {
            return false;
        }
        String total_interest_span_element_text = total_interest_span_element.getText();
        System.out.println("total_interest_span_element_text " + total_interest_span_element_text);
        if (!total_interest_span_element_text.equals(total_interest)) {
            return false;
        }
        return true;
    }

    public static boolean fixed_deposit_calculator_check_total_corpus(WebDriver driver, String total_corpus) {
        String total_corpus_span = locators.money_control_element.get("total_corpus_span");
        WebElement total_corpus_span_element = SubActivities.find_element_use_xpath(driver, total_corpus_span);
        if (total_corpus_span_element == null) {
            return false;
        }
        boolean total_corpus_span_element_visible = SubActivities.wait_for_element_visible(driver, total_corpus_span);
        System.out.println("total_corpus_span_element_visible " + total_corpus_span_element_visible);
        if (total_corpus_span_element_visible == false) {
            return false;
        }
        String total_corpus_span_element_text = total_corpus_span_element.getText();
        System.out.println("total_corpus_span_element_text " + total_corpus_span_element_text);
        if (!total_corpus_span_element_text.equals(total_corpus)) {
            return false;
        }
        return true;
    }

    public static boolean fixed_deposit_calculator_check_post_tax_amount(WebDriver driver, String post_tax_amount) {
        String post_tax_amount_span = locators.money_control_element.get("post_tax_amount_span");
        WebElement post_tax_amount_span_element = SubActivities.find_element_use_xpath(driver, post_tax_amount_span);
        if (post_tax_amount_span_element == null) {
            return false;
        }
        boolean post_tax_amount_span_element_visible = SubActivities.wait_for_element_visible(driver, post_tax_amount_span);
        System.out.println("post_tax_amount_span_element_visible " + post_tax_amount_span_element_visible);
        if (post_tax_amount_span_element_visible == false) {
            return false;
        }
        String post_tax_amount_span_element_text = post_tax_amount_span_element.getText();
        System.out.println("post_tax_amount_span_element_text " + post_tax_amount_span_element_text);
        if (!post_tax_amount_span_element_text.equals(post_tax_amount)) {
            return false;
        }
        return true;
    }

    public static boolean emergency_fund_calculator_enter_medical_dental_cost(WebDriver driver, String medical_dental_cost) {
        String medical_dental_cost_input = locators.money_control_element.get("medical_dental_cost_input");
        WebElement medical_dental_cost_input_element = SubActivities.find_element_use_xpath(driver, medical_dental_cost_input);
        if (medical_dental_cost_input_element == null) {
            return false;
        }
        boolean medical_dental_cost_input_element_visible = SubActivities.wait_for_element_visible(driver,
                medical_dental_cost_input);
        System.out.println("medical_dental_cost_input_element_visible " + medical_dental_cost_input_element_visible);
        if (medical_dental_cost_input_element_visible == false) {
            return false;
        }
        medical_dental_cost_input_element.clear();
        medical_dental_cost_input_element.sendKeys(medical_dental_cost);
        return true;
    }

    public static boolean emergency_fund_calculator_check_medical_dental_cost(WebDriver driver, String medical_dental_cost) {
        String medical_dental_cost_input = locators.money_control_element.get("medical_dental_cost_input");
        WebElement medical_dental_cost_input_element = SubActivities.find_element_use_xpath(driver, medical_dental_cost_input);
        if (medical_dental_cost_input_element == null) {
            return false;
        }
        boolean medical_dental_cost_input_element_visible = SubActivities.wait_for_element_visible(driver,
                medical_dental_cost_input);
        System.out.println("medical_dental_cost_input_element_visible " + medical_dental_cost_input_element_visible);
        if (medical_dental_cost_input_element_visible == false) {
            return false;
        }
        String medical_dental_cost_input_element_value_attribute = medical_dental_cost_input_element.getAttribute("value");
        System.out.println("medical_dental_cost_input_element_value_attribute " + medical_dental_cost_input_element_value_attribute);
        if (!medical_dental_cost_input_element_value_attribute.equals(medical_dental_cost)) {
            return false;
        }
        return true;
    }

    public static boolean emergency_fund_calculator_enter_vehicle_repair(WebDriver driver, String vehicle_repair) {
        String vehicle_repair_input = locators.money_control_element.get("vehicle_repair_input");
        WebElement vehicle_repair_input_element = SubActivities.find_element_use_xpath(driver, vehicle_repair_input);
        if (vehicle_repair_input_element == null) {
            return false;
        }
        boolean vehicle_repair_input_element_visible = SubActivities.wait_for_element_visible(driver, vehicle_repair_input);
        System.out.println("vehicle_repair_input_element_visible " + vehicle_repair_input_element_visible);
        if (vehicle_repair_input_element_visible == false) {
            return false;
        }
        vehicle_repair_input_element.clear();
        vehicle_repair_input_element.sendKeys(vehicle_repair);
        return true;
    }

    public static boolean emergency_fund_calculator_check_vehicle_repair(WebDriver driver, String vehicle_repair) {
        String vehicle_repair_input = locators.money_control_element.get("vehicle_repair_input");
        WebElement vehicle_repair_input_element = SubActivities.find_element_use_xpath(driver, vehicle_repair_input);
        if (vehicle_repair_input_element == null) {
            return false;
        }
        boolean vehicle_repair_input_element_visible = SubActivities.wait_for_element_visible(driver, vehicle_repair_input);
        System.out.println("vehicle_repair_input_element_visible " + vehicle_repair_input_element_visible);
        if (vehicle_repair_input_element_visible == false) {
            return false;
        }
        String vehicle_repair_input_element_value_attribute = vehicle_repair_input_element.getAttribute("value");
        System.out.println("vehicle_repair_input_element_value_attribute " + vehicle_repair_input_element_value_attribute);
        if (!vehicle_repair_input_element_value_attribute.equals(vehicle_repair)) {
            return false;
        }
        return true;
    }

    public static boolean emergency_fund_calculator_enter_others(WebDriver driver, String others) {
        String others_input = locators.money_control_element.get("others_input");
        WebElement others_input_element = SubActivities.find_element_use_xpath(driver, others_input);
        if (others_input_element == null) {
            return false;
        }
        boolean others_input_element_visible = SubActivities.wait_for_element_visible(driver, others_input);
        System.out.println("others_input_element_visible " + others_input_element_visible);
        if (others_input_element_visible == false) {
            return false;
        }
        others_input_element.clear();
        others_input_element.sendKeys(others);
        return true;
    }

    public static boolean emergency_fund_calculator_check_others(WebDriver driver, String others) {
        String others_input = locators.money_control_element.get("others_input");
        WebElement others_input_element = SubActivities.find_element_use_xpath(driver, others_input);
        if (others_input_element == null) {
            return false;
        }
        boolean others_input_element_visible = SubActivities.wait_for_element_visible(driver, others_input);
        System.out.println("others_input_element_visible " + others_input_element_visible);
        if (others_input_element_visible == false) {
            return false;
        }
        String others_input_element_value_attribute = others_input_element.getAttribute("value");
        System.out.println("others_input_element_value_attribute " + others_input_element_value_attribute);
        if (!others_input_element_value_attribute.equals(others)) {
            return false;
        }
        return true;
    }


    public static boolean emergency_fund_calculator_enter_life_health_insurance_premium(WebDriver driver, String life_health_insurance_premium) {
        String life_health_insurance_premium_input = locators.money_control_element.get("life_health_insurance_premium_input");
        WebElement life_health_insurance_premium_input_element = SubActivities.find_element_use_xpath(driver, life_health_insurance_premium_input);
        if (life_health_insurance_premium_input_element == null) {
            return false;
        }
        boolean life_health_insurance_premium_input_element_visible = SubActivities.wait_for_element_visible(driver, life_health_insurance_premium_input);
        System.out.println("life_health_insurance_premium_input_element_visible " + life_health_insurance_premium_input_element_visible);
        if (life_health_insurance_premium_input_element_visible == false) {
            return false;
        }
        life_health_insurance_premium_input_element.clear();
        life_health_insurance_premium_input_element.sendKeys(life_health_insurance_premium);
        return true;
    }

    public static boolean emergency_fund_calculator_check_life_health_insurance_premium(WebDriver driver, String life_health_insurance_premium) {
        String life_health_insurance_premium_input = locators.money_control_element.get("life_health_insurance_premium_input");
        WebElement life_health_insurance_premium_input_element = SubActivities.find_element_use_xpath(driver, life_health_insurance_premium_input);
        if (life_health_insurance_premium_input_element == null) {
            return false;
        }
        boolean life_health_insurance_premium_input_element_visible = SubActivities.wait_for_element_visible(driver, life_health_insurance_premium_input);
        System.out.println("life_health_insurance_premium_input_element_visible " + life_health_insurance_premium_input_element_visible);
        if (life_health_insurance_premium_input_element_visible == false) {
            return false;
        }
        String life_health_insurance_premium_input_element_value_attribute = life_health_insurance_premium_input_element.getAttribute("value");
        System.out.println("life_health_insurance_premium_input_element_value_attribute " + life_health_insurance_premium_input_element_value_attribute);
        if (!life_health_insurance_premium_input_element_value_attribute.equals(life_health_insurance_premium)) {
            return false;
        }
        return true;
    }

    public static boolean emergency_fund_calculator_enter_home_auto_insurance_premium(WebDriver driver, String home_auto_insurance_premium) {
        String home_auto_insurance_premium_input = locators.money_control_element.get("home_auto_insurance_premium_input");
        WebElement home_auto_insurance_premium_input_element = SubActivities.find_element_use_xpath(driver, home_auto_insurance_premium_input);
        if (home_auto_insurance_premium_input_element == null) {
            return false;
        }
        boolean home_auto_insurance_premium_input_element_visible = SubActivities.wait_for_element_visible(driver, home_auto_insurance_premium_input);
        System.out.println("home_auto_insurance_premium_input_element_visible " + home_auto_insurance_premium_input_element_visible);
        if (home_auto_insurance_premium_input_element_visible == false) {
            return false;
        }
        home_auto_insurance_premium_input_element.clear();
        home_auto_insurance_premium_input_element.sendKeys(home_auto_insurance_premium);
        return true;
    }

    public static boolean emergency_fund_calculator_check_home_auto_insurance_premium(WebDriver driver, String home_auto_insurance_premium) {
        String home_auto_insurance_premium_input = locators.money_control_element.get("home_auto_insurance_premium_input");
        WebElement home_auto_insurance_premium_input_element = SubActivities.find_element_use_xpath(driver, home_auto_insurance_premium_input);
        if (home_auto_insurance_premium_input_element == null) {
            return false;
        }
        boolean home_auto_insurance_premium_input_element_visible = SubActivities.wait_for_element_visible(driver, home_auto_insurance_premium_input);
        System.out.println("home_auto_insurance_premium_input_element_visible " + home_auto_insurance_premium_input_element_visible);
        if (home_auto_insurance_premium_input_element_visible == false) {
            return false;
        }
        String home_auto_insurance_premium_input_element_value_attribute = home_auto_insurance_premium_input_element.getAttribute("value");
        System.out.println("home_auto_insurance_premium_input_element_value_attribute " + home_auto_insurance_premium_input_element_value_attribute);
        if (!home_auto_insurance_premium_input_element_value_attribute.equals(home_auto_insurance_premium)) {
            return false;
        }
        return true;
    }

    public static boolean emergency_fund_calculator_enter_home_loan_other_important_emis(WebDriver driver, double home_loan_other_important_emis) {
        String home_loan_other_important_emis_input = locators.money_control_element.get("home_loan_other_important_emis_input");
        WebElement home_loan_other_important_emis_input_element = SubActivities.find_element_use_xpath(driver, home_loan_other_important_emis_input);
        if (home_loan_other_important_emis_input_element == null) {
            return false;
        }
        boolean home_loan_other_important_emis_input_element_visible = SubActivities.wait_for_element_visible(driver, home_loan_other_important_emis_input);
        System.out.println("home_loan_other_important_emis_input_element_visible " + home_loan_other_important_emis_input_element_visible);
        if (home_loan_other_important_emis_input_element_visible == false) {
            return false;
        }
        home_loan_other_important_emis_input_element.clear();
        home_loan_other_important_emis_input_element.sendKeys(String.valueOf(home_loan_other_important_emis));
        return true;
    }


    public static boolean emergency_fund_calculator_check_home_loan_other_important_emis(WebDriver driver, double home_loan_other_important_emis) {
        String home_loan_other_important_emis_input = locators.money_control_element.get("home_loan_other_important_emis_input");
        WebElement home_loan_other_important_emis_input_element = SubActivities.find_element_use_xpath(driver, home_loan_other_important_emis_input);
        if (home_loan_other_important_emis_input_element == null) {
            return false;
        }
        boolean home_loan_other_important_emis_input_element_visible = SubActivities.wait_for_element_visible(driver, home_loan_other_important_emis_input);
        System.out.println("home_loan_other_important_emis_input_element_visible " + home_loan_other_important_emis_input_element_visible);
        if (home_loan_other_important_emis_input_element_visible == false) {
            return false;
        }
        String home_loan_other_important_emis_input_element_value_attribute = home_loan_other_important_emis_input_element.getAttribute("value");
        System.out.println("home_loan_other_important_emis_input_element_value_attribute " + home_loan_other_important_emis_input_element_value_attribute);
        if (!home_loan_other_important_emis_input_element_value_attribute.equals(String.valueOf(home_loan_other_important_emis))) {
            return false;
        }
        return true;
    }

    public static boolean emergency_fund_calculator_enter_monthly_living_expenses(WebDriver driver, double monthly_living_expenses) {
        String monthly_living_expenses_input = locators.money_control_element.get("monthly_living_expenses_input");
        WebElement monthly_living_expenses_input_element = SubActivities.find_element_use_xpath(driver, monthly_living_expenses_input);
        if (monthly_living_expenses_input_element == null) {
            return false;
        }
        boolean monthly_living_expenses_input_element_visible = SubActivities.wait_for_element_visible(driver, monthly_living_expenses_input);
        System.out.println("monthly_living_expenses_input_element_visible " + monthly_living_expenses_input_element_visible);
        if (monthly_living_expenses_input_element_visible == false) {
            return false;
        }
        monthly_living_expenses_input_element.clear();
        monthly_living_expenses_input_element.sendKeys(String.valueOf(monthly_living_expenses));
        return true;
    }

    public static boolean emergency_fund_calculator_check_monthly_living_expenses(WebDriver driver, double monthly_living_expenses) {
        String monthly_living_expenses_input = locators.money_control_element.get("monthly_living_expenses_input");
        WebElement monthly_living_expenses_input_element = SubActivities.find_element_use_xpath(driver, monthly_living_expenses_input);
        if (monthly_living_expenses_input_element == null) {
            return false;
        }
        boolean monthly_living_expenses_input_element_visible = SubActivities.wait_for_element_visible(driver, monthly_living_expenses_input);
        System.out.println("monthly_living_expenses_input_element_visible " + monthly_living_expenses_input_element_visible);
        if (monthly_living_expenses_input_element_visible == false) {
            return false;
        }
        String monthly_living_expenses_input_element_value_attribute = monthly_living_expenses_input_element.getAttribute("value");
        System.out.println("monthly_living_expenses_input_element_value_attribute " + monthly_living_expenses_input_element_value_attribute);
        if (!monthly_living_expenses_input_element_value_attribute.equals(String.valueOf(monthly_living_expenses))) {
            return false;
        }
        return true;
    }

    public static boolean emergency_fund_calculator_enter_month_unemployed(WebDriver driver, int month_unemployed) {
        String month_unemployed_input = locators.money_control_element.get("month_unemployed_input");
        WebElement month_unemployed_input_element = SubActivities.find_element_use_xpath(driver, month_unemployed_input);
        if (month_unemployed_input_element == null) {
            return false;
        }
        boolean month_unemployed_input_element_visible = SubActivities.wait_for_element_visible(driver, month_unemployed_input);
        System.out.println("month_unemployed_input_element_visible " + month_unemployed_input_element_visible);
        if (month_unemployed_input_element_visible == false) {
            return false;
        }
        month_unemployed_input_element.clear();
        month_unemployed_input_element.sendKeys(String.valueOf(month_unemployed));
        return true;
    }

    public static boolean emergency_fund_calculator_check_month_unemployed(WebDriver driver, int month_unemployed) {
        String month_unemployed_input = locators.money_control_element.get("month_unemployed_input");
        WebElement month_unemployed_input_element = SubActivities.find_element_use_xpath(driver, month_unemployed_input);
        if (month_unemployed_input_element == null) {
            return false;
        }
        boolean month_unemployed_input_element_visible = SubActivities.wait_for_element_visible(driver, month_unemployed_input);
        System.out.println("month_unemployed_input_element_visible " + month_unemployed_input_element_visible);
        if (month_unemployed_input_element_visible == false) {
            return false;
        }
        String month_unemployed_input_element_value_attribute = month_unemployed_input_element.getAttribute("value");
        System.out.println("month_unemployed_input_element_value_attribute " + month_unemployed_input_element_value_attribute);
        if (!month_unemployed_input_element_value_attribute.equals(String.valueOf(month_unemployed))) {
            return false;
        }
        return true;
    }

    public static boolean emergency_fund_calculator_click_calculate_button(WebDriver driver) {
        String calculate_button = locators.money_control_element.get("calculate_button");
        WebElement calculate_button_element = SubActivities.find_element_use_xpath(driver, calculate_button);
        if (calculate_button_element == null) {
            return false;
        }
        boolean calculate_button_element_visible = SubActivities.wait_for_element_visible(driver, calculate_button);
        System.out.println("calculate_button_element_visible " + calculate_button_element_visible);
        if (calculate_button_element_visible == false) {
            return false;
        }
        calculate_button_element.click();
        return true;
    }

    public static boolean emergency_fund_calculator_check_uninsured_unexpected_emergencies_total(WebDriver driver, double uninsured_unexpected_emergencies_total) {
        String uninsured_unexpected_emergencies_total_div = locators.money_control_element.get("uninsured_unexpected_emergencies_total_div");
        WebElement uninsured_unexpected_emergencies_total_div_element = SubActivities.find_element_use_xpath(driver, uninsured_unexpected_emergencies_total_div);
        if (uninsured_unexpected_emergencies_total_div_element == null) {
            return false;
        }
        boolean uninsured_unexpected_emergencies_total_div_element_visible = SubActivities.wait_for_element_visible(driver, uninsured_unexpected_emergencies_total_div);
        System.out.println("uninsured_unexpected_emergencies_total_div_element_visible " + uninsured_unexpected_emergencies_total_div_element_visible);
        if (uninsured_unexpected_emergencies_total_div_element_visible == false) {
            return false;
        }
        String uninsured_unexpected_emergencies_total_div_element_text = uninsured_unexpected_emergencies_total_div_element.getText();
        System.out.println("uninsured_unexpected_emergencies_total_div_element_text " + uninsured_unexpected_emergencies_total_div_element_text);
        if (!uninsured_unexpected_emergencies_total_div_element_text.equals(String.valueOf(uninsured_unexpected_emergencies_total))) {
            return false;
        }
        return true;
    }

    public static boolean emergency_fund_calculator_check_annual_amount_of_fixed_payments_total(WebDriver driver, double annual_amount_of_fixed_payments_total) {
        String annual_amount_of_fixed_payments_total_div = locators.money_control_element.get("annual_amount_of_fixed_payments_total_div");
        WebElement annual_amount_of_fixed_payments_total_div_element = SubActivities.find_element_use_xpath(driver, annual_amount_of_fixed_payments_total_div);
        if (annual_amount_of_fixed_payments_total_div_element == null) {
            return false;
        }
        boolean annual_amount_of_fixed_payments_total_div_element_visible = SubActivities.wait_for_element_visible(driver, annual_amount_of_fixed_payments_total_div);
        System.out.println("annual_amount_of_fixed_payments_total_div_element_visible " + annual_amount_of_fixed_payments_total_div_element_visible);
        if (annual_amount_of_fixed_payments_total_div_element_visible == false) {
            return false;
        }
        String annual_amount_of_fixed_payments_total_div_element_text = annual_amount_of_fixed_payments_total_div_element.getText();
        System.out.println("annual_amount_of_fixed_payments_total_div_element_text " + annual_amount_of_fixed_payments_total_div_element_text);
        if (!annual_amount_of_fixed_payments_total_div_element_text.equals(String.valueOf(annual_amount_of_fixed_payments_total))) {
            return false;
        }
        return true;
    }

    public static boolean emergency_fund_calculator_check_build_reserve_to_pay_for_job_loss(WebDriver driver, String build_reserve_to_pay_for_job_loss) {
        String build_reserve_to_pay_for_job_loss_div = locators.money_control_element.get("build_reserve_to_pay_for_job_loss_div");
        WebElement build_reserve_to_pay_for_job_loss_div_element = SubActivities.find_element_use_xpath(driver, build_reserve_to_pay_for_job_loss_div);
        if (build_reserve_to_pay_for_job_loss_div_element == null) {
            return false;
        }
        boolean build_reserve_to_pay_for_job_loss_div_element_visible = SubActivities.wait_for_element_visible(driver, build_reserve_to_pay_for_job_loss_div);
        System.out.println("build_reserve_to_pay_for_job_loss_div_element_visible " + build_reserve_to_pay_for_job_loss_div_element_visible);
        if (build_reserve_to_pay_for_job_loss_div_element_visible == false) {
            return false;
        }
        String build_reserve_to_pay_for_job_loss_div_element_text = build_reserve_to_pay_for_job_loss_div_element.getText();
        System.out.println("build_reserve_to_pay_for_job_loss_div_element_text " + build_reserve_to_pay_for_job_loss_div_element_text);
        if (!build_reserve_to_pay_for_job_loss_div_element_text.equals(build_reserve_to_pay_for_job_loss)) {
            return false;
        }
        return true;
    }

    public static boolean emergency_fund_calculator_check_result(WebDriver driver, String result) {
        String emergency_fund_calculator_result_div = locators.money_control_element.get("emergency_fund_calculator_result_div");
        WebElement emergency_fund_calculator_result_div_element = SubActivities.find_element_use_xpath(driver, emergency_fund_calculator_result_div);
        if (emergency_fund_calculator_result_div_element == null) {
            return false;
        }
        boolean emergency_fund_calculator_result_div_element_visible = SubActivities.wait_for_element_visible(driver, emergency_fund_calculator_result_div);
        System.out.println("emergency_fund_calculator_result_div_element_visible " + emergency_fund_calculator_result_div_element_visible);
        if (emergency_fund_calculator_result_div_element_visible == false) {
            return false;
        }
        String emergency_fund_calculator_result_div_element_text = emergency_fund_calculator_result_div_element.getText();
        System.out.println("emergency_fund_calculator_result_div_element_text " + emergency_fund_calculator_result_div_element_text);

        if (!emergency_fund_calculator_result_div_element_text.contains(result)) {
            return false;
        }
        return true;
    }

    public static boolean provident_fund_calculator_enter_your_age(WebDriver driver, String your_age) {
        String your_age_input = locators.money_control_element.get("your_age_input");
        WebElement your_age_input_element = SubActivities.find_element_use_xpath(driver, your_age_input);
        if (your_age_input_element == null) {
            return false;
        }
        boolean your_age_input_element_visible = SubActivities.wait_for_element_visible(driver, your_age_input);
        System.out.println("your_age_input_element_visible " + your_age_input_element_visible);
        if (your_age_input_element_visible == false) {
            return false;
        }
        your_age_input_element.clear();
        your_age_input_element.sendKeys(your_age);
        return true;
    }

    public static boolean provident_fund_calculator_check_your_age(WebDriver driver, String your_age) {
        String your_age_input = locators.money_control_element.get("your_age_input");
        WebElement your_age_input_element = SubActivities.find_element_use_xpath(driver, your_age_input);
        if (your_age_input_element == null) {
            return false;
        }
        boolean your_age_input_element_visible = SubActivities.wait_for_element_visible(driver, your_age_input);
        System.out.println("your_age_input_element_visible " + your_age_input_element_visible);
        if (your_age_input_element_visible == false) {
            return false;
        }
        String your_age_input_element_value_attribute = your_age_input_element.getAttribute("value");
        System.out.println("your_age_input_element_value_attribute " + your_age_input_element_value_attribute);
        if (!your_age_input_element_value_attribute.equals(your_age)) {
            return false;
        }
        return true;
    }

    public static boolean provident_fund_calculator_enter_your_basic_salary_monthly(WebDriver driver, String your_basic_salary_monthly) {
        String your_basic_salary_monthly_input = locators.money_control_element.get("your_basic_salary_monthly_input");
        WebElement your_basic_salary_monthly_input_element = SubActivities.find_element_use_xpath(driver, your_basic_salary_monthly_input);
        if (your_basic_salary_monthly_input_element == null) {
            return false;
        }
        boolean your_basic_salary_monthly_input_element_visible = SubActivities.wait_for_element_visible(driver, your_basic_salary_monthly_input);
        System.out.println("your_basic_salary_monthly_input_element_visible " + your_basic_salary_monthly_input_element_visible);
        if (your_basic_salary_monthly_input_element_visible == false) {
            return false;
        }
        your_basic_salary_monthly_input_element.clear();
        your_basic_salary_monthly_input_element.sendKeys(your_basic_salary_monthly);
        return true;
    }

    public static boolean provident_fund_calculator_check_your_basic_salary_monthly(WebDriver driver, String your_basic_salary_monthly) {
        String your_basic_salary_monthly_input = locators.money_control_element.get("your_basic_salary_monthly_input");
        WebElement your_basic_salary_monthly_input_element = SubActivities.find_element_use_xpath(driver, your_basic_salary_monthly_input);
        if (your_basic_salary_monthly_input_element == null) {
            return false;
        }
        boolean your_basic_salary_monthly_input_element_visible = SubActivities.wait_for_element_visible(driver, your_basic_salary_monthly_input);
        System.out.println("your_basic_salary_monthly_input_element_visible " + your_basic_salary_monthly_input_element_visible);
        if (your_basic_salary_monthly_input_element_visible == false) {
            return false;
        }
        String your_basic_salary_monthly_input_element_value_attribute = your_basic_salary_monthly_input_element.getAttribute("value");
        System.out.println("your_basic_salary_monthly_input_element_value_attribute " + your_basic_salary_monthly_input_element_value_attribute);
        if (!your_basic_salary_monthly_input_element_value_attribute.equals(your_basic_salary_monthly)) {
            return false;
        }
        return true;
    }

    public static boolean provident_fund_calculator_enter_your_contribution_to_epf(WebDriver driver, String your_contribution_to_epf) {
        String your_contribution_to_epf_input = locators.money_control_element.get("your_contribution_to_epf_input");
        WebElement your_contribution_to_epf_input_element = SubActivities.find_element_use_xpath(driver, your_contribution_to_epf_input);
        if (your_contribution_to_epf_input_element == null) {
            return false;
        }
        boolean your_contribution_to_epf_input_element_visible = SubActivities.wait_for_element_visible(driver, your_contribution_to_epf_input);
        System.out.println("your_contribution_to_epf_input_element_visible " + your_contribution_to_epf_input_element_visible);
        if (your_contribution_to_epf_input_element_visible == false) {
            return false;
        }
        your_contribution_to_epf_input_element.clear();
        your_contribution_to_epf_input_element.sendKeys(your_contribution_to_epf);
        return true;
    }

    public static boolean provident_fund_calculator_check_your_contribution_to_epf(WebDriver driver, String your_contribution_to_epf) {
        String your_contribution_to_epf_input = locators.money_control_element.get("your_contribution_to_epf_input");
        WebElement your_contribution_to_epf_input_element = SubActivities.find_element_use_xpath(driver, your_contribution_to_epf_input);
        if (your_contribution_to_epf_input_element == null) {
            return false;
        }
        boolean your_contribution_to_epf_input_element_visible = SubActivities.wait_for_element_visible(driver, your_contribution_to_epf_input);
        System.out.println("your_contribution_to_epf_input_element_visible " + your_contribution_to_epf_input_element_visible);
        if (your_contribution_to_epf_input_element_visible == false) {
            return false;
        }
        String your_contribution_to_epf_input_element_value_attribute = your_contribution_to_epf_input_element.getAttribute("value");
        System.out.println("your_contribution_to_epf_input_element_value_attribute " + your_contribution_to_epf_input_element_value_attribute);
        if (!your_contribution_to_epf_input_element_value_attribute.equals(your_contribution_to_epf)) {
            return false;
        }
        return true;
    }

    public static boolean provident_fund_calculator_enter_your_employer_contribution_to_epf(WebDriver driver, String your_employer_contribution_to_epf) {
        String your_employer_contribution_to_epf_input = locators.money_control_element.get("your_employer_contribution_to_epf_input");
        WebElement your_employer_contribution_to_epf_input_element = SubActivities.find_element_use_xpath(driver, your_employer_contribution_to_epf_input);
        if (your_employer_contribution_to_epf_input_element == null) {
            return false;
        }
        boolean your_employer_contribution_to_epf_input_element_visible = SubActivities.wait_for_element_visible(driver, your_employer_contribution_to_epf_input);
        System.out.println("your_employer_contribution_to_epf_input_element_visible " + your_employer_contribution_to_epf_input_element_visible);
        if (your_employer_contribution_to_epf_input_element_visible == false) {
            return false;
        }
        your_employer_contribution_to_epf_input_element.clear();
        your_employer_contribution_to_epf_input_element.sendKeys(your_employer_contribution_to_epf);
        return true;
    }


    public static boolean provident_fund_calculator_check_your_employer_contribution_to_epf(WebDriver driver,
                                                                                            String your_employer_contribution_to_epf) {
        String your_employer_contribution_to_epf_input = locators.money_control_element.get("your_employer_contribution_to_epf_input");
        WebElement your_employer_contribution_to_epf_input_element = SubActivities.find_element_use_xpath(driver,
                your_employer_contribution_to_epf_input);
        if (your_employer_contribution_to_epf_input_element == null) {
            return false;
        }
        boolean your_employer_contribution_to_epf_input_element_visible = SubActivities.wait_for_element_visible(driver,
                your_employer_contribution_to_epf_input);
        System.out.println("your_employer_contribution_to_epf_input_element_visible " + your_employer_contribution_to_epf_input_element_visible);
        if (!your_employer_contribution_to_epf_input_element_visible) {
            return false;
        }
        String your_employer_contribution_to_epf_input_element_value_attribute = your_employer_contribution_to_epf_input_element.getAttribute(
                "value");
        System.out.println("your_employer_contribution_to_epf_input_element_value_attribute " + your_employer_contribution_to_epf_input_element_value_attribute);
        if (!your_employer_contribution_to_epf_input_element_value_attribute.equals(your_employer_contribution_to_epf)) {
            return false;
        }
        return true;
    }

    public static boolean provident_fund_calculator_enter_average_annual_increase_in_salary_you_expect(WebDriver driver,
                                                                                                       String average_annual_increase_in_salary_you_expect) {
        String average_annual_increase_in_salary_you_expect_input = locators.money_control_element.get("average_annual_increase_in_salary_you_expect_input");
        WebElement average_annual_increase_in_salary_you_expect_input_element = SubActivities.find_element_use_xpath(driver,
                average_annual_increase_in_salary_you_expect_input);
        if (average_annual_increase_in_salary_you_expect_input_element == null) {
            return false;
        }
        boolean average_annual_increase_in_salary_you_expect_input_element_visible = SubActivities.wait_for_element_visible(
                driver, average_annual_increase_in_salary_you_expect_input);
        System.out.println("average_annual_increase_in_salary_you_expect_input_element_visible " +
                average_annual_increase_in_salary_you_expect_input_element_visible);
        if (!average_annual_increase_in_salary_you_expect_input_element_visible) {
            return false;
        }
        average_annual_increase_in_salary_you_expect_input_element.clear();
        average_annual_increase_in_salary_you_expect_input_element.sendKeys(average_annual_increase_in_salary_you_expect);
        return true;
    }

    public static boolean provident_fund_calculator_check_average_annual_increase_in_salary_you_expect(WebDriver driver,
                                                                                                       String average_annual_increase_in_salary_you_expect) {
        String average_annual_increase_in_salary_you_expect_input = locators.money_control_element.get("average_annual_increase_in_salary_you_expect_input");
        WebElement average_annual_increase_in_salary_you_expect_input_element = SubActivities.find_element_use_xpath(driver,
                average_annual_increase_in_salary_you_expect_input);
        if (average_annual_increase_in_salary_you_expect_input_element == null) {
            return false;
        }
        boolean average_annual_increase_in_salary_you_expect_input_element_visible = SubActivities.wait_for_element_visible(
                driver, average_annual_increase_in_salary_you_expect_input);
        System.out.println("average_annual_increase_in_salary_you_expect_input_element_visible " +
                average_annual_increase_in_salary_you_expect_input_element_visible);
        if (!average_annual_increase_in_salary_you_expect_input_element_visible) {
            return false;
        }
        String average_annual_increase_in_salary_you_expect_input_element_value_attribute = average_annual_increase_in_salary_you_expect_input_element.getAttribute(
                "value");
        System.out.println("average_annual_increase_in_salary_you_expect_input_element_value_attribute " +
                average_annual_increase_in_salary_you_expect_input_element_value_attribute);
        if (!average_annual_increase_in_salary_you_expect_input_element_value_attribute.equals(average_annual_increase_in_salary_you_expect)) {
            return false;
        }
        return true;
    }

    public static boolean provident_fund_calculator_enter_age_when_you_intend_to_retire(WebDriver driver,
                                                                                        String age_when_you_intend_to_retire) {
        String age_when_you_intend_to_retire_input = locators.money_control_element.get("age_when_you_intend_to_retire_input");
        WebElement age_when_you_intend_to_retire_input_element = SubActivities.find_element_use_xpath(driver,
                age_when_you_intend_to_retire_input);
        if (age_when_you_intend_to_retire_input_element == null) {
            return false;
        }
        boolean age_when_you_intend_to_retire_input_element_visible = SubActivities.wait_for_element_visible(driver,
                age_when_you_intend_to_retire_input);
        System.out.println("age_when_you_intend_to_retire_input_element_visible " + age_when_you_intend_to_retire_input_element_visible);
        if (!age_when_you_intend_to_retire_input_element_visible) {
            return false;
        }
        age_when_you_intend_to_retire_input_element.clear();
        age_when_you_intend_to_retire_input_element.sendKeys(age_when_you_intend_to_retire);
        return true;
    }
    public static boolean provident_fund_calculator_check_age_when_you_intend_to_retire(WebDriver driver,
                                                                                        String age_when_you_intend_to_retire) {
        String age_when_you_intend_to_retire_input = locators.money_control_element.get("age_when_you_intend_to_retire_input");
        WebElement age_when_you_intend_to_retire_input_element = SubActivities.find_element_use_xpath(driver,
                age_when_you_intend_to_retire_input);
        if (age_when_you_intend_to_retire_input_element == null) {
            return false;
        }
        boolean age_when_you_intend_to_retire_input_element_visible = SubActivities.wait_for_element_visible(driver,
                age_when_you_intend_to_retire_input);
        System.out.println("age_when_you_intend_to_retire_input_element_visible " + age_when_you_intend_to_retire_input_element_visible);
        if (!age_when_you_intend_to_retire_input_element_visible) {
            return false;
        }
        String age_when_you_intend_to_retire_input_element_value_attribute = age_when_you_intend_to_retire_input_element.getAttribute(
                "value");
        System.out.println("age_when_you_intend_to_retire_input_element_value_attribute " + age_when_you_intend_to_retire_input_element_value_attribute);
        if (!age_when_you_intend_to_retire_input_element_value_attribute.equals(age_when_you_intend_to_retire)) {
            return false;
        }
        return true;
    }

    public static boolean provident_fund_calculator_enter_current_epf_balance_if_any(WebDriver driver,
                                                                                     String current_epf_balance_if_any) {
        String current_epf_balance_if_any_input = locators.money_control_element.get("current_epf_balance_if_any_input");
        WebElement current_epf_balance_if_any_input_element = SubActivities.find_element_use_xpath(driver,
                current_epf_balance_if_any_input);
        if (current_epf_balance_if_any_input_element == null) {
            return false;
        }
        boolean current_epf_balance_if_any_input_element_visible = SubActivities.wait_for_element_visible(driver,
                current_epf_balance_if_any_input);
        System.out.println("current_epf_balance_if_any_input_element_visible " + current_epf_balance_if_any_input_element_visible);
        if (!current_epf_balance_if_any_input_element_visible) {
            return false;
        }
        current_epf_balance_if_any_input_element.clear();
        current_epf_balance_if_any_input_element.sendKeys(current_epf_balance_if_any);
        return true;
    }
    public static boolean provident_fund_calculator_check_current_epf_balance_if_any(WebDriver driver,
                                                                                     String current_epf_balance_if_any) {
        String current_epf_balance_if_any_input = locators.money_control_element.get("current_epf_balance_if_any_input");
        WebElement current_epf_balance_if_any_input_element = SubActivities.find_element_use_xpath(driver,
                current_epf_balance_if_any_input);
        if (current_epf_balance_if_any_input_element == null) {
            return false;
        }
        boolean current_epf_balance_if_any_input_element_visible = SubActivities.wait_for_element_visible(driver,
                current_epf_balance_if_any_input);
        System.out.println("current_epf_balance_if_any_input_element_visible " + current_epf_balance_if_any_input_element_visible);
        if (!current_epf_balance_if_any_input_element_visible) {
            return false;
        }
        String current_epf_balance_if_any_input_element_value_attribute = current_epf_balance_if_any_input_element.getAttribute(
                "value");
        System.out.println("current_epf_balance_if_any_input_element_value_attribute " + current_epf_balance_if_any_input_element_value_attribute);
        if (!current_epf_balance_if_any_input_element_value_attribute.equals(current_epf_balance_if_any)) {
            return false;
        }
        return true;
    }
    public static boolean provident_fund_calculator_enter_current_interest_rate(WebDriver driver, double current_interest_rate) {
        String current_interest_rate_input = locators.money_control_element.get("current_interest_rate_input");
        WebElement current_interest_rate_input_element = SubActivities.find_element_use_xpath(driver, current_interest_rate_input);
        if (current_interest_rate_input_element == null) {
            return false;
        }
        boolean current_interest_rate_input_element_visible = SubActivities.wait_for_element_visible(driver, current_interest_rate_input);
        System.out.println("current_interest_rate_input_element_visible " + current_interest_rate_input_element_visible);
        if (current_interest_rate_input_element_visible == false) {
            return false;
        }
        current_interest_rate_input_element.clear();
        current_interest_rate_input_element.sendKeys(String.valueOf(current_interest_rate));
        return true;
    }

    public static boolean provident_fund_calculator_check_current_interest_rate(WebDriver driver, double current_interest_rate) {
        String current_interest_rate_input = locators.money_control_element.get("current_interest_rate_input");
        WebElement current_interest_rate_input_element = SubActivities.find_element_use_xpath(driver, current_interest_rate_input);
        if (current_interest_rate_input_element == null) {
            return false;
        }
        boolean current_interest_rate_input_element_visible = SubActivities.wait_for_element_visible(driver, current_interest_rate_input);
        System.out.println("current_interest_rate_input_element_visible " + current_interest_rate_input_element_visible);
        if (current_interest_rate_input_element_visible == false) {
            return false;
        }
        String current_interest_rate_input_element_value_attribute = current_interest_rate_input_element.getAttribute("value");
        System.out.println("current_interest_rate_input_element_value_attribute " + current_interest_rate_input_element_value_attribute);
        if (!current_interest_rate_input_element_value_attribute.equals(String.valueOf(current_interest_rate))) {
            return false;
        }
        return true;
    }

    public static boolean provident_fund_calculator_click_submit_button(WebDriver driver) {
        String pf_calculator_calculate_button = locators.money_control_element.get("pf_calculator_calculate_button");
        WebElement pf_calculator_calculate_button_element = SubActivities.find_element_use_xpath(driver, pf_calculator_calculate_button);
        if (pf_calculator_calculate_button_element == null) {
            return false;
        }
        boolean pf_calculator_calculate_button_element_visible = SubActivities.wait_for_element_visible(driver, pf_calculator_calculate_button);
        System.out.println("pf_calculator_calculate_button_element_visible " + pf_calculator_calculate_button_element_visible);
        if (pf_calculator_calculate_button_element_visible == false) {
            return false;
        }
        pf_calculator_calculate_button_element.click();
        return true;
    }

    public static boolean provident_fund_calculator_check_result(WebDriver driver, String result) {
        String pf_cal_result_div = locators.money_control_element.get("pf_cal_result_div");
        WebElement pf_cal_result_div_element = SubActivities.find_element_use_xpath(driver, pf_cal_result_div);
        if (pf_cal_result_div_element == null) {
            return false;
        }
        boolean pf_cal_result_div_element_visible = SubActivities.wait_for_element_visible(driver, pf_cal_result_div);
        System.out.println("pf_cal_result_div_element_visible " + pf_cal_result_div_element_visible);
        if (pf_cal_result_div_element_visible == false) {
            return false;
        }
        String pf_cal_result_div_element_text = pf_cal_result_div_element.getText();
        System.out.println("pf_cal_result_div_element_text " + pf_cal_result_div_element_text);
        if (!pf_cal_result_div_element_text.contains(result)) {
            return false;
        }
        return true;
    }

    public static boolean debt_reduction_plan_calculator_enter_total_debt_outstanding(WebDriver driver, double total_debt_outstanding) {
        String total_debt_outstanding_input = locators.money_control_element.get("total_debt_outstanding_input");
        WebElement total_debt_outstanding_input_element = SubActivities.find_element_use_xpath(driver, total_debt_outstanding_input);
        if (total_debt_outstanding_input_element == null) {
            return false;
        }
        boolean total_debt_outstanding_input_element_visible = SubActivities.wait_for_element_visible(driver, total_debt_outstanding_input);
        System.out.println("total_debt_outstanding_input_element_visible " + total_debt_outstanding_input_element_visible);
        if (total_debt_outstanding_input_element_visible == false) {
            return false;
        }
        total_debt_outstanding_input_element.clear();
        total_debt_outstanding_input_element.sendKeys(String.valueOf(total_debt_outstanding));
        return true;
    }

    public static boolean debt_reduction_plan_calculator_check_total_debt_outstanding(WebDriver driver, double total_debt_outstanding) {
        String total_debt_outstanding_input = locators.money_control_element.get("total_debt_outstanding_input");
        WebElement total_debt_outstanding_input_element = SubActivities.find_element_use_xpath(driver, total_debt_outstanding_input);
        if (total_debt_outstanding_input_element == null) {
            return false;
        }
        boolean total_debt_outstanding_input_element_visible = SubActivities.wait_for_element_visible(driver, total_debt_outstanding_input);
        System.out.println("total_debt_outstanding_input_element_visible " + total_debt_outstanding_input_element_visible);
        if (total_debt_outstanding_input_element_visible == false) {
            return false;
        }
        String total_debt_outstanding_input_element_value_attribute = total_debt_outstanding_input_element.getAttribute("value");
        System.out.println("total_debt_outstanding_input_element_value_attribute " + total_debt_outstanding_input_element_value_attribute);
        if (!total_debt_outstanding_input_element_value_attribute.equals(String.valueOf(total_debt_outstanding))) {
            return false;
        }
        return true;
    }

    public static boolean debt_reduction_plan_calculator_enter_rate_of_interest_per_annum(WebDriver driver, double rate_of_interest_per_annum) {
        String rate_of_interest_per_annum_input = locators.money_control_element.get("rate_of_interest_per_annum_input");
        WebElement rate_of_interest_per_annum_input_element = SubActivities.find_element_use_xpath(driver, rate_of_interest_per_annum_input);
        if (rate_of_interest_per_annum_input_element == null) {
            return false;
        }
        boolean rate_of_interest_per_annum_input_element_visible = SubActivities.wait_for_element_visible(driver, rate_of_interest_per_annum_input);
        System.out.println("rate_of_interest_per_annum_input_element_visible " + rate_of_interest_per_annum_input_element_visible);
        if (rate_of_interest_per_annum_input_element_visible == false) {
            return false;
        }
        rate_of_interest_per_annum_input_element.clear();
        rate_of_interest_per_annum_input_element.sendKeys(String.valueOf(rate_of_interest_per_annum));
        return true;
    }

    public static boolean debt_reduction_plan_calculator_check_rate_of_interest_per_annum(WebDriver driver, double rate_of_interest_per_annum) {
        String rate_of_interest_per_annum_input = locators.money_control_element.get("rate_of_interest_per_annum_input");
        WebElement rate_of_interest_per_annum_input_element = SubActivities.find_element_use_xpath(driver, rate_of_interest_per_annum_input);
        if (rate_of_interest_per_annum_input_element == null) {
            return false;
        }
        boolean rate_of_interest_per_annum_input_element_visible = SubActivities.wait_for_element_visible(driver, rate_of_interest_per_annum_input);
        System.out.println("rate_of_interest_per_annum_input_element_visible " + rate_of_interest_per_annum_input_element_visible);
        if (rate_of_interest_per_annum_input_element_visible == false) {
            return false;
        }
        String rate_of_interest_per_annum_input_element_value_attribute = rate_of_interest_per_annum_input_element.getAttribute("value");
        System.out.println("rate_of_interest_per_annum_input_element_value_attribute " + rate_of_interest_per_annum_input_element_value_attribute);
        if (!rate_of_interest_per_annum_input_element_value_attribute.equals(String.valueOf(rate_of_interest_per_annum))) {
            return false;
        }
        return true;
    }

    public static boolean debt_reduction_plan_calculator_enter_how_much_can_you_repay_every_month(WebDriver driver, double how_much_can_you_repay_every_month) {
        String how_much_can_you_repay_every_month_input = locators.money_control_element.get("how_much_can_you_repay_every_month_input");
        WebElement how_much_can_you_repay_every_month_input_element = SubActivities.find_element_use_xpath(driver, how_much_can_you_repay_every_month_input);
        if (how_much_can_you_repay_every_month_input_element == null) {
            return false;
        }
        boolean how_much_can_you_repay_every_month_input_element_visible = SubActivities.wait_for_element_visible(driver, how_much_can_you_repay_every_month_input);
        System.out.println("how_much_can_you_repay_every_month_input_element_visible " + how_much_can_you_repay_every_month_input_element_visible);
        if (how_much_can_you_repay_every_month_input_element_visible == false) {
            return false;
        }
        how_much_can_you_repay_every_month_input_element.clear();
        how_much_can_you_repay_every_month_input_element.sendKeys(String.valueOf(how_much_can_you_repay_every_month));
        return true;
    }

    public static boolean debt_reduction_plan_calculator_check_how_much_can_you_repay_every_month(WebDriver driver, String how_much_can_you_repay_every_month) {
        String how_much_can_you_repay_every_month_input = locators.money_control_element.get("how_much_can_you_repay_every_month_input");
        WebElement how_much_can_you_repay_every_month_input_element = SubActivities.find_element_use_xpath(driver, how_much_can_you_repay_every_month_input);
        if (how_much_can_you_repay_every_month_input_element == null) {
            return false;
        }
        boolean how_much_can_you_repay_every_month_input_element_visible = SubActivities.wait_for_element_visible(driver, how_much_can_you_repay_every_month_input);
        System.out.println("how_much_can_you_repay_every_month_input_element_visible " + how_much_can_you_repay_every_month_input_element_visible);
        if (how_much_can_you_repay_every_month_input_element_visible == false) {
            return false;
        }
        String how_much_can_you_repay_every_month_input_element_value_attribute = how_much_can_you_repay_every_month_input_element.getAttribute("value");
        System.out.println("how_much_can_you_repay_every_month_input_element_value_attribute " + how_much_can_you_repay_every_month_input_element_value_attribute);
        if (!how_much_can_you_repay_every_month_input_element_value_attribute.equals(how_much_can_you_repay_every_month)) {
            return false;
        }
        return true;
    }

    public static boolean debt_reduction_plan_calculator_click_calculate_button(WebDriver driver) {
        String debt_reduction_plan_calculator_calculate_button = locators.money_control_element.get("debt_reduction_plan_calculator_calculate_button");
        WebElement debt_reduction_plan_calculator_calculate_button_element = SubActivities.find_element_use_xpath(driver, debt_reduction_plan_calculator_calculate_button);
        if (debt_reduction_plan_calculator_calculate_button_element == null) {
            return false;
        }
        boolean debt_reduction_plan_calculator_calculate_button_element_visible = SubActivities.wait_for_element_visible(driver, debt_reduction_plan_calculator_calculate_button);
        System.out.println("debt_reduction_plan_calculator_calculate_button_element_visible " + debt_reduction_plan_calculator_calculate_button_element_visible);
        if (debt_reduction_plan_calculator_calculate_button_element_visible == false) {
            return false;
        }
        debt_reduction_plan_calculator_calculate_button_element.click();
        return true;
    }

    public static boolean debt_reduction_plan_calculator_check_result(WebDriver driver, String result) {
        String debt_reduction_plan_calculator_result_div = locators.money_control_element.get("debt_reduction_plan_calculator_result_div");
        WebElement debt_reduction_plan_calculator_result_div_element = SubActivities.find_element_use_xpath(driver, debt_reduction_plan_calculator_result_div);
        if (debt_reduction_plan_calculator_result_div_element == null) {
            return false;
        }
        boolean debt_reduction_plan_calculator_result_div_element_visible = SubActivities.wait_for_element_visible(driver, debt_reduction_plan_calculator_result_div);
        System.out.println("debt_reduction_plan_calculator_result_div_element_visible " + debt_reduction_plan_calculator_result_div_element_visible);
        if (debt_reduction_plan_calculator_result_div_element_visible == false) {
            return false;
        }
        String debt_reduction_plan_calculator_result_div_element_text = debt_reduction_plan_calculator_result_div_element.getText();
        System.out.println("debt_reduction_plan_calculator_result_div_element_text " + debt_reduction_plan_calculator_result_div_element_text);

        if (!debt_reduction_plan_calculator_result_div_element_text.contains(result)) {
            return false;
        }
        return true;
    }


























}


