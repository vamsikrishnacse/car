package com.rishav.gloginexample;

import android.Manifest;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.telephony.SmsManager;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SignUp3rdClass extends AppCompatActivity {
    String st;
    private TextInputEditText et;
    CountryCodePicker country;
    TextInputLayout phone_number;
    Button next;
    public static int number;
    private FirebaseAuth auth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.signup3);
        next = findViewById(R.id.signup_next_button);
        country = findViewById(R.id.country_code_picker);
        et=findViewById(R.id.phone_number2);
        phone_number=findViewById(R.id.phone_number);
        auth=FirebaseAuth.getInstance();


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!validatePhoneNumber()){
                    return ;
                }


//                PhoneAuthProvider.getInstance().verifyPhoneNumber(
//                        "+91"+et.getText().toString(),
//                        60,
//                        TimeUnit.SECONDS,
//                        SignUp3rdClass.this,
//                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
//
//                            @Override
//                            public void onVerificationCompleted(@NotNull PhoneAuthCredential phoneAuthCredential) {
//                                next.setVisibility(view.VISIBLE);
//                            }
//
//                            @Override
//                            public void onVerificationFailed(@NotNull FirebaseException e) {
//                                next.setVisibility(view.VISIBLE);
//                                Toast.makeText(SignUp3rdClass.this,e.getMessage(),Toast.LENGTH_SHORT).show();
//                            }
//
//                            @Override
//                            public void onCodeSent(@NotNull String s,@NotNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
//                                next.setVisibility(view.VISIBLE);
//                                Intent intent = new Intent(SignUp3rdClass.this, Verifyotp.class);
//                                st= Objects.requireNonNull(et.getText()).toString();
//                                intent.putExtra("value",st);
//
//                                intent.putExtra("v11",name11);
//                                intent.putExtra("v22",userr11);
//                                intent.putExtra("v33",emai11);
//                                intent.putExtra("v44",pass11);
//                                intent.putExtra("v55",gender1);
//                                intent.putExtra("v66",date1);
//
//                                intent.putExtra("verification",s);
//                                startActivity(intent);
//                                finish();
//                            }
//                        }
//                );
                PhoneAuthOptions options =
                        PhoneAuthOptions.newBuilder(auth)
                                .setPhoneNumber("+91"+et.getText().toString())       // Phone number to verify
                                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                                .setActivity(SignUp3rdClass.this)                 // Activity (for callback binding)
                                .setCallbacks(mCallBack)          // OnVerificationStateChangedCallbacks
                                .build();
                PhoneAuthProvider.verifyPhoneNumber(options);

                auth.setLanguageCode("fr");




            }
        });
        mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {

                Toast.makeText(SignUp3rdClass.this,e.getMessage(),Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {

                Intent intent = new Intent(SignUp3rdClass.this, Verifyotp.class);
                st= Objects.requireNonNull(et.getText()).toString();
                intent.putExtra("value",st);
                String name11=getIntent().getExtras().getString("v1");
                String userr11=getIntent().getExtras().getString("v2");
                String emai11=getIntent().getExtras().getString("v3");
                String pass11=getIntent().getExtras().getString("v4");
                String gender1=getIntent().getExtras().getString("value5");
                String date1=getIntent().getExtras().getString("value6");
                intent.putExtra("v11",name11);
                intent.putExtra("v22",userr11);
                intent.putExtra("v33",emai11);
                intent.putExtra("v44",pass11);
                intent.putExtra("v55",gender1);
                intent.putExtra("v66",date1);

                intent.putExtra("verification",verificationId);
                startActivity(intent);
                finish();
            }
        };
    }






    private boolean validatePhoneNumber() {
        String val = et.getText().toString().trim();
        String checkspaces = "^[+]?[0-9]{10,13}$";
        if (val.isEmpty()) {
            phone_number.setError("Enter valid phone number");
            return false;
        } else if (!val.matches(checkspaces)) {
            phone_number.setError("No White spaces are allowed and not Valid!");
            return false;
        } else {
            phone_number.setError(null);
            phone_number.setErrorEnabled(false);
            return true;
        }
    }
}
