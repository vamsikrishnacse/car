//package com.rishav.gloginexample;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.app.ActivityOptions;
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Pair;
//import android.view.View;
//import android.view.WindowManager;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.bumptech.glide.Glide;
//import com.google.android.gms.auth.api.Auth;
//import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
//import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
//import com.google.android.gms.auth.api.signin.GoogleSignInResult;
//import com.google.android.gms.common.ConnectionResult;
//import com.google.android.gms.common.api.GoogleApiClient;
//import com.google.android.gms.common.api.OptionalPendingResult;
//import com.google.android.gms.common.api.ResultCallback;
//import com.google.android.gms.common.api.Status;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.android.material.textfield.TextInputEditText;
//import com.google.android.material.textfield.TextInputLayout;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.database.FirebaseDatabase;
//
//
//public class Phonesignup extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{
//
//    Button logoutBtn;
//    int s;
//    //private TextInputLayout userName,userEmail;
//    private TextInputEditText username2,useremail2;
//    private GoogleApiClient googleApiClient;
//    private GoogleSignInOptions gso;
//
//    ImageView backBtn;
//    Button next, login;
//    TextView titleText, slideText;
//    private FirebaseAuth mAuth;
//
//    TextInputLayout fullname,username,email,password;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        setContentView(R.layout.activity_profile);
//
//        logoutBtn=(Button)findViewById(R.id.signup_logout_button);
//        username2= findViewById(R.id.signup_username2);
//        useremail2= findViewById(R.id.signup_email2);
//
//        //Hooks for animation
//        backBtn = findViewById(R.id.signup_back_button);
//        next = findViewById(R.id.signup_next_button);
//        login = findViewById(R.id.signup_login_button);
//        titleText = findViewById(R.id.signup_title_text);
//        slideText = findViewById(R.id.signup_slide_text);
//        fullname = findViewById(R.id.signup_fullname);
//        username=findViewById(R.id.signup_username);
//        email=findViewById(R.id.signup_email);
//        password=findViewById(R.id.signup_password);
//        mAuth=FirebaseAuth.getInstance();
//
//        backBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Phonesignup.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
//
//
//
//
//
//        gso =  new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestEmail()
//                .build();
//
//        googleApiClient=new GoogleApiClient.Builder(this)
//                .enableAutoManage(this,this)
//                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
//                .build();
//
//        logoutBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(
//                        new ResultCallback<Status>() {
//                            @Override
//                            public void onResult(Status status) {
//                                if (status.isSuccess()){
//                                    gotoMainActivity();
//                                }else{
//                                    Toast.makeText(getApplicationContext(),"Session not close", Toast.LENGTH_LONG).show();
//                                }
//                            }
//                        });
//            }
//        });
//
//    }
//
//
//
//
//
//    private void gotoMainActivity(){
//        Intent intent=new Intent(this,MainActivity.class);
//        startActivity(intent);
//        finish();
//    }
//
//    @Override
//    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//
//    }
//
//    public void callNextSignupScreen(View view) {
//        String name = fullname.getEditText().getText().toString().trim();
//        String userr = username.getEditText().getText().toString().trim();
//        String emai = email.getEditText().getText().toString().trim();
//        String pass = password.getEditText().getText().toString().trim();
//        if (!validateFullName() | !validateUsername() | !validateEmail() | !validatePassword()) {
//            return;
//        }else {
//            mAuth.createUserWithEmailAndPassword(emai,pass)
//                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if(task.isSuccessful())
//                            {
//                                User user=new User(name,userr,emai);
//                                FirebaseDatabase.getInstance("https://carrentalsystem-79a8a-default-rtdb.firebaseio.com").getReference("users")
//                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
//                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                    @Override
//                                    public void onComplete(@NonNull  Task<Void> task) {
//                                        if(task.isSuccessful()){
//                                            Toast.makeText(Phonesignup.this,"You are successfully Registered", Toast.LENGTH_SHORT).show();
//                                            Intent intent = new Intent(Phonesignup.this, SignUp2ndClass.class);
//
//                                            startActivity(intent);
//                                        }else {
//                                            Toast.makeText(Phonesignup.this,"Failed", Toast.LENGTH_SHORT).show();
//                                        }
//                                    }
//                                });
//
//                            }
//                            else
//                            {
//                                Toast.makeText(Phonesignup.this,"You are not Registered! Try again",Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
//
//
//
//        }
//
//    }
//    private boolean validateFullName() {
//        String val = fullname.getEditText().getText().toString().trim();
//        if (val.isEmpty()) {
//            fullname.setError("Field can not be empty");
//            return false;
//        } else {
//            fullname.setError(null);
//            fullname.setErrorEnabled(false);
//            return true;
//        }
//    }
//    private boolean validateUsername(){
//        String val = username.getEditText().getText().toString().trim();
//        String checkspaces="\\A\\w{4,20}\\z";
//        if (val.isEmpty()) {
//            username.setError("Field can not be empty");
//            return false;
//        }else if(val.length()>20){
//            username.setError("username is too large!>20");
//            return false;
//        }
//        else if(!val.matches(checkspaces)){
//            username.setError("No white spaces are allowed ");
//            return false;
//        }
//        else {
//            username.setError(null);
//            username.setErrorEnabled(false);
//            return true;
//        }
//    }
//    private boolean validateEmail() {
//        String val = email.getEditText().getText().toString().trim();
//        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";
//
//        if (val.isEmpty()) {
//            email.setError("Field can not be empty");
//            return false;
//        } else if (!val.matches(checkEmail)) {
//            email.setError("Invalid Email!");
//            return false;
//        } else {
//            email.setError(null);
//            email.setErrorEnabled(false);
//            return true;
//        }
//    }
//    private boolean validatePassword() {
//        String val = password.getEditText().getText().toString().trim();
//        String checkPassword = "[a-zA-Z0-9\\\\!\\\\@\\\\#\\\\$]{8,24}";
//
//        if (val.isEmpty()) {
//            password.setError("Field can not be empty");
//            return false;
//        } else if (!val.matches(checkPassword)) {
//            password.setError("Password should contain atleast 8 characters!");
//            return false;
//        } else {
//            password.setError(null);
//            password.setErrorEnabled(false);
//            return true;
//        }
//    }
//
//
//    public void callLoginFromSignUp(View view) {
//        startActivity(new Intent(Phonesignup.this, Login.class));
//        finish();
//    }
//}