package com.rishav.gloginexample;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class MyTripsFragment extends Fragment {

    RecyclerView rvtrips;
    recycleradaptertrips adaptertrips,Adptr;
    private FirebaseUser user;
    private DatabaseReference reference;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mytrips, container, false);
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("users");

        rvtrips = view.findViewById(R.id.rvtrips);

        List<ListDataTrips> ListData = new ArrayList<ListDataTrips>();

        reference.child(user.getUid()).child("Booked").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot childsnapshot : snapshot.getChildren()) {
                    String name = childsnapshot.child("Name").getValue().toString();
                    String seater = childsnapshot.child("Seater").getValue().toString();
                    String locsrc = childsnapshot.child("Locsrc").getValue().toString();
                    String Locdest = childsnapshot.child("Locdest").getValue().toString();
                    int Imgid = Integer.parseInt(childsnapshot.child("Imgid").getValue().toString());
                    String Rphr = childsnapshot.child("RupeesperHour").getValue().toString();
                    String irs = childsnapshot.child("InitialRs").getValue().toString();
                    String hrs = childsnapshot.child("Hours").getValue().toString();
                    String dt = childsnapshot.child("Date").getValue().toString();
                    String tm = childsnapshot.child("Time").getValue().toString();
                    String tprc = childsnapshot.child("Totalprice").getValue().toString();



                    ListData.add(new ListDataTrips(name, seater, locsrc, Locdest, Rphr, irs, hrs, dt, tm, tprc, Imgid));
                }

                rvtrips.setLayoutManager(new LinearLayoutManager(getContext()));
                adaptertrips = new recycleradaptertrips(getActivity(), ListData);
                rvtrips.setAdapter(adaptertrips);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        adaptertrips = (recycleradaptertrips) rvtrips.getAdapter();
        rvtrips.setAdapter(adaptertrips);

        return view;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.main_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setQueryHint("Search for name or Location");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adaptertrips.getFilter().filter(newText);
                return false;
            }
        });

    }

}