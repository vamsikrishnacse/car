package com.rishav.gloginexample;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class recycleviewholdertrips extends RecyclerView.ViewHolder {
    TextView textView,textView1,loc_txt,Rs,Rsphr,initial,initrupees,time,date,hours,totalprice;
    ImageView imageView;
    Button location;
    public recycleviewholdertrips(@NonNull View itemView) {
        super(itemView);
        textView=itemView.findViewById(R.id.txt1trips);
        imageView=itemView.findViewById(R.id.ivtrips);
        textView1 = itemView.findViewById(R.id.txt2trips);
        location = itemView.findViewById(R.id.loc_buttontrips);
        loc_txt = itemView.findViewById(R.id.loctxttrips);
        Rs = itemView.findViewById(R.id.Rupeestrips);
        Rsphr = itemView.findViewById(R.id.Rsphrtrips);
        initial = itemView.findViewById(R.id.Initialtrips);
        initrupees = itemView.findViewById(R.id.InitialRstrips);
        time = itemView.findViewById(R.id.tmtrips);
        date = itemView.findViewById(R.id.dttrips);
        hours = itemView.findViewById(R.id.hrstrips);
        totalprice = itemView.findViewById(R.id.tprctrips);


    }

}
