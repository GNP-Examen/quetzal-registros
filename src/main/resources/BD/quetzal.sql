SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema quetzal
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS  quetzal  ;

-- -----------------------------------------------------
-- Schema quetzal
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS quetzal DEFAULT CHARACTER SET utf8 ;
USE quetzal ;

-- -----------------------------------------------------
-- Table quetzal.MASCOTA
-- -----------------------------------------------------
DROP TABLE IF EXISTS  quetzal.MASCOTA  ;

CREATE TABLE IF NOT EXISTS  quetzal.MASCOTA  (
   id_mascota  INT NOT NULL,
   nombre_mascota  VARCHAR(45) NULL,
   raza  VARCHAR(45) NULL,
   color  VARCHAR(20) NULL,
   tamano  VARCHAR(25) NULL,
   edad  INT NULL,
   sexo  VARCHAR(15) NULL,
   propietario  VARCHAR(100) NULL,
  PRIMARY KEY ( id_mascota ))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table  quetzal . VISITA 
-- -----------------------------------------------------
DROP TABLE IF EXISTS  quetzal.VISITA  ;

CREATE TABLE IF NOT EXISTS  quetzal.VISITA  (
   id_visita  INT NOT NULL,
   fecha  DATE NULL,
   motivo_visita  VARCHAR(450) NULL,
   diagnostico  VARCHAR(450) NULL,
   id_mascota  INT NOT NULL,
  PRIMARY KEY ( id_visita ),
  INDEX  fk_VISITA_MASCOTA_idx  ( id_mascota  ASC) VISIBLE,
  CONSTRAINT  fk_VISITA_MASCOTA 
    FOREIGN KEY ( id_mascota )
    REFERENCES  quetzal.MASCOTA  ( id_mascota )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
