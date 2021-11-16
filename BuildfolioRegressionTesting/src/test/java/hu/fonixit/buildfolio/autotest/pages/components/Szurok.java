package hu.fonixit.buildfolio.autotest.pages.components;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Szurok extends BasePage {
    //gombok
    private final By szurokBtn = By.xpath("//span[contains(text(), 'Szűrők')]");
    private final By keresesBtn = By.xpath("//button[contains(text(), 'Keresés')]");
    private final By szurokTorleseBtn = By.xpath("//button[contains(text(), 'Szűrők törlése')]");
    //Felhasználók
    private final By nevFld = By.cssSelector("input[placeholder='Név']");
    private final By emailFld = By.xpath("//input[@placeholder='Email']");
    private final By szervezetDropDown = By.xpath("(//input[@role='combobox'])[1]");
    private final By szerepkorDropDown = By.xpath("(//input[@role='combobox'])[2]");
    //Szervezetek
    private final By szervezetAzonFld = By.xpath("//input[@placeholder='Szervezet azonosító']");
    private final By kapcsolodoPartnDropDown = By.xpath("//input[@role='combobox']");
    //Parkolók
    private final By azonositoFld = By.xpath("//input[@placeholder='Azonosító']");
    private final By parkoloMegnFld = By.xpath("(//input[@placeholder='Parkoló megnevezése'])[1]");
    private final By tipusDropDown = By.xpath("//input[@role='combobox']");
    private final By iranyitoszamFld = By.xpath("//input[@placeholder='Irányítószám']");
    private final By varosFld = By.xpath("//input[@placeholder='Város']");
    private final By koztNeveFld = By.xpath("//input[@placeholder='Közterület neve']");
    private final By hrszFld = By.xpath("//input[@placeholder='Helyrajzi szám']");


    public Szurok(WebDriver driver){
        super(driver);
    }

    //szervezetek
    public Szurok enterSzervezetAzonFld(String SzervezAzon){
        wait.until(ExpectedConditions.visibilityOfElementLocated(szervezetAzonFld)).sendKeys(SzervezAzon);
        return this;
    }

    public Szurok clickOnKapcsolodoPartnDropDown(){
        wait.until(ExpectedConditions.elementToBeClickable(kapcsolodoPartnDropDown)).click();
        return this;
    }

    public Szurok kapcsolodoPartnerKivalasztasaFromKapcsolodoPartnDropDown(String kapcsolodoPartn){
        clickOnKapcsolodoPartnDropDown();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='"+kapcsolodoPartn+"']"))).click();
        return this;
    }

   //gombok
    public Szurok clickOnSzurokBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(szurokBtn)).click();
        return this;
    }

    public Szurok clickOnKeresesBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(keresesBtn)).click();
        return this;
    }

    public Szurok clickOnSzurokTorleseBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(szurokTorleseBtn)).click();
        return this;
    }

    //felhasználók
    public Szurok enterNev(String nev){
        wait.until(ExpectedConditions.visibilityOfElementLocated(nevFld)).sendKeys(nev);
        return this;
    }

    public Szurok enterEmail(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFld)).sendKeys(email);
        return this;
    }

    public Szurok selectSzervezetFromSzervezetDropdDown(String szervezet){
        wait.until(ExpectedConditions.visibilityOfElementLocated(szervezetDropDown)).click();
        WebElement szerv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='"+szervezet+"']")));
        szerv.click();
        return this;
    }

    public Szurok selectSzerepkorFromSzerepkorDropdDown(String szerepkor){
        wait.until(ExpectedConditions.visibilityOfElementLocated(szerepkorDropDown)).click();
        WebElement szerepk = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[title='"+szerepkor+"']")));
        szerepk.click();
        return this;
    }

    //parkolók
    public Szurok enterTextToAzonositoFld(String azonosito){
        wait.until(ExpectedConditions.visibilityOfElementLocated(azonositoFld)).sendKeys(azonosito);
        return this;
    }

    public Szurok enterTextToParkoloMegnFld (String parkoloMegn){
        wait.until(ExpectedConditions.visibilityOfElementLocated(parkoloMegnFld)).sendKeys(parkoloMegn);
        return this;
    }

    public Szurok selectTipusFromDropDown(String tipus){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@role='combobox'])[1]"))).sendKeys(tipus);
        return this;
    }

    public Szurok enterTextToIranyitoszamFld (String iranyitoszam){
        wait.until(ExpectedConditions.visibilityOfElementLocated(iranyitoszamFld)).sendKeys(iranyitoszam);
        return this;
    }

    public Szurok enterTextToVarosFld (String varos){
        wait.until(ExpectedConditions.visibilityOfElementLocated(varosFld)).sendKeys(varos);
        return this;
    }

    public Szurok enterTextToKoztNeveFld (String kozterNeve){
        wait.until(ExpectedConditions.visibilityOfElementLocated(koztNeveFld)).sendKeys(kozterNeve);
        return this;
    }

    public Szurok enterTextToHrszFld (String hrsz){
        wait.until(ExpectedConditions.visibilityOfElementLocated(hrszFld)).sendKeys(hrsz);
        return this;
    }

    public String felvettSzervezetMegjelenikSzures(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[1]//td[1]"))).getText();
    }

}
