/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.model;

/**    
 * @author：QYW   
 * @since：2018年12月28日上午10:16:59
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public class TAB_WXARTICLE {
	private String id;
	private String title;
	private String timestamp;
	private String time;
	private String imgurl;
	private String likes;
	private String pageViews;
	private String messageCount;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getLikes() {
		return likes;
	}
	public void setLikes(String likes) {
		this.likes = likes;
	}
	public String getPageViews() {
		return pageViews;
	}
	public void setPageViews(String pageViews) {
		this.pageViews = pageViews;
	}
	public String getMessageCount() {
		return messageCount;
	}
	public void setMessageCount(String messageCount) {
		this.messageCount = messageCount;
	}
	@Override
	public String toString() {
		return "TAB_WXARTICLE [id=" + id + ", title=" + title + ", timestamp=" + timestamp + ", time=" + time
				+ ", imgurl=" + imgurl + ", likes=" + likes + ", pageViews=" + pageViews + ", messageCount="
				+ messageCount + "]";
	}
	
}
