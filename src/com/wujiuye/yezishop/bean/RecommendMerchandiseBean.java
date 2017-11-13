package com.wujiuye.yezishop.bean;

import java.io.Serializable;

/**
 * 推荐商品表
 * 
 * @author wjy
 *
 */
public class RecommendMerchandiseBean implements Serializable {

	private int id;
	private MerchandiseBean merchandiseBean;// 商品
	private int showType;// 推荐商品的显示样式

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MerchandiseBean getMerchandiseBean() {
		return merchandiseBean;
	}

	public void setMerchandiseBean(MerchandiseBean merchandiseBean) {
		this.merchandiseBean = merchandiseBean;
	}

	public int getShowType() {
		return showType;
	}

	public void setShowType(int showType) {
		this.showType = showType;
	}

	@Override
	public String toString() {
		return "RecommendMerchandiseBean [id=" + id + ", merchandiseBean=" + merchandiseBean + ", showType=" + showType
				+ "]";
	}

}
