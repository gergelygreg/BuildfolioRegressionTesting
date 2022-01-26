package hu.fonixit.buildfolio.autotest.pages.detailsPages.IngatlanokDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.WebDriver;

public class IngatlanokDetailsMunkafolyamatok extends BasePage {

    public IngatlanokDetailsMunkafolyamatok(WebDriver driver) {
        super(driver);
    }

    //assert
    public boolean munkafolyamatMegjelenikATablazatban(String egyediAzon, String ozslopIndex){
        return waitUtil.elementIsDisplayedInTable(egyediAzon, ozslopIndex);
    }
}
