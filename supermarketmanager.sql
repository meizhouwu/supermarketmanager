/*
 Navicat Premium Data Transfer

 Source Server         : 本地Mysql
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : supermarketmanager

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 22/04/2023 18:41:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (1, 'root', '123456', 'Admin', '超级管理员');

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES (1, '厨具', '厨具');
INSERT INTO `t_category` VALUES (2, '餐具', '餐具');
INSERT INTO `t_category` VALUES (3, '家用电器', '电视机、冰箱、洗衣机等');
INSERT INTO `t_category` VALUES (4, '家具', '家具');
INSERT INTO `t_category` VALUES (5, '卫浴', '卫生间用品');
INSERT INTO `t_category` VALUES (6, '粮油', '粮油');
INSERT INTO `t_category` VALUES (7, '零食', '零食');
INSERT INTO `t_category` VALUES (8, '宠物用品', '宠物用品');

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES (1, '张三', '19898989898', '四川成都市武侯区', '2023-04-19 12:50:07', NULL);
INSERT INTO `t_customer` VALUES (2, '李四', '17878787878', '四川成都市成华区', '2023-04-19 12:50:32', '2023-04-19 12:50:34');
INSERT INTO `t_customer` VALUES (3, '王五', '16767677676', '四川成都市双流区', '2023-04-19 12:58:22', '2023-04-19 12:58:25');
INSERT INTO `t_customer` VALUES (4, '赵六', '16556566565', '四川成都市郫都区', '2023-04-19 12:58:56', '2023-04-19 12:58:58');
INSERT INTO `t_customer` VALUES (5, '钱七', '15445454545', '四川成都市金牛区', '2023-04-19 12:59:43', '2023-04-19 12:59:46');
INSERT INTO `t_customer` VALUES (6, '王八', '14334343433', '四川成都市高新区', '2023-04-19 13:00:23', NULL);

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_sn` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单唯一编号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '订单日期',
  `total_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单总价',
  `state` int(11) NULL DEFAULT NULL COMMENT '订单状态：1已完成，0待支付，-1取消',
  `customer_id` bigint(20) NULL DEFAULT NULL COMMENT '顾客id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES (1, 'CD-2012021665008', '2023-04-19 13:01:51', 568.50, 1, 1);
INSERT INTO `t_order` VALUES (2, 'CD-2012021673676', '2023-04-19 13:08:08', 1128.34, -1, 2);
INSERT INTO `t_order` VALUES (3, 'CD-2012021665938', '2023-04-19 13:08:41', 56.00, 0, 1);
INSERT INTO `t_order` VALUES (4, 'CD-2012021667676', '2023-04-19 13:11:29', 88.60, 1, 4);
INSERT INTO `t_order` VALUES (5, 'CD-2012021633422', '2023-04-05 13:11:51', 128.80, 1, 5);
INSERT INTO `t_order` VALUES (6, 'CD-2012021322090', '2023-03-28 13:19:19', 665.00, 0, 3);
INSERT INTO `t_order` VALUES (7, 'CD-2012021676763', '2023-06-26 13:19:49', 8500.00, 1, 2);
INSERT INTO `t_order` VALUES (8, 'CD-2012021222900', '2015-06-19 13:20:24', 6350.00, 0, 2);
INSERT INTO `t_order` VALUES (9, 'CD-2012021393920', '2023-05-15 13:20:52', 3490.00, 1, 4);
INSERT INTO `t_order` VALUES (10, 'CD-2012021339009', '2023-04-19 13:21:14', 1200.00, -1, 4);

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品编码',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `price` double NULL DEFAULT NULL COMMENT '商品价格',
  `stock` int(11) NULL DEFAULT NULL COMMENT '商品库存',
  `category_id` bigint(20) NULL DEFAULT NULL COMMENT '商品分类',
  `supplier_id` bigint(20) NULL DEFAULT NULL COMMENT '供应商',
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO `t_product` VALUES (1, 'HXTV11-028765', '海信电视H11', 6500, 30, 3, 3, '85寸超大屏电视');
INSERT INTO `t_product` VALUES (2, 'CWTV22-028676', '创维电视P22', 7500, 20, 3, 3, '创维电视');
INSERT INTO `t_product` VALUES (3, 'PT33-7363536', '剔骨刀A33', 200, 100, 1, 4, '砍死它-骨头');
INSERT INTO `t_product` VALUES (4, 'PT44-6553636', '高压锅B44', 430, 50, 1, 4, '炖排骨');
INSERT INTO `t_product` VALUES (5, 'TC55-YUE7888', '陶瓷餐具套装C55', 560, 30, 2, 2, '吃饭的家伙');
INSERT INTO `t_product` VALUES (6, 'PT66-YU67677', '403不锈钢盆', 68, 20, 2, 2, '盆');
INSERT INTO `t_product` VALUES (7, 'SHE-YI783222', '上下床N77', 340, 10, 4, 8, '经久耐用');
INSERT INTO `t_product` VALUES (8, 'DESKTOP7847', '实木餐桌K90', 3450, 20, 4, 8, '10人圆桌');
INSERT INTO `t_product` VALUES (9, 'HS11-8837833', '多功能花洒L11', 350, 100, 5, 6, '好用');
INSERT INTO `t_product` VALUES (10, 'MT33-6767733', '高颜值马桶', 600, 20, 5, 6, '飘飘欲仙的感觉');
INSERT INTO `t_product` VALUES (11, 'XC44-9898933', '俄罗斯大香肠', 50, 30, 6, 1, '风味十足');
INSERT INTO `t_product` VALUES (12, 'XM77-7363838', '泰国香米', 45, 44, 6, 1, '保质保量');
INSERT INTO `t_product` VALUES (13, 'HS88-9822321', '酒鬼花生Y88', 18, 300, 7, 7, '花生还是那个花生');
INSERT INTO `t_product` VALUES (14, 'JT99-7878362', '盐焗鸡腿U99', 20, 34, 7, 7, '香得很');
INSERT INTO `t_product` VALUES (15, 'MS02-3374888', '猫砂R02', 40, 89, 8, 5, '推荐使用');
INSERT INTO `t_product` VALUES (18, 'MW67-3837878', '皇家三层猫屋', 430, 39, 8, 5, '颜值相当高');

-- ----------------------------
-- Table structure for t_supplier
-- ----------------------------
DROP TABLE IF EXISTS `t_supplier`;
CREATE TABLE `t_supplier`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商编码',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商名称',
  `contact` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '练习电话',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_supplier
-- ----------------------------
INSERT INTO `t_supplier` VALUES (1, 'CD-WHH112334', '娃哈哈粮油公司', '刘三农', '15653535242', '四川成都', '2023-04-04 13:53:33');
INSERT INTO `t_supplier` VALUES (2, 'DZ-LX44532222', '吃得香餐具', '张二炮', '15244252552', '四川达州', '2022-06-16 13:55:19');
INSERT INTO `t_supplier` VALUES (3, 'ZG-LP22899982', '老板电器', '王大花', '12788776333', '四川自贡', '2023-01-06 13:57:29');
INSERT INTO `t_supplier` VALUES (4, 'MY-HK8977373', '好看厨具', '代小丽', '14557282722', '四川绵阳', '2023-02-15 13:58:52');
INSERT INTO `t_supplier` VALUES (5, 'DY-CW3333333', '宠物乐园', '赵一丿', '13556564533', '四川德阳', '2019-06-01 14:57:14');
INSERT INTO `t_supplier` VALUES (6, 'NC-XSS555555', '洗刷刷有限公司', '李小凤', '13654546353', '四川南充', '2024-06-19 15:00:13');
INSERT INTO `t_supplier` VALUES (7, 'WW-DGG8787', '顶呱呱食品有限公司', '托马斯', '13764545463', '四川万源', '2020-07-19 15:04:37');
INSERT INTO `t_supplier` VALUES (8, 'ZY-JJ9383743', '家家乐家具', '五连鞭', '13862526262', '四川资阳', '2022-08-19 17:28:25');

-- ----------------------------
-- Table structure for t_system_log
-- ----------------------------
DROP TABLE IF EXISTS `t_system_log`;
CREATE TABLE `t_system_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `operation_id` bigint(20) NULL DEFAULT NULL COMMENT '操作人-关联admin表',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日志内容',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_system_log
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
