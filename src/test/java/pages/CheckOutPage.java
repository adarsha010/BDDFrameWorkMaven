package pages;


import org.openqa.selenium.WebDriver;
import utilities.BaseTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.SeleniumUtils;
import utilities.ValidationUtils;
import utilities.WaitUtils;


public class CheckOutPage extends BaseTest {
	public WebDriver localDriver;
	final static Logger logger = Logger.getLogger(CheckOutPage.class);
	public SeleniumUtils su = new SeleniumUtils();
	public WaitUtils wu= new WaitUtils();
	public ValidationUtils vu = new ValidationUtils();

	// http://edp-checkout-alpha.prd115.nonprod5.us-east-1.tktm.io/event/3F005639C71AA649?no_ccp=1&bba=1

	/*
	  IFRAME(By.cssSelector("[title=\"secure_accounts_widget\"]")),
  	  EMAIL_FIELD(By.cssSelector("[data-bdd=\"email-address-field\"]")),
 	  PASSWORD_FIELD(By.cssSelector("[data-bdd=\"password-field\"]")),
  	  REMEMBER_ME_CHECKBOX(By.cssSelector("[data-bdd=\"remember-me\"]")),
  	  SIGN_IN_BUTTON(By.cssSelector("[data-bdd=\"sign-in-button\"]")),
  	  FORGOT_PASSWORD_LINK(By.cssSelector("[data-bdd=\"forgot-password\"]")),
	 */


    // EDP Home Page
	@FindBy(css="span.id-login__login-text")
	public WebElement signInBTN_OLD;

	@FindBy(xpath="//button[@class='unbutton offer-card__back-button']")
	public WebElement close_offer_Card_BTN;
	@FindBy(xpath="(//button[@class=\"quick-picks__button\"])[2] ")
	public WebElement first_Ticket_BTN;
	@FindBy(css="button#offer-card-buy-button")
	public WebElement next_BTN;
	@FindBy(css="div.polling-modal__container")
	public WebElement pollingPOP;
	@FindBy(xpath="//h1[contains(text(),\"Checkout\")]")
	public WebElement checkoutHeader;

	@FindBy(xpath="//div[@data-tid=\"timer\"] ")
	public WebElement checkOuttimer;

	@FindBy(css="div[data-tid=\"timer\"]")
	public WebElement urgrency_MOD;
	@FindBy(css="button#urgency-modal")
	public WebElement urgrency_BTN;

	@FindBy(xpath="//div[@data-bdd='resale-message-landing']")
	public WebElement resaleLandingModalMsg;
	@FindBy(css="button.pricing-landing__modal-btn")
	public WebElement resaleLandingOKBTN;



	//LOCATORS FOR EDP-Login Modal
	@FindBy(xpath="//iframe[@title='secure_accounts_widget']")
	public WebElement loginFrame;
	@FindBy(css="input[type='email']")
	public WebElement enterEmail;
	@FindBy(css="input[type='password']")
	public WebElement pwdField;
	@FindBy(xpath="button[@name='sign-in']")
	public WebElement loginBTN;
	@FindBy(xpath="//div[@data-bdd='login-modal']")
	public WebElement loginModal;
	@FindBy(id="rememberMefalseinput")
	public WebElement remember_CHK;
	@FindBy(xpath="//span[contains(text(),'Sign in')]")
	public WebElement signInBTN;
	@FindBy(css="span.id-login__login-text")
	public WebElement signIn_LNK;


	// LOCATORS For Checkout-Place-Order-Page
	@FindBy(xpath="//div[@data-tid='delivery-section']//child::h4")
	public WebElement deliverySection_HDR;
	@FindBy(xpath="//div[@data-tid='payment-section']//child::h4")
	public WebElement paymentSection_HDR;
	@FindBy(xpath="//div[@data-tid='ticket-insurance-section']//child::h4")
	public WebElement ticketInsuranceSection_HDR;

	@FindBy(css="div[data-tid=\"cost-breakdown\"]")
	public WebElement costBreakDown;

	// LOCATORS for Order-Summary-Details
	@FindBy(css="button[aria-label='Toggle Order Summary']")
	public WebElement toggle_OrderBTN;
	@FindBy(css="div[data-tid='summary-ticket-heading']")
	public WebElement ticket_Summary;
	@FindBy(css="div[data-tid='summary-fees']")
	public WebElement ticket_Summary_Fees;
	@FindBy(css="div[data-tid='summary-delivery']")
	public WebElement ticket_Summary_Delivery_Fees;
	@FindBy(xpath="//div[starts-with(@class,'style__PlaceOrder')]//button")
	public WebElement placeOrder_BTN;
	@FindBy(css="button[data-tid='cancel-order-link']")
	public WebElement cancelOrder_BTN;

	// Cancel Order Confirmation Popup Message
	@FindBy(css="button[data-tid='keep-tickets-btn']")
	public WebElement stayInCheckOut_BTN;
	@FindBy(css="button[data-tid='release-tickets-btn']")
	public WebElement cancelOrderConfirm_BTN;
	@FindBy(xpath="//h3[contains(text(),'Are You Sure You Want to Leave Checkout?')]")
	public WebElement checkOutConfirm_MSG;

	@FindBy(xpath="//div[@class='id-login__first-name']//span[1]")
	public WebElement loggedInWelcomeText;

	public CheckOutPage(WebDriver localDriver) {
		this.localDriver =driver;
		PageFactory.initElements(driver,this);
	}

	public void goToToCheckOutPage() {
		su.mouseHoverAndClickOnElement(first_Ticket_BTN);
		logger.info("User could see the Available Tickets");
		su.jsClick(first_Ticket_BTN);
		logger.info("User Choose the First Available Ticket");
		su.clickOnElement(next_BTN,"next_BTN");
		logger.info("Popup arrives");
		vu.verifyElementContainsText(checkoutHeader,"Checkout");
		logger.info("User Moved To Checkout Page");
		wu.waitTillElementVisible(checkOuttimer);
		logger.info("Booking Time Count down Started");
		su.switchToMainWindow();
	}
	public void loginToCheckoutPage(String userName, String password){
		wu.waitTillElementVisible(loginFrame);
		su.switchToIframeByName(loginFrame,"loginFrame");
		su.enterTextinField(enterEmail,userName);
		su.enterTextinField(pwdField,password);
		wu.waitTillElementClickable(remember_CHK);
		su.jsClick(remember_CHK);
		su.clickOnElement(signInBTN,"signInBTN");
		su.switchToMainWindow();
		wu.waitUntillPageLoad();
	}
	public void goToLoginScreen(){
		if(handleResaleLandingPopup()){
			logger.info("Resale Popup is handled");
		}else {
			logger.info("Resale Popup is not handled");
		}
		su.clickOnElement(signIn_LNK,"Sign In Link on EDP");
		wu.waitUntillPageLoad();

	}

	public void verifyLoggedInUser(){
		wu.waitTillElementVisible(loggedInWelcomeText);
		vu.verifyElementContainsText(loggedInWelcomeText,"Hi");
	}

	public void checkWeAreInPlaceOrderPage(){
		//su.refreshBrowser(2);
		handleCompleteYourPurchase();
		wu.waitTillElementGetsVisible(deliverySection_HDR);
		//vu.verifyElementContainsText(deliverySection_HDR,"Delivery");
		wu.waitTillElementGetsVisible(paymentSection_HDR);
		vu.verifyElementContainsText(paymentSection_HDR,"Payment");
		vu.verifyElementContainsText(ticketInsuranceSection_HDR,"Ticket Insurance");
		logger.info("User has validated all the sections in Place-Order-Page");
	}

	public void expandAndCheckOrderSummaryDetails(){
		su.clickOnElement(toggle_OrderBTN,"Order Toggle Button");
		vu.verifyElementPresent(ticket_Summary,"Ticket Summary");
		vu.verifyElementPresent(ticket_Summary_Fees,"Ticket Summary Fees");
		vu.verifyElementPresent(ticket_Summary_Delivery_Fees,"Ticket Summary Delivery Fees");
		vu.verifyElementPresent(placeOrder_BTN,"Place Order Button");
		vu.verifyElementPresent(cancelOrder_BTN,"Cancel Order Button");
		logger.info("User has validated all the sections Present Inside the Order-Summary-Details-Section");
	}

	public void navigateToCancelOrderConfirmationPageAndCancelToGetBackToEDPPage(){
		expandAndCheckOrderSummaryDetails();
		wu.waitTillElementClickable(cancelOrder_BTN);
		su.clickOnElement(cancelOrder_BTN,"Cancel Order Button");
		wu.waitTillElementVisible(checkOutConfirm_MSG);
		vu.verifyElementContainsText(checkOutConfirm_MSG,"Are You Sure You Want to Leave Checkout?");
		vu.verifyElementPresent(stayInCheckOut_BTN,"Stay In CheckOut Button");
		vu.verifyElementPresent(cancelOrderConfirm_BTN,"Cancel Order Button");
		su.clickOnElement(cancelOrderConfirm_BTN,"Cancel Order Button");
		wu.waitTillElementVisible(loggedInWelcomeText);
	}

	public void handleCompleteYourPurchase(){
		try{
			wu.waitTillElementVisible(urgrency_BTN);
			su.clickOnElement(urgrency_BTN,"Urgency Button is clicked");
			logger.info("Closed The Complete Your Purchase Popup");
		}catch(Exception e){
			logger.warn(e.getLocalizedMessage());
		}
	}
	public boolean handleResaleLandingPopup(){
		try{
			wu.waitTillElementVisible(resaleLandingModalMsg);
			su.clickOnElement(resaleLandingOKBTN,"resaleLandingOKBTN");
			logger.info("Closed The ResaleLanding Page PopUp");
			//wu.waitTillElementVisible(close_offer_Card_BTN);
			//su.clickOnElement(close_offer_Card_BTN,"closed offer Card");
			return  true;
		}catch(Exception e){
			return  false;
		}
	}

}
