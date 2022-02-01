package hu.fonixit.buildfolio.autotest.pages.detailsPages.EszkozokDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EszkozokDetailsBanktecknikaiEszkozok extends BasePage {
    //Új eszköz felvétele ablak
    private final By megnevezesFld = By.xpath("//app-new-bank-technical-device-modal//app-text-input[@name='deviceName']//input");
    private final By leltariSzamFld = By.xpath("//app-new-bank-technical-device-modal//app-text-input[@name='inventoryNumber']//input");
    private final By eszkozcsoportDropDown = By.xpath(("//app-new-bank-technical-device-modal//app-buildfolio-select[@name='deviceGroupCode']//input"));
    private final By tipusFld = By.xpath("//app-new-bank-technical-device-modal//app-text-input[@name='deviceType']//input");
    private final By statuszDropDown = By.xpath("//app-new-bank-technical-device-modal//app-buildfolio-select[@name='stateCode']//input");
    private final By felvetelBtn = By.xpath("//span[normalize-space()='Felvétel']");
    private final By megsemBtn = By.xpath("//button[normalize-space()='Mégsem']");
    //Alapadatok
    private final By adatokSzerkeszteseBtn = By.xpath("//button[normalize-space()='Adatok szerkesztése']");
    private final By szervizertFelelosPartnerDropDown = By.xpath("//app-partner-autocomplete[@name='maintenancePartnerId']//input");
    private final By mentesBtn = By.xpath("//span[normalize-space()='Mentés']");

    public EszkozokDetailsBanktecknikaiEszkozok(WebDriver driver) {
        super(driver);
    }

    //click
    public EszkozokDetailsBanktecknikaiEszkozok clickOnFelvetelBtn(){
       waitUtil.waitAndClick(felvetelBtn);
       return this;
    }

    public EszkozokDetailsBanktecknikaiEszkozok clickOnAdatokSzerkeszteseBtn(){
        waitUtil.waitAndClick(adatokSzerkeszteseBtn);
        return this;
    }

    public EszkozokDetailsBanktecknikaiEszkozok clickOnMentesBtn(){
        waitUtil.waitAndClick(mentesBtn);
        return this;
    }

    public EszkozokDetailsBanktecknikaiEszkozok clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    //enter text
    public EszkozokDetailsBanktecknikaiEszkozok enterTextToMegnevezesFld(String megnevezes){
        waitUtil.waitAndSendkeys(megnevezesFld, megnevezes);
        return this;
    }

    public EszkozokDetailsBanktecknikaiEszkozok enterTextToLeltariSzamFld(String leltariSzam){
        waitUtil.waitAndSendkeys(leltariSzamFld, leltariSzam);
        return this;
    }

    public EszkozokDetailsBanktecknikaiEszkozok enterTextToTipusFld(String tipus){
        waitUtil.waitAndSendkeys(tipusFld, tipus);
        return this;
    }

    //select From dropdown
    public EszkozokDetailsBanktecknikaiEszkozok selectFromEszkozcsoportDropDown(String eszkozcsoport){
        waitUtil.waitAndClick(eszkozcsoportDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+eszkozcsoport+"']"));
        return this;
    }

    public EszkozokDetailsBanktecknikaiEszkozok selectFromStatuszDropDown(String statusz){
        waitUtil.waitAndClick(statuszDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+statusz+"']"));
        return this;
    }

    public EszkozokDetailsBanktecknikaiEszkozok selectFromSzervizertFelelosPartnerDropDown(String szervFelelosPartner){
        waitUtil.waitAndClick(szervizertFelelosPartnerDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+szervFelelosPartner+"']"));
        return this;
    }

    //assert
    public boolean popUpMegjelenik(String popUpSzovege){
        return waitUtil.popupWindMegjelenik(popUpSzovege);
    }

    public boolean elemMegjelenikATablazatban(String egyediAzon, String oszlopIndex){
        return waitUtil.elementIsDisplayedInTable(egyediAzon, oszlopIndex);
    }
}
