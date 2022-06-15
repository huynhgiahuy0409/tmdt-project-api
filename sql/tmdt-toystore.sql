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

 Date: 15/06/2022 19:57:35
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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of brand
-- ----------------------------
INSERT INTO `brand` VALUES (1, NULL, NULL, NULL, NULL, 'ANGRY-BIRD', 'Angry Bird', NULL);
INSERT INTO `brand` VALUES (2, NULL, NULL, NULL, NULL, 'AVENGER', 'Avengers', NULL);
INSERT INTO `brand` VALUES (3, NULL, NULL, NULL, NULL, 'DC', 'DC', NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, NULL, NULL, NULL, NULL, 'moive-toy', 'Đồ chơi theo phim');
INSERT INTO `category` VALUES (2, NULL, NULL, NULL, NULL, 'bulding-toy', 'Đồ chơi lắp ghép');
INSERT INTO `category` VALUES (3, NULL, NULL, NULL, NULL, 'fashion-toy', 'Đồ chơi thời trang');
INSERT INTO `category` VALUES (4, NULL, NULL, NULL, NULL, 'dolly', 'Búp Bê');
INSERT INTO `category` VALUES (5, NULL, NULL, NULL, NULL, 'robot', 'Robot');
INSERT INTO `category` VALUES (6, NULL, NULL, NULL, NULL, 'bicycle-scooter', 'Xe đạp & scooter');
INSERT INTO `category` VALUES (7, NULL, NULL, NULL, NULL, 'school-supplies', 'Đồ dùng học tập');
INSERT INTO `category` VALUES (8, NULL, NULL, NULL, NULL, 'kindergaten-toy', 'Đồ chơi mầm non');
INSERT INTO `category` VALUES (9, NULL, NULL, NULL, NULL, 'vehicle-toy', 'Đồ chơi phương tiện');
INSERT INTO `category` VALUES (10, NULL, NULL, NULL, NULL, 'creative-toy', 'Đồ chơi sáng tạo');
INSERT INTO `category` VALUES (11, NULL, NULL, NULL, NULL, 'simulation-toy', 'Đồ chơi mô phỏng');
INSERT INTO `category` VALUES (12, NULL, NULL, NULL, NULL, 'activity-toy', 'Đồ chơi vận động');
INSERT INTO `category` VALUES (13, NULL, NULL, NULL, NULL, 'game', 'Game');
INSERT INTO `category` VALUES (14, NULL, NULL, NULL, NULL, 'flying-toy', 'Đồ chơi bay');
INSERT INTO `category` VALUES (15, NULL, NULL, NULL, NULL, 'animal-worl', 'Thế giới động vật');
INSERT INTO `category` VALUES (16, NULL, NULL, NULL, NULL, 'baby-item', 'Đồ dùng cho bé');
INSERT INTO `category` VALUES (17, NULL, NULL, NULL, NULL, 'teddy', 'Thú bông');
INSERT INTO `category` VALUES (18, NULL, NULL, NULL, NULL, 'toy-candy', 'Kẹo đồ chơi');

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

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
  `brand_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKgpextbyee3uk9u6o2381m7ft1`(`product_id` ASC) USING BTREE,
  INDEX `FKhrkf7ckgs6v4gwyxjd63cs8jg`(`brand_id` ASC) USING BTREE,
  CONSTRAINT `FKgpextbyee3uk9u6o2381m7ft1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKhrkf7ckgs6v4gwyxjd63cs8jg` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of material
-- ----------------------------
INSERT INTO `material` VALUES (1, NULL, NULL, NULL, NULL, 'ABS', 'ABS');
INSERT INTO `material` VALUES (2, NULL, NULL, NULL, NULL, 'PE', 'PE');
INSERT INTO `material` VALUES (3, NULL, NULL, NULL, NULL, 'PP', 'PP');
INSERT INTO `material` VALUES (4, NULL, NULL, NULL, NULL, 'POM', 'POM');
INSERT INTO `material` VALUES (5, NULL, NULL, NULL, NULL, 'PET', 'PET');

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

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
  `discount_percent` double NOT NULL,
  `source_price` double NOT NULL,
  `recommend_id` bigint NULL DEFAULT NULL,
  `status_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKs6cydsualtsrprvlf2bb3lcam`(`brand_id` ASC) USING BTREE,
  INDEX `FK1mtsbur82frn64de7balymq9s`(`category_id` ASC) USING BTREE,
  INDEX `FKw04fq456sc4tk26tnbhvr59o`(`material_id` ASC) USING BTREE,
  INDEX `FKh1dt3psyi40p0njd9es1l2wpm`(`recommend_id` ASC) USING BTREE,
  INDEX `FKsccbu8jiglqc6t5tjsp04amv7`(`size_id` ASC) USING BTREE,
  INDEX `FK8556hocjcb04st51nt8yknfbg`(`status_id` ASC) USING BTREE,
  CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKh1dt3psyi40p0njd9es1l2wpm` FOREIGN KEY (`recommend_id`) REFERENCES `recommend` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKs6cydsualtsrprvlf2bb3lcam` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKsccbu8jiglqc6t5tjsp04amv7` FOREIGN KEY (`size_id`) REFERENCES `size` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKw04fq456sc4tk26tnbhvr59o` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK8556hocjcb04st51nt8yknfbg` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of product
-- ----------------------------

-- ----------------------------
-- Table structure for recommend
-- ----------------------------
DROP TABLE IF EXISTS `recommend`;
CREATE TABLE `recommend`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `created_date` datetime NULL DEFAULT NULL,
  `modified_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `modified_date` datetime NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of recommend
-- ----------------------------
INSERT INTO `recommend` VALUES (1, NULL, NULL, NULL, NULL, '<6', 'Dưới 6 tuổi');
INSERT INTO `recommend` VALUES (2, NULL, NULL, NULL, NULL, '>=6', '6 tuổi trở lên');

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

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
  `weight` double NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of size
-- ----------------------------

-- ----------------------------
-- Table structure for status
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `created_date` datetime NULL DEFAULT NULL,
  `modified_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `modified_date` datetime NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of status
-- ----------------------------
INSERT INTO `status` VALUES (1, NULL, NULL, NULL, NULL, 'new', 'Mới');
INSERT INTO `status` VALUES (2, NULL, NULL, NULL, NULL, 'like-new', 'Như mới');

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
) ENGINE = InnoDB AUTO_INCREMENT = 82 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of token
-- ----------------------------
INSERT INTO `token` VALUES (37, 'anonymousUser', '2022-06-13 02:15:33', 'anonymousUser', '2022-06-13 02:15:33', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNjI3ODMsImlhdCI6MTY1NTA2MTMzM30.8GC2vbbOcRJD9Jqq0eE4NPR90LqYyohrR_IlQWsrc-4rZveO0-fjE-CfaQ73hN49842qR6vqRd08DUyWUBiFxA', '2022-06-13 02:39:43');
INSERT INTO `token` VALUES (38, 'anonymousUser', '2022-06-13 02:19:20', NULL, '2022-06-13 02:36:30', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNjQwNDAsImlhdCI6MTY1NTA2MjU5MH0.JGOHPlLwIFZc3zuwAWGehGKwqSVUyBqZMKcn7zvZyr9y_ebL6oX7QXvbzdW2af_KOtwDaiQCcNT_EGPDKcyBZA', '2022-06-13 03:00:40');
INSERT INTO `token` VALUES (39, 'anonymousUser', '2022-06-13 03:01:24', NULL, '2022-06-13 03:01:30', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNjU1MzksImlhdCI6MTY1NTA2NDA4OX0.K8G2H60LONQZMDeZMrgoJe_1YituVy2myXmknQ_7GX6en7zyLasZ-C5pwtXg6kt4FpDPosQ2GuejWE2tKZvjJg', '2022-06-13 03:25:39');
INSERT INTO `token` VALUES (40, 'anonymousUser', '2022-06-13 03:03:38', NULL, '2022-06-13 03:03:43', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNjU2NzMsImlhdCI6MTY1NTA2NDIyM30.km72wRMGYv3HM6cqw3mvIjfjos2K1n-1CxbOJTgQStnyqXng_2_jN2nEDCDRAvXdTvbNd7aAMGRMcF5QBVowcQ', '2022-06-13 03:27:53');
INSERT INTO `token` VALUES (41, 'anonymousUser', '2022-06-13 03:06:03', NULL, '2022-06-13 03:06:08', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNjU4MTgsImlhdCI6MTY1NTA2NDM2OH0.qKRdneOQEhUlQJk8tYpuxaxW3HgMq7OmvXx72J-Cs6jagX_JBElFdOORpfYCWlUKzfwJ00quTMHTRVQ4RhaVZg', '2022-06-13 03:30:18');
INSERT INTO `token` VALUES (42, 'anonymousUser', '2022-06-13 03:11:33', NULL, '2022-06-13 03:11:37', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNjYxNDcsImlhdCI6MTY1NTA2NDY5N30.A9cNWarLvmIgP6kyNFXP_w6ynyMGyqkg77RlqIUWgvtVWa4BTK38VE37YT2wJRdDZeRC0OOgc-NlEFDs2Alkfg', '2022-06-13 03:35:47');
INSERT INTO `token` VALUES (43, 'anonymousUser', '2022-06-13 03:12:08', NULL, '2022-06-13 03:12:13', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNjYxODMsImlhdCI6MTY1NTA2NDczM30.TBs6f80csezBXD8IAitNCPLXt3d4Ni4rJqwov72nINAVGHREZue-azNstxCtRVky9DKvpts0KMq7Nhf1yx7Ubw', '2022-06-13 03:36:23');
INSERT INTO `token` VALUES (44, 'anonymousUser', '2022-06-13 03:15:56', NULL, '2022-06-13 03:16:01', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNjY0MTEsImlhdCI6MTY1NTA2NDk2MX0.OFd_4EHq8e5ZZtjZ06fnYFmYS56rElVCV4YV-d3BqvP-9ggHG8f5JIosel_xA_4TgBOHvxXhaJk5y16-NOjxkQ', '2022-06-13 03:40:11');
INSERT INTO `token` VALUES (45, 'anonymousUser', '2022-06-13 03:17:33', NULL, '2022-06-13 03:17:47', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNjY1MjcsImlhdCI6MTY1NTA2NTA2N30.gohH0lascE9xt0__1u_qKA3dl1_vRq5nvrFR5igGxH5yAbGN3VhiRRKPXPWvnoBTWj7PHyrT1QJb0_0_rknKLg', '2022-06-13 03:42:07');
INSERT INTO `token` VALUES (46, 'anonymousUser', '2022-06-13 03:19:36', NULL, '2022-06-13 03:28:24', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNjcxNjMsImlhdCI6MTY1NTA2NTcwM30.tn7YYJycfdLrMa-2gW3dFba8N05hUOHKRFGdM4FduhLEGgR_lSxkrVIfq2sKtoedtugITRyZ4Dd1tpR24tHIzw', '2022-06-13 03:52:43');
INSERT INTO `token` VALUES (47, 'anonymousUser', '2022-06-13 03:26:21', NULL, '2022-06-13 03:26:35', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNjcwNTUsImlhdCI6MTY1NTA2NTU5NX0.YM53VfUWkEQm6vs967pmAXwJiqe25N3uwzjE8pyzZ1P9OfLEu5y8WAwDnjtAiFshne1pNIR3L37veaOqufSujg', '2022-06-13 03:50:55');
INSERT INTO `token` VALUES (48, 'anonymousUser', '2022-06-13 03:35:58', NULL, '2022-06-13 03:36:13', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNjc2MzMsImlhdCI6MTY1NTA2NjE3M30.EX_b3CPrgkuxuCtUIozfqBMWo2tbVL2BqRSS68_Uk3M1q1I7o_i_zBCiT5X3FZa9F_qdPdLEK92Hvox8oVKY_Q', '2022-06-13 04:00:33');
INSERT INTO `token` VALUES (49, 'anonymousUser', '2022-06-13 03:39:06', NULL, '2022-06-13 03:39:20', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNjc4MjAsImlhdCI6MTY1NTA2NjM2MH0.uB749V5W4y6onN631nDCfqmHmrL5A-y_N_PEQKwP_5lUYd5UIAPP7p1mHfTvyGqo1TIAGz0ol9iu3wMv_zWOqQ', '2022-06-13 04:03:40');
INSERT INTO `token` VALUES (50, 'anonymousUser', '2022-06-13 03:40:15', NULL, '2022-06-13 03:40:29', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNjc4ODksImlhdCI6MTY1NTA2NjQyOX0.DVxgqPvoJqvou1LUUPepn_TpG2fLJCkAl_-aZ2pLnCg8mefHUfzxaWGsLWPbPpqDTQC3ECuvflAYJhk0Pny-6g', '2022-06-13 04:04:49');
INSERT INTO `token` VALUES (51, 'anonymousUser', '2022-06-13 03:42:26', NULL, '2022-06-13 03:42:40', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNjgwMjAsImlhdCI6MTY1NTA2NjU2MH0._Zf0KncxL2j5CwgzMluDnx7rlrPCxxQZ69QrNOY87MGdd21TNMcSiyjbKtv2RTX5yjFQQbBI5Pcra8hEtkVBJA', '2022-06-13 04:07:00');
INSERT INTO `token` VALUES (52, 'anonymousUser', '2022-06-13 05:03:07', 'anonymousUser', '2022-06-13 05:03:07', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNzI4NDYsImlhdCI6MTY1NTA3MTM4Nn0.WADB7EoGXyRA73nog1DlPKLrYlUwFC1tNAvrsTIKky_b7wSsQn8xO3SuqQJp646ET8TRytPF6FAQofRV5DE9Ng', '2022-06-13 05:27:26');
INSERT INTO `token` VALUES (53, 'anonymousUser', '2022-06-13 05:03:23', 'anonymousUser', '2022-06-13 05:03:23', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNzI4NjMsImlhdCI6MTY1NTA3MTQwM30.OkCq02172YL_gqIlbM2_sFktwNc--HTApSYb5pggnpqWTluz1Ukwkaonsam9fmdiHA5kHtkR3XLJPFqVcTSIUg', '2022-06-13 05:27:43');
INSERT INTO `token` VALUES (54, 'anonymousUser', '2022-06-13 05:03:24', 'anonymousUser', '2022-06-13 05:03:24', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNzI4NjQsImlhdCI6MTY1NTA3MTQwNH0.IGeOpxeX-rD96s7tzaCOWzanXiULmHWJYzbI15c9yQEL-8E62Q-qGSI---wN05SWZyHSn_bJy3BY84AK3rkPkQ', '2022-06-13 05:27:44');
INSERT INTO `token` VALUES (55, 'anonymousUser', '2022-06-13 05:05:06', 'anonymousUser', '2022-06-13 05:05:06', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNzI5NjUsImlhdCI6MTY1NTA3MTUwNX0.vzHZ3mvsbJpWGZht7zMAsth0NUzeqV7OrcwtJkmO_V5m9ZziV6rp5rP-7nepC6NootWuzEz8fjkLXOyfH76d0g', '2022-06-13 05:29:25');
INSERT INTO `token` VALUES (56, 'anonymousUser', '2022-06-13 05:06:23', NULL, '2022-06-13 05:15:00', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNzM1NTksImlhdCI6MTY1NTA3MjA5OX0.sy2MMuJ9J1q9zbnms2xhuzd9QQ8RxPZK-xWysl8RSu6b3k0-9HY87-F44G51mBlm3QX9r7_y325AldfWOIFn-A', '2022-06-13 05:39:19');
INSERT INTO `token` VALUES (57, 'anonymousUser', '2022-06-13 05:18:53', NULL, '2022-06-13 05:19:07', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNzM4MDcsImlhdCI6MTY1NTA3MjM0N30.3jmzkMzWU_elSDirFQdtYO1Ek3NkBLKZBpgQR4ElO4-1ZObyWnqKY0kr6mZws4D4J_zyKRkkcpbexJQfxCvJ2g', '2022-06-13 05:43:27');
INSERT INTO `token` VALUES (58, 'anonymousUser', '2022-06-13 05:34:05', NULL, '2022-06-13 05:34:20', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNzQ3MjAsImlhdCI6MTY1NTA3MzI2MH0.kQraLiMw2HvC6hyGuPsUt1F0TciMeLLQH92_xlUuBpK40W1-tV-nnkLpaKVjsmBGqN80CB3CbNE5orEb0jqLRA', '2022-06-13 05:58:40');
INSERT INTO `token` VALUES (59, 'anonymousUser', '2022-06-13 05:38:03', NULL, '2022-06-13 05:38:18', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNzQ5NTgsImlhdCI6MTY1NTA3MzQ5OH0.ltHumHZOY4nK8uVvl_alP5ARvQ4ubyyS551onYhqmsSWx5g3Yb9GJtHWOosCZwmViiomtFF9W164tv0tHkGyWw', '2022-06-13 06:02:38');
INSERT INTO `token` VALUES (60, 'anonymousUser', '2022-06-13 05:48:53', NULL, '2022-06-13 05:58:04', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNzYxNDMsImlhdCI6MTY1NTA3NDY4M30.R0tmZd1l53OfeMzMpJ1rfz2wXDPIwS1dpRF0GRxDbRIA-5pmggPsGFtvIQNFdN2PJwI-g70ddrLbE7yy1DLxkA', '2022-06-13 06:22:23');
INSERT INTO `token` VALUES (61, NULL, '2022-06-13 06:09:40', NULL, '2022-06-13 06:10:23', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUwNzY4ODMsImlhdCI6MTY1NTA3NTQyM30.y7Tc10u2viO1A3hXSsdpdByKgMQ0-VkwbQyfmMgj-nyLL6FQF16xRHQ4ZHUSE0JttpLWFAVCDwUvGlONXkKE6g', '2022-06-13 06:34:43');
INSERT INTO `token` VALUES (62, 'anonymousUser', '2022-06-13 15:40:33', NULL, '2022-06-13 15:53:14', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUxMTE4NTQsImlhdCI6MTY1NTExMDM5NH0.WbrjR_oxoeC0SeIZAGIjemI_ib79qjdH39v0Gv8_jXAzfNfQDDyT1p5zYI09-kZoMlpUo0vzOGZtqNzUxLv26g', '2022-06-13 16:17:34');
INSERT INTO `token` VALUES (63, NULL, '2022-06-13 15:50:10', NULL, '2022-06-13 15:50:10', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUxMTE2NzAsImlhdCI6MTY1NTExMDIxMH0.DtyZ6u5JqFei03Vf9xom25RnSyFQCaO-JdlfVxNfiNRN20LHU6P0rXJTLYAhed11DMsZN290LIaC5NXgfmwaUw', '2022-06-13 16:14:30');
INSERT INTO `token` VALUES (64, NULL, '2022-06-13 15:53:35', NULL, '2022-06-13 16:14:09', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUxMTMxMDgsImlhdCI6MTY1NTExMTY0OH0.TG_b2vDWn3A_KLOpPZsbnOeiczEDGw9qvZ9ctkirXEYNGlxcffNo8iQhrSKpxjJAZQU9nZ1cO7lopsQUdZ7LNw', '2022-06-13 16:38:28');
INSERT INTO `token` VALUES (65, 'anonymousUser', '2022-06-13 16:19:25', 'anonymousUser', '2022-06-13 16:19:25', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUxMTM0MjUsImlhdCI6MTY1NTExMTk2NX0.HL0Rz49kpwrG6ngEovZCSNXSFWmer-_Fku8EcxBoTA5HilaaJoVre35ft4tFNAcpLrfrAvBh8oKo4fL6DH8CTQ', '2022-06-13 16:43:45');
INSERT INTO `token` VALUES (66, 'anonymousUser', '2022-06-13 16:21:53', NULL, '2022-06-13 16:22:07', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUxMTM1ODcsImlhdCI6MTY1NTExMjEyN30._0HV7aJ3l8Sqkl_ijmJ5KUc-r1BVsV4fAx2fisGLLzp575yYyTyl3_cjBOoLXC7jxgwXZ1FHpMZEWz9rRDZ-1A', '2022-06-13 16:46:27');
INSERT INTO `token` VALUES (67, 'anonymousUser', '2022-06-13 16:30:57', NULL, '2022-06-13 16:31:28', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUxMTQxNDcsImlhdCI6MTY1NTExMjY4N30.rXB94lhY_KMhmnGQ3HpKK9ITpmrhF3F3TwTEWLPJBc0q6Ymm5y4GPUkj03boIdD_YLHtYiENsf6B1MO_hzUrmg', '2022-06-13 16:55:47');
INSERT INTO `token` VALUES (68, 'anonymousUser', '2022-06-13 16:33:12', NULL, '2022-06-13 16:33:26', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUxMTQyNjYsImlhdCI6MTY1NTExMjgwNn0.aEX8MHZwk-tNrlM5Wpbq-FbN4MASt6ZEl89JeOk66xLxFOsIMTYvzt5nw-m7wm3aFQuZJ6ylKyxikgYpFy0J3w', '2022-06-13 16:57:46');
INSERT INTO `token` VALUES (69, 'anonymousUser', '2022-06-13 16:34:48', NULL, '2022-06-13 16:35:06', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUxMTQzNjUsImlhdCI6MTY1NTExMjkwNX0.vB9w6pAMCPkkmHmrnWVUP2847XVrXpLLFl8pIVjqe0x_NdobMFm9j9uwd8Ev0FoTdTeCWbu_BKCIbH_EJafURw', '2022-06-13 16:59:25');
INSERT INTO `token` VALUES (70, 'anonymousUser', '2022-06-13 16:35:41', NULL, '2022-06-13 16:42:20', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUxMTQ3OTksImlhdCI6MTY1NTExMzMzOX0.7wc5LwDjR4Zqg4aR6iToCxfQMiHSJoRXmP1f_g15bv1b1Rhm90vzhldH109pFD3XQwL0VRmcVMkCBva0_j-qxw', '2022-06-13 17:06:39');
INSERT INTO `token` VALUES (71, NULL, '2022-06-13 16:48:54', NULL, '2022-06-13 16:48:54', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUxMTUxOTMsImlhdCI6MTY1NTExMzczM30.TvnEYDCYouXPUQblZyu2Mz9Y9X6xCzHmQCdncG5egD31BmcZqymoUjQ-_aj4zoEy2yCU_kKDBemMewjkgSnvMg', '2022-06-13 17:13:13');
INSERT INTO `token` VALUES (72, 'anonymousUser', '2022-06-13 16:52:02', 'anonymousUser', '2022-06-13 16:52:02', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUxMTUzODIsImlhdCI6MTY1NTExMzkyMn0.Q7NuoONLXxUZRmIauKHWcbCQVzORhwoG2HefPd2LdqM42DlVfRNN-Y2QYg72ubSqEHzhxDxwBeR8i6nVAy4xAw', '2022-06-13 17:16:22');
INSERT INTO `token` VALUES (73, 'anonymousUser', '2022-06-13 16:54:32', 'anonymousUser', '2022-06-13 16:54:32', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUxMTU1MzEsImlhdCI6MTY1NTExNDA3MX0.ADBXpI4oYivU1-hi8wYG0Ywlit9kcAwI4GGXRB_97TjOcDc6CfbtiS1FZjix-e9lteu1yHA5T3Yg69p31rq0Dw', '2022-06-13 17:18:51');
INSERT INTO `token` VALUES (78, 'anonymousUser', '2022-06-13 22:24:13', 'anonymousUser', '2022-06-13 22:24:13', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUxMzUzMTIsImlhdCI6MTY1NTEzMzg1Mn0.12n0wsb9xJwtSE8R5eT3uJ5qXvyLiH8ydJwzvneqXAv2Gsz1LEQ1KBD1D7Dgb3oOqcCh82Xnev4L33F7LwwTCw', '2022-06-13 22:48:32');
INSERT INTO `token` VALUES (79, 'anonymousUser', '2022-06-13 22:24:24', 'anonymousUser', '2022-06-13 22:24:24', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUxMzUzMjMsImlhdCI6MTY1NTEzMzg2M30.mE1I4l8hvW1iT_RhHuOZQRvkV4VsUE0jEdAxYLAfhPZ3Hh_lWUEdh-vhp2vj15C-nv3s9mgFMWTUaj6za-TV1w', '2022-06-13 22:48:43');
INSERT INTO `token` VALUES (80, 'anonymousUser', '2022-06-13 22:28:33', 'anonymousUser', '2022-06-13 22:28:33', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXluaGdpYWh1eTQ5MkBnbWFpbC5jb20iLCJleHAiOjE2NTUxMzU1NzMsImlhdCI6MTY1NTEzNDExM30.UKHNk048ipSKXbJJSorbavmdkvUY7f2-itBR9qHAMTN4df4ij-9dD0GQWw0dJmj6Ns2CzeNgMtzbaTNif8CnOA', '2022-06-13 22:52:53');

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
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'admin', NULL, 'ROLE_ADMIN', NULL, 'admin');
INSERT INTO `user` VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'user', NULL, NULL, NULL, 'huynhgiahuy@gmail.com');
INSERT INTO `user` VALUES (30, 'anonymousUser', '2022-06-13 22:19:58', 'anonymousUser', '2022-06-13 22:19:58', NULL, NULL, 'Huynh Gia Huy', NULL, NULL, '$2a$10$AlGYYUTm9rwyGbCZVdIuiOVSy5rblyJQBWzIMjMI4I./YX4lC4CqK', NULL, NULL, NULL, 'huynhgiahuy492@gmail.com');

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_role
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
