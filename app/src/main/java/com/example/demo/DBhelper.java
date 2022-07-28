package com.example.demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;


/**
 * Handle the communications between the database and intents
 */
public class DBhelper extends SQLiteOpenHelper{

    private Context context;
    public static final String DATABASE_NAME="REC.db";//declaring database name
    public static final int DATABASE_VERSION= 1;
    /**
     * Declaring table properties
     */
    public static final String TABLE_NAME="health_condition";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_sis ="sis";
    public static final String COLUMN_di = "dia";
    public static final String COLUMN_hrate = "h_rate";
    public static final String COLUMN_date ="Date";
    public static final String COLUMN_time = "time";
    public static final String COLUMN_comment="comment";

    public DBhelper(@Nullable Context context) {
        super(context, TABLE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    /**
     * creating Table named "TABLE_NAME"
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
            String querry =
                    "Create table " + TABLE_NAME +" ( " + COLUMN_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT," +
                            COLUMN_sis +" Text,"+ COLUMN_di +" Text,"+ COLUMN_hrate +" Text,"+ COLUMN_date +" Text,"+ COLUMN_time +" Text,"+ COLUMN_comment +" Text );";
            db.execSQL(querry);
    }

    /**
     * initially drop table and create database
     * @param db
     * @param i
     * @param i1
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("DROP TABLE if EXISTS " +TABLE_NAME);
            onCreate(db);
    }

    /**
     * Add new row
     * @param sis
     * @param dia
     * @param h_rate
     * @param date
     * @param Comment
     * @param time
     */
    public void  addEntry(String sis,String dia, String h_rate, String date,String Comment ,String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_comment, Comment);
        cv.put(COLUMN_time, time);
        cv.put(COLUMN_sis, sis);
        cv.put(COLUMN_di, dia);
        cv.put(COLUMN_date, date);
        cv.put(COLUMN_hrate, h_rate);

        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "failed..!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added successfully..!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * read all rows from the database and load them into a Cursor
     * Then returns the Cursor
     * @return Cursor
     */
     public  Cursor readAllData(){
            String querry = "SELECT *FROM "+TABLE_NAME;
            SQLiteDatabase db =  this.getReadableDatabase();

            Cursor cursor = null;
            if(db!=null){
                cursor = db.rawQuery(querry,null);
            }
           return cursor;
        }

    /**
     * Update a row if exists
     * @param row_id
     * @param sis
     * @param dia
     * @param h_rate
     * @param date
     * @param Comment
     * @param time
     */
    void updateData(String row_id,String sis,String dia, String h_rate, String date,String Comment ,String time){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_comment, Comment);
        cv.put(COLUMN_time, time);
        cv.put(COLUMN_sis, sis);
        cv.put(COLUMN_di, dia);
        cv.put(COLUMN_date, date);
        cv.put(COLUMN_hrate, h_rate);

        System.out.println(row_id);

        long result = db.update(TABLE_NAME, cv, "id=?", new String[]{row_id});//table update query
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * Delete given row(One row delete only)
     * @param row_id
     */
    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * check if there is any entry for given date
     * @param id
     * @return
     */
    public Boolean checkData (String id){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String Query = "Select * from " + TABLE_NAME + " where " + id + " = " + id;
        Cursor cursor = sqLiteDatabase.rawQuery(Query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }
}
