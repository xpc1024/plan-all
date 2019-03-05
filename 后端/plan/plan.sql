/*
Navicat MySQL Data Transfer

Source Server         : 119.3.48.53
Source Server Version : 50722
Source Host           : 119.3.48.53:3306
Source Database       : plan

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-02-27 12:33:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for generate
-- ----------------------------
DROP TABLE IF EXISTS `generate`;
CREATE TABLE `generate` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `sex` int(10) DEFAULT NULL COMMENT '性别 女:0  男:1',
  `goal` int(10) DEFAULT NULL COMMENT '目的 减脂:0 增肌:1',
  `health` varchar(10) DEFAULT NULL COMMENT '健康状况 优:A 良:B 差:C',
  `training` varchar(10) DEFAULT NULL COMMENT '训练方式 健身房:A 哑铃:B 徒手:C',
  `strength` varchar(10) DEFAULT NULL COMMENT '训练强度 强:A 中:B 弱:C',
  `person_id` int(11) DEFAULT NULL COMMENT '请求对应的用户id',
  `ip` varchar(255) DEFAULT NULL COMMENT '请求者的ip',
  `date` date DEFAULT NULL COMMENT '生成计划的日期',
  `cost_time` varchar(255) DEFAULT NULL COMMENT '用户从发起请求至生成完计划 操作的总耗时 单位:ms',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(20) DEFAULT NULL COMMENT '用户姓名',
  `age` int(5) DEFAULT NULL COMMENT '用户年龄',
  `wechat` varchar(255) DEFAULT NULL COMMENT '用户微信',
  `qq` varchar(255) DEFAULT NULL COMMENT '用户QQ',
  `mail` varchar(255) DEFAULT NULL COMMENT '用户邮箱',
  `phone` varchar(255) DEFAULT NULL COMMENT '用户手机号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;
