package hu.fonixit.buildfolio.autotest.pages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PartnerekPage extends BasePage {
    private final By ujPartnerFelveteleBtn = By.xpath("(//button[normalize-space()='Új partner felvétele'])[1]");
    //új partner felvétele ablak
    private final By felvetelBtn = By.xpath("//span[normalize-space()='Felvétel']");
    private final By megsemBtn = By.xpath("//button[normalize-space()='Mégsem']");
    private final By partnerNeveFld = By.xpath("(//input[@placeholder='Nincs megadva'])[1]");
    private final By telefonszFld = By.xpath("(//input[@placeholder='Nincs megadva'])[2]");
    private final By emailFld = By.xpath("(//input[@placeholder='Nincs megadva'])[3]");
    //lista
    private final By listaUtolsoPartnerNev = By.xpath("//tr[last()]//td[2]");

    public PartnerekPage (WebDriver driver){
        super(driver);
    }
    //lista
    public String kapcsolodoPartnerNev(){  //Ezt átadjuk Szervezet kapcsolódó partner dropdownba
        return wait.until(ExpectedConditions.visibilityOfElementLocated(listaUtolsoPartnerNev)).getText();
    }

    //partner adarok megadása
    public PartnerekPage enterPartnerNeveFld(String partnerNeve){
        wait.until(ExpectedConditions.visibilityOfElementLocated(partnerNeveFld)).sendKeys(partnerNeve);
        return this;
    }

    public PartnerekPage enterTelefonszFld(String telefonszam){
        wait.until(ExpectedConditions.visibilityOfElementLocated(telefonszFld)).sendKeys(telefonszam);
        return this;
    }

    public PartnerekPage enterEmailFld(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFld)).sendKeys(email);
        return this;
    }

    public PartnerekPage clickOnFelvetelBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(felvetelBtn)).click();
        return this;
    }

    public PartnerekPage clickOnMegsemBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(megsemBtn)).click();
        return this;
    }

    public PartnerekPage clickOnUjPartnerFelveteleBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(ujPartnerFelveteleBtn)).click();
        return this;
    }


}
