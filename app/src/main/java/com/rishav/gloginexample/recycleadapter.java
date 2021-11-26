package com.rishav.gloginexample;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class recycleadapter extends RecyclerView.Adapter<recycleviewholder> implements Filterable {

    FragmentActivity c;
    List<MyListData> mdata;
    List<MyListData> mylistdata;





    public recycleadapter(FragmentActivity c, List<MyListData> mdata) {
        this.c = c;
        this.mdata = mdata;
        this.mylistdata =new ArrayList<>(mdata);

    }

    @NonNull
    @Override
    public recycleviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(c).inflate(R.layout.recycler_view,parent,false);
        return new recycleviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  recycleviewholder holder, int position) {


        holder.textView.setText(mdata.get(position).getName());
        holder.imageView.setImageResource(mdata.get(position).getImgid());
        holder.textView1.setText(mdata.get(position).getX());
        holder.loc_txt.setText(mdata.get(position).getLoc());
        holder.Rs.setText(mdata.get(position).getRs());
        holder.Rsphr.setText(mdata.get(position).getRsphr());
        holder.initrupees.setText(mdata.get(position).getInitialrs());
// Starts here variables....
        String txt1 = mdata.get(position).getX().toString();
        String seater = mdata.get(position).getName().toString();
        int imgid = mdata.get(position).getImgid();
        String loctxt = mdata.get(position).getLoc().toString();
        String Rstxt = mdata.get(position).getRs().toString() ;
        String initrupeestxt = mdata.get(position).getInitialrs().toString();
        String locsrc = mdata.get(position).getLocsrc().toString();

        FragmentManager fragmentManager = c.getSupportFragmentManager();


        holder.location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c.getApplicationContext(),holder.loc_txt.getText().toString(),Toast.LENGTH_SHORT).show();
                try {
                    Uri uri = Uri.parse("https://www.google.co.in/maps/dir/" + locsrc + "/" + loctxt);
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    intent.setPackage("com.google.android.apps.maps");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    v.getContext().startActivity(intent);
                } catch (ActivityNotFoundException e){
                    Uri uri=  Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
                    Intent intent=new Intent(Intent.ACTION_VIEW,uri );
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    v.getContext().startActivity(intent);

                }


            }
        });


        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("hello","Clicked text");
            }
        });

        holder.book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c.getApplicationContext(),"Booking "+holder.textView1.getText().toString(),Toast.LENGTH_SHORT).show();

                Dataholder.getInstance().setName(txt1);
                Dataholder.getInstance().setSeater(seater);
                Dataholder.getInstance().setImgid(imgid);
                Dataholder.getInstance().setLoc(loctxt);
                Dataholder.getInstance().setRs(Rstxt);
                Dataholder.getInstance().setInitialRs(initrupeestxt);
                Dataholder.getInstance().setLocsrc(locsrc);



                fragmentManager.beginTransaction().replace(R.id.fragment_container, new BooknowFragment()).commit();

            }
        });



    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

  final Filter filter = new Filter() {
        // runs on background thread
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {


            List<MyListData> filteredList = new ArrayList<MyListData>();
            if (charSequence.toString().isEmpty()) {
                  filteredList.addAll(mylistdata);
            }
            else {
                for(int i=0;i<mylistdata.size();i++)
                {
                    String name = mylistdata.get(i).getX().toString();
                    String loc = mylistdata.get(i).getLoc().toString();
                    if(name.toLowerCase().contains(charSequence.toString().toLowerCase()) || loc.toLowerCase().contains(charSequence.toString().toLowerCase()) )
                    {
                        filteredList.add(mylistdata.get(i));
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;


            return filterResults;
        }

        // runs on a ui thread
        @Override
        protected void publishResults(CharSequence constraint, FilterResults filterResults) {

            mdata.clear();
            mdata.addAll((Collection<? extends MyListData>) filterResults.values);

            notifyDataSetChanged();
        }
    };


    }


