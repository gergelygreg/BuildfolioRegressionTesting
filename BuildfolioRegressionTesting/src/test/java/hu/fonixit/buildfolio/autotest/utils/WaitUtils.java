
package hu.fonixit.buildfolio.autotest.utils;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import hu.fonixit.buildfolio.autotest.pages.components.Oldalmeret;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class WaitUtils {
    private WebDriverWait wait;

    public WaitUtils(WebDriverWait wait) {
        this.wait = wait;
    }

    public WebElement waitWebElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitAndSendkeys(By element, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(text);
    }

    public void waitAndSendNumbers(By element, int num){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(String.valueOf(num));
    }

    public void waitAndClick(By locator) {
        wait.until((ExpectedConditions.elementToBeClickable(locator))).click();
    }

    public String waitAndGetText(By element) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getText();
    }

    public void waitAndClearText(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element)).clear();
    }

    public boolean waitAndEnabled(By element) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element)).isEnabled();
    }

    public boolean elementIsDisplayed(By locator) {
        boolean ertek;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            ertek = true;
        } catch (Exception e) {
            ertek = false;
        }
        return ertek;
    }

    public boolean elementIsClickable(By locator) {
        boolean ertek;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            ertek = true;
        } catch (Exception e) {
            ertek = false;
        }
        return ertek;
    }

    public boolean elementIsDisplayedInTable(String elemNeve, String oldalmeret, String tablaOszlopa) {  //ha felvétel során a táblázat "1." sorába kerül felvételre az elem
        String tablazatElem = null;
        boolean ertek;
        do {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select"))).click();
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select//option[contains(.,'"+oldalmeret+"')]"))).click();
                tablazatElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td["+tablaOszlopa+"]"))).getText();
                if (tablazatElem != null && tablazatElem.contains(elemNeve)) {
                    ertek = true;
                }
                else {
                    ertek = false;
                }

            } catch (Exception e) {
                ertek = false;
            }

        } while (!tablazatElem.contains(elemNeve));
        return ertek;
    }

    public void selectElementFromTableOszlopKivalasztasaval(String elemNeve, String oldalmeret, String tablaOszlopa) {  //ha felvétel során a táblázat "1." sorába kerül felvételre az elem
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select//option[contains(.,'" + oldalmeret + "')]"))).click();
            String tablazatElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[" + tablaOszlopa + "]"))).getText();
            WebElement tablaElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[" + tablaOszlopa + "]")));
            if (tablazatElem.contains(elemNeve)) {
                tablaElement.click();
            }
        } catch (ElementClickInterceptedException e) {

        } catch (NoSuchElementException e) {

        }
    }

    public boolean radioBtnIsChecked(By element) {
        boolean ertek;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
            ertek = true;
        } catch (Exception e) {
            ertek = false;
        }
        return ertek;
    }

    public boolean fldIsNotEditable(By locator, String attribute) { //disabled attribute
        boolean ertek;
        String elem;
        try {
            WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            elem = e.getAttribute(attribute);
            if (elem != null) {
                ertek = true;
            } else {
                ertek = false;
            }
        } catch (Exception e) {
            ertek = false;
        }
        return ertek;
    }

    public boolean btnIsEditable(By locator, String attribute) {
        boolean ertek;
        String elem;
        try {
            WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            elem = e.getAttribute(attribute);
            if (elem != null) {
                ertek = true;
            } else {
                ertek = false;
            }
        } catch (Exception e) {
            ertek = false;
        }
        return ertek;
    }

    public boolean mezoSzerkesztheto(By locator) {
        boolean ertek;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isEnabled();
            ertek = true;
        } catch (Exception e) {
            ertek = false;
        }
        return ertek;
    }

    public boolean nincsMegjAdatFeliratMegj() {
        boolean ertek;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Nincs megjeleníthető adat.']")));
            ertek = true;
        } catch (Exception e) {
            ertek = false;
        }
        return ertek;
    }

    public boolean popupWindMegjelenik(String popupSzoveg) {
        boolean ertek;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alertdialog']['"+popupSzoveg+"']")));
            ertek = true;
        } catch (
                Exception e) {
            ertek = false;
        }
        return ertek;
    }

}
