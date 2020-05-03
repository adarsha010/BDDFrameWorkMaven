package com.www.runners;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/test/resources" }, glue = { "classpath:www.com.stepdefinations" }, plugin = {
			"pretty", "html:target/reports/cucumber",
			"junit:build/reports/junit.xml",
			"json:build/reports/cucumber.json" }, tags = { "@google" })
	public class MyTestNGCukesRunner extends AbstractTestNGCucumberTests {

	final static Logger logger = Logger.getLogger(MyTestNGCukesRunner.class);
		@BeforeClass
		public static void setup() {
			logger.info("GOOGLE TESTNG RUNNER - within @BeforeClass setup() block");

		}
}
