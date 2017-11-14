package com.wujiuye.yezishop.bean;

import java.io.Serializable;

/**
 * 推荐分类表
 * 
 * @author wjy
 *
 */
public class RecommendClassBean implements Serializable {

	private int id;
	private String name;
	private String image;
	private String url;// 点击跳转的链接,可自定义链接app内跳转搜索

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "RecommendClassBean [id=" + id + ", name=" + name + ", image=" + image + ", url=" + url + "]";
	}

}
