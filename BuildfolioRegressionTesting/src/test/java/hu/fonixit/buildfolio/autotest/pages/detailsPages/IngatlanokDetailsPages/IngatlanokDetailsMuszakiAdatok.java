package hu.fonixit.buildfolio.autotest.pages.detailsPages.IngatlanokDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import hu.fonixit.buildfolio.autotest.objects.UjMuszakiAdatok;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IngatlanokDetailsMuszakiAdatok extends BasePage {
    private final By adatokSzerkeszteseBtn = By.xpath("//button[contains(.,'Adatok szerkesztése')]");
    private final By mentesBtn = By.xpath("//span[normalize-space()='Mentés']");
    private final By megsemBtn = By.xpath("//button[normalize-space()='Mégsem']");

    private final By epitesEveDropDown = By.xpath("(//input[@role='combobox'])[1]");
    private final By utolsoFelujEveDropDown = By.xpath("(//span[@class='ng-arrow'])[2]");
    private final By kozmuvesitettsegFld = By.xpath("//app-text-input[@name='publicUtilities']//input[@placeholder='Nincs megadva']");




    public IngatlanokDetailsMuszakiAdatok(WebDriver driver){
        super(driver);
    }

    //click
    public IngatlanokDetailsMuszakiAdatok clickOnAdatokSzerkeszteseBtn(){
        waitUtil.waitAndClick(adatokSzerkeszteseBtn);
        return this;
    }

    public IngatlanokDetailsMuszakiAdatok clickOnMentesBtn(){
        waitUtil.waitAndClick(mentesBtn);
        return this;
    }

    public IngatlanokDetailsMuszakiAdatok clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    public IngatlanokDetailsMuszakiAdatok clickOnEpitesEveDropDown(){
        waitUtil.waitAndClick(epitesEveDropDown);
        return this;
    }

    public IngatlanokDetailsMuszakiAdatok clickOnUtolsoFelujEveDropDown(){
        waitUtil.waitAndClick(utolsoFelujEveDropDown);
        return this;
    }

    //select
    public IngatlanokDetailsMuszakiAdatok selectElementFromEpitesEveDropDown(String epitesEve){
        waitUtil.waitAndSendkeys(By.xpath("(//input[@role='combobox'])[1]"), epitesEve);
        return this;
    }



    public IngatlanokDetailsMuszakiAdatok selectElementFromUtolsoFelujEveDropDown(String utolsoFelujEve){
        waitUtil.waitAndSendkeys(By.xpath("(//input[@role='combobox'])[2]"), utolsoFelujEve);
        return this;
    }


    //enter
    public IngatlanokDetailsMuszakiAdatok enterTextToKozmuvesitettseg(String kozmuvetitettseg){
        waitUtil.waitAndSendkeys(kozmuvesitettsegFld, kozmuvetitettseg);
        return this;
    }

    //set új műszaki adatok
    public IngatlanokDetailsMuszakiAdatok setUjMuszakiAdatok(UjMuszakiAdatok ujMuszakiAdatok){
        return selectElementFromEpitesEveDropDown(ujMuszakiAdatok.getEpitesEve()).
                selectElementFromUtolsoFelujEveDropDown(ujMuszakiAdatok.getUtolsoFelujitasEve()).
                enterTextToKozmuvesitettseg(ujMuszakiAdatok.getKozmuvesitettseg());
    }


}
