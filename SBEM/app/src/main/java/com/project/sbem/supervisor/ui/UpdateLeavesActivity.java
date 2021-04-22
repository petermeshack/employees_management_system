package com.project.sbem.supervisor.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.sbem.R;
import com.project.sbem.UpdateUserInfo;
import com.project.sbem.data.model.DatabaseHelper;
import com.project.sbem.data.model.LeaveModel;
import com.project.sbem.owner.ui.HomeFragment;
import com.project.sbem.owner.ui.NewEmployeeActivity;

public class UpdateLeavesActivity extends AppCompatActivity {

    EditText txt_work_leave_id,txt_leave_Name,txt_leave_start_date,txt_leave_end_date;
    Button btn_grant_leave,btn_update_leave,btn_terminate_leave;
    LeaveModel leaveModel;
    String S_work_leave_id,S_leave_Name,S_leave_start_date,S_leave_end_date;
    DatabaseHelper db = new DatabaseHelper(UpdateLeavesActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_leaves);

        txt_work_leave_id = findViewById(R.id.leave_emp_id);
        txt_leave_Name = findViewById(R.id.leave_type);
        txt_leave_start_date = findViewById(R.id.leave_emp_start_date);
        txt_leave_end_date = findViewById(R.id.leave_emp_end_date);
        btn_grant_leave = findViewById(R.id.approuve_leave_employee);
        btn_update_leave = findViewById(R.id.update_leave_employee);
        btn_terminate_leave = findViewById(R.id.terminate_leave_employee);

        getSetIntetdata();
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(S_work_leave_id);
        }
        btn_grant_leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leaveModel = new LeaveModel(
                        -1,
                        txt_work_leave_id.getText().toString(),
                        txt_leave_Name.getText().toString(),
                        txt_leave_start_date.getText().toString(),
                        txt_leave_end_date.getText().toString()
                );
                if (txt_work_leave_id.getText().toString().isEmpty()||
                   txt_leave_Name.getText().toString().isEmpty()||
                  txt_leave_start_date.getText().toString().isEmpty()||
                  txt_leave_end_date.getText().toString().isEmpty()
                ){
                    Toast.makeText(UpdateLeavesActivity.this, "Please enter all data", Toast.LENGTH_SHORT).show();
                }else{
                    // instance of offline database
                    DatabaseHelper helper = new DatabaseHelper(UpdateLeavesActivity.this);
                    // helper.addOne(employeesModel);
                    boolean testsuccess = helper.addOneLEAVE(leaveModel);
                    Toast.makeText(UpdateLeavesActivity.this, "Sucess"+testsuccess, Toast.LENGTH_SHORT).show();
                    Toast.makeText(UpdateLeavesActivity.this, "info Added", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btn_update_leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    db.updateDataLeave(
                            txt_work_leave_id.getText().toString(),
                            txt_work_leave_id.getText().toString(),
                            txt_leave_Name.getText().toString(),
                            txt_leave_start_date.getText().toString(),
                            txt_leave_end_date.getText().toString()
                    );
                    Toast.makeText(UpdateLeavesActivity.this, "Success entering data", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(UpdateLeavesActivity.this, "Error entering data", Toast.LENGTH_SHORT).show();
                }
            }

        });

        btn_terminate_leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }
        });

    }
    void getSetIntetdata(){
        if(getIntent().hasExtra("id") &&
                getIntent().hasExtra("leave_type")&&
                getIntent().hasExtra("leave_start")&&
                getIntent().hasExtra("leave_end")
        ){
            S_work_leave_id=getIntent().getStringExtra("id");
            S_leave_Name=getIntent().getStringExtra("leave_type");
            S_leave_start_date=getIntent().getStringExtra("leave_start");
            S_leave_end_date=getIntent().getStringExtra("leave_end");


            txt_work_leave_id.setText(S_work_leave_id);
            txt_leave_Name.setText(S_leave_Name);
            txt_leave_start_date.setText(S_leave_start_date);
            txt_leave_end_date.setText(S_leave_end_date);


        }else{
            Toast.makeText(this, "no data", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete"+txt_work_leave_id.getText().toString()+"!");
        builder.setMessage("Are you sure");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                db.deleteOberowLeave(txt_work_leave_id.getText().toString());
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