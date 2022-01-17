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

    public FeladatkezeloFeladatokPage feladatKivalasztas(String alcim){
        String feldatAlcim = null;
        try {
            feldatAlcim = waitUtil.waitAndGetText(By.xpath("//span[normalize-space()='"+alcim+"']"));
            if (feldatAlcim != null && feldatAlcim.contains(alcim)) {
                waitUtil.waitAndClick(By.xpath("//tr[contains(.,'"+alcim+"')]//input"));
            }
            else {
                waitUtil.waitAndClick(By.xpath("//button[@id='table-pager-next']//span[@class='icon-container']"));
            }
        } catch (Exception e) {
        }
        return this;
    }
}
