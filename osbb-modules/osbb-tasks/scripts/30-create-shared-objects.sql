-- -----------------------------------------------------
-- Table User_Login
-- -----------------------------------------------------
DROP TABLE IF EXISTS User_Login;

CREATE  TABLE IF NOT EXISTS User_Login (
  login_id              INT UNSIGNED NOT NULL AUTO_INCREMENT,
  username              VARCHAR(100) NOT NULL,
  password              VARCHAR(100) NOT NULL,
  email                 VARCHAR(100) NOT NULL,
  database_name         VARCHAR(36) NOT NULL,
  activation_uuid       VARCHAR(36) NULL,
  user_id               INT NOT NULL,
  PRIMARY KEY (login_id)
) DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci 
  COMMENT = 'Інформація для входу в систему';


-- test --
INSERT INTO `User_Login` VALUES (1, 'paco', 'hola', 'paco.hola@test.org', 'osbb_test', null, 1);
INSERT INTO `User_Login` VALUES (2, 'jaalonso', 'hola', 'jaalonso.hola@test.org', 'osbb_test', null, 2);
INSERT INTO `User_Login` VALUES (3, 'joko', 'hola', 'joko.hola@test.org', 'osbb_test', null, 3);

-- another --
INSERT INTO `User_Login` VALUES (4, 'Gardo', 'hola', 'gardo.hola@test.org', 'osbb_another', null, 4);
INSERT INTO `User_Login` VALUES (5, 'ramon', 'hola', 'ramon.hola@test.org', 'osbb_another', null, 5);
INSERT INTO `User_Login` VALUES (6, 'hose', 'hola', 'hose.hola@test.org', 'osbb_another', null, 6);
