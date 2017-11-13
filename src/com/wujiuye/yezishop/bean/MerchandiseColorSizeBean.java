package com.wujiuye.yezishop.bean;

import java.io.Serializable;

public class MerchandiseColorSizeBean implements Serializable {

	private int id;
	private MerchandiseBean merch;// 商品id
	private String color;// 颜色
	private String size;// 大小
	private int stock;// 库存，还剩多少件

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

	@Override
	public String toString() {
		return "MerchandiseColorSizeBean [id=" + id + ", merchId=" + (merch==null?0:merch.getId()) + ", color=" + color + ", size=" + size
				+ ", stock=" + stock + "]";
	}

}
