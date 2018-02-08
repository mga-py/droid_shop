<?php

require 'UsuarioDAO.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    $body = json_decode(file_get_contents("php://input"), true);

    $resultado = UsuarioDAO::actualizaUsuario(
        $body['codigo_cliente'],
        $body['nif'],
        $body['nombre'],
        $body['apellido1'],
        $body['apellido2'],
        $body['numero_cuenta'],
        $body['rol'],
        $body['activo'],
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