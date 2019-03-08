package com.cucumbercraft.stepdefinitions;

import org.apache.log4j.Logger;

import com.cucumbercraft.framework.DriverManager;
import com.cucumbercraft.pages.EriBankPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;

public class EribankPayment extends MasterStepDefs {

	static Logger log = Logger.getLogger(EribankPayment.class);
	@SuppressWarnings("rawtypes")
	AppiumDriver driver = DriverManager.getAppiumDriver();
	EriBankPage eribankPage = new EriBankPage();

	@When("^I click Make Payment$")
	public void i_click_Make_Payment() throws Throwable {
		eribankPage.btnMakePayment.click();
	}

	@When("^I enter Phone number as \"([^\"]*)\" name as \"([^\"]*)\" Amount as \"([^\"]*)\"$")
	public void i_enter_Phone_number_as_name_as_Amount_as(String phone, String name, String amount) throws Throwable {
		eribankPage.txtPhone.sendKeys(phone);
		eribankPage.txtName.sendKeys(name);
		eribankPage.txtAmount.sendKeys(amount);
	}

	@Then("^I select country as \"([^\"]*)\"$")
	public void i_select_country_as(String country) throws Throwable {
		driver.hideKeyboard();
		eribankPage.btnCountrySelect.click();
		eribankPage.btnCountryValue.click();
	}

	@Then("^click Send Payment$")
	public void click_Send_Payment() throws Throwable {
		eribankPage.btnSendPayment.click();
		eribankPage.btnYes.click();
		driver.navigate().back();
	}
}
