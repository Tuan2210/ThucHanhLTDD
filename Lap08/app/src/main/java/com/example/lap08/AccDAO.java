package com.example.lap08;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AccDAO {
    @Insert
    public void insertAcc(Account account);

    @Query("select * from acc_table where Email in (:userEmail)")
    List<Account> loadAccByEmail(String userEmail);

    @Query("select * from acc_table")
    List<Account> loadAcc();
}
