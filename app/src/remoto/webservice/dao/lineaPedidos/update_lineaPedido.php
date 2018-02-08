<?php

require 'LineaPedidoDAO.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    $body = json_decode(file_get_contents("php://input"), true);

    $resultado = LineaPedidoDAO::actualizaLineaPedido(
        $body['codigo_linea_pedido'],
        $body['id_pedido'],
        $body['id_producto'],
        $body['descripcion'],
        $body['unidades'],
        $body['iva'],
        $body['pvp'],
        $body['id']);

    if ($resultado) {
        print json_encode(
            array(
                'estado' => '1',
                'mensaje' => 'Operación correcta')
        );
    } else {
        print json_encode(
            array(
                'estado' => '2',
                'mensaje' => 'Error en la operación')
        );
    }
}