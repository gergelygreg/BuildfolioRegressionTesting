package hu.fonixit.buildfolio.autotest.pages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ErtesitesekPage extends BasePage {
    private final By listaElsoElem = By.xpath("(//button[@class='no-button'])[1]");

    public ErtesitesekPage(WebDriver driver) {
        super(driver);
    }

    //click
    public ErtesitesekPage clickOnFelvettErtesites(){
        waitUtil.waitAndClick(listaElsoElem);
        return this;
    }


    //assertion
    public boolean kiemeltAzErtesitesCime(){
        try{
            waitUtil.waitForVisibility(By.xpath("//div[@class='notification-item visited ng-star-inserted']//p[@class='notification-title'][contains(text(),'Szerződés értesítés')]"));
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
