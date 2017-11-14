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
>>*例：http://yezishop.shop/api/homeHeadNews<br>
>2.椰子商城app首页分类推荐，数据捉取自必要首页分组推荐<br>
>>*例：http://yezishop.shop/api/homeRecommendClassData<br>
>3.获取所有分类及其父分类，分类数据来源于必要app<br>
>>*例：http://yezishop.shop/api/merchClass<br>
>4.搜索功能：<br>
>>1).关键词搜索<br>
>>>*例：http://yezishop.shop/api/search?type=keyword&keywordOrClass=毛衣&page=1<br>
>>2).分类搜索<br>
>>>*例：http://yezishop.shop/api/search?type=class&keywordOrClass=男士风衣/大衣<br>
>5.商品详情，数据捉取自京东手机版页面<br>
>>*例：http://yezishop.shop/api/merchInfo?merchId=10<br>
<br>
#数据库表<br>
>数据库使用的是mysql社区版<br>
>可直接使用本项目跟目录下的yezishop.shop.database.sqlscript目录下的脚本文件导入<br>
<br>
<br>
#关于我<br>
>了解更多？ 关注我的微信公众号吧，打开微信，搜索“移动开发与网络安全技术栈”加关注，与我一同进步！！！<br>