package com.rishav.gloginexample;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;


public class VerifyLicense extends Fragment {

    RadioGroup rg;
    RadioButton cred,netb,upi;
    Button pay;
    RelativeLayout frm_credcard,frm_debcard,upipaylout;
    String ss;

    TextInputEditText creditcardnumber,credexpirymonth,credexpiryyear,credholdername,credamount;
    TextInputEditText netbaccountno,netbifsccode,netbexpirymonth,netbexpiryyear,netbamount;
    TextInputEditText upiid,upiamount;

    TextInputEditText credcrdnumber,debcrdnumber,upiname;
    int flag = 0;
    private FirebaseUser user;
    private DatabaseReference reference;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_verify, container, false);

        frm_credcard = view.findViewById(R.id.frm_credcard);
        frm_debcard = view.findViewById(R.id.frm_debcard);
        upipaylout = view.findViewById(R.id.upipaylayout);

        rg = view.findViewById(R.id.rg_payment);
        cred = view.findViewById(R.id.Credcard);
        netb = view.findViewById(R.id.debcard);
        upi = view.findViewById(R.id.upi_payment);

        pay = view.findViewById(R.id.addmoney_payment);

        credamount = view.findViewById(R.id.credcrdamt);
        netbamount = view.findViewById(R.id.debcrdamt);
        upiamount = view.findViewById(R.id.upiamount);

        credcrdnumber = view.findViewById(R.id.credcrdnumber);
        debcrdnumber = view.findViewById(R.id.debcrdnumber);
        upiname = view.findViewById(R.id.upiname);

        user= FirebaseAuth.getInstance().getCurrentUser();
        reference= FirebaseDatabase.getInstance().getReference("users");


        int visible = 0x00000000;
        int gone = 0x00000008;

        pay.setText("Add");
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.Credcard:


                        frm_credcard.setVisibility(visible);
                        frm_debcard.setVisibility(gone);
                        upipaylout.setVisibility(gone);

                        ss="PAN";
                        pay.setText("Add"+" "+ss);



                        break;

                    case R.id.debcard:

                        frm_debcard.setVisibility(visible);
                        upipaylout.setVisibility(gone);
                        frm_credcard.setVisibility(gone);

                        ss="Aadhaar Card";

                        pay.setText("Add"+" "+ss);

                        break;

                    case R.id.upi_payment:
                        upipaylout.setVisibility(visible);
                        frm_credcard.setVisibility(gone);
                        frm_debcard.setVisibility(gone);
                        ss="Driving License";

                        pay.setText("Add"+" "+ss);

                        break;

                }
            }
        });


        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pan=credcrdnumber.getText().toString().length();
                int ad=debcrdnumber.getText().toString().length();
                int wa=upiname.getText().toString().length();


                if(pan==10 ||   ad==12 || wa==15) {


                    License li;
                    if(ss.equals("PAN"))
                    {
                        li = new License(credcrdnumber.getText().toString());

                    }
                    else if(ss.equals("Aadhaar Card"))
                    {
                        li = new License(debcrdnumber.getText().toString());
                    }
                    else
                    {
                        li = new License(upiname.getText().toString());
                    }

                    reference.child(user.getUid()).child("License").setValue(li).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(getContext(), "Added" + " " + ss, Toast.LENGTH_LONG).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull @NotNull Exception e) {
                            Toast.makeText(getContext(), "License Not Added", Toast.LENGTH_LONG).show();
                        }
                    });
                }
                else
                {
                    Toast.makeText(getContext(), "Please Check Licence Correctly", Toast.LENGTH_LONG).show();
                }

            }
        });


        return view;
    }
}