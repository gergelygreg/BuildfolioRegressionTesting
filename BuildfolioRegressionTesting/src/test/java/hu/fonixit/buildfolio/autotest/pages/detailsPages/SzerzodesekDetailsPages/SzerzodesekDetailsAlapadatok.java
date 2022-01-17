package hu.fonixit.buildfolio.autotest.pages.detailsPages.SzerzodesekDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SzerzodesekDetailsAlapadatok extends BasePage {
    private final By adatokSzerkeszteseBtn = By.xpath("//button[.=' Adatok szerkesztése ']");
    private final By mentesBtn = By.xpath("//button[contains(.,'Mentés')]");
    private final By megsemBtn = By.xpath("//button[normalize-space()='Mégsem']");
    private final By ujErtesitesBtn = By.xpath("//button[normalize-space()='+ Új értesítés']");
    //Új értesítés ablak
    private final By letrehozasBtn = By.xpath("//button[contains(.,'Létrehozás')]");
    private final By datumFld = By.xpath("//input[@placeholder='Dátum']");
    private final By oraFld = By.xpath("//input[@placeholder='HH']");
    private final By percFld = By.xpath("//input[@placeholder='MM']");
    private final By megjegyzesTextArea = By.xpath("//textarea[@placeholder='Nincs megadva']");
    private final By ertesitesekXBtn = By.xpath("//button[@class='btn btn-remove no-outline text-right']");
    //Megerősítés ablak
    private final By torlesBtn = By.xpath("//button[normalize-space()='Törlés']");

    public SzerzodesekDetailsAlapadatok(WebDriver driver){
        super(driver);
    }

    //click
    public SzerzodesekDetailsAlapadatok clickOnAdatokSzerkeszteseBtn(){
        waitUtil.waitAndClick(adatokSzerkeszteseBtn);
        return this;
    }

    public SzerzodesekDetailsAlapadatok clickOnMentesBtn(){
        waitUtil.waitAndClick(mentesBtn);
        return this;
    }

    public SzerzodesekDetailsAlapadatok clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    public SzerzodesekDetailsAlapadatok clickOnUjErtesitesBtn(){
        waitUtil.waitAndClick(ujErtesitesBtn);
        return this;
    }

    public SzerzodesekDetailsAlapadatok clickOnLetrehozasBtn(){
        waitUtil.waitAndClick(letrehozasBtn);
        return this;
    }

    public SzerzodesekDetailsAlapadatok clickOnXBtn(){
        waitUtil.waitAndClick(ertesitesekXBtn);
        return this;
    }

    public SzerzodesekDetailsAlapadatok clickOnTorlesBtn(){
        waitUtil.waitAndClick(torlesBtn);
        return this;
    }

    //sendKeys
    public SzerzodesekDetailsAlapadatok enterTextToDatumFld(String datum){
        waitUtil.waitAndSendkeys(datumFld, datum);
        return this;
    }

    public SzerzodesekDetailsAlapadatok enterTextToHHField(String ora){
        waitUtil.waitAndSendkeys(oraFld, ora);
        return this;
    }

    public SzerzodesekDetailsAlapadatok enterTextToMMField(String perc){
        waitUtil.waitAndSendkeys(percFld, perc);
        return this;
    }

    public SzerzodesekDetailsAlapadatok enterTextToMegjegyzesFld(String megjegyzes){
        waitUtil.waitAndSendkeys(megjegyzesTextArea, megjegyzes);
        return this;
    }

    //assertion
    public boolean popUpMegjelenik(String uzenetSzovege){
        return waitUtil.popupWindMegjelenik(uzenetSzovege);
    }

    public boolean ertesitesMegjelenikAlapadatokOldalon(){
        return waitUtil.elementIsDisplayed(By.xpath("//span[@class='title']"));
    }
}
