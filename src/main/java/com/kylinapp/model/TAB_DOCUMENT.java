/** 
 * Copyright: Copyright (c)2015
 * Company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
package com.kylinapp.model;

import java.util.Arrays;

/**
 * @author��QYW
 * @since��2018��12��29������2:46:39
 * @description:
 * @version: 1.0
 * @copyright: Copyright (c)2015
 * @company: ����������Ϣ���޹�˾(jxhtxx.com)
 */
public class TAB_DOCUMENT {
	private String uuid;
	private String description;
	private byte[] document;
	private String type;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getDocument() {
		return document;
	}

	public void setDocument(byte[] document) {
		this.document = document;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "TAB_DOCUMENT [uuid=" + uuid + ", description=" + description + ", document=" + Arrays.toString(document)
				+ ", type=" + type + "]";
	}

}
