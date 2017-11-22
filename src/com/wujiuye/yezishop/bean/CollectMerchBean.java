package com.wujiuye.yezishop.bean;

import java.io.Serializable;

/**
 * 商品收藏
 * 
 * @author wjy
 *
 */
public class CollectMerchBean implements Serializable {

	private int id;
	private ApiUserBean user;// 用户
	private MerchandiseBean merch;// 商品
	private long dataTime;// 时间日期

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ApiUserBean getUser() {
		return user;
	}

	public void setUser(ApiUserBean user) {
		this.user = user;
	}

	public MerchandiseBean getMerch() {
		return merch;
	}

	public void setMerch(MerchandiseBean merch) {
		this.merch = merch;
	}

	public long getDataTime() {
		return dataTime;
	}

	public void setDataTime(long dataTime) {
		this.dataTime = dataTime;
	}

}
