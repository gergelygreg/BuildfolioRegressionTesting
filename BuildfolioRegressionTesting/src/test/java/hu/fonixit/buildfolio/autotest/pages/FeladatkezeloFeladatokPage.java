package hu.fonixit.buildfolio.autotest.pages;

import com.sun.xml.txw2.TypedXmlWriter;
import hu.fonixit.buildfolio.autotest.base.BasePage;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.FeladatkezeloDetailsPages.FeladatkezeloDetailsAlapadatok;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FeladatkezeloFeladatokPage extends BasePage {

    public FeladatkezeloFeladatokPage (WebDriver driver){
        super(driver);
    }


    //select
    public FeladatkezeloFeladatokPage selectFeladatFromTable(String egyediAzon, String oszlopIndex){
        waitUtil.selectElementFromTableOszlopKivalasztasaval(egyediAzon, oszlopIndex);
        return this;
    }

    //assert
    public boolean feladatMegjelenikATablazatban(String egyediAzon, String oszlopIndex){
        return waitUtil.elementIsDisplayedInTable(egyediAzon, oszlopIndex);
    }

}
