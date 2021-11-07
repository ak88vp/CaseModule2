package model;

public class AccountAdmin {
    private static final String adminName="admin";
    private  String password="123456";

    public AccountAdmin() {
    }
    public AccountAdmin( String password) {
        this.password = password;
    }
    public String getAdminName() {
        return adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
