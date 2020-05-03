package com.www.utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.www.browser.Browser;

public class SeleniumUtils {

	static JavascriptExecutor js =((JavascriptExecutor)Browser.driver);
	final static Logger logger = Logger.getLogger(SeleniumUtils.class);


	public static void clickOnElemnet(WebElement ele,String WebElementName) {
		WaitUtils.waitTillElementClickable(ele);
		ele.click();
		logger.info(WebElementName + " is clicked");
	}
		
	public static void enterTextinField(WebElement ele,String value) {
		ele.sendKeys(value);
		logger.info(" Value entered in text field and is " +value );	
	}
	
	public static void jsClick(WebElement ele) {
		js.executeScript("arguments[0].click();", ele);	
		logger.info(" Element is clicked using java script");	
		
	}
	
	public static void enterValue(String id, String value) {
		js.executeScript("document.getElementById('"+id+"').value='"+value+"';");
		logger.info(" Value is enetered using Java script");
	}

	// IFRAME wrapper utility methods

	public static void switchToIframeById(String Id) {
		Browser.driver.switchTo().frame(Id);
		logger.info("Moved into iframe having the locator having id: " +Id );
	}

	public static void switchToIframeByName(String name) {
		Browser.driver.switchTo().frame(name);
		logger.info("Moved into iframe having the locator having name: " +name );
	}

	public static void switchToIframeByName(WebElement ele, String name) {
		Browser.driver.switchTo().frame(ele);
		logger.info("Moved into iframe : " + name);
	}
	public static void switchToMainWindow(WebElement ele) {
		Browser.driver.switchTo().defaultContent();
		logger.info("Moved control Back to main Window");
	}

}
