package hu.fonixit.buildfolio.autotest.objects;

public class ADUser {

    private String username;
    private String password;

    public ADUser(){

    }

    public ADUser(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getADUsername() {
        return username;
    }

    public ADUser setADUsername(String username) {
        this.username = username;
        return  this;
    }

    public String getPassword() {
        return password;
    }

    public ADUser setPassword(String password) {
        this.password = password;
        return this;
    }


}
