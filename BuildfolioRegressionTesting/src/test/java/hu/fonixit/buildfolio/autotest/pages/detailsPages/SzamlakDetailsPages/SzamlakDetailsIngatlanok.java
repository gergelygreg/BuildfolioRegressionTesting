package hu.fonixit.buildfolio.autotest.pages.detailsPages.SzamlakDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.IngatlanokDetailsPages.IngatlanokDetailsParkolas;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SzamlakDetailsIngatlanok extends BasePage {
    private final By hozzarendelesBtn = By.xpath("//a[contains(.,'Hozzárendelés ')]");
    private final By hozzarendelesKijBtn = By.xpath("//button[contains(.,'Hozzárendelés ')]");
    private final By megsemBtn = By.xpath("//a[normalize-space()='Mégsem']");
    private final By eltavolitasBtn = By.xpath("//button[contains(.,'Eltávolítás ')]");

    public SzamlakDetailsIngatlanok(WebDriver driver) {
        super(driver);
    }

    //click
    public SzamlakDetailsIngatlanok clickOnHozzarendelesBtn(){
        waitUtil.waitAndClick(hozzarendelesBtn);
        return this;
    }

    public SzamlakDetailsIngatlanok clickOnHozzarendleseKijBtn(){
        waitUtil.waitAndClick(hozzarendelesKijBtn);
        return this;
    }

    public SzamlakDetailsIngatlanok clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    public SzamlakDetailsIngatlanok clickOnEltavolitasBtn(){
        waitUtil.waitAndClick(eltavolitasBtn);
        return this;
    }


}
