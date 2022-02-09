package hu.fonixit.buildfolio.autotest.pages.detailsPages.SzerzodesekDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;

public class SzerzodesekDetailsIngatlanokEsEladasiArak extends BasePage {
    private final By ingaltlHozzarendeleseASzerzhezBtn = By.xpath("//a[contains(text(),'Ingatlanok hozzárendelése a szerződéshez')]");
    private final By eladasiArakMegadasaAKijelolteknelBtn = By.xpath("//button[@class='btn btn-primary mr-3 ng-star-inserted']");
    private final By nettoEladasiArFld = By.xpath("//app-currency[@amountname='contractAmountOriginal']//input[@placeholder='Nincs megadva']");
    private final By hozzarendelesBtn = By.xpath("//button[.=' Hozzárendelés ']");

    public SzerzodesekDetailsIngatlanokEsEladasiArak(WebDriver driver){
        super(driver);
    }

    public boolean hozzarendelesBtnKattinthato(){
        return waitUtil.waitAndEnabled(hozzarendelesBtn);
    }

    //click
    public SzerzodesekDetailsIngatlanokEsEladasiArak clickOnIngaltlHozzarendelewseASzerzhezBtn(){
        waitUtil.waitAndClick(ingaltlHozzarendeleseASzerzhezBtn);
        return this;
    }

    public SzerzodesekDetailsIngatlanokEsEladasiArak clickOnEladasiArakMegadasaAKijelolteknelBtn(){
        waitUtil.waitAndClick(eladasiArakMegadasaAKijelolteknelBtn);
        return this;
    }

    public SzerzodesekDetailsIngatlanokEsEladasiArak clickOnHozzarendelesBtn(){
        waitUtil.waitAndClick(hozzarendelesBtn);
        return this;
    }

    public SzerzodesekDetailsIngatlanokEsEladasiArak clickOnHozzarendelesBtnAblakon(){
        waitUtil.waitAndClick(By.xpath("//button[@class='btn btn-primary']"));
        return this;
    }

    //sendKeys
    public SzerzodesekDetailsIngatlanokEsEladasiArak enterToNettoEladasiArFld(String nettoEladasiAr){
        waitUtil.waitAndSendkeys(nettoEladasiArFld, nettoEladasiAr);
        return this;
    }

    //select
    public SzerzodesekDetailsIngatlanokEsEladasiArak selectCheckboxFelvettIngatlan(String felvettIngatlanNeve){
        waitUtil.waitAndClick(By.xpath("//td[normalize-space()='"+felvettIngatlanNeve+"']/ancestor::tr//td//app-checkbox//div//label"));
        return this;
    }

    //assert
    public boolean eladasiArakMegadasaAKijelolteknelBtnKattinthato(){
        return waitUtil.waitAndEnabled(eladasiArakMegadasaAKijelolteknelBtn);
    }

    public boolean popupMegjelenik(String uzenet){
        return waitUtil.popupWindMegjelenik(uzenet);
    }

    public boolean ingatlanokHozzarendeleseSzerzodeshezSzoveg(){
        boolean ertek;
        try{
            waitUtil.waitForVisibility(By.xpath("//p[contains(text(),'Hozzárendeli az ingatlanokat a megadott eladási ár')]"));
            ertek = true;
        }catch (ElementNotVisibleException e){
            ertek = false;
        }
        return ertek;
    }

    public boolean ingatlanMegjATablBan(String ingatlanNeve, String tablaoszlopIndex){
       return waitUtil.elementIsDisplayedInTable(ingatlanNeve,tablaoszlopIndex);
    }


}
