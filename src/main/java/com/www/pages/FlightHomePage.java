package com.www.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.www.browser.Browser;
import com.www.utilities.SeleniumUtils;
import com.www.utilities.WaitUtils;

public class FlightHomePage {
	
	final static Logger logger = Logger.getLogger(FlightHomePage.class);

	@FindBy(css="a#airli")
	public WebElement flightMenu;
	
	@FindBy(css="input[name='fsc-origin-search']")
	public WebElement fromField;
	
	@FindBy(css="input[name='fsc-destination-search']")
	public WebElement toField;
	
	@FindBy(xpath="//div[@class='shelf-tiles']/div[@class='tile third full indent']//a")
	public WebElement firstPlace;
	
	@FindBy(xpath="//button[@aria-label='Search flights']")
	public WebElement searchFlights;
	
	
	@FindBy(css="input[value='Log In']")
	public WebElement subMit_BTN;
	
	@FindBy(css="div#header-list-count>div>span")
	public WebElement searched_Resulta_Txt;
	
	public FlightHomePage() {
		PageFactory.initElements(Browser.driver,this);
	}
	
	public void goToFlightSections() {
		WaitUtils.waitTillElementVisible(flightMenu);
		SeleniumUtils.clickOnElemnet(flightMenu,"flightMenu");
		logger.info("Click On flightMenu");
		
	}
	
	public void choosegoToPlace() {
		WaitUtils.waitTillElementClickable(toField);
		SeleniumUtils.clickOnElemnet(toField,"toField");
		WebElement elementName =null;
		for(int j=0; j<5;j++)
			try {
			    elementName=Browser.driver.findElement(By.name("fsc-destination-search"));
				
			    break;
			} catch(StaleElementReferenceException e){
			e.toString();
			System.out.println(e.getMessage());
			}
		elementName.sendKeys("Goa (GOI)");
		logger.info("Entered the value to To Field");
		searchFlights.click();
		logger.info("Click On Search Flights");
	}
}
