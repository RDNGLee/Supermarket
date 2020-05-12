/*
 Navicat Premium Data Transfer

 Source Server         : supermarket
 Source Server Type    : MySQL
 Source Server Version : 50623
 Source Host           : localhost:3306
 Source Schema         : supermarket

 Target Server Type    : MySQL
 Target Server Version : 50623
 File Encoding         : 65001

 Date: 11/03/2019 22:23:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for clock_info
-- ----------------------------
DROP TABLE IF EXISTS `clock_info`;
CREATE TABLE `clock_info`  (
  `clock_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `clock_in_time` datetime(0) NULL DEFAULT NULL,
  `clock_off_time` datetime(0) NULL DEFAULT NULL,
  `clock_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`clock_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of clock_info
-- ----------------------------
INSERT INTO `clock_info` VALUES (1, 'S0002', '2018-08-01 11:30:52', '2018-08-01 18:30:30', '2018-08-01');
INSERT INTO `clock_info` VALUES (2, 's0004', '2018-08-02 09:46:52', '2018-08-02 17:30:30', '2018-08-02');
INSERT INTO `clock_info` VALUES (3, 's0005', '2018-08-03 08:46:52', '2018-08-03 17:30:30', '2018-08-03');
INSERT INTO `clock_info` VALUES (4, 's0003', '2018-08-04 09:13:52', '2018-08-04 18:30:30', '2018-08-04');
INSERT INTO `clock_info` VALUES (5, 's0004', '2018-08-05 09:46:52', '2018-08-05 18:30:30', '2018-08-05');
INSERT INTO `clock_info` VALUES (6, 's0005', NULL, '2018-08-06 18:30:30', '2018-08-06');
INSERT INTO `clock_info` VALUES (7, 'S0005', '2018-08-01 08:46:52', '2018-08-01 18:30:30', '2018-08-01');
INSERT INTO `clock_info` VALUES (8, 'S0002', '2018-08-02 09:46:52', '2018-08-02 17:30:30', '2018-08-02');
INSERT INTO `clock_info` VALUES (9, 'S0006', '2018-08-03 08:46:52', '2018-08-03 17:30:30', '2018-08-03');
INSERT INTO `clock_info` VALUES (10, 'S0003', '2018-08-01 09:46:52', '2018-08-01 18:30:30', '2018-08-01');
INSERT INTO `clock_info` VALUES (11, 'S0004', '2018-08-02 09:46:52', '2018-08-02 17:30:30', '2018-08-02');
INSERT INTO `clock_info` VALUES (12, 'S0003', '2018-08-03 08:46:52', '2018-08-03 17:30:30', '2018-08-03');
INSERT INTO `clock_info` VALUES (13, 'S0004', '2018-08-04 09:13:52', '2018-08-04 18:30:30', '2018-08-04');
INSERT INTO `clock_info` VALUES (14, 'S0005', '2018-08-05 09:46:52', '2018-08-05 14:30:30', '2018-08-05');
INSERT INTO `clock_info` VALUES (15, 'S0006', NULL, '2018-08-06 18:30:30', '2018-08-06');
INSERT INTO `clock_info` VALUES (17, 'S0001', '2019-01-23 15:45:51', '2019-01-23 15:45:53', '2019-01-23');
INSERT INTO `clock_info` VALUES (18, 'S0002', '2019-01-23 08:07:55', '2019-01-23 14:07:57', '2019-01-23');
INSERT INTO `clock_info` VALUES (19, 'S0006', '2019-01-23 14:53:42', '2019-01-23 14:53:46', '2019-01-23');
INSERT INTO `clock_info` VALUES (20, 's0013', '2019-01-23 16:47:25', '2019-01-23 16:47:27', '2019-01-23');
INSERT INTO `clock_info` VALUES (21, 'S0003', '2019-01-23 21:16:26', '2019-01-23 21:16:29', '2019-01-23');
INSERT INTO `clock_info` VALUES (22, 'S0010', '2019-01-23 21:26:26', '2019-01-23 21:26:31', '2019-01-23');
INSERT INTO `clock_info` VALUES (23, 'S0007', '2019-01-23 21:29:37', '2019-01-23 21:29:39', '2019-01-23');
INSERT INTO `clock_info` VALUES (24, 'S0002', NULL, NULL, '2019-01-24');
INSERT INTO `clock_info` VALUES (25, 'S0001', NULL, NULL, '2019-01-24');
INSERT INTO `clock_info` VALUES (26, 'S0010', NULL, '2019-01-24 17:41:21', '2019-01-24');
INSERT INTO `clock_info` VALUES (27, 'S0008', NULL, NULL, '2019-01-24');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`number`) USING BTREE,
  UNIQUE INDEX `phone`(`phone`) USING BTREE,
  INDEX `role_id_FK`(`role`) USING BTREE,
  CONSTRAINT `role_id_FK` FOREIGN KEY (`role`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('s00004', 'zhang', '1234', '男', '13566667777', 2);
INSERT INTO `employee` VALUES ('s00009', 'asdf', '1234', '女', NULL, 0);
INSERT INTO `employee` VALUES ('S0001', '洪七公', 'admin', '男', '15919754435', 1);
INSERT INTO `employee` VALUES ('s00016', '张飞', '123456', '男', NULL, 2);
INSERT INTO `employee` VALUES ('s00019', 'zhang', '1234', '男', '13577667666', 0);
INSERT INTO `employee` VALUES ('S0002', '杨过', '1234', '男', '15919764435', 2);
INSERT INTO `employee` VALUES ('S0003', '黄蓉', '1111', '女', '15949754435', 2);
INSERT INTO `employee` VALUES ('S0004', '小龙女', '1234', '女', '15919757435', 2);
INSERT INTO `employee` VALUES ('S0005', '郭靖', 'admin', '男', '15919754485', 1);
INSERT INTO `employee` VALUES ('S0006', '郭襄', '1234', '男', '15919759485', 3);
INSERT INTO `employee` VALUES ('S0007', '黄老邪', '1111', '男', '15919754425', 3);
INSERT INTO `employee` VALUES ('S0008', '段誉', '1111', '男', '15919724485', 3);
INSERT INTO `employee` VALUES ('S0009', '段誉', '1111', '男', '15919724985', 2);
INSERT INTO `employee` VALUES ('S0010', '乔峰', '1234', '男', '15919754415', 2);
INSERT INTO `employee` VALUES ('S0011', '扫地僧', 'admin', '男', '15919751415', 1);
INSERT INTO `employee` VALUES ('s0012', 'zhangfei', '1234', '男', '12345678999', 3);
INSERT INTO `employee` VALUES ('s0013', '荒鸡', '1234', '男', '19333338888', 2);
INSERT INTO `employee` VALUES ('s0014', '李白', '1234', '男', '13245664565', 0);
INSERT INTO `employee` VALUES ('s0015', '章子怡', '1234', '女', '15113674572', 0);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `c_number` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `c_price` decimal(10, 2) NULL DEFAULT NULL,
  `vip_price` decimal(10, 2) NULL DEFAULT NULL,
  `inventory` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`c_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '洗衣粉', 10.50, 8.40, 885);
INSERT INTO `goods` VALUES (2, '洗衣机', 1200.00, 960.00, 495);
INSERT INTO `goods` VALUES (3, '电视机', 5000.00, 4000.00, 115);
INSERT INTO `goods` VALUES (4, '空调', 3400.00, 2720.00, 180000047);
INSERT INTO `goods` VALUES (5, '电磁炉', 120.00, 96.00, 10017);
INSERT INTO `goods` VALUES (6, '牙膏', 12.00, 9.60, 5000);
INSERT INTO `goods` VALUES (7, '洗面奶', 10.00, 8.00, 30);
INSERT INTO `goods` VALUES (8, '香皂', 4.00, 3.20, 335);
INSERT INTO `goods` VALUES (9, '奶粉', 100.00, 80.00, 4990);
INSERT INTO `goods` VALUES (10, '苹果', 10.00, 8.00, 411);
INSERT INTO `goods` VALUES (11, '大米', 3.00, 2.40, 58767);
INSERT INTO `goods` VALUES (12, '烂白菜', 12.00, 9.60, 4519);
INSERT INTO `goods` VALUES (13, '口香糖', 11.00, 8.80, 1006);
INSERT INTO `goods` VALUES (14, '大白兔', 10.00, 8.00, 4500);
INSERT INTO `goods` VALUES (15, '味精', 1.00, 0.80, 48687);
INSERT INTO `goods` VALUES (17, '小白兔', 8.00, 6.40, 796);
INSERT INTO `goods` VALUES (18, '花生', 18.00, 14.40, 599);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL,
  `r_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (0, '炒鱿鱼');
INSERT INTO `role` VALUES (1, '管理员');
INSERT INTO `role` VALUES (2, '收银员');
INSERT INTO `role` VALUES (3, '采购员');

-- ----------------------------
-- Table structure for sell_info
-- ----------------------------
DROP TABLE IF EXISTS `sell_info`;
CREATE TABLE `sell_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `s_c_number` int(50) NULL DEFAULT NULL,
  `s_quantity` int(11) NULL DEFAULT NULL,
  `s_time` datetime(0) NULL DEFAULT NULL,
  `s_e_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `s_vip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `s_money` float(20, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `s_c_number_FK`(`s_c_number`) USING BTREE,
  INDEX `s_e_number_FK`(`s_e_number`) USING BTREE,
  CONSTRAINT `s_c_number_FK` FOREIGN KEY (`s_c_number`) REFERENCES `goods` (`c_number`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `s_e_number_FK` FOREIGN KEY (`s_e_number`) REFERENCES `employee` (`number`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sell_info
-- ----------------------------
INSERT INTO `sell_info` VALUES (13, 1, 1, '2019-01-22 17:17:13', 'S0002', 'vip201901020004', 8.40);
INSERT INTO `sell_info` VALUES (14, 15, 1, '2019-01-22 17:47:36', 'S0002', NULL, 1.00);
INSERT INTO `sell_info` VALUES (15, 17, 10, '2019-01-22 17:47:48', 'S0002', NULL, 80.00);
INSERT INTO `sell_info` VALUES (16, 2, 1, '2019-01-22 17:56:31', 'S0002', NULL, 1200.00);
INSERT INTO `sell_info` VALUES (17, 15, 1000, '2019-01-23 14:14:15', 'S0002', 'vip201901020005', 800.00);
INSERT INTO `sell_info` VALUES (18, 11, 20, '2019-01-23 14:14:32', 'S0002', 'vip201901020005', 48.00);
INSERT INTO `sell_info` VALUES (32, 17, 1, '2019-01-23 14:57:27', 'S0002', NULL, 8.00);
INSERT INTO `sell_info` VALUES (33, 17, 1, '2019-01-23 14:57:51', 'S0002', NULL, 8.00);
INSERT INTO `sell_info` VALUES (34, 1, 1, '2019-01-23 16:47:57', 's0013', NULL, 10.50);
INSERT INTO `sell_info` VALUES (36, 1, 1, '2019-01-23 16:48:56', 's0013', NULL, 10.50);
INSERT INTO `sell_info` VALUES (37, 1, 1, '2019-01-23 16:49:10', 's0013', NULL, 10.50);
INSERT INTO `sell_info` VALUES (38, 1, 1, '2019-01-23 16:56:25', 's0013', NULL, 10.50);
INSERT INTO `sell_info` VALUES (39, 1, 1, '2019-01-23 16:56:40', 's0013', NULL, 10.50);
INSERT INTO `sell_info` VALUES (40, 1, 1, '2019-01-23 16:57:02', 's0013', NULL, 10.50);
INSERT INTO `sell_info` VALUES (44, 4, 7, '2019-01-23 17:00:44', 's0013', NULL, 23800.00);
INSERT INTO `sell_info` VALUES (45, 2, 4, '2019-01-23 17:02:08', 's0013', NULL, 4800.00);
INSERT INTO `sell_info` VALUES (49, 1, 1, '2019-01-23 17:31:47', 'S0002', 'vip201901020002', 8.40);
INSERT INTO `sell_info` VALUES (50, 3, 1, '2019-01-23 17:31:51', 'S0002', NULL, 5000.00);
INSERT INTO `sell_info` VALUES (51, 1, 1, '2019-01-23 17:38:14', 'S0002', 'vip201901020004', 8.40);
INSERT INTO `sell_info` VALUES (52, 12, 100, '2019-01-23 17:38:24', 'S0002', 'vip201901020004', 960.00);
INSERT INTO `sell_info` VALUES (53, 1, 100, '2019-01-23 21:12:52', 'S0003', 'vip201901020002', 840.00);
INSERT INTO `sell_info` VALUES (54, 18, 100, '2019-01-23 21:13:01', 'S0003', 'vip201901020002', 1440.00);
INSERT INTO `sell_info` VALUES (55, 18, 100, '2019-01-23 21:28:17', 'S0010', 'vip2019010200011', 1440.00);
INSERT INTO `sell_info` VALUES (56, 18, 100, '2019-01-23 21:28:23', 'S0010', 'vip2019010200011', 1440.00);
INSERT INTO `sell_info` VALUES (62, 1, 1, '2019-01-23 23:01:13', 'S0002', 'vip201901020003', 8.40);
INSERT INTO `sell_info` VALUES (65, 1, 1, '2019-01-23 23:10:37', 'S0002', NULL, 10.50);
INSERT INTO `sell_info` VALUES (66, 1, 1, '2019-01-23 23:16:55', 'S0002', 'vip201901020003', 8.40);
INSERT INTO `sell_info` VALUES (67, 1, 2, '2019-01-23 23:17:22', 'S0002', 'vip201901020003', 16.80);
INSERT INTO `sell_info` VALUES (68, 1, 1, '2019-01-23 23:28:05', 'S0002', 'vip201901020003', 8.40);
INSERT INTO `sell_info` VALUES (69, 3, 1, '2019-01-23 23:28:27', 'S0002', 'vip201901020003', 4000.00);
INSERT INTO `sell_info` VALUES (70, 13, 1, '2019-01-23 23:28:33', 'S0002', 'vip201901020003', 8.80);
INSERT INTO `sell_info` VALUES (71, 3, 1, '2019-01-23 23:29:21', 'S0002', NULL, 5000.00);
INSERT INTO `sell_info` VALUES (72, 8, 333, '2019-01-23 23:30:01', 'S0002', 'vip201901020003', 1065.60);
INSERT INTO `sell_info` VALUES (73, 8, 132, '2019-01-24 00:11:51', 'S0002', 'vip201901020003', 422.40);
INSERT INTO `sell_info` VALUES (74, 17, 100, '2019-01-24 17:42:22', 'S0010', 'vip201901020005', 640.00);
INSERT INTO `sell_info` VALUES (75, 18, 1, '2019-01-24 17:42:34', 'S0010', 'vip201901020005', 14400.00);
INSERT INTO `sell_info` VALUES (76, 1, 20, '2019-01-24 17:42:41', 'S0010', 'vip201901020005', 168.00);
INSERT INTO `sell_info` VALUES (77, 12, 12, '2019-01-24 17:42:48', 'S0010', 'vip201901020005', 115.20);

-- ----------------------------
-- Table structure for vip
-- ----------------------------
DROP TABLE IF EXISTS `vip`;
CREATE TABLE `vip`  (
  `v_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `v_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `v_score` int(11) NULL DEFAULT NULL,
  `v_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `v_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`v_number`) USING BTREE,
  UNIQUE INDEX `v_phone`(`v_phone`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vip
-- ----------------------------
INSERT INTO `vip` VALUES ('vip201901020001', '范统', 1515, '15844760501', '2019-01-17');
INSERT INTO `vip` VALUES ('vip2019010200011', '李飞', 3600, '13566677767', '2019-01-23');
INSERT INTO `vip` VALUES ('vip2019010200019', 'asdf', 0, '13567676767', '2019-01-24');
INSERT INTO `vip` VALUES ('vip201901020002', '令狐冲', 2051, '15844760502', '2019-01-17');
INSERT INTO `vip` VALUES ('vip201901020003', '任盈盈', 4941, '15844760401', '2019-01-17');
INSERT INTO `vip` VALUES ('vip201901020005', '章子怡', 17102, '13455111111', '2019-01-23');
INSERT INTO `vip` VALUES ('vip201901020111', '荒荒', 0, '13500969569', '2019-01-24');

-- ----------------------------
-- Table structure for work_date
-- ----------------------------
DROP TABLE IF EXISTS `work_date`;
CREATE TABLE `work_date`  (
  `work_date_id` int(11) NOT NULL AUTO_INCREMENT,
  `work_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`work_date_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of work_date
-- ----------------------------
INSERT INTO `work_date` VALUES (1, '2018-08-01');
INSERT INTO `work_date` VALUES (2, '2018-08-02');
INSERT INTO `work_date` VALUES (3, '2018-08-03');
INSERT INTO `work_date` VALUES (4, '2018-08-04');
INSERT INTO `work_date` VALUES (5, '2018-08-06');
INSERT INTO `work_date` VALUES (29, '2019-01-23');

-- ----------------------------
-- View structure for check_info
-- ----------------------------
DROP VIEW IF EXISTS `check_info`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `check_info` AS #查询是否出勤情况
select t.work_date,t.employee_no,clock_in_time,clock_off_time, 
	case 
	        when diff_in_time<-120
			then '旷工'
		when diff_in_time<0 
			then '迟到'
		when diff_in_time>0
			then '正常'
		else '忘记打卡'
	end as diff_in_status,
	case 
	        when diff_off_time>120
			then '旷工'
		when diff_off_time>0 
			then '早退'
		when diff_off_time<0
			then '正常'
		else '忘记打卡'
	end as diff_off_time
from 
check_info_son
t ;

-- ----------------------------
-- View structure for check_info_son
-- ----------------------------
DROP VIEW IF EXISTS `check_info_son`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `check_info_son` AS select work_date,employee_no,clock_in_time,clock_off_time,
TIMESTAMPDIFF(MINUTE, clock_in_time, concat(clock_date,' 09:00:00')) as diff_in_time,
TIMESTAMPDIFF(MINUTE, clock_off_time, concat(clock_date,' 18:00:00')) as diff_off_time
from work_date w 
left join clock_info t 
on t.clock_date = w.work_date ;

-- ----------------------------
-- Triggers structure for table sell_info
-- ----------------------------
DROP TRIGGER IF EXISTS `commodity_t`;
delimiter ;;
CREATE TRIGGER `commodity_t` AFTER INSERT ON `sell_info` FOR EACH ROW begin
update goods set inventory=(inventory-new.s_quantity)
where c_number = new.s_c_number;

update vip set v_score = v_score+(new.s_c_number*new.s_quantity)
where v_number = new.s_vip;

end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
