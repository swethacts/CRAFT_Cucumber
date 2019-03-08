package com.cucumbercraft.stepdefinitions;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cucumbercraft.framework.DriverManager;
import com.cucumbercraft.framework.Util;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefs extends MasterStepDefs {
	
	static Logger log = Logger.getLogger(LoginStepDefs.class);

	WebDriver driver = DriverManager.getWebDriver();

	
	@When("^I login using the invalid username (.*) and the invalid password (.*)$")
	public void i_login_using_invalid_username_invalid_password(String userName, String password) {
		login(userName, password);
	}
	
	@When("^I login using the valid username (.*) and the invalid password (.*)$")
	public void i_login_using_valid_username_invalid_password(String userName, String password) {
		login(userName, password);
	}
	
	@When("^I login using the valid username (.*) and the valid password (.*)$")
	public void i_login_using_valid_username_valid_password(String userName, String password) {
		login(userName, password);
	}
	
	private void login(String userName, String password) {
		driver.findElement(By.name("userName")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		
		currentScenario.embed(Util.takeScreenshot(driver), "image/png");
		
		driver.findElement(By.name("login")).click();
	}
	
	@And("^I click on the sign in link$")
	public void i_click_on_signin_link() {
		driver.findElement(By.linkText("sign-in")).click();
	}
	
	@Then("^The application should stay on the login page, and not log me in")
	public void application_should_stay_on_login_page() {
		currentScenario.embed(Util.takeScreenshot(driver), "image/png");
		
		assertTrue(driver.getTitle().contains("Sign-on") || driver.getTitle().contains("Welcome"));
	}
	
	@Then("^The application should log me in and navigate to the Flight Finder page")
	public void application_should_login_navigate_to_FlightFinder_page() {
		currentScenario.embed(Util.takeScreenshot(driver), "image/png");
		
		assertTrue(driver.getTitle().contains("Find a Flight"), "Find a Flight page displayed?");
	}
}
