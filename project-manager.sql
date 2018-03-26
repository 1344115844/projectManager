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

 Date: 26/03/2018 14:05:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for academic
-- ----------------------------
DROP TABLE IF EXISTS `academic`;
CREATE TABLE `academic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学术论文',
  `createTime` datetime(0) NULL DEFAULT NULL,
  `updateTime` datetime(0) NULL DEFAULT NULL,
  `deleteTime` datetime(0) NULL DEFAULT NULL,
  `thesisName` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '论文名称\r\n',
  `Novon` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '刊物名称\r\n',
  `releasingCode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发行代码\r\n',
  `publicationLevel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '刊物级别\r\n',
  ` periodical` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '刊期\r\n',
  `publishJournals` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发表刊物\r\n',
  `collectionSituation` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收录情况\r\n',
  `authorRank` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者排名\r\n',
  `category` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别\r\n',
  `authorID` int(11) NULL DEFAULT NULL COMMENT '关联member表',
  `fileID` int(11) NULL DEFAULT NULL COMMENT '关联filepath表',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for academic-report
-- ----------------------------
DROP TABLE IF EXISTS `academic-report`;
CREATE TABLE `academic-report`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学术报告',
  `createTime` datetime(0) NULL DEFAULT NULL,
  `updateTime` datetime(0) NULL DEFAULT NULL,
  `deleteTime` datetime(0) NULL DEFAULT NULL,
  `reportTitle` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学术报告标题',
  `beginTime` datetime(0) NULL DEFAULT NULL COMMENT '学术报告开始的时间',
  `overTime` datetime(0) NULL DEFAULT NULL COMMENT '结束的时间',
  `hostUnit` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '举办单位',
  `hostPlace` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '举办地点',
  `attendNum` int(11) NULL DEFAULT NULL COMMENT '参加人数',
  `reporterID` int(11) NULL DEFAULT NULL COMMENT '报告人，关联member表',
  `fileID` int(11) NULL DEFAULT NULL COMMENT '附件id，关联filepath表',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for attend-conference
-- ----------------------------
DROP TABLE IF EXISTS `attend-conference`;
CREATE TABLE `attend-conference`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '参加学术会议',
  `createTime` datetime(0) NULL DEFAULT NULL,
  `updateTime` datetime(0) NULL DEFAULT NULL,
  `deleteTime` datetime(0) NULL DEFAULT NULL,
  `conferenceName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会议名称\r\n',
  `paperTitle` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '论文题目',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '举办时间',
  `place` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地点',
  `hostUnit` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主办单位',
  `conferenceCategory` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会议类别',
  `attendID` int(11) NULL DEFAULT NULL COMMENT '参加人id，关联member表',
  `fileID` int(11) NULL DEFAULT NULL COMMENT '附件id，关联filepath表',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for award
-- ----------------------------
DROP TABLE IF EXISTS `award`;
CREATE TABLE `award`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '获奖信息',
  `createTime` datetime(0) NULL DEFAULT NULL,
  `updateTime` datetime(0) NULL DEFAULT NULL,
  `deleteTime` datetime(0) NULL DEFAULT NULL,
  `projectName` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目名称\r\n',
  `awardName` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '获奖名称',
  `awardLevel` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '获奖等级',
  `awardTime` datetime(0) NULL DEFAULT NULL COMMENT '获奖时间',
  `awardRank` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '获奖排行',
  `awardID` int(11) NULL DEFAULT NULL COMMENT '获奖人id，关联member表',
  `fileID` int(11) NULL DEFAULT NULL COMMENT '附件id，关联filepath表',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for copyright
-- ----------------------------
DROP TABLE IF EXISTS `copyright`;
CREATE TABLE `copyright`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '软件著作权',
  `createTime` datetime(0) NULL DEFAULT NULL,
  `updateTime` datetime(0) NULL DEFAULT NULL,
  `deleteTime` datetime(0) NULL DEFAULT NULL,
  `rightName` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '著作权名称',
  `rank` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排名',
  `awardTime` datetime(0) NULL DEFAULT NULL COMMENT '颁发时间',
  `rightNum` int(11) NULL DEFAULT NULL COMMENT '证书编号',
  `memberID` int(11) NULL DEFAULT NULL COMMENT '软件著作权所属人，关联member表',
  `fileID` int(11) NULL DEFAULT NULL COMMENT '附件id，关联filepath表',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for editbook
-- ----------------------------
DROP TABLE IF EXISTS `editbook`;
CREATE TABLE `editbook`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '参与教材表',
  `createTime` datetime(0) NULL DEFAULT NULL,
  `updateTime` datetime(0) NULL DEFAULT NULL,
  `deleteTime` datetime(0) NULL DEFAULT NULL,
  `bookName` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教材名称',
  `editRank` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编辑排名',
  `ISBN` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '书号',
  `publishUnit` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出版单位',
  `publishTime` datetime(0) NULL DEFAULT NULL COMMENT '出版时间',
  `byte` int(25) NULL DEFAULT NULL COMMENT '字数',
  `memberID` int(11) NULL DEFAULT NULL COMMENT '编辑人，关联member 表',
  `fileID` int(11) NULL DEFAULT NULL COMMENT '附件id，关联filepath表',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for filepath
-- ----------------------------
DROP TABLE IF EXISTS `filepath`;
CREATE TABLE `filepath`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '附件表',
  `createTime` datetime(0) NULL DEFAULT NULL,
  `updateTime` datetime(0) NULL DEFAULT NULL,
  `deleteTime` datetime(0) NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for investigate
-- ----------------------------
DROP TABLE IF EXISTS `investigate`;
CREATE TABLE `investigate`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '外出考察',
  `deleteTime` datetime(0) NULL DEFAULT NULL,
  `updateTime` datetime(0) NULL DEFAULT NULL,
  `createTime` datetime(0) NULL DEFAULT NULL,
  `beginTime` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `overTime` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `investigatePlace` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '考察地点',
  `investigateContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '考察内容',
  `investigatorID` int(11) NULL DEFAULT NULL COMMENT '考察者id，关联member表',
  `fileID` int(11) NULL DEFAULT NULL COMMENT '附件id，关联filepath表',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '成员表',
  `name` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '人员名称\r\n',
  `jobTitle` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职称\r\n',
  `education` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
  `researchDirection` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '研究方向',
  `AcademicTitle` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学术头衔\r\n',
  `createTime` datetime(0) NULL DEFAULT NULL,
  `updateTime` datetime(0) NULL DEFAULT NULL,
  `deleteTime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for patent
-- ----------------------------
DROP TABLE IF EXISTS `patent`;
CREATE TABLE `patent`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '专利表',
  `deleteTime` datetime(0) NULL DEFAULT NULL,
  `updateTime` datetime(0) NULL DEFAULT NULL,
  `createTime` datetime(0) NULL DEFAULT NULL,
  `patentName` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专利名称',
  `patentRank` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专利排名',
  `patentForm` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `authority` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权',
  `registrationEnterprise` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登记单位',
  `patentNum` int(11) NULL DEFAULT NULL COMMENT '证书编号',
  `memberID` int(11) NULL DEFAULT NULL COMMENT '专利人id，关联member表',
  `fileID` int(11) NULL DEFAULT NULL COMMENT '附件id，关联filepath表',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `id` int(25) NOT NULL AUTO_INCREMENT COMMENT '科研项目',
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
  `creatTime` datetime(0) NULL DEFAULT NULL,
  `deleteTime` datetime(0) NULL DEFAULT NULL,
  `updateTime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for speech
-- ----------------------------
DROP TABLE IF EXISTS `speech`;
CREATE TABLE `speech`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '受聘讲学',
  `createTime` datetime(0) NULL DEFAULT NULL,
  `updateTime` datetime(0) NULL DEFAULT NULL,
  `deleteTime` datetime(0) NULL DEFAULT NULL,
  `inviteTime` datetime(0) NULL DEFAULT NULL COMMENT '邀请时间',
  `beginTime` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `overTime` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `speechForm` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '演讲形式',
  `speakerID` int(11) NULL DEFAULT NULL COMMENT '演讲者id，与member表关联',
  `fileID` int(11) NULL DEFAULT NULL COMMENT '附件id，与filepath表关联',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for study
-- ----------------------------
DROP TABLE IF EXISTS `study`;
CREATE TABLE `study`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '进修学习',
  `createTime` datetime(0) NULL DEFAULT NULL,
  `updateTime` datetime(0) NULL DEFAULT NULL,
  `deleteTime` datetime(0) NULL DEFAULT NULL,
  `beginTime` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `overTime` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `school` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '进修学校',
  `studyContent` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学习内容',
  `learnerID` int(11) NULL DEFAULT NULL COMMENT '进修者id，关联member表',
  `fileID` int(11) NULL DEFAULT NULL COMMENT '附件id，关联filepath表',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for unit
-- ----------------------------
DROP TABLE IF EXISTS `unit`;
CREATE TABLE `unit`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学术团体',
  `deleteTime` datetime(0) NULL DEFAULT NULL,
  `updateTime` datetime(0) NULL DEFAULT NULL,
  `createTime` datetime(0) NULL DEFAULT NULL,
  `unitName` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学术团体名称',
  `hostUnit` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主办单位',
  `duty` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职务',
  `term` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任期',
  `memberID` int(11) NULL DEFAULT NULL COMMENT '成员id，关联member表',
  `fileID` int(11) NULL DEFAULT NULL COMMENT '附件id，关联filepath表',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '账户表',
  `username` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `createTime` datetime(0) NULL DEFAULT NULL,
  `daeleteTime` datetime(0) NULL DEFAULT NULL,
  `updateTime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
