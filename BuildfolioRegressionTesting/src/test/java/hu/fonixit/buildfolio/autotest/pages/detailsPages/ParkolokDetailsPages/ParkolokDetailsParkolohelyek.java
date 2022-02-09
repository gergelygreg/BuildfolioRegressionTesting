package hu.fonixit.buildfolio.autotest.pages.detailsPages.ParkolokDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import hu.fonixit.buildfolio.autotest.pages.components.ParkolokDetailsPageTabs;
import hu.fonixit.buildfolio.autotest.pages.components.Szurok;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ParkolokDetailsParkolohelyek extends BasePage {
    private final By ujParkolohelyFelveteleBtn = By.xpath("//button[.='Új parkolóhely felvétele']");
    private final By muveletekBtn = By.xpath("(//button[@type='button'])[3]");
    private final By szerkesztesDropDownElem = By.xpath("//button[.='Szerkesztés']");
    private final By torlesDropDownElem = By.xpath("//button[normalize-space()='Törlés']");

    //Új parkolóhely felvétele ablak
    private final By azonositoFld = By.xpath("//input[@maxlength='50']");
    private final By parkolohelyTipusaDropDown = By.xpath("(//input[@role='combobox'])[3]");
    private final By felvetelBtn = By.xpath("//button[.=' Felvétel ']");
    private final By megsemBtn = By.xpath("//button[.=' Mégsem ']");
    //Parkolóhely szerkesztése ablak
    private final By mentesBtn = By.xpath("//button[contains(.,'Mentés')]");
    //Megerősítés ablak
    private final By torlesBtn = By.xpath("//div[@class='modal-footer text-center']//button[.='Törlés']");
    private final By megsemMegEroBtn = By.xpath("//div[@class='modal-footer text-center']//button[.='Mégsem']");

    public ParkolokDetailsParkolohelyek(WebDriver driver) {
        super(driver);
    }

    //click
    public ParkolokDetailsParkolohelyek clickOnTorlesBtn(){
        waitUtil.waitAndClick(torlesBtn);
        return this;
    }

    public ParkolokDetailsParkolohelyek clickOnMegsemMegEroBtn(){
        waitUtil.waitAndClick(megsemMegEroBtn);
        return this;
    }

    public ParkolokDetailsParkolohelyek clickOnMentesBtn(){
        waitUtil.waitAndClick(mentesBtn);
        return this;
    }

    public ParkolokDetailsParkolohelyek clickOnFelvetelBtn(){
        waitUtil.waitAndClick(felvetelBtn);
        return this;
    }

    public ParkolokDetailsParkolohelyek clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    public ParkolokDetailsParkolohelyek clickOnUjParkolohelyFelevBtn(){
        waitUtil.waitAndClick(ujParkolohelyFelveteleBtn);
        return this;
    }

    public ParkolokDetailsParkolohelyek clickOnMuveletekBtn(){
        waitUtil.waitAndClick(muveletekBtn);
        return this;
    }

    public ParkolokDetailsParkolohelyek clickOnSzerkesztesMuvelDropDown(){
        waitUtil.waitAndClick(szerkesztesDropDownElem);
        return this;
    }

    public ParkolokDetailsParkolohelyek clickOnTorlesMuvelDropDown(){
        waitUtil.waitAndClick(torlesDropDownElem);
        return this;
    }
    //clear field
    public ParkolokDetailsParkolohelyek clearAzonositFld(){
        waitUtil.waitAndClearText(azonositoFld);
        return this;
    }

    public ParkolokDetailsParkolohelyek clearParkTipDropDown(){
        waitUtil.waitAndClearText(parkolohelyTipusaDropDown);
        return this;
    }

    //sendKeys

    public ParkolokDetailsParkolohelyek enterTextToAzonositoFld(String azonosito){
        waitUtil.waitAndSendkeys(azonositoFld, azonosito);
        return this;
    }

    //select from dropdown
    public ParkolokDetailsParkolohelyek selectElemFromParkHelyTipDropDown(String tipus){
        waitUtil.waitAndClick(parkolohelyTipusaDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+tipus+"']"));
        return this;
    }

    //assertion
    public boolean felvetelBtnKattinthato(){
        return  waitUtil.elementIsClickable(felvetelBtn);
    }

    public boolean megsemBtnKattinthato(){
        return waitUtil.elementIsClickable(megsemBtn);
    }

    public boolean felvettParkolohelyMegjATablazatban(String parkhelyNeve, String tablaIndex){
        return waitUtil.elementIsDisplayedInTable(parkhelyNeve, tablaIndex);
    }


    public int parkolohelyekSzamaTablazat(){
       int parkhelySzama = driver.findElements(By.xpath("//tr")).size();
       return parkhelySzama;
    }

    public String sikeresRogzMessage(){
        return waitUtil.waitAndGetText(By.xpath("//div[@role='alertdialog']"));
    }

    public boolean popUpMegjelenik(String popUpSzoveg){
        return waitUtil.popupWindMegjelenik(popUpSzoveg);
    }



}
