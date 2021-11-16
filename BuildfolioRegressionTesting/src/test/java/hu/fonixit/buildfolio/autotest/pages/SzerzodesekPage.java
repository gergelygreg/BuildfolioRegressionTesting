package hu.fonixit.buildfolio.autotest.pages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import hu.fonixit.buildfolio.autotest.objects.UjSzerzodes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SzerzodesekPage extends BasePage {
    private final By ujSzerzodesFelveteleBtn = By.xpath("//button[contains(text(),'Új szerződés felvétele')]");
    private  final By szerzodesszamFld = By.xpath("//app-text-input[@name='contractNumber']//input[@placeholder='Nincs megadva']");
    private final By szerzodesTipusaDropDown = By.xpath("(//span[@class='ng-arrow-wrapper'])[4]");
    private final By szerzodesTargyaTArea = By.xpath("//textarea[@placeholder='Nincs megadva']"); //először click és utána sendKeys
    private final By lejaratiTipusDropDown = By.xpath("(//span[@class='ng-arrow-wrapper'])[5]");
    private By felvetelBtn = By.xpath("//button[@class='btn btn-primary btn-submit']");

    public SzerzodesekPage (WebDriver driver){
        super(driver);
    }

    public boolean ujSzerzodesFelveteleBtnKattinthato(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ujSzerzodesFelveteleBtn)).isEnabled();
    }

    //click
    public SzerzodesekPage clickOnElsoElem(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[1]"))).click();
        return this;
    }

    public SzerzodesekPage clickOnFelvettSzerzodes(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[1]"))).click();
        return this;
    }

    public SzerzodesekPage clickOnUjSzerzodesFelveteleBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(ujSzerzodesFelveteleBtn)).click();
        return this;
    }

    public SzerzodesekPage clickOnFelvetelBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(felvetelBtn)).click();
        return this;
    }

    //enterText
    public SzerzodesekPage enterTextToSzerzodesszamFld(String szerzodesSzam){
        wait.until(ExpectedConditions.visibilityOfElementLocated(szerzodesszamFld)).sendKeys(szerzodesSzam);
        return this;
    }

    //enterText to textarea
    public SzerzodesekPage clickOnSzerzodesekTargyaTextarea(){
        wait.until(ExpectedConditions.elementToBeClickable(szerzodesTargyaTArea)).click();
        return this;
    }

    public SzerzodesekPage enterTextToSzerzodesekTargyaTextarea(String szerzodesTargy){
        clickOnSzerzodesekTargyaTextarea();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@placeholder='Nincs megadva']"))).sendKeys(szerzodesTargy);
        return this;
    }

    //select
    public SzerzodesekPage clickOnSzerzodesTipusaDropDown(){
        wait.until(ExpectedConditions.elementToBeClickable(szerzodesTipusaDropDown)).click();
        return this;
    }

    public SzerzodesekPage selectSzerzodesTipusa(String szerzodesTipusa){
        clickOnSzerzodesTipusaDropDown();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='"+szerzodesTipusa+"']"))).click();
        return this;
    }

    public SzerzodesekPage clickOnLejaratiTipusaDropDown(){
        wait.until(ExpectedConditions.elementToBeClickable(lejaratiTipusDropDown)).click();
        return this;
    }

    public SzerzodesekPage selectLejaratiTipus(String lejaratiTipus){
        clickOnLejaratiTipusaDropDown();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='"+lejaratiTipus+"']"))).click();
        return this;
    }

    //set uj szerzodes
    public SzerzodesekPage setUjSzerzodes(UjSzerzodes ujSzerzodes){
        return selectSzerzodesTipusa(ujSzerzodes.getSzerzodesTipusa()).
                enterTextToSzerzodesekTargyaTextarea(ujSzerzodes.getSzerzodesTargya()).
                selectLejaratiTipus(ujSzerzodes.getLejaratiTipus());
    }

    //ellenőrzés
    public String listaElsoElemeEll(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[1]//td[1]"))).getText();
    }
}

