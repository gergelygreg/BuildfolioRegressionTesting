package hu.fonixit.buildfolio.autotest.pages.components;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FeladatokDetailsPageTabs extends BasePage {
    private final By alapadatokTab = By.xpath("//a[normalize-space()='Alapadatok']");
    private final By kapcsolodoIngatlanokTab = By.xpath("//a[normalize-space()='Kapcsolódó ingatlanok']");

    public FeladatokDetailsPageTabs(WebDriver driver) {
        super(driver);
    }

    //click
    public FeladatokDetailsPageTabs clickOnAlapadatokTab(){
        waitUtil.waitAndClick(alapadatokTab);
        return this;
    }

    public FeladatokDetailsPageTabs clickOnKapcsolodoIngatlanokTab(){
        waitUtil.waitAndClick(kapcsolodoIngatlanokTab);
        return this;
    }
}
