package com.wujiuye.yezishop.bean;

import java.io.Serializable;

public class GwcMerchBean implements Serializable {

	private int id;
	private String derviceOS;// 设置操作系统
	private String derviceToken;// 设置唯一标识
	private MerchandiseBean merchandise;// 购物车商品
	private long dateTime;// 加入购物车日期

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDerviceOS() {
		return derviceOS;
	}

	public void setDerviceOS(String derviceOS) {
		this.derviceOS = derviceOS;
	}

	public String getDerviceToken() {
		return derviceToken;
	}

	public void setDerviceToken(String derviceToken) {
		this.derviceToken = derviceToken;
	}

	public MerchandiseBean getMerchandise() {
		return merchandise;
	}

	public void setMerchandise(MerchandiseBean merchandise) {
		this.merchandise = merchandise;
	}

	public long getDateTime() {
		return dateTime;
	}

	public void setDateTime(long dateTime) {
		this.dateTime = dateTime;
	}

}
