package hu.fonixit.buildfolio.autotest.tests;


import hu.fonixit.buildfolio.autotest.base.BaseTest;
import hu.fonixit.buildfolio.autotest.objects.ADUser;
import hu.fonixit.buildfolio.autotest.pages.DashboardPage;
import hu.fonixit.buildfolio.autotest.pages.LoginPage;
import hu.fonixit.buildfolio.autotest.pages.SzamlakPage;
import hu.fonixit.buildfolio.autotest.pages.SzerzodesekPage;
import hu.fonixit.buildfolio.autotest.pages.components.SideMenu;
import hu.fonixit.buildfolio.autotest.utils.UserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttekintesTest extends BaseTest {

    @Test
    public void Attekintes_TULAJDONOS_szerepkorrel_design(){
       // DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
       // Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
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
      //  DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
      //  Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
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

    @Test
    public void Attekintes_tulajdonos_szerepkorrel_INGATLAN_PORTFOLIO_panel_riport(){
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
        dashboardPage1.clickOningatlanPortfolioRiportBtn();
        Assert.assertFalse(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.pdfFajlformRiportKivalasztasa();   //PDF riport
        Assert.assertTrue(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.clickOnFuttatasBtn();
        dashboardPage1.clickOnRiportLetolteseBtn();

        dashboardPage1.clickOningatlanPortfolioRiportBtn();
        Assert.assertFalse(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.excelFajlformRiportKivalasztasa();   //Excel riport
        Assert.assertTrue(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.clickOnFuttatasBtn();
        dashboardPage1.clickOnRiportLetolteseBtn();

    }

    @Test
    public void Attekintes_tulajdonos_szerepkorrel_INGATLANOK_ERTEKE_panel_riport(){
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
        dashboardPage1.clickOnIngatlanokErtekeRiportBtn();
        Assert.assertFalse(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.pdfFajlformRiportKivalasztasa();   //PDF riport
        Assert.assertTrue(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.clickOnFuttatasBtn();
        dashboardPage1.clickOnRiportLetolteseBtn();

        dashboardPage1.clickOnIngatlanokErtekeRiportBtn();
        Assert.assertFalse(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.excelFajlformRiportKivalasztasa();   //Excel riport
        Assert.assertTrue(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.clickOnFuttatasBtn();
        dashboardPage1.clickOnRiportLetolteseBtn();
    }

    @Test
    public void Attektintes_tulajdonos_szerepkorrel_SZAMLAK_panel_riport_tovabb_gomb(){
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
        dashboardPage1.clickOnSzamlakRiportBtn();
        Assert.assertFalse(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.pdfFajlformRiportKivalasztasa();   //PDF riport
        Assert.assertTrue(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.clickOnFuttatasBtn();
        dashboardPage1.clickOnRiportLetolteseBtn();

        dashboardPage1.clickOnSzamlakRiportBtn();
        Assert.assertFalse(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.excelFajlformRiportKivalasztasa();   //Excel riport
        Assert.assertTrue(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.clickOnFuttatasBtn();
        dashboardPage1.clickOnRiportLetolteseBtn();

        dashboardPage1.clickOnTovabbSzamlakBtn();
        SzamlakPage szamlakPage = new SzamlakPage(getDriver());
        Assert.assertTrue(szamlakPage.ujSzamlaFelveteleBtnKattinthato());

    }

    @Test
    public void Attekintes_tulajdonos_szerepkorrel_SZERZODESEK_panel_riport_tovabb_gomb() throws InterruptedException {
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
        dashboardPage1.clickOnSzerzodesekRiportBtn();
        Assert.assertFalse(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.pdfFajlformRiportKivalasztasa();   //PDF riport
        Assert.assertTrue(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.clickOnFuttatasBtn();
        dashboardPage1.clickOnRiportLetolteseBtn();
        Thread.sleep(5000);
        dashboardPage1.clickOnSzerzodesekRiportBtn();
        Assert.assertFalse(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.excelFajlformRiportKivalasztasa();   //Excel riport
        Assert.assertTrue(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.clickOnFuttatasBtn();
        dashboardPage1.clickOnRiportLetolteseBtn();
        //Thread.sleep(5000);
        dashboardPage1.clickOnTovabbSzerzodesekBtn();
        SzerzodesekPage szerzodesekPage = new SzerzodesekPage(getDriver());
        Assert.assertTrue(szerzodesekPage.ujSzerzodesFelveteleBtnKattinthato());
    }

    @Test
    public void Attekintes_KEZELŐ_szerepkorrel_megjeleno_panelek()  {
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
        dashboardPage1.selectSzerepkor("Kezelő");
        Assert.assertEquals(dashboardPage1.szerepkorEllenorzes(), "Kezelő");
        dashboardPage1.
                ingatlanPortfolioPanelMegjelenik().
                szerzodesekPanelMegjelenik().
                szamlakPanelMegjelenik().
                legutobbErtekesitettIngatlanokPanelMegjelenik();
    }

    @Test
    public void Attekintes_KEZELO_szerepkorrel_INGATLAN_PORTFOLIO_panel_riport(){
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
        dashboardPage1.selectSzerepkor("Kezelő");
        Assert.assertEquals(dashboardPage1.szerepkorEllenorzes(), "Kezelő");
        dashboardPage1.clickOningatlanPortfolioRiportBtn();
        Assert.assertFalse(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.pdfFajlformRiportKivalasztasa();   //PDF riport
        Assert.assertTrue(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.clickOnFuttatasBtn();
        dashboardPage1.clickOnRiportLetolteseBtn();

        dashboardPage1.clickOningatlanPortfolioRiportBtn();
        Assert.assertFalse(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.excelFajlformRiportKivalasztasa();   //Excel riport
        Assert.assertTrue(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.clickOnFuttatasBtn();
        dashboardPage1.clickOnRiportLetolteseBtn();

    }

    @Test
    public void Attekintes_KEZELO_szerepkorrel_SZERZODESEK_riport_tovabb_gomb() throws InterruptedException {
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
        dashboardPage1.selectSzerepkor("Kezelő");
        Assert.assertEquals(dashboardPage1.szerepkorEllenorzes(), "Kezelő");
        dashboardPage1.clickOnSzerzodesekRiportBtn();
        Assert.assertFalse(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.pdfFajlformRiportKivalasztasa();   //PDF riport
        Assert.assertTrue(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.clickOnFuttatasBtn();
        dashboardPage1.clickOnRiportLetolteseBtn();
        Thread.sleep(5000);
        dashboardPage1.clickOnSzerzodesekRiportBtn();
        Assert.assertFalse(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.excelFajlformRiportKivalasztasa();   //Excel riport
        Assert.assertTrue(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.clickOnFuttatasBtn();
        dashboardPage1.clickOnRiportLetolteseBtn();
        //Thread.sleep(5000);
        dashboardPage1.clickOnTovabbSzerzodesekBtn();
        SzerzodesekPage szerzodesekPage = new SzerzodesekPage(getDriver());
        Assert.assertTrue(szerzodesekPage.ujSzerzodesFelveteleBtnKattinthato());
    }

    @Test
    public void Attekintes_KEZELO_szerepkorrel_SZAMLAK_riport_tovabb_gomb(){
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
        dashboardPage1.selectSzerepkor("Kezelő");
        Assert.assertEquals(dashboardPage1.szerepkorEllenorzes(), "Kezelő");
        dashboardPage1.clickOnSzamlakRiportBtn();
        Assert.assertFalse(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.pdfFajlformRiportKivalasztasa();   //PDF riport
        Assert.assertTrue(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.clickOnFuttatasBtn();
        dashboardPage1.clickOnRiportLetolteseBtn();

        dashboardPage1.clickOnSzamlakRiportBtn();
        Assert.assertFalse(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.excelFajlformRiportKivalasztasa();   //Excel riport
        Assert.assertTrue(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.clickOnFuttatasBtn();
        dashboardPage1.clickOnRiportLetolteseBtn();

        dashboardPage1.clickOnTovabbSzamlakBtn();
        SzamlakPage szamlakPage = new SzamlakPage(getDriver());
        Assert.assertTrue(szamlakPage.ujSzamlaFelveteleBtnKattinthato());
    }

    @Test
    public void Attekintes_UZEMELTETO_szerepkorrel_megjeleno_panelek(){
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
        dashboardPage1.selectSzerepkor("Üzemeltető");
        Assert.assertEquals(dashboardPage1.szerepkorEllenorzes(), "Üzemeltető");
        dashboardPage1.
                ingatlanPortfolioPanelMegjelenik().
                szerzodesekPanelMegjelenik().
                szamlakPanelMegjelenik();
    }

    @Test
    public void Attekintes_UZEMELTETO_szerepkorrel_INGATLAN_PORTFOLIO_panel_riport(){
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
        dashboardPage1.selectSzerepkor("Üzemeltető");
        Assert.assertEquals(dashboardPage1.szerepkorEllenorzes(), "Üzemeltető");
        dashboardPage1.clickOningatlanPortfolioRiportBtn();
        Assert.assertFalse(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.pdfFajlformRiportKivalasztasa();   //PDF riport
        Assert.assertTrue(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.clickOnFuttatasBtn();
        dashboardPage1.clickOnRiportLetolteseBtn();

        dashboardPage1.clickOningatlanPortfolioRiportBtn();
        Assert.assertFalse(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.excelFajlformRiportKivalasztasa();   //Excel riport
        Assert.assertTrue(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.clickOnFuttatasBtn();
        dashboardPage1.clickOnRiportLetolteseBtn();

    }

    @Test
    public void Attekintes_UZEMELTETO_szerepkorrel_SZERZODESEK_riport_tovabb_gomb() throws InterruptedException {
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
        dashboardPage1.selectSzerepkor("Üzemeltető");
        Assert.assertEquals(dashboardPage1.szerepkorEllenorzes(), "Üzemeltető");
        dashboardPage1.clickOnSzerzodesekRiportBtn();
        Assert.assertFalse(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.pdfFajlformRiportKivalasztasa();   //PDF riport
        Assert.assertTrue(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.clickOnFuttatasBtn();
        dashboardPage1.clickOnRiportLetolteseBtn();
        Thread.sleep(5000);
        dashboardPage1.clickOnSzerzodesekRiportBtn();
        Assert.assertFalse(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.excelFajlformRiportKivalasztasa();   //Excel riport
        Assert.assertTrue(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.clickOnFuttatasBtn();
        dashboardPage1.clickOnRiportLetolteseBtn();
        //Thread.sleep(5000);
        dashboardPage1.clickOnTovabbSzerzodesekBtn();
        SzerzodesekPage szerzodesekPage = new SzerzodesekPage(getDriver());
        Assert.assertTrue(szerzodesekPage.ujSzerzodesFelveteleBtnKattinthato());
    }

    @Test
    public void Attekintes_UZEMELTETO_szerepkorrel_SZAMLAK_riport_tovabb_gomb(){
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
        dashboardPage1.selectSzerepkor("Üzemeltető");
        Assert.assertEquals(dashboardPage1.szerepkorEllenorzes(), "Üzemeltető");
        dashboardPage1.clickOnSzamlakRiportBtn();
        Assert.assertFalse(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.pdfFajlformRiportKivalasztasa();   //PDF riport
        Assert.assertTrue(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.clickOnFuttatasBtn();
        dashboardPage1.clickOnRiportLetolteseBtn();

        dashboardPage1.clickOnSzamlakRiportBtn();
        Assert.assertFalse(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.excelFajlformRiportKivalasztasa();   //Excel riport
        Assert.assertTrue(dashboardPage1.futtatasBtnKattinthato());
        dashboardPage1.clickOnFuttatasBtn();
        dashboardPage1.clickOnRiportLetolteseBtn();

        dashboardPage1.clickOnTovabbSzamlakBtn();
        SzamlakPage szamlakPage = new SzamlakPage(getDriver());
        Assert.assertTrue(szamlakPage.ujSzamlaFelveteleBtnKattinthato());
    }
}
