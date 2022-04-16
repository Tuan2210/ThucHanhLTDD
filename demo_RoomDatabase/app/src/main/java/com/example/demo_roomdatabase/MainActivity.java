package com.example.demo_roomdatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.room.Room;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

//public class MainActivity extends AndroidViewModel {
public class MainActivity extends AppCompatActivity {

//    public MainActivity(@NonNull Application application) {
//        super(application);
//
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();

        User user1 = new User();
        user1.setFirstName("Tuan");
        user1.setLastName("Dinh");

        User user2 = new User();
        user2.setFirstName("Linh");
        user2.setLastName("Dinh Tran");

        Log.d("insert_user", "inserting...");
        db.userDao().insertAll(user1, user2);

        Log.d("read all users", "reading all users...");
        UserDao userDao = db.userDao();
        List<User> users = userDao.getAll();

        for(User user : users){
            String log = "id: " +user.getUid() +", first name: " +user.getFirstName() +", last name: " +user.getLastName();
            Log.d("info_users", log);
        }
    }
}