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


public class recycleradaptertrips extends RecyclerView.Adapter<recycleviewholdertrips> implements Filterable {

    FragmentActivity c;
    List<ListDataTrips> mdata;
    List<ListDataTrips> mylistdata;





    public recycleradaptertrips(FragmentActivity c, List<ListDataTrips> mdata) {
        this.c = c;
        this.mdata = mdata;
        this.mylistdata =new ArrayList<>(mdata);

    }

    @NonNull
    @Override
    public recycleviewholdertrips onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.recycler_viewtrips,parent,false);
        return new recycleviewholdertrips(view);
    }

   @Override
    public void onBindViewHolder(@NonNull  recycleviewholdertrips holder, int position) {


        holder.textView.setText(mdata.get(position).getSeater());
        holder.imageView.setImageResource(mdata.get(position).getImgid());
        holder.textView1.setText(mdata.get(position).getName());
        holder.loc_txt.setText(mdata.get(position).getLocDest());
        holder.Rs.setText(mdata.get(position).getRsphr());
        holder.initrupees.setText(mdata.get(position).getInitialRs());
        holder.hours.setText(mdata.get(position).getHours());
        holder.date.setText(mdata.get(position).getDate());
        holder.time.setText(mdata.get(position).getTime());
        holder.totalprice.setText(mdata.get(position).getTotalprice());
// Starts here variables....

        String loctxt = mdata.get(position).getLocDest();
        String locsrc = mdata.get(position).getLocSrc();





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


            List<ListDataTrips> filteredList = new ArrayList<>();
            if (charSequence.toString().isEmpty()) {
                filteredList.addAll(mylistdata);
            }
            else {
                for(int i=0;i<mylistdata.size();i++)
                {
                    String name = mylistdata.get(i).getName().toString();
                    String loc = mylistdata.get(i).getLocDest().toString();
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
            mdata.addAll((Collection<? extends ListDataTrips>) filterResults.values);
            notifyDataSetChanged();
        }
    };


}


