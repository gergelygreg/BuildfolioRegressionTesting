package hu.fonixit.buildfolio.autotest.pages.components;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Navbar extends BasePage {
   private final By kilepesUsername = By.cssSelector(".user-name");
   private final By ertesitesIkon = By.xpath("//app-dropdown[@icon='notifications']");
   private final By sugoBtn = By.xpath("//a[normalize-space()='Súgó']");

   public Navbar (WebDriver driver){
       super(driver);
   }
   //click
    public Navbar clickOnErtesitesIkon(){
       waitUtil.waitAndClick(ertesitesIkon);
       return this;
    }

   public Navbar exitApplicationUsingUsername (){
       waitUtil.waitAndClick(kilepesUsername);
       return this;
   }

   public Navbar clickOnSugoBtn(){
       waitUtil.waitAndClick(sugoBtn);
       return this;
   }

   //assertion
    public boolean harangDropDownElemMegjelenik(String szerzodesSzama){
       waitUtil.waitAndClick(ertesitesIkon);
       return waitUtil.elementIsDisplayed(By.xpath("(//span[@class='notification-desc mb-1'][contains(text(),'"+szerzodesSzama+" - Ingatlan adásvételi sze')])[1]"));
    }
}
