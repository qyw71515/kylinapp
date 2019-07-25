/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.kylinapp.model;

/**    
 * @author：QYW   
 * @since：2018年12月28日上午9:34:58
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public class TAB_WXBLOGCATEGORY {
	private String id;
	private String categoryName;
	private String categoryIcon;
	private String categoryDescription;
	private String articleTotle;
	private String type;
	@Override
	public String toString() {
		return "TAB_WXBLOGCATEGORY [id=" + id + ", categoryName=" + categoryName + ", categoryIcon=" + categoryIcon
				+ ", categoryDescription=" + categoryDescription + ", articleTotle=" + articleTotle + ", type=" + type
				+ "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryIcon() {
		return categoryIcon;
	}
	public void setCategoryIcon(String categoryIcon) {
		this.categoryIcon = categoryIcon;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public String getArticleTotle() {
		return articleTotle;
	}
	public void setArticleTotle(String articleTotle) {
		this.articleTotle = articleTotle;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
