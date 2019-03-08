package com.cucumbercraft.stepdefinitions;

import org.apache.log4j.Logger;

import com.cucumber.listener.Reporter;
import com.cucumbercraft.framework.DriverManager;
import com.cucumbercraft.pages.EriBankPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;

public class EribankLogin extends MasterStepDefs {

	static Logger log = Logger.getLogger(EribankLogin.class);
	@SuppressWarnings("rawtypes")
	AppiumDriver driver = DriverManager.getAppiumDriver();
	EriBankPage eribankPage = new EriBankPage();

	@Given("^I launch eribank$")
	public void i_launch_eribank() throws Throwable {
		if (eribankPage.txtUsername.isDisplayed()) {
			log.info("Launched the Application");
			Reporter.addStepLog("Launched the Application");
		}
	}

	@When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_and(String userName, String password) throws Throwable {
		eribankPage.txtUsername.sendKeys(userName);
		eribankPage.txtPassword.sendKeys(password);
	}

	@Then("^I click LOGIN$")
	public void i_click_LOGIN() throws Throwable {
		eribankPage.btnLogin.click();
	}

	@Then("^I click LOGOUT$")
	public void i_click_LOGOUT() throws Throwable {
		eribankPage.btnLogout.click();
	}
}
