package hu.fonixit.buildfolio.autotest.pages.components;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IngatlanokDetailsPageTabs extends BasePage {
    //fülek
    private final By alapadatokTab = By.linkText("Alapadatok");
    private final By parkolasTab = By.linkText("Parkolás");
    private final By muszakiAdatokTab = By.linkText("Műszaki adatok");
    private final By tulajdoniLapTab = By.linkText("Tulajdoni lap");
    private final By nyilvantartasTab = By.linkText("Nyilvántartás");
    private final By ertekTab = By.linkText("Érték");
    private final By partnerekTab = By.linkText("Partnerek");
    private final By szerzodesekTab = By.linkText("Szerződések");
    private final By szamlakTab = By.linkText("Számlák");
    private final By alingatlanokTab = By.linkText("Alingatlanok");
    private final By eszkozokTab = By.linkText("Eszközök");
    private final By dokumentumokTab = By.linkText("Dokumentumok");
    private final By munkafolyamatokTab = By.linkText("Munkafolyamatok");
    private final By igenyekTab = By.linkText("Igények");

    public IngatlanokDetailsPageTabs(WebDriver driver){
        super(driver);
    }

    //click
    public IngatlanokDetailsPageTabs clickOnAlapadatokTab(){
        wait.until(ExpectedConditions.elementToBeClickable(alapadatokTab)).click();
        return this;
    }

    public IngatlanokDetailsPageTabs clickOnParkolasTab(){
        wait.until(ExpectedConditions.elementToBeClickable(parkolasTab)).click();
        return this;
    }

    public IngatlanokDetailsPageTabs clickOnMuszakiAdatokTab(){
        wait.until(ExpectedConditions.elementToBeClickable(muszakiAdatokTab)).click();
        return this;
    }

    public IngatlanokDetailsPageTabs clickOnTulajdoniLapTab(){
        wait.until(ExpectedConditions.elementToBeClickable(tulajdoniLapTab)).click();
        return this;
    }

    public IngatlanokDetailsPageTabs clickOnNyilvantartasTab(){
        wait.until(ExpectedConditions.elementToBeClickable(nyilvantartasTab)).click();
        return this;
    }

    public IngatlanokDetailsPageTabs clickOnErtekTab(){
        wait.until(ExpectedConditions.elementToBeClickable(ertekTab)).click();
        return this;
    }

    public IngatlanokDetailsPageTabs clickOnPartnerekTab(){
        wait.until(ExpectedConditions.elementToBeClickable(partnerekTab)).click();
        return this;
    }

    public IngatlanokDetailsPageTabs clickOnSzerzodesekTab(){
        wait.until(ExpectedConditions.elementToBeClickable(szerzodesekTab)).click();
        return this;
    }

    public IngatlanokDetailsPageTabs clickOnSzamlakTab(){
        wait.until(ExpectedConditions.elementToBeClickable(szamlakTab)).click();
        return this;
    }

    public IngatlanokDetailsPageTabs clickOnAlingatlanokTab(){
        wait.until(ExpectedConditions.elementToBeClickable(alingatlanokTab)).click();
        return this;
    }

    public IngatlanokDetailsPageTabs clickOnEszkozokTab(){
        wait.until(ExpectedConditions.elementToBeClickable(eszkozokTab)).click();
        return this;
    }

    public IngatlanokDetailsPageTabs clickOnDokumentumokTab(){
        wait.until(ExpectedConditions.elementToBeClickable(dokumentumokTab)).click();
        return this;
    }

    public IngatlanokDetailsPageTabs clickOnMunkafolyamatokTab(){
        wait.until(ExpectedConditions.elementToBeClickable(munkafolyamatokTab)).click();
        return this;
    }

    public IngatlanokDetailsPageTabs clickOnIgenyekTab(){
        wait.until(ExpectedConditions.elementToBeClickable(igenyekTab)).click();
        return this;
    }




}
