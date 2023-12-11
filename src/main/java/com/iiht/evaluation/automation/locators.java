package com.iiht.evaluation.automation;

import java.util.HashMap;
import java.util.Map;

public class locators {
    public static final Map<String, String> money_control_element = new HashMap<>();

    static {
        money_control_element.put("login_link", "//a[contains(@title,'Login') and @class='userlink']");
        money_control_element.put("login_signup_box", "//div[@class='log_signupbox']");
        money_control_element.put("signup_box_login_link", "(//div[@class='log_signupbox']/descendant::a[contains(@class,'linkSignIn')])[1]");
        money_control_element.put("login_signin_iframe", "//iframe[@id='myframe']");
        money_control_element.put("login_signin_box", "//div[@id='mc_login']");
        money_control_element.put("signin_box_email_field", "//div[@id='mc_login']/descendant::input[@name='email']");
        money_control_element.put("signin_box_password_field", "//div[@id='mc_login']/descendant::input[@name='pwd']");
        money_control_element.put("signin_box_login_button", "//div[@id='mc_login']/descendant::button[@type='submit']");
        money_control_element.put("logged_in_user_link", "//div[contains(@class,'user_after_login')]/descendant::a[@class='userlink']");
        money_control_element.put("signin_box_error_div", "//div[@id='mc_login']/descendant::div[contains(@class,'mclog_error')]");

        money_control_element.put("main_menu", "//div[contains(@class,'bottom_nav')]/descendant::li[contains(@class,'menu_l')]/a[@title='$(main_menu)']");
        money_control_element.put("sub_menu", "//ul[contains(@class,'market_listmenu')]/descendant::a[@title='$(sub_menu)']");

        money_control_element.put("investment_amount_input", "//input[@id='edulonvalue_1']");
        money_control_element.put("investment_period_input", "//input[@id='edulonvalue_2']");
        money_control_element.put("rate_of_return_input", "//input[@id='edulonvalue_3']");
        money_control_element.put("interest_frequency_radio", "//span[text()='$(interest_frequency)']/preceding-sibling::input[@type='radio']");
        money_control_element.put("tax_rate_input", "//input[@id='edulonvalue_4']");
        money_control_element.put("submit_button", "//a[text()='Submit']");
        money_control_element.put("reset_button", "//a[text()='Reset']");
        money_control_element.put("total_payment_span", "//div[@class='result_block']/following-sibling::div/descendant::div[@class='subContent' and text()='Total Payment']/preceding-sibling::span[1]");
        money_control_element.put("total_interest_span", "//div[@class='result_block']/following-sibling::div/descendant::div[@class='subContent' and text()='Total Interest']/preceding-sibling::span[1]");
        money_control_element.put("total_corpus_span", "//div[@class='result_block']/following-sibling::div/descendant::div[@class='subContent' and text()='Total Corpus']/preceding-sibling::span[1]");
        money_control_element.put("post_tax_amount_span", "//div[@class='result_block']/following-sibling::div/descendant::div[@class='subContent' and text()='Post Tax Amount']/preceding-sibling::span[1]");

        money_control_element.put("medical_dental_cost_input", "//input[@name='medical_dental_costs']");
        money_control_element.put("vehicle_repair_input", "//input[@name='vehicle_repairs']");
        money_control_element.put("others_input", "//input[@name='others']");
        money_control_element.put("life_health_insurance_premium_input", "//input[@name='life_insurance_premium']");
        money_control_element.put("home_auto_insurance_premium_input", "//input[@name='medical_insurance_premium']");
        money_control_element.put("home_loan_other_important_emis_input", "//input[@name='home_auto_insurance_premium']");
        money_control_element.put("monthly_living_expenses_input", "//input[@name='monthly_living_expenses']");
        money_control_element.put("month_unemployed_input", "//input[@name='month_unemployed']");
        money_control_element.put("calculate_button", "//img[contains(@src,'calculate')]/parent::a");
        money_control_element.put("emergency_fund_calculator_result_div", "//div[@id='result']");
        money_control_element.put("uninsured_unexpected_emergencies_total_div", "//div[@id='uninsured']");
        money_control_element.put("annual_amount_of_fixed_payments_total_div", "//div[@id='insurance']");
        money_control_element.put("build_reserve_to_pay_for_job_loss_div", "//div[@id='unemploy']");

        money_control_element.put("loan_amount_input", "//input[@id='carhome_loan']");
        money_control_element.put("loan_period_input", "//input[@id='loan_period']");
        money_control_element.put("upfront_charges_input", "//input[@id='upfront_charges']");
        money_control_element.put("interest_rate_input", "//input[@id='interest_rate']");
        money_control_element.put("submit_button_link", "//a[text()='Submit']");
        money_control_element.put("reset_button_link", "//a[text()='Reset']");
        money_control_element.put("total_payment_li_span", "//span[@id='total_payment']");
        money_control_element.put("interest_charges_payment_li_span", "//span[@id='interest_charges']");
        money_control_element.put("emi_li_span", "//span[@id='emi']");

        money_control_element.put("your_age_input", "//input[@id='id_your_age']");
        money_control_element.put("your_basic_salary_monthly_input", "//input[@name='basic_salary_monthly']");
        money_control_element.put("your_contribution_to_epf_input", "//input[@name='your_contribution']");
        money_control_element.put("your_employer_contribution_to_epf_input", "//input[@name='employers_contribuion']");
        money_control_element.put("average_annual_increase_in_salary_you_expect_input", "//input[@name='annual_increase_in_salary']");
        money_control_element.put("age_when_you_intend_to_retire_input", "//input[@name='intend_to_retire']");
        money_control_element.put("current_epf_balance_if_any_input", "//input[@name='current_epf_balance']");
        money_control_element.put("current_interest_rate_input", "//input[@name='current_interest_rate']");
        money_control_element.put("pf_calculator_calculate_button", "//img[contains(@src,'calculate')]/parent::a");
        money_control_element.put("pf_cal_result_div", "//div[@id='result_epf']");

        money_control_element.put("total_debt_outstanding_input", "//input[@name='total_debt_outstanding']");
        money_control_element.put("rate_of_interest_per_annum_input", "//input[@name='rate_of_interest']");
        money_control_element.put("how_much_can_you_repay_every_month_input", "//input[@name='repay_every_month']");
        money_control_element.put("debt_reduction_plan_calculator_calculate_button", "//img[contains(@src,'calculate')]");
        money_control_element.put("debt_reduction_plan_calculator_result_div", "//div[@id='result']");
    }
}
