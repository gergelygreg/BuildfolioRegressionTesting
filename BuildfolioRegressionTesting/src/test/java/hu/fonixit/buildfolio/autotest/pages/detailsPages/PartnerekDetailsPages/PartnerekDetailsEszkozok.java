package hu.fonixit.buildfolio.autotest.pages.detailsPages.PartnerekDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PartnerekDetailsEszkozok extends BasePage {
    private final By atmekBtn = By.xpath("//a[normalize-space()='ATM-ek']");
    private final By banktechnikaiEszkBtn = By.xpath("//a[normalize-space()='Banktechnikai eszközök']");
    private final By bankbiztonsagiEszkozok = By.xpath("//a[normalize-space()='Bankbiztonsági eszközök']");

    public PartnerekDetailsEszkozok(WebDriver driver) {
        super(driver);
    }

    //click
    public PartnerekDetailsEszkozok clickOnAtmekBtn(){
        waitUtil.waitAndClick(atmekBtn);
        return this;
    }

    public PartnerekDetailsEszkozok clickOnBanktechnikaiEszkBtn(){
        waitUtil.waitAndClick(banktechnikaiEszkBtn);
        return this;
    }

    public PartnerekDetailsEszkozok clickOnBankbiztonsagiEszkozok(){
        waitUtil.waitAndClick(bankbiztonsagiEszkozok);
        return this;
    }

    //assertion
    public boolean elemMegjelenikATablazatban(String  elemNeve, String oszlopIndex){
        return waitUtil.elementIsDisplayedInTable(elemNeve, oszlopIndex);
    }

    public boolean nincsMegjelenithetoAdatFeliratMegjelenik(){
        return waitUtil.nincsMegjAdatFeliratMegj();
    }
}
