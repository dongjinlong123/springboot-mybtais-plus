CREATE TABLE IF NOT EXISTS WX_INFO_TABLE (
	row_id INT UNSIGNED auto_increment COMMENT '信息id',
	To_User_Name VARCHAR (200) COMMENT '接受者',
	From_User_Name VARCHAR (200) COMMENT '发送者',
	CreateTime VARCHAR (20) COMMENT '信息创建时间',
	Msg_Type VARCHAR (100) COMMENT '信息类型',
	Content VARCHAR (2000) COMMENT '内容',
    content_msg varchar(1000) COMMENT '文本信息内容',
	Msg_Id VARCHAR (200) COMMENT '信息ID',
	IMAGE_PicUrl VARCHAR (1000) COMMENT '图片信息链接',
	Media_Id VARCHAR (200) COMMENT '媒体信息ID',
	Recognition VARCHAR(2000) COMMENT '语音识别结果',
	RES_MSG VARCHAR(2000) COMMENT '回复的信息',
	data_create datetime DEFAULT now(),
	create_by VARCHAR (20) NOT NULL DEFAULT 'djl',
	data_last_upd datetime DEFAULT now(),
	last_upd_by VARCHAR (20) NOT NULL DEFAULT 'djl',
	PRIMARY KEY (row_id)
);