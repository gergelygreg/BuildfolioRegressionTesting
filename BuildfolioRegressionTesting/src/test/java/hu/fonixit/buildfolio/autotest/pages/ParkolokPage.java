package hu.fonixit.buildfolio.autotest.pages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import hu.fonixit.buildfolio.autotest.objects.UjFelhasznalo;
import hu.fonixit.buildfolio.autotest.objects.UjParkolo;
import hu.fonixit.buildfolio.autotest.utils.AttributeUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParkolokPage extends BasePage {
    private final By ujParkoloFelveteleBtn = By.xpath("(//button[normalize-space()='Új parkoló felvétele'])[1]");
    private final By parkolokSzoveg = By.cssSelector("h3[class='ng-tns-c156-1']");
    //Új parkoló felvétele ablak unique fld-s
    private final By parkoloMegnFld = By.xpath("//app-text-input[@name='parkingLotName']//input[@placeholder='Nincs megadva']");
    private final By azonositoFld = By.xpath("//app-text-input[@name='identifier']//input[@placeholder='Nincs megadva']");
    //Új parkoló felvétele ablak
    private final By parkoloTipDropDown = By.xpath("(//input[@role='combobox'])[2]");
    private final By kozteruletTipDropDown = By.xpath("(//input[@role='combobox'])[3]");
    private final By teruletFld = By.xpath("//app-text-input[@name='area']//input[@placeholder='Nincs megadva']");
    private final By irSzamFld = By.xpath("//app-text-input[@name='postCode']//input[@placeholder='Nincs megadva']");
    private final By varosFld = By.xpath("//app-text-input[@name='city']//input[@placeholder='Nincs megadva']");
    private final By kozteruletNeveFld = By.xpath("//app-text-input[@name='publicPlace']//input[@placeholder='Nincs megadva']");
    private final By hazszamFld = By.xpath("//app-text-input[@name='houseNumber']//input[@placeholder='Nincs megadva']");
    private final By hrszFld = By.xpath("//app-text-input[@name='topographicalNumber']//input[@placeholder='Nincs megadva']");
    private final By felvetelBtn = By.xpath("//span[normalize-space()='Felvétel']");
    private final By megseBtn = By.xpath("//button[normalize-space()='Mégsem']");

    public ParkolokPage(WebDriver driver){
        super(driver);
    }


    public boolean parkolokSzovegMegj(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(parkolokSzoveg)).isDisplayed();
    }

    //click
    public ParkolokPage clickOnMegseBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(megseBtn)).click();
        return this;
    }

    public ParkolokPage clickOnFelvetelBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(felvetelBtn)).click();
        return this;
    }

    public boolean felvetelBtnNemKattinthato() {
        Boolean eredm = false;
        WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Felvétel']")));
        try {
            String attributeName = elem.getAttribute("disabled");
            if(attributeName != null){
                eredm = true;
        }
    }
        catch (Exception e){}
        return eredm;
    }


   /* public boolean asd(){
        WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-text-input[@name='guardAccessMode']//input[@placeholder='Nincs megadva']")));
        Boolean ertek = AttributeUtils.isAttribtuePresent(elem,"disabled");
        return ertek;
    }*/

    public  ParkolokPage clickOnUjParkoloFelveteleBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(ujParkoloFelveteleBtn)).click();
        return this;
    }

    //sendKeys
    public ParkolokPage enterParkoloMegn(String parkoloMegn){
        wait.until(ExpectedConditions.visibilityOfElementLocated(parkoloMegnFld)).sendKeys(parkoloMegn);
        return this;
    }

    public ParkolokPage selectParkoloTipFromDropDown(String parkoloTip){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@role='combobox'])[2]"))).sendKeys(parkoloTip);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='"+parkoloTip+"']"))).click();
        return this;
    }

    public ParkolokPage enterTerulet(String terulet){
        wait.until(ExpectedConditions.visibilityOfElementLocated(teruletFld)).sendKeys(terulet);
        return this;
    }

    public ParkolokPage enterIrSzam(String irSzam){
        wait.until(ExpectedConditions.visibilityOfElementLocated(irSzamFld)).sendKeys(irSzam);
        return this;
    }

    public ParkolokPage enterVaros(String varos){
        wait.until(ExpectedConditions.visibilityOfElementLocated(varosFld)).sendKeys(varos);
        return this;
    }

    public ParkolokPage enterKozteruletNeve(String kozteruletNeve){
        wait.until(ExpectedConditions.visibilityOfElementLocated(kozteruletNeveFld)).sendKeys(kozteruletNeve);
        return this;
    }

    public ParkolokPage selectKoztTipFromDropDown(String kozterTip){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@role='combobox'])[3]"))).sendKeys(kozterTip);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='"+kozterTip+"']"))).click();
        return this;
    }

    public ParkolokPage enterHazszam(String hazSzam){
        wait.until(ExpectedConditions.visibilityOfElementLocated(hazszamFld)).sendKeys(hazSzam);
        return this;
    }

    public ParkolokPage enterAzonosito(String azonosito){
        wait.until(ExpectedConditions.visibilityOfElementLocated(azonositoFld)).sendKeys(azonosito);
        return this;
    }

    public ParkolokPage enterHrsz(String hrsz){
        wait.until(ExpectedConditions.visibilityOfElementLocated(hrszFld)).sendKeys(hrsz);
        return this;
    }

    public String felvettParkoloMegjAListaba(){
      return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[1]//td[1]"))).getText();
    }


    //setting új parkoló
        public ParkolokPage setUjParkolo(UjParkolo ujParkolo){
            return selectParkoloTipFromDropDown(ujParkolo.getParkoloTipusa()).
                    enterTerulet(ujParkolo.getTerulet()).
                    enterIrSzam(ujParkolo.getIrSzam()).
                    enterVaros(ujParkolo.getVaros()).
                    enterKozteruletNeve(ujParkolo.getKozteruletNeve()).
                    selectKoztTipFromDropDown(ujParkolo.getKozteruletTipusa()).
                    enterHazszam(ujParkolo.getHazszam()).
                    enterHrsz(ujParkolo.getHrsz());
        }

    public ParkolokPage clickOnListaElsoParkolo(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[1]//td[1]"))).click();
        return this;
    }

  //assertions
  public boolean azonositoElemMegjelenik(String azon){
      return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[1][contains(text(), '"+azon+"')]"))).isDisplayed();
  }

    public boolean parkMegnevElemMegjelenik(String parkMegn){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[2][contains(text(), '"+parkMegn+"')]"))).isDisplayed();
    }

    public boolean tipusElemMegjelenik(String tipus){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[3][contains(text(), '"+tipus+"')]"))).isDisplayed();
    }

    public boolean iranyitoszamElemMegjelenik(String iranyitoszam){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[4][contains(text(), '"+iranyitoszam+"')]"))).isDisplayed();
    }

    public boolean varosMegjelenik(String varos){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[4][contains(text(), '"+varos+"')]"))).isDisplayed();
    }

    public boolean koztNeveMegjelenik(String koztNeve){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[4][contains(text(), '"+koztNeve+"')]"))).isDisplayed();
    }

    public boolean hrszMegjelenik(String hrsz){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[5][contains(text(), '"+hrsz+"')]"))).isDisplayed();
    }

    public Integer parkolohelyekSzama(){
        int sum=0;
        String e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[7]"))).getText();
        ArrayList<String> parkolohelyek = new ArrayList <String>(Arrays.asList(e.split(",")));
        int[] parkolohelyekSzama = new int[parkolohelyek.size()];
        int i = 0;
        for (String szam :parkolohelyek) {
            parkolohelyekSzama[i++] = Integer.parseInt(szam);
        }

        for (int szam: parkolohelyekSzama)
        {
          sum += szam;
        }

        return sum;
    }

    public Integer parkolohelyekSzamaDetails(){ //Még SZERKESZTÉS ALATT
        int sum = 0;
        String e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[1]"))).getText();
        ArrayList<String> parkolohelyek = new ArrayList <String>(Arrays.asList(e.split(",")));
        Select oldalmeret = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("select[class='ng-valid ng-touched ng-dirty']"))));
        oldalmeret.selectByVisibleText("100");
        for(int i = 1; i <= parkolohelyek.size(); i++ ) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[" + i + "]//td[1]"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Parkolóhelyek"))).click();
            String nincsMegjAdat = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Nincs megjeleníthető adat.')]"))).getText();
            //for
            if (nincsMegjAdat != null) {
                String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[7]"))).getText();
                ArrayList<String> parkolohely = new ArrayList<String>(Arrays.asList(e.split(",")));
                int[] parkolohelyekSzama = new int[parkolohelyek.size()];
                int j = 0;
                for (String szam : parkolohely) {
                    parkolohelyekSzama[j++] = Integer.parseInt(szam);
                }

                for (int szam : parkolohelyekSzama) {
                    sum += szam;
                }
            } else {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='no-link back-btn ng-star-inserted']"))).click();
            }
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='no-link back-btn ng-star-inserted']"))).click();
        }


        return sum;
    }

   /* public Boolean parkolohelySzerkesztese(){
      //  try catch a "Nincs megjeleníthető adat."-ra

    }*/



}
