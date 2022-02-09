package hu.fonixit.buildfolio.autotest.pages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import hu.fonixit.buildfolio.autotest.objects.UjParkolo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;

public class ParkolokPage extends BasePage {
    private final By ujParkoloFelveteleBtn = By.xpath("//button[@id='lot-create-lot-button']");
    private final By parkolokSzoveg = By.cssSelector("h3[class='ng-tns-c156-1']");
    //Új parkoló felvétele ablak unique fld-s
    private final By parkoloMegnFld = By.xpath("//app-text-input[@name='parkingLotName']//input[@placeholder='Nincs megadva']");
    private final By azonositoFld = By.xpath("//app-text-input[@name='identifier']//input[@placeholder='Nincs megadva']");
    //Új parkoló felvétele ablak
    private final By teruletFld = By.xpath("//app-text-input[@name='area']//input[@placeholder='Nincs megadva']");
    private final By irSzamFld = By.xpath("//app-text-input[@name='postCode']//input[@placeholder='Nincs megadva']");
    private final By varosFld = By.xpath("//app-text-input[@name='city']//input[@placeholder='Nincs megadva']");
    private final By kozteruletNeveFld = By.xpath("//app-text-input[@name='publicPlace']//input[@placeholder='Nincs megadva']");
    private final By hazszamFld = By.xpath("//app-text-input[@name='houseNumber']//input[@placeholder='Nincs megadva']");
    private final By hrszFld = By.xpath("//app-text-input[@name='topographicalNumber']//input[@placeholder='Nincs megadva']");
    private final By felvetelBtn = By.xpath("//span[normalize-space()='Felvétel']");
    private final By megseBtn = By.xpath("//button[normalize-space()='Mégsem']");

    public ParkolokPage(WebDriver driver){
        super(driver);
    }


    public boolean parkolokSzovegMegj(){
        boolean ertek;
        try{
            waitUtil.waitForVisibility(parkolokSzoveg);
            ertek = true;
        }catch (Exception e){
            ertek = false;
        }
        return ertek;
    }

    //click
    public ParkolokPage clickOnMegseBtn(){
        waitUtil.waitAndClick(megseBtn);
        return this;
    }

    public ParkolokPage clickOnFelvetelBtn(){
        waitUtil.waitAndClick(felvetelBtn);
        return this;
    }

    public boolean felvetelBtnKattinthato() {
        WebElement e = waitUtil.waitWebElement(By.xpath("//button[@id='lot-modal-save-button']"));
        return e.isEnabled();
    }

    public  ParkolokPage clickOnUjParkoloFelveteleBtn(){
        waitUtil.waitAndClick(ujParkoloFelveteleBtn);
        return this;
    }

    //sendKeys
    public ParkolokPage enterParkoloMegn(String parkoloMegn){
        waitUtil.waitAndSendkeys(parkoloMegnFld, parkoloMegn);
        return this;
    }

    public ParkolokPage selectParkoloTipFromDropDown(String parkoloTip){
        waitUtil.waitAndSendkeys(By.xpath("(//input[@role='combobox'])[2]"), parkoloTip);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+parkoloTip+"']"));
        return this;
    }

    public ParkolokPage enterTerulet(String terulet){
        waitUtil.waitAndSendkeys(teruletFld, terulet);
        return this;
    }

    public ParkolokPage enterIrSzam(String irSzam){
        waitUtil.waitAndSendkeys(irSzamFld, irSzam);
        return this;
    }

    public ParkolokPage enterVaros(String varos){
        waitUtil.waitAndSendkeys(varosFld, varos);

        return this;
    }

    public ParkolokPage enterKozteruletNeve(String kozteruletNeve){
        waitUtil.waitAndSendkeys(kozteruletNeveFld, kozteruletNeve);
        return this;
    }

    public ParkolokPage selectKoztTipFromDropDown(String kozterTip){
        waitUtil.waitAndSendkeys(By.xpath("(//input[@role='combobox'])[3]"), kozterTip);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+kozterTip+"']"));
        return this;
    }

    public ParkolokPage enterHazszam(String hazSzam){
        waitUtil.waitAndSendkeys(hazszamFld, hazSzam);
        return this;
    }

    public ParkolokPage enterAzonosito(String azonosito){
        waitUtil.waitAndSendkeys(azonositoFld, azonosito);
        return this;
    }

    public ParkolokPage enterHrsz(String hrsz){
        waitUtil.waitAndSendkeys(hrszFld, hrsz);
        return this;
    }

    public boolean felvettParkoloMegjAListaban(String egyediAzon, String oszlopIndex){
        return waitUtil.elementIsDisplayedInTable(egyediAzon, oszlopIndex);
    }


    //setting új parkoló
        public ParkolokPage setUjParkolo(UjParkolo ujParkolo){
            return selectParkoloTipFromDropDown(ujParkolo.getParkoloTipusa()).
                    enterTerulet(ujParkolo.getTerulet()).
                    enterIrSzam(ujParkolo.getIrSzam()).
                    enterVaros(ujParkolo.getVaros()).
                    enterKozteruletNeve(ujParkolo.getKozteruletNeve()).
                    selectKoztTipFromDropDown(ujParkolo.getKozteruletTipusa()).
                    enterHazszam(ujParkolo.getHazszam()).
                    enterHrsz(ujParkolo.getHrsz());
        }

    public ParkolokPage selectParkoloFromTable(String egyediAzon, String oszlopIndex){
        waitUtil.selectElementFromTableOszlopKivalasztasaval(egyediAzon, oszlopIndex);
        return this;
    }

  //assertions
    public boolean popUpSzovegMegj(String popUpSzovege){
        return waitUtil.popupWindMegjelenik(popUpSzovege);
    }

  public boolean azonositoElemMegjelenik(String azon){
       return waitUtil.elementIsDisplayed(By.xpath("//td[1][contains(text(), '"+azon+"')]"));
  }

    public boolean parkMegnevElemMegjelenik(String parkMegn){
        return waitUtil.elementIsDisplayed(By.xpath("//td[2][contains(text(), '"+parkMegn+"')]"));

    }

    public boolean tipusElemMegjelenik(String tipus){
        return waitUtil.elementIsDisplayed(By.xpath("//td[3][contains(text(), '"+tipus+"')]"));
    }

    public boolean iranyitoszamElemMegjelenik(String iranyitoszam){
        return waitUtil.elementIsDisplayed(By.xpath("//td[4][contains(text(), '"+iranyitoszam+"')]"));
    }

    public boolean varosMegjelenik(String varos){
        return waitUtil.elementIsDisplayed(By.xpath("//td[4][contains(text(), '"+varos+"')]"));
    }

    public boolean koztNeveMegjelenik(String koztNeve){
        return waitUtil.elementIsDisplayed(By.xpath("//td[4][contains(text(), '"+koztNeve+"')]"));
    }

    public boolean hrszMegjelenik(String hrsz){
        return waitUtil.elementIsDisplayed(By.xpath("//td[5][contains(text(), '"+hrsz+"')]"));
    }

}
