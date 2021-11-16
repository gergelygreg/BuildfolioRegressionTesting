package hu.fonixit.buildfolio.autotest.pages.detailsPages.SzerzodesekDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SzerzodesekDetailsIngatlanokEsEladasiArak extends BasePage {
    private final By hozzarendelesBtn = By.xpath("//a[normalize-space()='Hozzárendelés']");
    private final By eladasiArakMegadasaAKijelolteknelBtn = By.xpath("//button[@class='btn btn-primary mr-3 ng-star-inserted']");
    private final By nettoEladasiArFld = By.xpath("//app-currency[@amountname='contractAmountOriginal']//input");

    public SzerzodesekDetailsIngatlanokEsEladasiArak(WebDriver driver){
        super(driver);
    }

    public boolean hozzarendelesBtnKattinthato(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(hozzarendelesBtn)).isEnabled();
    }

    //click
    public SzerzodesekDetailsIngatlanokEsEladasiArak clickOnHozzarendelesBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(hozzarendelesBtn)).click();
        return this;
    }

    public SzerzodesekDetailsIngatlanokEsEladasiArak clickOnEladasiArakMegadasaAKijelolteknelBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(eladasiArakMegadasaAKijelolteknelBtn)).click();
        return this;
    }


    //select
    public SzerzodesekDetailsIngatlanokEsEladasiArak selectCheckboxFelvettIngatlan(String felvettIngatlan){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[contains(.,'"+felvettIngatlan+"')]//input"))).click();
        return this;
    }

    public boolean eladasiArakMegadasaAKijelolteknelBtnKattinthato(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(eladasiArakMegadasaAKijelolteknelBtn)).isEnabled();
    }

    public SzerzodesekDetailsIngatlanokEsEladasiArak enterToNettoEladasiArFld(String nettoEladasiAr){
        wait.until(ExpectedConditions.visibilityOfElementLocated(nettoEladasiArFld)).sendKeys(nettoEladasiAr);
        return this;
    }

}
