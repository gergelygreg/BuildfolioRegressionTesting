package hu.fonixit.buildfolio.autotest.pages.detailsPages.IngatlanokDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import hu.fonixit.buildfolio.autotest.pages.EszkozokPage;
import hu.fonixit.buildfolio.autotest.pages.IngatlanokPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IngatlanokDetailsEszkozok extends BasePage {
    private final By atmekLinkBtn = By.xpath("//a[.=' ATM-ek ']");
    private final By banktechnLinkBtn = By.xpath("//a[.=' Banktechnikai eszközök ']");
    private final By bankbiztLinkBtn = By.xpath("//a[.=' Bankbiztonsági eszközök ']");
    private final By merooraLinkBtn = By.xpath("//a[.=' Mérőórák ']");
    private final By hozzarendelesBtn = By.xpath("//a[normalize-space()='Hozzárendelés']");
    private final By hozzarendelesKijeloltBtn = By.xpath("//button[contains(.,'Hozzárendelés ')]");
    //mérőórák tab
    private final By ujMerooraFelvBtn = By.xpath("//button[.=' Új mérőóra felvétele ']");
    //új mérőóra felvétele ablak
    private final By oratipusDropDown = By.xpath("//div//label[.='Óratípus *']/following-sibling::app-buildfolio-select//input");
    private final By gyariszam = By.xpath("//label[.='Gyári szám']/following-sibling::input");
    private final By kozmucegDropDown = By.xpath("//div//label[.='Közműcég *']/following-sibling::app-public-utility-autocomplete//input");
    private final By felvetleBtn = By.xpath("//button[contains(.,'Felvétel')]");
    private final By megsemBtn = By.xpath("//button[.='Mégsem']");

    public IngatlanokDetailsEszkozok(WebDriver driver) {
        super(driver);
    }

    //checkbox kiválasztása
    public IngatlanokDetailsEszkozok checkboxKivalasztasa(String tipus){
        waitUtil.waitAndClick(By.xpath("//td[normalize-space()='"+tipus+"']/ancestor::tr//td//app-checkbox//div//label"));
        return this;
    }

    //click
    public IngatlanokDetailsEszkozok clickOnHozzarendelesBtn(){
        waitUtil.waitAndClick(hozzarendelesBtn);
        return this;
    }

    public IngatlanokDetailsEszkozok clickOnHozzarendelesKijeloltBtn(){
        waitUtil.waitAndClick(hozzarendelesKijeloltBtn);
        return this;
    }

    public IngatlanokDetailsEszkozok clickOnATMekLinkBtn(){
        waitUtil.waitAndClick(atmekLinkBtn);
        return this;
    }

    public IngatlanokDetailsEszkozok clickOnBanktechnLinkBtn(){
        waitUtil.waitAndClick(banktechnLinkBtn);
        return this;
    }

    public IngatlanokDetailsEszkozok clickOnBankbiztLinkBtn(){
        waitUtil.waitAndClick(bankbiztLinkBtn);
        return this;
    }

    public IngatlanokDetailsEszkozok clickOnMeroorakLinkBtn(){
        waitUtil.waitAndClick(merooraLinkBtn);
        return this;
    }

    public IngatlanokDetailsEszkozok clickOnUjMerooraFelveteleBtn(){
        waitUtil.waitAndClick(ujMerooraFelvBtn);
        return this;
    }

    public IngatlanokDetailsEszkozok clickOnFelvetelBtn(){
        waitUtil.waitAndClick(felvetleBtn);
        return this;
    }

    public IngatlanokDetailsEszkozok clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    //select from DropDown
    public IngatlanokDetailsEszkozok selectFromOratipusDropDown(String oratipus){
        waitUtil.waitAndClick(oratipusDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+oratipus+"']"));
        return this;
    }

    public IngatlanokDetailsEszkozok selectFromKozmucegDropDown(String kozmuceg){
        waitUtil.waitAndClick(kozmucegDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+kozmuceg+"']"));
        return this;
    }

    //sendKeys
    public IngatlanokDetailsEszkozok enterTextGyariSzam(String gyariSzam){
        waitUtil.waitAndSendkeys(gyariszam, gyariSzam);
        return this;
    }

    //select
    public IngatlanokDetailsEszkozok elemKivalasztasaATablazatbol(String elemNeve, String oszlopIndex){
        waitUtil.selectElementFromTableOszlopKivalasztasaval(elemNeve, oszlopIndex);
        return this;
    }

    //assertion
    public boolean felvetelBtnKattinthato(){
        return waitUtil.elementIsClickable(felvetleBtn);
    }

    public boolean popUpMegjelenik(String popUpSzovege){
       return waitUtil.popupWindMegjelenik(popUpSzovege);
    }
}
