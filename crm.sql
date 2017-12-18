/*
Navicat MySQL Data Transfer

Source Server         : 47.95.253.137_8088
Source Server Version : 50022
Source Host           : 47.95.253.137:8088
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2017-12-18 14:51:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `clien_info`
-- ----------------------------
DROP TABLE IF EXISTS `clien_info`;
CREATE TABLE `clien_info` (
  `id` bigint(11) NOT NULL auto_increment,
  `name` varchar(10) default NULL COMMENT '客户名',
  `phone` bigint(11) default NULL COMMENT '客户联系电话',
  `address` varchar(250) default NULL,
  `wechat` varchar(255) default NULL COMMENT '微信号',
  `qq` bigint(11) default NULL COMMENT 'qq',
  `status` varchar(10) default NULL COMMENT '客户状态：1潜在用户2意向用户3成交用户4无效用户',
  `create_time` timestamp NULL default CURRENT_TIMESTAMP COMMENT '创建时间',
  `customer_type` varchar(255) default NULL COMMENT '客户种类：1潜在用户2普通用户3vip客户4代理商5合作伙伴',
  `email` varchar(255) default NULL,
  `company` varchar(255) default NULL COMMENT '公司',
  `department` varchar(255) default NULL COMMENT '部门',
  `source` varchar(255) default NULL COMMENT '来源：电话来访；客户介绍；媒体宣传；促销活动；老客户；代理商；合作伙伴；公开招标；互联网；其它',
  `scale_of_company` varchar(255) default NULL COMMENT '公司规模：10人以内；10-20人；20-50人；50-200人；200人以上',
  `returnvisit_time` datetime default NULL COMMENT '下次回访时间',
  `remark` varchar(255) default NULL COMMENT '备注',
  `uid` bigint(20) default NULL,
  PRIMARY KEY  (`id`),
  KEY `uid` (`uid`),
  CONSTRAINT `clien_info_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user_info` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户表';

-- ----------------------------
-- Records of clien_info
-- ----------------------------
INSERT INTO `clien_info` VALUES ('2', '罗志祥', '11344522052', '上海', 'luozhixiang', '4657651234', '意向客户', '2017-12-12 00:00:00', '潜在客户', '32654321@qq.com', '上海甲骨文有限公司', '宣传部', '媒体宣传', '200人以上', '2018-04-20 00:00:00', '字字字字字字字字字字字字字字字字字字字字字字字字字字字字随便给点备注，我是罗志祥！假的字字字字', '1');
INSERT INTO `clien_info` VALUES ('3', '金科', '1800000000', '', '', null, '意向客户', '2017-11-27 16:04:27', '潜在客户', '', '', null, '电话来访', '', '2018-02-17 16:07:50', '', '3');
INSERT INTO `clien_info` VALUES ('4', '银科', '18000000000', '', '', null, '潜在客户', '2017-11-30 16:04:55', '潜在客户', '', '', null, '促销活动', '', '2018-02-19 16:07:43', '', '1');
INSERT INTO `clien_info` VALUES ('5', '马云', '13465258558', '', '', null, '成交客户', '2017-11-27 16:04:52', 'VIP客户', '', '', null, '互联网', '', '2018-03-16 16:07:38', '', '2');
INSERT INTO `clien_info` VALUES ('1000', '张某', '12345678912', '广州天河区玫瑰花园250号', 'luods13', '1347874521', '潜在客户', '2017-12-06 00:00:00', '潜在客户', '1345@qq.com', null, null, '电话来访', null, '2018-02-22 00:00:00', '给点备注咯...', '2');
INSERT INTO `clien_info` VALUES ('1001', '李小龙', '1325776555', '', '', null, '潜在客户', '2017-01-19 16:04:59', '潜在客户', '', '', null, '电话来访', '', '2017-12-01 00:00:00', '', '1');
INSERT INTO `clien_info` VALUES ('1002', '福隆盛', '132435412', '', '', null, '成交客户', '2017-12-12 16:06:51', 'VIP客户', '', '', null, '促销活动', '', '2018-12-21 16:07:27', '', '1');
INSERT INTO `clien_info` VALUES ('1003', '李小璐', '18000000000', '', '', null, '潜在客户', '2017-12-12 17:13:28', '潜在客户', '', '', null, '电话来访', '', null, '', '1');
INSERT INTO `clien_info` VALUES ('1004', '李四', '18235431123', '', '', null, '潜在客户', '2017-12-12 17:20:01', '潜在客户', '', '', null, '电话来访', '', null, '', '1');
INSERT INTO `clien_info` VALUES ('1005', '张全蛋', '15643531233', '', '', null, '意向客户', '2017-12-13 17:47:28', '普通客户', '', '', null, '媒体宣传', '', null, '', '1');
INSERT INTO `clien_info` VALUES ('1007', '李小龙', '15300000000', '', '', null, '成交客户', '2017-12-14 10:21:45', '普通客户', '', '', null, '老客户介绍', '', null, '', '1');
INSERT INTO `clien_info` VALUES ('1008', '周杰伦', '1655461332', '', '', null, '成交客户', '2017-12-14 10:22:24', 'VIP客户', '', '', null, '客户介绍', '', null, '', '1');
INSERT INTO `clien_info` VALUES ('1009', '苏志薪', '12356456412', '', '', null, '潜在客户', '2017-12-16 11:55:41', '潜在客户', '', '', null, '电话来访', '', null, '', '1');
INSERT INTO `clien_info` VALUES ('1010', '赵吴恩', '13254344522', '', '', null, '潜在客户', '2017-12-18 10:50:39', '潜在客户', '', '', null, '促销活动', '', null, '', '3');
INSERT INTO `clien_info` VALUES ('1011', '农裂', '13485984365', '', '', null, '成交客户', '2017-12-18 10:51:19', '代理商', '', '', null, '促销活动', '', null, '', '3');
INSERT INTO `clien_info` VALUES ('1012', '凯力', '18337354465', '', '', null, '潜在客户', '2017-12-18 10:51:55', '潜在客户', '', '', null, '电话来访', '', null, '', '3');
INSERT INTO `clien_info` VALUES ('1013', '陈信宏', '14538876352', '', '', null, '成交客户', '2017-12-18 11:06:58', 'VIP客户', '', '', null, '媒体宣传', '', null, '', '3');
INSERT INTO `clien_info` VALUES ('1014', '曾自强', '12345678978', '', '', null, '潜在客户', '2017-12-18 11:22:21', '潜在客户', '', '', null, '客户介绍', '', null, '', '3');
INSERT INTO `clien_info` VALUES ('1015', '罗大佑', '15234685321', '', '', null, '成交客户', '2017-12-18 11:40:01', '普通客户', '', '', null, '公开招标', '', null, '', '3');
INSERT INTO `clien_info` VALUES ('1016', '马里奥', '16354687656', '', '', null, '意向客户', '2017-12-18 11:41:28', '普通客户', '', '', null, '客户介绍', '', null, '', '3');

-- ----------------------------
-- Table structure for `department_info`
-- ----------------------------
DROP TABLE IF EXISTS `department_info`;
CREATE TABLE `department_info` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `pid` bigint(20) default NULL,
  PRIMARY KEY  (`id`),
  KEY `pid` (`pid`),
  CONSTRAINT `department_info_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `department_info` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表：经理-销售部-人事部';

-- ----------------------------
-- Records of department_info
-- ----------------------------
INSERT INTO `department_info` VALUES ('1', '经理', null);
INSERT INTO `department_info` VALUES ('2', '销售部', '1');
INSERT INTO `department_info` VALUES ('3', '人事部', '1');

-- ----------------------------
-- Table structure for `garbage_info`
-- ----------------------------
DROP TABLE IF EXISTS `garbage_info`;
CREATE TABLE `garbage_info` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(250) default NULL COMMENT '文件名称',
  `date` datetime default NULL COMMENT '文件生成时间日期',
  `path` varchar(250) default NULL COMMENT '文件所在路径',
  `u_id` bigint(20) default NULL COMMENT '文件生成者',
  `status` int(8) default NULL COMMENT '文件状态：1删除失败文件，2过期文件',
  `type` varchar(10) default NULL COMMENT '文件类型，保存文件的后缀',
  PRIMARY KEY  (`id`),
  KEY `u_id` (`u_id`),
  CONSTRAINT `garbage_info_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='垃圾文件信息';

-- ----------------------------
-- Records of garbage_info
-- ----------------------------

-- ----------------------------
-- Table structure for `loginrecord`
-- ----------------------------
DROP TABLE IF EXISTS `loginrecord`;
CREATE TABLE `loginrecord` (
  `id` bigint(20) NOT NULL auto_increment,
  `user_id` bigint(20) NOT NULL,
  `login_date` datetime default NULL,
  `login_site` varchar(120) default NULL,
  `login_ip` varchar(20) default NULL COMMENT 'ip地址',
  PRIMARY KEY  (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `loginrecord_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of loginrecord
-- ----------------------------
INSERT INTO `loginrecord` VALUES ('1', '1', '2017-09-13 16:41:56', null, null);
INSERT INTO `loginrecord` VALUES ('2', '1', '2017-09-13 17:37:51', null, null);
INSERT INTO `loginrecord` VALUES ('3', '1', '2017-09-13 17:40:38', null, null);
INSERT INTO `loginrecord` VALUES ('4', '1', '2017-09-13 17:48:09', null, null);
INSERT INTO `loginrecord` VALUES ('5', '1', '2017-09-13 17:49:56', null, null);
INSERT INTO `loginrecord` VALUES ('6', '1', '2017-09-13 17:50:21', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('7', '1', '2017-09-13 17:55:14', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('8', '1', '2017-09-13 18:02:02', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('9', '1', '2017-09-14 09:01:17', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('10', '1', '2017-09-14 09:05:18', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('11', '1', '2017-09-14 09:06:09', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('12', '1', '2017-09-14 09:06:41', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('13', '1', '2017-09-14 09:07:02', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('14', '1', '2017-09-14 09:09:18', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('15', '1', '2017-09-14 09:09:20', null, null);
INSERT INTO `loginrecord` VALUES ('16', '1', '2017-09-14 09:10:05', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('17', '1', '2017-09-14 09:10:07', null, null);
INSERT INTO `loginrecord` VALUES ('18', '1', '2017-09-14 09:13:51', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('19', '1', '2017-09-14 09:15:31', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('20', '1', '2017-09-14 09:16:48', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('21', '1', '2017-09-14 09:19:43', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('22', '1', '2017-09-14 09:19:44', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('23', '1', '2017-09-14 09:19:44', null, null);
INSERT INTO `loginrecord` VALUES ('24', '1', '2017-09-14 09:20:11', null, null);
INSERT INTO `loginrecord` VALUES ('25', '1', '2017-09-14 09:21:04', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('26', '1', '2017-09-14 09:21:23', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('27', '1', '2017-09-14 09:22:33', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('28', '1', '2017-09-14 09:23:05', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('29', '1', '2017-09-14 09:25:17', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('30', '1', '2017-09-14 09:29:29', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('31', '1', '2017-09-14 09:57:01', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('32', '1', '2017-09-14 09:58:20', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('33', '1', '2017-09-14 10:00:07', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('34', '1', '2017-09-14 10:04:53', null, null);
INSERT INTO `loginrecord` VALUES ('35', '1', '2017-09-14 10:12:35', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('36', '1', '2017-09-14 10:19:20', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('37', '1', '2017-09-14 10:19:39', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('38', '1', '2017-09-14 10:20:02', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('39', '1', '2017-09-14 10:21:33', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('40', '1', '2017-09-14 10:21:42', null, null);
INSERT INTO `loginrecord` VALUES ('41', '1', '2017-09-14 10:24:12', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('42', '1', '2017-09-14 10:28:03', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('43', '1', '2017-09-14 10:31:13', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('44', '1', '2017-09-14 10:31:27', null, null);
INSERT INTO `loginrecord` VALUES ('45', '1', '2017-09-14 10:32:26', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('46', '1', '2017-09-14 10:32:59', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('47', '1', '2017-09-14 10:49:37', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('48', '1', '2017-09-14 11:06:26', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('49', '1', '2017-09-14 11:07:04', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('50', '1', '2017-09-14 11:42:56', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('51', '1', '2017-09-14 11:49:28', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('52', '1', '2017-09-14 11:49:32', null, null);
INSERT INTO `loginrecord` VALUES ('53', '1', '2017-09-14 11:49:34', null, null);
INSERT INTO `loginrecord` VALUES ('54', '1', '2017-09-14 11:49:45', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('55', '1', '2017-09-14 11:50:00', null, null);
INSERT INTO `loginrecord` VALUES ('56', '1', '2017-09-14 11:50:35', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('57', '1', '2017-09-14 11:53:20', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('58', '1', '2017-09-14 11:55:30', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('59', '1', '2017-09-14 11:55:50', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('60', '1', '2017-09-14 11:55:53', null, null);
INSERT INTO `loginrecord` VALUES ('61', '1', '2017-09-14 11:56:25', null, null);
INSERT INTO `loginrecord` VALUES ('62', '1', '2017-09-14 11:56:31', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('63', '1', '2017-09-14 11:56:53', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('64', '1', '2017-09-14 11:58:03', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('65', '1', '2017-09-14 12:00:21', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('66', '1', '2017-09-14 12:02:15', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('67', '1', '2017-09-14 12:03:31', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('68', '1', '2017-09-14 12:04:46', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('69', '1', '2017-09-14 12:05:08', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('70', '1', '2017-09-14 12:07:29', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('71', '1', '2017-09-14 12:08:07', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('72', '1', '2017-09-14 12:08:27', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('73', '1', '2017-09-14 12:37:29', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('74', '1', '2017-09-14 13:11:44', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('75', '1', '2017-09-14 13:20:10', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('76', '1', '2017-09-14 13:21:26', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('77', '1', '2017-09-14 13:22:17', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('78', '1', '2017-09-14 13:22:26', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('79', '1', '2017-09-14 13:22:41', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('80', '1', '2017-09-14 14:11:38', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('81', '1', '2017-09-14 14:55:13', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('82', '1', '2017-09-14 14:59:34', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('83', '1', '2017-09-14 15:01:12', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('84', '1', '2017-09-14 15:01:57', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('85', '1', '2017-09-14 15:08:09', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('86', '1', '2017-09-14 16:15:06', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('87', '1', '2017-09-14 16:26:53', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('88', '1', '2017-09-14 16:56:01', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('89', '1', '2017-09-15 09:27:44', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('90', '1', '2017-09-15 10:10:55', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('91', '1', '2017-09-15 10:14:07', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('92', '1', '2017-09-15 11:10:11', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('93', '1', '2017-09-17 16:15:27', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('94', '1', '2017-09-17 16:22:12', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('95', '1', '2017-09-17 16:29:35', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('96', '1', '2017-09-17 16:36:06', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('97', '1', '2017-09-17 16:38:16', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('98', '1', '2017-09-17 16:41:15', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('99', '1', '2017-09-17 16:41:20', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('100', '1', '2017-09-17 16:44:07', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('101', '1', '2017-09-17 16:45:56', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('102', '1', '2017-09-17 16:55:53', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('103', '1', '2017-09-17 16:59:27', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('104', '1', '2017-09-17 17:10:26', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('105', '1', '2017-09-17 17:10:45', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('106', '1', '2017-09-19 22:33:57', null, null);
INSERT INTO `loginrecord` VALUES ('107', '1', '2017-09-19 22:34:38', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('108', '1', '2017-09-19 22:36:22', '广东省广州市番禺区南塘大街1号', null);
INSERT INTO `loginrecord` VALUES ('109', '1', '2017-09-19 23:15:28', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('110', '1', '2017-09-21 09:34:48', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('111', '1', '2017-09-21 10:39:24', '中国北京市北京市', null);
INSERT INTO `loginrecord` VALUES ('112', '1', '2017-09-21 10:44:00', '中国北京市北京市', null);
INSERT INTO `loginrecord` VALUES ('113', '1', '2017-09-21 11:37:08', '中国北京市北京市', null);
INSERT INTO `loginrecord` VALUES ('114', '1', '2017-09-23 16:29:16', '中国北京市北京市', null);
INSERT INTO `loginrecord` VALUES ('115', '1', '2017-09-24 09:49:22', '广东省广州市番禺区育英东路', null);
INSERT INTO `loginrecord` VALUES ('116', '1', '2017-09-26 16:08:23', '广东省广州市天河区纺联西一路', null);
INSERT INTO `loginrecord` VALUES ('117', '1', '2017-09-26 16:18:51', '广东省广州市海珠区前进路40号-2层', null);
INSERT INTO `loginrecord` VALUES ('118', '1', '2017-09-26 16:43:33', '广东省广州市天河区纺联西一路', null);
INSERT INTO `loginrecord` VALUES ('119', '1', '2017-09-26 17:13:30', '广东省广州市天河区纺联西一路', null);
INSERT INTO `loginrecord` VALUES ('120', '1', '2017-09-27 09:15:30', '广东省广州市天河区纺联西一路', null);
INSERT INTO `loginrecord` VALUES ('121', '1', '2017-09-29 16:29:57', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('122', '1', '2017-09-30 09:21:22', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('123', '1', '2017-09-30 12:40:29', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('124', '1', '2017-09-30 17:00:49', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('125', '1', '2017-10-01 12:34:19', '广东省广州市番禺区大石大桥', null);
INSERT INTO `loginrecord` VALUES ('126', '1', '2017-10-10 15:35:45', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('127', '1', '2017-10-10 17:51:19', '广东省广州市海珠区前进路40-3', null);
INSERT INTO `loginrecord` VALUES ('128', '1', '2017-10-11 09:46:54', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('129', '1', '2017-10-11 10:05:14', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('130', '1', '2017-10-11 10:08:58', null, null);
INSERT INTO `loginrecord` VALUES ('131', '1', '2017-10-11 10:40:59', null, null);
INSERT INTO `loginrecord` VALUES ('132', '1', '2017-10-11 11:11:37', '广东省广州市海珠区前进路40-3', null);
INSERT INTO `loginrecord` VALUES ('133', '1', '2017-10-11 14:44:43', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('134', '1', '2017-10-11 14:46:58', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('135', '1', '2017-10-11 17:05:08', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('136', '1', '2017-10-12 09:52:38', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('137', '1', '2017-10-12 10:20:30', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('138', '1', '2017-10-12 10:31:24', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('139', '1', '2017-10-12 15:12:20', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('140', '1', '2017-10-12 17:13:33', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('141', '1', '2017-10-12 22:17:12', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('142', '1', '2017-10-13 09:25:20', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('143', '1', '2017-10-13 14:37:41', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('144', '1', '2017-10-13 16:20:37', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('145', '1', '2017-10-17 10:47:51', '中国广东省', null);
INSERT INTO `loginrecord` VALUES ('146', '1', '2017-10-24 09:11:39', '中国广东省', null);
INSERT INTO `loginrecord` VALUES ('147', '1', '2017-10-24 12:01:12', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('148', '1', '2017-10-24 15:04:54', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('149', '1', '2017-10-25 11:05:27', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('150', '1', '2017-10-25 11:26:36', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('151', '1', '2017-10-25 17:17:29', '中国北京市北京市', null);
INSERT INTO `loginrecord` VALUES ('152', '1', '2017-10-26 09:58:00', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('153', '1', '2017-10-26 10:48:45', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('154', '1', '2017-10-26 11:01:27', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('155', '1', '2017-10-26 15:06:52', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('156', '1', '2017-10-26 16:09:27', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('157', '1', '2017-10-26 17:23:07', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('158', '1', '2017-10-26 17:58:38', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('159', '1', '2017-10-27 09:18:00', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('160', '1', '2017-10-27 15:35:30', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('161', '1', '2017-10-27 16:30:10', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('162', '1', '2017-10-27 20:10:43', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('163', '1', '2017-10-27 20:24:39', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('164', '1', '2017-10-28 00:00:16', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('165', '1', '2017-10-28 01:24:32', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('166', '1', '2017-10-28 12:17:47', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('167', '1', '2017-10-31 11:34:06', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('168', '1', '2017-10-31 12:46:13', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('169', '1', '2017-10-31 14:55:52', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('170', '1', '2017-10-31 15:16:27', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('171', '1', '2017-10-31 15:49:29', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('172', '1', '2017-10-31 15:59:12', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('173', '1', '2017-10-31 16:04:09', '中国广东省', null);
INSERT INTO `loginrecord` VALUES ('174', '1', '2017-10-31 16:07:54', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('175', '1', '2017-10-31 16:16:08', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('176', '1', '2017-10-31 16:25:34', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('177', '1', '2017-10-31 16:29:27', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('178', '1', '2017-10-31 16:33:57', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('179', '1', '2017-10-31 16:41:22', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('180', '1', '2017-10-31 18:04:59', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('181', '1', '2017-11-01 08:54:43', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('182', '1', '2017-11-01 10:02:04', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('183', '1', '2017-11-01 10:29:42', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('184', '1', '2017-11-01 11:55:28', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('185', '1', '2017-11-01 17:58:36', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('186', '1', '2017-11-01 23:01:07', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('187', '1', '2017-11-01 23:31:02', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('188', '1', '2017-11-02 11:45:34', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('189', '1', '2017-11-02 11:56:11', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('190', '1', '2017-11-02 12:49:19', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('191', '1', '2017-11-02 15:30:31', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('192', '1', '2017-11-02 15:32:55', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('193', '1', '2017-11-02 09:26:45', '内网IP内网IP内网IP', null);
INSERT INTO `loginrecord` VALUES ('194', '1', '2017-11-02 17:36:34', '广东省广州市海珠区前进路40号-2层', null);
INSERT INTO `loginrecord` VALUES ('195', '1', '2017-11-02 17:42:14', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('196', '1', '2017-11-02 17:44:28', '广东省广州市海珠区前进路40号-2层', null);
INSERT INTO `loginrecord` VALUES ('197', '1', '2017-11-02 17:46:38', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('198', '1', '2017-11-02 22:27:24', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('199', '1', '2017-11-02 23:29:56', '广东省广州市番禺区南塘大街1号', null);
INSERT INTO `loginrecord` VALUES ('200', '1', '2017-11-03 09:25:31', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('201', '1', '2017-11-03 09:30:01', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('202', '1', '2017-11-03 09:30:48', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('203', '1', '2017-11-03 09:34:07', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('204', '1', '2017-11-03 09:36:55', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('205', '1', '2017-11-03 03:23:20', '内网IP内网IP内网IP', null);
INSERT INTO `loginrecord` VALUES ('206', '1', '2017-11-03 12:44:29', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('207', '1', '2017-11-03 06:31:34', '内网IP内网IP内网IP', null);
INSERT INTO `loginrecord` VALUES ('208', '1', '2017-11-03 07:11:03', '内网IP内网IP内网IP', null);
INSERT INTO `loginrecord` VALUES ('209', '1', '2017-11-03 15:30:43', '广东省广州市海珠区前进路40号-2层', null);
INSERT INTO `loginrecord` VALUES ('210', '1', '2017-11-08 11:46:10', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('211', '1', '2017-11-08 11:46:38', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('212', '1', '2017-11-08 11:47:50', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('213', '1', '2017-11-08 15:32:03', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('214', '1', '2017-11-08 17:07:46', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('215', '1', '2017-11-09 15:36:35', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('216', '1', '2017-11-09 15:49:47', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('217', '1', '2017-11-09 15:51:21', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('218', '1', '2017-11-13 17:36:46', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('219', '1', '2017-11-14 11:22:03', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('220', '1', '2017-11-16 11:14:25', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('221', '1', '2017-11-16 11:22:45', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('222', '2', '2017-11-16 15:32:51', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('223', '1', '2017-11-16 15:43:04', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('224', '1', '2017-11-16 15:43:21', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('225', '1', '2017-11-16 15:47:46', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('226', '1', '2017-11-16 15:55:13', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('227', '1', '2017-11-16 16:00:19', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('228', '1', '2017-11-16 16:06:57', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('229', '1', '2017-11-16 16:52:26', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('230', '1', '2017-11-16 16:58:50', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('231', '1', '2017-11-16 17:01:50', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('232', '1', '2017-11-16 17:45:40', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('233', '2', '2017-11-16 17:45:54', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('234', '1', '2017-11-16 17:52:11', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('235', '1', '2017-11-16 17:53:20', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('236', '1', '2017-11-16 17:55:04', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('237', '1', '2017-11-17 09:32:08', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('238', '1', '2017-11-17 15:08:20', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('239', '1', '2017-11-17 15:44:19', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('240', '1', '2017-11-17 15:46:20', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('241', '1', '2017-11-17 16:26:43', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('242', '1', '2017-11-17 16:29:12', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('243', '1', '2017-11-17 16:32:44', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('244', '1', '2017-11-17 16:37:05', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('245', '1', '2017-11-17 16:45:09', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('246', '1', '2017-11-17 16:51:29', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('247', '1', '2017-11-17 16:56:50', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('248', '1', '2017-11-17 16:58:58', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('249', '1', '2017-11-17 17:03:04', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('250', '1', '2017-11-17 17:06:07', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('251', '1', '2017-11-17 17:08:38', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('252', '1', '2017-11-17 17:08:38', null, null);
INSERT INTO `loginrecord` VALUES ('253', '1', '2017-11-17 17:12:48', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('254', '1', '2017-11-17 17:16:13', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('255', '1', '2017-11-17 18:07:08', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('256', '1', '2017-11-17 18:07:42', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('257', '1', '2017-11-17 18:09:51', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('258', '1', '2017-11-17 21:09:42', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('259', '1', '2017-11-17 21:11:29', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('260', '1', '2017-11-17 21:21:01', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('261', '1', '2017-11-17 21:43:02', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('262', '1', '2017-11-18 09:59:05', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('263', '1', '2017-11-18 10:24:14', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('264', '1', '2017-11-18 10:25:59', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('265', '1', '2017-11-18 10:30:03', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('266', '1', '2017-11-18 10:34:06', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('267', '1', '2017-11-18 10:38:09', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('268', '1', '2017-11-18 10:42:23', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('269', '1', '2017-11-18 10:43:43', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('270', '1', '2017-11-18 11:17:58', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('271', '1', '2017-11-18 11:20:22', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('272', '1', '2017-11-18 11:38:25', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('273', '1', '2017-11-18 11:42:13', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('274', '1', '2017-11-18 11:46:23', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('275', '1', '2017-11-18 12:06:14', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('276', '1', '2017-11-18 12:07:38', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('277', '1', '2017-11-18 12:09:01', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('278', '1', '2017-11-18 12:11:20', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('279', '1', '2017-11-18 12:21:09', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('280', '1', '2017-11-18 12:23:59', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('281', '1', '2017-11-18 12:25:36', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('282', '1', '2017-11-18 13:06:29', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('283', '1', '2017-11-18 13:09:10', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('284', '1', '2017-11-18 13:13:38', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('285', '1', '2017-11-18 13:15:19', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('286', '1', '2017-11-18 13:19:33', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('287', '1', '2017-11-18 13:23:27', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('288', '1', '2017-11-18 13:29:16', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('289', '1', '2017-11-18 13:30:53', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('290', '1', '2017-11-18 13:31:59', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('291', '1', '2017-11-18 13:33:55', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('292', '1', '2017-11-18 13:33:55', null, null);
INSERT INTO `loginrecord` VALUES ('293', '1', '2017-11-18 13:34:01', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('294', '1', '2017-11-18 13:38:19', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('295', '1', '2017-11-18 13:41:32', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('296', '1', '2017-11-18 15:24:44', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('297', '1', '2017-11-18 16:16:40', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('298', '1', '2017-11-18 17:03:15', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('299', '1', '2017-11-18 17:07:33', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('300', '1', '2017-11-18 21:20:53', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('301', '1', '2017-11-18 21:35:43', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('302', '1', '2017-11-18 22:11:27', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('303', '1', '2017-11-18 23:03:57', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('304', '1', '2017-11-18 23:05:22', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('305', '1', '2017-11-18 23:08:43', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('306', '1', '2017-11-18 23:11:03', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('307', '1', '2017-11-18 23:12:20', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('308', '1', '2017-11-18 23:24:11', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('309', '1', '2017-11-18 23:26:59', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('310', '1', '2017-11-18 23:29:13', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('311', '1', '2017-11-18 23:36:39', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('312', '1', '2017-11-18 23:53:16', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('313', '1', '2017-11-18 23:54:54', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('314', '1', '2017-11-19 00:00:16', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('315', '1', '2017-11-19 00:05:38', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('316', '1', '2017-11-19 00:11:06', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('317', '1', '2017-11-19 13:31:57', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('318', '1', '2017-11-19 14:33:08', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('319', '1', '2017-11-19 16:51:10', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('320', '1', '2017-11-19 16:54:35', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('321', '1', '2017-11-19 16:56:36', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('322', '1', '2017-11-19 16:58:02', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('323', '1', '2017-11-19 17:03:05', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('324', '1', '2017-11-19 17:07:57', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('325', '1', '2017-11-19 17:10:38', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('326', '1', '2017-11-19 17:14:44', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('327', '1', '2017-11-19 17:35:10', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('328', '1', '2017-11-19 17:46:07', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('329', '1', '2017-11-19 17:47:46', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('330', '1', '2017-11-19 18:04:56', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('331', '1', '2017-11-19 18:30:50', '广东省广州市番禺区南塘大街1号', null);
INSERT INTO `loginrecord` VALUES ('332', '1', '2017-11-19 20:11:59', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('333', '1', '2017-11-19 20:31:25', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('334', '1', '2017-11-19 22:03:38', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('335', '1', '2017-11-19 22:04:52', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('336', '1', '2017-11-19 22:09:40', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('337', '1', '2017-11-19 22:54:58', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('338', '1', '2017-11-19 22:56:25', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('339', '1', '2017-11-19 23:06:28', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('340', '1', '2017-11-19 23:07:50', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('341', '1', '2017-11-19 23:12:55', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('342', '1', '2017-11-19 23:15:36', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('343', '1', '2017-11-19 23:16:02', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('344', '1', '2017-11-19 23:16:02', null, null);
INSERT INTO `loginrecord` VALUES ('345', '1', '2017-11-19 23:21:29', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('346', '1', '2017-11-19 23:32:25', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('347', '1', '2017-11-19 23:54:23', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('348', '1', '2017-11-20 00:15:24', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('349', '1', '2017-11-20 08:47:17', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('350', '1', '2017-11-20 09:03:44', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('351', '1', '2017-11-20 09:06:20', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('352', '1', '2017-11-20 09:07:26', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('353', '1', '2017-11-20 09:09:50', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('354', '1', '2017-11-20 09:14:41', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('355', '1', '2017-11-20 09:24:07', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('356', '1', '2017-11-20 09:32:53', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('357', '1', '2017-11-20 09:49:26', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('358', '1', '2017-11-20 10:05:02', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('359', '1', '2017-11-20 10:09:19', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('360', '1', '2017-11-20 10:11:41', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('361', '1', '2017-11-20 10:14:47', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('362', '1', '2017-11-20 10:18:19', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('363', '1', '2017-11-20 10:24:51', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('364', '1', '2017-11-20 10:39:59', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('365', '1', '2017-11-20 11:39:04', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('366', '1', '2017-11-20 11:40:00', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('367', '1', '2017-11-20 11:44:40', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('368', '1', '2017-11-20 11:47:58', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('369', '1', '2017-11-20 14:09:19', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('370', '1', '2017-11-20 14:17:17', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('371', '1', '2017-11-20 14:52:50', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('372', '1', '2017-11-20 14:54:44', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('373', '1', '2017-11-20 15:07:52', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('374', '1', '2017-11-20 15:09:50', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('375', '1', '2017-11-20 15:11:12', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('376', '1', '2017-11-20 15:13:48', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('377', '1', '2017-11-20 15:16:52', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('378', '1', '2017-11-20 15:19:56', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('379', '1', '2017-11-20 15:23:22', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('380', '1', '2017-11-20 15:28:35', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('381', '1', '2017-11-20 17:05:08', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('382', '1', '2017-11-20 17:15:04', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('383', '1', '2017-11-20 17:16:37', '广东省广州市海珠区前进路40-3', null);
INSERT INTO `loginrecord` VALUES ('384', '1', '2017-11-20 20:06:04', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('385', '1', '2017-11-20 20:13:00', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('386', '1', '2017-11-21 08:55:54', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('387', '1', '2017-11-21 10:38:56', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('388', '1', '2017-11-21 11:16:04', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('389', '1', '2017-11-21 11:19:44', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('390', '1', '2017-11-21 11:20:54', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('391', '1', '2017-11-21 11:33:24', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('392', '1', '2017-11-21 11:35:52', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('393', '1', '2017-11-21 11:38:48', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('394', '1', '2017-11-21 11:42:11', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('395', '1', '2017-11-21 11:45:49', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('396', '1', '2017-11-21 11:51:13', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('397', '1', '2017-11-21 13:51:54', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('398', '1', '2017-11-21 14:45:18', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('399', '1', '2017-11-21 14:46:35', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('400', '1', '2017-11-21 14:51:09', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('401', '1', '2017-11-21 14:53:09', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('402', '1', '2017-11-21 14:56:27', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('403', '1', '2017-11-21 14:57:41', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('404', '1', '2017-11-21 14:59:27', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('405', '1', '2017-11-21 15:01:00', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('406', '1', '2017-11-21 15:03:42', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('407', '1', '2017-11-21 15:08:04', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('408', '1', '2017-11-21 15:09:40', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('409', '1', '2017-11-21 15:35:33', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('410', '1', '2017-11-21 15:37:51', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('411', '1', '2017-11-21 15:41:16', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('412', '1', '2017-11-21 17:06:32', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('413', '1', '2017-11-21 17:32:40', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('414', '1', '2017-11-21 17:33:26', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('415', '1', '2017-11-21 17:36:11', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('416', '1', '2017-11-21 17:38:09', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('417', '1', '2017-11-21 17:39:31', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('418', '1', '2017-11-21 17:41:59', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('419', '1', '2017-11-21 17:44:52', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('420', '1', '2017-11-21 17:46:44', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('421', '1', '2017-11-21 17:47:30', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('422', '1', '2017-11-21 17:49:25', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('423', '1', '2017-11-21 20:41:51', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('424', '1', '2017-11-21 20:59:16', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('425', '1', '2017-11-21 20:59:57', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('426', '1', '2017-11-21 21:34:16', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('427', '1', '2017-11-21 23:58:09', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('428', '1', '2017-11-22 09:16:13', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('429', '1', '2017-11-22 09:29:07', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('430', '1', '2017-11-22 10:30:26', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('431', '1', '2017-11-22 11:17:48', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('432', '1', '2017-11-22 11:38:07', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('433', '1', '2017-11-22 11:44:10', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('434', '1', '2017-11-22 11:45:52', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('435', '1', '2017-11-22 11:48:48', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('436', '1', '2017-11-22 12:00:43', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('437', '1', '2017-11-22 12:02:56', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('438', '1', '2017-11-22 14:23:41', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('439', '1', '2017-11-22 14:35:11', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('440', '1', '2017-11-22 14:46:40', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('441', '2', '2017-11-22 14:55:40', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('442', '1', '2017-11-22 14:56:03', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('443', '1', '2017-11-22 15:37:51', null, null);
INSERT INTO `loginrecord` VALUES ('444', '1', '2017-11-22 15:47:45', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('445', '1', '2017-11-22 15:47:45', null, null);
INSERT INTO `loginrecord` VALUES ('446', '1', '2017-11-22 16:18:36', null, null);
INSERT INTO `loginrecord` VALUES ('447', '1', '2017-11-22 16:20:46', null, null);
INSERT INTO `loginrecord` VALUES ('448', '1', '2017-11-22 16:22:21', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('449', '1', '2017-11-22 16:25:27', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('450', '1', '2017-11-22 16:35:22', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('451', '1', '2017-11-22 16:50:01', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('452', '1', '2017-11-22 16:52:29', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('453', '1', '2017-11-22 16:58:06', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('454', '1', '2017-11-22 17:09:44', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('455', '1', '2017-11-22 17:28:16', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('456', '1', '2017-11-22 17:30:06', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('457', '1', '2017-11-22 17:48:17', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('458', '1', '2017-11-22 17:56:32', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('459', '1', '2017-11-22 20:01:22', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('460', '1', '2017-11-23 08:54:22', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('461', '1', '2017-11-23 09:30:57', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('462', '1', '2017-11-23 09:34:04', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('463', '1', '2017-11-23 09:37:16', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('464', '1', '2017-11-23 09:43:43', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('465', '1', '2017-11-23 10:35:22', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('466', '1', '2017-11-23 13:52:51', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('467', '1', '2017-11-23 13:53:16', '广东省广州市海珠区前进路40-3', null);
INSERT INTO `loginrecord` VALUES ('468', '1', '2017-11-23 14:57:44', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('469', '1', '2017-11-23 14:59:01', '广东省广州市海珠区前进路40号-2层', null);
INSERT INTO `loginrecord` VALUES ('470', '1', '2017-11-23 15:24:39', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('471', '1', '2017-11-23 16:20:16', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('472', '1', '2017-11-23 17:21:46', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('473', '1', '2017-11-23 20:16:58', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('474', '1', '2017-11-23 20:27:38', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('475', '1', '2017-11-23 20:28:44', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('476', '1', '2017-11-23 20:30:56', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('477', '1', '2017-11-23 20:32:02', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('478', '1', '2017-11-23 20:35:30', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('479', '1', '2017-11-23 20:40:00', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('480', '1', '2017-11-23 20:45:07', null, null);
INSERT INTO `loginrecord` VALUES ('481', '1', '2017-11-23 21:08:23', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('482', '1', '2017-11-23 21:31:43', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('483', '1', '2017-11-23 21:34:49', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('484', '1', '2017-11-23 21:35:58', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('485', '1', '2017-11-23 21:41:32', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('486', '1', '2017-11-23 21:46:17', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('487', '1', '2017-11-23 21:58:14', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('488', '1', '2017-11-23 22:39:32', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('489', '1', '2017-11-24 09:01:40', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('490', '1', '2017-11-24 09:43:13', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('491', '3', '2017-11-24 09:43:19', null, null);
INSERT INTO `loginrecord` VALUES ('492', '3', '2017-11-24 09:45:18', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('493', '1', '2017-11-24 09:45:38', null, null);
INSERT INTO `loginrecord` VALUES ('494', '1', '2017-11-24 10:19:53', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('495', '1', '2017-11-24 13:40:37', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('496', '1', '2017-11-24 13:45:37', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('497', '1', '2017-11-24 13:46:32', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('498', '1', '2017-11-24 13:47:28', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('499', '1', '2017-11-24 13:50:59', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('500', '1', '2017-11-24 13:50:59', null, null);
INSERT INTO `loginrecord` VALUES ('501', '1', '2017-11-24 13:54:35', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('502', '1', '2017-11-24 13:54:36', null, null);
INSERT INTO `loginrecord` VALUES ('503', '1', '2017-11-24 13:57:54', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('504', '1', '2017-11-24 13:59:41', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('505', '1', '2017-11-24 15:12:43', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('506', '1', '2017-11-24 16:15:28', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('507', '1', '2017-11-24 17:12:43', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('508', '1', '2017-11-24 17:21:38', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('509', '1', '2017-11-24 17:29:14', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('510', '1', '2017-11-24 17:56:00', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('511', '1', '2017-11-25 11:48:27', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('512', '1', '2017-11-25 16:53:09', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('513', '1', '2017-11-26 10:41:31', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('514', '1', '2017-11-26 14:23:27', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('515', '1', '2017-11-26 15:47:12', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('516', '1', '2017-11-26 16:12:57', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('517', '1', '2017-11-26 16:14:21', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('518', '1', '2017-11-26 16:16:06', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('519', '1', '2017-11-26 16:17:17', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('520', '1', '2017-11-26 16:33:15', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('521', '1', '2017-11-26 16:35:52', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('522', '1', '2017-11-26 17:05:12', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('523', '1', '2017-11-26 17:06:40', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('524', '1', '2017-11-26 17:09:22', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('525', '1', '2017-11-26 17:59:00', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('526', '1', '2017-11-26 18:27:51', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('527', '1', '2017-11-26 18:30:00', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('528', '1', '2017-11-26 18:32:51', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('529', '1', '2017-11-26 18:34:25', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('530', '1', '2017-11-26 18:57:54', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('531', '1', '2017-11-26 18:57:55', null, null);
INSERT INTO `loginrecord` VALUES ('532', '1', '2017-11-26 19:06:29', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('533', '1', '2017-11-26 19:06:29', null, null);
INSERT INTO `loginrecord` VALUES ('534', '1', '2017-11-26 19:10:37', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('535', '1', '2017-11-27 09:01:56', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('536', '1', '2017-11-27 09:09:02', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('537', '1', '2017-11-27 09:09:02', null, null);
INSERT INTO `loginrecord` VALUES ('538', '1', '2017-11-27 09:12:50', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('539', '1', '2017-11-27 09:33:12', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('540', '1', '2017-11-27 09:38:43', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('541', '1', '2017-11-27 09:48:08', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('542', '1', '2017-11-27 09:59:47', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('543', '1', '2017-11-27 10:14:47', '0', null);
INSERT INTO `loginrecord` VALUES ('544', '1', '2017-11-27 10:59:05', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('545', '1', '2017-11-27 11:03:22', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('546', '1', '2017-11-27 11:09:19', null, null);
INSERT INTO `loginrecord` VALUES ('547', '1', '2017-11-27 11:17:53', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('548', '1', '2017-11-27 11:21:26', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('549', '1', '2017-11-27 11:33:21', null, null);
INSERT INTO `loginrecord` VALUES ('550', '1', '2017-11-27 11:33:21', null, null);
INSERT INTO `loginrecord` VALUES ('551', '1', '2017-11-27 11:33:30', null, null);
INSERT INTO `loginrecord` VALUES ('552', '1', '2017-11-27 12:32:52', null, null);
INSERT INTO `loginrecord` VALUES ('553', '1', '2017-11-27 13:08:28', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('554', '1', '2017-11-27 13:30:29', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('555', '1', '2017-11-27 13:35:21', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('556', '1', '2017-11-27 13:38:20', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('557', '1', '2017-11-27 13:42:35', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('558', '1', '2017-11-27 14:07:58', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('559', '1', '2017-11-27 14:19:06', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('560', '1', '2017-11-27 14:27:31', null, null);
INSERT INTO `loginrecord` VALUES ('561', '1', '2017-11-27 14:36:42', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('562', '1', '2017-11-27 14:40:53', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('563', '1', '2017-11-27 14:53:50', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('564', '1', '2017-11-27 15:29:11', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('565', '1', '2017-11-27 16:16:04', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('566', '1', '2017-11-27 16:27:29', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('567', '1', '2017-11-27 16:29:57', null, null);
INSERT INTO `loginrecord` VALUES ('568', '1', '2017-11-27 16:35:35', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('569', '1', '2017-11-27 16:35:42', null, null);
INSERT INTO `loginrecord` VALUES ('570', '1', '2017-11-27 16:42:48', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('571', '1', '2017-11-27 16:50:49', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('572', '1', '2017-11-27 17:03:21', null, null);
INSERT INTO `loginrecord` VALUES ('573', '1', '2017-11-27 17:24:22', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('574', '1', '2017-11-27 18:02:54', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('575', '1', '2017-11-27 20:44:08', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('576', '1', '2017-11-27 20:47:03', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('577', '1', '2017-11-27 21:23:50', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('578', '1', '2017-11-27 21:26:47', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('579', '1', '2017-11-28 10:27:48', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('580', '1', '2017-11-28 10:31:02', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('581', '1', '2017-11-28 10:32:50', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('582', '1', '2017-11-28 10:38:19', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('583', '1', '2017-11-28 10:39:12', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('584', '3', '2017-11-28 11:27:28', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('585', '1', '2017-11-28 11:29:38', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('586', '1', '2017-11-28 11:32:14', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('587', '1', '2017-11-28 11:36:16', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('588', '1', '2017-11-28 11:38:12', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('589', '3', '2017-11-28 11:39:42', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('590', '3', '2017-11-28 11:40:45', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('591', '3', '2017-11-28 11:49:37', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('592', '3', '2017-11-28 11:51:14', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('593', '3', '2017-11-28 11:52:26', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('594', '1', '2017-11-28 11:54:21', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('595', '1', '2017-11-28 12:39:04', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('596', '1', '2017-11-28 12:42:39', null, null);
INSERT INTO `loginrecord` VALUES ('597', '1', '2017-11-28 12:47:14', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('598', '1', '2017-11-28 12:50:53', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('599', '1', '2017-11-28 12:52:44', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('600', '1', '2017-11-28 13:01:17', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('601', '1', '2017-11-28 13:05:23', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('602', '1', '2017-11-28 13:30:38', null, null);
INSERT INTO `loginrecord` VALUES ('603', '1', '2017-11-28 13:32:28', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('604', '1', '2017-11-28 13:40:04', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('605', '1', '2017-11-28 13:44:46', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('606', '1', '2017-11-28 13:51:17', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('607', '1', '2017-11-28 14:36:04', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('608', '1', '2017-11-28 14:38:35', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('609', '1', '2017-11-28 14:51:19', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('610', '1', '2017-11-28 14:57:12', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('611', '1', '2017-11-28 15:05:01', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('612', '1', '2017-11-28 15:06:42', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('613', '1', '2017-11-28 15:19:49', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('614', '1', '2017-11-28 15:35:37', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('615', '1', '2017-11-28 15:43:27', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('616', '1', '2017-11-28 15:46:15', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('617', '3', '2017-11-28 15:46:26', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('618', '1', '2017-11-28 15:47:00', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('619', '1', '2017-11-28 17:09:06', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('620', '1', '2017-11-28 17:09:33', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('621', '1', '2017-11-28 17:28:57', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('622', '1', '2017-11-28 17:51:33', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('623', '1', '2017-11-28 17:52:46', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('624', '1', '2017-11-28 17:54:22', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('625', '1', '2017-11-28 19:50:02', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('626', '1', '2017-11-28 22:16:36', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('627', '1', '2017-11-28 22:19:31', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('628', '1', '2017-11-28 22:26:52', null, null);
INSERT INTO `loginrecord` VALUES ('629', '1', '2017-11-28 22:41:20', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('630', '1', '2017-11-28 22:42:14', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('631', '1', '2017-11-29 09:01:21', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('632', '1', '2017-11-29 16:56:08', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('633', '1', '2017-11-29 20:57:40', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('634', '1', '2017-11-29 21:04:12', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('635', '1', '2017-11-29 21:08:57', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('636', '1', '2017-11-29 22:05:58', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('637', '1', '2017-11-29 22:09:49', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('638', '1', '2017-11-29 22:21:53', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('639', '1', '2017-11-29 22:23:50', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('640', '1', '2017-11-29 22:53:24', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('641', '1', '2017-11-29 22:55:10', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('642', '1', '2017-11-29 23:12:12', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('643', '1', '2017-11-29 23:18:16', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('644', '1', '2017-11-29 23:21:39', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('645', '1', '2017-11-29 23:24:29', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('646', '1', '2017-11-29 23:26:15', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('647', '1', '2017-11-29 23:28:42', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('648', '1', '2017-11-29 23:29:43', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('649', '1', '2017-11-29 23:30:25', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('650', '1', '2017-11-29 23:32:58', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('651', '1', '2017-11-29 23:34:08', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('652', '1', '2017-11-30 10:21:15', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('653', '1', '2017-11-30 12:25:28', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('654', '1', '2017-11-30 12:27:37', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('655', '1', '2017-11-30 12:28:44', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('656', '1', '2017-11-30 14:02:10', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('657', '1', '2017-11-30 15:30:53', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('658', '1', '2017-11-30 16:15:04', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('659', '1', '2017-11-30 17:25:08', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('660', '1', '2017-11-30 20:42:48', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('661', '1', '2017-11-30 21:17:50', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('662', '1', '2017-11-30 21:32:50', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('663', '1', '2017-11-30 21:43:24', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('664', '1', '2017-11-30 21:44:25', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('665', '1', '2017-11-30 21:56:43', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('666', '1', '2017-11-30 22:00:48', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('667', '1', '2017-11-30 22:01:40', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('668', '1', '2017-11-30 22:03:34', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('669', '1', '2017-11-30 22:06:07', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('670', '1', '2017-11-30 22:07:17', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('671', '1', '2017-11-30 22:08:41', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('672', '1', '2017-11-30 22:10:15', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('673', '1', '2017-12-01 09:12:55', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('674', '1', '2017-12-01 09:14:39', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('675', '1', '2017-12-01 09:49:07', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('676', '1', '2017-12-01 11:35:37', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('677', '1', '2017-12-01 12:55:01', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('678', '1', '2017-12-01 14:35:21', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('679', '1', '2017-12-01 14:39:15', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('680', '1', '2017-12-01 14:40:34', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('681', '1', '2017-12-01 14:49:22', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('682', '1', '2017-12-01 15:31:23', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('683', '1', '2017-12-01 15:34:38', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('684', '1', '2017-12-01 16:00:48', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('685', '1', '2017-12-01 16:14:05', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('686', '1', '2017-12-01 16:15:40', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('687', '1', '2017-12-01 16:27:15', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('688', '1', '2017-12-01 17:05:15', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('689', '1', '2017-12-01 17:35:33', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('690', '1', '2017-12-01 17:39:05', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('691', '1', '2017-12-01 19:46:49', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('692', '1', '2017-12-01 22:54:45', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('693', '1', '2017-12-01 23:46:25', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('694', '1', '2017-12-02 11:00:01', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('695', '1', '2017-12-02 13:24:02', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('696', '1', '2017-12-02 16:04:13', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('697', '1', '2017-12-02 16:17:22', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('698', '1', '2017-12-02 17:43:12', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('699', '1', '2017-12-02 17:44:29', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('700', '1', '2017-12-02 17:46:34', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('701', '1', '2017-12-02 17:50:24', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('702', '1', '2017-12-02 20:21:24', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('703', '1', '2017-12-02 20:50:21', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('704', '1', '2017-12-02 21:02:00', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('705', '3', '2017-12-02 21:46:48', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('706', '1', '2017-12-02 21:50:27', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('707', '1', '2017-12-03 09:28:24', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('708', '1', '2017-12-03 11:17:16', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('709', '1', '2017-12-03 11:40:48', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('710', '2', '2017-12-03 13:28:32', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('711', '1', '2017-12-03 15:00:23', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('712', '1', '2017-12-03 17:08:58', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('713', '1', '2017-12-03 17:21:10', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('714', '2', '2017-12-03 17:23:36', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('715', '1', '2017-12-03 17:26:36', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('716', '1', '2017-12-03 17:47:40', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('717', '1', '2017-12-03 18:23:22', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('718', '1', '2017-12-03 20:18:06', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('719', '1', '2017-12-03 20:42:02', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('720', '1', '2017-12-03 23:00:32', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('721', '1', '2017-12-03 23:22:23', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('722', '1', '2017-12-04 09:14:22', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('723', '1', '2017-12-04 09:19:35', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('724', '1', '2017-12-04 09:45:44', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('725', '1', '2017-12-04 10:13:14', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('726', '1', '2017-12-04 10:22:32', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('727', '1', '2017-12-04 10:25:04', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('728', '1', '2017-12-04 11:07:35', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('729', '1', '2017-12-04 11:10:13', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('730', '1', '2017-12-04 12:53:19', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('731', '1', '2017-12-04 14:30:49', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('732', '1', '2017-12-04 14:48:39', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('733', '1', '2017-12-04 16:00:42', null, null);
INSERT INTO `loginrecord` VALUES ('734', '1', '2017-12-04 16:28:07', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('735', '1', '2017-12-04 17:06:58', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('736', '1', '2017-12-04 17:14:51', null, null);
INSERT INTO `loginrecord` VALUES ('737', '3', '2017-12-04 17:16:59', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('738', '1', '2017-12-04 17:28:57', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('739', '1', '2017-12-04 17:38:11', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('740', '1', '2017-12-04 17:48:33', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('741', '1', '2017-12-04 18:02:45', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('742', '1', '2017-12-04 22:11:38', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('743', '3', '2017-12-04 22:12:04', null, null);
INSERT INTO `loginrecord` VALUES ('744', '1', '2017-12-04 22:17:20', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('745', '1', '2017-12-04 22:20:24', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('746', '1', '2017-12-05 09:31:57', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('747', '1', '2017-12-05 09:59:14', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('748', '1', '2017-12-05 10:18:17', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('749', '1', '2017-12-05 10:30:14', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('750', '1', '2017-12-05 10:59:26', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('751', '1', '2017-12-05 11:17:12', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('752', '4', '2017-12-05 11:18:57', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('753', '1', '2017-12-05 11:27:40', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('754', '1', '2017-12-05 12:56:19', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('755', '1', '2017-12-05 15:07:25', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('756', '1', '2017-12-05 15:48:53', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('757', '1', '2017-12-05 16:20:21', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('758', '1', '2017-12-05 16:28:57', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('759', '1', '2017-12-05 16:52:45', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('760', '1', '2017-12-05 16:57:43', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('761', '1', '2017-12-05 17:18:36', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('762', '1', '2017-12-05 17:47:31', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('763', '1', '2017-12-06 10:33:21', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('764', '1', '2017-12-06 10:55:51', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('765', '1', '2017-12-06 11:01:15', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('766', '1', '2017-12-06 11:04:48', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('767', '1', '2017-12-06 11:17:40', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('768', '1', '2017-12-06 11:55:41', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('769', '1', '2017-12-06 16:10:28', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('770', '1', '2017-12-06 16:29:45', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('771', '1', '2017-12-06 16:47:38', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('772', '1', '2017-12-06 17:42:37', null, null);
INSERT INTO `loginrecord` VALUES ('773', '1', '2017-12-06 20:44:36', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('774', '1', '2017-12-06 21:42:27', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('775', '1', '2017-12-07 09:56:23', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('776', '1', '2017-12-07 10:34:41', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('777', '1', '2017-12-07 11:43:31', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('778', '1', '2017-12-07 13:09:28', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('779', '1', '2017-12-07 14:49:47', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('780', '1', '2017-12-07 14:52:32', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('781', '1', '2017-12-07 14:53:16', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('782', '1', '2017-12-07 15:20:24', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('783', '1', '2017-12-07 15:24:31', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('784', '1', '2017-12-07 15:28:05', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('785', '1', '2017-12-07 15:29:05', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('786', '1', '2017-12-07 15:30:01', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('787', '1', '2017-12-07 15:35:57', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('788', '1', '2017-12-07 15:37:13', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('789', '1', '2017-12-07 15:38:34', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('790', '1', '2017-12-07 15:40:50', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('791', '1', '2017-12-07 15:43:00', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('792', '1', '2017-12-07 15:45:20', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('793', '1', '2017-12-07 15:46:08', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('794', '1', '2017-12-07 15:48:21', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('795', '1', '2017-12-07 15:49:08', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('796', '1', '2017-12-07 15:54:42', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('797', '1', '2017-12-07 15:57:04', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('798', '1', '2017-12-07 16:17:40', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('799', '1', '2017-12-07 16:21:11', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('800', '1', '2017-12-07 16:29:43', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('801', '1', '2017-12-07 16:34:52', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('802', '1', '2017-12-07 16:46:34', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('803', '1', '2017-12-07 16:52:40', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('804', '1', '2017-12-07 16:54:41', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('805', '1', '2017-12-07 17:58:35', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('806', '1', '2017-12-08 09:39:45', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('807', '1', '2017-12-08 15:28:21', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('808', '1', '2017-12-08 15:50:07', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('809', '1', '2017-12-08 16:10:47', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('810', '1', '2017-12-08 16:12:10', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('811', '1', '2017-12-08 16:13:22', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('812', '1', '2017-12-08 16:15:02', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('813', '1', '2017-12-08 16:17:39', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('814', '1', '2017-12-08 16:24:23', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('815', '1', '2017-12-08 17:16:16', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('816', '1', '2017-12-09 11:44:29', '0', null);
INSERT INTO `loginrecord` VALUES ('817', '1', '2017-12-09 12:24:01', '0', null);
INSERT INTO `loginrecord` VALUES ('818', '1', '2017-12-09 16:06:37', '0', null);
INSERT INTO `loginrecord` VALUES ('819', '1', '2017-12-11 09:15:55', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('820', '1', '2017-12-11 09:20:11', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('821', '1', '2017-12-11 09:33:01', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('822', '1', '2017-12-11 10:50:46', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('823', '1', '2017-12-11 11:08:00', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('824', '1', '2017-12-11 11:14:00', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('825', '1', '2017-12-11 11:25:06', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('826', '1', '2017-12-11 11:28:54', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('827', '1', '2017-12-11 11:45:50', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('828', '1', '2017-12-11 15:21:58', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('829', '1', '2017-12-11 16:06:49', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('830', '1', '2017-12-11 16:32:52', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('831', '1', '2017-12-11 16:38:29', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('832', '1', '2017-12-11 17:05:41', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('833', '1', '2017-12-11 17:37:22', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('834', '1', '2017-12-11 17:45:24', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('835', '1', '2017-12-11 17:49:22', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('836', '1', '2017-12-11 17:53:40', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('837', '1', '2017-12-12 10:36:31', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('838', '1', '2017-12-12 10:47:04', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('839', '1', '2017-12-12 11:03:32', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('840', '1', '2017-12-12 11:17:02', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('841', '1', '2017-12-12 11:26:42', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('842', '1', '2017-12-12 11:56:36', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('843', '1', '2017-12-12 12:36:56', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('844', '1', '2017-12-12 12:56:14', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('845', '1', '2017-12-12 13:00:00', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('846', '1', '2017-12-12 13:07:04', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('847', '1', '2017-12-12 13:12:51', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('848', '1', '2017-12-12 13:19:02', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('849', '1', '2017-12-12 13:22:13', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('850', '1', '2017-12-12 13:24:05', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('851', '1', '2017-12-12 13:28:52', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('852', '1', '2017-12-12 13:33:08', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('853', '1', '2017-12-12 15:31:36', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('854', '1', '2017-12-12 15:33:25', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('855', '1', '2017-12-12 15:39:32', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('856', '1', '2017-12-12 15:41:52', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('857', '1', '2017-12-12 15:44:27', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('858', '1', '2017-12-12 15:49:45', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('859', '1', '2017-12-12 15:55:55', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('860', '1', '2017-12-12 16:00:35', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('861', '1', '2017-12-12 17:12:51', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('862', '1', '2017-12-12 17:19:22', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('863', '1', '2017-12-13 09:45:54', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('864', '1', '2017-12-13 10:32:40', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('865', '1', '2017-12-13 11:10:06', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('866', '1', '2017-12-13 14:12:02', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('867', '1', '2017-12-13 15:53:19', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('868', '1', '2017-12-13 16:01:44', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('869', '1', '2017-12-13 16:37:13', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('870', '1', '2017-12-13 19:49:24', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('871', '1', '2017-12-14 09:29:58', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('872', '1', '2017-12-14 10:12:01', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('873', '1', '2017-12-14 16:02:21', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('874', '1', '2017-12-14 20:04:32', '中国广东省深圳市', null);
INSERT INTO `loginrecord` VALUES ('875', '1', '2017-12-15 10:19:15', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('876', '1', '2017-12-15 11:58:27', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('877', '1', '2017-12-15 14:55:11', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('878', '1', '2017-12-15 15:17:20', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('879', '1', '2017-12-15 15:20:18', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('880', '1', '2017-12-15 15:47:44', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('881', '1', '2017-12-16 11:08:23', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('882', '1', '2017-12-16 11:14:24', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('883', '1', '2017-12-16 11:24:40', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('884', '1', '2017-12-16 11:27:25', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('885', '1', '2017-12-16 11:30:09', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('886', '1', '2017-12-16 11:33:55', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('887', '1', '2017-12-16 12:32:52', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('888', '1', '2017-12-16 12:38:51', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('889', '1', '2017-12-16 12:45:52', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('890', '1', '2017-12-16 19:29:43', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('891', '1', '2017-12-17 16:59:40', '中国广东省深圳市', null);
INSERT INTO `loginrecord` VALUES ('892', '1', '2017-12-17 19:35:32', '中国广东省深圳市', null);
INSERT INTO `loginrecord` VALUES ('893', '1', '2017-12-17 21:22:43', '中国广东省深圳市', null);
INSERT INTO `loginrecord` VALUES ('894', '1', '2017-12-17 21:27:22', '中国广东省深圳市', null);
INSERT INTO `loginrecord` VALUES ('895', '1', '2017-12-17 21:49:16', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('896', '1', '2017-12-17 21:52:37', '中国广东省深圳市', null);
INSERT INTO `loginrecord` VALUES ('897', '1', '2017-12-18 09:19:29', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('898', '3', '2017-12-18 09:38:46', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('899', '3', '2017-12-18 10:49:55', '中国广东省广州市', null);
INSERT INTO `loginrecord` VALUES ('900', '1', '2017-12-18 14:47:17', '中国广东省广州市', null);

-- ----------------------------
-- Table structure for `permission_info`
-- ----------------------------
DROP TABLE IF EXISTS `permission_info`;
CREATE TABLE `permission_info` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(255) default NULL COMMENT '名称',
  `action` varchar(255) default NULL COMMENT '动作',
  `level` int(11) default NULL COMMENT '权限等级：1、2、3',
  `status` int(255) default '1' COMMENT '状态1可用0禁用',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `action` (`action`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_info
-- ----------------------------
INSERT INTO `permission_info` VALUES ('1', '填写报表', 'report:edit', '3', '1');
INSERT INTO `permission_info` VALUES ('2', '删除报表', 'report:delete', '3', '1');
INSERT INTO `permission_info` VALUES ('4', '用户添加', 'user:add', '1', '1');

-- ----------------------------
-- Table structure for `right_info`
-- ----------------------------
DROP TABLE IF EXISTS `right_info`;
CREATE TABLE `right_info` (
  `right_code` bigint(20) NOT NULL auto_increment COMMENT '菜单编码(主键)',
  `right_parent_code` bigint(20) default NULL COMMENT '父菜单编码',
  `right_type` int(20) default NULL COMMENT '菜单类型',
  `right_text` varchar(50) default NULL COMMENT '菜单文本',
  `right_url` varchar(100) default '' COMMENT '菜单访问路径',
  `right_tip` varchar(50) default NULL COMMENT '菜单提示',
  `ispatent` tinyint(1) default '0' COMMENT '是否含有子菜单0表示没有1表示有',
  PRIMARY KEY  (`right_code`),
  KEY `right_parent_code` (`right_parent_code`),
  CONSTRAINT `right_info_ibfk_1` FOREIGN KEY (`right_parent_code`) REFERENCES `right_info` (`right_code`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表：营销管理、客户管理、服务管理、统';

-- ----------------------------
-- Records of right_info
-- ----------------------------
INSERT INTO `right_info` VALUES ('1', null, '1', '系统管理', '', '系统管理', '1');
INSERT INTO `right_info` VALUES ('2', null, '1', '营销管理', 'open/developing.do', '223213123', '0');
INSERT INTO `right_info` VALUES ('3', null, '1', '客户管理', 'word/clienManagePage.do', null, '0');
INSERT INTO `right_info` VALUES ('4', null, '1', '服务管理', 'open/developing.do', null, '0');
INSERT INTO `right_info` VALUES ('5', null, '1', '统计报表', 'open/developing.do', null, '0');
INSERT INTO `right_info` VALUES ('6', null, '1', '基本数据', 'open/developing.do', null, '0');
INSERT INTO `right_info` VALUES ('7', null, '1', '权限管理', null, null, '1');
INSERT INTO `right_info` VALUES ('8', '7', '2', '用户管理', 'word/Umanager.do', '', '0');
INSERT INTO `right_info` VALUES ('9', '1', '2', '菜单管理', 'word/Menumanage.do', '菜单管理功能完成', '0');
INSERT INTO `right_info` VALUES ('10', null, '1', '部门管理', 'word/departmentManage.do', '哈哈', '0');
INSERT INTO `right_info` VALUES ('17', '7', '2', '角色管理', 'word/roleManage.do', '角色修改功能已完成', '0');
INSERT INTO `right_info` VALUES ('18', null, '1', '第三方个', 'open/developing.do', null, '1');
INSERT INTO `right_info` VALUES ('20', '18', '2', '菜单名未定义', 'open/developing.do', null, '0');
INSERT INTO `right_info` VALUES ('21', null, '1', '系统垃圾管理', 'open/developing.do', null, '0');
INSERT INTO `right_info` VALUES ('22', '1', '2', '操作权限管理', 'word/PermissionManage.do', '权限操作管理功能完成', '0');

-- ----------------------------
-- Table structure for `role_info`
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info` (
  `role_id` bigint(20) NOT NULL auto_increment,
  `role_name` varchar(50) NOT NULL COMMENT '角色名称',
  `role_desc` varchar(50) default NULL COMMENT '角色描述',
  `status` int(11) default NULL COMMENT '角色状态（1或0，1表示可用）',
  `role_code` varchar(255) default NULL COMMENT '角色编码',
  PRIMARY KEY  (`role_id`),
  UNIQUE KEY `role_code` USING HASH (`role_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表：系统管理员、销售主管、客户经理和';

-- ----------------------------
-- Records of role_info
-- ----------------------------
INSERT INTO `role_info` VALUES ('1', 'Admin', '系统管理员', '1', 'admin');
INSERT INTO `role_info` VALUES ('2', '销售主管', '销售主管', '1', 'salesExecutive');
INSERT INTO `role_info` VALUES ('3', '客户经理', '客户经理', '1', 'customerManage');
INSERT INTO `role_info` VALUES ('4', '人事主管', '人事主管', '1', 'hr');

-- ----------------------------
-- Table structure for `role_permission_info`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission_info`;
CREATE TABLE `role_permission_info` (
  `id` bigint(20) NOT NULL auto_increment,
  `rid` bigint(20) default NULL,
  `pid` bigint(20) default NULL,
  PRIMARY KEY  (`id`),
  KEY `rid` (`rid`),
  KEY `pid` (`pid`),
  CONSTRAINT `role_permission_info_ibfk_3` FOREIGN KEY (`pid`) REFERENCES `permission_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `role_permission_info_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `role_info` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission_info
-- ----------------------------
INSERT INTO `role_permission_info` VALUES ('1', '1', '1');
INSERT INTO `role_permission_info` VALUES ('2', '1', '2');
INSERT INTO `role_permission_info` VALUES ('3', '3', '1');
INSERT INTO `role_permission_info` VALUES ('4', '3', '2');
INSERT INTO `role_permission_info` VALUES ('6', '4', '1');
INSERT INTO `role_permission_info` VALUES ('7', '4', '2');
INSERT INTO `role_permission_info` VALUES ('8', '2', '1');
INSERT INTO `role_permission_info` VALUES ('9', '2', '2');

-- ----------------------------
-- Table structure for `role_right_info`
-- ----------------------------
DROP TABLE IF EXISTS `role_right_info`;
CREATE TABLE `role_right_info` (
  `rf_id` bigint(20) NOT NULL auto_increment,
  `rf_role_id` bigint(20) NOT NULL COMMENT '角色编号（外键role表role_id）',
  `rf_right_code` bigint(20) NOT NULL,
  PRIMARY KEY  (`rf_id`),
  KEY `rf_role_id` (`rf_role_id`),
  KEY `rf_right_code` (`rf_right_code`),
  CONSTRAINT `role_right_info_ibfk_1` FOREIGN KEY (`rf_right_code`) REFERENCES `right_info` (`right_code`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `rf_role_id` FOREIGN KEY (`rf_role_id`) REFERENCES `role_info` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单权限表：角色对应菜单; ';

-- ----------------------------
-- Records of role_right_info
-- ----------------------------
INSERT INTO `role_right_info` VALUES ('2', '1', '2');
INSERT INTO `role_right_info` VALUES ('3', '1', '3');
INSERT INTO `role_right_info` VALUES ('4', '1', '4');
INSERT INTO `role_right_info` VALUES ('5', '1', '5');
INSERT INTO `role_right_info` VALUES ('6', '1', '6');
INSERT INTO `role_right_info` VALUES ('7', '1', '7');
INSERT INTO `role_right_info` VALUES ('12', '1', '8');
INSERT INTO `role_right_info` VALUES ('13', '1', '9');
INSERT INTO `role_right_info` VALUES ('16', '3', '8');
INSERT INTO `role_right_info` VALUES ('17', '3', '9');
INSERT INTO `role_right_info` VALUES ('21', '1', '10');
INSERT INTO `role_right_info` VALUES ('22', '1', '17');
INSERT INTO `role_right_info` VALUES ('23', '1', '21');
INSERT INTO `role_right_info` VALUES ('24', '1', '22');
INSERT INTO `role_right_info` VALUES ('25', '1', '1');
INSERT INTO `role_right_info` VALUES ('26', '4', '2');
INSERT INTO `role_right_info` VALUES ('27', '4', '3');
INSERT INTO `role_right_info` VALUES ('28', '4', '5');
INSERT INTO `role_right_info` VALUES ('29', '4', '10');
INSERT INTO `role_right_info` VALUES ('30', '2', '2');
INSERT INTO `role_right_info` VALUES ('31', '2', '3');
INSERT INTO `role_right_info` VALUES ('32', '2', '4');
INSERT INTO `role_right_info` VALUES ('33', '2', '5');
INSERT INTO `role_right_info` VALUES ('34', '2', '6');
INSERT INTO `role_right_info` VALUES ('36', '2', '7');
INSERT INTO `role_right_info` VALUES ('37', '2', '17');

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` bigint(11) NOT NULL auto_increment COMMENT '唯一标示',
  `username` varchar(8) default NULL COMMENT '用户登陆名',
  `password` varchar(32) default NULL COMMENT '登陆密码',
  `name` varchar(8) default NULL COMMENT '名字',
  `himg` varchar(254) default NULL COMMENT '用户头像',
  `IDcard` varchar(18) default NULL COMMENT '身份证号',
  `qq` varchar(30) default NULL COMMENT 'qq号',
  `wechat` varchar(30) default NULL COMMENT '微信号',
  `email` varchar(32) default NULL,
  `phone` bigint(12) default NULL COMMENT '联系电话',
  `birthday` date default NULL COMMENT '出生年月',
  `height` int(11) default NULL COMMENT '身高：*/cm',
  `weight` int(11) default NULL COMMENT '体重：*/kg',
  `education` varchar(255) default NULL COMMENT '学历',
  `graduate_school` varchar(255) default NULL COMMENT '毕业院校',
  `major` varchar(255) default NULL COMMENT '专业',
  `graduation_time` date default NULL COMMENT '毕业时间',
  `male` varchar(2) default NULL COMMENT '性别',
  `role_id` bigint(20) default NULL COMMENT '角色',
  `department_id` bigint(20) default NULL COMMENT '部门',
  `remark` varchar(250) default NULL COMMENT '个人信息备注',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `username` USING HASH (`username`),
  KEY `role_id` (`role_id`),
  KEY `department_id` (`department_id`),
  CONSTRAINT `department_id` FOREIGN KEY (`department_id`) REFERENCES `department_info` (`id`),
  CONSTRAINT `user_info_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role_info` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '管理员', '/upload/2017/1204/20171204175853.jpg', '', '1134420025', 'luo1134420025', '1134420025@qq.com', '13788459121', '2017-11-08', '170', '150', '本科', '桂林电子科技大学', '计算机应用技术', '2017-11-15', '男', '1', '1', '备注信息备注信息');
INSERT INTO `user_info` VALUES ('2', 'a123', 'e10adc3949ba59abbe56e057f20f883e', 'MonMy', '/images/headPortrait/20171122144127.jpg', '', '', '', '', null, '1995-02-18', null, null, '', '', '', '2017-06-01', '女', '2', '2', '');
INSERT INTO `user_info` VALUES ('3', 'a111', 'e10adc3949ba59abbe56e057f20f883e', '苏苏', '/upload/2017/1204/20171204221220.jpg', '', '', '', '', null, null, null, null, '', '', '', null, '女', '4', '3', '');
INSERT INTO `user_info` VALUES ('4', 'oumuv', 'e10adc3949ba59abbe56e057f20f883e', '欧银锋', null, '', '1134420025', 'luo1134420025', '1134420025@qq.com', '13788459121', '1994-10-15', null, null, '硕士', '桂林电子科技大学', '计算机应用技术专业', '2017-07-01', '男', '1', '1', '');

-- ----------------------------
-- Table structure for `user_role_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_role_info`;
CREATE TABLE `user_role_info` (
  `uid` bigint(20) NOT NULL default '0' COMMENT '用户id',
  `rid` bigint(20) NOT NULL default '0' COMMENT '角色id',
  PRIMARY KEY  (`uid`,`rid`),
  KEY `user_role_info_ibfk_1` (`uid`),
  KEY `user_role_info_ibfk_2` (`rid`),
  CONSTRAINT `user_role_info_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_role_info_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role_info` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色桥表';

-- ----------------------------
-- Records of user_role_info
-- ----------------------------
INSERT INTO `user_role_info` VALUES ('1', '1');
INSERT INTO `user_role_info` VALUES ('1', '3');
INSERT INTO `user_role_info` VALUES ('2', '2');
INSERT INTO `user_role_info` VALUES ('3', '4');
INSERT INTO `user_role_info` VALUES ('4', '1');
