package hu.fonixit.buildfolio.autotest.pages;

import hu.fonixit.buildfolio.autotest.objects.ADUser;
import hu.fonixit.buildfolio.autotest.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import hu.fonixit.buildfolio.autotest.base.BasePage;

public class LoginPage extends BasePage {   //id, kigyűjteni ahol nincs id
    private final By usernameFld = By.id("login-username");
    private final By passwordFld = By.id("login-password");
    private final By belepesBtn = By.cssSelector(".btn.btn-primary.btn-submit.sign-in");
    private final By headerLetGazdRendsz = By.cssSelector("div[class='col-12 mb-5'] h3");
    private final By felugroAblakSzoveg = By.cssSelector(".h5.mt-4");
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
         waitUtil.waitAndSendkeys(usernameFld, username);
        return this;
    }

    public LoginPage enterTextInPasswordFld(String password){
        waitUtil.waitAndSendkeys(passwordFld, password);
        return this;
    }

    public String headerLetGazdRendSzoveg(){
        return waitUtil.waitAndGetText(headerLetGazdRendsz);
    }

    public String errorMessageText(){
        return waitUtil.waitAndGetText(felugroAblakSzoveg);
    }

    public LoginPage clickOnErrorMessageOkBtn(){
        waitUtil.waitAndClick(felugroAblakOkBtn);

        return this;
    }

    public String alertMessageText(){
        return waitUtil.waitAndGetText(alertMessage);
    }

    public DashboardPage belepes(){ //explicit wait használata
        waitUtil.waitAndClick(belepesBtn);
        return new DashboardPage(driver);
    }

   public DashboardPage doLogin(ADUser user) {
        return this.load()
                .enterTextInUsernameFld(user.getADUsername())
                .enterTextInPasswordFld(user.getPassword())
                .belepes();
    }

}
