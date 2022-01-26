package hu.fonixit.buildfolio.autotest.pages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdatletoltesPage extends BasePage {
    public final By adattablaDropDown = By.xpath("//input[@role='combobox']");
    private final By letoltesBtn = By.xpath("//button[.='Letöltés']");

    public AdatletoltesPage(WebDriver driver) {
        super(driver);
    }

    //click
    public AdatletoltesPage clickOnLetoltesBtn(){
        waitUtil.waitAndClick(letoltesBtn);
        return this;
    }

    //select
    public AdatletoltesPage selectFromAdattablaDropDown(String adattabla){
        waitUtil.waitAndClick(adattablaDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+adattabla+"']"));
        return this;
    }
}
