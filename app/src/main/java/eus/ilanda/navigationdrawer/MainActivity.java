package eus.ilanda.navigationdrawer;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    NavigationView nav_view;

    View header_view;

    TextView text,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nav_view = (NavigationView) findViewById(R.id.nav_view);

        header_view = nav_view.getHeaderView(0);

        //Change name and email texts from the header view
        text = (TextView) header_view.findViewById(R.id.nav_txt_name);
        email = (TextView) header_view.findViewById(R.id.nav_txt_email);
        text.setText("Name");
        email.setText("mail@gmail.com");


        //Use our  own toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


           getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new OwnerFragment()).commit();
            Toast.makeText(this, "On create", Toast.LENGTH_LONG);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch ( item.getItemId()){
            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new OwnerFragment()).commit();
                Toast.makeText(this, "On create", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_exit:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new Fragment()).commit();
                 break;
            case R.id.nav_fav:
                Toast.makeText(this,"fac Icon", Toast.LENGTH_SHORT).show();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}
