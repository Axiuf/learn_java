-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE secKill;

-- 使用数据库
use secKill;

-- 创建秒杀库存表
CREATE TABLE secKill(
    `secKill_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
    `name` varchar(120) NOT NULL COMMENT '商品名称',
    `number` int NOT NULL COMMENT '库存数量',
    `start_time` timestamp NOT NULL COMMENT '秒杀开启时间',
    `end_time` timestamp NOT NULL COMMENT '秒杀结束时间',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (secKill_id),
    key idx_start_time(start_time),
    key idx_end_time(end_time),
    key idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';

-- 初始化数据
insert into
    secKill(name, number, start_time, end_time)
values
    ('1000元秒杀iPhoneX', 100, '2021-04-06 00:00:00', '2021-04-17 00:00:00'),
    ('500元秒杀Apple Watch', 200, '2021-04-06 00:00:00', '2021-04-17 00:00:00'),
    ('1000元秒杀华为P10', 500, '2021-04-06 00:00:00', '2021-04-17 00:00:00'),
    ('2000秒杀汤臣一品', 10, '2021-04-06 00:00:00', '2021-04-17 00:00:00');

-- 秒杀成功明细表
-- 用户登录认证相关的信息
CREATE TABLE success_killed(
    `secKill_id` bigint NOT NULL COMMENT '秒杀商品id',
    `user_phone` bigint NOT NULL COMMENT '用户手机号',
    `state` tinyint NOT NULL DEFAULT -1 COMMENT '状态标识：-1：无效，0：成功，1：已付款， 2：已发货， 3：已收货',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (secKill_id, user_phone), /*联合主键*/
    key idx_create_time(create_time)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细表';

-- 连接数据库控制台
