package eus.ilanda.navigationdrawer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;



public class OwnerFragment extends android.support.v4.app.Fragment{

    Button signOut;
    private FragmentTabHost tabHost;

    BottomNavigationView navigationView;

    private BottomNavigationView.OnNavigationItemSelectedListener navViewMenuListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case(R.id.nav_fav):
                    Toast.makeText(getContext(), "Fav icon selected" , Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        }
    };



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.activity_owner, container, false);
        setUpControls(v);
       return v;
    }

    public void setUpControls(View v){
    navigationView= v.findViewById(R.id.bottom_navigation);

    navigationView.setOnNavigationItemSelectedListener(navViewMenuListener);

    }


    /**  public void signOut(){
        AuthUI.getInstance().signOut(this).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    startActivity(MainActivity.createIntent(OwnerActivity.this));
                }else{ //sign out failed
                    Toast.makeText(OwnerActivity.this, "Sign out failed", Toast.LENGTH_SHORT);
                }
            }
        });
    }/**

   /** public static Intent createIntent(Context context) {
        Intent in  = new Intent();
        in.setClass(context, OwnerActivity.class);
        return in;
    }**/
}
