package hu.fonixit.buildfolio.autotest.pages.components;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SideMenu extends BasePage {
    private final By attekintesBtn = By.xpath("//span[normalize-space()='Áttekintés']");
    private final By riportokBtn = By.xpath("//span[normalize-space()='Riportok']");
    private final By ingatlanokBtn = By.xpath("//span[normalize-space()='Ingatlanok']");
    private final By parkolokBtn = By.xpath("//span[normalize-space()='Parkolók']");
    private final By partnerekBtn = By.xpath("//span[normalize-space()='Partnerek']");
    private final By feladatkezeloBtn = By.xpath("//span[normalize-space()='Feladatkezelő']");
    private final By szerzodesekBtn = By.xpath("//span[normalize-space()='Szerződések']");
    private final By szamlakBtn = By.xpath("//span[normalize-space()='Számlák']");
    private final By eszkozokBtn = By.xpath("//span[normalize-space()='Eszközök']");
    private final By igenyekBtn = By.xpath("//span[normalize-space()='Igények']");
    private final By ertesitesekBtn = By.xpath("//span[normalize-space()='Értesítések']");
    private final By felhasznalokBtn = By.xpath("//span[normalize-space()='Felhasználók']");
    private final By szervezetekBtn = By.xpath("//span[normalize-space()='Szervezetek']");
    private final By adatfeltoltesBtn = By.xpath("//span[normalize-space()='Adatfeltöltés']");
    private final By adatletoltesBtn = By.xpath("//span[normalize-space()='Adatletöltés']");

    public SideMenu(WebDriver driver){
        super(driver);
    }

    public SideMenu navigateToAttekintesPanel(){
        waitUtil.waitAndClick(attekintesBtn);
        return this;
    }

    public SideMenu navigateToRiportokPanel(){
        waitUtil.waitAndClick(riportokBtn);
        return this;
    }

    public SideMenu navigateToIngatlanokPanel(){
        waitUtil.waitAndClick(ingatlanokBtn);
        return this;
    }

    public SideMenu navigateToParkolokPanel(){
        waitUtil.waitAndClick(parkolokBtn);
        return this;
    }

    public SideMenu navigateToPartnerekPanel(){
        waitUtil.waitAndClick(partnerekBtn);
        return this;
    }

    public SideMenu navigateToFeladatkezeloPanel(){
        waitUtil.waitAndClick(feladatkezeloBtn);
        return this;
    }

    public SideMenu navigateToSzerzodesekPanel(){
        waitUtil.waitAndClick(szerzodesekBtn);
        return this;
    }

    public SideMenu navigateToSzamlakPanel(){
        waitUtil.waitAndClick(szamlakBtn);
        return this;
    }

    public SideMenu navigateToEszkozokPanel(){
        waitUtil.waitAndClick(eszkozokBtn);
        return this;
    }

    public SideMenu navigateToIgenyekPanel(){
        waitUtil.waitAndClick(igenyekBtn);
        return this;
    }

    public SideMenu navigateToErtesitesekPanel(){
        waitUtil.waitAndClick(ertesitesekBtn);
        return this;
    }

    public SideMenu navigateToFelhasznalokPanel(){
        waitUtil.waitAndClick(felhasznalokBtn);
        return this;
    }

    public SideMenu navigateToSzervezetekPanel(){
        waitUtil.waitAndClick(szervezetekBtn);
        return  this;
    }

    public SideMenu navigateToAdatfeltoltesPanel(){
        waitUtil.waitAndClick(adatfeltoltesBtn);
        return this;
    }

    public SideMenu navigateToAdatletoltesPanel(){
        waitUtil.waitAndClick(adatletoltesBtn);
        return this;
    }
}
