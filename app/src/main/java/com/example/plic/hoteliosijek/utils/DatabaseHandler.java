package com.example.plic.hoteliosijek.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.plic.hoteliosijek.model.Accommodation;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "appDB";

    // Accommodation table name
    private static final String TABLE_ACCOMMODATION = "accommodation";

    // Accommodation Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_CITY = "city";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_IMAGES = "images";
    private static final String KEY_RATING = "rating";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ACCOMMODATION_TABLE = "CREATE TABLE " + TABLE_ACCOMMODATION + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_ADDRESS + " TEXT,"+ KEY_CITY + " TEXT,"+ KEY_DESCRIPTION + " TEXT,"
                + KEY_IMAGE + " TEXT," + KEY_IMAGES + " TEXT," + KEY_RATING + " REAL)";
        db.execSQL(CREATE_ACCOMMODATION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCOMMODATION);

        // Create tables again
        onCreate(db);

    }

    //Check if table if empty
    public boolean emptyTable(){
        boolean empty=true;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cur = db.rawQuery("SELECT COUNT(*) FROM " + TABLE_ACCOMMODATION, null);
        if (cur != null && cur.moveToFirst()) {
            empty = (cur.getInt (0) == 0);
        }
        cur.close();

        return empty;
    }
    // Adding new accommodation
    public void addAccommodation(Accommodation accommodation) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, accommodation.getName());
        values.put(KEY_ADDRESS, accommodation.getAddress());
        values.put(KEY_CITY, accommodation.getCity());
        values.put(KEY_DESCRIPTION, accommodation.getDescription());
        values.put(KEY_IMAGE, accommodation.getImage());
        values.put(KEY_IMAGES, accommodation.getImages());
        values.put(KEY_RATING, accommodation.getRating());

        // Inserting Row
        db.insert(TABLE_ACCOMMODATION, null, values);
        db.close(); // Closing database connection
    }

    // Getting All Accommodations
    public List<Accommodation> getAllAccommodations() {
        List<Accommodation> accommodationList = new ArrayList<Accommodation>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ACCOMMODATION;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Accommodation accommodation = new Accommodation();
                accommodation.setId(Integer.parseInt(cursor.getString(0)));
                accommodation.setName(cursor.getString(1));
                accommodation.setAddress(cursor.getString(2));
                accommodation.setCity(cursor.getString(3));
                accommodation.setDescription(cursor.getString(4));
                accommodation.setImage(cursor.getString(5));
                accommodation.setImages(cursor.getString(6));
                accommodation.setRating(Float.parseFloat(cursor.getString(7)));
                // Adding accommodation to list
                accommodationList.add(accommodation);
            } while (cursor.moveToNext());
        }

        // return accommodation list
        return accommodationList;
    }
}
