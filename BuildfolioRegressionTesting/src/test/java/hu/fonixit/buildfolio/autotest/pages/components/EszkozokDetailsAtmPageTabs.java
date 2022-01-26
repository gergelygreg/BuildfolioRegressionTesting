package hu.fonixit.buildfolio.autotest.pages.components;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EszkozokDetailsAtmPageTabs extends BasePage {
    private final By alapadatokTab = By.xpath("//a[normalize-space()='Alapadatok']");
    private final By bankbiztonsagiEszkozokTab = By.xpath("//a[normalize-space()='Bankbiztonsági eszközök']");
    private final By igenyekTab = By.xpath("//a[contains(text(),'Igények')]");

    public EszkozokDetailsAtmPageTabs(WebDriver driver) {
        super(driver);
    }

    //click
    public EszkozokDetailsAtmPageTabs clickOnAlapadatokTab(){
        waitUtil.waitAndClick(alapadatokTab);
        return this;
    }

    public EszkozokDetailsAtmPageTabs clickOnBankbiztonsagieszkozokTab(){
        waitUtil.waitAndClick(bankbiztonsagiEszkozokTab);
        return this;
    }

    public EszkozokDetailsAtmPageTabs clickOnIgenyekTab(){
        waitUtil.waitAndClick(igenyekTab);
        return this;
    }
}
