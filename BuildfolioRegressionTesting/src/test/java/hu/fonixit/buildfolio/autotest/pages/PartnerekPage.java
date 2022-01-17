package hu.fonixit.buildfolio.autotest.pages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PartnerekPage extends BasePage {
    private final By ujPartnerFelveteleBtn = By.xpath("(//button[normalize-space()='Új partner felvétele'])[1]");
    //új partner felvétele ablak
    private final By felvetelBtn = By.xpath("//span[normalize-space()='Felvétel']");
    private final By megsemBtn = By.xpath("//button[normalize-space()='Mégsem']");
    private final By partnerNeveFld = By.xpath("(//input[@placeholder='Nincs megadva'])[1]");
    private final By telefonszFld = By.xpath("(//input[@placeholder='Nincs megadva'])[2]");
    private final By emailFld = By.xpath("(//input[@placeholder='Nincs megadva'])[3]");
    private final By kozmuChb = By.xpath("//label[.=' Közműcég ']");
    //lista
    private final By listaUtolsoPartnerNev = By.xpath("//tr[last()]//td[2]");

    public PartnerekPage (WebDriver driver){
        super(driver);
    }
    //lista
    public String kapcsolodoPartnerNev(){  //Ezt átadjuk Szervezet kapcsolódó partner dropdownba
        return waitUtil.waitAndGetText(listaUtolsoPartnerNev);
    }

    //partner adatok megadása
    public PartnerekPage enterPartnerNeveFld(String partnerNeve){
        waitUtil.waitAndSendkeys(partnerNeveFld, partnerNeve);
        return this;
    }

    public PartnerekPage enterTelefonszFld(String telefonszam){
        waitUtil.waitAndSendkeys(telefonszFld, telefonszam);
        return this;
    }

    public PartnerekPage enterEmailFld(String email){
        waitUtil.waitAndSendkeys(emailFld, email);
        return this;
    }

    //click
    public PartnerekPage clickOnFelvetelBtn(){
        waitUtil.waitAndClick(felvetelBtn);
        return this;
    }

    public PartnerekPage clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    public PartnerekPage clickOnUjPartnerFelveteleBtn(){
        waitUtil.waitAndClick(ujPartnerFelveteleBtn);
        return this;
    }

    public PartnerekPage clickOnListaElsoEleme(){
        waitUtil.waitAndClick(By.xpath("//tr[1]"));
        return this;
    }

    //select
    public PartnerekPage selectKozmuChb(){
        WebElement chb = driver.findElement(kozmuChb);
        chb.click();
        return this;
    }

    public PartnerekPage selectPartnerFromTable(String partnerNeve, String oszlopIndex){
        waitUtil.selectElementFromTableOszlopKivalasztasaval(partnerNeve, oszlopIndex);
        return this;
    }

    //assertion
    public  boolean uzenetMegjelenik(String uzenet){
       return waitUtil.popupWindMegjelenik(uzenet);
    }

    public boolean partnerMegjATablaban(String elemNeve, String oszlop){
       return waitUtil.elementIsDisplayedInTable(elemNeve, oszlop);
    }


    public boolean partnerekTextMegjelenik(){
         return waitUtil.elementIsDisplayed(By.xpath("//h3[contains(.,'Partnerek')]"));
    }

    public String alapadatokLinkActive() {
        WebElement alapadLink = driver.findElement(By.xpath("//a[.='Alapadatok']"));
        String value = alapadLink.getAttribute("class");
        return value;
    }

}
