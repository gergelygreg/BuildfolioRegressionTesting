package hu.fonixit.buildfolio.autotest.pages.components;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PartnerekDetailsPageTabs extends BasePage {
    private final By alapadatokLinkBtn = By.xpath("//a[.='Alapadatok']");
    private final By ingatlanokLinkBtn = By.xpath("//a[.='Ingatlanok']");
    private final By szerzodesekLinkBtn = By.xpath("//a[.='Szerződések']");
    private final By szamlakLinkBtn = By.xpath("//a[.='Számlák']");
    private final By meroorakLinkBtn = By.xpath("//a[.='Mérőórák']");
    private final By eszkozokLinkBtn = By.xpath("//a[contains(text(),'Eszközök')]");

    public PartnerekDetailsPageTabs(WebDriver driver) {
        super(driver);
    }

    //click
    public PartnerekDetailsPageTabs clickOnAlapadatokLinkBtn(){
        waitUtil.waitAndClick(alapadatokLinkBtn);
        return this;
    }

    public PartnerekDetailsPageTabs clickOnIngatlanokLinkBtn(){
        waitUtil.waitAndClick(ingatlanokLinkBtn);
        return this;
    }

    public PartnerekDetailsPageTabs clickOnSzerzodesekLinkBtn(){
        waitUtil.waitAndClick(szerzodesekLinkBtn);
        return this;
    }

    public PartnerekDetailsPageTabs clickOnSzamlakLinkBtn(){
        waitUtil.waitAndClick(szamlakLinkBtn);
        return this;
    }

    public PartnerekDetailsPageTabs clickOnMeroorakLinkBtn(){
        waitUtil.waitAndClick(meroorakLinkBtn);
        return this;
    }

    public PartnerekDetailsPageTabs clickOnEszkozokLinkBtn(){
        waitUtil.waitAndClick(eszkozokLinkBtn);
        return this;
    }

}
