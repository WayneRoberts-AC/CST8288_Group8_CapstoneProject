-- MySQL Workbench Forward Engineering

-- MY SQL Workbench Version : 8.0.33

-- -----------------------------------------------------
-- Database RestuarantReviews
-- -----------------------------------------------------
CREATE DATABASE IF NOT EXISTS `RestuarantReviews` DEFAULT CHARACTER SET utf8 ;
USE `RestuarantReviews` ;

-- -----------------------------------------------------
-- Create user
-- Source for create user code. 
-- https://stackoverflow.com/questions/13357760/mysql-create-user-if-not-exists
-- Source for granting user permissions 
-- https://dev.mysql.com/doc/refman/8.0/en/grant.html

-- -----------------------------------------------------
CREATE USER IF NOT EXISTS 'rr_user'@'localhost' IDENTIFIED BY 'rr_password';
GRANT INSERT, SELECT, UPDATE, DELETE ON RestuarantReviews. * TO 'rr_user'@'localhost';



-- -----------------------------------------------------
-- Table `RestuarantReviews`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RestuarantReviews`.`user` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `UserName` VARCHAR(45) NULL,
  `Password` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `LastName` VARCHAR(45) NULL,
  `FirstName` VARCHAR(45) NULL,
  `RoleName` VARCHAR(45) NULL,
  `AccountVerified` TINYINT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RestuarantReviews`.`business`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RestuarantReviews`.`business` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL,
  `Address` VARCHAR(45) NULL,
  `Description` VARCHAR(250) NULL,
  `PhoneNumber` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `OverallRating` INT NULL,
  `PriceRating` INT NULL,
  `FoodType` VARCHAR(45) NULL,
  `PhotosFileName` VARCHAR(45) NULL,
  `HoursOfOperation` VARCHAR(45) NULL,
  `User_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_business_user1_idx` (`User_ID` ASC) VISIBLE,
  CONSTRAINT `fk_business_user1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `RestuarantReviews`.`user` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RestuarantReviews`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RestuarantReviews`.`business` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL,
  `Address` VARCHAR(45) NULL,
  `Description` VARCHAR(250) NULL,
  `PhoneNumber` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `OverallRating` INT NULL,
  `PriceRating` INT NULL,
  `PhotosFileName` VARCHAR(45) NULL,
  `HoursOfOperation` VARCHAR(45) NULL,
  `User_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_business_user1_idx` (`User_ID` ASC) VISIBLE,
  CONSTRAINT `fk_business_user1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `RestuarantReviews`.`user` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `RestuarantReviews`.`foodType`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RestuarantReviews`.`foodType` (
  `ID` INT NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `RestuarantReviews`.`business_foodType`
-- Table is used to reslove the many to many relationship. 
-- A business can serve more than one type of food. 
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RestuarantReviews`.`business_foodType` (
  `foodType_ID` INT NOT NULL,
  `business_ID` INT NOT NULL,
  INDEX `fk_business_foodType_foodType1_idx` (`foodType_ID` ASC) VISIBLE,
  INDEX `fk_business_foodType_business1_idx` (`business_ID` ASC) VISIBLE,
  CONSTRAINT `fk_business_foodType_foodType1`
    FOREIGN KEY (`foodType_ID`)
    REFERENCES `RestuarantReviews`.`foodType` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_business_foodType_business1`
    FOREIGN KEY (`business_ID`)
    REFERENCES `RestuarantReviews`.`business` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Insert same data into users table. 
-- -----------------------------------------------------
INSERT INTO user (ID, UserName, Password, Email, LastName, FirstName, RoleName, AccountVerified)
VALUES (1, 'Admin', 'admin', 'admin@gmail.com', '', '', 'Admin', 1);

INSERT INTO user (ID, UserName, Password, Email, LastName, FirstName, RoleName, AccountVerified)
VALUES (2, 'JaneDoe123', 'password', 'janeDoe123@gmail.com', 'Doe', 'Jane', 'Contributor', 1);

INSERT INTO user (ID, UserName, Password, Email, LastName, FirstName, RoleName, AccountVerified)
VALUES (3, 'JohnDoe456', 'password', 'johnDoe456@gmail.com', 'Doe', 'John', 'Contributor', 1);
