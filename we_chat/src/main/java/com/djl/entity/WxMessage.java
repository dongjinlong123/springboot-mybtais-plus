package com.djl.entity;

public class WxMessage {
	/*
	 *按照微信的标准 ：正常的需要小写，因为大写的时候注入可能会出现问题
	 */
	//开发者微信号
	private String ToUserName;
	//关注者
	private String FromUserName;
	//信息创建时间
	private long CreateTime;
	//信息类型
	private String MsgType;	
	//内容
	private String Content;	
	//消息id
	private String MsgId;
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
}
