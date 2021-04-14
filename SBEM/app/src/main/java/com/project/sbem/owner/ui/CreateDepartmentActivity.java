package com.project.sbem.owner.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.sbem.R;
import com.project.sbem.data.model.DatabaseHelper;
import com.project.sbem.data.model.DepartmentModel;
import com.project.sbem.data.model.EmployeesModel;

public class CreateDepartmentActivity extends AppCompatActivity {
    EditText  WORK_D_ID,Department_name,Department_creatio_date;
    Button save_dept;
    DepartmentModel departmentModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_department);
        WORK_D_ID = findViewById(R.id.dept_id);
        Department_name = findViewById(R.id.dept_name);
        Department_creatio_date = findViewById(R.id.dept_create_date);
        save_dept = findViewById(R.id.save_dpt_info);



        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        save_dept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    departmentModel = new DepartmentModel(
                            -1,
                            WORK_D_ID.getText().toString(),
                            Department_name.getText().toString(),
                            Department_creatio_date.getText().toString()
                    );
                    Toast.makeText(CreateDepartmentActivity.this, "department Added", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    departmentModel = new DepartmentModel(-1,"work_D_id", "D_name", "00/00/0000");
                    Toast.makeText(CreateDepartmentActivity.this, "Error entering data", Toast.LENGTH_SHORT).show();
                }
                // instance of offline database
                DatabaseHelper helper = new DatabaseHelper(CreateDepartmentActivity.this);
                // helper.addOne(employeesModel);
                boolean testsuccess = helper.addOneDepartment(departmentModel);
                Toast.makeText(CreateDepartmentActivity.this, "Sucess"+testsuccess, Toast.LENGTH_SHORT).show();

            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}