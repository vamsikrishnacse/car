package com.rishav.gloginexample;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class Changepass extends AppCompatActivity {

    private Button b2;
    private TextInputEditText et,et2;
    TextInputLayout password1,password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.changepass);
        password1 = findViewById(R.id.newpass);
        password2=findViewById(R.id.connewpass);
        et=findViewById(R.id.newpass2);
        et2=findViewById(R.id.connewpass2);
        b2 =findViewById(R.id.chpass) ;


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = et.getText().toString().trim();
                String val2 =et2.getText().toString().trim();
                if ( !validatePassword()) {
                    return;
                } else {
                Toast.makeText(Changepass.this, "SuccessFully Changed Password", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Changepass.this, Login.class);
                startActivity(i);}

            }
        });



    }
    private boolean validatePassword() {
        String val = et.getText().toString().trim();
        String val2 =et2.getText().toString().trim();
        String checkPassword = "[a-zA-Z0-9\\\\!\\\\@\\\\#\\\\$]{8,24}";

        if (val.isEmpty() && val2.isEmpty()) {
            password1.setError("Field can not be empty");
            password2.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkPassword)) {
            password1.setError("Password should contain atleast 8 characters!");

            return false;
        }else if(!val2.matches(checkPassword)){
            password2.setError("Password should contain atleast 8 characters!");
            return false;
        }else if(!val2.matches(val)){
            password2.setError("Re entered Password Not Matched with New password");
            return false;
        }

        else {
            password1.setError(null);
            password2.setError(null);
            password1.setErrorEnabled(false);
            password2.setErrorEnabled(false);
            return true;
        }
    }
}

