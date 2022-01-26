package hu.fonixit.buildfolio.autotest.pages.detailsPages.IgenyekDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IgenyekDetailsIngatlanok extends BasePage {
    private final By hozzarendelesBtn = By.xpath("//a[contains(.,'Hozzárendelés')]");
    private final By hozzarendelesKijelBtn = By.xpath("//button[contains(.,'Hozzárendelés ')]");
    private final By eltavolitasBtn = By.xpath("//button[contains(.,'Eltávolítás')]");
    private final By megsemBtn = By.xpath("//a[normalize-space()='Mégsem']");


    public IgenyekDetailsIngatlanok(WebDriver driver) {
        super(driver);
    }

    //select
    public IgenyekDetailsIngatlanok selectIngatlanCheckBox(String nev){
        waitUtil.waitAndClick(By.xpath("//td[normalize-space()='"+nev+"']/ancestor::tr//td//app-checkbox//div//label"));
        return this;
    }

    //click
    public IgenyekDetailsIngatlanok clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    public IgenyekDetailsIngatlanok clickOnHozzarendelesBtn(){
        waitUtil.waitAndClick(hozzarendelesBtn);
        return this;
    }

    public IgenyekDetailsIngatlanok clickOnHozzarendelesKijelBtn(){
        waitUtil.waitAndClick(hozzarendelesKijelBtn);
        return this;
    }

    public IgenyekDetailsIngatlanok clickOnEltavolitasBtn(){
        waitUtil.waitAndClick(eltavolitasBtn);
        return this;
    }

    //assert
    public boolean ingatlanMegjelenikATablban(String nev, String oszlopIndex){
        return waitUtil.elementIsDisplayedInTable(nev, oszlopIndex);
    }


}
