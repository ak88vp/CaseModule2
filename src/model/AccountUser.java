package model;

import java.time.LocalDateTime;

public class AccountUser {
    public static final String ANSI_CYAN = "\u001B[36m";
    private String userName;
    private String password;
    private LocalDateTime dateTime;

    public AccountUser() {
    }

    public AccountUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
        dateTime = LocalDateTime.now();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }



    @Override
    public String toString() {
        return String.format(ANSI_CYAN + "%-22s %-22s %-20s", userName, password, dateTime);
    }
}
