package hu.fonixit.buildfolio.autotest.pages.components;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EszkozokDetailsBankbiztonsagiEszkozokTabs extends BasePage {
    private final By alapadatokTab = By.xpath("//a[normalize-space()='Alapadatok']");
    private final By igenyekTab = By.xpath("//a[@class='nav-link']");

    public EszkozokDetailsBankbiztonsagiEszkozokTabs(WebDriver driver) {
        super(driver);
    }

    public EszkozokDetailsBankbiztonsagiEszkozokTabs clickOnAlapadatokTab(){
        waitUtil.waitAndClick(alapadatokTab);
        return this;
    }

    public EszkozokDetailsBankbiztonsagiEszkozokTabs clickOnIgenyekTab(){
        waitUtil.waitAndClick(igenyekTab);
        return this;
    }
}
