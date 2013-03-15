SET foreign_key_checks = 0;

    DROP TABLE IF EXISTS Building;
    DROP TABLE IF EXISTS Entrance
    DROP TABLE IF EXISTS Apartment;
    DROP TABLE IF EXISTS Person;

    DROP TABLE IF EXISTS Apartment_Owner;
    DROP TABLE IF EXISTS Apartment_Habitant;

SET foreign_key_checks = 1;


-- -----------------------------------------------------
-- Table Building
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS Building (
  bdng_id               INT UNSIGNED NOT NULL,
  address               VARCHAR(200) NOT NULL,
  floors_number         INT NOT NULL DEFAULT 1,
  PRIMARY KEY (bdng_id)
) DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci 
  COMMENT = 'Будинки, що входять до ОСББ';
