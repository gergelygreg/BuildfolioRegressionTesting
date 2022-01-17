package hu.fonixit.buildfolio.autotest.pages.detailsPages.EszkozokDetailsPages;

import com.github.javafaker.Bool;
import hu.fonixit.buildfolio.autotest.base.BasePage;
import hu.fonixit.buildfolio.autotest.objects.UjAtmAlapadatok;
import hu.fonixit.buildfolio.autotest.pages.EszkozokPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EszkozokDetailsAtm extends BasePage {
    private final By adatokSzerkeszteseBtn = By.xpath("//button[.=' Adatok szerkesztése ']");
    private final By mentesBtn = By.xpath("//button[contains(.,'Mentés')]");
    private final By megsemBtn = By.xpath("//button[contains(.,'Mégsem')]");
    //fieldek
    private final By szervizertFelelosPartnerFld = By.xpath("(//input[@role='combobox'])[2]");
    private  final By beepitettsegDropDwon = By.xpath("(//input[@role='combobox'])[1]");
    private final By penznemDropDown = By.xpath("(//input[@role='combobox'])[4]");
    private  final By toltesiOsszegFld = By.xpath("//app-text-input[@name='fillingAmount']//input[@placeholder='Nincs megadva']");
    private final By hitelkeretFld = By.xpath("//app-text-input[@name='creditLine']//input[@placeholder='Nincs megadva']");;
    private final By kartyaSzamFld = By.xpath("//app-text-input[@name='cardNumber']//input");
    private final By kartyaErvenyesFld = By.xpath("//app-datepicker-basic[@name='cardValidityDate']//input");
    private final By kartyaHasznalojaFld = By.xpath("//app-text-input[@name='cardUser']//input[@placeholder='Nincs megadva']");
    private final By kartyaolvasoTipusa = By.xpath("//app-text-input[@name='cardReaderType']//input[@placeholder='Nincs megadva']");
    private final By halozatiSzolgaltatoFld = By.xpath("//app-text-input[@name='networkServiceProvider']//input[@placeholder='Nincs megadva']");
    private final By cimletekFld = By.xpath("//app-text-input[@name='denomination']//input[@placeholder='Nincs megadva']");
    private final By festekszalagJournalTipusaFld = By.xpath("//app-text-input[@name='ribbonJournalType']//input[@placeholder='Nincs megadva']");
    private final By journalNyomtatoTipusaFld = By.xpath("//app-text-input[@name='journalTapeType']//input[@placeholder='Nincs megadva']");
    private final By journalSzalagTipusaFld = By.xpath("//app-text-input[@name='customerTapeType']//input[@placeholder='Nincs megadva']");
    private final By ugyfelBonSzalagTipusaFld = By.xpath("//app-text-input[@name = 'customerTapeType']//input");


    public EszkozokDetailsAtm(WebDriver driver) {
        super(driver);
    }

    //select
    public EszkozokDetailsAtm selectPartnerFromSzervizertFelPartnerDropDown(String partner){
        waitUtil.waitAndClick(szervizertFelelosPartnerFld);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+partner+"']"));
        return this;
    }

    public EszkozokDetailsAtm selectBeepitettsegFromDropDown(String beepitettseg){
        waitUtil.waitAndClick(beepitettsegDropDwon);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+beepitettseg+"']"));
        return this;
    }

    public EszkozokDetailsAtm selectPenznemFromDropDown(String penznem){
        waitUtil.waitAndClick(penznemDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+penznem+"']"));
        return this;
    }

    //enter text
    public EszkozokDetailsAtm enterTextToToltesiOsszegFld(String toltesiOsszeg){
        waitUtil.waitAndSendkeys(toltesiOsszegFld, toltesiOsszeg);
        return this;
    }

    public EszkozokDetailsAtm enterTextToHitelkeretFld(String hitelkeret)
    {
        waitUtil.waitAndSendkeys(hitelkeretFld, hitelkeret);
        return this;
    }

    public EszkozokDetailsAtm enterTextToKartyaSzamaFld(String kartyaSzama){
        waitUtil.waitAndSendkeys(kartyaSzamFld, kartyaSzama);
        return this;
    }

    public EszkozokDetailsAtm enterTextToKartyaErvenyesFld(String kartyaErvenyesDatum){
        waitUtil.waitAndSendkeys(kartyaErvenyesFld, kartyaErvenyesDatum);
        return this;
    }

    public EszkozokDetailsAtm enterTextToKartyaHasznalojaFld(String kartyahsznaloja){
        waitUtil.waitAndSendkeys(kartyaHasznalojaFld, kartyahsznaloja);
        return this;
    }

    public EszkozokDetailsAtm enterTextToKartyaOlvasoTipusaFld(String kartyaOlvasoTipusa){
        waitUtil.waitAndSendkeys(kartyaolvasoTipusa, kartyaOlvasoTipusa);
        return this;
    }

    public EszkozokDetailsAtm enterTextToHalozatiSzolgaltatoFld(String halozatiSzolgaltato){
        waitUtil.waitAndSendkeys(halozatiSzolgaltatoFld, halozatiSzolgaltato);
        return this;
    }

    public EszkozokDetailsAtm enterTextToCimletekFld(String cimletek){
        waitUtil.waitAndSendkeys(cimletekFld, cimletek);
        return this;
    }

    public EszkozokDetailsAtm enterTextToFestekSzalagJournalTipusaFld(String festekSzalagJournalTipusa){
        waitUtil.waitAndSendkeys(festekszalagJournalTipusaFld, festekSzalagJournalTipusa);
        return this;
    }

    public EszkozokDetailsAtm enterTextToJournalNyomtatoTipusa(String journalNyomtatoTipusa){
        waitUtil.waitAndSendkeys(journalNyomtatoTipusaFld, journalNyomtatoTipusa);
        return this;
    }

    public EszkozokDetailsAtm enterTextToJournalSzalagTipusa(String journalSzalagTipusa){
        waitUtil.waitAndSendkeys(journalSzalagTipusaFld, journalSzalagTipusa);
        return this;
    }

    public EszkozokDetailsAtm enterTextUgyfelBonSzalagTipusa(String ugyfelBonSzalagTipusa){
        waitUtil.waitAndSendkeys(ugyfelBonSzalagTipusaFld, ugyfelBonSzalagTipusa);
        return this;
    }

    //click
    public EszkozokDetailsAtm clickOnAdatokSzerkeszteseBtn(){
        waitUtil.waitAndClick(adatokSzerkeszteseBtn);
        return this;
    }

    public EszkozokDetailsAtm clickOnMentesBtn(){
        waitUtil.waitAndClick(mentesBtn);
        return this;
    }

    public EszkozokDetailsAtm clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }


    //set ATM alapadatok
    public EszkozokDetailsAtm setUjAtmAlapadatok(UjAtmAlapadatok ujAtmAlapadatok){
        return selectBeepitettsegFromDropDown(ujAtmAlapadatok.getBeepitettseg()).
                selectPenznemFromDropDown(ujAtmAlapadatok.getPenznem()).
                enterTextToToltesiOsszegFld(ujAtmAlapadatok.getToltesiOsszeg()).
                enterTextToHitelkeretFld(ujAtmAlapadatok.getHitelkeret()).
                enterTextToKartyaSzamaFld(ujAtmAlapadatok.getKartyaSzama()).
                enterTextToKartyaErvenyesFld(ujAtmAlapadatok.getKartyaErvenyes()).
                enterTextToKartyaHasznalojaFld(ujAtmAlapadatok.getKartyaHasznaloja()).
                enterTextToKartyaOlvasoTipusaFld(ujAtmAlapadatok.getKartyaolvasoTipusa()).
                enterTextToHalozatiSzolgaltatoFld(ujAtmAlapadatok.getHalozatiSzolgaltato()).
                enterTextToCimletekFld(ujAtmAlapadatok.getCimletek()).
                enterTextToFestekSzalagJournalTipusaFld(ujAtmAlapadatok.getFestekSzalahJournalTipusa()).
                enterTextToJournalNyomtatoTipusa(ujAtmAlapadatok.getJournalNyomtatoTipusa()).
                enterTextToJournalSzalagTipusa(ujAtmAlapadatok.getJournalSzalagTipusa()).
                enterTextUgyfelBonSzalagTipusa(ujAtmAlapadatok.getUgyfelBonSzalagTipusa());
    }

}
