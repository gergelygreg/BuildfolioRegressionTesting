package hu.fonixit.buildfolio.autotest.tests;

import hu.fonixit.buildfolio.autotest.base.BaseTest;
import hu.fonixit.buildfolio.autotest.pages.DashboardPage;
import hu.fonixit.buildfolio.autotest.pages.FeladatkezeloMunkafolyamatokPage;
import hu.fonixit.buildfolio.autotest.pages.FeladatkezeloUjMunkafolyamatInditasaPage;
import hu.fonixit.buildfolio.autotest.pages.LoginPage;
import hu.fonixit.buildfolio.autotest.pages.components.FeladatkezeloPageTabs;
import hu.fonixit.buildfolio.autotest.pages.components.SideMenu;
import hu.fonixit.buildfolio.autotest.utils.UserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FeladatkezeloFeladatTest extends BaseTest {

    @Test
    public void Munkafolyamat_inditasa_berbeadas() throws InterruptedException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());
        sideMenu.
                navigateToFeladatkezeloPanel();
        FeladatkezeloPageTabs feladatkezeloPageTabs = new FeladatkezeloPageTabs(getDriver());
        feladatkezeloPageTabs.
                clickOnMunkafolyamatokTab();
        FeladatkezeloMunkafolyamatokPage feladatkezeloMunkafolyamatokPage = new FeladatkezeloMunkafolyamatokPage(getDriver());
        feladatkezeloMunkafolyamatokPage.
                clickOnUjMunkafolyamatInditasaBtn();

        FeladatkezeloUjMunkafolyamatInditasaPage feladatkezeloUjMunkafolyamatInditasaPage = new FeladatkezeloUjMunkafolyamatInditasaPage(getDriver());
        feladatkezeloUjMunkafolyamatInditasaPage.
                ingatlanKivalasztasa().
                scrollUp();
        feladatkezeloUjMunkafolyamatInditasaPage.
                clickOnFolyamatInditasaBtn();
    }

    @Test
    public void Munkafolyamat_inditasa_berbevetel() throws InterruptedException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());
        sideMenu.
                navigateToFeladatkezeloPanel();
        FeladatkezeloPageTabs feladatkezeloPageTabs = new FeladatkezeloPageTabs(getDriver());
        feladatkezeloPageTabs.
                clickOnMunkafolyamatokTab();
        FeladatkezeloMunkafolyamatokPage feladatkezeloMunkafolyamatokPage = new FeladatkezeloMunkafolyamatokPage(getDriver());
        feladatkezeloMunkafolyamatokPage.
                clickOnUjMunkafolyamatInditasaBtn();

        FeladatkezeloUjMunkafolyamatInditasaPage feladatkezeloUjMunkafolyamatInditasaPage = new FeladatkezeloUjMunkafolyamatInditasaPage(getDriver());
        feladatkezeloUjMunkafolyamatInditasaPage.
                ingatlanKivalasztasa().
                scrollUp().
                clickOnBerbevetelChbox();
        feladatkezeloUjMunkafolyamatInditasaPage.
                clickOnFolyamatInditasaBtn();
    }

    @Test
    public void Munkafolyamat_inditasa_eladas() throws InterruptedException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());
        sideMenu.
                navigateToFeladatkezeloPanel();
        FeladatkezeloPageTabs feladatkezeloPageTabs = new FeladatkezeloPageTabs(getDriver());
        feladatkezeloPageTabs.
                clickOnMunkafolyamatokTab();
        FeladatkezeloMunkafolyamatokPage feladatkezeloMunkafolyamatokPage = new FeladatkezeloMunkafolyamatokPage(getDriver());
        feladatkezeloMunkafolyamatokPage.
                clickOnUjMunkafolyamatInditasaBtn();

        FeladatkezeloUjMunkafolyamatInditasaPage feladatkezeloUjMunkafolyamatInditasaPage = new FeladatkezeloUjMunkafolyamatInditasaPage(getDriver());
        feladatkezeloUjMunkafolyamatInditasaPage.
                ingatlanKivalasztasa().
                scrollUp().
                clickOnEladasChbox();
        feladatkezeloUjMunkafolyamatInditasaPage.
                clickOnFolyamatInditasaBtn();
    }

    @Test
    public void Munkafolyamat_inditasa_vetel() throws InterruptedException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver());
        sideMenu.
                navigateToFeladatkezeloPanel();
        FeladatkezeloPageTabs feladatkezeloPageTabs = new FeladatkezeloPageTabs(getDriver());
        feladatkezeloPageTabs.
                clickOnMunkafolyamatokTab();
        FeladatkezeloMunkafolyamatokPage feladatkezeloMunkafolyamatokPage = new FeladatkezeloMunkafolyamatokPage(getDriver());
        feladatkezeloMunkafolyamatokPage.
                clickOnUjMunkafolyamatInditasaBtn();

        FeladatkezeloUjMunkafolyamatInditasaPage feladatkezeloUjMunkafolyamatInditasaPage = new FeladatkezeloUjMunkafolyamatInditasaPage(getDriver());
        feladatkezeloUjMunkafolyamatInditasaPage.
                ingatlanKivalasztasa().
                scrollUp().
                clickOnVetelChbox();
        feladatkezeloUjMunkafolyamatInditasaPage.
                clickOnFolyamatInditasaBtn();
    }


}
