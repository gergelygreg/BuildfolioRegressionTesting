package hu.fonixit.buildfolio.autotest.pages.detailsPages.IngatlanokDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import hu.fonixit.buildfolio.autotest.objects.UjIngatlanAlapadatok;
import org.openqa.selenium.By;
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

    public IngatlanokDetailsAlapadatok(WebDriver driver){
        super(driver);
    }

    //click
    public IngatlanokDetailsAlapadatok clickOnAdatokSzerkeszteseBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(adatokSzerkeszteseBtn)).click();
        return this;
    }

    public IngatlanokDetailsAlapadatok clickOnMentesBtnBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(mentesBtn)).click();
        return this;
    }

    public IngatlanokDetailsAlapadatok clickOnMegsemBtnBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(megsemBtn)).click();
        return this;
    }

    //enter text to field
    public IngatlanokDetailsAlapadatok enterTextToKoltsegHelyAzonFld(String koltsegHelyAzon){
        wait.until(ExpectedConditions.visibilityOfElementLocated(koltsegHelyAzonFld)).sendKeys(koltsegHelyAzon);
        return this;
    }

    public IngatlanokDetailsAlapadatok enterTextToTihaszIdFld(String tihaszId){
        wait.until(ExpectedConditions.visibilityOfElementLocated(tihaszIdFld)).sendKeys(tihaszId);
        return this;
    }

    public IngatlanokDetailsAlapadatok enterTextToEmailFld(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFld)).sendKeys(email);
        return this;
    }

    public IngatlanokDetailsAlapadatok enterTextToTelefonszamFld(String telefonszam){
        wait.until(ExpectedConditions.visibilityOfElementLocated(telefonszamFld)).sendKeys(telefonszam);
        return this;
    }

    public IngatlanokDetailsAlapadatok enterTextToEpuletAlapterFld(String epuletAlapTer){
        wait.until(ExpectedConditions.visibilityOfElementLocated(epuletAlapteruleteFld)).sendKeys(epuletAlapTer);
        return this;
    }

    public IngatlanokDetailsAlapadatok enterTextToEpuletHasznosTerFld(String epuletHasznosTer){
        wait.until(ExpectedConditions.visibilityOfElementLocated(epuletHasznosTeruleteFld)).sendKeys(epuletHasznosTer);
        return this;
    }

    public IngatlanokDetailsAlapadatok enterTextToTelekAlapTerFld(String telekAlapter){
        wait.until(ExpectedConditions.visibilityOfElementLocated(telekAlapteruleteFld)).sendKeys(telekAlapter);
        return this;
    }

    public IngatlanokDetailsAlapadatok enterTextToUgyfelkiszAlapTerFld(String ugyfelkiszolgalAlapTer){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ugyfelszolgalatAlapteruleteFld)).sendKeys(ugyfelkiszolgalAlapTer);
        return this;
    }

    public IngatlanokDetailsAlapadatok enterTextToHasznositottBankuzemiTerFld(String hasznositottBankuzemTer){
        wait.until(ExpectedConditions.visibilityOfElementLocated(hasznositottBankuzemiTeruletFld)).sendKeys(hasznositottBankuzemTer);
        return this;
    }

    public IngatlanokDetailsAlapadatok enterTextToFelelosVezFld(String koltsegHelyAzon){
        wait.until(ExpectedConditions.visibilityOfElementLocated(felelosVezetoFld)).sendKeys(koltsegHelyAzon);
        return this;
    }

    public IngatlanokDetailsAlapadatok enterTextToFelelosVezTelSzamaFld(String felelosVezTelSzama){
        wait.until(ExpectedConditions.visibilityOfElementLocated(felelosVezTelSzamaFld)).sendKeys(felelosVezTelSzama);
        return this;
    }

    public IngatlanokDetailsAlapadatok enterTextToKulcsorzoFld(String kulcsOrzo){
        wait.until(ExpectedConditions.visibilityOfElementLocated(kulcsorzoFld)).sendKeys(kulcsOrzo);
        return this;

    }
    public IngatlanokDetailsAlapadatok enterTextToKulcsorzoTelSzamaFld(String kulcsorzoTelSzama){
        wait.until(ExpectedConditions.visibilityOfElementLocated(kulcsorzoTelSzamaFld)).sendKeys(kulcsorzoTelSzama);
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

}
