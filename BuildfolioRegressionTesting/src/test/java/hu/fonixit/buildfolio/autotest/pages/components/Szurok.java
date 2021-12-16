package hu.fonixit.buildfolio.autotest.pages.components;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Szurok extends BasePage {
    //gombok
    private final By szurokBtn = By.xpath("//span[contains(text(), 'Szűrők')]");
    private final By keresesBtn = By.xpath("//button[contains(text(), 'Keresés')]");
    private final By szurokTorleseBtn = By.xpath("//button[contains(text(), 'Szűrők törlése')]");
    //Felhasználók
    private final By nevFld = By.cssSelector("input[placeholder='Név']");
    private final By emailFld = By.xpath("//input[@placeholder='Email']");
    private final By szervezetDropDown = By.xpath("(//input[@role='combobox'])[1]");
    private final By szerepkorDropDown = By.xpath("(//input[@role='combobox'])[2]");
    //Szervezetek
    private final By szervezetAzonFld = By.xpath("//input[@placeholder='Szervezet azonosító']");
    private final By kapcsolodoPartnDropDown = By.xpath("//input[@role='combobox']");
    //Parkolók
    private final By azonositoFld = By.xpath("//input[@placeholder='Azonosító']");
    private final By parkoloMegnFld = By.xpath("(//input[@placeholder='Parkoló megnevezése'])[1]");
    private final By tipusDropDown = By.xpath("//input[@role='combobox']");
    private final By iranyitoszamFld = By.xpath("//input[@placeholder='Irányítószám']");
    private final By varosFld = By.xpath("//input[@placeholder='Város']");
    private final By koztNeveFld = By.xpath("//input[@placeholder='Közterület neve']");
    private final By hrszFld = By.xpath("//input[@placeholder='Helyrajzi szám']");
    //Parkolók-parkolóhelyek
    private final By azonositoFldParkolohely = By.xpath("//input[@placeholder='Azonosító']");
    private final By parkolohelyTipusaDropDown = By.xpath("//div[.='Parkolóhely típusa']//input");
    //Parkolok-ingatlanok
    private final By megnevezesFld = By.xpath("//input[@placeholder='Megnevezés']");
    private final By jellegDropDown = By.xpath("//app-buildfolio-select[@name='natureCode']//div//ng-select//div//div//div//input");
    private final By iranyitoszamFldIng = By.xpath("//input[@placeholder='Irányítószám']");
    private final By varosFldIng = By.xpath("//input[@placeholder='Város']");
    private final By koztNeveFldIng = By.xpath("//input[@placeholder='Közterület neve']");
    private final By hrszFldIng = By.xpath("//input[@placeholder='HRSZ']");
    private final By hasznDropDown = By.xpath("//app-buildfolio-select[@name='utilizationCode']//div//ng-select//div//div//div//input");
    private final By bankUzemCeluDropDown = By.xpath("//app-buildfolio-select[@name='usedAsBank']//div//ng-select//div//div//div//input");
    //Partnerek
    private final By nevFldPartn = By.xpath("//input[@placeholder='Név']");
    private final By cegjegyzekSzamFldPartn = By.xpath("//input[@placeholder='Cégjegyzékszám']");
    private final By iranyitoszamFldPartn = By.xpath("//input[@placeholder='Irányítószám']");
    private final By varosFldPartn = By.xpath("//input[@placeholder='Város']");
    private final By kozteruletneveFldPartn = By.xpath("//input[@placeholder='Közterület neve']");


    public Szurok(WebDriver driver){
        super(driver);
    }

    //Parkolók adatlap - ingatlanok
    public Szurok enterToMegnevezesFldIng(String ingatlanNeve){
        waitUtil.waitAndSendkeys(megnevezesFld, ingatlanNeve);
        return this;
    }

    public Szurok selectElemFromJellegDropDownIng(String jelleg){
        waitUtil.waitAndClick(jellegDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+jelleg+"']"));
        return this;
    }

    public Szurok enterToIranyitoszamFldIng(String iranyitoszam){
        waitUtil.waitAndSendkeys(iranyitoszamFldIng, iranyitoszam);
        return this;
    }

    public Szurok enterToVarosFldIng(String varos){
        waitUtil.waitAndSendkeys(varosFldIng, varos);
        return this;
    }

    public Szurok enterToKozteruletNeveFldIng(String koztNeve){
        waitUtil.waitAndSendkeys(koztNeveFldIng, koztNeve);
        return this;
    }

    public Szurok hrszFldIng(String HRSZ){
        waitUtil.waitAndSendkeys(hrszFldIng, HRSZ);
        return this;
    }

    public Szurok selectElemFromHasznositasDropDownIng(String hasznositas){
        waitUtil.waitAndClick(hasznDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+hasznositas+"']"));
        return this;
    }

    public Szurok selectElemFromBankuzemiCeluDropDownIng(String bankuzemiCelu){
        waitUtil.waitAndClick(bankUzemCeluDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+bankuzemiCelu+"']"));
        return this;
    }


    //szervezetek
    public Szurok enterSzervezetAzonFld(String szervezetAzon){
        waitUtil.waitAndSendkeys(szervezetAzonFld, szervezetAzon);
        return this;
    }

    public Szurok clickOnKapcsolodoPartnDropDown(){
        waitUtil.waitAndClick(kapcsolodoPartnDropDown);
        return this;
    }

    public Szurok kapcsolodoPartnerKivalasztasaFromKapcsolodoPartnDropDown(String kapcsolodoPartn){
        clickOnKapcsolodoPartnDropDown();
        waitUtil.waitAndClick(By.xpath("//div[@title='"+kapcsolodoPartn+"']"));
        return this;
    }

   //gombok
    public Szurok clickOnSzurokBtn(){
        waitUtil.waitAndClick(szurokBtn);
        return this;
    }

    public Szurok clickOnKeresesBtn(){
        waitUtil.waitAndClick(keresesBtn);
        return this;
    }

    public Szurok clickOnSzurokTorleseBtn(){
        waitUtil.waitAndClick(szurokTorleseBtn);
        return this;
    }

    //felhasználók
    public Szurok enterNev(String nev){
        waitUtil.waitAndSendkeys(nevFld, nev);
        return this;
    }

    public Szurok enterEmail(String email){
        waitUtil.waitAndSendkeys(emailFld, email);
        return this;
    }

    public Szurok selectSzervezetFromSzervezetDropdDown(String szervezet){
        waitUtil.waitAndClick(szervezetDropDown);
        WebElement szerv = waitUtil.waitWebElement(By.xpath("//div[@title='" + szervezet + "']"));
        szerv.click();
        return this;
    }

    public Szurok selectSzerepkorFromSzerepkorDropdDown(String szerepkor){
        waitUtil.waitAndClick(szerepkorDropDown);
        WebElement szerepk = waitUtil.waitWebElement(By.cssSelector("div[title='" + szerepkor + "']"));
        szerepk.click();
        return this;
    }

    //parkolók
    public Szurok enterTextToAzonositoFld(String azonosito){
        waitUtil.waitAndSendkeys(azonositoFld, azonosito);
        return this;
    }

    public Szurok enterTextToParkoloMegnFld (String parkoloMegn){
        waitUtil.waitAndSendkeys(parkoloMegnFld, parkoloMegn);
        return this;
    }

    public Szurok selectTipusFromDropDown(String tipus){
        waitUtil.waitAndSendkeys(By.xpath("(//input[@role='combobox'])[1]"), tipus);
        return this;
    }

    public Szurok enterTextToIranyitoszamFld (String iranyitoszam){
        waitUtil.waitAndSendkeys(iranyitoszamFld, iranyitoszam);
        return this;
    }

    public Szurok enterTextToVarosFld (String varos){
        waitUtil.waitAndSendkeys(varosFld, varos);
        return this;
    }

    public Szurok enterTextToKoztNeveFld (String kozterNeve){
        waitUtil.waitAndSendkeys(koztNeveFld, kozterNeve);
        return this;
    }

    public Szurok enterTextToHrszFld (String hrsz){
        waitUtil.waitAndSendkeys(hrszFld, hrsz);
        return this;
    }

    public String felvettSzervezetMegjelenikSzures(){
        return waitUtil.waitAndGetText(By.xpath("//tr[1]//td[1]"));
    }

    //parkolók-parkolóhelyek
    public Szurok selectFromParkolohelyTipusaDropDown(String tipus){
        waitUtil.waitAndClick(parkolohelyTipusaDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+tipus+"']"));
        return this;
    }

    public Szurok enterTextToAzonFldParkolohely(String azon){
        waitUtil.waitAndSendkeys(azonositoFldParkolohely, azon);
        return this;
    }


    //partnerek
    public Szurok enterTextToNevFldPartn(String nev){
        waitUtil.waitAndSendkeys(nevFldPartn, nev);
        return this;
    }

    public Szurok enterTextToCegjegyzekszamFldPartn(String cegjegyzekszam){
        waitUtil.waitAndSendkeys(cegjegyzekSzamFldPartn, cegjegyzekszam);
        return this;
    }

    public Szurok enterTextToIranyitoszamFldPartn(String iranyitoszam){
        waitUtil.waitAndSendkeys(iranyitoszamFldPartn, iranyitoszam);
        return this;
    }

    public Szurok enterTextToVarosFldPartn(String varos){
        waitUtil.waitAndSendkeys(varosFldPartn, varos);
        return this;
    }

    public Szurok enterTextToKoztNeveFldPartn(String koztNeve){
        waitUtil.waitAndSendkeys(kozteruletneveFldPartn, koztNeve);
        return this;
    }

}
