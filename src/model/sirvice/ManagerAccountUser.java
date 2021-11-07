package model.sirvice;
import model.AccountUser;
import java.util.ArrayList;
import java.util.Comparator;

public class ManagerAccountUser implements UserAccountManager<AccountUser> {
    ArrayList<AccountUser> listUserAccount;

    public ManagerAccountUser() {
        listUserAccount = new ArrayList<>();
        listUserAccount.add(new AccountUser("dung24","123123"));
        listUserAccount.add(new AccountUser("ak6688","123123"));
        listUserAccount.add(new AccountUser("c0821i1","123123"));
    }

    public ManagerAccountUser(ArrayList<AccountUser> listUserAccount) {
        this.listUserAccount = listUserAccount;
    }

    public ArrayList<AccountUser> getListUserAccount() {
        return listUserAccount;
    }

    public void setListUserAccount(ArrayList<AccountUser> listUserAccount) {
        this.listUserAccount = listUserAccount;
    }

    @Override
    public void add(AccountUser accountUser) {
        listUserAccount.add(accountUser);
    }

    @Override
    public void print() {
        for (AccountUser user :
                listUserAccount) {
            System.out.println(user);

        }
    }

    @Override
    public void edit(String name, AccountUser accountUser) {
        listUserAccount.set(find(name), accountUser);
        print();
    }
    public void editPassWord(String name, String newPass) {
        listUserAccount.get(find(name)).setPassword(newPass);
    }

    @Override
    public void delete(String name) {
        listUserAccount.remove(find(name));
        print();
    }

    public void findByName(String userName) {
        for (AccountUser accountUser : listUserAccount) {
            if (accountUser.getUserName().contains(userName)) {
                System.out.println(accountUser);
            }
        }

    }
    @Override
    public int find(String userName) {
        int index = -1;
        for (int i = 0; i < listUserAccount.size(); i++) {
            if (listUserAccount.get(i).getUserName().equals(userName)) {
                return i;
            }
        }
        return -1;

    }

    @Override
    public void sortDate() {
        listUserAccount.sort(Comparator.comparing(AccountUser::getDateTime));
        print();
    }
}
