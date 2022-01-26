package hu.fonixit.buildfolio.autotest.tests;


import hu.fonixit.buildfolio.autotest.base.BaseTest;
import hu.fonixit.buildfolio.autotest.objects.UjAtmAlapadatok;
import hu.fonixit.buildfolio.autotest.objects.UjBankbiztonsagiEszkoz;
import hu.fonixit.buildfolio.autotest.objects.UjBanktechnikaiEszkoz;
import hu.fonixit.buildfolio.autotest.objects.UjIngatlan;
import hu.fonixit.buildfolio.autotest.pages.*;
import hu.fonixit.buildfolio.autotest.pages.components.*;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.EszkozokDetailsPages.EszkozokDetailsAtm;
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
                clickOnFelvetelBtn().
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
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(tipus, "1"));

        //Szűrés
        sideMenu.
                navigateToEszkozokPanel();
        String iranyitoszam = "Nincs megadva";
        String varos = "Nincs megadva";
        String kozteruletNeve = "Nincs megadva";
        String beepitettseg = "N/A";
        String elhelyezkedes = "Nincs megadva";
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
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(iranyitoszam, "3"));

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToIranyitoszamFldAtmAdatlap(varos).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(varos, "3"));

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToIranyitoszamFldAtmAdatlap(kozteruletNeve).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(kozteruletNeve, "3"));

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToIranyitoszamFldAtmAdatlap(kozteruletNeve).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(kozteruletNeve, "3"));

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToIranyitoszamFldAtmAdatlap(kozteruletNeve).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(kozteruletNeve, "3"));

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToIranyitoszamFldAtmAdatlap(kozteruletNeve).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(kozteruletNeve, "3"));


        //Nincs megadva nem lehet kiválasztani FOLYTATÁS
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
        UjAtmAlapadatok ujAtmAlapadatok = deserializeJson("atmAlapadatok.json", UjAtmAlapadatok.class);
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
    public void ingatlanhoz_rendelt_ATM_alapadatok_szerkesztes() throws IOException {
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

        ingatlanokPage.clickOnUjIngatlanFelveteleBtn();
        String megnevezes = "Teszt Ingatlan" + new FakerUtils().generateRandomNumber();
        ingatlanokPage.
                enterTextToMegnevezesFld(megnevezes).
                setUjIngatlan(ujIngatlan).
                selectElementFromSzervezetDropDown(szervezetAzon).
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
                clickOnFelvetelBtn().
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
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(tipus, "1"));

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

        //Külső helyszín megadása
        sideMenu.
                navigateToEszkozokPanel();
        eszkozokPage.
                elemKivalasztasaATablazatbol(tipus, "1");
        eszkozokDetailsAtm.
                clickOnAdatokSzerkeszteseBtn().
                clickOnKulsoHelyszinChBox().
                enterTextToIrSzamFld("6720").
                enterTextToVarosFld("Szeged").
                enterTextToKozteruletNeve("Mátyás").
                selectKoztTipusaFromDropDown("tér").
                enterTextToHazszamFld("10").
                clickOnMentesBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres rögzítés!"));
    }

    @Test
    public void atm_alapadatok_szerkesztes_statusz() throws IOException {
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

        ingatlanokPage.clickOnUjIngatlanFelveteleBtn();
        String megnevezes = "Teszt Ingatlan" + new FakerUtils().generateRandomNumber();
        ingatlanokPage.
                enterTextToMegnevezesFld(megnevezes).
                setUjIngatlan(ujIngatlan).
                selectElementFromSzervezetDropDown(szervezetAzon).
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
                clickOnFelvetelBtn().
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
        Assert.assertTrue(eszkozokPage.eszkozMegjelenikATablazatban(tipus, "1"));

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

        ingatlanokPage.clickOnUjIngatlanFelveteleBtn();
        String megnevezes = "Teszt Ingatlan" + new FakerUtils().generateRandomNumber();
        ingatlanokPage.
                enterTextToMegnevezesFld(megnevezes).
                setUjIngatlan(ujIngatlan).
                selectElementFromSzervezetDropDown(szervezetAzon).
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
                clickOnFelvetelBtn().
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
        EszkozokDetailsPageTabs eszkozokDetailsPageTabs = new EszkozokDetailsPageTabs(getDriver());
        eszkozokDetailsPageTabs.
                clickOnBankbiztEszkTab();
        eszkozokPage.
                clickOnUjEszkozFelveteleBtn().
                enterTextToMegnevezesFld(megnevezesBankbizEszk).
                setUjBankbiztonsagiEszkoz(ujBankbiztonsagiEszkoz).
                clickOnFelvetelBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres létrehozás!"));

        //Bankbiztonsági eszköz hozzárendelése Atm-hez
        eszkozokDetailsPageTabs.
                clickOnAtmekTab();
        eszkozokPage.
                elemKivalasztasaATablazatbol(tipus, "1");
        EszkozokDetailsAtmPageTabs eszkozokDetailsAtmPageTabs = new EszkozokDetailsAtmPageTabs(getDriver());
        eszkozokDetailsAtmPageTabs.
                clickOnBankbiztonsagieszkozokTab();
        EszkozokDetailsAtm eszkozokDetailsAtm = new EszkozokDetailsAtm(getDriver());
        eszkozokDetailsAtm.
                clickOnHozzarendelesBtn().
                eszkozKivalasztasaChBox("3").
                clickOnHozzarendelesKijelBtn();
        Assert.assertTrue(eszkozokDetailsAtm.popUpUzenetMegjelenik("Sikeres hozzárendelés!"));

        //ATM adatlap - Bankbiztonsági eszköz - Szűrés
        String leltariSzam = "LE-1023";
        String tipusBankbiztEszk = "Tesla intelligens IP kamera";
        String eszkozCsoport = "ATM belső kamera";
        String iranyitoSzam = "6720";
        String varos = "Szeged";
        String koztNeve = "Máyás";
        String statuszBankBiztEszk = "N/A";
        Szurok szurok = new Szurok(getDriver());
        szurok.
                clickOnSzurokBtn().
                enterTextToMegnevezesFldBankbiztEszk(megnevezesBankbizEszk).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokDetailsAtm.elemMegjelenikATablazatban(megnevezesBankbizEszk, "2"));

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToLeltariSzamFldBankbiztEszk(leltariSzam).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokDetailsAtm.elemMegjelenikATablazatban(leltariSzam, "3"));

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
                enterTextToIranyitoszamFldBankbiztEszk(iranyitoSzam).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokDetailsAtm.elemMegjelenikATablazatban(iranyitoSzam, "6"));

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToVarosFldBankbiztEszk(varos).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokDetailsAtm.elemMegjelenikATablazatban(varos, "6"));

        szurok.
                clickOnSzurokTorleseBtn().
                enterTextToKoztNeveFld(koztNeve).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokDetailsAtm.elemMegjelenikATablazatban(koztNeve, "6"));

        szurok.
                clickOnSzurokTorleseBtn().
                selectStatuszFromDropDown(statuszBankBiztEszk).
                clickOnKeresesBtn();
        Assert.assertTrue(eszkozokDetailsAtm.elemMegjelenikATablazatban(statuszBankBiztEszk, "7"));
    }

    @Test
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

        ingatlanokPage.clickOnUjIngatlanFelveteleBtn();
        String megnevezes = "Teszt Ingatlan" + new FakerUtils().generateRandomNumber();
        ingatlanokPage.
                enterTextToMegnevezesFld(megnevezes).
                setUjIngatlan(ujIngatlan).
                selectElementFromSzervezetDropDown(szervezetAzon).
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
                clickOnFelvetelBtn().
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
        EszkozokDetailsPageTabs eszkozokDetailsPageTabs = new EszkozokDetailsPageTabs(getDriver());
        eszkozokDetailsPageTabs.
                clickOnBankbiztEszkTab();
        eszkozokPage.
                clickOnUjEszkozFelveteleBtn().
                enterTextToMegnevezesFld(megnevezesBankbizEszk).
                setUjBankbiztonsagiEszkoz(ujBankbiztonsagiEszkoz).
                clickOnFelvetelBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres létrehozás!"));

        //Bankbiztonsági eszköz hozzárendelése Atm-hez
        eszkozokDetailsPageTabs.
                clickOnAtmekTab();
        eszkozokPage.
                elemKivalasztasaATablazatbol(tipus, "1");
        EszkozokDetailsAtmPageTabs eszkozokDetailsAtmPageTabs = new EszkozokDetailsAtmPageTabs(getDriver());
        eszkozokDetailsAtmPageTabs.
                clickOnBankbiztonsagieszkozokTab();
        EszkozokDetailsAtm eszkozokDetailsAtm = new EszkozokDetailsAtm(getDriver());
        eszkozokDetailsAtm.
                clickOnHozzarendelesBtn().
                eszkozKivalasztasaChBox("3").
                clickOnHozzarendelesKijelBtn();
        Assert.assertTrue(eszkozokDetailsAtm.popUpUzenetMegjelenik("Sikeres hozzárendelés!"));

        //Bankbiztonsági eszköz eltávolítása a listából
        eszkozokDetailsAtm.
                eszkozKivalasztasaChBox("3").
                clickOnEltavolitasBtn().
                clickOnTorlesBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres törlés!"));
    }

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

        ingatlanokPage.clickOnUjIngatlanFelveteleBtn();
        String megnevezes = "Teszt Ingatlan" + new FakerUtils().generateRandomNumber();
        ingatlanokPage.
                enterTextToMegnevezesFld(megnevezes).
                setUjIngatlan(ujIngatlan).
                selectElementFromSzervezetDropDown(szervezetAzon).
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
                clickOnFelvetelBtn().
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
    public void kereses_az_Athez_rendelt_igenyek_kozott(){
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
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres létrehozás"));
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
        Assert.assertTrue(igenyekPage.popUpMegjelenik("Sikeres rögzítés"));
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
        Assert.assertTrue(igenyekDetailsEszkozok.popUpMegjelenik("Sikeres hozzárendelés"));
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
       Assert.assertTrue(eszkozokDetailsAtm.elemMegjelenikATablazatban("Rossz leírás", "2"));
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
        EszkozokPage eszkozokPage = new EszkozokPage(getDriver());
        eszkozokPage.
                clickOnUjEszkozFelveteleBtn().
                enterTextToMegnevezesFld(megnevezes).
                setUjBankTechnikaiEszkoz(ujBanktechnikaiEszkoz).
                clickOnFelvetelBtn();
        Assert.assertTrue(eszkozokPage.sikeresUzenetMegjelenik("Sikeres létrehozás"));
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
        String leltariSzam = "10-200B";
        String eszkozcsoport = "Bankjegyszámláló";
        String tipus = "Bankjegyszámláló eszköz";
        String statusz = "N/A";
        EszkozokPage eszkozokPage = new EszkozokPage(getDriver());
        eszkozokPage.
                clickOnUjEszkozFelveteleBtn().
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
        EszkozokPage eszkozokPage = new EszkozokPage(getDriver());
        eszkozokPage.
                clickOnUjEszkozFelveteleBtn().
                enterTextToMegnevezesFld(megnevezes).
                setUjBankTechnikaiEszkoz(ujBanktechnikaiEszkoz);
        //Felvétel megszakítása
        eszkozokPage.
                clickOnMegsemBtn();
        Assert.assertFalse(eszkozokPage.eszkozMegjelenikATablazatban(megnevezes, "1"));
    }

    @Test
    public void kereses_a_banktechnikai_eszkozok_kozott(){
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());
        //Ingatlan felvétele
        
        //Banktechnikai eszköz fölvétele

        //Banktechnikaieszköz Ingatlanhoz rendelése

        //Eszközök oldal - Banktechnikai eszközök - Szűrés
    }
}
