-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 18, 2025 at 09:45 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `timidos_titulados`
--

-- --------------------------------------------------------

--
-- Table structure for table `contenido`
--

CREATE TABLE `contenido` (
  `id_contenido` int(11) NOT NULL,
  `contenido_reportado` varchar(255) DEFAULT NULL,
  `detalle_contenido` varchar(255) DEFAULT NULL,
  `editado` varchar(255) DEFAULT NULL,
  `fecha_edicion_contenido` datetime(6) DEFAULT NULL,
  `fecha_publicacion` int(11) DEFAULT NULL,
  `reportado` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `vistas_contenido` int(11) DEFAULT NULL,
  `id_contenidos` int(11) DEFAULT NULL,
  `id_tipo_contenido` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `contenido`
--

INSERT INTO `contenido` (`id_contenido`, `contenido_reportado`, `detalle_contenido`, `editado`, `fecha_edicion_contenido`, `fecha_publicacion`, `reportado`, `titulo`, `vistas_contenido`, `id_contenidos`, `id_tipo_contenido`) VALUES
(1, 'no', 'Prueba', 'no', '2025-05-16 20:00:00.000000', 20250517, 'no', 'Test', 0, NULL, NULL),
(4, 'no', 'Este es el detalle del contenido', 'no', '2025-05-16 20:00:00.000000', 20250517, 'no', 'Mi nuevo contenido', 0, NULL, 1),
(5, 'no', 'Este es el detalle dedawdawdal contenido', 'no', '2025-05-16 20:00:00.000000', 20250517, 'no', 'Mi nuevo wawdawdcontenido', 0, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `contenidos`
--

CREATE TABLE `contenidos` (
  `id_contenidos` int(11) NOT NULL,
  `id_usuario` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `contenidos`
--

INSERT INTO `contenidos` (`id_contenidos`, `id_usuario`) VALUES
(2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `reporte`
--

CREATE TABLE `reporte` (
  `id_tipo_reporte` int(11) NOT NULL,
  `descripcion_reporte` varchar(255) DEFAULT NULL,
  `estado_reporte` varchar(255) DEFAULT NULL,
  `fecha_reporte` datetime(6) DEFAULT NULL,
  `id_contenido` int(11) DEFAULT NULL,
  `reportes_id_reportes` int(11) DEFAULT NULL,
  `tipo_reporte` varchar(255) DEFAULT NULL,
  `usuario_reportado_id` int(11) DEFAULT NULL,
  `usuario_reporte_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `reportes`
--

CREATE TABLE `reportes` (
  `id_reportes` int(11) NOT NULL,
  `id_contenido` int(11) DEFAULT NULL,
  `id_tipo_reporte` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tipousuario`
--

CREATE TABLE `tipousuario` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tipo_contenido`
--

CREATE TABLE `tipo_contenido` (
  `id_tipo_contenido` int(11) NOT NULL,
  `descripcion_tipo_contenido` varchar(255) DEFAULT NULL,
  `nombre_tipo_contenido` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tipo_contenido`
--

INSERT INTO `tipo_contenido` (`id_tipo_contenido`, `descripcion_tipo_contenido`, `nombre_tipo_contenido`) VALUES
(1, 'Contenido de tipo artículo', 'Artículo');

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `id` bigint(20) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `fecha_nacimiento` datetime(6) DEFAULT NULL,
  `nombres` varchar(255) NOT NULL,
  `run` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`id`, `apellidos`, `correo`, `fecha_nacimiento`, `nombres`, `run`) VALUES
(1, 'Pérez', 'juan.perez@email.com', '1999-12-31 21:00:00.000000', 'Juan', '12345678-9');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contenido`
--
ALTER TABLE `contenido`
  ADD PRIMARY KEY (`id_contenido`),
  ADD KEY `FKobmqo2fba5uiwntvd260q31wf` (`id_contenidos`),
  ADD KEY `FKsfflg2n6gi582ibt4xhj76tub` (`id_tipo_contenido`);

--
-- Indexes for table `contenidos`
--
ALTER TABLE `contenidos`
  ADD PRIMARY KEY (`id_contenidos`),
  ADD KEY `FKo1sbgfxoi3xu190pdisvigyfu` (`id_usuario`);

--
-- Indexes for table `reporte`
--
ALTER TABLE `reporte`
  ADD PRIMARY KEY (`id_tipo_reporte`);

--
-- Indexes for table `reportes`
--
ALTER TABLE `reportes`
  ADD PRIMARY KEY (`id_reportes`),
  ADD KEY `FKohptf3jofuchn47wwuq8w0y2u` (`id_contenido`),
  ADD KEY `FK3hajcq6tekmduasdsk1uxv8ca` (`id_tipo_reporte`);

--
-- Indexes for table `tipousuario`
--
ALTER TABLE `tipousuario`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tipo_contenido`
--
ALTER TABLE `tipo_contenido`
  ADD PRIMARY KEY (`id_tipo_contenido`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKksyidfr5g3rl0b04glr24fxjn` (`run`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `contenido`
--
ALTER TABLE `contenido`
  MODIFY `id_contenido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `contenidos`
--
ALTER TABLE `contenidos`
  MODIFY `id_contenidos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `reporte`
--
ALTER TABLE `reporte`
  MODIFY `id_tipo_reporte` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `reportes`
--
ALTER TABLE `reportes`
  MODIFY `id_reportes` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tipousuario`
--
ALTER TABLE `tipousuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tipo_contenido`
--
ALTER TABLE `tipo_contenido`
  MODIFY `id_tipo_contenido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `contenido`
--
ALTER TABLE `contenido`
  ADD CONSTRAINT `FKobmqo2fba5uiwntvd260q31wf` FOREIGN KEY (`id_contenidos`) REFERENCES `contenidos` (`id_contenidos`),
  ADD CONSTRAINT `FKsfflg2n6gi582ibt4xhj76tub` FOREIGN KEY (`id_tipo_contenido`) REFERENCES `tipo_contenido` (`id_tipo_contenido`);

--
-- Constraints for table `contenidos`
--
ALTER TABLE `contenidos`
  ADD CONSTRAINT `FKo1sbgfxoi3xu190pdisvigyfu` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`);

--
-- Constraints for table `reportes`
--
ALTER TABLE `reportes`
  ADD CONSTRAINT `FK3hajcq6tekmduasdsk1uxv8ca` FOREIGN KEY (`id_tipo_reporte`) REFERENCES `reporte` (`id_tipo_reporte`),
  ADD CONSTRAINT `FKohptf3jofuchn47wwuq8w0y2u` FOREIGN KEY (`id_contenido`) REFERENCES `contenido` (`id_contenido`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
