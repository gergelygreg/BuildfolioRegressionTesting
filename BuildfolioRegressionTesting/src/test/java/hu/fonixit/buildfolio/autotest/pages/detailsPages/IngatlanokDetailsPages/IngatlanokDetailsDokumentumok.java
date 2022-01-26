package hu.fonixit.buildfolio.autotest.pages.detailsPages.IngatlanokDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.xml.crypto.Data;

public class IngatlanokDetailsDokumentumok extends BasePage {
    private final By kepekTab = By.xpath("//a[normalize-space()='Képek']");
    private final By tovabbiakTab = By.xpath("//a[normalize-space()='Továbbiak']");
    //Képek
    private final By ujKepFeltoltese = By.xpath("//button[normalize-space()='Új kép feltöltése']");
    //Új kép feltöltése ablak
    private final By kepTipusaDropDown = By.xpath("//input[@autocomplete='a9872969d25d']");
    private final By kepFeltolteseFld = By.xpath("//input[@id='upload-input']");
    private final By feltoltesBtn = By.xpath("//span[normalize-space()='Feltöltés']");
    private final By megsemBtn = By.xpath("//button[normalize-space()='Mégsem']");
    //Tobábbiak
    private final By ujFajlFeltoltese = By.xpath("//button[normalize-space()='Új fájl feltöltése']");
    //Új dokumentum feltöltése
    private final By dokumentumTipusaDropDown = By.xpath("//input[@autocomplete='aa5d399d6c3b']");
    private final By keletkezesOkaTextArea = By.xpath("//textarea[@placeholder='Nincs megadva']");
    private final By dukumentumKelteDateFld = By.xpath("//app-datepicker-basic[@name='documentCreationDate']//input");
    private final By ervenyessegVegeDateFld = By.xpath("//app-datepicker-basic[@name='documentValidityEnd']//input[@placeholder='Nincs megadva']");
    private final By fajlKivalasztasaFileInput = By.xpath("//input[@id='upload-input']");



    public IngatlanokDetailsDokumentumok(WebDriver driver) {
        super(driver);
    }

    //select
    public IngatlanokDetailsDokumentumok selectKepTipusaFromDropDown(String kepTipusa){
        waitUtil.waitAndClick(kepTipusaDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+kepTipusa+"']"));
        return this;
    }

    public IngatlanokDetailsDokumentumok selectDokumentumTipusaFromDropDown(String dokumentumTipusa){
        waitUtil.waitAndClick(dokumentumTipusaDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+dokumentumTipusa+"']"));
        return this;
    }

    //click
    public IngatlanokDetailsDokumentumok clickOnUjFajlFeltoltese(){
        waitUtil.waitAndClick(ujFajlFeltoltese);
        return this;
    }

    public IngatlanokDetailsDokumentumok clickOnKepekTab(){
        waitUtil.waitAndClick(kepekTab);
        return this;
    }

    public IngatlanokDetailsDokumentumok clickOnTovabbiakTab(){
        waitUtil.waitAndClick(tovabbiakTab);
        return this;
    }

    public IngatlanokDetailsDokumentumok clickOnUjKepFeltolteseBtn(){
        waitUtil.waitAndClick(ujKepFeltoltese);
        return this;
    }

    public IngatlanokDetailsDokumentumok clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    public IngatlanokDetailsDokumentumok clickOnFeltoltesBtn(){
        waitUtil.waitAndClick(feltoltesBtn);
        return this;
    }

    //sendKeys
    public IngatlanokDetailsDokumentumok kepFeltoltese(){
        WebElement kepFeltInputFld = driver.findElement(kepFeltolteseFld);
        kepFeltInputFld.sendKeys("C:\\Users\\ggulacsi\\IdeaProjects\\buildfolio-autotest\\BuildfolioRegressionTesting\\src\\test\\resources\\hotel-palota.jpg");
        return this;
    }

    public IngatlanokDetailsDokumentumok fajlKivalasztasa(){
        WebElement fajlKivalasztasaInputFld = driver.findElement(fajlKivalasztasaFileInput);
        fajlKivalasztasaInputFld.sendKeys("C:\\Users\\ggulacsi\\IdeaProjects\\buildfolio-autotest\\BuildfolioRegressionTesting\\src\\test\\resources\\adasveteli_szerzodes_alairt.docx");
        return this;
    }

    public IngatlanokDetailsDokumentumok enterTextToKeletkezesOkaFld(String keletkezesOka){
        waitUtil.waitAndSendkeys(keletkezesOkaTextArea, keletkezesOka);
        return this;
    }

    public IngatlanokDetailsDokumentumok enterDateToDokumentumKelteFld(String dokumentumKelte){
        waitUtil.waitAndSendkeys(dukumentumKelteDateFld, dokumentumKelte);
        return this;
    }

    public IngatlanokDetailsDokumentumok enterDateToErvenyessegVegeFld(String ervenyessegVegeFld){
        waitUtil.waitAndSendkeys(ervenyessegVegeDateFld, ervenyessegVegeFld);
        return this;
    }
}
