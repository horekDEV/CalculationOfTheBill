package ru.horekdev.calculationofthebill;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
}