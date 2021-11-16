package hu.fonixit.buildfolio.autotest.pages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import hu.fonixit.buildfolio.autotest.objects.UjFelhasznalo;
//import hu.fonixit.buildfolio.autotest.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class UsersPage extends BasePage {
    private final By ujFelhasznaloFelveteleBtn = By.xpath("//button[normalize-space()='Új felhasználó felvétele']");
    //Új felhasználó felvétele ablak
    private final By felhasznaloNevFld = By.cssSelector("app-text-input[name='accountName'] input[placeholder='Nincs megadva']");
    private final By nevFld = By.xpath("//app-text-input[@name='fullName']//input[@placeholder='Nincs megadva']");
    private final By emailFld = By.cssSelector("app-text-input[name='email'] input[placeholder='Nincs megadva']");
    private final By szervezetDropDown = By.xpath("(//input[@role='combobox'])[3]");
    private final By szerepkorDropDown = By.xpath("(//input[@role='combobox'])[4]");
    private final By megsemBtn = By.xpath("//button[normalize-space()='Mégsem']");
    private final By felvetelBtn = By.xpath("//button[normalize-space()='Felvétel']");
    private final By pluszSzerepkorDropDownBtn = By.cssSelector(".btn.simple-button.add");
    private final By pluszszerepkorDropDown = By.cssSelector("div[class='select-wrapper ng-untouched ng-pristine ng-invalid'] input[role='combobox']");
    //találati lista
    private final By muveletekBtn = By.xpath("//tbody/app-user-list-view/tr[1]/td[5]/app-dropdown[1]/div[1]/button[1]");
    private final By szerkesztesBtnInMuveletekDropDown = By.xpath("(//button[contains(text(),'Szerkesztés')])");
    private final By jelszoModositasaBtnInuveletekDropDown = By.xpath("(//button[normalize-space()='Jelszó módosítása'])[1]");
    private final By inaktivalasBtnInMuveletekDropDown = By.xpath("(//button[normalize-space()='Inaktiválás'])[1]");
    //felhasználó módosítása ablak
    private final By nevFldModosit = By.xpath("(//input[@placeholder='Nincs megadva'])[1]");
    private final By emailFldModosit = By.xpath("pl-0 pr-0 text-align-left ng-pristine ng-star-inserted ng-valid ng-touched");
    private final By mentesBtn = By.cssSelector("button[class='btn btn-primary btn-submit']");
    private final By megsemBtnModositas = By.xpath("(//button[normalize-space()='Mégsem'])[1]");
    private final By plusSzerepkorBtn = By.xpath("(//button[normalize-space()='+ Szerepkör'])[1]");
    //jelszó módosítása ablak
    private final By ujJelszoFld = By.xpath("//input[@placeholder='Új jelszó']");
    private final By jelszoMegerositesFld = By.xpath("//input[@placeholder='Jelszó megerősítés']");
    private final By mentesBtnJelszoModositas = By.xpath("//button[normalize-space()='Mentés']");
    private final By megsemBtnJelszoModositas = By.xpath("//button[normalize-space()='Mégsem']");
    private final By jelszoGeneralasCheckbox = By.id("generateNewPassword");
    //inaktivalas megerősítő ablak
    private final By okMegerBtn = By.xpath("//button[normalize-space()='Igen']");
    private final By megseMegerBtn = By.xpath("//button[normalize-space()='Mégsem']");


    public UsersPage(WebDriver driver){
        super(driver);
    }

    //user inaktiválás
    public UsersPage clickOnInaktivalasBtnInMuveletekDropDown(){
        wait.until(ExpectedConditions.elementToBeClickable(inaktivalasBtnInMuveletekDropDown)).click();
        return this;
    }

    public UsersPage felhasznaloInaktivalasa(){
        clickOnInaktivalasBtnInMuveletekDropDown();
        wait.until(ExpectedConditions.visibilityOfElementLocated(okMegerBtn)).click();
        return this;
    }

    public UsersPage clickOnMegseMegerBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(megsemBtn)).click();
        return this;
    }

    public UsersPage inaktivUser(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tr[@class='default-cursor not-filled ng-star-inserted'])[1]")));
        return this;
    }

    //jelszó módosítás

    public UsersPage clickOnmentesBtnJelszoModositas(){
        //waitUtil.waitAndClick(mentesBtnJelszoModositas);
        wait.until(ExpectedConditions.elementToBeClickable(mentesBtnJelszoModositas)).click();
        return this;
    }

    public UsersPage enterUjJelszoFld(String jelszo){
        //waitUtil.waitAndSendkeys(ujJelszoFld, jelszo);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ujJelszoFld)).sendKeys(jelszo);
        return this;
    }

    public UsersPage enterJelszoMegerositesFld(String jelszoMeger){
        //waitUtil.waitAndSendkeys(jelszoMegerositesFld, jelszoMeger);
        wait.until(ExpectedConditions.visibilityOfElementLocated(jelszoMegerositesFld)).sendKeys(jelszoMeger);
        return this;
    }

    public UsersPage clickOnJelszoModositasaBtnMuveletekDropDown(){
        //waitUtil.waitAndClick(jelszoModositasaBtnInuveletekDropDown);
        wait.until(ExpectedConditions.visibilityOfElementLocated(jelszoModositasaBtnInuveletekDropDown)).click();
        return this;
    }

    public boolean mentesBtnJelszoModositasKattinthato(){  //
       return wait.until(ExpectedConditions.visibilityOfElementLocated(mentesBtnJelszoModositas)).isEnabled();
    }

    public UsersPage clickOnjelszoGeneralasCheckbox(){
        wait.until(ExpectedConditions.elementToBeClickable(jelszoGeneralasCheckbox)).click();
        return this;
    }

    public boolean ujJelszoFldSzerkesztheto(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ujJelszoFld)).isEnabled();
    }

    public boolean jelszoMegerositesFldSzerkesztheto(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(jelszoMegerositesFld)).isEnabled();
    }

    public boolean megsemBtnJelszoModositasKattinthato(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(megsemBtnJelszoModositas)).isEnabled();
    }

    public UsersPage clickOnMegsemBtnJelszoModositas(){
        wait.until(ExpectedConditions.elementToBeClickable(megsemBtnJelszoModositas)).click();
        return this;
    }

    //felhasználó módosítás ablak
    public UsersPage enterPlusSzerepkorModositAblakon(String role){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[normalize-space()='+ Szerepkör'])[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='row ng-star-inserted ng-touched ng-dirty ng-invalid']//input[1]"))).click();
        WebElement e = wait.until((ExpectedConditions.elementToBeClickable(By.cssSelector("div[title='"+role+"']"))));
        e.click();
        return this;
    }

    public UsersPage clickOnMentesBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(mentesBtn)).click();
        return this;
    }

    public UsersPage nevFldClearAndenterModositottNevToNevFld(String nev) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Teszt Név'])[1]"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Teszt Név']"))).sendKeys(nev);
        return this;
    }

    public UsersPage emailFldClearAndEnterModositottEmailToEmailFld(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@placeholder='email@gmail.com'])[1]"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@placeholder='email@gmail.com'])[1]"))).sendKeys(email);
        return this;
    }

    public UsersPage szervezetDropDownClearAndEnterModositottSzervezetToSzervezetFld(String szervezet){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@title='Clear all'])[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@role='combobox'])[3]"))).click();
        WebElement e = wait.until((ExpectedConditions.elementToBeClickable(By.cssSelector("div[title='"+szervezet+"']"))));
        e.click();
        return this;
    }

    public UsersPage szerepkorDropDownClearAndEnterModositottSzerepkorToSzerepkorFld(String szerepkor){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@title='Clear all'])[2]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@role='combobox'])[4]"))).click();
        WebElement e = wait.until((ExpectedConditions.elementToBeClickable(By.cssSelector("div[title='"+szerepkor+"']"))));
        e.click();
        return this;
    }

    public UsersPage addUjSzerepkorToFelhasznaloModositasAblak(String szerepkor){
        wait.until(ExpectedConditions.visibilityOfElementLocated(plusSzerepkorBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@role='combobox'])[7]"))).click();
        WebElement e = wait.until((ExpectedConditions.elementToBeClickable(By.cssSelector("div[title='"+szerepkor+"']"))));
        e.click();
        return this;
    }

    public UsersPage clickOnszerkesztesBtnInMuveletekDropDown(){
        wait.until(ExpectedConditions.elementToBeClickable(szerkesztesBtnInMuveletekDropDown)).click();
        return this;
    }



    public UsersPage clickOninaktivalasBtnInMuveletekDropDown(){
        wait.until(ExpectedConditions.elementToBeClickable(inaktivalasBtnInMuveletekDropDown)).click();
        return this;
    }

    //találati lista
    public UsersPage clickOnMuveletekButton(){
        wait.until(ExpectedConditions.elementToBeClickable(muveletekBtn)).click();
        return this;
    }

    public UsersPage clickOnUjFelhasznaloFelveteleBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(ujFelhasznaloFelveteleBtn)).click();
        return this;
    }

    public UsersPage megjelenoNevAListaban(String nev){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[contains(text(),'"+nev+"')])")));
        return this;
    }

    public UsersPage megjelenoEmailAListaban(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[contains(text(),'"+email+"')])")));
        return this;
    }

    public UsersPage megjelenoSzervezetAListaban(String szervezet){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[contains(text(),'"+szervezet+"')])")));
        return this;
    }

    public UsersPage megjelenoSzerepkorAListaban(String szerepkor){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='cell-row ng-star-inserted'][contains(text(),'"+szerepkor+"')])")));
        return this;
    }

    //új felhasználó felvétele
    public UsersPage enterFelhasznalonev(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(felhasznaloNevFld)).sendKeys(username);
        return this;
    }

    public UsersPage enterNev(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(nevFld)).sendKeys(name);
        return this;
    }

    public UsersPage enterEmail(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFld)).sendKeys(email);
        return this;
    }

    public UsersPage selectSzervezet(String organisation){
        wait.until(ExpectedConditions.visibilityOfElementLocated(szervezetDropDown)).click();
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='"+organisation+"']")));
        e.click();
        return this;
    }

    public UsersPage selectSzerepkor(String role){
        wait.until(ExpectedConditions.visibilityOfElementLocated(szerepkorDropDown)).click();
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='"+role+"']")));
        e.click();
        return this;
    }

    public UsersPage selectPlusSzerepkor(String role){
        wait.until(ExpectedConditions.visibilityOfElementLocated(pluszSzerepkorDropDownBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pluszszerepkorDropDown)).click();
        WebElement e = wait.until((ExpectedConditions.elementToBeClickable(By.cssSelector("div[title='"+role+"']"))));
        e.click();
        return this;
    }


    public UsersPage clickOnFelvetelBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(felvetelBtn)).click();
        return this;
    }

    public UsersPage clickOnMegseBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(megsemBtn)).click();
        return this;
    }

    public UsersPage felvetelBtnDisabled(){
        WebElement felvetelBtn = driver.findElement(By.xpath("//button[normalize-space()='Felvétel']"));
        Assert.assertEquals("true", felvetelBtn.getAttribute("disabled"));
        return this;
    }

    public UsersPage setUjFelhasznalo(UjFelhasznalo ujFelhasznalo){
        return enterNev(ujFelhasznalo.getName()).
                enterEmail(ujFelhasznalo.getEmail()).
                selectSzervezet(ujFelhasznalo.getOrganisation()).
                selectSzerepkor(ujFelhasznalo.getRole());
    }


}
