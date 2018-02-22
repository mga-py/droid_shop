-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-02-2018 a las 09:30:38
-- Versión del servidor: 10.1.29-MariaDB
-- Versión de PHP: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `droid_shop`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `linea_pedido`
--

CREATE TABLE `linea_pedido` (
  `id` int(11) NOT NULL,
  `codigo_linea_pedido` varchar(10) NOT NULL,
  `id_pedido` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `descripcion` varchar(500),
  `unidades` int(11) NOT NULL,
  `iva` decimal(10,2),
  `pvp` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `linea_pedido`
--

INSERT INTO `linea_pedido` (`id`, `codigo_linea_pedido`, `id_pedido`, `id_producto`, `descripcion`, `unidades`, `iva`, `pvp`) VALUES
(1, '1', 1, 1, 'lineaPedido1', 12, '21.00', '22.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `id` int(11) NOT NULL,
  `codigo_pedido` varchar(10) NOT NULL,
  `id_empleado_empaqueta` int(11) NOT NULL,
  `empresa_transporte` varchar(25) NOT NULL,
  `fecha_pedido` date NOT NULL,
  `fecha_envio` date,
  `fecha_entrega` date,
  `fecha_pago` date,
  `id_factura` int(11) NOT NULL,
  `facturado` tinyint(1) NOT NULL,
  `metodo_pago` enum('Tarjeta Crédito','Paypal','Transferencia Bancaria','Contrareembolso') NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`id`, `codigo_pedido`, `id_empleado_empaqueta`, `empresa_transporte`, `fecha_pedido`, `fecha_envio`, `fecha_entrega`, `fecha_pago`, `id_factura`, `facturado`, `metodo_pago`, `id_usuario`, `activo`) VALUES
(1, '1', 1, 'SEUR', '2018-02-01', '2018-02-02', '2018-02-02', '2018-02-01', 1, 1, 'Paypal', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(11) NOT NULL,
  `codigo_producto` varchar(10) NOT NULL,
  `descripcion` varchar(250) NOT NULL,
  `id_proveedor` int(10) NOT NULL,
  `precio_coste` decimal(10,2) NOT NULL,
  `pvp` decimal(10,2) NOT NULL,
  `iva` decimal(10,2) NOT NULL,
  `codigo_barras` varchar(20),
  `stock_actual` int(11),
  `stock_minimo` int(11),
  `stock_maximo` int(11),
  `ruta_foto` varchar(250),
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `codigo_producto`, `descripcion`, `id_proveedor`, `precio_coste`, `pvp`, `iva`, `codigo_barras`, `stock_actual`, `stock_minimo`, `stock_maximo`, `ruta_foto`, `activo`) VALUES
(1, '1', 'ImPHUNE', 1, '32.00', '100.00', '21.00', '1234567890', 100, 20, 200, '', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `codigo_cliente` varchar(10) NOT NULL,
  `nif` varchar(15) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido1` varchar(25),
  `apellido2` varchar(25),
  `numero_cuenta` varchar(20),
  `rol` enum('cliente','administrador','empleado','invitado') NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `codigo_cliente`, `nif`, `nombre`, `apellido1`, `apellido2`, `numero_cuenta`, `rol`, `activo`) VALUES
(1, '1', '80666555A', 'Baltasar', 'Rangel', 'Pinilla', 'noTengo', 'administrador', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `linea_pedido`
--
ALTER TABLE `linea_pedido`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo_linea_pedido` (`codigo_linea_pedido`),
  ADD KEY `id_pedido` (`id_pedido`),
  ADD KEY `id_producto` (`id_producto`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo_pedido` (`codigo_pedido`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_empleado_empaqueta` (`id_empleado_empaqueta`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo_producto` (`codigo_producto`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo_cliente` (`codigo_cliente`),
  ADD UNIQUE KEY `nif` (`nif`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `linea_pedido`
--
ALTER TABLE `linea_pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `linea_pedido`
--
ALTER TABLE `linea_pedido`
  ADD CONSTRAINT `linea_pedido_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`),
  ADD CONSTRAINT `linea_pedido_ibfk_2` FOREIGN KEY (`id_pedido`) REFERENCES `pedidos` (`id`);

--
-- Filtros para la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`),
  ADD CONSTRAINT `pedidos_ibfk_2` FOREIGN KEY (`id_empleado_empaqueta`) REFERENCES `usuarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
