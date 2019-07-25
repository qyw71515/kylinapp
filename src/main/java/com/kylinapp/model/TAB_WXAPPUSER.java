/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.model;

/**    
 * @author：QYW   
 * @since：2018年12月27日下午4:50:24
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public class TAB_WXAPPUSER {
	String uuid;
	String Uid;
	String CreateTimeStamp;
	String CreateTime;
	String Sessionkey;
	int Ubalance;
	String Skey;
	String Uaddress;
	String Uavatar;
	int Ugender;
	String Uname;
	String UpdateTimeStamp;
	String UpdateTime;
	@Override
	public String toString() {
		return "TAB_WXAPPUSER [uuid=" + uuid + ", Uid=" + Uid + ", CreateTimeStamp=" + CreateTimeStamp + ", CreateTime="
				+ CreateTime + ", Sessionkey=" + Sessionkey + ", Ubalance=" + Ubalance + ", Skey=" + Skey
				+ ", Uaddress=" + Uaddress + ", Uavatar=" + Uavatar + ", Ugender=" + Ugender + ", Uname=" + Uname
				+ ", UpdateTimeStamp=" + UpdateTimeStamp + ", UpdateTime=" + UpdateTime + "]";
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getUid() {
		return Uid;
	}
	public void setUid(String uid) {
		Uid = uid;
	}
	public String getCreateTimeStamp() {
		return CreateTimeStamp;
	}
	public void setCreateTimeStamp(String createTimeStamp) {
		CreateTimeStamp = createTimeStamp;
	}
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	public String getSessionkey() {
		return Sessionkey;
	}
	public void setSessionkey(String sessionkey) {
		Sessionkey = sessionkey;
	}
	public int getUbalance() {
		return Ubalance;
	}
	public void setUbalance(int ubalance) {
		Ubalance = ubalance;
	}
	public String getSkey() {
		return Skey;
	}
	public void setSkey(String skey) {
		Skey = skey;
	}
	public String getUaddress() {
		return Uaddress;
	}
	public void setUaddress(String uaddress) {
		Uaddress = uaddress;
	}
	public String getUavatar() {
		return Uavatar;
	}
	public void setUavatar(String uavatar) {
		Uavatar = uavatar;
	}
	public int getUgender() {
		return Ugender;
	}
	public void setUgender(int ugender) {
		Ugender = ugender;
	}
	public String getUname() {
		return Uname;
	}
	public void setUname(String uname) {
		Uname = uname;
	}
	public String getUpdateTimeStamp() {
		return UpdateTimeStamp;
	}
	public void setUpdateTimeStamp(String updateTimeStamp) {
		UpdateTimeStamp = updateTimeStamp;
	}
	public String getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(String updateTime) {
		UpdateTime = updateTime;
	}
}
