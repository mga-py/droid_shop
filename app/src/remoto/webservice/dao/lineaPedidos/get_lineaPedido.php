<?php

require 'LineaPedidoDAO.php';

if ($_SERVER['REQUEST_METHOD'] == 'GET') {
    $mensajes = LineaPedidoDAO::getAll();
    if ($mensajes) {
        $datos["estado"] = 1;
        $datos["linea_pedido"] = $mensajes;
        print json_encode($datos);
    } else {
        print json_encode(array(
            "estado" => 2,
            "resultado" => "Ha ocurrido un error"
        ));
    }
}