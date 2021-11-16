package hu.fonixit.buildfolio.autotest.base;

import hu.fonixit.buildfolio.autotest.utils.ConfigLoader;
//import hu.fonixit.buildfolio.autotest.utils.WaitUtils;
import hu.fonixit.buildfolio.autotest.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    //protected WaitUtils waitUtil;

 /*   public BasePage(WaitUtils waitUtil) {
        this.waitUtil = waitUtil;
    }*/

    public BasePage(WebDriverWait wait) {
        this.wait = wait;
    }

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
       // this.waitUtil = new WaitUtils(driver);

    }

    public void load(String endPoint){
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);
    }


}
