package com.jesusgonzalez.droidshop;

/**
 * Created by Antonio on 23/01/2018.
 */

/**
 * Clase que contiene los códigos usados en "I Wish" para
 * mantener la integridad en las interacciones entre actividades
 * y fragmentos
 * Fuente: http://www.hermosaprogramacion.com/2015/05/crear-un-webservice-para-android-con-mysql-php-y-json/
 */
public class Constantes {
    /**
     * Transición Home -> Detalle
     */
    public static final int CODIGO_DETALLE = 100;

    /**
     * Transición Detalle -> Actualización
     */
    public static final int CODIGO_ACTUALIZACION = 101;

    /**
     * Puerto que utilizas para la conexión.
     * Dejalo en blanco si no has configurado esta carácteristica.
     */
    private static final String PUERTO_HOST = "";

    /**
     * Dirección IP de genymotion o AVD
     */
    private static final String IP = "http://192.168.0.160:";
    /**
     * URLs del Web Service
     */
    public static final String GET = IP + PUERTO_HOST + "/webservice-droidShop/dao/lineaPedidos/get_lineaPedido.php";
    public static final String GET_BY_ID = IP + PUERTO_HOST + "/webservice-droidShop/dao/lineaPedidos/get_mensaje_by_id.php";
    public static final String UPDATE = IP + PUERTO_HOST + "/webservice-droidShop/dao/lineaPedidos/update_mensaje.php";
    public static final String DELETE = IP + PUERTO_HOST + "/webservice-droidShop/dao/lineaPedidos/delete_mensaje.php";
    public static final String INSERT = IP + PUERTO_HOST + "/webservice-droidShop/dao/lineaPedidos/insert_lineaPedido.php";

    /**
     * Clave para el valor extra que representa al identificador de un mensaje
     */
    public static final String EXTRA_ID = "IDEXTRA";

}

