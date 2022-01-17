package hu.fonixit.buildfolio.autotest.pages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SzamlakPage extends BasePage {

    private final By ujSzamlaFelveteleBtn = By.xpath("//button[normalize-space()='Új számla felvétele']");
    //új számla felvétele ablak
    private final By szamlaIranyaDropDown = By.xpath("//app-buildfolio-select[@id='invoice-modal-sub-type-select']//input");
    private final By szamlaSorszamaFld = By.xpath("//label[contains(.,'Számla sorszáma')]/following-sibling::input");
    private final By szamlaTipusa = By.xpath("//app-buildfolio-select[@id='invoice-modal-invoice-type-select']//input");
    private final By felvetelBtn = By.xpath("//button[.=' Felvétel ']");
    private final By megsemBtn = By.xpath("//button[.='Mégsem']");

    public SzamlakPage (WebDriver driver){
        super(driver);
    }

    //click
    public SzamlakPage clickOnFelvetelBtn(){
        waitUtil.waitAndClick(felvetelBtn);
        return this;
    }

    public SzamlakPage clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    public SzamlakPage clickOnUjSzamlaFelveteleBtn(){
        waitUtil.waitAndClick(ujSzamlaFelveteleBtn);
        return this;
    }

    //enterText
    public SzamlakPage enterTextToSzamlaSorszFld(String szamlaSorszama){
        waitUtil.waitAndSendkeys(szamlaSorszamaFld, szamlaSorszama);
        return this;
    }

    //select
    public SzamlakPage selectSzamlaIranyaFromDropDown(String irany){
        waitUtil.waitAndClick(szamlaIranyaDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+irany+"']"));
        return this;
    }

    public SzamlakPage selectSzamlaTipusaFromDropDown(String tipus){
        waitUtil.waitAndClick(szamlaTipusa);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+tipus+"']"));
        return this;
    }

    //assert
    public boolean ujSzamlaFelveteleBtnKattinthato(){
       return waitUtil.elementIsDisplayed(ujSzamlaFelveteleBtn);
    }

    public boolean felvetelBtnKattinthato(){
        return waitUtil.elementIsClickable(felvetelBtn);
    }
}
