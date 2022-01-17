package hu.fonixit.buildfolio.autotest.pages.components;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EszkozokDetailsPageTabs extends BasePage {
    private final By atmekTab = By.xpath("//a[normalize-space()='ATM-ek']");
    private final By banktechnikaiEszkTab = By.xpath("//a[normalize-space()='Banktechnikai eszközök']");
    private final By bankbiztEszkTab = By.xpath("//a[normalize-space()='Bankbiztonsági eszközök']");

    public EszkozokDetailsPageTabs(WebDriver driver) {
        super(driver);
    }

    //click
    public EszkozokDetailsPageTabs clickOnAtmekTab(){
        waitUtil.waitAndClick(atmekTab);
        return this;
    }

    public EszkozokDetailsPageTabs clickOnBanktechnikaiEszkTab(){
        waitUtil.waitAndClick(banktechnikaiEszkTab);
        return this;
    }

    public EszkozokDetailsPageTabs clickOnBankbiztEszkTab(){
        waitUtil.waitAndClick(bankbiztEszkTab);
        return this;
    }
}
