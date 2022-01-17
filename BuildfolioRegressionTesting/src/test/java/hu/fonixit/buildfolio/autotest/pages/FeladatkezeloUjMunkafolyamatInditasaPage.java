package hu.fonixit.buildfolio.autotest.pages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import hu.fonixit.buildfolio.autotest.pages.detailsPages.SzerzodesekDetailsPages.SzerzodesekDetailsSzerzodoPartnerek;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FeladatkezeloUjMunkafolyamatInditasaPage extends BasePage {
    private final By folyamatInditasaBtn = By.xpath("//button[.=' Folyamat indítása ']");
    private final By megsemBtn = By.xpath("//a[normalize-space()='Mégsem']");
    private final By berbeadasChbox = By.xpath("(//label[normalize-space()='Bérbeadás'])[1]");
    private final By berbevetelChbox = By.xpath("(//label[normalize-space()='Bérbevétel'])[1]");
    private final By eladasChbox = By.xpath("(//label[normalize-space()='Eladás'])[1]");
    private final By vetelChbox = By.xpath("(//label[normalize-space()='Vétel'])[1]");

    public FeladatkezeloUjMunkafolyamatInditasaPage(WebDriver driver) {
        super(driver);
    }

    //click
    public FeladatkezeloUjMunkafolyamatInditasaPage clickOnFolyamatInditasaBtn(){
        waitUtil.waitAndClick(folyamatInditasaBtn);
        return this;
    }

    public FeladatkezeloUjMunkafolyamatInditasaPage clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    public FeladatkezeloUjMunkafolyamatInditasaPage ingatlanKivalasztasa(){
        waitUtil.waitAndClick(By.xpath("//td[normalize-space()='xcbyxb']/ancestor::tr//td//app-checkbox//div//label"));
        return this;
    }

    public FeladatkezeloUjMunkafolyamatInditasaPage clickOnBerbeadasChbox(){
        waitUtil.waitAndClick(berbeadasChbox);
        return this;
    }

    public FeladatkezeloUjMunkafolyamatInditasaPage clickOnBerbevetelChbox(){
        waitUtil.waitAndClick(berbevetelChbox);
        return this;
    }

    public FeladatkezeloUjMunkafolyamatInditasaPage clickOnEladasChbox(){
        waitUtil.waitAndClick(eladasChbox);
        return this;
    }

    public FeladatkezeloUjMunkafolyamatInditasaPage clickOnVetelChbox(){
        waitUtil.waitAndClick(vetelChbox);
        return this;
    }

    //navigate to element
    public FeladatkezeloUjMunkafolyamatInditasaPage scrollUp() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        return this;
    }

    //select
    public FeladatkezeloUjMunkafolyamatInditasaPage selectCheckboxIngatlan(String ingatlanNeve, String tablaIndex){
        String tablazatElem = null;
        try {
            tablazatElem = waitUtil.waitAndGetText(By.xpath("//td["+tablaIndex+"][contains(.,'"+ingatlanNeve+"')]"));
            if (tablazatElem != null && tablazatElem.contains(ingatlanNeve)) {
                waitUtil.waitAndClick(By.xpath("//tr[contains(.,'"+ingatlanNeve+"')]//input"));
            }
            else {
                waitUtil.waitAndClick(By.xpath("//button[@class='btn next']"));
            }
        } catch (Exception e) {
        }
        return this;
    }
}
