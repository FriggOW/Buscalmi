package com.browser.buscalmi;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.browser.buscalmi.Fragmentos.FragAmazon;
import com.browser.buscalmi.Fragmentos.FragInicio;
import com.browser.buscalmi.Fragmentos.FragSoon;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private FragInicio fIni =  new FragInicio();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

       //getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.entrada, R.anim.salida).replace(R.id.Cprincipal, new FragInicio()).addToBackStack(null).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.Cprincipal, fIni).addToBackStack(null).commit();

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

    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.nav_home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.Cprincipal, new FragInicio()).addToBackStack(null).commit();

        }else if (id == R.id.nav_amazon) {
            getSupportFragmentManager().beginTransaction().replace(R.id.Cprincipal, new FragAmazon()).addToBackStack(null).commit();

        } else if (id == R.id.nav_ebay) {
            getSupportFragmentManager().beginTransaction().replace(R.id.Cprincipal, new FragInicio()).addToBackStack(null).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.searchbar,menu);
        MenuItem mSearch = menu.findItem(R.id.searchbar);
        SearchView mSearchView = (SearchView) mSearch.getActionView();

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                fIni.Filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
