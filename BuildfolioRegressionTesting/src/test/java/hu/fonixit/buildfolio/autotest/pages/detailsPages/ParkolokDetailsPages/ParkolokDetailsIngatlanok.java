package hu.fonixit.buildfolio.autotest.pages.detailsPages.ParkolokDetailsPages;

import com.github.javafaker.Bool;
import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ParkolokDetailsIngatlanok extends BasePage {
    private final By hozzarendelesBtn = By.xpath("//a[normalize-space()='Hozzárendelés']");
    private final By hozzarendKijBtn = By.xpath("//button[contains(.,'Hozzárendelés')]");
    private final By eltavolitasBtn = By.xpath("//button[contains(.,'Eltávolítás')]");
    private final By megsemBtn = By.xpath("//button[normalize-space()='Mégsem']");
    //Eltavolítás megerősítés
    private final By torlesBtn = By.xpath("//button[.='Törlés']");

    public ParkolokDetailsIngatlanok(WebDriver driver) {
        super(driver);
    }


    //click
    public ParkolokDetailsIngatlanok clickOnHozzarendelesKijBtn(){
        waitUtil.waitAndClick(hozzarendKijBtn);
        return this;
    }

    public ParkolokDetailsIngatlanok clickOnTorlesBtn(){
        waitUtil.waitAndClick(torlesBtn);
        return this;
    }

    public ParkolokDetailsIngatlanok selectElementFromTable(String egyediAzon, String oszlopIndex){
        waitUtil.selectElementFromTableOszlopKivalasztasaval(egyediAzon, oszlopIndex);
        return this;
    }

    public ParkolokDetailsIngatlanok clickOnCheckbox(String egyediAzonosito){
        waitUtil.waitAndClick(By.xpath("//tr//td[contains(.,'"+egyediAzonosito+"')]/preceding-sibling::td//label"));
        return this;
    }

    public ParkolokDetailsIngatlanok clickOnHozzarendelesBtn(){
        waitUtil.waitAndClick(hozzarendelesBtn);
        return this;
    }

    public ParkolokDetailsIngatlanok clickOnEltavolitasBtn(){
        waitUtil.waitAndClick(eltavolitasBtn);
        return this;
    }

    public ParkolokDetailsIngatlanok clickOnMegsem(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    //assertion
    public boolean elemMegjelenikATablazatban(String egyediAzon, String oszlopIndex){
        return waitUtil.elementIsDisplayedInTable(egyediAzon, oszlopIndex);
    }

    public String ingatlanokFelirat(String felirat){
        return waitUtil.waitAndGetText(By.xpath("//h3[contains(.,'"+felirat+"')]"));
    }

    public boolean nincsMegjAdatFelirat(){
       return waitUtil.nincsMegjAdatFeliratMegj();
    }

    public boolean hozzarendelesBtnInaktiv(){
        boolean ertek;
        try {
          waitUtil.waitAndClick(hozzarendelesBtn);
          ertek = false;
        }catch (Exception e){
            ertek =true;
        }
        return ertek;
    }

    public boolean eltavolitasBtnInaktiv(){
        boolean ertek;
        try {
            waitUtil.waitAndClick(eltavolitasBtn);
            ertek = false;
        }catch (Exception e){
            ertek =true;
        }
        return ertek;
    }

    public boolean popupMegjelenik(String popupSzoveg){
       return waitUtil.popupWindMegjelenik(popupSzoveg);
    }

    public boolean ingatlanMegjATabl(String elemNeve, String tablaIndex){
        return  waitUtil.elementIsDisplayedInTable(elemNeve, tablaIndex);
    }

    public ParkolokDetailsIngatlanok hozzarendelesSzama(String hozzarendSzama){
        waitUtil.waitForVisibility(By.xpath("//button[.=' Hozzárendelés ("+hozzarendSzama+") ']"));
        return this;
    }

    public boolean bankuzemCeluUnchecked(){
        boolean ertek;
        try {
            waitUtil.waitForVisibility(By.xpath("//span[@class='unchecked"));
            ertek = true;
        }catch (Exception e){
            ertek = false;
        }
        return ertek;
    }

    public boolean ingatlanAdatlaponAllunk(String ingatlanNeve){
        boolean ertek;
        try {
            waitUtil.waitForVisibility(By.xpath("//span[.=' "+ingatlanNeve+" ']"));
            ertek = false;
        }catch (Exception e){
            ertek =true;
        }
        return ertek;
    }




}
