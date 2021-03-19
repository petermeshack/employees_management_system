package com.example.employeems;

public class User {
    public String fullname;
    public String email;
    public String contact;
    public String department;
    public String jobtitle;
    public String educationalleval;
    public String age;
    public String nationality;
    public String startdate;
    public String leavedate;


    public User() {

    }
    public User (String contact,String emailinput){
        this.email = emailinput;
        this.contact = contact;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public String getDepartment() {
        return department;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public String getEducationalleval() {
        return educationalleval;
    }

    public String getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public String getStartdate() {
        return startdate;
    }

    public String getLeavedate() {
        return leavedate;
    }

    public User (String fullname, String emailinput, String contact, String department, String jobtitle, String educationalleval, String age, String nationality, String startdate, String leavedate){
        this.fullname = fullname;
        this.email = emailinput;
        this.contact = contact;
        this.department = department;
        this.jobtitle = jobtitle;
        this.educationalleval = educationalleval;
        this.age = age;
        this.nationality = nationality;
        this.startdate = startdate;
        this.leavedate = leavedate;

    }

}
