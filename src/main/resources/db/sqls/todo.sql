CREATE TABLE IF NOT EXISTS `todo`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `name` VARCHAR(128) NOT NULL,
   `priority` INT NOT NULL,
   `status` INT NOT NULL ,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `todo`(name, priority, status)  VALUES ( 'Write the report', 1, 0)