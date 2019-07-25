/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**    
 * @author：QYW   
 * @since：2018年12月28日上午10:27:14
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public class TimeUtil {
	public static String leadTime(String time) {
		long t = System.currentTimeMillis();
		
		long t1 = Long.parseLong(time);
		long i = (t-t1)/1000/60;
		if(i>60) {
			i = i/60;
			if(i>24) {
				i = i/24;
				if(i>30) {
					i = i/30;
					if(i>12) {
						i=i/12;
						return i+"年前";
					}else {
						return i+"个月前";
					}
				}else {
					return i+"天前";
				}
				
				
			}else {
				return i+"小时前";
			}
		}else {
			return i+"分钟前";
		}
	}
	
	public static String getTime() {
		Calendar c = Calendar.getInstance();    
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");    
        String time = String.valueOf(f.format(c.getTime()));
        return time;
	}
	
	public static String getTimeStamp() {
		return String.valueOf(System.currentTimeMillis());
	}
	
	public static String timeFormat(String time) {
		if(time != null && time.length()>10) {
			time = time.substring(0,4) + "-" + time.substring(4,6) + "-" + time.substring(6,8);
		}
		return time!=null ? time : "";
	}
	
	public static void main(String[] args) {
	System.err.println(timeFormat("20181228091017"));
		System.err.println(getTime());
		String time = getTime();
		time = time.substring(0, 4) + "-" + time.substring(4, 6)  + "-" + time.substring(6, 8)  + " " + time.substring(8, 10) + ":" + time.substring(10, 12);   
		System.err.println(time);
		System.err.println(leadTime("1546503639867"));
	}
}
