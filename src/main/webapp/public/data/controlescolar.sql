-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-11-2020 a las 01:50:07
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `controlescolar`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `id` int(10) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `paterno` varchar(50) DEFAULT NULL,
  `materno` varchar(50) DEFAULT NULL,
  `matricula` varchar(5) NOT NULL,
  `activo` int(1) DEFAULT NULL,
  `promedio` double DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `sexo` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`id`, `nombre`, `paterno`, `materno`, `matricula`, `activo`, `promedio`, `correo`, `sexo`) VALUES
(1, 'JOSÉ DAMIÁN ', 'SÁNCHEZ ', 'LEOBARDO', '56513', 1, 8.3, 'al056513@uacam.mx', 'H'),
(2, 'JESÚS ALBERTO', 'TELLO', 'MEDINA', '58752', 1, 9.399999618530273, 'al058752@uacam.mx', 'H'),
(4, 'JESÚS ABRAHAM', 'NAVARRETE', 'CANUL', '60881', 1, 8.3, 'al060881@uacam.mx', 'H'),
(5, 'DANIEL', 'JAIMES', 'CARBAJAL', '61844', 0, 9.3, 'dajaimes@uacam.mx', 'H');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clases`
--

CREATE TABLE `clases` (
  `id` int(3) NOT NULL,
  `clase` varchar(15) NOT NULL,
  `id_grupo` int(3) NOT NULL,
  `dia1` varchar(10) NOT NULL,
  `horario1` varchar(15) NOT NULL,
  `dia2` varchar(10) NOT NULL,
  `horario2` varchar(15) NOT NULL,
  `id_profesor` int(10) NOT NULL,
  `id_materia` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clases`
--

INSERT INTO `clases` (`id`, `clase`, `id_grupo`, `dia1`, `horario1`, `dia2`, `horario2`, `id_profesor`, `id_materia`) VALUES
(1, '001008-1715-68', 2, 'Lunes', '19:00 - 21:00', 'Jueves', '19:00 - 21:00', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupos`
--

CREATE TABLE `grupos` (
  `id` int(3) NOT NULL,
  `grupo` varchar(3) NOT NULL,
  `id_alumno` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `grupos`
--

INSERT INTO `grupos` (`id`, `grupo`, `id_alumno`) VALUES
(1, '7A', 1),
(2, '7B', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materias`
--

CREATE TABLE `materias` (
  `id` int(3) NOT NULL,
  `materia` varchar(100) NOT NULL,
  `seccion` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `materias`
--

INSERT INTO `materias` (`id`, `materia`, `seccion`) VALUES
(1, 'PROGRAMACIÓN DE APLICACIONES WEB', 'FI.ISC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesores`
--

CREATE TABLE `profesores` (
  `id` int(10) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `paterno` varchar(50) DEFAULT NULL,
  `materno` varchar(50) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `sexo` varchar(1) DEFAULT NULL,
  `titulo` varchar(10) DEFAULT NULL,
  `puesto` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `profesores`
--

INSERT INTO `profesores` (`id`, `nombre`, `paterno`, `materno`, `correo`, `sexo`, `titulo`, `puesto`) VALUES
(1, 'DANIEL', 'JAIMES', 'CARBAJAL', 'dajaimes@uacam.mx', 'H', 'ING.', ''),
(2, 'NANCY GEORGINA', 'ORTIZ', 'CUEVAS', 'nagortiz@uacam.mx', 'M', 'MTRA.', 'COORDINADORA DE INGENIERÍA EN SSITEMAS COMPUTACIONALES');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(3) NOT NULL,
  `login` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `paterno` varchar(50) DEFAULT NULL,
  `materno` varchar(50) DEFAULT NULL,
  `sexo` varchar(1) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `codigo` varchar(6) DEFAULT NULL,
  `activo` int(1) DEFAULT NULL,
  `perfil` int(1) DEFAULT NULL,
  `alta` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Usuarios del sistema';

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `login`, `password`, `nombre`, `paterno`, `materno`, `sexo`, `correo`, `codigo`, `activo`, `perfil`, `alta`) VALUES
(1, 'dajaimes', 'colage', 'Daniel', 'Jaimes', 'Carbajal', 'H', 'dajaimes@uacam.mx', 'HFGTDR', 1, 1, '2020-11-02 10:43:03');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `clases`
--
ALTER TABLE `clases`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `grupos`
--
ALTER TABLE `grupos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `materias`
--
ALTER TABLE `materias`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `clases`
--
ALTER TABLE `clases`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `grupos`
--
ALTER TABLE `grupos`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `materias`
--
ALTER TABLE `materias`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `profesores`
--
ALTER TABLE `profesores`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
