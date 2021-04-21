package com.project.sbem.data.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

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


    public static final String LEAVES = "LEAVES_TABLE";
    public static final String COLUMN_LEAVES_ID = "ID";
    public static final String COLUMN_WorkLEAVES_ID = "WorkLEAVE_ID";
    public static final String COLUMN_LEAVES_NAME = "LEAVES_NAME";
    public static final String COLUMN_LEAVES_START_DATE = "LEAVES_START_DATE";
    public static final String COLUMN_LEAVES_END_DATE = "LEAVES_END_DATE";
    private Context context;


    public DatabaseHelper(@Nullable Context context) {
        super(context, "employees_edb.db", null, 1);
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

        String Create_table_LEAVES = " CREATE TABLE " + LEAVES + "("
                + COLUMN_LEAVES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_WorkLEAVES_ID + " TEXT,"
                + COLUMN_LEAVES_NAME + " TEXT,"
                + COLUMN_LEAVES_START_DATE + " TEXT,"
                + COLUMN_LEAVES_END_DATE + " TEXT )";

        db.execSQL(Create_table_Users);
        db.execSQL(Create_table_Departments);
        db.execSQL(Create_table_DUTIES);
        db.execSQL(Create_table_LEAVES);
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


    // ADD LEAVES
    public boolean addOneLEAVE(LeaveModel leaveModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_LEAVES_ID,leaveModel.getLeave_id());
        cv.put(COLUMN_WorkLEAVES_ID,leaveModel.getWork_leave_id());
        cv.put(COLUMN_LEAVES_NAME,leaveModel.getLeave_Name());
        cv.put(COLUMN_LEAVES_START_DATE,leaveModel.getLeave_start_date());
        cv.put(COLUMN_LEAVES_END_DATE,leaveModel.getLeave_end_date());
        long insert = db.insert(LEAVES, null, cv);
        if (insert == -1){
            return false;
        }else{
            return true;
        }
    }


    //////QUERIES
    public Cursor readAllData_employee(){
        String query = "SELECT * FROM " + USERS;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
           cursor = db.rawQuery(query,null);
        }
        return cursor;

     }
    public Cursor readAllData_employeeRoles(){
        String query = "SELECT * FROM " + USERS;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;

    }
    /*public void updateData(String row_id, String id_emp_up,String first_name_up,String last_name_up,String phone_emp_up,String email_emp_up,String department_emp_up,String role_emp_up,String salary_emp_up,String hiredate_emp_up){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_WORK_ID, id_emp_up);
        cv.put(COLUMN_FIRSTNAME, first_name_up);
        cv.put(COLUMN_LASTNAME, last_name_up);
        cv.put(COLUMN_MOBILENUMBER, phone_emp_up);
        cv.put(COLUMN_EMAIL, email_emp_up);
        cv.put(COLUMN_SALARY, salary_emp_up);
        cv.put(COLUMN_HIREDATE, hiredate_emp_up);
        cv.put(COLUMN_DEPARTMENT, department_emp_up);
        cv.put(COLUMN_ROLE, role_emp_up);
        long results = db.update(USERS,cv,"ID=?", new String[]{row_id});
        if(results == -1){
            //
        }else{
            //
        }

    }*/
    public void updateData(String id_row,String id_emp_up,String first_name_up,String last_name_up,String phone_emp_up,String email_emp_up,String department_emp_up,String role_emp_up,String salary_emp_up,String hiredate_emp_up){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_WORK_ID, id_emp_up);
        cv.put(COLUMN_FIRSTNAME, first_name_up);
        cv.put(COLUMN_LASTNAME, last_name_up);
        cv.put(COLUMN_MOBILENUMBER, phone_emp_up);
        cv.put(COLUMN_EMAIL, email_emp_up);
        cv.put(COLUMN_SALARY, salary_emp_up);
        cv.put(COLUMN_HIREDATE, hiredate_emp_up);
        cv.put(COLUMN_DEPARTMENT, department_emp_up);
        cv.put(COLUMN_ROLE, role_emp_up);
        long results = db.update(USERS,cv,"WORK_ID=?", new String[]{id_row});
        if(results == -1){
            //
        }else{
            //
        }

    }



    public Cursor readAllData_Department(){
        String query = "SELECT * FROM " + DEPARTMENTS;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;

    }
    public Cursor readAllData_Duty(){
        String query = "SELECT * FROM " + DUTIES;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;

    }
    public Cursor readAllData_Leave(){
        String query = "SELECT * FROM " + LEAVES;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;

    }



}
