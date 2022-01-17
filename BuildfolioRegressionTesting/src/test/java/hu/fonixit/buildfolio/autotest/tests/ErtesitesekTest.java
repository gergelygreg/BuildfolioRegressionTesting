package hu.fonixit.buildfolio.autotest.tests;

import hu.fonixit.buildfolio.autotest.base.BaseTest;
import hu.fonixit.buildfolio.autotest.objects.UjSzerzodes;
import hu.fonixit.buildfolio.autotest.pages.DashboardPage;
import hu.fonixit.buildfolio.autotest.pages.ErtesitesekPage;
import hu.fonixit.buildfolio.autotest.pages.LoginPage;
import hu.fonixit.buildfolio.autotest.pages.SzerzodesekPage;
import hu.fonixit.buildfolio.autotest.pages.components.SideMenu;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.SzerzodesekDetailsPages.SzerzodesekDetailsAlapadatok;
import hu.fonixit.buildfolio.autotest.utils.FakerUtils;
import hu.fonixit.buildfolio.autotest.utils.UserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;


import static hu.fonixit.buildfolio.autotest.utils.JacksonUtils.deserializeJson;

public class ErtesitesekTest extends BaseTest {

    @Test
    public void Ertesitesek_menu_felulete_es_ertesites_torlese() throws IOException, InterruptedException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        UjSzerzodes ujSzerzodes = deserializeJson("ujSzerzodes.json", UjSzerzodes.class);
        //Szerződés felvétele
        SideMenu sideMenu = new SideMenu(getDriver());
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

        //Értesítés beállítása a szerződéshez
        SzerzodesekDetailsAlapadatok szerzodesekDetailsAlapadatok = new SzerzodesekDetailsAlapadatok(getDriver());

        LocalDate currentdate = LocalDate.now();
        Integer currentDay = currentdate.getDayOfMonth();
        Integer currentMonth = currentdate.getMonthValue();
        Integer currentYear = currentdate.getYear();
        Integer currentHour = LocalDateTime.now().getHour();
        Integer currentMinute = LocalDateTime.now().getMinute() + 1;

        String HH = currentHour.toString();
        String MM = currentMinute.toString();
        String yyyy = currentYear.toString();
        String mm = currentMonth.toString();
        String dd = currentDay.toString();

        String megjegyzes = "Megjegyzés teszt";

        szerzodesekDetailsAlapadatok.
                clickOnUjErtesitesBtn().
                enterTextToDatumFld(yyyy+"."+mm+"."+dd).
                enterTextToHHField(HH).
                enterTextToMMField(MM).
                enterTextToMegjegyzesFld(megjegyzes).
                clickOnLetrehozasBtn();

        Assert.assertTrue(szerzodesekPage.popUpMegjelenik("Sikeres rögzítés!"));

        Assert.assertTrue(szerzodesekDetailsAlapadatok.ertesitesMegjelenikAlapadatokOldalon());
        szerzodesekDetailsAlapadatok.
                clickOnXBtn().
                clickOnTorlesBtn();
        Assert.assertTrue(szerzodesekPage.popUpMegjelenik("Sikeres törlés!"));
    }

    @Test
    public void Ertesites_utani_teszt() throws InterruptedException, IOException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        UjSzerzodes ujSzerzodes = deserializeJson("ujSzerzodes.json", UjSzerzodes.class);
        //Szerződés felvétele
        SideMenu sideMenu = new SideMenu(getDriver());
        sideMenu.
                navigateToSzerzodesekPanel();

        String szerzodesSzam = "Szerzodesszám teszt" + new FakerUtils().generateRandomNumber();
        SzerzodesekPage szerzodesekPage = new SzerzodesekPage(getDriver());
        szerzodesekPage.
                clickOnUjSzerzodesFelveteleBtn().
                enterTextToSzerzodesszamFld(szerzodesSzam).
                setUjSzerzodes(ujSzerzodes).
                clickOnFelvetelBtn();
        Assert.assertTrue(szerzodesekPage.popUpMegjelenik("Sikeres rögzítés!"));
        Assert.assertTrue(szerzodesekPage.elemMegjelenikATablazatban(szerzodesSzam, "1"));
        szerzodesekPage.
                clickOnTablazatEleme(szerzodesSzam, "1");

        //Értesítés beállítása a szerződéshez
        SzerzodesekDetailsAlapadatok szerzodesekDetailsAlapadatok = new SzerzodesekDetailsAlapadatok(getDriver());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd"); //aktuális dátum
        String datum = formatter.toString();

        LocalDate currentdate = LocalDate.now();
        Integer currentDay = currentdate.getDayOfMonth();
        Integer currentMonth = currentdate.getMonthValue();
        Integer currentYear = currentdate.getYear();
        Integer currentHour = LocalDateTime.now().getHour();
        Integer currentMinute = LocalDateTime.now().getMinute() + 1;

        String HH = currentHour.toString();
        String MM = currentMinute.toString();
        String yyyy = currentYear.toString();
        String mm = currentMonth.toString();
        String dd = currentDay.toString();

        String megjegyzes = "Megjegyzés teszt";

        szerzodesekDetailsAlapadatok.
                clickOnUjErtesitesBtn().
                enterTextToDatumFld(yyyy+"."+mm+"."+dd).
                enterTextToHHField(HH).
                enterTextToMMField(MM).
                enterTextToMegjegyzesFld(megjegyzes).
                clickOnLetrehozasBtn();

        Assert.assertTrue(szerzodesekPage.popUpMegjelenik("Sikeres létrehozás!"));

        Thread.sleep(65000); //~1 perc várás, amíg megjelenik az értesítés
        Assert.assertTrue(sideMenu.ertesitesSzamMegjelenik("1"));

        sideMenu.
                navigateToErtesitesekPanel();

        ErtesitesekPage ertesitesekPage = new ErtesitesekPage(getDriver());
        Assert.assertTrue(ertesitesekPage.kiemeltAzErtesitesCime());

        ertesitesekPage.
                clickOnFelvettErtesites();
        Assert.assertFalse(szerzodesekDetailsAlapadatok.ertesitesMegjelenikAlapadatokOldalon());

        sideMenu.
                navigateToErtesitesekPanel();
        Assert.assertFalse(ertesitesekPage.kiemeltAzErtesitesCime());
        Assert.assertFalse(sideMenu.ertesitesSzamMegjelenik("1"));

    /*    Navbar navbar = new Navbar(getDriver());
        navbar.
                clickOnErtesitesIkon();
        Assert.assertTrue(navbar.harangDropDownElemMegjelenik(szerzodesSzam));
*/
    }

    @Test
    public void Ket_egyideju_szerzodes_beallitasa() throws InterruptedException, IOException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        UjSzerzodes ujSzerzodes = deserializeJson("ujSzerzodes.json", UjSzerzodes.class);
        //Szerződés felvétele
        SideMenu sideMenu = new SideMenu(getDriver());
        sideMenu.
                navigateToSzerzodesekPanel();

        String szerzodesSzam = "Szerzodesszám teszt" + new FakerUtils().generateRandomNumber();
        SzerzodesekPage szerzodesekPage = new SzerzodesekPage(getDriver());
        szerzodesekPage.
                clickOnUjSzerzodesFelveteleBtn().
                enterTextToSzerzodesszamFld(szerzodesSzam).
                setUjSzerzodes(ujSzerzodes).
                clickOnFelvetelBtn();
        Assert.assertTrue(szerzodesekPage.popUpMegjelenik("Sikeres rögzítés!"));
        Assert.assertTrue(szerzodesekPage.elemMegjelenikATablazatban(szerzodesSzam, "1"));
        szerzodesekPage.
                clickOnTablazatEleme(szerzodesSzam, "1");

        //Értesítés beállítása a szerződéshez
        SzerzodesekDetailsAlapadatok szerzodesekDetailsAlapadatok = new SzerzodesekDetailsAlapadatok(getDriver());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd"); //aktuális dátum
        String datum = formatter.toString();

        LocalDate currentdate = LocalDate.now();
        Integer currentDay = currentdate.getDayOfMonth();
        Integer currentMonth = currentdate.getMonthValue();
        Integer currentYear = currentdate.getYear();
        Integer currentHour = LocalDateTime.now().getHour();
        Integer currentMinute = LocalDateTime.now().getMinute() + 1;

        String HH = currentHour.toString();
        String MM = currentMinute.toString();
        String yyyy = currentYear.toString();
        String mm = currentMonth.toString();
        String dd = currentDay.toString();

        String megjegyzes = "Megjegyzés teszt";

        szerzodesekDetailsAlapadatok.
                clickOnUjErtesitesBtn().
                enterTextToDatumFld(yyyy+"."+mm+"."+dd).
                enterTextToHHField(HH).
                enterTextToMMField(MM).
                enterTextToMegjegyzesFld(megjegyzes).
                clickOnLetrehozasBtn();

        Assert.assertTrue(szerzodesekPage.popUpMegjelenik("Sikeres létrehozás!"));

        Thread.sleep(1000);
                szerzodesekDetailsAlapadatok.
                clickOnUjErtesitesBtn().
                enterTextToDatumFld(yyyy+"."+mm+"."+dd).
                enterTextToHHField(HH).
                enterTextToMMField(MM).
                enterTextToMegjegyzesFld(megjegyzes).
                clickOnLetrehozasBtn();

        Assert.assertTrue(szerzodesekPage.popUpMegjelenik("Sikeres létrehozás!"));

        Thread.sleep(65000); //~1 perc várás, amíg megjelenik az értesítés
        Assert.assertTrue(sideMenu.ertesitesSzamMegjelenik("2"));

    }

    @Test
    public void Multbeli_datum_megadasa() throws IOException {
        DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
        Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
        UjSzerzodes ujSzerzodes = deserializeJson("ujSzerzodes.json", UjSzerzodes.class);
        //Szerződés felvétele
        SideMenu sideMenu = new SideMenu(getDriver());
        sideMenu.
                navigateToSzerzodesekPanel();

        String szerzodesSzam = "Szerzodesszám teszt" + new FakerUtils().generateRandomNumber();
        SzerzodesekPage szerzodesekPage = new SzerzodesekPage(getDriver());
        szerzodesekPage.
                clickOnUjSzerzodesFelveteleBtn().
                enterTextToSzerzodesszamFld(szerzodesSzam).
                setUjSzerzodes(ujSzerzodes).
                clickOnFelvetelBtn();
        Assert.assertTrue(szerzodesekPage.popUpMegjelenik("Sikeres rögzítés!"));
        Assert.assertTrue(szerzodesekPage.elemMegjelenikATablazatban(szerzodesSzam, "1"));
        szerzodesekPage.
                clickOnTablazatEleme(szerzodesSzam, "1");

        //Értesítés beállítása a szerződéshez
        SzerzodesekDetailsAlapadatok szerzodesekDetailsAlapadatok = new SzerzodesekDetailsAlapadatok(getDriver());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd"); //aktuális dátum
        String datum = formatter.toString();

        //múltbeli dátum beállítása: (aktuális időpont) - 1 perc
        LocalDate currentdate = LocalDate.now();
        Integer currentDay = currentdate.getDayOfMonth();
        Integer currentMonth = currentdate.getMonthValue();
        Integer currentYear = currentdate.getYear();
        Integer currentHour = LocalDateTime.now().getHour();
        Integer currentMinute = LocalDateTime.now().getMinute() - 1;

        String HH = currentHour.toString();
        String MM = currentMinute.toString();
        String yyyy = currentYear.toString();
        String mm = currentMonth.toString();
        String dd = currentDay.toString();

        String megjegyzes = "Megjegyzés teszt";

        szerzodesekDetailsAlapadatok.
                clickOnUjErtesitesBtn().
                enterTextToDatumFld(yyyy+"."+mm+"."+dd).
                enterTextToHHField(HH).
                enterTextToMMField(MM).
                enterTextToMegjegyzesFld(megjegyzes).
                clickOnLetrehozasBtn();

        Assert.assertTrue(szerzodesekPage.popUpMegjelenik("Értesítés időpontja csak jövőbeli lehet!"));
    }


}
