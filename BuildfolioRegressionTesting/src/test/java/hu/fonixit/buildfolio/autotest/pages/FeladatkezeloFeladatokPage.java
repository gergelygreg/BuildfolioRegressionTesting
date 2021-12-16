package hu.fonixit.buildfolio.autotest.pages;

import com.sun.xml.txw2.TypedXmlWriter;
import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FeladatkezeloFeladatokPage extends BasePage {
    private final By feladatokTab = By.xpath("//a[normalize-space()='Feladatok']");
    private final By munkafolyamatokTab = By.xpath("//a[normalize-space()='Munkafolyamatok']");

    public FeladatkezeloFeladatokPage (WebDriver driver){
        super(driver);
    }

    public FeladatkezeloFeladatokPage clickOnFeladatokTab(){
        waitUtil.waitAndClick(feladatokTab);
        return this;
    }

    public FeladatkezeloFeladatokPage clickOnMunkafolyamatokTab(){
        waitUtil.waitAndClick(munkafolyamatokTab);
        return this;
    }

    public FeladatkezeloFeladatokPage statuszDoneListaElso(){
        waitUtil.waitForVisibility(By.xpath("(//div[@class='icon-container done'])[1]"));
        return this;
    }

    public FeladatkezeloFeladatokPage statuszDoneListaUtolso(){
        waitUtil.waitForVisibility(By.xpath("(//div[@class='icon-container done'])[last()]"));
        return this;
    }

    public FeladatkezeloFeladatokPage feladatMegnevezeseEladasiArAListaban(String eladasiAr){
        waitUtil.waitForVisibility(By.xpath("td[2][contains(.,'"+eladasiAr+"')]"));
        return this;
    }

    public FeladatkezeloFeladatokPage azonositoAListaban(String azonosito){
        waitUtil.waitForVisibility(By.xpath("//td[2][contains(.,'"+azonosito+"')]"));
        return this;
    }

    public FeladatkezeloFeladatokPage feladatFeleloseAListaban(String feladatFelelose){
        waitUtil.waitForVisibility(By.xpath("//td[3][contains(.,'"+feladatFelelose+"')]"));
        return this;
    }

    public FeladatkezeloFeladatokPage munkafolyamatAListaban(String munkafolyamat){
        waitUtil.waitForVisibility(By.xpath("//td[4][contains(.,'"+munkafolyamat+"')]"));
        return this;
    }

}
