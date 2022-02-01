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
    private final By ingatlanokErtekeRiportBtn = By.id("dashboard-real-estate-bf-report");
    private final By szamlakRiportBtn = By.xpath("(//button[@class='btn btn-primary mr-2 dashboard-report-button'][normalize-space()='Riport'])[1]");
    private final By szerzodesekRiportBtn = By.xpath("(//button[@class='btn btn-primary mr-2 dashboard-report-button'][normalize-space()='Riport'])[2]");
    //ingatlan portfólio dobozok
    private final By osszesIngatlanDoboz = By.id("dashboard-portfolio-all");
    private final By berbeadottDoboz = By.id("dashboard-portfolio-leasehold");
    private final By bereltDoboz =  By.id("dashboard-portfolio-rented");
    private final By kiadatlanDoboz =  By.id("dashboard-portfolio-unpublished");
    private final By sajatHasznalatbanDoboz =  By.id("dashboard-portfolio-own");
    private final By hasznositatlanDoboz =  By.id("dashboard-portfolio-unutilized");
    //Riport futtatás ablak
    private final By fajlformatumDropDown = By.xpath("//div[@class='ng-select-container']//input[@role='combobox']");
    private final By futtatasBtn = By.xpath("//button[normalize-space()='Futtatás']");
    private final By megsemBtn = By.xpath("//button[normalize-space()='Mégsem']");
    private final By fajlformatumDropDownPDF = By.xpath("//div[@title='PDF']");
    private final By fajlformatumDropDownExcel = By.xpath("//div[@title='Excel']");
    //Riport letöltése ablak
    private final By riportLetolteseBtn = By.xpath("//button[normalize-space()='Riport letöltése']");
    //Tovább gombok
    private final By tovabbSzamlakBtn = By.xpath("//div//a[@id='dashboard-invoice-more-router-button']");
    private final By tovabbSzerzodesekBtn = By.xpath("//div//a[@id='dashboard-contract-bf-router-button']");


    public DashboardPage(WebDriver driver){
        super(driver);
    }

    public DashboardPage load(){
        load("panel/dashboard");
        return  this;
    }

    public String attekintesSuccessNotice(){
        return waitUtil.waitAndGetText(attekintesHeader);
    }

    //Tovább gombra kattintás

    public DashboardPage clickOnTovabbSzamlakBtn(){
        waitUtil.waitAndClick(tovabbSzamlakBtn);
        return this;
    }


    public DashboardPage clickOnTovabbSzerzodesekBtn(){
        waitUtil.waitAndGetText(tovabbSzerzodesekBtn);

        return this;
    }


    //riport letöltése ablak
    public DashboardPage clickOnRiportLetolteseBtn(){
        waitUtil.waitAndClick(riportLetolteseBtn);
        return this;
    }

    //riport futtatás ablak
    public boolean futtatasBtnKattinthato(){
        return waitUtil.waitAndEnabled(futtatasBtn);
    }

    public DashboardPage clickOnFuttatasBtn(){
        waitUtil.waitAndClick(futtatasBtn);
        return this;
    }

    public DashboardPage clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    public DashboardPage clickOnfajlformatumDropDown(){
        waitUtil.waitAndClick(fajlformatumDropDown);
        return this;
    }

    public DashboardPage pdfFajlformRiportKivalasztasa(){
        clickOnfajlformatumDropDown();
        waitUtil.waitAndClick(fajlformatumDropDownPDF);
        return this;
    }

    public DashboardPage excelFajlformRiportKivalasztasa(){
        clickOnfajlformatumDropDown();
        waitUtil.waitAndClick(fajlformatumDropDownExcel);
        return this;
    }

    //szerepkor
    public String szerepkorEllenorzes(){
        return waitUtil.waitAndGetText(userDropDown);
    }

    public DashboardPage clickOnSzerepkorDropDown(){
        waitUtil.waitAndClick(szerepkorDropDown);
        return this;
    }

    public DashboardPage selectSzerepkor(String szerepkor){
        clickOnSzerepkorDropDown();
        WebElement szerepk = waitUtil.waitWebElement(By.xpath("//span[contains(text(),'"+szerepkor+"')]"));
        szerepk.click();
        return this;
    }

    //panelek
    public DashboardPage ingatlanPortfolioPanelMegjelenik(){
        waitUtil.waitForVisibility(ingatlanPortfolioPanel);
        return this;
    }

    public DashboardPage ingatlanErtekePanelMegjelenik(){
        waitUtil.waitForVisibility(ingatlanokErtekePanel);
        return this;
    }

    public DashboardPage szamlakPanelMegjelenik(){
        waitUtil.waitForVisibility(szamlakPanel);
        return this;
    }

    public DashboardPage legutobbErtekesitettIngatlanokPanelMegjelenik(){
        waitUtil.waitForVisibility(legutobbErtekesitettIngatlanokPanel);
        return this;
    }

    public DashboardPage szerzodesekPanelMegjelenik(){
        waitUtil.waitForVisibility(szerzodesekPanel);
        return this;
    }

    //riport gombok
    public DashboardPage clickOningatlanPortfolioRiportBtn(){
        waitUtil.waitAndClick(ingatlanPortfolioRiportBtn);
        return this;
    }

    public DashboardPage clickOnSzamlakRiportBtn(){
        waitUtil.waitAndClick(szamlakRiportBtn);
        return this;
    }

    public DashboardPage clickOnIngatlanokErtekeRiportBtn(){
        waitUtil.waitAndClick(ingatlanokErtekeRiportBtn);
        return this;
    }

    public DashboardPage clickOnSzerzodesekRiportBtn(){
        waitUtil.waitAndClick(szamlakRiportBtn);
        return this;
    }

    //ingatlan portfólio dobozok
    public DashboardPage osszesIngatlanDobozMegjelenik(){
        waitUtil.waitForVisibility(osszesIngatlanDoboz);
        return this;
    }

    public DashboardPage berbeadottDobozMegjelenik(){
        waitUtil.waitForVisibility(berbeadottDoboz);
        return this;
    }

    public DashboardPage bereltDobozMegjelenik(){
        waitUtil.waitForVisibility(bereltDoboz);
        return this;
    }

    public DashboardPage kiadatlanDobozMegjelenik(){
        waitUtil.waitForVisibility(kiadatlanDoboz);
        return this;
    }

    public DashboardPage sajatHasznalatbanDobozMegjelenik(){
        waitUtil.waitForVisibility(sajatHasznalatbanDoboz);
        return this;
    }

    public DashboardPage hasznositatlanDobozMegjelenik(){
        waitUtil.waitForVisibility(hasznositatlanDoboz);
        return this;
    }
}
