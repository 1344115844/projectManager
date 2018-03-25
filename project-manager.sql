/*
 Navicat Premium Data Transfer

 Source Server         : xampp
 Source Server Type    : MySQL
 Source Server Version : 100130
 Source Host           : localhost:3306
 Source Schema         : project-manager

 Target Server Type    : MySQL
 Target Server Version : 100130
 File Encoding         : 65001

 Date: 25/03/2018 22:04:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for filepath
-- ----------------------------
DROP TABLE IF EXISTS `filepath`;
CREATE TABLE `filepath`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createTime` datetime(0) NULL DEFAULT NULL,
  `updateTime` datetime(0) NULL DEFAULT NULL,
  `deleteTime` datetime(0) NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `id` int(25) NOT NULL AUTO_INCREMENT,
  `projectName` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT ' 项目名称\r\n',
  `projectNumber` int(10) NULL DEFAULT NULL COMMENT '编号\r\n',
  ` projectSource` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目来源',
  `beginTime` datetime(0) NULL DEFAULT NULL COMMENT '项目开始时间',
  `overTime` datetime(0) NULL DEFAULT NULL COMMENT '项目结束时间',
  `funds` double(20, 0) NULL DEFAULT NULL COMMENT '项目经费',
  `level` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目级别',
  `isTeamWork` int(1) NULL DEFAULT NULL COMMENT '是否合作研究',
  `state` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目状态',
  `projectDirector` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课题负责人，关联member表\r\n',
  `fileID` int(20) NULL DEFAULT NULL COMMENT '附件地址关联filepath表',
  `memberID` int(10) NULL DEFAULT NULL COMMENT '参与人，关联member表',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
