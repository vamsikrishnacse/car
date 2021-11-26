package com.rishav.gloginexample;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class WalletFragment extends Fragment {


    TextView wallet_balance,wallet_name,wallet_email;
    Button Addmoney;
    private FirebaseUser user;
    private DatabaseReference reference;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

        View view = inflater.inflate(R.layout.fragment_wallet, container, false);
        wallet_balance = view.findViewById(R.id.wallet_balance);
        wallet_email = view.findViewById(R.id.wallet_email);
        wallet_name = view.findViewById(R.id.wallet_name);
        Addmoney = view.findViewById(R.id.addmoney);

        user= FirebaseAuth.getInstance().getCurrentUser();
        reference= FirebaseDatabase.getInstance().getReference("users");

        reference.child(user.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                wallet_name.setText(snapshot.child("fullname").getValue().toString());
                wallet_email.setText(snapshot.child("email").getValue().toString());
                wallet_balance.setText("₹"+snapshot.child("balance").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        Addmoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentManager.beginTransaction().replace(R.id.fragment_container,new WalletAddmoneyFragment()).commit();

            }
        });


        return view;
    }
}