package hu.fonixit.buildfolio.autotest.base;

import hu.fonixit.buildfolio.autotest.utils.ConfigLoader;
import hu.fonixit.buildfolio.autotest.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WaitUtils waitUtil;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.waitUtil = new WaitUtils(new WebDriverWait(driver, 15));

    }

    public void load(String endPoint){
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);
    }


}
