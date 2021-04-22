package com.project.sbem.supervisor.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.sbem.R;
import com.project.sbem.data.model.AllocateDuties;
import com.project.sbem.data.model.DatabaseHelper;
import com.project.sbem.data.model.LeaveModel;
import com.project.sbem.owner.ui.HomeFragment;

public class AllocateDutiesActivity extends AppCompatActivity {
    EditText txt_work_duty_id,txt_duty_Name,txt_duty_start_date,txt_duty_end_date;
    Button btn_grant_duty,btn_update_duty;
    AllocateDuties  allocateDuties;
    String S_work_duty_id,S_duty_Name,S_duty_start_date,S_duty_end_date;
    DatabaseHelper db = new DatabaseHelper(AllocateDutiesActivity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allocate_duties);

        txt_work_duty_id = findViewById(R.id.duty_id);
        txt_duty_Name = findViewById(R.id.duty_name);
        txt_duty_start_date = findViewById(R.id.duty_startdate);
        txt_duty_end_date = findViewById(R.id.duty_enddate);
        btn_grant_duty = findViewById(R.id.save_duties);
        btn_update_duty = findViewById(R.id.reassign_duties);

        getSetIntetdata();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(S_work_duty_id);
        }

        btn_grant_duty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allocateDuties = new AllocateDuties(
                        -1,
                        txt_work_duty_id.getText().toString(),
                        txt_duty_Name.getText().toString(),
                        txt_duty_start_date.getText().toString(),
                        txt_duty_end_date.getText().toString()
                );
                if (txt_work_duty_id.getText().toString().isEmpty()||
                        txt_duty_Name.getText().toString().isEmpty()||
                        txt_duty_start_date.getText().toString().isEmpty()||
                        txt_duty_end_date.getText().toString().isEmpty()
                ){
                    Toast.makeText(AllocateDutiesActivity.this, "Please enter all data", Toast.LENGTH_SHORT).show();
                }else{
                    // instance of offline database
                    DatabaseHelper helper = new DatabaseHelper(AllocateDutiesActivity.this);
                    // helper.addOne(employeesModel);
                    boolean testsuccess = helper.addOneDuty(allocateDuties);
                    Toast.makeText(AllocateDutiesActivity.this, "Sucess"+testsuccess, Toast.LENGTH_SHORT).show();
                    Toast.makeText(AllocateDutiesActivity.this, "info Added", Toast.LENGTH_SHORT).show();

                }
            }
        });

        btn_update_duty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    db.updateDataDuty(
                            txt_work_duty_id.getText().toString(),
                            txt_work_duty_id.getText().toString(),
                            txt_duty_Name.getText().toString(),
                            txt_duty_start_date.getText().toString(),
                            txt_duty_end_date.getText().toString()
                    );
                    Toast.makeText(AllocateDutiesActivity.this, "Success entering data", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(AllocateDutiesActivity.this, "Error entering data", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    void getSetIntetdata(){
        if(getIntent().hasExtra("id") &&
                getIntent().hasExtra("duty_type")&&
                getIntent().hasExtra("duty_start")&&
                getIntent().hasExtra("duty_end")
        ){
            S_work_duty_id=getIntent().getStringExtra("id");
            S_duty_Name=getIntent().getStringExtra("duty_type");
            S_duty_start_date=getIntent().getStringExtra("duty_start");
            S_duty_end_date=getIntent().getStringExtra("duty_end");


            txt_work_duty_id.setText(S_work_duty_id);
            txt_duty_Name.setText(S_duty_Name);
            txt_duty_start_date.setText(S_duty_start_date);
            txt_duty_end_date.setText(S_duty_end_date);


        }else{
            Toast.makeText(this, "no data", Toast.LENGTH_SHORT).show();
        }
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