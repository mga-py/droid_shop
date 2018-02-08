<?php

require 'PedidoDAO.php';

if ($_SERVER['REQUEST_METHOD'] == 'GET') {
    $mensajes = PedidoDAO::getAll();
    if ($mensajes) {
        $datos["estado"] = 1;
        $datos["pedido"] = $mensajes;
        print json_encode($datos);
    } else {
        print json_encode(array(
            "estado" => 2,
            "resultado" => "Ha ocurrido un error"
        ));
    }
}