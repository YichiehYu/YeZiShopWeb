package com.wujiuye.yezishop.networkutils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wujiuye.yezishop.bean.ClassBean;
import com.wujiuye.yezishop.bean.MerchandiseBean;
import com.wujiuye.yezishop.bean.MerchandiseColorSizeBean;
import com.wujiuye.yezishop.bean.MerchandiseImagesBean;
import com.wujiuye.yezishop.bean.MerchandiseParameterBean;
import com.wujiuye.yezishop.http.HttpURLConnectionUtils;
import com.wujiuye.yezishop.http.HttpUrl;

/**
 * 京东商品捉取工具类
 * 
 * @author wjy
 *
 */
public class JDMerchandiseUtils {

	/**
	 * 捉取商品详情
	 * 
	 * @return
	 * @throws IOException
	 */
	public static MerchandiseBean getXiangQing(String wareId) throws IOException {
		MerchandiseBean mMerchandiseBean = null;
		String result = HttpURLConnectionUtils.httpURLConectionGET(HttpUrl.JDDetailUrl + wareId);
		JsonElement jsonResult = new JsonParser().parse(result);
		if (jsonResult.isJsonObject()) {
			mMerchandiseBean = new MerchandiseBean();
			JsonObject obj = (JsonObject) jsonResult;
			JsonObject ware = (JsonObject) obj.get("ware");
			// 获取商品名称
			String merchName = ware.get("wname").getAsString();
			merchName = merchName.split(" ")[0];
			mMerchandiseBean.setMerchName(merchName);
			System.err.println(merchName);
			// 获取图片
			JsonArray imagesJson = ware.get("images").getAsJsonArray();
			Set<MerchandiseImagesBean> imgBeanList = new HashSet<>();
			Iterator<JsonElement> imagesIterator = imagesJson.iterator();
			while (imagesIterator.hasNext()) {
				JsonObject imgItem = (JsonObject) imagesIterator.next();
				MerchandiseImagesBean imgBean = new MerchandiseImagesBean();
				imgBean.setBigPath(imgItem.get("bigpath").getAsString());
				imgBean.setBigPath(imgItem.get("newpath").getAsString());
				imgBeanList.add(imgBean);
			}
			mMerchandiseBean.setImages(imgBeanList);
			// 获取颜色与大小
			JsonObject skuColorSizeHandler = ware.get("skuColorSizeHandler").getAsJsonObject();
			JsonObject skuColorSize = skuColorSizeHandler.get("skuColorSize").getAsJsonObject();
			JsonArray colorSize = skuColorSize.get("colorSize").getAsJsonArray();
			Set<MerchandiseColorSizeBean> colorSizeList = new HashSet<>();
			Iterator<JsonElement> colorSizeIterator = colorSize.iterator();
			while (colorSizeIterator.hasNext()) {
				JsonObject colorSizeItem = (JsonObject) colorSizeIterator.next();
				MerchandiseColorSizeBean csBean = new MerchandiseColorSizeBean();
				csBean.setColor(colorSizeItem.get("color").getAsString());
				csBean.setSize(colorSizeItem.get("size").getAsString());
				colorSizeList.add(csBean);
				System.err.println("color=" + csBean.getColor() + ",size=" + csBean.getSize());
			}
			mMerchandiseBean.setColorSize(colorSizeList);
			// 获取规格参数
			JsonObject wi = ware.get("wi").getAsJsonObject();
			String code = wi.get("code").getAsString();
			JsonArray codeJsonArray = new JsonParser().parse(code).getAsJsonArray();
			Set<MerchandiseParameterBean> parementer = new HashSet<>();
			Iterator<JsonElement> codeIterator = codeJsonArray.iterator();
			while (codeIterator.hasNext()) {
				JsonObject codeItem = (JsonObject) codeIterator.next();
				MerchandiseParameterBean parementerBean = new MerchandiseParameterBean();
				String itmeStr = codeItem.toString().trim();
				String[] keyValue = itmeStr.substring(1, itmeStr.length() - 1).split(":");
				parementerBean.setKey(keyValue[0].replace("\"", ""));
				parementerBean.setValue(keyValue[1].replace("\"", ""));
				parementer.add(parementerBean);
				System.err.println("key=" + parementerBean.getKey() + ",value=" + parementerBean.getValue());
			}
			mMerchandiseBean.setParameter(parementer);
			// 获取html详情，使用base64编码处理数据
//			String wdis = Base64Utils.encode(ware.get("wdis").getAsString());
			String wdis = ware.get("wdis").getAsString();
			System.err.println(wdis);
			mMerchandiseBean.setHtmlBody(wdis);
		}

		return mMerchandiseBean;
	}

	/**
	 * 根据分类捉取与该分类有关的商品wareid列表
	 * 
	 * @param clas
	 *            分类
	 * @return
	 */
	@SuppressWarnings("serial")
	public static List<Map<String, String>> queryJDMerchWareIdWithClassBean(ClassBean clas) {
		String keywork = clas.getName();
		List<Map<String, String>> wareIdList = new ArrayList<>();
		String cookie = getPostCookies(HttpUrl.JDClassSearchGetUrl);
		try {
			Document result = Jsoup.connect(HttpUrl.JDClassSearchGetUrl)
					.header("Accept", "text/html, application/xhtml+xml, */*")
					.header("Content-Type", "application/x-www-form-urlencoded").header("Cookie", cookie)
					.data(new HashMap<String, String>() {
						{
							put("keyword", keywork);
							put("wq", keywork);
						}
					}).get();
			Elements J_goodsList = result.select("#J_goodsList");
			Elements gl_warp = J_goodsList.select(".gl-warp");
			Elements gl_item = gl_warp.select(".gl-item");

			Iterator<Element> iterator = gl_item.iterator();
			while (iterator.hasNext()) {
				Element item = iterator.next();
				Map<String, String> itemMap = new HashMap<String, String>();
				String price = item.select(".p-price").text();
				System.err.println(price);
				
				itemMap.put("price", price);
				String wareId = item.attr("data-sku");
				itemMap.put("wareId", wareId);
				
				wareIdList.add(itemMap);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wareIdList;
	}

	/**
	 * 请求获取url返回的cookie
	 */
	private static String getPostCookies(String url) {
		// 获取请求连接
		Connection con = Jsoup.connect(url);
		// 请求头设置，特别是cookie设置
		con.header("Accept", "text/html, application/xhtml+xml, */*");
		con.header("Content-Type", "application/x-www-form-urlencoded");
		con.header("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0))");
		// 发送请求
		Response resp = null;
		try {
			resp = con.method(Method.GET).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (resp == null)
			return null;
		Map<String, String> cookies = resp.cookies();
		String cookiesStr = "";
		int count = 0;
		for (String cookieKey : cookies.keySet()) {
			if (count > 0)
				cookiesStr += ";";
			count++;
			cookiesStr += (cookieKey + "=");
			cookiesStr += cookies.get(cookieKey);
		}
		System.err.println("所有cookie值：  " + cookiesStr);
		return cookiesStr;
	}
}
