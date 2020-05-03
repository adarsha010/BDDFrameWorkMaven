package com.www.utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.www.browser.Browser;

public class WaitUtils {

	public static WebDriverWait wait = new WebDriverWait(Browser.driver,2000);
	final static Logger logger = Logger.getLogger(WaitUtils.class);
	
	public static void waitTillElementClickable(WebElement ele) {
		
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		logger.info("Element is now Clickable ");
	}
	
	
	public static void waitTillElementVisible(WebElement ele) {
		
		wait.until(ExpectedConditions.visibilityOf(ele));
		logger.info("Element is now Visible ");
	}

	public static void waitTillElementInvisibleVisible(WebElement ele) {

		wait.until(ExpectedConditions.invisibilityOf(ele));
		logger.info("Element is now Visible ");
	}

	public static void waitTillElementGetsInvisible(WebElement ele) {
		
		wait.until(ExpectedConditions.invisibilityOf(ele));
		logger.info("Element is now disspeared");
	}
}
