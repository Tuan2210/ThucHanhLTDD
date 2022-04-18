package com.example.lap08;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "acc_table")
public class Account {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    @NonNull
    @ColumnInfo(name = "Name")
    private String name;

    @NonNull
    @ColumnInfo(name = "Email")
    private String email;

    @NonNull
    @ColumnInfo(name = "Password")
    private String passWord;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(@NonNull String passWord) {
        this.passWord = passWord;
    }

    public Account(int id, @NonNull String name, @NonNull String email, @NonNull String passWord) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passWord = passWord;
    }

    public Account(@NonNull String name, @NonNull String email, @NonNull String passWord) {
        this.name = name;
        this.email = email;
        this.passWord = passWord;
    }

    public Account(@NonNull String email) {
        this.email = email;
    }

    public Account() {
    }
}
