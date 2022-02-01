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
    //Partner adatlap - Szerződések
    private final By szerzodesszamFld = By.xpath("//input[@placeholder='Szerződésszám']");
    private final By partnerFld = By.xpath("//input[@placeholder='Partner']");
    private final By tipusDropDown1 = By.xpath("//app-buildfolio-select[@name='contractType']//input");
    private final By lejaratiTipusDropDown = By.xpath("//app-buildfolio-select[@name='expirationTypeCode']//input");
    private final By ervenyKezdeteDate = By.xpath("//app-datepicker-range[@name='validityStartFrom']//input");
    private final By ervenyVegeDate = By.xpath("//app-datepicker-range[@name='validityEndFrom']//input");
    private final By statuszDropDown = By.xpath("//app-buildfolio-select[.='Státusz']//input");
    //Partner adatlap - Ingatlanok
    private final By megnevezesFldPartnIng = By.xpath("//input[@placeholder='Megnevezés']");
    private final By jellegDropDownPartnIng = By.xpath("//app-buildfolio-select[@name='natureCode']//input");
    private final By iranyitoszamFldPartnIng = By.xpath("//input[@placeholder='Irányítószám']");
    private final By telepulesFldPartnIng = By.xpath("//input[@placeholder='Település']");
    private final By koztNeveFldPartnIng = By.xpath("//input[@placeholder='Közterület neve']");
    private final By hrszFldPartnIng = By.xpath("//input[@placeholder='HRSZ']");
    private final By bankuzemCeluPartnIngDropDown = By.xpath("//app-buildfolio-select[@name='usedAsBank']//input");
    private final By szerepDropDownPartnIng = By.xpath("//app-buildfolio-select[@name='roleCode']//input");
    //Partner adatlap - Partnerek
    private final By sorszamFldPartnSzamlak = By.xpath("//input[@placeholder='Név']");
    private final By tipusDropDownPartnSzamlak = By.xpath("//app-buildfolio-select[@name='invoiceTypeCode']//input");
    private final By vevoFldPartnSzamlak = By.xpath("//input[@placeholder='Vevő']");
    private final By szallitoFldPartnSzamlak = By.xpath("//input[@placeholder='Szállító']");
    private final By bruttoVegosszegTolFldPartnSzamlak = By.xpath("//input[@placeholder='-tól']");
    private final By bruttoVegosszegIgFldPartnSzamlak = By.xpath("//input[@placeholder='-ig']");
    private final By statuszDropDownPartnSzamlak = By.xpath("//app-buildfolio-select[@name='stateCode']//input");
    //Partnerek adatlap - Mérőórák
    private final By oratipusDropDownPartnMero = By.xpath("//div//div[text()='Óratípus']/following-sibling::div//input");
    private final By gyariSzamFldPartnMero = By.xpath("//app-text-input[@name='meterFactoryNumber']//input");
    private final By hrszFldPartnMero = By.xpath("//app-text-input[@name='topographicalNumber']//input");
    private final By meresiPontAzonPartnMero = By.xpath("//app-text-input[@name='placeOfUse']//input");
    private final By legutobbiRogzitesFld = By.xpath("//input[@placeholder='Legutóbbi rögzítés']");
    //Eszközök - Atm-ek
    private final By tipusFldAtmAdatlap = By.xpath("//input[@placeholder='Típus']");
    private final By gyariSzamFldAtmAdatlap = By.xpath("//input[@placeholder='Gyári szám']");
    private final By iranyitoszamFldAtmAdatlap = By.xpath("//input[@placeholder='Irányítószám']");
    private final By varosFldAtmAdatlap = By.xpath("//input[@placeholder='Város']");
    private final By kozteruletNeveFldAtmAdatlap = By.xpath("//input[@placeholder='Közterület neve']");
    private final By beepitettsegDropDownAtmAdatlap = By.xpath("//app-buildfolio-select[@name='atmIntegrationCode']//input");
    private final By elhelyezkedesDropDownAtmAdatlap = By.xpath("//app-buildfolio-select[@name='locationCode']//input");
    private final By statuszDropDownAtmAdatlap = By.xpath("//app-buildfolio-select[@name='atmStateCode']//input");
    //Eszközök - Banktechnikai eszközök
    private final By megnevezesFldBanktechEszk = By.xpath("//input[@placeholder='Megnevezés']");
    private final By leltariSzamFldBanktechEszk = By.xpath("//input[@placeholder='Leltári szám']");
    private final By tipusFldBanktechEszk = By.xpath("//input[@placeholder='Típus']");
    private final By eszkozcsoportDropDownBanktechEszk = By.xpath("//app-buildfolio-select[.='Eszközcsoport']//input");
    private final By iranyitoszamFldBanktechEszk = By.xpath("//input[@placeholder='Irányítószám']");
    private final By varosFldBanktechEszk = By.xpath("//input[@placeholder='Város']");
    private final By kozteruletNeveFldBanktechEszk = By.xpath("//input[@placeholder='Közterület neve']");
    private final By statuszDropDownBanktechEszk = By.xpath("//app-buildfolio-select[.='Státusz']//input");
    //Eszközök - ATM adatlap - Igények
    private final By azonositoAtmDetailsIgenyekFld = By.xpath("//input[@placeholder='Azonosító']");
    private final By leirasFld = By.xpath("//input[@placeholder='Leírás']");
    //Eszközök - Banktechnikai eszköz adatlap - Igények
    private final By leirasFldBanktechEszk = By.xpath("//input[@placeholder='Leírás']");
    //Eszközök - Bankbiztonsági eszközök - Szűrők
    private final By megnevezesFldBankbiztEszk = By.xpath("//input[@placeholder='Megnevezés']");
    private final By leltariSzamFldBankbiztEszk = By.xpath("//input[@placeholder='Leltári szám']");
    private final By tipusFldBankbiztEszk = By.xpath("//input[@placeholder='Típus']");
    private final By eszkozcsoportDropDownBankbiztEszk = By.xpath("//app-buildfolio-select[.='Eszközcsoport']//input");
    private final By iranyitoszamFldBankbiztEszk = By.xpath("//input[@placeholder='Irányítószám']");
    private final By varosFldBankbiztEszk = By.xpath("//input[@placeholder='Város']");
    private final By kozteruletNeveFldBankbiztEszk = By.xpath("//input[@placeholder='Közterület neve']");
    private final By statuszDropDownBankbiztEszk = By.xpath("//app-buildfolio-select[.='Státusz']//input");

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

    //Partner adatlap - Szerződések
    public Szurok enterTextToSzerzodesszamFld(String szerzodesszam){
        waitUtil.waitAndSendkeys(szerzodesszamFld, szerzodesszam);
        return this;
    }

    public Szurok enterTextToPartnerFld(String partner){
        waitUtil.waitAndSendkeys(szerzodesszamFld, partner);
        return this;
    }

    public Szurok selectTipus1FromDropDown(String tipus){
        waitUtil.waitAndClick(tipusDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+tipus+"']"));
        return this;
    }

    public Szurok selectLejaratiTipusFromDropDown(String lejaratiTipus){
        waitUtil.waitAndClick(lejaratiTipusDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+lejaratiTipus+"']"));
        return this;
    }

    public Szurok selectDateFromErvenyessegKezdDropDown(String datum){
        waitUtil.waitAndSendkeys(ervenyKezdeteDate, datum);
        return this;
    }

    public Szurok selectDateFromErvenyessegVegeDropDown(String datum){
        waitUtil.waitAndSendkeys(ervenyVegeDate, datum);
        return this;
    }

    public Szurok selectStatuszFromDropDown(String statusz){
        waitUtil.waitAndClick(statuszDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+statusz+"']"));
        return this;
    }

    //Partner adatlap - Ingatlanok

    public Szurok enterTextToMegnevezesFldPartnIng (String megnevezes){
        waitUtil.waitAndSendkeys(megnevezesFldPartnIng, megnevezes);
        return this;
    }

    public Szurok enterTextToIranyitoszamFldPartnIng (String iranyitoszam){
        waitUtil.waitAndSendkeys(iranyitoszamFldPartn, iranyitoszam);
        return this;
    }

    public Szurok enterTextToTelepulesFldPartnIng (String telepules){
        waitUtil.waitAndSendkeys(telepulesFldPartnIng, telepules);
        return this;
    }

    public Szurok enterTextToKoztNeveFldPartnIng(String kozterNeve){
        waitUtil.waitAndSendkeys(kozteruletneveFldPartn, kozterNeve);
        return this;
    }

    public Szurok enterTextToHrszFldPartnIng (String HRSZ){
        waitUtil.waitAndSendkeys(hrszFldPartnIng, HRSZ);
        return this;
    }

    public Szurok selectSzerepPartIngDropDown(String szerep){
        waitUtil.waitForVisibility(szerepDropDownPartnIng);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+szerep+"'])"));
        return this;
    }

    public Szurok selectJellegPartIngFromDropDown(String jelleg){
        waitUtil.waitAndClick(jellegDropDownPartnIng);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+jelleg+"'])"));
        return this;
    }
    public Szurok selectBankuzemCeluPartnIngDropDown(String bankuzemCelu){
        waitUtil.waitAndClick(bankuzemCeluPartnIngDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+bankuzemCelu+"'])"));
        return this;
    }

    //Partnerek adatlap - Számlák
    public Szurok enterTextToSorszamFldPartnSzamlak(String sorszam){
        waitUtil.waitAndSendkeys(sorszamFldPartnSzamlak, sorszam);
        return  this;
    }

    public Szurok selectTipusFromtipusDropDownPartnSzamlak(String tipus){
        waitUtil.waitAndClick(tipusDropDownPartnSzamlak);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+tipus+"']"));
        return this;
    }

    public Szurok enterTextToVevoFldPartnSzamlak(String vevo){
        waitUtil.waitAndSendkeys(vevoFldPartnSzamlak, vevo);
        return this;
    }

    public Szurok enterTextToSzallitoFldPartnSzamlak(String szallito){
        waitUtil.waitAndSendkeys(szallitoFldPartnSzamlak, szallito);
        return this;
    }

    public Szurok enterDateToKiallitasDatumaFld(String datum){
        waitUtil.waitAndSendkeys(By.xpath("//input[@placeholder='-tól -ig']"), datum);
        return this;
    }

    public Szurok enterTextToBruttoVegosszegTolFLdPartnSzamlak(String bruttoVegosszegTol){
        waitUtil.waitAndSendkeys(bruttoVegosszegTolFldPartnSzamlak, bruttoVegosszegTol);
        return this;
    }

    public Szurok enterTextToBruttoVegosszegIgFldPartnSzamlak(String bruttoVegosszegIg){
        waitUtil.waitAndSendkeys(bruttoVegosszegIgFldPartnSzamlak, bruttoVegosszegIg);
        return this;
    }

    public Szurok selectStatuszFromStatuszDropDownPartnSzamlak(String statusz){
        waitUtil.waitAndSendkeys(statuszDropDownPartnSzamlak, statusz);
        return this;
    }

    //Partnerek adatlap - Merőórák
    public Szurok selectOratipusDropDownPartnMero(String oratipus){
        waitUtil.waitAndClick(oratipusDropDownPartnMero);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+oratipus+"']"));
        return this;
    }

    public Szurok enterTextGyariSzamFldPartnMero(String gyariSzam){
        waitUtil.waitAndSendkeys(gyariSzamFldPartnMero, gyariSzam);
        return this;
    }

    public Szurok enterTextToHrszFldPartnMero(String hrsz){
        waitUtil.waitAndSendkeys(hrszFldPartnIng, hrsz);
        return this;
    }

    public Szurok enterTextToMeresiPontAzonPartnMero(String meresiPontAzon){
        waitUtil.waitAndSendkeys(meresiPontAzonPartnMero, meresiPontAzon);
        return this;
    }

    public Szurok enterDateToLegutobbiRogzitesFld(String legutobbiRogz){
        waitUtil.waitAndSendkeys(legutobbiRogzitesFld, legutobbiRogz);
        return this;
    }

    //Eszközök - Atm-ek adatlap

    public Szurok enterTextToTipusFldAtmAdatlap(String tipus){
        waitUtil.waitAndSendkeys(tipusFldAtmAdatlap, tipus);
        return this;
    }

    public Szurok enterTextToGyariSzamAtmAdatlap(String gyariSzam){
        waitUtil.waitAndSendkeys(gyariSzamFldAtmAdatlap, gyariSzam);
        return this;
    }

    public Szurok enterTextToIranyitoszamFldAtmAdatlap(String iranyitoszam){
        waitUtil.waitAndSendkeys(iranyitoszamFldAtmAdatlap, iranyitoszam);
        return this;
    }

    public Szurok enterTextToVarosFldAtmAdatlap(String varos){
        waitUtil.waitAndSendkeys(varosFldAtmAdatlap, varos);
        return this;
    }

    public Szurok enterTextToKozteruletNeveFldAtmAdatlap(String kozteruletNeve){
        waitUtil.waitAndSendkeys(kozteruletNeveFldAtmAdatlap , kozteruletNeve);
        return this;
    }

    public Szurok selectBeepitettsegFromDropDownAtmAdatlap(String beepitettseg){
        waitUtil.waitAndClick(beepitettsegDropDownAtmAdatlap);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+beepitettseg+"']"));
        return this;
    }

    public Szurok selectElhelyezkedesFromDropDownAtmAdatlap(String elhelyezkedes){
        waitUtil.waitAndClick(elhelyezkedesDropDownAtmAdatlap);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+elhelyezkedes+"']"));
        return this;
    }

    public Szurok selectStatuszFromDropDownAtmAdatlap(String statusz){
        waitUtil.waitAndClick(statuszDropDownAtmAdatlap);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+statusz+"']"));
        return this;
    }

    //Eszközök - Banktechnikai eszközök

    public Szurok enterTextToMegnevezesFldBanktechEszk(String megnevezes){
        waitUtil.waitAndSendkeys(megnevezesFldBanktechEszk, megnevezes);
        return this;
    }

    public Szurok enterTextToLeltariSzamFldBanktechEszk(String leltariSzam){
        waitUtil.waitAndSendkeys(leltariSzamFldBanktechEszk, leltariSzam);
        return this;
    }

    public Szurok enterTextToTipusFldBanktechEszk(String tipus){
        waitUtil.waitAndSendkeys(tipusFldBanktechEszk, tipus);
        return this;
    }

    public Szurok selectFromEszkozcsoportDropDownBanktechEszk(String eszkozcsoport){
        waitUtil.waitAndClick(eszkozcsoportDropDownBanktechEszk);
        waitUtil.waitAndClick(By.xpath("//div[@title='Bankjegyszámláló']"));
        return this;
    }

    public Szurok enterTextToIranyitoszamFldBanktechEszk(String iranyitoszam){
        waitUtil.waitAndSendkeys(iranyitoszamFldBanktechEszk, iranyitoszam);
        return this;
    }

    public Szurok enterTextToVarosFldBanktechEszk(String varos){
        waitUtil.waitAndSendkeys(varosFldBanktechEszk, varos);
        return this;
    }

    public Szurok enterTextKozteruletNeveFldBanktechEszk(String koztNeve){
        waitUtil.waitAndSendkeys(kozteruletNeveFldBanktechEszk, koztNeve);
        return this;
    }

    public Szurok selectFromStatuszDropDownBanktechEszk(String statusz){
        waitUtil.waitAndClick(statuszDropDownBanktechEszk);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+statusz+"']"));
        return this;
    }

    //Eszközök - Bankbiztonsági eszközök

    public Szurok enterTextToMegnevezesFldBankbiztEszk(String megnevezes){
        waitUtil.waitAndSendkeys(megnevezesFldBanktechEszk, megnevezes);
        return this;
    }

    public Szurok enterTextToLeltariSzamFldBankbiztEszk(String leltariSzam){
        waitUtil.waitAndSendkeys(leltariSzamFldBanktechEszk, leltariSzam);
        return this;
    }

    public Szurok enterTextToTipusFldBankbiztEszk(String tipus){
        waitUtil.waitAndSendkeys(tipusFldBanktechEszk, tipus);
        return this;
    }

    public Szurok selectFromEszkozcsoportDropDownBankbiztEszk(String eszkozcsoport){
        waitUtil.waitAndClick(eszkozcsoportDropDownBanktechEszk);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+eszkozcsoport+"']"));
        return this;
    }

    public Szurok enterTextToIranyitoszamFldBankbiztEszk(String iranyitoszam){
        waitUtil.waitAndSendkeys(iranyitoszamFldBanktechEszk, iranyitoszam);
        return this;
    }

    public Szurok enterTextToVarosFldBankbiztEszk(String varos){
        waitUtil.waitAndSendkeys(varosFldBanktechEszk, varos);
        return this;
    }

    public Szurok enterTextKozteruletNeveFldBankbiztEszk(String koztNeve){
        waitUtil.waitAndSendkeys(kozteruletNeveFldBanktechEszk, koztNeve);
        return this;
    }

    public Szurok selectFromStatuszDropDownBankbiztEszk(String statusz){
        waitUtil.waitAndClick(statuszDropDownBanktechEszk);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+statusz+"']"));
        return this;
    }

    //Partner adatlap - Eszközök - Atm-ek adatlap

    public Szurok enterTextToTipusFldPartnerAdatlapAtm(String tipus){
        waitUtil.waitAndSendkeys(tipusFldAtmAdatlap, tipus);
        return this;
    }

    public Szurok enterTextToGyariSzamPartnerAdatlapAtm(String gyariSzam){
        waitUtil.waitAndSendkeys(gyariSzamFldAtmAdatlap, gyariSzam);
        return this;
    }

    public Szurok enterTextToIranyitoszamFldPartnerAdatlapAtm(String iranyitoszam){
        waitUtil.waitAndSendkeys(iranyitoszamFldAtmAdatlap, iranyitoszam);
        return this;
    }

    public Szurok enterTextToVarosFldPartnerAdatlapAtm(String varos){
        waitUtil.waitAndSendkeys(varosFldAtmAdatlap, varos);
        return this;
    }

    public Szurok enterTextToKozteruletNeveFldPartnerAdatlapAtm(String kozteruletNeve){
        waitUtil.waitAndSendkeys(kozteruletNeveFldAtmAdatlap , kozteruletNeve);
        return this;
    }

    public Szurok selectBeepitettsegFromDropDownPartnerAdatlapAtm(String beepitettseg){
        waitUtil.waitAndClick(beepitettsegDropDownAtmAdatlap);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+beepitettseg+"']"));
        return this;
    }

    public Szurok selectElhelyezkedesFromDropDownPartnerAdatlapAtm(String elhelyezkedes){
        waitUtil.waitAndClick(elhelyezkedesDropDownAtmAdatlap);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+elhelyezkedes+"']"));
        return this;
    }

    public Szurok selectStatuszFromDropDownPartnerAdatlapAtm(String statusz){
        waitUtil.waitAndClick(statuszDropDownAtmAdatlap);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+statusz+"']"));
        return this;
    }

    //Partner adatlap - Eszközök - Banktechnikai eszközök

    public Szurok enterTextToMegnevezesFldPartnerAdatlapBanktechEszk(String megnevezes){
        waitUtil.waitAndSendkeys(megnevezesFldBanktechEszk, megnevezes);
        return this;
    }

    public Szurok enterTextToLeltariSzamFldPartnerAdatlapBanktechEszk(String leltariSzam){
        waitUtil.waitAndSendkeys(leltariSzamFldBanktechEszk, leltariSzam);
        return this;
    }

    public Szurok enterTextToTipusFldPartnerAdatlapBanktechEszk(String tipus){
        waitUtil.waitAndSendkeys(tipusFldBanktechEszk, tipus);
        return this;
    }

    public Szurok selectFromEszkozcsoportDropDownPartnerAdatlapBanktechEszk(String eszkozcsoport){
        waitUtil.waitAndClick(eszkozcsoportDropDownBanktechEszk);
        waitUtil.waitAndClick(By.xpath("//div[@title='Bankjegyszámláló']"));
        return this;
    }

    public Szurok enterTextToIranyitoszamFldPartnerAdatlapBanktechEszk(String iranyitoszam){
        waitUtil.waitAndSendkeys(iranyitoszamFldBanktechEszk, iranyitoszam);
        return this;
    }

    public Szurok enterTextToVarosFldPartnerAdatlapBanktechEszk(String varos){
        waitUtil.waitAndSendkeys(varosFldBanktechEszk, varos);
        return this;
    }

    public Szurok enterTextKozteruletNeveFldPartnerAdatlapBanktechEszk(String koztNeve){
        waitUtil.waitAndSendkeys(kozteruletNeveFldBanktechEszk, koztNeve);
        return this;
    }

    public Szurok selectFromStatuszDropDownPartnerAdatlapBanktechEszk(String statusz){
        waitUtil.waitAndClick(statuszDropDownBanktechEszk);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+statusz+"']"));
        return this;
    }

    //Partnerek adatlap - Eszközök - Bankbiztonsági eszközök

    public Szurok enterTextToMegnevezesFldPartnerAdatlapBankbiztEszk(String megnevezes){
        waitUtil.waitAndSendkeys(megnevezesFldBanktechEszk, megnevezes);
        return this;
    }

    public Szurok enterTextToLeltariSzamFldPartnerAdatlapBankbiztEszk(String leltariSzam){
        waitUtil.waitAndSendkeys(leltariSzamFldBanktechEszk, leltariSzam);
        return this;
    }

    public Szurok enterTextToTipusFldPartnerAdatlapBankbiztEszk(String tipus){
        waitUtil.waitAndSendkeys(tipusFldBanktechEszk, tipus);
        return this;
    }

    public Szurok selectFromEszkozcsoportDropDownPartnerAdatlapBankbiztEszk(String eszkozcsoport){
        waitUtil.waitAndClick(eszkozcsoportDropDownBanktechEszk);
        waitUtil.waitAndClick(By.xpath("//div[@title='Bankjegyszámláló']"));
        return this;
    }

    public Szurok enterTextToIranyitoszamFldPartnerAdatlapBankbiztEszk(String iranyitoszam){
        waitUtil.waitAndSendkeys(iranyitoszamFldBanktechEszk, iranyitoszam);
        return this;
    }

    public Szurok enterTextToVarosFldPartnerAdatlapBankbiztEszk(String varos){
        waitUtil.waitAndSendkeys(varosFldBanktechEszk, varos);
        return this;
    }

    public Szurok enterTextKozteruletNeveFldPartnerAdatlapBankbiztEszk(String koztNeve){
        waitUtil.waitAndSendkeys(kozteruletNeveFldBanktechEszk, koztNeve);
        return this;
    }

    public Szurok selectFromStatuszDropDownPartnerAdatlapBankbiztEszk(String statusz){
        waitUtil.waitAndClick(statuszDropDownBanktechEszk);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+statusz+"']"));
        return this;
    }

    //ATM adatlap - Igények
    public Szurok enterTextToAzonositoAtmDetailsIgenyekFld(String azonosito){
        waitUtil.waitAndSendkeys(azonositoAtmDetailsIgenyekFld, azonosito);
        return this;
    }

    public Szurok enterTextToAtmDetailsLeirasFld(String leiras){
        waitUtil.waitAndSendkeys(leirasFld, leiras);
        return this;
    }

    //Eszközök - Banktechnikai eszköz adatlap - Igények
    public Szurok enterTextToLeirasFldBanktechEszk(String leiras){
        waitUtil.waitAndSendkeys(leirasFldBanktechEszk, leiras);
        return this;
    }

    //Eszközök - Bankbiztonsági eszközök - Szűrők
    public Szurok enterTextToMegnevezesBankbiztEszkFld(String megnevezes){
        waitUtil.waitAndSendkeys(megnevezesFldBankbiztEszk, megnevezes);
        return this;
    }

    public Szurok enterTextToLeltarBankbiztEszkFld(String leltariSzam){
        waitUtil.waitAndSendkeys(leltariSzamFldBankbiztEszk, leltariSzam);
        return this;
    }

    public Szurok enterTextToTipusBankbiztEszkozFld(String tipus){
        waitUtil.waitAndSendkeys(tipusFldBankbiztEszk, tipus);
        return this;
    }

    public Szurok selectEszkozcsoportBankbiztEszkozFromDropDown(String eszkozcsoport){
        waitUtil.waitAndClick(eszkozcsoportDropDownBankbiztEszk);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+eszkozcsoport+"']"));
        return this;
    }

    public Szurok enterTextToIranyitoszamBanbiztEszkFld(String iranyitoszam){
        waitUtil.waitAndSendkeys(iranyitoszamFldBankbiztEszk, iranyitoszam);
        return this;
    }

    public Szurok enterTextToVarosBanbiztEszkFld(String varos){
        waitUtil.waitAndSendkeys(varosFldBankbiztEszk, varos);
        return this;
    }

    public Szurok enterTextToKoztNeveBankbiztFld(String koztNeve){
        waitUtil.waitAndSendkeys(kozteruletNeveFldBankbiztEszk, koztNeve);
        return this;
    }

    public Szurok selectStatuszBankbiztEszkozFromDropDown(String statusz){
        waitUtil.waitAndSendkeys(statuszDropDownBankbiztEszk, statusz);
        return this;
    }

}
