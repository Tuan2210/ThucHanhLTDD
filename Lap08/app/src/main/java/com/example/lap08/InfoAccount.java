package com.example.lap08;

import java.util.List;

public class InfoAccount {
    private static List<Account> accountList;
    private static GetInfoAccounts getInfoAccounts;

    public interface GetInfoAccounts{
        void infoAccounts(Account account);
    }

    public void setData(List<Account> accountList, GetInfoAccounts getInfoAccounts){
        this.accountList = accountList;
        this.getInfoAccounts = getInfoAccounts;
        notifyAll();
    }
}
