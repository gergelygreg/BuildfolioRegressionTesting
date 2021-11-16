package hu.fonixit.buildfolio.autotest.objects;

import hu.fonixit.buildfolio.autotest.base.BasePage;
import org.openqa.selenium.WebDriver;

public class UjIngatlanAlapadatok {
    private String koltseghelyAzonosito;
    private String email;
    private String telefonszam;
    private String epuletAlapterulete;
    private String epuletHaszonsTerulete;
    private String telekAlapterulete;
    private String ugyfelkiszolgalasAlapterulete;
    private String hasznositottBankuzemiTerulet;
    private String felelosVezeto;
    private String felelosVezetoTelefonszama;
    private String kulcsorzo;
    private String kulcsorzoTelefonszama;




    public UjIngatlanAlapadatok(){

    }

    public UjIngatlanAlapadatok(WebDriver driver, String koltseghelyAzonosito, String telefonszam, String epuletAlapterulete, String epuletHaszonsTerulete, String telekAlapterulete, String ugyfelkiszolgalasAlapterulete, String hasznositottBankuzemiTerulet, String felelosVezeto, String felelosVezetoTelefonszama, String kulcsorzo, String kulcsorzoTelefonszama, String email) {
        this.koltseghelyAzonosito = koltseghelyAzonosito;
        this.telefonszam = telefonszam;
        this.epuletAlapterulete = epuletAlapterulete;
        this.epuletHaszonsTerulete = epuletHaszonsTerulete;
        this.telekAlapterulete = telekAlapterulete;
        this.ugyfelkiszolgalasAlapterulete = ugyfelkiszolgalasAlapterulete;
        this.hasznositottBankuzemiTerulet = hasznositottBankuzemiTerulet;
        this.felelosVezeto = felelosVezeto;
        this.felelosVezetoTelefonszama = felelosVezetoTelefonszama;
        this.kulcsorzo = kulcsorzo;
        this.kulcsorzoTelefonszama = kulcsorzoTelefonszama;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getKoltseghelyAzonosito() {
        return koltseghelyAzonosito;
    }

    public String getTelefonszam() {
        return telefonszam;
    }

    public String getEpuletAlapterulete() {
        return epuletAlapterulete;
    }

    public String getEpuletHaszonsTerulete() {
        return epuletHaszonsTerulete;
    }

    public String getTelekAlapterulete() {
        return telekAlapterulete;
    }

    public String getUgyfelkiszolgalasAlapterulete() {
        return ugyfelkiszolgalasAlapterulete;
    }

    public String getHasznositottBankuzemiTerulet() {
        return hasznositottBankuzemiTerulet;
    }

    public String getFelelosVezeto() {
        return felelosVezeto;
    }

    public String getFelelosVezetoTelefonszama() {
        return felelosVezetoTelefonszama;
    }

    public String getKulcsorzo() {
        return kulcsorzo;
    }

    public String getKulcsorzoTelefonszama() {
        return kulcsorzoTelefonszama;
    }



}
