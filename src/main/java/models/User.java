package models;

public class User {
    private String email;
    private String password;



    public User setEmail(String email) { // User withEmail - optional type
        this.email = email;
        return this;
    }

    public  User setPassword(String password) { //User withPassword
        this.password = password;
        return this;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
