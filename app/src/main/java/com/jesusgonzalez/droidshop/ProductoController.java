package com.jesusgonzalez.droidshop;

import android.content.Context;
import android.view.View;

import com.google.gson.Gson;

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
}
