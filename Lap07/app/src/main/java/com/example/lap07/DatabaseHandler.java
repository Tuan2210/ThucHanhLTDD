package com.example.lap07;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "lap7NamesAndPlaces";
    
    private static final String TABLE_CONTACTS_NAME = "Names";
    private static final String KEY_ID_1 = "idName";
    private static final String KEY_NAME_1 = "name";

    private static final String TABLE_CONTACTS_PLACE = "Places";
    private static final String KEY_ID_2 = "idPlace";
    private static final String KEY_NAME_2 = "place";

    private static final String create_table_names = "CREATE TABLE " + TABLE_CONTACTS_NAME + "("
                                                    + KEY_ID_1 + " INTEGER PRIMARY KEY, " + KEY_NAME_1 + " TEXT" + ")"+"\n";
    private static final String create_table_places = "CREATE TABLE " + TABLE_CONTACTS_PLACE + "("
                                                    + KEY_ID_2 + " INTEGER PRIMARY KEY, " + KEY_NAME_2 + " TEXT " +","
                                                    + KEY_ID_1 + " INTEGER NOT NULL, "
                                                    + "FOREIGN KEY ("+KEY_ID_1+")"
                                                    + " REFERENCES " +TABLE_CONTACTS_NAME+ "("+KEY_ID_1+")" + ")";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
//        String create_table_names =
//                "CREATE TABLE " + TABLE_CONTACTS_NAME + "("
//                        + KEY_ID_1 + " INTEGER PRIMARY KEY, " + KEY_NAME_1 + " TEXT" + ")"
//        db.execSQL(create_table_names);

//        String create_table_places =
//                "CREATE TABLE " + TABLE_CONTACTS_PLACE + "("
//                + KEY_ID_2 + " INTEGER PRIMARY KEY, " + KEY_NAME_2 + " TEXT " +","
//                + KEY_ID_1 + " INTEGER NOT NULL, "
//                + "FOREIGN KEY ("+KEY_ID_1+")"
//                + " REFERENCES " +TABLE_CONTACTS_NAME+ "("+KEY_ID_1+")" + ")";

//        String create_all_tables = create_table_names.concat(create_table_places);

        db.execSQL(create_table_names);
        db.execSQL(create_table_places);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS_PLACE);

        // Create tables again
        onCreate(db);
    }

    // code to add the new name
    public void addName(Name name) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME_1, name.getName()); // Contact Name

        // Inserting Row
        db.insert(TABLE_CONTACTS_NAME, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    // code to get the single name
    Name getName(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS_NAME, new String[] { KEY_ID_1}, KEY_ID_1 + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Name name = new Name(Integer.parseInt(cursor.getString(0)), cursor.getString(1));
        return name;
    }

    // code to get all names in a list view
    public List<Name> getAllNames() {
        List<Name> nameList = new ArrayList<Name>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Name name = new Name();
                name.setId(Integer.parseInt(cursor.getString(0)));
                name.setName(cursor.getString(1));
                // Adding name to list
                nameList.add(name);
            } while (cursor.moveToNext());
        }

        // return contact list
        return nameList;
    }

    // code to update the single contact
//    public int updateName(Name name) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_NAME_1, name.getName());
//
//        // updating row
//        return db.update(TABLE_CONTACTS_NAME, values, KEY_ID_1 + " = ?",
//                new String[] { String.valueOf(name.getId()) });
//    }

    // Deleting single name
    public void deleteName(Name name) {
            SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS_NAME, KEY_ID_1 + " = ?",
                new String[] { String.valueOf(name.getId()) });
        db.close();
    }

    // Getting names Count
    public int getNamesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    ////////////////////////////////////////

//    public List<Place> getAllPlaces(Name name) {
    public List<Place> getAllPlaces(int nameId) {
        List<Place> placeList = new ArrayList<Place>();

//        String selectQuery = "SELECT "+KEY_NAME_2+" from "+TABLE_CONTACTS_PLACE+" " +
//                            "INNER JOIN "+TABLE_CONTACTS_NAME+" on Names.idName = Places.idName";
        String selectQuery = "SELECT idplace, place from Places " +
                             "INNER JOIN Names on Names.idName = places.idName " +
//                             "WHERE idName = " +name.getId()+ "";
                             "WHERE idName = " +nameId+ "";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Place place=new Place();
                place.setIdPlace(Integer.parseInt(cursor.getString(0)));
                place.setNamePlace(cursor.getString(1));

                placeList.add(place);
            } while (cursor.moveToNext());
        }

        // return contact list
        return placeList;
    }

    public void addPlace(Place place, int nameId) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME_2, place.getNamePlace());
        values.put(KEY_ID_1, nameId);

        db.insert(TABLE_CONTACTS_PLACE, null, values);

        db.close();
    }

    public void deletePlace(Place place) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS_PLACE, KEY_ID_2 + " = ?",
                new String[] { String.valueOf(place.getIdPlace()) });
        db.close();
    }

    public int updatePlace(Place place) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME_2, place.getNamePlace());

        // updating row
        return db.update(TABLE_CONTACTS_PLACE, values, KEY_ID_2 + " = ?",
                new String[] { String.valueOf(place.getIdPlace()) });
    }
}
