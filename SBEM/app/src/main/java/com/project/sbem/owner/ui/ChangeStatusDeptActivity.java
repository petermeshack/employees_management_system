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
import com.project.sbem.UpdateUserInfo;
import com.project.sbem.data.model.DatabaseHelper;

public class ChangeStatusDeptActivity extends AppCompatActivity {
    EditText dept_id,dep_name,dep_date;
    Button save_changes;
    String dept_id_ch,dep_name_ch,dep_date_ch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_status_dept);

        dept_id = findViewById(R.id.dept_id);
        dep_name = findViewById(R.id.dept_name);
        dep_date = findViewById(R.id.dept_date);
        save_changes = findViewById(R.id.bt_savechanges);

        setUpdateInfo();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(dept_id_ch);
        }

        save_changes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper db = new DatabaseHelper(ChangeStatusDeptActivity.this);
                //try {
                    db.updateDataDepatment(
                            dept_id.getText().toString(),
                            dept_id.getText().toString(),
                            dep_name.getText().toString(),
                    dep_date.getText().toString());
                  //  Toast.makeText(ChangeStatusDeptActivity.this, "Success entering data", Toast.LENGTH_SHORT).show();
                //}catch (Exception e){
                 //   Toast.makeText(ChangeStatusDeptActivity.this, "Error entering data", Toast.LENGTH_SHORT).show();
                //}
            }
        });

    }
    void setUpdateInfo(){
        if(getIntent().hasExtra("id") &&
        getIntent().hasExtra("department_name")&&
        getIntent().hasExtra("department_start")
        ){
            dept_id_ch = getIntent().getStringExtra("id");
            dep_name_ch = getIntent().getStringExtra("department_name");
            dep_date_ch= getIntent().getStringExtra("department_start");

            dept_id.setText(dept_id_ch);
            dep_name.setText(dep_name_ch);
            dep_date.setText(dep_date_ch);

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