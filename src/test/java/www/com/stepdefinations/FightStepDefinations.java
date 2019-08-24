package www.com.stepdefinations;

import org.apache.log4j.Logger;

import com.www.browser.Browser;
import com.www.pages.FlightHomePage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FightStepDefinations {

	static FlightHomePage fp ;
	
	
	final static Logger logger = Logger.getLogger(FightStepDefinations.class);

	@When("^i launch the Flight Application$")
	public void i_launch_the_Flight_Application() throws Throwable {
	  Browser.initialize();
	  fp= new FlightHomePage();
	}
	
	@When("^I click of flights section$")
	public void i_click_of_flights_section() throws Throwable {
      fp.goToFlightSections();
	}

	@Then("^choosegoToPlace and Proceed with Search flights$")
	public void choosegotoplace_and_Proceed_with_Search_flights() throws Throwable {
		fp.choosegoToPlace();
		Browser.quitBrowsers();
	}
	
	
}
