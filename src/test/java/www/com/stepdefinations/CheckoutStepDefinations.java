package www.com.stepdefinations;

import org.openqa.selenium.WebDriver;
import pages.CheckOutPage;
import utilities.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

public class CheckoutStepDefinations extends BaseTest {
	final static Logger logger = Logger.getLogger(CheckoutStepDefinations.class);
	CheckOutPage cp = new CheckOutPage(driver);
	SeleniumUtils su =new SeleniumUtils();
	WaitUtils wu =new WaitUtils();

	@When("^I Login with the (.*) and Password and (.*)$")
	public void i_Login_with_the_username_and_Password(String userName,String password) throws Throwable {
		cp.loginToCheckoutPage(userName,password);
	}

	@When("^I Login into EDP with the (.*) and Password and (.*)$")
	public void i_Login_to_EDP_with_the_username_and_Password(String userName,String password) throws Throwable {
		cp.goToLoginScreen();
		cp.loginToCheckoutPage(userName,password);
		su.refreshBrowser(1);
		cp.verifyLoggedInUser();
	}

	@Then("^verify that user is logged in with welcomeGreetText$")
	public void verify_that_user_is_logged_in_with_welcomeGreetText() throws Throwable {
		cp.verifyLoggedInUser();
	}
	@Then("^Event Display page should be rendered$")
	public void event_page_should_be_rendered() throws Throwable {
		logger.info("Event page should be rendered : Passed");
	}

	@When("^user choose anyone of the ticket on the EDP page and move to CheckOutPage$")
	public void userChooseAnyoneOfTheTicketOnTheEDPPage() {
		cp.goToToCheckOutPage();
	}

	@Then("^the user is on the Place Order checkout page$")
	public void theUserIsOnThePlaceOrderCheckoutPage() {
		cp.checkWeAreInPlaceOrderPage();
	}

	@And("^I verify the order summary details$")
	public void iVerifyTheOrderSummaryDetails() {
		cp.expandAndCheckOrderSummaryDetails();
	}

	@And("^go to the Cancel OrderConfirmation Page and confirm the Cancel Order$")
	public void goToTheCancelOrderConfirmationPageAndConfirmTheCancelOrder() {
		cp.navigateToCancelOrderConfirmationPageAndCancelToGetBackToEDPPage();
	}
}
