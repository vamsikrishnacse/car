package com.rishav.gloginexample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class WalletAddmoneyFragment extends Fragment {

    RadioGroup rg;
    RadioButton cred,netb,upi;
    Button pay;
    RelativeLayout frm_credcard,frm_debcard,upipaylout;
    private FirebaseUser user;
    private DatabaseReference reference;

    TextInputEditText creditcardnumber,credexpirymonth,credexpiryyear,credcrdcvv,credholdername,credamount;
    TextInputEditText netbaccountno,netbifsccode,netbexpirymonth,netbexpiryyear,netbcvv,netbamount;
    TextInputEditText upiid,upiname,upiamount;
    int flag = 0;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_wallet_addmoney, container, false);

        frm_credcard = view.findViewById(R.id.frm_credcard);
        frm_debcard = view.findViewById(R.id.frm_debcard);
        upipaylout = view.findViewById(R.id.upipaylayout);

        rg = view.findViewById(R.id.rg_payment);
        cred = view.findViewById(R.id.Credcard);
        netb = view.findViewById(R.id.debcard);
        upi = view.findViewById(R.id.upi_payment);

        pay = view.findViewById(R.id.addmoney_payment);

        creditcardnumber = view.findViewById(R.id.credcrdnumber);
        credexpirymonth = view.findViewById(R.id.credcrdexpirymnth);
        credexpiryyear = view.findViewById(R.id.credcrdexpiryyr);
        credcrdcvv = view.findViewById(R.id.credcrdcvv);
        credholdername = view.findViewById(R.id.credcrdname);


        netbaccountno = view.findViewById(R.id.debcrdnumber);
        netbifsccode = view.findViewById(R.id.debcrdifsc);
        netbexpirymonth = view.findViewById(R.id.debcrdexpirymnth);
        netbexpiryyear = view.findViewById(R.id.debcrdexpiryyr);
        netbcvv = view.findViewById(R.id.debcrdcvv);


        upiid = view.findViewById(R.id.upiid);
        upiname = view.findViewById(R.id.upiname);


        credamount = view.findViewById(R.id.credcrdamt);
        netbamount = view.findViewById(R.id.debcrdamt);
        upiamount = view.findViewById(R.id.upiamount);



        user= FirebaseAuth.getInstance().getCurrentUser();
        reference= FirebaseDatabase.getInstance().getReference("users");


        int visible = 0x00000000;
        int gone = 0x00000008;

        pay.setText("Add"+" "+"₹"+"0");
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



                        credamount.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                            }

                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {

                            }

                            @Override
                            public void afterTextChanged(Editable s) {
                                pay.setText("Add"+" "+"₹"+" "+s);

                            }
                        });


                        break;

                    case R.id.debcard:

                        frm_debcard.setVisibility(visible);
                        upipaylout.setVisibility(gone);
                        frm_credcard.setVisibility(gone);




                        netbamount.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                            }

                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {

                            }

                            @Override
                            public void afterTextChanged(Editable s) {

                                pay.setText("Add"+" "+"₹"+" "+s);
                            }
                        });



                        break;

                    case R.id.upi_payment:
                        upipaylout.setVisibility(visible);
                        frm_credcard.setVisibility(gone);
                        frm_debcard.setVisibility(gone);


                        upiamount.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                            }

                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {

                            }

                            @Override
                            public void afterTextChanged(Editable s) {
                                pay.setText("Add"+" "+"₹"+" "+s);
                            }
                        });


                        break;

                }
            }
        });



        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean cred,netb,upi;

                cred = credchecker(creditcardnumber.getText().toString(),credexpirymonth.getText().toString(),credexpiryyear.getText().toString(),credcrdcvv.getText().toString(),credholdername.getText().toString());
                netb = netbchecker(netbaccountno.getText().toString(),netbifsccode.getText().toString(),netbexpirymonth.getText().toString(),netbexpiryyear.getText().toString(),netbcvv.getText().toString());
                upi =  upichecker(upiid.getText().toString(),upiname.getText().toString());

                if(!credamount.getText().toString().equals("") || !netbamount.getText().toString().equals("") || !upiamount.getText().toString().equals("")  ) {

                    if (cred == true || netb == true || upi == true)
                    {


                        if (!credamount.getText().toString().equals("0")) {
                            if (!netbamount.getText().toString().equals("0")) {
                                if (!upiamount.getText().toString().equals("0")) {
                                    String money = pay.getText().toString();
                                    String[] strings = money.split(" ");

                                    reference.child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                                            if (snapshot.exists()) {

                                                String bl = snapshot.child("balance").getValue().toString();
                                                String total = String.valueOf(Integer.parseInt(bl) + Integer.parseInt(strings[2]));

                                                reference.child(user.getUid()).child("balance").setValue(total).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                    @Override
                                                    public void onSuccess(Void unused) {
                                                        Toast.makeText(getContext(), "Added" + " " + "₹" + strings[2], Toast.LENGTH_LONG).show();
                                                    }
                                                }).addOnFailureListener(new OnFailureListener() {
                                                    @Override
                                                    public void onFailure(@NonNull Exception e) {
                                                        Toast.makeText(getContext(), "Money Not Added", Toast.LENGTH_LONG).show();
                                                    }
                                                });
                                            }


                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });


                                } else {
                                    Toast.makeText(getContext(), "Please Add Money greater than 0 Rupees", Toast.LENGTH_LONG).show();
                                }
                            } else {
                                Toast.makeText(getContext(), "Please Add Money greater than 0 Rupees", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(getContext(), "Please Add Money greater than 0 Rupees", Toast.LENGTH_LONG).show();
                        }

                    }
                    else
                    {
                        Toast.makeText(getContext(), "Please Fill All the blanks with correct details", Toast.LENGTH_LONG).show();
                    }


                }
                else
                {
                    Toast.makeText(getContext(), "Fill The amount blank", Toast.LENGTH_LONG).show();
                }

            }
        });

        return view;
    }


    public Boolean credchecker(String crdno,String exp_month ,String exp_year,String cvv,String holdername)
    {
        Boolean flag = false;
        String[] nos = crdno.trim().split(" ");
        String lastno="";
        for(int i=0;i< nos.length;i++)
        {
            lastno+=nos[i];
        }
        if(lastno.length() == 16 && exp_month .length() == 2 && exp_year.length()>=2 && cvv.length() ==3 && holdername.length()!=0)
        {
            flag=true;
        }

        return flag;
    }

    public Boolean netbchecker(String accno,String ifsc,String exp_month,String exp_year,String cvv)
    {
        Boolean flag = false;
        String ifscregex = "^[A-Z]{4}0[A-Z0-9]{6}$";

        if(accno.length()>=9 && ifsc.matches(ifscregex) && exp_month.length()==2 && exp_year.length()>=2 && cvv.length()==3)
        {
            flag = true;
        }

        return flag;
    }

    public Boolean upichecker(String Id,String Name)
    {
        String upiid = "/[a-zA-Z0-9_]{3,}@[a-zA-Z]{3,}/";
        Boolean flag = false;

        if(Id.matches(upiid) && Name.length()!=0)
        {
            flag = true;
        }

        return flag;
    }



}