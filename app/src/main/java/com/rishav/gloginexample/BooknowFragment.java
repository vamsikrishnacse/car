package com.rishav.gloginexample;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.Calendar;


public class BooknowFragment extends Fragment {

    EditText hours,date,time;
    Button check,loc_buttonbook;
    ImageButton back_btn;
    DatePickerDialog.OnDateSetListener onDateSetListener;
    int hour,minute;
    TextView txt1vwbook,txt2vwbook,loctxtbook,Rupeesbook,InitialRsbook;
    ImageView ivbook;

    String hourstxt;
    String datetxt,timetxt;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_booknow, container, false);

        hours =view.findViewById(R.id.hours);
        date = view.findViewById(R.id.date);
        time = view.findViewById(R.id.time);
        check = view.findViewById(R.id.btn_check);
        back_btn = view.findViewById(R.id.backbtn);
        loc_buttonbook = view.findViewById(R.id.loc_buttonbook);


        txt1vwbook = view.findViewById(R.id.txt1vwbook);
        txt2vwbook = view.findViewById(R.id.txt2vwbook);
        ivbook = view.findViewById(R.id.ivbook);
        loctxtbook = view.findViewById(R.id.loctxtbook);
        Rupeesbook = view.findViewById(R.id.Rupeesbook);
        InitialRsbook = view.findViewById(R.id.InitialRsbook);



        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month=month+1;
                        String datee = day+"/"+month+"/"+year;
                        date.setText(datee);

                    }
                },year,month,day);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog.show();
            }
        });


        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int selectedhour, int slectedminute) {

                        hour = selectedhour;
                        minute = slectedminute;
                        Calendar cal = Calendar.getInstance();
                        String sDate = date.getText().toString().trim();
                        String[] strings = sDate.split("/");

                        int sDay = Integer.parseInt(strings[0]);
                        cal.set(Calendar.DAY_OF_MONTH,sDay);



                        cal.set(Calendar.HOUR_OF_DAY,hour);
                        cal.set(Calendar.MINUTE,minute);
                        time.setText(DateFormat.format("hh:mm aa",cal));

                        if(cal.getTimeInMillis() == Calendar.getInstance().getTimeInMillis())
                        {
                            time.setText("");
                            Toast.makeText(getContext(),"Current Time Selected!! Change Time",Toast.LENGTH_LONG).show();
                        }

                        else if(cal.getTimeInMillis()>Calendar.getInstance().getTimeInMillis())
                        {
                            time.setText(DateFormat.format("hh:mm aa",cal));
                        }

                        else
                        {
                            time.setText("");
                            Toast.makeText(getContext(),"Past Time Selected!! Change Time",Toast.LENGTH_LONG).show();
                        }


                    }

                };

                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),onTimeSetListener,hour,minute,false);
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();

            }
        });

        loc_buttonbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String locsrc = Dataholder.getInstance().getLocsrc();
                String loctxt = Dataholder.getInstance().getLoc();

                Toast.makeText(getContext(),loctxt,Toast.LENGTH_LONG).show();
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

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int flag1=0;
                int flag2=0;
                int flag3=0;



                if(!hours.getText().toString().equals(""))
                {
                    hourstxt = hours.getText().toString();
                    Dataholder.getInstance().setHours(hourstxt);
                    flag1=1;
                }

                if(!date.getText().toString().equals(""))
                {
                    datetxt = date.getText().toString();
                    Dataholder.getInstance().setDate(datetxt);
                    flag2=1;
                }

                if(!time.getText().toString().equals(""))
                {
                    timetxt = time.getText().toString();
                    Dataholder.getInstance().setTime(timetxt);
                    flag3 = 1;
                }


                if(flag1==1 && flag2==1 && flag3==1) {


                    fragmentManager.beginTransaction().replace(R.id.fragment_container, new Confirmandpay()).commit();
                }
                else
                {
                    Toast.makeText(getContext(),"Please Fill all The blanks",Toast.LENGTH_LONG).show();
                }
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.fragment_container, new Needacarfragment()).commit();

            }
        });


        //Assigning to card View starts here

        txt1vwbook.setText(Dataholder.getInstance().getName());
        txt2vwbook.setText(Dataholder.getInstance().getSeater());
        ivbook.setImageResource(Dataholder.getInstance().getImgid());
        loctxtbook.setText(Dataholder.getInstance().getLoc());
        Rupeesbook.setText(Dataholder.getInstance().getRs());
        InitialRsbook.setText(Dataholder.getInstance().getInitialRs());







        return view;
    }
}