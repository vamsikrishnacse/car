package com.rishav.gloginexample;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    TextView linktext, singtest;
    private TextInputEditText emails, passwords;
    Button login;
    String f = "hide";
    String f1 = "show";
    boolean checked = false;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        emails = findViewById(R.id.email2);
        passwords = findViewById(R.id.pass2);
        login = findViewById(R.id.bt1);
        mAuth = FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               emailValidat(emails,passwords);
                String email= emails.getText().toString().trim();
                String password=passwords.getText().toString().trim();
                if(checked) {
                    mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                        if(task.isSuccessful())
                        {
                            FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
                            if(user.isEmailVerified())
                            {
                            Toast.makeText(Login.this,
                                    "SuccessFully Loged In",
                                    Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Login.this, MainActivity2.class);
                            startActivity(i);
                            finish();}else{
                                user.sendEmailVerification();
                                Toast.makeText(Login.this,
                                        "Check your mail for verification and try to Register again",
                                        Toast.LENGTH_SHORT).show();
                        }
                        }
                        else
                        {
                            Toast.makeText(Login.this,
                                    "Please Check Your login Credentials",
                                    Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Login.this,MainActivity.class ));
                        }

                    });

                }
            }
        });

        singtest = findViewById(R.id.signup);
        singtest.setTextColor(Color.BLUE);
        singtest.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
        });


        linktext = findViewById(R.id.forget);
        linktext.setTextColor(Color.BLUE);
        linktext.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Forpass.class);
                startActivity(intent);
            }
        });

    }


    public void emailValidat(EditText emails, EditText passwords) {

        if(passwords.getText().toString().equals("") || emails.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Email and password should be filled", Toast.LENGTH_SHORT).show();
        }
        else {
            if (emails.getText().toString().trim().matches(emailPattern)) {
                checked = true;
            } else {
                Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
            }
        }



    }


}
