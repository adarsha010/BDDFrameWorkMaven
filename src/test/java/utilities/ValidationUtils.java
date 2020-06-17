package utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class ValidationUtils extends BaseTest {
    final static Logger logger = Logger.getLogger(ValidationUtils.class);
    WaitUtils wu =new WaitUtils();

    public  void verifyElementContainsText(WebElement ele, String expectedText) {
        wu.waitTillElementVisible(ele);
        logger.info("Actual Text  of the element " + ele.getText());
        Assert.assertEquals(ele.getText().toString(),expectedText);
        logger.info("Element Passed has the write text " + expectedText);
    }

    public  void verifyElementPresent(WebElement ele, String WebElementName) {
        Assert.assertEquals(ele.isDisplayed(),true);
        logger.info(WebElementName + "is Present");
    }

}

