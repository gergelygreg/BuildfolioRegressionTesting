package hu.fonixit.buildfolio.autotest.pages.detailsPages.PartnerekDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.WebDriver;

public class PartnerekDetailsIngatlanok extends BasePage {

    public PartnerekDetailsIngatlanok(WebDriver driver) {
        super(driver);
    }

    //assertion
    public boolean ingatlanMegjATablBan(String elemNeve, String tablaoszlopIndex){
        return waitUtil.elementIsDisplayedInTable(elemNeve,tablaoszlopIndex);
    }

    //nincs megjeleníthető adat
    public boolean nincsMegjelenithetoAdatFelirat(){
        return waitUtil.nincsMegjAdatFeliratMegj();
    }
}
