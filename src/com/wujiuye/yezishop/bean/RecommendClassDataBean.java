package com.wujiuye.yezishop.bean;

import java.io.Serializable;

/**
 * 推荐分组数据
 * 
 * @author wjy
 * 
 */
public class RecommendClassDataBean implements Serializable {

	private int id;
	private RecommendClassBean recommendClass;// 推荐分类表
	private RecommendMerchandiseBean merchandise;// 推荐的商品

	public RecommendClassBean getRecommendClass() {
		return recommendClass;
	}

	public void setRecommendClass(RecommendClassBean recommendClass) {
		this.recommendClass = recommendClass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RecommendMerchandiseBean getMerchandise() {
		return merchandise;
	}

	public void setMerchandise(RecommendMerchandiseBean merchandise) {
		this.merchandise = merchandise;
	}

	@Override
	public String toString() {
		return "RecommendClassDataBean [id=" + id + ", recommendClass=" + recommendClass + ", merchandise="
				+ merchandise + "]";
	}

}
