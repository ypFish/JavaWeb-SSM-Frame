package com.sdt.oneword.domain;

import java.io.Serializable;

public class Message implements Serializable{

	/**
	 * 信息实体类 
	 */
	private static final long serialVersionUID = 1990L;

	private long messageId ;
	
	private String autherName ;
	
	private String messageInfo ;
	
	private long positiveCount ;
	
	private long negativeCount ;
	
	private String createTime ;
	
	private String remark;

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public String getAutherName() {
		return autherName;
	}

	public void setAutherName(String autherName) {
		this.autherName = autherName;
	}

	public String getMessageInfo() {
		return messageInfo;
	}

	public void setMessageInfo(String messageInfo) {
		this.messageInfo = messageInfo;
	}

	public long getPositiveCount() {
		return positiveCount;
	}

	public void setPositiveCount(long positiveCount) {
		this.positiveCount = positiveCount;
	}

	public long getNegativeCount() {
		return negativeCount;
	}

	public void setNegativeCount(long negativeCount) {
		this.negativeCount = negativeCount;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
