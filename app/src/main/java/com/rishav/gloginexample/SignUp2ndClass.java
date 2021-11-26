package com.rishav.gloginexample;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.Objects;

public class SignUp2ndClass extends AppCompatActivity {

    //Variables
    ImageView backBtn;
    Button next, login;
    TextView titleText, slideText;
    RadioGroup radioGroup;
    RadioButton selectedGender;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.signup2);


        //Hooks
        backBtn = findViewById(R.id.signup_back_button);
        next = findViewById(R.id.signup_next_button);
        login = findViewById(R.id.signup_login_button);
        titleText = findViewById(R.id.signup_title_text);
        slideText = findViewById(R.id.signup_slide_text);
        radioGroup = findViewById(R.id.radio_group);
        datePicker = findViewById(R.id.age_picker);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp2ndClass.this, ProfileActivity.class);
                startActivity(intent);
            }
        });


    }



    public void call3rdSigupScreen(View view) {
        String name1=getIntent().getExtras().getString("value1");
        String userr1=getIntent().getExtras().getString("value2");
        String emai1=getIntent().getExtras().getString("value3");
        String pass1=getIntent().getExtras().getString("value4");


      if(!validateage() | !validategender()){
        return ;
        }
      selectedGender=findViewById(radioGroup.getCheckedRadioButtonId());
      String _gender=selectedGender.getText().toString().trim();
      int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();
        Intent intent = new Intent(SignUp2ndClass.this, SignUp3rdClass.class);
        String _date=day+"/"+month+"/"+year;
        String gender= Objects.requireNonNull(selectedGender.getText()).toString().trim();
        intent.putExtra("value5",gender);
        String date= Objects.requireNonNull(_date);
        intent.putExtra("value6",date);

        intent.putExtra("v1",name1);
        intent.putExtra("v2",userr1);
        intent.putExtra("v3",emai1);
        intent.putExtra("v4",pass1);
        startActivity(intent);


    }

private boolean validategender(){
        if(radioGroup.getCheckedRadioButtonId()==-1){
            Toast.makeText(this,"please select gender",Toast.LENGTH_SHORT).show();
            return false;

        }
        else{
            return true;
        }
}
    private boolean validateage(){
        int currentYear= Calendar.getInstance().get(Calendar.YEAR);
        int userage=datePicker.getYear();
        int isagevalid=currentYear - userage;

        if(isagevalid<14){
            Toast.makeText(this,"you are to eligible(age<14)",Toast.LENGTH_SHORT).show();
            return false;
        }else{
            return true;
        }
    }

}
