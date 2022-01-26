package hu.fonixit.buildfolio.autotest.pages.components;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IgenyekDetailsPageTabs extends BasePage {
    private final By alapadatokTab = By.xpath("//a[normalize-space()='Alapadatok']");
    private final By ingatlanokTab = By.xpath("//a[contains(text(),'Ingatlanok')]");
    private final By eszkozokTab = By.xpath("//a[contains(text(),'Eszközök')]");

    public IgenyekDetailsPageTabs(WebDriver driver) {
        super(driver);
    }

    //click
    public IgenyekDetailsPageTabs clickOnAlapadatokTab(){
        waitUtil.waitAndClick(alapadatokTab);
        return this;
    }
    public IgenyekDetailsPageTabs clickOnIngatlanokTab(){
        waitUtil.waitAndClick(ingatlanokTab);
        return this;
    }
    public IgenyekDetailsPageTabs clickOnEszkozokTab(){
        waitUtil.waitAndClick(eszkozokTab);
        return this;
    }


}
