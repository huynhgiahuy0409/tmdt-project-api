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

 Date: 18/06/2022 04:38:39
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
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of brand
-- ----------------------------
INSERT INTO `brand` VALUES (1, NULL, NULL, NULL, NULL, 'ANGRY-BIRD', 'Angry Bird', NULL);
INSERT INTO `brand` VALUES (2, NULL, NULL, NULL, NULL, 'AVENGER', 'Avengers', NULL);
INSERT INTO `brand` VALUES (3, NULL, NULL, NULL, NULL, 'DC', 'DC', NULL);
INSERT INTO `brand` VALUES (4, NULL, NULL, NULL, NULL, 'AMONGUS', 'Among Us', NULL);
INSERT INTO `brand` VALUES (5, NULL, NULL, NULL, NULL, 'AIRHOG', 'Airhog', NULL);
INSERT INTO `brand` VALUES (6, NULL, NULL, NULL, NULL, 'AQUADABRA', 'Aqua Dabra', NULL);
INSERT INTO `brand` VALUES (7, NULL, NULL, NULL, NULL, 'AWESOMEBLOSSOM', 'Awesome Blossom', NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

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
  `brand_id` bigint NULL DEFAULT NULL,
  `product_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKgpextbyee3uk9u6o2381m7ft1`(`product_id` ASC) USING BTREE,
  INDEX `FKhrkf7ckgs6v4gwyxjd63cs8jg`(`brand_id` ASC) USING BTREE,
  CONSTRAINT `FKgpextbyee3uk9u6o2381m7ft1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKhrkf7ckgs6v4gwyxjd63cs8jg` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 77 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES (57, 'anonymousUser', '2022-06-17 06:56:03', 'anonymousUser', '2022-06-17 06:56:03', 'd4b94d73-e1ae-4da7-9118-40f3da4dca65.jpg', NULL, 98);
INSERT INTO `image` VALUES (58, 'anonymousUser', '2022-06-17 06:56:03', 'anonymousUser', '2022-06-17 06:56:03', 'cc118f9c-1565-4f39-85e1-663c8adf7f8a.jpg', NULL, 98);
INSERT INTO `image` VALUES (59, 'anonymousUser', '2022-06-17 06:56:03', 'anonymousUser', '2022-06-17 06:56:03', '739b16d9-2fbb-4d10-a613-c6fb6bacb777.jpg', NULL, 98);
INSERT INTO `image` VALUES (60, 'anonymousUser', '2022-06-17 06:56:03', 'anonymousUser', '2022-06-17 06:56:03', 'de267892-75e0-4ca3-99e6-c73e687ca4b2.jpg', NULL, 98);
INSERT INTO `image` VALUES (61, 'anonymousUser', '2022-06-17 06:56:03', 'anonymousUser', '2022-06-17 06:56:03', '84aaf4d7-3b31-4c0a-b642-617bd4c3a8c6.jpg', NULL, 98);
INSERT INTO `image` VALUES (62, 'anonymousUser', '2022-06-17 06:56:03', 'anonymousUser', '2022-06-17 06:56:03', '6168208d-6619-4f5c-a46d-e8a42ba1ddf1.jpg', NULL, 98);
INSERT INTO `image` VALUES (63, 'anonymousUser', '2022-06-17 06:56:03', 'anonymousUser', '2022-06-17 06:56:03', 'ce224a46-a959-48ee-aa53-8dddb77f47c4.jpg', NULL, 98);
INSERT INTO `image` VALUES (64, 'anonymousUser', '2022-06-17 06:56:03', 'anonymousUser', '2022-06-17 06:56:03', 'ec0b09c5-6647-4e96-9152-b53f11fe8582.jpg', NULL, 98);
INSERT INTO `image` VALUES (65, 'anonymousUser', '2022-06-17 06:59:32', 'anonymousUser', '2022-06-17 06:59:32', '9b33919d-3c73-4198-a742-24de6fa2277a.jpg', NULL, 99);
INSERT INTO `image` VALUES (66, 'anonymousUser', '2022-06-17 06:59:32', 'anonymousUser', '2022-06-17 06:59:32', 'c33aecf7-e912-4aed-a64b-41ef1883ec36.jpg', NULL, 99);
INSERT INTO `image` VALUES (67, 'anonymousUser', '2022-06-17 06:59:32', 'anonymousUser', '2022-06-17 06:59:32', '20da830d-3ba6-432c-b9d0-b5a500954277.jpg', NULL, 99);
INSERT INTO `image` VALUES (68, 'anonymousUser', '2022-06-17 06:59:32', 'anonymousUser', '2022-06-17 06:59:32', 'b8731063-7941-49d5-8d1f-5204e5bc8c2c.jpg', NULL, 99);
INSERT INTO `image` VALUES (69, 'anonymousUser', '2022-06-17 07:01:30', 'anonymousUser', '2022-06-17 07:01:30', '756c0734-aca4-4397-814e-537a5d8b89f8.jpg', NULL, 100);
INSERT INTO `image` VALUES (70, 'anonymousUser', '2022-06-17 07:01:30', 'anonymousUser', '2022-06-17 07:01:30', '3ec4e6ec-9aa4-4106-a4c6-e197dfc4662d.jpg', NULL, 100);
INSERT INTO `image` VALUES (71, 'anonymousUser', '2022-06-17 07:01:30', 'anonymousUser', '2022-06-17 07:01:30', 'bc9cfa8e-ab52-4770-b762-3cfb3d5be328.jpg', NULL, 100);
INSERT INTO `image` VALUES (72, 'anonymousUser', '2022-06-17 07:01:30', 'anonymousUser', '2022-06-17 07:01:30', '44372f8f-7ec5-4b3b-8157-ef90f191ab85.jpg', NULL, 100);
INSERT INTO `image` VALUES (73, 'anonymousUser', '2022-06-17 07:02:49', 'anonymousUser', '2022-06-17 07:02:49', '64f3ab91-51bd-4e4f-a2d2-83db76ae74a3.jpg', NULL, 101);
INSERT INTO `image` VALUES (74, 'anonymousUser', '2022-06-17 07:02:49', 'anonymousUser', '2022-06-17 07:02:49', 'ece0e32b-f599-4779-8e60-62cffb0526f6.jpg', NULL, 101);
INSERT INTO `image` VALUES (75, 'anonymousUser', '2022-06-17 07:02:49', 'anonymousUser', '2022-06-17 07:02:49', 'a5ba7d15-94c8-473a-b3a5-574ca5d2256c.jpg', NULL, 101);
INSERT INTO `image` VALUES (76, 'anonymousUser', '2022-06-17 07:02:49', 'anonymousUser', '2022-06-17 07:02:49', 'e4fa286e-fc4a-41e1-a3e3-833b9fc46a83.jpg', NULL, 101);

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
-- Table structure for origin
-- ----------------------------
DROP TABLE IF EXISTS `origin`;
CREATE TABLE `origin`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `created_date` datetime NULL DEFAULT NULL,
  `modified_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modified_date` datetime NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of origin
-- ----------------------------
INSERT INTO `origin` VALUES (1, NULL, NULL, NULL, NULL, 'TQ', 'Trung quốc');
INSERT INTO `origin` VALUES (2, NULL, NULL, NULL, NULL, 'VN', 'Việt Nam');
INSERT INTO `origin` VALUES (3, NULL, NULL, NULL, NULL, 'TL', 'Thái Lan');

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

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
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `discount_percent` double NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `origin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `repository` int NOT NULL,
  `source_price` double NOT NULL,
  `brand_id` bigint NULL DEFAULT NULL,
  `category_id` bigint NULL DEFAULT NULL,
  `material_id` bigint NULL DEFAULT NULL,
  `recommend_id` bigint NULL DEFAULT NULL,
  `size_id` bigint NULL DEFAULT NULL,
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
) ENGINE = InnoDB AUTO_INCREMENT = 102 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (98, 'anonymousUser', '2022-06-17 06:56:03', 'anonymousUser', '2022-06-17 06:56:03', '98', 'Bức phá giới hạn với xe đua đệm khí siêu mạnh Drone Power Racers. Khả năng tách rời và kết hợp 2 trong 1 siêu linh hoạt giúp Drone Power Racers đạt được tốc độ tới đa khi đua trên mặt đất và bức phá ở những chặng cuối với khả năng bay tăng tốc.', 50, 'Xe đua đệm khí Drone Power Racer', 'TQ', 20, 999000, 5, 1, 2, 5, 110, 1);
INSERT INTO `product` VALUES (99, 'anonymousUser', '2022-06-17 06:59:32', 'anonymousUser', '2022-06-17 06:59:32', '99', 'Among Us là một tựa game online nổi tiếng trên toàn cầu - làm mưa làm gió trong giới trẻ những năm gần đây. Among Us - by Toikido - là sản phẩm đồ chơi với bản quyền chính thức từ game Among Us.\nSưu tập trọn bộ 13 Phi hành gia bí ấn - trong đó có 1 phi hành gia đặc biệt cực hiếm, có thể phát sáng trong đêm.\nMỗi Phi hành gia sẽ đi kèm theo các phụ kiện và chân đế để trưng bày.', 0, 'Phi hành gia bí ẩn Among Us', 'TQ', 20, 279000, 4, 1, 2, 5, 111, 1);
INSERT INTO `product` VALUES (100, 'anonymousUser', '2022-06-17 07:01:30', 'anonymousUser', '2022-06-17 07:01:30', '100', 'Among Us là tựa game online nổi tiếng trên toàn cầu - làm mưa làm gió trong giới trẻ những năm gần đây. Among Us - by Toikido - là sản phẩm đồ chơi với bản quyền chính thức của game Among Us.\nSản phẩm đèn phi hành gia Among Us có kèm pin LR44 (3 viên). Có thể sử dụng ngay.\nĐèn có nút với 2 chế độ sáng vừa và sáng nhẹ. Có thể sử dụng như đèn trang trí, đèn ngủ. Có 4 màu để các bạn tha hồ lựa chọn theo sở thích của mình, gồm: Đỏ, vàng, tím và xanh ngọc', 0, 'Đèn phi hành gia Among Us màu vàng', 'TQ', 20, 299000, 4, 3, 2, 4, 112, 1);
INSERT INTO `product` VALUES (101, 'anonymousUser', '2022-06-17 07:02:49', 'anonymousUser', '2022-06-17 07:02:49', '101', 'Among Us là tựa game online nổi tiếng trên toàn cầu - làm mưa làm gió trong giới trẻ những năm gần đây. Among Us - by Toikido - là sản phẩm đồ chơi với bản quyền chính thức của game Among Us.\nSản phẩm đèn phi hành gia Among Us có kèm pin LR44 (3 viên). Có thể sử dụng ngay.\nĐèn có nút với 2 chế độ sáng vừa và sáng nhẹ. Có thể sử dụng như đèn trang trí, đèn ngủ. Có 4 màu để các bạn tha hồ lựa chọn theo sở thích của mình, gồm: Đỏ, vàng, tím và xanh ngọc', 0, 'Đèn phi hành gia Among Us màu đỏ', 'TQ', 20, 299000, 4, 3, 2, 4, 113, 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of recommend
-- ----------------------------
INSERT INTO `recommend` VALUES (3, NULL, NULL, NULL, NULL, '4-6', '4 đến 6 tuổi');
INSERT INTO `recommend` VALUES (4, NULL, NULL, NULL, NULL, '6-12', '6 đến 11 tuổi');
INSERT INTO `recommend` VALUES (5, NULL, NULL, NULL, NULL, '>12', '12 tuổi trở lên');
INSERT INTO `recommend` VALUES (6, NULL, NULL, NULL, NULL, '0-1', '0 đến 12 tháng');
INSERT INTO `recommend` VALUES (7, NULL, NULL, NULL, NULL, '1-3', '1 đến 3 tuổi');

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
  `weight` double NOT NULL,
  `width` double NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 114 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of size
-- ----------------------------
INSERT INTO `size` VALUES (110, 'anonymousUser', '2022-06-17 06:56:03', 'anonymousUser', '2022-06-17 06:56:03', 40, 40, 500, 40);
INSERT INTO `size` VALUES (111, 'anonymousUser', '2022-06-17 06:59:32', 'anonymousUser', '2022-06-17 06:59:32', 40, 40, 500, 40);
INSERT INTO `size` VALUES (112, 'anonymousUser', '2022-06-17 07:01:30', 'anonymousUser', '2022-06-17 07:01:30', 40, 40, 500, 40);
INSERT INTO `size` VALUES (113, 'anonymousUser', '2022-06-17 07:02:49', 'anonymousUser', '2022-06-17 07:02:49', 40, 40, 500, 40);

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
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of token
-- ----------------------------

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------

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
