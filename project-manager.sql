/*
 Navicat Premium Data Transfer

 Source Server         : xam
 Source Server Type    : MySQL
 Source Server Version : 100130
 Source Host           : localhost:3306
 Source Schema         : project-manager

 Target Server Type    : MySQL
 Target Server Version : 100130
 File Encoding         : 65001

 Date: 09/04/2018 00:08:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for academic
-- ----------------------------
DROP TABLE IF EXISTS `academic`;
CREATE TABLE `academic`  (
  `acad_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学术论文',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `deleted` int(11) UNSIGNED NULL DEFAULT 0,
  `thesis_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '论文名称\r\n',
  `novon` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '刊物名称\r\n',
  `releasing_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发行代码\r\n',
  `publication_level` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '刊物级别\r\n',
  `periodical` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '刊期\r\n',
  `publish_journals` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发表刊物\r\n',
  `collection_situation` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收录情况\r\n',
  `author_rank` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者排名\r\n',
  `category` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别\r\n',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '关联member表',
  `file_id` int(11) NULL DEFAULT NULL COMMENT '关联filepath表',
  PRIMARY KEY (`acad_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for academicreport
-- ----------------------------
DROP TABLE IF EXISTS `academicreport`;
CREATE TABLE `academicreport`  (
  `rep_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学术报告',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `deleted` int(11) NULL DEFAULT 0,
  `report_title` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学术报告标题',
  `begin_time` datetime(0) NULL DEFAULT NULL COMMENT '学术报告开始的时间',
  `over_time` datetime(0) NULL DEFAULT NULL COMMENT '结束的时间',
  `host_unit` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '举办单位',
  `host_place` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '举办地点',
  `attend_num` int(11) NULL DEFAULT NULL COMMENT '参加人数',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '报告人，关联member表',
  `file_id` int(11) NULL DEFAULT NULL COMMENT '附件id，关联filepath表',
  PRIMARY KEY (`rep_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for attendconference
-- ----------------------------
DROP TABLE IF EXISTS `attendconference`;
CREATE TABLE `attendconference`  (
  `conf_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '参加学术会议',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `deleted` int(11) NULL DEFAULT 0,
  `conference_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会议名称\r\n',
  `paper_title` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '论文题目',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '举办时间',
  `place` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地点',
  `host_unit` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主办单位',
  `conference_category` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会议类别',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '参加人id，关联member表',
  `file_id` int(11) NULL DEFAULT NULL COMMENT '附件id，关联filepath表',
  PRIMARY KEY (`conf_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority`  (
  `auth_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限表',
  `auth_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册权限',
  PRIMARY KEY (`auth_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for award
-- ----------------------------
DROP TABLE IF EXISTS `award`;
CREATE TABLE `award`  (
  `award_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '获奖信息',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `deleted` int(11) NULL DEFAULT 0,
  `project_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目名称\r\n',
  `award_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '获奖名称',
  `award_level` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '获奖等级',
  `award_time` datetime(0) NULL DEFAULT NULL COMMENT '获奖时间',
  `award_rank` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '获奖排行',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '获奖人id，关联member表',
  `file_id` int(11) NULL DEFAULT NULL COMMENT '附件id，关联filepath表',
  PRIMARY KEY (`award_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for copyright
-- ----------------------------
DROP TABLE IF EXISTS `copyright`;
CREATE TABLE `copyright`  (
  `copy_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '软件著作权',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `deleted` int(11) NULL DEFAULT 0,
  `right_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '著作权名称',
  `rank` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排名',
  `award_time` datetime(0) NULL DEFAULT NULL COMMENT '颁发时间',
  `right_num` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证书编号',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '软件著作权所属人，关联member表',
  `file_id` int(11) NULL DEFAULT NULL COMMENT '附件id，关联filepath表',
  PRIMARY KEY (`copy_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for editbook
-- ----------------------------
DROP TABLE IF EXISTS `editbook`;
CREATE TABLE `editbook`  (
  `edit_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '参与教材表',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `deleted` int(11) NULL DEFAULT 0,
  `book_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教材名称',
  `edit_rank` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编辑排名',
  `isbn` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '书号',
  `publish_unit` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出版单位',
  `publish_time` datetime(0) NULL DEFAULT NULL COMMENT '出版时间',
  `byte_num` int(25) NULL DEFAULT NULL COMMENT '字数',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '编辑人，关联member 表',
  `file_id` int(11) NULL DEFAULT NULL COMMENT '附件id，关联filepath表',
  PRIMARY KEY (`edit_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for filepath
-- ----------------------------
DROP TABLE IF EXISTS `filepath`;
CREATE TABLE `filepath`  (
  `file_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '附件表',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `deleted` int(11) NULL DEFAULT 0,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`file_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 259 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for investigate
-- ----------------------------
DROP TABLE IF EXISTS `investigate`;
CREATE TABLE `investigate`  (
  `inv_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '外出考察',
  `deleted` int(11) NULL DEFAULT 0,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `begin_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `over_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `investigate_place` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '考察地点',
  `investigate_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '考察内容',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '考察者id，关联member表',
  `file_id` int(11) NULL DEFAULT NULL COMMENT '附件id，关联filepath表',
  PRIMARY KEY (`inv_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for patent
-- ----------------------------
DROP TABLE IF EXISTS `patent`;
CREATE TABLE `patent`  (
  `tent_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '专利表',
  `deleted` int(11) NULL DEFAULT 0,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `patent_tame` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专利名称',
  `patent_rank` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专利排名',
  `patent_form` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `authority` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权',
  `registration_enterprise` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登记单位',
  `patent_num` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证书编号',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '专利人id，关联member表',
  `file_id` int(11) NULL DEFAULT NULL COMMENT '附件id，关联filepath表',
  PRIMARY KEY (`tent_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `pro_id` int(25) NOT NULL AUTO_INCREMENT COMMENT '科研项目',
  `project_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT ' 项目名称\r\n',
  `project_number` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '编号\r\n',
  `project_source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目来源',
  `begin_time` datetime(0) NULL DEFAULT NULL COMMENT '项目开始时间',
  `over_time` datetime(0) NULL DEFAULT NULL COMMENT '项目结束时间',
  `funds` double(20, 4) NULL DEFAULT NULL COMMENT '项目经费',
  `level` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目级别',
  `is_teamwork` int(1) NULL DEFAULT NULL COMMENT '是否合作研究',
  `state` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目状态',
  `project_director` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课题负责人，关联member表\r\n',
  `file_id` int(20) NULL DEFAULT NULL COMMENT '附件地址关联filepath表',
  `user_id` int(10) NULL DEFAULT NULL COMMENT '参与人，关联member表',
  `creat_time` datetime(0) NULL DEFAULT NULL,
  `deleted` int(11) NULL DEFAULT 0,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`pro_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for speech
-- ----------------------------
DROP TABLE IF EXISTS `speech`;
CREATE TABLE `speech`  (
  `speech_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '受聘讲学',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `deleted` int(11) NULL DEFAULT 0,
  `invite_time` datetime(0) NULL DEFAULT NULL COMMENT '邀请时间',
  `begin_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `over_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `speech_form` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '演讲形式',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '演讲者id，与member表关联',
  `file_id` int(11) NULL DEFAULT NULL COMMENT '附件id，与filepath表关联',
  PRIMARY KEY (`speech_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for study
-- ----------------------------
DROP TABLE IF EXISTS `study`;
CREATE TABLE `study`  (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '进修学习',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `deleted` int(11) NULL DEFAULT 0,
  `begin_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `over_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `school` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '进修学校',
  `study_content` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学习内容',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '进修者id，关联member表',
  `file_id` int(11) NULL DEFAULT NULL COMMENT '附件id，关联filepath表',
  PRIMARY KEY (`stu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for unit
-- ----------------------------
DROP TABLE IF EXISTS `unit`;
CREATE TABLE `unit`  (
  `unit_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学术团体',
  `deleted` int(11) NULL DEFAULT 0,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `unit_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学术团体名称',
  `host_unit` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主办单位',
  `duty` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职务',
  `term` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任期',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '成员id，关联member表',
  `file_id` int(11) NULL DEFAULT NULL COMMENT '附件id，关联filepath表',
  PRIMARY KEY (`unit_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '成员表',
  `name` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '人员名称\r\n',
  `short_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '短号',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '长号',
  `job_title` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职称\r\n',
  `education` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
  `research_direction` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '研究方向',
  `academic_title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学术头衔\r\n',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `deleted` int(11) NULL DEFAULT 0,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
