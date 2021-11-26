package com.rishav.gloginexample;


import android.os.Bundle;

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

import java.util.ArrayList;
import java.util.List;


public class Needacarfragment extends Fragment {

    RecyclerView rv;
    recycleadapter adapter;





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_needacar, container, false);
        rv = view.findViewById(R.id.rv);
        List<MyListData> myListData=new ArrayList<MyListData>();
        myListData.add(new MyListData("5 Seater",R.drawable.duster,"Duster","Visakhapatnam - Frenz Travels","55","Per Hour","150","Visakhapatnam"));
        myListData.add(new MyListData("7 Seater",R.drawable.safari,"Safari","Vijayawada - Aman selfdrive cars","75","Per Hour","175","Vijayawada"));
        myListData.add(new MyListData("7 Seater",R.drawable.ertiga,"Ertiga","Guntur - Vasu car travels","60","Per Hour","160","Guntur"));
        myListData.add(new MyListData("4 Seater",R.drawable.nexon,"Nexon","Nellore - Ravi travels","80","Per Hour","200","Nellore"));
        myListData.add(new MyListData("5 Seater",R.drawable.terrano,"Terrano","Kakinada - Costa car travels","70","Per Hour","220","Kakinada"));
        myListData.add(new MyListData("4 Seater",R.drawable.magnite,"Magnite","Rajhmundry - Vinayaka cars","65","Per Hour","250","Rajhmundry"));
        myListData.add(new MyListData("7 Seater",R.drawable.tavera,"Tavera","Tirupati - Ramana cabs","75","Per Hour","160","Tirupati"));
        myListData.add(new MyListData("7 Seater",R.drawable.innova,"Innova","Hyderabad - Savaari car","85","Per Hour","200","Hyderabad"));
        myListData.add(new MyListData("7 Seater",R.drawable.bolero,"Bolero","Warangal - Happymove car","60","Per Hour","180","Warangal"));
        myListData.add(new MyListData("6 Seater",R.drawable.scorpio,"Scorpio","kurnool - Reddy's travels","80","Per Hour","190","Kurnool"));




        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter =new recycleadapter(getActivity(),myListData);
        rv.setAdapter(adapter);
        // Inflate the layout for this fragment
        return view;



    }

    public void onCreateOptionsMenu(Menu menu,MenuInflater inflater) {

        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.main_menu,menu);
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
                adapter.getFilter().filter(newText);
                return false;
            }
        });



    }







}


