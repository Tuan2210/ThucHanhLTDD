package com.example.lap08;//package com.example.lap08;
//
//import android.content.Context;
//
//import androidx.room.Database;
//import androidx.room.Room;
//import androidx.room.RoomDatabase;
//
//@Database(entities = {Account.class}, version = 1)
//public abstract class Acc_RoomDB extends RoomDatabase {
//    private static final String DATABASE_NAME="lap8_account.db";
//    private static Acc_RoomDB instance;
//    public abstract AccDAO accDAO();
//
//    public static synchronized Acc_RoomDB getInstance(Context context) {
//        if(instance==null){
//            instance = Room.databaseBuilder(context.getApplicationContext(), Acc_RoomDB.class, DATABASE_NAME)
//                    .allowMainThreadQueries().build();
//        }
//        return instance;
//    }
//}
