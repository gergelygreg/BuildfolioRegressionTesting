package hu.fonixit.buildfolio.autotest.objects;

public class UjParkolo {
    private String parkoloTipusa;
    private String terulet;
    private String irSzam;
    private String varos;
    private String kozteruletNeve;
    private String kozteruletTipusa;
    private String hazszam;
    private String hrsz;

    public String getParkoloTipusa() {
        return parkoloTipusa;
    }

    public void setParkoloTipusa(String parkoloTipusa) {
        this.parkoloTipusa = parkoloTipusa;
    }

    public String getTerulet() {
        return terulet;
    }

    public void setTerulet(String terulet) {
        this.terulet = terulet;
    }

    public String getIrSzam() {
        return irSzam;
    }

    public void setIrSzam(String irSzam) {
        this.irSzam = irSzam;
    }

    public String getVaros() {
        return varos;
    }

    public void setVaros(String varos) {
        this.varos = varos;
    }

    public String getKozteruletNeve() {
        return kozteruletNeve;
    }

    public void setKozteruletNeve(String kozteruletNeve) {
        this.kozteruletNeve = kozteruletNeve;
    }

    public String getKozteruletTipusa() {
        return kozteruletTipusa;
    }

    public void setKozteruletTipusa(String kozteruletTipusa) {
        this.kozteruletTipusa = kozteruletTipusa;
    }

    public String getHazszam() {
        return hazszam;
    }

    public void setHazszam(String hazszam) {
        this.hazszam = hazszam;
    }

    public String getHrsz() {
        return hrsz;
    }

    public void setHrsz(String hrsz) {
        this.hrsz = hrsz;
    }


    public UjParkolo(){

    }

    public UjParkolo(String terulet, String irSzam, String varos, String kozteruletNeve, String kozteruletTipusa, String hazszam, String hrsz){
        this.terulet = terulet;
        this.irSzam = irSzam;
        this.varos = varos;
        this.kozteruletNeve = kozteruletNeve;
        this.kozteruletTipusa = kozteruletTipusa;
        this.hazszam = hazszam;
        this.hrsz = hrsz;
    }


}
