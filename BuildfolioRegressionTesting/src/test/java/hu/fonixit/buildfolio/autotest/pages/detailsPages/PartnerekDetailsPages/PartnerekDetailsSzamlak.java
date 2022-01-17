package hu.fonixit.buildfolio.autotest.pages.detailsPages.PartnerekDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.WebDriver;

public class PartnerekDetailsSzamlak extends BasePage {

    public PartnerekDetailsSzamlak(WebDriver driver) {
        super(driver);
    }

    public boolean szamlaMegjelenikATablazatban(String elemNeve, String oszlopIndex){
       return waitUtil.elementIsDisplayedInTable(elemNeve, oszlopIndex);
    }
}
