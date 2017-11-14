package com.wujiuye.yezishop.networkutils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wujiuye.yezishop.HibernateManager;
import com.wujiuye.yezishop.bean.ClassBean;
import com.wujiuye.yezishop.bean.MerchandiseBean;
import com.wujiuye.yezishop.bean.MerchandiseColorSizeBean;
import com.wujiuye.yezishop.bean.MerchandiseImagesBean;
import com.wujiuye.yezishop.bean.MerchandiseParameterBean;

/**
 * 京东商品捉取爬虫
 * 
 * @author wjy
 *
 */
public class JDMerchandiseReptile {

	/**
	 * 捉取商品详情数据的线程
	 * 
	 * @author wjy
	 *
	 */
	static class GetJDMerchInfoThread extends Thread {

		private List<Map<String, String>> wareIdList;
		private ClassBean clas;

		public GetJDMerchInfoThread(List<Map<String, String>> wareIdList, ClassBean clas) {
			this.wareIdList = wareIdList;
			this.clas = clas;
		}

		@Override
		public void run() {
			if (wareIdList != null && wareIdList.size() > 0) {
				for (Map<String, String> ware : wareIdList) {
					try {
						Session session =HibernateManager.getHibernateManager().getSessionFactory().getCurrentSession();
						Transaction transaction = session.beginTransaction();
						MerchandiseBean merch = JDMerchandiseUtils.getXiangQing(ware.get("wareId"));
						if (merch != null) {
							merch.setClas(clas);
							merch.setPrice(Float.valueOf(ware.get("price").trim().replaceAll("￥", "")));
							System.out.println(merch.toString());
							try {
								session.save(merch);
								for (MerchandiseParameterBean par : merch.getParameter()) {
									par.setMerch(merch);
									session.save(par);
								}
								for (MerchandiseColorSizeBean cs : merch.getColorSize()) {
									cs.setMerch(merch);
									session.save(cs);
								}
								for (MerchandiseImagesBean img : merch.getImages()) {
									img.setMerch(merch);
									session.save(img);
								}
								// 提交事务
								transaction.commit();
							} catch (Exception e) {
								e.printStackTrace();
								// 只要有数据插入失败就执行事务回滚
								transaction.rollback();
							}
						} else {
							System.out.println("捉取不到wareId为" + ware.get("wareId") + "的商品信息！");
						}
						Thread.sleep(5000);
					} catch (IOException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * 捉取指定分类的商品信息
	 * 
	 * @param clas
	 */
	private static void getJDMerchWithMerchClass(ClassBean clas) {
		List<Map<String, String>> wareIdList = JDMerchandiseUtils.queryJDMerchWareIdWithClassBean(clas);
		System.out.println(wareIdList);
		if (wareIdList != null)
			new GetJDMerchInfoThread(wareIdList, clas).start();
	}

	/**
	 * 查询数据库中的所有分类
	 * 
	 * @return
	 */
	private static List<ClassBean> getAllClassBean() {
		Session session = HibernateManager.getHibernateManager().getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		@SuppressWarnings("unchecked")
		/**
		 * 迫切和非迫切： 非迫切返回结果是Object[] 迫切连接返回的结果是对象 + fetch
		 */
		List<ClassBean> classList = session.createQuery("from ClassBean child left join fetch child.parentsClass")
				.list();
		transaction.commit();
		List<ClassBean> chilClasslist = new ArrayList<>();
		// 只要子分类
		for (ClassBean cla : classList) {
			if (cla.getParentsClass() != null && cla.getParentsClass().getParentsClass() != null) {
				System.out.println(cla.getName());
				chilClasslist.add(cla);
			}
		}
		return chilClasslist;
	}

	/**
	 * 捉取所有分类的数据,每个分类只捉取一页的数据(约30条)
	 * 
	 * @param argv
	 */
	public static void main(String[] argv) {
		HibernateManager.getHibernateManager().openSessionFactory();
		try {
			List<ClassBean> clasArray = getAllClassBean();
			for (ClassBean clas : clasArray) {
				getJDMerchWithMerchClass(clas);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
