package hu.fonixit.buildfolio.autotest.pages.components;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Oldalmeret extends BasePage {
    private final By lista = By.xpath("//select");

    public Oldalmeret(WebDriver driver){
        super(driver);
    }

    public Oldalmeret selectOldalmeret(String oldalmeret){
        waitUtil.waitAndClick(lista);
        waitUtil.waitAndClick(By.xpath("//select//option[contains(.,'"+oldalmeret+"')]"));
        return this;
    }

    public Oldalmeret megjelenoElemekATablazatban(String oldalmeret){
        try {
            selectOldalmeret(oldalmeret);
            List<WebElement> listaElemek = driver.findElements(By.xpath("//tr"));
            if (listaElemek.size() > Integer.parseInt(oldalmeret)){
                System.out.println("A rendezés nem működik helyesen");
            }
        }catch (NoSuchElementException e){
            System.out.println("A táblázatban nem található elem");
        }
        return this;
    }

}
