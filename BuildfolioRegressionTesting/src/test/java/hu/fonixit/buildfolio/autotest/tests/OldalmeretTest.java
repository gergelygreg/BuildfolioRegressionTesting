package hu.fonixit.buildfolio.autotest.tests;

import hu.fonixit.buildfolio.autotest.base.BaseTest;
import hu.fonixit.buildfolio.autotest.pages.DashboardPage;
import hu.fonixit.buildfolio.autotest.pages.IngatlanokPage;
import hu.fonixit.buildfolio.autotest.pages.LoginPage;
import hu.fonixit.buildfolio.autotest.pages.components.Oldalmeret;
import hu.fonixit.buildfolio.autotest.pages.components.SideMenu;
import hu.fonixit.buildfolio.autotest.utils.UserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OldalmeretTest extends BaseTest {

   @Test
    public void oldalmeret_teszt(){
       DashboardPage dashboardPage = new LoginPage(getDriver()).doLogin(UserUtils.getTakarekIngatlanUser1());
       Assert.assertEquals(dashboardPage.attekintesSuccessNotice(), "Áttekintés");
       SideMenu sideMenu = new SideMenu(getDriver()).navigateToIngatlanokPanel();
       IngatlanokPage ingatlanokPage = new IngatlanokPage(getDriver());
       Oldalmeret oldalmeret = new Oldalmeret(getDriver()).
               megjelenoElemekATablazatban("5").
               megjelenoElemekATablazatban("10").
               megjelenoElemekATablazatban("25").
               megjelenoElemekATablazatban("50").
               megjelenoElemekATablazatban("75").
               megjelenoElemekATablazatban("100");
   }
}
