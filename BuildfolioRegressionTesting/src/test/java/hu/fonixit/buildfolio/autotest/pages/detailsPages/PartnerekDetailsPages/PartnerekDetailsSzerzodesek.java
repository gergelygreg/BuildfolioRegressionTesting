package hu.fonixit.buildfolio.autotest.pages.detailsPages.PartnerekDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.WebDriver;

public class PartnerekDetailsSzerzodesek extends BasePage {

    public PartnerekDetailsSzerzodesek(WebDriver driver) {
        super(driver);
    }

    //assert
    public boolean szerzodesMegjelenikATablBan(String elemNeve, String tablaIndex){
        return waitUtil.elementIsDisplayedInTable(elemNeve, tablaIndex);
    }

    public boolean nincsMegjAdatMegj(){
      return  waitUtil.nincsMegjAdatFeliratMegj();
    }
}
