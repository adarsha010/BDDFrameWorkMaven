package www.com.stepdefinations;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import utilities.BaseTest;
import cucumber.api.java.en.When;
import cucumber.api.Scenario;
import cucumber.api.TestStep;
import utilities.SeleniumUtils;

import java.io.File;
import java.io.IOException;

public class BaseStepDefinations extends  BaseTest{
    final static Logger logger = Logger.getLogger(BaseStepDefinations.class);
    public static Scenario message;

    @When("^i launch the EDP Application$")
    public void i_launch_the_EDP_Application() throws Throwable {
        initialize();
        launchApplication();
    }

    @Before
    public static void startSuite() {
        logger.info("STARTED");
    }

   /* @After
    public void afterEnd(Scenario scenario){

        if (scenario.isFailed()) {
            try{
                TakesScreenshot ts=(TakesScreenshot)driver;
                File source=ts.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(source, new File("build/reports/"+scenario.getName()+".png"));
                logger.info("SCREEN **** CAPTURED *** AFTER EVERY FAILURE *****");
            }catch (Exception e){
                logger.info("DID NOT CAPTURED");
            }
        }
        
        logger.info("After scenario Hook is called");
        closeDriver();
    } */


    /**
     * Embed a screenshot in test report if a ui scenario is marked as failed
     */


    @After()
    public void embedScreenshotIfFailed(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                if (driver instanceof TakesScreenshot) {
                    byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    scenario.embed(screenshot, "image/png");
                }
            } catch (Throwable somePlatformsDontSupportScreenshotsOrBrowserHasDied) {
                somePlatformsDontSupportScreenshotsOrBrowserHasDied.printStackTrace(System.err);
            }
        }
        closeDriver();
    }

}
