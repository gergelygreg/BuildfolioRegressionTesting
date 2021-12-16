package hu.fonixit.buildfolio.autotest.pages.detailsPages.IngatlanokDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.WebDriver;

public class IngatlanokDetailsParkolas extends BasePage {

    public IngatlanokDetailsParkolas(WebDriver driver) {
        super(driver);
    }

    public boolean parkoloMegjATabl(String parkoloNeve){
        return  waitUtil.elementIsDisplayedInTable(parkoloNeve, "100", "2");
    }
}
