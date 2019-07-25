/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.model;

import java.util.Arrays;

/**
 * @author：QYW
 * @since：2018年12月29日上午10:20:28
 * @description:
 * @version: 1.0
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com)
 */
public class TAB_OCR {
	private int id;
	private String username;
	private String usericonurl;
	private String cjsj;
	private String code;
	private String message;
	private byte[] img;// img(二进制)

	@Override
	public String toString() {
		return "TAB_OCR [id=" + id + ", username=" + username + ", usericonurl=" + usericonurl + ", cjsj=" + cjsj
				+ ", code=" + code + ", message=" + message + ", img=" + Arrays.toString(img) + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getCjsj() {
		return cjsj;
	}

	public void setCjsj(String cjsj) {
		this.cjsj = cjsj;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}
}
