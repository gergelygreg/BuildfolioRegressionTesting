package hu.fonixit.buildfolio.autotest.pages.components;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.*;

import java.util.List;

public class Lapozo extends BasePage {
    public Lapozo(WebDriver driver) {
        super(driver);
    }

    //click
    public Lapozo clickOnNextArrow() {
        waitUtil.waitAndClick(By.xpath("//button[@class='btn next']"));
        return this;
    }

    public Lapozo clickOnLastArrow() {
        waitUtil.waitAndClick(By.xpath("//button[@class='btn last']"));
        return this;
    }

    public Lapozo clickOnPrevArrow() {
        waitUtil.waitAndClick(By.xpath("//button[@class='btn prev']"));
        return this;
    }

    public Lapozo clickOnFirstArrow() {
        waitUtil.waitAndClick(By.xpath("//button[@class='btn first']"));
        return this;
    }

    //metódusok
    public Lapozo megjelenoElemekSzamaATablazatban() {
        try {
            List<WebElement> tablaElemek = driver.findElements(By.xpath("//tr"));
            if (tablaElemek.size() < 25) {
                System.out.println("A táblázatban kevesebb, mint 25 elem található, a nyilak inaktívak");
            }
            else if (tablaElemek.size() == 25 && waitUtil.elementIsClickable(By.xpath("//button[@class='btn next']"))) {
                clickOnNextArrow();
                List<WebElement> tablaElemek2 = driver.findElements(By.xpath("//tr"));
                if (tablaElemek2.size() < 25) {
                    clickOnPrevArrow();
                } else if (tablaElemek2.size() == 25 && waitUtil.elementIsClickable(By.xpath("//button[@class='btn next']"))) {
                    clickOnNextArrow();
                    List<WebElement> tablaElemek3 = driver.findElements(By.xpath("//tr"));
                    if (tablaElemek3.size() < 25 || tablaElemek3.size() == 25) {
                        clickOnFirstArrow();
                    }
                }
            }
            else{
                System.out.println("HIBA");
            }
        } catch (NoSuchElementException e) {
            System.out.println("A táblázatban nem található elem");
        } catch (ElementClickInterceptedException e){
            System.out.println("A táblázatban összesen 25 elem van");
        }
        return this;
    }

}
