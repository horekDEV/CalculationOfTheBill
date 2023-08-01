package ru.horekdev.calculationofthebill;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.sql.Connection;
import java.sql.Statement;

public class dataBaseManager extends SQLiteOpenHelper {
    private Context context;
    private static final String dataBaseName = "request.bd";
    private static final int dataBaseVersion = 1;

    private static final String TABLE_NAME = "my_requests";
    private static final String COLUMN_ID = "_id";
    private static final String REQUEST_AUTHOR = "request_author";
    private static final String REQUEST_AUTHOR_EMAIL = "request_email";
    private static final String REQUEST_AUTHOR_COMMENT = "request_comment";


    public dataBaseManager(@Nullable Context context) {
        super(context, dataBaseName, null, dataBaseVersion);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String db = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                REQUEST_AUTHOR + " TEXT, " +
                REQUEST_AUTHOR_EMAIL + " TEXT, " +
                REQUEST_AUTHOR_COMMENT + " TEXT); ";

        sqLiteDatabase.execSQL(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public void addRequest(String author, String email, String comment) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(REQUEST_AUTHOR, author);
        contentValues.put(REQUEST_AUTHOR_EMAIL, email);
        contentValues.put(REQUEST_AUTHOR_COMMENT, comment);

        long res = db.insert(TABLE_NAME, null, contentValues);

        if (res == -1) {
            Toast.makeText(context, "Ошибка, что-то пошло не так!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Ваш запрос отправлен, мы скоро рассмотрим его", Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor getRequest() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    public Cursor deleteAllRequests() {
        String queryDelete = "DROP TABLE " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(queryDelete, null);
        }

        return cursor;
    }
}
