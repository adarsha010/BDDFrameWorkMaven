package com.www.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.www.browser.Browser;
import com.www.utilities.PropertyUtil;
import com.www.utilities.WaitUtils;

public class SignUpPage {

	final static Logger logger = Logger.getLogger(SignUpPage.class);
	
	@FindBy(id="email")
	public WebElement userName;
	
	@FindBy(id="pass")
	public WebElement passwordField;
	
	@FindBy(css="input[value='Log In']")
	public WebElement subMit_BTN;
	
	
	public SignUpPage() {
		PageFactory.initElements(Browser.driver,this);
	}
	
	public void login() {
		String un = PropertyUtil.getProperty("username");
		String pwd = PropertyUtil.getProperty("password");
		WaitUtils.waitTillElementVisible(userName);
		userName.sendKeys(un);
		logger.info("UserName is entered in the field "+ un );
		passwordField.sendKeys(pwd);
		logger.info("Password is entered in the password edit field "+ pwd );
		WaitUtils.waitTillElementClickable(subMit_BTN);
		subMit_BTN.click();
		logger.info("Clicked on the submit button");
	}
	
}
