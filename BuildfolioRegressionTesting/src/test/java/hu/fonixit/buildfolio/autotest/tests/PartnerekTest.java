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
import hu.fonixit.buildfolio.autotest.pages.detailsPages.ParkolokDetailsPages.ParkolokDetailsIngatlanok;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.PartnerekDetailsPages.*;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.SzamlakDetailsPages.SzamlakDetailsPartnerek;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.SzerzodesekDetailsPages.SzerzodesekDetailsIngatlanokEsEladasiArak;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.SzerzodesekDetailsPages.SzerzodesekDetailsSzerzodoPartnerek;
import hu.fonixit.buildfolio.autotest.utils.FakerUtils;
import hu.fonixit.buildfolio.autotest.utils.UserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


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
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(partnerNeve, "1"));
        partnerekPage.clickOnListaElsoEleme(partnerNeve, "1");

        String iranyitoszam = "6830";
        String telepules = "Szeged";
        String koztNeve = "Széchenyi";
        String koztTipus = "tér";
        String hazszam = "10";
        String cegjegyzekszam = new FakerUtils().generateRandomNumber10();

        PartnerekDetailsAlapadatok partnerekDetailsAlapadatok = new PartnerekDetailsAlapadatok(getDriver()).
                clickOnAdatokSzerkBtn().
                enterTextToIrSzamFld(iranyitoszam).
                enterTextToTelepulesFld(telepules).
                enterTextToKoztNeveFld(koztNeve).
                selectElementFromKozteruletTipusaDropDown(koztTipus).
                enterTextToHazSzamFld(hazszam).
                enterTextToCegjegyzekszam(cegjegyzekszam).
                scrollDownPage().
                clickOnMentesBtn();
        Assert.assertTrue(partnerekPage.uzenetMegjelenik("Sikeres rögzítés!"));

        sideMenu.
                navigateToPartnerekPanel();
        Assert.assertTrue(partnerekPage.partnerekTextMegjelenik());
        Szurok szurok = new Szurok(getDriver()).
                clickOnSzurokBtn().
                enterTextToNevFldPartn(partnerNeve).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(partnerNeve, "1"));
        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToCegjegyzekszamFldPartn(cegjegyzekszam).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(partnerNeve, "1"));
        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToIranyitoszamFldPartn(iranyitoszam).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(partnerNeve, "1"));
        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToVarosFldPartn(telepules).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(partnerNeve, "1"));
        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToKoztNeveFldPartn(koztNeve).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(partnerNeve, "1"));

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
        partnerekPage.clickOnListaElsoEleme(partnerNeve, "1");
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
        partnerekPage.clickOnListaElsoEleme(partnerNeve, "1");
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
        partnerekPage.clickOnListaElsoEleme(partnerNeve, "1");

        String iranyitoszam = "6830";
        String telepules = "Szeged";
        String koztNeve = "Széchenyi";
        String koztTipus = "tér";
        String hazszam = "10";
        String cegjegyzekszam = new FakerUtils().generateRandomNumber10();

        PartnerekDetailsAlapadatok partnerekDetailsAlapadatok = new PartnerekDetailsAlapadatok(getDriver()).
                clickOnAdatokSzerkBtn().
                enterTextToIrSzamFld(iranyitoszam).
                enterTextToTelepulesFld(telepules).
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
        partnerekPage.clickOnListaElsoEleme(partnerNeve, "1");

        String iranyitoszam = "6830";
        String telepules = "Szeged";
        String koztNeve = "Széchenyi";
        String koztTipus = "tér";
        String hazszam = "10";
        String cegjegyzekszam = new FakerUtils().generateRandomNumber10();

        PartnerekDetailsAlapadatok partnerekDetailsAlapadatok = new PartnerekDetailsAlapadatok(getDriver()).
                clickOnAdatokSzerkBtn().
                enterTextToIrSzamFld(iranyitoszam).
                enterTextToTelepulesFld(telepules).
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
    public void Alapadatok_tab_szerkesztes_Kozmuceg_Kozmuceg_checkbox_eltavolitasa() throws IOException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToPartnerekPanel();
        UjPartnerAlapadatok ujPartnerAlapadatok = deserializeJson("ujPartnerAlapadatok.json", UjPartnerAlapadatok.class);

        PartnerekPage partnerekPage = new PartnerekPage(getDriver());
        String partnerNeve = "Teszt partner" + new FakerUtils().generateRandomNumber();
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
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(partnerNeve, "1"));
        partnerekPage.clickOnListaElsoEleme(partnerNeve, "1");

        PartnerekDetailsAlapadatok partnerekDetailsAlapadatok = new PartnerekDetailsAlapadatok(getDriver());
        Assert.assertEquals(partnerekDetailsAlapadatok.kozmucegTxtAlapadatok(), "Közműcég");
        partnerekDetailsAlapadatok.
                clickOnAdatokSzerkBtn().
                ujPartnerAlapadatok(ujPartnerAlapadatok).
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
        String kozmuPartnerNeve = "Teszt Közmű Partner" + new FakerUtils().generateRandomNumber();
        String telefonszamKozmu = "06202102121";
        String emailKozmu = "email@email.com";
        partnerekPage.
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(kozmuPartnerNeve).
                enterTelefonszFld(telefonszamKozmu).
                enterEmailFld(emailKozmu).
                selectKozmuChb().
                clickOnFelvetelBtn();
        Assert.assertTrue(partnerekPage.uzenetMegjelenik("Sikeres létrehozás!"));
        getDriver().navigate().refresh();
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(kozmuPartnerNeve, "1"));

        //szervezet felvétele
        String partnerNeve = "Teszt Partner" + new FakerUtils().generateRandomNumber();
        String telefonszam = "06202102121";
        String email = "email@gmail.com";
       partnerekPage.
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(partnerNeve).
                enterTelefonszFld(telefonszam).
                enterEmailFld(email).
                clickOnFelvetelBtn();
        SideMenu sideMenu1 = new SideMenu(getDriver()).navigateToSzervezetekPanel();
        String szervezetAzon = "Szervezet" + new FakerUtils().generateRandomNumber();

        SzervezetekPage szervezetekPage = new SzervezetekPage(getDriver());
        szervezetekPage.clickOnUjSzervezetFelveteleBtn();
        szervezetekPage.enterSzervezetAzonositoFld(szervezetAzon);
        szervezetekPage.selectKapcsolodoPartnerFromDropDown(partnerNeve);
        szervezetekPage.clickOnFelvetelBtn();

        //ingatlan felvétele
        Thread.sleep(2000);
        sideMenu.
                navigateToIngatlanokPanel();
        UjIngatlan ujIngatlan = deserializeJson("ujIngatlan.json", UjIngatlan.class);
        IngatlanokPage ingatlanokPage = new IngatlanokPage(getDriver());
        IngatlanokDetailsAlapadatok ingatlanokDetailsAlapadatok = new IngatlanokDetailsAlapadatok(getDriver());
        ingatlanokPage.
                clickOnUjIngatlanFelveteleBtn();
        String megnevezes = "Teszt Ingatlan" + new FakerUtils().generateRandomNumber();
        ingatlanokPage.
                enterTextToMegnevezesFld(megnevezes).
                setUjIngatlan(ujIngatlan).
                selectElementFromSzervezetDropDown(partnerNeve).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertTrue(ingatlanokPage.ingatlanMegjATabl(megnevezes, "2"));

        //mérrőóra felvétele ingatlanhoz
        ingatlanokPage.
                clickOnElsoIngatlan(megnevezes, "2");
        IngatlanokDetailsPageTabs ingatlanokDetailsPageTabs = new IngatlanokDetailsPageTabs(getDriver());
        ingatlanokDetailsPageTabs.
                clickOnEszkozokTab();
        IngatlanokDetailsEszkozok ingatlanokDetailsEszkozok = new IngatlanokDetailsEszkozok(getDriver());
        String oratipus = "Gázóra";
        String gyariszam = "Gyári szám" + new FakerUtils().generateRandomNumber();

        ingatlanokDetailsEszkozok.
                clickOnMeroorakLinkBtn();
        Assert.assertFalse(ingatlanokDetailsEszkozok.felvetelBtnKattinthato());
        ingatlanokDetailsEszkozok.
                clickOnUjMerooraFelveteleBtn().
                selectFromOratipusDropDown(oratipus);
        Assert.assertFalse(ingatlanokDetailsEszkozok.felvetelBtnKattinthato());
        ingatlanokDetailsEszkozok.
                enterTextGyariSzam(gyariszam);
        Assert.assertFalse(ingatlanokDetailsEszkozok.felvetelBtnKattinthato());
        ingatlanokDetailsEszkozok.
                selectFromKozmucegDropDown(kozmuPartnerNeve);
        Assert.assertTrue(ingatlanokDetailsEszkozok.felvetelBtnKattinthato());
        ingatlanokDetailsEszkozok.
                clickOnFelvetelBtn();
        Assert.assertTrue(ingatlanokDetailsAlapadatok.popupSzovegMegjelenik("Sikeres létrehozás!"));

        sideMenu.
                navigateToPartnerekPanel();
        partnerekPage.clickOnListaElsoEleme(kozmuPartnerNeve, "1");
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
                clickOnListaElsoEleme(partnerNeve, "1");
        PartnerekDetailsAlapadatok partnerekDetailsAlapadatok = new PartnerekDetailsAlapadatok(getDriver());
        Assert.assertFalse(partnerekDetailsAlapadatok.kozmucegFeliratMegjelenik());
    }

    @Test
    public void Ingatlanok_tab_szures() throws IOException, InterruptedException {
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
        szervezetekPage.enterSzervezetAzonositoFld(szervezetAzon);
        szervezetekPage.selectKapcsolodoPartnerFromDropDown(partnerNeve);
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
        Assert.assertTrue(ingatlanokPage.ingatlanMegjATabl(megnevezes, "2"));
        ingatlanokPage.
                clickOnElsoIngatlan(megnevezes, "2");

        IngatlanokDetailsAlapadatok ingatlanokDetailsAlapadatok = new IngatlanokDetailsAlapadatok(getDriver());
        ingatlanokDetailsAlapadatok.
                clickOnAdatokSzerkeszteseBtn().
                setUjIngatlanAlapadatok(ujIngatlanAlapadatok).
                enterTextToTihaszIdFld(tihaszId).
                clickOnMentesBtnBtn();
        Assert.assertTrue(ingatlanokDetailsAlapadatok.popupSzovegMegjelenik("Sikeres rögzítés"));
        ingatlanokDetailsAlapadatok.
                scrollUp();

        IngatlanokDetailsPageTabs ingatlanokDetailsPageTabs = new IngatlanokDetailsPageTabs(getDriver());
        ingatlanokDetailsPageTabs.
                clickOnMuszakiAdatokTab();
        IngatlanokDetailsMuszakiAdatok ingatlanokDetailsMuszakiAdatok = new IngatlanokDetailsMuszakiAdatok(getDriver());
        ingatlanokDetailsMuszakiAdatok.
                clickOnAdatokSzerkeszteseBtn().
                scrollUp().
                setUjMuszakiAdatok(ujMuszakiAdatok).
                clickOnMentesBtn();

        //szerződés felvétele
        sideMenu.
                navigateToSzerzodesekPanel();
        UjSzerzodes ujSzerzodes = deserializeJson("ujSzerzodes.json", UjSzerzodes.class);
        String szerzodesSzam = "Teszt Szerződésszám" + new FakerUtils().generateRandomNumber();
        SzerzodesekPage szerzodesekPage = new SzerzodesekPage(getDriver());
        szerzodesekPage.
                clickOnUjSzerzodesFelveteleBtn().
                enterTextToSzerzodesszamFld(szerzodesSzam).
                setUjSzerzodes(ujSzerzodes).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        szerzodesekPage.clickOnElsoElem(szerzodesSzam, "1");

        //szerződés //Ingatlanok és eladási árak
        SzerzodesekDetailsTabs szerzodesekDetailsTabs = new SzerzodesekDetailsTabs(getDriver());
        szerzodesekDetailsTabs.
                clickOnIngatlanokEsEladasiArakTab();

        SzerzodesekDetailsIngatlanokEsEladasiArak szerzodesekDetailsIngatlanokEsEladasiArak = new SzerzodesekDetailsIngatlanokEsEladasiArak(getDriver());
        szerzodesekDetailsIngatlanokEsEladasiArak.
                clickOnIngaltlHozzarendelewseASzerzhezBtn();
        Assert.assertFalse(szerzodesekDetailsIngatlanokEsEladasiArak.eladasiArakMegadasaAKijelolteknelBtnKattinthato());

        szerzodesekDetailsIngatlanokEsEladasiArak.
                selectCheckboxFelvettIngatlan(megnevezes);
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.eladasiArakMegadasaAKijelolteknelBtnKattinthato());

        szerzodesekDetailsIngatlanokEsEladasiArak.
                clickOnEladasiArakMegadasaAKijelolteknelBtn();
        Assert.assertFalse(szerzodesekDetailsIngatlanokEsEladasiArak.hozzarendelesBtnKattinthato());

        String nettoEladasiAr = "10000000";
        szerzodesekDetailsIngatlanokEsEladasiArak.
                enterToNettoEladasiArFld(nettoEladasiAr).
                clickOnHozzarendelesBtn();
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.ingatlanokHozzarendeleseSzerzodeshezSzoveg());
        szerzodesekDetailsIngatlanokEsEladasiArak.
                clickOnHozzarendelesBtnAblakon();
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.popupMegjelenik("Sikeres hozzárendelés!"));
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.ingatlanMegjATablBan(megnevezes, "3"));

        //Szerződő partnerek
        szerzodesekDetailsTabs.
                clickOnSzerzodoPartnerekTab();
        SzerzodesekDetailsSzerzodoPartnerek szerzodesekDetailsSzerzodoPartnerek = new SzerzodesekDetailsSzerzodoPartnerek(getDriver());

        Thread.sleep(2000);
        szerzodesekDetailsSzerzodoPartnerek.
                clickOnHozzarendBtn().
                selectCheckboxFelvettPartner(partnerNeve).
                clickOnHozzarendelesKijeloltBtn();
        Assert.assertTrue(szerzodesekDetailsSzerzodoPartnerek.popupMegjelenik("Sikeres hozzárendelés!"));
        Assert.assertTrue(szerzodesekDetailsSzerzodoPartnerek.ingatlanMegjATablBan(partnerNeve, "2"));

        //II. szervezet felvétele, közmű partner
        sideMenu.
                navigateToPartnerekPanel();
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
        Assert.assertTrue(partnerekPage.uzenetMegjelenik("Sikeres létrehozás!"));
        sideMenu.
                navigateToSzervezetekPanel();
        String szervezetAzon1 = "Szervezet" + new FakerUtils().generateRandomNumber();

        szervezetekPage.clickOnUjSzervezetFelveteleBtn();
        szervezetekPage.enterSzervezetAzonositoFld(szervezetAzon1);
        szervezetekPage.selectKapcsolodoPartnerFromDropDown(partnerNeve1);
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
        Assert.assertTrue(ingatlanokPage.popUpMegjelenik("Sikeres létrehozás!"));
        getDriver().navigate().refresh();
        Assert.assertTrue(ingatlanokPage.ingatlanMegjATabl(megnevezes1, "2"));
        ingatlanokPage.
                clickOnElsoIngatlan(megnevezes1, "2");

        ingatlanokDetailsAlapadatok.
                clickOnAdatokSzerkeszteseBtn().
                setUjIngatlanAlapadatok(ujIngatlanAlapadatok1).
                enterTextToTihaszIdFld(tihaszId1).
                clickOnMentesBtnBtn();
        Assert.assertTrue(ingatlanokDetailsAlapadatok.popupSzovegMegjelenik("Sikeres rögzítés"));

        ingatlanokDetailsAlapadatok.
                scrollUp();
        ingatlanokDetailsPageTabs.
                clickOnMuszakiAdatokTab();

        ingatlanokDetailsMuszakiAdatok.
                clickOnAdatokSzerkeszteseBtn().
                scrollUp().
                setUjMuszakiAdatok(ujMuszakiAdatok1).
                clickOnMentesBtn();

        //szerződés felvétele
        sideMenu.
                navigateToSzerzodesekPanel();
        String szerzodesSzam1 = "Teszt Szerződésszám" + new FakerUtils().generateRandomNumber();
        szerzodesekPage.
                clickOnUjSzerzodesFelveteleBtn().
                enterTextToSzerzodesszamFld(szerzodesSzam1).
                setUjSzerzodes(ujSzerzodes).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        szerzodesekPage.clickOnElsoElem(szerzodesSzam1, "1");

        //szerződés //Ingatlanok és eladási árak
        szerzodesekDetailsTabs.
                clickOnIngatlanokEsEladasiArakTab();

        szerzodesekDetailsIngatlanokEsEladasiArak.
                clickOnIngaltlHozzarendelewseASzerzhezBtn();
        Assert.assertFalse(szerzodesekDetailsIngatlanokEsEladasiArak.eladasiArakMegadasaAKijelolteknelBtnKattinthato());

        szerzodesekDetailsIngatlanokEsEladasiArak.
                selectCheckboxFelvettIngatlan(megnevezes1);
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.eladasiArakMegadasaAKijelolteknelBtnKattinthato());

        szerzodesekDetailsIngatlanokEsEladasiArak.
                clickOnEladasiArakMegadasaAKijelolteknelBtn();
        Assert.assertFalse(szerzodesekDetailsIngatlanokEsEladasiArak.hozzarendelesBtnKattinthato());

        String nettoEladasiAr1 = "10000000";
        szerzodesekDetailsIngatlanokEsEladasiArak.
                enterToNettoEladasiArFld(nettoEladasiAr1).
                clickOnHozzarendelesBtn();
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.ingatlanokHozzarendeleseSzerzodeshezSzoveg());
        szerzodesekDetailsIngatlanokEsEladasiArak.
                clickOnHozzarendelesBtnAblakon();
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.popupMegjelenik("Sikeres hozzárendelés!"));
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.ingatlanMegjATablBan(megnevezes1, "3"));

        //Szerződő partnerek
        szerzodesekDetailsTabs.
                clickOnSzerzodoPartnerekTab();

        Thread.sleep(2000);
        szerzodesekDetailsSzerzodoPartnerek.
                clickOnHozzarendBtn().
                selectCheckboxFelvettPartner(partnerNeve1).
                clickOnHozzarendelesKijeloltBtn();
        Assert.assertTrue(szerzodesekDetailsSzerzodoPartnerek.popupMegjelenik("Sikeres hozzárendelés!"));
        Assert.assertTrue(szerzodesekDetailsSzerzodoPartnerek.ingatlanMegjATablBan(partnerNeve1, "2"));

        //szűrés
        sideMenu.
                navigateToPartnerekPanel();
        partnerekPage.
                selectPartnerFromTable(partnerNeve, "1");
        PartnerekDetailsPageTabs partnerekDetailsPageTabs = new PartnerekDetailsPageTabs(getDriver());
        partnerekDetailsPageTabs.
                clickOnIngatlanokLinkBtn();

        PartnerekDetailsIngatlanok partnerekDetailsIngatlanok = new PartnerekDetailsIngatlanok(getDriver());
        Szurok szurok = new Szurok(getDriver()).
                clickOnSzurokBtn().
                enterTextToMegnevezesFldPartnIng(megnevezes).
                clickOnKeresesBtn();
        Assert.assertFalse(partnerekDetailsIngatlanok.ingatlanMegjATablBan(megnevezes1, "2"));
        Assert.assertTrue(partnerekDetailsIngatlanok.ingatlanMegjATablBan(megnevezes, "2"));

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
        Assert.assertTrue(partnerekDetailsIngatlanok.ingatlanMegjATablBan(megnevezes, "2"));

        String telepules = "Szeged";
        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToTelepulesFldPartnIng(telepules).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsIngatlanok.ingatlanMegjATablBan(megnevezes, "2"));

        String koztNeve = "Mátyás";
        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToKoztNeveFldPartnIng(koztNeve).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsIngatlanok.ingatlanMegjATablBan(megnevezes, "2"));

        String hrsz = "123/456";
        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToHrszFldPartnIng(hrsz).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsIngatlanok.ingatlanMegjATablBan(hrsz, "5"));
        Assert.assertFalse(partnerekDetailsIngatlanok.ingatlanMegjATablBan("123/123", "5"));

        String bankUzemCelu = "Nem";
        szurok.
                clickOnSzurokTorleseBtn().
                selectBankuzemCeluPartnIngDropDown(bankUzemCelu).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsIngatlanok.ingatlanMegjATablBan(megnevezes, "2"));

        String szerep = "Bérlő";
        szurok.
                clickOnSzurokTorleseBtn().
                selectSzerepPartIngDropDown(szerep).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsIngatlanok.nincsMegjelenithetoAdatFelirat());
    }

    @Test
    public void Szerzodesek_tab_kereses() throws IOException, InterruptedException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");

        //I. szervezet felvétele, nem közmű partnerrel
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
        //Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.enterSzervezetAzonositoFld(szervezetAzon);
        //Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.selectKapcsolodoPartnerFromDropDown(partnerNeve);
        //Assert.assertTrue(szervezetekPage.felvetelBtnKattinthato());
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
        Assert.assertTrue(ingatlanokPage.ingatlanMegjATabl(megnevezes, "2"));
        ingatlanokPage.
                clickOnElsoIngatlan(megnevezes, "2");

        IngatlanokDetailsAlapadatok ingatlanokDetailsAlapadatok = new IngatlanokDetailsAlapadatok(getDriver());
        ingatlanokDetailsAlapadatok.
                clickOnAdatokSzerkeszteseBtn().
                setUjIngatlanAlapadatok(ujIngatlanAlapadatok).
                enterTextToTihaszIdFld(tihaszId).
                clickOnMentesBtnBtn();
        Assert.assertTrue(ingatlanokDetailsAlapadatok.popupSzovegMegjelenik("Sikeres rögzítés"));
        ingatlanokDetailsAlapadatok.
                scrollUp();

        IngatlanokDetailsPageTabs ingatlanokDetailsPageTabs = new IngatlanokDetailsPageTabs(getDriver());
        ingatlanokDetailsPageTabs.
                clickOnMuszakiAdatokTab();
        IngatlanokDetailsMuszakiAdatok ingatlanokDetailsMuszakiAdatok = new IngatlanokDetailsMuszakiAdatok(getDriver());
        ingatlanokDetailsMuszakiAdatok.
                clickOnAdatokSzerkeszteseBtn().
                scrollUp().
                setUjMuszakiAdatok(ujMuszakiAdatok).
                clickOnMentesBtn();

        //szerződés felvétele
        sideMenu.
                navigateToSzerzodesekPanel();
        UjSzerzodes ujSzerzodes = deserializeJson("ujSzerzodes.json", UjSzerzodes.class);
        String szerzodesSzam = "Teszt Szerződésszám" + new FakerUtils().generateRandomNumber();
        SzerzodesekPage szerzodesekPage = new SzerzodesekPage(getDriver());
        szerzodesekPage.
                clickOnUjSzerzodesFelveteleBtn().
                enterTextToSzerzodesszamFld(szerzodesSzam).
                setUjSzerzodes(ujSzerzodes).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        szerzodesekPage.clickOnElsoElem(szerzodesSzam, "1");

        //szerződés //Ingatlanok és eladási árak
        SzerzodesekDetailsTabs szerzodesekDetailsTabs = new SzerzodesekDetailsTabs(getDriver());
        szerzodesekDetailsTabs.
                clickOnIngatlanokEsEladasiArakTab();

        SzerzodesekDetailsIngatlanokEsEladasiArak szerzodesekDetailsIngatlanokEsEladasiArak = new SzerzodesekDetailsIngatlanokEsEladasiArak(getDriver());
        szerzodesekDetailsIngatlanokEsEladasiArak.
                clickOnIngaltlHozzarendelewseASzerzhezBtn();
        Assert.assertFalse(szerzodesekDetailsIngatlanokEsEladasiArak.eladasiArakMegadasaAKijelolteknelBtnKattinthato());

        szerzodesekDetailsIngatlanokEsEladasiArak.
                selectCheckboxFelvettIngatlan(megnevezes);
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.eladasiArakMegadasaAKijelolteknelBtnKattinthato());

        szerzodesekDetailsIngatlanokEsEladasiArak.
                clickOnEladasiArakMegadasaAKijelolteknelBtn();
        Assert.assertFalse(szerzodesekDetailsIngatlanokEsEladasiArak.hozzarendelesBtnKattinthato());

        String nettoEladasiAr = "10000000";
        szerzodesekDetailsIngatlanokEsEladasiArak.
                enterToNettoEladasiArFld(nettoEladasiAr).
                clickOnHozzarendelesBtn();
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.ingatlanokHozzarendeleseSzerzodeshezSzoveg());
        szerzodesekDetailsIngatlanokEsEladasiArak.
                clickOnHozzarendelesBtnAblakon();
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.popupMegjelenik("Sikeres hozzárendelés!"));
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.ingatlanMegjATablBan(megnevezes, "3"));

        //Szerződő partnerek
        szerzodesekDetailsTabs.
                clickOnSzerzodoPartnerekTab();
        SzerzodesekDetailsSzerzodoPartnerek szerzodesekDetailsSzerzodoPartnerek = new SzerzodesekDetailsSzerzodoPartnerek(getDriver());

        Thread.sleep(2000);
        szerzodesekDetailsSzerzodoPartnerek.
                clickOnHozzarendBtn().
                selectCheckboxFelvettPartner(partnerNeve).
                clickOnHozzarendelesKijeloltBtn();
        Assert.assertTrue(szerzodesekDetailsSzerzodoPartnerek.popupMegjelenik("Sikeres hozzárendelés!"));
        Assert.assertTrue(szerzodesekDetailsSzerzodoPartnerek.ingatlanMegjATablBan(partnerNeve, "2"));

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

        String lejaratiTipus = "Nem értelmezhető";
        szurok.
                clickOnSzurokTorleseBtn().
                selectLejaratiTipusFromDropDown(lejaratiTipus).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsSzerzodesek.szerzodesMegjelenikATablBan(szerzodesSzam, "1"));

        String ervenyKezdeteDatum = "2022. 01. 05. - 2022. 01. 13.";
        String ervenyVegeDatum = "2022. 02. 15. - 2022. 02. 18.";
        szurok.
                clickOnSzurokTorleseBtn().
                selectDateFromErvenyessegKezdDropDown(ervenyKezdeteDatum).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsSzerzodesek.nincsMegjAdatMegj());

        szurok.
                clickOnSzurokTorleseBtn().
                selectDateFromErvenyessegVegeDropDown(ervenyVegeDatum).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsSzerzodesek.nincsMegjAdatMegj());


        String statusz = "Piszkozat";
        szurok.
                clickOnSzurokTorleseBtn().
                selectStatuszFromDropDown(statusz).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsSzerzodesek.szerzodesMegjelenikATablBan(statusz,"7"));
        Assert.assertFalse(partnerekDetailsSzerzodesek.szerzodesMegjelenikATablBan("Érvénytelen", "7"));

    }

    @Test
    public void Szamlak_tab_kereses() throws InterruptedException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");

        //partner fölvétele
        SideMenu sideMenu = new SideMenu(getDriver()).
                navigateToPartnerekPanel();
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
        String szamlaSorszam = "Számla Sorszama Teszt" + new FakerUtils().generateRandomNumber();
        String szamlaTipusa = "Egyéb számla";
        String szallito = "Nincs megadva";
        String vevo = "Nincs megadva";
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
        Assert.assertTrue(szamlakPage.popUpMegjelenik("Sikeres létrehozás!"));
        szamlakPage.
                selectSzamlaFromTabla(szamlaSorszam, "1");
        SzamlakDetailsPageTabs szamlakDetailsPageTabs = new SzamlakDetailsPageTabs(getDriver());
        szamlakDetailsPageTabs.
                clickOnPartnerekTab();
        SzamlakDetailsPartnerek szamlakDetailsPartnerek = new SzamlakDetailsPartnerek(getDriver());
        szamlakDetailsPartnerek.
                clickOnHozzarendelesBtn().
                clickOnCheckBox(partnerNeve).
                clickOnHozzarendleseKijBtn();
        Assert.assertTrue(szamlakPage.popUpMegjelenik("Sikeres hozzárendelés!"));

        //szűrés
        sideMenu.navigateToPartnerekPanel();
        partnerekPage.
                clickOnListaElsoEleme(partnerNeve, "1");

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
        Assert.assertTrue(partnerekDetailsSzamlak.nincsMegjelenithetoAdat());

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToSzallitoFldPartnSzamlak(szallito).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsSzamlak.nincsMegjelenithetoAdat());

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String szamlaKiallitasDatuma = sdf.format(date);
        szurok.
                clickOnSzurokTorleseBtn().
                enterDateToKiallitasDatumaFld(szamlaKiallitasDatuma+" - "+szamlaKiallitasDatuma).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsSzamlak.nincsMegjelenithetoAdat());

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
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        //ingatlanhoz szervezet felvétele
        SideMenu sideMenu = new SideMenu(getDriver());
        sideMenu.
                navigateToPartnerekPanel();
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
        szervezetekPage.enterSzervezetAzonositoFld(szervezetAzon);
        szervezetekPage.selectKapcsolodoPartnerFromDropDown(partnerNeve);
        szervezetekPage.clickOnFelvetelBtn();


        //közmű partner felvétele a Mérőórához
        sideMenu.
                navigateToPartnerekPanel();
        String kozmuPartnerNeve = "Közmű Partner Teszt Mérőórához" + new FakerUtils().generateRandomNumber();
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
        Thread.sleep(2000);
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
        Assert.assertTrue(ingatlanokPage.ingatlanMegjATabl(megnevezes, "2"));

        ingatlanokPage.
                clickOnElsoIngatlan(megnevezes, "2");
        IngatlanokDetailsPageTabs ingatlanokDetailsPageTabs = new IngatlanokDetailsPageTabs(getDriver()).
                clickOnEszkozokTab();
        IngatlanokDetailsEszkozok ingatlanokDetailsEszkozok = new IngatlanokDetailsEszkozok(getDriver());

        String oratipus ="Villanyóra";
        String gyariSzam = "Gyári szám" + new FakerUtils().generateRandomNumber();
        String meresiPontAzon = "Nincs megadva";
        String legutobbiRogzites = "2022. 02. 08.";

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
        Assert.assertTrue(ingatlanokDetailsEszkozok.popUpMegjelenik("Sikeres létrehozás!"));

        //szervizelésért felelős partner beállítása

        //Közmű partner - Merőórák tab Szűrők
        sideMenu.
                navigateToPartnerekPanel();
        partnerekPage.
                clickOnListaElsoEleme(kozmuPartnerNeve, "1");
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

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToHrszFldPartnMero(hrsz).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsMeroorak.merooraMegjelenikATablazatban(hrsz, "3"));

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToMeresiPontAzonPartnMero(meresiPontAzon).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsMeroorak.nincsMegjelenithetoAdatFelirat());

        szurok.
                clickOnSzurokTorleseBtn().
                enterDateToLegutobbiRogzitesFld(legutobbiRogzites).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsMeroorak.nincsMegjelenithetoAdatFelirat());
    }


    @Test
    public void Eszkozok_tab_ATM_ek_kereses() throws IOException {
        //Partner felvétele
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToPartnerekPanel();
        String partnerNeve = "Szervizelésért Felelős Teszt Partner" + new FakerUtils().generateRandomNumber();
        String telefonszam = "06202102121";
        String email = "email@gmail.com";
        PartnerekPage partnerekPage = new PartnerekPage(getDriver()).
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(partnerNeve).
                enterTelefonszFld(telefonszam).
                enterEmailFld(email).
                selectKozmuChb().
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
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres létrehozás!"));
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
        String telepules = "Szeged";
        String kozteruletNeve = "Mátyás";
        String beepitettseg = "N/A";
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
        Assert.assertTrue(partnerekDetailsEszkozok.nincsMegjelenithetoAdatFeliratMegjelenik());

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToTelepulesFldAtmAdatlap(telepules).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsEszkozok.nincsMegjelenithetoAdatFeliratMegjelenik());

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToKozteruletNeveFldAtmAdatlap(kozteruletNeve).
                clickOnKeresesBtn();
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
        Assert.assertTrue(partnerekDetailsEszkozok.nincsMegjelenithetoAdatFeliratMegjelenik());

        szurok.
                clickOnSzurokTorleseBtn().
                selectStatuszFromDropDownAtmAdatlap(statusz).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsEszkozok.elemMegjelenikATablazatban(statusz, "6"));
    }

    @Test
    public void Banktechnikai_eszkozok_kereses(){
        //Partner felvétele
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).
                navigateToPartnerekPanel();
        String partnerNeve = "Teszt Közmű Partner" + new FakerUtils().generateRandomNumber();
        String telefonszam = "06202102121";
        String email = "email@gmail.com";
        PartnerekPage partnerekPage = new PartnerekPage(getDriver()).
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(partnerNeve).
                enterTelefonszFld(telefonszam).
                enterEmailFld(email).
                selectKozmuChb().
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
        String leltariSzam = "Leltári szám teszt" + new FakerUtils().generateRandomNumber();
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
                clickOnSzurokBtn().
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
                enterTextToTelepulesFldPartnerAdatlapBanktechEszk(telepules).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsEszkozok.nincsMegjelenithetoAdatFeliratMegjelenik());

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToKoztNeveFldPartnerAdatlapBanktechEszk(kozteruletNeve).
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
        String partnerNeve = "Szervizelésért felelős Teszt Partner" + new FakerUtils().generateRandomNumber();
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
                clickOnBankbiztEszkTab();

        eszkozokPage.
                clickOnUjEszkozFelveteleBtn();

        String megnevezes = "Bankbiztonsági eszköz teszt" + new FakerUtils().generateRandomNumber();
        String leltariSzam = "Leltári szám teszt" + new FakerUtils().generateRandomNumber();
        String eszkozcsoport = "Kamerarendszer";
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
                clickOnSzurokBtn().
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
                enterTextToTelepulesFldPartnerAdatlapBankbiztEszk(telepules).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsEszkozok.nincsMegjelenithetoAdatFeliratMegjelenik());

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToKoztNeveBankbiztFld(kozteruletNeve).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsEszkozok.nincsMegjelenithetoAdatFeliratMegjelenik());

        szurok.
                clickOnSzurokTorleseBtn().
                selectFromStatuszDropDownPartnerAdatlapBankbiztEszk(statusz).
                clickOnKeresesBtn();
        Assert.assertTrue(partnerekDetailsEszkozok.elemMegjelenikATablazatban(statusz, "6"));
    }

}
