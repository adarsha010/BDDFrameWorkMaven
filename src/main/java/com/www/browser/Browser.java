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
		logger.info("Read value of browser:"+browser);
		logger.info("Read value of application URL:" + url );

		
		if(browser.equals("chrome")) {
			System.getProperty("browser");
			System.setProperty("webdriver.chrome.driver", ".//src/test/resources/chromedriver");
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--incognito");
			DesiredCapabilities capabilities= new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver=new ChromeDriver();
		}else if(browser.equals("firefox")){
			
		}else {
			System.out.println("Invlaid Browser");
			System.setProperty("webdriver.gecko.driver", ".//src/test/resources/geckodriver.exe");
			FirefoxOptions FFoptions= new FirefoxOptions();
			FFoptions.addArguments("--incognito");
			driver= new FirefoxDriver(FFoptions);
		}
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(2000,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	public static void initialize() {
		new Browser();
	}
	public static void quitBrowsers() {
		driver.quit();
	}
	
}
