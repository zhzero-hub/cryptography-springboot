/*
 Navicat Premium Data Transfer

 Source Server         : ali_exam
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : 47.107.78.99:3306
 Source Schema         : exam

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 19/12/2020
*/
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `knapsack`;
CREATE TABLE `knapsack` (
    `id` INT(9) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `message` VARCHAR(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '明文信息',
    `k` BIGINT(20) NULL DEFAULT NULL COMMENT 'k',
    `t` BIGINT(20) NULL DEFAULT NULL COMMENT 't',
    `publicKey` VARCHAR(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '公钥',
    `secretKey` VARCHAR(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '私钥',
    `encodedMessage` VARCHAR(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '加密信息',
    `decodedMessage` VARCHAR(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '解密信息',
    `date` VARCHAR(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '加密时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 0000 CHARACTER SET utf8 COLLATE utf8_bin ROW_FORMAT = Dynamic COMMENT '背包密码体制加密历史记录表';