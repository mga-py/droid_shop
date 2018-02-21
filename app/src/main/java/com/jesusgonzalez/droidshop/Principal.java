package com.jesusgonzalez.droidshop;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.jesusgonzalez.droidshop.productos.AddProductoFragment;
import com.jesusgonzalez.droidshop.productos.ProductoController;
import com.jesusgonzalez.droidshop.productos.ProductoFragment;
import com.jesusgonzalez.droidshop.productos.dummy.DummyContent;

import java.io.Serializable;

public class Principal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ProductoFragment.OnListFragmentInteractionListener, AddProductoFragment.OnFragmentInteractionListener {

    private static final String LISTA_PRODUCTOS = "com.jesusgonzalez.droidshop.productos.ListaProductos";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void loadFragmentsProductos() {
        //Bundle bundle = new Bundle();
        //bundle.putSerializable(LISTA_PRODUCTOS, (Serializable) noticias);

//        ProductoController productoController = new ProductoController(this,getCurrentFocus());
//        productoController.getAll(mListener);

        FragmentManager fm01 = getSupportFragmentManager();
        FragmentTransaction ft01 = fm01.beginTransaction();
        ProductoFragment fragment01 = new ProductoFragment();
        //fragment01.setArguments(bundle);
        ft01.replace(R.id.frame_contain01, fragment01);
        ft01.commit();
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
        getMenuInflater().inflate(R.menu.principal, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_products) {
            // Handle the camera action

            loadFragmentsProductos();


        } else if (id == R.id.nav_orders) {

        } else if (id == R.id.nav_cart) {

        } else if (id == R.id.nav_clients) {

        } else if (id == R.id.nav_profile) {

        } else if (id == R.id.nav_logout) {
            loadFragmentsadd();



        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    private void loadFragmentsadd() {
        //Bundle bundle = new Bundle();
        //bundle.putSerializable(LISTA_PRODUCTOS, (Serializable) noticias);

//        ProductoController productoController = new ProductoController(this,getCurrentFocus());
//        productoController.getAll(mListener);

        FragmentManager fm01 = getSupportFragmentManager();
        FragmentTransaction ft01 = fm01.beginTransaction();
        AddProductoFragment fragment01 = new AddProductoFragment();
        //fragment01.setArguments(bundle);
        ft01.replace(R.id.frame_contain01, fragment01);
        ft01.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
