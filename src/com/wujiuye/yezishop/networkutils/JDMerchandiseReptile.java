package com.wujiuye.yezishop.networkutils;

import java.io.IOException;

import com.wujiuye.yezishop.bean.ClassBean;

/**
 * 京东商品捉取爬虫
 * 
 * @author wjy
 *
 */
public class JDMerchandiseReptile {

	private static JDMerchandiseReptile mJDMerchandiseReptile = null;

	private JDMerchandiseReptile() {
	}

	public static JDMerchandiseReptile getJDMerchandiseReptile() {
		if (mJDMerchandiseReptile == null)
			mJDMerchandiseReptile = new JDMerchandiseReptile();
		return mJDMerchandiseReptile;
	}

	/**
	 * 用于测试
	 * 
	 * @param argv
	 */
	public static void main(String[] argv) {
		try {
			// JDMerchandiseUtils.getXiangQing("10813464797");
			ClassBean clas = new ClassBean();
			clas.setName("男士羽绒服");
			JDMerchandiseUtils.queryJDMerchWareIdWithClassBean(clas, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
