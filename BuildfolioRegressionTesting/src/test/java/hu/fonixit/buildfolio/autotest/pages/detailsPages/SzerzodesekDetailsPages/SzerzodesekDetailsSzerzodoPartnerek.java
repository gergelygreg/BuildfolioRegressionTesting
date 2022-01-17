package hu.fonixit.buildfolio.autotest.pages.detailsPages.SzerzodesekDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;

public class SzerzodesekDetailsSzerzodoPartnerek extends BasePage {
    private final By hozzarendelesLinkBtn = By.xpath("//a[contains(., ' Hozzárendelés ')]");
    private final By eltavolitasBtn = By.xpath("//button[contains(.,'Eltávolítás')]");
    private final By megsemBtn = By.xpath("//a[.=' Mégsem ']");
    private final By hozzarendelesKijeloltBtn = By.xpath("//button[contains(.,'Hozzárendelés ')]");
    private final By szerkesztesBtn = By.xpath("(//button[@class='btn btn-simple ng-star-inserted'][normalize-space()='Szerkesztés'])[1]");
    private final By mentesIcon = By.xpath("(//button[@class='btn btn-primary mr-2 ng-star-inserted'])[1]");
    private final By jogkorDropDown = By.xpath("(//input[@role='combobox'])[1]");

    public SzerzodesekDetailsSzerzodoPartnerek(WebDriver driver) {
        super(driver);
    }

    //click
    public SzerzodesekDetailsSzerzodoPartnerek clickOnHozzarendBtn(){
        waitUtil.waitAndClick(hozzarendelesLinkBtn);
        return this;
    }

    public SzerzodesekDetailsSzerzodoPartnerek clickOnEltavolitasBtn(){
        waitUtil.waitAndClick(eltavolitasBtn);
        return this;
    }

    public SzerzodesekDetailsSzerzodoPartnerek clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    public SzerzodesekDetailsSzerzodoPartnerek clickOnHozzarendelesKijeloltBtn(){
        waitUtil.waitAndClick(hozzarendelesKijeloltBtn);
        return this;
    }

    public SzerzodesekDetailsSzerzodoPartnerek clickOnSzerkesztesBtn(){
        waitUtil.waitAndClick(szerkesztesBtn);
        return this;
    }

    public SzerzodesekDetailsSzerzodoPartnerek clickOnMentesIkon(){
        waitUtil.waitAndClick(mentesIcon);
        return this;
    }

    //select
    public SzerzodesekDetailsSzerzodoPartnerek selectCheckboxFelvettPartner(String felvettPartner, String tablaIndex){
        String tablazatElem = null;
        try {
            tablazatElem = waitUtil.waitAndGetText(By.xpath("//td["+tablaIndex+"][contains(.,'"+felvettPartner+"')]"));
            if (tablazatElem != null && tablazatElem.contains(felvettPartner)) {
                waitUtil.waitAndClick(By.xpath("//tr[contains(.,'"+felvettPartner+"')]//input"));
            }
            else {
                waitUtil.waitAndClick(By.xpath("//button[@class='btn next']"));
            }
        } catch (Exception e) {
        }
        return this;
    }

    public SzerzodesekDetailsSzerzodoPartnerek selectJogkorFromDropDown(String jogkor){
        waitUtil.waitAndClick(jogkorDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+jogkor+"']"));
        return this;
    }

    //assert
    public boolean popupMegjelenik(String uzenet){
        return waitUtil.popupWindMegjelenik(uzenet);
    }


    public boolean partnerekSzovegMegjelenik(){
        boolean ertek;
        try{
            waitUtil.waitForVisibility(By.xpath("//h3[contains(.,'Partnerek ')]"));
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
