package com.example.lap07_b_roomdb;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface NameDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Name name);

    @Delete
    void delete(Name name);
//    @Query("DELETE FROM name_table")
//    void deleteAll();

    @Update
    void update(Name name);

    @Query("select * from name_table")
    List<Name> getAllNames(); //ko dùng đc arraylist
}
