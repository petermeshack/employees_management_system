package com.example.employeems;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AddEmployee extends AppCompatActivity {
    private EditText Rfullname, Remail, Rcontacts, Rdepartments, Rjobtitle, Reducationallevel, Rage, Rnationality, Rstartdate, Rleavedate;
    private Button registerEmployees;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;

    private FirebaseFirestore fstore;
    private DatabaseReference rdatabase;
    private static final String USER = "employees";
    //private static final String TAG = ".AddEmployee";
    //private User user;
    String  userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        mAuth = FirebaseAuth.getInstance();
       // database = FirebaseDatabase.getInstance();
        //rdatabase = database.getReference(USER);
        fstore = FirebaseFirestore.getInstance();


        Rfullname = findViewById(R.id.RFullnamestxt);
        Remail = findViewById(R.id.Remailtxt);
        Rcontacts = findViewById(R.id.RContactstxt);
        Rdepartments = findViewById(R.id.RDepartmenttxt);
        Rjobtitle = findViewById(R.id.RJobtitletxt);
        Reducationallevel = findViewById(R.id.REducationlevaltxt);
        Rage = findViewById(R.id.RAgetxt);
        Rnationality = findViewById(R.id.RNationalitytxt);
        Rstartdate = findViewById(R.id.RStartdatetxt);
        Rleavedate = findViewById(R.id.RLeavelefttxt);
        registerEmployees = findViewById(R.id.registerEmployeesview);


        registerEmployees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String fullname = Rfullname.getText().toString();
                final String emailinput = Remail.getText().toString();
                final String contactinput = Rcontacts.getText().toString();
                final String department = Rdepartments.getText().toString();
                final String jobtitle = Rjobtitle.getText().toString();
                final String educationalleval = Reducationallevel.getText().toString();
                final String age = Rage.getText().toString();
                final String nationality = Rnationality.getText().toString();
                final String startdate = Rstartdate.getText().toString();
                final String leavedate = Rleavedate.getText().toString();



                if (TextUtils.isEmpty(fullname) ||
                        TextUtils.isEmpty(emailinput) ||
                        TextUtils.isEmpty(contactinput) ||
                        TextUtils.isEmpty(department) ||
                        TextUtils.isEmpty(jobtitle) ||
                        TextUtils.isEmpty(educationalleval) ||
                        TextUtils.isEmpty(age) ||
                        TextUtils.isEmpty(nationality) ||
                        TextUtils.isEmpty(startdate) ||
                        TextUtils.isEmpty(leavedate)) {

                    Toast.makeText(getApplicationContext(), "please fill everything", Toast.LENGTH_SHORT).show();

                }
                    mAuth.createUserWithEmailAndPassword(emailinput, contactinput).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                userID = Objects.requireNonNull(mAuth.getCurrentUser()).getUid();
                                DocumentReference documentReference = fstore.collection("employees").document(userID);
                                Map<String,Object> user = new HashMap<>();
                                user.put("fullname",fullname);
                                user.put("emailinput",emailinput);
                                user.put("contactinput",contactinput);
                                user.put("department",department);
                                user.put("jobtitle",jobtitle);
                                user.put("educationalleval",educationalleval);
                                user.put("age",age);
                                user.put("nationality",nationality);
                                user.put("startdate",startdate);
                                user.put("leavedate",leavedate);
                                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Toast toast = Toast.makeText(getApplicationContext(),
                                                "success", Toast.LENGTH_SHORT);
                                        toast.show();
                                        startActivity(new Intent(getApplicationContext(),
                                                LoginActivity.class));
                                    }
                                });

                            } else {
                                Toast toast = Toast.makeText(getApplicationContext(),
                                        "fail", Toast.LENGTH_SHORT);
                                toast.show();

                            }
                        }
                    });
            }
        });




    }

}
