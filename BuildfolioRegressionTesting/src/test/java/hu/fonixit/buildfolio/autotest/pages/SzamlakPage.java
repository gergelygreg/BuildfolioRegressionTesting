package hu.fonixit.buildfolio.autotest.pages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SzamlakPage extends BasePage {

    private final By ujSzamlaFelveteleBtn = By.xpath("//button[normalize-space()='Új számla felvétele']");

    public SzamlakPage (WebDriver driver){
        super(driver);
    }

    public boolean ujSzamlaFelveteleBtnKattinthato(){
       return wait.until(ExpectedConditions.visibilityOfElementLocated(ujSzamlaFelveteleBtn)).isEnabled();
    }
}
