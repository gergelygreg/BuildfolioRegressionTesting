package hu.fonixit.buildfolio.autotest.pages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdatfeltoltesPage extends BasePage {
    private final By fajlKivalasztasaBtn = By.id("file-input");
    private final By feltoltesBtn = By.xpath("//button[.=' Feltöltés ']");
    private final By modositasBtn = By.xpath("//label[normalize-space()='Módosítás']");
    private final By adattablaDropDown = By.xpath("//input[@role='combobox']");

    public AdatfeltoltesPage(WebDriver driver) {
        super(driver);
    }

    //sendKeys
    public AdatfeltoltesPage fajlfeltoltese(){
        WebElement fajlfeltolteseBtn = driver.findElement(fajlKivalasztasaBtn);
        fajlfeltolteseBtn.sendKeys("C:\\Users\\ggulacsi\\IdeaProjects\\buildfolio-autotest\\BuildfolioRegressionTesting\\src\\test\\resources\\minta_csv_ingatlan_hozzarendeles_v1.2.7.csv");
        return this;
    }

    //click
    public AdatfeltoltesPage clickOnFeltoltesBtn(){
        waitUtil.waitAndClick(feltoltesBtn);
        return this;
    }

    public AdatfeltoltesPage clickOnModositasBtn(){
        waitUtil.waitAndClick(modositasBtn);
        return this;
    }

    //select
    public AdatfeltoltesPage selectAdattablaFromDropDown(String adattabla){
        waitUtil.waitAndClick(adattablaDropDown);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+adattabla+"']"));
        return this;
    }
}
