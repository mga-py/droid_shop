<?php

require 'UsuarioDAO.php';

if ($_SERVER['REQUEST_METHOD'] == 'GET') {
    $mensajes = UsuarioDAO::getAll();
    if ($mensajes) {
        $datos["estado"] = 1;
        $datos["usuario"] = $mensajes;
        print json_encode($datos);
    } else {
        print json_encode(array(
            "estado" => 2,
            "resultado" => "Ha ocurrido un error"
        ));
    }
}