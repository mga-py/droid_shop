package com.jesusgonzalez.droidshop;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "errores";
    private Gson gson = new Gson();
    private ListView lvLineaPedido;
    private EditText editText_codLineaPedido;
    private EditText editText_idPedido;
    private EditText editText_ipProducto;
    private EditText editText_descripcion;
    private EditText editText_unidades;
    private EditText editText_iva;
    private EditText editText_pvp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        lvLineaPedido = findViewById(R.id.lv_lineaPedido);
        editText_codLineaPedido = findViewById(R.id.editText);
        editText_idPedido = findViewById(R.id.editText2);
        editText_ipProducto = findViewById(R.id.editText3);
        editText_descripcion = findViewById(R.id.editText4);
        editText_unidades = findViewById(R.id.editText5);
        editText_iva = findViewById(R.id.editText6);
        editText_pvp = findViewById(R.id.editText7);
        getMensajes();


    }

    public void clickInsert(View view) {
        insertMensaje(editText_codLineaPedido.getText().toString(), editText_idPedido.getText().toString(), editText_ipProducto.getText().toString(),
                editText_descripcion.getText().toString(), editText_unidades.getText().toString(), editText_iva.getText().toString(), editText_pvp.getText().toString());


    }

    public void insertMensaje(String codLineaPedido, String idPedido, String idProducto, String descripcion, String unidades, String iva, String pvp) {
        final boolean resultado = false;
        final HashMap<String, String> map = new HashMap<>();
        map.put("codigo_linea_pedido", String.valueOf(codLineaPedido));
        map.put("id_pedido", String.valueOf(idPedido));
        map.put("id_producto", String.valueOf(idProducto));
        map.put("descripcion", String.valueOf(descripcion));
        map.put("unidades", String.valueOf(unidades));
        map.put("iva", String.valueOf(iva));
        map.put("pvp", String.valueOf(pvp));


        // Crear nuevo objeto Json basado en el mapa
        JSONObject jsonObject = new JSONObject(map);

        //Volley
        VolleySingleton.getInstance(this).addToRequestQueue(
                new JsonObjectRequest(Request.Method.POST, Constantes.INSERT_LINEAPEDIDO, jsonObject,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                procesarInsercion(response); // Procesar la respuesta Json
                                //Log.d(TAG,"Inserción correcta");
                                Toast.makeText(MainActivity.this, "INSERCION CORRECTAA", Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d(TAG, "Error Volley: " + error.getMessage());
                                Toast.makeText(MainActivity.this, "PETARDAZOOO....", Toast.LENGTH_SHORT).show();
                                Toast.makeText(MainActivity.this, map.toString(), Toast.LENGTH_SHORT).show();

                            }
                        })  //Fin de JsonObjectRequest
        );
    } //Fin insertMensaje

    private void procesarInsercion(JSONObject response) {
        try {
            //Log.d(TAG,"Respuesta: "+response.toString());
            String estado = response.getString("estado");  // Obtener atributo estado
            switch (estado) {
                case "1": // Correcto
                    Toast.makeText(this, "Message added suscessfully", Toast.LENGTH_LONG).show();
                    break;
                case "2": // error
                    Toast.makeText(this, response.getString("mensaje"), Toast.LENGTH_LONG).show();
                    //Snackbar.make(view, response.getString("mensaje"),Snackbar.LENGTH_LONG).show();
                    break;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public void getMensajes() {
        Toast.makeText(MainActivity.this, "Empezando.....", Toast.LENGTH_SHORT).show();
        VolleySingleton.getInstance(this).addToRequestQueue(
                new JsonObjectRequest(Request.Method.GET, Constantes.GET_LINEAPEDIDO, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                procesarRespuesta(response); // Procesar la respuesta Json
                                Toast.makeText(MainActivity.this, "PROCESANDOO.....", Toast.LENGTH_SHORT).show();
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

    private void procesarRespuesta(JSONObject response) {
        try {
            Log.d(TAG, "Respuesta: " + response.toString());
            String estado = response.getString("estado");

            switch (estado) {
                case "1": // correcto
                    JSONArray mensaje = response.getJSONArray("linea_pedido");
                    LineaPedido[] mensajes = gson.fromJson(mensaje.toString(), LineaPedido[].class); // preparar con Gson
                    // Inicializar adaptador
                    ArrayAdapter<LineaPedido> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mensajes);

                    lvLineaPedido.setAdapter(adapter);
                    break;
                case "2": // error
                    String mensaje2 = response.getString("mensaje");
                    Toast.makeText(
                            getApplicationContext(),

                            mensaje2,
                            Toast.LENGTH_LONG).show();
                    break;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
