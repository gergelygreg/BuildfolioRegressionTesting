package hu.fonixit.buildfolio.autotest.tests;

import hu.fonixit.buildfolio.autotest.base.BaseTest;
import hu.fonixit.buildfolio.autotest.objects.UjIngatlan;
import hu.fonixit.buildfolio.autotest.objects.UjSzerzodes;
import hu.fonixit.buildfolio.autotest.pages.*;
import hu.fonixit.buildfolio.autotest.pages.components.FeladatkezeloPageTabs;
import hu.fonixit.buildfolio.autotest.pages.components.SideMenu;
import hu.fonixit.buildfolio.autotest.pages.components.SzerzodesekDetailsPageTabs;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.SzerzodesekDetailsPages.SzerzodesekDetailsIngatlanokEsEladasiArak;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.SzerzodesekDetailsPages.SzerzodesekDetailsSzerzodoPartnerek;
import hu.fonixit.buildfolio.autotest.utils.FakerUtils;
import hu.fonixit.buildfolio.autotest.utils.UserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static hu.fonixit.buildfolio.autotest.utils.JacksonUtils.deserializeJson;

public class FeladatkezeloTest extends BaseTest {

    /*@Test
    public void feladatkezelo_menu_Feladatok_tab_szurok_mukodese() throws IOException, InterruptedException {
        //Eladás
        //Szervezet+Partner felvétele(az ingatlanhoz)
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
        sideMenu.
                navigateToSzervezetekPanel();
        String szervezetAzon = "Szervezet" + new FakerUtils().generateRandomNumber();

        SzervezetekPage szervezetekPage = new SzervezetekPage(getDriver());
        szervezetekPage.clickOnUjSzervezetFelveteleBtn();
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.enterSzervezetAzonositoFld(szervezetAzon);
        Assert.assertFalse(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.selectKapcsolodoPartnerFromDropDown(partnerNeve);
        Assert.assertTrue(szervezetekPage.felvetelBtnKattinthato());
        szervezetekPage.clickOnFelvetelBtn();

        //partner felvétele(Vevő)
        String partnerVevoNeve = "Teszt Vevő partner" + new FakerUtils().generateRandomNumber();
        String telefonszamVevo = "06202102121";
        String emailVevo = "emailvevo@gmail.com";
        sideMenu.
                navigateToPartnerekPanel();
        partnerekPage.
                clickOnFelvetelBtn().
                enterPartnerNeveFld(partnerVevoNeve).
                enterTelefonszFld(telefonszamVevo).
                enterEmailFld(emailVevo).
                clickOnFelvetelBtn();
        Assert.assertTrue(partnerekPage.partnerMegjATablaban(partnerVevoNeve, "1"));


        //Ingatlan felvétele
        IngatlanokPage ingatlanokPage = new IngatlanokPage(getDriver());
        UjIngatlan ujIngatlan = deserializeJson("ujIngatlan.json", UjIngatlan.class);

        ingatlanokPage.clickOnUjIngatlanFelveteleBtn();
        String megnevezes = "Teszt Ingatlan" + new FakerUtils().generateRandomNumber();
        ingatlanokPage.
                enterTextToMegnevezesFld(megnevezes).
                setUjIngatlan(ujIngatlan).
                selectElementFromSzervezetDropDown(szervezetAzon).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        Assert.assertTrue(ingatlanokPage.ingatlanMegjelATablaban(megnevezes));

        //Szerződés felvétele
        UjSzerzodes ujSzerzodes = deserializeJson("ujSzerzodes.json", UjSzerzodes.class);
        sideMenu.
                navigateToSzerzodesekPanel();

        String szerzodesSzam = "Szerződésszám teszt" + new FakerUtils().generateRandomNumber();
        SzerzodesekPage szerzodesekPage = new SzerzodesekPage(getDriver());
        szerzodesekPage.
                clickOnUjSzerzodesFelveteleBtn().
                enterTextToSzerzodesszamFld(szerzodesSzam).
                setUjSzerzodes(ujSzerzodes).
                clickOnFelvetelBtn();
        Assert.assertTrue(szerzodesekPage.popUpMegjelenik("Sikeres rögzítés!"));
        getDriver().navigate().refresh();
        Assert.assertTrue(szerzodesekPage.elemMegjelenikATablazatban(szerzodesSzam, "1"));
        szerzodesekPage.
                clickOnTablazatEleme(szerzodesSzam, "1");
        //-ingatlan hozzárendelése a szerződéshez - ingatlan árának meghatározása
        SzerzodesekDetailsPageTabs szerzodesekDetailsPageTabs = new SzerzodesekDetailsPageTabs(getDriver());
        szerzodesekDetailsPageTabs.
                clickOnIngatlanokEsEladasiArakNavLink();

        SzerzodesekDetailsIngatlanokEsEladasiArak szerzodesekDetailsIngatlanokEsEladasiArak = new SzerzodesekDetailsIngatlanokEsEladasiArak(getDriver());
        szerzodesekDetailsIngatlanokEsEladasiArak.
                clickOnIngaltlHozzarendelewseASzerzhezBtn().
                selectCheckboxFelvettIngatlan(megnevezes, "3").
                clickOnEladasiArakMegadasaAKijelolteknelBtn().
                enterToNettoEladasiArFld("1000000").
                clickOnHozzarendelesBtn();
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.ingatlanokHozzarendeleseSzerzodeshezSzoveg());
        szerzodesekDetailsIngatlanokEsEladasiArak.
                clickOnHozzarendelesBtn();
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.popupMegjelenik("Sikeres rögzítés!"));
        //-szerződő partnerek(vevő, eladó) meghatározása
        szerzodesekDetailsPageTabs.
                clickOnSzerzodoPartnerekNavLink();

        SzerzodesekDetailsSzerzodoPartnerek szerzodesekDetailsSzerzodoPartnerek = new SzerzodesekDetailsSzerzodoPartnerek(getDriver());
        szerzodesekDetailsSzerzodoPartnerek. //eladó
                clickOnHozzarendBtn().
                selectCheckboxFelvettPartner(partnerNeve, "2").
                clickOnHozzarendelesKijeloltBtn();
        Assert.assertTrue(szerzodesekDetailsSzerzodoPartnerek.popupMegjelenik("Sikeres hozzárendelés!"));
        szerzodesekDetailsSzerzodoPartnerek.
                clickOnSzerkesztesBtn().
                selectJogkorFromDropDown("Eladó").
                clickOnMentesIkon();
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.popupMegjelenik("Sikeres rögzítés!"));

        szerzodesekDetailsSzerzodoPartnerek.
              clickOnHozzarendBtn().
                selectCheckboxFelvettPartner(partnerVevoNeve, "2").
                clickOnHozzarendelesKijeloltBtn();
        Assert.assertTrue(szerzodesekDetailsSzerzodoPartnerek.popupMegjelenik("Sikeres hozzárendelés"));
        szerzodesekDetailsSzerzodoPartnerek.
                clickOnSzerkesztesBtn().
                selectJogkorFromDropDown("Vevő").
                clickOnMentesIkon();
        Assert.assertTrue(szerzodesekDetailsIngatlanokEsEladasiArak.popupMegjelenik("Sikeres rögzítés!"));

        //Új munkafolyamat indítása
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
                selectCheckboxIngatlan(megnevezes, "2").
                scrollUp().
                clickOnEladasChbox();
        feladatkezeloUjMunkafolyamatInditasaPage.
                clickOnFolyamatInditasaBtn();

        //Feladat tab - Szűrés


        //FOLYATATÁS, SZERVEZET FELVÉTELE BUG
    }*/
}
