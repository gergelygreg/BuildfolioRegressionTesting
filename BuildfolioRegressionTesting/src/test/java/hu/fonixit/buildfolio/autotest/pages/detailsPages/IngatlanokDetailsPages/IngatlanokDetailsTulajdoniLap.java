package hu.fonixit.buildfolio.autotest.pages.detailsPages.IngatlanokDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IngatlanokDetailsTulajdoniLap extends BasePage {
    private final By adatokSzerkeszteseBtn = By.xpath("//button[normalize-space()='Adatok szerkesztése']");
    private final By mentesBtn = By.xpath("//button[contains(.,'Mentés')]");
    private final By megsemBtn = By.xpath("//button[normalize-space()='Mégsem']");
    //Tulajdonos(ok)
    private final By tulajdonosDropDown = By.xpath("//input[@autocomplete='aca578d11e46']");
    private final By tulajdonjogJogcimDropDown = By.xpath("//input[@autocomplete='a23aeacaaae2']");
    private final By tulajdonjogJogallasDropDown = By.xpath("//input[@autocomplete='acde16bb8238']");
    private final By tulajdoniHanyadFld = By.xpath("//app-text-input[@name='ownershipProportion']//input");
    private final By bejegyzesDatumaFld = By.xpath("//app-datepicker-basic[@name='ownershipRecordDate']//input");

    public IngatlanokDetailsTulajdoniLap(WebDriver driver) {
        super(driver);
    }

    //click
    public IngatlanokDetailsTulajdoniLap clickOnAdatokSzerkeszteseBtn(){
        waitUtil.waitAndClick(adatokSzerkeszteseBtn);
        return this;
    }

    public IngatlanokDetailsTulajdoniLap clickOnMentesBtn(){
        waitUtil.waitAndClick(mentesBtn);
        return this;
    }

    public IngatlanokDetailsTulajdoniLap clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    //select
    public IngatlanokDetailsTulajdoniLap selectFromTulajdonosDropDown(String tulajdonos){
        waitUtil.waitAndClick(tulajdonosDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+tulajdonos+"']"));
        return this;
    }

    public IngatlanokDetailsTulajdoniLap selectFromTulajdonjogJogcimDropDown(String tulajJogcim){
        waitUtil.waitAndClick(tulajdonjogJogcimDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+tulajJogcim+"']"));
        return this;
    }

    public IngatlanokDetailsTulajdoniLap selectFromTulajdonjogJogallasDropDown(String tulajJogallas){
        waitUtil.waitAndClick(tulajdonjogJogallasDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+tulajJogallas+"']"));
        return this;
    }

    //sendKeys
    public IngatlanokDetailsTulajdoniLap enterTextToTulajdoniHanyadFld(String tulajdoniHanyad){
        waitUtil.waitAndSendkeys(tulajdoniHanyadFld, tulajdoniHanyad);
        return this;
    }

    public IngatlanokDetailsTulajdoniLap enterDateToBejegyzesDatumaFld(String bejegyzesDatuma){
        waitUtil.waitAndSendkeys(bejegyzesDatumaFld, bejegyzesDatuma);
        return this;
    }

    //assert
    public boolean popUpMegjelenik(String popUpSzovege){
        return waitUtil.popupWindMegjelenik(popUpSzovege);
    }

}
