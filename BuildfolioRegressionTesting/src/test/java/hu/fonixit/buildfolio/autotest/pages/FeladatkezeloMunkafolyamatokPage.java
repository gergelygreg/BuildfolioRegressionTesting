package hu.fonixit.buildfolio.autotest.pages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FeladatkezeloMunkafolyamatokPage extends BasePage {
    private final By ujMunkafolyamatInditasa = By.xpath("//a[normalize-space()='Új munkafolyamat indítása']");

    public FeladatkezeloMunkafolyamatokPage(WebDriver driver) {
        super(driver);
    }

    //click
    public FeladatkezeloMunkafolyamatokPage clickOnUjMunkafolyamatInditasaBtn(){
        waitUtil.waitAndClick(ujMunkafolyamatInditasa);
        return this;
    }

    //select
    public FeladatkezeloMunkafolyamatokPage selectMunkafolyamatFromTable(String egyediAzon, String oszlopIndex){
        waitUtil.selectElementFromTableOszlopKivalasztasaval(egyediAzon, oszlopIndex);
        return this;
    }

    //assert
    public boolean munkafolyamatMegjelenikATablazatban(String egyediAzon, String oszlopIndex){
        return waitUtil.elementIsDisplayedInTable(egyediAzon, oszlopIndex);
    }




}
