package hu.fonixit.buildfolio.autotest.pages.detailsPages.PartnerekDetailsPages;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import hu.fonixit.buildfolio.autotest.objects.UjPartnerAlapadatok;
import hu.fonixit.buildfolio.autotest.pages.IngatlanokPage;
import hu.fonixit.buildfolio.autotest.pages.PartnerekPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PartnerekDetailsAlapadatok extends BasePage {
    //gombok
    private final By adatokSzerkBtn = By.xpath("//button[contains(.,' Adatok szerkesztése ')]");
    private final By mentesBtn = By.xpath("//button[normalize-space()='Mentés']");
    private final By megsemBtn = By.xpath("//button[.=' Mégsem ']");
    //mezők
    private final By irSzamFld = By.xpath("(//app-text-input[@name='postCode'])[1]//input");
    private final By telepulesFld = By.xpath("//app-detail-section[@header='partners.details.data.titles.address']//app-text-input[@name='city']//input[@placeholder='Nincs megadva']");
    private final By kozterulNeveFld = By.xpath("(//app-text-input[@name='publicPlace'])[1]//input");
    private final By koztTipDropDown = By.xpath("(//input[@role='combobox'])[2]");
    private final By hazszamFld = By.xpath("(//app-text-input[@name='houseNumber'])[1]//input");
    private final By cegjegyzekszamFld = By.xpath("(//app-text-input[@name='partnerRegisterNumber'])[1]//input");

    public PartnerekDetailsAlapadatok(WebDriver driver) {
        super(driver);
    }

    //enter text
    public PartnerekDetailsAlapadatok enterTextToIrSzamFld(String irSzam){
        waitUtil.waitAndSendkeys(irSzamFld, irSzam);
        return this;
    }

    public PartnerekDetailsAlapadatok enterTextToTelepulesFld(String telepules){
        waitUtil.waitAndSendkeys(telepulesFld, telepules);
        return this;
    }

    public PartnerekDetailsAlapadatok enterTextToKoztNeveFld(String koztNeve){
        waitUtil.waitAndSendkeys(kozterulNeveFld, koztNeve);
        return this;
    }

    public PartnerekDetailsAlapadatok enterTextToHazSzamFld(String hazszam){
        waitUtil.waitAndSendkeys(hazszamFld, hazszam);
        return this;
    }

    public PartnerekDetailsAlapadatok enterTextToCegjegyzekszam(String cegjegyzSzam){
        waitUtil.waitAndSendkeys(cegjegyzekszamFld, cegjegyzSzam);
        return this;
    }

    //select
    public PartnerekDetailsAlapadatok selectElementFromKozteruletTipusaDropDown(String kozteruletTipusaAlap){
        waitUtil.waitAndSendkeys(koztTipDropDown, kozteruletTipusaAlap);
        waitUtil.waitAndClick(By.xpath("//div[@title='"+kozteruletTipusaAlap+"']"));
        driver.findElement(koztTipDropDown).sendKeys(Keys.ENTER);
        return this;
    }

    //click
    public PartnerekDetailsAlapadatok clickOnAdatokSzerkBtn(){
        waitUtil.waitAndClick(adatokSzerkBtn);
        return this;
    }

    public PartnerekDetailsAlapadatok clickOnMentesBtn(){
        waitUtil.waitAndClick(mentesBtn);
        return this;
    }

    public PartnerekDetailsAlapadatok clickOnMegsemBtn(){
        waitUtil.waitAndClick(megsemBtn);
        return this;
    }

    public PartnerekDetailsAlapadatok clickOnKozmucegChb(){
        waitUtil.waitAndClick(By.xpath("//label[contains(text(),'Közműcég')]"));
        return this;
    }

    //scroll-down
    public PartnerekDetailsAlapadatok scrollDownPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(mentesBtn));
        return this;
    }

    //clear txtfld
    public PartnerekDetailsAlapadatok clearHazszamTxtFld(){
        waitUtil.waitAndClearText(hazszamFld);
        return this;
    }

    //assert
    public boolean linkText(String linkText){
        try{
            waitUtil.waitForVisibility(By.xpath("//a[.='"+linkText+"']"));
        }
        catch (Exception e){

        }
        return true;
    }

    public String kozmucegTxtAlapadatok(){
       return waitUtil.waitAndGetText(By.xpath("//label[.=' Közműcég ']"));
    }

    public boolean kozmucegChbMegjelenik(){
       return waitUtil.elementIsDisplayed(By.xpath("//label[.=' Közműcég ']"));
    }

    public boolean kozmucegChboxpipaMegjelenik(){
        boolean ertek;
        try{
            waitUtil.waitForVisibility(By.xpath("//span[@class='icon-container checkbox-icon']"));
            ertek = true;
        }
        catch (Exception e ){
            ertek = false;
        }
        return ertek;
    }

    public boolean kozmucegFeliratMegjelenik() {
        boolean ertek;
        try{
            waitUtil.waitForVisibility(By.xpath("//label[.=' Közműcég ']"));
            ertek = true;
        }
        catch (Exception e ){
            ertek = false;
        }
        return ertek;
    }

    //set
    public PartnerekDetailsAlapadatok ujPartnerAlapadatok(UjPartnerAlapadatok ujPartnerAlapadatok){
        return enterTextToIrSzamFld(ujPartnerAlapadatok.getIranyitoszam()).
                enterTextToTelepulesFld(ujPartnerAlapadatok.getTelepules()).
                enterTextToKoztNeveFld(ujPartnerAlapadatok.getKozteruletNeve()).
                selectElementFromKozteruletTipusaDropDown(ujPartnerAlapadatok.getKozteruletTipusa()).
                enterTextToHazSzamFld(ujPartnerAlapadatok.getHazszam());
    }

}
