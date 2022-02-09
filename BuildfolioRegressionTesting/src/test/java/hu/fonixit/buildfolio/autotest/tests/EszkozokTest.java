package hu.fonixit.buildfolio.autotest.tests;


import hu.fonixit.buildfolio.autotest.base.BaseTest;
import hu.fonixit.buildfolio.autotest.objects.UjAtmAlapadatok;
import hu.fonixit.buildfolio.autotest.objects.UjBankbiztonsagiEszkoz;
import hu.fonixit.buildfolio.autotest.objects.UjBanktechnikaiEszkoz;
import hu.fonixit.buildfolio.autotest.objects.UjIngatlan;
import hu.fonixit.buildfolio.autotest.pages.*;
import hu.fonixit.buildfolio.autotest.pages.components.*;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.EszkozokDetailsPages.EszkozokDetailsAtm;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.EszkozokDetailsPages.EszkozokDetailsBankbiztonsagiEszkozok;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.EszkozokDetailsPages.EszkozokDetailsBanktecknikaiEszkozok;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.IgenyekDetailsPages.IgenyekDetailsAlapadatok;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.IgenyekDetailsPages.IgenyekDetailsEszkozok;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.IngatlanokDetailsPages.IngatlanokDetailsEszkozok;
import hu.fonixit.buildfolio.autotest.utils.FakerUtils;
import hu.fonixit.buildfolio.autotest.utils.UserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


import static hu.fonixit.buildfolio.autotest.utils.JacksonUtils.deserializeJson;

public class EszkozokTest extends BaseTest {

    @Test
    public void eszkozok_menu_ATMek_ful_kereses() throws IOException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());
        //Szervizelesért felelős partner megadása
        sideMenu.
                navigateToPartnerekPanel();
        PartnerekPage partnerekPage = new PartnerekPage(getDriver());
        String szervFelPartnerNeve = "Teszt Szervizelésért felelős partner" + new FakerUtils().generateRandomNumber();
        String szervFelPartnerTelefonszam = "06202102121";
        String szervFelPartnerEmail = "emailvevo@gmail.com";
        sideMenu.
                navigateToPartnerekPanel();
        partnerekPage.
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(szervFelPartnerNeve).
                enterTelefonszFld(szervFelPartnerTelefonszam).
                enterEmailFld(szervFelPartnerEmail).
                clickOnFelvetelBtn();
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(szervFelPartnerNeve, "1"));
        //ATM felvétele
        sideMenu.
                navigateToEszkozokPanel();
        EszkozokPage eszkozokPage = new EszkozokPage(getDriver());
        String gyariSzam = "Gyári szám teszt" + new FakerUtils().generateRandomNumber();
        String tipus = "Atm teszt";
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
        //-alapadatok kitöltése
        EszkozokDetailsAtm eszkozokDetailsAtm = new EszkozokDetailsAtm(getDriver());
        UjAtmAlapadatok ujAtmAlapadatok = deserializeJson("ujAtmAlapadatok.json", UjAtmAlapadatok.class);

        eszkozokDetailsAtm.
                clickOnAdatokSzerkeszteseBtn().
                selectPartnerFromSzervizertFelPartnerDropDown(szervFelPartnerNeve).
                setUjAtmAlapadatok(ujAtmAlapadatok).
                clickOnMentesBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres rögzítés!"));

        //Szűrés
        sideMenu.
                navigateToEszkozokPanel();
        String iranyitoszam = "Nincs megadva";
        String varos = "Nincs megadva";
        String kozteruletNeve = "Nincs megadva";
        String beepitettseg = "N/A";
        Szurok szurok = new Szurok(getDriver());
        szurok.
                clickOnSzurokBtn().
                enterTextToTipusFldAtmAdatlap(tipus).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(tipus, "1"));

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToGyariSzamAtmAdatlap(gyariSzam).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(gyariSzam,"2"));

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToIranyitoszamFldAtmAdatlap(iranyitoszam).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokPage.nincsMegjAdatFeliratMegj());

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToIranyitoszamFldAtmAdatlap(varos).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokPage.nincsMegjAdatFeliratMegj());

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToIranyitoszamFldAtmAdatlap(kozteruletNeve).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokPage.nincsMegjAdatFeliratMegj());

        szurok.
                clickOnSzurokTorleseBtn().
                selectBeepitettsegFromDropDownAtmAdatlap(beepitettseg).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(beepitettseg, "4"));
        szurok.
                clickOnSzurokTorleseBtn().
                selectStatuszFromDropDownAtmAdatlap(statusz).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(statusz, "6"));
    }

    @Test
    public void eszkozok_menu_ATMek_ful_Uj_ATM_felvetele(){
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());
        sideMenu.
                navigateToEszkozokPanel();
        //ATM felvétele
        String gyariSzam = "Gyári szám teszt" + new FakerUtils().generateRandomNumber();
        String tipus = "tipus teszt";
        String statusz = "N/A";
        EszkozokPage eszkozokPage = new EszkozokPage(getDriver());
        eszkozokPage.
                clickOnUjAtmFelveteleBtn().
                enterTextToGyariSzamFld(gyariSzam).
                enterTextToTipusFld(tipus).
                selectStatuszFromDropDown(statusz).
                clickOnFelvetelBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres létrehozás!"));
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(tipus, "1"));
    }

    @Test
    public void atm_alapadatok_szerkesztese() throws IOException, InterruptedException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        //Szervizelésért felelős partner felvétele
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
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(partnerNeve, "1"));
        //ATM felvétele
        sideMenu.
                navigateToEszkozokPanel();
        String gyariSzam = "Gyári szám teszt" + new FakerUtils().generateRandomNumber();
        String tipus = "tipus teszt";
        String statusz = "N/A";
        EszkozokPage eszkozokPage = new EszkozokPage(getDriver());
        eszkozokPage.
                clickOnUjAtmFelveteleBtn().
                enterTextToGyariSzamFld(gyariSzam).
                enterTextToTipusFld(tipus).
                selectStatuszFromDropDown(statusz).
                clickOnFelvetelBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres létrehozás!"));
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(tipus, "1"));
        getDriver().navigate().refresh();
        eszkozokPage.elemKivalasztasaATablazatbol(gyariSzam, "2");
        //ATM alapadatok szerkesztése
        UjAtmAlapadatok ujAtmAlapadatok = deserializeJson("ujAtmAlapadatok.json", UjAtmAlapadatok.class);
        EszkozokDetailsAtm eszkozokDetailsAtm = new EszkozokDetailsAtm(getDriver());
        eszkozokDetailsAtm.
                clickOnAdatokSzerkeszteseBtn().
                setUjAtmAlapadatok(ujAtmAlapadatok).
                selectPartnerFromSzervizertFelPartnerDropDown(partnerNeve).
                clickOnMentesBtn();
        Assert.assertTrue(eszkozokDetailsAtm.popUpUzenetMegjelenik("Sikeres rögzítés!"));
        String statusz2 = "Felfüggesztett";
        eszkozokDetailsAtm.
                clickOnAdatokSzerkeszteseBtn().
                selectStatuszFromDropDown(statusz2).
                clickOnMentesBtn();
        Assert.assertTrue(eszkozokDetailsAtm.popUpUzenetMegjelenik("Sikeres rögzítés!"));
        Thread.sleep(6000);
        eszkozokDetailsAtm.
                clickOnAdatokSzerkeszteseBtn().
                enterDatumToAktivalasIdopontjaFld("2022. 01. 27.").
                enterDatumToFelfuggesztesKezdeteFld("2022. 01. 07.").
                enterDatumToFelfuggesztesVegeFld("2022. 01. 04.").
                clickOnMentesBtn();
        Assert.assertTrue(eszkozokDetailsAtm.popUpUzenetMegjelenik("A Felfüggesztés kezdete nem lehet korábbi, mint az Aktiválás időpontja!"));
        Assert.assertTrue(eszkozokDetailsAtm.popUpUzenetMegjelenik("A Felfüggesztés vége nem lehet korábbi, mint a Felfüggesztés kezdete!"));
        eszkozokDetailsAtm.
                clearAktivalasIdopontjaFld().
                clearFelfuggesztesKezdeteFld().
                clearFelfuggesztesVegeFld().
                enterDatumToAktivalasIdopontjaFld("2022. 01. 04.").
                enterDatumToFelfuggesztesKezdeteFld("2022. 01. 07.").
                enterDatumToFelfuggesztesVegeFld("2022. 01. 04.").
                clickOnMentesBtn();
        Assert.assertTrue(eszkozokDetailsAtm.popUpUzenetMegjelenik("Sikeres rögzítés!"));
    }

    @Test
    public void ingatlanhoz_rendelt_ATM_alapadatok_szerkesztes() throws IOException, InterruptedException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());

        //Szervezet+Partner felvétele(az ingatlanhoz)
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
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.enterSzervezetAzonositoFld(szervezetAzon);
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.selectKapcsolodoPartnerFromDropDown(partnerNeve);
        Assert.assertTrue(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.clickOnFelvetelBtn();

        //Ingatlan felvétele
        IngatlanokPage ingatlanokPage = new IngatlanokPage(getDriver());
        UjIngatlan ujIngatlan = deserializeJson("ujIngatlan.json", UjIngatlan.class);
        sideMenu.
                navigateToIngatlanokPanel();
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

        //ATM fölvétele
        //Szervizelesért felelős partner megadása
        String szervFelPartnerNeve = "Teszt Szervizelésért felelős partner" + new FakerUtils().generateRandomNumber();
        String szervFelPartnerTelefonszam = "06202102121";
        String szervFelPartnerEmail = "emailvevo@gmail.com";
        sideMenu.
                navigateToPartnerekPanel();
        partnerekPage.
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(szervFelPartnerNeve).
                enterTelefonszFld(szervFelPartnerTelefonszam).
                enterEmailFld(szervFelPartnerEmail).
                clickOnFelvetelBtn();
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(szervFelPartnerNeve, "1"));
        sideMenu.
                navigateToEszkozokPanel();
        EszkozokPage eszkozokPage = new EszkozokPage(getDriver());
        String gyariSzam = "Gyári szám teszt" + new FakerUtils().generateRandomNumber();
        String tipus = "Atm teszt";
        String statusz = "Raktáron";
        eszkozokPage.
                clickOnUjAtmFelveteleBtn().
                enterTextToGyariSzamFld(gyariSzam).
                enterTextToTipusFld(tipus).
                selectStatuszFromDropDown(statusz).
                clickOnFelvetelBtn();
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(gyariSzam, "2"));
        eszkozokPage.
                elemKivalasztasaATablazatbol(gyariSzam, "2");
        //-alapadatok kitöltése
        EszkozokDetailsAtm eszkozokDetailsAtm = new EszkozokDetailsAtm(getDriver());
        UjAtmAlapadatok ujAtmAlapadatok = deserializeJson("ujAtmAlapadatok.json", UjAtmAlapadatok.class);
        eszkozokDetailsAtm.
                clickOnAdatokSzerkeszteseBtn().
                selectPartnerFromSzervizertFelPartnerDropDown(szervFelPartnerNeve).
                setUjAtmAlapadatok(ujAtmAlapadatok).
                clickOnMentesBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres rögzítés!"));
        Thread.sleep(2000);
        //ATM ingatlanhoz rendelése
        sideMenu.
                navigateToIngatlanokPanel();
        ingatlanokPage.
                selectIngatlanFromTablazat(megnevezes, "2");
        IngatlanokDetailsPageTabs ingatlanokDetailsPageTabs = new IngatlanokDetailsPageTabs(getDriver());
        ingatlanokDetailsPageTabs.
                clickOnEszkozokTab();
        IngatlanokDetailsEszkozok ingatlanokDetailsEszkozok = new IngatlanokDetailsEszkozok(getDriver());
        ingatlanokDetailsEszkozok.
                clickOnHozzarendelesBtn().
                checkboxKivalasztasa(tipus).
                clickOnHozzarendelesKijeloltBtn();
        Assert.assertTrue(ingatlanokDetailsEszkozok.popUpMegjelenik("Sikeres hozzárendelés!"));

        /*//Külső helyszín megadása
        sideMenu.
                navigateToEszkozokPanel();
        eszkozokPage.
                elemKivalasztasaATablazatbol(tipus, "1");
        eszkozokDetailsAtm.
                clickOnAdatokSzerkeszteseBtn().
                clickOnKulsoHelyszinChBox().
                clickOnIgenBtn().
                enterTextToIrSzamFld("6720").
                enterTextToVarosFld("Szeged").
                enterTextToKozteruletNeve("Mátyás").
                selectKoztTipusaFromDropDown("tér").
                enterTextToHazszamFld("10").
                clickOnMentesBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres rögzítés!"));*/
    }

    @Test
    public void atm_alapadatok_szerkesztes_statusz() throws IOException, InterruptedException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());

        //Szervezet+Partner felvétele(az ingatlanhoz)
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
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.enterSzervezetAzonositoFld(szervezetAzon);
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.selectKapcsolodoPartnerFromDropDown(partnerNeve);
        Assert.assertTrue(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.clickOnFelvetelBtn();
        Thread.sleep(2000);
        //Ingatlan felvétele
        IngatlanokPage ingatlanokPage = new IngatlanokPage(getDriver());
        UjIngatlan ujIngatlan = deserializeJson("ujIngatlan.json", UjIngatlan.class);
        sideMenu.
                navigateToIngatlanokPanel();
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

        //ATM fölvétele
        //Szervizelesért felelős partner megadása
        sideMenu.
                navigateToPartnerekPanel();
        String szervFelPartnerNeve = "Teszt Szervizelésért felelős partner" + new FakerUtils().generateRandomNumber();
        String szervFelPartnerTelefonszam = "06202102121";
        String szervFelPartnerEmail = "emailvevo@gmail.com";
        sideMenu.
                navigateToPartnerekPanel();
        partnerekPage.
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(szervFelPartnerNeve).
                enterTelefonszFld(szervFelPartnerTelefonszam).
                enterEmailFld(szervFelPartnerEmail).
                clickOnFelvetelBtn();
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(szervFelPartnerNeve, "1"));
        sideMenu.
                navigateToEszkozokPanel();
        EszkozokPage eszkozokPage = new EszkozokPage(getDriver());
        String gyariSzam = "Gyári szám teszt" + new FakerUtils().generateRandomNumber();
        String tipus = "Atm teszt";
        String statusz = "Raktáron";
        eszkozokPage.
                clickOnUjAtmFelveteleBtn().
                enterTextToGyariSzamFld(gyariSzam).
                enterTextToTipusFld(tipus).
                selectStatuszFromDropDown(statusz).
                clickOnFelvetelBtn();
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(gyariSzam, "2"));
        eszkozokPage.
                elemKivalasztasaATablazatbol(gyariSzam, "2");
        //-alapadatok kitöltése
        EszkozokDetailsAtm eszkozokDetailsAtm = new EszkozokDetailsAtm(getDriver());
        UjAtmAlapadatok ujAtmAlapadatok = deserializeJson("ujAtmAlapadatok.json", UjAtmAlapadatok.class);
        eszkozokDetailsAtm.
                clickOnAdatokSzerkeszteseBtn().
                selectPartnerFromSzervizertFelPartnerDropDown(szervFelPartnerNeve).
                setUjAtmAlapadatok(ujAtmAlapadatok).
                clickOnMentesBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres rögzítés!"));

        //ATM ingatlanhoz rendelése
        sideMenu.
                navigateToIngatlanokPanel();
        ingatlanokPage.
                selectIngatlanFromTablazat(megnevezes, "2");
        IngatlanokDetailsPageTabs ingatlanokDetailsPageTabs = new IngatlanokDetailsPageTabs(getDriver());
        ingatlanokDetailsPageTabs.
                clickOnEszkozokTab();
        IngatlanokDetailsEszkozok ingatlanokDetailsEszkozok = new IngatlanokDetailsEszkozok(getDriver());
        ingatlanokDetailsEszkozok.
                clickOnHozzarendelesBtn().
                checkboxKivalasztasa(tipus).
                clickOnHozzarendelesKijeloltBtn();
        Assert.assertTrue(ingatlanokDetailsEszkozok.popUpMegjelenik("Sikeres hozzárendelés!"));

        //Státusz mező átállítása Lekapcsoltra
        ingatlanokDetailsEszkozok.
                elemKivalasztasaATablazatbol(tipus, "2");
        eszkozokDetailsAtm.
                clickOnAdatokSzerkeszteseBtn().
                selectStatuszFromDropDown("Lekapcsolt").
                megjelenikGyartasIdopontjaFld().
                megjelenikBeszerzesIdopontjaFld().
                megjelenikAktivalasIdopontjaFld().
                megjelenikFelfuggesztesKezdeteFld().
                megjelenikFelfuggesztesVegeFld().
                megkelenikLekapcsolasIdopontjaFld().
                megjelenikSelejtezesIdopontjaBtn();
    }

    @Test
    public void atm_adatlap_Bankbiztonsagi_eszkozok_kereses() throws IOException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());

        //Szervezet+Partner felvétele(az ingatlanhoz)
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
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.enterSzervezetAzonositoFld(szervezetAzon);
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.selectKapcsolodoPartnerFromDropDown(partnerNeve);
        Assert.assertTrue(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.clickOnFelvetelBtn();

        //Ingatlan felvétele
        IngatlanokPage ingatlanokPage = new IngatlanokPage(getDriver());
        UjIngatlan ujIngatlan = deserializeJson("ujIngatlan.json", UjIngatlan.class);
        sideMenu.
                navigateToIngatlanokPanel();
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

        //ATM fölvétele
        //Szervizelesért felelős partner megadása
        String szervFelPartnerNeve = "Teszt Szervizelésért felelős partner" + new FakerUtils().generateRandomNumber();
        String szervFelPartnerTelefonszam = "06202102121";
        String szervFelPartnerEmail = "emailvevo@gmail.com";
        sideMenu.
                navigateToPartnerekPanel();
        partnerekPage.
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(szervFelPartnerNeve).
                enterTelefonszFld(szervFelPartnerTelefonszam).
                enterEmailFld(szervFelPartnerEmail).
                clickOnFelvetelBtn();
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(szervFelPartnerNeve, "1"));
        sideMenu.
                navigateToEszkozokPanel();
        EszkozokPage eszkozokPage = new EszkozokPage(getDriver());
        String gyariSzam = "Gyári szám teszt" + new FakerUtils().generateRandomNumber();
        String tipus = "Atm teszt";
        String statusz = "Aktív";
        eszkozokPage.
                clickOnUjAtmFelveteleBtn().
                enterTextToGyariSzamFld(gyariSzam).
                enterTextToTipusFld(tipus).
                selectStatuszFromDropDown(statusz).
                clickOnFelvetelBtn();
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(gyariSzam, "2"));

        //Banbiztonsági eszköz fölvétele (Raktáron)
        UjBankbiztonsagiEszkoz ujBankbiztonsagiEszkoz = deserializeJson("ujBankbiztonsagiEszkoz.json", UjBankbiztonsagiEszkoz.class);
        String megnevezesBankbizEszk = "Atm belső biztonsági kamera";
        String leltariszamBankbizEszk = "LE-012 Bankbiztonsági eszköz" + new FakerUtils().generateRandomNumber();
        EszkozokDetailsPageTabs eszkozokDetailsPageTabs = new EszkozokDetailsPageTabs(getDriver());
        eszkozokDetailsPageTabs.
                clickOnBankbiztEszkTab();
        eszkozokPage.
                clickOnUjEszkozFelveteleBtn().
                enterTextToMegnevezesFld(megnevezesBankbizEszk).
                enterTextToLeltariSzamFld(leltariszamBankbizEszk).
                setUjBankbiztonsagiEszkoz(ujBankbiztonsagiEszkoz).
                clickOnFelvetelBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres létrehozás!"));

        //Bankbiztonsági eszköz hozzárendelése Atm-hez
        EszkozokPageTabs eszkozokPageTabs = new EszkozokPageTabs(getDriver());
        eszkozokPageTabs.
                clickOnAtmekTab();
        eszkozokPage.
                elemKivalasztasaATablazatbol(tipus, "1");
        EszkozokDetailsAtmPageTabs eszkozokDetailsAtmPageTabs = new EszkozokDetailsAtmPageTabs(getDriver());
        eszkozokDetailsAtmPageTabs.
                clickOnBankbiztonsagieszkozokTab();
        EszkozokDetailsAtm eszkozokDetailsAtm = new EszkozokDetailsAtm(getDriver());
        eszkozokDetailsAtm.
                clickOnHozzarendelesBtn().
                eszkozKivalasztasaChBox(megnevezesBankbizEszk).
                clickOnHozzarendelesKijelBtn();
        Assert.assertTrue(eszkozokDetailsAtm.popUpUzenetMegjelenik("Sikeres hozzárendelés!"));

        //ATM adatlap - Bankbiztonsági eszköz - Szűrés
        String tipusBankbiztEszk = "Tesla intelligens IP kamera";
        String eszkozCsoport = "ATM belső kamera";
        String statuszBankBiztEszk = "N/A";
        Szurok szurok = new Szurok(getDriver());
        szurok.
                clickOnSzurokBtn().
                enterTextToMegnevezesFldBankbiztEszk(megnevezesBankbizEszk).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokDetailsAtm.elemMegjelenikATablazatban(megnevezesBankbizEszk, "2"));

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToLeltariSzamFldBankbiztEszk(leltariszamBankbizEszk).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokDetailsAtm.elemMegjelenikATablazatban(leltariszamBankbizEszk, "3"));

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToTipusFldBankbiztEszk(tipusBankbiztEszk).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokDetailsAtm.elemMegjelenikATablazatban(tipusBankbiztEszk, "4"));

        szurok.
                clickOnSzurokTorleseBtn().
                selectFromEszkozcsoportDropDownBankbiztEszk(eszkozCsoport).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokDetailsAtm.elemMegjelenikATablazatban(eszkozCsoport, "5"));

        szurok.
                clickOnSzurokTorleseBtn().
                selectStatuszFromDropDown(statuszBankBiztEszk).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokDetailsAtm.elemMegjelenikATablazatban(statuszBankBiztEszk, "7"));
    }

  /*  @Test
    public void atm_adatlap_Bankbiztonsagi_eszkoz_eltavolitasa_a_listabol() throws IOException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());

        //Szervezet+Partner felvétele(az ingatlanhoz)
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
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.enterSzervezetAzonositoFld(szervezetAzon);
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.selectKapcsolodoPartnerFromDropDown(partnerNeve);
        Assert.assertTrue(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.clickOnFelvetelBtn();

        //Ingatlan felvétele
        IngatlanokPage ingatlanokPage = new IngatlanokPage(getDriver());
        UjIngatlan ujIngatlan = deserializeJson("ujIngatlan.json", UjIngatlan.class);
        sideMenu.
                navigateToIngatlanokPanel();
        ingatlanokPage.clickOnUjIngatlanFelveteleBtn();
        String megnevezes = "Teszt Ingatlan" + new FakerUtils().generateRandomNumber();
        ingatlanokPage.
                enterTextToMegnevezesFld(megnevezes).
                setUjIngatlan(ujIngatlan).
                selectElementFromSzervezetDropDown(partnerNeve).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertTrue(ingatlanokPage.ingatlanMegjelATablaban(megnevezes));

        //ATM fölvétele
        //Szervizelesért felelős partner megadása
        sideMenu.
                navigateToPartnerekPanel();
        String szervFelPartnerNeve = "Teszt Szervizelésért felelős partner" + new FakerUtils().generateRandomNumber();
        String szervFelPartnerTelefonszam = "06202102121";
        String szervFelPartnerEmail = "emailvevo@gmail.com";
        sideMenu.
                navigateToPartnerekPanel();
        partnerekPage.
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(szervFelPartnerNeve).
                enterTelefonszFld(szervFelPartnerTelefonszam).
                enterEmailFld(szervFelPartnerEmail).
                clickOnFelvetelBtn();
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(szervFelPartnerNeve, "1"));
        sideMenu.
                navigateToEszkozokPanel();
        EszkozokPage eszkozokPage = new EszkozokPage(getDriver());
        String gyariSzam = "Gyári szám teszt" + new FakerUtils().generateRandomNumber();
        String tipus = "Atm teszt";
        String statusz = "Raktáron";
        eszkozokPage.
                clickOnUjAtmFelveteleBtn().
                enterTextToGyariSzamFld(gyariSzam).
                enterTextToTipusFld(tipus).
                selectStatuszFromDropDown(statusz).
                clickOnFelvetelBtn();
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(gyariSzam, "2"));

        //Banbiztonsági eszköz fölvétele (Raktáron)
        UjBankbiztonsagiEszkoz ujBankbiztonsagiEszkoz = deserializeJson("ujBankbiztonsagiEszkoz.json", UjBankbiztonsagiEszkoz.class);
        String megnevezesBankbizEszk = "Atm belső biztonsági kamera" + new FakerUtils().generateRandomNumber();
        String leltariSzamBankbiztEszk = "LE-010" + new FakerUtils().generateRandomNumber();
        EszkozokDetailsPageTabs eszkozokDetailsPageTabs = new EszkozokDetailsPageTabs(getDriver());
        eszkozokDetailsPageTabs.
                clickOnBankbiztEszkTab();
        eszkozokPage.
                clickOnUjEszkozFelveteleBtn().
                enterTextToMegnevezesFld(megnevezesBankbizEszk).
                enterTextToLeltariSzamFld(leltariSzamBankbiztEszk).
                setUjBankbiztonsagiEszkoz(ujBankbiztonsagiEszkoz).
                clickOnFelvetelBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres létrehozás!"));

        //Bankbiztonsági eszköz hozzárendelése Atm-hez
        eszkozokDetailsPageTabs.
                clickOnAtmekTab();
        getDriver().navigate().refresh();
        eszkozokPage.
                elemKivalasztasaATablazatbol(gyariSzam, "2");
        EszkozokDetailsAtmPageTabs eszkozokDetailsAtmPageTabs = new EszkozokDetailsAtmPageTabs(getDriver());
        eszkozokDetailsAtmPageTabs.
                clickOnBankbiztonsagieszkozokTab();
        EszkozokDetailsAtm eszkozokDetailsAtm = new EszkozokDetailsAtm(getDriver());
        eszkozokDetailsAtm.
                clickOnHozzarendelesBtn().
                eszkozKivalasztasaChBox(megnevezesBankbizEszk).
                clickOnHozzarendelesKijelBtn();
        Assert.assertTrue(eszkozokDetailsAtm.popUpUzenetMegjelenik("Sikeres hozzárendelés!"));

        //Bankbiztonsági eszköz eltávolítása a listából
        getDriver().navigate().refresh();
        eszkozokDetailsAtm.
                hozzarendeltEszkozKivalasztasa(megnevezesBankbizEszk).
                clickOnEltavolitasBtn().
                clickOnTorlesBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres törlés!"));
    }*/

    @Test
    public void atm_adatlap_igenyek_ful() throws IOException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());

        //Szervezet+Partner felvétele(az ingatlanhoz)
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
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.enterSzervezetAzonositoFld(szervezetAzon);
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.selectKapcsolodoPartnerFromDropDown(partnerNeve);
        Assert.assertTrue(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.clickOnFelvetelBtn();

        //Ingatlan felvétele
        IngatlanokPage ingatlanokPage = new IngatlanokPage(getDriver());
        UjIngatlan ujIngatlan = deserializeJson("ujIngatlan.json", UjIngatlan.class);
        String megnevezes = "Teszt Ingatlan" + new FakerUtils().generateRandomNumber();
        sideMenu.
                navigateToIngatlanokPanel();
        ingatlanokPage.
                clickOnUjIngatlanFelveteleBtn().
                enterTextToMegnevezesFld(megnevezes).
                setUjIngatlan(ujIngatlan).
                selectElementFromSzervezetDropDown(partnerNeve).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertTrue(ingatlanokPage.ingatlanMegjATabl(megnevezes, "2"));

        //ATM fölvétele
        //Szervizelesért felelős partner megadása
        sideMenu.
                navigateToPartnerekPanel();
        String szervFelPartnerNeve = "Teszt Szervizelésért felelős partner" + new FakerUtils().generateRandomNumber();
        String szervFelPartnerTelefonszam = "06202102121";
        String szervFelPartnerEmail = "emailvevo@gmail.com";
        sideMenu.
                navigateToPartnerekPanel();
        partnerekPage.
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(szervFelPartnerNeve).
                enterTelefonszFld(szervFelPartnerTelefonszam).
                enterEmailFld(szervFelPartnerEmail).
                clickOnFelvetelBtn();
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(szervFelPartnerNeve, "1"));
        sideMenu.
                navigateToEszkozokPanel();
        EszkozokPage eszkozokPage = new EszkozokPage(getDriver());
        String gyariSzam = "Gyári szám teszt" + new FakerUtils().generateRandomNumber();
        String tipus = "Atm teszt";
        String statusz = "Aktív";
        eszkozokPage.
                clickOnUjAtmFelveteleBtn().
                enterTextToGyariSzamFld(gyariSzam).
                enterTextToTipusFld(tipus).
                selectStatuszFromDropDown(statusz).
                clickOnFelvetelBtn();
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(gyariSzam, "2"));

        //Igény felvétele, felvett igényhez ATM hozzárendelése
        sideMenu.
                navigateToIgenyekPanel();
        String azonosito = "Igények teszt" + new FakerUtils().generateRandomNumber();
        String leiras = "Leírás teszt igény ATM";
        IgenyekPage igenyekPage =  new IgenyekPage(getDriver());
        igenyekPage.
                clickOnUjIgenyekFelvetelBtn().
                enterTextToAzonositoFld(azonosito).
                enterTextToLeirasFld(leiras).
                clickOnFelvetelBtn();
        Assert.assertTrue(igenyekPage.popUpMegjelenik("Sikeres rögzítés!"));
        igenyekPage.
                elemkivalasztasaTablazatbol(azonosito, "1");
        IgenyekDetailsPageTabs igenyekDetailsPageTabs = new IgenyekDetailsPageTabs(getDriver());
        igenyekDetailsPageTabs.
                clickOnEszkozokTab();
        IgenyekDetailsEszkozok igenyekDetailsEszkozok = new IgenyekDetailsEszkozok(getDriver());
        igenyekDetailsEszkozok.
                clickOnHozzarendelesBtn().
                eszkozKivalasztasa(gyariSzam).
                clickOnHozzarendelesKijelBtn();
        Assert.assertTrue(igenyekDetailsEszkozok.popUpMegjelenik("Sikeres hozzárendelés!"));

        //ATM adatlap igények fül
        sideMenu.
                navigateToEszkozokPanel();
        eszkozokPage.
                elemKivalasztasaATablazatbol(gyariSzam, "2");
        EszkozokDetailsAtmPageTabs eszkozokDetailsAtmPageTabs = new EszkozokDetailsAtmPageTabs(getDriver());
        eszkozokDetailsAtmPageTabs.
                clickOnIgenyekTab();

        EszkozokDetailsAtm eszkozokDetailsAtm = new EszkozokDetailsAtm(getDriver());
        eszkozokDetailsAtm.
                elemKivalasztasaTablazatbol(azonosito, "1");
        IgenyekDetailsAlapadatok igenyekDetailsAlapadatok = new IgenyekDetailsAlapadatok(getDriver());
        igenyekDetailsAlapadatok.
                igenyekDetailsOldalonAllunk();
        getDriver().navigate().back();
        eszkozokDetailsAtm.
                eszkozokDetailsAtmOldalonAllunk().
                clickOnVisszaGomb();
        eszkozokPage.
                clickOnUjAtmFelveteleBtn();
    }

    @Test
    public void kereses_az_Atmhez_rendelt_igenyek_kozott(){
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());
        //Atm felvétele
        sideMenu.
                navigateToEszkozokPanel();
        String gyariSzam = "Gyári szám teszt" + new FakerUtils().generateRandomNumber();
        String tipus = "típus teszt";
        String statusz = "N/A";
        EszkozokPage eszkozokPage = new EszkozokPage(getDriver());
        eszkozokPage.
                clickOnUjAtmFelveteleBtn().
                enterTextToGyariSzamFld(gyariSzam).
                enterTextToTipusFld(tipus).
                selectStatuszFromDropDown(statusz).
                clickOnFelvetelBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres létrehozás!"));
        //Igény felvétele
        sideMenu.
                navigateToIgenyekPanel();
        IgenyekPage igenyekPage = new IgenyekPage(getDriver());
        String azonosito = "Teszt azonosító" + new FakerUtils().generateRandomNumber();
        String leiras = "Teszt leírás";
        igenyekPage.
                clickOnUjIgenyekFelvetelBtn().
                enterTextToAzonositoFld(azonosito).
                enterTextToLeirasFld(leiras).
                clickOnFelvetelBtn();
        Assert.assertTrue(igenyekPage.popUpMegjelenik("Sikeres rögzítés!"));
        Assert.assertTrue(igenyekPage.elemMegjelenikATablazatban(azonosito, "1"));
        //Atm hozzárendelése igényhez
        igenyekPage.
                elemkivalasztasaTablazatbol(azonosito, "1");
        IgenyekDetailsPageTabs igenyekDetailsPageTabs = new IgenyekDetailsPageTabs(getDriver());
        igenyekDetailsPageTabs.
                clickOnEszkozokTab();
        IgenyekDetailsEszkozok igenyekDetailsEszkozok = new IgenyekDetailsEszkozok(getDriver());
        igenyekDetailsEszkozok.
                clickOnHozzarendelesBtn().
                eszkozKivalasztasa(gyariSzam).
                clickOnHozzarendelesKijelBtn();
        Assert.assertTrue(igenyekDetailsEszkozok.popUpMegjelenik("Sikeres hozzárendelés!"));
        //Atm adatlap - Igények fül - Szűrés
        sideMenu.
                navigateToEszkozokPanel();
        eszkozokPage.
                elemKivalasztasaATablazatbol(gyariSzam, "2");
       EszkozokDetailsAtmPageTabs eszkozokDetailsAtmPageTabs = new EszkozokDetailsAtmPageTabs(getDriver());
       eszkozokDetailsAtmPageTabs.
               clickOnIgenyekTab();
       EszkozokDetailsAtm eszkozokDetailsAtm = new EszkozokDetailsAtm(getDriver());
       Szurok szurok = new Szurok(getDriver());
       szurok.
               clickOnSzurokBtn().
               enterTextToAzonositoAtmDetailsIgenyekFld(azonosito).
               clickOnKeresesBtn();
       Assert.assertTrue(eszkozokDetailsAtm.elemMegjelenikATablazatban(azonosito, "1"));
       szurok.
               clickOnSzurokTorleseBtn().
               enterTextToAtmDetailsLeirasFld(leiras).
               clickOnKeresesBtn();
       Assert.assertTrue(eszkozokDetailsAtm.elemMegjelenikATablazatban(leiras, "2"));
       Assert.assertFalse(eszkozokDetailsAtm.elemMegjelenikATablazatban("Rossz leírás", "2"));
    }

    @Test
    public void uj_Banktechnikai_eszkoz_felvetele() throws IOException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());
        //Új Banktechnikai Eszköz fölvétele
        UjBanktechnikaiEszkoz ujBanktechnikaiEszkoz = deserializeJson("ujBanktechnikaiEszkoz.json", UjBanktechnikaiEszkoz.class);
        sideMenu.
                navigateToEszkozokPanel();
        EszkozokPageTabs eszkozokPageTabs = new EszkozokPageTabs(getDriver());
        eszkozokPageTabs.
                clickOnBanktechnikaiEszkozokTab();
        String megnevezes = "Bantechnikai eszköz teszt" + new FakerUtils().generateRandomNumber();
        String leltariSzam = "LE-010" + new FakerUtils().generateRandomNumber();
        EszkozokPage eszkozokPage = new EszkozokPage(getDriver());
        eszkozokPage.
                clickOnUjEszkozFelveteleBtn().
                enterTextToMegnevezesFld(megnevezes).
                enterTextToLeltariSzamFld(leltariSzam).
                setUjBankTechnikaiEszkoz(ujBanktechnikaiEszkoz).
                clickOnFelvetelBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres létrehozás!"));
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(megnevezes, "1"));
    }

    @Test
    public void uj_Banktechnikai_eszkoz_felvetele_kotelezo_mezok_kitoltese_nelkul() throws IOException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());
        //Új Banktechnikai Eszköz fölvétele
        UjBanktechnikaiEszkoz ujBanktechnikaiEszkoz = deserializeJson("ujBanktechnikaiEszkoz.json", UjBanktechnikaiEszkoz.class);
        sideMenu.
                navigateToEszkozokPanel();
        EszkozokPageTabs eszkozokPageTabs = new EszkozokPageTabs(getDriver());
        eszkozokPageTabs.
                clickOnBanktechnikaiEszkozokTab();
        String megnevezes = "Bantechnikai eszköz teszt" + new FakerUtils().generateRandomNumber();
        String leltariSzam = "10-200B" + new FakerUtils().generateRandomNumber();
        String eszkozcsoport = "Bankjegyszámláló";
        String tipus = "Bankjegyszámláló eszköz";
        String statusz = "N/A";
        EszkozokPage eszkozokPage = new EszkozokPage(getDriver());
        eszkozokPage.
                clickOnUjEszkozFelveteleBtn().
                enterTextToLeltariSzamFld(leltariSzam).
                setUjBankTechnikaiEszkoz(ujBanktechnikaiEszkoz);
        Assert.assertFalse(eszkozokPage.felvetelGombKattinthato());
        eszkozokPage.
                clickOnMegsemBtn().
                clickOnUjEszkozFelveteleBtn().
                enterTextToMegnevezesFld(megnevezes).
                selectEszkozcsoportFromDropDown(eszkozcsoport).
                enterTextToEszkozTipusFld(tipus).
                selectEszkozStatuszFromDropDown(statusz);
        Assert.assertFalse(eszkozokPage.felvetelGombKattinthato());
        eszkozokPage.
                clickOnMegsemBtn().
                clickOnUjEszkozFelveteleBtn().
                enterTextToMegnevezesFld(megnevezes).
                enterTextToLeltariSzamFld(leltariSzam).
                enterTextToEszkozTipusFld(tipus).
                selectEszkozStatuszFromDropDown(statusz);
        Assert.assertFalse(eszkozokPage.felvetelGombKattinthato());
        eszkozokPage.
                clickOnMegsemBtn().
                clickOnUjEszkozFelveteleBtn().
                enterTextToMegnevezesFld(megnevezes).
                enterTextToLeltariSzamFld(leltariSzam).
                selectEszkozcsoportFromDropDown(eszkozcsoport).
                selectEszkozStatuszFromDropDown(statusz);
        Assert.assertFalse(eszkozokPage.felvetelGombKattinthato());
        eszkozokPage.
                clickOnMegsemBtn().
                clickOnUjEszkozFelveteleBtn().
                enterTextToMegnevezesFld(megnevezes).
                enterTextToLeltariSzamFld(leltariSzam).
                selectEszkozcsoportFromDropDown(eszkozcsoport).
                enterTextToEszkozTipusFld(tipus);
        Assert.assertFalse(eszkozokPage.felvetelGombKattinthato());

    }

    @Test
    public void uj_banktechnikai_eszkoz_felvetelenek_megszakitasa_Megsem_gombbal() throws IOException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());
        //Új Banktechnikai Eszköz fölvétele
        UjBanktechnikaiEszkoz ujBanktechnikaiEszkoz = deserializeJson("ujBanktechnikaiEszkoz.json", UjBanktechnikaiEszkoz.class);
        sideMenu.
                navigateToEszkozokPanel();
        EszkozokPageTabs eszkozokPageTabs = new EszkozokPageTabs(getDriver());
        eszkozokPageTabs.
                clickOnBanktechnikaiEszkozokTab();
        String megnevezes = "Bantechnikai eszköz teszt" + new FakerUtils().generateRandomNumber();
        String leltariSzam = "LE-012" + new FakerUtils().generateRandomNumber();
        EszkozokPage eszkozokPage = new EszkozokPage(getDriver());
        eszkozokPage.
                clickOnUjEszkozFelveteleBtn().
                enterTextToMegnevezesFld(megnevezes).
                enterTextToLeltariSzamFld(leltariSzam).
                setUjBankTechnikaiEszkoz(ujBanktechnikaiEszkoz);
        //Felvétel megszakítása
        eszkozokPage.
                clickOnMegsemBtn();
        Assert.assertFalse(eszkozokPage.eszkozMegjelenikATablazatban(megnevezes, "1"));
    }

    @Test
    public void kereses_a_banktechnikai_eszkozok_kozott() throws IOException { //ELl
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());
        //Új Banktechnikai Eszköz fölvétele (előfeltétel: min 3 db)
        UjBanktechnikaiEszkoz ujBanktechnikaiEszkoz = deserializeJson("ujBanktechnikaiEszkoz.json", UjBanktechnikaiEszkoz.class);
        sideMenu.
                navigateToEszkozokPanel();
        EszkozokPageTabs eszkozokPageTabs = new EszkozokPageTabs(getDriver());
        eszkozokPageTabs.
                clickOnBanktechnikaiEszkozokTab();
        String megnevezes1 = "Bantechnikai eszköz teszt" + new FakerUtils().generateRandomNumber();
        String megnevezes2 = "Bantechnikai eszköz teszt" + new FakerUtils().generateRandomNumber();
        String megnevezes3 = "Bantechnikai eszköz teszt" + new FakerUtils().generateRandomNumber();
        String leltariSzam1 = "LE_BANKTECH 001" + new FakerUtils().generateRandomNumber();
        String leltariSzam2 = "LE_BANKTECH 002" + new FakerUtils().generateRandomNumber();
        String leltariSzam3 = "LE_BANKTECH 003" + new FakerUtils().generateRandomNumber();
        EszkozokPage eszkozokPage = new EszkozokPage(getDriver());
        eszkozokPage.
                clickOnUjEszkozFelveteleBtn().
                enterTextToMegnevezesFld(megnevezes1).
                enterTextToLeltariSzamFld(leltariSzam1).
                setUjBankTechnikaiEszkoz(ujBanktechnikaiEszkoz).
                clickOnFelvetelBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres létrehozás!"));
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(megnevezes1, "1"));
        eszkozokPage.
                clickOnUjEszkozFelveteleBtn().
                enterTextToMegnevezesFld(megnevezes2).
                enterTextToLeltariSzamFld(leltariSzam2).
                setUjBankTechnikaiEszkoz(ujBanktechnikaiEszkoz).
                clickOnFelvetelBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres létrehozás!"));
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(megnevezes2, "1"));
        eszkozokPage.
                clickOnUjEszkozFelveteleBtn().
                enterTextToMegnevezesFld(megnevezes3).
                enterTextToLeltariSzamFld(leltariSzam3).
                setUjBankTechnikaiEszkoz(ujBanktechnikaiEszkoz).
                clickOnFelvetelBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres létrehozás!"));
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(megnevezes3, "1"));
        //Eszközök oldal - Banktechnikai eszközök - Szűrés
        String tipus = "Cashtech 160 UV/MG";
        String eszkozcsoport = "Bankjegyszámláló";
        String statusz = "N/A";
        Szurok szurok = new Szurok(getDriver());
        szurok.
              clickOnSzurokBtn().
                enterTextToMegnevezesFldBanktechEszk(megnevezes1).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(megnevezes1, "1"));
        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToLeltariSzamFldBankbiztEszk(leltariSzam1).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(leltariSzam1, "2"));
        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToTipusFldBankbiztEszk(tipus).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(tipus, "3"));
        szurok.
                clickOnSzurokTorleseBtn().
                selectFromEszkozcsoportDropDownBanktechEszk(eszkozcsoport).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(eszkozcsoport, "4"));
        szurok.
                clickOnSzurokTorleseBtn().
                selectFromStatuszDropDownBanktechEszk(statusz).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(statusz, "6"));
        szurok.
                clickOnSzurokTorleseBtn();
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(megnevezes1, "1"));
    }

    @Test
    public void banktechnikai_eszkoz_alapadatok_szerkesztese() throws IOException { //Ell
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());
        //Szervizelesért felelős partner megadása
        sideMenu.
                navigateToPartnerekPanel();
        PartnerekPage partnerekPage = new PartnerekPage(getDriver());
        String szervFelPartnerNeve = "Teszt Szervizelésért felelős partner" + new FakerUtils().generateRandomNumber();
        String szervFelPartnerTelefonszam = "06202102121";
        String szervFelPartnerEmail = "emailvevo@gmail.com";
        sideMenu.
                navigateToPartnerekPanel();
        partnerekPage.
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(szervFelPartnerNeve).
                enterTelefonszFld(szervFelPartnerTelefonszam).
                enterEmailFld(szervFelPartnerEmail).
                clickOnFelvetelBtn();
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(szervFelPartnerNeve, "1"));
        //Új Banktechnikai Eszköz fölvétele (előfeltétel: legalább 1 db)
        UjBanktechnikaiEszkoz ujBanktechnikaiEszkoz = deserializeJson("ujBanktechnikaiEszkoz.json", UjBanktechnikaiEszkoz.class);
        sideMenu.
                navigateToEszkozokPanel();
        EszkozokPageTabs eszkozokPageTabs = new EszkozokPageTabs(getDriver());
        eszkozokPageTabs.
                clickOnBanktechnikaiEszkozokTab();
        String megnevezes = "Bantechnikai eszköz teszt" + new FakerUtils().generateRandomNumber();
        String leltariSzam = "LE-Banktechnikai eszköz teszt" + new FakerUtils().generateRandomNumber();
        EszkozokPage eszkozokPage = new EszkozokPage(getDriver());
        eszkozokPage.
                clickOnUjEszkozFelveteleBtn().
                enterTextToMegnevezesFld(megnevezes).
                enterTextToLeltariSzamFld(leltariSzam).
                setUjBankTechnikaiEszkoz(ujBanktechnikaiEszkoz).
                clickOnFelvetelBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres létrehozás!"));
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(megnevezes, "1"));
        //Banktechnikai eszköz alapadatok szerkesztése
        eszkozokPage.
                elemKivalasztasaATablazatbol(megnevezes, "1");
        EszkozokDetailsBanktecknikaiEszkozok eszkozokDetailsBanktecknikaiEszkozok = new EszkozokDetailsBanktecknikaiEszkozok(getDriver());
        eszkozokDetailsBanktecknikaiEszkozok.
                clickOnAdatokSzerkeszteseBtn().
                selectFromSzervizertFelelosPartnerDropDown(szervFelPartnerNeve).
                clickOnMegsemBtn().
                clickOnAdatokSzerkeszteseBtn().
                selectFromSzervizertFelelosPartnerDropDown(szervFelPartnerNeve).
                clickOnMentesBtn();
        Assert.assertTrue(eszkozokDetailsBanktecknikaiEszkozok.popUpMegjelenik("Sikeres rögzítés!"));
    }

    @Test
    public void kereses_a_banktechnikai_eszkozokhoz_rendelt_igenyek_kozott() throws IOException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());
        //Új Banktechnikai Eszköz fölvétele (előfeltétel: legalább 1 db)
        UjBanktechnikaiEszkoz ujBanktechnikaiEszkoz = deserializeJson("ujBanktechnikaiEszkoz.json", UjBanktechnikaiEszkoz.class);
        sideMenu.
                navigateToEszkozokPanel();
        EszkozokPageTabs eszkozokPageTabs = new EszkozokPageTabs(getDriver());
        eszkozokPageTabs.
                clickOnBanktechnikaiEszkozokTab();
        String megnevezes = "Bantechnikai eszköz teszt" + new FakerUtils().generateRandomNumber();
        String leltariSzam = "Le-0123" + new FakerUtils().generateRandomNumber();
        EszkozokPage eszkozokPage = new EszkozokPage(getDriver());
        eszkozokPage.
                clickOnUjEszkozFelveteleBtn().
                enterTextToMegnevezesFld(megnevezes).
                enterTextToLeltariSzamFld(leltariSzam).
                setUjBankTechnikaiEszkoz(ujBanktechnikaiEszkoz).
                clickOnFelvetelBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres létrehozás!"));
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(megnevezes, "1"));
        //Igény felvétele (legalább 3 db)
        sideMenu.
                navigateToIgenyekPanel();
        IgenyekPage igenyekPage = new IgenyekPage(getDriver());
        String azonosito1 = "Teszt azonosító" + new FakerUtils().generateRandomNumber();
        String azonosito2 = "Teszt azonosító" + new FakerUtils().generateRandomNumber();
        String azonosito3 = "Teszt azonosító" + new FakerUtils().generateRandomNumber();
        String leiras1 = "Teszt leírás1";
        String leiras2 = "Teszt leírás2";
        String leiras3 = "Teszt leírás3";
        igenyekPage.
                clickOnUjIgenyekFelvetelBtn().
                enterTextToAzonositoFld(azonosito1).
                enterTextToLeirasFld(leiras1).
                clickOnFelvetelBtn();
        Assert.assertTrue(igenyekPage.popUpMegjelenik("Sikeres rögzítés!"));
        Assert.assertTrue(igenyekPage.elemMegjelenikATablazatban(azonosito1, "1"));
        igenyekPage.
                clickOnUjIgenyekFelvetelBtn().
                enterTextToAzonositoFld(azonosito2).
                enterTextToLeirasFld(leiras2).
                clickOnFelvetelBtn();
        Assert.assertTrue(igenyekPage.popUpMegjelenik("Sikeres rögzítés!"));
        Assert.assertTrue(igenyekPage.elemMegjelenikATablazatban(azonosito2, "1"));
        igenyekPage.
                clickOnUjIgenyekFelvetelBtn().
                enterTextToAzonositoFld(azonosito3).
                enterTextToLeirasFld(leiras3).
                clickOnFelvetelBtn();
        Assert.assertTrue(igenyekPage.popUpMegjelenik("Sikeres rögzítés!"));
        Assert.assertTrue(igenyekPage.elemMegjelenikATablazatban(azonosito3, "1"));
        //Banktechnikai eszköz Igényekhez(3 db) rendelése
        igenyekPage.
                elemkivalasztasaTablazatbol(azonosito1, "1");
        IgenyekDetailsPageTabs igenyekDetailsPageTabs = new IgenyekDetailsPageTabs(getDriver());
        igenyekDetailsPageTabs.
                clickOnEszkozokTab();
        IgenyekDetailsEszkozok igenyekDetailsEszkozok = new IgenyekDetailsEszkozok(getDriver());
        igenyekDetailsEszkozok.
                clickOnBanktechnikaiEszkTab().
                clickOnHozzarendelesBtn().
                eszkozKivalasztasa(megnevezes).
                clickOnHozzarendelesKijelBtn();
        Assert.assertTrue(igenyekDetailsEszkozok.popUpMegjelenik("Sikeres hozzárendelés!"));

        sideMenu.
                navigateToIgenyekPanel();
        igenyekPage.
                elemkivalasztasaTablazatbol(azonosito2, "1");
        igenyekDetailsPageTabs.
                clickOnEszkozokTab();
        igenyekDetailsEszkozok.
                clickOnBanktechnikaiEszkTab().
                clickOnHozzarendelesBtn().
                eszkozKivalasztasa(megnevezes).
                clickOnHozzarendelesKijelBtn();
        Assert.assertTrue(igenyekDetailsEszkozok.popUpMegjelenik("Sikeres hozzárendelés!"));

        sideMenu.
                navigateToIgenyekPanel();
        igenyekPage.
                elemkivalasztasaTablazatbol(azonosito3, "1");
        igenyekDetailsPageTabs.
                clickOnEszkozokTab();
        igenyekDetailsEszkozok.
                clickOnBanktechnikaiEszkTab().
                clickOnHozzarendelesBtn().
                eszkozKivalasztasa(megnevezes).
                clickOnHozzarendelesKijelBtn();
        Assert.assertTrue(igenyekDetailsEszkozok.popUpMegjelenik("Sikeres hozzárendelés!"));
        //Keresés a Banktechnikai eszközhöz rendelt igények között
        sideMenu.
                navigateToEszkozokPanel();
        eszkozokPageTabs.
                clickOnBanktechnikaiEszkozokTab();
        eszkozokPage.
                elemKivalasztasaATablazatbol(megnevezes, "1");
        EszkozokDetailsBanktechnikaiEszkozokTabs eszkozokDetailsBanktechnikaiEszkozokTabs = new EszkozokDetailsBanktechnikaiEszkozokTabs(getDriver());
        eszkozokDetailsBanktechnikaiEszkozokTabs.
                clickOnIgenyekTab();
        EszkozokDetailsBanktecknikaiEszkozok eszkozokDetailsBanktecknikaiEszkozok = new EszkozokDetailsBanktecknikaiEszkozok(getDriver());
        Szurok szurok = new Szurok(getDriver());
        szurok.
                clickOnSzurokBtn().
                enterTextToAzonositoFld(azonosito1).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokDetailsBanktecknikaiEszkozok.elemMegjelenikATablazatban(azonosito1, "1"));
        Assert.assertFalse(eszkozokDetailsBanktecknikaiEszkozok.elemMegjelenikATablazatban(azonosito2, "1"));
        Assert.assertFalse(eszkozokDetailsBanktecknikaiEszkozok.elemMegjelenikATablazatban(azonosito3, "1"));
        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToLeirasFldBanktechEszk(leiras1).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokDetailsBanktecknikaiEszkozok.elemMegjelenikATablazatban(leiras1, "2"));
        Assert.assertFalse(eszkozokDetailsBanktecknikaiEszkozok.elemMegjelenikATablazatban(leiras2, "2"));
        Assert.assertFalse(eszkozokDetailsBanktecknikaiEszkozok.elemMegjelenikATablazatban(leiras3, "2"));
    }

    @Test
    public void uj_bankbiztonsagi_eszkoz_felvetele() throws IOException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());
        //Új bankbiztonsági eszköz fölvétele
        UjBankbiztonsagiEszkoz ujBankbiztonsagiEszkoz = deserializeJson("ujBankbiztonsagiEszkoz.json", UjBankbiztonsagiEszkoz.class);
        sideMenu.
                navigateToEszkozokPanel();
        EszkozokPageTabs eszkozokPageTabs = new EszkozokPageTabs(getDriver());
        eszkozokPageTabs.
                clickOnBankbiztonsagiEszkozokTab();
        EszkozokPage eszkozokPage = new EszkozokPage(getDriver());
        String megnevezes = "Bankbiztonsági eszköz teszt" + new FakerUtils().generateRandomNumber();
        String leltariSzam = "LE-Bankbizt";
        eszkozokPage.
                clickOnUjEszkozFelveteleBtn().
                enterTextToMegnevezesFld(megnevezes).
                enterTextToLeltariSzamFld(leltariSzam).
                setUjBankbiztonsagiEszkoz(ujBankbiztonsagiEszkoz).
                clickOnFelvetelBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres létrezozás!"));
    }

    @Test
    public void uj_bankbiztonsagi_eszkoz_felvetele_kotelezo_mezok_kitoltese_nelkul() throws IOException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());
        //Új bankbiztonsági eszköz felvétele
        sideMenu.
                navigateToEszkozokPanel();
        UjBankbiztonsagiEszkoz ujBankbiztonsagiEszkoz = deserializeJson("ujBankbiztonsagiEszkoz.json", UjBankbiztonsagiEszkoz.class);
        EszkozokPageTabs eszkozokPageTabs = new EszkozokPageTabs(getDriver());
        eszkozokPageTabs.
                clickOnBankbiztonsagiEszkozokTab();
        String megnevezes = "Banbiztonsági eszköz teszt" + new FakerUtils().generateRandomNumber();
        String leltariSzam = "LE-1023" + new FakerUtils().generateRandomNumber();
        String eszkozcsoport = "ATM belső kamera";
        String tipus = "Tesla intelligens IP kamera";
        String statusz = "N/A";
        EszkozokPage eszkozokPage = new EszkozokPage(getDriver());
        eszkozokPage.
                clickOnUjEszkozFelveteleBtn().
                enterTextToLeltariSzamFld(leltariSzam).
                setUjBankbiztonsagiEszkoz(ujBankbiztonsagiEszkoz);
        Assert.assertFalse(eszkozokPage.felvetelGombKattinthato());
        eszkozokPage.
                clickOnMegsemBtn().
                clickOnUjEszkozFelveteleBtn().
                enterTextToMegnevezesFld(megnevezes).
                selectEszkozcsoportFromDropDown(eszkozcsoport).
                enterTextToEszkozTipusFld(tipus).
                selectEszkozStatuszFromDropDown(statusz);
        Assert.assertFalse(eszkozokPage.felvetelGombKattinthato());
        eszkozokPage.
                clickOnMegsemBtn().
                clickOnUjEszkozFelveteleBtn().
                enterTextToMegnevezesFld(megnevezes).
                enterTextToLeltariSzamFld(leltariSzam).
                enterTextToEszkozTipusFld(tipus).
                selectEszkozStatuszFromDropDown(statusz);
        Assert.assertFalse(eszkozokPage.felvetelGombKattinthato());
        eszkozokPage.
                clickOnMegsemBtn().
                clickOnUjEszkozFelveteleBtn().
                enterTextToMegnevezesFld(megnevezes).
                enterTextToLeltariSzamFld(leltariSzam).
                selectEszkozcsoportFromDropDown(eszkozcsoport).
                selectEszkozStatuszFromDropDown(statusz);
        Assert.assertFalse(eszkozokPage.felvetelGombKattinthato());
        eszkozokPage.
                clickOnMegsemBtn().
                clickOnUjEszkozFelveteleBtn().
                enterTextToMegnevezesFld(megnevezes).
                enterTextToLeltariSzamFld(leltariSzam).
                selectEszkozcsoportFromDropDown(eszkozcsoport).
                enterTextToEszkozTipusFld(tipus);
        Assert.assertFalse(eszkozokPage.felvetelGombKattinthato());
    }

    @Test
    public void uj_bankbiztonsagi_eszkoz_felvetelenek_megszakitasa_Megsem_gombbal() throws IOException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());
        //Új Bankbiztonsági Eszköz fölvétele
        UjBankbiztonsagiEszkoz ujBankbiztonsagiEszkoz = deserializeJson("ujBankbiztonsagiEszkoz.json", UjBankbiztonsagiEszkoz.class);
        sideMenu.
                navigateToEszkozokPanel();
        EszkozokPageTabs eszkozokPageTabs = new EszkozokPageTabs(getDriver());
        eszkozokPageTabs.
                clickOnBankbiztonsagiEszkozokTab();
        String megnevezes = "Banbiztonsági eszköz teszt" + new FakerUtils().generateRandomNumber();
        String leltariSzam = "LE-012" + new FakerUtils().generateRandomNumber();
        EszkozokPage eszkozokPage = new EszkozokPage(getDriver());
        eszkozokPage.
                clickOnUjEszkozFelveteleBtn().
                enterTextToMegnevezesFld(megnevezes).
                enterTextToLeltariSzamFld(leltariSzam).
                setUjBankbiztonsagiEszkoz(ujBankbiztonsagiEszkoz);
        //Felvétel megszakítása
        eszkozokPage.
                clickOnMegsemBtn();
        Assert.assertFalse(eszkozokPage.eszkozMegjelenikATablazatban(megnevezes, "1"));
    }

    @Test
    public void kereses_a_bankbiztonsagi_eszkozok_kozott() throws IOException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());
        //Bankbiztonsági eszköz felvétele (min. 3 db)
        //Új bankbiztonsági eszköz fölvétele
        UjBankbiztonsagiEszkoz ujBankbiztonsagiEszkoz = deserializeJson("ujBankbiztonsagiEszkoz.json", UjBankbiztonsagiEszkoz.class);
        sideMenu.
                navigateToEszkozokPanel();
        EszkozokPageTabs eszkozokPageTabs = new EszkozokPageTabs(getDriver());
        eszkozokPageTabs.
                clickOnBankbiztonsagiEszkozokTab();
        EszkozokPage eszkozokPage = new EszkozokPage(getDriver());
        String megnevezes1 = "Bankbiztonsági eszköz teszt" + new FakerUtils().generateRandomNumber();
        String megnevezes2 = "Bankbiztonsági eszköz teszt" + new FakerUtils().generateRandomNumber();
        String megnevezes3 = "Bankbiztonsági eszköz teszt" + new FakerUtils().generateRandomNumber();
        String leltariSzam1 = "LE-012" + new FakerUtils().generateRandomNumber();
        String leltariSzam2 = "LE-012" + new FakerUtils().generateRandomNumber();
        String leltariSzam3 = "LE-012" + new FakerUtils().generateRandomNumber();
        eszkozokPage.
                clickOnUjEszkozFelveteleBtn().
                enterTextToMegnevezesFld(megnevezes1).
                enterTextToLeltariSzamFld(leltariSzam1).
                setUjBankbiztonsagiEszkoz(ujBankbiztonsagiEszkoz).
                clickOnFelvetelBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres létrezozás!"));
        eszkozokPage.
                clickOnUjEszkozFelveteleBtn().
                enterTextToMegnevezesFld(megnevezes2).
                enterTextToLeltariSzamFld(leltariSzam2).
                setUjBankbiztonsagiEszkoz(ujBankbiztonsagiEszkoz).
                clickOnFelvetelBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres létrezozás!"));
        eszkozokPage.
                clickOnUjEszkozFelveteleBtn().
                enterTextToMegnevezesFld(megnevezes3).
                enterTextToLeltariSzamFld(leltariSzam3).
                setUjBankbiztonsagiEszkoz(ujBankbiztonsagiEszkoz).
                clickOnFelvetelBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres létrezozás!"));
        Szurok szurok = new Szurok(getDriver());
        szurok.
                clickOnSzurokBtn().
                enterTextToMegnevezesFldBankbiztEszk(megnevezes1).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(megnevezes1, "1"));
        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToLeltarBankbiztEszkFld(leltariSzam1).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(leltariSzam1, "2"));
        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToTipusFldBankbiztEszk("Tesla intelligens IP kamera").
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban("Tesla intelligens IP kamera", "3"));
        szurok.
                clickOnSzurokTorleseBtn().
                selectEszkozcsoportBankbiztEszkozFromDropDown("ATM belső kamera").
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban("ATM belső kamera", "4"));
        szurok.
                clickOnSzurokTorleseBtn().
                selectStatuszBankbiztEszkozFromDropDown("N/A").
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban("N/A", "6"));
        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToMegnevezesFldBankbiztEszk(megnevezes2).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(megnevezes2, "1"));
    }

    @Test
    public void bankbiztonsagi_eszkoz_alapadatok_szerkesztese() throws IOException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());
        //Szervizelesért felelős partner megadása
        sideMenu.
                navigateToPartnerekPanel();
        PartnerekPage partnerekPage = new PartnerekPage(getDriver());
        String szervFelPartnerNeve = "Teszt Szervizelésért felelős partner" + new FakerUtils().generateRandomNumber();
        String szervFelPartnerTelefonszam = "06202102121";
        String szervFelPartnerEmail = "emailvevo@gmail.com";
        sideMenu.
                navigateToPartnerekPanel();
        partnerekPage.
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(szervFelPartnerNeve).
                enterTelefonszFld(szervFelPartnerTelefonszam).
                enterEmailFld(szervFelPartnerEmail).
                clickOnFelvetelBtn();
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(szervFelPartnerNeve, "1"));
        //Új bankbiztonsági eszköz fölvétele
        UjBankbiztonsagiEszkoz ujBankbiztonsagiEszkoz = deserializeJson("ujBankbiztonsagiEszkoz.json", UjBankbiztonsagiEszkoz.class);
        sideMenu.
                navigateToEszkozokPanel();
        EszkozokPageTabs eszkozokPageTabs = new EszkozokPageTabs(getDriver());
        eszkozokPageTabs.
                clickOnBankbiztonsagiEszkozokTab();
        EszkozokPage eszkozokPage = new EszkozokPage(getDriver());
        String megnevezes = "Bankbiztonsági eszköz teszt" + new FakerUtils().generateRandomNumber();
        String leltariSzam = "LE-012" + new FakerUtils().generateRandomNumber();
        eszkozokPage.
                clickOnUjEszkozFelveteleBtn().
                enterTextToMegnevezesFld(megnevezes).
                enterTextToLeltariSzamFld(leltariSzam).
                setUjBankbiztonsagiEszkoz(ujBankbiztonsagiEszkoz).
                clickOnFelvetelBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres létrezozás!"));
        //Alapadatok szerkesztése
        eszkozokPage.elemKivalasztasaATablazatbol(megnevezes, "1");
        EszkozokDetailsBankbiztonsagiEszkozok eszkozokDetailsBankbiztonsagiEszkozok = new EszkozokDetailsBankbiztonsagiEszkozok(getDriver());
        eszkozokDetailsBankbiztonsagiEszkozok.
                clickOnAdatokSzerkeszteseBtn().
                selectFromSzervizertFelelosPartnerDropDown(szervFelPartnerNeve).
                clickOnMentesBtn();
        Assert.assertTrue(eszkozokDetailsBankbiztonsagiEszkozok.popUpUzenetMegjelenik("Sikeres rögzítés"));
    }

    @Test
    public void kereses_a_bankbiztonsagi_eszkozokhoz_rendelt_igenyek_kozot() throws IOException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());
        //Új Banktechnikai Eszköz fölvétele (előfeltétel: legalább 1 db)
        UjBankbiztonsagiEszkoz ujBankbiztonsagiEszkoz = deserializeJson("ujBankbiztonsagiEszkoz.json", UjBankbiztonsagiEszkoz.class);
        sideMenu.
                navigateToEszkozokPanel();
        EszkozokPageTabs eszkozokPageTabs = new EszkozokPageTabs(getDriver());
        eszkozokPageTabs.
                clickOnBankbiztonsagiEszkozokTab();
        String megnevezes = "Banbiztonsági eszköz teszt" + new FakerUtils().generateRandomNumber();
        String leltariSzam = "Le-0123" + new FakerUtils().generateRandomNumber();
        EszkozokPage eszkozokPage = new EszkozokPage(getDriver());
        eszkozokPage.
                clickOnUjEszkozFelveteleBtn().
                enterTextToMegnevezesFld(megnevezes).
                enterTextToLeltariSzamFld(leltariSzam).
                setUjBankbiztonsagiEszkoz(ujBankbiztonsagiEszkoz).
                clickOnFelvetelBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres létrehozás!"));
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(megnevezes, "1"));
        //Igény felvétele (legalább 3 db)
        sideMenu.
                navigateToIgenyekPanel();
        IgenyekPage igenyekPage = new IgenyekPage(getDriver());
        String azonosito1 = "Teszt azonosító" + new FakerUtils().generateRandomNumber();
        String azonosito2 = "Teszt azonosító" + new FakerUtils().generateRandomNumber();
        String azonosito3 = "Teszt azonosító" + new FakerUtils().generateRandomNumber();
        String leiras1 = "Teszt leírás1";
        String leiras2 = "Teszt leírás2";
        String leiras3 = "Teszt leírás3";
        igenyekPage.
                clickOnUjIgenyekFelvetelBtn().
                enterTextToAzonositoFld(azonosito1).
                enterTextToLeirasFld(leiras1).
                clickOnFelvetelBtn();
        Assert.assertTrue(igenyekPage.popUpMegjelenik("Sikeres rögzítés!"));
        Assert.assertTrue(igenyekPage.elemMegjelenikATablazatban(azonosito1, "1"));
        igenyekPage.
                clickOnUjIgenyekFelvetelBtn().
                enterTextToAzonositoFld(azonosito2).
                enterTextToLeirasFld(leiras2).
                clickOnFelvetelBtn();
        Assert.assertTrue(igenyekPage.popUpMegjelenik("Sikeres rögzítés!"));
        Assert.assertTrue(igenyekPage.elemMegjelenikATablazatban(azonosito2, "1"));
        igenyekPage.
                clickOnUjIgenyekFelvetelBtn().
                enterTextToAzonositoFld(azonosito3).
                enterTextToLeirasFld(leiras3).
                clickOnFelvetelBtn();
        Assert.assertTrue(igenyekPage.popUpMegjelenik("Sikeres rögzítés!"));
        Assert.assertTrue(igenyekPage.elemMegjelenikATablazatban(azonosito3, "1"));
        //Banktechnikai eszköz Igényekhez(3 db) rendelése
        igenyekPage.
                elemkivalasztasaTablazatbol(azonosito1, "1");
        IgenyekDetailsPageTabs igenyekDetailsPageTabs = new IgenyekDetailsPageTabs(getDriver());
        igenyekDetailsPageTabs.
                clickOnEszkozokTab();
        IgenyekDetailsEszkozok igenyekDetailsEszkozok = new IgenyekDetailsEszkozok(getDriver());
        igenyekDetailsEszkozok.
                clickOnBankbiztonsagiTab().
                clickOnHozzarendelesBtn().
                eszkozKivalasztasa(megnevezes).
                clickOnHozzarendelesKijelBtn();
        Assert.assertTrue(igenyekDetailsEszkozok.popUpMegjelenik("Sikeres hozzárendelés!"));

        sideMenu.
                navigateToIgenyekPanel();
        igenyekPage.
                elemkivalasztasaTablazatbol(azonosito2, "1");
        igenyekDetailsPageTabs.
                clickOnEszkozokTab();
        igenyekDetailsEszkozok.
                clickOnBankbiztonsagiTab().
                clickOnHozzarendelesBtn().
                eszkozKivalasztasa(megnevezes).
                clickOnHozzarendelesKijelBtn();
        Assert.assertTrue(igenyekDetailsEszkozok.popUpMegjelenik("Sikeres hozzárendelés!"));

        sideMenu.
                navigateToIgenyekPanel();
        igenyekPage.
                elemkivalasztasaTablazatbol(azonosito3, "1");
        igenyekDetailsPageTabs.
                clickOnEszkozokTab();
        igenyekDetailsEszkozok.
                clickOnBankbiztonsagiTab().
                clickOnHozzarendelesBtn().
                eszkozKivalasztasa(megnevezes).
                clickOnHozzarendelesKijelBtn();
        Assert.assertTrue(igenyekDetailsEszkozok.popUpMegjelenik("Sikeres hozzárendelés!"));
        //Keresés a Bankbiztonsági eszközhöz rendelt igények között
        sideMenu.
                navigateToEszkozokPanel();
        eszkozokPageTabs.
                clickOnBankbiztonsagiEszkozokTab();
        eszkozokPage.
                elemKivalasztasaATablazatbol(megnevezes, "1");
        EszkozokDetailsBankbiztonsagiEszkozokTabs eszkozokDetailsBankbiztonsagiEszkozokTabs = new EszkozokDetailsBankbiztonsagiEszkozokTabs(getDriver());
        eszkozokDetailsBankbiztonsagiEszkozokTabs.
                clickOnIgenyekTab();
        EszkozokDetailsBankbiztonsagiEszkozok eszkozokDetailsBankbiztonsagiEszkozok = new EszkozokDetailsBankbiztonsagiEszkozok(getDriver());
        Szurok szurok = new Szurok(getDriver());
        szurok.
                clickOnSzurokBtn().
                enterTextToAzonositoFld(azonosito1).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokDetailsBankbiztonsagiEszkozok.elemMegjelenikATablazatban(azonosito1, "1"));
        Assert.assertFalse(eszkozokDetailsBankbiztonsagiEszkozok.elemMegjelenikATablazatban(azonosito2, "1"));
        Assert.assertFalse(eszkozokDetailsBankbiztonsagiEszkozok.elemMegjelenikATablazatban(azonosito3, "1"));
        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToLeirasFldBanktechEszk(leiras1).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokDetailsBankbiztonsagiEszkozok.elemMegjelenikATablazatban(leiras1, "2"));
        Assert.assertFalse(eszkozokDetailsBankbiztonsagiEszkozok.elemMegjelenikATablazatban(leiras2, "2"));
        Assert.assertFalse(eszkozokDetailsBankbiztonsagiEszkozok.elemMegjelenikATablazatban(leiras3, "2"));
        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToAzonositoFld(azonosito2).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokDetailsBankbiztonsagiEszkozok.elemMegjelenikATablazatban(azonosito2, "1"));
        Assert.assertFalse(eszkozokDetailsBankbiztonsagiEszkozok.elemMegjelenikATablazatban(azonosito1, "1"));
        Assert.assertFalse(eszkozokDetailsBankbiztonsagiEszkozok.elemMegjelenikATablazatban(azonosito3, "1"));
    }



    @Test
    public void teszt(){
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());
        sideMenu.
                navigateToEszkozokPanel();
        EszkozokPage eszkozokPage = new EszkozokPage(getDriver());
        eszkozokPage.
                elemKivalasztasaATablazatbol( "Gyári szám teszt24417" , "2");
        EszkozokDetailsAtmPageTabs eszkozokDetailsAtmPageTabs = new EszkozokDetailsAtmPageTabs(getDriver());
        eszkozokDetailsAtmPageTabs.
                clickOnBankbiztonsagieszkozokTab();
        EszkozokDetailsAtm eszkozokDetailsAtm = new EszkozokDetailsAtm(getDriver());
        eszkozokDetailsAtm.
                clickOnHozzarendelesBtn().
                eszkozKivalasztasaChBox("Bankbiztonsági eszköz teszt25448").
                clickOnHozzarendelesKijelBtn();
        Assert.assertTrue(eszkozokDetailsAtm.popUpUzenetMegjelenik("Sikeres hozzárendelés!"));

        //Bankbiztonsági eszköz eltávolítása a listából
        eszkozokDetailsAtm.
                hozzarendeltEszkozKivalasztasa("Atm belső biztonsági kamera").
                clickOnEltavolitasBtn().
                clickOnTorlesBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres törlés!"));
    }

}
