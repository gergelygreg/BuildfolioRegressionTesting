package hu.fonixit.buildfolio.autotest.tests;


import hu.fonixit.buildfolio.autotest.base.BaseTest;
import hu.fonixit.buildfolio.autotest.objects.ADUser;
import hu.fonixit.buildfolio.autotest.objects.UjFelhasznalo;
import hu.fonixit.buildfolio.autotest.pages.DashboardPage;
import hu.fonixit.buildfolio.autotest.pages.LoginPage;
import hu.fonixit.buildfolio.autotest.pages.UsersPage;
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

       // DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());

        //Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToFelhasznalokPanel();
        String username = "TestUser" + new FakerUtils().generateRandomNumber();
        UsersPage usersPage = new UsersPage(getDriver())
                .clickOnUjFelhasznaloFelveteleBtn()
                .enterFelhasznalonev(username)
                .setUjFelhasznalo(ujFelhasznalo)
                .clickOnFelvetelBtn();

    }

    @Test
    public void Uj_felhasznalo_felvetele_uresen_hagyott_mezokkel() throws IOException {
        UjFelhasznalo ujFelhasznalo = deserializeJson("ujFelhasznalo.json", UjFelhasznalo.class);
       // DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
       // Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToFelhasznalokPanel();
        String username = "TestUser" + new FakerUtils().generateRandomNumber();
        String name = "Teszt Elek";
        String email = "ujemail@gmail.com";
        UsersPage usersPage = new UsersPage(getDriver()).
                clickOnUjFelhasznaloFelveteleBtn().
                enterFelhasznalonev(username).
                enterNev(name).
                enterEmail(email).
                felvetelBtnDisabled();

    }

    @Test
    public void Uj_felhasznalo_felvetele_tobb_szerepkorrel() throws IOException {
        UjFelhasznalo ujFelhasznalo = deserializeJson("ujFelhasznalo.json", UjFelhasznalo.class);
     //   DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
     //   Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToFelhasznalokPanel();
        String username = "TestUser" + new FakerUtils().generateRandomNumber();
        String role1 = "Bérlő";
        String role2 = "Igénykezelő";
        UsersPage usersPage = new UsersPage(getDriver()).
                clickOnUjFelhasznaloFelveteleBtn().
                enterFelhasznalonev(username).
                setUjFelhasznalo(ujFelhasznalo).
                selectPlusSzerepkor(role1).
                selectPlusSzerepkor(role2).
                clickOnFelvetelBtn();
    }

    @Test
    public void Uj_felhasznalo_felvetele_az_osszes_szerepkorrel() throws IOException {
        UjFelhasznalo ujFelhasznalo = deserializeJson("ujFelhasznalo.json", UjFelhasznalo.class);
        //DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        //Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToFelhasznalokPanel();
        String username = "TestUser" + new FakerUtils().generateRandomNumber();
        String role1 = "Bérlő";
        String role2 = "Igénykezelő";
        String role3 = "Adminisztrátor";
        String role4 = "Kezelő";
        String role5 = "Üzemeltető";
        UsersPage usersPage = new UsersPage(getDriver()).
                clickOnUjFelhasznaloFelveteleBtn().
                enterFelhasznalonev(username).
                setUjFelhasznalo(ujFelhasznalo).
                selectPlusSzerepkor(role1).
                selectPlusSzerepkor(role2).
                selectPlusSzerepkor(role3).
                selectPlusSzerepkor(role4).
                selectPlusSzerepkor(role5).
                clickOnFelvetelBtn();
    }

    @Test
    public void Uj_felhasznalo_felvetele_tobb_azonos_szerepkorrel() throws IOException {
        UjFelhasznalo ujFelhasznalo = deserializeJson("ujFelhasznalo.json", UjFelhasznalo.class);
       // DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
       // Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToFelhasznalokPanel();
        String username = "TestUser" + new FakerUtils().generateRandomNumber();
        String role = "Tulajdonos";
        UsersPage usersPage = new UsersPage(getDriver()).
                clickOnUjFelhasznaloFelveteleBtn().
                enterFelhasznalonev(username).
                setUjFelhasznalo(ujFelhasznalo).
                selectPlusSzerepkor(role).
                clickOnFelvetelBtn();
    }

    @Test
    public void Uj_felhasznalo_felvetelenek_megszakitasa_Megsem_gombbal() throws IOException {
        UjFelhasznalo ujFelhasznalo = deserializeJson("ujFelhasznalo.json", UjFelhasznalo.class);
       // DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
       // Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToFelhasznalokPanel();
        String username = "TestUser" + new FakerUtils().generateRandomNumber();
        UsersPage usersPage = new UsersPage(getDriver()).
                clickOnUjFelhasznaloFelveteleBtn().
                enterFelhasznalonev(username).
                setUjFelhasznalo(ujFelhasznalo).
                clickOnMegseBtn();
    }

    @Test
    public void Szurok_mukodese() throws InterruptedException {
       //DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        //Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToFelhasznalokPanel();
        String nev = "Teszt Név";
        String email = "email@gmail.com";
        String szervezet = "Minta Zrt.";
        String szerepkor = "Tulajdonos";
        Szurok szurok = new Szurok(getDriver()).
                clickOnSzurokBtn().
                enterNev(nev).
                clickOnKeresesBtn();
        UsersPage usersPage = new UsersPage(getDriver()).
                megjelenoNevAListaban(nev);
        szurok.
                clickOnSzurokTorleseBtn().
                enterEmail(email).
                clickOnKeresesBtn();
        usersPage.
                megjelenoEmailAListaban(email);
        szurok.
                clickOnSzurokTorleseBtn().
                selectSzervezetFromSzervezetDropdDown(szervezet).
                clickOnKeresesBtn();
        usersPage.
                megjelenoSzervezetAListaban(szervezet);
        szurok.
                clickOnSzurokTorleseBtn().
                selectSzerepkorFromSzerepkorDropdDown(szerepkor).
                clickOnKeresesBtn();
        usersPage.
                megjelenoSzerepkorAListaban(szerepkor);
        szurok.
                clickOnSzurokTorleseBtn().
                enterNev(nev).
                enterEmail(email).
                selectSzervezetFromSzervezetDropdDown(szervezet).
                selectSzerepkorFromSzerepkorDropdDown(szerepkor).
                clickOnKeresesBtn();
      usersPage.
              megjelenoNevAListaban(nev).
              megjelenoEmailAListaban(email).
              megjelenoSzervezetAListaban(szervezet).
              megjelenoSzerepkorAListaban(szerepkor);
    }

   @Test
    public void Nem_ADs_felhasználó_szerkesztése() {
       // DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
       ADUser user = new ADUser().
               setADUsername("takarekingatlanuser1").
               setPassword("Testing123");
       DashboardPage dashboardPage = new LoginPage(getDriver()).
               load().
               enterTextInUsernameFld(user.getADUsername()).
               enterTextInPasswordFld(user.getPassword()).
               belepes();
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToFelhasznalokPanel();
        String nev = "Teszt Elek";
        String email = "testemail@gmail.com";
        String szervezet = "Teszt Partner";
        String szerepkor1 = "Adminisztrátor";
        String szerepkor2 = "Kezelő";
        UsersPage usersPage = new UsersPage(getDriver()).
                clickOnMuveletekButton().
                clickOnszerkesztesBtnInMuveletekDropDown().
                nevFldClearAndenterModositottNevToNevFld(nev).
                emailFldClearAndEnterModositottEmailToEmailFld(email).
                szervezetDropDownClearAndEnterModositottSzervezetToSzervezetFld(szervezet).
                szerepkorDropDownClearAndEnterModositottSzerepkorToSzerepkorFld(szerepkor1).
                addUjSzerepkorToFelhasznaloModositasAblak(szerepkor2).
                clickOnMentesBtn();



    }


   @Test
    public void Nem_ADs_felhasznalo_eseten_jelszo_modositas_kitoltes_hianyaban(){
      // DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
       ADUser user = new ADUser().
               setADUsername("takarekingatlanuser1").
               setPassword("Testing123");
       DashboardPage dashboardPage = new LoginPage(getDriver()).
               load().
               enterTextInUsernameFld(user.getADUsername()).
               enterTextInPasswordFld(user.getPassword()).
               belepes();
       Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
       SideMenu sideMenu = new SideMenu(getDriver()).navigateToFelhasznalokPanel();
       String jelszo = "Testpassword";
       String jelszoMeger = "Testpassword";
       UsersPage usersPage = new UsersPage(getDriver()).
               clickOnMuveletekButton().
               clickOnJelszoModositasaBtnMuveletekDropDown();
       Assert.assertFalse(usersPage.mentesBtnJelszoModositasKattinthato());
       usersPage.
               enterUjJelszoFld(jelszo).
               enterJelszoMegerositesFld(jelszoMeger).
               clickOnmentesBtnJelszoModositas();
    }

    @Test
    public void Nem_ADs_felhasznalo_eseten_jelszo_modositas_generalassal(){
        ADUser user = new ADUser().
                setADUsername("takarekingatlanuser1").
                setPassword("Testing123");
        DashboardPage dashboardPage = new LoginPage(getDriver()).
                load().
                enterTextInUsernameFld(user.getADUsername()).
                enterTextInPasswordFld(user.getPassword()).
                belepes();
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToFelhasznalokPanel();
        UsersPage usersPage = new UsersPage(getDriver()).
                clickOnMuveletekButton().
                clickOnJelszoModositasaBtnMuveletekDropDown();
        Assert.assertFalse(usersPage.mentesBtnJelszoModositasKattinthato());
        usersPage.
                clickOnjelszoGeneralasCheckbox();
        Assert.assertFalse(usersPage.ujJelszoFldSzerkesztheto());
        Assert.assertFalse(usersPage.jelszoMegerositesFldSzerkesztheto());
        Assert.assertTrue(usersPage.mentesBtnJelszoModositasKattinthato());
        usersPage.clickOnmentesBtnJelszoModositas();
    }

    @Test
    public void Nem_ADs_felhasznalo_eseten_jelszo_modositas_megszakitassal(){
        ADUser user = new ADUser().
                setADUsername("takarekingatlanuser1").
                setPassword("Testing123");
        DashboardPage dashboardPage = new LoginPage(getDriver()).
                load().
                enterTextInUsernameFld(user.getADUsername()).
                enterTextInPasswordFld(user.getPassword()).
                belepes();
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToFelhasznalokPanel();
        UsersPage usersPage = new UsersPage(getDriver()).
                clickOnMuveletekButton().
                clickOnJelszoModositasaBtnMuveletekDropDown();
        Assert.assertFalse(usersPage.mentesBtnJelszoModositasKattinthato());
        Assert.assertTrue(usersPage.megsemBtnJelszoModositasKattinthato());
        String jelszo = "Testpassword";
        String jelszoMeger = "Testpassword";
        usersPage.
                enterUjJelszoFld(jelszo).
                enterJelszoMegerositesFld(jelszoMeger).
                clickOnMegsemBtnJelszoModositas();
    }

    @Test
    public void Nem_ADs_felhasználó_eseten_jelszo_modositasa_uj_jelszo_megadasaval() {
        ADUser user = new ADUser().
                setADUsername("takarekingatlanuser1").
                setPassword("Testing123");
        DashboardPage dashboardPage = new LoginPage(getDriver()).
                load().
                enterTextInUsernameFld(user.getADUsername()).
                enterTextInPasswordFld(user.getPassword()).
                belepes();
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToFelhasznalokPanel();
        String jelszo = "Testpassword";
        String jelszoMeger = "Testpassword";
        UsersPage usersPage = new UsersPage(getDriver()).
                clickOnMuveletekButton().
                clickOnJelszoModositasaBtnMuveletekDropDown();
        Assert.assertFalse(usersPage.mentesBtnJelszoModositasKattinthato());
        usersPage.enterUjJelszoFld(jelszo);
        Assert.assertFalse(usersPage.mentesBtnJelszoModositasKattinthato());
        usersPage.enterJelszoMegerositesFld(jelszoMeger);
        Assert.assertTrue(usersPage.mentesBtnJelszoModositasKattinthato());
        usersPage.clickOnMentesBtn();
    }

    @Test
    public void Nem_ADs_felhasznalo_inaktivalasa(){
        ADUser user = new ADUser().
                setADUsername("takarekingatlanuser1").
                setPassword("Testing123");
        DashboardPage dashboardPage = new LoginPage(getDriver()).
                load().
                enterTextInUsernameFld(user.getADUsername()).
                enterTextInPasswordFld(user.getPassword()).
                belepes();
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToFelhasznalokPanel();
        UsersPage usersPage = new UsersPage(getDriver()).
                clickOnMuveletekButton().
                felhasznaloInaktivalasa().
                inaktivUser();
    }

}
