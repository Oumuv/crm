/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.3_3306
Source Server Version : 50130
Source Host           : 192.168.1.3:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50130
File Encoding         : 65001

Date: 2017-09-15 11:13:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `loginrecord`
-- ----------------------------
DROP TABLE IF EXISTS `loginrecord`;
CREATE TABLE `loginrecord` (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `login_date` datetime DEFAULT NULL COMMENT '登录时间记录',
  `login_site` varchar(120) DEFAULT NULL,
  KEY `user_id` (`user_id`) USING BTREE,
  CONSTRAINT `loginrecord_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户登录记录信息';

-- ----------------------------
-- Records of loginrecord
-- ----------------------------
INSERT INTO `loginrecord` VALUES ('1', '2017-09-13 16:41:56', null);
INSERT INTO `loginrecord` VALUES ('1', '2017-09-13 17:37:51', null);
INSERT INTO `loginrecord` VALUES ('1', '2017-09-13 17:40:38', null);
INSERT INTO `loginrecord` VALUES ('1', '2017-09-13 17:48:09', null);
INSERT INTO `loginrecord` VALUES ('1', '2017-09-13 17:49:56', null);
INSERT INTO `loginrecord` VALUES ('1', '2017-09-13 17:50:21', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-13 17:55:14', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-13 18:02:02', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 09:01:17', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 09:05:18', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 09:06:09', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 09:06:41', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 09:07:02', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 09:09:18', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 09:09:20', null);
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 09:10:05', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 09:10:07', null);
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 09:13:51', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 09:15:31', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 09:16:48', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 09:19:43', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 09:19:44', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 09:19:44', null);
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 09:20:11', null);
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 09:21:04', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 09:21:23', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 09:22:33', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 09:23:05', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 09:25:17', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 09:29:29', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 09:57:01', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 09:58:20', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 10:00:07', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 10:04:53', null);
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 10:12:35', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 10:19:20', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 10:19:39', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 10:20:02', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 10:21:33', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 10:21:42', null);
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 10:24:12', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 10:28:03', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 10:31:13', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 10:31:27', null);
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 10:32:26', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 10:32:59', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 10:49:37', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 11:06:26', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 11:07:04', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 11:42:56', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 11:49:28', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 11:49:32', null);
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 11:49:34', null);
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 11:49:45', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 11:50:00', null);
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 11:50:35', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 11:53:20', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 11:55:30', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 11:55:50', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 11:55:53', null);
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 11:56:25', null);
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 11:56:31', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 11:56:53', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 11:58:03', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 12:00:21', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 12:02:15', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 12:03:31', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 12:04:46', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 12:05:08', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 12:07:29', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 12:08:07', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 12:08:27', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 12:37:29', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 13:11:44', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 13:20:10', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 13:21:26', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 13:22:17', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 13:22:26', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 13:22:41', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 14:11:38', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 14:55:13', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 14:59:34', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 15:01:12', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 15:01:57', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 15:08:09', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 16:15:06', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 16:26:53', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-14 16:56:01', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-15 09:27:44', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-15 10:10:55', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-15 10:14:07', '中国广东省广州市');
INSERT INTO `loginrecord` VALUES ('1', '2017-09-15 11:10:11', '中国广东省广州市');

-- ----------------------------
-- Table structure for `right_info`
-- ----------------------------
DROP TABLE IF EXISTS `right_info`;
CREATE TABLE `right_info` (
  `right_code` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单编码(主键)',
  `right_parent_code` bigint(20) DEFAULT NULL COMMENT '父菜单编码',
  `right_type` varchar(20) DEFAULT NULL COMMENT '菜单类型',
  `right_text` varchar(50) DEFAULT NULL COMMENT '菜单文本',
  `right_url` varchar(100) DEFAULT NULL COMMENT '菜单访问路径',
  `right_tip` varchar(50) DEFAULT NULL COMMENT '菜单提示',
  `ispatent` int(1) DEFAULT '0' COMMENT '是否含有子菜单0表示没有1表示有',
  PRIMARY KEY (`right_code`),
  KEY `right_parent_code` (`right_parent_code`),
  CONSTRAINT `right_info_ibfk_1` FOREIGN KEY (`right_parent_code`) REFERENCES `right_info` (`right_code`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='菜单表：营销管理、客户管理、服务管理、统计报表、基础数据和权限管理六个模块；';

-- ----------------------------
-- Records of right_info
-- ----------------------------
INSERT INTO `right_info` VALUES ('1', null, '1', '系统管理', null, null, '0');
INSERT INTO `right_info` VALUES ('2', null, '1', '营销管理', null, null, '0');
INSERT INTO `right_info` VALUES ('3', null, '1', '客户管理', null, null, '0');
INSERT INTO `right_info` VALUES ('4', null, '1', '服务管理', null, null, '0');
INSERT INTO `right_info` VALUES ('5', null, '1', '统计报表', null, null, '0');
INSERT INTO `right_info` VALUES ('6', null, '1', '基本数据', null, null, '0');
INSERT INTO `right_info` VALUES ('7', null, '1', '权限管理', null, null, '1');
INSERT INTO `right_info` VALUES ('8', '7', '2', '用户管理', null, null, '0');

-- ----------------------------
-- Table structure for `role_info`
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL COMMENT '角色名称',
  `role_desc` varchar(50) DEFAULT NULL COMMENT '角色描述',
  `role_flag` int(11) DEFAULT NULL COMMENT '角色状态（1或0，1表示可用）',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='角色表：系统管理员、销售主管、客户经理和高管；';

-- ----------------------------
-- Records of role_info
-- ----------------------------
INSERT INTO `role_info` VALUES ('1', 'Admin', '系统管理员', '1');
INSERT INTO `role_info` VALUES ('2', 'SalesExecutive', '销售主管', '1');
INSERT INTO `role_info` VALUES ('3', 'AccountManager', '客户经理', '1');
INSERT INTO `role_info` VALUES ('4', 'HRManager', '人事主管', '1');

-- ----------------------------
-- Table structure for `role_right_info`
-- ----------------------------
DROP TABLE IF EXISTS `role_right_info`;
CREATE TABLE `role_right_info` (
  `rf_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rf_role_id` bigint(20) NOT NULL COMMENT '角色编号（外键role表role_id）',
  `rf_right_code` bigint(20) NOT NULL,
  PRIMARY KEY (`rf_id`),
  KEY `rf_role_id` (`rf_role_id`),
  KEY `rf_right_code` (`rf_right_code`),
  CONSTRAINT `rf_right_code` FOREIGN KEY (`rf_right_code`) REFERENCES `right_info` (`right_code`),
  CONSTRAINT `rf_role_id` FOREIGN KEY (`rf_role_id`) REFERENCES `role_info` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='权限表：角色对应菜单';

-- ----------------------------
-- Records of role_right_info
-- ----------------------------
INSERT INTO `role_right_info` VALUES ('1', '1', '1');
INSERT INTO `role_right_info` VALUES ('2', '1', '2');
INSERT INTO `role_right_info` VALUES ('3', '1', '3');
INSERT INTO `role_right_info` VALUES ('4', '1', '4');
INSERT INTO `role_right_info` VALUES ('5', '1', '5');
INSERT INTO `role_right_info` VALUES ('6', '1', '6');
INSERT INTO `role_right_info` VALUES ('7', '1', '7');

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标示',
  `username` varchar(8) DEFAULT NULL COMMENT '用户登陆名',
  `password` varchar(32) DEFAULT NULL COMMENT '登陆密码',
  `name` varchar(8) DEFAULT NULL COMMENT '名字',
  `himg` varchar(254) DEFAULT NULL COMMENT '用户头像',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_info_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role_info` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '管理员', null, '1');
INSERT INTO `user_info` VALUES ('2', 'a123', 'e10adc3949ba59abbe56e057f20f883e', 'Monmy', null, '2');
