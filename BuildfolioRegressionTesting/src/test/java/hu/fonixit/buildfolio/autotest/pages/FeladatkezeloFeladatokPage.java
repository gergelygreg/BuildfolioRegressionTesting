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
        wait.until(ExpectedConditions.elementToBeClickable(feladatokTab)).click();
        return this;
    }

    public FeladatkezeloFeladatokPage clickOnMunkafolyamatokTab(){
        wait.until(ExpectedConditions.elementToBeClickable(munkafolyamatokTab)).click();
        return this;
    }

    public FeladatkezeloFeladatokPage statuszDoneListaElso(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='icon-container done'])[1]")));
        return this;
    }

    public FeladatkezeloFeladatokPage statuszDoneListaUtolso(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='icon-container done'])[last()]")));
        return this;
    }

    public FeladatkezeloFeladatokPage feladatMegnevezeseEladasiArAListaban(String eladasiAr){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("td[2][contains(.,'"+eladasiAr+"')]")));
        return this;
    }

    public FeladatkezeloFeladatokPage azonositoAListaban(String azonosito){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[2][contains(.,'"+azonosito+"')]")));
        return this;
    }

    public FeladatkezeloFeladatokPage feladatFeleloseAListaban(String feladatFelelose){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[3][contains(.,'"+feladatFelelose+"')]")));
        return this;
    }

    public FeladatkezeloFeladatokPage munkafolyamatAListaban(String munkafolyamat){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[4][contains(.,'"+munkafolyamat+"')]")));
        return this;
    }

}
