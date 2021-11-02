package hu.fonixit.buildfolio.autotest.tests;


import com.github.javafaker.Faker;
import hu.fonixit.buildfolio.autotest.base.BaseTest;
import hu.fonixit.buildfolio.autotest.objects.ADUser;
import hu.fonixit.buildfolio.autotest.objects.UjFelhasznalo;
import hu.fonixit.buildfolio.autotest.pages.DashboardPage;
import hu.fonixit.buildfolio.autotest.pages.LoginPage;
import hu.fonixit.buildfolio.autotest.pages.UsersPage;
import hu.fonixit.buildfolio.autotest.pages.components.SideMenu;
import hu.fonixit.buildfolio.autotest.pages.components.Szurok;
import hu.fonixit.buildfolio.autotest.utils.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static hu.fonixit.buildfolio.autotest.utils.JacksonUtils.deserializeJson;

public class FelhasználókTest extends BaseTest {


    @Test
    public void Uj_felhasznalo_felvetele_az_osszes_mezo_kitoltesevel() throws IOException {
        UjFelhasznalo ujFelhasznalo = deserializeJson("ujFelhasznalo.json", UjFelhasznalo.class);
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
        String username = "TestUser" + new FakerUtils().generateRandomNumber();
        UsersPage usersPage = new UsersPage(getDriver()).
                clickOnUjFelhasznaloFelveteleBtn().
                enterFelhasznalonev(username).
                setUjFelhasznalo(ujFelhasznalo).
                clickOnMegseBtn();
    }

}
