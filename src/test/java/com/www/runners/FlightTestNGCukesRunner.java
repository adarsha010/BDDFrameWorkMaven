package com.www.runners;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/test/resources" }, glue = { "classpath:www.com.stepdefinations" }, plugin = {
			"pretty", "html:target/reports/cucumber",
			"junit:build/reports/junit.xml",
			"json:build/reports/cucumber.json" }, tags = { "@custom1" })
	public class FlightTestNGCukesRunner extends AbstractTestNGCucumberTests {

	final static Logger logger = Logger.getLogger(FlightTestNGCukesRunner.class);
		@BeforeClass
		public static void setup() {
			logger.info("FLGHT TESTNG RUNNER - within @BeforeClass setup() block");

		}
}
