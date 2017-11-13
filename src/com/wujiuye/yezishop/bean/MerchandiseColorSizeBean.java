package com.wujiuye.yezishop.bean;

import java.io.Serializable;

public class MerchandiseColorSizeBean implements Serializable {

	private int id;
	private int merchId;// 商品id
	private String color;// 颜色
	private String size;// 大小
	private int stock;// 库存，还剩多少件

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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
