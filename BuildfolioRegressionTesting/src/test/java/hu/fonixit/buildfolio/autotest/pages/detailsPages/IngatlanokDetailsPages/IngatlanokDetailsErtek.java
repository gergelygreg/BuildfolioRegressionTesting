package hu.fonixit.buildfolio.autotest.pages.detailsPages.IngatlanokDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IngatlanokDetailsErtek extends BasePage {
    private final By adatokSzerkeszteseBtn = By.xpath("//button[normalize-space()='Adatok szerkesztése']");
    private final By konyvSzerintiNettoErtekValutaDropDown = By.xpath("//app-currency[@amountname='netBookValue']//input[@autocomplete='ad80eb3ac7cb']");
    private final By konyvSzerintiNettoErtekFld = By.xpath("//app-currency[@amountname='netBookValue']//input[@placeholder='Nincs megadva']");
    private final By rogzitesDatumaFld = By.xpath("//app-datepicker-basic[@name='netBookValueDate']//input");
    private final By nettoPiaciForgalmiErtekValutaDropDown = By.xpath("//app-currency[@amountname='netMarketValue']//input[@autocomplete='a54c6ff84ba2']");
    private final By nettoPiaciForgalmiErtekFld = By.xpath("//app-currency[@amountname='netMarketValue']//input[@placeholder='Nincs megadva']");
    private final By utolsoHelysziniSzemlesErtekBecslDatumaFld = By.xpath("//app-datepicker-basic[@name='lastAppraisalDate']//input[@placeholder='Nincs megadva']");
    private final By utolsoHelysziniSzemlesErtekBecslVegzoTarsMegnDropDown = By.xpath("//app-partner-autocomplete[@name='lastAppraisalCompPartnerID']//input");

    private final By mentesBtn = By.xpath("//button[contains(.,'Mentés')]");
    private final By megsemBtn = By.xpath("//button[normalize-space()='Mégsem']");


    public IngatlanokDetailsErtek(WebDriver driver) {
        super(driver);
    }

    //click
    public IngatlanokDetailsErtek clickOnAdatokSzerkeszteseBtn(){
        waitUtil.waitAndClick(adatokSzerkeszteseBtn);
        return this;
    }

    public IngatlanokDetailsErtek clickOnMentesBtn(){
        waitUtil.waitAndClick(mentesBtn);
        return this;
    }

    public IngatlanokDetailsErtek clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    //select
    public IngatlanokDetailsErtek selectOnKonyvSzerintiNettoErtekValuta(String valuta){
        waitUtil.waitAndClick(konyvSzerintiNettoErtekValutaDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+valuta+"']"));
        return this;
    }

    public IngatlanokDetailsErtek selectNettoPiaciForgalmiErtekValutaDropDown(String forgalmiErtek){
        waitUtil.waitAndClick(nettoPiaciForgalmiErtekValutaDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+forgalmiErtek+"']"));
        return this;
    }

    public IngatlanokDetailsErtek selectUtolsoHelysziniSzemlesErtekBecslVegzoTarsMegnDropDown(String tarsasag){
        waitUtil.waitAndClick(utolsoHelysziniSzemlesErtekBecslVegzoTarsMegnDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+tarsasag+"']"));
        return this;
    }

    //sendKeys
    public IngatlanokDetailsErtek enterTextToKonyvSzerintiNettoErtekFld(String konyvSzerintiNettoErtek){
        waitUtil.waitAndSendkeys(konyvSzerintiNettoErtekFld, konyvSzerintiNettoErtek);
        return this;
    }

    public IngatlanokDetailsErtek enterTextToNettoPiaciForgalmiErtekValuta(String forgalmiErtek){
        waitUtil.waitAndSendkeys(nettoPiaciForgalmiErtekFld, forgalmiErtek);
        return this;
    }

    public IngatlanokDetailsErtek enterTextToUtolsoHelysziniSzemlesErtekBecslDatumaFld(String ertekbecslesDatuma){
        waitUtil.waitAndSendkeys(utolsoHelysziniSzemlesErtekBecslDatumaFld, ertekbecslesDatuma);
        return this;
    }

    public IngatlanokDetailsErtek enterTextToRogzitesDatumaFld(String rogzitesDatuma){
        waitUtil.waitAndSendkeys(rogzitesDatumaFld, rogzitesDatuma);
        return this;
    }

    //assert
    public boolean popUpMegjelenik(String popUpSzovege){
        return waitUtil.popupWindMegjelenik(popUpSzovege);
    }

}
