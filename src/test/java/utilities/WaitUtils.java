package utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils extends BaseTest {

	public WebDriverWait wait = new WebDriverWait(driver,10);
	final static Logger logger = Logger.getLogger(WaitUtils.class);
	
	public  void waitTillElementClickable(WebElement ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		logger.info("Element is now Clickable ");
	}
	
	
	public  void waitTillElementVisible(WebElement ele) {
		wait.until(ExpectedConditions.visibilityOf(ele));
		logger.info("Element is now Visible ");
	}

	public void waitUntillPageLoad() {
		wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
		logger.info("Element is now Visible ");
	}


	public void waitTillElementInvisibleVisible(WebElement ele) {

		wait.until(ExpectedConditions.invisibilityOf(ele));
		logger.info("Element is now Visible ");
	}

	public void waitTillElementGetsVisible(WebElement ele) {
		
		wait.until(ExpectedConditions.visibilityOf(ele));
		logger.info("Element is no more visible");
	}
}
