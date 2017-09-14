/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50130
Source Host           : localhost:3306
Source Database       : iotlife

Target Server Type    : MYSQL
Target Server Version : 50130
File Encoding         : 65001

Date: 2017-09-14 23:08:40
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id`             INT(11) NOT NULL AUTO_INCREMENT,
  `adminLoginName` VARCHAR(255)     DEFAULT NULL,
  `adminPassword`  VARCHAR(255)     DEFAULT NULL,
  `adminName`      VARCHAR(255)     DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = MyISAM
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for dev
-- ----------------------------
DROP TABLE IF EXISTS `dev`;
CREATE TABLE `dev` (
  `id`       INT(11) NOT NULL AUTO_INCREMENT,
  `devName`  VARCHAR(255)     DEFAULT NULL,
  `devType`  INT(255)         DEFAULT NULL,
  `devDes`   VARCHAR(255)     DEFAULT NULL,
  `devTopic` VARCHAR(255)     DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = MyISAM
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for devtype
-- ----------------------------
DROP TABLE IF EXISTS `devtype`;
CREATE TABLE `devtype` (
  `id`          INT(11) NOT NULL AUTO_INCREMENT,
  `devTypeName` VARCHAR(255)     DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = MyISAM
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id`            INT(11) NOT NULL AUTO_INCREMENT,
  `userLoginName` VARCHAR(255)     DEFAULT NULL,
  `userPassword`  VARCHAR(255)     DEFAULT NULL,
  `userName`      VARCHAR(255)     DEFAULT NULL,
  `userTel`       INT(11)          DEFAULT NULL,
  `userDes`       VARCHAR(255)     DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = MyISAM
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for userdevrelation
-- ----------------------------
DROP TABLE IF EXISTS `userdevrelation`;
CREATE TABLE `userdevrelation` (
  `id`     INT(11) NOT NULL,
  `userId` INT(11) DEFAULT NULL,
  `devId`  INT(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = MyISAM
  DEFAULT CHARSET = utf8;
