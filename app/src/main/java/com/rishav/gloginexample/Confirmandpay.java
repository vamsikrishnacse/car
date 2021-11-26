package com.rishav.gloginexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Confirmandpay extends Fragment {


    ImageButton backbtn2;
    Button confirmandpay;
    private FirebaseUser user;
    private DatabaseReference reference;

    private FirebaseAuth auth;
    TextView initialtxt,prctxt,hourstxtvw,datetxtvw,timetxtvw,total;
    int flag = 0,diff,key=0;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_confirmandpay, container, false);

        backbtn2 = view.findViewById(R.id.backbtn2);
        confirmandpay = view.findViewById(R.id.confirmandpay);

        initialtxt = view.findViewById(R.id.initaltxt);
        prctxt = view.findViewById(R.id.prctxt);
        hourstxtvw = view.findViewById(R.id.hourstxt);
        datetxtvw = view.findViewById(R.id.datetxt);
        timetxtvw = view.findViewById(R.id.timetxt);
        total = view.findViewById(R.id.total);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

        user= FirebaseAuth.getInstance().getCurrentUser();
        reference= FirebaseDatabase.getInstance().getReference("users");


        backbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.fragment_container, new BooknowFragment()).commit();
            }
        });




        initialtxt.setText(Dataholder.getInstance().getInitialRs());
        prctxt.setText(Dataholder.getInstance().getRs());
        hourstxtvw.setText(Dataholder.getInstance().getHours());
        datetxtvw.setText(Dataholder.getInstance().getDate());
        timetxtvw.setText(Dataholder.getInstance().getTime());

        String TotalP;
        int Totalprice;

        Totalprice = Integer.parseInt(initialtxt.getText().toString())+(Integer.parseInt(hourstxtvw.getText().toString())*Integer.parseInt(prctxt.getText().toString()));

        TotalP = initialtxt.getText().toString()+" "+"+"+" "+"("+hourstxtvw.getText().toString()+")"+"*"+"("+prctxt.getText().toString()+")"+" "+"="+" "+String.valueOf(Totalprice);

        total.setText(TotalP);
        confirmandpay.setText("Confirm And Pay"+" "+"₹"+String.valueOf(Totalprice));


        confirmandpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reference.child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists())
                        {
                            String price = snapshot.child("balance").getValue().toString();
                            if(Totalprice<= Integer.parseInt(price))
                            {
                                diff = Integer.parseInt(price)-Totalprice;
                                reference.child(user.getUid()).child("balance").setValue(String.valueOf(diff)).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {




                                        Toast.makeText(getContext(),"Paid"+" "+"₹"+String.valueOf(Totalprice),Toast.LENGTH_LONG).show();
                                        String name = Dataholder.getInstance().getName();
                                        String seat = Dataholder.getInstance().getSeater();
                                        String locdst = Dataholder.getInstance().getLoc();
                                        String locsrc = Dataholder.getInstance().getLocsrc();
                                        String Imgid  = String.valueOf(Dataholder.getInstance().getImgid());
                                        String Rph = prctxt.getText().toString();
                                        String InitialRs = initialtxt.getText().toString();
                                        String Totlp = String.valueOf(Totalprice);
                                        String dt = datetxtvw.getText().toString();
                                        String tm = timetxtvw.getText().toString();
                                        String hrs = hourstxtvw.getText().toString();

                                        Payitems payitems = new Payitems(name,seat,locdst,locsrc,Imgid,Rph,InitialRs,Totlp,dt,tm,hrs);


                                        reference.child(user.getUid()).child("Booked").child(name).setValue(payitems).addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {


                                                Toast.makeText(getContext(),"Booking Done!!!",Toast.LENGTH_LONG).show();
                                                fragmentManager.beginTransaction().replace(R.id.fragment_container, new Homefragment()).commit();





                                            }

                                        }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(getContext(),"Something Went Wrong",Toast.LENGTH_LONG).show();
                                            }
                                        });
                                    }
                                });
                            }
                            else
                            {
                                Toast.makeText(getContext(),"Please Add"+" "+"₹"+String.valueOf(Totalprice-Integer.parseInt(price))+" "+"to Wallet to Continue",Toast.LENGTH_LONG).show();
                            }





                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }


                });











            }
        });








        return view;
    }
}