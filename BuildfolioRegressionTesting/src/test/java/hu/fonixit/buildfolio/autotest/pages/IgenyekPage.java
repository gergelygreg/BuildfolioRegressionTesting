package hu.fonixit.buildfolio.autotest.pages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IgenyekPage extends BasePage {
    private final  By ujIgenyFelveteleBtn = By.xpath("//button[normalize-space()='Új igény felvétele']");
    //Új igény felvétele ablak
    private final By azonositoFld = By.xpath("//app-text-input[.='Azonosító']//input");
    private final By leirasFld = By.xpath("//app-textarea//textarea");
    private final By felvetelBtn = By.xpath("//button[contains(.,'Felvétel')]");
    private final By megsemBtn = By.xpath("//button[normalize-space()='Mégsem']");

    public IgenyekPage(WebDriver driver) {
        super(driver);
    }
    //click
    public IgenyekPage clickOnUjIgenyekFelvetelBtn(){
        waitUtil.waitAndClick(ujIgenyFelveteleBtn);
        return this;
    }

    public IgenyekPage clickOnFelvetelBtn(){
        waitUtil.waitAndClick(felvetelBtn);
        return this;
    }

    public IgenyekPage clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    //select
    public IgenyekPage elemkivalasztasaTablazatbol(String elemNeve, String oszlopIdex){
        waitUtil.selectElementFromTableOszlopKivalasztasaval(elemNeve, oszlopIdex);
        return this;
    }

    public boolean popUpMegjelenik(String popUpSzovege){
        return waitUtil.popupWindMegjelenik(popUpSzovege);
    }

    //enterText
    public IgenyekPage enterTextToAzonositoFld(String azonosito){
        waitUtil.waitAndSendkeys(azonositoFld, azonosito);
        return this;
    }

    public IgenyekPage enterTextToLeirasFld(String leiras){
        waitUtil.waitAndSendkeys(leirasFld, leiras);
        return this;
    }

    //assert
    public boolean elemMegjelenikATablazatban(String egyediAzon, String oszlopIndex){
        return waitUtil.elementIsDisplayedInTable(egyediAzon, oszlopIndex);
    }
}
