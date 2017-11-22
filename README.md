#椰子商品-后台服务javaweb<br>
#author wujiuye<br>

#项目框架简介<br>
>.本项目使用struts2+hibernate框架搭建
>.hibernate用于简化数据库操作
>.structs2封装serverlet

#数据来源<br>
>.所有数据都是捉取京东商城以及必要商城的<br/>
>.数据捉取的代码在源码包com.wujiuye.yezishop.networkutils下<br/>
>.由于只是用于演示，所以所有的数据都只是捉取一页<br/>
>.数据捉取使用jsoup.jar<br>

#已实现接口<br>
>1.椰子商城app首页头部轮播图，数据捉取自必要app首页轮播图<br>
>>*例：http://wujiuye.yezishop.shop/api/homeHeadNews<br>
>2.椰子商城app首页分类推荐，数据捉取自必要首页分组推荐<br>
>>*例：http://wujiuye.yezishop.shop/api/homeRecommendClassData<br>
>3.获取所有分类及其父分类，分类数据来源于必要app<br>
>>*例：http://wujiuye.yezishop.shop/api/merchClass<br>
>4.搜索功能：<br>
>>1).关键词搜索<br>
>>>*例：http://wujiuye.yezishop.shop/api/search?type=keyword&keywordOrClass=毛衣&page=1<br>
>>2).分类搜索<br>
>>>*例：http://wujiuye.yezishop.shop/api/search?type=class&keywordOrClass=男士风衣/大衣<br>
>5.商品详情，数据捉取自京东手机版页面<br>
>>*例：http://wujiuye.yezishop.shop/api/merchInfo?merchId=10<br>
<br>

>>>package com.wujiuye.yezishop;
>>>public final class HttpUrl {
>>>	
>>>	//http请求or https请求
>>>	private static final String HTTP_VERSION = "http://";
>>>	//api接口域名
>>>	private static final String API_DOMAIN = "wujiuye.yezishop.shop";
>>>	
>>>	//获取所有分类
>>>	public static final String GetMerchClassUrl = HTTP_VERSION + API_DOMAIN + "/api/merchClass";
>>>	//首页轮播图
>>>	public static final String HomeHeadImagesUrl = HTTP_VERSION + API_DOMAIN + "/api/homeHeadNews";
>>>	//首页推荐
>>>	public static final String HomeRecommendMerchUrl = HTTP_VERSION + API_DOMAIN + "/api/homeRecommendClassData";
>>>	//商品搜索
>>>	public static final String SearchMerchUrl = HTTP_VERSION + API_DOMAIN + "/api/search";
>>>	//获取商品详情信息
>>>	public static final String GetMerchDetailsUrl = HTTP_VERSION + API_DOMAIN + "/api/merchInfo";
>>>	
>>>	//用户第三方登录 
>>>	//参数1:openid
>>>	//参数2:nickname
>>>	//参数3:face
>>>	//参数4:sex
>>>	//参数5:access_token 
>>>	//参数6:api_platform 第三方平台：QQ,WEIXIN
>>>	public static final String APIUesrLoginUrl = HTTP_VERSION + API_DOMAIN + "/api/apiLogin";
>>>	
>>>	//加入收藏
>>>	//参数1:token 登录获取的token
>>>	//参数2:merchId 商品id
>>>	public static final String JoinMyCollectUrl = HTTP_VERSION + API_DOMAIN + "/api/joinCollect";
>>>	//删除收藏
>>>	//参数1:token 登录获取的token
>>>	//参数2:merchId 商品id
>>>	public static final String DelMyCollectWithMerchIdUrl = HTTP_VERSION + API_DOMAIN + "/api/delCollect";
>>>	//我的收藏列表
>>>	//参数1:token 登录获取的token
>>>	public static final String MyCollectsUrl = HTTP_VERSION + API_DOMAIN + "/api/myCollects";
>>>	
>>>	//加入购物车
>>>	//参数1:merchId 商品id
>>>	//参数1:derviceToken 设备唯一标识
>>>	//参数2:derviceOS 设备操作系统
>>>	public static final String JoinGwcUrl = HTTP_VERSION + API_DOMAIN + "/api/joinGwcWithMerchId";
>>>	//我的购物车列表
>>>	//参数1:derviceToken 设备唯一标识
>>>	//参数2:derviceOS 设备操作系统
>>>	public static final String MyGouWuCheListUrl = HTTP_VERSION + API_DOMAIN + "/api/gwcMerch";
>>>}
>>>
>>>
#数据库表<br>
>数据库使用的是mysql社区版<br>
>可直接使用本项目跟目录下的yezishop.shop.database.sqlscript目录下的脚本文件导入<br>
<br>
<br>
#关于我<br>
>了解更多？ 关注我的微信公众号吧，打开微信，搜索“移动开发与网络安全技术栈”加关注，与我一同进步！！！<br>