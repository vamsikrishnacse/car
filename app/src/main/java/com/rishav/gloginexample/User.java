package com.rishav.gloginexample;

import com.google.android.material.textfield.TextInputLayout;

public class User {

    public String fullname,username,email,phone,gender,date,balance;
    public User(){

    }

    public User(String fullname, String username, String email,String phone,String gender,String date,String balance){
        this.fullname=fullname;
        this.username=username;
        this.email=email;
        this.phone=phone;
        this.gender=gender;
        this.date=date;
        this.balance=balance;
    }

}
