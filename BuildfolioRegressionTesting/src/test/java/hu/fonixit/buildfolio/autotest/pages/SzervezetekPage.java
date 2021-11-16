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
    private final By kapcsolodoPartnerTorles = By.xpath("//span[@title='Clear all']");
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
        wait.until(ExpectedConditions.elementToBeClickable(ujSzervezetFelveteleBtn)).click();
        return this;
    }

    public SzervezetekPage szervezetekFeliratMegjelenik() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(szervezetekFelirat));
        return this;
    }

    ////Új szervezet felvétele ablak
    public SzervezetekPage clickOnFelvetelBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(felvetelBtn)).click();
        return this;
    }

    public SzervezetekPage clickOnMegsemBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(megsemBtn)).click();
        return this;
    }


    public SzervezetekPage enterSzervezetAzonositoFld(String szervezAzon) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(szervezetAzonositoFld)).sendKeys(szervezAzon);
        return this;
    }

    public SzervezetekPage clickOnKapcsolodoPartnerDropDown() {
        wait.until(ExpectedConditions.elementToBeClickable(kapcsolodoPartnerDropDown)).click();
        return this;
    }

    public SzervezetekPage selectKapcsolodoPartnerFromDropDown(String kapcsolodoPartn) {
        clickOnKapcsolodoPartnerDropDown();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='" + kapcsolodoPartn + "']"))).click();
        return this;
    }

    public SzervezetekPage enterADOrganisUnitFld(String ADOrganisUnit) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADOrganisUnitFld)).sendKeys(ADOrganisUnit);
        return this;
    }

    //ellenőrzések

    public boolean felvettSzervezetMegjelenik(String felvettSzervezet)  {
        String szervezet;
        do{
            szervezet = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[last()]//td[1]"))).getText();
            if (felvettSzervezet.equals(szervezet)) {
            }
            else {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn next']"))).click();
            }
        }
        while (!felvettSzervezet.equals(szervezet));
        return true;
    }





    public boolean felvettKapcsolodoPartnerMegjelenik(String kapcsolodoPartner){
        String partner;
        do{
            partner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[last()]//td[2]"))).getText();
            if (kapcsolodoPartner.equals(partner)) {
            }
            else {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn next']"))).click();
            }
        }
        while (!kapcsolodoPartner.equals(partner));
        return true;
    }


    public boolean felvetelBtnKattinthato() {
        boolean ertek;
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(felvetelBtn));
        if (e.isEnabled()) {
            ertek = true;
        }else{
            ertek = false;
        }
        return ertek;
    }
    //

    public SzervezetekPage clickOnUtolsoMuveletekBtn (){
        wait.until(ExpectedConditions.elementToBeClickable(muveletekUtolsoBtn)).click();
        return this;
    }

    public SzervezetekPage clickOnSzerkesztesUtolsoMuveletekBtn(){
        clickOnUtolsoMuveletekBtn();
        wait.until(ExpectedConditions.elementToBeClickable(szervezetekFromMuveletekDropDown)).click();
        return this;
    }

    public boolean szervezetAzonositoSzerkesztheto(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(szervezetAzonositoFld)).isSelected();
    }

    public SzervezetekPage clearKapcsolodoPartner(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(kapcsolodoPartnerTorles)).click();
        return this;
    }

    public SzervezetekPage clearADOrgUnitFld(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADOrganisUnitFld)).clear();
        return this;
    }
}
