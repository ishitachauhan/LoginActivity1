package login.loginactivity1;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Settings;
import android.util.Log;
import android.widget.Button;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;


public class SQLlitehelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "contactsManager.";
    public static final String TABLE_NAME = "login_tb";
    public static final String FIRST_NAME = "fname";
    public static final String LAST_NAME = "lname";
    public static final String EMAIL = "email";
    public static final String USER_NAME = "username";
    public static final String PASSWORD = "password";
    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXIST " + TABLE_NAME + "(" +
                    FIRST_NAME + " TEXT," +
                    LAST_NAME + " TEXT," +
                    EMAIL + " TEXT," + USER_NAME + " TEXT," + PASSWORD + " TEXT)";

    public SQLlitehelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}



