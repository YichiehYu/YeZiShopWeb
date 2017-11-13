package com.wujiuye.yezishop.bean;

import java.io.Serializable;

/**
 * 商品图片
 * 
 * @author wjy
 *
 */
public class MerchandiseImagesBean implements Serializable {

	private int id;
	private int merchId;// 商品id
	private String bigPath;// 大图url
	private String newPath;// 图片url

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMerchId() {
		return merchId;
	}

	public void setMerchId(int merchId) {
		this.merchId = merchId;
	}

	public String getBigPath() {
		return bigPath;
	}

	public void setBigPath(String bigPath) {
		this.bigPath = bigPath;
	}

	public String getNewPath() {
		return newPath;
	}

	public void setNewPath(String newPath) {
		this.newPath = newPath;
	}

}
