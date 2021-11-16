package hu.fonixit.buildfolio.autotest.tests;

import hu.fonixit.buildfolio.autotest.base.BaseTest;
import hu.fonixit.buildfolio.autotest.objects.ADUser;
import hu.fonixit.buildfolio.autotest.objects.UjParkolo;
import hu.fonixit.buildfolio.autotest.pages.DashboardPage;
import hu.fonixit.buildfolio.autotest.pages.LoginPage;
import hu.fonixit.buildfolio.autotest.pages.ParkolokPage;
import hu.fonixit.buildfolio.autotest.pages.components.SideMenu;
import hu.fonixit.buildfolio.autotest.pages.components.Szurok;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.ParkolokDetailsPages.ParkolokDetailsAlapadatok;
import hu.fonixit.buildfolio.autotest.utils.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static hu.fonixit.buildfolio.autotest.utils.JacksonUtils.deserializeJson;

public class ParkolokTest extends BaseTest { //Szekvenciálisan kell lefutnia

    @Test
    public void Uj_parkolo_felvetele() throws IOException { //új parkolók felvételénél mely mezők egyediek?
        UjParkolo ujParkolo = deserializeJson("ujParkolo.json", UjParkolo.class);

        ADUser user = new ADUser().
                setADUsername("takarekingatlanuser1").
                setPassword("Testing123");
        DashboardPage dashboardPage = new LoginPage(getDriver()).
                load().
                enterTextInUsernameFld(user.getADUsername()).
                enterTextInPasswordFld(user.getPassword()).
                belepes();
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
        Assert.assertEquals(parkolokPage.felvettParkoloMegjAListaba(), azonosito);
    }

    @Test
    public void Uj_parkolo_felvetele_kotelezo_mezok_kitoltese_nelkul() throws IOException {
        UjParkolo ujParkolo = deserializeJson("ujParkolo.json", UjParkolo.class);
        ADUser user = new ADUser().
                setADUsername("takarekingatlanuser1").
                setPassword("Testing123");
        DashboardPage dashboardPage = new LoginPage(getDriver()).
                load().
                enterTextInUsernameFld(user.getADUsername()).
                enterTextInPasswordFld(user.getPassword()).
                belepes();
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

        ADUser user = new ADUser().
                setADUsername("takarekingatlanuser1").
                setPassword("Testing123");
        DashboardPage dashboardPage = new LoginPage(getDriver()).
                load().
                enterTextInUsernameFld(user.getADUsername()).
                enterTextInPasswordFld(user.getPassword()).
                belepes();
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
        ADUser user = new ADUser().
                setADUsername("takarekingatlanuser1").
                setPassword("Testing123");
        DashboardPage dashboardPage = new LoginPage(getDriver()).
                load().
                enterTextInUsernameFld(user.getADUsername()).
                enterTextInPasswordFld(user.getPassword()).
                belepes();
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
        ADUser user = new ADUser().
                setADUsername("takarekingatlanuser1").
                setPassword("Testing123");
        DashboardPage dashboardPage = new LoginPage(getDriver()).
                load().
                enterTextInUsernameFld(user.getADUsername()).
                enterTextInPasswordFld(user.getPassword()).
                belepes();
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
        Assert.assertEquals(parkolokPage.felvettParkoloMegjAListaba(), azonosito);

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
        ADUser user = new ADUser().
                setADUsername("takarekingatlanuser1").
                setPassword("Testing123");
        DashboardPage dashboardPage = new LoginPage(getDriver()).
                load().
                enterTextInUsernameFld(user.getADUsername()).
                enterTextInPasswordFld(user.getPassword()).
                belepes();
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
        Assert.assertEquals(parkolokPage.felvettParkoloMegjAListaba(), azonosito);
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










    }

