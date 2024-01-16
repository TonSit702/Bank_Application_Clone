package com.example.bcelone;

public class Model {
    private String username; // New field
    private String password; // New field
    private String Stitle;
    private String SDescription;
    private int Simage;
    private String Smoney; // New field
    private String fromAcc;
    public Model(String username, String password, String Stitle, String SDescription, int Simage, String Smoney, String fromAcc) {
        this.username = username;
        this.password = password;
        this.Stitle = Stitle;
        this.SDescription = SDescription;
        this.Simage = Simage;
        this.Smoney = Smoney;
        this.fromAcc = fromAcc;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    // Getters and Setters
    public String getStitle() {
        return Stitle;
    }

    public void setStitle(String Stitle) {
        this.Stitle = Stitle;
    }

    public String getSDescription() {
        return SDescription;
    }

    public void setSDescription(String SDescription) {
        this.SDescription = SDescription;
    }

    public int getSimage() {
        return Simage;
    }

    public void setSimage(int Simage) {
        this.Simage = Simage;
    }

    public String getSmoney() {
        return Smoney;
    }

    public void setSmoney(String Smoney) {
        this.Smoney = Smoney;
    }

    public String getFromAcc() {
        return fromAcc;
    }

    public void setFromAcc(String fromAcc) {
        this.fromAcc = fromAcc;
    }
}

