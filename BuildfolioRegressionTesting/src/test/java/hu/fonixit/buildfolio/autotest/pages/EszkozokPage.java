package hu.fonixit.buildfolio.autotest.pages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import hu.fonixit.buildfolio.autotest.objects.UjBankbiztonsagiEszkoz;
import hu.fonixit.buildfolio.autotest.objects.UjBanktechnikaiEszkoz;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EszkozokPage extends BasePage {
    private final By ujAtmFelveteleBtn = By.xpath("//button[.=' Új ATM felvétele ']");
    private final By ujEszkozFelveteleBtn = By.xpath("//button[normalize-space()='Új eszköz felvétele']");
    //Új ATM felvétele
    private final By gyariSzamFld = By.xpath("//app-text-input[@name='factoryNumber']//input[@placeholder='Nincs megadva']");
    private  final By tipusFld = By.xpath("//app-text-input[@name='atmType']//input[@placeholder='Nincs megadva']");
    private final By statuszDropDown = By.xpath("//div//label[contains(.,'Státusz *')]/following::input[@role='combobox']");
    private final By felvetelBtn = By.xpath("//button[contains(.,'Felvétel')]");
    //Új eszköz fölvétele
    private final By megnevezesFld = By.xpath("//app-text-input[@name='deviceName']//input[@placeholder='Nincs megadva']");
    private final By leltariSzamFld = By.xpath("//app-text-input[@name='inventoryNumber']//input[@placeholder='Nincs megadva']");
    private final By eszkozcsoportDropDown = By.xpath("//app-buildfolio-select[@name='deviceGroupCode']//input");
    private final By tipusEszozFld = By.xpath("//app-text-input[@name='deviceType']//input[@placeholder='Nincs megadva']");
    private final By statuszEszkozDropDown = By.xpath("//div//label[.='Státusz *']/following-sibling::app-buildfolio-select//input");
    private final By megsemBtn = By.xpath("//button[normalize-space()='Mégsem']");


    public EszkozokPage(WebDriver driver) {
        super(driver);
    }

    //click
    public EszkozokPage clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    public EszkozokPage clickOnUjAtmFelveteleBtn(){
        waitUtil.waitAndClick(ujAtmFelveteleBtn);
        return this;
    }

    public EszkozokPage clickOnFelvetelBtn(){
        waitUtil.waitAndClick(felvetelBtn);
        return this;
    }

    public EszkozokPage clickOnUjEszkozFelveteleBtn(){
        waitUtil.waitAndClick(ujEszkozFelveteleBtn);
        return this;
    }
    //select
    public EszkozokPage elemKivalasztasaATablazatbol(String elemNeve, String oszlopIndex){
        waitUtil.selectElementFromTableOszlopKivalasztasaval(elemNeve, oszlopIndex);
        return this;
    }

    public EszkozokPage selectStatuszFromDropDown(String statusz){
        waitUtil.waitAndClick(statuszDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+statusz+"']"));
        return this;
    }

    public EszkozokPage selectEszkozcsoportFromDropDown(String eszkozcsoport){
        waitUtil.waitAndClick(eszkozcsoportDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+eszkozcsoport+"']"));
        return this;
    }

    public EszkozokPage selectEszkozStatuszFromDropDown(String statusz){
        waitUtil.waitAndClick(statuszEszkozDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+statusz+"']"));
        return this;
    }

    //sendKeys
    public EszkozokPage enterTextToGyariSzamFld(String gyariSzam){
        waitUtil.waitAndSendkeys(gyariSzamFld, gyariSzam);
        return this;
    }

    public EszkozokPage enterTextToTipusFld(String tipus){
        waitUtil.waitAndSendkeys(tipusFld, tipus);
        return this;
    }

    public EszkozokPage enterTextToMegnevezesFld(String megnevezes){
        waitUtil.waitAndSendkeys(megnevezesFld, megnevezes);
        return this;
    }

    public EszkozokPage enterTextToLeltariSzamFld(String leltariSzam){
        waitUtil.waitAndSendkeys(leltariSzamFld, leltariSzam);
        return this;
    }

    public EszkozokPage enterTextToEszkozTipusFld(String tipus){
        waitUtil.waitAndSendkeys(tipusEszozFld, tipus);
        return this;
    }


    //assertion
    public boolean eszkozMegjelenikATablazatban(String elemNeve, String oszlopIndex){
        return waitUtil.elementIsDisplayedInTable(elemNeve, oszlopIndex);
    }

    public boolean sikeresUzenetMegjelenik(String popupSzoveg){
        return waitUtil.popupWindMegjelenik(popupSzoveg);
    }

    public boolean hibauzenetMegjelenik(String hibauzenetSzovege){
        return waitUtil.popupWindMegjelenik(hibauzenetSzovege);
    }

    public boolean felvetelGombKattinthato(){
        return waitUtil.elementIsClickable(felvetelBtn);
    }

    //set
    public EszkozokPage setUjBankbiztonsagiEszkoz(UjBankbiztonsagiEszkoz ujBankbiztonsagiEszkoz){
        return enterTextToLeltariSzamFld(ujBankbiztonsagiEszkoz.getLeltariSzam()).
                selectEszkozcsoportFromDropDown(ujBankbiztonsagiEszkoz.getEszkozcsoport()).
                enterTextToEszkozTipusFld(ujBankbiztonsagiEszkoz.getTipus()).
                selectEszkozStatuszFromDropDown(ujBankbiztonsagiEszkoz.getStatusz());
    }

    public EszkozokPage setUjBankTechnikaiEszkoz(UjBanktechnikaiEszkoz ujBankTechnikaiEszkoz){
        return enterTextToLeltariSzamFld(ujBankTechnikaiEszkoz.getLeltariSzam()).
                selectEszkozcsoportFromDropDown(ujBankTechnikaiEszkoz.getEszkozcsoport()).
                enterTextToEszkozTipusFld(ujBankTechnikaiEszkoz.getTipus()).
                selectEszkozStatuszFromDropDown(ujBankTechnikaiEszkoz.getStatusz());
    }
}
