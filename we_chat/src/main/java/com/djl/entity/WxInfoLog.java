package com.djl.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 *
 * 微信日志记录表
 *
 */
@TableName(value = "wx_info_table")
public class WxInfoLog implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 主键 */
	@TableId
	@TableField(value="row_id")
	private Long rowId;
	/**
	 * 创建时间
	 */
	@TableField(value = "CreateTime")
	private String createTime;
	/**
	 * 媒体信息ID
	 */
	@TableField(value = "Media_Id")
	private String mediaId;
	/** 图片信息链接 */
	@TableField(value = "IMAGE_PicUrl")
	private String imgUrl;
	
	//发送的信息内容
	private String contentMsg;
	/**
	 * 语音识别结果
	 */
	private String recognition;
	// 开发者微信号
	private String ToUserName;
	// 关注者
	private String FromUserName;
	// 信息类型
	private String MsgType;
	// 内容
	private String Content;
	// 消息id
	private String MsgId;
	/**
	 * 回复的信息
	 */
	@TableField(value = "RES_MSG")
	private String resMsg;
	
	public String getContentMsg() {
		return contentMsg;
	}

	public void setContentMsg(String contentMsg) {
		this.contentMsg = contentMsg;
	}

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

	public Long getRowId() {
		return rowId;
	}

	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getRecognition() {
		return recognition;
	}

	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}

	public String getResMsg() {
		return resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	@Override
	public String toString() {
		return "WxInfoLog [rowId=" + rowId + ", createTime=" + createTime + ", mediaId=" + mediaId + ", imgUrl="
				+ imgUrl + ", recognition=" + recognition + ", ToUserName=" + ToUserName + ", FromUserName="
				+ FromUserName + ", MsgType=" + MsgType + ", Content=" + Content + ", MsgId=" + MsgId + ", resMsg="
				+ resMsg + "]";
	}

}
