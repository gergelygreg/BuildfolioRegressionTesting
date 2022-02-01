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
    private final By muveletekBtn = By.xpath("(//button[@type='button'])[3]");
    //felhasználó módosítása ablak
    private final By nevFldModosit = By.xpath("(//input[@placeholder='Nincs megadva'])[1]");
    private final By emailFldModosit = By.xpath("pl-0 pr-0 text-align-left ng-pristine ng-star-inserted ng-valid ng-touched");
    private final By mentesBtn = By.cssSelector("button[class='btn btn-primary btn-submit']");
    private final By megsemBtnModositas = By.xpath("(//button[normalize-space()='Mégsem'])[1]");
    private final By plusSzerepkorBtn = By.xpath("//button[@id='user-add-new-role-button']");
    //jelszó módosítása ablak
    private final By ujJelszoFld = By.xpath("//input[@placeholder='Új jelszó']");
    private final By jelszoMegerositesFld = By.xpath("//input[@placeholder='Jelszó megerősítés']");
    private final By mentesBtnJelszoModositas = By.xpath("//button[normalize-space()='Mentés']");
    private final By megsemBtnJelszoModositas = By.xpath("//button[normalize-space()='Mégsem']");
    private final By jelszoGeneralasCheckbox = By.xpath("//label[normalize-space()='Jelszó generálás']");
    //inaktivalas megerősítő ablak
    private final By okMegerBtn = By.xpath("//button[normalize-space()='Igen']");
    private final By megseMegerBtn = By.xpath("//button[normalize-space()='Mégsem']");


    public UsersPage(WebDriver driver){
        super(driver);
    }

    //user inaktiválás
    public UsersPage clickOnInaktivalasBtnInMuveletekDropDown(String egyediAzon){
        waitUtil.waitAndClick(By.xpath("//tr//td[.='"+egyediAzon+"']/following-sibling::td//button[.='Inaktiválás']"));
        return this;
    }

    public UsersPage clickOnszerkesztesBtnInMuveletekDropDown(String egyediAzon){
        waitUtil.waitAndClick(By.xpath("//tr//td[.='"+egyediAzon+"']/following-sibling::td//button[.='Szerkesztés']"));
        return this;
    }

    public UsersPage clickOnJelszoModositasaBtnMuveletekDropDown(String egyediAzon){
        waitUtil.waitAndClick(By.xpath("//tr//td[.='"+egyediAzon+"']/following-sibling::td//button[.='Jelszó módosítása']"));
        return this;
    }



    public UsersPage clickOnMuveletekBtn(){
        waitUtil.waitAndClick(muveletekBtn);
        return this;
    }

    public UsersPage clickOnOkMegerBtn(){
        waitUtil.waitAndClick(okMegerBtn);
        return this;
    }

    public UsersPage clickOnMegseMegerBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }


    //jelszó módosítás

    public UsersPage clickOnmentesBtnJelszoModositas(){
        waitUtil.waitAndClick(mentesBtnJelszoModositas);
        return this;
    }

    public UsersPage enterUjJelszoFld(String jelszo){
        waitUtil.waitAndSendkeys(ujJelszoFld, jelszo);
        return this;
    }

    public UsersPage enterJelszoMegerositesFld(String jelszoMeger){
        waitUtil.waitAndSendkeys(jelszoMegerositesFld, jelszoMeger);
        return this;
    }


    public boolean mentesBtnJelszoModositasKattinthato(){  //
       return waitUtil.elementIsClickable(mentesBtnJelszoModositas);
    }

    public UsersPage clickOnjelszoGeneralasCheckbox(){
        waitUtil.waitAndClick(jelszoGeneralasCheckbox);
        return this;
    }

    public boolean ujJelszoFldSzerkesztheto(){
        return waitUtil.mezoSzerkesztheto(ujJelszoFld);
    }

    public boolean jelszoMegerositesFldSzerkesztheto(){
        return waitUtil.mezoSzerkesztheto(jelszoMegerositesFld);
    }

    public boolean megsemBtnJelszoModositasKattinthato(){
        return waitUtil.mezoSzerkesztheto(megsemBtnJelszoModositas);
    }

    public UsersPage clickOnMegsemBtnJelszoModositas(){
        waitUtil.waitAndClick(megsemBtnJelszoModositas);
        return this;
    }

    //felhasználó módosítás ablak
    public UsersPage enterPlusSzerepkorModositAblakon(String role){
        waitUtil.waitAndClick(By.xpath("//button[normalize-space()='+ Szerepkör']"));
        waitUtil.waitAndClick(By.xpath("(//input[@role='combobox'])[last()]"));
        WebElement e = waitUtil.waitWebElement(By.cssSelector("div[title='"+role+"']"));
        e.click();
        return this;
    }

    public UsersPage clickOnMentesBtn(){
        waitUtil.waitAndClick(mentesBtn);
        return this;
    }

    public UsersPage nevFldClearAndEnterModositottNevToNevFld(String nev, String nevModositott) {
        waitUtil.waitAndClearText(By.xpath("//input[@placeholder='"+nev+"']"));
        waitUtil.waitAndSendkeys(By.xpath("//input[@placeholder='Nincs megadva']"), nevModositott);
        return this;
    }

    public UsersPage emailFldClearAndEnterModositottEmailToEmailFld(String email, String emailModositott){
        waitUtil.waitAndClearText(By.xpath("//input[@placeholder='"+email+"']"));
        waitUtil.waitAndSendkeys(By.xpath("//input[@placeholder='Nincs megadva']"), emailModositott);
        return this;
    }

    public UsersPage szervezetDropDownClearAndEnterModositottSzervezetToSzervezetFld(String szervezetModositott){
        waitUtil.waitAndClick(By.xpath("//app-buildfolio-select[@id='user-legal-entities-select']//input"));
        waitUtil.waitAndClick(By.xpath("//div[@title='"+szervezetModositott+"']"));
        return this;
    }

    public UsersPage szerepkorDropDownClearAndEnterModositottSzerepkorToSzerepkorFld(String szerepkorModositott){
        waitUtil.waitAndClick(By.xpath("//app-buildfolio-select[@id='user-role-select_0']//input"));
        waitUtil.waitAndClick(By.xpath("//div[@title='"+szerepkorModositott+"']"));
        return this;
    }

    public UsersPage addUjSzerepkorToFelhasznaloModositasAblak(String ujSzerepkor){
        waitUtil.waitAndClick(plusSzerepkorBtn);
        waitUtil.waitAndClick(By.xpath("//app-buildfolio-select[@id='user-role-select_1']//input"));
        waitUtil.waitAndClick(By.xpath("//div[@title='"+ujSzerepkor+"']"));
        return this;
    }


    //találati lista
    public UsersPage clickOnUjFelhasznaloFelveteleBtn(){
        waitUtil.waitAndClick(ujFelhasznaloFelveteleBtn);
        return this;
    }

    public UsersPage megjelenoNevAListaban(String nev){
        waitUtil.waitForVisibility(By.xpath("(//td[contains(text(),'"+nev+"')])"));
        return this;
    }

    public UsersPage megjelenoEmailAListaban(String email){
       waitUtil.waitForVisibility(By.xpath("(//td[contains(text(),'"+email+"')])"));
        return this;
    }

    public UsersPage megjelenoSzervezetAListaban(String szervezet){
        waitUtil.waitForVisibility(By.xpath("(//td[contains(text(),'"+szervezet+"')])"));
        return this;
    }

    public UsersPage megjelenoSzerepkorAListaban(String szerepkor){
        waitUtil.waitForVisibility(By.xpath("//tr[position()=1][contains(.,'"+szerepkor+"')]"));
        return this;
    }

    //új felhasználó felvétele
    public UsersPage enterFelhasznalonev(String username){
        waitUtil.waitAndSendkeys(felhasznaloNevFld, username);
        return this;
    }

    public UsersPage enterNev(String name){
        waitUtil.waitAndSendkeys(nevFld, name);
        return this;
    }

    public UsersPage enterEmail(String email){
        waitUtil.waitAndSendkeys(emailFld, email);
        return this;
    }

    public UsersPage selectSzervezet(String organisation){
        waitUtil.waitAndClick(szervezetDropDown);
        WebElement e = waitUtil.waitWebElement(By.xpath("//div[@title='" + organisation + "']"));
        e.click();
        return this;
    }

    public UsersPage selectSzerepkor(String role){
        waitUtil.waitAndClick(szerepkorDropDown);
        WebElement e = waitUtil.waitWebElement(By.xpath("//div[@title='" + role + "']"));
        e.click();
        return this;
    }

    public UsersPage selectPlusSzerepkor(String role){
        waitUtil.waitAndClick(pluszSzerepkorDropDownBtn);
        waitUtil.waitAndClick(pluszszerepkorDropDown);
        WebElement e = waitUtil.waitWebElement(By.cssSelector("div[title='" + role + "']"));
        e.click();
        return this;
    }


    public UsersPage clickOnFelvetelBtn(){
        waitUtil.waitAndClick(felvetelBtn);
        return this;
    }

    public UsersPage clickOnMegseBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    public UsersPage felvetelBtnDisabled(){
        WebElement felvetelBtn = driver.findElement(By.xpath("//button[normalize-space()='Felvétel']"));
        Assert.assertEquals("true", felvetelBtn.getAttribute("disabled"));
        return this;
    }

    public UsersPage setUjFelhasznalo(UjFelhasznalo ujFelhasznalo){
        return enterEmail(ujFelhasznalo.getEmail()).
                selectSzerepkor(ujFelhasznalo.getRole());
    }

    //assertion
    public boolean elemMegjelenikATablazatban(String egyediAzonosito, String oszlopIndex){
        return waitUtil.elementIsDisplayedInTable(egyediAzonosito, oszlopIndex);
    }

    public boolean popUpMegjelenik(String popUpSzovege){
        return waitUtil.popupWindMegjelenik(popUpSzovege);
    }

    public boolean addMegegyezoSzerepkorToFelhasznaloModositasAblak(String ujSzerepkor){
        waitUtil.waitAndClick(plusSzerepkorBtn);
        waitUtil.waitAndClick(By.xpath("//app-buildfolio-select[@id='user-role-select_1']//input"));
        WebElement e = driver.findElement(By.xpath("//div[@title='" + ujSzerepkor + "']"));
        return e.isSelected();
    }


}
