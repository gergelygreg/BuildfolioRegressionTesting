package hu.fonixit.buildfolio.autotest.pages.detailsPages.IngatlanokDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.WebDriver;

public class IngatlanokDetailsPartnerek extends BasePage {

    public IngatlanokDetailsPartnerek(WebDriver driver) {
        super(driver);
    }

    //assert
    public boolean partnerMegjelenikATablazatban(String egyediAzon, String oszlopIndex){
        return waitUtil.elementIsDisplayedInTable(egyediAzon, oszlopIndex);
    }


}
