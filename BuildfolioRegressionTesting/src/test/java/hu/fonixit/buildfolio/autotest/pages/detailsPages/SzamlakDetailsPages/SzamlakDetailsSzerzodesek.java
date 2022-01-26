package hu.fonixit.buildfolio.autotest.pages.detailsPages.SzamlakDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SzamlakDetailsSzerzodesek extends BasePage {
    private final By hozzarendelesBtn = By.xpath("//button[normalize-space()='Hozzárendelés']");
    private final By eltavolitasBtn = By.xpath("//span[contains(text(),' Eltávolítás ')]");
    private final By hozzarendelesKijBtn = By.xpath("//span[contains(text(),' Hozzárendelés ')]");
    private final By megsemBtn = By.xpath("//a[normalize-space()='Mégsem']");

    public SzamlakDetailsSzerzodesek(WebDriver driver) {
        super(driver);
    }

    //click
    public SzamlakDetailsSzerzodesek clickOnHozzarendelesBtn(){
        waitUtil.waitAndClick(hozzarendelesBtn);
        return this;
    }

    public SzamlakDetailsSzerzodesek clickOnHozzarendleseKijBtn(){
        waitUtil.waitAndClick(hozzarendelesKijBtn);
        return this;
    }

    public SzamlakDetailsSzerzodesek clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    public SzamlakDetailsSzerzodesek clickOnEltavolitasBtn(){
        waitUtil.waitAndClick(eltavolitasBtn);
        return this;
    }
}
