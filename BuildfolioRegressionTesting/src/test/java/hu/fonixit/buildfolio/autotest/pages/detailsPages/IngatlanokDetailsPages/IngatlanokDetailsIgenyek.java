package hu.fonixit.buildfolio.autotest.pages.detailsPages.IngatlanokDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.WebDriver;

public class IngatlanokDetailsIgenyek extends BasePage {

    public IngatlanokDetailsIgenyek(WebDriver driver) {
        super(driver);
    }

    //assert
    public boolean igenyMegjelenikATablazatban(String egyediAzon, String ozslopIndex){
        return waitUtil.elementIsDisplayedInTable(egyediAzon, ozslopIndex);
    }
}
