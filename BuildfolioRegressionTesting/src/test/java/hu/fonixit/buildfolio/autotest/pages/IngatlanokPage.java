package hu.fonixit.buildfolio.autotest.pages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import hu.fonixit.buildfolio.autotest.objects.UjIngatlan;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class IngatlanokPage extends BasePage {
    private final By ujIngatlanFelvetelBtn = By.xpath("//button[normalize-space()='Új ingatlan felvétele']");
    //Új ingatlan felvétele ablak
    private final By felvetelBtn = By.xpath("//button[contains(.,'Felvétel')]");
    private final By megsemBtn = By.xpath("//button[normalize-space()='Mégsem']");

    private final By megnevezesFld  = By.xpath("//app-text-input[@name='name']//input[@placeholder='Nincs megadva']");  //uniqueField
    private final By gpsSzelessegFld = By.xpath("//app-text-input[@name='gpsLatitude']//input[@placeholder='Nincs megadva']");
    private final By gpsHosszusagFld = By.xpath("//app-text-input[@name='gpsLongitude']//input[@placeholder='Nincs megadva']");
    private final By jellegDropDown = By.xpath("(//input[@role='combobox'])[4]");
    private final By helyrajziSzamFld = By.xpath("//app-text-input[@name='topographicalNumber']//input[@placeholder='Nincs megadva']");
    private final By uzemeltetesiRegioDropDown = By.xpath("(//input[@role='combobox'])[7]");
    private final By iranyitoszamFld = By.xpath("//app-text-input[@name='postCode']//input[@placeholder='Nincs megadva']");
    private final By telepulesFld = By.xpath("//app-text-input[@name='city']//input[@placeholder='Nincs megadva']");
    private final By szervezetDropDown = By.xpath("(//input[@role='combobox'])[8]");
    private final By kozteruletNeveFld = By.xpath("//app-text-input[@name='publicPlace']//input[@placeholder='Nincs megadva']");
    private final By tulajdoniStatuszDropDown = By.xpath("(//input[@role='combobox'])[9]");
    private final By hasznositasDropDown = By.xpath("(//input[@role='combobox'])[10]");
    private final By kozteruletTipusaDropDown = By.xpath("(//input[@role='combobox'])[5]");
    private final By hazszamFld = By.xpath("//app-text-input[@name='houseNumber']//input[@placeholder='Nincs megadva']");

    public IngatlanokPage(WebDriver driver) {
        super(driver);
    }

    //assert
    public boolean ingatlanMegjATabl(String egyediAzon, String oszlopIndex){
        return waitUtil.elementIsDisplayedInTable(egyediAzon, oszlopIndex);
    }

    //enterText
    public IngatlanokPage enterTextToMegnevezesFld(String megnevezes){
        waitUtil.waitAndSendkeys(megnevezesFld, megnevezes);
        return this;
    }

    public IngatlanokPage enterTextToGpsSzelessegFld(String gpsSzelesseg){
        waitUtil.waitAndSendkeys(gpsSzelessegFld, gpsSzelesseg);
        return this;
    }

    public IngatlanokPage enterTextToGpsHosszusagFld(String gpsHosszusag){
        waitUtil.waitAndSendkeys(gpsHosszusagFld, gpsHosszusag);
        return this;
    }

    public IngatlanokPage enterTextToHelyrajziSzamFld(String helyrajziSzam){
        waitUtil.waitAndSendkeys(helyrajziSzamFld, helyrajziSzam);
        return this;
    }

    public IngatlanokPage enterTextToIranyitoszamFld(String iranyitoszam){
        waitUtil.waitAndSendkeys(iranyitoszamFld, iranyitoszam);
        return this;
    }

    public IngatlanokPage enterTextToTelepulesFld(String telepules){
        waitUtil.waitAndSendkeys(telepulesFld, telepules);
        return this;
    }

    public IngatlanokPage enterTextToKozteruletNeveFld(String kozteruletNeve){
        waitUtil.waitAndSendkeys(kozteruletNeveFld, kozteruletNeve);
        return this;
    }

    public IngatlanokPage enterTextToHazszamFld(String hazszam){
        waitUtil.waitAndSendkeys(hazszamFld, hazszam);
        return this;
    }

    //click

    //lista első ingatlanja
    public IngatlanokPage clickOnElsoIngatlan(String egyediAzon, String oszlopIndex){
        waitUtil.selectElementFromTableOszlopKivalasztasaval(egyediAzon, oszlopIndex);
        return this;
    }
    //
    public IngatlanokPage clickOnUjIngatlanFelveteleBtn(){
        waitUtil.waitAndClick(ujIngatlanFelvetelBtn);
        return this;
    }

    public IngatlanokPage clickOnFelvetelBtn(){
        waitUtil.waitAndClick(felvetelBtn);
        return this;
    }

    public IngatlanokPage clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    public IngatlanokPage clickJellegDropDown(){
        waitUtil.waitAndClick(jellegDropDown);
        return this;
    }

    public IngatlanokPage clickUzemeltetesiRegioDropDown(){
        waitUtil.waitAndClick(uzemeltetesiRegioDropDown);
        return this;
    }

    public IngatlanokPage clickSzervezetDropDown(){
        waitUtil.waitAndClick(szervezetDropDown);
        return this;
    }

    public IngatlanokPage clickTulajdonosiStatuszDropDown(){
        waitUtil.waitAndClick(tulajdoniStatuszDropDown);
        return this;
    }

    public IngatlanokPage clickHasznositasDropDown(){
        waitUtil.waitAndClick(hasznositasDropDown);
        return this;
    }

    public IngatlanokPage clickKozteruletTipusaDropDown(){
        waitUtil.waitAndClick(kozteruletTipusaDropDown);
        return this;
    }

    //select
    public IngatlanokPage selectElementFromJellegDropDown(String jelleg){
        waitUtil.waitAndSendkeys(jellegDropDown, jelleg);
        driver.findElement(jellegDropDown).sendKeys(Keys.ENTER);
        return this;
    }

    public IngatlanokPage selectElementFromUzemeltetesiRegioDropDown(String uzemeltetesiRegio){
        waitUtil.waitAndSendkeys(uzemeltetesiRegioDropDown, uzemeltetesiRegio);
        driver.findElement(uzemeltetesiRegioDropDown).sendKeys(Keys.ENTER);
        return this;
    }

    public IngatlanokPage selectElementFromSzervezetDropDown(String szervezet){
        waitUtil.waitAndSendkeys(szervezetDropDown, szervezet);
        driver.findElement(szervezetDropDown).sendKeys(Keys.ENTER);
        return this;
    }

    public IngatlanokPage selectElementFromTulajdoniStatuszDropDown(String tulajdoniStatusz){
        waitUtil.waitAndSendkeys(tulajdoniStatuszDropDown, tulajdoniStatusz);
        driver.findElement(tulajdoniStatuszDropDown).sendKeys(Keys.ENTER);
        return this;
    }

    public IngatlanokPage selectElementFromHasznositasDropDown(String hasznositas){
        waitUtil.waitAndSendkeys(hasznositasDropDown, hasznositas);
        driver.findElement(hasznositasDropDown).sendKeys(Keys.ENTER);
        return this;
    }

    public IngatlanokPage selectElementFromKozteruletTipusaDropDown(String kozteruletTipusa){
        waitUtil.waitAndSendkeys(kozteruletTipusaDropDown, kozteruletTipusa);
        driver.findElement(kozteruletTipusaDropDown).sendKeys(Keys.ENTER);
        return this;
    }

    //set ujIngatlan
    public  IngatlanokPage setUjIngatlan(UjIngatlan ujIngatlan){
        return enterTextToGpsSzelessegFld(ujIngatlan.getGpsSzelesseg()).
                enterTextToGpsHosszusagFld(ujIngatlan.getGpsHosszusag()).
                selectElementFromJellegDropDown(ujIngatlan.getJelleg()).
                enterTextToHelyrajziSzamFld(ujIngatlan.getHelyrajziszam()).
                selectElementFromUzemeltetesiRegioDropDown(ujIngatlan.getUzemeltetesiRegio()).
                enterTextToIranyitoszamFld(ujIngatlan.getIranyitoszam()).
                enterTextToTelepulesFld(ujIngatlan.getTelepules()).
                enterTextToKozteruletNeveFld(ujIngatlan.getKozteruletNeve()).
                selectElementFromTulajdoniStatuszDropDown(ujIngatlan.getTulajdoniStatusz()).
                selectElementFromHasznositasDropDown(ujIngatlan.getHasznositas()).
                selectElementFromKozteruletTipusaDropDown(ujIngatlan.getKozteruletTipusa()).
                enterTextToHazszamFld(ujIngatlan.getHazszam());
    }

    public IngatlanokPage selectIngatlanFromTablazat(String ingatlanNeve, String tablaIndex){
        waitUtil.selectElementFromTableOszlopKivalasztasaval(ingatlanNeve, tablaIndex);
        return this;
    }

    //assertion
    public boolean popUpMegjelenik(String popUpSzovege){
        return waitUtil.popupWindMegjelenik(popUpSzovege);
    }

}

