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
        wait.until(ExpectedConditions.elementToBeClickable(attekintesBtn)).click();
        return this;
    }

    public SideMenu navigateToRiportokPanel(){
        wait.until(ExpectedConditions.elementToBeClickable(riportokBtn)).click();
        return this;
    }

    public SideMenu navigateToIngatlanokPanel(){
        wait.until(ExpectedConditions.elementToBeClickable(ingatlanokBtn)).click();
        return this;
    }

    public SideMenu navigateToParkolokPanel(){
        wait.until(ExpectedConditions.elementToBeClickable(parkolokBtn)).click();
        return this;
    }

    public SideMenu navigateToPartnerekPanel(){
        wait.until(ExpectedConditions.elementToBeClickable(partnerekBtn)).click();
        return this;
    }

    public SideMenu navigateToFeladatkezeloPanel(){
        wait.until(ExpectedConditions.elementToBeClickable(feladatkezeloBtn)).click();
        return this;
    }

    public SideMenu navigateToSzerzodesekPanel(){
        wait.until(ExpectedConditions.elementToBeClickable(szerzodesekBtn)).click();
        return this;
    }

    public SideMenu navigateToSzamlakPanel(){
        wait.until(ExpectedConditions.elementToBeClickable(szamlakBtn)).click();
        return this;
    }

    public SideMenu navigateToEszkozokPanel(){
        wait.until(ExpectedConditions.elementToBeClickable(eszkozokBtn)).click();
        return this;
    }

    public SideMenu navigateToIgenyekPanel(){
        wait.until(ExpectedConditions.elementToBeClickable(igenyekBtn)).click();
        return this;
    }

    public SideMenu navigateToErtesitesekPanel(){
        wait.until(ExpectedConditions.elementToBeClickable(ertesitesekBtn)).click();
        return this;
    }

    public SideMenu navigateToFelhasznalokPanel(){
        wait.until(ExpectedConditions.elementToBeClickable(felhasznalokBtn)).click();
        return this;
    }

    public SideMenu navigateToSzervezetekPanel(){
        wait.until(ExpectedConditions.elementToBeClickable(szervezetekBtn)).click();
        return  this;
    }

    public SideMenu navigateToAdatfeltoltesPanel(){
        wait.until(ExpectedConditions.elementToBeClickable(adatfeltoltesBtn)).click();
        return this;
    }

    public SideMenu navigateToAdatletoltesPanel(){
        wait.until(ExpectedConditions.elementToBeClickable(adatletoltesBtn)).click();
        return this;
    }
}
