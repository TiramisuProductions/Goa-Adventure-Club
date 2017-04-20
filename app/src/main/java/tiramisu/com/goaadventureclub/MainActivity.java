package tiramisu.com.goaadventureclub;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
         {

    public static FragmentManager mFragmentManager;
    public static FragmentTransaction mFragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



      final  DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView, new UpcomingTripsFragment()).commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();
                FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

                switch (item.getItemId()) {
                    case R.id.hotelreviewsforgoans:

                        fragmentTransaction.replace(R.id.containerView, new HotelReviewsForGoans()).commit();
                        return true;

                    case  R.id.hotelreviewsforoutsiders :
                        fragmentTransaction.replace(R.id.containerView, new HotelsReviewsforOutSide()).commit();
                        return true;
                    case  R.id.previoustrips :
                        fragmentTransaction.replace(R.id.containerView, new PreviousTripsFragment()).commit();
                        return true;
                    case  R.id.suggestionforgoantravellers :
                        fragmentTransaction.replace(R.id.containerView, new SuggestionforGoan()).commit();
                        return true;
                    case  R.id.suggestionforoutsidetravellers :
                        fragmentTransaction.replace(R.id.containerView, new SuggestionForOutside()).commit();
                        return true;
                    case  R.id.travellerreviews :
                        fragmentTransaction.replace(R.id.containerView, new TravellerReviewsFragment()).commit();
                        return true;
                    case  R.id.upcomingtrips :
                        fragmentTransaction.replace(R.id.containerView, new UpcomingTripsFragment()).commit();
                        return true;

                    default:
                        return true;
            }
        }});

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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
