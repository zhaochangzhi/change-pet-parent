/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : change_pet

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-01-31 16:06:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for chp_user
-- ----------------------------
DROP TABLE IF EXISTS `chp_user`;
CREATE TABLE `chp_user` (
  `id` varchar(64) NOT NULL COMMENT 'user_id',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `realname` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `sex` bit(1) DEFAULT b'0' COMMENT '0女1男',
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` bit(1) DEFAULT b'1' COMMENT '0禁用1启用，默认1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for chp_user_auth
-- ----------------------------
DROP TABLE IF EXISTS `chp_user_auth`;
CREATE TABLE `chp_user_auth` (
  `id` bigint(20) NOT NULL,
  `user_id` varchar(64) DEFAULT NULL COMMENT 'user_id',
  `auth_type` varchar(10) NOT NULL COMMENT '授权类型：手机号 phone；邮箱 email；微信 wechat；微博 weibo',
  `access_account` varchar(200) NOT NULL COMMENT '授权账户',
  `access_token` varchar(200) NOT NULL COMMENT '授权密钥',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` bit(1) DEFAULT b'1' COMMENT '0禁用1启用，默认1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
