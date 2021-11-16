package hu.fonixit.buildfolio.autotest.tests;

import hu.fonixit.buildfolio.autotest.base.BaseTest;
import hu.fonixit.buildfolio.autotest.objects.ADUser;
import hu.fonixit.buildfolio.autotest.objects.UjIngatlan;
import hu.fonixit.buildfolio.autotest.objects.UjIngatlanAlapadatok;
import hu.fonixit.buildfolio.autotest.objects.UjMuszakiAdatok;
import hu.fonixit.buildfolio.autotest.pages.DashboardPage;
import hu.fonixit.buildfolio.autotest.pages.IngatlanokPage;
import hu.fonixit.buildfolio.autotest.pages.LoginPage;
import hu.fonixit.buildfolio.autotest.pages.components.IngatlanokDetailsPageTabs;
import hu.fonixit.buildfolio.autotest.pages.components.SideMenu;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.IngatlanokDetailsPages.IngatlanokDetailsAlapadatok;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.IngatlanokDetailsPages.IngatlanokDetailsMuszakiAdatok;
import hu.fonixit.buildfolio.autotest.utils.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static hu.fonixit.buildfolio.autotest.utils.JacksonUtils.deserializeJson;

public class IngatlanokTest extends BaseTest {

    @Test
    public  void ingatlan_felvetele() throws IOException {
        //teljes kitöltöttségű ingatlan felvétele
        ADUser user = new ADUser().
                setADUsername("takarekingatlanuser1").
                setPassword("Testing123");
        DashboardPage dashboardPage = new LoginPage(getDriver()).
                load().
                enterTextInUsernameFld(user.getADUsername()).
                enterTextInPasswordFld(user.getPassword()).
                belepes();
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");

        SideMenu sideMenu = new SideMenu(getDriver());
        sideMenu.navigateToIngatlanokPanel();
        UjIngatlan ujIngatlan = deserializeJson("ujIngatlan.json", UjIngatlan.class);
        UjIngatlanAlapadatok ujIngatlanAlapadatok = deserializeJson("ujIngatlanAlapadatok.json", UjIngatlanAlapadatok.class);
        UjMuszakiAdatok ujMuszakiAdatok = deserializeJson("ujIngatlanMuszakiAdatok.json", UjMuszakiAdatok.class);
        String szervezetAzon = "Minta Zrt.";
        IngatlanokPage ingatlanokPage = new IngatlanokPage(getDriver());
        ingatlanokPage.clickOnUjIngatlanFelveteleBtn();
        String megnevezes = "Teszt Ingatlan" + new FakerUtils().generateRandomNumber();
        String tihaszId = "TihaszID" + new FakerUtils().generateRandomNumber();
        ingatlanokPage.
                enterTextToMegnevezesFld(megnevezes).
                setUjIngatlan(ujIngatlan).
                selectElementFromSzervezetDropDown(szervezetAzon).
                clickOnFelvetelBtn();
        getDriver().navigate().refresh();
        ingatlanokPage.clickOnElsoIngatlan();

        IngatlanokDetailsAlapadatok ingatlanokDetailsAlapadatok = new IngatlanokDetailsAlapadatok(getDriver());
        ingatlanokDetailsAlapadatok.
                clickOnAdatokSzerkeszteseBtn().
                setUjIngatlanAlapadatok(ujIngatlanAlapadatok).
                enterTextToTihaszIdFld(tihaszId).
                clickOnMentesBtnBtn();

        IngatlanokDetailsPageTabs ingatlanokDetailsPageTabs = new IngatlanokDetailsPageTabs(getDriver());
        ingatlanokDetailsPageTabs.
                clickOnMuszakiAdatokTab();
        IngatlanokDetailsMuszakiAdatok ingatlanokDetailsMuszakiAdatok = new IngatlanokDetailsMuszakiAdatok(getDriver());
        ingatlanokDetailsMuszakiAdatok.
                clickOnAdatokSzerkeszteseBtn().
                setUjMuszakiAdatok(ujMuszakiAdatok).
                clickOnMentesBtn();
    }
}
