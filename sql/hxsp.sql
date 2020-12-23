/*
Navicat MySQL Data Transfer

Source Server         : 福建鸿成
Source Server Version : 50628
Source Host           : 101.37.152.199:3306
Source Database       : hxsp

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2020-12-19 17:51:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for advertising_page
-- ----------------------------
DROP TABLE IF EXISTS `advertising_page`;
CREATE TABLE `advertising_page` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT '0' COMMENT '产品id',
  `type` int(11) NOT NULL DEFAULT '1' COMMENT '类型：1.商品，2.优惠券3.文章等',
  `path` varchar(255) DEFAULT '/0/' COMMENT '路径',
  `image` varchar(600) NOT NULL COMMENT '图片',
  `sort` int(5) DEFAULT '99999' COMMENT '排序',
  `is_show` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态（0：未上架，1：上架）',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='首页轮播广告表';

-- ----------------------------
-- Records of advertising_page
-- ----------------------------
INSERT INTO `advertising_page` VALUES ('13', null, '2', '/pages/couponCenter/couponCenter', 'https://hxsp.mynatapp.cc/images/a34dc2242f99419baff583596e674989.png', null, '1', '2020-12-19 02:27:41', '0000-00-00 00:00:00');

-- ----------------------------
-- Table structure for cart_product_info
-- ----------------------------
DROP TABLE IF EXISTS `cart_product_info`;
CREATE TABLE `cart_product_info` (
  `id` bigint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '购物车表ID',
  `uid` int(10) unsigned NOT NULL COMMENT '用户ID',
  `type` varchar(32) NOT NULL COMMENT '类型',
  `product_id` int(10) unsigned NOT NULL COMMENT '商品ID',
  `product_attr_unique` varchar(16) NOT NULL DEFAULT '' COMMENT '商品属性',
  `cart_num` smallint(5) unsigned NOT NULL DEFAULT '0' COMMENT '商品数量',
  `combination_id` int(11) unsigned DEFAULT '0' COMMENT '拼团id',
  `seckill_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '秒杀商品ID',
  `bargain_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '砍价id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '已添加的商品是否有效状态',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`uid`) USING BTREE,
  KEY `goods_id` (`product_id`) USING BTREE,
  KEY `uid` (`uid`) USING BTREE,
  KEY `uid_2` (`uid`) USING BTREE,
  KEY `type` (`type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车商品关系表';

-- ----------------------------
-- Records of cart_product_info
-- ----------------------------

-- ----------------------------
-- Table structure for coupon_info
-- ----------------------------
DROP TABLE IF EXISTS `coupon_info`;
CREATE TABLE `coupon_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '优惠券表ID',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '优惠券名称',
  `money` decimal(8,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '兑换的优惠券面值',
  `is_limited` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否限量, 默认0 不限量， 1限量',
  `total` int(11) DEFAULT '0' COMMENT '发放总数',
  `last_total` int(11) DEFAULT '0' COMMENT '剩余数量',
  `use_type` tinyint(2) NOT NULL DEFAULT '1' COMMENT '使用类型 1 全场通用, 2 商品券, 3 品类券',
  `primary_key` varchar(255) DEFAULT '' COMMENT '所属商品id / 分类id',
  `min_price` decimal(8,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '最低消费，0代表不限制',
  `receive_start_time` datetime DEFAULT NULL COMMENT '可领取开始时间',
  `receive_end_time` datetime DEFAULT NULL COMMENT '可领取结束时间',
  `is_fixed_time` tinyint(1) DEFAULT '0' COMMENT '是否固定使用时间, 默认0 否， 1是',
  `use_start_time` datetime DEFAULT NULL COMMENT '可使用时间范围 开始时间',
  `use_end_time` datetime DEFAULT NULL COMMENT '可使用时间范围 结束时间',
  `day` int(4) DEFAULT '0' COMMENT '天数',
  `type` tinyint(2) NOT NULL DEFAULT '1' COMMENT '优惠券类型 1 手动领取, 2 新人券, 3 赠送券',
  `sort` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '排序',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态（0：关闭，1：开启）',
  `is_del` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除 状态（0：否，1：是）',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `state` (`status`) USING BTREE,
  KEY `is_del` (`is_del`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='优惠券表';

-- ----------------------------
-- Records of coupon_info
-- ----------------------------

-- ----------------------------
-- Table structure for coupon_user
-- ----------------------------
DROP TABLE IF EXISTS `coupon_user`;
CREATE TABLE `coupon_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `coupon_id` int(10) NOT NULL COMMENT '优惠券发布id',
  `cid` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '兑换的项目id',
  `uid` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '领取人id',
  `name` varchar(32) NOT NULL DEFAULT '' COMMENT '优惠券名称',
  `money` decimal(8,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '优惠券的面值',
  `min_price` decimal(8,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '最低消费多少金额可用优惠券',
  `type` tinyint(1) NOT NULL DEFAULT '1' COMMENT '获取方式，1后台发放, 2用户领取',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态（0：未使用，1：已使用, 2:已失效）',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `start_time` timestamp NULL DEFAULT NULL COMMENT '开始使用时间',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '过期时间',
  `use_time` timestamp NULL DEFAULT NULL COMMENT '使用时间',
  `use_type` tinyint(1) DEFAULT '1' COMMENT '使用类型 1 全场通用, 2 商品券, 3 品类券',
  `primary_key` varchar(255) DEFAULT NULL COMMENT '所属商品id / 分类id',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `cid` (`cid`) USING BTREE,
  KEY `uid` (`uid`) USING BTREE,
  KEY `end_time` (`end_time`) USING BTREE,
  KEY `status` (`status`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='优惠券记录表';

-- ----------------------------
-- Records of coupon_user
-- ----------------------------

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `order_id` varchar(32) NOT NULL COMMENT '订单号',
  `uid` int(11) unsigned NOT NULL COMMENT '用户id',
  `real_name` varchar(32) NOT NULL COMMENT '用户姓名',
  `user_phone` varchar(18) NOT NULL COMMENT '用户电话',
  `user_address` varchar(100) NOT NULL COMMENT '详细地址',
  `freight_price` decimal(8,2) DEFAULT '0.00' COMMENT '运费金额',
  `total_num` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '订单商品总数',
  `total_price` decimal(8,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '订单总价',
  `total_postage` decimal(8,2) unsigned DEFAULT '0.00' COMMENT '邮费',
  `pay_price` decimal(8,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '实际支付金额',
  `pay_postage` decimal(8,2) unsigned DEFAULT '0.00' COMMENT '支付邮费',
  `deduction_price` decimal(8,2) unsigned DEFAULT '0.00' COMMENT '抵扣金额',
  `coupon_id` int(11) unsigned DEFAULT '0' COMMENT '优惠券id',
  `coupon_price` decimal(8,2) unsigned DEFAULT '0.00' COMMENT '优惠券金额',
  `paid` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '支付状态',
  `pay_time` timestamp NULL DEFAULT NULL COMMENT '支付时间',
  `pay_type` varchar(32) DEFAULT NULL COMMENT '支付方式',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '订单状态（-1 : 申请退款 -2 : 退货成功 -3：退货失败 0：待发货；1：待收货；2：已收货，待评价；3：已完成；）',
  `refund_status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '0 未退款 1 申请中 2 已退款',
  `refund_reason_wap_img` varchar(255) DEFAULT NULL COMMENT '退款图片',
  `refund_reason_wap_explain` varchar(255) DEFAULT NULL COMMENT '退款用户说明',
  `refund_reason_wap` varchar(255) DEFAULT NULL COMMENT '前台退款原因',
  `refund_reason` varchar(255) DEFAULT NULL COMMENT '不退款的理由',
  `refund_reason_time` timestamp NULL DEFAULT NULL COMMENT '退款时间',
  `refund_price` decimal(8,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '退款金额',
  `delivery_name` varchar(64) DEFAULT NULL COMMENT '快递名称/送货人姓名',
  `delivery_type` varchar(32) DEFAULT NULL COMMENT '发货类型',
  `delivery_id` varchar(64) DEFAULT NULL COMMENT '快递单号/手机号',
  `gain_integral` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '消费赚取积分',
  `use_integral` int(11) unsigned DEFAULT '0' COMMENT '使用积分',
  `back_integral` int(11) unsigned DEFAULT NULL COMMENT '给用户退了多少积分',
  `mark` varchar(512) DEFAULT NULL COMMENT '备注',
  `is_del` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除',
  `unique` char(32) DEFAULT NULL COMMENT '唯一id(md5加密)类似id',
  `remark` varchar(512) DEFAULT NULL COMMENT '管理员备注',
  `mer_id` int(10) unsigned DEFAULT '0' COMMENT '商户ID',
  `is_mer_check` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `combination_id` int(11) unsigned DEFAULT '0' COMMENT '拼团商品id0一般商品',
  `pink_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '拼团id 0没有拼团',
  `cost` decimal(8,2) unsigned DEFAULT NULL COMMENT '成本价',
  `seckill_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '秒杀商品ID',
  `bargain_id` int(11) unsigned DEFAULT '0' COMMENT '砍价id',
  `is_channel` tinyint(1) unsigned DEFAULT '1' COMMENT '支付渠道(0微信公众号1微信小程序)',
  `is_remind` tinyint(1) unsigned DEFAULT '0' COMMENT '消息提醒',
  `is_system_del` tinyint(1) DEFAULT '0' COMMENT '后台是否删除',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `order_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '订单类型（1：普通，2：积分）',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `order_id_2` (`order_id`,`uid`) USING BTREE,
  UNIQUE KEY `unique` (`unique`) USING BTREE,
  KEY `uid` (`uid`) USING BTREE,
  KEY `add_time` (`create_time`) USING BTREE,
  KEY `pay_price` (`pay_price`) USING BTREE,
  KEY `paid` (`paid`) USING BTREE,
  KEY `pay_time` (`pay_time`) USING BTREE,
  KEY `pay_type` (`pay_type`) USING BTREE,
  KEY `status` (`status`) USING BTREE,
  KEY `is_del` (`is_del`) USING BTREE,
  KEY `coupon_id` (`coupon_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of order_info
-- ----------------------------

-- ----------------------------
-- Table structure for order_product
-- ----------------------------
DROP TABLE IF EXISTS `order_product`;
CREATE TABLE `order_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '关联ID',
  `order_id` varchar(255) NOT NULL COMMENT '订单号',
  `product_id` int(11) NOT NULL COMMENT '商品ID',
  `product_name` varchar(255) NOT NULL COMMENT '商品名称',
  `cart_num` int(11) NOT NULL COMMENT '商品数量',
  `image` varchar(255) NOT NULL COMMENT '商品图片',
  `price` varchar(10) NOT NULL COMMENT '金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_product
-- ----------------------------

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `pid` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '父级ID',
  `path` varchar(255) DEFAULT NULL COMMENT '路径',
  `name` varchar(50) DEFAULT NULL COMMENT '分类名称',
  `type` smallint(2) NOT NULL DEFAULT '1' COMMENT '类型，1 产品分类，2 附件分类，3 文章分类， 4 设置分类， 5 菜单分类',
  `url` varchar(255) DEFAULT '' COMMENT '地址',
  `extra` mediumtext COMMENT '扩展字段 Jsos格式',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态, 1正常，0失效',
  `sort` int(5) DEFAULT '99999' COMMENT '排序',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `status+pid` (`pid`,`status`) USING BTREE,
  KEY `id+status+url` (`path`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分类表';

-- ----------------------------
-- Records of product_category
-- ----------------------------

-- ----------------------------
-- Table structure for product_category_ano
-- ----------------------------
DROP TABLE IF EXISTS `product_category_ano`;
CREATE TABLE `product_category_ano` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL DEFAULT '0' COMMENT '商品id',
  `cate_id` int(11) NOT NULL DEFAULT '0' COMMENT '分类id',
  `add_time` int(11) NOT NULL DEFAULT '0' COMMENT '添加时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='商品分类辅助表';

-- ----------------------------
-- Records of product_category_ano
-- ----------------------------

-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info` (
  `id` mediumint(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `image` varchar(600) NOT NULL COMMENT '商品图片',
  `slider_image` varchar(2000) NOT NULL COMMENT '轮播图',
  `product_name` varchar(128) NOT NULL COMMENT '商品名称',
  `product_info` varchar(256) NOT NULL COMMENT '商品简介',
  `keyword` varchar(256) DEFAULT NULL COMMENT '关键字',
  `bar_code` varchar(15) DEFAULT '' COMMENT '商品条码（一维码）',
  `cate_id` varchar(64) DEFAULT NULL COMMENT '分类id',
  `price` decimal(8,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '商品价格/兑换所需积分',
  `vip_price` decimal(8,2) unsigned DEFAULT '0.00' COMMENT '会员价格',
  `ot_price` decimal(8,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '市场价',
  `unit_name` varchar(32) DEFAULT NULL COMMENT '单位名',
  `sort` smallint(11) DEFAULT '0' COMMENT '排序',
  `sales` mediumint(11) unsigned DEFAULT '0' COMMENT '销量',
  `stock` mediumint(11) unsigned NOT NULL DEFAULT '0' COMMENT '库存',
  `is_show` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态（0：未上架，1：上架）',
  `product_type` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '0-普通商品 1-积分商品',
  `is_hot` tinyint(1) DEFAULT '0' COMMENT '是否热卖',
  `is_benefit` tinyint(1) DEFAULT '0' COMMENT '是否优惠',
  `is_best` tinyint(1) DEFAULT '0' COMMENT '是否精品',
  `is_new` tinyint(1) DEFAULT '0' COMMENT '是否新品',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `is_postage` tinyint(1) unsigned DEFAULT '0' COMMENT '是否包邮',
  `is_del` tinyint(1) unsigned DEFAULT '0' COMMENT '是否删除',
  `give_integral` decimal(8,2) unsigned DEFAULT '0.00' COMMENT '获得积分',
  `cost` decimal(8,2) unsigned DEFAULT '0.00' COMMENT '成本价',
  `is_seckill` tinyint(1) unsigned DEFAULT '0' COMMENT '秒杀状态 0 未开启 1已开启',
  `is_bargain` tinyint(1) unsigned DEFAULT NULL COMMENT '砍价状态 0未开启 1开启',
  `is_good` tinyint(1) DEFAULT '0' COMMENT '是否优品推荐',
  `is_sub` tinyint(1) DEFAULT '0' COMMENT '是否单独分佣',
  `fack_sales` mediumint(11) DEFAULT '100' COMMENT '虚拟销量',
  `browse` int(11) DEFAULT '0' COMMENT '浏览量',
  `code_path` varchar(64) DEFAULT '' COMMENT '商品二维码地址(用户小程序海报)',
  `soure_link` varchar(255) DEFAULT '' COMMENT '淘宝京东1688类型',
  `video_link` varchar(200) DEFAULT '' COMMENT '主图视频链接',
  `temp_id` int(11) DEFAULT '1' COMMENT '运费模板ID',
  `spec_type` tinyint(1) DEFAULT '0' COMMENT '规格 0单 1多',
  `activity` varchar(255) DEFAULT '' COMMENT '活动显示排序1=秒杀，2=砍价，3=拼团',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `cate_id` (`cate_id`) USING BTREE,
  KEY `is_hot` (`is_hot`) USING BTREE,
  KEY `is_benefit` (`is_benefit`) USING BTREE,
  KEY `is_best` (`is_best`) USING BTREE,
  KEY `is_new` (`is_new`) USING BTREE,
  KEY `toggle_on_sale, is_del` (`is_del`) USING BTREE,
  KEY `price` (`price`) USING BTREE,
  KEY `is_show` (`is_show`) USING BTREE,
  KEY `sort` (`sort`) USING BTREE,
  KEY `sales` (`sales`) USING BTREE,
  KEY `add_time` (`add_time`) USING BTREE,
  KEY `is_postage` (`is_postage`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='商品表';

-- ----------------------------
-- Records of product_info
-- ----------------------------

-- ----------------------------
-- Table structure for system_admin
-- ----------------------------
DROP TABLE IF EXISTS `system_admin`;
CREATE TABLE `system_admin` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '后台管理员表ID',
  `account` varchar(32) NOT NULL COMMENT '后台管理员账号',
  `pwd` char(32) NOT NULL COMMENT '后台管理员密码',
  `real_name` varchar(16) NOT NULL COMMENT '后台管理员姓名',
  `roles` varchar(128) NOT NULL COMMENT '后台管理员权限(menus_id)',
  `last_ip` varchar(16) DEFAULT NULL COMMENT '后台管理员最后一次登录ip',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `login_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '登录次数',
  `level` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '后台管理员级别',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '后台管理员状态 1有效0无效',
  `is_del` tinyint(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `account` (`account`) USING BTREE,
  KEY `status` (`status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台管理员表';

-- ----------------------------
-- Records of system_admin
-- ----------------------------

-- ----------------------------
-- Table structure for template_message
-- ----------------------------
DROP TABLE IF EXISTS `template_message`;
CREATE TABLE `template_message` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '模板id',
  `type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0=订阅消息,1=微信模板消息',
  `temp_key` char(50) NOT NULL DEFAULT '' COMMENT '模板编号',
  `title` char(100) NOT NULL COMMENT '模板标题',
  `content` varchar(1000) NOT NULL COMMENT '回复内容',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态',
  `extra` mediumtext COMMENT '扩展字段 Json格式',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='微信模板';

-- ----------------------------
-- Records of template_message
-- ----------------------------

-- ----------------------------
-- Table structure for user_address
-- ----------------------------
DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户地址id',
  `uid` int(10) unsigned NOT NULL COMMENT '用户id',
  `real_name` varchar(32) NOT NULL DEFAULT '' COMMENT '收货人姓名',
  `phone` varchar(16) NOT NULL DEFAULT '' COMMENT '收货人电话',
  `province` varchar(64) DEFAULT '' COMMENT '收货人所在省',
  `city` varchar(64) DEFAULT '' COMMENT '收货人所在市',
  `city_id` int(11) DEFAULT '0' COMMENT '城市id',
  `district` varchar(64) DEFAULT '' COMMENT '收货人所在区',
  `detail` varchar(256) DEFAULT '' COMMENT '收货人详细地址',
  `post_code` varchar(10) DEFAULT '0' COMMENT '邮编',
  `longitude` varchar(16) DEFAULT NULL COMMENT '经度',
  `latitude` varchar(16) DEFAULT '0' COMMENT '纬度',
  `is_default` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否默认',
  `is_del` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `uid` (`uid`) USING BTREE,
  KEY `is_default` (`is_default`) USING BTREE,
  KEY `is_del` (`is_del`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='用户地址表';

-- ----------------------------
-- Records of user_address
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `uid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `account` varchar(32) DEFAULT NULL COMMENT '用户账号',
  `pwd` varchar(32) DEFAULT '' COMMENT '用户密码',
  `real_name` varchar(25) DEFAULT '' COMMENT '真实姓名',
  `tag_name` varchar(25) DEFAULT '' COMMENT '标签名称',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `mark` varchar(255) DEFAULT '' COMMENT '用户备注',
  `partner_id` int(11) DEFAULT '0' COMMENT '合伙人id',
  `group_id` varchar(255) DEFAULT '' COMMENT '用户分组id',
  `nickname` varchar(16) DEFAULT '' COMMENT '用户昵称',
  `avatar` varchar(256) DEFAULT '' COMMENT '用户头像',
  `phone` char(15) DEFAULT NULL COMMENT '手机号码',
  `openid` varchar(200) DEFAULT NULL COMMENT '添加ip',
  `last_ip` varchar(16) DEFAULT '' COMMENT '最后一次登录ip',
  `now_money` decimal(8,2) unsigned DEFAULT '0.00' COMMENT '用户余额',
  `brokerage_price` decimal(8,2) DEFAULT '0.00' COMMENT '佣金金额',
  `integral` int(8) unsigned DEFAULT '0' COMMENT '用户剩余积分',
  `experience` int(11) unsigned DEFAULT '0' COMMENT '用户剩余经验',
  `sign_num` int(11) DEFAULT '0' COMMENT '连续签到天数',
  `status` tinyint(1) DEFAULT '1' COMMENT '1为正常，0为禁止',
  `level` tinyint(2) unsigned DEFAULT '0' COMMENT '等级',
  `user_type` varchar(32) DEFAULT '' COMMENT '用户类型  1-用户 2-管理员',
  `pay_count` int(11) unsigned DEFAULT '0' COMMENT '用户购买次数',
  `addres` varchar(255) DEFAULT '' COMMENT '详细地址',
  `login_type` varchar(36) DEFAULT '' COMMENT '用户登陆类型，h5,wechat,routine',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `clean_time` timestamp NULL DEFAULT NULL COMMENT '清除时间',
  `subscribe` tinyint(3) DEFAULT '0' COMMENT '是否关注公众号',
  `subscribe_time` timestamp NULL DEFAULT NULL COMMENT '关注公众号时间',
  `sex` tinyint(1) DEFAULT '1' COMMENT '性别，0未知，1男，2女，3保密',
  `country` varchar(20) DEFAULT 'CN' COMMENT '国家，中国CN，其他OTHER',
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE KEY `account` (`account`) USING BTREE,
  KEY `level` (`level`) USING BTREE,
  KEY `status` (`status`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('4', '10086', '6412121cbb2dc2cb9e460cfee7046be2', '', '', null, '', '0', '', '', '', null, null, '', '0.00', '0.00', '0', '0', '0', '1', '0', '2', '0', '', '', '2020-12-15 16:00:00', '2020-12-18 13:10:56', null, '0', null, '1', 'CN');
INSERT INTO `user_info` VALUES ('26', null, '', '', '', null, '', '0', '', '用户oGGdr', '', null, 'oGGdr5Lrw71yIiqt3i5sLUngtfNc', '', '0.00', '0.00', '0', '0', '0', '1', '0', '', '0', '', '', null, '2020-12-19 02:16:19', null, '0', null, '1', 'CN');
INSERT INTO `user_info` VALUES ('27', null, '', '', '', null, '', '0', '', '用户oGGdr', '', null, 'oGGdr5PQEeQqzJUcVs0Ac8RMl7uY', '', '0.00', '0.00', '0', '0', '0', '1', '0', '', '0', '', '', null, '2020-12-19 02:21:18', null, '0', null, '1', 'CN');
INSERT INTO `user_info` VALUES ('28', null, '', '', '', null, '', '0', '', '用户oGGdr', '', null, 'oGGdr5AOMiOHiw60ZBfr3kPLyBZ0', '', '0.00', '0.00', '0', '0', '0', '1', '0', '', '0', '', '', null, '2020-12-19 02:30:57', null, '0', null, '1', 'CN');
INSERT INTO `user_info` VALUES ('29', null, '', '', '', null, '', '0', '', '用户oGGdr', '', null, 'oGGdr5D187Ct6Uf5xqGIEW18C8ZU', '', '0.00', '0.00', '0', '0', '0', '1', '0', '', '0', '', '', null, '2020-12-19 02:30:57', null, '0', null, '1', 'CN');
INSERT INTO `user_info` VALUES ('30', null, '', '', '', null, '', '0', '', '用户oGGdr', '', null, 'oGGdr5MAatRNq_yx7MseTycCHBMA', '', '0.00', '0.00', '0', '0', '0', '1', '0', '', '0', '', '', null, '2020-12-19 02:53:04', null, '0', null, '1', 'CN');
INSERT INTO `user_info` VALUES ('31', null, '', '', '', null, '', '0', '', '用户oGGdr', '', null, 'oGGdr5JPtxwKXyTji8ROgysXGDqg', '', '0.00', '0.00', '0', '0', '0', '1', '0', '', '0', '', '', null, '2020-12-19 04:02:04', null, '0', null, '1', 'CN');
INSERT INTO `user_info` VALUES ('32', null, '', '', '', null, '', '0', '', '用户oGGdr', '', null, 'oGGdr5I0vyjLb4DDJPSxsF8s5u1s', '', '0.00', '0.00', '0', '0', '0', '1', '0', '', '0', '', '', null, '2020-12-19 07:49:31', null, '0', null, '1', 'CN');
INSERT INTO `user_info` VALUES ('33', null, '', '', '', null, '', '0', '', '用户oGGdr', '', null, 'oGGdr5Hwfiv5nezOj5-pj9omYLGM', '', '0.00', '0.00', '0', '0', '0', '1', '0', '', '0', '', '', null, '2020-12-19 08:25:41', null, '0', null, '1', 'CN');
INSERT INTO `user_info` VALUES ('34', null, '', '', '', null, '', '0', '', '用户oGGdr', '', null, 'oGGdr5KSccLhEjomzqNcoOyzszS0', '', '0.00', '0.00', '0', '0', '0', '1', '0', '', '0', '', '', null, '2020-12-19 09:43:10', null, '0', null, '1', 'CN');
INSERT INTO `user_info` VALUES ('35', null, '', '', '', null, '', '0', '', '用户oGGdr', '', null, 'oGGdr5LNFzWvq2QG7Uy3hxmwAFlw', '', '0.00', '0.00', '0', '0', '0', '1', '0', '', '0', '', '', null, '2020-12-19 12:38:33', null, '0', null, '1', 'CN');
INSERT INTO `user_info` VALUES ('36', null, '', '', '', null, '', '0', '', '用户oGGdr', '', null, 'oGGdr5DL-vJJC1er_16IY_gbqvPQ', '', '0.00', '0.00', '0', '0', '0', '1', '0', '', '0', '', '', null, '2020-12-19 12:38:37', null, '0', null, '1', 'CN');
INSERT INTO `user_info` VALUES ('37', null, '', '', '', null, '', '0', '', '用户oGGdr', '', null, 'oGGdr5OhDUUcL21TAevwl_LS2IQU', '', '0.00', '0.00', '0', '0', '0', '1', '0', '', '0', '', '', null, '2020-12-19 12:50:48', null, '0', null, '1', 'CN');
INSERT INTO `user_info` VALUES ('38', null, '', '', '', null, '', '0', '', '用户oGGdr', '', null, 'oGGdr5LjSmeWPLxF1OGNJsN0iW3k', '', '0.00', '0.00', '0', '0', '0', '1', '0', '', '0', '', '', null, '2020-12-19 12:53:32', null, '0', null, '1', 'CN');
INSERT INTO `user_info` VALUES ('39', null, '', '', '', null, '', '0', '', '用户oGGdr', '', null, 'oGGdr5NzDhEMZuKikgbJw_rLov1g', '', '0.00', '0.00', '0', '0', '0', '1', '0', '', '0', '', '', null, '2020-12-19 12:53:59', null, '0', null, '1', 'CN');
INSERT INTO `user_info` VALUES ('40', null, '', '', '', null, '', '0', '', '用户oGGdr', '', null, 'oGGdr5KBb_bm1RHOOeXstC9rkYu0', '', '0.00', '0.00', '0', '0', '0', '1', '0', '', '0', '', '', null, '2020-12-19 12:54:00', null, '0', null, '1', 'CN');
INSERT INTO `user_info` VALUES ('41', null, '', '', '', null, '', '0', '', '用户oGGdr', '', null, 'oGGdr5MbH0bld5S6rjYqfh7L97g0', '', '0.00', '0.00', '0', '0', '0', '1', '0', '', '0', '', '', null, '2020-12-19 12:56:30', null, '0', null, '1', 'CN');
INSERT INTO `user_info` VALUES ('42', null, '', '', '', null, '', '0', '', '用户oGGdr', '', null, 'oGGdr5N2tC30vgd_W1xB8VMMEwGE', '', '0.00', '0.00', '0', '0', '0', '1', '0', '', '0', '', '', null, '2020-12-19 15:28:38', null, '0', null, '1', 'CN');
INSERT INTO `user_info` VALUES ('43', null, '', '', '', null, '', '0', '', '用户oGGdr', '', null, 'oGGdr5FPUJD36jCk-erHzooBuJIw', '', '0.00', '0.00', '0', '0', '0', '1', '0', '', '0', '', '', null, '2020-12-19 16:38:02', null, '0', null, '1', 'CN');