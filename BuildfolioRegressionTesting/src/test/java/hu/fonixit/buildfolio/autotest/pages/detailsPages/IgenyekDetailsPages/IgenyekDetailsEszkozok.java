package hu.fonixit.buildfolio.autotest.pages.detailsPages.IgenyekDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IgenyekDetailsEszkozok extends BasePage {
    //tabok
    private final By atmekTab = By.xpath("");
    private final By banktechnikaiEszkTab = By.xpath("//a[normalize-space()='Banktechnikai eszközök']");
    private final By bankbiztonsagiTab = By.xpath("//a[normalize-space()='Bankbiztonsági eszközök']");

    //gombok
    private final By hozzarendelesBtn = By.xpath("//a[contains(.,'Hozzárendelés')]");
    private final By hozzarendelesKijelBtn = By.xpath("//button[contains(.,'Hozzárendelés ')]");
    private final By eltavolitasBtn = By.xpath("//button[contains(.,'Eltávolítás')]");
    private final By megsemBtn = By.xpath("//a[normalize-space()='Mégsem']");

    public IgenyekDetailsEszkozok(WebDriver driver) {
        super(driver);
    }

    //click
    public IgenyekDetailsEszkozok clickOnAtmekTab(){
        waitUtil.waitAndClick(atmekTab);
        return this;
    }

    public IgenyekDetailsEszkozok clickOnBanktechnikaiEszkTab(){
        waitUtil.waitAndClick(banktechnikaiEszkTab);
        return this;
    }

    public IgenyekDetailsEszkozok clickOnBankbiztonsagiTab(){
        waitUtil.waitAndClick(bankbiztonsagiTab);
        return this;
    }

    public IgenyekDetailsEszkozok clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    public IgenyekDetailsEszkozok clickOnHozzarendelesBtn(){
        waitUtil.waitAndClick(hozzarendelesBtn);
        return this;
    }

    public IgenyekDetailsEszkozok clickOnHozzarendelesKijelBtn(){
        waitUtil.waitAndClick(hozzarendelesKijelBtn);
        return this;
    }

    public IgenyekDetailsEszkozok clickOnEltavolitasBtn(){
        waitUtil.waitAndClick(eltavolitasBtn);
        return this;
    }

    //assert
    public boolean eszkozMegjelenikATablban(String nev, String oszlopIndex){
        return waitUtil.elementIsDisplayedInTable(nev, oszlopIndex);
    }

    public boolean popUpMegjelenik(String popUpSzovege){
        return waitUtil.popupWindMegjelenik(popUpSzovege);
    }

    //select
    public IgenyekDetailsEszkozok eszkozKivalasztasa(String egyediAzonosito){
        waitUtil.waitAndClick(By.xpath("//td[normalize-space()='"+egyediAzonosito+"']/ancestor::tr//td//app-checkbox//div//label"));
        return this;
    }
}
