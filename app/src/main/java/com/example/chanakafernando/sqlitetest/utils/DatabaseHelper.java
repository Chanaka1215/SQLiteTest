package com.example.chanakafernando.sqlitetest.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.chanakafernando.sqlitetest.models.School;
import com.example.chanakafernando.sqlitetest.models.Student;


/**
 * Created by Chanaka Fernando on 9/17/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    // Database Info
    private static final String DATABASE_NAME = "sqllitetest";
    private static final int DATABASE_VERSION = 1;

    // Table Names
    private static final String TABLE_STUDENT = "student";
    private static final String TABLE_SCHOOL = "school";

    // Student Table Columns
    private static final String STUDENT_PK = "id";
    private static final String STUDENT_INDEX_PK ="student_id";
    private static final String STUDENT_SCHOOL_ID_FK = "school_id";
    private static final String STUDENT_FIRST_NAME = "f_name";
    private static final String STUDENT_LAST_NAME = "l_name";
    private static final String STUDENT_EMAIL = "email";
    private static final String STUDENT_MOBILE = "mobile";

    // School Table Columns
    private static final String SCHOOL_PK = "id";
    private static final String SCHOOL_ID_PK = "school_id";
    private static final String SCHOOL_NAME = "school_name";
    private static final String SCHOOL_DISTRICT = "district";
    private static final String SCHOOL_TOTAL_STUDENT ="amount";

    private static DatabaseHelper sInstance;


    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_STUDENT_TABLE = "CREATE TABLE " + TABLE_STUDENT +
                "(" +
                STUDENT_PK + " INTEGER PRIMARY KEY," + // Define a primary key
                STUDENT_INDEX_PK + " TEXT UNIQUE," +
                STUDENT_SCHOOL_ID_FK + " INTEGER REFERENCES " + TABLE_SCHOOL + "," + // Define a foreign key
                STUDENT_FIRST_NAME + " TEXT, " +
                STUDENT_LAST_NAME + " TEXT, " +
                STUDENT_EMAIL + " TEXT, " +
                STUDENT_MOBILE + " TEXT " +
                ")";

        String CREATE_SCHOOL_TABLE = "CREATE TABLE " + TABLE_SCHOOL +
                "(" +
                //SCHOOL_PK + " INTEGER PRIMARY KEY," +
                SCHOOL_ID_PK + " INTEGER PRIMARY KEY, " +
                SCHOOL_NAME  + " TEXT UNIQUE, " +
                SCHOOL_DISTRICT + " TEXT, " +
                SCHOOL_TOTAL_STUDENT + " INTEGER " +
                ")";

        db.execSQL(CREATE_STUDENT_TABLE);
        db.execSQL(CREATE_SCHOOL_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCHOOL);
            onCreate(db);
        }

    }


    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    public static synchronized DatabaseHelper getInstance(Context context) {
        Log.i("helper","Initiated");
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }


    // Insert a School into the database
    public void addStudent(Student student) {
        Log.i("helper", "Access the method addStudent");
        SQLiteDatabase db = getWritableDatabase();

        db.beginTransaction();
        try {
            Log.i("helper", "Access the method try block of addStudent");
            long schoolId = getPkBySchoolName(student.getsSchoolName());
            ContentValues values = new ContentValues();
            values.put(STUDENT_INDEX_PK, student.getStudentId());
            values.put(STUDENT_SCHOOL_ID_FK, schoolId);
            values.put(STUDENT_FIRST_NAME, student.getFname());
            values.put(STUDENT_LAST_NAME, student.getlName());
            values.put(STUDENT_EMAIL, student.geteMail());
            values.put(STUDENT_MOBILE, student.getMobile());

            db.insertOrThrow(TABLE_STUDENT, null, values);
            db.setTransactionSuccessful();
            Log.i("helper", "finished Sucessfully the add student to database");

        } catch (Exception e) {
            Log.i("helper", "Error while trying to add student to database" + e);
        } finally {
            db.endTransaction();
            Log.i("helper", "finished the add student to database");
        }
    }


    public void addSchool(School school){
        // Create and/or open the database for writing
        Log.i("helper","access te addSchool method");
        SQLiteDatabase db = getWritableDatabase();

        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(SCHOOL_NAME, school.getsName());
            values.put(SCHOOL_DISTRICT, school.getDistrict());
            values.put(SCHOOL_TOTAL_STUDENT, school.getAmout());

            // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
            long key =db.insertOrThrow(TABLE_SCHOOL, null, values);
            Log.i("helper","the primary key"+ key);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.i("helper","School not successfully");
        } finally {
            db.endTransaction();
            Log.i("helper","School exit");
        }
    }

    public long getPkBySchoolName(String name) {
        long pk = -1;
        Log.i("helper", "Access the method getPkBySchoolName");
        SQLiteDatabase db = getWritableDatabase();
        String SCHOOL_SELECT_QUERY = String.format("SELECT %s FROM %s WHERE %s = ?", SCHOOL_ID_PK, TABLE_SCHOOL, SCHOOL_NAME);
        Cursor cursor = db.rawQuery(SCHOOL_SELECT_QUERY, new String[]{name});
        db.beginTransaction();
        try {
            Log.i("helper", "Acess the try block of getPkBySchoolName");
            if (cursor.moveToFirst()) {
                do {
                    pk = cursor.getLong(cursor.getColumnIndex(SCHOOL_ID_PK));
                    Log.i("helper", "Success the primary key  => " + pk);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.i("helper", "Error while trying to get posts from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            Log.i("helper", "Closed 11");
        }
        return pk;
    }
}
