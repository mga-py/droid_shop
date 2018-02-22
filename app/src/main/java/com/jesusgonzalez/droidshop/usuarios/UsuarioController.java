package com.jesusgonzalez.droidshop.usuarios;

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
import com.jesusgonzalez.droidshop.usuarios.dummy.DummyContent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Chusgome on 15/02/2018.
 */

public class UsuarioController {
    private static final String TAG = "Usuario";
    private Context context; //Contexto desde donde se está realizando la acción
    private View view; //Vista donde se está ejecutando
    private Gson gson = new Gson();

    public UsuarioController(Context context, View view) {
        this.context = context;
        this.view = view;
    }

    public void insert(String codigo_cliente, String nif, String nombre, String apellido1, String apellido2, String numero_cuenta,
                       String rol, String activo, String id_usuario) {
        final boolean resultado = false;
        final HashMap<String, String> map = new HashMap<>();
        map.put("codigo_cliente", String.valueOf(codigo_cliente));
        map.put("nif", String.valueOf(nif));
        map.put("nombre", String.valueOf(nombre));
        map.put("apellido1", String.valueOf(apellido1));
        map.put("apellido2", String.valueOf(apellido2));
        map.put("numero_cuenta", String.valueOf(numero_cuenta));
        map.put("rol", String.valueOf(rol));
        map.put("activo", String.valueOf(activo));
        map.put("id_usuario", String.valueOf(id_usuario));

        // Crear nuevo objeto Json basado en el mapa
        JSONObject jsonObject = new JSONObject(map);

        //Volley
        VolleySingleton.getInstance(context).addToRequestQueue(
                new JsonObjectRequest(Request.Method.POST, Constantes.INSERT_USUARIO, jsonObject,
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


    public void getAll(final UsuariosFragment.OnListFragmentInteractionListener listener) {
        Toast.makeText(context, "Empezando.....", Toast.LENGTH_SHORT).show();
        VolleySingleton.getInstance(context).addToRequestQueue(
                new JsonObjectRequest(Request.Method.GET, Constantes.GET_USUARIO, null,
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

    private void procesarRespuesta(JSONObject response, UsuariosFragment.OnListFragmentInteractionListener listener) {
        try {
            Log.d(TAG, "Respuesta: " + response.toString());
            String estado = response.getString("estado");

            switch (estado) {
                case "1": // correcto
                    JSONArray mensaje = response.getJSONArray("usuario");
                    DummyContent.DummyItem[] usuarios = gson.fromJson(mensaje.toString(), DummyContent.DummyItem[].class); // preparar con Gson
                    DummyContent.ITEMS = new ArrayList<>(Arrays.asList(usuarios));
                    Log.e("anzuelo", usuarios.toString());
                    ArrayAdapter<DummyContent.DummyItem> adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, usuarios);
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

    public void deleteUsuario(String codigoCliente) {
        HashMap<String, String> map = new HashMap<>();
        map.put("codigoCliente", String.valueOf(codigoCliente));
        JSONObject jsonObject = new JSONObject(map); // Crear nuevo objeto Json basado en el mapa

        //Volley
        VolleySingleton.getInstance(context).addToRequestQueue(
                new JsonObjectRequest(Request.Method.POST, Constantes.DELETE_USUARIO, jsonObject,
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

    public void searchUsuario(String codigoUsuario) {
        HashMap<String, String> map = new HashMap<>();
        map.put("codigoUsuario", String.valueOf(codigoUsuario));
        JSONObject jsonObject = new JSONObject(map); // Crear nuevo objeto Json basado en el mapa

        //Volley
        VolleySingleton.getInstance(context).addToRequestQueue(
                new JsonObjectRequest(Request.Method.POST, Constantes.GET_BY_ID_USUARIO, jsonObject,
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

    public void upadate(String codigo_cliente, String nif, String nombre, String apellido1, String apellido2, String numero_cuenta,
                        String rol, String activo) {
        final boolean resultado = false;
        final HashMap<String, String> map = new HashMap<>();
        map.put("codigo_cliente", String.valueOf(codigo_cliente));
        map.put("nif", String.valueOf(nif));
        map.put("nombre", String.valueOf(nombre));
        map.put("apellido1", String.valueOf(apellido1));
        map.put("apellido2", String.valueOf(apellido2));
        map.put("numero_cuenta", String.valueOf(numero_cuenta));
        map.put("rol", String.valueOf(rol));
        map.put("activo", String.valueOf(activo));

        // Crear nuevo objeto Json basado en el mapa
        JSONObject jsonObject = new JSONObject(map);

        //Volley
        VolleySingleton.getInstance(context).addToRequestQueue(
                new JsonObjectRequest(Request.Method.POST, Constantes.UPDATE_USUARIO, jsonObject,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                procesarActualizacion(response); // Procesar la respuesta Json
                                //Log.d(TAG,"Inserción correcta");
                                Toast.makeText(context, "ACTUALIZACION CORRECTAA", Toast.LENGTH_SHORT).show();
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

}
