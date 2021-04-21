package com.project.sbem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.sbem.data.model.DatabaseHelper;
import com.project.sbem.data.model.EmployeesModel;
import com.project.sbem.owner.ui.NewEmployeeActivity;

import java.util.ArrayList;

public class UpdateUserInfo extends AppCompatActivity {
    EditText id_emp_update,first_name_update,last_name_update,phone_emp_update,email_emp_update,department_emp_update,role_emp_update, salary_emp_update, hiredate_emp_update;
    Button btn_update,btn_terminate;


    String id,id_emp_up,first_name_up,last_name_up,phone_emp_up,email_emp_up,department_emp_up,role_emp_up, salary_emp_up, hiredate_emp_up;
    DatabaseHelper db = new DatabaseHelper(UpdateUserInfo.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_info);

        id_emp_update =findViewById(R.id.update_emp_id);
        first_name_update=findViewById(R.id.update_emp_fname);
        last_name_update=findViewById(R.id.update_emp_lname);
        phone_emp_update=findViewById(R.id.update_emp_phoneno);
        email_emp_update=findViewById(R.id.update_emp_email);
        department_emp_update=findViewById(R.id.update_emp_department);
        role_emp_update=findViewById(R.id.update_emp_role);
        salary_emp_update=findViewById(R.id.update_emp_salary);
        hiredate_emp_update=findViewById(R.id.update_emp_hire_date);
        btn_update = findViewById(R.id.update_employee);
        btn_terminate = findViewById(R.id.terminate_employee);

        getSetIntetdata();
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(id_emp_up);
        }


        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              try {
                  db.updateData(
                          id_emp_update.getText().toString(),
                          id_emp_update.getText().toString(),
                          first_name_update.getText().toString(),
                          last_name_update.getText().toString(),
                          phone_emp_update.getText().toString(),
                          email_emp_update.getText().toString(),
                          department_emp_update.getText().toString(),
                          role_emp_update.getText().toString(),
                          salary_emp_update.getText().toString(),
                          hiredate_emp_update.getText().toString()
                  );
                  Toast.makeText(UpdateUserInfo.this, "Success entering data", Toast.LENGTH_SHORT).show();
              }catch (Exception e){
                  Toast.makeText(UpdateUserInfo.this, "Error entering data", Toast.LENGTH_SHORT).show();
              }
            }
        });
        btn_terminate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }
        });
    }
    void getSetIntetdata(){
        if(getIntent().hasExtra("id") &&
                getIntent().hasExtra("firstname")&&
                getIntent().hasExtra("lastname")&&
                getIntent().hasExtra("mobilenumber")&&
                getIntent().hasExtra("email")&&
                getIntent().hasExtra("salary")&&
                getIntent().hasExtra("hiredate")&&
                getIntent().hasExtra("department")&&
                getIntent().hasExtra("role")
        ){
                    id_emp_up=getIntent().getStringExtra("id");
                    first_name_up=getIntent().getStringExtra("firstname");
                    last_name_up=getIntent().getStringExtra("lastname");
                    phone_emp_up=getIntent().getStringExtra("mobilenumber");
                    email_emp_up=getIntent().getStringExtra("email");
                    salary_emp_up=getIntent().getStringExtra("salary");
                    hiredate_emp_up=getIntent().getStringExtra("hiredate");
                    department_emp_up=getIntent().getStringExtra("department");
                    role_emp_up=getIntent().getStringExtra("role");


            id_emp_update.setText(id_emp_up);
            first_name_update.setText(first_name_up);
            last_name_update.setText(last_name_up);
            phone_emp_update.setText(phone_emp_up);
            email_emp_update.setText(email_emp_up);
            department_emp_update.setText(department_emp_up);
            role_emp_update.setText(role_emp_up);
            salary_emp_update.setText(salary_emp_up);
            hiredate_emp_update.setText(hiredate_emp_up);


        }else{
            Toast.makeText(this, "no data", Toast.LENGTH_SHORT).show();
        }
    }
    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete"+id_emp_update.getText().toString()+"!");
        builder.setMessage("Are you sure");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                db.deleteOberowEmployee(id_emp_update.getText().toString());
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();

    }
}