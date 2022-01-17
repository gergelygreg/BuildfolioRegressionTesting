package hu.fonixit.buildfolio.autotest.pages.components;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SzerzodesekDetailsPageTabs extends BasePage {
    private final By alapadatokNavLink = By.xpath("//a[.='Alapadatok']");
    private final By ingatlanokEsBerletiDijakNavLink = By.xpath("//a[.='Ingatlanok és bérleti díjak']");
    private final By uzemeltetesiEsBerletiDijaklNavLink = By.xpath("//a[.='Üzemeltetési díjak']");
    private final By egyebDijaklNavLink = By.xpath("//a[.='Egyéb díjak']");
    private final By szerzodoPartnerekNavLink = By.xpath("//a[contains(text(),'Szerződő partnerek')]");
    private final By szamlakNavLink = By.xpath("//a[contains(text(),'Számlák')]");
    private final By dokumentumokNavLink = By.xpath("//a[normalize-space()='Dokumentumok']");
    private final By ingatlanokEsEladasiArak = By.xpath("//a[normalize-space()='Ingatlanok és eladási árak']");

    public SzerzodesekDetailsPageTabs(WebDriver driver) {
        super(driver);
    }

    //click
    public SzerzodesekDetailsPageTabs clickOnAlapadatokNavLink(){
        waitUtil.waitAndClick(alapadatokNavLink);
        return this;
    }

    public SzerzodesekDetailsPageTabs clickOnIngatlanokEsBerletiDijakNavLink(){
        waitUtil.waitAndClick(ingatlanokEsBerletiDijakNavLink);
        return this;
    }

    public SzerzodesekDetailsPageTabs clickOnUzemeltetesiEsBerletiDijaklNavLink(){
        waitUtil.waitAndClick(uzemeltetesiEsBerletiDijaklNavLink);
        return this;
    }

    public SzerzodesekDetailsPageTabs clickOnEgyekDijaklNavLink(){
        waitUtil.waitAndClick(egyebDijaklNavLink);
        return this;
    }

    public SzerzodesekDetailsPageTabs clickOnSzerzodoPartnerekNavLink(){
        waitUtil.waitAndClick(szerzodoPartnerekNavLink);
        return this;
    }

    public SzerzodesekDetailsPageTabs clickOnSzamlakNavLink(){
        waitUtil.waitAndClick(szamlakNavLink);
        return this;
    }

    public SzerzodesekDetailsPageTabs clickOnDokumentumokNavLink(){
        waitUtil.waitAndClick(dokumentumokNavLink);
        return this;
    }

    public SzerzodesekDetailsPageTabs clickOnIngatlanokEsEladasiArakNavLink(){
        waitUtil.waitAndClick(ingatlanokEsEladasiArak);
        return this;
    }
}
