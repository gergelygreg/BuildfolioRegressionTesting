package hu.fonixit.buildfolio.autotest.pages.detailsPages.SzamlakDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SzamlakDetailsDokumentumok extends BasePage {
    private final By ujDokumentumFeltoltese = By.xpath("//button[normalize-space()='Új dokumentum feltöltése']");
    //Új dokumentum feltöltése
    private final By feltoltesBtn = By.xpath("//button[contains(.,'Feltöltés')]");
    private final By megsemBtn = By.xpath("//button[normalize-space()='Mégsem']");
    private final By modositasBtn = By.xpath("//label[normalize-space()='Módosítás']");
    private final By dokumentumTipusaDropDown = By.xpath("//app-buildfolio-select[@name='documentTypeCode']//input[@autocomplete='a6d985fdd703']");
    private final By dokumentumKelteFld = By.xpath("//app-datepicker-basic[@name='documentCreationDate']//input");
    private final By ervenyessegVegeFld = By.xpath("//app-datepicker-basic[@name='documentValidityEnd']//input[@placeholder='Nincs megadva']");

    public SzamlakDetailsDokumentumok(WebDriver driver) {
        super(driver);
    }

    //click
    public SzamlakDetailsDokumentumok clickOnUjDokumentumFeltolteseBtn(){
        waitUtil.waitAndClick(ujDokumentumFeltoltese);
        return this;
    }

    public SzamlakDetailsDokumentumok clickOnFeltoltesBtn(){
        waitUtil.waitAndClick(feltoltesBtn);
        return this;
    }

    public SzamlakDetailsDokumentumok clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    public SzamlakDetailsDokumentumok clickOnModositasBtn(){
        waitUtil.waitAndClick(modositasBtn);
        return this;
    }

    //sendKeys
    public SzamlakDetailsDokumentumok enterTextToDokumentumKelteFld(String dokumentumKelte){
        waitUtil.waitAndSendkeys(dokumentumKelteFld, dokumentumKelte);
        return this;
    }

    public SzamlakDetailsDokumentumok enterTextToErvenyessegVegeFld(String ervenyessegVege){
        waitUtil.waitAndSendkeys(ervenyessegVegeFld, ervenyessegVege);
        return this;
    }

    public SzamlakDetailsDokumentumok fajlKivalasztasa(){
        WebElement fajlKivalasztasa = driver.findElement(By.id("upload-input"));
        fajlKivalasztasa.sendKeys("C:\\Users\\ggulacsi\\IdeaProjects\\buildfolio-autotest\\BuildfolioRegressionTesting\\src\\test\\resources\\adasveteli_szerzodes_alairt.docx");
        return this;
    }

    //select
    public SzamlakDetailsDokumentumok selectDokumentumTipusaFromDropDown(String dokumentumTipusa){
        waitUtil.waitAndClick(dokumentumTipusaDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+dokumentumTipusa+"']"));
        return this;
    }

    //assert
    public boolean popUpMegjelenik(String popUpSzovege){
       return waitUtil.popupWindMegjelenik(popUpSzovege);
    }

}
