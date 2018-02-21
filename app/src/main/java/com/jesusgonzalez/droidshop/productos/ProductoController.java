package com.jesusgonzalez.droidshop.productos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.SupportActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.jesusgonzalez.droidshop.Constantes;
import com.jesusgonzalez.droidshop.Principal;
import com.jesusgonzalez.droidshop.R;
import com.jesusgonzalez.droidshop.VolleySingleton;
import com.jesusgonzalez.droidshop.productos.dummy.DummyContent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Chusgome on 15/02/2018.
 */

public class ProductoController {
    private static final String TAG = "Producto";
    private Context context; //Contexto desde donde se está realizando la acción
    private View view; //Vista donde se está ejecutando
    private Gson gson = new Gson();

    public ProductoController(Context context, View view) {
        this.context = context;
        this.view = view;
    }

    public void insert(String codigo_producto, String id_proveedor, String precio_coste, String pvp, String iva, String codigo_barras,
                       String stock_actual, String stock_minimo, String stock_maximo, String ruta_foto, String activo) {
        final boolean resultado = false;
        final HashMap<String, String> map = new HashMap<>();
        map.put("codigo_producto", String.valueOf(codigo_producto));
        map.put("id_proveedor", String.valueOf(id_proveedor));
        map.put("precio_coste", String.valueOf(precio_coste));
        map.put("pvp", String.valueOf(pvp));
        map.put("iva", String.valueOf(iva));
        map.put("codigo_barras", String.valueOf(codigo_barras));
        map.put("stock_actual", String.valueOf(stock_actual));
        map.put("stock_minimo", String.valueOf(stock_minimo));
        map.put("stock_maximo", String.valueOf(stock_maximo));
        map.put("ruta_foto", String.valueOf(ruta_foto));
        map.put("activo", String.valueOf(activo));


        // Crear nuevo objeto Json basado en el mapa
        JSONObject jsonObject = new JSONObject(map);

        //Volley
        VolleySingleton.getInstance(context).addToRequestQueue(
                new JsonObjectRequest(Request.Method.POST, Constantes.INSERT_PRODUCTO, jsonObject,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                procesarInsercion(response); // Procesar la respuesta Json
                                //Log.d(TAG,"Inserción correcta");
                                Toast.makeText(context, "INSERCION CORRECTAA", Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d(TAG, "Error Volley: " + error.getMessage());
                                Toast.makeText(context, map.toString(), Toast.LENGTH_SHORT).show();

                            }
                        })  //Fin de JsonObjectRequest
        );
    } //Fin insert

    private void procesarInsercion(JSONObject response) {
        try {
            //Log.d(TAG,"Respuesta: "+response.toString());
            String estado = response.getString("estado");  // Obtener atributo estado
            switch (estado) {
                case "1": // Correcto
                    Toast.makeText(context, "Message added suscessfully", Toast.LENGTH_LONG).show();
                    break;
                case "2": // error
                    Toast.makeText(context, response.getString("mensaje"), Toast.LENGTH_LONG).show();
                    //Snackbar.make(view, response.getString("mensaje"),Snackbar.LENGTH_LONG).show();
                    break;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public void getAll(final ProductoFragment.OnListFragmentInteractionListener listener) {
        Toast.makeText(context, "Empezando.....", Toast.LENGTH_SHORT).show();
        VolleySingleton.getInstance(context).addToRequestQueue(
                new JsonObjectRequest(Request.Method.GET, Constantes.GET_PRODUCTO, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                procesarRespuesta(response, listener); // Procesar la respuesta Json

                                Toast.makeText(context, "PROCESANDOO.....", Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d(TAG, "Error Volley: " + error.getMessage());
                            }
                        }

                )
        );
    }

    private void procesarRespuesta(JSONObject response, ProductoFragment.OnListFragmentInteractionListener listener) {
        try {

            Log.d(TAG, "Respuesta: " + response.toString());
            String estado = response.getString("estado");

            switch (estado) {
                case "1": // correcto
                    JSONArray mensaje = response.getJSONArray("producto");
                    DummyContent.DummyItem[] productos = gson.fromJson(mensaje.toString(), DummyContent.DummyItem[].class); // preparar con Gson
                    DummyContent.ITEMS = new ArrayList<>(Arrays.asList(productos));
                    // MyProductoRecyclerViewAdapter recyclerViewAdapter = new MyProductoRecyclerViewAdapter(new ArrayList<>(Arrays.asList(productos)),listener);

//                    RecyclerView recyclerView = view.findViewById(R.id.reciclerView1);
//                    recyclerView.setAdapter(recyclerViewAdapter);
//                    Bundle bundle = new Bundle();
//                    bundle.putSerializable("com.jesusgonzalez.droidshop.productos.ListaProductos", (Serializable) progetall);
//
//                    Bundle bundle = new Bundle();
//                    bundle.putParcelableArrayList("com.jesusgonzalez.droidshop.productos.ListaProductos", (ArrayList<? extends Parcelable>) progetall);


//                    FragmentManager fm01 = Principal.getFragmentManager();
//                    FragmentTransaction ft01 = fm01.beginTransaction();
//                    ProductoFragment fragment01 = new ProductoFragment();
//                    fragment01.setArguments(bundle);
//                    ft01.replace(R.id.frame_contain01, fragment01);
//                    ft01.commit();




                    // Inicializar adaptador
                    Log.e("clarabolla", productos.toString());
                    ArrayAdapter<DummyContent.DummyItem> adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, productos);
// Lista de linea pedido
                    //lvLineaPedido.setAdapter(adapter);


                    break;
                case "2": // error
                    String mensaje2 = response.getString("mensaje");
                    Toast.makeText(context, mensaje2, Toast.LENGTH_LONG).show();
                    break;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void deleteProducto(String codigoProducto) {
        HashMap<String, String> map = new HashMap<>();
        map.put("codigoProducto", String.valueOf(codigoProducto));
        JSONObject jsonObject = new JSONObject(map); // Crear nuevo objeto Json basado en el mapa

        //Volley
        VolleySingleton.getInstance(context).addToRequestQueue(
                new JsonObjectRequest(Request.Method.POST, Constantes.DELETE_PRODUCTO, jsonObject,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                //procesarRespuesta(response); // Procesar la respuesta Json
                                Log.d(TAG, "Inserción correcta");
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d(TAG, "Error Volley: " + error.getMessage());
                            }
                        })  //Fin de JsonObjectRequest
        );
    }


}
