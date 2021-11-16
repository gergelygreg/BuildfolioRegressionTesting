package hu.fonixit.buildfolio.autotest.pages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RiportokPage extends BasePage {
    //szerepkör
    private final By szerepkorDropDown = By.xpath("//span[text()=' Tulajdonos ']");
    private final By futtatasBtn = By.xpath("//span[normalize-space()='Futtatás']");
    private final By dropDownSzerepkorTulajd = By.xpath("//span[contains(text(),'Tulajdonos')]");
    private final By dropDownSzerepkorBerlo = By.xpath("//span[contains(text(),'Bérlő')]");
    private final By dropDownSzerepkorUzem = By.xpath("//span[contains(text(),'Üzemeltető')]");
    private final By dropDownSzerepkorKezelo = By.xpath("//span[contains(text(),'Kezelő')]");

    //riportok típusa
    private final By ingatlanokErteke = By.xpath("//label[normalize-space()='Ingatlanok értéke']");
    private final By ezskozokLista = By.xpath("//label[normalize-space()='Eszközök lista']");
    private final By partnerLista = By.xpath("//label[normalize-space()='Partner lista']");
    private final By ingatlanokLista = By.xpath("//label[normalize-space()='Ingatlanok lista']");
    private final By szamlakLista = By.xpath("//label[normalize-space()='Számlák lista']");
    private final By szerzodesLista = By.xpath("//label[contains(text(),'Szerződés lista')]");
    //radio buttonok tulajdonos
    private final By ingatlanokErtekeRadioBtn = By.xpath("//div[@class='radio-group ng-untouched ng-pristine ng-valid']//div[1]");
    private final By eszkozokListaRadioBtn = By.xpath("//form[@class='ng-untouched ng-pristine ng-valid']//div[2]");
    private final By partnerListaRadioBtn = By.xpath("//body//app-root//div[@class='row']//div[@class='row']//div[@class='row']//div[3]");
    private final By ingatlanokListaRadioBtn = By.xpath("//div[@class='radio-group ng-untouched ng-pristine ng-valid']");
    private final By szamlakListaRadioBtn = By.xpath("//body//app-root//div[5]");
    private final By szerzodesListaRadioBtn = By.xpath("//body//app-root//div[6]");
    //radio buttonok bérlő
    private final By ingatlanokListaRadioBtnBerlo = By.xpath("//div[@class='radio-group ng-untouched ng-pristine ng-valid']");
    private final By szamlakListaRadioBtnBerlo = By.xpath("(//div[@class='radio-button mr-3'])[2]");
    private final By szerzodesListaRadioBtnBerlo = By.xpath("(//div[@class='radio-button mr-3'])[3]");
    //radio buttonok üzemeltető
    private final By ingatlanokListaRadioBtnUzem = By.xpath("(//div[@class='radio-button mr-3'])[2]");
    private final By szamlakListaRadioBtnUzem = By.xpath("(//div[@class='radio-button mr-3'])[3]");
    private final By szerzodesListaRadioBtnUzem = By.xpath("(//div[@class='radio-button mr-3'])[4]");
    private final By eszkozokListaRadioBtnUzem = By.xpath("(//div[@class='radio-button mr-3'])[1]");
    //radio buttonok kezelő
    private final By szamlakListaRadioBtnKezelo = By.xpath("//label[text()=' Számlák lista ']");
    private final By szerzodesListaRadioBtnKezelo = By.xpath("//label[text()=' Szerződés lista ']");
    //fájlformátum tulajdonos
    private final By pdfRadioBtn = By.xpath("(//div[@class='radio-button mr-3'])[7]");
    private final By excelRadioBtn = By.xpath("//body//app-root//div[@class='transition']//div[@class='transition']//div[@class='row']//div[2]");
    //fájlformátum bérlő
    private final By pdfRadioBtnBerlo = By.xpath("(//div[@class='radio-button mr-3'])[4]");
    private final By excelRadioBtnBerlo = By.xpath("(//div[@class='radio-button mr-3'])[5]");
    //fájlformátum üzemeltető
    private final By pdfRadioBtnUzem = By.xpath("(//div[@class='radio-button mr-3'])[5]");
    private final By excelRadioBtnUzem = By.xpath("(//div[@class='radio-button mr-3'])[6]");
    //fájlformátum kezelő
    private final By pdfRadioBtnKezelo = By.xpath("(//div[@class='radio-button mr-3'])[3]");
    private final By excelRadioBtnKezelo = By.xpath("(//div[@class='radio-button mr-3'])[4]");

    //riport futtatása ablak
    private final By riportLetolteseBtn = By.xpath("//button[normalize-space()='Riport letöltése']");

    public RiportokPage (WebDriver driver){
        super(driver);
    }



    //futtatás gomb
    public RiportokPage clickOnFuttatasBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(futtatasBtn)).click();
        return this;
    }
   //szerepkörök
    public RiportokPage clickOnSzerepkorDropDown(){
        wait.until(ExpectedConditions.elementToBeClickable(szerepkorDropDown)).click();
        return this;
    }

    public RiportokPage selectSzerepkor(String szerepkor){
        clickOnSzerepkorDropDown();
        WebElement szerepk = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+szerepkor+"')]")));
        szerepk.click();
        return this;
    }
   //szerepkor ellenőrzés
   public String szerepkorEllenorzesTulajd(){
       return  wait.until(ExpectedConditions.visibilityOfElementLocated(dropDownSzerepkorTulajd)).getText();
   }

    public String szerepkorEllenorzesBerlo(){
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(dropDownSzerepkorBerlo)).getText();
    }

    public String szerepkorEllenorzesUzem(){
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(dropDownSzerepkorUzem)).getText();
    }

    public String szerepkorEllenorzesKezelo(){
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(dropDownSzerepkorKezelo)).getText();
    }


    //riport típusa isSelected()?
    public boolean ingatlanokErtekeRadioBtnChecked(){
        return wait.until(ExpectedConditions.elementToBeClickable(ingatlanokErtekeRadioBtn)).isEnabled();
    }

    public boolean ingatlanokListaRadioBtnCheckedBerlo(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ingatlanokListaRadioBtnBerlo)).isEnabled();
    }

    public boolean eszkozokListaRadioBtnCheckedUzem(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(eszkozokListaRadioBtnUzem)).isEnabled();
    }

    public boolean szamlakListaRadioBtnCheckedKezelo(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(szamlakListaRadioBtnKezelo)).isEnabled();
    }

    //fájlformátum isEnabled()? tulajdonos
    public boolean pdfFajlformRadioBtnChecked(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pdfRadioBtn)).isEnabled();
    }

    //fájlformátum isEnabled()? üzemeltető
    public boolean pdfFajlformRadioBtnCheckedUzem(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pdfRadioBtnUzem)).isEnabled();
    }

    //fájlformátum isEnabled()? berlo
    public boolean pdfFajlformRadioBtnCheckedBerlo(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pdfRadioBtnBerlo)).isEnabled();
    }

    //fájlformátum isEnabled()? kezelo
    public boolean pdfFajlformRadioBtnCheckedKezelo(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pdfRadioBtnBerlo)).isEnabled();
    }

    //megjelenő riport típusok
    public boolean ingatlanErtekeMegjelenik(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ingatlanokErteke)).isDisplayed();
    }

    public boolean eszkozokListaMegjelenik(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ezskozokLista)).isDisplayed();
    }

    public boolean partnerListaMegjelenik(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(partnerLista)).isDisplayed();
    }

    public boolean ingatlanokListaMegjelenik(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ingatlanokLista)).isDisplayed();
    }

    public boolean szamlakListaMegjelenik(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(szamlakLista)).isDisplayed();
    }

    public boolean szerzodesListaMegjelenik(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(szerzodesLista)).isDisplayed();
    }

    //Fájlformátum kiválasztása tulajdonos
    public RiportokPage selectExcelRadioBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(excelRadioBtn)).click();
        return this;
    }

    public RiportokPage selectPdfRadioBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(pdfRadioBtn)).click();
        return this;
    }

    //fájlformátum kiválasztása bérlo
    public RiportokPage selectExcelRadioBtnBerlo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(excelRadioBtnBerlo)).click();
        return this;
    }

    public RiportokPage selectPdfRadioBtnBerlo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(pdfRadioBtnBerlo)).click();
        return this;
    }
    //fájlformátum kiválasztása üzemeltető

    public RiportokPage selectExcelRadioBtnUzem(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(excelRadioBtnUzem)).click();
        return this;
    }

    public RiportokPage selectPdfRadioBtnUzem(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(pdfRadioBtnUzem)).click();
        return this;
    }

    //fájlformátum kiválasztása kezelő

       public RiportokPage selectExcelRadioBtnKezelo(){
           wait.until(ExpectedConditions.visibilityOfElementLocated(excelRadioBtnKezelo)).click();
            return this;
       }

       public RiportokPage selectPdfRadioBtnKezelo(){
            wait.until(ExpectedConditions.visibilityOfElementLocated(pdfRadioBtnKezelo)).click();
            return this;
        }

    //Riport típusának kiválasztása tulajdonos

    public RiportokPage selectEszkozokListaRadioBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(eszkozokListaRadioBtn)).click();
        return this;
    }

    public RiportokPage selectPartnerListaRadioBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(partnerListaRadioBtn)).click();
        return this;
    }

    public RiportokPage selectIngatlanokListaRadioBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ingatlanokListaRadioBtn)).click();
        return this;
    }

    public RiportokPage selectSzamlakListaRadioBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(szamlakListaRadioBtn)).click();
        return this;
    }

    public RiportokPage selectSzerzodesListaRadioBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(szerzodesListaRadioBtn)).click();
        return this;
    }

    //riport kiválasztása berlő


    public RiportokPage selectIngatlanokListaRadioBtnBerlo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ingatlanokListaRadioBtnBerlo)).click();
        return this;
    }

    public RiportokPage selectSzamlakListaRadioBtnBerlo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(szamlakListaRadioBtnBerlo)).click();
        return this;
    }

    public RiportokPage selectSzerzodesListaRadioBtnBerlo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(szerzodesListaRadioBtnBerlo)).click();
        return this;
    }

    //Riport kiválasztása Üzemeltető
    public RiportokPage selectIngatlanokListaRadioBtnUzem(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ingatlanokListaRadioBtnUzem)).click();
        return this;
    }

    public RiportokPage selectSzamlakListaRadioBtnUzem(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(szamlakListaRadioBtnUzem)).click();
        return this;
    }

    public RiportokPage selectSzerzodesListaRadioBtnUzem(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(szerzodesListaRadioBtnUzem)).click();
        return this;
    }

    //Riport kiválasztása Kezelő

    public RiportokPage selectSzamlakListaRadioBtnKezelo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(szamlakListaRadioBtnKezelo)).click();
        return this;
    }

    public RiportokPage selectSzerzodesListaRadioBtnKezelo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(szerzodesListaRadioBtnKezelo)).click();
        return this;
    }

    //riport letöltése
    public RiportokPage clickOnRiportLetolteseBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(riportLetolteseBtn)).click();
        return this;
    }

}
