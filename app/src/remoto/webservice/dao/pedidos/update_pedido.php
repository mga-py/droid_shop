<?php

require 'PedidoDAO.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    $body = json_decode(file_get_contents("php://input"), true);

    $resultado = PedidoDAO::actualizaPedido(
        $body['codigo_pedido'],
        $body['id_empleado_empaqueta'],
        $body['empresa_transporte'],
        $body['fecha_pedido'],
        $body['fecha_envio'],
        $body['fecha_entrega'],
        $body['fecha_pago'],
        $body['id_factura'],
        $body['facturado'],
        $body['metodo_pago'],
        $body['activo'],
        $body['id_usuario'],
        $body['id'],);

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