-- 数据库初始化脚本
-- select version();
-- +-----------+
-- | version() |
-- +-----------+
-- | 5.6.26    |
-- +-----------+
-- 创建数据库
CREATE DATABASE invoice;
-- 使用数据库
use invoice;
--创建电子发票表
CREATE TABLE invoice(
`invoice_id` bigint NOT NULL AUTO_INCREMENT COMMENT '电子发票id',
`name` varchar(120) NOT NULL COMMENT '电子发票印章名称',
`code` varchar(120)  NOT NULL COMMENT '发票代码',
`number` varchar(120)  NOT NULL COMMENT '发票号码',
`counter` int NOT NULL COMMENT '电子发票数量',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`issue_invoice_time` timestamp NOT NULL COMMENT '开票时间',
`start_time` timestamp NOT NULL COMMENT '开启时间',
`end_time` timestamp NOT NULL COMMENT '结束时间',
PRIMARY KEY (invoice_id),
key idx_name(name),
key idx_code(code),
key idx_issue_invoice_time(issue_invoice_time),
key idx_create_time(create_time),
key idx_start_time(start_time),
key idx_end_time(end_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='电子发票表';

-- 初始化数据
insert into
  invoice(name,code,number,counter,issue_invoice_time,start_time,end_time)
values
  ('小米通讯技术有限公司','01110012542','0211854',1,'2015-11-01 00:00:00','2016-09-04 00:00:00','2016-09-07 00:00:00'),
  ('苹果技术有限公司','01110012566','0214324',1,'2015-11-01 00:00:00','2016-09-04 00:00:00','2016-09-07 00:00:00'),
  ('华为通讯技术有限公司','01110046542','0214374',1,'2015-11-01 00:00:00','2016-09-04 00:00:00','2016-09-07 00:00:00'),
  ('中兴通讯公司','01110012982','0212354',1,'2015-11-01 00:00:00','2016-09-04 00:00:00','2016-09-07 00:00:00');

-- 打印成功明细表
-- 用户登录认证相关的信息
create table success_printed(
`invoice_id` bigint NOT NULL COMMENT '电子发票id',
`user_phone` bigint NOT NULL COMMENT '用户手机号',
`state` tinyint NOT NULL DEFAULT -1 COMMENT '状态标示:-1:无效 0:成功 1:已打印 2:已恢复',
`create_time` timestamp NOT NULL COMMENT '创建时间',
PRIMARY KEY(invoice_id,user_phone),/*联合主键*/
key idx_create_time(create_time)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='打印成功明细表';

-- 连接数据库控制台
mysql -uroot -p

-- 为什么手写DDL
-- 记录每次上线的DDL修改
-- 上线V1.1
ALTER TABLE invoice
DROP INDEX idx_create_time,
ADD index idx_c_c(issue_invoice_time,create_time);

-- 上线V1.2
-- ddl
