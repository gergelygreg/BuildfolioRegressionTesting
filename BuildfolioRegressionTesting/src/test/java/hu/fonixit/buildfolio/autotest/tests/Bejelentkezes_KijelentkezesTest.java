package hu.fonixit.buildfolio.autotest.tests;

import hu.fonixit.buildfolio.autotest.base.BaseTest;
import hu.fonixit.buildfolio.autotest.objects.ADUser;
import hu.fonixit.buildfolio.autotest.pages.DashboardPage;
import hu.fonixit.buildfolio.autotest.pages.LoginPage;
import hu.fonixit.buildfolio.autotest.pages.components.Navbar;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Bejelentkezes_KijelentkezesTest extends BaseTest {

    @Test
    public void Bejelentkzesi_kepernyo_elerese() {
        LoginPage loginPage = new LoginPage(getDriver()).load();
        Assert.assertEquals(loginPage.headerSuccessNotice(), "Létesítménygazdálkodási rendszer");
    }

    @Test
    public void Sikeres_bejelentkezes_ADs_userrel (){
        ADUser user = new ADUser().
                setADUsername("takarekingatlanuser1").
                setPassword("Testing123");
        DashboardPage dashboardPage = new LoginPage(getDriver()).
                load().
                enterTextInUsernameFld(user.getADUsername()).
                enterTextInPasswordFld(user.getPassword()).
                belepes();
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");

    }

    @Test
    public void Sikeres_kijelentkezes(){
        ADUser user = new ADUser().
                setADUsername("takarekingatlanuser1").
                setPassword("Testing123");
        DashboardPage dashboardPage = new LoginPage(getDriver()).
                load().
                enterTextInUsernameFld(user.getADUsername()).
                enterTextInPasswordFld(user.getPassword()).
                belepes();
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        Navbar navbar = new Navbar(getDriver()).exitApplicationUsingUsername();
    }

    @Test
    public void Sikertelen_bejelentkezes_hibas_jelszoval(){
        ADUser user = new ADUser().
                setADUsername("takarekingatlanuser1").
                setPassword("asdasd");
        DashboardPage dashboardPage = new LoginPage(getDriver()).
                load().
                enterTextInUsernameFld(user.getADUsername()).
                enterTextInPasswordFld(user.getPassword()).
                belepes();
        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertEquals(loginPage.errorMessageText(), "A művelet végrehajtása sikertelen.");
        loginPage.clickOnErrorMessageOkBtn();
        Assert.assertEquals(loginPage.alertMessageText(), "Hibás adatok!");
    }

    @Test
    public void Sikertelen_bejelentkezes_hibas_felhasznalonevvel(){
        ADUser user = new ADUser().
                setADUsername("asdasd").
                setPassword("Testing123");
        DashboardPage dashboardPage = new LoginPage(getDriver()).
                load().
                enterTextInUsernameFld(user.getADUsername()).
                enterTextInPasswordFld(user.getPassword()).
                belepes();
        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertEquals(loginPage.errorMessageText(), "A művelet végrehajtása sikertelen.");
        loginPage.clickOnErrorMessageOkBtn();
        Assert.assertEquals(loginPage.alertMessageText(), "Hibás adatok!");
    }

   // @Test



    /*
    @Test
    public void Sikeres_belepes_email_cimes_felhasznaloval_OTP(){
    }
     */
}
