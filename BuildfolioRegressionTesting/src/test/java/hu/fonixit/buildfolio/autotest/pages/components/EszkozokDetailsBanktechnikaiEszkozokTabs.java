package hu.fonixit.buildfolio.autotest.pages.components;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EszkozokDetailsBanktechnikaiEszkozokTabs extends BasePage {
    private final By alapadatokTab = By.xpath("//a[normalize-space()='Alapadatok']");
    private final By igenyekTab = By.xpath("//a[@class='nav-link']");

    public EszkozokDetailsBanktechnikaiEszkozokTabs(WebDriver driver) {
        super(driver);
    }

    public EszkozokDetailsBanktechnikaiEszkozokTabs clickOnAlapadatokTab(){
        waitUtil.waitAndClick(alapadatokTab);
        return this;
    }

    public EszkozokDetailsBanktechnikaiEszkozokTabs clickOnIgenyekTab(){
        waitUtil.waitAndClick(igenyekTab);
        return this;
    }
}
