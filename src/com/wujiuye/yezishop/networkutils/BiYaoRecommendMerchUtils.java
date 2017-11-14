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
import com.wujiuye.yezishop.bean.MerchandiseBean;
import com.wujiuye.yezishop.bean.RecommendClassBean;
import com.wujiuye.yezishop.bean.RecommendClassDataBean;
import com.wujiuye.yezishop.bean.RecommendMerchandiseBean;
import com.wujiuye.yezishop.http.HttpUrl;

/**
 * 必要首页推荐商品捉取工具类
 * 
 * @author wjy
 *
 */
public class BiYaoRecommendMerchUtils {

	/**
	 * 捉取必要首页分组推荐的商品
	 * 
	 * @param recommendClass
	 *            根据推荐分类（分组分类）捉取
	 * @return
	 */
	private static void networkBiYaoHomeRecommendMerch(RecommendClassBean recommendClass) {
		List<RecommendClassDataBean> recommendClassDataBean = new ArrayList<>();
		List<RecommendMerchandiseBean> merchandiseList = new ArrayList<>();
		try {
			Session session = HibernateManager.getHibernateManager().getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Document document = Jsoup.connect(HttpUrl.BiYaoHomeRecommendMerchUrl).get();
			Elements recommendGroupElements = document.select(".category").select(".category-recommend-3");
			for (Element groupElement : recommendGroupElements) {
				// 获取标题
				Elements groupTitleElement = groupElement.select("category-title");
				String groupTitle = groupElement.select("p").text().trim();
				if (!recommendClass.getName().equals(groupTitle)) {
					continue;
				}
				Elements merchUl = recommendGroupElements.select(".category-list").select("li");
				for (Element item : merchUl) {
					System.err.println(item.attr("class"));
					// 获取长图商品
					if (item.attr("class").equals("category-brand")) {
						// 补全推荐分类
						String img = item.select("img").get(0).attr("src");// 长图
						String url = item.select("a").get(0).attr("href");// 点击图片跳转的链接
						System.err.println("img="+img+",url="+url);
						recommendClass.setImage(img);
						recommendClass.setUrl(url);
						session.update(recommendClass);
						break;
					}
				}
				System.err.println(recommendClass);
				// 其它商品从数据库中提取最新6条数据
				List<MerchandiseBean> recomd6 = null;
				if (recommendClass.getName().indexOf("男") >= 0) {
					recomd6 = session.createQuery("from MerchandiseBean where mc_id>=:start and mc_id<=:end")
							.setInteger("start", 9).setInteger("end", 22).setFirstResult(0)// 设置从第几条数据开始
							.setMaxResults(6)// 设置最多查询6条数据
							.list();
				} else if (recommendClass.getName().indexOf("女") >= 0) {
					recomd6 = session.createQuery("from MerchandiseBean where mc_id>=:start and mc_id<=:end")
							.setInteger("start", 23).setInteger("end", 32).setFirstResult(0)// 设置从第几条数据开始
							.setMaxResults(6)// 设置最多查询6条数据
							.list();
				}
				if (recomd6 == null || recomd6.size() != 6) {
					return;
				}
				for (int i = 0; i < recomd6.size(); i++) {
					RecommendClassDataBean bcd = new RecommendClassDataBean();
					RecommendMerchandiseBean rm = new RecommendMerchandiseBean();
					rm.setShowType(3);// 一行3列样式
					rm.setMerchandiseBean(recomd6.get(i));
					session.save(rm);
					bcd.setRecommendClass(recommendClass);
					bcd.setMerchandise(rm);
					session.save(bcd);
					merchandiseList.add(rm);
					recommendClassDataBean.add(bcd);
				}
			}
			try {
				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] argv) {
		HibernateManager.getHibernateManager().openSessionFactory();
		Session session = HibernateManager.getHibernateManager().getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<RecommendClassBean> rclist = session.createQuery("from RecommendClassBean").list();
		transaction.commit();
		if (rclist != null && rclist.size() > 0) {
			for (int n = 0; n < rclist.size(); n++)
				networkBiYaoHomeRecommendMerch(rclist.get(n));
		}
		HibernateManager.getHibernateManager().closeSessionFactory();
	}

}
