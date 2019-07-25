/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.model;

/**    
 * @author：QYW   
 * @since：2018年12月28日下午2:14:32
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public class TAB_WxArticleLike {
	private String id;
	private String username;
	private String timestamp;
	private String time;
	private String articleid;
	private String usericonurl;
	private String openid;
	private int flag;
	@Override
	public String toString() {
		return "TAB_WxArticleLike [id=" + id + ", username=" + username + ", timestamp=" + timestamp + ", time=" + time
				+ ", articleid=" + articleid + ", usericonurl=" + usericonurl + ", openid=" + openid + ", flag=" + flag
				+ "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getArticleid() {
		return articleid;
	}
	public void setArticleid(String articleid) {
		this.articleid = articleid;
	}
	public String getUsericonurl() {
		return usericonurl;
	}
	public void setUsericonurl(String usericonurl) {
		this.usericonurl = usericonurl;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
}
