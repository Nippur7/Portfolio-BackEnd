-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-01-2023 a las 23:27:34
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
-- Base de datos: `cv_arg_prog`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contacto`
--

CREATE TABLE `contacto` (
  `idactividad` int(11) NOT NULL,
  `click` varchar(30) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `iduser` int(11) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `celular` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle`
--

CREATE TABLE `detalle` (
  `iddetalles` int(11) NOT NULL,
  `puesto` varchar(30) NOT NULL,
  `descripción` varchar(80) NOT NULL,
  `obs` varchar(20) NOT NULL,
  `iduser` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalle`
--

INSERT INTO `detalle` (`iddetalles`, `puesto`, `descripción`, `obs`, `iduser`) VALUES
(1, 'IT', 'DATA ENTRY', '0', 10),
(2, 'DATA SCIENTIST', 'BOOTCAMP DATA SCIENTIST', '6 MESES ', 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `experiencia`
--

CREATE TABLE `experiencia` (
  `idexperiencia` int(11) NOT NULL,
  `imagen` mediumblob NOT NULL,
  `lugar` varchar(30) NOT NULL,
  `inicio` date NOT NULL,
  `fin` date NOT NULL,
  `iddetalles` int(11) NOT NULL,
  `tipo` int(11) NOT NULL,
  `obs` varchar(30) NOT NULL,
  `iduser` int(11) DEFAULT NULL,
  `modificado` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `experiencia`
--

INSERT INTO `experiencia` (`idexperiencia`, `imagen`, `lugar`, `inicio`, `fin`, `iddetalles`, `tipo`, `obs`, `iduser`, `modificado`) VALUES
(2, '', 'DEMISA CONSTRUCCIONES S.A.', '2007-11-01', '2021-08-30', 1, 1, '0', 10, '2023-01-08 19:00:52'),
(4, '', 'HENRY', '2022-05-01', '2022-11-30', 2, 2, '0', 10, '2023-01-08 19:06:57');

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
-- Estructura de tabla para la tabla `skill`
--

CREATE TABLE `skill` (
  `idskill` int(11) NOT NULL,
  `detalle` varchar(30) NOT NULL,
  `porcentaje` float NOT NULL,
  `experiencia` int(11) NOT NULL,
  `modificado` date NOT NULL,
  `iduser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `skill`
--

INSERT INTO `skill` (`idskill`, `detalle`, `porcentaje`, `experiencia`, `modificado`, `iduser`) VALUES
(1, 'python', 82, 2, '2023-01-08', 10);

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
(1, 'trabajo'),
(2, 'estudio'),
(3, 'hobbie');

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
  `aboutme` varchar(45) DEFAULT NULL,
  `picture` mediumblob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idusuario`, `apellido`, `nombre`, `email`, `password`, `ingreso`, `aboutme`, `picture`) VALUES
(10, 'MATICH CUEZZO', 'CARLOS ANTONIO', 'NIPPUR.ARGENTO@GMAIL.COM', '123456', '2023-01-08', NULL, NULL);

--
-- Disparadores `usuario`
--
DELIMITER $$
CREATE TRIGGER `usuario_BEFORE_UPDATE` BEFORE INSERT ON `usuario` FOR EACH ROW BEGIN	    
		set NEW.ingreso = CURRENT_TIMESTAMP;
END
$$
DELIMITER ;

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
  MODIFY `idactividad` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detalle`
--
ALTER TABLE `detalle`
  MODIFY `iddetalles` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `experiencia`
--
ALTER TABLE `experiencia`
  MODIFY `idexperiencia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `skill`
--
ALTER TABLE `skill`
  MODIFY `idskill` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

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
