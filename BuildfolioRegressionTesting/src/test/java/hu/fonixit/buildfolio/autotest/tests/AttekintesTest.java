package hu.fonixit.buildfolio.autotest.tests;

import hu.fonixit.buildfolio.autotest.base.BaseTest;
import hu.fonixit.buildfolio.autotest.objects.ADUser;
import hu.fonixit.buildfolio.autotest.pages.DashboardPage;
import hu.fonixit.buildfolio.autotest.pages.LoginPage;
import hu.fonixit.buildfolio.autotest.pages.components.SideMenu;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttekintesTest extends BaseTest {

    @Test
    public void Attekintes_TULAJDONOS_szerepkorrel_design(){
        ADUser user = new ADUser().
                setADUsername("takarekingatlanuser1").
                setPassword("Testing123");
        DashboardPage dashboardPage = new LoginPage(getDriver()).
                load().
                enterTextInUsernameFld(user.getADUsername()).
                enterTextInPasswordFld(user.getPassword()).
                belepes();
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToAttekintesPanel();
        DashboardPage attekintesPage = new DashboardPage(getDriver());
        Assert.assertEquals(attekintesPage.szerepkorEllenorzes(), "Tulajdonos");
        attekintesPage.
                ingatlanPortfolioPanelMegjelenik().
                ingatlanErtekePanelMegjelenik().
                szamlakPanelMegjelenik().
                legutobbErtekesitettIngatlanokPanelMegjelenik().
                szerzodesekPanelMegjelenik();

    }

    @Test
    public void Attekintes_tulajdonos_szerepkorrel_Ingatlan_Portfolio_panel(){
        ADUser user = new ADUser().
                setADUsername("takarekingatlanuser1").
                setPassword("Testing123");
        DashboardPage dashboardPage = new LoginPage(getDriver()).
                load().
                enterTextInUsernameFld(user.getADUsername()).
                enterTextInPasswordFld(user.getPassword()).
                belepes();
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToAttekintesPanel();
        DashboardPage dashboardPage1 = new DashboardPage(getDriver());
        Assert.assertEquals(dashboardPage1.szerepkorEllenorzes(), "Tulajdonos");
        dashboardPage1.
                osszesIngatlanDobozMegjelenik().   
                berbeadottDobozMegjelenik().
                bereltDobozMegjelenik().
                kiadatlanDobozMegjelenik().
                sajatHasznalatbanDobozMegjelenik().
                hasznositatlanDobozMegjelenik();
    }
}
