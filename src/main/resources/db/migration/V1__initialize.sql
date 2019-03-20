SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id                    INT(11) NOT NULL AUTO_INCREMENT,
  username              VARCHAR(50) NOT NULL,
  password              CHAR(80) NOT NULL,
  first_name            VARCHAR(50) NOT NULL,
  last_name             VARCHAR(50) NOT NULL,
  email                 VARCHAR(50) NOT NULL,
  phone                 VARCHAR(15) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS role;
CREATE TABLE role (
  id                    INT(11) NOT NULL AUTO_INCREMENT,
  name                  VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role (
  user_id               INT(11) NOT NULL,
  role_id               INT(11) NOT NULL,

  PRIMARY KEY (user_id,role_id),

--  KEY FK_ROLE_idx (role_id),

  CONSTRAINT FK_USER_ID_01 FOREIGN KEY (user_id)
  REFERENCES user (id)
  ON DELETE NO ACTION ON UPDATE NO ACTION,

  CONSTRAINT FK_ROLE_ID FOREIGN KEY (role_id)
  REFERENCES role (id)
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS product;
CREATE TABLE product (
  id                    INT(11) NOT NULL AUTO_INCREMENT,
  title                 VARCHAR(50) NOT NULL,
  cost                  DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO product VALUES (1,'Computer','500'),(2,'Smartphone','100'),(3,'TV','400'),(4,'Milk','50'),(5,'Bread','20'),(6,'Apple','10'),(7,'Banana','20'),(8,'Coffe','15'),(9,'Whore','2000'),(10,'Disk','200'),(11,'Playstation','4000'),(12,'HeadPhones','500'),(13,'Vodka','700'),(14,'Whisky','800'),(15,'Tea','25'),(16,'Snickers','600'),(17,'Notebook','15000'),(18,'Cola','60'),(19,'Snowboard','3500'),(20,'Keyboard','1800');

INSERT INTO role (name)
VALUES
('ROLE_EMPLOYEE'), ('ROLE_MANAGER'), ('ROLE_ADMIN');

INSERT INTO user (username,password,first_name,last_name,email,phone)
VALUES
('admin','$2a$10$.BJ99hWDPMLTVuOJCzYI3u4AF6WsoinJ4vchxWu5q6Dc7BJQnSjxm','Admin','Admin','admin@gmail.com','+79881111111');

INSERT INTO user_role (user_id, role_id)
VALUES
(1, 1),
(1, 2),
(1, 3);
