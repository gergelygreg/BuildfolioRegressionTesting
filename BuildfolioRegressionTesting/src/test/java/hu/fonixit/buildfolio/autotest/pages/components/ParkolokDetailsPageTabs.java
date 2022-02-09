package hu.fonixit.buildfolio.autotest.pages.components;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ParkolokDetailsPageTabs extends BasePage {
    private final By alapadatokTab = By.xpath("//a[normalize-space()='Alapadatok']");
    private final By parkolohelyekTab = By.xpath("//a[normalize-space()='Parkolóhelyek']");
    private final By ingatlanokTab = By.xpath("//a[contains(text(),'Ingatlanok')]");

    public ParkolokDetailsPageTabs(WebDriver driver){
        super(driver);
    }

    //click
    public ParkolokDetailsPageTabs clickOnAlapadatokTab(){
        waitUtil.waitAndClick(alapadatokTab);
        return this;
    }

    public ParkolokDetailsPageTabs clickOnParkolohelyekTab(){
        waitUtil.waitAndClick(parkolohelyekTab);
        return this;
    }

    public ParkolokDetailsPageTabs clickOnIngatlanokTab(){
        waitUtil.waitAndClick(ingatlanokTab);
        return this;
    }
}
