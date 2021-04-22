package com.project.sbem.data.model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.sbem.R;
import com.project.sbem.supervisor.ui.AllocateDutiesActivity;
import com.project.sbem.supervisor.ui.UpdateLeavesActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AllocateDutiesAdapter extends RecyclerView.Adapter<AllocateDutiesAdapter.MyViewFolder>{
    Context context;
    ArrayList work_duty_id, duty_Name, duty_start_date, duty_end_date;

    public AllocateDutiesAdapter(Context context, ArrayList work_duty_id, ArrayList duty_Name, ArrayList duty_start_date, ArrayList duty_end_date) {
        this.context = context;
        this.work_duty_id = work_duty_id;
        this.duty_Name = duty_Name;
        this.duty_start_date = duty_start_date;
        this.duty_end_date = duty_end_date;
    }

    @NonNull
    @Override
    public MyViewFolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_duties,parent,false);
        return new AllocateDutiesAdapter.MyViewFolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewFolder holder, int position) {
        holder.text_work_duty_id.setText(String.valueOf(work_duty_id.get(position)));
        holder.text_duty_Name.setText(String.valueOf(duty_Name.get(position)));
        holder.text_duty_start_date.setText(String.valueOf(duty_start_date.get(position)));
        holder.text_duty_end_date.setText(String.valueOf(duty_end_date.get(position)));
        holder.linearLayout_duty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AllocateDutiesActivity.class);
                intent.putExtra("id",String.valueOf(work_duty_id.get(position)));
                intent.putExtra("duty_type",String.valueOf(duty_Name.get(position)));
                intent.putExtra("duty_start",String.valueOf(duty_start_date.get(position)));;
                intent.putExtra("duty_end",String.valueOf(duty_end_date.get(position)));
                context.startActivities(new Intent[]{intent});
            }
        });

    }

    @Override
    public int getItemCount() {
        return work_duty_id.size();
    }

    public class MyViewFolder extends RecyclerView.ViewHolder {
        TextView text_work_duty_id,text_duty_Name,text_duty_start_date,text_duty_end_date;
        LinearLayout linearLayout_duty;
        public MyViewFolder(@NonNull View itemView) {
            super(itemView);
                text_work_duty_id= itemView.findViewById(R.id.txt_duty_user_id);
                text_duty_Name= itemView.findViewById(R.id.txt_duty_name);
                text_duty_start_date= itemView.findViewById(R.id.txt_duty_start_date);
                text_duty_end_date= itemView.findViewById(R.id.txt_duty_end_date);
                linearLayout_duty = itemView.findViewById(R.id.my_row_duty_row);
            }
        }


}
