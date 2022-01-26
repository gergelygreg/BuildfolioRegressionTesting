package hu.fonixit.buildfolio.autotest.pages.detailsPages.IngatlanokDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IngatlanokDetailsParkolas extends BasePage {
    private final By parkolokTab = By.xpath("//a[text()=' Parkolók ']");
    private final By parkolohelyekTab = By.xpath("//a[normalize-space()='Parkolóhelyek']");
    private final By hozzarendelesBtn = By.xpath("//a[contains(.,'Hozzárendelés ')]");
    private final By hozzarendleseKijBtn = By.xpath("//button[contains(.,'Hozzárendelés ')]");
    private final By megsemBtn = By.xpath("//a[normalize-space()='Mégsem']");
    private final By eltavolitasBtn = By.xpath("//button[contains(.,'Eltávolítás ')]");

    public IngatlanokDetailsParkolas(WebDriver driver) {
        super(driver);
    }

    //click
    public IngatlanokDetailsParkolas clickOnParkolokTab(){
        waitUtil.waitAndClick(parkolokTab);
        return this;
    }

    public IngatlanokDetailsParkolas clickOnParkolohelyekTab(){
        waitUtil.waitAndClick(parkolohelyekTab);
        return this;
    }

    public IngatlanokDetailsParkolas clickOnHozzarendelesBtn(){
        waitUtil.waitAndClick(hozzarendelesBtn);
        return this;
    }

    public IngatlanokDetailsParkolas clickOnHozzarendleseKijBtn(){
        waitUtil.waitAndClick(hozzarendleseKijBtn);
        return this;
    }

    public IngatlanokDetailsParkolas clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    public IngatlanokDetailsParkolas clickOnEltavolitasBtn(){
        waitUtil.waitAndClick(eltavolitasBtn);
        return this;
    }

    public boolean parkoloMegjATabl(String parkoloNeve, String tablaIndex){
        return  waitUtil.elementIsDisplayedInTable(parkoloNeve, tablaIndex);
    }

    //select
    public IngatlanokDetailsParkolas selectCheckBox(String egyediAzon){
        waitUtil.waitAndClick(By.xpath("//td[normalize-space()='"+egyediAzon+"']/ancestor::tr//td//app-checkbox//div//label"));
        return this;
    }

    //assert
    public boolean popUpMegjelenik(String popUpSzovege){
        return waitUtil.popupWindMegjelenik(popUpSzovege);
    }
}
