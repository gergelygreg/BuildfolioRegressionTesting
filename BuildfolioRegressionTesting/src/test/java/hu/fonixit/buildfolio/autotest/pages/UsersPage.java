package hu.fonixit.buildfolio.autotest.pages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import hu.fonixit.buildfolio.autotest.objects.UjFelhasznalo;
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
    //Új felhasználó felvétele ablak


    public UsersPage(WebDriver driver){
        super(driver);
    }

    public UsersPage clickOnUjFelhasznaloFelveteleBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(ujFelhasznaloFelveteleBtn)).click();
        return this;
    }

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
