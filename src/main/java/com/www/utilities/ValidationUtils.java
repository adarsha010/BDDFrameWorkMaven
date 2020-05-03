package com.www.utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class ValidationUtils {
    final static Logger logger = Logger.getLogger(ValidationUtils.class);

    public static void verifyElementContainsText(WebElement ele, String expectedText) {
        WaitUtils.waitTillElementVisible(ele);
        if(ele.getText().contains(expectedText)) {
            logger.info("Element Passed has the write text " + expectedText);
        }
    }
}

