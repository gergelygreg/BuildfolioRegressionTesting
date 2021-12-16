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
        waitUtil.waitAndClick(alapadatokTab);
        return this;
    }

    public IngatlanokDetailsPageTabs clickOnParkolasTab(){
        waitUtil.waitAndClick(parkolasTab);
        return this;
    }

    public IngatlanokDetailsPageTabs clickOnMuszakiAdatokTab(){
        waitUtil.waitAndClick(muszakiAdatokTab);
        return this;
    }

    public IngatlanokDetailsPageTabs clickOnTulajdoniLapTab(){
        waitUtil.waitAndClick(tulajdoniLapTab);
        return this;
    }

    public IngatlanokDetailsPageTabs clickOnNyilvantartasTab(){
        waitUtil.waitAndClick(nyilvantartasTab);
        return this;
    }

    public IngatlanokDetailsPageTabs clickOnErtekTab(){
        waitUtil.waitAndClick(ertekTab);
        return this;
    }

    public IngatlanokDetailsPageTabs clickOnPartnerekTab(){
        waitUtil.waitAndClick(partnerekTab);
        return this;
    }

    public IngatlanokDetailsPageTabs clickOnSzerzodesekTab(){
        waitUtil.waitAndClick(szerzodesekTab);
        return this;
    }

    public IngatlanokDetailsPageTabs clickOnSzamlakTab(){
        waitUtil.waitAndClick(szamlakTab);
        return this;
    }

    public IngatlanokDetailsPageTabs clickOnAlingatlanokTab(){
        waitUtil.waitAndClick(alingatlanokTab);
        return this;
    }

    public IngatlanokDetailsPageTabs clickOnEszkozokTab(){
        waitUtil.waitAndClick(eszkozokTab);
        return this;
    }

    public IngatlanokDetailsPageTabs clickOnDokumentumokTab(){
        waitUtil.waitAndClick(dokumentumokTab);
        return this;
    }

    public IngatlanokDetailsPageTabs clickOnMunkafolyamatokTab(){
        waitUtil.waitAndClick(munkafolyamatokTab);
        return this;
    }

    public IngatlanokDetailsPageTabs clickOnIgenyekTab(){
        waitUtil.waitAndClick(igenyekTab);
        return this;
    }




}
