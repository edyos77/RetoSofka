-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-06-2022 a las 06:36:19
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `navesespacialesbd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nave_lanzadera`
--

CREATE TABLE `nave_lanzadera` (
  `nombre` varchar(20) NOT NULL,
  `pais` varchar(20) NOT NULL,
  `peso` double NOT NULL,
  `velocidad` double NOT NULL,
  `potencia` double NOT NULL,
  `combustible` varchar(70) NOT NULL,
  `cap_carga` int(11) NOT NULL,
  `altura` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `nave_lanzadera`
--

INSERT INTO `nave_lanzadera` (`nombre`, `pais`, `peso`, `velocidad`, `potencia`, `combustible`, `cap_carga`, `altura`) VALUES
('Saturno v', 'EEUU', 2900, 8600, 3500, 'H(liq)+O(liq)', 118, 100),
('Energia', 'Rusia', 2400, 8000, 3060, 'Querosena+O(liq)', 100, 60),
('Delta IV', 'EEUU', 2100, 8300, 2900, 'H(liq)+O(liq)', 100, 72);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nave_no_tripulada`
--

CREATE TABLE `nave_no_tripulada` (
  `nombre` varchar(20) NOT NULL,
  `pais` varchar(20) NOT NULL,
  `peso` double NOT NULL,
  `velocidad` double NOT NULL,
  `potencia` double NOT NULL,
  `combustible` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `nave_no_tripulada`
--

INSERT INTO `nave_no_tripulada` (`nombre`, `pais`, `peso`, `velocidad`, `potencia`, `combustible`) VALUES
('Explorer', 'EEUU', 10, 18000, 45, 'Sólido+Liquido'),
('Sputnik', 'Rusia', 12, 18200, 50, 'N2O4+UDMH'),
('ATV', 'Europa ESA/ASI', 11, 18000, 45, 'MMH+NO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nave_tripulada`
--

CREATE TABLE `nave_tripulada` (
  `nombre` varchar(20) NOT NULL,
  `pais` varchar(20) NOT NULL,
  `peso` double NOT NULL,
  `velocidad` double NOT NULL,
  `potencia` double NOT NULL,
  `combustible` varchar(70) NOT NULL,
  `cap_personas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `nave_tripulada`
--

INSERT INTO `nave_tripulada` (`nombre`, `pais`, `peso`, `velocidad`, `potencia`, `combustible`, `cap_personas`) VALUES
('Dragon V2', 'EEUU', 77, 5000, 50, 'Solido', 3),
('Apolo', 'EEUU', 80, 18000, 60, 'NO4+UDMH', 3),
('Vostok', 'Rusia', 25, 18000, 70, 'NO+Amina', 3),
('EEI', 'EEUU, JAP, CAN, EUR', 420, 28000, 80, 'Querosena+H(liq)', 7);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
