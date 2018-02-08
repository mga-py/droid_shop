<?php

require '../Database.php';

class ProductoDAO {

    function __construct(){

    }

    public function altaProducto($codigo_producto, $descripcion, $id_proveedor, $precio_coste, $pvp, $iva, $codigo_barras, $stock_actual, $stock_minimo, $stock_maximo, $ruta_foto, $activo) {
        $comando = "INSERT INTO productos (codigo_producto, descripcion, id_proveedor, precio_coste, pvp, iva, codigo_barras, stock_actual, stock_minimo,stock_maximo, ruta_foto, activo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        $sentencia = Database::getInstance()->getDb()->prepare($comando);
        return $sentencia->execute(array($codigo_producto, $descripcion, $id_proveedor, $precio_coste, $pvp, $iva, $codigo_barras, $stock_actual, $stock_minimo, $stock_maximo, $ruta_foto, $activo));
    }

    public function bajaProducto($id) {
        $comando = "DELETE FROM productos WHERE id = ?";
        $sentencia = Database::getInstance()->getDb()->prepare($comando);
        return $sentencia->execute(array($id));
    }

    public function actualizaProducto($codigo_producto, $descripcion, $id_proveedor, $precio_coste, $pvp, $iva, $codigo_barras, $stock_actual, $stock_minimo, $stock_maximo, $ruta_foto, $activo, $id) {
        $comando = "UPDATE productos SET codigo_producto=?, descripcion=?, id_proveedor=?, precio_coste=?, pvp=?, iva=?, codigo_barras=?, stock_actual=?, stock_minimo=?, stock_maximo=?. ruta_foto=?, activo=? WHERE id=?";
        $cmd = Database::getInstance()->getDb()->prepare($comando);
        $cmd->execute(array($codigo_producto, $descripcion, $id_proveedor, $precio_coste, $pvp, $iva, $codigo_barras, $stock_actual, $stock_minimo, $stock_maximo, $ruta_foto, $activo, $id));
        return $cmd;
    }

    public function getAll() {
        $consulta = "SELECT * FROM productos";
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
        $consulta = "SELECT id, codigo_producto, descripcion, id_proveedor, precio_coste, pvp, iva, codigo_barras, stock_actual, stock_minimo,stock_maximo, ruta_foto, activo FROM prodcutos WHERE id = ?";
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
