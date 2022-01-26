package hu.fonixit.buildfolio.autotest.pages.detailsPages.IgenyekDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import hu.fonixit.buildfolio.autotest.pages.IgenyekPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IgenyekDetailsAlapadatok extends BasePage {
    private final By adatokSzerkeszteseBtn = By.xpath("//button[normalize-space()='Adatok szerkesztése']");
    private final By mentesBtn = By.xpath("//button[normalize-space()='Adatok szerkesztése']");
    private final By megsemBtn = By.xpath("//button[.=' Mégsem ']");
    private final By nevFld = By.xpath("input[formcontrolname$='externalIdentifier']");
    private final By feltoltesBtn = By.xpath("//label[normalize-space()='Feltöltés']");
    private final By leirasTextArea = By.xpath("//textarea");

    public IgenyekDetailsAlapadatok(WebDriver driver) {
        super(driver);
    }

    //click
    public IgenyekDetailsAlapadatok clickOnAdatokSzerkeszteseBtn(){
        waitUtil.waitAndClick(adatokSzerkeszteseBtn);
        return this;
    }

    public IgenyekDetailsAlapadatok clickOnMentesBtn(){
        waitUtil.waitAndClick(mentesBtn);
        return this;
    }

    public IgenyekDetailsAlapadatok clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    public IgenyekDetailsAlapadatok clickOnFeltoltesBtn(){
        waitUtil.waitAndClick(feltoltesBtn);
        return this;
    }

    //sendKeys
    public IgenyekDetailsAlapadatok enterTextToNevFld(String nev){
        waitUtil.waitAndSendkeys(nevFld, nev);
        return this;
    }

    public IgenyekDetailsAlapadatok enterTextToLeirasTextarea(String leiras){
        waitUtil.waitAndSendkeys(leirasTextArea, leiras);
        return this;
    }

    //assert
    public boolean popUpMegjelenik(String popUpSzoveg){
        return waitUtil.popupWindMegjelenik(popUpSzoveg);
    }

    public IgenyekDetailsAlapadatok igenyekDetailsOldalonAllunk(){
        waitUtil.waitWebElement(By.xpath("//span[normalize-space()='Igény adatlap']"));
        return this;
    }

}
