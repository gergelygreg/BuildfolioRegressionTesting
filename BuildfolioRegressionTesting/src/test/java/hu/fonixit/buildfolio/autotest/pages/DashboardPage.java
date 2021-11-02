package hu.fonixit.buildfolio.autotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import hu.fonixit.buildfolio.autotest.base.BasePage;

public class DashboardPage extends BasePage {
    private final By attekintesHeader = By.cssSelector("div[class='col'] h3");
    private final By szerepkorDropDown = By.cssSelector(".icon-container.ml-1");
    private final By userDropDown = By.xpath("(//div[@class='user-dropdown-inner'])[2]");
    private final By ingatlanPortfolioPanel = By.xpath("//h4[normalize-space()='Ingatlan portfólió']");
    private final By ingatlanokErtekePanel = By.xpath("//h4[normalize-space()='Ingatlanok értéke']");
    private  final By szamlakPanel = By.xpath("//h4[normalize-space()='Számlák']");
    private final By legutobbErtekesitettIngatlanokPanel = By.xpath("//input[@role='combobox']");
    private final By szerzodesekPanel = By.xpath("//h4[contains(text(),'Szerződések')]");
    //riport gomgok
    private final By ingatlanPortfolioRiportBtn = By.xpath("(//button[@class='btn btn-primary dashboard-report-button'][normalize-space()='Riport'])[1]");
    private final By ingatlanokErtekeRiportBtn = By.xpath("((//button[@class='btn btn-primary dashboard-report-button'][normalize-space()='Riport'])[2]");
    private final By szamlakErtekeRiportBtn = By.xpath("(//button[@class='btn btn-primary mr-2 dashboard-report-button'][normalize-space()='Riport'])[1]");
    private final By szerzodesekRiportBtn = By.xpath("(//button[@class='btn btn-primary mr-2 dashboard-report-button'][normalize-space()='Riport'])[2]");
    //ingatlan portfólio dobozok
    private final By osszesIngatlanDoboz = By.xpath("//div[@class='portfolio-item all']");
    private final By berbeadottDoboz = By.xpath("//div[@class='portfolio-item leasehold ng-star-inserted']");
    private final By bereltDoboz = By.xpath("//div[@class='portfolio-item rented ng-star-inserted']");
    private final By kiadatlanDoboz = By.xpath("//div[@class='portfolio-item unpublished ng-star-inserted']");
    private final By sajatHasznalatbanDoboz = By.xpath("//div[@class='portfolio-item own ng-star-inserted']");
    private final By hasznositatlanDoboz = By.xpath("//div[@class='portfolio-item unutilized ng-star-inserted']");

    public DashboardPage(WebDriver driver){
        super(driver);
    }

    public DashboardPage load(){
        load("panel/dashboard");
        return  this;
    }

    public String attekintesSuccessNotice(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(attekintesHeader)).getText();
    }


    public String szerepkorEllenorzes(){
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(userDropDown)).getText();
    }

    public DashboardPage clickOnSzerepkorDropDown(){
        wait.until(ExpectedConditions.elementToBeClickable(szerepkorDropDown)).click();
        return this;
    }

    public DashboardPage selectSzerepkor(String szerepkor){
        clickOnSzerepkorDropDown();
        WebElement szerepk = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+szerepkor+"')]")));
        szerepk.click();
        return this;
    }

    public DashboardPage ingatlanPortfolioPanelMegjelenik(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ingatlanPortfolioPanel));
        return this;
    }

    public DashboardPage ingatlanErtekePanelMegjelenik(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ingatlanokErtekePanel));
        return this;
    }

    public DashboardPage szamlakPanelMegjelenik(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(szamlakPanel));
        return this;
    }

    public DashboardPage legutobbErtekesitettIngatlanokPanelMegjelenik(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(legutobbErtekesitettIngatlanokPanel));
        return this;
    }

    public DashboardPage szerzodesekPanelMegjelenik(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(szerzodesekPanel));
        return this;
    }

    public DashboardPage clickOningatlanPortfolioRiportBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(ingatlanPortfolioRiportBtn)).click();
        return this;
    }

    public DashboardPage clickOnszamlakErtekeRiportBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(szamlakErtekeRiportBtn)).click();
        return this;
    }

    public DashboardPage clickOningatlanokErtekeRiportBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(ingatlanokErtekeRiportBtn)).click();
        return this;
    }

    public DashboardPage clickOnszerzodesekRiportBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(szerzodesekRiportBtn)).click();
        return this;
    }

    public DashboardPage osszesIngatlanDobozMegjelenik(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(osszesIngatlanDoboz));
        return this;
    }

    public DashboardPage berbeadottDobozMegjelenik(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(berbeadottDoboz));
        return this;
    }

    public DashboardPage bereltDobozMegjelenik(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(bereltDoboz));
        return this;
    }

    public DashboardPage kiadatlanDobozMegjelenik(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(kiadatlanDoboz));
        return this;
    }

    public DashboardPage sajatHasznalatbanDobozMegjelenik(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(sajatHasznalatbanDoboz));
        return this;
    }

    public DashboardPage hasznositatlanDobozMegjelenik(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(hasznositatlanDoboz));
        return this;
    }
}
