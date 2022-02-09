package hu.fonixit.buildfolio.autotest.pages.detailsPages.PartnerekDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.WebDriver;

public class PartnerekDetailsMeroorak extends BasePage {

    public PartnerekDetailsMeroorak(WebDriver driver) {
        super(driver);
    }

    public boolean merooraMegjelenikATablazatban(String elemNeve, String oszlopindex){
        return waitUtil.elementIsDisplayedInTable(elemNeve, oszlopindex);
    }

    public boolean nincsMegjelenithetoAdatFelirat(){
        return waitUtil.nincsMegjAdatFeliratMegj();
    }
}
