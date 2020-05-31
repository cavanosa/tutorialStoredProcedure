#CREAR BASE DE DATOS

CREATE DATABASE IF NOT EXISTS tutorial_procedure CHARACTER SET utf8 COLLATE utf8_general_ci;

# LISTA DE COCHES

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `lista_procedure`()
    READS SQL DATA
SELECT * FROM coche$$
DELIMITER ;

# LISTA DE COCHES POR MARCA

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `marca_procedure`(IN `marcaIn` VARCHAR(255))
    READS SQL DATA
SELECT * FROM coche WHERE marca = marcaIn$$
DELIMITER ;

# COCHE A PARTIR DEL ID

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `id_procedure`(IN `idIn` INT(11))
    READS SQL DATA
SELECT * FROM coche WHERE id = idIn$$
DELIMITER ;

# GUARDAR UN NUEVO COCHE

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `save_procedure`(IN `marcaIn` VARCHAR(255), IN `modeloIn` VARCHAR(255), IN `anyoIn` INT(11), IN `kmIn` INT(11))
    MODIFIES SQL DATA
INSERT INTO coche (marca, modelo, anyo, km) VALUES(marcaIn, modeloIn, anyoIn, kmIn)$$
DELIMITER ;

# ELIMINAR UN COCHE

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `borrar_procedure`(IN `idIn` INT(11))
    MODIFIES SQL DATA
DELETE FROM coche WHERE id = idIn$$
DELIMITER ;

# OBTENER LA MEDIA DE LOS KILÓMETROS DE TODOS LOS COCHES

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `media_procedure`()
    READS SQL DATA
SELECT AVG(km) FROM coche$$
DELIMITER ;

