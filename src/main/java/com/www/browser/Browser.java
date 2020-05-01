package com.www.browser;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.www.utilities.PropertyUtil;


public class Browser {

	public static WebDriver driver;
	final static Logger logger = Logger.getLogger(Browser.class);
	private Browser() {

		String browser = PropertyUtil.getProperty("browser");
		String url = PropertyUtil.getProperty("URL");
		String platFormName = PropertyUtil.getProperty("platformName");
		logger.info("Read value of browser:" + browser);
		logger.info("Read value of application URL:" + url);

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/" + platFormName + "/chromedriver");
			logger.info("Picked the chrome driver from the location  :" + System.getProperty("webdriver.chrome.driver").toString());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/" + platFormName + "/geckodriver.exe");
			logger.info("Picked the Firefox Gecko driver from the location  :" + System.getProperty("webdriver.gecko.driver").toString());
			FirefoxOptions FFoptions = new FirefoxOptions();
			FFoptions.addArguments("--incognito");
			driver = new FirefoxDriver(FFoptions);
		} else {
			logger.error("Invalid args are passed either browser|platFormName " + "Browser :" + browser + " platFormName :" + platFormName);
			System.exit(1);
		}
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	public static void initialize() {
		new Browser();
	}
	public static void quitBrowsers() {
		driver.quit();
	}
	
}
