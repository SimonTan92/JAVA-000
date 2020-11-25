-- 基于电商交易场景（用户、商品、订单）
create or replace table e_user(
    USER_ID varchar(255) primary key comment '用户ID, 使用UUID创建字符串',
    USER_NAME varchar(50) not null comment '用户姓名',
    USER_NICKNAME varchar(255) not null comment '用户昵称(登陆名)',
    USER_PASSWORD varchar(100) not null comment '用户登陆密码',
    USER_HEADIMAGE varchar(255) default '' comment '用户头像',
    CREATE_TIME timestamp not null default now() comment '用户信息创建日期',
    UPDATE_TIME timestamp not null default now() comment '用户信息修改日期'
)ENGINE=INNODB DEFAULT CHARSET=UTF8;

create or replace table e_commodit(
    COMMODIT_ID varchar(255) primary key comment '商品ID',
    COMMODIT_NAME varchar(100) not null comment '商品名称',
    COMMODIT_PRICE varchar(100) not null default '0.00' comment '商品价格',
    COMMODIT_DISCOUNT varchar(10) not null default '1' comment '商品折扣',
    COMMODIT_MADE varchar(255) not null default '' comment '商品产地',
    COMMODIT_KIND varchar(2) not null default '0' comment '商品种类',
    COMMODIT_PD date not null comment '商品生产日期',
    COMMODIT_DESCRIPTION varchar(255) not null default '' comment '商品介绍',
    CREATE_TIME timestamp not null default now() comment '商品信息创建日期',
    UPDATE_TIME timestamp not null default now() comment '商品信息修改日期'
)ENGINE=INNODB DEFAULT CHARSET=UTF8;

create or replace table e_order(
    ORDER_ID varchar(255) comment '订单ID',
    USER_ID varchar(255) comment '用户ID',
    -- 但是一个订单会存在多个商品呀～应该有个联合表才对
    COMMIDIT_ID varchar(255) comment '商品ID',
    ORDER_STATUS varchar(1) not null default '1' comment '订单状态',
    CREATE_TIME timestamp not null default now() comment '订单信息创建日期',
    UPDATE_TIME timestamp not null default now() comment '订单信息修改日期',
    PRIMARY KEY (ORDER_ID, USER_ID, COMMIDIT_ID)
)ENGINE=INNODB DEFAULT CHARSET=UTF8;
