package com.example.lap08;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AccDAO {
    private DatabaseReference db;

    public AccDAO() {
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
        db = FirebaseDatabase.getInstance().getReference(Account.class.getSimpleName());
    }

    public Task<Void> addAccount(Account account){
        if (account != null)
            return db.push().setValue(account);
        return null;
    }
}



//SQLite
//import androidx.room.Dao;
//import androidx.room.Insert;
//import androidx.room.Query;
//
//import java.util.List;
//
//@Dao
//public interface AccDAO {
//    @Insert
//    public void insertAcc(Account account);
//
//    @Query("select * from acc_table where Email in (:userEmail)")
//    List<Account> loadAccByEmail(String userEmail);
//
//    @Query("select * from acc_table")
//    List<Account> loadAcc();
//}
