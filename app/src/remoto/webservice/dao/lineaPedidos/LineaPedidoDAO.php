<?php

require '../Database.php';

class LineaPedidoDAO {

    function __construct(){

    }

    public function altaLineaPedido($id, $codigo_linea_pedido, $id_pedido, $id_producto, $descripcion, $unidades, $iva, $pvp) {
        $comando = "INSERT INTO linea_pedido (id, codigo_linea_pedido, id_pedido, id_producto, descripcion, unidades, iva, pvp) VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
        $sentencia = Database::getInstance()->getDb()->prepare($comando);
        return $sentencia->execute(array($id, $codigo_linea_pedido, $id_pedido, $id_producto, $descripcion, $unidades, $iva, $pvp));
    }

    public function bajaLineaPedido($id) {
        $comando = "DELETE FROM linea_pedido WHERE id = ?";
        $sentencia = Database::getInstance()->getDb()->prepare($comando);
        return $sentencia->execute(array($id));
    }

    public function actualizaLineaPedido($codigo_linea_pedido, $id_pedido, $id_producto, $descripcion, $unidades, $iva, $pvp, $id) {
        $comando = "UPDATE linea_pedido SET codigo_linea_pedido=?, id_pedido=?, id_producto=?, descripcion=?, unidades=?, iva=?, pvp=? WHERE id=?";
        $cmd = Database::getInstance()->getDb()->prepare($comando);
        $cmd->execute(array($codigo_linea_pedido, $id_pedido, $id_producto, $descripcion, $unidades, $iva, $pvp, $id));
        return $cmd;
    }

    public function getAll() {
        $consulta = "SELECT * FROM linea_pedido";
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
        $consulta = "SELECT id, codigo_linea_pedido, id_pedido, id_producto, descripcion, unidades, iva, pvp FROM linea_pedido WHERE id = ?";
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
