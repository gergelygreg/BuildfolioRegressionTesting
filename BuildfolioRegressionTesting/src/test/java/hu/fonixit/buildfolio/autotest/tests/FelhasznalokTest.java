package hu.fonixit.buildfolio.autotest.tests;


import hu.fonixit.buildfolio.autotest.base.BaseTest;
import hu.fonixit.buildfolio.autotest.objects.ADUser;
import hu.fonixit.buildfolio.autotest.objects.UjFelhasznalo;
import hu.fonixit.buildfolio.autotest.pages.*;
import hu.fonixit.buildfolio.autotest.pages.components.Navbar;
import hu.fonixit.buildfolio.autotest.pages.components.SideMenu;
import hu.fonixit.buildfolio.autotest.pages.components.Szurok;
import hu.fonixit.buildfolio.autotest.utils.FakerUtils;
import hu.fonixit.buildfolio.autotest.utils.UserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static hu.fonixit.buildfolio.autotest.utils.JacksonUtils.deserializeJson;

public class FelhasznalokTest extends BaseTest {


    @Test
    public void Uj_felhasznalo_felvetele_az_osszes_mezo_kitoltesevel() throws IOException {
        UjFelhasznalo ujFelhasznalo = deserializeJson("ujFelhasznalo.json", UjFelhasznalo.class);
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());

        //Szervezet felvétele
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

        //új felhasználó felvétele összes mező kitöltésével
        String username = "TestUser" + new FakerUtils().generateRandomNumber();
        String nev = "Teszt Név" + new FakerUtils().generateRandomNumber();
        sideMenu.
                navigateToFelhasznalokPanel();
        UsersPage usersPage = new UsersPage(getDriver())
                .clickOnUjFelhasznaloFelveteleBtn()
                .enterFelhasznalonev(username)
                .enterNev(nev)
                .selectSzervezet(partnerNeve)
                .setUjFelhasznalo(ujFelhasznalo)
                .clickOnFelvetelBtn();
        Assert.assertTrue(usersPage.elemMegjelenikATablazatban(nev, "1"));
    }

    @Test
    public void Uj_felhasznalo_felvetele_uresen_hagyott_mezokkel() throws IOException {
        UjFelhasznalo ujFelhasznalo = deserializeJson("ujFelhasznalo.json", UjFelhasznalo.class);
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());
        //Szervezet felvétele
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

        //új felhasználó felvétele üresen hagyott mezőkkel
        sideMenu.
                navigateToFelhasznalokPanel();
        String username = "TestUser" + new FakerUtils().generateRandomNumber();
        String nev = "Teszt Név" + new FakerUtils().generateRandomNumber();
        String emailFelhasz = "ujemail@gmail.com";
        sideMenu.
                navigateToFelhasznalokPanel();
        UsersPage usersPage = new UsersPage(getDriver()).
                clickOnUjFelhasznaloFelveteleBtn().
                enterFelhasznalonev(username).
                enterNev(nev).
                enterEmail(emailFelhasz).
                felvetelBtnDisabled();
    }

    @Test
    public void Uj_felhasznalo_felvetele_tobb_szerepkorrel() throws IOException {
        UjFelhasznalo ujFelhasznalo = deserializeJson("ujFelhasznalo.json", UjFelhasznalo.class);
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());
        //Szervezet felvétele
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

        //Uj felhasználó felvétele több szerepkörrel
        sideMenu.
                navigateToFelhasznalokPanel();
        String username = "TestUser" + new FakerUtils().generateRandomNumber();
        String nev = "Teszt Név" + new FakerUtils().generateRandomNumber();
        String role1 = "Bérlő";
        String role2 = "Igénykezelő";
        UsersPage usersPage = new UsersPage(getDriver()).
                clickOnUjFelhasznaloFelveteleBtn().
                enterFelhasznalonev(username).
                enterNev(nev).
                selectSzervezet(partnerNeve).
                setUjFelhasznalo(ujFelhasznalo).
                selectPlusSzerepkor(role1).
                selectPlusSzerepkor(role2).
                clickOnFelvetelBtn();
        Assert.assertTrue(usersPage.elemMegjelenikATablazatban(nev, "1"));
    }

    @Test
    public void Uj_felhasznalo_felvetele_az_osszes_szerepkorrel() throws IOException {
        UjFelhasznalo ujFelhasznalo = deserializeJson("ujFelhasznalo.json", UjFelhasznalo.class);
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());
        //Szervezet felvétele
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

        //új felhasználó fölvétele az összes szerepkörrel
        sideMenu.
                navigateToFelhasznalokPanel();
        String username = "TestUser" + new FakerUtils().generateRandomNumber();
        String nev = "Teszt Név" + new FakerUtils().generateRandomNumber();
        String role1 = "Bérlő";
        String role2 = "Igénykezelő";
        String role3 = "Adminisztrátor";
        String role4 = "Kezelő";
        String role5 = "Üzemeltető";
        UsersPage usersPage = new UsersPage(getDriver()).
                clickOnUjFelhasznaloFelveteleBtn().
                enterFelhasznalonev(username).
                enterNev(nev).
                selectSzervezet(partnerNeve).
                setUjFelhasznalo(ujFelhasznalo).
                selectPlusSzerepkor(role1).
                selectPlusSzerepkor(role2).
                selectPlusSzerepkor(role3).
                selectPlusSzerepkor(role4).
                selectPlusSzerepkor(role5).
                clickOnFelvetelBtn();
        Assert.assertTrue(usersPage.elemMegjelenikATablazatban(nev, "1"));
    }

    @Test
    public void Uj_felhasznalo_felvetele_tobb_azonos_szerepkorrel() throws IOException {
        UjFelhasznalo ujFelhasznalo = deserializeJson("ujFelhasznalo.json", UjFelhasznalo.class);
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());
        //Szervezet felvétele
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

        sideMenu.
                navigateToFelhasznalokPanel();
        String username = "TestUser" + new FakerUtils().generateRandomNumber();
        String nev = "Teszt Név" + new FakerUtils().generateRandomNumber();
        String role = "Tulajdonos";
        UsersPage usersPage = new UsersPage(getDriver()).
                clickOnUjFelhasznaloFelveteleBtn().
                enterFelhasznalonev(username).
                enterNev(nev).
                selectSzervezet(partnerNeve).
                setUjFelhasznalo(ujFelhasznalo);
        Assert.assertFalse(usersPage.addMegegyezoSzerepkorToFelhasznaloModositasAblak(role));
    }

    @Test
    public void Uj_felhasznalo_felvetelenek_megszakitasa_Megsem_gombbal() throws IOException {
        UjFelhasznalo ujFelhasznalo = deserializeJson("ujFelhasznalo.json", UjFelhasznalo.class);
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());
        //Szervezet felvétele
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

        //új felhasználó felvételének megszakítása a Mégsem gomb megnyomásával
        sideMenu.
                navigateToFelhasznalokPanel();
        String username = "TestUser" + new FakerUtils().generateRandomNumber();
        String nev = "Teszt Név" + new FakerUtils().generateRandomNumber();
        UsersPage usersPage = new UsersPage(getDriver()).
                clickOnUjFelhasznaloFelveteleBtn().
                enterFelhasznalonev(username).
                enterNev(nev).
                setUjFelhasznalo(ujFelhasznalo).
                clickOnMegseBtn();
    }

    @Test
    public void Szurok_mukodese() throws InterruptedException, IOException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        UjFelhasznalo ujFelhasznalo = deserializeJson("ujFelhasznalo.json", UjFelhasznalo.class);
        SideMenu sideMenu = new SideMenu(getDriver());

        //Szervezet felvétele
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

        //új felhasználó felvétele összes mező kitöltésével
        String username = "TestUser" + new FakerUtils().generateRandomNumber();
        String nev = "Teszt Név" + new FakerUtils().generateRandomNumber();
        String emailFelhasz = "felhaszEmail@gmail.com" + new FakerUtils().generateRandomNumber();
        String szerepkor = "Tulajdonos";
        sideMenu.
                navigateToFelhasznalokPanel();
        UsersPage usersPage = new UsersPage(getDriver())
                .clickOnUjFelhasznaloFelveteleBtn()
                .enterFelhasznalonev(username)
                .enterNev(nev)
                .selectSzervezet(partnerNeve)
                .enterEmail(emailFelhasz)
                .selectSzerepkor(szerepkor)
                .clickOnFelvetelBtn();
        Assert.assertTrue(usersPage.elemMegjelenikATablazatban(nev, "1"));

        //Szűrés
        Szurok szurok = new Szurok(getDriver());
        szurok.
                clickOnSzurokBtn().
                enterNev(nev).
                clickOnKeresesBtn();
        usersPage.
                megjelenoNevAListaban(nev);
        szurok.
                clickOnSzurokTorleseBtn().
                enterEmail(email).
                clickOnKeresesBtn();
        usersPage.
                megjelenoEmailAListaban(emailFelhasz);
        szurok.
                clickOnSzurokTorleseBtn().
                selectSzervezetFromSzervezetDropdDown(partnerNeve).
                clickOnKeresesBtn();
        usersPage.
                megjelenoSzervezetAListaban(partnerNeve);
        szurok.
                clickOnSzurokTorleseBtn().
                selectSzerepkorFromSzerepkorDropdDown(szerepkor).
                clickOnKeresesBtn();
        usersPage.
                megjelenoSzerepkorAListaban(szerepkor);
        szurok.
                clickOnSzurokTorleseBtn().
                enterNev(nev).
                enterEmail(emailFelhasz).
                selectSzervezetFromSzervezetDropdDown(partnerNeve).
                selectSzerepkorFromSzerepkorDropdDown(szerepkor).
                clickOnKeresesBtn();
      usersPage.
              megjelenoNevAListaban(nev).
              megjelenoEmailAListaban(emailFelhasz).
              megjelenoSzervezetAListaban(partnerNeve).
              megjelenoSzerepkorAListaban(szerepkor);
    }

   @Test
    public void Nem_ADs_felhasználó_szerkesztése() throws IOException, InterruptedException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
       UjFelhasznalo ujFelhasznalo = deserializeJson("ujFelhasznalo.json", UjFelhasznalo.class);
       SideMenu sideMenu = new SideMenu(getDriver());

       //Szervezet felvétele
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
       Thread.sleep(2000);
       //Módosított Szervezet felvétele
       sideMenu.
               navigateToPartnerekPanel();
       String partnerNeveMod = "Teszt Partner" + new FakerUtils().generateRandomNumber();
       String telefonszamMod = "06202102121";
       String emailMod = "email@gmail.com";
       partnerekPage.
               clickOnUjPartnerFelveteleBtn().
               enterPartnerNeveFld(partnerNeveMod).
               enterTelefonszFld(telefonszamMod).
               enterEmailFld(emailMod).
               clickOnFelvetelBtn();
       sideMenu.
               navigateToSzervezetekPanel();
       String szervezetAzonMod = "Szervezet" + new FakerUtils().generateRandomNumber();

       szervezetekPage.clickOnUjSzervezetFelveteleBtn();
       szervezetekPage.enterSzervezetAzonositoFld(szervezetAzonMod);
       szervezetekPage.selectKapcsolodoPartnerFromDropDown(partnerNeveMod);
       szervezetekPage.clickOnFelvetelBtn();
       Thread.sleep(2000);
       //Uj felhasználó felvétele
       sideMenu.
               navigateToFelhasznalokPanel();
       String username = "TestUser" + new FakerUtils().generateRandomNumber();
       String nev = "Teszt Név" + new FakerUtils().generateRandomNumber();
       sideMenu.
               navigateToFelhasznalokPanel();
       UsersPage usersPage = new UsersPage(getDriver())
               .clickOnUjFelhasznaloFelveteleBtn()
               .enterFelhasznalonev(username)
               .enterNev(nev)
               .selectSzervezet(partnerNeve)
               .setUjFelhasznalo(ujFelhasznalo)
               .clickOnFelvetelBtn();
       Assert.assertTrue(usersPage.elemMegjelenikATablazatban(nev, "1"));

        //felhasználó szerkesztése
        String nevModositott = "Teszt Módosított";
        String emailModositott = "modositottmail@gmail.com";
        String szerepkorModositott = "Adminisztrátor";
        String ujSzerepkor = "Kezelő";
        usersPage.
                clickOnMuveletekBtn().
                clickOnszerkesztesBtnInMuveletekDropDown(nev).
                nevFldClearAndEnterModositottNevToNevFld(nev, nevModositott).
                emailFldClearAndEnterModositottEmailToEmailFld("email@gmail.com",emailModositott).
                szervezetDropDownClearAndEnterModositottSzervezetToSzervezetFld(partnerNeveMod).
                szerepkorDropDownClearAndEnterModositottSzerepkorToSzerepkorFld(szerepkorModositott).
                addUjSzerepkorToFelhasznaloModositasAblak(ujSzerepkor).
                clickOnMentesBtn();
        getDriver().navigate().refresh();
       Assert.assertTrue(usersPage.elemMegjelenikATablazatban(nevModositott, "1"));
    }


   @Test
    public void Nem_ADs_felhasznalo_eseten_jelszo_modositas_kitoltes_hianyaban() throws IOException {
       DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
       Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
       UjFelhasznalo ujFelhasznalo = deserializeJson("ujFelhasznalo.json", UjFelhasznalo.class);
       SideMenu sideMenu = new SideMenu(getDriver());

       //Szervezet felvétele
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

       //új felhasználó felvétele összes mező kitöltésével
       String username = "TestUser" + new FakerUtils().generateRandomNumber();
       String nev = "Teszt Név" + new FakerUtils().generateRandomNumber();
       sideMenu.
               navigateToFelhasznalokPanel();
       UsersPage usersPage = new UsersPage(getDriver())
               .clickOnUjFelhasznaloFelveteleBtn()
               .enterFelhasznalonev(username)
               .enterNev(nev)
               .selectSzervezet(partnerNeve)
               .setUjFelhasznalo(ujFelhasznalo)
               .clickOnFelvetelBtn();
       Assert.assertTrue(usersPage.elemMegjelenikATablazatban(nev, "1"));

       //Jelszó módosítása
       getDriver().navigate().refresh();
       String jelszo = "Testpassword";
       String jelszoMeger = "Testpassword";
       usersPage.
               clickOnMuveletekBtn().
               clickOnJelszoModositasaBtnMuveletekDropDown(nev);
       Assert.assertFalse(usersPage.mentesBtnJelszoModositasKattinthato());
       usersPage.
               enterUjJelszoFld(jelszo);
       Assert.assertFalse(usersPage.mentesBtnJelszoModositasKattinthato());
       usersPage.
               enterJelszoMegerositesFld(jelszoMeger).
               clickOnmentesBtnJelszoModositas();
       Assert.assertTrue(usersPage.popUpMegjelenik("Sikeres rögzítés!"));
    }

    @Test
    public void Nem_ADs_felhasznalo_eseten_jelszo_modositas_generalassal() throws IOException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        UjFelhasznalo ujFelhasznalo = deserializeJson("ujFelhasznalo.json", UjFelhasznalo.class);
        SideMenu sideMenu = new SideMenu(getDriver());

        //Szervezet felvétele
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

        //új felhasználó felvétele összes mező kitöltésével
        String username = "TestUser" + new FakerUtils().generateRandomNumber();
        String nev = "Teszt Név" + new FakerUtils().generateRandomNumber();
        sideMenu.
                navigateToFelhasznalokPanel();
        UsersPage usersPage = new UsersPage(getDriver())
                .clickOnUjFelhasznaloFelveteleBtn()
                .enterFelhasznalonev(username)
                .enterNev(nev)
                .selectSzervezet(partnerNeve)
                .setUjFelhasznalo(ujFelhasznalo)
                .clickOnFelvetelBtn();
        Assert.assertTrue(usersPage.elemMegjelenikATablazatban(nev, "1"));

        //Jelszó módosítás generálással
        getDriver().navigate().refresh();
        usersPage.
                clickOnMuveletekBtn().
                clickOnJelszoModositasaBtnMuveletekDropDown(nev).
                clickOnjelszoGeneralasCheckbox();
        Assert.assertFalse(usersPage.ujJelszoFldSzerkesztheto());
        Assert.assertFalse(usersPage.jelszoMegerositesFldSzerkesztheto());
        Assert.assertTrue(usersPage.mentesBtnJelszoModositasKattinthato());
        usersPage.
                clickOnmentesBtnJelszoModositas();
        Assert.assertTrue(usersPage.popUpMegjelenik("Sikeres rögzítés"));
    }

    @Test
    public void Nem_ADs_felhasznalo_eseten_jelszo_modositas_megszakitassal() throws IOException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        UjFelhasznalo ujFelhasznalo = deserializeJson("ujFelhasznalo.json", UjFelhasznalo.class);
        SideMenu sideMenu = new SideMenu(getDriver());

        //Szervezet felvétele
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

        //új felhasználó felvétele összes mező kitöltésével
        String username = "TestUser" + new FakerUtils().generateRandomNumber();
        String nev = "Teszt Név" + new FakerUtils().generateRandomNumber();
        sideMenu.
                navigateToFelhasznalokPanel();
        UsersPage usersPage = new UsersPage(getDriver())
                .clickOnUjFelhasznaloFelveteleBtn()
                .enterFelhasznalonev(username)
                .enterNev(nev)
                .selectSzervezet(partnerNeve)
                .setUjFelhasznalo(ujFelhasznalo)
                .clickOnFelvetelBtn();
        Assert.assertTrue(usersPage.elemMegjelenikATablazatban(nev, "1"));

        //Jelszó módosítás megszakítással
        getDriver().navigate().refresh();
        String jelszo = "Testpassword";
        String jelszoMeger = "Testpassword";
        usersPage.
                clickOnMuveletekBtn().
                clickOnJelszoModositasaBtnMuveletekDropDown(nev).
                enterUjJelszoFld(jelszo).
                enterJelszoMegerositesFld(jelszoMeger).
                clickOnMegsemBtnJelszoModositas();
        Assert.assertTrue(usersPage.popUpMegjelenik("Sikeres rögzítés"));
    }

    @Test
    public void Nem_ADs_felhasználó_eseten_jelszo_modositasa_uj_jelszo_megadasaval() throws IOException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        UjFelhasznalo ujFelhasznalo = deserializeJson("ujFelhasznalo.json", UjFelhasznalo.class);
        SideMenu sideMenu = new SideMenu(getDriver());

        //Szervezet felvétele
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

        //új felhasználó felvétele összes mező kitöltésével
        String username = "TestUser" + new FakerUtils().generateRandomNumber();
        String nev = "Teszt Név" + new FakerUtils().generateRandomNumber();
        sideMenu.
                navigateToFelhasznalokPanel();
        UsersPage usersPage = new UsersPage(getDriver())
                .clickOnUjFelhasznaloFelveteleBtn()
                .enterFelhasznalonev(username)
                .enterNev(nev)
                .selectSzervezet(partnerNeve)
                .setUjFelhasznalo(ujFelhasznalo)
                .clickOnFelvetelBtn();
        Assert.assertTrue(usersPage.elemMegjelenikATablazatban(nev, "1"));

        //jelszó módosítása új jelszó megadásával
        getDriver().navigate().refresh();
        String jelszo = "Testpassword";
        String jelszoMeger = "Testpassword";
        usersPage.
                clickOnMuveletekBtn().
                clickOnJelszoModositasaBtnMuveletekDropDown(nev);
        Assert.assertFalse(usersPage.mentesBtnJelszoModositasKattinthato());
        usersPage.enterUjJelszoFld(jelszo);
        Assert.assertFalse(usersPage.mentesBtnJelszoModositasKattinthato());
        usersPage.enterJelszoMegerositesFld(jelszoMeger);
        Assert.assertTrue(usersPage.mentesBtnJelszoModositasKattinthato());
        usersPage.clickOnMentesBtn();
        Assert.assertTrue(usersPage.popUpMegjelenik("Sikeres rögzítés"));
    }

    @Test
    public void Nem_ADs_felhasznalo_inaktivalasa() throws IOException, InterruptedException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        UjFelhasznalo ujFelhasznalo = deserializeJson("ujFelhasznalo.json", UjFelhasznalo.class);
        SideMenu sideMenu = new SideMenu(getDriver());

        //Szervezet felvétele
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

        //új felhasználó felvétele összes mező kitöltésével
        String username = "TestUser" + new FakerUtils().generateRandomNumber();
        String nev = "Teszt Név" + new FakerUtils().generateRandomNumber();
        sideMenu.
                navigateToFelhasznalokPanel();
        UsersPage usersPage = new UsersPage(getDriver())
                .clickOnUjFelhasznaloFelveteleBtn()
                .enterFelhasznalonev(username)
                .enterNev(nev)
                .selectSzervezet(partnerNeve)
                .setUjFelhasznalo(ujFelhasznalo)
                .clickOnFelvetelBtn();
        Assert.assertTrue(usersPage.elemMegjelenikATablazatban(nev, "1"));

        //Felhasználó inaktiválása
        usersPage.
                clickOnMuveletekBtn().
                clickOnInaktivalasBtnInMuveletekDropDown(nev).
                clickOnOkMegerBtn();
        Assert.assertTrue(usersPage.popUpMegjelenik("Sikeres inaktiválás!"));
    }

}
