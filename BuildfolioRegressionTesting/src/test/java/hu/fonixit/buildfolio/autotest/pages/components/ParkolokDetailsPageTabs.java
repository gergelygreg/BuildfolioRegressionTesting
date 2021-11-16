package hu.fonixit.buildfolio.autotest.pages.components;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ParkolokDetailsPageTabs extends BasePage {
    private final By alapadatokTab = By.linkText("Alapadatok");
    private final By parkolohelyekTab = By.linkText("Parkolóhelyek");
    private final By ingatlanokTab = By.linkText("Ingatlanok");

    public ParkolokDetailsPageTabs(WebDriver driver){
        super(driver);
    }

    //click
    public ParkolokDetailsPageTabs clickOnalapadatokTab(){
        wait.until(ExpectedConditions.elementToBeClickable(alapadatokTab)).click();
        return this;
    }

    public ParkolokDetailsPageTabs clickOnParkolohelyekTab(){
        wait.until(ExpectedConditions.elementToBeClickable(parkolohelyekTab)).click();
        return this;
    }

    public ParkolokDetailsPageTabs clickOnIngatlanokTab(){
        wait.until(ExpectedConditions.elementToBeClickable(ingatlanokTab)).click();
        return this;
    }
}
