package hu.fonixit.buildfolio.autotest.pages.detailsPages.IngatlanokDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IngatlanokDetailsNyilvantartas extends BasePage {
    private final By adatokSzerkeszteseBtn = By.xpath("//button[normalize-space()='Adatok szerkesztése']");
    private final By mentesBtn = By.xpath("//button[contains(.,'Mentés')]");
    private final By megsemBtn = By.xpath("//button[normalize-space()='Mégsem']");
    private final By nyilvantartasDropDown = By.xpath("//app-buildfolio-select[@name='registrationCode']//input");

    public IngatlanokDetailsNyilvantartas(WebDriver driver) {
        super(driver);
    }

    //click
    public IngatlanokDetailsNyilvantartas clickOnAdatokSzerkeszteseBtn(){
        waitUtil.waitAndClick(adatokSzerkeszteseBtn);
        return this;
    }

    public IngatlanokDetailsNyilvantartas clickOnMentesBtn(){
        waitUtil.waitAndClick(mentesBtn);
        return this;
    }

    public IngatlanokDetailsNyilvantartas clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    //select
    public IngatlanokDetailsNyilvantartas selectNyilvantartasFromDropDown(String nyilvantartas){
        waitUtil.waitAndClick(nyilvantartasDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+nyilvantartas+"']"));
        return this;
    }
}
