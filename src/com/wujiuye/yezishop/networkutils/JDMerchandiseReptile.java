package com.wujiuye.yezishop.networkutils;


/**
 * 京东商品捉取爬虫
 * @author wjy
 *
 */
public class JDMerchandiseReptile {
	
	private static JDMerchandiseReptile mJDMerchandiseReptile = null;
	private JDMerchandiseReptile() {
	}
	
	public static JDMerchandiseReptile getJDMerchandiseReptile() {
		if(mJDMerchandiseReptile==null)
			mJDMerchandiseReptile = new JDMerchandiseReptile();
		return mJDMerchandiseReptile;
	}
	
	

}
