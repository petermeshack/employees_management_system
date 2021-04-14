package com.project.sbem.data.model;

public class AllocateDuties {
    int duty_id;
    String work_Duty_id;
    String duty_Name;
    String duty_start_date;
    String duty_end_date;

    public AllocateDuties(int duty_id, String work_Duty_id, String duty_Name, String duty_start_date, String duty_end_date) {
        this.duty_id = duty_id;
        this.work_Duty_id = work_Duty_id;
        this.duty_Name = duty_Name;
        this.duty_start_date = duty_start_date;
        this.duty_end_date = duty_end_date;
    }


    public int getDuty_id() {
        return duty_id;
    }

    public void setDuty_id(int duty_id) {
        this.duty_id = duty_id;
    }

    public String getWork_Duty_id() {
        return work_Duty_id;
    }

    public void setWork_Duty_id(String work_Duty_id) {
        this.work_Duty_id = work_Duty_id;
    }

    public String getDuty_Name() {
        return duty_Name;
    }

    public void setDuty_Name(String duty_Name) {
        this.duty_Name = duty_Name;
    }

    public String getDuty_start_date() {
        return duty_start_date;
    }

    public void setDuty_start_date(String duty_start_date) {
        this.duty_start_date = duty_start_date;
    }

    public String getDuty_end_date() {
        return duty_end_date;
    }

    public void setDuty_end_date(String duty_end_date) {
        this.duty_end_date = duty_end_date;
    }
}
