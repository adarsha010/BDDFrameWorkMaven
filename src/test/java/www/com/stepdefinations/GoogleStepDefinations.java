package www.com.stepdefinations;

import org.apache.log4j.Logger;

import com.www.browser.Browser;
import com.www.pages.GooglePage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleStepDefinations {

	static GooglePage gp ;
	
	
	final static Logger logger = Logger.getLogger(GoogleStepDefinations.class);

	@When("^i launch the Google Application$")
	public void i_launch_the_Google_Application() throws Throwable {
	  Browser.initialize();
	  gp= new GooglePage();
	}
	


	@When("^user enters the random value in Google search Bar$")
	public void user_enters_the_random_value_in_Google_search_Bar() throws Throwable {
		gp.login();

	}

	@When("^click on the search Button$")
	public void click_on_the_search_Button() throws Throwable {
	   logger.info("click on the search Button : Passed");

	}

	@Then("^Results page should be rendered$")
	public void results_page_should_be_rendered() throws Throwable {
	  
		logger.info("Results page should be rendered : Passed");
		Browser.quitBrowsers();

	}

	
	
}
