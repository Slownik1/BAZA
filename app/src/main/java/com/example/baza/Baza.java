package com.example.baza;

import android.content.Context;
import android.database.sqlite.*;
import android.util.Log;
import android.database.*;

public class Baza {

    private SQLiteDatabase db;

    public static final String TABLE_ROW_ID = "_id";
    public static final String TABLE_ROW_NAME = "name";
    public static final String TABLE_ROW_SURENAME = "surname";
    public static final String TABLE_ROW_BIRTH_DATE = "birthDate";
    public static final String TABLE_ROW_PHONE = "Phone";

    public static final String DB_NAME ="adress_book.db";
    public static final int DB_VARSION =1;
    public static final String TABLE_N_AND_S = "namesAndSurenames";

    public Baza(MainActivity mainActivity) {
    }

    private class CustomSQLiteOpenHelper extends SQLiteOpenHelper{

        public CustomSQLiteOpenHelper(Context contex){
            super(contex, DB_NAME, null, DB_VARSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            String newTableQueryString = "CREATE TABLE "
                    +TABLE_N_AND_S+" ("
                    +TABLE_ROW_ID
                    +"integer PRIMARY KEY AUTOINCREMENT NOT NULL, "
                    +TABLE_ROW_NAME
                    +" text NOT NULL, "
                    +TABLE_ROW_SURENAME
                    +" text NOT NULL, "
                    +TABLE_ROW_BIRTH_DATE
                    +" text not null );";

            db.execSQL(newTableQueryString);

        }

        public void Baza(Context contex){

            CustomSQLiteOpenHelper helper = new CustomSQLiteOpenHelper(contex);
            db = helper.getWritableDatabase();

        }

        public void insert(String name, String surname, String birthDate, String phone){

            String query ="INSERY INTO "+ TABLE_N_AND_S + "("+
                    TABLE_ROW_NAME + ", " + TABLE_ROW_SURENAME+ ", "+TABLE_ROW_BIRTH_DATE
                    + ", "+ TABLE_ROW_PHONE +")"+
                    " VALUES ("+
                    "'"+ name +"'"+", "+"'"+surname+"'"+" ,"+"'"+birthDate+"'"+" ,"+phone+"');";
            Log.i("insert() = ", query);
            db.execSQL(query);

        }

        public void delete(String name){

            String query ="DELETE FROM " + TABLE_N_AND_S + "WHERE" + TABLE_ROW_NAME + " = '"+name+"';";
            Log.i("delete() = ", query);

        }

        public Cursor selectAll(){

            Cursor c =db.rawQuery("SELECT * FROM " +
                    TABLE_N_AND_S, null);
            return c;
        }

        public Cursor searchName(String name){

            String query = "SELECT * "+
                    "FROM " + "WHERE " +
                    TABLE_ROW_NAME +" = '"+name+"' ;";
            Log.i("searchName() =", query);
            Cursor c =db.rawQuery(query, null);

            return c;
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }

}
