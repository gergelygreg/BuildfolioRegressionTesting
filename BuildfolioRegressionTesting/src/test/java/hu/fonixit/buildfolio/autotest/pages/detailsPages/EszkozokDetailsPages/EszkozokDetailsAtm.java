package hu.fonixit.buildfolio.autotest.pages.detailsPages.EszkozokDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import hu.fonixit.buildfolio.autotest.objects.UjAtmAlapadatok;
import hu.fonixit.buildfolio.autotest.pages.EszkozokPage;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.IgenyekDetailsPages.IgenyekDetailsAlapadatok;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class EszkozokDetailsAtm extends BasePage {
    private final By adatokSzerkeszteseBtn = By.xpath("//button[.=' Adatok szerkesztése ']");
    private final By mentesBtn = By.xpath("//button[contains(.,'Mentés')]");
    private final By megsemBtn = By.xpath("//button[contains(.,'Mégsem')]");
    //Alapadatok
    private final By szervizertFelelosPartnerFld = By.xpath("(//input[@role='combobox'])[2]");
    private final By beepitettsegDropDwon = By.xpath("(//input[@role='combobox'])[1]");
    private final By statuszDropDown = By.xpath("(//input[@role='combobox'])[3]");
    private final By penznemDropDown = By.xpath("(//input[@role='combobox'])[4]");
    private final By toltesiOsszegFld = By.xpath("//app-text-input[@name='fillingAmount']//input[@placeholder='Nincs megadva']");
    private final By hitelkeretFld = By.xpath("//app-text-input[@name='creditLine']//input[@placeholder='Nincs megadva']");;
    private final By kartyaSzamFld = By.xpath("//app-text-input[@name='cardNumber']//input");
    private final By kartyaErvenyesFld = By.xpath("//app-datepicker-basic[@name='cardValidityDate']//input");
    private final By kartyaHasznalojaFld = By.xpath("//app-text-input[@name='cardUser']//input[@placeholder='Nincs megadva']");
    private final By kartyaolvasoTipusa = By.xpath("//app-text-input[@name='cardReaderType']//input[@placeholder='Nincs megadva']");
    private final By halozatiSzolgaltatoFld = By.xpath("//app-text-input[@name='networkServiceProvider']//input[@placeholder='Nincs megadva']");
    private final By cimletekFld = By.xpath("//app-text-input[@name='denomination']//input[@placeholder='Nincs megadva']");
    private final By festekszalagJournalTipusaFld = By.xpath("//app-text-input[@name='ribbonJournalType']//input[@placeholder='Nincs megadva']");
    private final By journalNyomtatoTipusaFld = By.xpath("//app-text-input[@name='journalPrinterType']//input[@placeholder='Nincs megadva']");
    private final By journalSzalagTipusaFld = By.xpath("//app-text-input[@name='journalTapeType']//input[@placeholder='Nincs megadva']");
    private final By ugyfelBonSzalagTipusaFld = By.xpath("//app-text-input[@name = 'customerTapeType']//input");
    private final By kulsoHelyszinChBox = By.xpath("(//div[@class='col-5'])[8]//label[contains(text(),'Külső helyszín')]");
    private final By irSzamFld = By.xpath("//app-text-input[@name='postCode']//input[@placeholder='Nincs megadva']");
    private final By varosFld = By.xpath("//app-text-input[@name='city']//input[@placeholder='Nincs megadva']");
    private final By kozteruletNeveFld = By.xpath("//app-text-input[@name='publicPlace']//input[@placeholder='Nincs megadva']");
    private final By kozteruletTipusaDropDown = By.xpath("//app-buildfolio-select[@name='publicPlaceTypeCode']//input");
    private final By hazszamFld = By.xpath("//app-text-input[@name='houseNumber']//input[@placeholder='Nincs megadva']");
    //-időpontok
    private final By gyartasIdopontjaFld = By.xpath("//app-datepicker-basic[@name='productionDate']//input");
    private final By beszerzesIdopontjaFld = By.xpath("//app-datepicker-basic[@name='purchaseDate']//input");
    private final By aktivalasIdopontjaFld = By.xpath("//app-datepicker-basic[@name='activationDate']//input");
    private final By felfuggesztesKezdeteFld = By.xpath("//app-datepicker-basic[@name='suspensionBegin']//input");
    private final By felfuggesztesVegeFld = By.xpath("//app-datepicker-basic[@name='suspensionEnd']//input");
    private final By lekapcsolasIdopontjaFld = By.xpath("//app-datepicker-basic[@name='turnoffDate']//input");
    private final By selejtezesIdopontjaBtn = By.xpath("//button[contains(text(),'+ Selejtezés időpontja')]");
    //Bankbiztonsági eszközök
    private final By hozzarendelesBtn = By.xpath("//a[.=' Hozzárendelés ']");
    private final By hozzarendelesKijelBtn = By.xpath("//button[contains(.,'Hozzárendelés')]");
    private final By eltavolitasBtn = By.xpath("//button[contains(.,'Eltávolítás ')]");
    private final By torlesBtn = By.xpath("//button[normalize-space()='Törlés']");
    //Külső helyszín megadása
    private final By igenBtn = By.xpath("//button[normalize-space()='Igen']");



    public EszkozokDetailsAtm(WebDriver driver) {
        super(driver);
    }

    //visibility
    public EszkozokDetailsAtm megjelenikGyartasIdopontjaFld(){
        waitUtil.waitForVisibility(gyartasIdopontjaFld);
        return this;
    }

    public EszkozokDetailsAtm megjelenikBeszerzesIdopontjaFld(){
        waitUtil.waitForVisibility(beszerzesIdopontjaFld);
        return this;
    }

    public EszkozokDetailsAtm megjelenikAktivalasIdopontjaFld(){
        waitUtil.waitForVisibility(aktivalasIdopontjaFld);
        return this;
    }

    public EszkozokDetailsAtm megjelenikFelfuggesztesKezdeteFld(){
        waitUtil.waitForVisibility(felfuggesztesKezdeteFld);
        return this;
    }

    public EszkozokDetailsAtm megjelenikFelfuggesztesVegeFld(){
        waitUtil.waitForVisibility(felfuggesztesVegeFld);
        return this;
    }

    public EszkozokDetailsAtm megkelenikLekapcsolasIdopontjaFld(){
        waitUtil.waitForVisibility(lekapcsolasIdopontjaFld);
        return this;
    }

    public EszkozokDetailsAtm megjelenikSelejtezesIdopontjaBtn(){
        waitUtil.waitForVisibility(selejtezesIdopontjaBtn);
        return this;
    }

    //clearFld
    public EszkozokDetailsAtm clearAktivalasIdopontjaFld(){
        waitUtil.waitAndClearText(aktivalasIdopontjaFld);
        return this;
    }

    public EszkozokDetailsAtm clearFelfuggesztesKezdeteFld(){
        waitUtil.waitAndClearText(felfuggesztesKezdeteFld);
        return this;
    }

    public EszkozokDetailsAtm clearFelfuggesztesVegeFld(){
        waitUtil.waitAndClearText(felfuggesztesVegeFld);
        return this;
    }

    //select
    public EszkozokDetailsAtm eszkozKivalasztasaChBox(String egyediAzon){
        waitUtil.waitAndClick(By.xpath("//td[normalize-space()='"+egyediAzon+"']/ancestor::tr//td//app-checkbox//div//label"));
        return this;
    }

    public EszkozokDetailsAtm hozzarendeltEszkozKivalasztasa(String egyediAzon){
        waitUtil.waitAndClick(By.xpath("//td[contains(text(),'"+egyediAzon+"')]/preceding-sibling::td//app-checkbox//div//label"));
        return this;
    }

    public EszkozokDetailsAtm selectKoztTipusaFromDropDown(String koztTipusa){
        waitUtil.waitAndClick(kozteruletTipusaDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+koztTipusa+"']"));
        return this;
    }

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

    public EszkozokDetailsAtm selectStatuszFromDropDown(String statusz){
        waitUtil.waitAndClick(statuszDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+statusz+"']"));
        return this;
    }

    //enter text
    public EszkozokDetailsAtm enterTextToIrSzamFld(String irSzam){
        waitUtil.waitAndSendkeys(irSzamFld, irSzam);
        return this;
    }

    public EszkozokDetailsAtm enterTextToVarosFld(String varos){
        waitUtil.waitAndSendkeys(varosFld, varos);
        return this;
    }

    public EszkozokDetailsAtm enterTextToKozteruletNeve(String koztNeve){
        waitUtil.waitAndSendkeys(kozteruletNeveFld, koztNeve);
        return this;
    }

    public EszkozokDetailsAtm enterTextToHazszamFld(String hazszam){
        waitUtil.waitAndSendkeys(hazszamFld, hazszam);
        return this;
    }

    public EszkozokDetailsAtm enterDatumToAktivalasIdopontjaFld(String aktivalasIdopontja){
        waitUtil.waitAndSendkeys(aktivalasIdopontjaFld, aktivalasIdopontja);
        return this;
    }

    public EszkozokDetailsAtm enterDatumToFelfuggesztesKezdeteFld(String felfuggesztesKezdete){
        waitUtil.waitAndSendkeys(felfuggesztesKezdeteFld, felfuggesztesKezdete);
        return this;
    }

    public EszkozokDetailsAtm enterDatumToFelfuggesztesVegeFld(String felfuggesztesVege){
        waitUtil.waitAndSendkeys(felfuggesztesVegeFld, felfuggesztesVege);
        return this;
    }

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
    //click
    public EszkozokDetailsAtm clickOnIgenBtn(){
        waitUtil.waitAndClick(igenBtn);
        return this;
    }

    public EszkozokDetailsAtm clickOnVisszaGomb(){
        waitUtil.waitAndClick(By.xpath("//a[@class='no-link back-btn ng-star-inserted']"));
        return this;
    }

    public EszkozokDetailsAtm clickOnTorlesBtn(){
        waitUtil.waitAndClick(torlesBtn);
        return this;
    }

    public EszkozokDetailsAtm clickOnEltavolitasBtn(){
        waitUtil.waitAndClick(eltavolitasBtn);
        return this;
    }

    public EszkozokDetailsAtm clickOnHozzarendelesKijelBtn(){
        waitUtil.waitAndClick(hozzarendelesKijelBtn);
        return this;
    }

    public EszkozokDetailsAtm clickOnHozzarendelesBtn(){
        waitUtil.waitAndClick(hozzarendelesBtn);
        return this;
    }

    public EszkozokDetailsAtm clickOnKulsoHelyszinChBox(){
        waitUtil.waitAndClick(kulsoHelyszinChBox);
        return this;
    }

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
                enterTextToFestekSzalagJournalTipusaFld(ujAtmAlapadatok.getFestekSzalagJournalTipusa()).
                enterTextToJournalNyomtatoTipusa(ujAtmAlapadatok.getJournalNyomtatoTipusa()).
                enterTextToJournalSzalagTipusa(ujAtmAlapadatok.getJournalSzalagTipusa()).
                enterTextUgyfelBonSzalagTipusa(ujAtmAlapadatok.getUgyfelBonSzalagTipusa());
    }

    //assert
    public boolean popUpUzenetMegjelenik(String popUpSzoveg){
        return waitUtil.popupWindMegjelenik(popUpSzoveg);
    }

    public boolean elemMegjelenikATablazatban(String elemNeve, String oszlopIndex){
        return waitUtil.elementIsDisplayedInTable(elemNeve, oszlopIndex);
    }

    public EszkozokDetailsAtm eszkozokDetailsAtmOldalonAllunk(){
        waitUtil.waitWebElement(By.xpath("//span[normalize-space()='ATM adatlap']"));
        return this;
    }

    //select
    public EszkozokDetailsAtm elemKivalasztasaTablazatbol(String egyediAzon, String oszlopIndex){
        waitUtil.selectElementFromTableOszlopKivalasztasaval(egyediAzon, oszlopIndex);
        return this;
    }

}
