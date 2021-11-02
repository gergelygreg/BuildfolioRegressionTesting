package hu.fonixit.buildfolio.autotest.pages;

import hu.fonixit.buildfolio.autotest.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import hu.fonixit.buildfolio.autotest.base.BasePage;

public class LoginPage extends BasePage {   //id, kigyűjteni ahol nincs id
    private final By usernameFld = By.id("login-username");
    private final By passwordFld = By.id("login-password");
    private final By belepesBtn = By.cssSelector(".btn.btn-primary.btn-submit.sign-in");
    private final By header = By.cssSelector("div[class='col-12 mb-5'] h3");
    private final By felugroAblakSzöveg = By.cssSelector(".h5.mt-4");
    private  final By felugroAblakOkBtn = By.cssSelector("button[class='btn btn-primary']");
    private final By alertMessage = By.cssSelector(".alert-danger.p-2.mt-3");

    public LoginPage(WebDriver driver){
        super(driver);
    } //util file-ba sendKeys, BasePage protected

    public LoginPage load(){
        load("");
        return this;
    }

    public LoginPage enterTextInUsernameFld(String username){
       wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFld)).sendKeys(username);
        //waitAndSendkeys(usernameFld, username);
       // WaitUtil.waitAndSendkeys(usernameFld, username);
        return this;
    }

    public LoginPage enterTextInPasswordFld(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFld)).sendKeys(password);
        return this;
    }

    public String headerSuccessNotice(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(header)).getText();
    }

    public String errorMessageText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(felugroAblakSzöveg)).getText();
    }

    public LoginPage clickOnErrorMessageOkBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(felugroAblakOkBtn)).click();
        return this;
    }

    public String alertMessageText(){
        //return waitAndGetText(alertMessage);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(alertMessage)).getText();
        //return WaitUtil.waitAndGetText(alertMessage);
    }



    public DashboardPage belepes(){ //explicit wait használata
        wait.until((ExpectedConditions.elementToBeClickable(belepesBtn))).click();
       // waitAndClick(belepesBtn);
        return new DashboardPage(driver);
    }


}
