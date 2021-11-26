package com.rishav.gloginexample;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;


public class UpdateFragment extends Fragment {

    private FirebaseUser user;
    private DatabaseReference reference;
    private String userid;
    TextView tv_name;
    EditText fullname,username,gender,phone,date;
    Button update;

    final Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    int day = calendar.get(Calendar.DAY_OF_MONTH);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update,container,false);
        user= FirebaseAuth.getInstance().getCurrentUser();
        reference= FirebaseDatabase.getInstance().getReference("users");
        userid=user.getUid();
        tv_name=view.findViewById(R.id.tv_name1);
        fullname=view.findViewById(R.id.fullname);
        username=view.findViewById(R.id.username);
        gender=view.findViewById(R.id.email);
        update=view.findViewById(R.id.update);
        phone=view.findViewById(R.id.phone);
        date=view.findViewById(R.id.date);
        DatePickerDialog.OnDateSetListener onDateSetListener;
        reference.child(userid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String name = snapshot.child("fullname").getValue().toString().trim();
                    String name2 = snapshot.child("fullname").getValue().toString().trim();
                    String username2 = snapshot.child("username").getValue().toString().trim();
                    String gender2 = snapshot.child("gender").getValue().toString().trim();
                    String phone2 = snapshot.child("phone").getValue().toString().trim();
                    String date2 = snapshot.child("date").getValue().toString().trim();
                    tv_name.setText(name);
                    fullname.setText(name2);
                    username.setText(username2);
                    gender.setText(gender2);
                    phone.setText(phone2);
                    date.setText(date2);
                }

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(),
                        "Some Thing went Wrong",
                        Toast.LENGTH_SHORT).show();
            }
        });
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month=month+1;
                        String datee = day+"/"+month+"/"+year;
                        date.setText(datee);

                    }
                },year,month,day);
                datePickerDialog.show();
            }

        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                     String fn=fullname.getText().toString();
                String un=username.getText().toString();
                String ge=gender.getText().toString();
                String ph=phone.getText().toString();
                String da=date.getText().toString();
                UpdateProfile(fn,un,ge,ph,da,userid);
            }

        });


        return view;
    }
    private void UpdateProfile(String fn,String un,String ge,String ph,String da,String userid){

        HashMap<String,Object> hashMap = new HashMap<String,Object>();
        hashMap.put("fullname",fn);
        hashMap.put("username",un);
        hashMap.put("gender",ge);
        hashMap.put("phone",ph);
        hashMap.put("date",da);

        reference.child(userid).updateChildren(hashMap)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NotNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getActivity(),
                                    "Update Successful",
                                    Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getActivity(),
                                    "Some Thing went Wrong",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }
}