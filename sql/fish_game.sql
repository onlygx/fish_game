/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : fish_game

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-01-27 17:30:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for game
-- ----------------------------
DROP TABLE IF EXISTS `game`;
CREATE TABLE `game` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `time` timestamp NULL DEFAULT NULL,
  `zhu` varchar(255) DEFAULT NULL,
  `cheng` varchar(255) DEFAULT NULL,
  `chang` int(11) DEFAULT NULL,
  `qu` int(11) DEFAULT NULL,
  `intro` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of game
-- ----------------------------
INSERT INTO `game` VALUES ('1234', '赛事名称2', '2016-01-20 09:39:23', '主办方1', '承办方1', '2', '4', '备注');
INSERT INTO `game` VALUES ('888888', '赛事名称', '2016-01-20 09:39:21', '主办方1', '承办方1', '2', '4', '备注');
INSERT INTO `game` VALUES ('2007229410189657170', '赛事名称3', '2016-01-20 14:59:06', '主办方3', '承办方3', '2', '4', '备注');
INSERT INTO `game` VALUES ('3801650139755203253', '赛事名称6', '2016-01-20 15:11:23', '主办方346', '承办方346', '3', '8', '备注46');
INSERT INTO `game` VALUES ('3803059139608003579', '新的比赛666', '2016-01-27 15:30:00', '主办方346', '承办方346', '3', '8', '备注46');
INSERT INTO `game` VALUES ('3927956532945765506', '赛事名称6', '2016-01-27 10:48:48', '主办方346', '承办方346', '3', '8', '备注46');
INSERT INTO `game` VALUES ('4727686310689029324', '赛事名称5', '2016-01-20 14:59:20', '主办方34', '承办方34', '3', '8', '备注4');

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `id` bigint(20) NOT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  `game_id` bigint(20) DEFAULT NULL,
  `time` timestamp NULL DEFAULT NULL,
  `chang` int(11) DEFAULT NULL,
  `qu` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `weight` double(5,2) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  `ranking` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of grade
-- ----------------------------

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `price` double(5,2) DEFAULT NULL,
  `intro` varchar(255) DEFAULT NULL,
  `game_id` bigint(20) DEFAULT NULL,
  `group` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('98196183983410979', '三号', '4', '333', null, null, null, '3803059139608003579', null, null);
INSERT INTO `person` VALUES ('257519209246248724', '六号', '20', '66', '66', '66.00', '66', '3803059139608003579', '111', null);
INSERT INTO `person` VALUES ('733383408978015654', '三号', '20', '33', '33', '33.00', '33', '3803059139608003579', '', null);
INSERT INTO `person` VALUES ('1133487955313510135', '二号', '2', '222', null, null, null, '3803059139608003579', null, null);
INSERT INTO `person` VALUES ('3297972990748674880', '十号', '20', '', '', null, '', '3803059139608003579', '33', null);
INSERT INTO `person` VALUES ('3416081322979602603', '九号', '20', '', '', null, '', '3803059139608003579', '33', null);
INSERT INTO `person` VALUES ('4183627603786222814', '五号', '20', '', '', null, '', '3803059139608003579', '', null);
INSERT INTO `person` VALUES ('5058590240752449458', '二号', '20', '22', '222', '22.00', '22', '3803059139608003579', '', null);
INSERT INTO `person` VALUES ('6302938579990788394', '八号', '20', '88', '', null, '', '3803059139608003579', '22', null);
INSERT INTO `person` VALUES ('6522618621713758915', '十一号', '20', '', '', null, '', '3803059139608003579', '', null);
INSERT INTO `person` VALUES ('6736844239283795362', '一号', '1', '1', null, null, null, '3927956532945765506', null, null);
INSERT INTO `person` VALUES ('6891828411900120412', '十一号', '1', '111', null, null, null, '3803059139608003579', null, null);
INSERT INTO `person` VALUES ('7434026844091169889', '二号', '2', '2', null, null, null, '3927956532945765506', null, null);
INSERT INTO `person` VALUES ('7560542290779288105', '三号', '3', '3', null, null, null, '3927956532945765506', null, null);
INSERT INTO `person` VALUES ('8003358367502647613', '一号', '20', '111', '111', '111.00', '111', '3803059139608003579', '111', null);
INSERT INTO `person` VALUES ('8159000854973298927', '六号', '20', '66', '66', '66.00', '66', '3927956532945765506', '66', null);
INSERT INTO `person` VALUES ('8557874525916738099', '5', '5', '5', null, null, null, '3927956532945765506', null, null);
INSERT INTO `person` VALUES ('8868511489929792630', '七号', '20', '77', '77', '77.00', '77', '3803059139608003579', '22', null);
INSERT INTO `person` VALUES ('9215931324572415205', '四号', '20', '', '', null, '', '3803059139608003579', '', null);
INSERT INTO `person` VALUES ('9220897601735246404', '4', '4', '4', null, null, null, '3927956532945765506', null, null);
