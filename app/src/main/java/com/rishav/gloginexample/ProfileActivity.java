package com.rishav.gloginexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;


public class ProfileActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    Button logoutBtn;
    int s;
    //private TextInputLayout userName,userEmail;
    private TextInputEditText username2,useremail2;
    private GoogleApiClient googleApiClient;
    private GoogleSignInOptions gso;

    ImageView backBtn;
    Button next, login;
    TextView titleText, slideText;

    TextInputLayout fullname,username,email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.accname);

        logoutBtn=(Button)findViewById(R.id.signup_logout_button);
        username2= findViewById(R.id.signup_username2);
        useremail2= findViewById(R.id.signup_email2);

        //Hooks for animation
        backBtn = findViewById(R.id.signup_back_button);
        next = findViewById(R.id.signup_next_button);
        login = findViewById(R.id.signup_login_button);
        titleText = findViewById(R.id.signup_title_text);
        slideText = findViewById(R.id.signup_slide_text);
        fullname = findViewById(R.id.signup_fullname);
        username=findViewById(R.id.signup_username);
        email=findViewById(R.id.signup_email);
        password=findViewById(R.id.signup_password);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });





        gso =  new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleApiClient=new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(
                        new ResultCallback<Status>() {
                            @Override
                            public void onResult(Status status) {
                                if (status.isSuccess()){
                                    gotoMainActivity();
                                }else{
                                    Toast.makeText(getApplicationContext(),"Session not close", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        OptionalPendingResult<GoogleSignInResult> opr= Auth.GoogleSignInApi.silentSignIn(googleApiClient);
        if(opr.isDone()){
            GoogleSignInResult result=opr.get();
            handleSignInResult(result);
        }else{
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(@NonNull GoogleSignInResult googleSignInResult) {
                    handleSignInResult(googleSignInResult);
                }
            });
        }
    }

    private void handleSignInResult(GoogleSignInResult result){

        if(result.isSuccess()){
            GoogleSignInAccount account=result.getSignInAccount();
            username2.setText(account.getDisplayName());
            useremail2.setText(account.getEmail());
        }else{
            gotoMainActivity();
        }
    }

    private void gotoMainActivity(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    public void callNextSignupScreen(View view) {




        if (!validateFullName() | !validateUsername() | !validateEmail() | !validatePassword()) {
            return;
        }else {


            Intent intent = new Intent(ProfileActivity.this, SignUp2ndClass.class);

            String name1= Objects.requireNonNull(fullname.getEditText().getText()).toString();
            intent.putExtra("value1",name1);
            String users1= Objects.requireNonNull(username.getEditText().getText()).toString();
            intent.putExtra("value2",users1);
            String emails1= Objects.requireNonNull(email.getEditText().getText()).toString();
            intent.putExtra("value3",emails1);
            String pass1= Objects.requireNonNull(password.getEditText().getText()).toString();
            intent.putExtra("value4",pass1);
            startActivity(intent);





        }

    }
    private boolean validateFullName() {
        String val = fullname.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            fullname.setError("Field can not be empty");
            return false;
        } else {
            fullname.setError(null);
            fullname.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validateUsername(){
        String val = username.getEditText().getText().toString().trim();
        String checkspaces="\\A\\w{4,20}\\z";
        if (val.isEmpty()) {
            username.setError("Field can not be empty");
            return false;
        }else if(val.length()>20){
            username.setError("username is too large!>20");
            return false;
        }
        else if(!val.matches(checkspaces)){
            username.setError("No white spaces are allowed ");
            return false;
        }
        else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validateEmail() {
        String val = email.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";

        if (val.isEmpty()) {
            email.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkEmail)) {
            email.setError("Invalid Email!");
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validatePassword() {
        String val = password.getEditText().getText().toString().trim();
        String checkPassword = "[a-zA-Z0-9\\\\!\\\\@\\\\#\\\\$]{8,24}";

        if (val.isEmpty()) {
            password.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkPassword)) {
            password.setError("Password should contain atleast 8 characters!");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }


    public void callLoginFromSignUp(View view) {
        startActivity(new Intent(ProfileActivity.this, Login.class));
        finish();
    }
}