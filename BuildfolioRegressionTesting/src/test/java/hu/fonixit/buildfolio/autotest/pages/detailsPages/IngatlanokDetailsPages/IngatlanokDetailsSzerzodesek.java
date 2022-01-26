package hu.fonixit.buildfolio.autotest.pages.detailsPages.IngatlanokDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IngatlanokDetailsSzerzodesek extends BasePage {
    private final By szerzodesekTab = By.xpath("//a[text()=' Szerződések ']");
    private final By alingatlanSzerzodesekTab = By.xpath("//a[contains(text(),'Alingatlan szerződések')]");
    //Alingatlan szerzodesek
    private final By szamlazhatoSzerzodesekBtn = By.xpath("//button[.=' Számlázható szerződések ']");
    //Számlázható szerződések ablak
    private final By szamlaGeneralasBtn = By.xpath("//button[normalize-space()='Számla generálás']");
    private final By megsemBtn = By.xpath("//button[normalize-space()='Mégsem']");

    public IngatlanokDetailsSzerzodesek(WebDriver driver) {
        super(driver);
    }

    //click
    public IngatlanokDetailsSzerzodesek clickOnSzerzodesekTab(){
        waitUtil.waitAndClick(szerzodesekTab);
        return this;
    }

    public IngatlanokDetailsSzerzodesek clickOnAlingatlanSzerzodesekTab(){
        waitUtil.waitAndClick(alingatlanSzerzodesekTab);
        return this;
    }

    public IngatlanokDetailsSzerzodesek clickOnSzamlazhatoSzerzodesekBtn(){
        waitUtil.waitAndClick(szamlazhatoSzerzodesekBtn);
        return this;
    }

    public IngatlanokDetailsSzerzodesek clickOnSzamlaGeneralasBtn(){
        waitUtil.waitAndClick(szamlaGeneralasBtn);
        return this;
    }

    public IngatlanokDetailsSzerzodesek clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    //assert
    public boolean szerzodesMegjelenikATablazatban(String egyediAzon, String oszlopIndex){
        return waitUtil.elementIsDisplayedInTable(egyediAzon, oszlopIndex);
    }
}
