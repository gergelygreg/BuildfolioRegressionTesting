package hu.fonixit.buildfolio.autotest.pages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import hu.fonixit.buildfolio.autotest.objects.UjIngatlan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IngatlanokPage extends BasePage {
    private final By ujIngatlanFelvetelBtn = By.xpath("//button[normalize-space()='Új ingatlan felvétele']");
    //Új ingatlan felvétele ablak
    private final By felvetelBtn = By.xpath("//button[@class='btn btn-primary btn-submit']");
    private final By megsemBtn = By.xpath("//button[normalize-space()='Mégsem']");

    private final By megnevezesFld  = By.xpath("//app-text-input[@name='name']//input[@placeholder='Nincs megadva']");  //uniqueField
    private final By gpsSzelessegFld = By.xpath("//app-text-input[@name='gpsLatitude']//input[@placeholder='Nincs megadva']");
    private final By gpsHosszusagFld = By.xpath("//app-text-input[@name='gpsLongitude']//input[@placeholder='Nincs megadva']");
    private final By jellegDropDown = By.xpath("(//span[@class='ng-arrow-wrapper'])[4]");
    private final By helyrajziSzamFld = By.xpath("//app-text-input[@name='topographicalNumber']//input[@placeholder='Nincs megadva']");
    private final By uzemeltetesiRegioDropDown = By.xpath("(//span[@class='ng-arrow-wrapper'])[7]");
    private final By iranyitoszamFld = By.xpath("//app-text-input[@name='postCode']//input[@placeholder='Nincs megadva']");
    private final By varosFld = By.xpath("//app-text-input[@name='city']//input[@placeholder='Nincs megadva']");
    private final By szervezerDropDown = By.xpath("(//span[@class='ng-arrow-wrapper'])[8]");
    private final By kozteruletNeveFld = By.xpath("//app-text-input[@name='publicPlace']//input[@placeholder='Nincs megadva']");
    private final By tulajdoniStatuszDropDown = By.xpath("(//span[@class='ng-arrow-wrapper'])[9]");
    private final By hasznositasDropDown = By.xpath("(//span[@class='ng-arrow-wrapper'])[10]");
    private final By kozteruletTipusaDropDown = By.xpath("(//span[@class='ng-arrow-wrapper'])[5]");
    private final By hazszamFld = By.xpath("//app-text-input[@name='houseNumber']//input[@placeholder='Nincs megadva']");

    public IngatlanokPage(WebDriver driver) {
        super(driver);
    }

    //enterText
    public IngatlanokPage enterTextToMegnevezesFld(String megnevezes){
        wait.until(ExpectedConditions.visibilityOfElementLocated(megnevezesFld)).sendKeys(megnevezes);
        return this;
    }

    public IngatlanokPage enterTextToGpsSzelessegFld(String megnevezes){
        wait.until(ExpectedConditions.visibilityOfElementLocated(gpsSzelessegFld)).sendKeys(megnevezes);
        return this;
    }

    public IngatlanokPage enterTextToGpsHosszusagFld(String megnevezes){
        wait.until(ExpectedConditions.visibilityOfElementLocated(gpsHosszusagFld)).sendKeys(megnevezes);
        return this;
    }

    public IngatlanokPage enterTextToHelyrajziSzamFld(String megnevezes){
        wait.until(ExpectedConditions.visibilityOfElementLocated(helyrajziSzamFld)).sendKeys(megnevezes);
        return this;
    }

    public IngatlanokPage enterTextToIranyitoszamFld(String megnevezes){
        wait.until(ExpectedConditions.visibilityOfElementLocated(iranyitoszamFld)).sendKeys(megnevezes);
        return this;
    }

    public IngatlanokPage enterTextToVarosFld(String megnevezes){
        wait.until(ExpectedConditions.visibilityOfElementLocated(varosFld)).sendKeys(megnevezes);
        return this;
    }

    public IngatlanokPage enterTextToKozteruletNeveFld(String megnevezes){
        wait.until(ExpectedConditions.visibilityOfElementLocated(kozteruletNeveFld)).sendKeys(megnevezes);
        return this;
    }

    public IngatlanokPage enterTextToHazszamFld(String megnevezes){
        wait.until(ExpectedConditions.visibilityOfElementLocated(hazszamFld)).sendKeys(megnevezes);
        return this;
    }

    //click

    //lista első ingatlanja
    public IngatlanokPage clickOnElsoIngatlan(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[1]//td[2]"))).click();
        return this;
    }

    public IngatlanokPage clickOnUjIngatlanFelveteleBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(ujIngatlanFelvetelBtn)).click();
        return this;
    }

    public IngatlanokPage clickOnFelvetelBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(felvetelBtn)).click();
        return this;
    }

    public IngatlanokPage clickOnMegsemBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(megsemBtn)).click();
        return this;
    }

    public IngatlanokPage clickJellegDropDown(){
        wait.until(ExpectedConditions.elementToBeClickable(jellegDropDown)).click();
        return this;
    }

    public IngatlanokPage clickUzemeltetesiRegioDropDown(){
        wait.until(ExpectedConditions.elementToBeClickable(uzemeltetesiRegioDropDown)).click();
        return this;
    }

    public IngatlanokPage clickSzervezetDropDown(){
        wait.until(ExpectedConditions.elementToBeClickable(szervezerDropDown)).click();
        return this;
    }

    public IngatlanokPage clickTulajdonosiStatuszDropDown(){
        wait.until(ExpectedConditions.elementToBeClickable(tulajdoniStatuszDropDown)).click();
        return this;
    }

    public IngatlanokPage clickHasznositasDropDown(){
        wait.until(ExpectedConditions.elementToBeClickable(hasznositasDropDown)).click();
        return this;
    }

    public IngatlanokPage clickKozteruletTipusaDropDown(){
        wait.until(ExpectedConditions.elementToBeClickable(kozteruletTipusaDropDown)).click();
        return this;
    }

    //select
    public IngatlanokPage selectElementFromJellegDropDown(String jelleg){
        clickJellegDropDown();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='"+jelleg+"']"))).click();
        return this;
    }

    public IngatlanokPage selectElementFromUzemeltetesiRegioDropDown(String uzemeltetesiRegio){
        clickUzemeltetesiRegioDropDown();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='"+uzemeltetesiRegio+"']"))).click();
        return this;
    }

    public IngatlanokPage selectElementFromSzervezetDropDown(String szervezet){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-buildfolio-select[@name='name']//input[@role='combobox']"))).sendKeys(szervezet);
        return this;
    }

    public IngatlanokPage selectElementFromTulajdoniStatuszDropDown(String tulajdoniStatusz){
        clickTulajdonosiStatuszDropDown();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='"+tulajdoniStatusz+"']"))).click();
        return this;
    }

    public IngatlanokPage selectElementFromHasznositasDropDown(String hasznositas){
        clickHasznositasDropDown();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='"+hasznositas+"']"))).click();
        return this;
    }

    public IngatlanokPage selectElementFromKozteruletTipusaDropDown(String kozteruletTipusa){
        clickKozteruletTipusaDropDown();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='"+kozteruletTipusa+"']"))).click();
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
                enterTextToVarosFld(ujIngatlan.getVaros()).
                enterTextToKozteruletNeveFld(ujIngatlan.getKozteruletNeve()).
                selectElementFromTulajdoniStatuszDropDown(ujIngatlan.getTulajdoniStatusz()).
                selectElementFromHasznositasDropDown(ujIngatlan.getHasznositas()).
                selectElementFromKozteruletTipusaDropDown(ujIngatlan.getKozteruletTipusa()).
                enterTextToHazszamFld(ujIngatlan.getHazszam());
    }


}

