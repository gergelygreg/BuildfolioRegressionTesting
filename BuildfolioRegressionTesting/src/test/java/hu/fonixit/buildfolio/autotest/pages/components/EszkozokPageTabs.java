package hu.fonixit.buildfolio.autotest.pages.components;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EszkozokPageTabs extends BasePage {
    private final By atmekTab = By.xpath("//a[normalize-space()='ATM-ek']");
    private final By banktechnikaiEszkozokTab = By.xpath("//a[normalize-space()='Banktechnikai eszközök']");
    private final By bankbiztonsagiEszkozokTab = By.xpath("//a[normalize-space()='Bankbiztonsági eszközök']");

    public EszkozokPageTabs(WebDriver driver) {
        super(driver);
    }

    //click
    public EszkozokPageTabs clickOnAtmekTab(){
        waitUtil.waitAndClick(atmekTab);
        return this;
    }

    public EszkozokPageTabs clickOnBanktechnikaiEszkozokTab(){
        waitUtil.waitAndClick(banktechnikaiEszkozokTab);
        return this;
    }

    public EszkozokPageTabs clickOnBankbiztonsagiEszkozokTab(){
        waitUtil.waitAndClick(bankbiztonsagiEszkozokTab);
        return this;
    }
}
