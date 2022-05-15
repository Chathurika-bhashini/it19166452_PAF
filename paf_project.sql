create database paf_project;

use paf_project;



-- Payment table --------------
DROP TABLE IF EXISTS payment;

CREATE TABLE IF NOT EXISTS payment (
  PaymenID int(4) NOT NULL AUTO_INCREMENT,
  PaymenType char(5) NOT NULL,
  PaymenPrice double NOT NULL,
  PaymenDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (PaymenID)
);
select * from payment;


