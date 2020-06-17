package utilities;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

public class SeleniumUtils extends BaseTest {

	PropertyUtil pu =new PropertyUtil();
	ValidationUtils vu =new ValidationUtils();
	WaitUtils wu =new WaitUtils();

	JavascriptExecutor js =((JavascriptExecutor)driver);
	TakesScreenshot ts=(TakesScreenshot)driver;
	final static Logger logger = Logger.getLogger(SeleniumUtils.class);
	Actions actObj= new Actions(driver);
	public void clickOnElement(WebElement ele,String WebElementName) {
		wu.waitTillElementClickable(ele);
		ele.click();
		logger.info(WebElementName + " is clicked");
	}
		
	public void enterTextinField(WebElement ele,String value) {
		wu.waitTillElementVisible(ele);
		ele.sendKeys(value);
		logger.info(" Value entered in text field and is " +value );	
	}

	public void jsClick(WebElement ele) {
		js.executeScript("arguments[0].click();", ele);	
		logger.info(" Element is clicked using java script");	
		
	}
	
	public void enterValue(String id, String value) {
		js.executeScript("document.getElementById('"+id+"').value='"+value+"';");
		logger.info(" Value is enetered using Java script");
	}

	// IFRAME wrapper utility methods

	public void switchToIframeById(String Id) {
		driver.switchTo().frame(Id);
		logger.info("Moved into iframe having the locator having id: " +Id );
	}

	public void switchToIframeByName(String name) {
		driver.switchTo().frame(name);
		logger.info("Moved into iframe having the locator having name: " +name );
	}

	public void switchToIframeByName(WebElement ele, String name) {
		Select sel = new Select(ele);
		sel.
		driver.switchTo().frame(ele);
		logger.info("Moved into iframe : " + name);
	}
	public void switchToMainWindow() {
		driver.switchTo().defaultContent();
		logger.info("Moved control Back to main Window");
	}

	// Browser
	public void refreshBrowser(int iteration) {
		while(iteration<1){
			driver.navigate().refresh();
		}
	}

	public void captureScreenShot(String scenarioName) {
		try{
			File source=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshots/"+scenarioName+".png"));
		}catch (Exception e){
			logger.info("SCREEN **** CAPTURED *** ON FAILURE *****");
		}
	}

	// Action class related

	public void mouseHoverAndClickOnElement(WebElement ele){
		actObj.moveToElement(ele).click().perform();
	}


}
