package hu.fonixit.buildfolio.autotest.pages.components;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Szurok extends BasePage {
    private final By szurokBtn = By.xpath("//span[contains(text(), 'Szűrők')]");
    private final By keresesBtn = By.cssSelector("button[type='submit']");
    private final By szurokTorleseBtn = By.cssSelector("button[type='reset']");
    private final By nevFld = By.cssSelector("input[placeholder='Név']");

    public Szurok(WebDriver driver){
        super(driver);
    }

    public Szurok clickOnSzurokBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(szurokBtn)).click();
        return this;
    }

    public Szurok enterNev(String nev){
        wait.until(ExpectedConditions.visibilityOfElementLocated(nevFld)).sendKeys(nev);
        return this;
    }

    public Szurok clickOnKeresesBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(keresesBtn)).click();
        return this;
    }
}
