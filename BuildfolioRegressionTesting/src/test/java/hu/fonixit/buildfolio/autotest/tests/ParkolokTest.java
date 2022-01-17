package hu.fonixit.buildfolio.autotest.tests;

import hu.fonixit.buildfolio.autotest.base.BaseTest;
import hu.fonixit.buildfolio.autotest.objects.UjIngatlan;
import hu.fonixit.buildfolio.autotest.objects.UjIngatlanAlapadatok;
import hu.fonixit.buildfolio.autotest.objects.UjMuszakiAdatok;
import hu.fonixit.buildfolio.autotest.objects.UjParkolo;
import hu.fonixit.buildfolio.autotest.pages.*;
import hu.fonixit.buildfolio.autotest.pages.components.*;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.IngatlanokDetailsPages.IngatlanokDetailsAlapadatok;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.IngatlanokDetailsPages.IngatlanokDetailsParkolas;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.ParkolokDetailsPages.ParkolokDetailsAlapadatok;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.ParkolokDetailsPages.ParkolokDetailsIngatlanok;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.ParkolokDetailsPages.ParkolokDetailsParkolohelyek;
import hu.fonixit.buildfolio.autotest.utils.FakerUtils;
import hu.fonixit.buildfolio.autotest.utils.UserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static hu.fonixit.buildfolio.autotest.utils.JacksonUtils.deserializeJson;

public class ParkolokTest extends BaseTest { //Szekvenciálisan kell lefutnia

    @Test
    public void Uj_parkolo_felvetele() throws IOException { //új parkolók felvételénél mely mezők egyediek?
        UjParkolo ujParkolo = deserializeJson("ujParkolo.json", UjParkolo.class);

        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToParkolokPanel();

        String parkMegn = "Parkoló" + new FakerUtils().generateRandomNumber();
        String azonosito = "12" + new FakerUtils().generateRandomNumber();
        ParkolokPage parkolokPage = new ParkolokPage(getDriver());
        parkolokPage.clickOnUjParkoloFelveteleBtn().
                enterParkoloMegn(parkMegn).
                setUjParkolo(ujParkolo).
                enterAzonosito(azonosito).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();  //csak frissítés után jelenik meg az elem a listában
        Assert.assertEquals(parkolokPage.felvettParkoloMegjAListaban(), azonosito);
    }

    @Test
    public void Uj_parkolo_felvetele_kotelezo_mezok_kitoltese_nelkul() throws IOException {
        UjParkolo ujParkolo = deserializeJson("ujParkolo.json", UjParkolo.class);
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToParkolokPanel();

        String parkMegn = "Parkoló" + new FakerUtils().generateRandomNumber();
        String azonosito = "12" + new FakerUtils().generateRandomNumber();
        String parkoloTipusa = "Parkolóház";
        String terulet = "1000";
        String irSzam = "6723";
        String varos = "Szeged";
        String koztNeve = "Mátyás";
        String koztTip = "tér";
        String hazSzam = "10";
        String hrsz = "112/231";
        ParkolokPage parkolokPage = new ParkolokPage(getDriver());
        parkolokPage.clickOnUjParkoloFelveteleBtn().  //parkoló megnevezése mező kitöltése nélkül
                setUjParkolo(ujParkolo).
                enterAzonosito(azonosito);
        Assert.assertTrue(parkolokPage.felvetelBtnNemKattinthato());


        parkolokPage.
                clickOnMegseBtn().
                clickOnUjParkoloFelveteleBtn().   //parkoló típusa mező kitöltése nélkül
                enterParkoloMegn(parkMegn).
                enterTerulet(terulet).
                enterIrSzam(irSzam).
                enterVaros(varos).
                enterKozteruletNeve(koztNeve).
                selectKoztTipFromDropDown(koztTip).
                enterHazszam(hazSzam).
                enterAzonosito(azonosito).
                enterHrsz(hrsz);
        Assert.assertTrue(parkolokPage.felvetelBtnNemKattinthato());


        parkolokPage.
                clickOnMegseBtn().
                clickOnUjParkoloFelveteleBtn().   //terület mező kitöltése nélkül
                enterParkoloMegn(parkMegn).
                selectParkoloTipFromDropDown(parkoloTipusa).
                enterIrSzam(irSzam).
                enterVaros(varos).
                enterKozteruletNeve(koztNeve).
                selectKoztTipFromDropDown(koztTip).
                enterHazszam(hazSzam).
                enterAzonosito(azonosito).
                enterHrsz(hrsz);
        Assert.assertTrue(parkolokPage.felvetelBtnNemKattinthato());

        parkolokPage.
                clickOnMegseBtn().
                clickOnUjParkoloFelveteleBtn().   //terület mező kitöltése nélkül
                enterParkoloMegn(parkMegn).
                selectParkoloTipFromDropDown(parkoloTipusa).
                enterIrSzam(irSzam).
                enterVaros(varos).
                enterKozteruletNeve(koztNeve).
                selectKoztTipFromDropDown(koztTip).
                enterHazszam(hazSzam).
                enterAzonosito(azonosito).
                enterHrsz(hrsz);
        Assert.assertTrue(parkolokPage.felvetelBtnNemKattinthato());

        parkolokPage.
                clickOnMegseBtn().
                clickOnUjParkoloFelveteleBtn().   //Ir.szám mező kitöltése nélkül
                enterParkoloMegn(parkMegn).
                selectParkoloTipFromDropDown(parkoloTipusa).
                enterTerulet(terulet).
                enterVaros(varos).
                enterKozteruletNeve(koztNeve).
                selectKoztTipFromDropDown(koztTip).
                enterHazszam(hazSzam).
                enterAzonosito(azonosito).
                enterHrsz(hrsz);
        Assert.assertTrue(parkolokPage.felvetelBtnNemKattinthato());

        parkolokPage.
                clickOnMegseBtn().
                clickOnUjParkoloFelveteleBtn().   //város mező kitöltése nélkül
                enterParkoloMegn(parkMegn).
                selectParkoloTipFromDropDown(parkoloTipusa).
                enterTerulet(terulet).
                enterIrSzam(irSzam).
                enterKozteruletNeve(koztNeve).
                selectKoztTipFromDropDown(koztTip).
                enterHazszam(hazSzam).
                enterAzonosito(azonosito).
                enterHrsz(hrsz);
        Assert.assertTrue(parkolokPage.felvetelBtnNemKattinthato());

        parkolokPage.
                clickOnMegseBtn().
                clickOnUjParkoloFelveteleBtn().   //közt neve kitöltése nélkül
                enterParkoloMegn(parkMegn).
                selectParkoloTipFromDropDown(parkoloTipusa).
                enterTerulet(terulet).
                enterIrSzam(irSzam).
                enterVaros(varos).
                selectKoztTipFromDropDown(koztTip).
                enterHazszam(hazSzam).
                enterAzonosito(azonosito).
                enterHrsz(hrsz);
        Assert.assertTrue(parkolokPage.felvetelBtnNemKattinthato());

        parkolokPage.
                clickOnMegseBtn().
                clickOnUjParkoloFelveteleBtn().   //közt típusa mező kitöltése nélkül
                enterParkoloMegn(parkMegn).
                selectParkoloTipFromDropDown(parkoloTipusa).
                enterTerulet(terulet).
                enterIrSzam(irSzam).
                enterVaros(varos).
                enterKozteruletNeve(koztNeve).
                enterHazszam(hazSzam).
                enterAzonosito(azonosito).
                enterHrsz(hrsz);
        Assert.assertTrue(parkolokPage.felvetelBtnNemKattinthato());

        parkolokPage.
                clickOnMegseBtn().
                clickOnUjParkoloFelveteleBtn().   //házszám mező kitöltése nélkül
                enterParkoloMegn(parkMegn).
                selectParkoloTipFromDropDown(parkoloTipusa).
                enterTerulet(terulet).
                enterIrSzam(irSzam).
                enterVaros(varos).
                enterKozteruletNeve(koztNeve).
                selectKoztTipFromDropDown(koztTip).
                enterAzonosito(azonosito).
                enterHrsz(hrsz);
        Assert.assertTrue(parkolokPage.felvetelBtnNemKattinthato());

        parkolokPage.
                clickOnMegseBtn().
                clickOnUjParkoloFelveteleBtn().   //azonosító mező kitöltése nélkül
                enterParkoloMegn(parkMegn).
                selectParkoloTipFromDropDown(parkoloTipusa).
                enterTerulet(terulet).
                enterIrSzam(irSzam).
                enterVaros(varos).
                enterKozteruletNeve(koztNeve).
                selectKoztTipFromDropDown(koztTip).
                enterHazszam(hazSzam).
                enterHrsz(hrsz);
        Assert.assertTrue(parkolokPage.felvetelBtnNemKattinthato());

        parkolokPage.
                clickOnMegseBtn().
                clickOnUjParkoloFelveteleBtn().   //HRSZ mező kitöltése nélkül
                enterParkoloMegn(parkMegn).
                selectParkoloTipFromDropDown(parkoloTipusa).
                enterTerulet(terulet).
                enterIrSzam(irSzam).
                enterVaros(varos).
                enterKozteruletNeve(koztNeve).
                selectKoztTipFromDropDown(koztTip).
                enterHazszam(hazSzam).
                enterAzonosito(azonosito);
        Assert.assertTrue(parkolokPage.felvetelBtnNemKattinthato());

    }

    @Test
    public void Uj_parkolo_felvetelenek_megszakitasa_Megsem_gombbal() throws IOException {
        UjParkolo ujParkolo = deserializeJson("ujParkolo.json", UjParkolo.class);

        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToParkolokPanel();

        String parkMegn = "Parkoló" + new FakerUtils().generateRandomNumber();
        String azonosito = "12" + new FakerUtils().generateRandomNumber();
        ParkolokPage parkolokPage = new ParkolokPage(getDriver());
        parkolokPage.clickOnUjParkoloFelveteleBtn().
                enterParkoloMegn(parkMegn).
                setUjParkolo(ujParkolo).
                enterAzonosito(azonosito).
                clickOnMegseBtn();
        Assert.assertTrue(parkolokPage.parkolokSzovegMegj());
    }

    @Test
    public void Szurok_mukodese(){
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToParkolokPanel();
        String azon = "12";
        String parkoloMegn = "Parkoló";
        String tipus = "Parkolóház";
        String iranyitoszam = "6720";
        String varos = "Szeged";
        String koztNeve = "Mátyás";
        String hrsz= "112/234";
        Szurok szurok = new Szurok(getDriver());
        ParkolokPage parkolokPage = new ParkolokPage(getDriver());
        szurok.
                clickOnSzurokBtn().
                enterTextToAzonositoFld(azon).
                clickOnKeresesBtn();
        Assert.assertTrue(parkolokPage.azonositoElemMegjelenik(azon));
        szurok.clickOnSzurokTorleseBtn();

        szurok.
                enterTextToParkoloMegnFld(parkoloMegn).
                clickOnKeresesBtn();
        Assert.assertTrue(parkolokPage.parkMegnevElemMegjelenik(parkoloMegn));
        szurok.clickOnSzurokTorleseBtn();

        szurok.
                selectTipusFromDropDown(tipus).
                clickOnKeresesBtn();
        Assert.assertTrue(parkolokPage.tipusElemMegjelenik(tipus));
        szurok.clickOnSzurokTorleseBtn();

        szurok.
                enterTextToIranyitoszamFld(iranyitoszam).
                clickOnKeresesBtn();
        Assert.assertTrue(parkolokPage.iranyitoszamElemMegjelenik(iranyitoszam));
        szurok.clickOnSzurokTorleseBtn();

        szurok.
                enterTextToVarosFld(varos).
                clickOnKeresesBtn();
        Assert.assertTrue(parkolokPage.varosMegjelenik(varos));
        szurok.clickOnSzurokTorleseBtn();

        szurok.
                enterTextToKoztNeveFld(koztNeve).
                clickOnKeresesBtn();
        Assert.assertTrue(parkolokPage.koztNeveMegjelenik(koztNeve));
        szurok.clickOnSzurokTorleseBtn();

        szurok.
                enterTextToHrszFld(hrsz).
                clickOnKeresesBtn();
        Assert.assertTrue(parkolokPage.hrszMegjelenik(hrsz));
        szurok.clickOnSzurokTorleseBtn();

        //összes szűrő ellenőrzése egyszerre
        szurok.
                enterTextToAzonositoFld(azon).
                enterTextToParkoloMegnFld(parkoloMegn).
                selectTipusFromDropDown(tipus).
                enterTextToIranyitoszamFld(iranyitoszam).
                enterTextToVarosFld(varos).
                enterTextToKoztNeveFld(koztNeve).
                enterTextToHrszFld(hrsz).
                clickOnKeresesBtn();
        Assert.assertTrue(parkolokPage.azonositoElemMegjelenik(azon));
        Assert.assertTrue(parkolokPage.parkMegnevElemMegjelenik(parkoloMegn));
        Assert.assertTrue(parkolokPage.tipusElemMegjelenik(tipus));
        Assert.assertTrue(parkolokPage.iranyitoszamElemMegjelenik(iranyitoszam));
        Assert.assertTrue(parkolokPage.varosMegjelenik(varos));
        Assert.assertTrue(parkolokPage.koztNeveMegjelenik(koztNeve));
        Assert.assertTrue(parkolokPage.hrszMegjelenik(hrsz));
        szurok.clickOnSzurokTorleseBtn();
    }

    @Test
    public void Alapadatok_ful_alapadatok_szerkesztese() throws IOException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToParkolokPanel();

        //Parkoló felvétele
        UjParkolo ujParkolo = deserializeJson("ujParkolo.json", UjParkolo.class);

        String parkMegn = "Parkoló" + new FakerUtils().generateRandomNumber();
        String azonosito = "12" + new FakerUtils().generateRandomNumber();
        ParkolokPage parkolokPage = new ParkolokPage(getDriver());
        parkolokPage.clickOnUjParkoloFelveteleBtn().
                enterParkoloMegn(parkMegn).
                setUjParkolo(ujParkolo).
                enterAzonosito(azonosito).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();  //csak frissítés után jelenik meg az elem a listában
        Assert.assertEquals(parkolokPage.felvettParkoloMegjAListaban(), azonosito);

        ParkolokDetailsAlapadatok parkolokDetailsPage = new ParkolokDetailsAlapadatok(getDriver());
        String betelepitesiMod = "telepítés";
        String nyitvaTartas = "nyitva";
        parkolokPage.clickOnListaElsoParkolo();
        parkolokDetailsPage.parkolokDetailsOldalonVagyunk();
        parkolokDetailsPage.
                clickOnAdatokSzerkeszteseBtn().
                enterTextToOrzeseBetelepitesiModFld(betelepitesiMod).
                clickOnMegsemBtn();
        parkolokDetailsPage.
                clickOnAdatokSzerkeszteseBtn();
        Assert.assertTrue(parkolokDetailsPage.orzeseBetelepitesiModFldUres());
        parkolokDetailsPage.
                enterTextToOrzeseBetelepitesiModFld(betelepitesiMod).
                enterTextToNyitvaTartasFld(nyitvaTartas).
                clickOnMentesBtn();
         Assert.assertTrue(parkolokDetailsPage.mezokNemszerkeszthetoek());


    }

    @Test
    public void Alapadatok_szerkesztese_kotelezo_mezok_kitoltese_nelkul() throws IOException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToParkolokPanel();

        //Parkoló felvétele
        UjParkolo ujParkolo = deserializeJson("ujParkolo.json", UjParkolo.class);

        String parkMegn = "Parkoló" + new FakerUtils().generateRandomNumber();
        String azonosito = "12" + new FakerUtils().generateRandomNumber();
        ParkolokPage parkolokPage = new ParkolokPage(getDriver());
        parkolokPage.clickOnUjParkoloFelveteleBtn().
                enterParkoloMegn(parkMegn).
                setUjParkolo(ujParkolo).
                enterAzonosito(azonosito).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();  //csak frissítés után jelenik meg az elem a listában
        Assert.assertEquals(parkolokPage.felvettParkoloMegjAListaban(), azonosito);
        parkolokPage.clickOnListaElsoParkolo();

        ParkolokDetailsAlapadatok parkolokDetailsPage = new ParkolokDetailsAlapadatok(getDriver());
        String parkoloMegn = "Parkolo Teszt";
        String tipus = "Parkolóház";
        String terulet = "1500";
        String irSzam = "6780";
        String varos = "Szentes";
        String koztNeve = "tere";
        String hazsam = "20";
        String parkAzonosito = "12" + new FakerUtils().generateRandomNumber();
        String orzBetMod = "betelepített";
        String nyitvaTart = "0-24";
        String nev = "Teszt Kapcsolattarto";
        String email = "teszt@email.com";
        String telefonszam = "06204504545";
        String mobilszam = "06201201212";
        String szolgMegn = "gumiszervíz";
        parkolokDetailsPage.clickOnAdatokSzerkeszteseBtn();
        Assert.assertTrue(parkolokDetailsPage.mentesBtnKattinthato());
        Assert.assertTrue(parkolokDetailsPage.megsemBtnKattinthato());
        Assert.assertFalse(parkolokDetailsPage.parkolohelyekPanelMegjelenik());
        parkolokDetailsPage.
                enterTextToOrzeseBetelepitesiModFld(orzBetMod).
                enterTextToNyitvaTartasFld(nyitvaTart).
                enterTextNevFld(nev).
                enterEmailFld(email).
                enterTelefonszamFld(telefonszam).
                enterTextMobilszamFld(mobilszam).
                enterTextSzolgaltatasMegnFld(szolgMegn).
                parkoloMegnevFldClear().   //parkoló megnevezése mező törlése
                clickOnMentesBtn();
        Assert.assertTrue(parkolokDetailsPage.popUpMegjelenik());
        Assert.assertEquals(parkolokDetailsPage.popUpSzoveg(), "Sikeres rögzítés!");

        parkolokDetailsPage.
                clickOnAdatokSzerkeszteseBtn().
                enterTextToParkoloMegnFld(parkoloMegn).
                tipusDropDownFldClear().  //típus dropdown mező törlése
                clickOnMentesBtn();
        Assert.assertTrue(parkolokDetailsPage.popUpMegjelenik());
        Assert.assertEquals(parkolokDetailsPage.popUpSzoveg(), "Töltse ki a kötelező mezőket");

        parkolokDetailsPage.
                enterTextToTipusDropDown(tipus).
                teruletFldClear().  //terület mező törlése
                clickOnMentesBtn();
        Assert.assertTrue(parkolokDetailsPage.popUpMegjelenik());
        Assert.assertEquals(parkolokDetailsPage.popUpSzoveg(), "Töltse ki a kötelező mezőket");
    }

    @Test
    public void Uj_Parkolohely_felvetele() throws IOException {
        UjParkolo ujParkolo = deserializeJson("ujParkolo.json", UjParkolo.class);
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToParkolokPanel();

        //új parkoló felvétele
        String parkMegn = "Parkoló" + new FakerUtils().generateRandomNumber();
        String azonosito = "12" + new FakerUtils().generateRandomNumber();
        ParkolokPage parkolokPage = new ParkolokPage(getDriver());
        parkolokPage.clickOnUjParkoloFelveteleBtn().
                enterParkoloMegn(parkMegn).
                setUjParkolo(ujParkolo).
                enterAzonosito(azonosito).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();  //csak frissítés után jelenik meg az elem a listában
        Assert.assertEquals(parkolokPage.felvettParkoloMegjAListaban(), azonosito);
        parkolokPage.clickOnListaElsoParkolo();
        ParkolokDetailsPageTabs parkolokDetailsPageTabs = new ParkolokDetailsPageTabs(getDriver()).
                clickOnParkolohelyekTab();
        ParkolokDetailsParkolohelyek parkolokDetailsParkolohelyek = new ParkolokDetailsParkolohelyek(getDriver());
        String parkhelyAzonosito = "Teszt Parkolóhely" + new FakerUtils().generateRandomNumber();
        String parkolohelyTip = "Elektromos autó";
        parkolokDetailsParkolohelyek.
                clickOnUjParkolohelyFelevBtn();
        Assert.assertFalse(parkolokDetailsParkolohelyek.felvetelBtnKattinthato());
        parkolokDetailsParkolohelyek.
                enterTextToAzonositoFld(parkhelyAzonosito);
        Assert.assertFalse(parkolokDetailsParkolohelyek.felvetelBtnKattinthato());
        parkolokDetailsParkolohelyek.
                selectElemFromParkHelyTipDropDown(parkolohelyTip);
        Assert.assertTrue(parkolokDetailsParkolohelyek.felvetelBtnKattinthato());
        parkolokDetailsParkolohelyek.
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertTrue(parkolokDetailsParkolohelyek.felvettParkolohelyMegjATablazatban(parkhelyAzonosito, "1"));
    }

    @Test
    public void Uj_parkolohely_felvetele_kotelezo_mezok_kitoltese_nelkul() throws IOException {
        UjParkolo ujParkolo = deserializeJson("ujParkolo.json", UjParkolo.class);
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToParkolokPanel();

        //új parkoló felvétele
        String parkMegn = "Parkoló" + new FakerUtils().generateRandomNumber();
        String azonosito = "12" + new FakerUtils().generateRandomNumber();
        ParkolokPage parkolokPage = new ParkolokPage(getDriver());
        parkolokPage.clickOnUjParkoloFelveteleBtn().
                enterParkoloMegn(parkMegn).
                setUjParkolo(ujParkolo).
                enterAzonosito(azonosito).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();  //csak frissítés után jelenik meg az elem a listában
        Assert.assertEquals(parkolokPage.felvettParkoloMegjAListaban(), azonosito);
        parkolokPage.clickOnListaElsoParkolo();
        ParkolokDetailsPageTabs parkolokDetailsPageTabs = new ParkolokDetailsPageTabs(getDriver()).
                clickOnParkolohelyekTab();
        ParkolokDetailsParkolohelyek parkolokDetailsParkolohelyek = new ParkolokDetailsParkolohelyek(getDriver());
        String parkhelyAzonosito = "Teszt Parkolóhely" + new FakerUtils().generateRandomNumber();
        String parkolohelyTip = "Elektromos autó";
        parkolokDetailsParkolohelyek.
                clickOnUjParkolohelyFelevBtn();
        Assert.assertFalse(parkolokDetailsParkolohelyek.felvetelBtnKattinthato());
        parkolokDetailsParkolohelyek.
                enterTextToAzonositoFld(parkhelyAzonosito);
        Assert.assertFalse(parkolokDetailsParkolohelyek.felvetelBtnKattinthato());
    }

    @Test
    public void Uj_parkolohely_felvetelenek_megszakitasa_megsem_gombbal() throws IOException {
        UjParkolo ujParkolo = deserializeJson("ujParkolo.json", UjParkolo.class);
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToParkolokPanel();

        //új parkoló felvétele
        String parkMegn = "Parkoló" + new FakerUtils().generateRandomNumber();
        String azonosito = "12" + new FakerUtils().generateRandomNumber();
        ParkolokPage parkolokPage = new ParkolokPage(getDriver());
        parkolokPage.clickOnUjParkoloFelveteleBtn().
                enterParkoloMegn(parkMegn).
                setUjParkolo(ujParkolo).
                enterAzonosito(azonosito).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();  //csak frissítés után jelenik meg az elem a listában
        Assert.assertEquals(parkolokPage.felvettParkoloMegjAListaban(), azonosito);
        parkolokPage.clickOnListaElsoParkolo();
        ParkolokDetailsPageTabs parkolokDetailsPageTabs = new ParkolokDetailsPageTabs(getDriver()).
                clickOnParkolohelyekTab();
        ParkolokDetailsParkolohelyek parkolokDetailsParkolohelyek = new ParkolokDetailsParkolohelyek(getDriver());
        String parkhelyAzonosito = "Teszt Parkolóhely" + new FakerUtils().generateRandomNumber();
        String parkolohelyTip = "Elektromos autó";
        parkolokDetailsParkolohelyek.
                clickOnUjParkolohelyFelevBtn();
        Assert.assertFalse(parkolokDetailsParkolohelyek.felvetelBtnKattinthato());
        Assert.assertTrue(parkolokDetailsParkolohelyek.megsemBtnKattinthato());
        parkolokDetailsParkolohelyek.
                enterTextToAzonositoFld(parkhelyAzonosito);
        Assert.assertFalse(parkolokDetailsParkolohelyek.felvetelBtnKattinthato());
        Assert.assertTrue(parkolokDetailsParkolohelyek.megsemBtnKattinthato());
        parkolokDetailsParkolohelyek.
                selectElemFromParkHelyTipDropDown(parkolohelyTip);
        Assert.assertTrue(parkolokDetailsParkolohelyek.felvetelBtnKattinthato());
        Assert.assertTrue(parkolokDetailsParkolohelyek.megsemBtnKattinthato());
        parkolokDetailsParkolohelyek.clickOnMegsemBtn();
    }

    @Test
    public void Parkolohelyek_tipusonkent_megjelenese_az_alapadatokon() throws IOException {
        UjParkolo ujParkolo = deserializeJson("ujParkolo.json", UjParkolo.class);
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToParkolokPanel();

        //új parkoló felvétele
        String parkMegn = "Parkoló" + new FakerUtils().generateRandomNumber();
        String azonosito = "12" + new FakerUtils().generateRandomNumber();
        ParkolokPage parkolokPage = new ParkolokPage(getDriver());
        parkolokPage.clickOnUjParkoloFelveteleBtn().
                enterParkoloMegn(parkMegn).
                setUjParkolo(ujParkolo).
                enterAzonosito(azonosito).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();  //csak frissítés után jelenik meg az elem a listában
        Assert.assertEquals(parkolokPage.felvettParkoloMegjAListaban(), azonosito);
        parkolokPage.clickOnListaElsoParkolo();
        ParkolokDetailsPageTabs parkolokDetailsPageTabs = new ParkolokDetailsPageTabs(getDriver()).
                clickOnParkolohelyekTab();
        ParkolokDetailsParkolohelyek parkolokDetailsParkolohelyek = new ParkolokDetailsParkolohelyek(getDriver());
        String parkhelyAzonosito1 = "Teszt Parkolóhely" + new FakerUtils().generateRandomNumber();
        String parkhelyAzonosito2 = "Teszt Parkolóhely" + new FakerUtils().generateRandomNumber();
        String parkhelyAzonosito3 = "Teszt Parkolóhely" + new FakerUtils().generateRandomNumber();
        String parkhelyAzonosito4 = "Teszt Parkolóhely" + new FakerUtils().generateRandomNumber();
        String parkhelyAzonosito5 = "Teszt Parkolóhely" + new FakerUtils().generateRandomNumber();
        String parkhelyAzonosito6 = "Teszt Parkolóhely" + new FakerUtils().generateRandomNumber();
        String parkhelyAzonosito7 = "Teszt Parkolóhely" + new FakerUtils().generateRandomNumber();
        String parkolohelyTip1 = "Elektromos autó";
        String parkolohelyTip2 = "Családos";
        String parkolohelyTip3 = "Normál";
        String parkolohelyTip4 = "Rokkant";
        parkolokDetailsParkolohelyek.
                clickOnUjParkolohelyFelevBtn().
                enterTextToAzonositoFld(parkhelyAzonosito1).
                selectElemFromParkHelyTipDropDown(parkolohelyTip1).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertTrue(parkolokDetailsParkolohelyek.felvettParkolohelyMegjATablazatban(parkhelyAzonosito1, "1"));
        parkolokDetailsParkolohelyek.
                clickOnUjParkolohelyFelevBtn().
                enterTextToAzonositoFld(parkhelyAzonosito2).
                selectElemFromParkHelyTipDropDown(parkolohelyTip2).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertTrue(parkolokDetailsParkolohelyek.felvettParkolohelyMegjATablazatban(parkhelyAzonosito2, "1"));
        parkolokDetailsParkolohelyek.
                clickOnUjParkolohelyFelevBtn().
                enterTextToAzonositoFld(parkhelyAzonosito3).
                selectElemFromParkHelyTipDropDown(parkolohelyTip3).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertTrue(parkolokDetailsParkolohelyek.felvettParkolohelyMegjATablazatban(parkhelyAzonosito3, "1"));
        parkolokDetailsParkolohelyek.
                clickOnUjParkolohelyFelevBtn().
                enterTextToAzonositoFld(parkhelyAzonosito4).
                selectElemFromParkHelyTipDropDown(parkolohelyTip4).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertTrue(parkolokDetailsParkolohelyek.felvettParkolohelyMegjATablazatban(parkhelyAzonosito4, "1"));
        parkolokDetailsParkolohelyek.
                clickOnUjParkolohelyFelevBtn().
                enterTextToAzonositoFld(parkhelyAzonosito5).
                selectElemFromParkHelyTipDropDown(parkolohelyTip1).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertTrue(parkolokDetailsParkolohelyek.felvettParkolohelyMegjATablazatban(parkhelyAzonosito5, "1"));
        parkolokDetailsParkolohelyek.
                clickOnUjParkolohelyFelevBtn().
                enterTextToAzonositoFld(parkhelyAzonosito6).
                selectElemFromParkHelyTipDropDown(parkolohelyTip2).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertTrue(parkolokDetailsParkolohelyek.felvettParkolohelyMegjATablazatban(parkhelyAzonosito6, "1")); //2db-Elektromos autó, 2db-Családos, 1db-Normál, 1db-Rokkant
        Assert.assertEquals(parkolokDetailsParkolohelyek.parkolohelyekSzamaTablazat(), 6);
        Assert.assertEquals(parkolokDetailsParkolohelyek.parkolohelyekSzamaHeader(), "Parkolóhelyek (6)");

        parkolokDetailsPageTabs.clickOnAlapadatokTab();
        ParkolokDetailsAlapadatok parkolokDetailsAlapadatok = new ParkolokDetailsAlapadatok(getDriver());
        Assert.assertEquals(parkolokDetailsAlapadatok.parkolohelyekSzamaHeaderben(), "Parkolóhelyek (6)");
        Assert.assertEquals(parkolokDetailsAlapadatok.normalParkolohelySzama(), "1");
        Assert.assertEquals(parkolokDetailsAlapadatok.rokkantParkolohelySzama(), "1");
        Assert.assertEquals(parkolokDetailsAlapadatok.csaladosParkolohelySzama(), "2");
        Assert.assertEquals(parkolokDetailsAlapadatok.elektrAutoParkolohelySzama(), "2");

        parkolokDetailsPageTabs.clickOnParkolohelyekTab();  //+1 Elektomos auto tip park.hely felvétele
        parkolokDetailsParkolohelyek.
                clickOnFelvetelBtn().
                enterTextToAzonositoFld(parkhelyAzonosito7).
                selectElemFromParkHelyTipDropDown(parkolohelyTip1).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertTrue(parkolokDetailsParkolohelyek.felvettParkolohelyMegjATablazatban(parkhelyAzonosito7, "1"));
    }

    @Test
    public void Parkolohelyek_szerkesztese() throws IOException {
        UjParkolo ujParkolo = deserializeJson("ujParkolo.json", UjParkolo.class);
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToParkolokPanel();

        //új parkoló felvétele
        String parkMegn = "Parkoló" + new FakerUtils().generateRandomNumber();
        String azonosito = "12" + new FakerUtils().generateRandomNumber();
        ParkolokPage parkolokPage = new ParkolokPage(getDriver());
        parkolokPage.clickOnUjParkoloFelveteleBtn().
                enterParkoloMegn(parkMegn).
                setUjParkolo(ujParkolo).
                enterAzonosito(azonosito).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();  //csak frissítés után jelenik meg az elem a listában
        Assert.assertEquals(parkolokPage.felvettParkoloMegjAListaban(), azonosito);
        parkolokPage.clickOnListaElsoParkolo();
        ParkolokDetailsPageTabs parkolokDetailsPageTabs = new ParkolokDetailsPageTabs(getDriver()).
                clickOnParkolohelyekTab();
        ParkolokDetailsParkolohelyek parkolokDetailsParkolohelyek = new ParkolokDetailsParkolohelyek(getDriver());
        String parkhelyAzonosito = "Teszt Parkolóhely" + new FakerUtils().generateRandomNumber();
        String parkolohelyTip = "Elektromos autó";
        String parkhelyAzonositoMod = "Teszt Parkolóhely" + new FakerUtils().generateRandomNumber();
        String parkolohelyTipMod = "Családos";

        parkolokDetailsParkolohelyek.
                clickOnUjParkolohelyFelevBtn().
                enterTextToAzonositoFld(parkhelyAzonosito).
                selectElemFromParkHelyTipDropDown(parkolohelyTip).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertTrue(parkolokDetailsParkolohelyek.felvettParkolohelyMegjATablazatban(parkhelyAzonosito, "1"));
        parkolokDetailsParkolohelyek.
                clickOnMuveletekBtn().
                clickOnSzerkesztesMuvelDropDown().
                clearAzonositFld().
                enterTextToAzonositoFld(parkhelyAzonositoMod).
                clearParkTipDropDown().
                selectElemFromParkHelyTipDropDown(parkolohelyTipMod).
                clickOnMentesBtn();
        Assert.assertEquals(parkolokDetailsParkolohelyek.sikeresRogzMessage(), "Sikeres rögzítés!");
        getDriver().navigate().refresh();
        Assert.assertTrue(parkolokDetailsParkolohelyek.felvettParkolohelyMegjATablazatban(parkhelyAzonositoMod, "1"));
        Assert.assertFalse(parkolokDetailsParkolohelyek.felvettParkolohelyMegjATablazatban(parkhelyAzonosito, "1"));
    }

    @Test
    public void Parkolohely_torlese() throws IOException {
        UjParkolo ujParkolo = deserializeJson("ujParkolo.json", UjParkolo.class);
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToParkolokPanel();

        //új parkoló felvétele
        String parkMegn = "Parkoló" + new FakerUtils().generateRandomNumber();
        String azonosito = "12" + new FakerUtils().generateRandomNumber();
        ParkolokPage parkolokPage = new ParkolokPage(getDriver());
        parkolokPage.clickOnUjParkoloFelveteleBtn().
                enterParkoloMegn(parkMegn).
                setUjParkolo(ujParkolo).
                enterAzonosito(azonosito).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();  //csak frissítés után jelenik meg az elem a listában
        Assert.assertEquals(parkolokPage.felvettParkoloMegjAListaban(), azonosito);
        parkolokPage.clickOnListaElsoParkolo();
        ParkolokDetailsPageTabs parkolokDetailsPageTabs = new ParkolokDetailsPageTabs(getDriver()).
                clickOnParkolohelyekTab();
        ParkolokDetailsParkolohelyek parkolokDetailsParkolohelyek = new ParkolokDetailsParkolohelyek(getDriver());
        String parkhelyAzonosito = "Teszt Parkolóhely" + new FakerUtils().generateRandomNumber();
        String parkolohelyTip = "Elektromos autó";

        parkolokDetailsParkolohelyek.
                clickOnUjParkolohelyFelevBtn().
                enterTextToAzonositoFld(parkhelyAzonosito).
                selectElemFromParkHelyTipDropDown(parkolohelyTip).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertTrue(parkolokDetailsParkolohelyek.felvettParkolohelyMegjATablazatban(parkhelyAzonosito, "1"));
        parkolokDetailsParkolohelyek.
                clickOnMuveletekBtn().
                clickOnTorlesMuvelDropDown().
                clickOnMegsemMegEroBtn().
                clickOnMuveletekBtn().
                clickOnTorlesMuvelDropDown().
                clickOnTorlesBtn();
        Assert.assertFalse(parkolokDetailsParkolohelyek.felvettParkolohelyMegjATablazatban(parkhelyAzonosito, "1"));
    }

    @Test
    public void Kereses_a_parkolohelyek_kozott() throws IOException, InterruptedException { //ELLENŐRIZNI
        UjParkolo ujParkolo = deserializeJson("ujParkolo.json", UjParkolo.class);
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToParkolokPanel();

        //új parkoló felvétele
        String parkMegn = "Parkoló" + new FakerUtils().generateRandomNumber();
        String azonosito = "12" + new FakerUtils().generateRandomNumber();
        ParkolokPage parkolokPage = new ParkolokPage(getDriver());
        parkolokPage.clickOnUjParkoloFelveteleBtn().
                enterParkoloMegn(parkMegn).
                setUjParkolo(ujParkolo).
                enterAzonosito(azonosito).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();  //csak frissítés után jelenik meg az elem a listában
        Assert.assertEquals(parkolokPage.felvettParkoloMegjAListaban(), azonosito);
        parkolokPage.clickOnListaElsoParkolo();
        ParkolokDetailsPageTabs parkolokDetailsPageTabs = new ParkolokDetailsPageTabs(getDriver()).
                clickOnParkolohelyekTab();
        ParkolokDetailsParkolohelyek parkolokDetailsParkolohelyek = new ParkolokDetailsParkolohelyek(getDriver());
        String parkhelyAzonosito = "Teszt Parkolóhely" + new FakerUtils().generateRandomNumber();
        String parkolohelyTip = "Elektromos autó";

        parkolokDetailsParkolohelyek.
                clickOnUjParkolohelyFelevBtn().
                enterTextToAzonositoFld(parkhelyAzonosito).
                selectElemFromParkHelyTipDropDown(parkolohelyTip).
                clickOnFelvetelBtn();
        Assert.assertTrue(parkolokDetailsParkolohelyek.felvettParkolohelyMegjATablazatban(parkhelyAzonosito, "1"));

        Szurok szurok = new Szurok(getDriver()).
                clickOnSzurokBtn().
                enterTextToAzonFldParkolohely(parkhelyAzonosito).
                clickOnKeresesBtn();
        Assert.assertEquals(parkolokDetailsParkolohelyek.felvettParkolohelyMegjAListaban(), parkhelyAzonosito);
        szurok.clickOnSzurokTorleseBtn();

        szurok.clickOnSzurokBtn().
                selectFromParkolohelyTipusaDropDown(parkolohelyTip).
                clickOnKeresesBtn();
        Assert.assertEquals(parkolokDetailsParkolohelyek.felvettParkolohelyMegjAListaban(), parkolohelyTip);
        szurok.clickOnSzurokTorleseBtn();
    }

    @Test
    public void Ingatlanok_hozzarendelese_a_parkolohoz() throws IOException {  //ELLENŐRIZNI
        UjParkolo ujParkolo = deserializeJson("ujParkolo.json", UjParkolo.class);
        // 2 ingatlanhoz a partner-szervezet fölvétele
        //1. szervezet
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
        SideMenu sideMenu1 = new SideMenu(getDriver()).navigateToSzervezetekPanel();
        String szervezetAzon = "Szervezet" + new FakerUtils().generateRandomNumber();

        SzervezetekPage szervezetekPage = new SzervezetekPage(getDriver());
        szervezetekPage.clickOnUjSzervezetFelveteleBtn();
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.enterSzervezetAzonositoFld(szervezetAzon);
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.selectKapcsolodoPartnerFromDropDown(partnerNeve);
        Assert.assertTrue(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.clickOnFelvetelBtn();

        //2 ingatlan fölvétele
        //1. ingatlan
        sideMenu.navigateToIngatlanokPanel();
        UjIngatlan ujIngatlan = deserializeJson("ujIngatlan.json", UjIngatlan.class);
        IngatlanokPage ingatlanokPage = new IngatlanokPage(getDriver());
        ingatlanokPage.clickOnUjIngatlanFelveteleBtn();
        String megnevezes = "Teszt Ingatlan" + new FakerUtils().generateRandomNumber();
        ingatlanokPage.
                enterTextToMegnevezesFld(megnevezes).
                setUjIngatlan(ujIngatlan).
                selectElementFromSzervezetDropDown(partnerNeve).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertEquals(ingatlanokPage.ingatlanMegjATabl(megnevezes), megnevezes);

        //2. ingatlan
        ingatlanokPage.clickOnUjIngatlanFelveteleBtn();
        String megnevezes2 = "Teszt Ingatlan" + new FakerUtils().generateRandomNumber();
        ingatlanokPage.
                enterTextToMegnevezesFld(megnevezes2).
                setUjIngatlan(ujIngatlan).
                selectElementFromSzervezetDropDown(partnerNeve).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertEquals(ingatlanokPage.ingatlanMegjATabl(megnevezes2), megnevezes2);

        //parkolóhoz - a 2 ingatlan hozzárendelése
        String parkMegn = "Parkoló" + new FakerUtils().generateRandomNumber();
        String azonosito = "12" + new FakerUtils().generateRandomNumber();
        ParkolokPage parkolokPage = new ParkolokPage(getDriver());
        parkolokPage.clickOnUjParkoloFelveteleBtn().
                enterParkoloMegn(parkMegn).
                setUjParkolo(ujParkolo).
                enterAzonosito(azonosito).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();  //csak frissítés után jelenik meg az elem a listában
        Assert.assertEquals(parkolokPage.felvettParkoloMegjAListaban(), azonosito);
        parkolokPage.clickOnListaElsoParkolo();
        ParkolokDetailsPageTabs parkolokDetailsPageTabs = new ParkolokDetailsPageTabs(getDriver()).
                clickOnIngatlanokTab();
        ParkolokDetailsIngatlanok parkolokDetailsIngatlanok = new ParkolokDetailsIngatlanok(getDriver());
        Assert.assertTrue(parkolokDetailsIngatlanok.nincsMegjAdatFelirat());
        Assert.assertEquals(parkolokDetailsIngatlanok.ingatlanokFelirat("Ingatlanok (0)"), "Ingatlanok (0)");
        parkolokDetailsIngatlanok.clickOnHozzarendelesBtn();
        Assert.assertTrue(parkolokDetailsIngatlanok.eltavolitasBtnInaktiv());
        parkolokDetailsIngatlanok.
                clickOnCheckbox(megnevezes);
        Assert.assertFalse(parkolokDetailsIngatlanok.hozzarendelesBtnInaktiv());
        Assert.assertEquals(parkolokDetailsIngatlanok.hozzarendelesSzama("1"), "1");
        parkolokDetailsIngatlanok.
                clickOnCheckbox(megnevezes2);
        Assert.assertFalse(parkolokDetailsIngatlanok.hozzarendelesBtnInaktiv());
        Assert.assertEquals(parkolokDetailsIngatlanok.hozzarendelesSzama("2"), "2");
        parkolokDetailsIngatlanok.
                clickOnHozzarendelesBtn();

        Assert.assertTrue(parkolokDetailsIngatlanok.popupMegjelenik("Sikeres hozzárendelés"));
        Assert.assertEquals(parkolokDetailsIngatlanok.ingatlanokFelirat("Ingatlanok (2)"), "Ingatlanok (2)");
        Assert.assertFalse(parkolokDetailsIngatlanok.hozzarendelesBtnInaktiv());

        parkolokDetailsIngatlanok.clickOnHozzarendelesBtn();
        Assert.assertFalse(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes, "3"));
        Assert.assertFalse(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes2, "3"));

        parkolokDetailsIngatlanok.
                clickOnMegsem().
                clickOnListaElsoElem();
        IngatlanokDetailsAlapadatok ingatlanokDetailsAlapadatok = new IngatlanokDetailsAlapadatok(getDriver());
        Assert.assertTrue(ingatlanokDetailsAlapadatok.ingatlanAdatlaponAllunk(megnevezes2));

        IngatlanokDetailsPageTabs ingatlanokDetailsPageTabs = new IngatlanokDetailsPageTabs(getDriver()).
                clickOnParkolasTab();
        IngatlanokDetailsParkolas ingatlanokDetailsParkolas = new IngatlanokDetailsParkolas(getDriver());
        Assert.assertTrue(ingatlanokDetailsParkolas.parkoloMegjATabl(parkMegn, "2"));
    }

    @Test
    public void Inaktiv_ingatlan_hozzarendelese_a_parkolohoz() throws IOException {
        UjParkolo ujParkolo = deserializeJson("ujParkolo.json", UjParkolo.class);

        //1 szervezet
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
        SideMenu sideMenu1 = new SideMenu(getDriver()).navigateToSzervezetekPanel();
        String szervezetAzon = "Szervezet" + new FakerUtils().generateRandomNumber();

        SzervezetekPage szervezetekPage = new SzervezetekPage(getDriver());
        szervezetekPage.clickOnUjSzervezetFelveteleBtn();
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.enterSzervezetAzonositoFld(szervezetAzon);
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.selectKapcsolodoPartnerFromDropDown(partnerNeve);
        Assert.assertTrue(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.clickOnFelvetelBtn();

        //1. ingatlan
        sideMenu.navigateToIngatlanokPanel();
        UjIngatlan ujIngatlan = deserializeJson("ujIngatlan.json", UjIngatlan.class);
        IngatlanokPage ingatlanokPage = new IngatlanokPage(getDriver());
        IngatlanokDetailsAlapadatok ingatlanokDetailsAlapadatok = new IngatlanokDetailsAlapadatok(getDriver());
        ingatlanokPage.clickOnUjIngatlanFelveteleBtn();
        String megnevezes = "Teszt Ingatlan" + new FakerUtils().generateRandomNumber();
        ingatlanokPage.
                enterTextToMegnevezesFld(megnevezes).
                setUjIngatlan(ujIngatlan).
                selectElementFromSzervezetDropDown(partnerNeve).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertEquals(ingatlanokPage.ingatlanMegjATabl(megnevezes), megnevezes);
        ingatlanokPage.clickOnElsoIngatlan();
        Assert.assertTrue(ingatlanokDetailsAlapadatok.ingatlanAdatlaponAllunk(megnevezes));
        ingatlanokDetailsAlapadatok.
                clickOnInaktivalasBtn().
                clickInIgenBtn().
                popupInaktivalasMegj();

        sideMenu.navigateToParkolokPanel();
        String parkMegn = "Parkoló" + new FakerUtils().generateRandomNumber();
        String azonosito = "12" + new FakerUtils().generateRandomNumber();
        ParkolokPage parkolokPage = new ParkolokPage(getDriver());
        parkolokPage.clickOnUjParkoloFelveteleBtn().
                enterParkoloMegn(parkMegn).
                setUjParkolo(ujParkolo).
                enterAzonosito(azonosito).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();  //csak frissítés után jelenik meg az elem a listában
        Assert.assertEquals(parkolokPage.felvettParkoloMegjAListaban(), azonosito);
        parkolokPage.clickOnListaElsoParkolo();
        ParkolokDetailsPageTabs parkolokDetailsPageTabs = new ParkolokDetailsPageTabs(getDriver());
        parkolokDetailsPageTabs.clickOnIngatlanokTab();
        ParkolokDetailsIngatlanok parkolokDetailsIngatlanok = new ParkolokDetailsIngatlanok(getDriver()).
                clickOnHozzarendelesBtn();
        Assert.assertFalse(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes, "3"));
    }

    @Test
    public void Ingatlan_eltavolitasa_a_parkolorol() throws IOException { //ELLENŐRIZNI

        UjParkolo ujParkolo = deserializeJson("ujParkolo.json", UjParkolo.class);

        //1 szervezet
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
        SideMenu sideMenu1 = new SideMenu(getDriver()).navigateToSzervezetekPanel();
        String szervezetAzon = "Szervezet" + new FakerUtils().generateRandomNumber();

        SzervezetekPage szervezetekPage = new SzervezetekPage(getDriver());
        szervezetekPage.clickOnUjSzervezetFelveteleBtn();
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.enterSzervezetAzonositoFld(szervezetAzon);
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.selectKapcsolodoPartnerFromDropDown(partnerNeve);
        Assert.assertTrue(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.clickOnFelvetelBtn();

        //1. ingatlan
        sideMenu.navigateToIngatlanokPanel();
        UjIngatlan ujIngatlan = deserializeJson("ujIngatlan.json", UjIngatlan.class);
        IngatlanokPage ingatlanokPage = new IngatlanokPage(getDriver());
        IngatlanokDetailsAlapadatok ingatlanokDetailsAlapadatok = new IngatlanokDetailsAlapadatok(getDriver());
        ingatlanokPage.clickOnUjIngatlanFelveteleBtn();
        String megnevezes = "Teszt Ingatlan" + new FakerUtils().generateRandomNumber();
        ingatlanokPage.
                enterTextToMegnevezesFld(megnevezes).
                setUjIngatlan(ujIngatlan).
                selectElementFromSzervezetDropDown(partnerNeve).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertEquals(ingatlanokPage.ingatlanMegjATabl(megnevezes), megnevezes);
        ingatlanokPage.clickOnElsoIngatlan();
        Assert.assertTrue(ingatlanokDetailsAlapadatok.ingatlanAdatlaponAllunk(megnevezes));
        ingatlanokDetailsAlapadatok.clickOnAdatokSzerkeszteseBtn().
                clickOnInaktivalasBtn().
                clickInIgenBtn().
                popupInaktivalasMegj();

        sideMenu.navigateToParkolokPanel();
        String parkMegn = "Parkoló" + new FakerUtils().generateRandomNumber();
        String azonosito = "12" + new FakerUtils().generateRandomNumber();
        ParkolokPage parkolokPage = new ParkolokPage(getDriver());
        parkolokPage.clickOnUjParkoloFelveteleBtn().
                enterParkoloMegn(parkMegn).
                setUjParkolo(ujParkolo).
                enterAzonosito(azonosito).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertEquals(parkolokPage.felvettParkoloMegjAListaban(), azonosito);
        parkolokPage.clickOnListaElsoParkolo();
        ParkolokDetailsPageTabs parkolokDetailsPageTabs = new ParkolokDetailsPageTabs(getDriver());
        parkolokDetailsPageTabs.clickOnIngatlanokTab();
        ParkolokDetailsIngatlanok parkolokDetailsIngatlanok = new ParkolokDetailsIngatlanok(getDriver()).
                clickOnHozzarendelesBtn();
        Assert.assertTrue(parkolokDetailsIngatlanok.hozzarendelesBtnInaktiv());
        parkolokDetailsIngatlanok.
                clickOnCheckbox(megnevezes);
        Assert.assertFalse(parkolokDetailsIngatlanok.hozzarendelesBtnInaktiv());
        Assert.assertEquals(parkolokDetailsIngatlanok.hozzarendelesSzama("1"), "1");
          parkolokDetailsIngatlanok.
                  clickOnHozzarendelesBtn();
          Assert.assertTrue(parkolokDetailsIngatlanok.popupMegjelenik("Sikeres hozzárendelés"));
        Assert.assertTrue(parkolokDetailsIngatlanok.eltavolitasBtnInaktiv());
          parkolokDetailsIngatlanok.
                  clickOnCheckbox(megnevezes).
                  clickOnEltavolitasBtn().
                  clickOnMegsem();
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes, "3"));
        parkolokDetailsIngatlanok.
                clickOnEltavolitasBtn().
                clickOntorlesBtn();
        Assert.assertTrue(parkolokDetailsIngatlanok.popupMegjelenik("Sikeres törlés"));
        sideMenu.navigateToIngatlanokPanel();
        ingatlanokPage.selectIngatlanFromTablazat(megnevezes, "2");
        IngatlanokDetailsPageTabs ingatlanokDetailsPageTabs = new IngatlanokDetailsPageTabs(getDriver()).
                clickOnParkolasTab();
        IngatlanokDetailsParkolas ingatlanokDetailsParkolas = new IngatlanokDetailsParkolas(getDriver());
        Assert.assertFalse(ingatlanokDetailsParkolas.parkoloMegjATabl(parkMegn, "2"));
    }

    @Test
    public void Kereses_a_parkolohoz_rendelt_ingatlanok_kozott() throws IOException {  //ELLENŐRIZNI
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());
        //szervezet felvétele
        sideMenu.navigateToPartnerekPanel();
        String partnerNeve = "Teszt Partner" + new FakerUtils().generateRandomNumber();
        String telefonszam = "06202102121";
        String email = "email@gmail.com";
        PartnerekPage partnerekPage = new PartnerekPage(getDriver()).
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(partnerNeve).
                enterTelefonszFld(telefonszam).
                enterEmailFld(email).
                clickOnFelvetelBtn();
        SideMenu sideMenu1 = new SideMenu(getDriver()).navigateToSzervezetekPanel();
        String szervezetAzon = "Szervezet" + new FakerUtils().generateRandomNumber();

        SzervezetekPage szervezetekPage = new SzervezetekPage(getDriver());
        szervezetekPage.clickOnUjSzervezetFelveteleBtn();
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.enterSzervezetAzonositoFld(szervezetAzon);
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.selectKapcsolodoPartnerFromDropDown(partnerNeve);
        Assert.assertTrue(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.clickOnFelvetelBtn();

        //1. ingatlan
        sideMenu.navigateToIngatlanokPanel();
        UjIngatlan ujIngatlan = deserializeJson("ujIngatlan.json", UjIngatlan.class);
        IngatlanokPage ingatlanokPage = new IngatlanokPage(getDriver());
        String megnevezes1 = "Teszt Ingatlan" + new FakerUtils().generateRandomNumber();
        String megnevezes2 = "Teszt Ingatlan" + new FakerUtils().generateRandomNumber();
        String megnevezes3 = "Teszt Ingatlan" + new FakerUtils().generateRandomNumber();
        ingatlanokPage.clickOnUjIngatlanFelveteleBtn();
        ingatlanokPage.
                enterTextToMegnevezesFld(megnevezes1).
                setUjIngatlan(ujIngatlan).
                selectElementFromSzervezetDropDown(partnerNeve).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertEquals(ingatlanokPage.ingatlanMegjATabl(megnevezes1), megnevezes1);

        ingatlanokPage.clickOnUjIngatlanFelveteleBtn();
        ingatlanokPage.
                enterTextToMegnevezesFld(megnevezes2).
                setUjIngatlan(ujIngatlan).
                selectElementFromSzervezetDropDown(partnerNeve).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertEquals(ingatlanokPage.ingatlanMegjATabl(megnevezes2), megnevezes2);

        ingatlanokPage.clickOnUjIngatlanFelveteleBtn();
        ingatlanokPage.
                enterTextToMegnevezesFld(megnevezes3).
                setUjIngatlan(ujIngatlan).
                selectElementFromSzervezetDropDown(partnerNeve).
                clickOnFelvetelBtn();
        Assert.assertEquals(ingatlanokPage.ingatlanMegjATabl(megnevezes3), megnevezes3);

        //parkoló felvétele
        UjParkolo ujParkolo = deserializeJson("ujParkolo.json", UjParkolo.class);
        sideMenu.navigateToPartnerekPanel().
                navigateToParkolokPanel();
        String parkMegn = "Parkoló" + new FakerUtils().generateRandomNumber();
        String azonosito = "12" + new FakerUtils().generateRandomNumber();
        ParkolokPage parkolokPage = new ParkolokPage(getDriver());
        parkolokPage.clickOnUjParkoloFelveteleBtn().
                enterParkoloMegn(parkMegn).
                setUjParkolo(ujParkolo).
                enterAzonosito(azonosito).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();  //csak frissítés után jelenik meg az elem a listában
        Assert.assertEquals(parkolokPage.felvettParkoloMegjAListaban(), azonosito);
        parkolokPage.clickOnListaElsoParkolo();
        ParkolokDetailsPageTabs parkolokDetailsPageTabs = new ParkolokDetailsPageTabs(getDriver()).clickOnIngatlanokTab();
        ParkolokDetailsIngatlanok parkolokDetailsIngatlanok = new ParkolokDetailsIngatlanok(getDriver());
        parkolokDetailsIngatlanok.
                clickOnHozzarendelesBtn().
                clickOnCheckbox(megnevezes1).
                clickOnCheckbox(megnevezes2).
                clickOnCheckbox(megnevezes3).
                clickOnHozzarendelesBtn();

        //Szűrés
        Szurok szurok = new Szurok(getDriver());
        szurok.
                clickOnSzurokBtn().
                enterToMegnevezesFldIng(megnevezes1).
                clickOnKeresesBtn();
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes1, "1"));
        Assert.assertFalse(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes2, "1"));
        Assert.assertFalse(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes3, "1"));
        szurok.
                clickOnSzurokTorleseBtn();

        szurok.
                clickOnSzurokBtn().
                selectElemFromJellegDropDownIng("Hétvégi ház").
                clickOnKeresesBtn();
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes1, "1"));
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes2, "1"));
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes3, "1"));
        szurok.
                clickOnSzurokTorleseBtn();

        szurok.
                clickOnSzurokBtn().
                enterToIranyitoszamFldIng("6720").
                clickOnKeresesBtn();
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes1, "1"));
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes2, "1"));
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes3, "1"));
        szurok.
                clickOnSzurokTorleseBtn();

        szurok.
                clickOnSzurokBtn().
                enterToVarosFldIng("Szeged").
                clickOnKeresesBtn();
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes1, "1"));
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes2, "1"));
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes3, "1"));
        szurok.
                clickOnSzurokTorleseBtn();

        szurok.
                clickOnSzurokBtn().
                enterToKozteruletNeveFldIng("Mátyás").
                clickOnKeresesBtn();
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes1, "1"));
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes2, "1"));
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes3, "1"));
        szurok.
                clickOnSzurokTorleseBtn();

        szurok.
                clickOnSzurokBtn().
                enterTextToHrszFld("123/456").
                clickOnKeresesBtn();
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes1, "1"));
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes2, "1"));
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes3, "1"));
        szurok.
                clickOnSzurokTorleseBtn();

        szurok.
                clickOnSzurokBtn().
                selectElemFromHasznositasDropDownIng("Egyéb").
                clickOnKeresesBtn();
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes1, "1"));
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes2, "1"));
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes3, "1"));
        szurok.
                clickOnSzurokTorleseBtn();

        szurok.
                clickOnSzurokBtn().
                selectElemFromBankuzemiCeluDropDownIng("Nem").
                clickOnKeresesBtn();
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes1, "1"));
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes2, "1"));
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes3, "1"));
        szurok.
                clickOnSzurokTorleseBtn();
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes1, "1"));
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes2, "1"));
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes3, "1"));


    }

    @Test
    public void Kereses_az_ingatlan_hozzarendelese_listaban() throws IOException { //ELLenőrizni
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());
        //szervezet felvétele
        sideMenu.navigateToPartnerekPanel();
        String partnerNeve = "Teszt Partner" + new FakerUtils().generateRandomNumber();
        String telefonszam = "06202102121";
        String email = "email@gmail.com";
        PartnerekPage partnerekPage = new PartnerekPage(getDriver()).
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(partnerNeve).
                enterTelefonszFld(telefonszam).
                enterEmailFld(email).
                clickOnFelvetelBtn();
        SideMenu sideMenu1 = new SideMenu(getDriver()).navigateToSzervezetekPanel();
        String szervezetAzon = "Szervezet" + new FakerUtils().generateRandomNumber();

        SzervezetekPage szervezetekPage = new SzervezetekPage(getDriver());
        szervezetekPage.clickOnUjSzervezetFelveteleBtn();
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.enterSzervezetAzonositoFld(szervezetAzon);
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.selectKapcsolodoPartnerFromDropDown(partnerNeve);
        Assert.assertTrue(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.clickOnFelvetelBtn();

        //1. ingatlan
        sideMenu.navigateToIngatlanokPanel();
        UjIngatlan ujIngatlan = deserializeJson("ujIngatlan.json", UjIngatlan.class);
        IngatlanokPage ingatlanokPage = new IngatlanokPage(getDriver());
        String megnevezes1 = "Teszt Ingatlan" + new FakerUtils().generateRandomNumber();
        ingatlanokPage.clickOnUjIngatlanFelveteleBtn();
        ingatlanokPage.
                enterTextToMegnevezesFld(megnevezes1).
                setUjIngatlan(ujIngatlan).
                selectElementFromSzervezetDropDown(partnerNeve).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertEquals(ingatlanokPage.ingatlanMegjATabl(megnevezes1), megnevezes1);

        //parkoló felvétele
        UjParkolo ujParkolo = deserializeJson("ujParkolo.json", UjParkolo.class);
        sideMenu.navigateToPartnerekPanel().
                navigateToParkolokPanel();
        String parkMegn = "Parkoló" + new FakerUtils().generateRandomNumber();
        String azonosito = "12" + new FakerUtils().generateRandomNumber();
        ParkolokPage parkolokPage = new ParkolokPage(getDriver());
        parkolokPage.clickOnUjParkoloFelveteleBtn().
                enterParkoloMegn(parkMegn).
                setUjParkolo(ujParkolo).
                enterAzonosito(azonosito).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertEquals(parkolokPage.felvettParkoloMegjAListaban(), azonosito);
        parkolokPage.clickOnListaElsoParkolo();
        ParkolokDetailsPageTabs parkolokDetailsPageTabs = new ParkolokDetailsPageTabs(getDriver()).clickOnIngatlanokTab();
        ParkolokDetailsIngatlanok parkolokDetailsIngatlanok = new ParkolokDetailsIngatlanok(getDriver()).clickOnHozzarendelesBtn();

        //Szűrés
        Szurok szurok = new Szurok(getDriver());
        szurok.
                clickOnSzurokBtn().
                enterToMegnevezesFldIng(megnevezes1).
                clickOnKeresesBtn();
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes1, "1"));

        szurok.
                clickOnSzurokTorleseBtn();

        szurok.
                clickOnSzurokBtn().
                selectElemFromJellegDropDownIng("Hétvégi ház").
                clickOnKeresesBtn();
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl("Hétvégi ház", "4"));

        szurok.
                clickOnSzurokTorleseBtn();

        szurok.
                clickOnSzurokBtn().
                enterToIranyitoszamFldIng("6720").
                clickOnKeresesBtn();
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl("6720", "5"));

        szurok.
                clickOnSzurokTorleseBtn();

        szurok.
                clickOnSzurokBtn().
                enterToVarosFldIng("Szeged").
                clickOnKeresesBtn();
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl("Szeged", "5"));

        szurok.
                clickOnSzurokTorleseBtn();

        szurok.
                clickOnSzurokBtn().
                enterToKozteruletNeveFldIng("Mátyás").
                clickOnKeresesBtn();
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl("Mátyás", "5"));

        szurok.
                clickOnSzurokTorleseBtn();

        szurok.
                clickOnSzurokBtn().
                enterTextToHrszFld("123/456").
                clickOnKeresesBtn();
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl("123/456", "6"));

        szurok.
                clickOnSzurokTorleseBtn();

        szurok.
                clickOnSzurokBtn().
                selectElemFromHasznositasDropDownIng("Egyéb").
                clickOnKeresesBtn();
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl("Egyéb", "8"));

        szurok.
                clickOnSzurokTorleseBtn();

        szurok.
                clickOnSzurokBtn().
                selectElemFromBankuzemiCeluDropDownIng("Nem").
                clickOnKeresesBtn();
        Assert.assertTrue(parkolokDetailsIngatlanok.bankuzemCeluUnchecked());

        szurok.
                clickOnSzurokTorleseBtn();
        Assert.assertTrue(parkolokDetailsIngatlanok.ingatlanMegjATabl(megnevezes1, "1"));

    }


}

