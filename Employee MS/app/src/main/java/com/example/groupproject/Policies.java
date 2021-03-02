package com.example.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Policies extends AppCompatActivity {
    ImageView toHomep, toProfilep, toLeavesp, toPolicies;
    TextView Attandance,Prevention,Competiton,Perfomance,Reimbersement,ITAssets;

    long queueid;
    DownloadManager dAttandance,dPrevention,dCompetiton,dPerfomance,dReimbersement,dITAssets;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policies);

        Attandance = findViewById(R.id.Attandance_and_time_offtxt);
        Prevention = findViewById(R.id.HarassmentInfotxt);
        Competiton = findViewById(R.id.CompetitonInfotxt);
        Perfomance = findViewById(R.id.PerfomanceInfotxt);
        Reimbersement = findViewById(R.id.ReimbersementInfotxt);
        ITAssets = findViewById(R.id.ITnAssetsInfotxt);

        toHomep = findViewById(R.id.HomeIvp);
        toProfilep = findViewById(R.id.ProfileIvp);
        toLeavesp = findViewById(R.id.LeavesIvp);
        toPolicies = findViewById(R.id.PoliciesIvIvp);

        BroadcastReceiver receiver =new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(action)){
                    DownloadManager.Query request_query = new DownloadManager.Query();
                    request_query.setFilterById(queueid);

                    Cursor cursor = dPrevention.query(request_query);
                    Cursor cursor1 = dCompetiton.query(request_query);
                    Cursor cursor2 = dPerfomance.query(request_query);
                    Cursor cursor3 = dReimbersement.query(request_query);
                    Cursor cursor4 = dITAssets.query(request_query);

                    if(cursor.moveToFirst()){
                        int collumindex = cursor.getColumnIndex(DownloadManager.COLUMN_STATUS);
                        if(DownloadManager.STATUS_SUCCESSFUL == cursor.getInt(collumindex)){
                            Toast.makeText(Policies.this, "download complete", Toast.LENGTH_SHORT).show();
                        }
                    }

                    if(cursor1.moveToFirst()){
                        int collumindex = cursor.getColumnIndex(DownloadManager.COLUMN_STATUS);
                        if(DownloadManager.STATUS_SUCCESSFUL == cursor.getInt(collumindex)){
                            Toast.makeText(Policies.this, "download complete", Toast.LENGTH_SHORT).show();
                        }
                    }

                    if(cursor2.moveToFirst()){
                        int collumindex = cursor.getColumnIndex(DownloadManager.COLUMN_STATUS);
                        if(DownloadManager.STATUS_SUCCESSFUL == cursor.getInt(collumindex)){
                            Toast.makeText(Policies.this, "download complete", Toast.LENGTH_SHORT).show();
                        }
                    }

                    if(cursor3.moveToFirst()){
                        int collumindex = cursor.getColumnIndex(DownloadManager.COLUMN_STATUS);
                        if(DownloadManager.STATUS_SUCCESSFUL == cursor.getInt(collumindex)){
                            Toast.makeText(Policies.this, "download complete", Toast.LENGTH_SHORT).show();
                        }
                    }
                    if(cursor4.moveToFirst()){
                        int collumindex = cursor.getColumnIndex(DownloadManager.COLUMN_STATUS);
                        if(DownloadManager.STATUS_SUCCESSFUL == cursor.getInt(collumindex)){
                            Toast.makeText(Policies.this, "download complete", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        };
        registerReceiver(receiver,new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));


        Prevention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // starting new Async Task
                dPrevention = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse("https://github.com/petermeshack/employees_management_system/raw/main/policies/Sexual%20Harassment%20Policy.docx"));
                queueid = dPrevention.enqueue(request);

                Intent i = new Intent();
                i.setAction(DownloadManager.ACTION_VIEW_DOWNLOADS);
                startActivity(i);
            }
        });

        Competiton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // starting new Async Task
                dCompetiton = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse("https://github.com/petermeshack/employees_management_system/raw/main/policies/Benefits%20and%20Compensation%20Policies.docx"));
                queueid = dCompetiton.enqueue(request);

                Intent i = new Intent();
                i.setAction(DownloadManager.ACTION_VIEW_DOWNLOADS);
                startActivity(i);
            }
        });

        Perfomance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // starting new Async Task
                dPerfomance = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse("https://github.com/petermeshack/employees_management_system/raw/main/policies/Performance%20%20Policy.docx"));
                queueid = dPerfomance.enqueue(request);

                Intent i = new Intent();
                i.setAction(DownloadManager.ACTION_VIEW_DOWNLOADS);
                startActivity(i);
            }
        });

        Reimbersement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // starting new Async Task
                dReimbersement = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse("https://github.com/petermeshack/employees_management_system/raw/main/policies/EXPENSE%20REIMBURSEMENT%20POLICY.docx"));
                queueid = dReimbersement.enqueue(request);

                Intent i = new Intent();
                i.setAction(DownloadManager.ACTION_VIEW_DOWNLOADS);
                startActivity(i);
            }
        });

        ITAssets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // starting new Async Task
                dITAssets = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse("https://github.com/petermeshack/employees_management_system/raw/main/policies/IT%20and%20asset%20policy.docx"));
                queueid = dITAssets.enqueue(request);

                Intent i = new Intent();
                i.setAction(DownloadManager.ACTION_VIEW_DOWNLOADS);
                startActivity(i);
            }
        });


        toHomep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
        toProfilep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
        toLeavesp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
        toPolicies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });

    }

//
}