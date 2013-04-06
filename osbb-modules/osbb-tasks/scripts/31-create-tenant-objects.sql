SET foreign_key_checks = 0;

    DROP TABLE IF EXISTS Building;
    DROP TABLE IF EXISTS Entrance;
    DROP TABLE IF EXISTS Apartment;
    DROP TABLE IF EXISTS Person;

    DROP TABLE IF EXISTS Apartment_Owner;
    DROP TABLE IF EXISTS Apartment_Habitant;

SET foreign_key_checks = 1;


-- -----------------------------------------------------
-- Table Building
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Building (
    bdng_id             INT UNSIGNED NOT NULL,
    address             VARCHAR(200) NOT NULL,
    floors_number       INT NOT NULL DEFAULT 1,
    PRIMARY KEY (bdng_id)
) DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci 
    COMMENT = 'Будинки, що входять до ОСББ';

-- -----------------------------------------------------
-- Table Entrance
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Entrance (
    entr_id             INT UNSIGNED NOT NULL,
    `number`            INT NOT NULL,
    building            INT UNSIGNED NOT NULL,
    PRIMARY KEY (entr_id),
    INDEX fk_entr_bdng (building ASC),
    CONSTRAINT fk_entr_bdng
        FOREIGN KEY (building) REFERENCES Building (bdng_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
) DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci 
    COMMENT = 'Під''їзди у будинку';

-- -----------------------------------------------------
-- Table Apartment
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Apartment (
    aprt_id             INT UNSIGNED NOT NULL,
    post_address        VARCHAR(200) NOT NULL,
    building            INT UNSIGNED NULL,
    entrance            INT UNSIGNED NULL,
    PRIMARY KEY (aprt_id),
    INDEX fk_aprt_bdng (building ASC),
    CONSTRAINT fk_aprt_bdng
        FOREIGN KEY (building) REFERENCES Building (bdng_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    INDEX fk_aprt_entr (entrance ASC),
    CONSTRAINT fk_aprt_entr
        FOREIGN KEY (entrance) REFERENCES Entrance (entr_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
) DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci 
    COMMENT = 'Квартири';

-- -----------------------------------------------------
-- Table Person
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Person (
    prsn_id             INT UNSIGNED NOT NULL AUTO_INCREMENT,
    lastName            VARCHAR(45) NOT NULL,
    firstName           VARCHAR(45) NOT NULL,
    midleName           VARCHAR(45) NOT NULL,
    PRIMARY KEY (prsn_id)
) DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci 
  COMMENT = 'Особа може бути мешканцем або орендарем';
