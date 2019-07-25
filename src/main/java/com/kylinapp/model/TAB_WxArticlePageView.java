/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.model;

/**
 * @author：QYW
 * @since：2018年12月28日下午3:41:01
 * @description:
 * @version: 1.0
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com)
 */
public class TAB_WxArticlePageView {
	private String id;
	private String articleid;
	private String timestamp;
	private String time;
	private String username;

	@Override
	public String toString() {
		return "TAB_WxArticlePageView [id=" + id + ", articleid=" + articleid + ", timestamp=" + timestamp + ", time="
				+ time + ", username=" + username + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getArticleid() {
		return articleid;
	}

	public void setArticleid(String articleid) {
		this.articleid = articleid;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
