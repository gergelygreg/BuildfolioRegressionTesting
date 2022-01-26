package hu.fonixit.buildfolio.autotest.pages.detailsPages.SzamlakDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.PartnerekDetailsPages.PartnerekDetailsAlapadatok;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SzamlakDetailsAlapadatok extends BasePage {
    private final By adatokSzerkBtn = By.xpath("//button[contains(.,' Adatok szerkesztése ')]");
    private final By mentesBtn = By.xpath("//button[normalize-space()='Mentés']");
    private final By megsemBtn = By.xpath("//button[.=' Mégsem ']");

    public SzamlakDetailsAlapadatok(WebDriver driver) {
        super(driver);
    }

    //click
    public SzamlakDetailsAlapadatok clickOnAdatokSzerkBtn(){
        waitUtil.waitAndClick(adatokSzerkBtn);
        return this;
    }

    public SzamlakDetailsAlapadatok clickOnMentesBtn(){
        waitUtil.waitAndClick(mentesBtn);
        return this;
    }

    public SzamlakDetailsAlapadatok clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }
}
