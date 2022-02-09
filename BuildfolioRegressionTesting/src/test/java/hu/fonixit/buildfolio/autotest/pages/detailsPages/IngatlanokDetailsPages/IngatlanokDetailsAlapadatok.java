package hu.fonixit.buildfolio.autotest.pages.detailsPages.IngatlanokDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import hu.fonixit.buildfolio.autotest.objects.UjIngatlanAlapadatok;
import hu.fonixit.buildfolio.autotest.pages.FeladatkezeloUjMunkafolyamatInditasaPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IngatlanokDetailsAlapadatok extends BasePage {
    private final By adatokSzerkeszteseBtn = By.xpath("//button[normalize-space()='Adatok szerkesztése']");
    private final By mentesBtn = By.xpath("//span[normalize-space()='Mentés']");
    private final By megsemBtn = By.xpath("//button[normalize-space()='Mégsem']");
    //input fields
    private final By koltsegHelyAzonFld = By.xpath("//app-text-input[@name='costCenterIdentifier']//input[@placeholder='Nincs megadva']");
    private final By tihaszIdFld = By.xpath("//app-text-input[@name='identifier']//input[@placeholder='Nincs megadva']"); //unique field!!
    private final By emailFld = By.xpath("//app-text-input[@name='email']//input[@placeholder='Nincs megadva']");
    private final By telefonszamFld = By.xpath("//app-text-input[@name='phoneNumber']//input[@placeholder='Nincs megadva']");
    private final By epuletAlapteruleteFld = By.xpath("//app-text-input[@name='buildingArea']//input[@placeholder='Nincs megadva']");
    private final By epuletHasznosTeruleteFld = By.xpath("//app-text-input[@name='usableArea']//input[@placeholder='Nincs megadva']");
    private final By telekAlapteruleteFld = By.xpath("//app-text-input[@name='plotArea']//input[@placeholder='Nincs megadva']");
    private final By ugyfelszolgalatAlapteruleteFld = By.xpath("//app-text-input[@name='customerServiceArea']//input[@placeholder='Nincs megadva']");
    private final By hasznositottBankuzemiTeruletFld = By.xpath("//app-text-input[@name='bankingArea']//input[@placeholder='Nincs megadva']");
    private final By felelosVezetoFld = By.xpath("//app-text-input[@name='responsibleManagerName']//input[@placeholder='Nincs megadva']");
    private final By felelosVezTelSzamaFld = By.xpath("//app-text-input[@name='responsibleManagerPhone']//input[@placeholder='Nincs megadva']");
    private final By kulcsorzoFld = By.xpath("//app-text-input[@name='keyKeeperName']//input[@placeholder='Nincs megadva']");
    private final By kulcsorzoTelSzamaFld = By.xpath("//app-text-input[@name='keyKeeperPhone']//input[@placeholder='Nincs megadva']");
    //button
    private final By inaktivalasBtn = By.xpath("//button[.=' Inaktiválás ']");
    //ingatlan inaktiválás
    private final By okBtn = By.xpath("//button[.='Igen']");

    public IngatlanokDetailsAlapadatok(WebDriver driver){
        super(driver);
    }

    //click
    public IngatlanokDetailsAlapadatok clickInIgenBtn(){
        waitUtil.waitAndClick(okBtn);
        return this;
    }

    public IngatlanokDetailsAlapadatok clickOnAdatokSzerkeszteseBtn(){
        waitUtil.waitAndClick(adatokSzerkeszteseBtn);
        return this;
    }

    public IngatlanokDetailsAlapadatok clickOnMentesBtnBtn(){
        waitUtil.waitAndClick(mentesBtn);
        return this;
    }

    public IngatlanokDetailsAlapadatok clickOnMegsemBtnBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    public IngatlanokDetailsAlapadatok clickOnInaktivalasBtn(){
        waitUtil.waitAndClick(inaktivalasBtn);
        return this;
    }

    //enter text to field
    public IngatlanokDetailsAlapadatok enterTextToKoltsegHelyAzonFld(String koltsegHelyAzon){
        waitUtil.waitAndSendkeys(koltsegHelyAzonFld, koltsegHelyAzon);
        return this;
    }

    public IngatlanokDetailsAlapadatok enterTextToTihaszIdFld(String tihaszId){
        waitUtil.waitAndSendkeys(tihaszIdFld, tihaszId);
        return this;
    }

    public IngatlanokDetailsAlapadatok enterTextToEmailFld(String email){
        waitUtil.waitAndSendkeys(emailFld, email);
        return this;
    }

    public IngatlanokDetailsAlapadatok enterTextToTelefonszamFld(String telefonszam){
        waitUtil.waitAndSendkeys(telefonszamFld, telefonszam);
        return this;
    }

    public IngatlanokDetailsAlapadatok enterTextToEpuletAlapterFld(String epuletAlapTer){
        waitUtil.waitAndSendkeys(epuletAlapteruleteFld, epuletAlapTer);
        return this;
    }

    public IngatlanokDetailsAlapadatok enterTextToEpuletHasznosTerFld(String epuletHasznosTer){
        waitUtil.waitAndSendkeys(epuletHasznosTeruleteFld, epuletHasznosTer);
        return this;
    }

    public IngatlanokDetailsAlapadatok enterTextToTelekAlapTerFld(String telekAlapter){
        waitUtil.waitAndSendkeys(telekAlapteruleteFld, telekAlapter);
        return this;
    }

    public IngatlanokDetailsAlapadatok enterTextToUgyfelkiszAlapTerFld(String ugyfelkiszolgalAlapTer){
        waitUtil.waitAndSendkeys(ugyfelszolgalatAlapteruleteFld, ugyfelkiszolgalAlapTer);
        return this;
    }

    public IngatlanokDetailsAlapadatok enterTextToHasznositottBankuzemiTerFld(String hasznositottBankuzemTer){
        waitUtil.waitAndSendkeys(hasznositottBankuzemiTeruletFld, hasznositottBankuzemTer);
        return this;
    }

    public IngatlanokDetailsAlapadatok enterTextToFelelosVezFld(String felelosVezeto){
        waitUtil.waitAndSendkeys(felelosVezetoFld, felelosVezeto);
        return this;
    }

    public IngatlanokDetailsAlapadatok enterTextToFelelosVezTelSzamaFld(String felelosVezTelSzama){
        waitUtil.waitAndSendkeys(felelosVezTelSzamaFld, felelosVezTelSzama);
        return this;
    }

    public IngatlanokDetailsAlapadatok enterTextToKulcsorzoFld(String kulcsorzo){
        waitUtil.waitAndSendkeys(kulcsorzoFld, kulcsorzo);
        return this;
    }
    public IngatlanokDetailsAlapadatok enterTextToKulcsorzoTelSzamaFld(String kulcsorzoTelSzama){
        waitUtil.waitAndSendkeys(kulcsorzoTelSzamaFld, kulcsorzoTelSzama);
        return this;
    }

    public IngatlanokDetailsAlapadatok setUjIngatlanAlapadatok(UjIngatlanAlapadatok ujIngatlanAlapadatok){
        return enterTextToKoltsegHelyAzonFld(ujIngatlanAlapadatok.getKoltseghelyAzonosito()).
                enterTextToEmailFld(ujIngatlanAlapadatok.getEmail()).
                enterTextToTelefonszamFld(ujIngatlanAlapadatok.getTelefonszam()).
                enterTextToEpuletAlapterFld(ujIngatlanAlapadatok.getEpuletAlapterulete()).
                enterTextToEpuletHasznosTerFld(ujIngatlanAlapadatok.getEpuletHaszonsTerulete()).
                enterTextToTelekAlapTerFld(ujIngatlanAlapadatok.getTelekAlapterulete()).
                enterTextToUgyfelkiszAlapTerFld(ujIngatlanAlapadatok.getUgyfelkiszolgalasAlapterulete()).
                enterTextToHasznositottBankuzemiTerFld(ujIngatlanAlapadatok.getHasznositottBankuzemiTerulet()).
                enterTextToFelelosVezFld(ujIngatlanAlapadatok.getFelelosVezeto()).
                enterTextToFelelosVezTelSzamaFld(ujIngatlanAlapadatok.getFelelosVezetoTelefonszama()).
                enterTextToKulcsorzoFld(ujIngatlanAlapadatok.getKulcsorzo()).
                enterTextToKulcsorzoTelSzamaFld(ujIngatlanAlapadatok.getKulcsorzoTelefonszama());
    }

    //scroll up
    public IngatlanokDetailsAlapadatok scrollUp() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        return this;
    }

    //assert
    public boolean ingatlanAdatlaponAllunk(String ingatlanNeve){
        boolean ertek;
        try {
            waitUtil.waitForVisibility(By.xpath("//span[.=' "+ingatlanNeve+" ']"));
            ertek = false;
        }catch (Exception e){
            ertek =true;
        }
        return ertek;
    }

    public boolean popupSzovegMegjelenik(String popUpSzoveg){
        return waitUtil.popupWindMegjelenik(popUpSzoveg);
    }

}
