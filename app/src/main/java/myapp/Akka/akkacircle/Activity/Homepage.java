package myapp.Akka.akkacircle.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import myapp.Akka.akkacircle.Fragment.Cart_Fragment;
import myapp.Akka.akkacircle.Fragment.Home_Fragment;
import myapp.Akka.akkacircle.Fragment.Meat_Fragment;
import myapp.Akka.akkacircle.Fragment.Order_Fragment;
import myapp.Akka.akkacircle.Fragment.Return_Fragment;
import myapp.Akka.akkacircle.Fragment.Search_Fragment;
import myapp.Akka.akkacircle.Fragment.Wallet;
import myapp.Akka.akkacircle.R;

public class Homepage extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener,NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    Toolbar toolbar;
    final Fragment fragment1= new Home_Fragment();
    final Fragment fragment2= new Search_Fragment();
    final Fragment fragment3= new Cart_Fragment();

    final FragmentManager fm = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        loadFragment(new Home_Fragment());
       setupToolbar();

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
                    fragment = new Cart_Fragment();
                    break;
            }
            return loadFragment(fragment);
        }
    };


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
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
                startActivity(new Intent(Homepage.this,LoginActivity.class));
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
 /**  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.drawermenu, menu);
       return true;

   }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.wallet:
                Toast.makeText(getApplicationContext(),"Item 1 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.Return:
                Toast.makeText(getApplicationContext(),"Item 2 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.order:
                Toast.makeText(getApplicationContext(),"Item 3 Selected",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

**/
  /**  @Override
    public void onNavigationDrawerItemSelected(int position) {
        Fragment fragment = null;


        switch (position) {
            case R.id.menu_nearme:

                fragment = new Home_Fragment();
                break;

            case R.id.menu_explor:
                fragment = new Search_Fragment();
                break;
            case R.id.menu_cart:
                fragment = new Cart_Fragment();
                break;

        }

    }**/
}
