package hu.fonixit.buildfolio.autotest.pages.detailsPages.SzamlakDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SzamlakDetailsPartnerek extends BasePage {
    private final By hozzarendelesBtn = By.xpath("//button[normalize-space()='Hozzárendelés']");
    private final By eltavolitasBtn = By.xpath("//span[contains(text(),' Eltávolítás ')]");
    private final By hozzarendelesKijBtn = By.xpath("//span[contains(text(),' Hozzárendelés ')]");
    private final By megsemBtn = By.xpath("//a[normalize-space()='Mégsem']");
    private final By torlesBtn = By.xpath("//button[.='Törlés']");

    public SzamlakDetailsPartnerek(WebDriver driver) {
        super(driver);
    }

    //click
    public SzamlakDetailsPartnerek clickOnCheckBox(String partnerNeve){
        waitUtil.waitAndClick(By.xpath("//td[normalize-space()='"+partnerNeve+"']/parent::tr//td//app-checkbox//div//label"));
        return this;
    }

    public SzamlakDetailsPartnerek clickOnHozzarendelesBtn(){
        waitUtil.waitAndClick(hozzarendelesBtn);
        return this;
    }

    public SzamlakDetailsPartnerek clickOnHozzarendleseKijBtn(){
        waitUtil.waitAndClick(hozzarendelesKijBtn);
        return this;
    }

    public SzamlakDetailsPartnerek clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    public SzamlakDetailsPartnerek clickOnEltavolitasBtn(){
        waitUtil.waitAndClick(eltavolitasBtn);
        return this;
    }

    public SzamlakDetailsPartnerek clickOnTorlesBtn(){
        waitUtil.waitAndClick(torlesBtn);
        return this;
    }



}
