package com.example.employeemanagement.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.employeemanagement.model.EmployeeModel;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "EmployeeDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_EMPLOYEE = "employee";

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

//    private static final String KEY_ID = "id";
//    private static final String KEY_NAME = "name";
//    private static final String KEY_EMAIL = "email";
//    private static final String KEY_CELL_NO = "cellNo";
//    private static final String KEY_GENDER = "gender";
//    private static final String KEY_DEPARTMENT = "department";
//    private static final String KEY_JOININGDATE = "joiningDate";




    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//
//
//        String CREATE_EMPLOYEE_TABLE = "CREATE TABLE " + TABLE_EMPLOYEE + "("
//                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
//                + KEY_NAME + " TEXT,"
//                + KEY_EMAIL + " TEXT,"
//                + KEY_CELL_NO+" TEXT, "
//                + KEY_GENDER+ " TEXT, "
//                +KEY_DEPARTMENT + " TEXT, "
//                +KEY_JOININGDATE +" TEXT "
//                + ")";

        String emp_table="Create table employee(id INTEGER primary key AUTOINCREMENT,  name text, email text,cellNo text,gender text, department text, joiningDate text)";
        sqLiteDatabase.execSQL(emp_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE);
        onCreate(sqLiteDatabase);
    }

    public long addEmployee(EmployeeModel employee) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", employee.getName());
        values.put("email", employee.getEmail());
        values.put("cellNo", employee.getCellNo());
        values.put("gender", employee.getGender());
        values.put("department", employee.getDepartment());
        values.put("joiningDate", employee.getJoiningDate());
        long id = db.insert(TABLE_EMPLOYEE, null, values);
        db.close();
        return id;
    }



}
