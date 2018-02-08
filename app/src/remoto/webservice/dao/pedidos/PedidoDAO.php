<?php

require '../Database.php';

class PedidoDAO {

    function __construct(){

    }

    public function altaPedido($codigo_pedido, $id_empledado_empaqueta, $empresa_transporte, $fecha_pedido, $fecha_envio, $fecha_entrega, $fecha_pago, $id_factura, $facturado, $metodo_pago, $activo, $id_usuario) {
        $comando = "INSERT INTO pedidos (codigo_pedido, id_empledado_empaqueta, empresa_transporte, fecha_pedido, fecha_envio, fecha_entrega, fecha_pago, id_factura, facturado, metodo_pago, activo, id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        $sentencia = Database::getInstance()->getDb()->prepare($comando);
        return $sentencia->execute(array($codigo_pedido, $id_empledado_empaqueta, $empresa_transporte, $fecha_pedido, $fecha_envio, $fecha_entrega, $fecha_pago, $id_factura, $facturado, $metodo_pago, $activo, $id_usuario));
    }

    public function bajaPedido($id) {
        $comando = "DELETE FROM pedidos WHERE id = ?";
        $sentencia = Database::getInstance()->getDb()->prepare($comando);
        return $sentencia->execute(array($id));
    }

    public function actualizaPedido($codigo_pedido, $id_empledado_empaqueta, $empresa_transporte, $fecha_pedido, $fecha_envio, $fecha_entrega, $fecha_pago, $id_factura, $facturado, $metodo_pago, $activo, $id_usuario, $id) {
        $comando = "UPDATE pedidos SET codigo_pedido=?, id_empledado_empaqueta=?, empresa_transporte=?, fecha_pedido=?, fecha_envio=?, fecha_entrega=?, fecha_pago=?, id_factura=?, facturado=?, metodo_pago=?, activo=? WHERE id=?";
        $cmd = Database::getInstance()->getDb()->prepare($comando);
        $cmd->execute(array($codigo_pedido, $id_empledado_empaqueta, $empresa_transporte, $fecha_pedido, $fecha_envio, $fecha_entrega, $fecha_pago, $id_factura, $facturado, $metodo_pago, $activo, $id_usuario, $id));
        return $cmd;
    }

    public function getAll() {
        $consulta = "SELECT * FROM pedidos";
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
        $consulta = "SELECT id, codigo_pedido, id_empledado_empaqueta, empresa_transporte, fecha_pedido, fecha_envio, fecha_entrega, fecha_pago, id_factura, facturado, metodo_pago, activo, id_usuario FROM pedidos WHERE id = ?";
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
