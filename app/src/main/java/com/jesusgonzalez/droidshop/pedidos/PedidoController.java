package com.jesusgonzalez.droidshop.pedidos;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.jesusgonzalez.droidshop.Constantes;
import com.jesusgonzalez.droidshop.VolleySingleton;
import com.jesusgonzalez.droidshop.pedidos.dummy.DummyContent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Chusgome on 15/02/2018.
 */

public class PedidoController {
    private static final String TAG = "Pedido";
    private Context context; //Contexto desde donde se está realizando la acción
    private View view; //Vista donde se está ejecutando
    private Gson gson = new Gson();

    public PedidoController(Context context, View view) {
        this.context = context;
        this.view = view;
    }

    public void insert(String codigo_pedido, String id_empleado_empaqueta, String empresa_transporte, String fecha_pedido, String fecha_envio, String fecha_entrega,
                       String fecha_pago, String id_factura, String facturado, String metodo_pago, String id_usuario, String activo) {
        final boolean resultado = false;
        final HashMap<String, String> map = new HashMap<>();
        map.put("codigo_pedido", String.valueOf(codigo_pedido));
        map.put("id_empleado_empaqueta", String.valueOf(id_empleado_empaqueta));
        map.put("empresa_transporte", String.valueOf(empresa_transporte));
        map.put("fecha_pedido", String.valueOf(fecha_pedido));
        map.put("fecha_envio", String.valueOf(fecha_envio));
        map.put("fecha_entrega", String.valueOf(fecha_entrega));
        map.put("fecha_pago", String.valueOf(fecha_pago));
        map.put("id_factura", String.valueOf(id_factura));
        map.put("facturado", String.valueOf(facturado));
        map.put("metodo_pago", String.valueOf(metodo_pago));
        map.put("id_usuario", String.valueOf(id_usuario));
        map.put("activo", String.valueOf(activo));


        // Crear nuevo objeto Json basado en el mapa
        JSONObject jsonObject = new JSONObject(map);

        //Volley
        VolleySingleton.getInstance(context).addToRequestQueue(
                new JsonObjectRequest(Request.Method.POST, Constantes.INSERT_PEDIDO, jsonObject,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                procesarInsercion(response); // Procesar la respuesta Json
                                //Log.d(TAG,"Inserción correcta");
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
                    Toast.makeText(context, "Order added suscessfully", Toast.LENGTH_LONG).show();
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


    public void getAll(final PedidosFragment.OnListFragmentInteractionListener listener) {
        Toast.makeText(context, "Empezando...", Toast.LENGTH_SHORT).show();
        VolleySingleton.getInstance(context).addToRequestQueue(
                new JsonObjectRequest(Request.Method.GET, Constantes.GET_PEDIDO, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                procesarRespuesta(response, listener); // Procesar la respuesta Json
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

    private void procesarRespuesta(JSONObject response, PedidosFragment.OnListFragmentInteractionListener listener) {
        try {
            Log.d(TAG, "Respuesta: " + response.toString());
            String estado = response.getString("estado");

            switch (estado) {
                case "1": // correcto
                    JSONArray mensaje = response.getJSONArray("pedido");
                    DummyContent.DummyItem[] pedidos = gson.fromJson(mensaje.toString(), DummyContent.DummyItem[].class); // preparar con Gson
                    DummyContent.ITEMS = new ArrayList<>(Arrays.asList(pedidos));
                    // Inicializar adaptador

                    Log.e("boveda", pedidos.toString());
                    ArrayAdapter<DummyContent.DummyItem> adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, pedidos);
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


    public void deletePedido(String codigoPedido) {
        HashMap<String, String> map = new HashMap<>();
        map.put("codigoPedido", String.valueOf(codigoPedido));
        JSONObject jsonObject = new JSONObject(map); // Crear nuevo objeto Json basado en el mapa

        //Volley
        VolleySingleton.getInstance(context).addToRequestQueue(
                new JsonObjectRequest(Request.Method.POST, Constantes.DELETE_PEDIDO, jsonObject,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                //procesarRespuesta(response); // Procesar la respuesta Json
                                Log.d(TAG, "Borrado correcto");
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

    public void searchPedido(String codigoPedido) {
        HashMap<String, String> map = new HashMap<>();
        map.put("codigoPedido", String.valueOf(codigoPedido));
        JSONObject jsonObject = new JSONObject(map); // Crear nuevo objeto Json basado en el mapa

        //Volley
        VolleySingleton.getInstance(context).addToRequestQueue(
                new JsonObjectRequest(Request.Method.POST, Constantes.GET_BY_ID_PEDIDO, jsonObject,
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


    public void update(String id_empleado_empaqueta, String empresa_transporte, String fecha_pedido, String id_factura,
                       String facturado, String metodo_pago, String id_usuario, String activo, String codigo_pedido) {
        final boolean resultado = false;
        final HashMap<String, String> map = new HashMap<>();
        map.put("id_empleado_empaqueta", String.valueOf(id_empleado_empaqueta));
        map.put("empresa_transporte", String.valueOf(empresa_transporte));
        map.put("fecha_pedido", String.valueOf(fecha_pedido));
        map.put("id_factura", String.valueOf(id_factura));
        map.put("facturado", String.valueOf(facturado));
        map.put("metodo_pago", String.valueOf(metodo_pago));
        map.put("id_usuario", String.valueOf(id_usuario));
        map.put("activo", String.valueOf(activo));
        map.put("codigo_pedido", String.valueOf(codigo_pedido));


        // Crear nuevo objeto Json basado en el mapa
        JSONObject jsonObject = new JSONObject(map);

        //Volley
        VolleySingleton.getInstance(context).addToRequestQueue(
                new JsonObjectRequest(Request.Method.POST, Constantes.UPDATE_PEDIDO, jsonObject,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                procesarActualizacion(response); // Procesar la respuesta Json
                                //Log.d(TAG,"Inserción correcta");
                                Toast.makeText(context, "ACTUALIZACION CORRECTA", Toast.LENGTH_SHORT).show();
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
    }

    private void procesarActualizacion(JSONObject response) {
        try {
            //Log.d(TAG,"Respuesta: "+response.toString());
            String estado = response.getString("estado");  // Obtener atributo estado
            switch (estado) {
                case "1": // Correcto
                    Toast.makeText(context, "Pedido updated suscessfully", Toast.LENGTH_LONG).show();
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
}
