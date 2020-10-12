/*
Navicat MySQL Data Transfer

Source Server         : iotgo
Source Server Version : 50559
Source Host           : ticket.iotgo.fun:3306
Source Database       : iotgo

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2020-10-12 18:00:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adminLoginName` varchar(255) DEFAULT NULL,
  `adminPassword` varchar(255) DEFAULT NULL,
  `adminName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for dev
-- ----------------------------
DROP TABLE IF EXISTS `dev`;
CREATE TABLE `dev` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `devName` varchar(255) DEFAULT NULL,
  `devType` int(255) DEFAULT NULL,
  `devDes` varchar(255) DEFAULT NULL,
  `devTopic` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

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
  `id` int(11) NOT NULL,
  `devId` int(11) DEFAULT NULL,
  `devStatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `devTypeName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of devtype
-- ----------------------------
INSERT INTO `devtype` VALUES ('1', '温度传感器');
INSERT INTO `devtype` VALUES ('2', '开关传感器');

-- ----------------------------
-- Table structure for todo
-- ----------------------------
DROP TABLE IF EXISTS `todo`;
CREATE TABLE `todo` (
  `id` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL COMMENT '提醒标题',
  `content` text COMMENT '提醒内容',
  `url` varchar(255) DEFAULT NULL COMMENT '提醒URL',
  `startTime` datetime NOT NULL COMMENT '提醒开始时间',
  `endTime` datetime NOT NULL COMMENT '提醒结束时间',
  `isCycle` tinyint(4) DEFAULT '0' COMMENT '是否为周期提醒 1代表TRUE,0代表FALSE',
  `cycleTime` datetime NOT NULL COMMENT '周期提醒时间',
  `isDone` tinyint(4) DEFAULT '0' COMMENT '是否完成 1代表TRUE,0代表FALSE',
  `belongListId` int(11) NOT NULL DEFAULT '0' COMMENT '归属提醒列表',
  `deviceId` int(11) NOT NULL DEFAULT '0' COMMENT '提醒归属设备的Id(需要提醒到哪个设备上)',
  `orderSum` int(11) DEFAULT '0' COMMENT '提醒顺序 0优先级最低，数越大越往上',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of todo
-- ----------------------------

-- ----------------------------
-- Table structure for todoList
-- ----------------------------
DROP TABLE IF EXISTS `todoList`;
CREATE TABLE `todoList` (
  `id` int(11) NOT NULL,
  `todoListName` varchar(255) NOT NULL COMMENT '提醒列表名称',
  `content` varchar(255) DEFAULT NULL COMMENT '提醒列表说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of todoList
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userLoginName` varchar(255) DEFAULT NULL,
  `userPassword` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `userTel` int(11) DEFAULT NULL,
  `userDes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'user1', '1', '用户1', null, null);

-- ----------------------------
-- Table structure for userdevrelation
-- ----------------------------
DROP TABLE IF EXISTS `userdevrelation`;
CREATE TABLE `userdevrelation` (
  `id` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `devId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userdevrelation
-- ----------------------------
INSERT INTO `userdevrelation` VALUES ('1', '1', '1');
INSERT INTO `userdevrelation` VALUES ('2', '1', '2');
