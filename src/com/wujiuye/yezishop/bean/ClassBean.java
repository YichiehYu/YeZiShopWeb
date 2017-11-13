package com.wujiuye.yezishop.bean;

import java.io.Serializable;

/**
 * 分类
 * 
 * @author wjy
 * 
 */
public class ClassBean implements Serializable {

	private int id;
	private String name;// 分类名称
	private String imgUrl;// 分类图片logo
	private ClassBean parentsClass;// 父分类

	public ClassBean() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ClassBean getParentsClass() {
		return parentsClass;
	}

	public void setParentsClass(ClassBean parentsClass) {
		this.parentsClass = parentsClass;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
