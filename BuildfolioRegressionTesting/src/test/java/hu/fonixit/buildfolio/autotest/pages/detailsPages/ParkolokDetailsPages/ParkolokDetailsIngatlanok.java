package hu.fonixit.buildfolio.autotest.pages.detailsPages.ParkolokDetailsPages;

import com.github.javafaker.Bool;
import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ParkolokDetailsIngatlanok extends BasePage {
    private final By hozzarendelesBtn = By.xpath("//a[contains(.,' Hozzárendelés ')]");
    private final By eltavolitasBtn = By.xpath("//button[contains(.,'Eltávolítás ')]");
    private final By megsemBtn = By.xpath("//a[.= ' Mégsem ']");
    //Eltavolítás megerősítés
    private final By torlesBtn = By.xpath("//button[.='Törlés']");

    public ParkolokDetailsIngatlanok(WebDriver driver) {
        super(driver);
    }


    //click
    public ParkolokDetailsIngatlanok clickOntorlesBtn(){
        waitUtil.waitAndClick(torlesBtn);
        return this;
    }

    public ParkolokDetailsIngatlanok clickOnListaElsoElem(){
        waitUtil.waitAndClick(By.xpath("//tr[1]"));
        return this;
    }

    public ParkolokDetailsIngatlanok clickOnCheckbox(String checkboxIngatlanNeve){
        waitUtil.waitAndClick(By.xpath("//tr//td[contains(.,' "+checkboxIngatlanNeve+"')]/preceding-sibling::td//input"));
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

    public boolean ingatlanMegjATabl(String nev){
        return  waitUtil.elementIsDisplayedInTable(nev, "100", "3");
    }

    public boolean ingatlanMegjATabl(String nev, String tablaOszlopa){
        return  waitUtil.elementIsDisplayedInTable(nev, "100", tablaOszlopa);
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
