/*
Navicat MySQL Data Transfer

Source Server         : lcx
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : db_jsjx

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2016-06-01 09:41:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_client
-- ----------------------------
DROP TABLE IF EXISTS `tb_client`;
CREATE TABLE `tb_client` (
  `client_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_name` varchar(255) DEFAULT NULL COMMENT '公司名称',
  `client_type` varchar(255) DEFAULT NULL COMMENT '公司性质',
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_client
-- ----------------------------
INSERT INTO `tb_client` VALUES ('1', '上海三键', '化工');
INSERT INTO `tb_client` VALUES ('2', '锤纺株式会社', '生物科技');
INSERT INTO `tb_client` VALUES ('3', '天津灯塔', '涂料');
INSERT INTO `tb_client` VALUES ('4', '深圳咏翰', '科技');
INSERT INTO `tb_client` VALUES ('5', '阿童木涂料（廊坊）', '涂料');
INSERT INTO `tb_client` VALUES ('6', '杭华油墨', '化学');
INSERT INTO `tb_client` VALUES ('7', '上海本诺', '电子材料');
INSERT INTO `tb_client` VALUES ('8', '珠海索马龙', '精细化工');
INSERT INTO `tb_client` VALUES ('9', '苏州雅士利涂料', '涂料');
INSERT INTO `tb_client` VALUES ('10', '苏州太阳油墨', '化学');
INSERT INTO `tb_client` VALUES ('11', '哈尔滨天坛铅芯', '铅芯');
INSERT INTO `tb_client` VALUES ('12', '大连比克', '电池');

-- ----------------------------
-- Table structure for tb_conference
-- ----------------------------
DROP TABLE IF EXISTS `tb_conference`;
CREATE TABLE `tb_conference` (
  `conference_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `conference_code` varchar(255) DEFAULT NULL COMMENT '期号',
  `congerence_done_date` date DEFAULT NULL COMMENT '作成日期',
  PRIMARY KEY (`conference_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_conference
-- ----------------------------
INSERT INTO `tb_conference` VALUES ('1', '第1期', '2016-03-01');
INSERT INTO `tb_conference` VALUES ('2', '第2期', '2016-03-08');
INSERT INTO `tb_conference` VALUES ('3', '第3期', '2016-03-15');
INSERT INTO `tb_conference` VALUES ('4', '第4期', '2016-03-22');
INSERT INTO `tb_conference` VALUES ('5', '第5期', '2016-03-29');
INSERT INTO `tb_conference` VALUES ('6', '第6期', '2016-04-07');
INSERT INTO `tb_conference` VALUES ('7', '第7期', '2016-04-14');
INSERT INTO `tb_conference` VALUES ('8', '第8期', '2016-04-21');
INSERT INTO `tb_conference` VALUES ('9', '第9期', '2016-04-28');
INSERT INTO `tb_conference` VALUES ('10', '第10期', '2016-05-05');
INSERT INTO `tb_conference` VALUES ('11', '第11期', '2016-05-12');

-- ----------------------------
-- Table structure for tb_contract
-- ----------------------------
DROP TABLE IF EXISTS `tb_contract`;
CREATE TABLE `tb_contract` (
  `contract_id` int(11) NOT NULL AUTO_INCREMENT,
  `contract_code` varchar(255) DEFAULT NULL COMMENT '合同编号',
  `contract_date` date DEFAULT NULL COMMENT '日期',
  `contract_industry` varchar(255) DEFAULT NULL COMMENT '公司名称',
  `contract_device` varchar(255) DEFAULT NULL COMMENT '机器及部件名称',
  `contract_order` varchar(255) DEFAULT NULL COMMENT '报价单号',
  `contract_comment` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`contract_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_contract
-- ----------------------------
INSERT INTO `tb_contract` VALUES ('1', 'TIM-X16-001', '2016-05-05', '上海本诺', '各种零件', 'TIM-Y16-001', '质量要求不明确的，按照国家标准、行业标准履行;没有国家标准、行业标准的，按照通常标准或者符合合同目的的特定标准履行。');
INSERT INTO `tb_contract` VALUES ('2', 'TIM-X16-002', '2016-05-25', '珠海索马龙', '备件', 'TIM-Y16-002', '价款或者报酬不明确的，按照订立合同时履行地的市场价格履行;依法应当执行政府定价或者政府指导价的，按照规定履行。');
INSERT INTO `tb_contract` VALUES ('3', 'TIM-X16-003', '2016-05-24', '苏州雅士利涂料', '驱动器修理', 'TIM-Y16-003', '履行地点不明确，给付货币的，在接受货币一方所在地履行;交付不动产的，在不动产所在地履行;其他标的，在履行义务一方所在地履行。');
INSERT INTO `tb_contract` VALUES ('4', 'TIM-X16-004', '2016-05-27', '苏州太阳油墨', '搅拌机HDC-3', 'TIM-Y16-004', '履行期限不明确的，债务人可以随时履行，债权人也可以随时要求履行，但应当给对方必要的准备时间。');
INSERT INTO `tb_contract` VALUES ('5', 'TIM-X16-005', '2016-05-04', '哈尔滨天坛铅芯', '搅拌机HDC-4', 'TIM-Y16-005', '履行方式不明确的，按照有利于实现合同目的的方式履行。');
INSERT INTO `tb_contract` VALUES ('6', 'TIM-X16-006', '2016-05-05', '苏州太阳油墨', '备件', 'TIM-Y16-006', '履行费用的负担不明确的，由履行义务一方负担。');
INSERT INTO `tb_contract` VALUES ('7', 'TIM-X16-007', '2016-05-04', '珠海索马龙', 'RS-16', 'TIM-Y16-007', '并无任何强制效力。');
INSERT INTO `tb_contract` VALUES ('8', 'TIM-X16-008', '2016-05-03', '天津农学院', '各种零件', 'TIM-Y16-008', '质量要求不明确的，按照国家标准、行业标准履行;没有国家标准、行业标准的，按照通常标准或者符合合同目的的特定标准履行。\r\n质量要求不明确的，按照国家标准、行业标准履行;没有国家标准、行业标准的，按照通常标准或者符合合同目的的特定标准履行。\r\n质量要求不明确的，按照国家标准、行业标准履行;没有国家标准、行业标准的，按照通常标准或者符合合同目的的特定标准履行。\r\n');
INSERT INTO `tb_contract` VALUES ('9', 'TIM-X16-009', '2016-05-03', '苏州太阳油墨', '各种零件', 'TIM-Y16-009', '价款或者报酬不明确的，按照订立合同时履行地的市场价格履行;依法应当执行政府定价或者政府指导价的，按照规定履行。');
INSERT INTO `tb_contract` VALUES ('10', 'TIM-X16-010', '2016-05-19', '珠海索马龙', '搅拌机HDC-6', 'TIM-Y16-010', '履行地点不明确，给付货币的，在接受货币一方所在地履行;交付不动产的，在不动产所在地履行;其他标的，在履行义务一方所在地履行。');
INSERT INTO `tb_contract` VALUES ('11', 'TIM-X16-011', '2016-05-10', '苏州雅士利涂料', '备件', 'TIM-Y16-011', '履行期限不明确的，债务人可以随时履行，债权人也可以随时要求履行，但应当给对方必要的准备时间。\r\n');
INSERT INTO `tb_contract` VALUES ('12', 'TIM-X12-012', '2016-05-25', '大连比克', '备件', 'TIM-Y12-12', '履行方式不明确的，按照有利于实现合同目的的方式履行。');
INSERT INTO `tb_contract` VALUES ('13', 'TIM-X12-013', '2016-05-28', '锤纺株式会社', '备件', 'TIM-Y12-12', '履行费用的负担不明确的，由履行义务一方负担。\r\n');

-- ----------------------------
-- Table structure for tb_contract_statis
-- ----------------------------
DROP TABLE IF EXISTS `tb_contract_statis`;
CREATE TABLE `tb_contract_statis` (
  `contract_statis_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) DEFAULT NULL,
  `quote_id` int(11) DEFAULT NULL,
  `contract_statis_date` date DEFAULT NULL COMMENT '合同统计月份',
  PRIMARY KEY (`contract_statis_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_contract_statis
-- ----------------------------
INSERT INTO `tb_contract_statis` VALUES ('1', '1', '3', '2016-04-06');
INSERT INTO `tb_contract_statis` VALUES ('2', '1', '6', '2016-04-08');
INSERT INTO `tb_contract_statis` VALUES ('3', '1', '6', '2016-04-15');
INSERT INTO `tb_contract_statis` VALUES ('4', '3', '5', '2016-04-22');
INSERT INTO `tb_contract_statis` VALUES ('5', '3', '4', '2016-04-27');
INSERT INTO `tb_contract_statis` VALUES ('6', '2', '5', '2016-05-01');
INSERT INTO `tb_contract_statis` VALUES ('7', '4', '8', '2016-05-04');
INSERT INTO `tb_contract_statis` VALUES ('8', '5', '1', '2016-05-05');
INSERT INTO `tb_contract_statis` VALUES ('9', '6', '1', '2016-05-12');
INSERT INTO `tb_contract_statis` VALUES ('10', '7', '2', '2016-05-19');
INSERT INTO `tb_contract_statis` VALUES ('11', '8', '2', '2016-05-29');

-- ----------------------------
-- Table structure for tb_cost
-- ----------------------------
DROP TABLE IF EXISTS `tb_cost`;
CREATE TABLE `tb_cost` (
  `cost_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `cost_date` date DEFAULT NULL COMMENT '日期',
  PRIMARY KEY (`cost_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_cost
-- ----------------------------
INSERT INTO `tb_cost` VALUES ('1', '2016-03-31');
INSERT INTO `tb_cost` VALUES ('2', '2016-04-05');
INSERT INTO `tb_cost` VALUES ('3', '2016-04-13');
INSERT INTO `tb_cost` VALUES ('4', '2016-04-20');
INSERT INTO `tb_cost` VALUES ('5', '2016-04-21');
INSERT INTO `tb_cost` VALUES ('6', '2016-04-30');
INSERT INTO `tb_cost` VALUES ('7', '2016-05-04');
INSERT INTO `tb_cost` VALUES ('8', '2016-05-07');
INSERT INTO `tb_cost` VALUES ('9', '2016-05-14');
INSERT INTO `tb_cost` VALUES ('10', '2016-05-18');
INSERT INTO `tb_cost` VALUES ('11', '2016-05-28');

-- ----------------------------
-- Table structure for tb_device
-- ----------------------------
DROP TABLE IF EXISTS `tb_device`;
CREATE TABLE `tb_device` (
  `device_id` int(11) NOT NULL AUTO_INCREMENT,
  `device_code` varchar(255) DEFAULT NULL COMMENT '型号',
  `device_main` varchar(255) DEFAULT NULL COMMENT '主体',
  `device_pump` varchar(255) DEFAULT NULL COMMENT '泵',
  `device_capcity` varchar(255) DEFAULT NULL COMMENT '分散筒全容量',
  `device_a` varchar(255) DEFAULT NULL,
  `device_b` varchar(255) DEFAULT NULL,
  `device_c` varchar(255) DEFAULT NULL,
  `device_d` varchar(255) DEFAULT NULL,
  `device_e` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`device_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_device
-- ----------------------------
INSERT INTO `tb_device` VALUES ('1', 'MSHⅡ-1.5/MSGⅡ-1.5', '3.7', '0.4', '1.98', '1040', '420', '700', '500', '1120');
INSERT INTO `tb_device` VALUES ('2', 'MSHⅡ-5/MSGⅡ-5', '11', '0.75', '7.9', '1150', '580', '950', '550', '1530');
INSERT INTO `tb_device` VALUES ('3', 'MSHⅡ-20/MSGⅡ-20', '22', '0.75', '17.5', '1520', '1000', '1150', '720', '2150');
INSERT INTO `tb_device` VALUES ('4', 'MSHⅡ-50/MSGⅡ-50', '37', '1.5', '51', '1570', '1300', '1530', '800', '2830');
INSERT INTO `tb_device` VALUES ('5', 'MSHⅡ-100/MSGⅡ-100', '55', '2.2', '106.9', '2010', '1700', '1940', '1250', '3640');
INSERT INTO `tb_device` VALUES ('6', 'MSHⅡ-200/MSGⅡ-200', '240', '4.0', '210', '2450', '1800', '2300', '1525', '4100');
INSERT INTO `tb_device` VALUES ('7', 'MSHⅡ-300/MSGⅡ-300', '340', '6.2', '330.2', '3500', '2400', '3300', '2300', '8000');
INSERT INTO `tb_device` VALUES ('8', 'MSHⅡ-400/MSGⅡ-400', '460', '8.15', '410.4', '4210', '3700', '4670', '3200', '12300');
INSERT INTO `tb_device` VALUES ('9', 'MSHⅡ-500/MSGⅡ-500', '550', '10.05', '550.7', '5340', '4980', '5200', '4870', '16700');
INSERT INTO `tb_device` VALUES ('10', 'MSHⅡ-1000/MSGⅡ-1000', '900', '21.0', '1000.3', '1200', '980', '12000', '9200', '36000');
INSERT INTO `tb_device` VALUES ('11', 'MSHⅡ-2000/MSGⅡ-2000', '2000', '44.0', '2039.6', '2500', '1940', '21000', '18900', '72000');

-- ----------------------------
-- Table structure for tb_employee
-- ----------------------------
DROP TABLE IF EXISTS `tb_employee`;
CREATE TABLE `tb_employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(255) DEFAULT NULL COMMENT '营业人名',
  `employee_pass` varchar(255) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_employee
-- ----------------------------
INSERT INTO `tb_employee` VALUES ('1', '唐部长', '1');
INSERT INTO `tb_employee` VALUES ('2', '王副部长', '1');
INSERT INTO `tb_employee` VALUES ('3', '部长助理1', '1');
INSERT INTO `tb_employee` VALUES ('4', '部长助理2', '1');
INSERT INTO `tb_employee` VALUES ('5', '李干事', '1');
INSERT INTO `tb_employee` VALUES ('6', '唐干事', '1');
INSERT INTO `tb_employee` VALUES ('7', '魏干事', '1');
INSERT INTO `tb_employee` VALUES ('8', '沈干事', '1');
INSERT INTO `tb_employee` VALUES ('9', '兰程成', '1');
INSERT INTO `tb_employee` VALUES ('10', '李姐', '1');
INSERT INTO `tb_employee` VALUES ('11', '岛田', '1');

-- ----------------------------
-- Table structure for tb_evection
-- ----------------------------
DROP TABLE IF EXISTS `tb_evection`;
CREATE TABLE `tb_evection` (
  `evection_id` int(11) NOT NULL AUTO_INCREMENT,
  `evection_name` varchar(255) DEFAULT NULL COMMENT '出差人员',
  `evection_place` varchar(255) DEFAULT NULL COMMENT '出发地点',
  `evection_out` date DEFAULT NULL COMMENT '出发日期',
  `evection_back` date DEFAULT NULL COMMENT '返程日期',
  `evection_comment` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`evection_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_evection
-- ----------------------------
INSERT INTO `tb_evection` VALUES ('1', '部长助理', '上海', '2016-04-05', '2016-04-06', '5月2日直接从上海移动至无锡');
INSERT INTO `tb_evection` VALUES ('2', '部长助理', '无锡', '2016-04-08', '2016-04-09', '无');
INSERT INTO `tb_evection` VALUES ('3', '唐部长', '洛阳', '2016-04-13', '2016-04-13', '无');
INSERT INTO `tb_evection` VALUES ('4', '部长助理', '郑州', '2016-04-28', '2016-04-28', '无');
INSERT INTO `tb_evection` VALUES ('5', '沈干事', '杭州', '2016-05-03', '2016-05-04', '无');
INSERT INTO `tb_evection` VALUES ('6', '沈干事', '深圳', '2016-05-11', '2016-05-13', '无');
INSERT INTO `tb_evection` VALUES ('7', '沈干事', '哈尔滨', '2016-05-18', '2016-05-19', '无');
INSERT INTO `tb_evection` VALUES ('8', '王副部长', '大连', '2016-05-20', '2016-05-21', '无');
INSERT INTO `tb_evection` VALUES ('9', '兰程成', '珠海', '2016-05-25', '2016-05-26', '无');
INSERT INTO `tb_evection` VALUES ('10', '部长助理', '塘沽', '2016-05-27', '2016-05-27', '无');
INSERT INTO `tb_evection` VALUES ('11', '部长助理', '廊坊', '2016-05-31', '2016-06-01', '无');

-- ----------------------------
-- Table structure for tb_maintain
-- ----------------------------
DROP TABLE IF EXISTS `tb_maintain`;
CREATE TABLE `tb_maintain` (
  `maintain_id` int(11) NOT NULL AUTO_INCREMENT,
  `maintain_date` date DEFAULT NULL COMMENT '维修日期',
  `maintain_evection` varchar(255) DEFAULT NULL COMMENT '维修出差号',
  `maintain_client` int(11) DEFAULT NULL,
  `maintain_device` int(11) DEFAULT NULL,
  `maintain_rely` varchar(255) DEFAULT NULL COMMENT '依赖号',
  `maintain_continue` varchar(255) DEFAULT NULL COMMENT '有无后续操作',
  `maintain_person` varchar(255) DEFAULT NULL COMMENT '维修人员',
  PRIMARY KEY (`maintain_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_maintain
-- ----------------------------
INSERT INTO `tb_maintain` VALUES ('1', '2016-04-04', 'TIM-R16-001', null, null, null, null, null);
INSERT INTO `tb_maintain` VALUES ('2', '2016-04-07', 'TIM-R16-002', null, null, null, null, null);
INSERT INTO `tb_maintain` VALUES ('3', '2016-04-17', 'TIM-R16-003', null, null, null, null, null);
INSERT INTO `tb_maintain` VALUES ('4', '2016-04-25', 'TIM-R16-004', null, null, null, null, null);
INSERT INTO `tb_maintain` VALUES ('5', '2016-05-03', 'TIM-R16-005', null, null, null, null, null);
INSERT INTO `tb_maintain` VALUES ('6', '2016-05-12', 'TIM-R16-006', null, null, null, null, null);
INSERT INTO `tb_maintain` VALUES ('7', '2016-05-16', 'TIM-R16-007', null, null, null, null, null);
INSERT INTO `tb_maintain` VALUES ('8', '2016-05-24', 'TIM-R16-008', null, null, null, null, null);
INSERT INTO `tb_maintain` VALUES ('9', '2016-05-26', 'TIM-R16-009', null, null, null, null, null);
INSERT INTO `tb_maintain` VALUES ('10', '2016-05-29', 'TIM-R16-010', null, null, null, null, null);
INSERT INTO `tb_maintain` VALUES ('11', '2016-06-16', 'TIM-R16-011', null, null, null, null, null);

-- ----------------------------
-- Table structure for tb_quote
-- ----------------------------
DROP TABLE IF EXISTS `tb_quote`;
CREATE TABLE `tb_quote` (
  `quote_id` int(11) NOT NULL AUTO_INCREMENT,
  `quote_date` date DEFAULT NULL COMMENT '日期',
  `quote_order` varchar(255) DEFAULT NULL COMMENT '报价单号',
  `quote_industry` varchar(255) DEFAULT NULL COMMENT '公司名称',
  `quote_device` varchar(255) DEFAULT NULL COMMENT '机器及部件名称',
  `quote_take` varchar(255) DEFAULT NULL COMMENT '担当',
  `quote_content` varchar(255) DEFAULT NULL COMMENT '报价内容',
  `quote_noTaxPrice` double(10,2) DEFAULT NULL,
  `quote_taxPrice` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`quote_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_quote
-- ----------------------------
INSERT INTO `tb_quote` VALUES ('1', '1999-01-01', 'TIM-Y16-001', '上海三键', '备件', '田中', '局部损坏', '1000.00', '1170.00');
INSERT INTO `tb_quote` VALUES ('2', '2000-01-01', 'TIM-Y16-002', '行华油墨', '驱动器修理', '铃木', '转速', '5700.00', '6669.00');
INSERT INTO `tb_quote` VALUES ('3', '2002-01-01', 'TIM-Y16-004', '锤纺株式会社', '搅拌机HDC-3', '唐武', '转轴故障', '3570.00', '4176.90');
INSERT INTO `tb_quote` VALUES ('4', '2003-01-01', 'TIM-Y16-005', '天津灯塔', 'RS-16', '李毅', '帮助客户使用机器', '500.00', '585.00');
INSERT INTO `tb_quote` VALUES ('5', '2004-01-01', 'TIM-Y16-006', '深圳永翰', '搅拌机DHC-60', '黄海滨', '转轴故障', '2300.00', '2691.00');
INSERT INTO `tb_quote` VALUES ('6', '2005-01-01', 'TIM-Y16-007', '深圳永翰', '各种零件', '黄海滨', '部件掉落', '1230.00', '1439.10');
INSERT INTO `tb_quote` VALUES ('7', '2006-01-01', 'TIM-Y16-008', '行华油墨', '驱动器修理', '铃木', '转速', '4740.00', '5545.80');
INSERT INTO `tb_quote` VALUES ('8', '2007-01-01', 'TIM-Y16-009', '上海三键', '搅拌机HDC-4', '田中', '转轴故障', '2200.00', '2574.00');
INSERT INTO `tb_quote` VALUES ('9', '2008-01-01', 'TIM-Y16-010', '上海三键', '驱动器修理', '田中', '转速', '4300.00', '5031.00');
INSERT INTO `tb_quote` VALUES ('10', '2016-05-04', 'TIM-Y16-011', '深圳永翰', '备件', '黄海滨', '局部损坏', '1320.00', '1544.40');
INSERT INTO `tb_quote` VALUES ('11', '2016-05-04', 'TIM-Y16-011', '天津灯塔', '备件', '李毅', '局部损坏', '3200.00', '3744.00');

-- ----------------------------
-- Table structure for tb_quote_statis
-- ----------------------------
DROP TABLE IF EXISTS `tb_quote_statis`;
CREATE TABLE `tb_quote_statis` (
  `quote_statis_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_name` varchar(255) DEFAULT NULL COMMENT '公司名称',
  `client_type` varchar(11) DEFAULT NULL COMMENT '公司性质',
  `quote_statis_date` date DEFAULT NULL COMMENT '报价统计月份',
  PRIMARY KEY (`quote_statis_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_quote_statis
-- ----------------------------
INSERT INTO `tb_quote_statis` VALUES ('1', '杭华油墨', '化学', '2016-04-01');
INSERT INTO `tb_quote_statis` VALUES ('2', '天津灯塔', '涂料', '2016-04-06');
INSERT INTO `tb_quote_statis` VALUES ('3', '深圳咏翰', '科技', '2016-04-13');
INSERT INTO `tb_quote_statis` VALUES ('4', '上海三键', '化工', '2016-04-15');
INSERT INTO `tb_quote_statis` VALUES ('5', '杭华油墨', '化学', '2016-04-24');
INSERT INTO `tb_quote_statis` VALUES ('6', '深圳咏翰', '科技', '2016-04-27');
INSERT INTO `tb_quote_statis` VALUES ('7', '深圳咏翰', '科技', '2016-05-01');
INSERT INTO `tb_quote_statis` VALUES ('8', '上海本诺', '电子材料', '2016-05-12');
INSERT INTO `tb_quote_statis` VALUES ('9', '珠海索马龙', '精细化工', '2016-05-20');
INSERT INTO `tb_quote_statis` VALUES ('10', '上海本诺', '电子材料', '2016-05-25');
INSERT INTO `tb_quote_statis` VALUES ('11', '苏州太阳油墨', '化学', '2016-05-30');

-- ----------------------------
-- Table structure for tb_servicecomplain
-- ----------------------------
DROP TABLE IF EXISTS `tb_servicecomplain`;
CREATE TABLE `tb_servicecomplain` (
  `servicecom_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `servicecom_code` varchar(255) DEFAULT NULL COMMENT '服务号',
  `servicecom_client` varchar(255) DEFAULT NULL,
  `servicecom_done_date` date DEFAULT NULL COMMENT '完成日期',
  `servicecom_letter_date` date DEFAULT NULL COMMENT '收信日期',
  `servicecom_letter_receiver` varchar(255) DEFAULT NULL COMMENT '收信人',
  `servicecom_take` varchar(255) DEFAULT NULL COMMENT '服务担当',
  `servicecom_device` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`servicecom_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_servicecomplain
-- ----------------------------
INSERT INTO `tb_servicecomplain` VALUES ('1', 'TIM-S16-001', '1', '2016-04-04', '2016-04-05', '岛田', '田中', '4');
INSERT INTO `tb_servicecomplain` VALUES ('2', 'TIM-S16-002', '6', '2016-04-08', '2016-04-10', '高逸', '王伟', '5');
INSERT INTO `tb_servicecomplain` VALUES ('3', 'TIM-S16-003', '4', '2016-04-14', '2016-04-17', '李伟', '王静', '6');
INSERT INTO `tb_servicecomplain` VALUES ('4', 'TIM-S16-004', '7', '2016-04-20', '2016-04-22', '王建平', '魏哲', '1');
INSERT INTO `tb_servicecomplain` VALUES ('5', 'TIM-S16-005', '3', '2016-04-28', '2016-04-30', '李毅', '李毅', '9');
INSERT INTO `tb_servicecomplain` VALUES ('6', 'TIM-S16-006', '2', '2016-05-05', '2016-05-10', '刘伟', '刘伟', '5');
INSERT INTO `tb_servicecomplain` VALUES ('7', 'TIM-S16-007', '8', '2016-05-19', '2016-05-25', '高逸', '王伟', '7');
INSERT INTO `tb_servicecomplain` VALUES ('8', 'TIM-S16-008', '6', '2016-05-11', '2016-05-12', '郑浩', '郑浩', '3');
INSERT INTO `tb_servicecomplain` VALUES ('9', 'TIM-S16-009', '4', '2016-05-29', '2016-05-30', '王江', '黄海滨', '4');
INSERT INTO `tb_servicecomplain` VALUES ('10', 'TIM-S16-010', '5', '2016-05-30', '2016-05-31', '雍波', '唐武', '9');
INSERT INTO `tb_servicecomplain` VALUES ('11', 'TIM-S16-011', '9', '2016-06-01', '2016-06-01', '李毅', '李毅', '2');
