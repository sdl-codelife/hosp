/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : hosp

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 23/02/2020 14:28:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_banner
-- ----------------------------
DROP TABLE IF EXISTS `t_banner`;
CREATE TABLE `t_banner` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_banner
-- ----------------------------
BEGIN;
INSERT INTO `t_banner` VALUES (36, 'ss', 'http://127.0.0.1:8787/static/upload/images/87ec1bc9-ae21-4cad-b2ce-22e70071475d.jpg');
INSERT INTO `t_banner` VALUES (37, 'ss', 'http://127.0.0.1:8787/static/upload/images/44e9d7b5-178a-4cda-99d0-cf465ec86f69.jpg');
COMMIT;

-- ----------------------------
-- Table structure for t_medicine
-- ----------------------------
DROP TABLE IF EXISTS `t_medicine`;
CREATE TABLE `t_medicine` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '药品编号',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '药品图片',
  `name` varchar(32) NOT NULL COMMENT '药品名称',
  `price` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `date` varchar(50) DEFAULT NULL COMMENT '生产日期',
  `type` varchar(32) DEFAULT NULL COMMENT '包装规格',
  `num` int DEFAULT NULL COMMENT '库存数量',
  `note` varchar(255) DEFAULT NULL COMMENT '药品描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_medicine
-- ----------------------------
BEGIN;
INSERT INTO `t_medicine` VALUES (1, NULL, '阿莫西林', 18.01, '2020-02-04', '20 粒/盒', 40, '消炎药');
INSERT INTO `t_medicine` VALUES (6, NULL, '试试', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_medicine` VALUES (7, NULL, '试试', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_medicine` VALUES (9, NULL, 'sdl', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_medicine` VALUES (10, NULL, 'sdl', 11.00, '2019-1-1', '30', 20, '没啥');
COMMIT;

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `create_time` varchar(32) DEFAULT NULL,
  `create_user` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `create_user` (`create_user`),
  CONSTRAINT `t_message_ibfk_1` FOREIGN KEY (`create_user`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_message
-- ----------------------------
BEGIN;
INSERT INTO `t_message` VALUES (1, '中共中央政治局常务委员会召开会议 分析新冠肺炎疫情形势', '新华社北京2月12日电 中共中央政治局常务委员会2月12日召开会议，听取中央应对新型冠状病毒感染肺炎疫情工作领导小组汇报，分析当前新冠肺炎疫情形势，研究加强疫情防控工作。中共中央总书记习近平主持会议并发表重要讲话。\n\n　　习近平指出，新冠肺炎疫情发生以来，我们始终坚持把人民群众生命安全和身体健康放在第一位，按照坚定信心、同舟共济、科学防治、精准施策的总要求，全面开展疫情防控工作。在党中央集中统一领导下，中央应对疫情工作领导小组及时研究部署工作，国务院联防联控机制加大政策协调和物资调配力度，各地区各部门积极履职尽责，广大医务人员冲锋在前、无私奉献，全国各族人民众志成城、团结奋战。经过艰苦努力，疫情形势出现积极变化，防控工作取得积极成效。这是来之不易的，各方面都作出了贡献。\n\n　　习近平强调，当前，疫情防控工作到了最吃劲的关键阶段，要毫不放松做好疫情防控重点工作，加强疫情特别严重或风险较大的地区防控。各级党委和政府要按照党中央决策部署，突出重点、统筹兼顾，分类指导、分区施策，切实把各项工作抓实、抓细、抓落地，坚决打赢疫情防控的人民战争、总体战、阻击战，努力实现今年经济社会发展目标任务。', '2020-02-13 12:21:00', 10000);
INSERT INTO `t_message` VALUES (2, '阿斯顿大时代', '啊是哒是哒打', '2020-2-13 15:50', 10000);
INSERT INTO `t_message` VALUES (3, '安达市撒', '阿诗丹顿萨达收到', '2020-2-13 15:53', 10000);
COMMIT;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '服务或商品名',
  `num` int DEFAULT NULL COMMENT '数量',
  `price` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `allprice` decimal(10,2) DEFAULT NULL COMMENT '总价',
  `registid` int DEFAULT NULL COMMENT '挂号单id',
  PRIMARY KEY (`id`),
  KEY `registid` (`registid`),
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`registid`) REFERENCES `t_regist` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_order
-- ----------------------------
BEGIN;
INSERT INTO `t_order` VALUES (11, '阿莫西林', 1, 18.01, 18.01, 5);
COMMIT;

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `permission` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
BEGIN;
INSERT INTO `t_permission` VALUES (1, 'admin', 'view:delete:update');
INSERT INTO `t_permission` VALUES (2, 'user', 'view:user');
COMMIT;

-- ----------------------------
-- Table structure for t_pet
-- ----------------------------
DROP TABLE IF EXISTS `t_pet`;
CREATE TABLE `t_pet` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '宠物名',
  `sex` varchar(2) DEFAULT NULL COMMENT '宠物性别',
  `type` varchar(32) DEFAULT NULL COMMENT '宠物种类',
  `age` varchar(10) DEFAULT NULL COMMENT '宠物年龄',
  `image` varchar(255) DEFAULT NULL COMMENT '宠物照片',
  `user` int DEFAULT NULL COMMENT '主人id',
  PRIMARY KEY (`id`),
  KEY `user` (`user`),
  CONSTRAINT `t_pet_ibfk_1` FOREIGN KEY (`user`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_pet
-- ----------------------------
BEGIN;
INSERT INTO `t_pet` VALUES (3, '小花', '雄', '狗', '4.5', 'image', 10000);
INSERT INTO `t_pet` VALUES (12, '小红', '雌', '猫', '1', '无', 10000);
INSERT INTO `t_pet` VALUES (34, '小猫', '雌', '猫', '3', 'http://127.0.0.1:8787/static/upload/images/cd5dfca8-6429-4f67-adac-49b75994a396.jpg', 258209);
INSERT INTO `t_pet` VALUES (36, '小黑', '雌', '大黑狗', '2', 'http://127.0.0.1:8787/static/upload/images/c24a1ad7-223d-4271-b3a0-8c69761f4ae0.jpg', 258209);
COMMIT;

-- ----------------------------
-- Table structure for t_regist
-- ----------------------------
DROP TABLE IF EXISTS `t_regist`;
CREATE TABLE `t_regist` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `resoved` int DEFAULT '0' COMMENT '诊断完成标记0/1',
  `question` varchar(255) DEFAULT NULL COMMENT '问题描述',
  `answer` varchar(255) DEFAULT NULL COMMENT '诊断结果',
  `medicine` varchar(255) DEFAULT NULL COMMENT '用药',
  `petid` int DEFAULT NULL COMMENT '宠物id',
  `userid` int DEFAULT NULL COMMENT '主人id',
  `doctorid` int DEFAULT NULL COMMENT '医生id',
  `date` datetime DEFAULT NULL COMMENT '挂号时间',
  PRIMARY KEY (`id`),
  KEY `petid` (`petid`),
  CONSTRAINT `t_regist_ibfk_1` FOREIGN KEY (`petid`) REFERENCES `t_pet` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_regist
-- ----------------------------
BEGIN;
INSERT INTO `t_regist` VALUES (5, 1, '萨达收到', '问题不大', NULL, 34, 258209, 258210, '2020-02-18 00:00:00');
INSERT INTO `t_regist` VALUES (9, 0, '有点毛病', '', NULL, 34, 258209, 258210, '2020-02-19 00:00:00');
INSERT INTO `t_regist` VALUES (10, 0, 'yaosssss', NULL, NULL, 34, 258209, 258210, '2020-02-22 00:00:00');
COMMIT;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '角色表ID',
  `userid` int DEFAULT NULL COMMENT '用户ID',
  `usertype` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色类型',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `t_role_ibfk_1` (`userid`) USING BTREE,
  CONSTRAINT `t_role_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_role
-- ----------------------------
BEGIN;
INSERT INTO `t_role` VALUES (2, 10000, 'admin');
INSERT INTO `t_role` VALUES (32, 258209, 'user');
INSERT INTO `t_role` VALUES (33, 258210, 'doctor');
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=258212 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (10000, 'admin', 'admin');
INSERT INTO `t_user` VALUES (258209, 'user', 'user');
INSERT INTO `t_user` VALUES (258210, 'doctor', 'doctor');
COMMIT;

-- ----------------------------
-- Table structure for t_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_userinfo`;
CREATE TABLE `t_userinfo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `realname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `sex` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `email` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `userid` int DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `userid` (`userid`) USING BTREE,
  CONSTRAINT `t_userinfo_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_userinfo
-- ----------------------------
BEGIN;
INSERT INTO `t_userinfo` VALUES (2, '小龙', '男', 'http://127.0.0.1:8787/static/upload/images/e1413010-bc67-45c5-a410-24031ae19842.jpg', '17344090162', 'sdllove1314@qq.com', '我这不是写了吗你才懒死了！', 10000);
INSERT INTO `t_userinfo` VALUES (31, 'user', '女', 'http://127.0.0.1:8787/static/upload/images/67f8d772-7687-4efe-bfac-641e3c7248ec.jpg', '173333090000', 'sdllove3121@qq.com', '我是一名用户', 258209);
INSERT INTO `t_userinfo` VALUES (32, 'doctor', '男', NULL, '173333090000', 'sdllove3121@qq.com', NULL, 258210);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
