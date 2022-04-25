package com.example.lap08;

//@IgnoreExtraProperties
public class Account {
//    private int id;   //nếu register - login chỉ bằng realtime db, ko authentication thì cần id
    private String name;
    private String email;
    private String passWord;
    private int happy;
    private int normal;
    private int sad;

//    public Map<String, Boolean> stars = new HashMap<>();

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName( String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getHappy() {
        return happy;
    }

    public void setHappy(int happy) {
        this.happy = happy;
    }

    public int getNormal() {
        return normal;
    }

    public void setNormal(int normal) {
        this.normal = normal;
    }

    public int getSad() {
        return sad;
    }

    public void setSad(int sad) {
        this.sad = sad;
    }

    //    public Account(int id, String name, String email, String passWord) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.passWord = passWord;
//    }

    public Account(String name, String email, String passWord) {
        this.name = name;
        this.email = email;
        this.passWord = passWord;
    }

    public Account(String name, String email, String passWord, int happy, int normal, int sad) {
        this.name = name;
        this.email = email;
        this.passWord = passWord;
        this.happy = happy;
        this.normal = normal;
        this.sad = sad;
    }

    //    public Account(int id) {
//        this.id = id;
//    }

    public Account(String email) {
        this.email = email;
    }

    public Account(String email, String passWord) {
        this.email = email;
        this.passWord = passWord;
    }

    public Account() {
    }

//    @Exclude
//    public Map<String, Object> toMap() {
//        HashMap<String, Object> result = new HashMap<>();
//        result.put("id", id);
//        result.put("name", name);
//        result.put("email", email);
//        result.put("password", passWord);
//        result.put("stars", stars);
//
//        return result;
//    }

//@Entity(tableName = "acc_table")  //entity roomdb
//public class Account {
//    @PrimaryKey(autoGenerate = true)
//    @NonNull
//    private int id;
//
//    @NonNull
//    @ColumnInfo(name = "Name")
//    private String name;
//
//    @NonNull
//    @ColumnInfo(name = "Email")
//    private String email;
//
//    @NonNull
//    @ColumnInfo(name = "Password")
//    private String passWord;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    @NonNull
//    public String getName() {
//        return name;
//    }
//
//    public void setName(@NonNull String name) {
//       this.name = name;
//    }
//
//    @NonNull
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(@NonNull String email) {
//        this.email = email;
//    }
//
//    @NonNull
//    public String getPassWord() {
//        return passWord;
//    }
//
//    public void setPassWord(@NonNull String passWord) {
//        this.passWord = passWord;
//    }
//
////    public Account(int id, @NonNull String name, @NonNull String email, @NonNull String passWord) {
////        this.id = id;
////        this.name = name;
////        this.email = email;
////        this.passWord = passWord;
////    }
////
////    public Account(@NonNull String name, @NonNull String email, @NonNull String passWord) {
////        this.name = name;
////        this.email = email;
////        this.passWord = passWord;
////    }
////
////    public Account(@NonNull String email) {
////        this.email = email;
////    }
//
//
//    public Account(int id, String name, String email, String passWord) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.passWord = passWord;
//    }
//
//    public Account(String name, String email, String passWord) {
//        this.name = name;
//        this.email = email;
//        this.passWord = passWord;
//    }
//
//    public Account() {
//    }

}
