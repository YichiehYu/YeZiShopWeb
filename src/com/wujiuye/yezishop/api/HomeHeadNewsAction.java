package com.wujiuye.yezishop.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wujiuye.yezishop.HibernateManager;
import com.wujiuye.yezishop.api.ResponseJsonResult.StateMessageKeyEnum;
import com.wujiuye.yezishop.bean.HomeHeadNewsBean;

/**
 * 首页头部轮播图
 * @author wjy
 *
 */
public class HomeHeadNewsAction extends BaseAction{
	
	private List<HomeHeadNewsBean> homeHeadNewsList = new ArrayList<>();

	/**
	 * 获取全部分类
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getHomeHeadNews() {
		if (this.homeHeadNewsList==null || homeHeadNewsList.size() == 0) {
			Session session = HibernateManager.getHibernateManager().getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			/**
			 * 迫切和非迫切： 非迫切返回结果是Object[] 迫切连接返回的结果是对象 + fetch
			 */
			List<HomeHeadNewsBean> resultList = session
					.createQuery("from HomeHeadNewsBean")
					.setFirstResult(0)
					.setMaxResults(3)
					.list();
			transaction.commit();
			session.close();
			this.homeHeadNewsList = resultList;
		}
		this.result = ResponseJsonResult.getResponseStateJsonResult(this.getCurrentRequestUrl("getHomeHeadNews"),
				StateMessageKeyEnum.SUCCESS);
		Map<String, Object> data = (Map<String, Object>) ResponseJsonResult.getDataMap(this.result);
		data.clear();
		data.put("homeHeadNews", this.homeHeadNewsList);
		return JSON;
	}

	@Override
	protected String setCurrentActionUrl() {
		return "/HomeHeadNewsAction";
	}

}
