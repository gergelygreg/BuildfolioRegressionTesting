package hu.fonixit.buildfolio.autotest.tests;

import hu.fonixit.buildfolio.autotest.base.BaseTest;
import hu.fonixit.buildfolio.autotest.pages.DashboardPage;
import hu.fonixit.buildfolio.autotest.pages.IngatlanokPage;
import hu.fonixit.buildfolio.autotest.pages.LoginPage;
import hu.fonixit.buildfolio.autotest.pages.components.Lapozo;
import hu.fonixit.buildfolio.autotest.pages.components.SideMenu;
import hu.fonixit.buildfolio.autotest.utils.UserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LapozoTest extends BaseTest {

    @Test
    public void lapozo_teszt_ingatlanok() throws InterruptedException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).
                navigateToIngatlanokPanel();
        Thread.sleep(500);
        Lapozo lapozo = new Lapozo(getDriver()).
                megjelenoElemekSzamaATablazatban();
    }

    @Test
    public void lapozo_teszt_parkolok() throws InterruptedException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).
                navigateToParkolokPanel();
        Thread.sleep(500);
        Lapozo lapozo = new Lapozo(getDriver()).
                megjelenoElemekSzamaATablazatban();
    }

    @Test
    public void lapozo_teszt_partnerek() throws InterruptedException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).
                navigateToPartnerekPanel();
        Thread.sleep(500);
        Lapozo lapozo = new Lapozo(getDriver()).
                megjelenoElemekSzamaATablazatban();
    }

    @Test
    public void lapozo_teszt_feladatkezelo() throws InterruptedException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).
                navigateToFeladatkezeloPanel();
        Thread.sleep(3000);
        Lapozo lapozo = new Lapozo(getDriver()).
                megjelenoElemekSzamaATablazatban();
    }

    @Test
    public void lapozo_teszt_szerzodesek() throws InterruptedException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).
                navigateToSzerzodesekPanel();
        Thread.sleep(500);
        Lapozo lapozo = new Lapozo(getDriver()).
                megjelenoElemekSzamaATablazatban();
    }

    @Test
    public void lapozo_teszt_szamlak() throws InterruptedException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).
                navigateToSzamlakPanel();
        Thread.sleep(500);
        Lapozo lapozo = new Lapozo(getDriver()).
                megjelenoElemekSzamaATablazatban();
    }

    @Test
    public void lapozo_teszt_eszkozok() throws InterruptedException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).
                navigateToEszkozokPanel();
        Thread.sleep(500);
        Lapozo lapozo = new Lapozo(getDriver()).
                megjelenoElemekSzamaATablazatban();
    }

    @Test
    public void lapozo_teszt_igenyek() throws InterruptedException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).
                navigateToIgenyekPanel();
        Thread.sleep(500);
        Lapozo lapozo = new Lapozo(getDriver()).
                megjelenoElemekSzamaATablazatban();
    }

    @Test
    public void lapozo_teszt_felhasznalok() throws InterruptedException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).
                navigateToFelhasznalokPanel();
        Thread.sleep(500);
        Lapozo lapozo = new Lapozo(getDriver()).
                megjelenoElemekSzamaATablazatban();
    }

    @Test
    public void lapozo_teszt_szervezetek() throws InterruptedException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).
                navigateToSzervezetekPanel();
        Thread.sleep(500);
        Lapozo lapozo = new Lapozo(getDriver()).
                megjelenoElemekSzamaATablazatban();
    }

}
