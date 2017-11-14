package com.wujiuye.yezishop.networkutils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.wujiuye.yezishop.HibernateManager;
import com.wujiuye.yezishop.bean.HomeHeadNewsBean;
import com.wujiuye.yezishop.http.HttpUrl;

public final class BiYaoHeadImageNewsUtils {
	
	
	/**
	 * 捉取必要头部轮播图及链接
	 */
	private static List<HomeHeadNewsBean> queryBiYaoHeadImageNews() {
		List<HomeHeadNewsBean> newsList = new ArrayList<>();
		try {
			Document document = Jsoup.connect(HttpUrl.BiYaoHeadImagesNewsUrl)
					.get();
			Elements elements = document.select("#pagebody")
					.select(".banner")
					.select(".banner-slider")
					.select("ul")
					.select("li");
			for(Element li : elements) {
				HomeHeadNewsBean headNews = new HomeHeadNewsBean();
				String href = li.select("a").attr("href");
				String imgUrl = li.select("img").get(0).attr("src");
				headNews.setClickToUrl(href);
				headNews.setImageUrl(imgUrl);
				newsList.add(headNews);
				System.err.println(li);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newsList;
	}
	
	
	/**
	 * 获取必要首页头部轮播图并插入到数据库中
	 */
	public static void getBiYaoHeadNewsInsertToDataBase() {
		List<HomeHeadNewsBean> list = queryBiYaoHeadImageNews();
		for(HomeHeadNewsBean news:list) {
			//插入数据库
			Session session = HibernateManager.getHibernateManager().getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();
			session.save(news);
			transaction.commit();
			System.out.println(news);
		}
	}
	
	public static void main(String[] argv) {
		HibernateManager.getHibernateManager().openSessionFactory();
		getBiYaoHeadNewsInsertToDataBase();
		HibernateManager.getHibernateManager().closeSessionFactory();
	}

}
