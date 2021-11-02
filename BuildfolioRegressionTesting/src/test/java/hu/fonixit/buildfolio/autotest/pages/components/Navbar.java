package hu.fonixit.buildfolio.autotest.pages.components;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Navbar extends BasePage {
   private final By kilepesUsername = By.cssSelector(".user-name");

   public Navbar (WebDriver driver){
       super(driver);
   }

   public Navbar exitApplicationUsingUsername (){
       wait.until(ExpectedConditions.visibilityOfElementLocated(kilepesUsername)).click();
       return this;
   }
}
