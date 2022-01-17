package hu.fonixit.buildfolio.autotest.tests;

import hu.fonixit.buildfolio.autotest.base.BaseTest;
import hu.fonixit.buildfolio.autotest.objects.*;
import hu.fonixit.buildfolio.autotest.pages.*;
import hu.fonixit.buildfolio.autotest.pages.components.SzerzodesekDetailsTabs;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.IngatlanokDetailsPages.IngatlanokDetailsAlapadatok;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.IngatlanokDetailsPages.IngatlanokDetailsMuszakiAdatok;
import hu.fonixit.buildfolio.autotest.pages.components.SideMenu;
import hu.fonixit.buildfolio.autotest.pages.components.IngatlanokDetailsPageTabs;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.SzerzodesekDetailsPages.SzerzodesekDetailsIngatlanokEsEladasiArak;
import hu.fonixit.buildfolio.autotest.utils.FakerUtils;
import hu.fonixit.buildfolio.autotest.utils.JacksonUtils;
import hu.fonixit.buildfolio.autotest.utils.UserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static hu.fonixit.buildfolio.autotest.utils.JacksonUtils.deserializeJson;

public class EladasTest extends BaseTest {

    @Test
    public void Eladasi_folyamat_inditasa_0lepes_teljes_folyamat_a_0_7_feladat_vegeig_tart() throws IOException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");

        //partnerek felvétele eladó-vevő
        //eladó
        SideMenu sideMenu = new SideMenu(getDriver());
        sideMenu.navigateToPartnerekPanel();
        PartnerekPage partnerekPage = new PartnerekPage(getDriver());
        String eladoPartnerNeve = "Teszt Partner Eladó" + new FakerUtils().generateRandomNumber();
        String telefonszam = "06202102121";
        String email = "email@gmail.com";
        partnerekPage.
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(eladoPartnerNeve).
                enterTelefonszFld(telefonszam).
                enterEmailFld(email).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();  //refresh page
        //vevő
        String vevoPartnerNeve = "Teszt Partner Vevő" + new FakerUtils().generateRandomNumber();
        String telefonszam1 = "06202102121";
        String email1 = "email@gmail.com";
        partnerekPage.
                clickOnUjPartnerFelveteleBtn().
                enterPartnerNeveFld(vevoPartnerNeve).
                enterTelefonszFld(telefonszam1).
                enterEmailFld(email1).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();  //refresh page

        //teljes kitöltöttségű ingatlan felvétele
        sideMenu.navigateToIngatlanokPanel();
        UjIngatlan ujIngatlan = deserializeJson("ujIngatlan.json", UjIngatlan.class);
        UjIngatlanAlapadatok ujIngatlanAlapadatok = deserializeJson("ujIngatlanAlapadatok.json", UjIngatlanAlapadatok.class);
        UjMuszakiAdatok ujMuszakiAdatok = deserializeJson("ujIngatlanMuszakiAdatok.json", UjMuszakiAdatok.class);
        IngatlanokPage ingatlanokPage = new IngatlanokPage(getDriver());
        ingatlanokPage.clickOnUjIngatlanFelveteleBtn();
        String megnevezes = "Teszt Ingatlan" + new FakerUtils().generateRandomNumber();
        ingatlanokPage.
                enterTextToMegnevezesFld(megnevezes).
                setUjIngatlan(ujIngatlan).
                selectElementFromSzervezetDropDown(vevoPartnerNeve).   //ITT PARTNERT LEHET KIVÁLASZTANI NEM SZERVEZETET!!!!!!!!!!!!!
                clickOnFelvetelBtn().
                clickOnElsoIngatlan();
        IngatlanokDetailsAlapadatok ingatlanokDetailsAlapadatok = new IngatlanokDetailsAlapadatok(getDriver());
        ingatlanokDetailsAlapadatok.
                clickOnAdatokSzerkeszteseBtn().
                setUjIngatlanAlapadatok(ujIngatlanAlapadatok).
                clickOnMentesBtnBtn();
        IngatlanokDetailsPageTabs ingatlanokDetailsPageTabs = new IngatlanokDetailsPageTabs(getDriver());
        ingatlanokDetailsPageTabs.
                clickOnMuszakiAdatokTab();
        IngatlanokDetailsMuszakiAdatok ingatlanokDetailsMuszakiAdatok = new IngatlanokDetailsMuszakiAdatok(getDriver());
        ingatlanokDetailsMuszakiAdatok.
                clickOnAdatokSzerkeszteseBtn().
                setUjMuszakiAdatok(ujMuszakiAdatok).
                clickOnMentesBtn();


        //Adásvételi szerződés felvétele


    }

}
