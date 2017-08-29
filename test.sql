/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.3_3306
Source Server Version : 50130
Source Host           : 192.168.1.3:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50130
File Encoding         : 65001

Date: 2017-08-29 14:52:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `right_info`
-- ----------------------------
DROP TABLE IF EXISTS `right_info`;
CREATE TABLE `right_info` (
  `right_code` bigint(20) NOT NULL COMMENT '菜单编码(主键)',
  `right_parent_code` bigint(20) DEFAULT NULL COMMENT '父菜单编码',
  `right_type` varchar(20) DEFAULT NULL COMMENT '菜单类型',
  `right_text` varchar(50) DEFAULT NULL COMMENT '菜单文本',
  `right_url` varchar(100) DEFAULT NULL COMMENT '菜单访问路径',
  `right_tip` varchar(50) DEFAULT NULL COMMENT '菜单提示',
  PRIMARY KEY (`right_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表：营销管理、客户管理、服务管理、统计报表、基础数据和权限管理六个模块；';

-- ----------------------------
-- Records of right_info
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表：系统管理员、销售主管、客户经理和高管；';

-- ----------------------------
-- Records of role_info
-- ----------------------------

-- ----------------------------
-- Table structure for `role_right_info`
-- ----------------------------
DROP TABLE IF EXISTS `role_right_info`;
CREATE TABLE `role_right_info` (
  `rf_id` bigint(20) NOT NULL,
  `rf_role_id` bigint(20) NOT NULL COMMENT '角色编号（外键role表role_id）',
  `rf_right_code` bigint(20) NOT NULL,
  PRIMARY KEY (`rf_id`),
  KEY `rf_role_id` (`rf_role_id`),
  KEY `rf_right_code` (`rf_right_code`),
  CONSTRAINT `rf_right_code` FOREIGN KEY (`rf_right_code`) REFERENCES `right_info` (`right_code`),
  CONSTRAINT `rf_role_id` FOREIGN KEY (`rf_role_id`) REFERENCES `role_info` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表：角色对应菜单';

-- ----------------------------
-- Records of role_right_info
-- ----------------------------

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标示',
  `username` varchar(8) DEFAULT NULL COMMENT '用户登陆名',
  `password` varchar(16) DEFAULT NULL COMMENT '登陆密码',
  `name` varchar(8) DEFAULT NULL COMMENT '名字',
  `himg` varchar(254) DEFAULT NULL COMMENT '用户头像',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_info_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role_info` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'admin', '123456', '管理员', null, null);
