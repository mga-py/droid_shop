package com.jesusgonzalez.droidshop;

/**
 * Created by Antonio on 23/01/2018.
 */

//Fuente: http://www.hermosaprogramacion.com/2015/05/crear-un-webservice-para-android-con-mysql-php-y-json/
//Fuente: https://developer.android.com/training/volley/index.html

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public final class VolleySingleton {
    private static VolleySingleton singleton;
    private RequestQueue requestQueue;
    private static Context context;

    private VolleySingleton(Context context) {
        VolleySingleton.context = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized VolleySingleton getInstance(Context context) {
        if (singleton == null) {
            singleton = new VolleySingleton(context.getApplicationContext());
        }
        return singleton;
    }

    public RequestQueue getRequestQueue() { //Obtiene la instancia de la cola de peticiones
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) { //Añade petición a la cola
        getRequestQueue().add(req);
    }

}
