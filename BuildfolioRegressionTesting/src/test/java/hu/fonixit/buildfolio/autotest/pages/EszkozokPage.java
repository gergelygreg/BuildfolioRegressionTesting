package hu.fonixit.buildfolio.autotest.pages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EszkozokPage extends BasePage {
    private final By ujAtmFelveteleBtn = By.xpath("//button[.=' Új ATM felvétele ']");
    private final By ujEszkozFelveteleBtn = By.xpath("//button[normalize-space()='Új eszköz felvétele']");
    //Új ATM felvétele
    private final By gyariSzamFld = By.xpath("//app-text-input[@name='factoryNumber']//input[@placeholder='Nincs megadva']");
    private  final By tipusFld = By.xpath("//app-text-input[@name='atmType']//input[@placeholder='Nincs megadva']");
    private final By statuszDropDown = By.xpath("//ng-select[@class='ng-select ng-select-single ng-select-searchable ng-select-clearable ng-untouched ng-pristine ng-invalid ng-star-inserted ng-select-opened ng-select-bottom']//input[@role='combobox']");
    private final By felvetelBtn = By.xpath("//button[contains(.,'Felvétel')]");


    public EszkozokPage(WebDriver driver) {
        super(driver);
    }

    //click
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

    //sendKeys
    public EszkozokPage enterTextToGyariSzamFld(String gyariSzam){
        waitUtil.waitAndSendkeys(gyariSzamFld, gyariSzam);
        return this;
    }

    public EszkozokPage enterTextToTipusFld(String tipus){
        waitUtil.waitAndSendkeys(tipusFld, tipus);
        return this;
    }

    //assertion
    public boolean eszkozMegjelenikATablazatban(String elemNeve, String oszlopIndex){
        return waitUtil.elementIsDisplayedInTable(elemNeve, oszlopIndex);
    }

    public boolean sikeresUzenetMegjelenik(String popupSzoveg){
        return waitUtil.popupWindMegjelenik(popupSzoveg);
    }
}
