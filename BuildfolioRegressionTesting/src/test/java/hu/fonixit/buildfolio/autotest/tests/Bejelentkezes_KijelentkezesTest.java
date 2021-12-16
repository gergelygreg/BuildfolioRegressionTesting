package hu.fonixit.buildfolio.autotest.tests;

import hu.fonixit.buildfolio.autotest.base.BaseTest;
import hu.fonixit.buildfolio.autotest.objects.ADUser;
import hu.fonixit.buildfolio.autotest.pages.DashboardPage;
import hu.fonixit.buildfolio.autotest.pages.LoginPage;
import hu.fonixit.buildfolio.autotest.pages.components.Navbar;
import hu.fonixit.buildfolio.autotest.utils.UserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Bejelentkezes_KijelentkezesTest extends BaseTest {

    @Test
    public void Bejelentkzesi_kepernyo_elerese() {
        LoginPage loginPage = new LoginPage(getDriver()).load();
        Assert.assertEquals(loginPage.headerLetGazdRendSzoveg(), "Létesítménygazdálkodási rendszer");
    }

    @Test
    public void Sikeres_bejelentkezes_ADs_userrel (){
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");

    }

    @Test
    public void Sikeres_kijelentkezes(){
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
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
