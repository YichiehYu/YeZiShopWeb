package com.wujiuye.yezishop.bean;

import java.io.Serializable;
import java.util.Set;

/**
 * 商品类
 * 
 * @author wjy
 *
 */
public class MerchandiseBean implements Serializable {

	private int id;

	private Set<MerchandiseImagesBean> images; // 商品页面头部展示的图片
	private String merchName;// 商品名称
	private float price;// 商品价格
	private String htmlBody;// 商品详情链接,html字符串

	private int sales;// 售量

	private ClassBean clas;// 商品所属分类,最低一级分类

	private Set<MerchandiseParameterBean> parameter;// 规格参数，多个参数\n分割，key：value
	private Set<MerchandiseColorSizeBean> colorSize;// 颜色大小

	public MerchandiseBean() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<MerchandiseImagesBean> getImages() {
		return images;
	}

	public void setImages(Set<MerchandiseImagesBean> images) {
		this.images = images;
	}

	public String getMerchName() {
		return merchName;
	}

	public void setMerchName(String merchName) {
		this.merchName = merchName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getHtmlBody() {
		return htmlBody;
	}

	public void setHtmlBody(String htmlBody) {
		this.htmlBody = htmlBody;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public ClassBean getClas() {
		return clas;
	}

	public void setClas(ClassBean clas) {
		this.clas = clas;
	}

	public Set<MerchandiseParameterBean> getParameter() {
		return parameter;
	}

	public void setParameter(Set<MerchandiseParameterBean> parameter) {
		this.parameter = parameter;
	}

	public Set<MerchandiseColorSizeBean> getColorSize() {
		return colorSize;
	}

	public void setColorSize(Set<MerchandiseColorSizeBean> colorSize) {
		this.colorSize = colorSize;
	}

	@Override
	public String toString() {
		return "MerchandiseBean [id=" + id + ", images=" + images + ", merchName=" + merchName + ", price=" + price
				+ ", htmlBody=" + htmlBody + ", sales=" + sales + ", clas=" + clas + ", parameter=" + parameter
				+ ", colorSize=" + colorSize + "]";
	}

}
