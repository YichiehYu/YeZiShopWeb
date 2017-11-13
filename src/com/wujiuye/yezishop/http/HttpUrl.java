package com.wujiuye.yezishop.http;

public final class HttpUrl {

	private HttpUrl() {
	}

	// 京东商品详情信息获取接口
	// 参数wareId：商品id 例如:10813464796
	public static final String JDDetailUrl = "https://item.m.jd.com/ware/detail.json?wareId=";

	// 京东商品关键词搜索，用于获取商品的wareid来获取商品详情,
	// 用于分类捉取数据,get请求
	public static final String JDClassSearchUrl = "https://so.m.jd.com/ware/search.action?keyword=";
	// post请求
	public static final String JDClassSearchPostUrl = "https://so.m.jd.com/ware/search.action";
	
	//电脑
	public static final String JDClassSearchGetUrl = "https://search.jd.com/Search?&enc=utf-8";
}
