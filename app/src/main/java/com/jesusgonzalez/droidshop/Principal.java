package com.jesusgonzalez.droidshop;


import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
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

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.jesusgonzalez.droidshop.pedidos.AddPedidoFragment;
import com.jesusgonzalez.droidshop.pedidos.DeletePedidoFragment;
import com.jesusgonzalez.droidshop.pedidos.PedidosFragment;
import com.jesusgonzalez.droidshop.pedidos.UpdatePedidoFragment;
import com.jesusgonzalez.droidshop.productos.AddProductoFragment;
import com.jesusgonzalez.droidshop.productos.DeleteProductoFragment;
import com.jesusgonzalez.droidshop.productos.ProductoFragment;
import com.jesusgonzalez.droidshop.productos.UpdateProductoFragment;
import com.jesusgonzalez.droidshop.productos.dummy.DummyContent;
import com.jesusgonzalez.droidshop.usuarios.AddUsuarioFragment;
import com.jesusgonzalez.droidshop.usuarios.DeleteUsuarioFragment;
import com.jesusgonzalez.droidshop.usuarios.UpdateUsuarioFragment;
import com.jesusgonzalez.droidshop.usuarios.UsuariosFragment;

public class Principal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ProductoFragment.OnListFragmentInteractionListener, UsuariosFragment.OnListFragmentInteractionListener, PedidosFragment.OnListFragmentInteractionListener,
        AddProductoFragment.OnFragmentInteractionListener, UpdateProductoFragment.OnFragmentInteractionListener, DeleteProductoFragment.OnFragmentInteractionListener,
        AddUsuarioFragment.OnFragmentInteractionListener, UpdateUsuarioFragment.OnFragmentInteractionListener, DeleteUsuarioFragment.OnFragmentInteractionListener,
        AddPedidoFragment.OnFragmentInteractionListener, UpdatePedidoFragment.OnFragmentInteractionListener, DeletePedidoFragment.OnFragmentInteractionListener {

    private static final String LISTA_PRODUCTOS = "com.jesusgonzalez.droidshop.productos.ListaProductos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void loadFragmentsProductos() {
        FragmentManager fm01 = getSupportFragmentManager();
        FragmentTransaction ft01 = fm01.beginTransaction();
        ProductoFragment fragment01 = new ProductoFragment();
        //fragment01.setArguments(bundle);
        ft01.replace(R.id.frame_contain01, fragment01);
        ft01.commit();
    }

    private void loadFragmentsUsuarios() {
        FragmentManager fm01 = getSupportFragmentManager();
        FragmentTransaction ft01 = fm01.beginTransaction();
        UsuariosFragment fragment01 = new UsuariosFragment();
        //fragment01.setArguments(bundle);
        ft01.replace(R.id.frame_contain01, fragment01);
        ft01.commit();
    }

    private void loadFragmentsPedidos() {
        FragmentManager fm01 = getSupportFragmentManager();
        FragmentTransaction ft01 = fm01.beginTransaction();
        PedidosFragment fragment01 = new PedidosFragment();
        //fragment01.setArguments(bundle);
        ft01.replace(R.id.frame_contain01, fragment01);
        ft01.commit();
    }

    @SuppressLint("WrongConstant")
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        //PRODUCTOS
        if (id == R.id.nav_products) {
            //LIST
            loadFragmentsProductos();

            final FloatingActionsMenu menu = findViewById(R.id.menu_fab);
            menu.setVisibility(1);

            //ADD
            FloatingActionButton btAdd = findViewById(R.id.fabAdd);
            btAdd.setTitle("Añadir Producto");
            btAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadAddProducto();
                    menu.collapse();
                }
            });
            //UPDATE
            FloatingActionButton btUpdate = findViewById(R.id.fabUpdate);
            btUpdate.setTitle("Actualizar Producto");
            btUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadUpdateProducto();
                    menu.collapse();
                }
            });
            //DELETE
            FloatingActionButton btDelete = findViewById(R.id.fabDelete);
            btDelete.setTitle("Borrar Producto");
            btDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadDeleteProducto();
                    menu.collapse();
                }
            });

            //PEDIDOS
        } else if (id == R.id.nav_orders) {
            loadFragmentsPedidos();
            final FloatingActionsMenu menu = findViewById(R.id.menu_fab);
            menu.setVisibility(1);
            //ADD
            FloatingActionButton btAdd = findViewById(R.id.fabAdd);
            btAdd.setTitle("Añadir Pedido");
            btAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadAddPedido();
                    menu.collapse();
                }
            });
            //UPDATE
            FloatingActionButton btUpdate = findViewById(R.id.fabUpdate);
            btUpdate.setTitle("Actualizar Pedido");
            btUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadUpdatePedido();
                    menu.collapse();
                }
            });
            //DELETE
            FloatingActionButton btDelete = findViewById(R.id.fabDelete);
            btDelete.setTitle("Borrar Pedido");
            btDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadDeletePedido();
                    menu.collapse();
                }
            });

        } else if (id == R.id.nav_cart) {
            final FloatingActionsMenu menu = findViewById(R.id.menu_fab);
            menu.setVisibility(1);
            //CLIENTES
        } else if (id == R.id.nav_clients) {
            loadFragmentsUsuarios();

            final FloatingActionsMenu menu = findViewById(R.id.menu_fab);
            menu.setVisibility(1);
            //ADD
            FloatingActionButton btAdd = findViewById(R.id.fabAdd);
            btAdd.setTitle("Añadir Usuario");
            btAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadAddUsuario();
                    menu.collapse();
                }
            });
            //UPDATE
            FloatingActionButton btUpdate = findViewById(R.id.fabUpdate);
            btUpdate.setTitle("Actualizar Usuario");
            btUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadUpdateUsuario();
                    menu.collapse();
                }
            });
            //DELETE
            FloatingActionButton btDelete = findViewById(R.id.fabDelete);
            btDelete.setTitle("Borrar Usuario");
            btDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadDeleteUsuario();
                    menu.collapse();
                }
            });

        } else if (id == R.id.nav_profile) {
        } else if (id == R.id.nav_logout) {
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    //FRAGMENTOS
    //---PRODUCTOS
    public void loadAddProducto() {
        FragmentManager fm01 = getSupportFragmentManager();
        FragmentTransaction ft01 = fm01.beginTransaction();
        AddProductoFragment fragment01 = new AddProductoFragment();
        //fragment01.setArguments(bundle);
        ft01.replace(R.id.frame_contain01, fragment01);
        ft01.commit();
    }

    public void loadUpdateProducto() {
        FragmentManager fm01 = getSupportFragmentManager();
        FragmentTransaction ft01 = fm01.beginTransaction();
        UpdateProductoFragment fragment01 = new UpdateProductoFragment();
        //fragment01.setArguments(bundle);
        ft01.replace(R.id.frame_contain01, fragment01);
        ft01.commit();
    }

    public void loadDeleteProducto() {
        FragmentManager fm01 = getSupportFragmentManager();
        FragmentTransaction ft01 = fm01.beginTransaction();
        DeleteProductoFragment fragment01 = new DeleteProductoFragment();
        //fragment01.setArguments(bundle);
        ft01.replace(R.id.frame_contain01, fragment01);
        ft01.commit();
    }

    //---PEDIDOS
    public void loadAddPedido() {
        FragmentManager fm01 = getSupportFragmentManager();
        FragmentTransaction ft01 = fm01.beginTransaction();
        AddPedidoFragment fragment01 = new AddPedidoFragment();
        //fragment01.setArguments(bundle);
        ft01.replace(R.id.frame_contain01, fragment01);
        ft01.commit();
    }

    public void loadUpdatePedido() {
        FragmentManager fm01 = getSupportFragmentManager();
        FragmentTransaction ft01 = fm01.beginTransaction();
        UpdatePedidoFragment fragment01 = new UpdatePedidoFragment();
        //fragment01.setArguments(bundle);
        ft01.replace(R.id.frame_contain01, fragment01);
        ft01.commit();
    }

    public void loadDeletePedido() {
        FragmentManager fm01 = getSupportFragmentManager();
        FragmentTransaction ft01 = fm01.beginTransaction();
        DeletePedidoFragment fragment01 = new DeletePedidoFragment();
        //fragment01.setArguments(bundle);
        ft01.replace(R.id.frame_contain01, fragment01);
        ft01.commit();
    }

    //---USUARIOS
    public void loadAddUsuario() {
        FragmentManager fm01 = getSupportFragmentManager();
        FragmentTransaction ft01 = fm01.beginTransaction();
        AddUsuarioFragment fragment01 = new AddUsuarioFragment();
        //fragment01.setArguments(bundle);
        ft01.replace(R.id.frame_contain01, fragment01);
        ft01.commit();
    }

    public void loadUpdateUsuario() {
        FragmentManager fm01 = getSupportFragmentManager();
        FragmentTransaction ft01 = fm01.beginTransaction();
        UpdateUsuarioFragment fragment01 = new UpdateUsuarioFragment();
        //fragment01.setArguments(bundle);
        ft01.replace(R.id.frame_contain01, fragment01);
        ft01.commit();
    }

    public void loadDeleteUsuario() {
        FragmentManager fm01 = getSupportFragmentManager();
        FragmentTransaction ft01 = fm01.beginTransaction();
        DeleteUsuarioFragment fragment01 = new DeleteUsuarioFragment();
        //fragment01.setArguments(bundle);
        ft01.replace(R.id.frame_contain01, fragment01);
        ft01.commit();
    }


    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
    }
    @Override
    public void onFragmentInteraction(Uri uri) {
    }
    @Override
    public void onListFragmentInteraction(com.jesusgonzalez.droidshop.pedidos.dummy.DummyContent.DummyItem item) {
    }
    @Override
    public void onListFragmentInteraction(com.jesusgonzalez.droidshop.usuarios.dummy.DummyContent.DummyItem item) {
    }
}
