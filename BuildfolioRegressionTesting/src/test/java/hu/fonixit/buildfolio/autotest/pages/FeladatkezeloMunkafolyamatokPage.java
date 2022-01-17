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




}
