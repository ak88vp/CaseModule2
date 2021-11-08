package model;

public class AccountAdmin {
    public static final String ANSI_CYAN = "\u001B[36m";
    private static final AccountAdmin instance = new AccountAdmin();

    private AccountAdmin() {
    }

    public static AccountAdmin getInstance() {
        return instance;
    }

    private static final String adminName = "admin";
    private String password = "123456";

    public AccountAdmin(String password) {
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

    @Override
    public String toString() {
        return String.format(ANSI_CYAN + "%-22s%-22s", getAdminName(), password);
    }
}
