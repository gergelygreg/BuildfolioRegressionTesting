package hu.fonixit.buildfolio.autotest.pages.detailsPages.IngatlanokDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IngatlanokDetailsSzamlak extends BasePage {
    private final By kozmuSzamlakTab = By.xpath("//a[contains(text(),'Közmű számlák')]");
    private final By tovabbiSzamlakTab = By.xpath("//a[normalize-space()='További számlák']");
    private final By alingatlanSzamlakTab = By.xpath("//a[normalize-space()='Alingatlan számlák']");
    //Alingatlan számlák
    private final By letolthetoSzamlaAnalitikaBtn = By.xpath("//a[normalize-space()='Alingatlan számlák']");

    public IngatlanokDetailsSzamlak(WebDriver driver) {
        super(driver);
    }

    //click
    public IngatlanokDetailsSzamlak clickOnKozmuSzamlakTab(){
        waitUtil.waitAndClick(kozmuSzamlakTab);
        return this;
    }

    public IngatlanokDetailsSzamlak clickOnTovabbiKozmuSzamlakTab(){
        waitUtil.waitAndClick(tovabbiSzamlakTab);
        return this;
    }

    public IngatlanokDetailsSzamlak clickOnAlingatlanSzamlakTab(){
        waitUtil.waitAndClick(alingatlanSzamlakTab);
        return this;
    }

    public IngatlanokDetailsSzamlak clickOnLetolthetoSzamlaAnalitikaBtn(){
        waitUtil.waitAndClick(letolthetoSzamlaAnalitikaBtn);
        return this;
    }

    public IngatlanokDetailsSzamlak clickOnElemFromTablazatbol(String egyediAzon, String oszlopIndex){
        waitUtil.selectElementFromTableOszlopKivalasztasaval(egyediAzon, oszlopIndex);
        return this;
    }

    //assert
    public boolean szamlaMegjelenikATablazatban(String egyediAzon, String oszlopIndex){
        return waitUtil.elementIsDisplayedInTable(egyediAzon, oszlopIndex);
    }
}
