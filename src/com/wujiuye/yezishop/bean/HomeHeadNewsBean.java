package com.wujiuye.yezishop.bean;

import java.io.Serializable;

/**
 * 首页头部轮播图
 * 
 * @author wjy
 * 
 */
public class HomeHeadNewsBean implements Serializable {

	private int id;
	private String clickToUrl;// 点击跳转的链接
	private String imageUrl;// 图片链接,用作活动

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClickToUrl() {
		return clickToUrl;
	}

	public void setClickToUrl(String clickToUrl) {
		this.clickToUrl = clickToUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "HomeHeadNewsBean [id=" + id + ", clickToUrl=" + clickToUrl + ", imageUrl=" + imageUrl + "]";
	}

}
