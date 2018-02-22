<?php

require 'ProductoDAO.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {


    $body = json_decode(file_get_contents("php://input"), true);

    $resultado = ProductoDAO::altaProducto(
        $body['codigo_producto'],
        $body['descripcion'],
        $body['id_proveedor'],
        $body['precio_coste'],
        $body['pvp'],
        $body['iva'],
        $body['codigo_barras'],
        $body['stock_actual'],
        $body['stock_minimo'],
        $body['stock_maximo'],
        $body['ruta_foto'],
        $body['activo']);

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