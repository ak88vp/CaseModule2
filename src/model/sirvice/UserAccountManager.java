package model.sirvice;

import model.AccountUser;

public interface UserAccountManager<A> extends Manager<AccountUser>{
    int find (String userName);
    void sortDate();
}
