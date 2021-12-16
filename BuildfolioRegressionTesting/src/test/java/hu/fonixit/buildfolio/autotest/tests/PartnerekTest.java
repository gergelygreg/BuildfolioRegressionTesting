package hu.fonixit.buildfolio.autotest.tests;

import hu.fonixit.buildfolio.autotest.base.BaseTest;
import hu.fonixit.buildfolio.autotest.pages.DashboardPage;
import hu.fonixit.buildfolio.autotest.pages.LoginPage;
import hu.fonixit.buildfolio.autotest.pages.PartnerekPage;
import hu.fonixit.buildfolio.autotest.pages.components.SideMenu;
import hu.fonixit.buildfolio.autotest.pages.components.Szurok;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.PartnerekDetailsPages.PartnerekDetailsAlapadatok;
import hu.fonixit.buildfolio.autotest.utils.FakerUtils;
import hu.fonixit.buildfolio.autotest.utils.UserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PartnerekTest extends BaseTest {

    @Test
    public void Uj_Partner_felvetele() throws InterruptedException { //Ellenőrizni
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToPartnerekPanel();
        PartnerekPage partnerekPage = new PartnerekPage(getDriver());
        String partnerNeve = "Teszt" + new FakerUtils().generateRandomNumber();
        String partnerNeve2 = "Teszt" + new FakerUtils().generateRandomNumber();
        String telefonszam = "06202102020";
        String email = "email@email.com";
        partnerekPage.
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(partnerNeve).
                enterTelefonszFld(telefonszam).
                enterEmailFld(email).
                selectKozmuChb().
                clickOnMegsemBtn().
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(partnerNeve).
                enterTelefonszFld(telefonszam).
                enterEmailFld(email).
                selectKozmuChb().
                clickOnFelvetelBtn();
        Assert.assertTrue(partnerekPage.uzenetMegjelenik("Sikeres létrehozás!"));
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(partnerNeve, "1"));
        Thread.sleep(5000); //popup üzenet eltűnjön
        partnerekPage.
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(partnerNeve2).
                enterTelefonszFld(telefonszam).
                enterEmailFld(email).
                clickOnFelvetelBtn();

        Assert.assertTrue(partnerekPage.uzenetMegjelenik("Sikeres létrehozás!"));
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(partnerNeve2, "1"));

    }

    @Test
    public void Uj_Partner_felvetele_kotelezo_mezok_nem_kitoltese() throws InterruptedException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToPartnerekPanel();
        PartnerekPage partnerekPage = new PartnerekPage(getDriver());
        String partnerNeve = "Teszt" + new FakerUtils().generateRandomNumber();
        String telefonszam = "06202102020";
        String email = "email@email.com";

        partnerekPage.
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(partnerNeve).
                enterEmailFld(email).
                clickOnFelvetelBtn();
        Assert.assertTrue(partnerekPage.uzenetMegjelenik("Töltse ki a kötelező mezőket!"));
        partnerekPage.clickOnMegsemBtn();
        Thread.sleep(5000); //popup eltünjön
        partnerekPage.
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(partnerNeve).
                enterTelefonszFld(telefonszam).
                clickOnFelvetelBtn();
        Assert.assertTrue(partnerekPage.uzenetMegjelenik("Töltse ki a kötelező mezőket!"));
        partnerekPage.clickOnMegsemBtn();
        Thread.sleep(5000); //popup eltünjön
        partnerekPage.
                clickOnUjPartnerFelveteleBtn().
                enterEmailFld(email).
                enterTelefonszFld(telefonszam).
                clickOnFelvetelBtn();
        Assert.assertTrue(partnerekPage.uzenetMegjelenik("Töltse ki a kötelező mezőket!"));

    }

    @Test
    public void Szurok_mukodese() throws InterruptedException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToPartnerekPanel();
        PartnerekPage partnerekPage = new PartnerekPage(getDriver());
        String partnerNeve = "Teszt" + new FakerUtils().generateRandomNumber();
        String telefonszam = "06202102121";
        String email = "email@email.com";
        partnerekPage.
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(partnerNeve).
                enterTelefonszFld(telefonszam).
                enterEmailFld(email).
                clickOnFelvetelBtn();

        Assert.assertTrue(partnerekPage.uzenetMegjelenik("Sikeres létrehozás!"));
        getDriver().navigate().refresh();
        Thread.sleep(5000);
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(partnerNeve, "1"));
        partnerekPage.clickOnListaElsoEleme();

        String iranyitoszam = "6830";
        String varos = "Szeged";
        String koztNeve = "Széchenyi";
        String koztTipus = "tér";
        String hazszam = "10";
        String cegjegyzekszam = new FakerUtils().generateRandomNumber10();

        PartnerekDetailsAlapadatok partnerekDetailsAlapadatok = new PartnerekDetailsAlapadatok(getDriver()).
                clickOnAdatokSzerkBtn().
                enterTextToIrSzamFld(iranyitoszam).
                enterTextToVarosFld(varos).
                enterTextToKoztNeveFld(koztNeve).
                selectElementFromKozteruletTipusaDropDown(koztTipus).
                enterTextToHazSzamFld(hazszam).
                enterTextToCegjegyzekszam(cegjegyzekszam).
                scrollDownPage().  //ELLENŐRIZNI
                clickOnMentesBtn();
        Assert.assertTrue(partnerekPage.uzenetMegjelenik("Sikeres létrehozás!"));

        sideMenu.navigateToPartnerekPanel();
        Assert.assertTrue(partnerekPage.partnerekTextMegjelenik());
        Szurok szurok = new Szurok(getDriver()).
                clickOnSzurokBtn().
                enterTextToNevFldPartn(partnerNeve).
                clickOnKeresesBtn();
        Thread.sleep(3000);
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(partnerNeve, "1"));
        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToCegjegyzekszamFldPartn(cegjegyzekszam).
                clickOnKeresesBtn();
        Thread.sleep(3000);
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(cegjegyzekszam, "2"));
        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToIranyitoszamFldPartn(iranyitoszam).
                clickOnKeresesBtn();
        Thread.sleep(3000);
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(iranyitoszam, "3"));
        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToVarosFldPartn(varos).
                clickOnKeresesBtn();
        Thread.sleep(3000);
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(varos, "3"));
        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToVarosFldPartn(koztNeve).
                clickOnKeresesBtn();
        Thread.sleep(3000);
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(koztNeve, "3"));

    }

    @Test
    public void Partner_adatlap_nem_kozmu_partner_eseten(){

    }

    @Test
    public void Partner_adatlap_kozmu_partner_eseten(){

    }

    @Test
    public void Alapadatok_tab_szerkesztese_nem_kozmuceg_eseten(){

    }

    @Test
    public void Alapadatok_tab_szerkesztese_kozmuceg_eseten(){

    }

    @Test
    public void Alapadatok_tab_szerkesztes_Kozmuceg_Kozmuceg_checkbox_eltavolitasa(){

    }

    @Test
    public void Alapadatok_tab_szerkesztes_Kozmuceg_Kozmuceg_merooraval(){

    }
    @Test
    public void Alapadatok_tab_szerkesztes_Nem_Kozmuceg_Kozmuceg(){

    }

    @Test
    public void Szerzodesek_tab_kozmu_partner_es_nem_kozmu_partner_eseten(){

    }

    @Test
    public void Szerzodesek_tab_kereses(){

    }

    @Test
    public void Szamlak_tab_kozmu_partner_es_nem_kozmu_partner_eseten(){

    }

    @Test
    public void Szamlak_tab_kereses(){

    }

    @Test
    public void Eszkozok_tab(){

    }

    @Test
    public void Eszkozok_tab_ATM_ek(){

    }

    @Test
    public void Eszkozok_tab_ATM_ek_kereses(){

    }

    @Test
    public void Eszkozok_tab_Banktechnikai_eszkozok(){

    }

    @Test
    public void Banktechnikai_eszkozok_tab_kereses(){

    }

    @Test
    public void Eszkozok_tab_Bankbiztonsagi_eszkozok_tab(){

    }

    @Test
    public void Bankbiztonsagi_ezskozok_tab_kereses(){

    }



}
