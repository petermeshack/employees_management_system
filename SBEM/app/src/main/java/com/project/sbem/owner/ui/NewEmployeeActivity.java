package com.project.sbem.owner.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.sbem.R;
import com.project.sbem.data.model.DatabaseHelper;
import com.project.sbem.data.model.EmployeesModel;

import java.util.List;

public class NewEmployeeActivity extends AppCompatActivity {

    EditText id_emp;
    EditText first_name;
    EditText last_name;
    EditText phone_emp;
    EditText email_emp;
    EditText department_emp;
    EditText role_emp;
    EditText salary_emp;
    EditText hiredate_emp;
    Button btn_save_emp;
    //ListView listemployees_emp;
    //ListView all_data_list;
    String id;
    DatabaseReference databaseEmployees;
    EmployeesModel employeesModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_employee);
        databaseEmployees = FirebaseDatabase.getInstance().getReference("EMPLOYEES");

        // reference to the controls
         id_emp = findViewById(R.id.emp_id);
         first_name = findViewById(R.id.emp_fname);
         last_name = findViewById(R.id.emp_lname);
         phone_emp = findViewById(R.id.emp_phoneno);
         email_emp = findViewById(R.id.emp_email);
         department_emp = findViewById(R.id.emp_department);
         role_emp = findViewById(R.id.emp_role);
         salary_emp = findViewById(R.id.emp_salary);
         hiredate_emp = findViewById(R.id.emp_hire_date);
         btn_save_emp = findViewById(R.id.save_employee);
         //listemployees_emp = findViewById(R.id.emp_employeelist);
         //all_data_list = findViewById(R.id.view_alldata_list);

         //DatabaseHelper helper = new DatabaseHelper(NewEmployeeActivity.this);
         //List<EmployeesModel> everyone = helper.getAllRecords();
        // ArrayAdapter employee_arrayAdapter = new ArrayAdapter<EmployeesModel>(NewEmployeeActivity.this, android.R.layout.simple_list_item_1,everyone);
         //all_data_list.setAdapter(employee_arrayAdapter);


        btn_save_emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{

                    employeesModel = new EmployeesModel(
                            -1,
                            id_emp.getText().toString(),
                            first_name.getText().toString(),
                            last_name.getText().toString(),
                            phone_emp.getText().toString(),
                            email_emp.getText().toString(),
                            salary_emp.getText().toString(),
                            hiredate_emp.getText().toString(),
                            department_emp.getText().toString(),
                            role_emp.getText().toString()
                    );
                    if(id_emp.getText().toString().isEmpty()||
                            first_name.getText().toString().isEmpty()||
                            last_name.getText().toString().isEmpty()||
                            phone_emp.getText().toString().isEmpty()||
                             email_emp.getText().toString().isEmpty()||
                            salary_emp.getText().toString().isEmpty()||
                            hiredate_emp.getText().toString().isEmpty()||
                            department_emp.getText().toString().isEmpty()||
                            role_emp.getText().toString().isEmpty()
                    ){
                        Toast.makeText(NewEmployeeActivity.this, "Please enter all data", Toast.LENGTH_SHORT).show();

                    }else{
                    // instance of offline database
                    DatabaseHelper helper = new DatabaseHelper(NewEmployeeActivity.this);
                        // helper.addOne(employeesModel);
                    boolean testsuccess = helper.addOneEmployee(employeesModel);
                    Toast.makeText(NewEmployeeActivity.this, "Sucess"+testsuccess, Toast.LENGTH_SHORT).show();
                    Toast.makeText(NewEmployeeActivity.this, "info ARCHIVED", Toast.LENGTH_SHORT).show();
                        archiveEmployeesOnline();

                        //give send notification
                        /*String message = "Data has been archived";
                        NotificationCompat.Builder builder = new NotificationCompat.Builder(
                                NewEmployeeActivity.this
                        ).setSmallIcon(R.drawable.ic_baseline_message_24)
                                .setContentTitle("New Notification")
                                .setContentText(message)
                                .setAutoCancel(true);
                        Intent intent = new Intent(NewEmployeeActivity.this, HomeFragment.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        //intent.putExtra("message",message);

                        PendingIntent pendingIntent = PendingIntent.getActivities(NewEmployeeActivity.this,0, new Intent[]{intent},PendingIntent.FLAG_UPDATE_CURRENT);
                        builder.setContentIntent(pendingIntent);

                        NotificationManager notificationManager = (NotificationManager)getSystemService(
                                Context.NOTIFICATION_SERVICE
                        );
                        notificationManager.notify(0,builder.build());*/

                    }

                }catch(Exception e){
                    employeesModel = new EmployeesModel(-1,"work_id", "f_name", "l_name", "0000000000","user@gmail.com", "00000000", "00/00/0000","department","role");
                    Toast.makeText(NewEmployeeActivity.this, "Error entering data", Toast.LENGTH_SHORT).show();
                    System.out.println("Could not parse " + Integer.getInteger(phone_emp.getText().toString()));
                }


            }
        });


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void archiveEmployeesOnline() {
        //getting the values to save

        //checking if the value is provided

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Artist
            String id = databaseEmployees.push().getKey();

            //creating an Artist Object
            employeesModel = new EmployeesModel(
                -1,
                id_emp.getText().toString(),
                first_name.getText().toString(),
                last_name.getText().toString(),
                phone_emp.getText().toString(),
                email_emp.getText().toString(),
                salary_emp.getText().toString(),
                hiredate_emp.getText().toString(),
                department_emp.getText().toString(),
                role_emp.getText().toString()
        );

            //Saving the Artist
            databaseEmployees.child(id).setValue(employeesModel);




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