package com.rishav.gloginexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class Forpass extends AppCompatActivity {
    TextInputLayout email1;
    private TextInputEditText et;
    Button b1;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.forpass);

        email1 = findViewById(R.id.changeed1);
        et=findViewById(R.id.changeed2);
        b1 = (Button) findViewById(R.id.changepass1);
        auth = FirebaseAuth.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateEmail()){
                    return ;
                }else{
                    resetpassword();
                Intent intent = new Intent(Forpass.this, Login.class);
                startActivity(intent);
                finish();}


            }
        });
    }
    private void resetpassword(){
        String email=et.getText().toString().trim();

        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Forpass.this, "Check your mail to reset your password", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Forpass.this, "Try Again!something went wrong or check your registered mail ID", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private boolean validateEmail() {
        String val;
        val = et.getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String checkspaces = "^[+]?[0-9]{10,13}$";

        if (val.isEmpty()) {
            email1.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkEmail)&&!val.matches(checkspaces)) {
            email1.setError("Invalid Email or phone number !");
            return false;
        } else {
            email1.setError(null);
            email1.setErrorEnabled(false);
            return true;
        }
    }



}
