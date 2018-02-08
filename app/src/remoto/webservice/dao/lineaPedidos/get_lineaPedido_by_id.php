<?php

require 'LineaPedidoDAO.php';

if ($_SERVER['REQUEST_METHOD'] == 'GET') {

    if (isset($_GET['id'])) {
        $parametro = $_GET['id'];
        $resultado = LineaPedidoDAO::getById($parametro);
        if ($resultado) {
            $dato["estado"] = "1";
            $dato["mensaje"] = $resultado;
            print json_encode($dato);
        } else {  //error
            print json_encode(
                array(
                    'estado' => '2',
                    'mensaje' => 'No se obtuvo el registro'
                )
            );
        }

    } else {
        print json_encode( //Otro error
            array(
                'estado' => '3',
                'mensaje' => 'Se necesita un identificador'
            )
        );
    }
}