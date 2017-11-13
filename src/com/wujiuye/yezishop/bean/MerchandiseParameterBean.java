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
	private MerchandiseBean merch;// 对应商品
	private String key;
	private String value;

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

	@Override
	public String toString() {
		return "MerchandiseParameterBean [id=" + id + ", merchId=" + (merch==null?0:merch.getId()) + ", key=" + key + ", value=" + value
				+ "]";
	}

}
