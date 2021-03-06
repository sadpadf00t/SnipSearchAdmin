package com.example.vibrantzz3.snipsearchadmin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class StylistList extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    List<Stylist> hData;
    String id;
    StylistListRecyclerViewAdapter myAdapter;
    RecyclerView myrv;
    private static final String url_spalist = "http://test.epoqueapparels.com/Salon/Salon_App/spafragment.php";
    JSONObject jsonObject;
    private static final String TAG_PROFILE = "data";
    private static final String TAG_ID = "id";
    private static final String TAG_NAME = "name";
    private static final String TAG_LOC = "location";
    private static final String TAG_RATE = "rating";
    private static final String TAG_PIC = "profilepic";
    private static final String TAG_RCOUNT = "rcount";
    ImageView img, touser;
    TextView uname;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stylistlist);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Stylist");
        mToolbar.setNavigationIcon(R.drawable.backarrow3);
        setSupportActionBar(mToolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        toggle.setDrawerIndicatorEnabled(false);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
        View headview=navigationView.getHeaderView(0);
        img=headview.findViewById(R.id.imageView);
        uname=headview.findViewById(R.id.uname);
        touser=headview.findViewById(R.id.imgto);
        /*uname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(StylistList.this , User.class);

                startActivity(intent);

                //InsertLocation(UName, GetCityName);
            }
        });*/
        //Intent intent = getIntent();
        // id = intent.getExtras().getString("id");

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        hData=new ArrayList<>();



        for(int i=0;i<5;i++){
            //JSONObject json_data = jArray.getJSONObject(i);
            //Parse the JSON response
            hData.add(new Stylist(TAG_NAME, TAG_LOC, TAG_RATE, TAG_PIC, TAG_ID, "string", TAG_RCOUNT));
        }

        myrv=(RecyclerView) findViewById(R.id.spl_recycler);
        myAdapter=new StylistListRecyclerViewAdapter(StylistList.this,hData);
        myrv.setLayoutManager(new LinearLayoutManager(StylistList.this));
        myrv.setAdapter(myAdapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            /*Intent intent = new Intent(SpaList.this , ViewAppointments.class);
            startActivity(intent);*/
        } else if (id == R.id.nav_gallery) {

           /* Intent intent = new Intent(SpaList.this , ViewBookmarksActivity.class);
            startActivity(intent);*/

        } else if (id == R.id.nav_slideshow) {
           /* Intent intent = new Intent(SpaList.this , ViewFavouritesActivity.class);
            startActivity(intent);
*/

        } else if (id == R.id.nav_manage) {
           /* Intent intent = new Intent(SpaList.this , ViewOffers.class);
            startActivity(intent);
*/
        }else if (id == R.id.nav_settings) {
           /* Intent intent = new Intent(SpaList.this , Settings.class);
            startActivity(intent);*/

        } else if (id == R.id.nav_about) {

        } else if (id == R.id.nav_feedback) {

        } else if (id == R.id.nav_playstore) {

        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
