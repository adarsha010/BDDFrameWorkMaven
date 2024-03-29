package com.www.browser;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.www.utilities.PropertyUtil;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriverService;
import org.openqa.selenium.safari.SafariOptions;


public class Browser {

	public static WebDriver driver;
	final static Logger logger = Logger.getLogger(Browser.class);
	private Browser() {

		String browser = System.getProperty("browser");
		String url = System.getProperty("appURL");
		String platFormName = System.getProperty("platformName");
		logger.info("Read value of browser:" + browser);
		logger.info("Read value of application URL:" + url);

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/" + platFormName + "/chromedriver");
			logger.info("Picked the chrome driver from the location  :" + System.getProperty("webdriver.chrome.driver").toString());
			ChromeOptions cOptions = new ChromeOptions();
			cOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			cOptions.addArguments("--incognito");
			cOptions.addArguments("test-type");
			//cOptions.addArguments("start-maximized");
			cOptions.addArguments("--start-fullscreen");
			cOptions.addArguments("--js-flags=--expose-gc");
			cOptions.addArguments("--enable-precise-memory-info");
			cOptions.addArguments("--disable-popup-blocking");
			cOptions.addArguments("--disable-default-apps");
			driver = new ChromeDriver(cOptions);
		} else if (browser.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/" + platFormName + "/geckodriver");
			logger.info("Picked the Firefox Gecko driver from the location  :" + System.getProperty("webdriver.gecko.driver").toString());
			FirefoxOptions FFoptions = new FirefoxOptions();
			FFoptions.addArguments("--incognito");
			driver = new FirefoxDriver(FFoptions);
		} else if (browser.equals("safari")){
		    logger.info("Code entered the safari");
		    SafariOptions expectedSafariOptions = new SafariOptions();
			//expectedSafariOptions.setCapability("screenResolution", "1690x1000");
			expectedSafariOptions.setCapability("browserstack.safari.resolution", "1690x1000");
			expectedSafariOptions.setCapability("browserstack.safari.allowAllCookies", "false");
			expectedSafariOptions.setCapability("safari.cleanSession", "tue");
		    driver = new SafariDriver(expectedSafariOptions);
		    driver.manage().window().fullscreen();
	    }else {
			logger.error("Invalid args are passed either browser|platFormName " + "Browser :" + browser + " platFormName :" + platFormName);
			System.exit(1);
		}
		driver.manage().deleteAllCookies();
		logger.info("Deleting all cookies");
		driver.get(url);
		logger.info("Launching URL");
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	}
	public static void initialize() {
		new Browser();
	}
	public static void quitBrowsers() {
		driver.quit();
	}
	
}
