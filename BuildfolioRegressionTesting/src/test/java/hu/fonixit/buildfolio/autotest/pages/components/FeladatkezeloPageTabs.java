package hu.fonixit.buildfolio.autotest.pages.components;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import hu.fonixit.buildfolio.autotest.pages.FeladatkezeloFeladatokPage;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.FeladatkezeloDetailsPages.FeladatkezeloDetailsAlapadatok;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FeladatkezeloPageTabs extends BasePage {
    private final By feladatokTab = By.xpath("//a[normalize-space()='Feladatok']");
    private final By munkafolyamatokTab = By.xpath("//a[normalize-space()='Munkafolyamatok']");

    public FeladatkezeloPageTabs(WebDriver driver) {
        super(driver);
    }

    public FeladatkezeloPageTabs clickOnFeladatokTab(){
        waitUtil.waitAndClick(feladatokTab);
        return this;
    }

    public FeladatkezeloPageTabs clickOnMunkafolyamatokTab(){
        waitUtil.waitAndClick(munkafolyamatokTab);
        return this;
    }



}
