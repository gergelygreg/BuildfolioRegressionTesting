package hu.fonixit.buildfolio.autotest.pages.detailsPages.ParkolokDetailsPages;

import com.github.javafaker.Bool;
import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ParkolokDetailsAlapadatok extends BasePage {
    //FINDING INPUT FIELDS WITH LABEL. //input[@placeholder='Nincs megadva']/preceding-sibling::label[contains(.,'Őrzési/beléptetési mód')]
    //gomok
    private final By adatokSzerkeszteseBtn = By.xpath("//button[contains(.,'Adatok szerkesztése')]");
    private final By mentesBtn = By.xpath("//button[contains(.,'Mentés')]");
    private final By megsemBtn = By.xpath("//button[contains(.,'Mégsem')]");
    private final By orzeseBetelepitesiModFld = By.xpath("(//input[@placeholder='Nincs megadva'])[1]");
    private final By nyitvaTartasFld = By.xpath("//app-text-input[@name='openingHours']//input[@placeholder='Nincs megadva']");
    private final By popUpToltseKiAKotMezoket = By.xpath("//div[@role='alertdialog']");
    private final By parkoloMegnevezeseFld = By.xpath("//input[@formcontrolname='parkingLotName']");
    private final By tipusDropDown = By.xpath("(//input[@role='combobox'])[1]");
    private final By teruletFld = By.xpath("//app-text-input[@name='area']//input");
    private final By irSzamFld = By.xpath("//app-text-input[@name='postCode']//input");
    private final By varosFld = By.xpath("//app-text-input[@name='postCode']//input");
    private final By kozteruletNeveFld = By.xpath("//app-text-input[@name='publicPlace']//input");
    private final By kozteruletTipusaDropDown = By.xpath("(//input[@role='combobox'])[2]");
    private final By hazszamFld = By.xpath("//app-text-input[@name='houseNumber']//input");
    private final By azonositoFld = By.xpath("//app-text-input[@name='identifier']//input");
    private final By hrszFld = By.xpath("//app-text-input[@name='topographicalNumber']//input");
    private final By nevFld = By.xpath("//app-text-input[@name='contactName']//input");
    private final By emailFld = By.xpath("//app-text-input[@name='contactEmail']//input");
    private final By telefonszamFld = By.xpath("//app-text-input[@name='contactPhoneNumber']//input");
    private final By mobilFld = By.xpath("//app-text-input[@name='contactMobilePhoneNumber']//input");
    private final By szolgaltatasMegnFld = By.xpath("//app-text-input[@name='serviceName']//input");
    //
    private final By parkoloAdatlapFelirat = By.xpath("//span[normalize-space()='Parkoló adatlap']");


    public ParkolokDetailsAlapadatok(WebDriver driver){
        super(driver);
    }

    //metódusok: click, enterText
    public ParkolokDetailsAlapadatok clickOnAdatokSzerkeszteseBtn(){
        waitUtil.waitAndClick(adatokSzerkeszteseBtn);
        return this;
    }

    public ParkolokDetailsAlapadatok clickOnMentesBtn(){
        waitUtil.waitAndClick(mentesBtn);
        return this;
    }

    public ParkolokDetailsAlapadatok clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextToOrzeseBetelepitesiModFld(String orzeseBetelepitesiMod){
        waitUtil.waitAndSendkeys(orzeseBetelepitesiModFld, orzeseBetelepitesiMod);
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextToNyitvaTartasFld(String nyitvaTartas){
        waitUtil.waitAndSendkeys(nyitvaTartasFld, nyitvaTartas);
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextToParkoloMegnFld(String parkoloMegn){
        waitUtil.waitAndSendkeys(parkoloMegnevezeseFld, parkoloMegn);
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextToTipusDropDown(String tipus){
        waitUtil.waitAndSendkeys(tipusDropDown, tipus);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+tipus+"']"));
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextToTeruletFld(String terulet){
        waitUtil.waitAndSendkeys(teruletFld, terulet);
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextIrSzamFld(String irSzam){
        waitUtil.waitAndSendkeys(irSzamFld, irSzam);
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextToVarosFld(String varos){
        waitUtil.waitAndSendkeys(varosFld, varos);
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextKozteruletNeveFld(String kozteruletNeve){
        waitUtil.waitAndSendkeys(kozteruletNeveFld, kozteruletNeve);
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextToKoztTipDropDown(String koztTip){
        waitUtil.waitAndSendkeys(tipusDropDown, koztTip);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+koztTip+"']"));
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextHazszamFld(String hazszam){
        waitUtil.waitAndSendkeys(hazszamFld, hazszam);
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextAzonositoFld(String azonosito){
        waitUtil.waitAndSendkeys(azonositoFld, azonosito);
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextHrszFld(String hrsz){
        waitUtil.waitAndSendkeys(hrszFld, hrsz);
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextNevFld(String nev){
        waitUtil.waitAndSendkeys(nevFld, nev);
        return this;
    }

    public ParkolokDetailsAlapadatok enterEmailFld(String email){
        waitUtil.waitAndSendkeys(emailFld, email);
        return this;
    }

    public ParkolokDetailsAlapadatok enterTelefonszamFld(String telefonszam){
        waitUtil.waitAndSendkeys(telefonszamFld, telefonszam);
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextMobilszamFld(String mobilszam){
        waitUtil.waitAndSendkeys(mobilFld, mobilszam);
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextSzolgaltatasMegnFld(String szolgaltatasMegn){
        waitUtil.waitAndSendkeys(szolgaltatasMegnFld, szolgaltatasMegn);
        return this;
    }

    //ellenőrző metódusok
    public boolean parkolokDetailsOldalonVagyunk(){
       return waitUtil.elementIsDisplayed(parkoloAdatlapFelirat);
    }

    public boolean orzeseBetelepitesiModFldUres(){
        WebElement inputBox = waitUtil.waitWebElement(orzeseBetelepitesiModFld);
        String textInsideInputBox = inputBox.getAttribute("value");
        return textInsideInputBox.isEmpty();
    }

    public boolean mezokNemszerkeszthetoek() {
        return waitUtil.elementIsDisplayed(By.xpath("//span[contains(.,'Nincs megadva')]"));
    }

    public boolean mentesBtnKattinthato(){
        return waitUtil.elementIsDisplayed(mentesBtn);
    }

    public boolean megsemBtnKattinthato(){
        return waitUtil.elementIsDisplayed(megsemBtn);
    }


    public boolean parkolohelyekPanelMegjelenik(){
        return waitUtil.elementIsDisplayed(By.xpath("//div[@class='card padded ng-star-inserted']"));
    }


    public boolean popUpMegjelenik(){
        return waitUtil.elementIsDisplayed(popUpToltseKiAKotMezoket);
    }

    public String popUpSzoveg(){
        String alertText = waitUtil.waitAndGetText(popUpToltseKiAKotMezoket);
        return alertText;
    }

    public String parkolohelyekSzamaHeaderben(){
        return waitUtil.waitAndGetText(By.cssSelector("div[class='col'] h3"));
    }

    public String normalParkolohelySzama(){
        return waitUtil.waitAndGetText(By.xpath("(//div[@class='col'])[7]//span"));
    }

    public String rokkantParkolohelySzama(){
        return waitUtil.waitAndGetText(By.xpath("(//div[@class='col'])[8]//span"));
    }

    public String csaladosParkolohelySzama(){
        return waitUtil.waitAndGetText(By.xpath("(//div[@class='col'])[9]//span"));
    }

    public String elektrAutoParkolohelySzama(){
        return waitUtil.waitAndGetText(By.xpath("(//div[@class='col'])[10]//span"));
    }


    //clear textfld
    public ParkolokDetailsAlapadatok parkoloMegnevFldClear(){
        waitUtil.waitAndClearText(parkoloMegnevezeseFld);
        return this;
    }

    public ParkolokDetailsAlapadatok tipusDropDownFldClear(){
        waitUtil.waitAndClearText(tipusDropDown);
        return this;
    }

    public ParkolokDetailsAlapadatok teruletFldClear(){
        waitUtil.waitAndClearText(teruletFld);
        return this;
    }

    public ParkolokDetailsAlapadatok irSzamFldClear(){
        waitUtil.waitAndClearText(irSzamFld);
        return this;
    }

    public ParkolokDetailsAlapadatok varosFldClear(){
        waitUtil.waitAndClearText(varosFld);
        return this;
    }

    public ParkolokDetailsAlapadatok kozteruletNeveFldClear(){
        waitUtil.waitAndClearText(kozteruletNeveFld);
        return this;
    }

    public ParkolokDetailsAlapadatok kozteruletTipusaDropDown(){
        waitUtil.waitAndClearText(kozteruletTipusaDropDown);
        return this;
    }

    public ParkolokDetailsAlapadatok hazszamFldClear(){
        waitUtil.waitAndClearText(hazszamFld);
        return this;
    }

    public ParkolokDetailsAlapadatok azonositoFldClear(){
        waitUtil.waitAndClearText(azonositoFld);
        return this;
    }

    public ParkolokDetailsAlapadatok hrszFldClear(){
        waitUtil.waitAndClearText(hrszFld);
        return this;
    }

    public ParkolokDetailsAlapadatok nevFldClear(){
        waitUtil.waitAndClearText(nevFld);
        return this;
    }

    public ParkolokDetailsAlapadatok emailFldClear(){
        waitUtil.waitAndClearText(emailFld);
        return this;
    }

    public ParkolokDetailsAlapadatok telefonszamFldClear(){
        waitUtil.waitAndClearText(telefonszamFld);
        return this;
    }

    public ParkolokDetailsAlapadatok mobilFldClear(){
        waitUtil.waitAndClearText(mobilFld);
        return this;
    }

    public ParkolokDetailsAlapadatok szolgaltatasMegnFldClear(){
        waitUtil.waitAndClearText(szolgaltatasMegnFld);
        return this;
    }

}
