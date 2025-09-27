package models;

public class LoginModel {
    // Attributes
    public String email;
    public String password;

    // Parameterized Constructor
    public LoginModel(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
