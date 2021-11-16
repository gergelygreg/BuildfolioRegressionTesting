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
    private final By szamlakRiportBtn = By.xpath("(//button[@class='btn btn-primary mr-2 dashboard-report-button'][normalize-space()='Riport'])[1]");
    private final By szerzodesekRiportBtn = By.xpath("(//button[@class='btn btn-primary mr-2 dashboard-report-button'][normalize-space()='Riport'])[2]");
    //ingatlan portfólio dobozok
    private final By osszesIngatlanDoboz = By.xpath("//div[@class='portfolio-item all']");
    private final By berbeadottDoboz = By.xpath("(//div[@class='portfolio-item leasehold ng-star-inserted'])[1]");
    private final By bereltDoboz = By.xpath("//div[@class='portfolio-item rented ng-star-inserted']");
    private final By kiadatlanDoboz = By.xpath("//div[@class='portfolio-item unpublished ng-star-inserted']");
    private final By sajatHasznalatbanDoboz = By.xpath("//div[@class='portfolio-item own ng-star-inserted']");
    private final By hasznositatlanDoboz = By.xpath("//div[@class='portfolio-item unutilized ng-star-inserted']");
    //Riport futtatás ablak
    private final By fajlformatumDropDown = By.xpath("//div[@class='ng-select-container']//input[@role='combobox']");
    private final By futtatasBtn = By.xpath("//button[normalize-space()='Futtatás']");
    private final By megsemBtn = By.xpath("//button[normalize-space()='Mégsem']");
    private final By fajlformatumDropDownPDF = By.xpath("//div[@title='PDF']");
    private final By fajlformatumDropDownExcel = By.xpath("//div[@title='Excel']");
    //Riport letöltése ablak
    private final By riportLetolteseBtn = By.xpath("//button[normalize-space()='Riport letöltése']");
    //Tovább gombok
    private final By tovabbSzamlakBtn = By.xpath("//a[@href='/panel/invoices'][normalize-space()='Továbbiak']");
    private final By tovabbSzerzodesekBtn = By.xpath("(//a[@href='/panel/contracts'][normalize-space()='Továbbiak'])[1]");


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

    //Tovább gombra kattintás

    public DashboardPage clickOnTovabbSzamlakBtn(){
        wait.until((ExpectedConditions.elementToBeClickable(tovabbSzamlakBtn))).click();
        return this;
    }


    public DashboardPage clickOnTovabbSzerzodesekBtn(){
        wait.until((ExpectedConditions.elementToBeClickable(tovabbSzerzodesekBtn))).click();
        return this;
    }


    //riport letöltése ablak
    public DashboardPage clickOnRiportLetolteseBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(riportLetolteseBtn)).click();
        return this;
    }

    //riport futtatás ablak
    public boolean futtatasBtnKattinthato(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(futtatasBtn)).isEnabled();
    }

    public DashboardPage clickOnFuttatasBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(futtatasBtn)).click();
        return this;
    }

    public DashboardPage clickOnMegsemBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(megsemBtn)).click();
        return this;
    }

    public DashboardPage clickOnfajlformatumDropDown(){
        wait.until(ExpectedConditions.elementToBeClickable(fajlformatumDropDown)).click();
        return this;
    }

    public DashboardPage pdfFajlformRiportKivalasztasa(){
        clickOnfajlformatumDropDown();
        wait.until(ExpectedConditions.elementToBeClickable(fajlformatumDropDownPDF)).click();
        return this;
    }

    public DashboardPage excelFajlformRiportKivalasztasa(){
        clickOnfajlformatumDropDown();
        wait.until(ExpectedConditions.elementToBeClickable(fajlformatumDropDownExcel)).click();
        return this;
    }

    //szerepkor
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

    //panelek
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

    //riport gombok
    public DashboardPage clickOningatlanPortfolioRiportBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(ingatlanPortfolioRiportBtn)).click();
        return this;
    }

    public DashboardPage clickOnSzamlakRiportBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(szamlakRiportBtn)).click();
        return this;
    }

    public DashboardPage clickOnIngatlanokErtekeRiportBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(ingatlanokErtekeRiportBtn)).click();
        return this;
    }

    public DashboardPage clickOnSzerzodesekRiportBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(szerzodesekRiportBtn)).click();
        return this;
    }

    //ingatlan portfólio dobozok
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
