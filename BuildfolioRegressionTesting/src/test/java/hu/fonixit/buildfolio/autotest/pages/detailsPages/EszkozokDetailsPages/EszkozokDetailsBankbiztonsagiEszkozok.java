package hu.fonixit.buildfolio.autotest.pages.detailsPages.EszkozokDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EszkozokDetailsBankbiztonsagiEszkozok extends BasePage {
    //Új eszköz felvétele ablak
    private final By megnevezesFld = By.xpath("//app-new-bank-security-device-modal//app-text-input[@name='deviceName']//input");
    private final By leltariSzamFld = By.xpath("//app-new-bank-security-device-modal//app-text-input[@name='inventoryNumber']//input");
    private final By eszkozcsoportDropDown = By.xpath(("//app-buildfolio-select[@name='deviceGroupCode']//input"));
    private final By tipusFld = By.xpath("//app-new-bank-security-device-modal//app-text-input[@name='deviceType']//input");
    private final By statuszDropDown = By.xpath("//app-new-bank-security-device-modal//app-buildfolio-select[@name='stateCode']//input");
    private final By felvetelBtn = By.xpath("//span[normalize-space()='Felvétel']");
    private final By megsemBtn = By.xpath("//button[normalize-space()='Mégsem']");

    private final By adatokSzerkeszteseBtn = By.xpath("//button[normalize-space()='Adatok szerkesztése']");
    private final By szervizertFelelosPartnerDropDown = By.xpath("//app-partner-autocomplete[@name='maintenancePartnerId']//input");
    private final By mentesBtn = By.xpath("//span[normalize-space()='Mentés']");


    public EszkozokDetailsBankbiztonsagiEszkozok(WebDriver driver) {
        super(driver);
    }

    //click
    public EszkozokDetailsBankbiztonsagiEszkozok clickOnFelvetelBtn(){
        waitUtil.waitAndClick(felvetelBtn);
        return this;
    }

    public EszkozokDetailsBankbiztonsagiEszkozok clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    public EszkozokDetailsBankbiztonsagiEszkozok clickOnAdatokSzerkeszteseBtn(){
        waitUtil.waitAndClick(adatokSzerkeszteseBtn);
        return this;
    }


    public EszkozokDetailsBankbiztonsagiEszkozok clickOnMentesBtn(){
        waitUtil.waitAndClick(mentesBtn);
        return this;
    }


    //enter text
    public EszkozokDetailsBankbiztonsagiEszkozok enterTextToMegnevezesFld(String megnevezes){
        waitUtil.waitAndSendkeys(megnevezesFld, megnevezes);
        return this;
    }

    public EszkozokDetailsBankbiztonsagiEszkozok enterTextToLeltariSzamFld(String leltariSzam){
        waitUtil.waitAndSendkeys(leltariSzamFld, leltariSzam);
        return this;
    }

    public EszkozokDetailsBankbiztonsagiEszkozok enterTextToTipusFld(String tipus){
        waitUtil.waitAndSendkeys(tipusFld, tipus);
        return this;
    }

    //select From dropdown
    public EszkozokDetailsBankbiztonsagiEszkozok selectFromEszkozcsoportDropDown(String eszkozcsoport){
        waitUtil.waitAndClick(eszkozcsoportDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+eszkozcsoport+"']"));
        return this;
    }

    public EszkozokDetailsBankbiztonsagiEszkozok selectFromStatuszDropDown(String statusz){
        waitUtil.waitAndClick(statuszDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+statusz+"']"));
        return this;
    }

    public EszkozokDetailsBankbiztonsagiEszkozok selectFromSzervizertFelelosPartnerDropDown(String szervFelelosPartner){
        waitUtil.waitAndClick(szervizertFelelosPartnerDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+szervFelelosPartner+"']"));
        return this;
    }

    //assert
    public boolean popUpUzenetMegjelenik(String popUpSzoveg){
        return waitUtil.popupWindMegjelenik(popUpSzoveg);
    }

    public boolean elemMegjelenikATablazatban(String egyediAzon, String oszlopIndex){
        return waitUtil.elementIsDisplayedInTable(egyediAzon, oszlopIndex);
    }


}
