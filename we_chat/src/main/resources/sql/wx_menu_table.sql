CREATE TABLE IF NOT EXISTS WX_MENU_TABLE (
	row_id INT UNSIGNED auto_increment comment '菜单id',
	menu_type varchar(20) comment '菜单类型',
	menu_level varchar(20) comment '菜单等级',
	menu_name varchar(20) comment '菜单名称',
	menu_parent_id varchar(20) comment '菜单父id',
	menu_order varchar(20) comment '菜单排序号',
	data_create datetime default now(),
	create_by varchar(20) not null default 'djl',
	data_last_upd datetime default now(),
	last_upd_by varchar(20) not null default 'djl',
	primary key(row_id)
);