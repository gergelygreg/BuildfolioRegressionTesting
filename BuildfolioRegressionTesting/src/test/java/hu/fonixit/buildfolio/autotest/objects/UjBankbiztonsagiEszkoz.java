package hu.fonixit.buildfolio.autotest.objects;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.WebDriver;

public class UjBankbiztonsagiEszkoz {
    private String leltariSzam;
    private String eszkozcsoport;
    private String tipus;
    private String statusz;
    public UjBankbiztonsagiEszkoz() {

    }

    public String getLeltariSzam() {
        return leltariSzam;
    }

    public String getEszkozcsoport() {
        return eszkozcsoport;
    }

    public String getTipus() {
        return tipus;
    }

    public String getStatusz() {
        return statusz;
    }


}
