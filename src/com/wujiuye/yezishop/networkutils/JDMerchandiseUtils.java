package com.wujiuye.yezishop.networkutils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wujiuye.yezishop.bean.MerchandiseColorSizeBean;
import com.wujiuye.yezishop.http.HttpURLConnectionUtils;
import com.wujiuye.yezishop.http.HttpUrl;

import antlr.collections.List;

/**
 * 京东商品捉取工具类
 * @author wjy
 *
 */
public class JDMerchandiseUtils {
	
	/**
	 * 捉取商品详情
	 * @return
	 * @throws IOException 
	 */
	public static String getXiangQing(String wareId) throws IOException {
		String result = HttpURLConnectionUtils.httpURLConectionGET(HttpUrl.JDDetailUrl+wareId);
		JsonElement jsonResult = new JsonParser().parse(result);
		if(jsonResult.isJsonObject()) {
			JsonObject obj = (JsonObject)jsonResult;
			JsonObject ware = (JsonObject)obj.get("ware");
			//获取商品名称
			String merchName = ware.get("wname").getAsString();
			merchName = merchName.split(" ")[0];
			System.out.println(merchName);
			//获取图片
			JsonArray imagesJson = ware.get("images").getAsJsonArray();
			ArrayList<String> bigImgList = new ArrayList<>();
			ArrayList<String> newImgList = new ArrayList<>();
			Iterator<JsonElement> imagesIterator = imagesJson.iterator();
			while (imagesIterator.hasNext()) {
				JsonObject imgItem = (JsonObject)imagesIterator.next();
				bigImgList.add(imgItem.get("bigpath").getAsString());
				newImgList.add(imgItem.get("newpath").getAsString());
			}
			//获取颜色与大小
			JsonObject skuColorSizeHandler = ware.get("skuColorSizeHandler").getAsJsonObject();
			JsonObject skuColorSize = skuColorSizeHandler.get("skuColorSize").getAsJsonObject();
			JsonArray colorSize = skuColorSize.get("colorSize").getAsJsonArray();
			ArrayList<MerchandiseColorSizeBean> colorSizeList = new ArrayList<>();
			Iterator<JsonElement> colorSizeIterator = colorSize.iterator();
			while (colorSizeIterator.hasNext()) {
				JsonObject colorSizeItem = (JsonObject)imagesIterator.next();
				MerchandiseColorSizeBean csBean = new MerchandiseColorSizeBean();
				csBean.setColor(colorSizeItem.get("color").getAsString());
				csBean.setSize(colorSizeItem.get("size").getAsString());
				colorSizeList.add(csBean);
			}
			//获取规格参数
			
			
			//获取html详情
		}
		
		return null;
	}
	
	public static void main(String[] argv) {
		try {
			getXiangQing("10813464797");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
