package hu.fonixit.buildfolio.autotest.utils;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AttributeUtils extends BasePage {

    public AttributeUtils(WebDriver driver) {
        super(driver);
    }

    public static boolean isAttribtuePresent(WebElement element, String attribute) {
        Boolean result = false;
        try {
            String value = element.getAttribute(attribute);
            if (value != null){
                result = true;
            }
        } catch (Exception e) {}

        return result;
    }

    /*WebElement input = driver.findElement(By.cssSelector("input[name*='response']"));
    Boolean checked = isAttribtuePresent(input, "checked");*/
}
