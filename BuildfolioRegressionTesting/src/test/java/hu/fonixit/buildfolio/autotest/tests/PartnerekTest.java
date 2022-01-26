package hu.fonixit.buildfolio.autotest.tests;

import hu.fonixit.buildfolio.autotest.base.BaseTest;
import hu.fonixit.buildfolio.autotest.objects.*;
import hu.fonixit.buildfolio.autotest.pages.*;
import hu.fonixit.buildfolio.autotest.pages.components.*;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.EszkozokDetailsPages.EszkozokDetailsAtm;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.EszkozokDetailsPages.EszkozokDetailsBankbiztonsagiEszkozok;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.EszkozokDetailsPages.EszkozokDetailsBanktecknikaiEszkozok;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.IngatlanokDetailsPages.IngatlanokDetailsAlapadatok;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.IngatlanokDetailsPages.IngatlanokDetailsEszkozok;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.IngatlanokDetailsPages.IngatlanokDetailsMuszakiAdatok;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.PartnerekDetailsPages.*;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.SzerzodesekDetailsPages.SzerzodesekDetailsIngatlanokEsEladasiArak;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.SzerzodesekDetailsPages.SzerzodesekDetailsSzerzodoPartnerek;
import hu.fonixit.buildfolio.autotest.utils.FakerUtils;
import hu.fonixit.buildfolio.autotest.utils.UserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


import static hu.fonixit.buildfolio.autotest.utils.JacksonUtils.deserializeJson;

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
                scrollDownPage().
                clickOnMentesBtn();
        Assert.assertTrue(partnerekPage.uzenetMegjelenik("Sikeres rögzítés!"));

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
    public void Partner_adatlap_nem_kozmu_partner_eseten() throws InterruptedException {
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
        PartnerekDetailsAlapadatok partnerekDetailsAlapadatok = new PartnerekDetailsAlapadatok(getDriver());
        Assert.assertTrue(partnerekDetailsAlapadatok.linkText("Alapadatok"));
        Assert.assertEquals(partnerekPage.alapadatokLinkActive(), "nav-link active");
    }

    @Test
    public void Partner_adatlap_kozmu_partner_eseten() throws InterruptedException {
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
                selectKozmuChb().
                clickOnFelvetelBtn();
        Assert.assertTrue(partnerekPage.uzenetMegjelenik("Sikeres létrehozás!"));
        getDriver().navigate().refresh();
        Thread.sleep(5000);
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(partnerNeve, "1"));
        partnerekPage.clickOnListaElsoEleme();
        PartnerekDetailsAlapadatok partnerekDetailsAlapadatok = new PartnerekDetailsAlapadatok(getDriver());
        Assert.assertTrue(partnerekDetailsAlapadatok.linkText("Alapadatok"));
        Assert.assertTrue(partnerekDetailsAlapadatok.linkText("Ingatlanok"));
        Assert.assertTrue(partnerekDetailsAlapadatok.linkText("Szerződések"));
        Assert.assertTrue(partnerekDetailsAlapadatok.linkText("Számlák"));
        Assert.assertTrue(partnerekDetailsAlapadatok.linkText("Mérőórák"));
    }

    @Test
    public void Alapadatok_tab_szerkesztese_nem_kozmuceg_eseten() throws InterruptedException {
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
                scrollDownPage().
                clickOnMentesBtn();
        Assert.assertTrue(partnerekPage.uzenetMegjelenik("Sikeres rögzítés!"));
    }

    @Test
    public void Alapadatok_tab_szerkesztese_kozmuceg_eseten() throws InterruptedException {
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
                scrollDownPage().
                clickOnMentesBtn();
        Assert.assertTrue(partnerekPage.uzenetMegjelenik("Sikeres rögzítés!"));
        partnerekDetailsAlapadatok.
                clickOnAdatokSzerkBtn().
                clearHazszamTxtFld().
                clickOnMentesBtn();
        Assert.assertTrue(partnerekPage.uzenetMegjelenik("Töltse ki a kötelező mezőket!"));
    }

    @Test
    public void Alapadatok_tab_szerkesztes_Kozmuceg_Kozmuceg_checkbox_eltavolitasa() throws InterruptedException {
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
                selectKozmuChb().
                clickOnFelvetelBtn();
        Assert.assertTrue(partnerekPage.uzenetMegjelenik("Sikeres létrehozás!"));
        getDriver().navigate().refresh();
        Thread.sleep(5000);
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(partnerNeve, "1"));
        partnerekPage.clickOnListaElsoEleme();
        PartnerekDetailsAlapadatok partnerekDetailsAlapadatok = new PartnerekDetailsAlapadatok(getDriver());
        Assert.assertEquals(partnerekDetailsAlapadatok.kozmucegTxtAlapadatok(), "Közműcég");
        partnerekDetailsAlapadatok.
                clickOnKozmucegChb().
                clickOnMentesBtn();
        Assert.assertTrue(partnerekPage.uzenetMegjelenik("Sikeres rögzítés!"));
        partnerekDetailsAlapadatok.
                clickOnAdatokSzerkBtn();
        Assert.assertFalse(partnerekDetailsAlapadatok.kozmucegChbMegjelenik());
    }

    @Test
    public void Alapadatok_tab_szerkesztes_Kozmuceg_Kozmuceg_merooraval() throws InterruptedException, IOException {
        //közműcég/közműpartner felvétele
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

        //ingatlan felvétele
        IngatlanokPage ingatlanokPage = new IngatlanokPage(getDriver());
        UjIngatlan ujIngatlan = deserializeJson("ujIngatlan.json", UjIngatlan.class);
        UjIngatlanAlapadatok ujIngatlanAlapadatok = deserializeJson("ujIngatlanAlapadatok.json", UjIngatlanAlapadatok.class);
        UjMuszakiAdatok ujMuszakiAdatok = deserializeJson("ujIngatlanMuszakiAdatok.json", UjMuszakiAdatok.class);
        String szervezetAzon = "Minta Zrt.";
        ingatlanokPage.clickOnUjIngatlanFelveteleBtn();
        String megnevezes = "Teszt Ingatlan" + new FakerUtils().generateRandomNumber();
        String tihaszId = "TihaszID" + new FakerUtils().generateRandomNumber();
        ingatlanokPage.
                enterTextToMegnevezesFld(megnevezes).
                setUjIngatlan(ujIngatlan).
                selectElementFromSzervezetDropDown(szervezetAzon).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertTrue(ingatlanokPage.ingatlanMegjelATablaban(megnevezes));
        ingatlanokPage.clickOnElsoIngatlan();
        IngatlanokDetailsPageTabs ingatlanokDetailsPageTabs = new IngatlanokDetailsPageTabs(getDriver());
        ingatlanokDetailsPageTabs.clickOnEszkozokTab();
        IngatlanokDetailsEszkozok ingatlanokDetailsEszkozok = new IngatlanokDetailsEszkozok(getDriver());
        String oratipus = "Gázóra";
        String gyariszam = "Gyári szám" + new FakerUtils().generateRandomNumber();

        ingatlanokDetailsEszkozok.
                clickOnMeroorakLinkBtn();
        Assert.assertFalse(ingatlanokDetailsEszkozok.felvetelBtnKattinthato());
        ingatlanokDetailsEszkozok.
                selectFromOratipusDropDown(oratipus);
        Assert.assertFalse(ingatlanokDetailsEszkozok.felvetelBtnKattinthato());
        ingatlanokDetailsEszkozok.
                enterTextGyariSzam(gyariszam);
        Assert.assertFalse(ingatlanokDetailsEszkozok.felvetelBtnKattinthato());
        ingatlanokDetailsEszkozok.
                selectFromKozmucegDropDown(partnerNeve);
        Assert.assertTrue(ingatlanokDetailsEszkozok.felvetelBtnKattinthato());
        ingatlanokDetailsEszkozok.
                clickOnFelvetelBtn();

        sideMenu.navigateToPartnerekPanel();
        partnerekPage.clickOnListaElsoEleme();
        PartnerekDetailsAlapadatok partnerekDetailsAlapadatok = new PartnerekDetailsAlapadatok(getDriver());
        partnerekDetailsAlapadatok.
                clickOnAdatokSzerkBtn();
        Assert.assertTrue(partnerekDetailsAlapadatok.kozmucegChboxpipaMegjelenik());

    }
    @Test
    public void Alapadatok_tab_szerkesztes_Nem_Kozmuceg_Kozmuceg() throws InterruptedException {
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
        partnerekPage.
                clickOnListaElsoEleme();
        PartnerekDetailsAlapadatok partnerekDetailsAlapadatok = new PartnerekDetailsAlapadatok(getDriver());
        Assert.assertFalse(partnerekDetailsAlapadatok.kozmucegFeliratMegjelenik());
    }

    @Test
    public void Ingatlanok_tab_szures() throws IOException {
        //I. szervezet felvétele, nem közmű partner
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToPartnerekPanel();
        String partnerNeve = "Teszt Partner" + new FakerUtils().generateRandomNumber();
        String telefonszam = "06202102121";
        String email = "email@gmail.com";
        PartnerekPage partnerekPage = new PartnerekPage(getDriver()).
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(partnerNeve).
                enterTelefonszFld(telefonszam).
                enterEmailFld(email).
                clickOnFelvetelBtn();
        sideMenu.
                navigateToSzervezetekPanel();
        String szervezetAzon = "Szervezet" + new FakerUtils().generateRandomNumber();

        SzervezetekPage szervezetekPage = new SzervezetekPage(getDriver());
        szervezetekPage.clickOnUjSzervezetFelveteleBtn();
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.enterSzervezetAzonositoFld(szervezetAzon);
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.selectKapcsolodoPartnerFromDropDown(partnerNeve);
        Assert.assertTrue(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.clickOnFelvetelBtn();

        //teljes kitöltöttségű ingatlan felvétele
        sideMenu.navigateToIngatlanokPanel();
        UjIngatlan ujIngatlan = deserializeJson("ujIngatlan.json", UjIngatlan.class);
        UjIngatlanAlapadatok ujIngatlanAlapadatok = deserializeJson("ujIngatlanAlapadatok.json", UjIngatlanAlapadatok.class);
        UjMuszakiAdatok ujMuszakiAdatok = deserializeJson("ujIngatlanMuszakiAdatok.json", UjMuszakiAdatok.class);

        IngatlanokPage ingatlanokPage = new IngatlanokPage(getDriver());
        ingatlanokPage.
                clickOnUjIngatlanFelveteleBtn();
        String megnevezes = "Teszt Ingatlan" + new FakerUtils().generateRandomNumber();
        String tihaszId = "TihaszID" + new FakerUtils().generateRandomNumber();
        ingatlanokPage.
                enterTextToMegnevezesFld(megnevezes).
                setUjIngatlan(ujIngatlan).
                selectElementFromSzervezetDropDown(partnerNeve).     //ITT PARTNERT LEHET KIVÁLASZTANI
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertTrue(ingatlanokPage.ingatlanMegjelATablaban(megnevezes));
        ingatlanokPage.clickOnElsoIngatlan();

        IngatlanokDetailsAlapadatok ingatlanokDetailsAlapadatok = new IngatlanokDetailsAlapadatok(getDriver());
        ingatlanokDetailsAlapadatok.
                clickOnAdatokSzerkeszteseBtn().
                setUjIngatlanAlapadatok(ujIngatlanAlapadatok).
                enterTextToTihaszIdFld(tihaszId).
                clickOnMentesBtnBtn();

        IngatlanokDetailsPageTabs ingatlanokDetailsPageTabs = new IngatlanokDetailsPageTabs(getDriver());
        ingatlanokDetailsPageTabs.
                clickOnMuszakiAdatokTab();
        IngatlanokDetailsMuszakiAdatok ingatlanokDetailsMuszakiAdatok = new IngatlanokDetailsMuszakiAdatok(getDriver());
        ingatlanokDetailsMuszakiAdatok.
                clickOnAdatokSzerkeszteseBtn().
                setUjMuszakiAdatok(ujMuszakiAdatok).
                clickOnMentesBtn();

        //szerződés felvétele
        sideMenu.navigateToSzerzodesekPanel();
        UjSzerzodes ujSzerzodes = deserializeJson("ujSzerzodes.json", UjSzerzodes.class);
        String szerzodesSzam = "Teszt Szerződésszám" + new FakerUtils().generateRandomNumber();
        SzerzodesekPage szerzodesekPage = new SzerzodesekPage(getDriver());
        szerzodesekPage.
                clickOnUjSzerzodesFelveteleBtn().
                enterTextToSzerzodesszamFld(szerzodesSzam).
                setUjSzerzodes(ujSzerzodes).
                clickOnFelvetelBtn();
        Assert.assertEquals(szerzodesekPage.listaElsoElemeEll(), szerzodesSzam);
        getDriver().navigate().refresh();
        szerzodesekPage.clickOnElsoElem();

        SzerzodesekDetailsTabs szerzodesekDetailsTabs = new SzerzodesekDetailsTabs(getDriver());
        szerzodesekDetailsTabs.clickOnIngatlanokEsEladasiArakTab();  //Ingatlanok és eladási árak

        SzerzodesekDetailsIngatlanokEsEladasiArak szerzodesekDetailsIngatlanokEsEladasiArak = new SzerzodesekDetailsIngatlanokEsEladasiArak(getDriver());
        szerzodesekDetailsIngatlanokEsEladasiArak.
                clickOnIngaltlHozzarendelewseASzerzhezBtn();
        Assert.assertFalse(szerzodesekDetailsIngatlanokEsEladasiArak.eladasiArakMegadasaAKijelolteknelBtnKattinthato());

        szerzodesekDetailsIngatlanokEsEladasiArak.selectCheckboxFelvettIngatlan(megnevezes, "3");
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.eladasiArakMegadasaAKijelolteknelBtnKattinthato());

        szerzodesekDetailsIngatlanokEsEladasiArak.clickOnEladasiArakMegadasaAKijelolteknelBtn();
        Assert.assertFalse(szerzodesekDetailsIngatlanokEsEladasiArak.hozzarendelesBtnKattinthato());

        String nettoEladasiAr = "10000000";
        szerzodesekDetailsIngatlanokEsEladasiArak.
                enterToNettoEladasiArFld(nettoEladasiAr);
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.hozzarendelesBtnKattinthato());

        szerzodesekDetailsIngatlanokEsEladasiArak.
                clickOnHozzarendelesBtn();
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.ingatlanokHozzarendeleseSzerzodeshezSzoveg());
        szerzodesekDetailsIngatlanokEsEladasiArak.
                clickOnHozzarendelesBtn();
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.popupMegjelenik("Sikeres hozzárendelés!"));
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.ingatlanMegjATablBan(megnevezes, "3"));

        szerzodesekDetailsTabs.clickOnSzerzodoPartnerekTab();
        SzerzodesekDetailsSzerzodoPartnerek szerzodesekDetailsSzerzodoPartnerek = new SzerzodesekDetailsSzerzodoPartnerek(getDriver());
        Assert.assertTrue(szerzodesekDetailsSzerzodoPartnerek.partnerekSzovegMegjelenik());

        szerzodesekDetailsSzerzodoPartnerek.
                clickOnHozzarendBtn().
                selectCheckboxFelvettPartner(partnerNeve, "2").
                clickOnHozzarendelesKijeloltBtn();
        Assert.assertTrue(szerzodesekDetailsSzerzodoPartnerek.popupMegjelenik("Sikeres hozzárendelés!"));
        Assert.assertTrue(szerzodesekDetailsSzerzodoPartnerek.ingatlanMegjATablBan(megnevezes, "2"));

        //II. szervezet felvétele, közmű partner
        String partnerNeve1 = "Teszt Partner Közmű" + new FakerUtils().generateRandomNumber();
        String telefonszam1 = "06202102121";
        String email1 = "email@gmail.com";
        partnerekPage.
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(partnerNeve1).
                enterTelefonszFld(telefonszam1).
                enterEmailFld(email1).
                selectKozmuChb().
                clickOnFelvetelBtn();
        sideMenu.
                navigateToSzervezetekPanel();
        String szervezetAzon1 = "Szervezet" + new FakerUtils().generateRandomNumber();

        szervezetekPage.clickOnUjSzervezetFelveteleBtn();
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.enterSzervezetAzonositoFld(szervezetAzon1);
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.selectKapcsolodoPartnerFromDropDown(partnerNeve1);
        Assert.assertTrue(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.clickOnFelvetelBtn();

        //teljes kitöltöttségű ingatlan felvétele
        sideMenu.navigateToIngatlanokPanel();
        UjIngatlan ujIngatlan1 = deserializeJson("ujIngatlan.json", UjIngatlan.class);
        UjIngatlanAlapadatok ujIngatlanAlapadatok1 = deserializeJson("ujIngatlanAlapadatok.json", UjIngatlanAlapadatok.class);
        UjMuszakiAdatok ujMuszakiAdatok1 = deserializeJson("ujIngatlanMuszakiAdatok.json", UjMuszakiAdatok.class);

        ingatlanokPage.clickOnUjIngatlanFelveteleBtn();
        String megnevezes1 = "Teszt Ingatlan" + new FakerUtils().generateRandomNumber();
        String tihaszId1 = "TihaszID" + new FakerUtils().generateRandomNumber();
        ingatlanokPage.
                enterTextToMegnevezesFld(megnevezes1).
                setUjIngatlan(ujIngatlan1).
                selectElementFromSzervezetDropDown(partnerNeve1).     //ITT PARTNERT LEHET KIVÁLASZTANI
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertTrue(ingatlanokPage.ingatlanMegjelATablaban(megnevezes1));
        ingatlanokPage.clickOnElsoIngatlan();

        ingatlanokDetailsAlapadatok.
                clickOnAdatokSzerkeszteseBtn().
                setUjIngatlanAlapadatok(ujIngatlanAlapadatok1).
                enterTextToTihaszIdFld(tihaszId1).
                clickOnMentesBtnBtn();

        ingatlanokDetailsPageTabs.
                clickOnMuszakiAdatokTab();

        ingatlanokDetailsMuszakiAdatok.
                clickOnAdatokSzerkeszteseBtn().
                setUjMuszakiAdatok(ujMuszakiAdatok1).
                clickOnMentesBtn();

        //szerződés felvétele
        sideMenu.navigateToSzerzodesekPanel();
        UjSzerzodes ujSzerzodes1 = deserializeJson("ujSzerzodes.json", UjSzerzodes.class);
        String szerzodesSzam1 = "Teszt Szerződésszám" + new FakerUtils().generateRandomNumber();
        szerzodesekPage.
                clickOnUjSzerzodesFelveteleBtn().
                enterTextToSzerzodesszamFld(szerzodesSzam1).
                setUjSzerzodes(ujSzerzodes1).
                clickOnFelvetelBtn();
        Assert.assertEquals(szerzodesekPage.listaElsoElemeEll(), szerzodesSzam1);
        getDriver().navigate().refresh();
        szerzodesekPage.clickOnElsoElem();


        szerzodesekDetailsTabs.
                clickOnIngatlanokEsEladasiArakTab();  //Ingatlanok és eladási árak

        szerzodesekDetailsIngatlanokEsEladasiArak.
                clickOnIngaltlHozzarendelewseASzerzhezBtn();
        Assert.assertFalse(szerzodesekDetailsIngatlanokEsEladasiArak.eladasiArakMegadasaAKijelolteknelBtnKattinthato());

        szerzodesekDetailsIngatlanokEsEladasiArak.selectCheckboxFelvettIngatlan(megnevezes1, "3");
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.eladasiArakMegadasaAKijelolteknelBtnKattinthato());

        szerzodesekDetailsIngatlanokEsEladasiArak.clickOnEladasiArakMegadasaAKijelolteknelBtn();
        Assert.assertFalse(szerzodesekDetailsIngatlanokEsEladasiArak.hozzarendelesBtnKattinthato());

        String nettoEladasiAr1 = "10000000";
        szerzodesekDetailsIngatlanokEsEladasiArak.
                enterToNettoEladasiArFld(nettoEladasiAr1);
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.hozzarendelesBtnKattinthato());

        szerzodesekDetailsIngatlanokEsEladasiArak.
                clickOnHozzarendelesBtn();
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.ingatlanokHozzarendeleseSzerzodeshezSzoveg());
        szerzodesekDetailsIngatlanokEsEladasiArak.
                clickOnHozzarendelesBtn();
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.popupMegjelenik("Sikeres hozzárendelés!"));
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.ingatlanMegjATablBan(megnevezes1, "3"));

        szerzodesekDetailsTabs.clickOnSzerzodoPartnerekTab();

        Assert.assertTrue(szerzodesekDetailsSzerzodoPartnerek.partnerekSzovegMegjelenik());

        szerzodesekDetailsSzerzodoPartnerek.
                clickOnHozzarendBtn().
                selectCheckboxFelvettPartner(partnerNeve1, "2").
                clickOnHozzarendelesKijeloltBtn();
        Assert.assertTrue(szerzodesekDetailsSzerzodoPartnerek.popupMegjelenik("Sikeres hozzárendelés!"));
        Assert.assertTrue(szerzodesekDetailsSzerzodoPartnerek.ingatlanMegjATablBan(megnevezes1, "2"));

        sideMenu.
                navigateToPartnerekPanel();
        partnerekPage.
                selectPartnerFromTable(partnerNeve, "1");
        PartnerekDetailsPageTabs partnerekDetailsPageTabs = new PartnerekDetailsPageTabs(getDriver()).
                clickOnIngatlanokLinkBtn();
        PartnerekDetailsIngatlanok partnerekDetailsIngatlanok = new PartnerekDetailsIngatlanok(getDriver());
        //szűrés
        Szurok szurok = new Szurok(getDriver()).
                clickOnSzurokBtn().
                enterTextToMegnevezesFldPartnIng(megnevezes1).
                clickOnKeresesBtn();
        Assert.assertFalse(partnerekDetailsIngatlanok.ingatlanMegjATablBan(megnevezes, "2"));
        Assert.assertTrue(partnerekDetailsIngatlanok.ingatlanMegjATablBan(megnevezes1, "2"));

        String jelleg = "Hétvégi ház";
        szurok.
                clickOnSzurokTorleseBtn().
                selectJellegPartIngFromDropDown(jelleg).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsIngatlanok.ingatlanMegjATablBan(jelleg, "3"));
        Assert.assertFalse(partnerekDetailsIngatlanok.ingatlanMegjATablBan("Bankfiók", "3"));

        String iranyitoszam = "6720";
        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToIranyitoszamFldPartnIng(iranyitoszam).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsIngatlanok.ingatlanMegjATablBan(iranyitoszam, "4"));
        Assert.assertFalse(partnerekDetailsIngatlanok.ingatlanMegjATablBan("6730", "4"));

        String telepules = "Szeged";
        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToTelepulesFldPartnIng(telepules).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsIngatlanok.ingatlanMegjATablBan(telepules, "4"));
        Assert.assertFalse(partnerekDetailsIngatlanok.ingatlanMegjATablBan("Szentes", "4"));

        String koztNeve = "Mátyás";
        szurok.
                clickOnSzurokBtn().
                enterTextToKoztNeveFldPartnIng(koztNeve).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsIngatlanok.ingatlanMegjATablBan(koztNeve, "4"));
        Assert.assertFalse(partnerekDetailsIngatlanok.ingatlanMegjATablBan("Klauzál", "4"));

        String hrsz = "123/456";
        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToHrszFldPartnIng(hrsz).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsIngatlanok.ingatlanMegjATablBan(hrsz, "5"));
        Assert.assertFalse(partnerekDetailsIngatlanok.ingatlanMegjATablBan("123/123", "5"));

        String bankUzemCelu = "nem";
        szurok.
                clickOnSzurokTorleseBtn().
                selectBankuzemCeluPartnIngDropDown(bankUzemCelu).
                clickOnKeresesBtn();
        Assert.assertFalse(partnerekDetailsIngatlanok.ingatlanMegjATablBan(megnevezes, "2"));

       /* String szerep = "Nincs megadva";  NEM LEHET A LEGÖRDÜLŐ LISTÁBÓL KIVÁLASZTANI EZT AZ OPCIÓT
        szurok.
                clickOnSzurokTorleseBtn().
                selectSzerepPartIngDropDown(szerep).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsIngatlanok.ingatlanMegjATablBan(szerep, "8"));*/
    }

    @Test
    public void Szerzodesek_tab_kereses() throws IOException {
        //I. szervezet felvétele, nem közmű partner
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToPartnerekPanel();
        String partnerNeve = "Teszt Partner" + new FakerUtils().generateRandomNumber();
        String telefonszam = "06202102121";
        String email = "email@gmail.com";
        PartnerekPage partnerekPage = new PartnerekPage(getDriver()).
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(partnerNeve).
                enterTelefonszFld(telefonszam).
                enterEmailFld(email).
                clickOnFelvetelBtn();
        sideMenu.
                navigateToSzervezetekPanel();
        String szervezetAzon = "Szervezet" + new FakerUtils().generateRandomNumber();

        SzervezetekPage szervezetekPage = new SzervezetekPage(getDriver());
        szervezetekPage.clickOnUjSzervezetFelveteleBtn();
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.enterSzervezetAzonositoFld(szervezetAzon);
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.selectKapcsolodoPartnerFromDropDown(partnerNeve);
        Assert.assertTrue(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.clickOnFelvetelBtn();

        //teljes kitöltöttségű ingatlan felvétele
        sideMenu.navigateToIngatlanokPanel();
        UjIngatlan ujIngatlan = deserializeJson("ujIngatlan.json", UjIngatlan.class);
        UjIngatlanAlapadatok ujIngatlanAlapadatok = deserializeJson("ujIngatlanAlapadatok.json", UjIngatlanAlapadatok.class);
        UjMuszakiAdatok ujMuszakiAdatok = deserializeJson("ujIngatlanMuszakiAdatok.json", UjMuszakiAdatok.class);

        IngatlanokPage ingatlanokPage = new IngatlanokPage(getDriver());
        ingatlanokPage.clickOnUjIngatlanFelveteleBtn();
        String megnevezes = "Teszt Ingatlan" + new FakerUtils().generateRandomNumber();
        String tihaszId = "TihaszID" + new FakerUtils().generateRandomNumber();
        ingatlanokPage.
                enterTextToMegnevezesFld(megnevezes).
                setUjIngatlan(ujIngatlan).
                selectElementFromSzervezetDropDown(partnerNeve).     //ITT PARTNERT LEHET KIVÁLASZTANI
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertTrue(ingatlanokPage.ingatlanMegjelATablaban(megnevezes));
        ingatlanokPage.clickOnElsoIngatlan();

        IngatlanokDetailsAlapadatok ingatlanokDetailsAlapadatok = new IngatlanokDetailsAlapadatok(getDriver());
        ingatlanokDetailsAlapadatok.
                clickOnAdatokSzerkeszteseBtn().
                setUjIngatlanAlapadatok(ujIngatlanAlapadatok).
                enterTextToTihaszIdFld(tihaszId).
                clickOnMentesBtnBtn();

        IngatlanokDetailsPageTabs ingatlanokDetailsPageTabs = new IngatlanokDetailsPageTabs(getDriver());
        ingatlanokDetailsPageTabs.
                clickOnMuszakiAdatokTab();
        IngatlanokDetailsMuszakiAdatok ingatlanokDetailsMuszakiAdatok = new IngatlanokDetailsMuszakiAdatok(getDriver());
        ingatlanokDetailsMuszakiAdatok.
                clickOnAdatokSzerkeszteseBtn().
                setUjMuszakiAdatok(ujMuszakiAdatok).
                clickOnMentesBtn();

        //szerződés felvétele
        sideMenu.navigateToSzerzodesekPanel();
        UjSzerzodes ujSzerzodes = deserializeJson("ujSzerzodes.json", UjSzerzodes.class);
        String szerzodesSzam = "Teszt Szerződésszám" + new FakerUtils().generateRandomNumber();
        SzerzodesekPage szerzodesekPage = new SzerzodesekPage(getDriver());
        szerzodesekPage.
                clickOnUjSzerzodesFelveteleBtn().
                enterTextToSzerzodesszamFld(szerzodesSzam).
                setUjSzerzodes(ujSzerzodes).
                clickOnFelvetelBtn();
        Assert.assertEquals(szerzodesekPage.listaElsoElemeEll(), szerzodesSzam);
        getDriver().navigate().refresh();
        szerzodesekPage.clickOnElsoElem();

        SzerzodesekDetailsTabs szerzodesekDetailsTabs = new SzerzodesekDetailsTabs(getDriver());
        szerzodesekDetailsTabs.clickOnIngatlanokEsEladasiArakTab();  //Ingatlanok és eladási árak

        SzerzodesekDetailsIngatlanokEsEladasiArak szerzodesekDetailsIngatlanokEsEladasiArak = new SzerzodesekDetailsIngatlanokEsEladasiArak(getDriver());
        szerzodesekDetailsIngatlanokEsEladasiArak.
                clickOnIngaltlHozzarendelewseASzerzhezBtn();
        Assert.assertFalse(szerzodesekDetailsIngatlanokEsEladasiArak.eladasiArakMegadasaAKijelolteknelBtnKattinthato());

        szerzodesekDetailsIngatlanokEsEladasiArak.selectCheckboxFelvettIngatlan(megnevezes, "3");
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.eladasiArakMegadasaAKijelolteknelBtnKattinthato());

        szerzodesekDetailsIngatlanokEsEladasiArak.clickOnEladasiArakMegadasaAKijelolteknelBtn();
        Assert.assertFalse(szerzodesekDetailsIngatlanokEsEladasiArak.hozzarendelesBtnKattinthato());

        String nettoEladasiAr = "10000000";
        szerzodesekDetailsIngatlanokEsEladasiArak.
                enterToNettoEladasiArFld(nettoEladasiAr);
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.hozzarendelesBtnKattinthato());

        szerzodesekDetailsIngatlanokEsEladasiArak.
                clickOnHozzarendelesBtn();
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.ingatlanokHozzarendeleseSzerzodeshezSzoveg());
        szerzodesekDetailsIngatlanokEsEladasiArak.
                clickOnHozzarendelesBtn();
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.popupMegjelenik("Sikeres hozzárendelés!"));
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.ingatlanMegjATablBan(megnevezes, "3"));

        szerzodesekDetailsTabs.clickOnSzerzodoPartnerekTab();
        SzerzodesekDetailsSzerzodoPartnerek szerzodesekDetailsSzerzodoPartnerek = new SzerzodesekDetailsSzerzodoPartnerek(getDriver());
        Assert.assertTrue(szerzodesekDetailsSzerzodoPartnerek.partnerekSzovegMegjelenik());

        szerzodesekDetailsSzerzodoPartnerek.
                clickOnHozzarendBtn().
                selectCheckboxFelvettPartner(partnerNeve, "2").
                clickOnHozzarendelesKijeloltBtn();
        Assert.assertTrue(szerzodesekDetailsSzerzodoPartnerek.popupMegjelenik("Sikeres hozzárendelés!"));
        Assert.assertTrue(szerzodesekDetailsSzerzodoPartnerek.ingatlanMegjATablBan(megnevezes, "2"));

        //II. szervezet felvétele, közmű partner
        String partnerNeve1 = "Teszt Partner Közmű" + new FakerUtils().generateRandomNumber();
        String telefonszam1 = "06202102121";
        String email1 = "email@gmail.com";
        partnerekPage.
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(partnerNeve1).
                enterTelefonszFld(telefonszam1).
                enterEmailFld(email1).
                selectKozmuChb().
                clickOnFelvetelBtn();
        sideMenu.
                navigateToSzervezetekPanel();
        String szervezetAzon1 = "Szervezet" + new FakerUtils().generateRandomNumber();

        szervezetekPage.clickOnUjSzervezetFelveteleBtn();
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.enterSzervezetAzonositoFld(szervezetAzon1);
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.selectKapcsolodoPartnerFromDropDown(partnerNeve1);
        Assert.assertTrue(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.clickOnFelvetelBtn();

        //teljes kitöltöttségű ingatlan felvétele
        sideMenu.navigateToIngatlanokPanel();
        UjIngatlan ujIngatlan1 = deserializeJson("ujIngatlan.json", UjIngatlan.class);
        UjIngatlanAlapadatok ujIngatlanAlapadatok1 = deserializeJson("ujIngatlanAlapadatok.json", UjIngatlanAlapadatok.class);
        UjMuszakiAdatok ujMuszakiAdatok1 = deserializeJson("ujIngatlanMuszakiAdatok.json", UjMuszakiAdatok.class);

        ingatlanokPage.clickOnUjIngatlanFelveteleBtn();
        String megnevezes1 = "Teszt Ingatlan" + new FakerUtils().generateRandomNumber();
        String tihaszId1 = "TihaszID" + new FakerUtils().generateRandomNumber();
        ingatlanokPage.
                enterTextToMegnevezesFld(megnevezes1).
                setUjIngatlan(ujIngatlan1).
                selectElementFromSzervezetDropDown(partnerNeve1).     //ITT PARTNERT LEHET KIVÁLASZTANI
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertTrue(ingatlanokPage.ingatlanMegjelATablaban(megnevezes1));
        ingatlanokPage.clickOnElsoIngatlan();

        ingatlanokDetailsAlapadatok.
                clickOnAdatokSzerkeszteseBtn().
                setUjIngatlanAlapadatok(ujIngatlanAlapadatok1).
                enterTextToTihaszIdFld(tihaszId1).
                clickOnMentesBtnBtn();

        ingatlanokDetailsPageTabs.
                clickOnMuszakiAdatokTab();

        ingatlanokDetailsMuszakiAdatok.
                clickOnAdatokSzerkeszteseBtn().
                setUjMuszakiAdatok(ujMuszakiAdatok1).
                clickOnMentesBtn();

        //szerződés felvétele
        sideMenu.navigateToSzerzodesekPanel();
        UjSzerzodes ujSzerzodes1 = deserializeJson("ujSzerzodes.json", UjSzerzodes.class);
        String szerzodesSzam1 = "Teszt Szerződésszám" + new FakerUtils().generateRandomNumber();
        szerzodesekPage.
                clickOnUjSzerzodesFelveteleBtn().
                enterTextToSzerzodesszamFld(szerzodesSzam1).
                setUjSzerzodes(ujSzerzodes1).
                clickOnFelvetelBtn();
        Assert.assertEquals(szerzodesekPage.listaElsoElemeEll(), szerzodesSzam1);
        getDriver().navigate().refresh();
        szerzodesekPage.clickOnElsoElem();


        szerzodesekDetailsTabs.
                clickOnIngatlanokEsEladasiArakTab();  //Ingatlanok és eladási árak

        szerzodesekDetailsIngatlanokEsEladasiArak.
                clickOnIngaltlHozzarendelewseASzerzhezBtn();
        Assert.assertFalse(szerzodesekDetailsIngatlanokEsEladasiArak.eladasiArakMegadasaAKijelolteknelBtnKattinthato());

        szerzodesekDetailsIngatlanokEsEladasiArak.selectCheckboxFelvettIngatlan(megnevezes1, "3");
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.eladasiArakMegadasaAKijelolteknelBtnKattinthato());

        szerzodesekDetailsIngatlanokEsEladasiArak.clickOnEladasiArakMegadasaAKijelolteknelBtn();
        Assert.assertFalse(szerzodesekDetailsIngatlanokEsEladasiArak.hozzarendelesBtnKattinthato());

        String nettoEladasiAr1 = "10000000";
        szerzodesekDetailsIngatlanokEsEladasiArak.
                enterToNettoEladasiArFld(nettoEladasiAr1);
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.hozzarendelesBtnKattinthato());

        szerzodesekDetailsIngatlanokEsEladasiArak.
                clickOnHozzarendelesBtn();
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.ingatlanokHozzarendeleseSzerzodeshezSzoveg());
        szerzodesekDetailsIngatlanokEsEladasiArak.
                clickOnHozzarendelesBtn();
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.popupMegjelenik("Sikeres hozzárendelés!"));
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.ingatlanMegjATablBan(megnevezes1, "3"));

        szerzodesekDetailsTabs.clickOnSzerzodoPartnerekTab();

        Assert.assertTrue(szerzodesekDetailsSzerzodoPartnerek.partnerekSzovegMegjelenik());

        szerzodesekDetailsSzerzodoPartnerek.
                clickOnHozzarendBtn().
                selectCheckboxFelvettPartner(partnerNeve1, "2").
                clickOnHozzarendelesKijeloltBtn();
        Assert.assertTrue(szerzodesekDetailsSzerzodoPartnerek.popupMegjelenik("Sikeres hozzárendelés!"));
        Assert.assertTrue(szerzodesekDetailsSzerzodoPartnerek.ingatlanMegjATablBan(megnevezes1, "2"));

        //szűrés
        sideMenu.
                navigateToPartnerekPanel();

        partnerekPage.
                selectPartnerFromTable(partnerNeve, "1");

        PartnerekDetailsPageTabs partnerekDetailsPageTabs = new PartnerekDetailsPageTabs(getDriver()).
                clickOnSzerzodesekLinkBtn();
        PartnerekDetailsSzerzodesek partnerekDetailsSzerzodesek = new PartnerekDetailsSzerzodesek(getDriver());

        Szurok szurok = new Szurok(getDriver());
        szurok.
                clickOnSzurokBtn().
                enterTextToSzerzodesszamFld(szerzodesSzam).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsSzerzodesek.szerzodesMegjelenikATablBan(szerzodesSzam, "1"));

        szurok.
            clickOnSzurokTorleseBtn().
            enterTextToPartnerFld(partnerNeve).
            clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsSzerzodesek.szerzodesMegjelenikATablBan(partnerNeve, "2"));

        String szerzodesTipus = "Adásvételi szerződés";
        szurok.
                clickOnSzurokTorleseBtn().
                selectTipusFromDropDown(szerzodesTipus).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsSzerzodesek.szerzodesMegjelenikATablBan(szerzodesTipus, "4"));
        Assert.assertFalse(partnerekDetailsSzerzodesek.szerzodesMegjelenikATablBan("Bérleti szerződés", "4"));

        /*String lejaratiTipus = "határozatlan";
        szurok.
                clickOnSzurokTorleseBtn().                                               API választ teszteljük??
                selectLejaratiTipusFromDropDown(lejaratiTipus).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsSzerzodesek.szerzodesMegjelenikATablBan(lejaratiTipus, ));  */

        String ervenyKezdeteDatum = "2022. 01. 05. - 2022. 01. 13.";
        String ervenyVegeDatum = "2022. 02. 15. - 2022. 02. 18.";
        szurok.
                clickOnSzurokTorleseBtn().
                selectDateFromErvenyessegKezdDropDown(ervenyKezdeteDatum).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsSzerzodesek.szerzodesMegjelenikATablBan(ervenyKezdeteDatum, "5"));

        szurok.
                clickOnSzurokTorleseBtn().
                selectDateFromErvenyessegKezdDropDown(ervenyVegeDatum).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsSzerzodesek.szerzodesMegjelenikATablBan(ervenyVegeDatum, "6"));

        szurok.
                clickOnSzurokTorleseBtn().
                selectDateFromErvenyessegKezdDropDown(ervenyVegeDatum).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsSzerzodesek.szerzodesMegjelenikATablBan(ervenyVegeDatum, "6"));
        Assert.assertFalse(partnerekDetailsSzerzodesek.szerzodesMegjelenikATablBan("2023. 02. 15. - 2023. 02. 18.", "6"));

        String statusz = "Piszkozat";
        szurok.
                clickOnSzurokTorleseBtn().
                selectStatuszFromDropDown(statusz).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsSzerzodesek.szerzodesMegjelenikATablBan(statusz,"7"));
        Assert.assertFalse(partnerekDetailsSzerzodesek.szerzodesMegjelenikATablBan("Érvénytelen", "7"));

        szurok.
                clickOnSzurokTorleseBtn().
                selectStatuszFromDropDown(statusz).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsSzerzodesek.szerzodesMegjelenikATablBan("Érvénytelen","7"));
        Assert.assertTrue(partnerekDetailsSzerzodesek.nincsMegjAdatMegj());

    }

    @Test
    public void Szamlak_tab_kereses(){
        //partner fölvétele
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToPartnerekPanel();
        String partnerNeve = "Teszt Partner" + new FakerUtils().generateRandomNumber();
        String telefonszam = "06202102121";
        String email = "email@gmail.com";
        PartnerekPage partnerekPage = new PartnerekPage(getDriver()).
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(partnerNeve).
                enterTelefonszFld(telefonszam).
                enterEmailFld(email).
                clickOnFelvetelBtn();

        //számla felvétele-partner hozzárendelése
        sideMenu.
                navigateToSzamlakPanel();
        SzamlakPage szamlakPage = new SzamlakPage(getDriver());

        String szamlaIranya = "Bejövő";
        String szamlaSorszam = "Szamla Sorszama Teszt" + new FakerUtils().generateRandomNumber();
        String szamlaTipusa = "Egyéb számla";
        String szallito = "Nincs megadva";
        String vevo = "Nincs megadva";
        String kiallitasDatuma = "2022. 01. 03. - 2022. 01. 12.";
        String bruttoVegosszegTol = "Nincs megadva";
        String bruttoVegosszegIg = "Nincs megadva";
        String statusz = "Vázlat";

        szamlakPage.
                clickOnUjSzamlaFelveteleBtn();
        Assert.assertFalse(szamlakPage.felvetelBtnKattinthato());
        szamlakPage.
                selectSzamlaIranyaFromDropDown(szamlaIranya);
        Assert.assertFalse(szamlakPage.felvetelBtnKattinthato());
        szamlakPage.
                enterTextToSzamlaSorszFld(szamlaSorszam);
        Assert.assertFalse(szamlakPage.felvetelBtnKattinthato());
        szamlakPage.
                selectSzamlaTipusaFromDropDown(szamlaTipusa);
        Assert.assertTrue(szamlakPage.felvetelBtnKattinthato());
        szamlakPage.
                clickOnFelvetelBtn();

        sideMenu.navigateToPartnerekPanel();
        partnerekPage.
                clickOnListaElsoEleme();

        PartnerekDetailsPageTabs partnerekDetailsPageTabs = new PartnerekDetailsPageTabs(getDriver()).
                clickOnSzamlakLinkBtn();
        PartnerekDetailsSzamlak partnerekDetailsSzamlak = new PartnerekDetailsSzamlak(getDriver());

        Szurok szurok = new Szurok(getDriver());
        szurok.
                clickOnSzurokBtn().
                enterTextToSorszamFldPartnSzamlak(szamlaSorszam).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsSzamlak.szamlaMegjelenikATablazatban(szamlaSorszam, "1"));
        Assert.assertFalse(partnerekDetailsSzamlak.szamlaMegjelenikATablazatban("Sorszámxyz", "1"));

        szurok.
                clickOnSzurokTorleseBtn().
                selectTipusFromtipusDropDownPartnSzamlak(szamlaTipusa).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsSzamlak.szamlaMegjelenikATablazatban(szamlaTipusa, "2"));
        Assert.assertFalse(partnerekDetailsSzamlak.szamlaMegjelenikATablazatban("Bérlés számla", "2"));

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToVevoFldPartnSzamlak(vevo).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsSzamlak.szamlaMegjelenikATablazatban(vevo, "4"));
        Assert.assertFalse(partnerekDetailsSzamlak.szamlaMegjelenikATablazatban("Teszt Vevo", "4"));

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToSzallitoFldPartnSzamlak(szallito).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsSzamlak.szamlaMegjelenikATablazatban(szallito, "4"));
        Assert.assertFalse(partnerekDetailsSzamlak.szamlaMegjelenikATablazatban("TIGÁZ", "4"));

        szurok.
                clickOnSzurokTorleseBtn().
                enterDateToKiallitasDatumaFld(kiallitasDatuma).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsSzamlak.szamlaMegjelenikATablazatban(kiallitasDatuma, "5"));
        Assert.assertFalse(partnerekDetailsSzamlak.szamlaMegjelenikATablazatban("2022. 01. 04. - 2023. 08. 16.", "5"));

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToBruttoVegosszegTolFLdPartnSzamlak(bruttoVegosszegTol).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsSzamlak.szamlaMegjelenikATablazatban(bruttoVegosszegTol, "6"));
        Assert.assertFalse(partnerekDetailsSzamlak.szamlaMegjelenikATablazatban("10000", "6"));

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToBruttoVegosszegIgFldPartnSzamlak(bruttoVegosszegIg).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsSzamlak.szamlaMegjelenikATablazatban(bruttoVegosszegIg, "6"));
        Assert.assertFalse(partnerekDetailsSzamlak.szamlaMegjelenikATablazatban("20000", "6"));

        szurok.
                clickOnSzurokTorleseBtn().
                selectStatuszFromStatuszDropDownPartnSzamlak(statusz).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsSzamlak.szamlaMegjelenikATablazatban(statusz, "7"));
        Assert.assertFalse(partnerekDetailsSzamlak.szamlaMegjelenikATablazatban("Fizetett", "7"));


    }

    @Test
    public void Meroorak_tab_kereses_Kozmu_partner_eseten() throws InterruptedException, IOException {
        //ingatlanhoz szervezet felvétele
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToPartnerekPanel();
        String partnerNeve = "Teszt Partner" + new FakerUtils().generateRandomNumber();
        String telefonszam = "06202102121";
        String email = "email@gmail.com";
        PartnerekPage partnerekPage = new PartnerekPage(getDriver()).
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(partnerNeve).
                enterTelefonszFld(telefonszam).
                enterEmailFld(email).
                clickOnFelvetelBtn();
        sideMenu.
                navigateToSzervezetekPanel();
        String szervezetAzon = "Szervezet" + new FakerUtils().generateRandomNumber();

        SzervezetekPage szervezetekPage = new SzervezetekPage(getDriver());
        szervezetekPage.clickOnUjSzervezetFelveteleBtn();
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.enterSzervezetAzonositoFld(szervezetAzon);
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.selectKapcsolodoPartnerFromDropDown(partnerNeve);
        Assert.assertTrue(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.clickOnFelvetelBtn();


        //közmű partner felvétele a Mérőórához
        sideMenu.
                navigateToPartnerekPanel();
        String kozmuPartnerNeve = "Teszt" + new FakerUtils().generateRandomNumber();
        String kozmuPartnerTelefonszam = "06202102121";
        String kozmuPartnerEmail = "email@email.com";
        partnerekPage.
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(kozmuPartnerNeve).
                enterTelefonszFld(kozmuPartnerTelefonszam).
                enterEmailFld(kozmuPartnerEmail).
                selectKozmuChb().
                clickOnFelvetelBtn();
        Assert.assertTrue(partnerekPage.uzenetMegjelenik("Sikeres létrehozás!"));
        getDriver().navigate().refresh();
        Thread.sleep(5000);
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(kozmuPartnerNeve, "1"));

        //ingatlan felvétele + mérőóra felvétele
        sideMenu.navigateToIngatlanokPanel();
        UjIngatlan ujIngatlan = deserializeJson("ujIngatlan.json", UjIngatlan.class);

        IngatlanokPage ingatlanokPage = new IngatlanokPage(getDriver());
        ingatlanokPage.
                clickOnUjIngatlanFelveteleBtn();

        String megnevezes = "Teszt Ingatlan" + new FakerUtils().generateRandomNumber();

        ingatlanokPage.
                enterTextToMegnevezesFld(megnevezes).
                setUjIngatlan(ujIngatlan).
                selectElementFromSzervezetDropDown(partnerNeve).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertTrue(ingatlanokPage.ingatlanMegjelATablaban(megnevezes));

        ingatlanokPage.
                clickOnElsoIngatlan();
        IngatlanokDetailsPageTabs ingatlanokDetailsPageTabs = new IngatlanokDetailsPageTabs(getDriver()).
                clickOnEszkozokTab();
        IngatlanokDetailsEszkozok ingatlanokDetailsEszkozok = new IngatlanokDetailsEszkozok(getDriver());

        String oratipus ="Villanyóra";
        String gyariSzam = "Gyári szám" + new FakerUtils().generateRandomNumber();
        String meresiPontAzon = "Nincs megadva";
        String legutobbiRogzites = "Nincs megadva";

         ingatlanokDetailsEszkozok.
                 clickOnMeroorakLinkBtn();
         Assert.assertFalse(ingatlanokDetailsEszkozok.felvetelBtnKattinthato());
         ingatlanokDetailsEszkozok.
                 clickOnUjMerooraFelveteleBtn();
        Assert.assertFalse(ingatlanokDetailsEszkozok.felvetelBtnKattinthato());
        ingatlanokDetailsEszkozok.
                 selectFromOratipusDropDown(oratipus);
        Assert.assertFalse(ingatlanokDetailsEszkozok.felvetelBtnKattinthato());
        ingatlanokDetailsEszkozok.
                 enterTextGyariSzam(gyariSzam);
        Assert.assertFalse(ingatlanokDetailsEszkozok.felvetelBtnKattinthato());
        ingatlanokDetailsEszkozok.
                 selectFromKozmucegDropDown(kozmuPartnerNeve);
        Assert.assertTrue(ingatlanokDetailsEszkozok.felvetelBtnKattinthato());
        ingatlanokDetailsEszkozok.
                 clickOnFelvetelBtn();

        //Közmű partner - Merőórák tab Szűrők
        sideMenu.
                navigateToPartnerekPanel();
        partnerekPage.
                clickOnListaElsoEleme();
        PartnerekDetailsPageTabs partnerekDetailsPageTabs = new PartnerekDetailsPageTabs(getDriver());
        partnerekDetailsPageTabs.
                clickOnMeroorakLinkBtn();
        Szurok szurok = new Szurok(getDriver());
        PartnerekDetailsMeroorak partnerekDetailsMeroorak = new PartnerekDetailsMeroorak(getDriver());

        String hrsz = "123/456";

        szurok.
                clickOnSzurokBtn().
                selectOratipusDropDownPartnMero(oratipus).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsMeroorak.merooraMegjelenikATablazatban(oratipus, "1"));
        Assert.assertFalse(partnerekDetailsMeroorak.merooraMegjelenikATablazatban("Gázóra", "1"));

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextGyariSzamFldPartnMero(gyariSzam).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsMeroorak.merooraMegjelenikATablazatban(gyariSzam, "2"));
        Assert.assertFalse(partnerekDetailsMeroorak.merooraMegjelenikATablazatban("Gyari szam teszt xyz", "2"));

        /*szurok.     //MEGNÉZNI
                clickOnSzurokTorleseBtn().
                enterTextToHrszFldPartnMero(hrsz).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsMeroorak.merooraMegjelenikATablazatban(hrsz, ""));
        Assert.assertFalse(partnerekDetailsMeroorak.merooraMegjelenikATablazatban("234234/23422324", ""));*/

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToMeresiPontAzonPartnMero(meresiPontAzon).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsMeroorak.merooraMegjelenikATablazatban(meresiPontAzon, "4"));
        Assert.assertFalse(partnerekDetailsMeroorak.merooraMegjelenikATablazatban("Mérési pont azonosító teszt", "4"));

        szurok.
                clickOnSzurokTorleseBtn().
                enterDateToLegutobbiRogzitesFld(legutobbiRogzites).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsMeroorak.merooraMegjelenikATablazatban(legutobbiRogzites, "6"));
        Assert.assertFalse(partnerekDetailsMeroorak.merooraMegjelenikATablazatban("2022. 01. 04.", "6"));
    }


    @Test
    public void Eszkozok_tab_ATM_ek_kereses() throws IOException {
        //Partner felvétele
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToPartnerekPanel();
        String partnerNeve = "Teszt Partner" + new FakerUtils().generateRandomNumber();
        String telefonszam = "06202102121";
        String email = "email@gmail.com";
        PartnerekPage partnerekPage = new PartnerekPage(getDriver()).
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(partnerNeve).
                enterTelefonszFld(telefonszam).
                enterEmailFld(email).
                clickOnFelvetelBtn();

        //Eszközök - ATM felvétele, ATM adatlap - Szervizért felelős partner beállítása
        sideMenu.
                navigateToEszkozokPanel();
        EszkozokPage eszkozokPage = new EszkozokPage(getDriver());
        String gyariSzam = "Gyári szám teszt" + new FakerUtils().generateRandomNumber();
        String tipus = "ATM tipus teszt";
        String statusz = "N/A";
        eszkozokPage.
                clickOnUjAtmFelveteleBtn().
                enterTextToGyariSzamFld(gyariSzam).
                enterTextToTipusFld(tipus).
                selectStatuszFromDropDown(statusz).
                clickOnFelvetelBtn();
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(gyariSzam, "2"));
        eszkozokPage.
                elemKivalasztasaATablazatbol(gyariSzam, "2");

        UjAtmAlapadatok ujAtmAlapadatok = deserializeJson("ujAtmAlapadatok.json", UjAtmAlapadatok.class);
        EszkozokDetailsAtm eszkozokDetailsAtm = new EszkozokDetailsAtm(getDriver());
        eszkozokDetailsAtm.
                clickOnAdatokSzerkeszteseBtn().
                selectPartnerFromSzervizertFelPartnerDropDown(partnerNeve).
                setUjAtmAlapadatok(ujAtmAlapadatok).
                clickOnMentesBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres rögzítés!"));
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(tipus, "1"));

        sideMenu.
                navigateToPartnerekPanel();
        partnerekPage.
                selectPartnerFromTable(partnerNeve, "1");
        PartnerekDetailsPageTabs partnerekDetailsPageTabs = new PartnerekDetailsPageTabs(getDriver());
        partnerekDetailsPageTabs.
                clickOnEszkozokLinkBtn();
        PartnerekDetailsEszkozok partnerekDetailsEszkozok = new PartnerekDetailsEszkozok(getDriver());

        //Partnerek adatlap - Eszközök - Szűrők
        String iranyitoszam = "6520";
        String varos = "Szeged";
        String kozteruletNeve = "Mátyás";
        String beepitettseg = "Falba épített";
        String elhelyezkedes = "Külső helyszín";
        Szurok szurok = new Szurok(getDriver());
        szurok.
                clickOnSzurokBtn().
                enterTextToTipusFldAtmAdatlap(tipus).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsEszkozok.elemMegjelenikATablazatban(tipus, "1"));

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToGyariSzamAtmAdatlap(gyariSzam).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsEszkozok.elemMegjelenikATablazatban(gyariSzam, "2"));

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToIranyitoszamFldAtmAdatlap(iranyitoszam).
                clickOnKeresesBtn();
        Assert.assertFalse(partnerekDetailsEszkozok.elemMegjelenikATablazatban(iranyitoszam, "3"));
        Assert.assertTrue(partnerekDetailsEszkozok.nincsMegjelenithetoAdatFeliratMegjelenik());

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToVarosFldAtmAdatlap(varos).
                clickOnKeresesBtn();
        Assert.assertFalse(partnerekDetailsEszkozok.elemMegjelenikATablazatban(varos, "3"));
        Assert.assertTrue(partnerekDetailsEszkozok.nincsMegjelenithetoAdatFeliratMegjelenik());

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToKozteruletNeveFldAtmAdatlap(kozteruletNeve).
                clickOnKeresesBtn();
        Assert.assertFalse(partnerekDetailsEszkozok.elemMegjelenikATablazatban(kozteruletNeve, "3"));
        Assert.assertTrue(partnerekDetailsEszkozok.nincsMegjelenithetoAdatFeliratMegjelenik());

        szurok.
                clickOnSzurokTorleseBtn().
                selectBeepitettsegFromDropDownAtmAdatlap(beepitettseg).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsEszkozok.elemMegjelenikATablazatban(beepitettseg, "4"));

        szurok.
                clickOnSzurokTorleseBtn().
                selectElhelyezkedesFromDropDownAtmAdatlap(elhelyezkedes).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsEszkozok.elemMegjelenikATablazatban(elhelyezkedes, "4"));

        szurok.
                clickOnSzurokTorleseBtn().
                selectStatuszFromDropDownAtmAdatlap(statusz).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsEszkozok.elemMegjelenikATablazatban(statusz, "5"));

    }

    @Test
    public void Banktechnikai_eszkozok_kereses(){
        //Partner felvétele
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToPartnerekPanel();
        String partnerNeve = "Teszt Partner" + new FakerUtils().generateRandomNumber();
        String telefonszam = "06202102121";
        String email = "email@gmail.com";
        PartnerekPage partnerekPage = new PartnerekPage(getDriver()).
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(partnerNeve).
                enterTelefonszFld(telefonszam).
                enterEmailFld(email).
                clickOnFelvetelBtn();

        //Eszközök - Banktechnikai eszköz felvétele - Szervizért felelős partner felvétele
        sideMenu.
                navigateToEszkozokPanel();
        EszkozokPage eszkozokPage = new EszkozokPage(getDriver());
        EszkozokDetailsPageTabs eszkozokDetailsPageTabs = new EszkozokDetailsPageTabs(getDriver());
        eszkozokDetailsPageTabs.
                clickOnBanktechnikaiEszkTab();

        eszkozokPage.
                clickOnUjEszkozFelveteleBtn();

        String megnevezes = "Banktechnikai eszköz teszt" + new FakerUtils().generateRandomNumber();
        String leltariSzam = "Leltári szám teszt";
        String eszkozcsoport = "Bankjegyszámláló";
        String tipus = "Típus teszt";
        String statusz = "N/A";

        EszkozokDetailsBanktecknikaiEszkozok eszkozokDetailsBanktecknikaiEszkozok = new EszkozokDetailsBanktecknikaiEszkozok(getDriver());
        eszkozokDetailsBanktecknikaiEszkozok.
                enterTextToMegnevezesFld(megnevezes).
                enterTextToLeltariSzamFld(leltariSzam).
                selectFromEszkozcsoportDropDown(eszkozcsoport).
                enterTextToTipusFld(tipus).
                selectFromStatuszDropDown(statusz).
                clickOnFelvetelBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres rögzítés!"));
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(megnevezes, "1"));

        eszkozokPage.
                elemKivalasztasaATablazatbol(megnevezes, "1");

        eszkozokDetailsBanktecknikaiEszkozok.
                clickOnAdatokSzerkeszteseBtn().
                selectFromSzervizertFelelosPartnerDropDown(partnerNeve).
                clickOnMentesBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres rögzítés!"));

        //Partnerek adatlap - Eszközök - Szűrők
        sideMenu.
                navigateToPartnerekPanel();

        partnerekPage.
                selectPartnerFromTable(partnerNeve, "1");
        PartnerekDetailsPageTabs partnerekDetailsPageTabs = new PartnerekDetailsPageTabs(getDriver());
        partnerekDetailsPageTabs.
                clickOnEszkozokLinkBtn();
        PartnerekDetailsEszkozok partnerekDetailsEszkozok = new PartnerekDetailsEszkozok(getDriver());
        partnerekDetailsEszkozok.
                clickOnBanktechnikaiEszkBtn();

        String iranyitoszam = "4565";
        String telepules = "Szeged";
        String kozteruletNeve = "Mátyás";
        Szurok szurok = new Szurok(getDriver());
        szurok.
                enterTextToMegnevezesFldPartnerAdatlapBanktechEszk(megnevezes).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsEszkozok.elemMegjelenikATablazatban(megnevezes, "1"));

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToLeltariSzamFldPartnerAdatlapBanktechEszk(leltariSzam);
        Assert.assertTrue(partnerekDetailsEszkozok.elemMegjelenikATablazatban(leltariSzam, "2"));

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToTipusFldPartnerAdatlapBanktechEszk(tipus).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsEszkozok.elemMegjelenikATablazatban(tipus, "3"));

        szurok.
               clickOnSzurokTorleseBtn().
               selectFromEszkozcsoportDropDownPartnerAdatlapBanktechEszk(eszkozcsoport).
               clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsEszkozok.elemMegjelenikATablazatban(eszkozcsoport, "4"));

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToIranyitoszamFldPartnerAdatlapBanktechEszk(iranyitoszam).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsEszkozok.nincsMegjelenithetoAdatFeliratMegjelenik());

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToIranyitoszamFldPartnerAdatlapBanktechEszk(telepules).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsEszkozok.nincsMegjelenithetoAdatFeliratMegjelenik());

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToIranyitoszamFldPartnerAdatlapBanktechEszk(kozteruletNeve).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsEszkozok.nincsMegjelenithetoAdatFeliratMegjelenik());

        szurok.
                clickOnSzurokTorleseBtn().
                selectFromStatuszDropDownPartnerAdatlapBanktechEszk(statusz).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsEszkozok.elemMegjelenikATablazatban(statusz, "6"));
    }

    @Test
    public void Bankbiztonsagi_eszkozok_tab_kereses(){
        //Partner felvétele
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToPartnerekPanel();
        String partnerNeve = "Teszt Partner" + new FakerUtils().generateRandomNumber();
        String telefonszam = "06202102121";
        String email = "email@gmail.com";
        PartnerekPage partnerekPage = new PartnerekPage(getDriver()).
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(partnerNeve).
                enterTelefonszFld(telefonszam).
                enterEmailFld(email).
                clickOnFelvetelBtn();

        //Eszközök - Bankbiztonsagi eszköz felvétele - Szervizért felelős partner felvétele
        sideMenu.
                navigateToEszkozokPanel();
        EszkozokPage eszkozokPage = new EszkozokPage(getDriver());
        EszkozokDetailsPageTabs eszkozokDetailsPageTabs = new EszkozokDetailsPageTabs(getDriver());
        eszkozokDetailsPageTabs.
                clickOnBanktechnikaiEszkTab();

        eszkozokPage.
                clickOnUjEszkozFelveteleBtn();

        String megnevezes = "Banktechnikai eszköz teszt" + new FakerUtils().generateRandomNumber();
        String leltariSzam = "Leltári szám teszt";
        String eszkozcsoport = "Bankjegyszámláló";
        String tipus = "Típus teszt";
        String statusz = "N/A";

        EszkozokDetailsBankbiztonsagiEszkozok eszkozokDetailsBankbiztonsagiEszkozok = new EszkozokDetailsBankbiztonsagiEszkozok(getDriver());
        eszkozokDetailsBankbiztonsagiEszkozok.
                enterTextToMegnevezesFld(megnevezes).
                enterTextToLeltariSzamFld(leltariSzam).
                selectFromEszkozcsoportDropDown(eszkozcsoport).
                enterTextToTipusFld(tipus).
                selectFromStatuszDropDown(statusz).
                clickOnFelvetelBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres rögzítés!"));
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(megnevezes, "1"));

        eszkozokPage.
                elemKivalasztasaATablazatbol(megnevezes, "1");

        eszkozokDetailsBankbiztonsagiEszkozok.
                clickOnAdatokSzerkeszteseBtn().
                selectFromSzervizertFelelosPartnerDropDown(partnerNeve).
                clickOnMentesBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres rögzítés!"));

        //Partnerek adatlap - Eszközök - Szűrők
        sideMenu.
                navigateToPartnerekPanel();

        partnerekPage.
                selectPartnerFromTable(partnerNeve, "1");
        PartnerekDetailsPageTabs partnerekDetailsPageTabs = new PartnerekDetailsPageTabs(getDriver());
        partnerekDetailsPageTabs.
                clickOnEszkozokLinkBtn();
        PartnerekDetailsEszkozok partnerekDetailsEszkozok = new PartnerekDetailsEszkozok(getDriver());
        partnerekDetailsEszkozok.
                clickOnBankbiztonsagiEszkozok();

        String iranyitoszam = "4565";
        String telepules = "Szeged";
        String kozteruletNeve = "Mátyás";
        Szurok szurok = new Szurok(getDriver());
        szurok.
                enterTextToMegnevezesFldPartnerAdatlapBankbiztEszk(megnevezes).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsEszkozok.elemMegjelenikATablazatban(megnevezes, "1"));

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToLeltariSzamFldPartnerAdatlapBankbiztEszk(leltariSzam);
        Assert.assertTrue(partnerekDetailsEszkozok.elemMegjelenikATablazatban(leltariSzam, "2"));

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToTipusFldPartnerAdatlapBankbiztEszk(tipus).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsEszkozok.elemMegjelenikATablazatban(tipus, "3"));

        szurok.
                clickOnSzurokTorleseBtn().
                selectFromEszkozcsoportDropDownPartnerAdatlapBankbiztEszk(eszkozcsoport).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsEszkozok.elemMegjelenikATablazatban(eszkozcsoport, "4"));

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToIranyitoszamFldPartnerAdatlapBankbiztEszk(iranyitoszam).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsEszkozok.nincsMegjelenithetoAdatFeliratMegjelenik());

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToIranyitoszamFldPartnerAdatlapBankbiztEszk(telepules).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsEszkozok.nincsMegjelenithetoAdatFeliratMegjelenik());

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToIranyitoszamFldPartnerAdatlapBankbiztEszk(kozteruletNeve).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsEszkozok.nincsMegjelenithetoAdatFeliratMegjelenik());

        szurok.
                clickOnSzurokTorleseBtn().
                selectFromStatuszDropDownPartnerAdatlapBankbiztEszk(statusz).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsEszkozok.elemMegjelenikATablazatban(statusz, "6"));
    }

}
