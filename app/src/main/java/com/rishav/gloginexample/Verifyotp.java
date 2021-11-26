package com.rishav.gloginexample;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.chaos.view.PinView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Verifyotp extends AppCompatActivity {
    TextView tv;
    private String verifyotp,newverifyotp;
    String st;
    Button code,resend;
    ImageView close;
    PinView pin_view;
    FirebaseAuth mAuth;
    private FirebaseAuth auth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.verifyotp);
        tv=findViewById(R.id.otp_description_text2);
        code=findViewById(R.id.code);
        close=findViewById(R.id.close);
        pin_view=findViewById(R.id.pin_view);
        resend=findViewById(R.id.resend);
        auth=FirebaseAuth.getInstance();
        mAuth=FirebaseAuth.getInstance();
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        st=getIntent().getExtras().getString("value");
        tv.setText(st);

        code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(pin_view.getText().toString().trim().isEmpty()){
                    Toast.makeText(Verifyotp.this,"Enter Code Again",Toast.LENGTH_SHORT).show();
                    return;
                }


                String name1=getIntent().getExtras().getString("v11");
                String userr1=getIntent().getExtras().getString("v22");
                String emai1=getIntent().getExtras().getString("v33");
                String pass1=getIntent().getExtras().getString("v44");
                String gender=getIntent().getExtras().getString("v55");
                String date=getIntent().getExtras().getString("v66");

                verifyotp=getIntent().getExtras().getString("verification");

                String name = name1;
                String userr = userr1;
                String emai = emai1;
                String pass = pass1;
                String gen = gender;
                String dat = date;
                String phone = st;
                String code=pin_view.getText().toString().trim();

                if(verifyotp!=null){
                    PhoneAuthCredential phoneAuthCredential= PhoneAuthProvider.getCredential(
                            verifyotp,
                            code
                    );
                    FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        mAuth.createUserWithEmailAndPassword(emai,pass)
                                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                                        if(task.isSuccessful())
                                                        {
                                                            User user=new User(name,userr,emai,phone,gen,dat,"0");
                                                            FirebaseDatabase.getInstance("https://carrentalsystem-79a8a-default-rtdb.firebaseio.com").getReference("users")
                                                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                @Override
                                                                public void onComplete(@NonNull  Task<Void> task) {
                                                                    if(task.isSuccessful()){

                                                                        String message="Enjoy Your Ride.";
                                                                        NotificationCompat.Builder builder=new NotificationCompat.Builder(
                                                                        Verifyotp.this)
                                                                                .setSmallIcon(R.drawable.splash)
                                                                                .setContentTitle("Instance Seekers")
                                                                                .setContentText(message)
                                                                                .setAutoCancel(true);

                                                                        Toast.makeText(Verifyotp.this,"You are successfully Registered", Toast.LENGTH_SHORT).show();
                                                                        Intent intent = new Intent(Verifyotp.this, Login.class);
                                                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                                        PendingIntent pendingIntent=PendingIntent.getActivity(Verifyotp.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                                                                        builder.setContentIntent(pendingIntent);
                                                                        NotificationManager notificationManager=(NotificationManager)getSystemService(
                                                                                Context.NOTIFICATION_SERVICE
                                                                        );
                                                                        notificationManager.notify(0,builder.build());
                                                                        Toast.makeText(getApplicationContext(),"Register success",Toast.LENGTH_SHORT).show();
                                                                        startActivity(intent);

                                                                        finish();
                                                                    }else {
                                                                        Toast.makeText(Verifyotp.this,"Failed Due to email is used again or check your Internet connection ", Toast.LENGTH_SHORT).show();
                                                                    }
                                                                }
                                                            });

                                                        }
                                                        else
                                                        {
                                                            Toast.makeText(Verifyotp.this,"You are not Registered! Try again",Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                });
                                    }else{
                                        Toast.makeText(Verifyotp.this,"Invalid verification code ", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }








            }
        });
        resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                PhoneAuthProvider.getInstance().verifyPhoneNumber(
//                        "+91"+getIntent().getExtras().getString("value"),
//                        60,
//                        TimeUnit.SECONDS,
//                        Verifyotp.this,
//                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
//
//                            @Override
//                            public void onVerificationCompleted(@NotNull PhoneAuthCredential phoneAuthCredential) {
//
//                            }
//
//                            @Override
//                            public void onVerificationFailed(@NotNull FirebaseException e) {
//
//                                Toast.makeText(Verifyotp.this,e.getMessage(),Toast.LENGTH_SHORT).show();
//                            }
//
//                            @Override
//                            public void onCodeSent(@NotNull String s,@NotNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
//
//                                verifyotp=newverifyotp;
//                                Toast.makeText(Verifyotp.this,"OTP sent",Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                );
                PhoneAuthOptions options =
                        PhoneAuthOptions.newBuilder(auth)
                                .setPhoneNumber("+91"+getIntent().getExtras().getString("value"))       // Phone number to verify
                                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                                .setActivity(Verifyotp.this)                 // Activity (for callback binding)
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

                Toast.makeText(Verifyotp.this,e.getMessage(),Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {

                           verifyotp=verificationId;
                           Toast.makeText(Verifyotp.this,"OTP sent",Toast.LENGTH_SHORT).show();
            }
        };


        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Verifyotp.this, SignUp3rdClass.class);

                startActivity(intent);
                finish();


            }
        });
    }
}
