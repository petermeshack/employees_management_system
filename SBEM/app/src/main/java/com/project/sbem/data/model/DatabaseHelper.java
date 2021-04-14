package com.project.sbem.data.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String USERS = "EMPLOYEES_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_WORK_ID = "WORK_ID";
    public static final String COLUMN_FIRSTNAME = "FIRSTNAME";
    public static final String COLUMN_LASTNAME = "LASTNAME";
    public static final String COLUMN_MOBILENUMBER = "MOBILENUMBER";
    public static final String COLUMN_EMAIL = "EMAIL";
    public static final String COLUMN_SALARY = "SALARY";
    public static final String COLUMN_HIREDATE = "HIREDATE";
    public static final String COLUMN_DEPARTMENT = " DEPARTMENT";
    public static final String COLUMN_ROLE = " ROLE";

    public static final String DEPARTMENTS = "DEPARTMENT_TABLE";
    public static final String COLUMN_D_ID = "ID";
    public static final String COLUMN_WorkD_ID = "WorkD_ID";
    public static final String COLUMN_DEPARTMENT_NAME = "DEPARTMENT_NAME";
    public static final String COLUMN_DEPARTMENT_CREATION_DATE = "CREATION_DATE";


    public static final String DUTIES = "DUTY_TABLE";
    public static final String COLUMN_DUTIES_ID = "ID";
    public static final String COLUMN_WorkDUTIES_ID = "WorkDUTY_ID";
    public static final String COLUMN_DUTY_NAME = "DUTY_NAME";
    public static final String COLUMN_START_DATE = "START_DATE";
    public static final String COLUMN_END_DATE = "END_DATE";


    public DatabaseHelper(@Nullable Context context) {
        super(context, "employees_M.db", null, 1);
    }

    // first time you access database object
    @Override
    public void onCreate(SQLiteDatabase db) {
        String Create_table_Users = "CREATE TABLE " + USERS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_WORK_ID + " TEXT ,"
                + COLUMN_FIRSTNAME + " TEXT ,"
                + COLUMN_LASTNAME + " TEXT ,"
                + COLUMN_MOBILENUMBER + " TEXT ,"
                + COLUMN_EMAIL + " TEXT ,"
                + COLUMN_SALARY + " TEXT ,"
                + COLUMN_HIREDATE + " TEXT ,"
                + COLUMN_DEPARTMENT + " TEXT ,"
                + COLUMN_ROLE + " TEXT )";

        String Create_table_Departments = " CREATE TABLE " + DEPARTMENTS + "("
                + COLUMN_D_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_WorkD_ID + " TEXT,"
                + COLUMN_DEPARTMENT_NAME + " TEXT,"
                + COLUMN_DEPARTMENT_CREATION_DATE + " TEXT )";


        String Create_table_DUTIES = " CREATE TABLE " + DUTIES + "("
                + COLUMN_DUTIES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_WorkDUTIES_ID + " TEXT,"
                + COLUMN_DUTY_NAME + " TEXT,"
                + COLUMN_START_DATE + " TEXT,"
                + COLUMN_END_DATE + " TEXT )";

        db.execSQL(Create_table_Users);
        db.execSQL(Create_table_Departments);
        db.execSQL(Create_table_DUTIES);
    }
    // evrytime db version changes or  you access database object
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // ADD EMPLOYEE
    public boolean addOneEmployee(EmployeesModel employeesModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_WORK_ID, employeesModel.getWork_id());
        cv.put(COLUMN_FIRSTNAME, employeesModel.getFirstName());
        cv.put(COLUMN_LASTNAME, employeesModel.getLastName());
        cv.put(COLUMN_MOBILENUMBER, employeesModel.getMobileNumber());
        cv.put(COLUMN_EMAIL, employeesModel.getEmail());
        cv.put(COLUMN_SALARY, employeesModel.getSalary());
        cv.put(COLUMN_HIREDATE, employeesModel.getHiredate());
        cv.put(COLUMN_DEPARTMENT, employeesModel.getDepartment());
        cv.put(COLUMN_ROLE, employeesModel.getRole());
        long insert = db.insert(USERS, null, cv);
        if (insert == -1){
            return false;
        }else{
            return true;
        }
    }

    // ADD DEPARTMENTS
    public boolean addOneDepartment(DepartmentModel departmentModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_D_ID, departmentModel.getDepartment_id());
        cv.put(COLUMN_WorkD_ID, departmentModel.getWork_D_id());
        cv.put(COLUMN_DEPARTMENT_NAME,departmentModel.getDepartment_Name());
        cv.put(COLUMN_DEPARTMENT_CREATION_DATE,departmentModel.getDepartment_creation_date());
        long insert = db.insert(DEPARTMENTS, null, cv);
        if (insert == -1){
            return false;
        }else{
            return true;
        }
    }

    // ADD DUTYS
    public boolean addOneDuty(AllocateDuties allocateDuties){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_DUTIES_ID,allocateDuties.getDuty_id());
        cv.put(COLUMN_WorkDUTIES_ID,allocateDuties.getWork_Duty_id());
        cv.put(COLUMN_DUTY_NAME,allocateDuties.getDuty_Name());
        cv.put(COLUMN_START_DATE,allocateDuties.getDuty_start_date());
        cv.put(COLUMN_END_DATE,allocateDuties.getDuty_end_date());
        long insert = db.insert(DUTIES, null, cv);
        if (insert == -1){
            return false;
        }else{
            return true;
        }
    }


    //////QUERIES

    public List<EmployeesModel> getAllRecords(){
        List <EmployeesModel> returnlist = new ArrayList<>();
        String queryallString = "SELECT * FROM " + USERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryallString, null);

        if(cursor.moveToFirst()){
            do{
                int employee_id = cursor.getInt(0);
                String employee_work_id = cursor.getString(1);
                String employee_firstName = cursor.getString(2);
                String employee_lastName= cursor.getString(3);
                String employee_mobileNumber= cursor.getString(4);
                String employee_email= cursor.getString(5);
                String employee_salary= cursor.getString(6);
                String employee_hiredate= cursor.getString(7);
                String employee_department= cursor.getString(8);
                String employee_role= cursor.getString(9);

                EmployeesModel employeesModel = new EmployeesModel(employee_id,employee_work_id,employee_firstName,employee_lastName,employee_mobileNumber,employee_email,employee_salary,employee_hiredate,employee_department,employee_role);
                returnlist.add(employeesModel);
            }while (cursor.moveToNext());

        }else{
            // returns to no items in the list
        }
        // relese db resorses
        cursor.close();
        db.close();
        return returnlist;
    }
}