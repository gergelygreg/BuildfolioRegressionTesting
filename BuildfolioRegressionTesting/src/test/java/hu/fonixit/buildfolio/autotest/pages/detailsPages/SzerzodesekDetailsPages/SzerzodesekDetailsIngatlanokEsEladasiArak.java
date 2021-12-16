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
        return waitUtil.waitAndEnabled(hozzarendelesBtn);
    }

    //click
    public SzerzodesekDetailsIngatlanokEsEladasiArak clickOnHozzarendelesBtn(){
        waitUtil.waitAndClick(hozzarendelesBtn);
        return this;
    }

    public SzerzodesekDetailsIngatlanokEsEladasiArak clickOnEladasiArakMegadasaAKijelolteknelBtn(){
        waitUtil.waitAndClick(eladasiArakMegadasaAKijelolteknelBtn);
        return this;
    }


    //select
    public SzerzodesekDetailsIngatlanokEsEladasiArak selectCheckboxFelvettIngatlan(String felvettIngatlan){
        waitUtil.waitAndClick(By.xpath("//tr[contains(.,'"+felvettIngatlan+"')]//input"));
        return this;
    }

    public boolean eladasiArakMegadasaAKijelolteknelBtnKattinthato(){
        return waitUtil.waitAndEnabled(eladasiArakMegadasaAKijelolteknelBtn);
    }

    public SzerzodesekDetailsIngatlanokEsEladasiArak enterToNettoEladasiArFld(String nettoEladasiAr){
        waitUtil.waitAndSendkeys(nettoEladasiArFld, nettoEladasiAr);
        return this;
    }

}
