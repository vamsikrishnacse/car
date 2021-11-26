package com.rishav.gloginexample;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class recycleviewholder extends RecyclerView.ViewHolder {
    TextView textView,textView1,loc_txt,Rs,Rsphr,initial,initrupees;
    ImageView imageView;
    Button location,book;
    public recycleviewholder(@NonNull View itemView) {
        super(itemView);
        textView=itemView.findViewById(R.id.txt1);
        imageView=itemView.findViewById(R.id.iv);
        textView1 = itemView.findViewById(R.id.txt2);
        location = itemView.findViewById(R.id.loc_button);
        loc_txt = itemView.findViewById(R.id.loctxt);
        Rs = itemView.findViewById(R.id.Rupees);
        Rsphr = itemView.findViewById(R.id.Rsphr);
        initial = itemView.findViewById(R.id.Initial);
        initrupees = itemView.findViewById(R.id.InitialRs);
        book = itemView.findViewById(R.id.booknow);

    }

}
