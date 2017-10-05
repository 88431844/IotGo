/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50130
Source Host           : localhost:3306
Source Database       : iotlife

Target Server Type    : MYSQL
Target Server Version : 50130
File Encoding         : 65001

Date: 2017-10-05 15:18:57
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
-- Records of admin
-- ----------------------------

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
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of dev
-- ----------------------------
INSERT INTO `dev` VALUES ('1', '室外传感器', '1', '在室外的传感器', '/room/senser/01');
INSERT INTO `dev` VALUES ('2', '门窗传感器', '2', '门窗打开关闭传感器', '/room/senser/02');
INSERT INTO `dev` VALUES ('3', '室内传感器', '1', '在室内的传感器', '/room/senser/03');

-- ----------------------------
-- Table structure for devstatus
-- ----------------------------
DROP TABLE IF EXISTS `devstatus`;
CREATE TABLE `devstatus` (
  `id`        INT(11) NOT NULL,
  `devId`     INT(11) DEFAULT NULL,
  `devStatus` INT(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = MyISAM
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of devstatus
-- ----------------------------
INSERT INTO `devstatus` VALUES ('1', '1', '1');
INSERT INTO `devstatus` VALUES ('2', '2', '0');
INSERT INTO `devstatus` VALUES ('3', '3', '1');

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
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of devtype
-- ----------------------------
INSERT INTO `devtype` VALUES ('1', '温度传感器');
INSERT INTO `devtype` VALUES ('2', '开关传感器');

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
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'user1', '1', '用户1', NULL, NULL);

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

-- ----------------------------
-- Records of userdevrelation
-- ----------------------------
INSERT INTO `userdevrelation` VALUES ('1', '1', '1');
INSERT INTO `userdevrelation` VALUES ('2', '1', '2');
