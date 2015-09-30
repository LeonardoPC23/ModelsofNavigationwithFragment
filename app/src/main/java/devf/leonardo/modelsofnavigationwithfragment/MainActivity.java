package devf.leonardo.modelsofnavigationwithfragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import devf.leonardo.modelsofnavigationwithfragment.activity.Login;
import devf.leonardo.modelsofnavigationwithfragment.domain.Udacity;
import devf.leonardo.modelsofnavigationwithfragment.fragment.FragmentCourse;
import devf.leonardo.modelsofnavigationwithfragment.fragment.FragmentHomePage;
import devf.leonardo.modelsofnavigationwithfragment.fragment.FragmentHouse;
import devf.leonardo.modelsofnavigationwithfragment.fragment.FragmentInstructor;
import devf.leonardo.modelsofnavigationwithfragment.io.adapter.MyAdapterRecycler;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    ListView myListView;
    private ArrayList<Udacity> myListaArtist;
    MyAdapterRecycler adapterRecyclerView;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolBar();
        setupDrawer();
        replaceFragment(new FragmentHouse());
        SharedPreferences preferences = getSharedPreferences()
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        Fragment fragment = null;
        Class fragmentClass = null;

        Class aClass;

        switch (menuItem.getItemId()) {
            case R.id.item_navigation_home:
                fragmentClass = FragmentHouse.class;
                Log.d("Navigation", "Home");
                drawerLayout.closeDrawers();
                break;
            case R.id.item_navigation_course:
                fragmentClass = FragmentCourse.class;
                Log.d("Navigation", "Curso");
                drawerLayout.closeDrawers();
                break;
            case R.id.item_navigation_instructor:
                Log.d("Navigation", "Instructor");
                fragmentClass = FragmentInstructor.class;
                drawerLayout.closeDrawers();
                break;
            case R.id.item_navigation_web:
                Log.d("Navigation", "HomePage");
                fragmentClass = FragmentHomePage.class;
                drawerLayout.closeDrawers();
                break;
            case R.id.item_logout:
                setupLogOut();
                break;
            default:
                fragmentClass = FragmentHouse.class;
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        replaceFragment(fragment);


        // Highlight the selected item, update the title, and close the drawer
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());


        return false;
    }

    //metodo de remplazar Fragmentos
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = MainActivity.this.getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_fragment, fragment).commit();

    }

    //metodo Drawer
    public void setupDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    //metodo ToolBar

    public void setupToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);

    }

    public void setupLogOut() {
        SharedPreferences preferences = getSharedPreferences("Save", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit().clear();

        editor.commit();
        Intent login = new Intent(this, Login.class);
        startActivity(login);
    }
}


