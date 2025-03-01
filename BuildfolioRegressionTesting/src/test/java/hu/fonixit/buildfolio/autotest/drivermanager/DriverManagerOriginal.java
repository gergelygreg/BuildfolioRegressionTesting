package hu.fonixit.buildfolio.autotest.drivermanager;

import hu.fonixit.buildfolio.autotest.constants.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverManagerOriginal {

    public WebDriver initializeDriver(String browser){
        WebDriver driver;
        switch (DriverType.valueOf(browser)) {
            case CHROME -> {
                WebDriverManager.chromedriver().cachePath("Drivers").setup();
                driver = new ChromeDriver();
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
                driver = new FirefoxDriver();
            }
            default -> throw new IllegalStateException("Invalid browser name: " + browser);
        }
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
}
