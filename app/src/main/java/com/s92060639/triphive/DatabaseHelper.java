package com.s92060639.triphive;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static String dbname = "TripHive";
    private static String tableName = "user";
    private static String idColumn = "id";
    private static String userNameColumn = "userName";
    private static String passwordNameColumn = "password";
    private static String nameColumn = "name";
    private static String phoneColumn = "phone";
    private static String emailColumn = "email";

    public DatabaseHelper(Context context){
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + tableName + "(" + idColumn + " integer primary key autoincrement, " +
                userNameColumn + " text, " +
                passwordNameColumn + " text, " +
                nameColumn + " text, " +
                phoneColumn + " int, " +
                emailColumn + " text " +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public boolean create(Account account){
        boolean result = true;
        try {
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(userNameColumn, account.getUsername());
            contentValues.put(passwordNameColumn, account.getPassword());
            contentValues.put(nameColumn, account.getFullName());
            contentValues.put(phoneColumn, account.getPhone());
            contentValues.put(emailColumn, account.getEmail());
            result = sqLiteDatabase.insert(tableName, null, contentValues) > 0;
        } catch (Exception e){
            result = false;
        }
        return result;
    }

    public boolean update(Account account){
        boolean result = true;
        try {
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(userNameColumn, account.getUsername());
            contentValues.put(passwordNameColumn, account.getPassword());
            contentValues.put(nameColumn, account.getFullName());
            contentValues.put(phoneColumn, account.getPhone());
            contentValues.put(emailColumn, account.getEmail());
            result = sqLiteDatabase.update(tableName, contentValues, idColumn + "=?",
                    new String[] { String.valueOf(account.getId()) }) > 0;
        } catch (Exception e){
            result = false;
        }
        return result;
    }

    public Account login(String username, String password){
        Account account = null;
        try {
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select * from " + tableName + " where username = ? and password = ?",
                    new String[] {username, password });
            if(cursor.moveToFirst()){
                account = new Account();
                account.setId(cursor.getInt(0));
                account.setUsername(cursor.getString(1));
                account.setPassword(cursor.getString(2));
                account.setFullName(cursor.getString(3));
                account.setPhone(cursor.getInt(4));
                account.setEmail(cursor.getString(5));

            }
        }catch (Exception e){
            account = null;
        }
        return account;
    }

    public Account find (int id){
        Account account = null;
        try {
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select * from " + tableName + " where id = ? ",
                    new String[] { String.valueOf(id) });
            if(cursor.moveToFirst()){
                account = new Account();
                account.setId(cursor.getInt(0));
                account.setUsername(cursor.getString(1));
                account.setPassword(cursor.getString(2));
                account.setFullName(cursor.getString(3));
                account.setPhone(cursor.getInt(4));
                account.setEmail(cursor.getString(5));

            }
        }catch (Exception e){
            account = null;
        }
        return account;
    }

    public Account checkUsername(String username){
        Account account = null;
        try {
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select * from " + tableName + " where username = ? ",
                    new String[] {username });
            if(cursor.moveToFirst()){
                account = new Account();
                account.setId(cursor.getInt(0));
                account.setUsername(cursor.getString(1));
                account.setPassword(cursor.getString(2));
                account.setFullName(cursor.getString(3));
                account.setPhone(cursor.getInt(4));
                account.setEmail(cursor.getString(5));

            }
        }catch (Exception e){
            account = null;
        }
        return account;
    }
}
