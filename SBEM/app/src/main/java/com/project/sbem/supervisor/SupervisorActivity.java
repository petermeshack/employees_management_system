package com.project.sbem.supervisor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.project.sbem.R;
import com.project.sbem.data.model.AllocateDuties;
import com.project.sbem.data.model.DatabaseHelper;
import com.project.sbem.data.model.DepartmentModel;
import com.project.sbem.owner.ui.CreateDepartmentActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class SupervisorActivity extends AppCompatActivity {
    EditText WORK_Duty_ID,duty_name,duty_start_date,duty_end_date;
    Button save_duties;
    AllocateDuties allocateDuties;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisor);
        WORK_Duty_ID = findViewById(R.id.empid);
        duty_name =findViewById(R.id.duty_name);;
        duty_start_date =findViewById(R.id.duty_startdate);
        duty_end_date=findViewById(R.id.duty_enddate);
        save_duties = findViewById(R.id.save_duties);

        save_duties.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    allocateDuties = new AllocateDuties(
                            -1,
                            WORK_Duty_ID.getText().toString(),
                            duty_name.getText().toString(),
                            duty_start_date.getText().toString(),
                            duty_end_date.getText().toString()
                    );
                    Toast.makeText(SupervisorActivity.this, "duties Added", Toast.LENGTH_SHORT).show();

                }catch (Exception e){
                    allocateDuties = new AllocateDuties(-1,"work_Duty_id", "D_name", "00/00/0000","00/00/0000");
                    Toast.makeText(SupervisorActivity.this, "Error entering data", Toast.LENGTH_SHORT).show();

                }
                // instance of offline database
                DatabaseHelper helper = new DatabaseHelper(SupervisorActivity.this);
                // helper.addOne(employeesModel);
                boolean testsuccess = helper.addOneDuty(allocateDuties);
                Toast.makeText(SupervisorActivity.this, "Sucess"+testsuccess, Toast.LENGTH_SHORT).show();

            }
        });

        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_sup_profile, R.id.nav_sup_leaves, R.id.nav_sup_duties)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);



    }
}