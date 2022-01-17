package hu.fonixit.buildfolio.autotest.pages.components;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SzamlakDetailsPageTabs extends BasePage {
    private final By alapadatokTab = By.xpath("//a[normalize-space()='Alapadatok']");
    private final By ingatlanokTab = By.xpath("//a[contains(text(),'Ingatlanok')]");
    private final By partnerekTab = By.xpath("//a[contains(text(),'Partnerek')]");
    private final By szerzodesekTab = By.xpath("//a[contains(text(),'Szerződések')]");
    private final By dokumentumokTab = By.xpath("//a[normalize-space()='Dokumentumok']");

    public SzamlakDetailsPageTabs(WebDriver driver){
        super(driver);
    }

    //click
    public SzamlakDetailsPageTabs clickOnAlapadatokTab(){
        waitUtil.waitAndClick(alapadatokTab);
        return this;
    }

    public SzamlakDetailsPageTabs clickOnIngatlanokTab(){
        waitUtil.waitAndClick(ingatlanokTab);
        return this;
    }

    public SzamlakDetailsPageTabs clickOnPartnerekTab(){
        waitUtil.waitAndClick(partnerekTab);
        return this;
    }

    public SzamlakDetailsPageTabs clickOnSzerzodesekTab(){
        waitUtil.waitAndClick(szerzodesekTab);
        return this;
    }

    public SzamlakDetailsPageTabs clickOnDokumentumokTab(){
        waitUtil.waitAndClick(dokumentumokTab);
        return this;
    }
}
