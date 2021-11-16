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
        wait.until(ExpectedConditions.elementToBeClickable(adatokSzerkeszteseBtn)).click();
        return this;
    }

    public ParkolokDetailsAlapadatok clickOnMentesBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(mentesBtn)).click();
        return this;
    }

    public ParkolokDetailsAlapadatok clickOnMegsemBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(megsemBtn)).click();
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextToOrzeseBetelepitesiModFld(String orzeseBetelepitesiMod){
        wait.until(ExpectedConditions.visibilityOfElementLocated(orzeseBetelepitesiModFld)).sendKeys(orzeseBetelepitesiMod);
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextToNyitvaTartasFld(String nyitvaTartas){
        wait.until(ExpectedConditions.visibilityOfElementLocated(nyitvaTartasFld)).sendKeys(nyitvaTartas);
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextToParkoloMegnFld(String parkoloMegn){
        wait.until(ExpectedConditions.visibilityOfElementLocated(nevFld)).sendKeys(parkoloMegn);
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextToTipusDropDown(String tipus){
        wait.until(ExpectedConditions.visibilityOfElementLocated(tipusDropDown)).sendKeys(tipus);
        wait.until(ExpectedConditions.elementToBeClickable(By.ByXPath.xpath("//div[@title='"+tipus+"']"))).click();
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextToTeruletFld(String terulet){
        wait.until(ExpectedConditions.visibilityOfElementLocated(teruletFld)).sendKeys(terulet);
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextIrSzamFld(String irSzam){
        wait.until(ExpectedConditions.visibilityOfElementLocated(irSzamFld)).sendKeys(irSzam);
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextToVarosFld(String varos){
        wait.until(ExpectedConditions.visibilityOfElementLocated(varosFld)).sendKeys(varos);
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextKozteruletNeveFld(String kozteruletNeve){
        wait.until(ExpectedConditions.visibilityOfElementLocated(kozteruletNeveFld)).sendKeys(kozteruletNeve);
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextToKoztTipDropDown(String koztTip){
        wait.until(ExpectedConditions.visibilityOfElementLocated(tipusDropDown)).sendKeys(koztTip);
        wait.until(ExpectedConditions.elementToBeClickable(By.ByXPath.xpath("//div[@title='"+koztTip+"']"))).click();
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextHazszamFld(String hazszam){
        wait.until(ExpectedConditions.visibilityOfElementLocated(hazszamFld)).sendKeys(hazszam);
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextAzonositoFld(String azonosito){
        wait.until(ExpectedConditions.visibilityOfElementLocated(azonositoFld)).sendKeys(azonosito);
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextHrszFld(String hrsz){
        wait.until(ExpectedConditions.visibilityOfElementLocated(hrszFld)).sendKeys(hrsz);
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextNevFld(String nev){
        wait.until(ExpectedConditions.visibilityOfElementLocated(nevFld)).sendKeys(nev);
        return this;
    }

    public ParkolokDetailsAlapadatok enterEmailFld(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFld)).sendKeys(email);
        return this;
    }

    public ParkolokDetailsAlapadatok enterTelefonszamFld(String telefonszam){
        wait.until(ExpectedConditions.visibilityOfElementLocated(telefonszamFld)).sendKeys(telefonszam);
        return this;
    }

    public ParkolokDetailsAlapadatok enterTextMobilszamFld(String mobilszam){
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobilFld)).sendKeys(mobilszam);
        return this;
    }


    public ParkolokDetailsAlapadatok enterTextSzolgaltatasMegnFld(String szolgaltatasMegn){
        wait.until(ExpectedConditions.visibilityOfElementLocated(nevFld)).sendKeys(szolgaltatasMegn);
        return this;
    }

    //ellenőrző metódusok
    public ParkolokDetailsAlapadatok parkolokDetailsOldalonVagyunk(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(parkoloAdatlapFelirat));
        return this;
    }

    public boolean orzeseBetelepitesiModFldUres(){
        WebElement inputBox = wait.until(ExpectedConditions.visibilityOfElementLocated(orzeseBetelepitesiModFld));
        String textInsideInputBox = inputBox.getAttribute("value");
        return textInsideInputBox.isEmpty();
    }

    public String javascriptErrorMessageTextMentes() {
        Alert alert = driver.switchTo().alert();
        String messageText = alert.getText();
        return messageText;
    }

    public boolean mezokNemszerkeszthetoek() {
        Boolean eredmeny = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Nincs megadva')]"))).isEnabled();
        return eredmeny;
    }

    public Boolean mentesBtnKattinthato(){
        Boolean eredmeny = wait.until(ExpectedConditions.elementToBeClickable(mentesBtn)).isEnabled();
        return eredmeny;
    }

    public Boolean megsemBtnKattinthato(){
        Boolean eredmeny = wait.until(ExpectedConditions.elementToBeClickable(megsemBtn)).isEnabled();
        return eredmeny;
    }


    public Boolean parkolohelyekPanelMegjelenik(){
        Boolean ertek = false;
        try{
            WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card padded ng-star-inserted']")));
            if(e.isDisplayed()){
                ertek = true;
            }
        }catch (Exception e){
            ertek = false;
        }
        return ertek;
    }


    public Boolean popUpMegjelenik(){
        Boolean eredmeny = wait.until(ExpectedConditions.visibilityOfElementLocated(popUpToltseKiAKotMezoket)).isDisplayed();
        return eredmeny;
    }

    public String popUpSzoveg(){
        String alertText = wait.until(ExpectedConditions.visibilityOfElementLocated(popUpToltseKiAKotMezoket)).getText();
        return alertText;
    }

    //clear textfld
    public ParkolokDetailsAlapadatok parkoloMegnevFldClear(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(parkoloMegnevezeseFld)).clear();
        return this;
    }

    public ParkolokDetailsAlapadatok tipusDropDownFldClear(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(tipusDropDown)).clear();
        return this;
    }

    public ParkolokDetailsAlapadatok teruletFldClear(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(teruletFld)).clear();
        return this;
    }

    public ParkolokDetailsAlapadatok irSzamFldClear(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(irSzamFld)).clear();
        return this;
    }

    public ParkolokDetailsAlapadatok varosFldClear(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(varosFld)).clear();
        return this;
    }

    public ParkolokDetailsAlapadatok kozteruletNeveFldClear(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(kozteruletNeveFld)).clear();
        return this;
    }

    public ParkolokDetailsAlapadatok kozteruletTipusaDropDown(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(kozteruletTipusaDropDown)).clear();
        return this;
    }

    public ParkolokDetailsAlapadatok hazszamFldClear(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(hazszamFld)).clear();
        return this;
    }

    public ParkolokDetailsAlapadatok azonositoFldClear(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(azonositoFld)).clear();
        return this;
    }

    public ParkolokDetailsAlapadatok hrszFldClear(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(hrszFld)).clear();
        return this;
    }

    public ParkolokDetailsAlapadatok nevFldClear(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(nevFld)).clear();
        return this;
    }

    public ParkolokDetailsAlapadatok emailFldClear(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFld)).clear();
        return this;
    }

    public ParkolokDetailsAlapadatok telefonszamFldClear(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(telefonszamFld)).clear();
        return this;
    }

    public ParkolokDetailsAlapadatok mobilFldClear(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobilFld)).clear();
        return this;
    }

    public ParkolokDetailsAlapadatok szolgaltatasMegnFldClear(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(szolgaltatasMegnFld)).clear();
        return this;
    }






}
