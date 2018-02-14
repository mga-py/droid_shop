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

    //LINEA PEDIDO
    public static final String GET_LINEAPEDIDO = IP + PUERTO_HOST + "/webservice-droidShop/dao/lineaPedidos/get_lineaPedido.php";
    public static final String GET_BY_ID_LINEAPEDIDO = IP + PUERTO_HOST + "/webservice-droidShop/dao/lineaPedidos/get_lineaPedido_by_id.php";
    public static final String UPDATE_LINEAPEDIDO = IP + PUERTO_HOST + "/webservice-droidShop/dao/lineaPedidos/update_lineaPedido.php";
    public static final String DELETE_LINEAPEDIDO = IP + PUERTO_HOST + "/webservice-droidShop/dao/lineaPedidos/delete_lineaPedido.php";
    public static final String INSERT_LINEAPEDIDO = IP + PUERTO_HOST + "/webservice-droidShop/dao/lineaPedidos/insert_lineaPedido.php";

    //PEDIDO
    public static final String GET_PEDIDO = IP + PUERTO_HOST + "/webservice-droidShop/dao/lineaPedidos/get_pedido.php";
    public static final String GET_BY_ID_PEDIDO = IP + PUERTO_HOST + "/webservice-droidShop/dao/lineaPedidos/get_pedido_by_id.php";
    public static final String UPDATE_PEDIDO = IP + PUERTO_HOST + "/webservice-droidShop/dao/lineaPedidos/update_pedido.php";
    public static final String DELETE_PEDIDO = IP + PUERTO_HOST + "/webservice-droidShop/dao/lineaPedidos/delete_pedido.php";
    public static final String INSERT_PEDIDO = IP + PUERTO_HOST + "/webservice-droidShop/dao/lineaPedidos/insert_pedido.php";

    //PRODUCTO
    public static final String GET_PRODUCTO = IP + PUERTO_HOST + "/webservice-droidShop/dao/lineaPedidos/get_producto.php";
    public static final String GET_BY_ID_PRODUCTO = IP + PUERTO_HOST + "/webservice-droidShop/dao/lineaPedidos/get_producto_by_id.php";
    public static final String UPDATE_PRODUCTO = IP + PUERTO_HOST + "/webservice-droidShop/dao/lineaPedidos/update_producto.php";
    public static final String DELETE_PRODUCTO = IP + PUERTO_HOST + "/webservice-droidShop/dao/lineaPedidos/delete_producto.php";
    public static final String INSERT_PRODUCTO = IP + PUERTO_HOST + "/webservice-droidShop/dao/lineaPedidos/insert_producto.php";

    //USUARIO
    public static final String GET_USUARIO = IP + PUERTO_HOST + "/webservice-droidShop/dao/lineaPedidos/get_usuario.php";
    public static final String GET_BY_ID_USUARIO = IP + PUERTO_HOST + "/webservice-droidShop/dao/lineaPedidos/get_usuario_by_id.php";
    public static final String UPDATE_USUARIO = IP + PUERTO_HOST + "/webservice-droidShop/dao/lineaPedidos/update_usuario.php";
    public static final String DELETE_USUARIO = IP + PUERTO_HOST + "/webservice-droidShop/dao/lineaPedidos/delete_usuario.php";
    public static final String INSERT_USUARIO = IP + PUERTO_HOST + "/webservice-droidShop/dao/lineaPedidos/insert_usuario.php";

    /**
     * Clave para el valor extra que representa al identificador de un mensaje
     */
    public static final String EXTRA_ID = "IDEXTRA";

}

