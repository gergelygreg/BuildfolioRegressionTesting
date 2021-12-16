package hu.fonixit.buildfolio.autotest.tests;

import hu.fonixit.buildfolio.autotest.base.BaseTest;
import hu.fonixit.buildfolio.autotest.objects.ADUser;
import hu.fonixit.buildfolio.autotest.pages.DashboardPage;
import hu.fonixit.buildfolio.autotest.pages.LoginPage;
import hu.fonixit.buildfolio.autotest.pages.PartnerekPage;
import hu.fonixit.buildfolio.autotest.pages.SzervezetekPage;
import hu.fonixit.buildfolio.autotest.pages.components.SideMenu;
import hu.fonixit.buildfolio.autotest.pages.components.Szurok;
import hu.fonixit.buildfolio.autotest.utils.FakerUtils;
import hu.fonixit.buildfolio.autotest.utils.UserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SzervezetekTest extends BaseTest {

    @Test
    public void Uj_szervezet_felvetele_csak_a_kotelezo_mezok_kitoltesevel() throws InterruptedException { //előtte fel kell venni egy partnert, mivel ELŐFELTÉTEL:
        // A Partnerek menüpontban van legalább egy olyan partner rögzítve, aki nincs szervezethez rendelve
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToPartnerekPanel();
        String partnerNeve = "Teszt Partner" + new FakerUtils().generateRandomNumber();
        String telefonszam = "06202102121";
        String email = "email@gmail.com";
        PartnerekPage partnerekPage = new PartnerekPage(getDriver()).
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(partnerNeve).
                enterTelefonszFld(telefonszam).
                enterEmailFld(email).
                clickOnFelvetelBtn();
        SideMenu sideMenu1 = new SideMenu(getDriver()).navigateToSzervezetekPanel();
        String szervezetAzon = "Szervezet" + new FakerUtils().generateRandomNumber();

        SzervezetekPage szervezetekPage = new SzervezetekPage(getDriver());
                szervezetekPage.clickOnUjSzervezetFelveteleBtn();
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.enterSzervezetAzonositoFld(szervezetAzon);
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.selectKapcsolodoPartnerFromDropDown(partnerNeve);
        Assert.assertTrue(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.clickOnFelvetelBtn();

    }

    @Test
    public void Uj_szervezet_felvetel_az_osszes_mezo_kitöltésével(){
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToPartnerekPanel();
        String partnerNeve = "Teszt Partner" + new FakerUtils().generateRandomNumber();
        String telefonszam = "06202102121";
        String email = "email@gmail.com";
        PartnerekPage partnerekPage = new PartnerekPage(getDriver()).
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(partnerNeve).
                enterTelefonszFld(telefonszam).
                enterEmailFld(email).
                clickOnFelvetelBtn();
        SideMenu sideMenu1 = new SideMenu(getDriver()).navigateToSzervezetekPanel();
        String szervezetAzon = "Szervezet" + new FakerUtils().generateRandomNumber();
        String adOrgUnit = "User";
        SzervezetekPage szervezetekPage = new SzervezetekPage(getDriver());
        szervezetekPage.clickOnUjSzervezetFelveteleBtn();
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.enterSzervezetAzonositoFld(szervezetAzon);
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.selectKapcsolodoPartnerFromDropDown(partnerNeve);
        Assert.assertTrue(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.enterADOrganisUnitFld(adOrgUnit);
        Assert.assertTrue(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.clickOnFelvetelBtn();
        //VÉGÉN ELLENŐRIZNI HOGY A LISTÁBAN MEGJELNIK A FELVETT SZERVEZET*/
        getDriver().navigate().refresh();  //refresh page
        Assert.assertTrue(szervezetekPage.felvettSzervezetMegjelenik(szervezetAzon));

    }

    @Test
    public void Uj_szervezet_felvetele_Kapcsolodo_partner_mezo_kitoltese_nelkul(){
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu1 = new SideMenu(getDriver()).navigateToSzervezetekPanel();

        String szervezetAzon = "Szervezet" + new FakerUtils().generateRandomNumber();
        SzervezetekPage szervezetekPage = new SzervezetekPage(getDriver());

        szervezetekPage.
                clickOnUjSzervezetFelveteleBtn().
                enterSzervezetAzonositoFld(szervezetAzon);
        Assert.assertTrue(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.clickOnFelvetelBtn();

    }

    @Test
    public void Uj_szervezet_felvetelenek_megszakitasa_Mégsem_gombbal(){
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");

        SideMenu sideMenu1 = new SideMenu(getDriver()).navigateToSzervezetekPanel();

        SzervezetekPage szervezetekPage = new SzervezetekPage(getDriver());
        String szervezetAzon = "Szervezet" + new FakerUtils().generateRandomNumber();
        String kapcsPartner = "Példa Kft.";
        szervezetekPage.
                clickOnUjSzervezetFelveteleBtn().
                enterSzervezetAzonositoFld(szervezetAzon).
                selectKapcsolodoPartnerFromDropDown(kapcsPartner);
        Assert.assertTrue(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.clickOnMegsemBtn();
        Assert.assertTrue(szervezetekPage.szervezetekFeliratMegjelenik());
    }

    @Test
    public void Szurok_mukodese(){
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToPartnerekPanel();
        String partnerNeve = "Teszt Partner" + new FakerUtils().generateRandomNumber();
        String telefonszam = "06202102121";
        String email = "email@gmail.com";
        PartnerekPage partnerekPage = new PartnerekPage(getDriver()).
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(partnerNeve).
                enterTelefonszFld(telefonszam).
                enterEmailFld(email).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();  //refresh page
        SideMenu sideMenu1 = new SideMenu(getDriver()).navigateToSzervezetekPanel();
        String szervezetAzon = "Szervezet" + new FakerUtils().generateRandomNumber();
        SzervezetekPage szervezetekPage = new SzervezetekPage(getDriver());
        szervezetekPage.clickOnUjSzervezetFelveteleBtn();
        Assert.assertTrue(szervezetekPage.felvetelBtnKattinthato()); //HIBA elvileg a Felvétel gomb végig kattintható
        szervezetekPage.enterSzervezetAzonositoFld(szervezetAzon);
        Assert.assertTrue(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.selectKapcsolodoPartnerFromDropDown(partnerNeve);
        Assert.assertTrue(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.clickOnFelvetelBtn();
        //VÉGÉN ELLENŐRIZNI HOGY A LISTÁBAN MEGJELNIK A FELVETT SZERVEZET*/
        getDriver().navigate().refresh();  //refresh page
        Assert.assertTrue(szervezetekPage.felvettSzervezetMegjelenik(szervezetAzon));

        Szurok szurok = new Szurok(getDriver());
        szurok.
                clickOnSzurokBtn().  //szervezet azonosító
                enterSzervezetAzonFld(szervezetAzon).
                clickOnKeresesBtn();
        Assert.assertEquals(szurok.felvettSzervezetMegjelenikSzures(), szervezetAzon);
        szurok.
                clickOnSzurokTorleseBtn(). //kapcsolódó partner
                kapcsolodoPartnerKivalasztasaFromKapcsolodoPartnDropDown(partnerNeve).
                clickOnKeresesBtn();
        szervezetekPage.felvettKapcsolodoPartnerMegjelenik(partnerNeve);
        szurok.
                clickOnSzurokTorleseBtn(). //szervezet azonosító+kapcsolódó partner
                enterSzervezetAzonFld(szervezetAzon).
                kapcsolodoPartnerKivalasztasaFromKapcsolodoPartnDropDown(partnerNeve).
                clickOnKeresesBtn();
        szervezetekPage.
                felvettKapcsolodoPartnerMegjelenik(partnerNeve);
        Assert.assertTrue(szervezetekPage.felvettSzervezetMegjelenik(szervezetAzon));
    }

    @Test
    public void Szervezet_szerkesztese(){
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        SideMenu sideMenu = new SideMenu(getDriver()).navigateToPartnerekPanel();
        String partnerNeve = "Teszt Partner" + new FakerUtils().generateRandomNumber();
        String telefonszam = "06202102121";
        String email = "email@gmail.com";
        PartnerekPage partnerekPage = new PartnerekPage(getDriver()).
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(partnerNeve).
                enterTelefonszFld(telefonszam).
                enterEmailFld(email).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();  //refresh page
        String listaUtolsoNevPartner = partnerekPage.kapcsolodoPartnerNev();
        SideMenu sideMenu1 = new SideMenu(getDriver()).navigateToSzervezetekPanel();
        String szervezetAzon = "Szervezet" + new FakerUtils().generateRandomNumber();
        SzervezetekPage szervezetekPage = new SzervezetekPage(getDriver());
        szervezetekPage.clickOnUjSzervezetFelveteleBtn();
        Assert.assertTrue(szervezetekPage.felvetelBtnKattinthato()); //HIBA elvileg a Felvétel gomb végig kattintható
        szervezetekPage.enterSzervezetAzonositoFld(szervezetAzon);
        Assert.assertTrue(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.selectKapcsolodoPartnerFromDropDown(partnerNeve);
        Assert.assertTrue(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.clickOnFelvetelBtn();
        //VÉGÉN ELLENŐRIZNI HOGY A LISTÁBAN MEGJELNIK A FELVETT SZERVEZET*/
        getDriver().navigate().refresh();  //refresh page
        Assert.assertTrue(szervezetekPage.felvettSzervezetMegjelenik(szervezetAzon));

        String adOrgUnit = "ADUnit";
        szervezetekPage.
                clickOnSzerkesztesUtolsoMuveletekBtn();
        Assert.assertTrue(szervezetekPage.szervezetAzonositoNemSzerkesztheto());  //MEGNÉZNI
        szervezetekPage.
                clearKapcsolodoPartner().
                selectKapcsolodoPartnerFromDropDown(partnerNeve).
                clearADOrgUnitFld().
                enterADOrganisUnitFld(adOrgUnit);

    }

}
