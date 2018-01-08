-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 08-01-2018 a las 02:03:23
-- Versión del servidor: 10.1.25-MariaDB
-- Versión de PHP: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `veterinariabd`
--
CREATE DATABASE IF NOT EXISTS `veterinariabd` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `veterinariabd`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especie`
--

CREATE TABLE `especie` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `especie`
--

INSERT INTO `especie` (`codigo`, `nombre`, `estado`) VALUES
(1, 'Perro', 1),
(2, 'Gato', 1),
(3, 'Ave', 1),
(4, 'Huron', 1),
(5, 'Tortuga', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mascota`
--

CREATE TABLE `mascota` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `codigo_especie` int(11) NOT NULL,
  `codigo_persona` int(11) NOT NULL,
  `fechaNacimiento` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu`
--

CREATE TABLE `menu` (
  `codigo` tinyint(4) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `url` varchar(100) DEFAULT NULL,
  `tipo` enum('S','I') NOT NULL,
  `tipoUsuario` enum('A','U','V') NOT NULL,
  `codigo_submenu` tinyint(4) DEFAULT NULL,
  `estado` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `menu`
--

INSERT INTO `menu` (`codigo`, `nombre`, `url`, `tipo`, `tipoUsuario`, `codigo_submenu`, `estado`) VALUES
(1, 'Inicio', '/protegido/principal.gazulabs', 'I', 'U', NULL, b'1'),
(2, 'Inicio', '/protegido/principal.gazulabs', 'I', 'V', NULL, b'1'),
(3, 'Inicio', '/protegido/principal.gazulabs', 'I', 'A', NULL, b'1'),
(4, 'Cliente', NULL, 'S', 'U', NULL, b'1'),
(5, 'Crear Cliente', '/protegido/usuario/crearCliente.gazulabs', 'I', 'U', 4, b'1'),
(6, 'Listar Clientes', '/protegido/usuario/listarClientes.gazulabs', 'I', 'U', 4, b'1'),
(7, 'Mascota', NULL, 'S', 'U', NULL, b'1'),
(8, 'Crear Mascota', '/protegido/usuario/crearMascota.gazulabs', 'I', 'U', 7, b'1'),
(9, 'Listar Mascotas', '/protegido/usuario/listarMascotas.gazulabs', 'I', 'U', 7, b'1'),
(10, 'Crear Especie', '/protegido/administrador/crearEspecie.gazulabs', 'I', 'A', NULL, b'1'),
(11, 'Crear Cuenta', '/protegido/administrador/usuario.gazulabs', 'I', 'A', NULL, b'1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `codigo` int(9) NOT NULL,
  `rut` int(9) NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `sexo` enum('M','F') NOT NULL,
  `fechaNacimiento` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`codigo`, `rut`, `nombres`, `apellidos`, `sexo`, `fechaNacimiento`) VALUES
(22, 22, 'Rafael', 'Quezada', 'M', '2017-06-21'),
(1919, 1919, 'prueba', 'prueba', 'M', '2018-01-20'),
(33333, 33333, 'Alejandra', 'Ojeda', 'F', '2017-06-06'),
(16147138, 16147138, 'Rodolfo', 'Quezada', 'M', '1985-10-23');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `codigo` int(9) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `clave` varchar(40) NOT NULL,
  `tipo` enum('U','A','V') NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`codigo`, `usuario`, `clave`, `tipo`, `estado`) VALUES
(22, 'rafa', '123', 'U', 0),
(1919, 'prueba', '123', 'U', 0),
(33333, 'ale', '123', 'A', 0),
(16147138, 'rodo', '123', 'U', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `especie`
--
ALTER TABLE `especie`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `mascota`
--
ALTER TABLE `mascota`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `codigo_especie` (`codigo_especie`),
  ADD KEY `codigo_persona` (`codigo_persona`);

--
-- Indices de la tabla `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `codigo_submenu` (`codigo_submenu`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `especie`
--
ALTER TABLE `especie`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `mascota`
--
ALTER TABLE `mascota`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `mascota`
--
ALTER TABLE `mascota`
  ADD CONSTRAINT `mascota_ibfk_1` FOREIGN KEY (`codigo_persona`) REFERENCES `persona` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mascota_ibfk_2` FOREIGN KEY (`codigo_especie`) REFERENCES `especie` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `menu`
--
ALTER TABLE `menu`
  ADD CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`codigo_submenu`) REFERENCES `menu` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`codigo`) REFERENCES `persona` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
