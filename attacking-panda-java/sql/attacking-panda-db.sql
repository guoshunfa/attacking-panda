/*
 Navicat Premium Data Transfer

 Source Server         : local_mysql
 Source Server Type    : MySQL
 Source Server Version : 50738
 Source Host           : localhost:3306
 Source Schema         : attacking-panda-db

 Target Server Type    : MySQL
 Target Server Version : 50738
 File Encoding         : 65001

 Date: 11/11/2022 10:08:27
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`
(
    `id`             varchar(255) COLLATE utf8_bin NOT NULL COMMENT '主键',
    `dept_name`      varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '部门名称',
    `parent_dept_id` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '上级部门id',
    `version`        int(255) DEFAULT NULL COMMENT '乐观锁字段',
    `delete_flag`    int(11) DEFAULT NULL COMMENT '逻辑删除字段',
    `create_time`    date                          DEFAULT NULL COMMENT '记录创建时间',
    `create_by`      varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '记录创建人',
    `update_time`    date                          DEFAULT NULL COMMENT '记录修改时间',
    `update_by`      varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '记录修改人',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='系统部门表';

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `id`            varchar(255) COLLATE utf8_bin NOT NULL COMMENT '主键',
    `user_name`     varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户姓名',
    `user_password` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户密码',
    `dept_id`       varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '所在部门id',
    `version`       int(11) DEFAULT NULL COMMENT '乐观锁字段',
    `delete_flag`   int(11) DEFAULT NULL COMMENT '逻辑删除字段',
    `create_time`   date                          DEFAULT NULL COMMENT '记录创建时间',
    `create_by`     varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '记录创建人',
    `update_time`   date                          DEFAULT NULL COMMENT '记录修改时间',
    `update_by`     varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '记录修改人',
    PRIMARY KEY (`id`) USING BTREE,
    KEY             `fk_user_dept_id` (`dept_id`),
    CONSTRAINT `fk_user_dept_id` FOREIGN KEY (`dept_id`) REFERENCES `sys_dept` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='系统用户表';

SET
FOREIGN_KEY_CHECKS = 1;
