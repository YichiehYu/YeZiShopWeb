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
	private MerchandiseBean merch;// 商品id
	private String bigPath;// 大图url
	private String newPath;// 图片url

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MerchandiseBean getMerch() {
		return merch;
	}

	public void setMerch(MerchandiseBean merch) {
		this.merch = merch;
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

	@Override
	public String toString() {
		return "MerchandiseImagesBean [id=" + id + ", merchId=" + (merch==null?0:merch.getId()) + ", bigPath=" + bigPath + ", newPath="
				+ newPath + "]";
	}

}
