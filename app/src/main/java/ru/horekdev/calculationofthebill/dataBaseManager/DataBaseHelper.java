package ru.horekdev.calculationofthebill.dataBaseManager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    public DataBaseHelper(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, "reports", factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE reports(id INT PRIMARY KEY, message TEXT, email VARCHAR(34))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS reports");
        onCreate(db);
    }

    public void addReport(String email, String comment) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(email, comment);
        db.insert("reports", null, contentValues);
        db.close();
    }
}
