package com.wujiuye.yezishop.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 一级分类推荐
 * 
 * @author wjy
 * 
 */
public class RecommendClassDataBean implements Serializable {

	private int id;
	private String imageUrl;// 一级分类主图片
	private RecommendClassBean recommendClass;// 推荐分类表
	private List<RecommendMerchandiseBean> merchandiseList;// 推荐的商品列表

	public RecommendClassBean getRecommendClass() {
		return recommendClass;
	}

	public void setRecommendClass(RecommendClassBean recommendClass) {
		this.recommendClass = recommendClass;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<RecommendMerchandiseBean> getMerchandiseList() {
		return merchandiseList;
	}

	public void setMerchandiseList(List<RecommendMerchandiseBean> merchandiseList) {
		this.merchandiseList = merchandiseList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
