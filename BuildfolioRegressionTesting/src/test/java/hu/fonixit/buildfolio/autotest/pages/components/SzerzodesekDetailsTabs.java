package hu.fonixit.buildfolio.autotest.pages.components;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SzerzodesekDetailsTabs extends BasePage {
    private final By alapadatokTab = By.linkText("Alapadatok");
    private final By ingatlanokEsEladasiArakTab = By.linkText("Ingatlanok és eladási árak");
    private final By szerzodoPartnereTab = By.linkText("Szerződő partnerek");
    private final By szamlakTab = By.linkText("Számlák");
    private final By dokumentumokTab = By.linkText("Dokumentumok");

    public SzerzodesekDetailsTabs(WebDriver driver){
        super(driver);
    }

    //click
    public SzerzodesekDetailsTabs clickOnAlapadatokTab(){
        waitUtil.waitAndClick(alapadatokTab);
        return this;
    }

    public SzerzodesekDetailsTabs clickOnIngatlanokEsEladasiArakTab(){
        waitUtil.waitAndClick(ingatlanokEsEladasiArakTab);
        return this;
    }

    public SzerzodesekDetailsTabs clickOnSzerzodoPartnerekTab(){
        waitUtil.waitAndClick(szerzodoPartnereTab);
        return this;
    }

    public SzerzodesekDetailsTabs clickOnSzamlakTab(){
        waitUtil.waitAndClick(szamlakTab);
        return this;
    }

    public SzerzodesekDetailsTabs clickOnDokumentumokTab(){
        waitUtil.waitAndClick(dokumentumokTab);
        return this;
    }

}
