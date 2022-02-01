
package hu.fonixit.buildfolio.autotest.utils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



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

    public void waitAndClick(By locator) {
        wait.until((ExpectedConditions.elementToBeClickable(locator))).click();
    }

    public String waitAndGetText(By element) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getText();
    }

    public void waitAndClearText(By element) {
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        e.sendKeys(Keys.CONTROL,"a", Keys.BACK_SPACE); //teljes input mező törlése
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

    public boolean elementIsDisplayedInTable(String elemNeve, String tablaIndex) {  //ha felvétel során a táblázat "1." sorába kerül felvételre az elem
        String tablazatElem = null;
        boolean ertek = false;
        do {
            try {
                tablazatElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[" + tablaIndex + "][contains(.,'" + elemNeve + "')]"))).getText();
                if (tablazatElem != null && tablazatElem.contains(elemNeve)) {
                    ertek = true;
                } else {
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='table-pager-next']//span[@class='icon-container']")));
                }
            } catch (Exception e) {
                return ertek = false;
            }

        } while (!tablazatElem.contains(elemNeve));
        return ertek;
    }

    public void selectElementFromTableOszlopKivalasztasaval(String elemNeve, String tablaIndex) {
        try {
            String tablazatElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td["+tablaIndex+"][contains(.,'"+elemNeve+"')]"))).getText();
            WebElement tablaElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td["+tablaIndex+"][contains(.,'"+elemNeve+"')]")));
            if (tablazatElem != null && tablazatElem.contains(elemNeve)) {
                tablaElement.click();
            }
            else {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='table-pager-next']//span[@class='icon-container']")));
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

    public boolean mezoSzerkesztheto(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isSelected();
        } catch (Exception e) {
            return false;
        }
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
