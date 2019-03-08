package com.cucumbercraft.stepdefinitions;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.cucumber.listener.Reporter;
import com.cucumbercraft.framework.DriverManager;
import com.cucumbercraft.framework.Settings;
import com.cucumbercraft.framework.TestHarness;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CukeHooks extends MasterStepDefs {

	static Logger log = Logger.getLogger(CukeHooks.class);

	static Properties propertiesFile = Settings.getInstance();
	private TestHarness testHarness;

	@Before
	public void setUp(Scenario scenario) {

		testHarness = new TestHarness();
		Reporter.addScenarioLog(scenario.getName());
		currentScenario = scenario;
		properties = propertiesFile;
		DriverManager.getTestParameters().setScenarioName(scenario.getName());
		testHarness.invokeDriver(scenario);
	}

	@After
	public void tearDown(Scenario scenario) throws IOException {

		testHarness.updateDefectInJira(scenario);
		testHarness.downloadAddtionalReports(scenario);
		testHarness.closeRespestiveDriver(scenario);
	}

}