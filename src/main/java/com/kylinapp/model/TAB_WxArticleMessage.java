/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.model;

/**    
 * @author：QYW   
 * @since：2018年12月28日下午2:54:47
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public class TAB_WxArticleMessage {
	private String id;
	private String articleID;
	private String username;
	private String usericonurl;
	private String messageContent;
	private String timestamp;
	private String time;
	@Override
	public String toString() {
		return "TAB_WxArticleMessage [id=" + id + ", articleID=" + articleID + ", username=" + username
				+ ", usericonurl=" + usericonurl + ", messageContent=" + messageContent + ", timestamp=" + timestamp
				+ ", time=" + time + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getArticleID() {
		return articleID;
	}
	public void setArticleID(String articleID) {
		this.articleID = articleID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsericonurl() {
		return usericonurl;
	}
	public void setUsericonurl(String usericonurl) {
		this.usericonurl = usericonurl;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
