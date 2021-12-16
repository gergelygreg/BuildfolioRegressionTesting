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
    private final By eszkozokLista = By.xpath("//label[normalize-space()='Eszközök lista']");
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
        waitUtil.waitAndClick(futtatasBtn);
        return this;
    }
   //szerepkörök
    public RiportokPage clickOnSzerepkorDropDown(){
        waitUtil.waitAndClick(szerepkorDropDown);
        return this;
    }

    public RiportokPage selectSzerepkor(String szerepkor){
        clickOnSzerepkorDropDown();
        WebElement szerepk = waitUtil.waitWebElement(By.xpath("//span[contains(text(),'"+szerepkor+"')]"));
        szerepk.click();
        return this;
    }
   //szerepkor ellenőrzés
   public String szerepkorEllenorzesTulajd(){
       return  waitUtil.waitAndGetText(dropDownSzerepkorTulajd);
   }

    public String szerepkorEllenorzesBerlo(){
        return  waitUtil.waitAndGetText(dropDownSzerepkorBerlo);
    }

    public String szerepkorEllenorzesUzem(){
        return  waitUtil.waitAndGetText(dropDownSzerepkorUzem);
    }

    public String szerepkorEllenorzesKezelo(){
        return  waitUtil.waitAndGetText(dropDownSzerepkorKezelo);
    }


    //riport típusa isSelected()?
    public boolean ingatlanokErtekeRadioBtnChecked(){
        return waitUtil.radioBtnIsChecked(ingatlanokErtekeRadioBtn);
    }

    public boolean ingatlanokListaRadioBtnCheckedBerlo(){
        return waitUtil.radioBtnIsChecked(ingatlanokListaRadioBtnBerlo);
    }

    public boolean eszkozokListaRadioBtnCheckedUzem(){
        return waitUtil.radioBtnIsChecked(eszkozokListaRadioBtnUzem);
    }

    public boolean szamlakListaRadioBtnCheckedKezelo(){
        return waitUtil.radioBtnIsChecked(szamlakListaRadioBtnKezelo);
    }

    //fájlformátum isEnabled()? tulajdonos
    public boolean pdfFajlformRadioBtnChecked(){
        return waitUtil.radioBtnIsChecked(pdfRadioBtn);
    }

    //fájlformátum isEnabled()? üzemeltető
    public boolean pdfFajlformRadioBtnCheckedUzem(){
        return waitUtil.radioBtnIsChecked(pdfRadioBtnUzem);
    }

    //fájlformátum isEnabled()? berlo
    public boolean pdfFajlformRadioBtnCheckedBerlo(){
        return waitUtil.radioBtnIsChecked(pdfRadioBtnBerlo);
    }

    //fájlformátum isEnabled()? kezelo
    public boolean pdfFajlformRadioBtnCheckedKezelo(){
        return waitUtil.radioBtnIsChecked(pdfRadioBtnKezelo);
    }

    //megjelenő riport típusok
    public boolean ingatlanErtekeMegjelenik(){
        return waitUtil.elementIsClickable(ingatlanokErteke);
    }

    public boolean eszkozokListaMegjelenik(){
        return waitUtil.elementIsClickable(eszkozokLista);
    }

    public boolean partnerListaMegjelenik(){
        return waitUtil.elementIsClickable(partnerLista);
    }

    public boolean ingatlanokListaMegjelenik(){
        return waitUtil.elementIsClickable(ingatlanokLista);
    }

    public boolean szamlakListaMegjelenik(){
        return waitUtil.elementIsClickable(szamlakLista);
    }

    public boolean szerzodesListaMegjelenik(){
        return waitUtil.elementIsClickable(szerzodesLista);
    }

    //Fájlformátum kiválasztása tulajdonos
    public RiportokPage selectExcelRadioBtn(){
        waitUtil.waitAndClick(excelRadioBtn);
        return this;
    }

    public RiportokPage selectPdfRadioBtn(){
        waitUtil.waitAndClick(pdfRadioBtn);
        return this;
    }

    //fájlformátum kiválasztása bérlo
    public RiportokPage selectExcelRadioBtnBerlo(){
        waitUtil.waitAndClick(excelRadioBtnBerlo);
        return this;
    }

    public RiportokPage selectPdfRadioBtnBerlo(){
        waitUtil.waitAndClick(pdfRadioBtnBerlo);
        return this;
    }
    //fájlformátum kiválasztása üzemeltető

    public RiportokPage selectExcelRadioBtnUzem(){
        waitUtil.waitAndClick(excelRadioBtnUzem);
        return this;
    }

    public RiportokPage selectPdfRadioBtnUzem(){
        waitUtil.waitAndClick(pdfRadioBtnUzem);
        return this;
    }

    //fájlformátum kiválasztása kezelő

       public RiportokPage selectExcelRadioBtnKezelo(){
           waitUtil.waitAndClick(excelRadioBtnKezelo);
           return this;
       }

       public RiportokPage selectPdfRadioBtnKezelo(){
           waitUtil.waitAndClick(pdfRadioBtnKezelo);
           return this;
        }

    //Riport típusának kiválasztása tulajdonos

    public RiportokPage selectEszkozokListaRadioBtn(){
        waitUtil.waitAndClick(eszkozokListaRadioBtn);
        return this;
    }

    public RiportokPage selectPartnerListaRadioBtn(){
        waitUtil.waitAndClick(partnerListaRadioBtn);
        return this;
    }

    public RiportokPage selectIngatlanokListaRadioBtn(){
        waitUtil.waitAndClick(ingatlanokListaRadioBtn);
        return this;
    }

    public RiportokPage selectSzamlakListaRadioBtn(){
        waitUtil.waitAndClick(szamlakListaRadioBtn);
        return this;
    }

    public RiportokPage selectSzerzodesListaRadioBtn(){
        waitUtil.waitAndClick(szerzodesListaRadioBtn);
        return this;
    }

    //riport kiválasztása berlő


    public RiportokPage selectIngatlanokListaRadioBtnBerlo(){
        waitUtil.waitAndClick(ingatlanokListaRadioBtnBerlo);
        return this;
    }

    public RiportokPage selectSzamlakListaRadioBtnBerlo(){
        waitUtil.waitAndClick(szamlakListaRadioBtnBerlo);
        return this;
    }

    public RiportokPage selectSzerzodesListaRadioBtnBerlo(){
        waitUtil.waitAndClick(szerzodesListaRadioBtnBerlo);
        return this;
    }

    //Riport kiválasztása Üzemeltető
    public RiportokPage selectIngatlanokListaRadioBtnUzem(){
        waitUtil.waitAndClick(ingatlanokListaRadioBtnUzem);
        return this;
    }

    public RiportokPage selectSzamlakListaRadioBtnUzem(){
        waitUtil.waitAndClick(szamlakListaRadioBtnUzem);
        return this;
    }

    public RiportokPage selectSzerzodesListaRadioBtnUzem(){
        waitUtil.waitAndClick(szerzodesListaRadioBtnUzem);
        return this;
    }

    //Riport kiválasztása Kezelő

    public RiportokPage selectSzamlakListaRadioBtnKezelo(){
        waitUtil.waitAndClick(szamlakListaRadioBtnKezelo);
        return this;
    }

    public RiportokPage selectSzerzodesListaRadioBtnKezelo(){
        waitUtil.waitAndClick(szerzodesListaRadioBtnKezelo);
        return this;
    }

    //riport letöltése
    public RiportokPage clickOnRiportLetolteseBtn(){
        waitUtil.waitAndClick(riportLetolteseBtn);
        return this;
    }

}
