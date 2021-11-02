package hu.fonixit.buildfolio.autotest.utils;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitUtil extends BasePage {

    private static WebDriverWait wait;


    public WaitUtil(WebDriver driver) {
        super(driver);
    }

    public WaitUtil(WebDriverWait wait){
        super(wait);
        this.wait = wait;
    }

    public static void waitAndSendkeys(By element, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(text);
    }

    public static void waitAndClick(By element){
        wait.until((ExpectedConditions.elementToBeClickable(element))).click();
    }

    public static String waitAndGetText(By element){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getText();
    }
}
