package myapp.Akka.akkacircle.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.andremion.counterfab.CounterFab;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import myapp.Akka.akkacircle.home.fragment.Cart_Fragment;
import myapp.Akka.akkacircle.home.fragment.Home_Fragment;
import myapp.Akka.akkacircle.home.fragment.Order_Fragment;
import myapp.Akka.akkacircle.home.fragment.Return_Fragment;
import myapp.Akka.akkacircle.home.fragment.Search_Fragment;
import myapp.Akka.akkacircle.home.fragment.Wallet;
import myapp.Akka.akkacircle.R;
import myapp.Akka.akkacircle.Util.SharedPrefManager;
import myapp.Akka.akkacircle.intro.FrontPage;

public class Homepage extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener,NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    Toolbar toolbar;
    CounterFab fab;
    final FragmentManager fm = getSupportFragmentManager();

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        loadFragment(new Home_Fragment());
        setupToolbar();

         fab=findViewById(R.id.fab);
         fab.setVisibility(View.GONE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f=new Cart_Fragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, f)
                        .commit();
            }
        });

        fab.setCount(1);

        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, FrontPage.class));
        }

        NavigationView navigationView = findViewById(R.id. nav_view ) ;
        navigationView.setNavigationItemSelectedListener( this ) ;

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.menu_nearme:
                    fragment = new Home_Fragment();
                    break;
                case R.id.menu_explor:
                    fragment = new Search_Fragment();
                    break;
                case R.id.menu_cart:
                    break;
            }
            return loadFragment(fragment);
        }
    };


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.home:
                fragment = new Home_Fragment();
                break;
            case R.id.wallet:
                fragment = new Wallet();
                break;
            case R.id.Return:
                fragment = new Return_Fragment();
                break;
            case R.id.order:
                fragment =new Order_Fragment();
                break;
            case R.id.aboutus:
                fragment =new Order_Fragment();
                break;
            case R.id.logout:
                SharedPrefManager.getInstance(this).logout();
                finish();
                startActivity(new Intent(this, FrontPage.class));

                break;
        }

        DrawerLayout drawer = findViewById(R.id. drawerlayout ) ;
        drawer.closeDrawer(GravityCompat. START ) ;
        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
      if (fragment != null) {
              getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;

    }


    private void setupToolbar(){
        dl = (DrawerLayout)findViewById(R.id.drawerlayout);
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(null);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        t=new ActionBarDrawerToggle(this,dl,toolbar,R.string.Open,R.string.Close);
        dl.addDrawerListener(t);
        t.syncState();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Fragment fragment=null;
        switch (id){
            case R.id.action_drawer_search:
               // Toast.makeText(getApplicationContext(),"Item 1 Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_drawer_cart:
                Fragment f= new Cart_Fragment();
                loadFragment(f);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }
}
