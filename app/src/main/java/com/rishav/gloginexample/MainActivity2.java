package com.rishav.gloginexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout drawer;
    private FirebaseUser user;
    private DatabaseReference reference;
    TextView ntx_name,ntx_email,ntx_balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_dash);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toogle);
        toogle.syncState();

        View headerview = navigationView.getHeaderView(0);


        ntx_name = headerview.findViewById(R.id.ntx);
        ntx_email = headerview.findViewById(R.id.ntx1);
        ntx_balance = headerview.findViewById(R.id.ntx2);

        user= FirebaseAuth.getInstance().getCurrentUser();
        reference= FirebaseDatabase.getInstance().getReference("users");

        reference.child(user.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    ntx_name.setText(snapshot.child("fullname").getValue().toString());
                    ntx_email.setText(snapshot.child("email").getValue().toString());
                    if(!snapshot.child("balance").getValue().toString().equals(""))
                    {
                        ntx_balance.setText("₹"+snapshot.child("balance").getValue().toString());
                    }
                    else
                    {
                        ntx_balance.setText("₹0");
                    }


                }

                else
                {
                    ntx_name.setText("ABC");
                    ntx_email.setText("ABC@gmail.com");
                    ntx_balance.setText("₹0");

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Homefragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull  MenuItem item) {

        switch(item.getItemId())
        {


            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Homefragment()).commit();
                break;


            case R.id.nav_mytrips:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyTripsFragment()).commit();
                break;

            case R.id.nav_verify:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new VerifyLicense()).commit();
                break;

            case R.id.nav_wallet:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new WalletFragment()).commit();
                break;
            case R.id.nav_update:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new UpdateFragment()).commit();
                break;


            case R.id.nav_policies:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Policiesfragment()).commit();
                break;

            case R.id.nav_support:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HelpFragment()).commit();
                break;
            case R.id.nav_pass:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new cpassFragment()).commit();
                break;

            case R.id.nav_logout:

                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                Toast.makeText(this,"Loged out Successfully",Toast.LENGTH_SHORT).show();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}