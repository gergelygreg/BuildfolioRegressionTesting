package hu.fonixit.buildfolio.autotest.objects;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.WebDriver;

public class UjMuszakiAdatok {
    private String epitesEve;
    private String utolsoFelujitasEve;
    private String kozmuvesitettseg;

    public UjMuszakiAdatok(){

    }

    public String getEpitesEve() {
        return epitesEve;
    }

    public String getUtolsoFelujitasEve() {
        return utolsoFelujitasEve;
    }

    public String getKozmuvesitettseg() {
        return kozmuvesitettseg;
    }


}
