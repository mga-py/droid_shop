<?php

require 'UsuarioDAO.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {


    $body = json_decode(file_get_contents("php://input"), true);

    $resultado = UsuarioDAO::altaUsuario(
        $id, $codigo_cliente, $nif, $nombre, $apellido1, $apellido2, $numero_cuenta, $rol, $activo
        $body[0],
        $body['codigo_cliente'],
        $body['nif'],
        $body['nombre'],
        $body['apellido1'],
        $body['apellido2'],
        $body['numero_cuenta'],
        $body['rol'],
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