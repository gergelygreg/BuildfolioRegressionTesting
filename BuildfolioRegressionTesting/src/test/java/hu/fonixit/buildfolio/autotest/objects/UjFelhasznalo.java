package hu.fonixit.buildfolio.autotest.objects;

public class UjFelhasznalo {
    private String username;
    private String name;
    private String email;
    private String organisation;
    private String role;

    public UjFelhasznalo(){

    }
    public UjFelhasznalo(String username, String name, String email, String organisation, String role){
        this.username = username;
        this.name = name;
        this.email = email;
        this.organisation = organisation;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
