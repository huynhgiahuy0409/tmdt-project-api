/*
 Navicat Premium Data Transfer

 Source Server         : tmdt-project
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : tmdt-toystore

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 13/06/2022 01:01:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for brand
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `created_date` datetime NULL DEFAULT NULL,
  `modified_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `modified_date` datetime NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of brand
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `created_date` datetime NULL DEFAULT NULL,
  `modified_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `modified_date` datetime NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, NULL, NULL, NULL, NULL, '1', '1');

-- ----------------------------
-- Table structure for coupon
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `created_date` datetime NULL DEFAULT NULL,
  `modified_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `modified_date` datetime NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `value` double NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coupon
-- ----------------------------

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `created_date` datetime NULL DEFAULT NULL,
  `modified_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `modified_date` datetime NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `product_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKgpextbyee3uk9u6o2381m7ft1`(`product_id` ASC) USING BTREE,
  CONSTRAINT `FKgpextbyee3uk9u6o2381m7ft1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of image
-- ----------------------------

-- ----------------------------
-- Table structure for material
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `created_date` datetime NULL DEFAULT NULL,
  `modified_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `modified_date` datetime NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of material
-- ----------------------------

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `created_date` datetime NULL DEFAULT NULL,
  `modified_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `modified_date` datetime NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `created_date` datetime NULL DEFAULT NULL,
  `modified_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `modified_date` datetime NULL DEFAULT NULL,
  `sku` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `buy_price` double NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `origin` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `repository` int NOT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `weight` double NOT NULL,
  `brand_id` bigint NULL DEFAULT NULL,
  `category_id` bigint NULL DEFAULT NULL,
  `material_id` bigint NULL DEFAULT NULL,
  `size_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKs6cydsualtsrprvlf2bb3lcam`(`brand_id` ASC) USING BTREE,
  INDEX `FK1mtsbur82frn64de7balymq9s`(`category_id` ASC) USING BTREE,
  INDEX `FKw04fq456sc4tk26tnbhvr59o`(`material_id` ASC) USING BTREE,
  INDEX `FKsccbu8jiglqc6t5tjsp04amv7`(`size_id` ASC) USING BTREE,
  CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKs6cydsualtsrprvlf2bb3lcam` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKsccbu8jiglqc6t5tjsp04amv7` FOREIGN KEY (`size_id`) REFERENCES `size` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKw04fq456sc4tk26tnbhvr59o` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `created_date` datetime NULL DEFAULT NULL,
  `modified_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `modified_date` datetime NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `role_id` bigint NOT NULL,
  `permission_id` bigint NOT NULL,
  PRIMARY KEY (`role_id`, `permission_id`) USING BTREE,
  INDEX `FKf8yllw1ecvwqy3ehyxawqa1qp`(`permission_id` ASC) USING BTREE,
  CONSTRAINT `FKa6jx8n8xkesmjmv6jqug6bg68` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKf8yllw1ecvwqy3ehyxawqa1qp` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `created_date` datetime NULL DEFAULT NULL,
  `modified_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `modified_date` datetime NULL DEFAULT NULL,
  `followers` int NOT NULL,
  `last_access` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `number_product` int NOT NULL,
  `number_review` int NOT NULL,
  `response_rate` int NOT NULL,
  `response_time` int NOT NULL,
  `image_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKh6ljwm1vgre8v1c4sras9hap5`(`image_id` ASC) USING BTREE,
  CONSTRAINT `FKh6ljwm1vgre8v1c4sras9hap5` FOREIGN KEY (`image_id`) REFERENCES `image` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop
-- ----------------------------

-- ----------------------------
-- Table structure for size
-- ----------------------------
DROP TABLE IF EXISTS `size`;
CREATE TABLE `size`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `created_date` datetime NULL DEFAULT NULL,
  `modified_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `modified_date` datetime NULL DEFAULT NULL,
  `height` double NOT NULL,
  `length` double NOT NULL,
  `width` double NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of size
-- ----------------------------

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `created_date` datetime NULL DEFAULT NULL,
  `modified_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `modified_date` datetime NULL DEFAULT NULL,
  `token` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `token_expiration_date` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of token
-- ----------------------------
INSERT INTO `token` VALUES (1, '18130094@st.hcmuaf.edu.vn', '2022-06-12 01:33:13', '18130094@st.hcmuaf.edu.vn', '2022-06-12 01:33:13', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTQ5NzI0MjIsImlhdCI6MTY1NDk3MjM5Mn0.VutfF1mkYmgR2QSdcEw707ykSJheBoKDSQx7vbagMqONjuZDjDjv0lpiBaTKZCbfK0H0fnCXgL8Aoj7YHZ3zVA', '2022-06-12 01:33:42');
INSERT INTO `token` VALUES (2, '18130094@st.hcmuaf.edu.vn', '2022-06-12 01:53:22', '18130094@st.hcmuaf.edu.vn', '2022-06-12 01:53:22', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTQ5NzM2MzIsImlhdCI6MTY1NDk3MzYwMn0.hVynxDGPqidpSo8qBX6CA-35zPAqt9XyoSbKqgFwnJFtUSn2pF_jXr0K_4ZrVaXWk0jTv2CA9RsyAJV6ySRDtg', '2022-06-12 01:53:52');
INSERT INTO `token` VALUES (3, '18130094@st.hcmuaf.edu.vn', '2022-06-12 01:58:22', '18130094@st.hcmuaf.edu.vn', '2022-06-12 01:58:22', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTQ5NzM5MzEsImlhdCI6MTY1NDk3MzkwMX0.nKvzhckXzcG2b0tFAWahM3F34kHgY5rqFBYF0LH_rojm9_NAwwb-8xwcvUzkvwSlIWrA8rxUbHY8fjMyPSvttQ', '2022-06-12 01:58:51');
INSERT INTO `token` VALUES (4, '18130094@st.hcmuaf.edu.vn', '2022-06-12 01:58:24', '18130094@st.hcmuaf.edu.vn', '2022-06-12 01:58:24', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTQ5NzM5MzMsImlhdCI6MTY1NDk3MzkwM30.hP-ZtOc148QOm3vuLxoDEsFvFafrSnIYpp4bholU07dUTHtgTDeHv0oTFfCYOEv5q0PEmsI-O49YDdyQZBx8zg', '2022-06-12 01:58:53');
INSERT INTO `token` VALUES (5, '18130094@st.hcmuaf.edu.vn', '2022-06-12 01:58:25', '18130094@st.hcmuaf.edu.vn', '2022-06-12 01:58:25', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTQ5NzM5MzQsImlhdCI6MTY1NDk3MzkwNH0.2mkn3ONSZapyc66WlVMhC3LGW3ZJ60yOaMdPbwLqGn69UN7SUGiMhLtO1v81ua5DdK6okFLLnYBXOqTaV-c6ug', '2022-06-12 01:58:54');
INSERT INTO `token` VALUES (6, '18130094@st.hcmuaf.edu.vn', '2022-06-12 01:58:26', '18130094@st.hcmuaf.edu.vn', '2022-06-12 01:58:26', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTQ5NzM5MzYsImlhdCI6MTY1NDk3MzkwNn0.I4y8WsIq-zlN-5VheHKUL87w8hR3JP3TQnbEScyQ44sDXYZNtYemTA5tQTwLf47z8lz5TStX2-wDq1ovF1fX9w', '2022-06-12 01:58:56');
INSERT INTO `token` VALUES (7, '18130094@st.hcmuaf.edu.vn', '2022-06-12 01:58:27', '18130094@st.hcmuaf.edu.vn', '2022-06-12 01:58:27', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTQ5NzM5MzcsImlhdCI6MTY1NDk3MzkwN30.ScH3QyvXi9xDHsAm9IxPUAx7AX5ROGxmXiFTrHZsRNzxrjs9xlXmX1gtEPv7U59krwUvSb2V7Letqz4j_Y2gIw', '2022-06-12 01:58:57');
INSERT INTO `token` VALUES (8, '18130094@st.hcmuaf.edu.vn', '2022-06-12 01:58:28', '18130094@st.hcmuaf.edu.vn', '2022-06-12 01:58:28', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTQ5NzM5MzgsImlhdCI6MTY1NDk3MzkwOH0.DYnjeuSvWbaVoGA04SN3TEpksZQ8Pm-L_L2Nd51tYA729MP7m32ToPfDHJ9P63cT3bdTo9Kw21gKj89_DPCsog', '2022-06-12 01:58:58');
INSERT INTO `token` VALUES (9, '18130094@st.hcmuaf.edu.vn', '2022-06-12 01:58:29', '18130094@st.hcmuaf.edu.vn', '2022-06-12 01:58:29', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTQ5NzM5MzgsImlhdCI6MTY1NDk3MzkwOH0.DYnjeuSvWbaVoGA04SN3TEpksZQ8Pm-L_L2Nd51tYA729MP7m32ToPfDHJ9P63cT3bdTo9Kw21gKj89_DPCsog', '2022-06-12 01:58:58');
INSERT INTO `token` VALUES (10, '18130094@st.hcmuaf.edu.vn', '2022-06-12 01:58:30', '18130094@st.hcmuaf.edu.vn', '2022-06-12 01:58:30', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTQ5NzM5MzksImlhdCI6MTY1NDk3MzkwOX0.ZLj9swN5OHjBKz3nk7pObTr43m2HRVo2cIeUf8hEKvA4jPa25gO-G2fNvbYlPjVLqjlOfqft8h_VOQc2ULRUUw', '2022-06-12 01:58:59');
INSERT INTO `token` VALUES (11, '18130094@st.hcmuaf.edu.vn', '2022-06-12 01:58:52', '18130094@st.hcmuaf.edu.vn', '2022-06-12 01:58:52', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTQ5NzM5NjEsImlhdCI6MTY1NDk3MzkzMX0.c7RfkMmXCrsmIXGwvFkOrdgZrb6EXMhxpBpGcjrDrZO9vQMpWHgNWz4r9AZ5J2qWg4L-5EAUM4JVIw90XphdTQ', '2022-06-12 01:59:21');
INSERT INTO `token` VALUES (12, '18130094@st.hcmuaf.edu.vn', '2022-06-12 02:12:01', '18130094@st.hcmuaf.edu.vn', '2022-06-12 02:12:01', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTQ5NzQ3NTAsImlhdCI6MTY1NDk3NDcyMH0.7oFTiKyrGZPqLZK2b5BLeBKzqSENEYJNS1K_Pplq3eQmx1_HlJp4WIGVppRk1UqrEtuwpvDiunTQv63hReMp7Q', '2022-06-12 02:12:30');
INSERT INTO `token` VALUES (13, '18130094@st.hcmuaf.edu.vn', '2022-06-12 02:14:59', '18130094@st.hcmuaf.edu.vn', '2022-06-12 02:14:59', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTQ5NzQ5MjgsImlhdCI6MTY1NDk3NDg5OH0.k4qaIGNMQ3yXAEIRs3vfVYkBen8LEasUiaUvhzpZIJCLZMlCHkOBWd61qTQuHYHu4F9fw-edH8u5QUbK_muG4g', '2022-06-12 02:15:28');
INSERT INTO `token` VALUES (14, '18130094@st.hcmuaf.edu.vn', '2022-06-12 02:15:34', '18130094@st.hcmuaf.edu.vn', '2022-06-12 02:15:34', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTQ5NzQ5NjQsImlhdCI6MTY1NDk3NDkzNH0.t5NVbKnIEomm1xvvLVvQOhzP_0S2ATRP3C4UuQVFXZzX_Qn8n3MaawVamx-17mXGbxQLu1j_84HDT7kGAqS30Q', '2022-06-12 02:16:04');
INSERT INTO `token` VALUES (15, '18130094@st.hcmuaf.edu.vn', '2022-06-12 02:29:19', '18130094@st.hcmuaf.edu.vn', '2022-06-12 02:29:19', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTQ5NzU3ODgsImlhdCI6MTY1NDk3NTc1OH0.BMJV0zl845pDESFpcmeimOO5djh99y82p2jsyEj7GyanEvUUxmUzzF8oNJuhBm5bVmA8_g8xC89FCOPsS2QjDQ', '2022-06-12 02:29:48');
INSERT INTO `token` VALUES (16, '18130094@st.hcmuaf.edu.vn', '2022-06-12 03:41:51', '18130094@st.hcmuaf.edu.vn', '2022-06-12 03:41:51', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTQ5ODAxNDAsImlhdCI6MTY1NDk4MDExMH0.ZNkVerPN0im_ImnT-q8Qxo5wABxOBuu3KMxdsRC8NDyasuXT6Gf04NuccYBT3Ed2JvCE3hIrFirAcEyJwea4sQ', '2022-06-12 03:42:20');
INSERT INTO `token` VALUES (17, '18130094@st.hcmuaf.edu.vn', '2022-06-12 03:45:39', '18130094@st.hcmuaf.edu.vn', '2022-06-12 03:45:39', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTQ5ODAzNjksImlhdCI6MTY1NDk4MDMzOX0.7nR0i2w9qXPlZ9wrObc8VS3l9Dxa3SukSlK4DS9k4A1CCktwIP1C5z-xiH0UdLEhS8RiuKOPtNFdL3Czv88CsA', '2022-06-12 03:46:09');
INSERT INTO `token` VALUES (18, '18130094@st.hcmuaf.edu.vn', '2022-06-12 03:52:39', '18130094@st.hcmuaf.edu.vn', '2022-06-12 03:52:39', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTQ5ODA3ODksImlhdCI6MTY1NDk4MDc1OX0.YZfgkZjoTabxGgnUsybbGfPfzfUCVJUmMFZbFE05BviCfYDEKtsAh7K3ir1ZRxMIgJmh8bUrMVCHzb_29ln-1A', '2022-06-12 03:53:09');
INSERT INTO `token` VALUES (19, '18130094@st.hcmuaf.edu.vn', '2022-06-12 03:58:56', '18130094@st.hcmuaf.edu.vn', '2022-06-12 03:58:56', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTQ5ODExNjYsImlhdCI6MTY1NDk4MTEzNn0.bfgLpa_tD-wwkPxe9etPIBLinI7QTuS8bwyFmILXWgZXq-hg8VmHRUquiWnbqzcJ4fO4qPBAShGAw5-LyTE1RA', '2022-06-12 03:59:26');
INSERT INTO `token` VALUES (20, '18130094@st.hcmuaf.edu.vn', '2022-06-12 04:50:56', '18130094@st.hcmuaf.edu.vn', '2022-06-12 04:50:56', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTQ5ODQyODYsImlhdCI6MTY1NDk4NDI1Nn0.4mhSzSfPOTtTLEKElsloOmNlEY7leslpvNsDItPNSkIfgevm00NMPO0d0RKKiD1NqejVflWsmBHQYdwmJHdpRw', '2022-06-12 04:51:26');
INSERT INTO `token` VALUES (21, '18130094@st.hcmuaf.edu.vn', '2022-06-12 04:51:47', '18130094@st.hcmuaf.edu.vn', '2022-06-12 04:51:47', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTQ5ODQzMzYsImlhdCI6MTY1NDk4NDMwNn0._JJqZByXTT7cSlYoS8t6hJvmeWsE_hDj3zVA6W7fb6I-vofmRZUeLYCE5-A5uisW7QcVEkQiNUZ4hqq32YwhDw', '2022-06-12 04:52:16');
INSERT INTO `token` VALUES (22, '18130094@st.hcmuaf.edu.vn', '2022-06-12 05:43:21', '18130094@st.hcmuaf.edu.vn', '2022-06-12 05:43:21', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTQ5ODc0MzAsImlhdCI6MTY1NDk4NzQwMH0.vQE7X_QqJOVBZo6RXK70BftdYN7_ZZJeRXihNGEuRUxDvzarOoul27avLyWMAop7DQA9GZ2Il_PGnqQd7ajn_A', '2022-06-12 05:43:50');
INSERT INTO `token` VALUES (23, '18130094@st.hcmuaf.edu.vn', '2022-06-12 05:44:49', '18130094@st.hcmuaf.edu.vn', '2022-06-12 05:44:49', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTQ5ODg5MzksImlhdCI6MTY1NDk4NzQ4OX0.q-Gfl0tadKk4mih1ItC9XTy7kX9-jrQ70fphzHsSFJuZZ4qdKNlTXsECyPi9f859dzg855f69IdiMk9ShMRGrA', '2022-06-12 06:08:59');
INSERT INTO `token` VALUES (24, '18130094@st.hcmuaf.edu.vn', '2022-06-12 05:56:21', '18130094@st.hcmuaf.edu.vn', '2022-06-12 05:56:21', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTQ5ODk2MzAsImlhdCI6MTY1NDk4ODE4MH0.rnhnmHxMg1wbqUmXnaXWBLAiKjL-xV_SPR8guLjdf1GB3MkG1HmHjge10Dq2lYPaLDbk-6qw4gu0c6zlAZf3WA', '2022-06-12 06:20:30');
INSERT INTO `token` VALUES (25, '18130094@st.hcmuaf.edu.vn', '2022-06-12 05:57:49', '18130094@st.hcmuaf.edu.vn', '2022-06-12 05:57:49', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTQ5ODk3MTksImlhdCI6MTY1NDk4ODI2OX0.3XKbJJ5cONCv97W-TEz0SeUQSn5AgdtZKPzD7t7HOM5OZvn1eTedUwUjxTBH2u9R9Ft95waDu6Pl9ree1TzCIg', '2022-06-12 06:21:59');
INSERT INTO `token` VALUES (26, '18130094@st.hcmuaf.edu.vn', '2022-06-12 20:50:37', '18130094@st.hcmuaf.edu.vn', '2022-06-12 20:50:37', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNDMyODcsImlhdCI6MTY1NTA0MTgzN30.DEnASvp7hyM2W47gIixLODVIeT2dhaPxl_F_QdH-0jbdsJCtT-4Kn73e4xuJayUZZbZj-xNwfLA8mw0vulVR8w', '2022-06-12 21:14:47');
INSERT INTO `token` VALUES (27, '18130094@st.hcmuaf.edu.vn', '2022-06-12 21:02:18', '18130094@st.hcmuaf.edu.vn', '2022-06-12 21:02:18', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNDM5ODcsImlhdCI6MTY1NTA0MjUzN30.B1Q2RZDBAi8feMCiRhHLgzMF1sBV98XoVmBCW89xY5HSsssPqWWpg3tI2FkVHUZOgqgfLkxWpXRfiG0KdxHhIw', '2022-06-12 21:26:27');
INSERT INTO `token` VALUES (28, '18130094@st.hcmuaf.edu.vn', '2022-06-12 21:03:20', '18130094@st.hcmuaf.edu.vn', '2022-06-12 21:03:20', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNDQwNTAsImlhdCI6MTY1NTA0MjYwMH0.AviHqHnlspjTuRfwYx8YlHkLj6lpLQ3Idl1Ga9_9O92P6e2CUsNlRVQbNBe5jgVbbVvYuufCxwyb7R_mlA2gIQ', '2022-06-12 21:27:30');
INSERT INTO `token` VALUES (29, '18130094@st.hcmuaf.edu.vn', '2022-06-12 21:04:26', '18130094@st.hcmuaf.edu.vn', '2022-06-12 21:04:26', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNDQxMTUsImlhdCI6MTY1NTA0MjY2NX0.8GkdazOlV_vJbdO156GnD2bVLWxWZ7rcMamv5hBYFdQSn5GRcQG9isVVewX3DZsXNhni6U0hPlS-A9IvkLgn2A', '2022-06-12 21:28:35');
INSERT INTO `token` VALUES (30, '18130094@st.hcmuaf.edu.vn', '2022-06-12 21:24:04', '18130094@st.hcmuaf.edu.vn', '2022-06-12 21:24:04', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNDUyOTQsImlhdCI6MTY1NTA0Mzg0NH0._zVWY-w1Nzhu7o8nR7ZyU_yABn6Z4RNiJ33-6SbdfJ9KjfYZX-JAoQbLgNYf_QMbE2w7dR-2VfQ5GHVNkrGS2w', '2022-06-12 21:48:14');
INSERT INTO `token` VALUES (31, '18130094@st.hcmuaf.edu.vn', '2022-06-12 21:26:28', '18130094@st.hcmuaf.edu.vn', '2022-06-12 21:26:28', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNDU0MzgsImlhdCI6MTY1NTA0Mzk4OH0.3rncL4RsAJ4Lj8Y-_AgQWWBZ5TAj62aRCHcS_AKl5kF5nAle-0rTnieIjF-2fl1gKAu_PpYRQ4gh8xzERYzk-g', '2022-06-12 21:50:38');
INSERT INTO `token` VALUES (32, '18130094@st.hcmuaf.edu.vn', '2022-06-12 21:35:10', '18130094@st.hcmuaf.edu.vn', '2022-06-12 21:35:10', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNDU5NTksImlhdCI6MTY1NTA0NDUwOX0.VVXdNHpJI2IrQAJ1DbiwarOsqk411Hp9BKvE-7uPe8QQqq4YyFuvm_0n5hSN4eV4SAb_gUUCvtdsn-qbTdONsA', '2022-06-12 21:59:19');
INSERT INTO `token` VALUES (33, '18130094@st.hcmuaf.edu.vn', '2022-06-12 21:39:05', '18130094@st.hcmuaf.edu.vn', '2022-06-12 21:39:05', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNDYxOTQsImlhdCI6MTY1NTA0NDc0NH0.z8-iP2T3xW47cT1U-mtsQH9n5O0KJiX6FbQ_vQDiikP_jH5fJ56ShMkK_yeNJrFMWSy_hbAAa-xaXWqtQXYoIQ', '2022-06-12 22:03:14');
INSERT INTO `token` VALUES (34, '18130094@st.hcmuaf.edu.vn', '2022-06-12 22:08:11', '18130094@st.hcmuaf.edu.vn', '2022-06-12 22:08:11', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNDc5NDAsImlhdCI6MTY1NTA0NjQ5MH0.oHv-0dxqT1bVb7BfR0s22tK7KtjgNuw9CdG35V5PpMU06dC1P9M2umWFnVtsIRsrMEeLjBmDHF3fjG1Vbcygcg', '2022-06-12 22:32:20');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `created_date` datetime NULL DEFAULT NULL,
  `modified_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `modified_date` datetime NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `full_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'admin', NULL, 'ROLE_ADMIN', NULL, 'admin');
INSERT INTO `user` VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'user', NULL, NULL, NULL, 'huynhgiahuy@gmail.com');
INSERT INTO `user` VALUES (3, '18130094@st.hcmuaf.edu.vn', '2022-06-10 09:18:31', '18130094@st.hcmuaf.edu.vn', '2022-06-10 09:18:31', NULL, NULL, NULL, NULL, NULL, 'admin', NULL, 'ROLE_USER', NULL, 'abv@gmail.com');
INSERT INTO `user` VALUES (27, '18130094@st.hcmuaf.edu.vn', '2022-06-12 01:48:45', '18130094@st.hcmuaf.edu.vn', '2022-06-12 01:48:45', NULL, NULL, 'Huỳnh Gia Huy', NULL, NULL, '$2a$10$owpqm1/mJRky1ZJnYxJMeeqEEzIWq710DvrBS0AFsgu3rxroSffWu', NULL, NULL, NULL, 'huynhgiahuy492@gmail.com');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE,
  INDEX `FKa68196081fvovjhkek5m97n3y`(`role_id` ASC) USING BTREE,
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
