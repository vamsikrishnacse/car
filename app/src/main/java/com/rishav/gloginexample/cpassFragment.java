package com.rishav.gloginexample;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;


public class cpassFragment extends Fragment {
    Button update;
    EditText old,newp;
    FirebaseAuth firebaseAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cpass,container,false);
        update= view.findViewById(R.id.chpass);
        old= view.findViewById(R.id.newpass2);
        newp= view.findViewById(R.id.connewpass2);
        firebaseAuth=FirebaseAuth.getInstance();
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                     String oldpass=old.getText().toString().trim();
                String newpass=newp.getText().toString().trim();
                if(TextUtils.isEmpty(oldpass)){
                    Toast.makeText(getActivity(), "Please Enter Current Password ", Toast.LENGTH_LONG ).show();
                    return;
                }
                if(newpass.length()<6){
                    Toast.makeText(getActivity(), "New Password length >6", Toast.LENGTH_LONG ).show();
                    return;
                }
                updatePassword(oldpass,newpass);
            }
            private void updatePassword(String oldpass,final String newpass){

                FirebaseUser user= firebaseAuth.getCurrentUser();


                assert user != null;
                AuthCredential authCredential= EmailAuthProvider.getCredential(Objects.requireNonNull(user.getEmail()),oldpass);
                user.reauthenticate(authCredential)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NotNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    user.updatePassword(newpass)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NotNull Task<Void> task) {
                                                    if(task.isSuccessful()){
                                                        Toast.makeText(getActivity(), "Password updated", Toast.LENGTH_LONG ).show();
                                                    }else{
                                                        Toast.makeText(getActivity(), "Check and Retry Again", Toast.LENGTH_LONG ).show();
                                                    }
                                                }
                                            });
                                }else{
                                    Toast.makeText(getActivity(), "Check and Retry Again", Toast.LENGTH_LONG ).show();
                                }
                            }
                        });
            }

        });

        return view;
    }
}