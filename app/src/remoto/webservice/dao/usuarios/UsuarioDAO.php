<?php

require '../Database.php';

class UsuarioDAO {

    function __construct(){

    }

    public function altaUsuario($id, $codigo_cliente, $nif, $nombre, $apellido1, $apellido2, $numero_cuenta, $rol, $activo) {
        $comando = "INSERT INTO usuarios (id, codigo_cliente, nif, nombre, apellido1, apellido2, numero_cuenta, rol, activo) VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)";
        $sentencia = Database::getInstance()->getDb()->prepare($comando);
        return $sentencia->execute(array($codigo_cliente, $nif, $nombre, $apellido1, $apellido2, $numero_cuenta, $rol, $activo));
    }

    public function bajaUsuario($id) {
        $comando = "DELETE FROM usuarios WHERE id = ?";
        $sentencia = Database::getInstance()->getDb()->prepare($comando);
        return $sentencia->execute(array($id));
    }

    public function actualizaUsuario($codigo_cliente, $nif, $nombre, $apellido1, $apellido2, $numero_cuenta, $rol, $activo, $id) {
        $comando = "UPDATE usuarios SET codigo_cliente=?, nif=?, nombre=?, apellido1=?, apellido2=?, numero_cuenta=?, rol=?, activo=? WHERE id=?";
        $cmd = Database::getInstance()->getDb()->prepare($comando);
        $cmd->execute(array($codigo_cliente, $nif, $nombre, $apellido1, $apellido2, $numero_cuenta, $rol, $activo, $id));
        return $cmd;
    }

    public function getAll() {
        $consulta = "SELECT * FROM usuarios";
        try {
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            $comando->execute();
            return $comando->fetchAll(PDO::FETCH_ASSOC);

        } catch (PDOException $e) {
            echo "Error en el método getAll.";
            return false;
        }
    }

    public function getById($id) {
        $consulta = "SELECT id, codigo_cliente, nif, nombre, apellido1, apellido2, numero_cuenta, rol, activo FROM usuarios WHERE id = ?";
        try {
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            $comando->execute(array($$id));
            $row = $comando->fetch(PDO::FETCH_ASSOC);
            return $row;

        } catch (PDOException $e) {
            return -1; //Clasificación del error para mostrarlo en json.
        }
    }

}
