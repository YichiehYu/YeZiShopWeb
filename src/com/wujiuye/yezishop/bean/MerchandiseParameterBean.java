package com.wujiuye.yezishop.bean;

import java.io.Serializable;

/**
 * 商品规格参数表
 * 
 * @author wjy
 *
 */
public class MerchandiseParameterBean implements Serializable {

	private int id;
	private int merchId;// 商品id
	private String key;
	private String value;

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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
