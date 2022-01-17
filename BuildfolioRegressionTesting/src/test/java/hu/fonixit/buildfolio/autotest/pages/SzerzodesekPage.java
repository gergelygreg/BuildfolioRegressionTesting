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
    private final By lejaratiTipusDropDown = By.xpath("((//input[@role='combobox'])[5]");
    private By felvetelBtn = By.xpath("//button[@class='btn btn-primary btn-submit']");

    public SzerzodesekPage (WebDriver driver){
        super(driver);
    }

    public boolean ujSzerzodesFelveteleBtnKattinthato(){
        return waitUtil.elementIsClickable(ujSzerzodesFelveteleBtn);
    }

    //click
    public SzerzodesekPage clickOnElsoElem(){
        waitUtil.waitAndClick(By.xpath("//tr[1]"));
        return this;
    }

    public SzerzodesekPage clickOnUjSzerzodesFelveteleBtn(){
        waitUtil.waitAndClick(ujSzerzodesFelveteleBtn);
        return this;
    }

    public SzerzodesekPage clickOnFelvetelBtn(){
        waitUtil.waitAndClick(felvetelBtn);
        return this;
    }

    public SzerzodesekPage clickOnTablazatEleme(String elemNeve, String oszlopIndex){
        waitUtil.selectElementFromTableOszlopKivalasztasaval(elemNeve, oszlopIndex);
        return this;
    }

    //enterText
    public SzerzodesekPage enterTextToSzerzodesszamFld(String szerzodesSzam){
        waitUtil.waitAndSendkeys(szerzodesszamFld, szerzodesSzam);
        return this;
    }

    //enterText to textarea
    public SzerzodesekPage clickOnSzerzodesekTargyaTextarea(){
        waitUtil.waitAndClick(szerzodesTargyaTArea);
        return this;
    }

    public SzerzodesekPage enterTextToSzerzodesekTargyaTextarea(String szerzodesTargya){
        clickOnSzerzodesekTargyaTextarea();
        waitUtil.waitAndSendkeys(By.xpath("//textarea[@placeholder='Nincs megadva']"), szerzodesTargya);
        return this;
    }

    //select
    public SzerzodesekPage clickOnSzerzodesTipusaDropDown(){
        waitUtil.waitAndClick(szerzodesTipusaDropDown);
        return this;
    }

    public SzerzodesekPage selectSzerzodesTipusa(String szerzodesTipusa){
        clickOnSzerzodesTipusaDropDown();
        waitUtil.waitAndClick(By.xpath("//div[@title='"+szerzodesTipusa+"']"));
        return this;
    }

    public SzerzodesekPage clickOnLejaratiTipusaDropDown(){
        waitUtil.waitAndClick(lejaratiTipusDropDown);
        return this;
    }

    public SzerzodesekPage selectLejaratiTipus(String lejaratiTipus){
        clickOnLejaratiTipusaDropDown();
        waitUtil.waitAndClick(By.xpath("//div[@title='"+lejaratiTipus+"']"));
        return this;
    }

    //set uj szerzodes
    public SzerzodesekPage setUjSzerzodes(UjSzerzodes ujSzerzodes){
        return selectSzerzodesTipusa(ujSzerzodes.getSzerzodesTipusa()).
                enterTextToSzerzodesekTargyaTextarea(ujSzerzodes.getSzerzodesTargya());
    }

    //assertion
    public String listaElsoElemeEll(){
        return waitUtil.waitAndGetText(By.xpath("//tr[1]//td[1]"));
    }

    public boolean elemMegjelenikATablazatban(String elemNeve, String oszlopIndex){
        return waitUtil.elementIsDisplayedInTable(elemNeve, oszlopIndex);
    }

    public boolean popUpMegjelenik(String popUpSzoveg){
        return waitUtil.popupWindMegjelenik(popUpSzoveg);
    }


}

