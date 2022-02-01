package hu.fonixit.buildfolio.autotest.pages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SzervezetekPage extends BasePage {
    private final By ujSzervezetFelveteleBtn = By.xpath("//button[normalize-space()='Új szervezet felvétele']");
    private final By szervezetekFelirat = By.cssSelector("h3[class='ng-tns-c156-1']");
    private final By muveletekUtolsoBtn = By.xpath("(//button[@type='button'])[last()]"); //a legutoljára felvett szervezethez tartozo műveletek gomg beazonosítása "last()" metódussal
    private final By szervezetekFromMuveletekDropDown = By.xpath("(//button[normalize-space()='Szerkesztés'])[1]");
    private final By kapcsolodoPartnerFld = By.xpath("(//input[@role='combobox'])[2]");
    //Új szervezet felvétele ablak
    private final By szervezetAzonositoFld = By.xpath("(//input[@placeholder='Nincs megadva'])[1]"); //webelem nem interaktálható
    private final By kapcsolodoPartnerDropDown = By.xpath("(//span[@class='ng-arrow-wrapper'])[2]");
    private final By ADOrganisUnitFld = By.xpath("//input[@placeholder='Nincs megadva']");
    private final By felvetelBtn = By.xpath("//button[@class='btn btn-primary btn-submit']");
    private final By megsemBtn = By.xpath("//button[normalize-space()='Mégsem']");

    public SzervezetekPage(WebDriver driver) {
        super(driver);
    }

    public SzervezetekPage clickOnUjSzervezetFelveteleBtn() {
        waitUtil.waitAndClick(ujSzervezetFelveteleBtn);
        return this;
    }

    public boolean szervezetekFeliratMegjelenik() {
        return waitUtil.elementIsDisplayed(szervezetekFelirat);
    }

    ////Új szervezet felvétele ablak
    public SzervezetekPage clickOnFelvetelBtn() {
        waitUtil.waitAndClick(felvetelBtn);
        return this;
    }

    public SzervezetekPage clickOnMegsemBtn() {
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }


    public SzervezetekPage enterSzervezetAzonositoFld(String szervezAzon) {
        waitUtil.waitAndSendkeys(szervezetAzonositoFld, szervezAzon);
        return this;
    }

    public SzervezetekPage clickOnKapcsolodoPartnerDropDown() {
        waitUtil.waitAndClick(kapcsolodoPartnerDropDown);
        return this;
    }

    public SzervezetekPage selectKapcsolodoPartnerFromDropDown(String kapcsolodoPartn) {
        clickOnKapcsolodoPartnerDropDown();
        waitUtil.waitAndClick(By.xpath("//div[@title='" + kapcsolodoPartn + "']"));
        return this;
    }

    public SzervezetekPage enterADOrganisUnitFld(String ADOrganisUnit) {
        waitUtil.waitAndSendkeys(ADOrganisUnitFld, ADOrganisUnit);
        return this;
    }

    //ellenőrzések

    public boolean felvettSzervezetMegjelenik(String felvettSzervezet)  { //tr[contains(td[1]/text(),'Mogul')]
        String szervezet;
        do{
            szervezet = waitUtil.waitAndGetText(By.xpath("//tr[last()]//td[1]")); //td[1]//td
            if (felvettSzervezet.equals(szervezet)) {
            }
            else {
                waitUtil.waitAndClick(By.xpath("//button[@class='btn next']"));
            }
        }
        while (!felvettSzervezet.equals(szervezet));
        return true;
    }

    public boolean popUpMegjelenik(String popUpSzovege){
        return waitUtil.popupWindMegjelenik(popUpSzovege);
    }



    public boolean felvettKapcsolodoPartnerMegjelenik(String kapcsolodoPartner){
        String partner;
        do{
            partner = waitUtil.waitAndGetText(By.xpath("//tr[last()]//td[2]"));
            if (kapcsolodoPartner.equals(partner)) {
            }
            else {
                waitUtil.waitAndClick(By.xpath("//button[@class='btn next']"));
            }
        }
        while (!kapcsolodoPartner.equals(partner));
        return true;
    }


    public boolean felvetelBtnKattinthato() {
        return waitUtil.elementIsClickable(felvetelBtn);
    }

    //click
    public SzervezetekPage clickOnUtolsoMuveletekBtn (){
        waitUtil.waitAndClick(muveletekUtolsoBtn);
        return this;
    }

    public SzervezetekPage clickOnSzerkesztesUtolsoMuveletekBtn(){
        clickOnUtolsoMuveletekBtn();
        waitUtil.waitAndClick(szervezetekFromMuveletekDropDown);
        return this;
    }

    public boolean szervezetAzonositoNemSzerkesztheto(){
        return waitUtil.fldIsNotEditable(szervezetAzonositoFld, "disabled");
    }

    public SzervezetekPage clearKapcsolodoPartner(){
        waitUtil.waitAndClearText(kapcsolodoPartnerFld);
        return this;
    }

    public SzervezetekPage clearADOrgUnitFld(){
        waitUtil.waitAndClearText(ADOrganisUnitFld);
        return this;
    }
}
