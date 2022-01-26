package hu.fonixit.buildfolio.autotest.pages.detailsPages.IngatlanokDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import hu.fonixit.buildfolio.autotest.pages.FeladatkezeloUjMunkafolyamatInditasaPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IngatlanokDetailsAlingatlanok extends BasePage {
    private final By hozzarendelesBtn = By.xpath("//a[normalize-space()='Hozzárendelés']");
    private final By hozzarendelesKijelBtn = By.xpath("//button[contains(.,'Hozzárendelés ')]");
    private final By koltsegSzamlaGeneralas = By.xpath("//span[normalize-space()='Költség számla generálás']");
    private final By eltavolitasBtn = By.xpath("//button[contains(.,'Eltávolítás')]");
    //költség számla generálás - megerősítés ablak
    private final By igenBtn = By.xpath("//button[normalize-space()='Igen']");
    private final By megsemBtn = By.xpath("//button[normalize-space()='Mégsem']");

    public IngatlanokDetailsAlingatlanok(WebDriver driver) {
        super(driver);
    }

    //click
    public IngatlanokDetailsAlingatlanok clickOnHozzarendelesBtn(){
        waitUtil.waitAndClick(hozzarendelesBtn);
        return this;
    }

    public IngatlanokDetailsAlingatlanok clickOnHozzarendelesKijelBtn(){
        waitUtil.waitAndClick(hozzarendelesKijelBtn);
        return this;
    }

    public IngatlanokDetailsAlingatlanok clickOnKoltsegSzamlaGeneralas(){
        waitUtil.waitAndClick(koltsegSzamlaGeneralas);
        return this;
    }

    public IngatlanokDetailsAlingatlanok clickOnEltavolitasBtn(){
        waitUtil.waitAndClick(eltavolitasBtn);
        return this;
    }

    public IngatlanokDetailsAlingatlanok clickOnIgenBtn(){
        waitUtil.waitAndClick(igenBtn);
        return this;
    }

    public IngatlanokDetailsAlingatlanok clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    //select
    public IngatlanokDetailsAlingatlanok alingatlanKivalasztasa(String egyediAzon){
        waitUtil.waitAndClick(By.xpath("//td[normalize-space()='"+egyediAzon+"']/ancestor::tr//td//app-checkbox//div//label"));
        return this;
    }

    //assert
    public boolean popUpMegjelenik(String popUpSzoveg){
        return waitUtil.popupWindMegjelenik(popUpSzoveg);
    }
}
