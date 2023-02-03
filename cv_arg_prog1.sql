-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-02-2023 a las 01:55:53
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 7.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cvargprog`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contacto`
--

CREATE TABLE `contacto` (
  `idactividad` int(11) NOT NULL,
  `click` varchar(30) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `iduser` int(11) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `celular` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `contacto`
--

INSERT INTO `contacto` (`idactividad`, `click`, `cantidad`, `fecha`, `iduser`, `email`, `celular`) VALUES
(17, 'linkedin', 1, '2023-11-30', 10, 'prueba1@hotmail.com', '+543885914783'),
(18, 'Whatsapp', 2, '2023-11-29', 10, 'Chichito@hotmail.com', '+543885914783'),
(19, 'Facebook', 4, NULL, 10, 'pruebita2@hotmail.com', '+543885914783');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle`
--

CREATE TABLE `detalle` (
  `iddetalles` int(11) NOT NULL,
  `puesto` varchar(30) DEFAULT NULL,
  `obs` varchar(20) DEFAULT NULL,
  `iduser` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalle`
--

INSERT INTO `detalle` (`iddetalles`, `puesto`, `obs`, `iduser`, `descripcion`) VALUES
(1, 'FULLSTACK', '0', 55, 'PROGRAMA ARGENTINA PROGRAMA'),
(2, 'DATA SCIENTIST', '6 MESES ', 10, 'BOOTCAMP DATA SCIENTIST'),
(3, 'IT', '0', 10, 'DATA ENTRY');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `experiencia`
--

CREATE TABLE `experiencia` (
  `idexperiencia` int(11) NOT NULL,
  `imagen` varchar(64) DEFAULT NULL,
  `lugar` varchar(30) DEFAULT NULL,
  `inicio` date DEFAULT NULL,
  `fin` date DEFAULT NULL,
  `iddetalles` int(11) NOT NULL,
  `tipo` int(11) NOT NULL,
  `obs` varchar(30) DEFAULT NULL,
  `iduser` int(11) NOT NULL,
  `modificado` date DEFAULT NULL,
  `detalles` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `experiencia`
--

INSERT INTO `experiencia` (`idexperiencia`, `imagen`, `lugar`, `inicio`, `fin`, `iddetalles`, `tipo`, `obs`, `iduser`, `modificado`, `detalles`) VALUES
(6, '', 'Henry', '2022-01-01', '2023-01-01', 2, 4, '0', 10, '2023-01-12', 0),
(14, NULL, 'Argentina Programa', '2021-12-30', '2022-12-30', 3, 4, 'Casi terminamos', 10, '2023-01-13', NULL),
(15, NULL, 'Argentina Programa', '2021-12-30', '2022-12-30', 2, 4, 'Se fué con Lisandro', 57, '2023-01-13', NULL);

--
-- Disparadores `experiencia`
--
DELIMITER $$
CREATE TRIGGER `experiencia_BEFORE_INSERT` BEFORE INSERT ON `experiencia` FOR EACH ROW BEGIN
	set NEW.modificado = CURRENT_TIMESTAMP;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequences`
--

CREATE TABLE `hibernate_sequences` (
  `sequence_name` varchar(255) NOT NULL,
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hibernate_sequences`
--

INSERT INTO `hibernate_sequences` (`sequence_name`, `next_val`) VALUES
('default', 100);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyecto`
--

CREATE TABLE `proyecto` (
  `idproyecto` int(11) NOT NULL,
  `titulo` varchar(45) DEFAULT NULL,
  `descripcion` longtext DEFAULT NULL,
  `link` varchar(64) DEFAULT NULL,
  `iduser` int(11) NOT NULL,
  `idexperiencia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `skill`
--

CREATE TABLE `skill` (
  `idskill` int(11) NOT NULL,
  `detalle` varchar(30) DEFAULT NULL,
  `porcentaje` float DEFAULT NULL,
  `experiencia` int(11) DEFAULT NULL,
  `modificado` date DEFAULT NULL,
  `iduser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `skill`
--

INSERT INTO `skill` (`idskill`, `detalle`, `porcentaje`, `experiencia`, `modificado`, `iduser`) VALUES
(1, 'PowerBi', 90, 2, '2023-01-08', 10),
(4, 'Python', 90, 2, '2023-01-13', 10),
(6, 'ETL', 85.2, 2, '2023-01-13', 10);

--
-- Disparadores `skill`
--
DELIMITER $$
CREATE TRIGGER `skill_BEFORE_INSERT` BEFORE INSERT ON `skill` FOR EACH ROW BEGIN
	set NEW.modificado = CURRENT_TIMESTAMP;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo`
--

CREATE TABLE `tipo` (
  `idtipo` int(11) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo`
--

INSERT INTO `tipo` (`idtipo`, `descripcion`) VALUES
(1, 'Trabajo'),
(4, 'Estudio'),
(5, 'Hobbie');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_seq`
--

CREATE TABLE `tipo_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_seq`
--

INSERT INTO `tipo_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `email` varchar(60) NOT NULL,
  `password` varchar(50) NOT NULL,
  `ingreso` date NOT NULL,
  `aboutme` varchar(500) DEFAULT NULL,
  `picture` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idusuario`, `apellido`, `nombre`, `email`, `password`, `ingreso`, `aboutme`, `picture`) VALUES
(10, 'MATICH CUEZZO', 'CARLOS ANTONIO', 'nippur.argento@gmail.com', '123456', '2022-12-01', 'Desde niño uno de mis hobbies son los videojuegos. Desde ahí mi pasión por la programación creció. Hoy mi horizonte es el deseo seguir en este camino interminable del mundo IT. Y aunque suene pretencioso quiero expandirlo. Siempre en busqueda de nuevos skills y mejorar mis prácticas. La vida es como un videogame, con más reglas y sin la función de deshacer, en el modo para expertos .', '1669705417472.jfif'),
(57, 'MATICH MEDINA', 'JESÚS', 'PRUEBA@GMAIL.COM', '123456', '2023-01-13', 'chichito', NULL),
(58, 'MATICH CUEZZO', 'CARLOS ANTONIO', 'NIPPUR.ARGENTO100@GMAIL.COM', '123456', '2023-01-07', 'vicios y morfi y pizzas', NULL),
(59, 'MATICH CUEZZO', 'CARLOS ANTONIO', 'NIPPUR.ARGENTO1@GMAIL.COM', '123456', '2023-01-23', 'vicios y morfi y pizzas', NULL);

--
-- Disparadores `usuario`
--
DELIMITER $$
CREATE TRIGGER `usuario_BEFORE_UPDATE` BEFORE INSERT ON `usuario` FOR EACH ROW BEGIN	    
		set NEW.ingreso = CURRENT_TIMESTAMP;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_seq`
--

CREATE TABLE `usuario_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario_seq`
--

INSERT INTO `usuario_seq` (`next_val`) VALUES
(151);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `contacto`
--
ALTER TABLE `contacto`
  ADD PRIMARY KEY (`idactividad`);

--
-- Indices de la tabla `detalle`
--
ALTER TABLE `detalle`
  ADD PRIMARY KEY (`iddetalles`);

--
-- Indices de la tabla `experiencia`
--
ALTER TABLE `experiencia`
  ADD PRIMARY KEY (`idexperiencia`),
  ADD KEY `delete_exp` (`iduser`),
  ADD KEY `delete_det` (`iddetalles`);

--
-- Indices de la tabla `hibernate_sequences`
--
ALTER TABLE `hibernate_sequences`
  ADD PRIMARY KEY (`sequence_name`);

--
-- Indices de la tabla `proyecto`
--
ALTER TABLE `proyecto`
  ADD PRIMARY KEY (`idproyecto`);

--
-- Indices de la tabla `skill`
--
ALTER TABLE `skill`
  ADD PRIMARY KEY (`idskill`),
  ADD KEY `delete_skill` (`iduser`);

--
-- Indices de la tabla `tipo`
--
ALTER TABLE `tipo`
  ADD PRIMARY KEY (`idtipo`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idusuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `contacto`
--
ALTER TABLE `contacto`
  MODIFY `idactividad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `detalle`
--
ALTER TABLE `detalle`
  MODIFY `iddetalles` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `experiencia`
--
ALTER TABLE `experiencia`
  MODIFY `idexperiencia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `proyecto`
--
ALTER TABLE `proyecto`
  MODIFY `idproyecto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `skill`
--
ALTER TABLE `skill`
  MODIFY `idskill` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `tipo`
--
ALTER TABLE `tipo`
  MODIFY `idtipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `experiencia`
--
ALTER TABLE `experiencia`
  ADD CONSTRAINT `delete_det` FOREIGN KEY (`iddetalles`) REFERENCES `detalle` (`iddetalles`),
  ADD CONSTRAINT `delete_exp` FOREIGN KEY (`iduser`) REFERENCES `usuario` (`idusuario`);

--
-- Filtros para la tabla `skill`
--
ALTER TABLE `skill`
  ADD CONSTRAINT `delete_skill` FOREIGN KEY (`iduser`) REFERENCES `usuario` (`idusuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
