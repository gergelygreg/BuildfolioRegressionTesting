package hu.fonixit.buildfolio.autotest.tests;

import hu.fonixit.buildfolio.autotest.base.BaseTest;
import hu.fonixit.buildfolio.autotest.objects.ADUser;
import hu.fonixit.buildfolio.autotest.pages.DashboardPage;
import hu.fonixit.buildfolio.autotest.pages.LoginPage;
import hu.fonixit.buildfolio.autotest.pages.RiportokPage;
import hu.fonixit.buildfolio.autotest.pages.components.SideMenu;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class RiportokTest extends BaseTest {

    @Test
    public void Megjeleno_Riportok_TULAJDONOSI_szerepkorrel_osszes_riport_futtatasa_pdf_es_excel_fajlformatumra() throws InterruptedException {
        ADUser user = new ADUser().
                setADUsername("takarekingatlanuser1").
                setPassword("Testing123");
        DashboardPage dashboardPage = new LoginPage(getDriver()).
                load().
                enterTextInUsernameFld(user.getADUsername()).
                enterTextInPasswordFld(user.getPassword()).
                belepes();
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToRiportokPanel();
        RiportokPage riportokPage = new RiportokPage(getDriver());
        Assert.assertEquals(riportokPage.szerepkorEllenorzesTulajd(), "Tulajdonos");
        Assert.assertTrue(riportokPage.ingatlanokErtekeRadioBtnChecked());
        Assert.assertTrue(riportokPage.pdfFajlformRadioBtnChecked());
        Assert.assertTrue(riportokPage.ingatlanErtekeMegjelenik());
        Assert.assertTrue(riportokPage.eszkozokListaMegjelenik());
        Assert.assertTrue(riportokPage.partnerListaMegjelenik());
        Assert.assertTrue(riportokPage.ingatlanokListaMegjelenik());
        Assert.assertTrue(riportokPage.szamlakListaMegjelenik());
        Assert.assertTrue(riportokPage.szerzodesListaMegjelenik());

        riportokPage.
                clickOnFuttatasBtn().  //ingatlanok értéke
                clickOnRiportLetolteseBtn().
                selectExcelRadioBtn().
                clickOnFuttatasBtn().
                clickOnRiportLetolteseBtn().
                selectPdfRadioBtn().
                selectEszkozokListaRadioBtn().  //eszközök lista
                clickOnFuttatasBtn().
                clickOnRiportLetolteseBtn().
                selectExcelRadioBtn().
                clickOnFuttatasBtn().
                clickOnRiportLetolteseBtn().
                selectPdfRadioBtn().
                selectPartnerListaRadioBtn().  //partner lista
                clickOnFuttatasBtn().
                clickOnRiportLetolteseBtn().
                selectExcelRadioBtn().
                clickOnFuttatasBtn().
                clickOnRiportLetolteseBtn().
                selectPdfRadioBtn().
                selectIngatlanokListaRadioBtn().  //ingatlanok lista
                clickOnFuttatasBtn().
                clickOnRiportLetolteseBtn().
                selectExcelRadioBtn().
                clickOnFuttatasBtn().
                clickOnRiportLetolteseBtn().
                selectPdfRadioBtn().
                selectSzamlakListaRadioBtn().  //számlák lista
                clickOnFuttatasBtn().
                clickOnRiportLetolteseBtn().
                selectExcelRadioBtn().
                clickOnFuttatasBtn().
                clickOnRiportLetolteseBtn().
                selectPdfRadioBtn().
                selectSzerzodesListaRadioBtn().   //szerződés lista
                clickOnFuttatasBtn().
                clickOnRiportLetolteseBtn().
                selectExcelRadioBtn().
                clickOnFuttatasBtn().
                clickOnRiportLetolteseBtn();

    }

    @Test
    public void Megjeleno_Riportok_BERLO_szerepkorrel_osszes_riport_futtatasa_pdf_es_excel_fajlformatumra() throws InterruptedException {
        ADUser user = new ADUser().
                setADUsername("takarekingatlanuser1").
                setPassword("Testing123");
        DashboardPage dashboardPage = new LoginPage(getDriver()).
                load().
                enterTextInUsernameFld(user.getADUsername()).
                enterTextInPasswordFld(user.getPassword()).
                belepes();
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToRiportokPanel();
        RiportokPage riportokPage = new RiportokPage(getDriver());
        String szerepkor = "Bérlő";
        riportokPage.selectSzerepkor(szerepkor);
        Assert.assertEquals(riportokPage.szerepkorEllenorzesBerlo(), "Bérlő");
        Assert.assertTrue(riportokPage.ingatlanokListaRadioBtnCheckedBerlo());
        Assert.assertTrue(riportokPage.pdfFajlformRadioBtnCheckedBerlo());
        Assert.assertTrue(riportokPage.ingatlanokListaMegjelenik());
        Assert.assertTrue(riportokPage.szamlakListaMegjelenik());
        Assert.assertTrue(riportokPage.szerzodesListaMegjelenik());
        riportokPage.
                clickOnFuttatasBtn().  //ingatlanok lista
                clickOnRiportLetolteseBtn().
                selectExcelRadioBtnBerlo().
                clickOnFuttatasBtn().
                clickOnRiportLetolteseBtn().
                selectPdfRadioBtnBerlo().
                selectSzamlakListaRadioBtnBerlo().  //számlák lista
                clickOnFuttatasBtn().
                clickOnRiportLetolteseBtn().
                selectExcelRadioBtnBerlo().
                clickOnFuttatasBtn().
                clickOnRiportLetolteseBtn().
                selectPdfRadioBtnBerlo().
                selectSzerzodesListaRadioBtnBerlo(). //szerződés lista
                clickOnFuttatasBtn().
                clickOnRiportLetolteseBtn().
                selectExcelRadioBtnBerlo().
                clickOnFuttatasBtn().
                clickOnRiportLetolteseBtn();
    }

    @Test
    public void Megjeleno_Riportok_UZEMELTETO_szerepkorrel_osszes_riport_futtatasa_pdf_es_excel_fajlformatumra() {
        ADUser user = new ADUser().
                setADUsername("takarekingatlanuser1").
                setPassword("Testing123");
        DashboardPage dashboardPage = new LoginPage(getDriver()).
                load().
                enterTextInUsernameFld(user.getADUsername()).
                enterTextInPasswordFld(user.getPassword()).
                belepes();
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToRiportokPanel();
        RiportokPage riportokPage = new RiportokPage(getDriver());
        String szerepkor = "Üzemeltető";
        riportokPage.selectSzerepkor(szerepkor);
        Assert.assertEquals(riportokPage.szerepkorEllenorzesUzem(), "Üzemeltető");
        Assert.assertTrue(riportokPage.eszkozokListaRadioBtnCheckedUzem());
        Assert.assertTrue(riportokPage.pdfFajlformRadioBtnCheckedUzem());
        Assert.assertTrue(riportokPage.eszkozokListaMegjelenik());
        Assert.assertTrue(riportokPage.ingatlanokListaMegjelenik());
        Assert.assertTrue(riportokPage.szamlakListaMegjelenik());
        Assert.assertTrue(riportokPage.szerzodesListaMegjelenik());
        riportokPage.
                clickOnFuttatasBtn().  //eszköz lista
                clickOnRiportLetolteseBtn().
                selectExcelRadioBtnUzem().
                clickOnFuttatasBtn().
                clickOnRiportLetolteseBtn().
                selectPdfRadioBtnUzem().
                selectIngatlanokListaRadioBtnUzem().  //ingatlanok lista
                clickOnFuttatasBtn().
                clickOnRiportLetolteseBtn().
                selectExcelRadioBtnUzem().
                clickOnFuttatasBtn().
                clickOnRiportLetolteseBtn().
                selectPdfRadioBtnUzem().
                selectSzamlakListaRadioBtnUzem().  //számlák lista
                clickOnFuttatasBtn().
                clickOnRiportLetolteseBtn().
                selectExcelRadioBtnUzem().
                clickOnFuttatasBtn().
                clickOnRiportLetolteseBtn().
                selectPdfRadioBtnUzem().
                selectSzerzodesListaRadioBtnUzem(). //szerződés lista
                clickOnFuttatasBtn().
                clickOnRiportLetolteseBtn().
                selectExcelRadioBtnUzem().
                clickOnFuttatasBtn().
                clickOnRiportLetolteseBtn();
    }

    @Test
    public void Megjeleno_Riportok_KEZELO_szerepkorrel_osszes_riport_futtatasa_pdf_es_excel_fajlformatumra() {
        ADUser user = new ADUser().
                setADUsername("takarekingatlanuser1").
                setPassword("Testing123");
        DashboardPage dashboardPage = new LoginPage(getDriver()).
                load().
                enterTextInUsernameFld(user.getADUsername()).
                enterTextInPasswordFld(user.getPassword()).
                belepes();
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToRiportokPanel();
        RiportokPage riportokPage = new RiportokPage(getDriver());
        String szerepkor = "Kezelő";
        riportokPage.selectSzerepkor(szerepkor);
        Assert.assertEquals(riportokPage.szerepkorEllenorzesKezelo(), "Kezelő");
        Assert.assertTrue(riportokPage.szamlakListaRadioBtnCheckedKezelo());
        Assert.assertTrue(riportokPage.pdfFajlformRadioBtnCheckedKezelo());
        Assert.assertTrue(riportokPage.szamlakListaMegjelenik());
        Assert.assertTrue(riportokPage.szerzodesListaMegjelenik());
        riportokPage.
                clickOnFuttatasBtn().  //Számlák lista
                clickOnRiportLetolteseBtn().
                selectExcelRadioBtnKezelo().
                clickOnFuttatasBtn().
                clickOnRiportLetolteseBtn().
                selectPdfRadioBtnKezelo().
                selectSzerzodesListaRadioBtnKezelo().  //szerződések lista
                clickOnFuttatasBtn().
                clickOnRiportLetolteseBtn().
                selectExcelRadioBtnKezelo().
                clickOnFuttatasBtn().
                clickOnRiportLetolteseBtn();

    }
}